package iTrust;

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

import java.util.Properties;

import Tables.tracesmethodscallees;
import mypackage.Clazz;
import mypackage.Interface2;
import mypackage.Method;
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
	private final String dbName = "databaseitrust";
	
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
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseitrust","root","123456");

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
		PrintStream fileOut = new PrintStream("C:\\Users\\mouna\\dumps\\logs\\consoleiTrustGeneralization.txt");

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

			Statement st= conn.createStatement();
			String requirement=""; 
			String requirementid=""; 
			String methodname=""; 
			String methodid=""; 
			String fullmethod=""; 
			String classname=""; 
			String classid=""; 
			String gold2=""; 
			String interfaceclassid=""; 
			String interfacename=""; 
			String implementationclassid=""; 
			String implementationclassname=""; 
			String superclassid=""; 
			String superclassname=""; 
			String childclassid=""; 
			String childclassname=""; 
			String rowID=""; 
			
				//implementationList.add(myinter); 
				
			
			
			HashMap<String, List<String>> RequirementClassHashMapGold2= new HashMap<String, List<String>>(); 			
			HashMap<String, List<String>> RequirementClassHashMapGold2TRACESCLASSES= new HashMap<String, List<String>>(); 			

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			int	counter=0; 
			ResultSet res=st.executeQuery("SELECT *" + 
					"			FROM databaseitrust.traces" ); 
			while(res.next()) {
				
				rowID=res.getString("id"); 
				requirement=res.getString("requirement"); 
				requirementid=res.getString("requirementid"); 
				methodname=res.getString("methodname"); 
				methodid=res.getString("methodid"); 
				fullmethod=res.getString("fullmethod"); 
				classname=res.getString("classname"); 
				classid=res.getString("classid"); 
				gold2=res.getString("gold2"); 
				MethodTrace2 methodtrace= new MethodTrace2(); 
				Requirement2 req= new Requirement2(requirementid, requirement); 
				Method methodrep = new Method(methodid, methodname); 
				Clazz classrep = new Clazz(classid, classname); 
				methodtrace.setID(rowID);
				methodtrace.setRequirement(req);
				methodtrace.setMethodRepresentation(methodrep);
				methodtrace.setClassRepresentation(classrep);
				methodtrace.setGold2(gold2);
			if(RequirementClassHashMapGold2.get(requirementid+"-"+classid)!=null) {
				List<String> list = RequirementClassHashMapGold2.get(requirementid+"-"+classid); 
				list.add(gold2); 
				RequirementClassHashMapGold2.put(requirementid+"-"+classid, list);
			}else {
				List<String> list = new ArrayList<String>(); 
				list.add(gold2); 
				
				RequirementClassHashMapGold2.put(requirementid+"-"+classid, list);
			} 
				
				
			
			}
			
			ResultSet res2=st.executeQuery("SELECT *" + 
					"			FROM databaseitrust.tracesclasses" ); 
			while(res2.next()) {
				
				rowID=res2.getString("id"); 
				requirement=res2.getString("requirement"); 
				requirementid=res2.getString("requirementid"); 
				
				classname=res2.getString("classname"); 
				classid=res2.getString("classid"); 
				gold2=res2.getString("gold2V2"); 
				MethodTrace2 methodtrace= new MethodTrace2(); 
				Requirement2 req= new Requirement2(requirementid, requirement); 
				Method methodrep = new Method(methodid, methodname); 
				Clazz classrep = new Clazz(classid, classname); 
				methodtrace.setID(rowID);
				methodtrace.setRequirement(req);
				methodtrace.setMethodRepresentation(methodrep);
				methodtrace.setClassRepresentation(classrep);
				methodtrace.setGold2(gold2);
			if(RequirementClassHashMapGold2TRACESCLASSES.get(requirementid+"-"+classid)!=null) {
				List<String> list = RequirementClassHashMapGold2TRACESCLASSES.get(requirementid+"-"+classid); 
				list.add(gold2); 
				RequirementClassHashMapGold2TRACESCLASSES.put(requirementid+"-"+classid, list);
			}else {
				List<String> list = new ArrayList<String>(); 
				list.add(gold2); 
				
				RequirementClassHashMapGold2TRACESCLASSES.put(requirementid+"-"+classid, list);
			} 
				
				
			
			}
			
			
			
	
			System.setOut(fileOut);
			
			  System.out.println("RequirementID, ClassID, Generalization, Values");

			for (Entry<String, List<String>> entry : RequirementClassHashMapGold2.entrySet()) {
			    String key = entry.getKey();
			    List<String> values = entry.getValue();
			    // now work with key and value...
			    String[] keys = key.split("-"); 
			    String reqID = keys[0]; 
			    String  classID= keys[1]; 
				 System.out.print(reqID+","+classID+","+RequirementClassHashMapGold2TRACESCLASSES.get(key)+","); 
				for(String value: values) {
					
			

			        System.out.print(value+" ");
			    }
				 System.out.println(); 
				
				
				
				
			
			}
			
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
