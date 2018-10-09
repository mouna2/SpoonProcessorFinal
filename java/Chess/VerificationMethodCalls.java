package Chess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import Tables.tracesmethodscallees;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.CtModel;
import spoon.reflect.factory.ClassFactory;
import spoon.reflect.factory.Factory;
import spoon.reflect.factory.InterfaceFactory;
import spoon.reflect.factory.MethodFactory;

public class VerificationMethodCalls {
	/** The name of the MySQL account to use (or empty for anonymous) */
	private static final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private static final String password = "root";

	/** The name of the computer running MySQL */  
	
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "databasechess";
	
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
	
	static File fout = null; 
	static FileOutputStream fos = null; 
	static BufferedWriter bwGold = null; 
	
	static File foutIntersection = null; 
	static FileOutputStream fosIntersection = null; 
	static BufferedWriter bwGoldIntersection = null; 
	public VerificationMethodCalls(List<tracesmethodscallees> tracesCalleesList) {
		 TracesCalleesList= new ArrayList<tracesmethodscallees>();

	}

	public VerificationMethodCalls() {
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
	 * @throws FileNotFoundException 
	 */
	public void run() throws FileNotFoundException {
		ResultSet rs = null; 
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
			Statement st= conn.createStatement();
		
			
			ResultSet intersectionparsedexecuted=st.executeQuery("SELECT count(*)" + 
					"			FROM databasechess.intersectionparsedexecuted" ); 
			if(intersectionparsedexecuted.next()) {
				st.execute("DROP TABLE intersectionparsedexecuted");
			}		st.executeUpdate("CREATE TABLE intersectionparsedexecuted"
					+" SELECT  databasechess.methodcallsexecuted.*\r\n" + 
					"   FROM databasechess.methodcalls\r\n" + 
					"   inner join databasechess.methodcallsexecuted \r\n" + 
					"   ON methodcalls.callermethodid=methodcallsexecuted.callermethodid and methodcalls.calleemethodid=methodcallsexecuted.calleemethodid"); 
			
		
			
			
			

			ResultSet methodcallsinparsednotexecexists=st.executeQuery("SELECT count(*)" + 
					"			FROM databasechess.methodcallsinparsednotexec" ); 
			if(methodcallsinparsednotexecexists.next()) {
				st.execute("DROP TABLE methodcallsinparsednotexec");
			}
			
//			st.executeUpdate("CREATE TABLE methodcallsinparsednotexec"
//					+  " SELECT methodcalls.*" + 
//					" FROM databasechess.methodcalls" + 
//					" LEFT OUTER JOIN databasechess.methodcallsexecuted" + 
//					" ON methodcalls.calleemethodid = methodcallsexecuted.calleemethodid and methodcalls.callermethodid = methodcallsexecuted.callermethodid" + 
//					" WHERE  methodcallsexecuted.callermethodid IS NULL and methodcallsexecuted.callermethodid IS NULL"); 
			
			st.executeUpdate("CREATE TABLE methodcallsinparsednotexec"
					+  " SELECT methodcalls.*" + 
					" FROM databasechess.methodcalls" + 
					" WHERE NOT EXISTS (SELECT intersectionparsedexecuted.*"+
			                  " FROM intersectionparsedexecuted"+
			                 " WHERE intersectionparsedexecuted.callermethodid = methodcalls.callermethodid AND"
			                 + " intersectionparsedexecuted.calleemethodid = methodcalls.calleemethodid)");
			
			
			
			ResultSet methodcallsinexecnotparsedexists=st.executeQuery("SELECT count(*)" + 
					"			FROM databasechess.methodcallsinexecnotparsed" ); 
			if(methodcallsinexecnotparsedexists.next()) {
				st.execute("DROP TABLE methodcallsinexecnotparsed");
			}
			
			st.executeUpdate("CREATE TABLE methodcallsinexecnotparsed"
					+  " SELECT methodcallsexecuted.*" + 
					" FROM databasechess.methodcallsexecuted" + 
					" WHERE NOT EXISTS (SELECT intersectionparsedexecuted.*"+
			                " FROM intersectionparsedexecuted"+
			                 " WHERE intersectionparsedexecuted.callermethodid = methodcallsexecuted.callermethodid AND "
			                 + " intersectionparsedexecuted.calleemethodid = methodcallsexecuted.calleemethodid)");
			
			
//			st.executeUpdate("CREATE TABLE methodcallsinexecnotparsed"
//					+" SELECT methodcallsexecuted.*\r\n" + 
//					" FROM databasechess.methodcallsexecuted\r\n" + 
//					" LEFT OUTER JOIN databasechess.methodcalls\r\n" + 
//					" ON methodcalls.calleemethodid = methodcallsexecuted.calleemethodid and methodcalls.callermethodid = methodcallsexecuted.callermethodid\r\n" + 
//					" WHERE  methodcalls.callermethodid IS NULL and methodcalls.callermethodid IS NULL"); 
			
			
			
			
		 
		  
		   
		   
		
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
		VerificationMethodCalls app = new VerificationMethodCalls();
		app.run();
		Spoon(); 
		
	}
	
	

	public static void Spoon() throws SQLException, IOException {
	Connection conn=getConnection();
	Statement st= conn.createStatement();
	 fout = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\CallsNotFoundLog.txt");
	 fos = new FileOutputStream(fout);
	 bwGold = new BufferedWriter(new OutputStreamWriter(fos));

	bwGold.write("description/ id/ callermethodid/ callername/ callerclass/ calleemethodid/ calleename/ calleeclass");
	bwGold.newLine();
	Statement st2= conn.createStatement();
	Statement st3= conn.createStatement();
		SpoonAPI spoon = new Launcher();
    	spoon.addInputResource("C:\\Users\\mouna\\Downloads\\chess and gantt code\\workspace_codeBase\\Chess\\src");
    	spoon.getEnvironment().setAutoImports(true);
    	spoon.getEnvironment().setNoClasspath(true);
    	CtModel model = spoon.buildModel();

    	//List<String> classnames= new ArrayList<String>(); 
  
    	// Interact with model
    	Factory factory = spoon.getFactory();
    	ClassFactory classFactory = factory.Class();
    	MethodFactory methodFactory = factory.Method(); 
    	InterfaceFactory interfaceFactory = factory.Interface(); 
    	int MethodsNumber=0; 
    	int methodcallsinparsednotexec=0; 
    	int methodcallsinexecnotparsed=0; 
    	int Methodssuperclasses=0; 
    	int i=1; 
    	int count=1; 
    	int count2=1; 
    	int count3=1; 
    	int count4=1; 

        /*********************************************************************************************************************************************************************************/	
        /*********************************************************************************************************************************************************************************/	
        /*********************************************************************************************************************************************************************************/	  	
    	ResultSet TracesCount2=st.executeQuery("SELECT COUNT(*) FROM methodcallsinparsednotexec"); 
		while(TracesCount2.next()) {
			methodcallsinparsednotexec= TracesCount2.getInt(1); 
			//System.out.println(methodcallsinparsednotexec);
		}
		ResultSet TracesCount3=st.executeQuery("SELECT COUNT(*) FROM methodcallsinexecnotparsed"); 
		while(TracesCount3.next()) {
			methodcallsinexecnotparsed= TracesCount3.getInt(1); 
		//	System.out.println(methodcallsinexecnotparsed);
		}
    	
    	
    	
    	ResultSet TracesCount=st.executeQuery("SELECT COUNT(*) FROM methodsinterfaces"); 
		while(TracesCount.next()) {
			MethodsNumber= TracesCount.getInt(1); 
		//	System.out.println(MethodsNumber);
		}
		ResultSet TracesCountSuperclasses=st.executeQuery("SELECT COUNT(*) FROM methodssuperclasses"); 
		while(TracesCountSuperclasses.next()) {
			Methodssuperclasses= TracesCountSuperclasses.getInt(1); 
		//	System.out.println(Methodssuperclasses);
		}
		
		
		while(count<=MethodsNumber) {
			ResultSet myresults=st.executeQuery("select methodsinterfaces.* from methodsinterfaces where id='"+count+"'"); 
	    	while(myresults.next()) {
	    		String FullInterface= myresults.getString("fullinterfacename"); 
	    		String FullMethod= myresults.getString("fullmethodname"); 
	    		InterfacesMethods.put(FullInterface, FullMethod); 
	    		MethodInterfaces.put(FullMethod, FullInterface); 
	    	}
	    	count++; 
		}
    	
    	
		while(count2<=Methodssuperclasses) {
			ResultSet myresults=st.executeQuery("select methodssuperclasses.* from methodssuperclasses where id='"+count2+"'"); 
	    	while(myresults.next()) {
	    		String FullSuperclass= myresults.getString("fullsuperclassname"); 
	    		String FullMethod= myresults.getString("fullmethodname"); 
	    		SuperclassesMethods.put(FullSuperclass, FullMethod); 
	    		MethodSuperclasses.put(FullMethod, FullSuperclass); 
	    	}
	    	count2++; 
		}

			ResultSet myresults2=st.executeQuery("select methodcallsinparsednotexec.* from methodcallsinparsednotexec "); 
	    	while(myresults2.next()) {
	    		List<String> mylist1= new ArrayList<String>(); 
	    		List<String> mylist2= new ArrayList<String>(); 
	    		String id= myresults2.getString("id"); 
	    		String Fullcaller= myresults2.getString("fullcaller"); 
	    		String Fullcallee= myresults2.getString("fullcallee"); 
	    		if(methodcallsinparsednotexecallercallee.get(Fullcaller)!=null) {
	    			mylist1 = methodcallsinparsednotexecallercallee.get(Fullcaller); 
	    		
	    		}
	    		mylist1.add(Fullcallee); 
    			methodcallsinparsednotexecallercallee.put(Fullcaller, mylist1); 
	    		if(methodcallsinparsednotexecalleecaller.get(Fullcallee)!=null) {
	    			 mylist2=methodcallsinparsednotexecalleecaller.get(Fullcallee); 
	    			

	    		}
	    		mylist2.add(Fullcaller); 
    			methodcallsinparsednotexecalleecaller.put(Fullcallee, mylist2); 
	    	
	    	//	System.out.println(id);
	    	}
	    	
		
	    	
	    	
	    	ResultSet myresults3=st.executeQuery("select methodcallsinexecnotparsed.* from methodcallsinexecnotparsed "); 
	    	while(myresults3.next()) {
	    	
	    		List<String> mylist1= new ArrayList<String>(); 
	    		List<String> mylist2= new ArrayList<String>(); 
	    		String id= myresults3.getString("id"); 
	    		String Fullcaller= myresults3.getString("fullcaller"); 
	    		String Fullcallee= myresults3.getString("fullcallee"); 
	    		if(methodcallsinexecnotparsedcallercallee.get(Fullcaller)!=null) {
	    			mylist1 = methodcallsinexecnotparsedcallercallee.get(Fullcaller); 
	    		
	    		}
	    		mylist1.add(Fullcallee); 
	    		methodcallsinexecnotparsedcallercallee.put(Fullcaller, mylist1); 
	    		
	    		
	    	
	    		
	    		
	    		if(methodcallsinexecnotparsedcalleecaller.get(Fullcallee)!=null) {
	    			 mylist2=methodcallsinexecnotparsedcalleecaller.get(Fullcallee); 
	    			

	    		}
	    		mylist2.add(Fullcaller); 
	    		methodcallsinexecnotparsedcalleecaller.put(Fullcallee, mylist2); 
	    	
	    		System.out.println(id);
	    	}
	    	
    	
    	
	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	String storefullcallee=""; 
	    	int mynewcounter=1; 
			ResultSet myresults4=st.executeQuery("select methodcallsinparsednotexec.* from methodcallsinparsednotexec "); 
	    	
			while(myresults4.next()) {
	    		
	    			String fullcaller =myresults4.getString("fullcaller"); 
	    			String fullcallee =myresults4.getString("fullcallee"); 
	    			storefullcallee=fullcallee; 
	    			
	    				
	    			List<String> list = methodcallsinparsednotexecallercallee.get(fullcaller); 
	    			List<String> list2 = methodcallsinparsednotexecalleecaller.get(fullcallee); 
	    			boolean entered1=false; 
    				boolean entered2=false; 
    				boolean entered3=false; 
    				boolean entered4=false; 
    				boolean entered5=false; 
    				boolean entered6=false; 
    				boolean entered7=false; 
    				boolean entered8=false; 
    				boolean entered9=false; 
    				boolean entered10=false; 
    				boolean entered11=false; 
    				boolean entered12=false; 
	    			if(list!=null) {
	    			for(String mycallee: list) {
	    				//System.out.println("====>"+mycallee);
	    				String mycallee1=MethodInterfaces.get(mycallee); 
	    				String mycallee2=InterfacesMethods.get(mycallee); 
	    				String mycallee3=SuperclassesMethods.get(mycallee); 
	    				String mycallee4=MethodSuperclasses.get(mycallee); 
	    			
	    				if(mycallee1!=null) {
	    					System.out.println("COUNTER ====="+mynewcounter);
	    					System.out.println("WROTE");
	    					String EquivalenceType="INTERFACE EQUIVALENCE CALLEE IN PARSED NOT EXEC"; 
	    					//if(entered1!=true) {
	    						entered1=WriteInDoc(fullcaller, mycallee, mycallee1, EquivalenceType, st3); 
	    					//}
	    					 
	    				
	    				
	    					
	    					
	    				}
	    				
	    				if(mycallee2!=null) {
	    					System.out.println("COUNTER ====="+mynewcounter);
	    					System.out.println("WROTE");
	    					String EquivalenceType="IMPLEMENTATION EQUIVALENCE CALLEE IN PARSED NOT EXEC";
	    					//if(entered2!=true) {
		    					entered2=WriteInDoc(fullcaller, mycallee, mycallee2, EquivalenceType, st3); 

	    					//}
	    					 
	    					
	    				
	    				}
	    				
	    				if(mycallee3!=null) {
	    					System.out.println("COUNTER ====="+mynewcounter);
	    					System.out.println("WROTE");
	    					String EquivalenceType="SUPERCLASS EQUIVALENCE CALLEE IN PARSED NOT EXEC"; 
	    					//if(entered3!=true) {
		    					entered3=WriteInDoc(fullcaller, mycallee, mycallee3, EquivalenceType, st3); 

	    					//}
	    					
	    				}
	    				
	    				if(mycallee4!=null) {
	    					System.out.println("COUNTER ====="+mynewcounter);
	    					System.out.println("WROTE");
	    					String EquivalenceType="CHILDCLASS EQUIVALENCE CALLEE IN PARSED NOT EXEC"; 
	    					//if(entered4!=true) {
		    					entered4=WriteInDoc(fullcaller, mycallee, mycallee4, EquivalenceType, st3); 

	    					//}
	    					               
	    					
	    				}

	    				
	    				
	    			}
	    		
	    			}
	    			
	    			if(list2!=null) {
	    				for(String mycaller: list2) {
	        				//System.out.println(mycallee);
	        				String mycaller1=MethodInterfaces.get(mycaller); 
	        				String mycaller2=InterfacesMethods.get(mycaller); 
	        				String mycaller3=SuperclassesMethods.get(mycaller); 
	        				String mycaller4=MethodSuperclasses.get(mycaller); 
	        			
	        				if(mycaller1!=null) {
	        					System.out.println("COUNTER ====="+mynewcounter);
	        					System.out.println("WROTE");
		    					String EquivalenceType="INTERFACE EQUIVALENCE CALLER IN PARSED NOT EXEC"; 
		    					//if(entered5!=true) {
			    					entered5=WriteInDoc2(fullcallee, mycaller, mycaller1, EquivalenceType, st3); 

		    					//}
		    					
		    				
		    					
		    				
		    				}
		    				
		    				if(mycaller2!=null) {
		    					System.out.println("COUNTER ====="+mynewcounter);
		    					System.out.println("WROTE");
		    					String EquivalenceType="IMPLEMENTATION EQUIVALENCE CALLER IN PARSED NOT EXEC"; 
		    					//if(entered6!=true) {
			    					entered6=WriteInDoc2(fullcallee, mycaller, mycaller2, EquivalenceType, st3); 

		    					//}
		    					
		    					
		    						  	
		    				}
		    				
		    				if(mycaller3!=null) {
		    					System.out.println("COUNTER ====="+mynewcounter);
		    					System.out.println("WROTE");
		    					
		    					String EquivalenceType="SUPERCLASS EQUIVALENCE CALLER IN PARSED NOT EXEC"; 
		    					//if(entered7!=true){
			    					entered7=WriteInDoc2(fullcallee, mycaller, mycaller3, EquivalenceType, st3); 

		    					//}
		    					
		    				}
		    				
		    				if(mycaller4!=null) {
		    					System.out.println("COUNTER ====="+mynewcounter);
		    					System.out.println("WROTE");
		    				
			    	    		
		    					String EquivalenceType="CHILDCLASS EQUIVALENCE CALLER IN PARSED NOT EXEC"; 
		    					//if(entered8!=true){
			    					entered8=WriteInDoc2(fullcallee, mycaller, mycaller4, EquivalenceType, st3); 

		    					//}
		    					
		    				}
	        			}
	    			}
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			if(list!=null && list2!=null) {
	    				for(String mycaller: list2) {
	        				//System.out.println(mycallee);
	        				String mycaller1=MethodInterfaces.get(mycaller); 
	        				String mycaller2=InterfacesMethods.get(mycaller); 
	        				String mycaller3=SuperclassesMethods.get(mycaller); 
	        				String mycaller4=MethodSuperclasses.get(mycaller); 
	        				
	        				
	    	 			for(String mycallee: list) {
		    				//System.out.println("====>"+mycallee);
		    				String mycallee1=MethodInterfaces.get(mycallee); 
		    				String mycallee2=InterfacesMethods.get(mycallee); 
		    				String mycallee3=SuperclassesMethods.get(mycallee); 
		    				String mycallee4=MethodSuperclasses.get(mycallee); 
		    				
		    				if(mycallee1!=null && mycaller1!=null) {
		    					System.out.println("COUNTER ====="+mynewcounter);
		    					System.out.println("WROTE");
		    					String EquivalenceType="INTERFACE EQUIVALENCE BOTH CALLEE CALLER IN PARSED NOT EXEC";
		    					//if(entered9!=true) {
			    					entered9=WriteInDocBothCallerCallee(fullcaller, mycallee, mycallee1, mycaller1, EquivalenceType, st3); 

		    					//}
		    				
		    					
		    					
		    				}
		    				
		    				if(mycallee2!=null && mycaller2!=null) {
		    					System.out.println("COUNTER ====="+mynewcounter);
		    					System.out.println("WROTE");
		    					String EquivalenceType="IMPLEMENTATION EQUIVALENCE BOTH CALLEE CALLER IN PARSED NOT EXEC"; 
		    					//if(entered10!=true) {
			    					entered10=WriteInDocBothCallerCallee(fullcaller, mycallee, mycallee2, mycaller2, EquivalenceType, st3); 

		    					//}
		    					
		    				
		    				}
		    				
		    				if(mycallee3!=null && mycaller3!=null) {
		    					System.out.println("COUNTER ====="+mynewcounter);
		    					System.out.println("WROTE");
		    					String EquivalenceType="SUPERCLASS EQUIVALENCE BOTH CALLEE CALLER IN PARSED NOT EXEC"; 
		    					//if(entered11!=true) {
			    					entered11=WriteInDocBothCallerCallee(fullcaller, mycallee, mycallee3, mycaller3, EquivalenceType, st3); 

		    					//}
		    				}
		    				
		    				if(mycallee4!=null && mycaller4!=null) {
		    					System.out.println("COUNTER ====="+mynewcounter);
		    					System.out.println("WROTE");
		    					String EquivalenceType="CHILDCLASS EQUIVALENCE BOTH CALLEE CALLER IN PARSED NOT EXEC"; 
		    					//if(entered12!=true) {
			    					entered12=WriteInDocBothCallerCallee(fullcaller, mycallee, mycallee4, mycaller4, EquivalenceType, st3); 

		    					//}
		    				}

		    				
		    				
		    			}

	    				}
	    				
	    			
	    			}
	    			
	    			
	    			
	    			

	    	
	    	
	    	
	    			
	    		
//	    			if(entered1==false && entered2==false && entered3==false && 
//	    					entered4==false && entered5==false && entered6==false && 
//	    					entered7==false && entered8==false && entered9==false && 
//	    					entered10==false && entered11==false && entered12==false ) {
//	    	    		System.out.println("COUNTER ====="+mynewcounter);
//	    	    		System.out.println("WROTE");
//	    	    		
//	    	    	
//	    				String EquivalenceType="NOT MAPPED IN PARSED NOT EXEC"; 
//	    				WriteInDocNotMapped(fullcaller, fullcallee, EquivalenceType, st3); 
//	    			}
	    	    	

	    	
	    	
	    	    	mynewcounter++; 
	    	}
	    
	    	
	    
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
    	
		
		
		
		
		
	    	
	    	
	    	
    	
		
		int counteryes=1; 
		 myresults4=st.executeQuery("select methodcallsinexecnotparsed.* from methodcallsinexecnotparsed "); 
    	while(myresults4.next()) {
    		
    			String fullcaller =myresults4.getString("fullcaller"); 
    			String fullcallee =myresults4.getString("fullcallee"); 
    			boolean entered1exec=false; 
				boolean entered2exec=false; 
				boolean entered3exec=false; 
				boolean entered4exec=false; 
				boolean entered5exec=false; 
				boolean entered6exec=false; 
				boolean entered7exec=false; 
				boolean entered8exec=false; 
				boolean entered9exec=false; 
				boolean entered10exec=false; 
				boolean entered11exec=false; 
				boolean entered12exec=false; 
    			
    			
    			List<String> list = methodcallsinexecnotparsedcallercallee.get(fullcaller); 
    			List<String> list2 = methodcallsinexecnotparsedcalleecaller.get(fullcallee); 
    			if(list!=null) {
    				for(String mycallee: list) {
        				//System.out.println(mycallee);
        				String mycallee1=MethodInterfaces.get(mycallee); 
        				String mycallee2=InterfacesMethods.get(mycallee); 
        				String mycallee3=SuperclassesMethods.get(mycallee); 
        				String mycallee4=MethodSuperclasses.get(mycallee); 
        				
        				
        		
        				if(mycallee1!=null) {
        					System.out.println("COUNTER YES====="+counteryes);
        					System.out.println("WROTE");
        					String EquivalenceType="INTERFACE EQUIVALENCE CALLEE IN EXEC NOT PARSED "; 
        					//if(entered1exec!=true){
            					entered1exec=WriteInDocExec(fullcaller, mycallee, mycallee1, EquivalenceType, st3); 

        					//}
        					
        				
        					
        					
        				}
        				
        				if(mycallee2!=null) {
        					System.out.println("COUNTER YES====="+counteryes);
        					System.out.println("WROTE");
        					String EquivalenceType="IMPLEMENTATION EQUIVALENCE CALLEE IN EXEC NOT PARSED "; 
        					//if(entered2exec!=true) {
            					entered2exec=WriteInDocExec(fullcaller, mycallee, mycallee2, EquivalenceType, st3); 

        					//}
        				
        					
        				
        				}
        				
        				if(mycallee3!=null) {
        					System.out.println("COUNTER YES====="+counteryes);
        					System.out.println("WROTE");
        					String EquivalenceType="SUPERCLASS EQUIVALENCE CALLEE IN EXEC NOT PARSED "; 
        					//if(entered3exec!=true) {
            					entered3exec=WriteInDocExec(fullcaller, mycallee, mycallee3, EquivalenceType, st3); 

        					//}
        					
        				}
        				
        				if(mycallee4!=null) {
        					System.out.println("COUNTER YES====="+counteryes);
        					System.out.println("WROTE");
        					String EquivalenceType="CHILDCLASS EQUIVALENCE CALLEE IN EXEC NOT PARSED "; 
        					//if(entered4exec!=true) {
            					entered4exec=WriteInDocExec(fullcaller, mycallee, mycallee4, EquivalenceType, st3); 

        					//}
        					
        				}
        				
        				
        				
        			}
        			
    			}
    	
    			
    			if(list2!=null) {
    				for(String mycaller: list2) {
        				//System.out.println(mycallee);
        				String mycaller1=MethodInterfaces.get(mycaller); 
        				String mycaller2=InterfacesMethods.get(mycaller); 
        				String mycaller3=SuperclassesMethods.get(mycaller); 
        				String mycaller4=MethodSuperclasses.get(mycaller); 
        			
        				
        				
        				if(mycaller1!=null) {
	    					String EquivalenceType="INTERFACE EQUIVALENCE CALLER IN EXEC NOT PARSED "; 
	    					System.out.println("COUNTER YES====="+counteryes);
	    					System.out.println("WROTE");
	    					//if(entered5exec!=true) {
		    					entered5exec=WriteInDocExec2(fullcallee, mycaller, mycaller1, EquivalenceType, st3); 

	    					//}
	    				
	    					
	    				
	    				}
	    				
	    				if(mycaller2!=null) {
	    					System.out.println("COUNTER YES====="+counteryes);
	    					System.out.println("WROTE");
	    					String EquivalenceType="IMPLEMENTATION EQUIVALENCE CALLER IN EXEC NOT PARSED "; 
	    					//if(entered6exec!=true) {
		    					entered6exec=WriteInDocExec2(fullcallee, mycaller, mycaller2, EquivalenceType, st3); 

	    					//}
	    					
	    						  	
	    				}
	    				
	    				if(mycaller3!=null) {
	    					System.out.println("COUNTER YES====="+counteryes);
	    					System.out.println("WROTE");
	    					String EquivalenceType="SUPERCLASS EQUIVALENCE CALLER IN EXEC NOT PARSED "; 
	    					//if(entered7exec!=true) {
		    					entered7exec=WriteInDocExec2(fullcallee, mycaller, mycaller3, EquivalenceType, st3); 

	    					//}
	    				}
	    				
	    				if(mycaller4!=null) {
	    					System.out.println("COUNTER YES====="+counteryes);
	    					System.out.println("WROTE");
	    					String EquivalenceType="CHILDCLASS EQUIVALENCE CALLER IN EXEC NOT PARSED "; 
	    					//if(entered8exec!=true) {
		    					entered8exec=WriteInDocExec2(fullcallee, mycaller, mycaller4, EquivalenceType, st3); 

	    					//}
	    				}
        				
        				
        				
        				
        				
        				
        				
        			}	
    			}
        
    	
    	
    	
    			
    			if(list!=null && list2!=null) {
    				for(String mycaller: list2) {
        				//System.out.println(mycallee);
        				String mycaller1=MethodInterfaces.get(mycaller); 
        				String mycaller2=InterfacesMethods.get(mycaller); 
        				String mycaller3=SuperclassesMethods.get(mycaller); 
        				String mycaller4=MethodSuperclasses.get(mycaller); 
        				
        				
    	 			for(String mycallee: list) {
	    				//System.out.println("====>"+mycallee);
	    				String mycallee1=MethodInterfaces.get(mycallee); 
	    				String mycallee2=InterfacesMethods.get(mycallee); 
	    				String mycallee3=SuperclassesMethods.get(mycallee); 
	    				String mycallee4=MethodSuperclasses.get(mycallee); 
	    				
	    				if(mycallee1!=null && mycaller1!=null) {
	    					System.out.println("COUNTER ====="+mynewcounter);
	    					System.out.println("WROTE");
	    					String EquivalenceType="INTERFACE EQUIVALENCE BOTH CALLEE CALLER IN PARSED NOT EXEC"; 
	    					//if(entered9exec!=true) {
		    					entered9exec=WriteInDocBothCallerCalleeExec(fullcaller, mycallee, mycallee1, mycaller1, EquivalenceType, st3); 

	    					//}
	    				
	    					
	    					
	    				}
	    				
	    				if(mycallee2!=null && mycaller2!=null) {
	    					System.out.println("COUNTER ====="+mynewcounter);
	    					System.out.println("WROTE");
	    					String EquivalenceType="IMPLEMENTATION EQUIVALENCE BOTH CALLEE CALLER IN PARSED NOT EXEC"; 
	    					//if(entered10exec!=true) {
		    					entered10exec=WriteInDocBothCallerCalleeExec(fullcaller, mycallee, mycallee2, mycaller2, EquivalenceType, st3); 

	    					//}
	    					
	    				
	    				}
	    				
	    				if(mycallee3!=null && mycaller3!=null) {
	    					System.out.println("COUNTER ====="+mynewcounter);
	    					System.out.println("WROTE");
	    					String EquivalenceType="SUPERCLASS EQUIVALENCE BOTH CALLEE CALLER IN PARSED NOT EXEC"; 
	    					//if(entered11exec!=true) {
		    					entered11exec=WriteInDocBothCallerCalleeExec(fullcaller, mycallee, mycallee3, mycaller3, EquivalenceType, st3); 

	    					//}
	    				}
	    				
	    				if(mycallee4!=null && mycaller4!=null) {
	    					System.out.println("COUNTER ====="+mynewcounter);
	    					System.out.println("WROTE");
	    					String EquivalenceType="CHILDCLASS EQUIVALENCE BOTH CALLEE CALLER IN PARSED NOT EXEC"; 
	    					//if(entered12exec!=true) {
		    					entered12exec=WriteInDocBothCallerCalleeExec(fullcaller, mycallee, mycallee4, mycaller4, EquivalenceType, st3); 

	    					//}
	    				}

	    				
	    				
	    			}

    				}
    				
    			
    			}
    	
    	
//    			if(entered1exec==false && entered2exec==false && entered3exec==false && 
//    					entered4exec==false && entered5exec==false && entered6exec==false && 
//    					entered7exec==false && entered8exec==false && entered9exec==false && 
//    					entered10exec==false && entered11exec==false && entered12exec==false ) {
//    				System.out.println("COUNTER YES====="+counteryes);
//    				System.out.println("WROTE");
//    				String EquivalenceType="NOT MAPPED IN EXEC NOT PARSED"; 
//    				WriteInDocExecNotMapped(fullcaller, fullcallee, EquivalenceType, st3); 
//    			}
//    	
    	
    	
    	counteryes++; 
    	}
    	
		
    	ResultSet myresultsleft=st.executeQuery("select methodcallsinparsednotexec.* from methodcallsinparsednotexec "); 
    	while(myresultsleft.next()) {
    	
    		bwGold.write("NOT MAPPED PARSED  NOT EXEC"+"/"+myresultsleft.getString("id")+"/"+myresultsleft.getString("callermethodid")+"/"+myresultsleft.getString("callername")
    			+"/"+myresultsleft.getString("callerclass")+"/"+myresultsleft.getString("calleemethodid")+"/"+myresultsleft.getString("calleename")
    			+"/"+myresultsleft.getString("calleeclass"));
    		bwGold.newLine(); 
    		
    	
    	}
    	
    	ResultSet myresultsleftexecnotparsed=st.executeQuery("select methodcallsinexecnotparsed.* from methodcallsinexecnotparsed "); 
    	while(myresultsleftexecnotparsed.next()) {
    	
    		bwGold.write("NOT MAPPED EXEC  NOT PARSED"+"/"+myresultsleftexecnotparsed.getString("id")+"/"+myresultsleftexecnotparsed.getString("callermethodid")+"/"+myresultsleftexecnotparsed.getString("callername")
    			+"/"+myresultsleftexecnotparsed.getString("callerclass")+"/"+myresultsleftexecnotparsed.getString("calleemethodid")+"/"+myresultsleftexecnotparsed.getString("calleename")
    			+"/"+myresultsleftexecnotparsed.getString("calleeclass"));
    		bwGold.newLine(); 
    		
    	
    	}
    	
    	
		bwGold.close();
		
		System.out.println("djsdjh");
		
		
		
		
	
		 foutIntersection = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\IntersectionExecParsed.txt");
		 fosIntersection = new FileOutputStream(foutIntersection);
		 bwGoldIntersection = new BufferedWriter(new OutputStreamWriter(fosIntersection));

			bwGoldIntersection.write("description/ id/ callermethodid/ callername/ callerclass/ calleemethodid/ calleename/ calleeclass");		
			bwGoldIntersection.newLine(); 
   
	    	ResultSet myresults=st.executeQuery("select intersectionparsedexecuted.* from intersectionparsedexecuted "); 
	    	while(myresults.next()) {
	    	
	    		bwGoldIntersection.write("INTERSECTION"+"/"+myresults.getString("id")+"/"+myresults.getString("callermethodid")+"/"+myresults.getString("callername")
	    			+"/"+myresults.getString("callerclass")+"/"+myresults.getString("calleemethodid")+"/"+myresults.getString("calleename")
	    			+"/"+myresults.getString("calleeclass"));
	    		bwGoldIntersection.newLine(); 
	    		
	    	
	    	}
	    	
	    	bwGoldIntersection.close();
	    
	    	
	    	
	    	
	    	
	    	
}

	private static boolean WriteInDocBothCallerCalleeExec(String fullcaller, String mycallee, String mycallee1,
			String mycaller1, String equivalenceType, Statement st3) throws SQLException, IOException {
		// TODO Auto-generated method stub
	boolean	entered=false; 
		ResultSet myresults=st3.executeQuery("select methodcalls.* from methodcalls where "
				+ "methodcalls.fullcaller='"+mycaller1+"' and methodcalls.fullcallee='"+mycallee1+"'"); 
		System.out.println(mycaller1+"   "+mycallee1);

		if(myresults.next()) {
			bwGold.write(equivalenceType+"/"+myresults.getString("id")+"/"+myresults.getString("callermethodid")+"/"+myresults.getString("callername")
			+"/"+myresults.getString("callerclass")+"/"+myresults.getString("calleemethodid")+"/"+myresults.getString("calleename")
			+"/"+myresults.getString("calleeclass"));
			bwGold.newLine(); 
			
		
	
			st3.executeUpdate("delete methodcallsinexecnotparsed.* from methodcallsinexecnotparsed where "
					+ "methodcallsinexecnotparsed.fullcaller='"+mycaller1+"' and methodcallsinexecnotparsed.fullcallee='"+mycallee1+"'"); 
			entered=true; 
		}
		return entered;
	}

	private static boolean WriteInDocBothCallerCallee(String fullcaller, String mycallee, String mycallee1,
			String mycaller1, String equivalenceType, Statement st3) throws SQLException, IOException {
		boolean entered=false; 
		ResultSet myresults=st3.executeQuery("select methodcallsexecuted.* from methodcallsexecuted where "
				+ "methodcallsexecuted.fullcaller='"+mycaller1+"' and methodcallsexecuted.fullcallee='"+mycallee1+"'"); 
		System.out.println(mycaller1+"   "+mycallee1);
		if(myresults.next()) {
			bwGold.write(equivalenceType+"/"+myresults.getString("id")+"/"+myresults.getString("callermethodid")+"/"+myresults.getString("callername")
			+"/"+myresults.getString("callerclass")+"/"+myresults.getString("calleemethodid")+"/"+myresults.getString("calleename")
			+"/"+myresults.getString("calleeclass"));
			bwGold.newLine(); 
		
		st3.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
				+ "methodcallsinparsednotexec.fullcaller='"+mycaller1+"' and methodcallsinparsednotexec.fullcallee='"+mycallee1+"'"); 
		entered=true; 
		}
		return entered; 
		
	
	}

