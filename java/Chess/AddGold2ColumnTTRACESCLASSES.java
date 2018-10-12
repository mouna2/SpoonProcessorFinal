package Chess;

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
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Pattern;

import spoon.Launcher;
import spoon.SpoonAPI;

public class AddGold2ColumnTTRACESCLASSES {
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
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasechess","root","123456");

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
		DBDemo2 DatabaseReading = new DBDemo2();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
		//st.executeUpdate("ALTER TABLE `traces` DROP COLUMN SubjectT"); 
//		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold2");
//		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold3");
//
//		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold4");

		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold2 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold3 LONGTEXT"); 

		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold4 LONGTEXT"); 

		int  TracesNumber=0; 
		int counter=0; 
		String mytraceclass=""; 
		String classid=""; 
		String requirementid= ""; 
		String gold2=""; 
		
		Hashtable<String,List<String>> RequirementClassHashMap=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMap2=new Hashtable<String,List<String>>(); 
		List<String> mylist= new ArrayList<String>(); 
		ResultSet TracesCount=st.executeQuery("SELECT COUNT(*) FROM traces"); 
		while(TracesCount.next()) {
			 TracesNumber= TracesCount.getInt(1); 
			System.out.println(TracesNumber);
		}
		
		while(counter<TracesNumber) {
			ResultSet traces = st.executeQuery("SELECT traces.* from traces where id='"+counter+"'"); 
			while(traces.next()){		
				//THIS IS GOLD 2
				 requirementid=traces.getString("requirementid").trim(); 
				 classid=traces.getString("classid").trim(); 
				String ReqClass=requirementid+"-"+classid;
				RequirementClassHashMap.put(ReqClass, mylist); 

			
	   		   }
			counter++; 
		}
		
		
		for (Entry<String, List<String>> entry : RequirementClassHashMap.entrySet()) {
		    System.out.println(entry.getKey() + " = " );
		    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
		     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
		     List<String> List= new ArrayList<String>(); 
		 	ResultSet traces = st.executeQuery("SELECT traces.* from traces where requirementid='"+requirementid+"' and classid='"+classid+"'"); 
			while(traces.next()){		
				//THIS IS GOLD 2
				 requirementid=traces.getString("requirementid").trim(); 
				 classid=traces.getString("classid").trim(); 
				
				 gold2=traces.getString("gold2").trim(); 
				 if(gold2!=null) {
					 List.add(gold2); 
				 }
				
				
			
	   		   }
			String ReqClass=requirementid+"-"+classid;
			System.out.println(ReqClass);
			RequirementClassHashMap2.put(ReqClass, List); 
		}
		
		
		
		
		for (Entry<String, List<String>> entry : RequirementClassHashMap2.entrySet()) {
			   System.out.println(entry.getKey() + " = " );
			    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
			     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
			     
			     List<String> MyValues = entry.getValue(); 
			     
			     if(MyValues.contains("T")) {
						st.executeUpdate("UPDATE `tracesclasses` SET `gold2` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			     }else if(MyValues.contains("E")) {
						st.executeUpdate("UPDATE `tracesclasses` SET `gold2` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			    	 
			     }else if(MyValues.isEmpty()) {
			    	 //DO NOTHING 
			     }
			     else {	st.executeUpdate("UPDATE `tracesclasses` SET `gold2` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			     }
		}
	
		
		
		//st.executeUpdate("SELECT * FROM `traces` where method LIKE `% %`"); 
	}
}
