package Gantt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import Chess.PredictionEvaluation;

import java.util.Properties;
import java.util.Set;

import Tables.tracesmethodscallees;
import mypackage.ClassRepresentation2;
import mypackage.Interface2;
import mypackage.Method2Representation;
import mypackage.MethodTrace2;
import mypackage.Requirement2;
import mypackage.SuperClass2;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.CtModel;
import spoon.reflect.factory.ClassFactory;
import spoon.reflect.factory.Factory;
import spoon.reflect.factory.InterfaceFactory;
import spoon.reflect.factory.MethodFactory;

public class GeneralizationComparison {
	/** The name of the MySQL account to use (or empty for anonymous) */
	private static final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private static final String password = "root";

	/** The name of the computer running MySQL */  
	
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "databasegantt";
	
	/** The name of the table we are testing with */
	private final String tableName = "classes";
	public static List<tracesmethodscallees> TracesCalleesList= new ArrayList<tracesmethodscallees>();
	public static List<tracesmethodscallees> TracesCallersList= new ArrayList<tracesmethodscallees>();
	public static HashMap <String, String> MethodInterfaces = new HashMap <String, String>(); 
	public static HashMap <String, String> InterfacesMethods = new HashMap <String, String>(); 
	public static HashMap <String, String> MethodSuperclasses = new HashMap <String, String>(); 
	public static HashMap <String, String> SuperclassesMethods = new HashMap <String, String>(); 
	
	public static HashMap <String, List<String>> methodcallsinexecnotparsedcallercallee = new HashMap <String, List<String>>(); 
	public static HashMap <String, List<String>> methodcallsinexecnotparsedcalleecaller = new HashMap <String, List<String>>(); 
	public static HashMap <String, List<String>> methodcallsinparsednotexecallercallee = new HashMap <String, List<String>>(); 
	public static HashMap <String, List<String>> methodcallsinparsednotexecalleecaller = new HashMap <String, List<String>>(); 
	public static LinkedHashMap <String, List<MethodTrace2>> ImplementationsTracesHashMap = new LinkedHashMap <String, List<MethodTrace2>>(); 
	public static LinkedHashMap <String, List<Interface2>> InterfacesImplementationsHashMap = new LinkedHashMap <String, List<Interface2>>(); 
	public static LinkedHashMap <String, List<SuperClass2>> SuperclassesChildrenHashMap = new LinkedHashMap <String, List<SuperClass2>>(); 

	static File fout = null; 
	static FileOutputStream fos = null; 
	static BufferedWriter bwGold = null; 
	
	static File foutIntersection = null; 
	static FileOutputStream fosIntersection = null; 
	static BufferedWriter bwGoldIntersection = null; 
	public GeneralizationComparison(List<tracesmethodscallees> tracesCalleesList) {
		 TracesCalleesList= new ArrayList<tracesmethodscallees>();

	}

	public GeneralizationComparison() {
		// TODO Auto-generated constructor stub
	}

	public List<tracesmethodscallees> getTracesCalleesList() {
		return TracesCalleesList;
	}

	public void setTracesCalleesList(List<tracesmethodscallees> tracesCalleesList) {
		TracesCalleesList = tracesCalleesList;
	}

	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("root", userName);
		connectionProps.put("123456", password);
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
	 * @throws FileNotFoundException 
	 */
	public void run() throws FileNotFoundException {
		ResultSet rs = null; 
		PrintStream fileOut = new PrintStream("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logs\\GeneralizationComparisonGantt.txt");

		// Connect to MySQL
		Connection conn = null;
		try {
			conn = getConnection();
			System.out.println("Connected to database");
			
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}

		// Create a table
		try {
			List<Interface2> implementationList = new ArrayList<Interface2>(); 
			List<SuperClass2> superclassList = new ArrayList<SuperClass2>(); 
			HashMap<String, String> myhashmap= new 	HashMap<String, String>(); 
			Statement st= conn.createStatement();
			
			ResultSet res2=st.executeQuery("SELECT *" + 
					"			FROM databasegantt.tracesclasses" ); 
			while(res2.next()) {
				String requirementid=""; 
				String classid=""; 
				String gold5=""; 
				String gold5V2=""; 
				String gold=""; 
				requirementid=res2.getString("requirementid"); 
				classid=res2.getString("classid"); 
				gold5=res2.getString("gold5"); 
				gold5V2=res2.getString("gold5V2"); 
				gold=res2.getString("gold"); 
				myhashmap.put(requirementid+"-"+classid, gold+"-"+gold5+"-"+gold5V2); 
				
			}
			
			
			
			
			
			
			
			
			
			PredictionEvaluation predMouna= new PredictionEvaluation();
			PredictionEvaluation predAlex= new PredictionEvaluation();
			System.setOut(fileOut);

			for (  Entry<String, String>entry : myhashmap.entrySet()) {
			    String key = entry.getKey();
			   String value = entry.getValue();
			    // now work with key and value...
			   String[] keys = key.split("-"); 
			    String[] values = value.split("-"); 
				 String RequirementID= keys[0]; 
				 String classid= keys[1]; 
				 String gold= values[0]; 
				 String gold5= values[1]; 
				 String gold5V2= values[2]; 
				 
				if(gold5.trim().equals("T") && gold.trim().equals("T")) {
					predMouna.TruePositive++; 
				}
				else if(gold5.trim().equals("T") && gold.trim().equals("N")) {
					predMouna.FalsePositive++; 
				}
				if(gold5.trim().equals("N") && gold.trim().equals("N")) {
					predMouna.TrueNegative++; 
				}
				else if(gold5.trim().equals("N") && gold.trim().equals("T")) {
					predMouna.FalseNegative++; 
				}
				else if(gold5.trim().equals("E") || gold.trim().equals("E")) {
					predMouna.E++; 
				}
				 
				
				
				
				
				
				if(gold5V2.trim().equals("T") && gold.trim().equals("T")) {
					predAlex.TruePositive++; 
				}
				else if(gold5V2.trim().equals("T") && gold.trim().equals("N")) {
					predAlex.FalsePositive++; 
				}
				if(gold5V2.trim().equals("N") && gold.trim().equals("N")) {
					predAlex.TrueNegative++; 
				}
				else if(gold5V2.trim().equals("N") && gold.trim().equals("T")) {
					predAlex.FalseNegative++; 
				}
				else if(gold5V2.trim().equals("E") || gold.trim().equals("E")) {
					predAlex.E++; 
				}
				
			
			}
			
			
			
			
			int TotalAlex=predAlex.E+predAlex.TruePositive+predAlex.TrueNegative+predAlex.FalsePositive+predAlex.FalseNegative; 
			int TotalMouna=predMouna.E+predMouna.TruePositive+predMouna.TrueNegative+predMouna.FalsePositive+predMouna.FalseNegative; 
			System.out.println("Alex ======"+predAlex.toString2()+ "  TOTAL "+TotalAlex);
			System.out.println("Mouna ======"+predMouna.toString2()+ "  TOTAL "+TotalMouna);
			System.out.println("finished");
		
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		}
		
		
	}
	
	/**
	 * Connect to the DB and do some stuff
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws SQLException, IOException {
		GeneralizationComparison app = new GeneralizationComparison();
		app.run();
		Spoon(); 
		
	}
	
	

	public static void Spoon() throws SQLException, IOException {
		
		
		
		
		
		
	}

	
}