	private static boolean WriteInDocExecNotMapped(String fullcaller, String fullcallee, String equivalenceType,
			Statement st3) throws SQLException, IOException {
		// TODO Auto-generated method stub
		boolean entered=false; 
		ResultSet myresults=st3.executeQuery("select methodcallsinexecnotparsed.* from methodcallsinexecnotparsed where "
				+ "methodcallsinexecnotparsed.fullcaller='"+fullcaller+"' and methodcallsinexecnotparsed.fullcallee='"+fullcallee+"'"); 
		if(myresults.next()) {
			bwGold.write(equivalenceType+"/"+myresults.getString("id")+"/"+myresults.getString("callermethodid")+"/"+myresults.getString("callername")
			+"/"+myresults.getString("callerclass")+"/"+myresults.getString("calleemethodid")+"/"+myresults.getString("calleename")
			+"/"+myresults.getString("calleeclass"));
			bwGold.newLine(); 
		
		st3.executeUpdate("delete methodcallsinexecnotparsed.* from methodcallsinexecnotparsed where "
				+ "methodcallsinexecnotparsed.fullcaller='"+fullcaller+"' and methodcallsinexecnotparsed.fullcallee='"+fullcallee+"'"); 
		entered=true; 
		}
		return entered; }

	private static boolean WriteInDocNotMapped(String fullcaller, String fullcallee, String equivalenceType,
			Statement st3) throws SQLException, IOException {
		// TODO Auto-generated method stub
		boolean entered=false; 
		ResultSet myresults=st3.executeQuery("select methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
				+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+fullcallee+"'"); 
		if(myresults.next()) {
			bwGold.write(equivalenceType+"/"+myresults.getString("id")+"/"+myresults.getString("callermethodid")+"/"+myresults.getString("callername")
			+"/"+myresults.getString("callerclass")+"/"+myresults.getString("calleemethodid")+"/"+myresults.getString("calleename")
			+"/"+myresults.getString("calleeclass"));
			bwGold.newLine(); 
		
		st3.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
				+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+fullcallee+"'"); 
		entered=true; 
		}
	return entered; 
	}

	private static boolean WriteInDoc(String fullcaller, String mycallee, String mycalleemapped, String equivalenceType, Statement st2) throws SQLException, IOException {
		// TODO Auto-generated method stub
		boolean entered=false; 
		ResultSet check= st2.executeQuery("select methodcallsexecuted.* from methodcallsexecuted where "
				+ "methodcallsexecuted.fullcaller='"+fullcaller+"' and methodcallsexecuted.fullcallee='"+mycalleemapped+"'"); 
		if(check.next()==true) {
			ResultSet myresults=st2.executeQuery("select methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
					+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycallee+"'"); 
			if(myresults.next()) {
				bwGold.write(equivalenceType+"/"+myresults.getString("id")+"/"+myresults.getString("callermethodid")+"/"+myresults.getString("callername")
				+"/"+myresults.getString("callerclass")+"/"+myresults.getString("calleemethodid")+"/"+myresults.getString("calleename")
				+"/"+myresults.getString("calleeclass"));
				bwGold.newLine(); 
			}
			st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
					+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycallee+"'"); 
		entered=true; 
		}
		return entered; 
		}
		
		
		
	
	
	
	
	
	private static boolean WriteInDoc2(String fullcallee, String mycaller, String mycallermapped, String equivalenceType, Statement st2) throws SQLException, IOException {
		// TODO Auto-generated method stub
		boolean entered=false; 
		ResultSet check= st2.executeQuery("select methodcallsexecuted.* from methodcallsexecuted where "
				+ "methodcallsexecuted.fullcaller='"+mycallermapped+"' and methodcallsexecuted.fullcallee='"+fullcallee+"'"); 
		if(check.next()==true) {
		ResultSet myresults=st2.executeQuery("select methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
				+ "methodcallsinparsednotexec.fullcaller='"+mycaller+"' and methodcallsinparsednotexec.fullcallee='"+fullcallee+"'"); 
		if(myresults.next()) {
			bwGold.write(equivalenceType+"/"+myresults.getString("id")+"/"+myresults.getString("callermethodid")+"/"+myresults.getString("callername")
			+"/"+myresults.getString("callerclass")+"/"+myresults.getString("calleemethodid")+"/"+myresults.getString("calleename")
			+"/"+myresults.getString("calleeclass"));
			bwGold.newLine(); 
		}
		
		st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
				+ "methodcallsinparsednotexec.fullcaller='"+mycaller+"' and methodcallsinparsednotexec.fullcallee='"+fullcallee+"'"); 	
		entered=true; 
		}
	return entered; 
	}

	
	private static boolean  WriteInDocExec(String fullcaller, String mycallee, String mycalleemapped, String equivalenceType, Statement st2) throws SQLException, IOException {
		// TODO Auto-generated method stub
		boolean entered=false; 
		ResultSet check= st2.executeQuery("select methodcalls.* from methodcalls where "
				+ "methodcalls.fullcaller='"+fullcaller+"' and methodcalls.fullcallee='"+mycalleemapped+"'"); 
		if(check.next()==true) {
		ResultSet myresults=st2.executeQuery("select methodcallsinexecnotparsed.* from methodcallsinexecnotparsed where "
				+ "methodcallsinexecnotparsed.fullcaller='"+fullcaller+"' and methodcallsinexecnotparsed.fullcallee='"+mycallee+"'"); 
		if(myresults.next()) {
			bwGold.write(equivalenceType+"/"+myresults.getString("id")+"/"+myresults.getString("callermethodid")+"/"+myresults.getString("callername")
			+"/"+myresults.getString("callerclass")+"/"+myresults.getString("calleemethodid")+"/"+myresults.getString("calleename")
			+"/"+myresults.getString("calleeclass"));
			bwGold.newLine(); 
		}
		st2.executeUpdate("delete methodcallsinexecnotparsed.* from methodcallsinexecnotparsed where "
				+ "methodcallsinexecnotparsed.fullcaller='"+fullcaller+"' and methodcallsinexecnotparsed.fullcallee='"+mycallee+"'"); 
	
		entered=true; 
		}
		return entered; 
		}
	
	
	private static boolean WriteInDocExec2(String fullcallee, String mycaller, String mycallermapped, String equivalenceType, Statement st2) throws SQLException, IOException {
		// TODO Auto-generated method stub
	boolean entered=false; 
		ResultSet check= st2.executeQuery("select methodcalls.* from methodcalls where "
				+ "methodcalls.fullcaller='"+mycallermapped+"' and methodcalls.fullcallee='"+fullcallee+"'"); 
		if(check.next()==true) {
		ResultSet myresults=st2.executeQuery("select methodcallsinexecnotparsed.* from methodcallsinexecnotparsed where "
				+ "methodcallsinexecnotparsed.fullcaller='"+mycaller+"' and methodcallsinexecnotparsed.fullcallee='"+fullcallee+"'"); 
		if(myresults.next()) {
			bwGold.write(equivalenceType+"/"+myresults.getString("id")+"/"+myresults.getString("callermethodid")+"/"+myresults.getString("callername")
			+"/"+myresults.getString("callerclass")+"/"+myresults.getString("calleemethodid")+"/"+myresults.getString("calleename")
			+"/"+myresults.getString("calleeclass"));
			bwGold.newLine(); 
		}
		
		st2.executeUpdate("delete methodcallsinexecnotparsed.* from methodcallsinexecnotparsed where "
				+ "methodcallsinexecnotparsed.fullcaller='"+mycaller+"' and methodcallsinexecnotparsed.fullcallee='"+fullcallee+"'"); 	
		
	entered=true; 
		}
		
		return entered; 
	}
}
