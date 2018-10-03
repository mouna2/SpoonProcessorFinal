package Chess;

import java.io.FileNotFoundException;
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
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "root";

	/** The name of the computer running MySQL */  
	
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "databasechess";
	
	/** The name of the table we are testing with */
	private final String tableName = "classes";
	public List<tracesmethodscallees> TracesCalleesList= new ArrayList<tracesmethodscallees>();
	public List<tracesmethodscallees> TracesCallersList= new ArrayList<tracesmethodscallees>();
	public HashMap <String, String> MethodInterfaces = new HashMap <String, String>(); 
	public HashMap <String, String> InterfacesMethods = new HashMap <String, String>(); 
	public HashMap <String, String> MethodSuperclasses = new HashMap <String, String>(); 
	public HashMap <String, String> SuperclassesMethods = new HashMap <String, String>(); 
	
	public HashMap <String, List<String>> methodcallsinexecnotparsedcallercallee = new HashMap <String, List<String>>(); 
	public HashMap <String, List<String>> methodcallsinexecnotparsedcalleecaller = new HashMap <String, List<String>>(); 
	public HashMap <String, List<String>> methodcallsinparsednotexecallercallee = new HashMap <String, List<String>>(); 
	public HashMap <String, List<String>> methodcallsinparsednotexecalleecaller = new HashMap <String, List<String>>(); 
	
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
	 */
	public void run() {
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
			st.executeUpdate("CREATE TABLE methodcallsInParsedNotExec"
					+  " SELECT methodcalls.*" + 
					" FROM databasechess.methodcalls" + 
					" LEFT OUTER JOIN databasechess.methodcallsexecuted" + 
					" ON methodcalls.calleemethodid = methodcallsexecuted.calleemethodid and methodcalls.callermethodid = methodcallsexecuted.callermethodid" + 
					" WHERE  methodcallsexecuted.callermethodid IS NULL and methodcallsexecuted.callermethodid IS NULL"); 

			
			
			st.executeUpdate("CREATE TABLE methodcallsInExecNotParsed"
					+" SELECT methodcallsexecuted.*\r\n" + 
					" FROM databasechess.methodcallsexecuted\r\n" + 
					" LEFT OUTER JOIN databasechess.methodcalls\r\n" + 
					" ON methodcalls.calleemethodid = methodcallsexecuted.calleemethodid and methodcalls.callermethodid = methodcallsexecuted.callermethodid\r\n" + 
					" WHERE  methodcalls.callermethodid IS NULL and methodcalls.callermethodid IS NULL"); 
			
			
			st.executeUpdate("CREATE TABLE IntersectionParsedExecuted"
					+" SELECT  databasechess.methodcallsexecuted.*\r\n" + 
					"   FROM databasechess.methodcalls\r\n" + 
					"   inner join databasechess.methodcallsexecuted \r\n" + 
					"   ON methodcalls.callermethodid=methodcallsexecuted.callermethodid and methodcalls.calleemethodid=methodcallsexecuted.calleemethodid"); 
//		   try {
//			Spoon();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		  
		   
		   
		
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		}
		
		
	}
	
	/**
	 * Connect to the DB and do some stuff
	 */
	public static void main(String[] args) {
		VerificationMethodCalls app = new VerificationMethodCalls();
		app.run();
	}
	
	public void Spoon() throws SQLException, FileNotFoundException {
		DBDemo3Chess dao = new DBDemo3Chess();
	Connection conn=getConnection();
	Statement st= conn.createStatement();
	
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
	    			if(fullcallee!=null)
	    				fullcallee=fullcallee.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
	    				if(fullcaller!=null)
	    				fullcaller=fullcaller.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
	    			List<String> list = methodcallsinparsednotexecallercallee.get(fullcaller); 
	    			List<String> list2 = methodcallsinparsednotexecalleecaller.get(fullcallee); 
	    			if(list!=null)
	    			for(String mycallee: list) {
	    				//System.out.println(mycallee);
	    				String mycallee1=MethodInterfaces.get(mycallee); 
	    				String mycallee2=InterfacesMethods.get(mycallee); 
	    				String mycallee3=SuperclassesMethods.get(mycallee); 
	    				String mycallee4=MethodSuperclasses.get(mycallee); 
	    				
	    				if(mycallee1!=null) {
	    					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
        							+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycallee+"'"); 	
	    				}
	    				
	    				if(mycallee2!=null) {
	    					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
        							+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycallee+"'");  	
	    				}
	    				
	    				if(mycallee3!=null) {
        					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
							+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycallee+"'"); 
	    				}
	    				
	    				if(mycallee4!=null) {
        					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
							+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycallee+"'"); 
	    				}
