package ALGO_OLD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Pattern;

import spoon.Launcher;
import spoon.SpoonAPI;

public class COMPARATOR {

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
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasejhotdraw","root","123456");

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

		   
		  
			  // AddColumns();
		
		  
		   
		   
		
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		}
		
		
	}
	
	public static void main(String[] args) throws SQLException, IOException {
		AddColumns2();
	}

	
	
	public static void AddColumns2() throws SQLException, IOException {

		// TODO Auto/generated method stub

		 FileReader fileReader = new FileReader("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\147FP");

		List<String> NewlineList= new ArrayList<String>(); 
		List<String> NewlineList2= new ArrayList<String>(); 

		
		 BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String line = null;
	        line = bufferedReader.readLine(); 
	        while((line = bufferedReader.readLine()) != null) {
//	            System.out.println(line);
	        	String[] splitted = line.split("\t");
	        	String newline=splitted[2]+"="+splitted[1]+"="+splitted[5]; 
	        	
//	            System.out.println(line);
	        	NewlineList.add(newline); 
	        }   
	        
	        
	         fileReader = new FileReader("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\300FP");
			  bufferedReader = new BufferedReader(fileReader);
			   line = null;
		        line = bufferedReader.readLine(); 
		        while((line = bufferedReader.readLine()) != null) {
//		            System.out.println(line);
		        	String[] splitted = line.split("\t");
		        	String newline=splitted[2]+"="+splitted[1]+"="+splitted[5]; 
		        	
//		            System.out.println(line);
		        	NewlineList2.add(newline); 
		        }   
			  
			  
		        boolean flag=false;  
	        // Always close files.
	        bufferedReader.close();         
int counter=0; 
int counter147=0; 
int count300=0; 
	        for(String s: NewlineList) {
	        	for(String s2: NewlineList2) {
	        		 flag=false; 
	        		if(s.equals(s2)) {
	        			System.out.println(s+"=PRESENT IN BOTH");
	        			counter++;
	        			flag=true; 
	        			break; 
	        			 
	        		}
	        		

	        	}
	        	if(flag==false) {
	    			System.out.println(s+"=PRESENT IN 147FP");
	    			counter147++; 
	        	}

	        }
		
	        for(String s2: NewlineList2) {
	        	for(String s: NewlineList) {
	        		 flag=false; 
	        		if(s.equals(s2)) {
//	        			System.out.println(s+"PRESENT IN BOTH");
	        			flag=true; 
	        			break; 
	        		}
	        		
	        	}
	        	if(flag==false) {
    			System.out.println(s2+"=PRESENT IN 300FP");
    			count300++; 
	        	}
	        }
		
	  System.out.println("BOTHHH "+counter);
	  System.out.println("COUNTER 147 "+counter147);
	  System.out.println("COUNTER 300 "+count300);

           
        }
   
	  

		
	}

