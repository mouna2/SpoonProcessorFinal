package CompareTracesClasses;

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
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Pattern;

import org.eclipse.swt.program.Program;

import Chess.DBDemo2;
import Chess.DBDemo3Chess;
import iTrust.DBDemo3iTrust;
import spoon.Launcher;
import spoon.SpoonAPI;

public class ComparisonTracesClasses {
	/** The name of the MySQL account to use (or empty for anonymous) */
	private final static String userName = "root";
	
	/** The password for the MySQL account (or empty for anonymous) */
	private final static String password = "root";

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
		if(programName.equals("chess")) {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasechess","root","123456");

		}else if(programName.equals("gantt")) {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasegantt","root","123456");

		}else if(programName.equals("itrust")) {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseitrust","root","123456");

		}else if(programName.equals("jhotdraw")) {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasejhotdraw","root","123456");

		}

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
	public  void run() throws SQLException {
		ResultSet rs = null; 
		// Connect to MySQL
		Connection conn = null;
		try {
			conn = this.getConnection(dbName);
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
		
		AddColumns2("chess");
		AddColumns2("gantt");
		AddColumns2("itrust");
		AddColumns2("jhotdraw");
	}

	

	public static  void AddColumns2(String ProgramName) throws SQLException, IOException {
		FileReader fileReader=null;  
		if(ProgramName.equals("chess")) {
			 fileReader = new FileReader("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\java\\Chess\\ChessFiles\\TracesClassesNEW.txt");

		}
		else if(ProgramName.equals("gantt")) {
			 fileReader = new FileReader("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\java\\GanttFiles\\TracesClassesNEW.txt");

		}else if(ProgramName.equals("itrust")) {
			 fileReader = new FileReader("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\java\\iTrustFiles\\TracesClassesNEW.txt");

		}else if(ProgramName.equals("jhotdraw")) {
			 fileReader = new FileReader("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\java\\JHotDrawFiles\\TracesClassesNEW.txt");

		}
        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        HashMap<String,  String> ReqClassHashMap= new HashMap<String,  String> (); 
        String line = null;
        line = bufferedReader.readLine(); 
        String[] requirements = line.split(","); 
        while((line = bufferedReader.readLine()) != null) {
//            System.out.println(line);
            String[] splitted = line.split(","); 
            
            for(int i=1; i<splitted.length; i++) {
            	if(splitted[i].equals("x")) {
            		ReqClassHashMap.put(i+"-"+splitted[0], "T"); 
            	}else {
            		ReqClassHashMap.put(i+"-"+splitted[0], "N"); 
            	}
            }
//            System.out.println(line);
        }   

        // Always close files.
        bufferedReader.close();         
   
		// TODO Auto-generated method stub
    	ComparisonTracesClasses dao = new ComparisonTracesClasses();
    	Connection conn=getConnection(ProgramName);
    	Statement st= conn.createStatement();

//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN SubjectT"); 
//		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold2");
//		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold3");

	

		int  TracesNumber=0; 
		int counter=0; 
		String mytraceclass=""; 
		String classid=""; 
		String requirementid= ""; 
		String gold2=""; 
		String classname=""; 
		String requirementname= ""; 
		Hashtable<String,List<String>> RequirementClassHashMap=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMap2=new Hashtable<String,List<String>>(); 
		List<String> mylist= new ArrayList<String>(); 
		ResultSet TracesCount=st.executeQuery("SELECT COUNT(*) FROM tracesclasses"); 
		while(TracesCount.next()) {
			 TracesNumber= TracesCount.getInt(1); 
			System.out.println(TracesNumber);
		}
		
			ResultSet traces = st.executeQuery("SELECT tracesclasses.* from tracesclasses "); 
			 counter=1; 
			while(traces.next()){		
				//THIS IS GOLD 2
				 requirementid=traces.getString("requirementid").trim(); 
				 classid=traces.getString("classid").trim(); 
				 requirementname=traces.getString("requirement").trim(); 
				 classname=traces.getString("classname").trim(); 
				String goldfinal=traces.getString("goldfinal").trim(); 
				String reqclassid= requirementid+"-"+classid; 
				String reqclassname= requirementid+"-"+classname; 

				String NewTraceValue = ReqClassHashMap.get(requirementid+"-"+classname); 
				if(NewTraceValue!=null) {
					if(NewTraceValue.equals(goldfinal) && (goldfinal.trim().equals("T")||NewTraceValue.trim().equals("T"))) {
						System.out.println(counter +" "+ProgramName+"  req-classid "+reqclassid+"  req-classname "+reqclassname+" EQUAL NEW VALUE "+NewTraceValue +" OLD VALUE "+goldfinal);
						counter++; 
					}
					
					else if(!NewTraceValue.equals(goldfinal) && (goldfinal.trim().equals("T")||NewTraceValue.trim().equals("T"))){
						System.out.println(counter +" "+ProgramName+"  req-classid "+reqclassid+"  req-classname "+reqclassname+" NOTEQUAL NEW VALUE "+NewTraceValue +" OLD VALUE "+goldfinal);
						counter++; 
					}
				
				}
				
				
				
			
	   		   }
			counter++; 
		
		

		
		

	
	}


}