//	    		
//	    				if(fullcallee!=null && mycallee1!=null) {
//	    					if(mycallee1.equals(fullcallee) ) {
//	    					
//	        					System.out.println("yes1");
//	        					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
//	        							+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycallee1+"'"); 
//	        				}
//	    				}
//	    				
//	    				if(fullcallee!=null && mycallee2!=null) {
//	    					if( mycallee2.equals(fullcallee)) {
//	        					System.out.println("yes  "+mynewcounter);
//	        					
//	        					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
//	        							+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycallee2+"'"); 
//	        					
//	        					
//	        				}
//	    				}
//	    				
//	    				
//	    				
//	    				
//	    				
//	    				if(fullcallee!=null && mycallee3!=null) {
//	    					if(mycallee3.equals(fullcallee) ) {
//	        					System.out.println("superclass1");
//	        					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
//	        							+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycallee3+"'"); 
//	        				}
//	    				}
//	    				if(fullcallee!=null && mycallee4!=null) {
//	    					if( mycallee4.equals(fullcallee)) {
//	        					System.out.println("superclass2");
//	        					
//	        					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
//	        							+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycallee4+"'"); 
//	        					//mynewcounter++; 
//	        					
//	        				}
//	    				}
	    				
	    				
	    				
	    			}
	    			
	    			
	    			if(list2!=null)
	        			for(String mycaller: list2) {
	        				//System.out.println(mycallee);
	        				String mycaller1=MethodInterfaces.get(mycaller); 
	        				String mycaller2=InterfacesMethods.get(mycaller); 
	        				String mycaller3=SuperclassesMethods.get(mycaller); 
	        				String mycaller4=MethodSuperclasses.get(mycaller); 
	        			
	        				if(mycaller1!=null) {
		    					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
	        							+ "methodcallsinparsednotexec.fullcallee='"+fullcallee+"' and methodcallsinparsednotexec.fullcaller='"+mycaller+"'"); 	
		    				}
		    				
		    				if(mycaller2!=null) {
		    					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
	        							+ "methodcallsinparsednotexec.fullcallee='"+fullcallee+"' and methodcallsinparsednotexec.fullcaller='"+mycaller+"'");  	
		    				}
		    				
		    				if(mycaller3!=null) {
	        					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
								+ "methodcallsinparsednotexec.fullcallee='"+fullcallee+"' and methodcallsinparsednotexec.fullcaller='"+mycaller+"'"); 
		    				}
		    				
		    				if(mycaller4!=null) {
	        					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
								+ "methodcallsinparsednotexec.fullcallee='"+fullcallee+"' and methodcallsinparsednotexec.fullcaller='"+mycaller+"'"); 
		    				}
	        			
	        			}
	    			
	    			
