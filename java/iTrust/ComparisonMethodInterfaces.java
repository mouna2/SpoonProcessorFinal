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

public class ComparisonMethodInterfaces {
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
	public ComparisonMethodInterfaces(List<tracesmethodscallees> tracesCalleesList) {
		 TracesCalleesList= new ArrayList<tracesmethodscallees>();

	}

	public ComparisonMethodInterfaces() {
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
		PrintStream fileOut = new PrintStream("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logs\\consoleITRUST.txt");

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
			ResultSet res2=st.executeQuery("SELECT *" + 
					"			FROM databaseitrust.interfaces" ); 
			while(res2.next()) {
				
				interfaceclassid=res2.getString("interfaceclassid"); 
				interfacename=res2.getString("interfacename"); 
				implementationclassid=res2.getString("ownerclassid"); 
				implementationclassname=res2.getString("classname"); 
				
				ClassRepresentation2 implclass= new ClassRepresentation2(implementationclassid, implementationclassname); 
				ClassRepresentation2 interfaceclass= new ClassRepresentation2(interfaceclassid, interfacename); 
				Interface2 myinter= new Interface2(); 
				myinter.setInterfaceClass(interfaceclass);
				myinter.setOwnerClass(implclass);
//				System.out.println("INTERFACE CLASS ID    "+ interfaceclassid);
				if(InterfacesImplementationsHashMap.get(interfaceclassid+"-"+interfacename)!=null) {
					implementationList= InterfacesImplementationsHashMap.get(interfaceclassid+"-"+interfacename); 
					implementationList.add(myinter); 
					InterfacesImplementationsHashMap.put(interfaceclassid+"-"+interfacename, implementationList); 
				}else {
					implementationList = new ArrayList<Interface2>(); 
					implementationList.add(myinter); 
					InterfacesImplementationsHashMap.put(interfaceclassid+"-"+interfacename, implementationList); 
				}
				System.out.println(myinter);
				System.out.println(implementationList);
				//implementationList.add(myinter); 
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			ResultSet res3=st.executeQuery("SELECT *" + 
					"			FROM databaseitrust.superclasses" ); 
			while(res3.next()) {
				
				superclassid=res3.getString("superclassid"); 
				superclassname=res3.getString("superclassname"); 
				childclassid=res3.getString("ownerclassid"); 
				childclassname=res3.getString("childclassname"); 
				
				ClassRepresentation2 superclass= new ClassRepresentation2(superclassid, superclassname); 
				ClassRepresentation2 childclass= new ClassRepresentation2(childclassid, childclassname); 
				SuperClass2 mysuperclass= new SuperClass2(); 
				mysuperclass.setSuperClass(superclass);
				mysuperclass.setOwnerClass(childclass);
//				System.out.println("INTERFACE CLASS ID    "+ interfaceclassid);
				if(SuperclassesChildrenHashMap.get(superclassid+"-"+superclassname)!=null) {
					superclassList= SuperclassesChildrenHashMap.get(superclassid+"-"+superclassname); 
				}else {
					superclassList = new ArrayList<SuperClass2>(); 
				}
				superclassList.add(mysuperclass); 
				SuperclassesChildrenHashMap.put(superclassid+"-"+superclassname, superclassList); 
			}
			
			
			
			
			
			
			
			
			
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
				Method2Representation methodrep = new Method2Representation(methodid, methodname); 
				ClassRepresentation2 classrep = new ClassRepresentation2(classid, classname); 
				methodtrace.setID(rowID);
				methodtrace.setRequirement(req);
				methodtrace.setMethodRepresentation(methodrep);
				methodtrace.setClassRepresentation(classrep);
				methodtrace.setGold2(gold2);
			
				for(String mykey: InterfacesImplementationsHashMap.keySet()) {

					String mykey2=mykey.substring(0, mykey.indexOf("-")); 
				
					if(classid.equals(mykey2)) {
						System.out.println("=================THIS IS AN INTERFACE");
					}
					
					for(Interface2 impl: InterfacesImplementationsHashMap.get(mykey)) {
						

						if(impl.getOwnerClass().getClassid().equals(classid)) {
							if(InterfacesImplementationsHashMap.get(mykey)!=null) {
							System.out.println(counter);
									List<MethodTrace2> 	mymethodtraces= new ArrayList<MethodTrace2>(); 
									methodtrace.setCLASSTYPE("INTERFACE");
									mymethodtraces=ImplementationsTracesHashMap.get(mykey); 
									if(mymethodtraces!=null) {
										mymethodtraces.add(methodtrace); 
									}
									else {
										mymethodtraces= new ArrayList<MethodTrace2>(); 
										mymethodtraces.add(methodtrace); 
									}
									ImplementationsTracesHashMap.put(mykey, mymethodtraces); 
								
								

							}
							
						}
						
					}
				}
				
				
				
				
				
				
				////////////////////////////////////////////
				//SUPERCLASSES
				/////////////////////////////////////////
				
				
				
				
				
//				for(String mykey: SuperclassesChildrenHashMap.keySet()) {
//					String mykey2=mykey.substring(0, mykey.indexOf("-")); 
//				
//					if(classid.equals(mykey2)) {
//						System.out.println("=================THIS IS A SUPERCLASS");
//					}
//					
//					for(SuperClass2 superclass: SuperclassesChildrenHashMap.get(mykey)) {
//						
//						if(superclass.getOwnerClass().getClassid().equals(classid)) {
//							if(SuperclassesChildrenHashMap.get(mykey)!=null) {
//								
//								if(ImplementationsTracesHashMap.get(mykey)!=null) {
//									mymethodtraces=ImplementationsTracesHashMap.get(mykey); 
//									methodtrace.setCLASSTYPE("SUPERCLASS");
//
//									mymethodtraces.add(methodtrace); 
//								}else {
//									mymethodtraces=new ArrayList<MethodTrace2>(); 
//									methodtrace.setCLASSTYPE("SUPERCLASS");
//
//									mymethodtraces.add(methodtrace); 
//								}
//								ImplementationsTracesHashMap.put(mykey, mymethodtraces); 
//
//							}
//							if(!mymethodtraces.isEmpty()) {
//
//							}
//						}
//					}
//					
//				}
				
				
				
				counter++; 

			}
			
			LinkedHashMap <String, List<String>>	ImplementationsTracesHashMapFinal= new  LinkedHashMap <String, List<String>>(); 
			 counter=0; 
			for (Entry<String, List<MethodTrace2>> entry : ImplementationsTracesHashMap.entrySet()) {
				 List<MethodTrace2> values = entry.getValue();
					List<String> list = new ArrayList<String>();

				for(MethodTrace2 value: values) {
				String	gold2val=value.getGold2(); 
				String	req=value.getRequirement().ID; 
				String	method=value.getMethodRepresentation().methodname; 
				String	methodID=value.getMethodRepresentation().methodid; 
				String	classIDTrace=value.getClassRepresentation().classid; 
				String	classnameTrace=value.getClassRepresentation().classname; 
				String	myinterfaceID=entry.getKey().substring(0, entry.getKey().indexOf("-")); 
				String	myinterfacename=entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
				System.out.println(counter);
				
					
				
					
						if(ImplementationsTracesHashMapFinal.get(req+"/"+method+"/"+myinterfaceID+"/"+myinterfacename)!=null) {
							
							list=ImplementationsTracesHashMapFinal.get(req+"/"+method+"/"+myinterfaceID+"/"+myinterfacename); 
							list.add(value.gold2+"("+classnameTrace+"/"+classIDTrace+") "); 
							ImplementationsTracesHashMapFinal.put(req+"/"+method+"/"+myinterfaceID+"/"+myinterfacename, list); 
						}else {
							list = new ArrayList<String>();
							list.add(value.gold2+"("+classnameTrace+"/"+classIDTrace+") "); 
							ImplementationsTracesHashMapFinal.put(req+"/"+method+"/"+myinterfaceID+"/"+myinterfacename, list); 
						}
					
				
	
			
					
				counter++; 
				}
				
				
				
			}
			System.setOut(fileOut);
			  System.out.println("RequirementID, MethodName, InterfaceID, InterfaceName, Values");

			for (Entry<String, List<String>> entry : ImplementationsTracesHashMapFinal.entrySet()) {
			    String key = entry.getKey();
			    List<String> values = entry.getValue();
			    // now work with key and value...
			    String[] keys = key.split("/"); 
				 String RequirementID= keys[0]; 
				 String MethodName= keys[1]; 
				 String myclassid= keys[2]; 
				 String myclassname= keys[3]; 
				 System.out.print(RequirementID+","+MethodName+","+myclassid+","+myclassname+" "); 
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
		ComparisonMethodInterfaces app = new ComparisonMethodInterfaces();
		app.run();
		Spoon(); 
		
	}
	
	

	public static void Spoon() throws SQLException, IOException {
		
		
		
		
		
		
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
