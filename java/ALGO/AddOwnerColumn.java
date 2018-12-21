package ALGO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import Gantt.DatabaseReading2Gantt;
import JHotDraw.DatabaseReading2JHotDraw;
import spoon.Launcher;
import spoon.SpoonAPI;

public class AddOwnerColumn {
	/** The name of the MySQL account to use (or empty for anonymous) */
	  static String userName = "root";
	
	/** The password for the MySQL account (or empty for anonymous) */
	  static String password = "root";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */

	private final int portNumber = 3306;
	
	private final String dbName = "databasegantt";

	/**
	 * Get a new database connection
	 * @param programName 
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection(String programName) throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("root", userName);
		connectionProps.put("123456", password);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database"+programName,"root","123456");

		return conn;
	}

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(command); // This will throw a SQLException if it fails
	        return true;
	    } finally {

	    	// This will run whether we throw an exception or not
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	
	
	public static void main(String[] args) throws SQLException, IOException {
		AddColumns("chess");
		AddColumns("gantt");
		AddColumns("itrust");
		AddColumns("jhotdraw");
	}

	public static void AddColumns(String ProgramName) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		DatabaseReading2Gantt DatabaseReading = new DatabaseReading2Gantt();
		conn = getConnection(ProgramName);
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
		
		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN  ownergold "); 

		
		
		st.executeUpdate("ALTER TABLE `traces` ADD ownergold LONGTEXT"); 
		int counter=1; 
		
//			File file = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\GanttFiles\\gantt_meth_votes.txt");
//			FileReader fileReader = new FileReader(file);
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			StringBuffer stringBuffer = new StringBuffer();
//			String line;
//			line = bufferedReader.readLine(); 
		int TracesNumber=0; 
		int SubjectT=0; 
		int SubjectN=0; 
	
		HashMap<String, String> TracesClassesHashMap = new HashMap<String, String>(); 
		
		
				ResultSet TraceInformation= st.executeQuery("SELECT tracesclasses.* from tracesclasses"); 
				
				while(TraceInformation.next()) {
					
					String goldfinal =TraceInformation.getString("goldfinal"); 
					String requirementid =TraceInformation.getString("requirementid"); 
					String classid =TraceInformation.getString("classid"); 
					TracesClassesHashMap.put(requirementid+"-"+classid, goldfinal); 
					
				}
				
				
				 
					
					 counter=0; 
					for(String mykey: TracesClassesHashMap.keySet()) {
						
					String mykeys[]= mykey.split("-"); 
					String requirementid= mykeys[0]; 
					String classid= mykeys[1]; 
					st.executeUpdate("UPDATE `traces` SET `ownergold` ='"+ TracesClassesHashMap.get(mykey) +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 
						
					System.out.println(counter);
					System.out.println(TracesClassesHashMap.size());
					counter++; 
				
			
			}
			
			

	
	
	
	
	
}

		
		
			
		
		
		
		
		
		//st.executeUpdate("SELECT * FROM `traces` where method LIKE `% %`"); 
	
	
	
	
}
