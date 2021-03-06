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

import Chess.CountTNE;

import java.util.Properties;
import java.util.Set;

import Tables.tracesmethodscallees;
import mypackage.Clazz;
import mypackage.Interface;
import mypackage.Method;
import mypackage.MethodTrace2;
import mypackage.Requirement;
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
	public static LinkedHashMap <String, List<Interface>> InterfacesImplementationsHashMap = new LinkedHashMap <String, List<Interface>>(); 
	public static LinkedHashMap <String, String> InterfacesTracesHashMap = new LinkedHashMap <String, String>(); 

	public static LinkedHashMap <String, List<MethodTrace2>> SuperclassesChildrenTracesHashMap = new LinkedHashMap <String, List<MethodTrace2>>(); 
	public static LinkedHashMap <String, String> SuperclassesTracesHashMap = new LinkedHashMap <String, String>(); 
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
	 * @throws IOException 
	 */
	public void run() throws IOException {
		ResultSet rs = null; 
		File fout1 = new File("C:\\Users\\mouna\\dumps\\logs\\ComparisonInterfacesImpITRUST.txt");
		FileOutputStream fos1 = new FileOutputStream(fout1);
		BufferedWriter bwfile1 = new BufferedWriter(new OutputStreamWriter(fos1));

		
		File fout3 = new File("C:\\Users\\mouna\\dumps\\logs\\ComparisonSuperclassesChildrenITRUST.txt");
		FileOutputStream fos3 = new FileOutputStream(fout3);
		BufferedWriter bwfile3 = new BufferedWriter(new OutputStreamWriter(fos3));
		
		File fout5 = new File("C:\\Users\\mouna\\dumps\\logs\\ComparisonInterfacesImpITRUST_COUNTS.txt");
		FileOutputStream fos5 = new FileOutputStream(fout5);
		BufferedWriter bwfile5 = new BufferedWriter(new OutputStreamWriter(fos5));
		
		File fout4 = new File("C:\\Users\\mouna\\dumps\\logs\\ComparisonSuperclassesChildrenITRUST_COUNTS.txt");
		FileOutputStream fos4 = new FileOutputStream(fout4);
		BufferedWriter bwfile4 = new BufferedWriter(new OutputStreamWriter(fos4));
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
			List<Interface> implementationList = new ArrayList<Interface>(); 
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
				
				Clazz implclass= new Clazz(implementationclassid, implementationclassname); 
				Clazz interfaceclass= new Clazz(interfaceclassid, interfacename); 
				Interface myinter= new Interface(); 
				myinter.setInterfaceClass(interfaceclass);
				myinter.setImplementation(implclass);
//				System.out.println("INTERFACE CLASS ID    "+ interfaceclassid);
				if(InterfacesImplementationsHashMap.get(interfaceclassid+"-"+interfacename)!=null) {
					implementationList= InterfacesImplementationsHashMap.get(interfaceclassid+"-"+interfacename); 
					implementationList.add(myinter); 
					InterfacesImplementationsHashMap.put(interfaceclassid+"-"+interfacename, implementationList); 
				}else {
					implementationList = new ArrayList<Interface>(); 
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
				
				Clazz superclass= new Clazz(superclassid, superclassname); 
				Clazz childclass= new Clazz(childclassid, childclassname); 
				SuperClass2 mysuperclass= new SuperClass2(); 
				mysuperclass.setSuperClass(superclass);
				mysuperclass.setChildClass(childclass);
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
				Requirement req= new Requirement(requirementid, requirement); 
				Method methodrep = new Method(methodid, methodname); 
				Clazz classrep = new Clazz(classid, classname); 
				methodtrace.setID(rowID);
				methodtrace.setRequirement(req);
				methodtrace.setMethodRepresentation(methodrep);
				methodtrace.setClassRepresentation(classrep);
				methodtrace.setGold2(gold2);
			
				for(String mykey: InterfacesImplementationsHashMap.keySet()) {

					String mykey2=mykey.substring(0, mykey.indexOf("-")); 
				
					if(classid.equals(mykey2)) {
						System.out.println("=================THIS IS AN INTERFACE");
						InterfacesTracesHashMap.put(requirementid+"/"+methodname+"/"+classid+"/"+classname, gold2); 
					}
					
					for(Interface impl: InterfacesImplementationsHashMap.get(mykey)) {
						

						if(impl.getImplementation().getClassid().equals(classid)) {
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
				
				
////////////////////////////////////////////
//SUPERCLASSES
/////////////////////////////////////////


for(String mykey: SuperclassesChildrenHashMap.keySet()) {

String mykey2=mykey.substring(0, mykey.indexOf("-")); 

if(classid.equals(mykey2)) {
System.out.println("=================THIS IS A SUPERCLASS");
SuperclassesTracesHashMap.put(requirementid+"/"+methodname+"/"+classid+"/"+classname, gold2); 
}

for(SuperClass2 impl: SuperclassesChildrenHashMap.get(mykey)) {


if(impl.getChildClass().getClassid().equals(classid)) {
	if(SuperclassesChildrenHashMap.get(mykey)!=null) {
	System.out.println(counter);
			List<MethodTrace2> 	mysuperclasses= new ArrayList<MethodTrace2>(); 
			
			mysuperclasses=SuperclassesChildrenTracesHashMap.get(mykey); 
			if(mysuperclasses!=null) {
				mysuperclasses.add(methodtrace); 
			}
			else {
				mysuperclasses= new ArrayList<MethodTrace2>(); 
				mysuperclasses.add(methodtrace); 
			}
			SuperclassesChildrenTracesHashMap.put(mykey, mysuperclasses); 
		
		

	}
	
}

}
}
				
				
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
				String	gold2val=value.getGoldfinal(); 
				String	req=value.getRequirement().ID; 
				String	method=value.getMethodRepresentation().methodname; 
				String	methodID=value.getMethodRepresentation().ID; 
				String	classIDTrace=value.getClassRepresentation().ID; 
				String	classnameTrace=value.getClassRepresentation().classname; 
				String	myinterfaceID=entry.getKey().substring(0, entry.getKey().indexOf("-")); 
				String	myinterfacename=entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
				System.out.println(counter);
				
					
				
					
						if(ImplementationsTracesHashMapFinal.get(req+"/"+method+"/"+myinterfaceID+"/"+myinterfacename)!=null) {
							
							list=ImplementationsTracesHashMapFinal.get(req+"/"+method+"/"+myinterfaceID+"/"+myinterfacename); 
//							list.add(value.goldfinal+"("+classnameTrace+"/"+classIDTrace+") "); 
							list.add(value.goldfinal); 
							ImplementationsTracesHashMapFinal.put(req+"/"+method+"/"+myinterfaceID+"/"+myinterfacename, list); 
						}else {
							list = new ArrayList<String>();
//							list.add(value.goldfinal+"("+classnameTrace+"/"+classIDTrace+") "); 
							list.add(value.goldfinal); 
							ImplementationsTracesHashMapFinal.put(req+"/"+method+"/"+myinterfaceID+"/"+myinterfacename, list); 
						}
					
				
	
			
					
				counter++; 
				}
				
				
				
			}
			
			
			LinkedHashMap <String, List<String>>	SuperclassesTracesHashMapFinal= new  LinkedHashMap <String, List<String>>(); 
			 counter=0; 
			for (Entry<String, List<MethodTrace2>> entry : SuperclassesChildrenTracesHashMap.entrySet()) {
				 List<MethodTrace2> values = entry.getValue();
					List<String> list = new ArrayList<String>();

				for(MethodTrace2 value: values) {
				String	gold2val=value.getGoldfinal(); 
				String	req=value.getRequirement().ID; 
				String	method=value.getMethodRepresentation().methodname; 
				String	methodID=value.getMethodRepresentation().ID; 
				String	classIDTrace=value.getClassRepresentation().ID; 
				String	classnameTrace=value.getClassRepresentation().classname; 
				String	myinterfaceID=entry.getKey().substring(0, entry.getKey().indexOf("-")); 
				String	myinterfacename=entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
				System.out.println(counter);
				
					
				
					
						if(SuperclassesTracesHashMapFinal.get(req+"/"+method+"/"+myinterfaceID+"/"+myinterfacename)!=null) {
							
							list=SuperclassesTracesHashMapFinal.get(req+"/"+method+"/"+myinterfaceID+"/"+myinterfacename); 
//							list.add(value.goldfinal+"("+classnameTrace+"/"+classIDTrace+") "); 
							list.add(value.goldfinal); 
							SuperclassesTracesHashMapFinal.put(req+"/"+method+"/"+myinterfaceID+"/"+myinterfacename, list); 
						}else {
							list = new ArrayList<String>();
//							list.add(value.goldfinal+"("+classnameTrace+"/"+classIDTrace+") "); 
							list.add(value.goldfinal); 
							SuperclassesTracesHashMapFinal.put(req+"/"+method+"/"+myinterfaceID+"/"+myinterfacename, list); 
						}
					
				
	
			
					
				counter++; 
				}
				
				
				
			}
			
			
			
//			System.setOut(fileOut);
			  System.out.println("RequirementID, MethodName, InterfaceID, InterfaceName, Values");
			  bwfile5.write("RequirementID, MethodName, InterfaceID, InterfaceName, COUNTTNE INTERFACE, COUNTTNE IMPLEMENTATION");
			  bwfile1.write("RequirementID, MethodName, InterfaceID, InterfaceName, Values");
			  bwfile5.newLine(); 
			  bwfile1.newLine(); 
			  CountTNE countInterface= new CountTNE(); 

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
				 bwfile1.write(RequirementID+","+MethodName+","+myclassid+","+myclassname+" ");
				 countInterface= new CountTNE(); 
				 if(InterfacesTracesHashMap.get(RequirementID+"/"+MethodName+"/"+myclassid+"/"+myclassname)!=null) {
					 System.out.print("------ "+InterfacesTracesHashMap.get(RequirementID+"/"+MethodName+"/"+myclassid+"/"+myclassname)+"------ ");
					 bwfile1.write("------ "+InterfacesTracesHashMap.get(RequirementID+"/"+MethodName+"/"+myclassid+"/"+myclassname)+"------ ");
					 String TraceVal=InterfacesTracesHashMap.get(RequirementID+"/"+MethodName+"/"+myclassid+"/"+myclassname); 
					 if(TraceVal.trim().equals("T")) {
						 countInterface.CountT++; 
						
					 }else if(TraceVal.trim().equals("N")) {
						 countInterface.CountN++; 
						
					 }else if(TraceVal.trim().equals("E")) {
						 countInterface.CountE++; 
						
					 }
					
					 
				 }
				
				 CountTNE countImp= new CountTNE(); 
				for(String value: values) {
					 for(String val: values) {
						 if(val.trim().equals("T")) {
							 countImp.CountT++; 
						 }else  if(val.trim().equals("N")) {
							 countImp.CountN++; 
						 }
						 else  if(val.trim().equals("E")) {
							 countImp.CountE++; 
						 }
					 }

					
					 System.out.print("*************** ");
					 bwfile1.write("*************** ");
			        System.out.print(value+" ");
			        bwfile1.write(value+" ");
			    }
				
				 System.out.println(); 
				
				 bwfile1.newLine();
				
				
				 bwfile5.write(RequirementID+","+MethodName+ ", "+ myclassid+" , "+myclassname+",  ");
				 if(countInterface.CountT>0|| countInterface.CountN>0|| countInterface.CountE>0) {
					 bwfile5.write("COUNT INTERFACE "+countInterface.toString()+"  ,");
				 }
				
				 bwfile5.write("COUNT IMPLEMENTATION "+countImp.toString()+"  ");
				 
				 if(countImp.CountT>0 && countImp.CountN>0 && countImp.CountE==0) {
//					 System.out.println("T MIXED WITH N CountSuperclass "+countSuperclassVal);
					 bwfile5.write("T MIXED WITH N  ");
				 }if(countImp.CountT==1 && countImp.CountE==0 && countImp.CountN==0 ) {
//					 System.out.println("ALL T CountSuperclass "+countSuperclassVal);
					 bwfile5.write("ONLY 1 IMPLEMENTATION T  ");
				 } if(countImp.CountN==1 && countImp.CountT==0 && countImp.CountE==0 ) {
//					 System.out.println("ALL N CountSuperclass "+countSuperclassVal);
					 bwfile5.write("ONLY 1 IMPLEMENTATION  N  "); 
				 } if(countImp.CountE==1 && countImp.CountT==0 && countImp.CountN==0 ) {
//					 System.out.println("ALL E CountSuperclass "+countSuperclassVal);
					 bwfile5.write("ONLY 1 IMPLEMENTATION  E  "); 
				 }  
				 
				 if(countImp.CountT>1 && countImp.CountE==0 && countImp.CountN==0 ) {
//					 System.out.println("ALL T CountSuperclass "+countSuperclassVal);
					 bwfile5.write("ALL T  ");
				 } if(countImp.CountN>1 && countImp.CountT==0 && countImp.CountE==0 ) {
//					 System.out.println("ALL N CountSuperclass "+countSuperclassVal);
					 bwfile5.write("ALL N  "); 
				 } if(countImp.CountE>1 && countImp.CountT==0 && countImp.CountN==0 ) {
//					 System.out.println("ALL E CountSuperclass "+countSuperclassVal);
					 bwfile5.write("ALL E  "); 
				 } if(countImp.CountN>0 && countImp.CountE>0 && countImp.CountT==0) {
//					 System.out.println("N MIXED WITH E CountSuperclass "+countSuperclassVal);
					 bwfile5.write("N MIXED WITH E  "); 
				 }
				  if(countImp.CountT>0 && countImp.CountE>0 && countImp.CountN==0) {
//					 System.out.println("T MIXED WITH E CountSuperclass "+countSuperclassVal);
					  bwfile5.write("T MIXED WITH E  "); 
				 }
				  if(countImp.CountT>0 && countImp.CountE>0 && countImp.CountN>0) {
//					 System.out.println("T MIXED WITH N AND E CountSuperclass "+countSuperclassVal);
					  bwfile5.write("T MIXED WITH N AND E  "); 
				 }
				
				  bwfile5.newLine();
				
				
		    
			}
			
			
			
			
			
	
			 bwfile5.close(); 
			 bwfile1.close(); 
			 
			 bwfile3.write("RequirementID, MethodName, SuperclassID, SuperclassName, Values");
			 bwfile3.newLine(); 
			 CountTNE countSuperclass= new CountTNE(); 
			for (Entry<String, List<String>> entry : SuperclassesTracesHashMapFinal.entrySet()) {
			    String key = entry.getKey();
			    List<String> values = entry.getValue();
			    // now work with key and value...
			    String[] keys = key.split("/"); 
				 String RequirementID= keys[0]; 
				 String MethodName= keys[1]; 
				 String myclassid= keys[2]; 
				 String myclassname= keys[3]; 
				 bwfile3.write(RequirementID+","+MethodName+","+myclassid+","+myclassname+" "); 
				 countSuperclass= new CountTNE(); 
				 if(SuperclassesTracesHashMap.get(RequirementID+"/"+MethodName+"/"+myclassid+"/"+myclassname)!=null) {
					 bwfile3.write("------ "+SuperclassesTracesHashMap.get(RequirementID+"/"+MethodName+"/"+myclassid+"/"+myclassname)+"------ ");
					 String TraceVal=SuperclassesTracesHashMap.get(RequirementID+"/"+MethodName+"/"+myclassid+"/"+myclassname); 
					 if(TraceVal.trim().equals("T")) {
						 countSuperclass.CountT++; 
						
					 }else if(TraceVal.trim().equals("N")) {
						 countSuperclass.CountN++; 
						
					 }else if(TraceVal.trim().equals("E")) {
						 countSuperclass.CountE++; 
						
					 }
					
				 }
				 CountTNE countImp= new CountTNE(); 
				for(String value: values) {
					 

					if(values.size()>1) {
						 System.out.print("*************** ");
						 bwfile3.write("*************** "); 
					}

			        System.out.print(value+" ");
			        bwfile3.write(value+" "); 
			    }
				 System.out.println(); 
				 bwfile3.newLine(); 
				
				 for(String val: values) {
					 if(val.trim().equals("T")) {
						 countImp.CountT++; 
					 }else  if(val.trim().equals("N")) {
						 countImp.CountN++; 
					 }
					 else  if(val.trim().equals("E")) {
						 countImp.CountE++; 
					 }
				 }
				 bwfile4.write(RequirementID+","+MethodName+ ", "+ myclassid+" , "+myclassname+",  ");
				 if(countInterface.CountT>0|| countInterface.CountN>0|| countInterface.CountE>0) {
					 bwfile4.write("COUNT INTERFACE "+countInterface.toString()+"  ,");
				 }
				
				 bwfile4.write("COUNT IMPLEMENTATION "+countImp.toString()+"  ");
				 
				 if(countImp.CountT>0 && countImp.CountN>0 && countImp.CountE==0) {
//					 System.out.println("T MIXED WITH N CountSuperclass "+countSuperclassVal);
					 bwfile4.write("T MIXED WITH N  ");
				 }if(countImp.CountT==1 && countImp.CountE==0 && countImp.CountN==0 ) {
//					 System.out.println("ALL T CountSuperclass "+countSuperclassVal);
					 bwfile4.write("ONLY 1 IMPLEMENTATION T  ");
				 } if(countImp.CountN==1 && countImp.CountT==0 && countImp.CountE==0 ) {
//					 System.out.println("ALL N CountSuperclass "+countSuperclassVal);
					 bwfile4.write("ONLY 1 IMPLEMENTATION  N  "); 
				 } if(countImp.CountE==1 && countImp.CountT==0 && countImp.CountN==0 ) {
//					 System.out.println("ALL E CountSuperclass "+countSuperclassVal);
					 bwfile4.write("ONLY 1 IMPLEMENTATION  E  "); 
				 }  
				 
				 if(countImp.CountT>1 && countImp.CountE==0 && countImp.CountN==0 ) {
//					 System.out.println("ALL T CountSuperclass "+countSuperclassVal);
					 bwfile4.write("ALL T  ");
				 } if(countImp.CountN>1 && countImp.CountT==0 && countImp.CountE==0 ) {
//					 System.out.println("ALL N CountSuperclass "+countSuperclassVal);
					 bwfile4.write("ALL N  "); 
				 } if(countImp.CountE>1 && countImp.CountT==0 && countImp.CountN==0 ) {
//					 System.out.println("ALL E CountSuperclass "+countSuperclassVal);
					 bwfile4.write("ALL E  "); 
				 } if(countImp.CountN>0 && countImp.CountE>0 && countImp.CountT==0) {
//					 System.out.println("N MIXED WITH E CountSuperclass "+countSuperclassVal);
					 bwfile4.write("N MIXED WITH E  "); 
				 }
				  if(countImp.CountT>0 && countImp.CountE>0 && countImp.CountN==0) {
//					 System.out.println("T MIXED WITH E CountSuperclass "+countSuperclassVal);
					  bwfile4.write("T MIXED WITH E  "); 
				 }
				  if(countImp.CountT>0 && countImp.CountE>0 && countImp.CountN>0) {
//					 System.out.println("T MIXED WITH N AND E CountSuperclass "+countSuperclassVal);
					  bwfile4.write("T MIXED WITH N AND E  "); 
				 }
				
				  bwfile4.newLine();
		    
			}
			
			
			
			System.out.println("finished");
			bwfile4.close(); 
			bwfile1.close(); 
			bwfile3.close(); 
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

	
}
