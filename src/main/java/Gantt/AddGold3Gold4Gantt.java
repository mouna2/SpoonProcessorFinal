package Gantt;

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
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import spoon.Launcher;
import spoon.SpoonAPI;

public class AddGold3Gold4Gantt {
	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";
	
	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "root";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */

	private final int portNumber = 3306;
	
	private final String dbName = "databasegantt";

	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("root", this.userName);
		connectionProps.put("123456", this.password);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasegantt","root","123456");

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
	
	/**
	 * Connect to MySQL and do some stuff.
	 * @throws SQLException 
	 */
	public void run() throws SQLException {
		ResultSet rs = null; 
		// Connect to MySQL
		Connection conn = null;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}
	
		// Create a table
		try {
			Statement st= conn.createStatement();

		   
		  
			   AddColumns();
		
		  
		   
		   
		
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		}
		
		
	}
	
	public static void main(String[] args) throws SQLException, IOException {
		AddColumns();

	}

	public static void AddColumns() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		DatabaseReading2Gantt DatabaseReading = new DatabaseReading2Gantt();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN gold3"); 
		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN gold4");
		st.executeUpdate("ALTER TABLE `traces` ADD gold3 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `traces` ADD gold4 LONGTEXT");
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
		String gold3=null; 
		String gold4=null;
		 
			ResultSet TracesCount=st.executeQuery("SELECT COUNT(*) FROM traces"); 
			while(TracesCount.next()) {
				 TracesNumber= TracesCount.getInt(1); 
				System.out.println(TracesNumber);
			}
			while(counter<=TracesNumber) {
				ResultSet TraceInformation= st.executeQuery("SELECT traces.* from traces where id ='"+counter+"'"); 
				boolean subjectTflag=false; 
				boolean subjectNflag=false; 
				while(TraceInformation.next()) {
					String	SubjectTstr=TraceInformation.getString("SubjectT"); 
					String SubjectNstr=TraceInformation.getString("SubjectN"); 
					
					 if(SubjectTstr!=null) {
						 SubjectT=Integer.parseInt(SubjectTstr); 
						 subjectTflag=true; 
					 }
					 if(SubjectNstr!=null) {
						 SubjectN=Integer.parseInt(SubjectNstr); 
						 subjectNflag=true; 
					 }
				}
				
				
				
				
				if(subjectNflag==true && subjectTflag==true) {
				gold3=PredictGold3(SubjectT, SubjectN); 
				gold4=PredictGold4(SubjectT, SubjectN); 
				
				st.executeUpdate("UPDATE `traces` SET `gold3` ='"+ gold3 +"',"+"`gold4` ='"+ gold4 +"'WHERE id='"+counter+"'"); 
				}
				
				
				
				counter++; 
			}
			
			


		
		
			
		
		
		
		
		
		//st.executeUpdate("SELECT * FROM `traces` where method LIKE `% %`"); 
	}
	
	
	static String PredictGold3(int SubjectT, int SubjectN) {
		String gold3=null; 
		if(SubjectT+SubjectN>=3) {
			if(SubjectT>=SubjectN) {
				gold3="T"; 
			}
			else if(SubjectT==0 && SubjectN>=3) {
				gold3="N"; 
			}
			else {
				gold3="E"; 
			}
			
			
			
		}
		
		return gold3; 
	}
	
	
	static String PredictGold4(int SubjectT, int SubjectN) {
		
		String gold4=null; 
		if(SubjectT+SubjectN>=3) {
			if(SubjectT>=2) {
				gold4="T"; 
			}
			else if(SubjectT==0 && SubjectN>=3) {
				gold4="N"; 
			}
			else {
				gold4="E"; 
			}
			
			
			
		}
		return gold4; 
	}
}