//	    			if(list2!=null)
//	        			for(String mycaller: list2) {
//	        				//System.out.println(mycallee);
//	        				String mycaller1=MethodInterfaces.get(mycaller); 
//	        				String mycaller2=InterfacesMethods.get(mycaller); 
//	        				String mycaller3=SuperclassesMethods.get(mycaller); 
//	        				String mycaller4=MethodSuperclasses.get(mycaller); 
//	        				if(fullcallee!=null)
//	        				fullcallee=fullcallee.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
//	        				if(fullcaller!=null)
//	        				fullcaller=fullcaller.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
//	        				if(mycaller1!=null)
//	        				mycaller1=mycaller1.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
//	        				if(mycaller2!=null)
//	        				mycaller2=mycaller2.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
//	        				if(mycaller3!=null)
//	        				mycaller3=mycaller3.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
//	        				if(mycaller4!=null)
//	        				mycaller4=mycaller4.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
//	        				if(fullcaller!=null && mycaller1!=null) {
//	        					if(mycaller1.equals(fullcaller) ) {
//	            					System.out.println("yes2");
//	            					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
//	            							+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycaller1+"'"); 
//	            				}
//	        				}
//	        				
//	        				if(fullcaller!=null && mycaller2!=null) {
//	        					if( mycaller2.equals(fullcaller)) {
//	            					System.out.println("YESSS  "+mynewcounter);
//	            					mynewcounter++; 
//	            					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
//        							+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycaller2+"'"); 
//	            					
//	            				}
//	        				}
//	        				
//	        				
//	        				
//	        				
//	        				
//	        				
//	        				
//	        				if(fullcaller!=null && mycaller3!=null) {
//	        					if(mycaller3.equals(fullcaller) ) {
//	            					System.out.println("superclass1");
//	            					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
//        							+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycaller3+"'"); 
//	            				}
//	        				}
//	        				if(fullcaller!=null && mycaller4!=null) {
//	        					if( mycaller4.equals(fullcaller)) {
//	            					System.out.println("superclass2");
//	            					
//	            					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
//	            							+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycaller4+"'"); 
//	            					mynewcounter++; 
//	            					
//	            				}
//	        				}
//	        				
//	        				
//	        				
//	        				
//	        				
//	        				
//	        				
//	        				
//	        			}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    			mynewcounter++; 
	    	}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
    	
		
		
		
		
		
	    	
	    	
	    	
    	
		
		int counteryes=1; 
		 myresults4=st.executeQuery("select methodcallsinexecnotparsed.* from methodcallsinexecnotparsed "); 
    	while(myresults4.next()) {
    			String fullcaller =myresults4.getString("fullcaller"); 
    			String fullcallee =myresults4.getString("fullcallee"); 
    			
    			if(fullcallee!=null)
    				fullcallee=fullcallee.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
    				if(fullcaller!=null)
    				fullcaller=fullcaller.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
    			List<String> list = methodcallsinparsednotexecallercallee.get(fullcaller); 
    			List<String> list2 = methodcallsinparsednotexecalleecaller.get(fullcallee); 
    			if(list!=null)
    			for(String mycallee: list) {
    				//System.out.println(mycallee);
    				String mycallee1=MethodInterfaces.get(mycallee); 
    				String mycallee2=InterfacesMethods.get(mycallee); 
    				String mycallee3=SuperclassesMethods.get(mycallee); 
    				String mycallee4=MethodSuperclasses.get(mycallee); 
    				
    				
    		
    				if(mycallee1!=null) {
    					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
    							+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycallee+"'"); 	
    				}
    				
    				if(mycallee2!=null) {
    					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
    							+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycallee+"'");  	
    				}
    				
    				if(mycallee3!=null) {
    					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
						+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycallee+"'"); 
    				}
    				
    				if(mycallee4!=null) {
    					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
						+ "methodcallsinparsednotexec.fullcaller='"+fullcaller+"' and methodcallsinparsednotexec.fullcallee='"+mycallee+"'"); 
    				}
    				
    				
    				counteryes++; 
    			}
    			
    			
    			if(list2!=null)
        			for(String mycaller: list2) {
        				//System.out.println(mycallee);
        				String mycaller1=MethodInterfaces.get(mycaller); 
        				String mycaller2=InterfacesMethods.get(mycaller); 
        				String mycaller3=SuperclassesMethods.get(mycaller); 
        				String mycaller4=MethodSuperclasses.get(mycaller); 
        				if(fullcallee!=null)
        				fullcallee=fullcallee.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
        				if(fullcaller!=null)
        				fullcaller=fullcaller.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
        				if(mycaller1!=null)
        				mycaller1=mycaller1.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
        				if(mycaller2!=null)
        				mycaller2=mycaller2.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
        				if(mycaller3!=null)
        				mycaller3=mycaller3.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
        				if(mycaller4!=null)
        				
        					
        					
        					mycaller4=mycaller4.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
        				
        				
        				
        				if(mycaller1!=null) {
	    					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
        							+ "methodcallsinparsednotexec.fullcallee='"+fullcallee+"' and methodcallsinparsednotexec.fullcaller='"+mycaller+"'"); 	
	    				}
	    				
	    				if(mycaller2!=null) {
	    					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
        							+ "methodcallsinparsednotexec.fullcallee='"+fullcallee+"' and methodcallsinparsednotexec.fullcaller='"+mycaller+"'");  	
	    				}
	    				
	    				if(mycaller3!=null) {
        					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
							+ "methodcallsinparsednotexec.fullcallee='"+fullcallee+"' and methodcallsinparsednotexec.fullcaller='"+mycaller+"'"); 
	    				}
	    				
	    				if(mycaller4!=null) {
        					st2.executeUpdate("delete methodcallsinparsednotexec.* from methodcallsinparsednotexec where "
							+ "methodcallsinparsednotexec.fullcallee='"+fullcallee+"' and methodcallsinparsednotexec.fullcaller='"+mycaller+"'"); 
	    				}
        				
        				
        				
        				
        				
        				
        				
        				
        			}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	}
    	
		
		
		
		
		
}
}
