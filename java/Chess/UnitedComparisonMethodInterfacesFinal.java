package Chess;

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

public class UnitedComparisonMethodInterfacesFinal {
	 final static String userName = "root";

		/** The password for the MySQL account (or empty for anonymous) */
		  final static String password = "root";
	public UnitedComparisonMethodInterfacesFinal() {

	}

	

	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	static Connection getConnection(String ProgramName) throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		
		connectionProps.put("root", userName);
		connectionProps.put("123456", password);
		String connectionString="jdbc:mysql://localhost:3306/database"+ProgramName;
		conn = DriverManager.getConnection(connectionString,"root","123456");

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
	 * @param string 
	 * @param string 
	 * @throws IOException 
	 */
	public void run(Connection conn, String ProgramName, String ProgramNameLoweCase) throws IOException {
		
		
		/** The name of the MySQL account to use (or empty for anonymous) */
		 

		/** The name of the computer running MySQL */  
		
		 final String serverName = "localhost";

		/** The port of the MySQL server (default is 3306) */
		
		final int portNumber = 3306;

		/** The name of the database we are testing with (this default is installed with MySQL) */
		
		/** The name of the table we are testing with */
		 final String tableName = "classes";
		List<tracesmethodscallees> TracesCalleesList= new ArrayList<tracesmethodscallees>();
		List<tracesmethodscallees> TracesCallersList= new ArrayList<tracesmethodscallees>();
		HashMap <String, String> MethodInterfaces = new HashMap <String, String>(); 
		HashMap <String, String> InterfacesMethods = new HashMap <String, String>(); 
		HashMap <String, String> MethodSuperclasses = new HashMap <String, String>(); 
		HashMap <String, String> SuperclassesMethods = new HashMap <String, String>(); 
		
		HashMap <String, List<String>> methodcallsinexecnotparsedcallercallee = new HashMap <String, List<String>>(); 
		HashMap <String, List<String>> methodcallsinexecnotparsedcalleecaller = new HashMap <String, List<String>>(); 
		HashMap <String, List<String>> methodcallsinparsednotexecallercallee = new HashMap <String, List<String>>(); 
		HashMap <String, List<String>> methodcallsinparsednotexecalleecaller = new HashMap <String, List<String>>(); 
		LinkedHashMap <String, List<MethodTrace2>> ImplementationsTracesHashMap = new LinkedHashMap <String, List<MethodTrace2>>(); 
		LinkedHashMap <String, List<Interface2>> InterfacesImplementationsHashMap = new LinkedHashMap <String, List<Interface2>>(); 
		LinkedHashMap <String, String> InterfacesTracesHashMap = new LinkedHashMap <String, String>(); 

		LinkedHashMap <String, List<MethodTrace2>> SuperclassesChildrenTracesHashMap = new LinkedHashMap <String, List<MethodTrace2>>(); 
		LinkedHashMap <String, String> SuperclassesTracesHashMap = new LinkedHashMap <String, String>(); 
		LinkedHashMap <String, List<SuperClass2>> SuperclassesChildrenHashMap = new LinkedHashMap <String, List<SuperClass2>>(); 
		
		

		
		ResultSet rs = null; 

		BufferedWriter bwfile5 = null ; 
		BufferedWriter bwfile2= null ; 
		if(ProgramName.equals("Chess")) {
			File fout1 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logs\\ComparisonSuperclassesChildrenChess_COUNTS.txt");
			FileOutputStream fos = new FileOutputStream(fout1);
			 bwfile2 = new BufferedWriter(new OutputStreamWriter(fos));
			File fout5 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logs\\ComparisonInterfacesImpChess_COUNTS.txt");
			FileOutputStream fos5 = new FileOutputStream(fout5);
			 bwfile5 = new BufferedWriter(new OutputStreamWriter(fos5));
		}
		if(ProgramName.equals("iTrust")) {
			File fout1 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logs\\ComparisonSuperclassesChildreniTrust_COUNTS.txt");
			FileOutputStream fos = new FileOutputStream(fout1);
			 bwfile2 = new BufferedWriter(new OutputStreamWriter(fos));
			File fout5 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logs\\ComparisonInterfacesImpiTrust_COUNTS.txt");
			FileOutputStream fos5 = new FileOutputStream(fout5);
			 bwfile5 = new BufferedWriter(new OutputStreamWriter(fos5));
		}
		if(ProgramName.equals("Gantt")) {
			File fout1 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logs\\ComparisonSuperclassesChildrenGantt_COUNTS.txt");
			FileOutputStream fos = new FileOutputStream(fout1);
			 bwfile2 = new BufferedWriter(new OutputStreamWriter(fos));
			File fout5 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logs\\ComparisonInterfacesImpGantt_COUNTS.txt");
			FileOutputStream fos5 = new FileOutputStream(fout5);
			 bwfile5 = new BufferedWriter(new OutputStreamWriter(fos5));
		}
		if(ProgramName.equals("JHotDraw")) {
			File fout1 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logs\\ComparisonSuperclassesChildrenJHotDraw_COUNTS.txt");
			FileOutputStream fos = new FileOutputStream(fout1);
			 bwfile2 = new BufferedWriter(new OutputStreamWriter(fos));
			File fout5 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logs\\ComparisonInterfacesImpJHotDraw_COUNTS.txt");
			FileOutputStream fos5 = new FileOutputStream(fout5);
			 bwfile5 = new BufferedWriter(new OutputStreamWriter(fos5));
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
			String goldfinal=""; 
			String interfaceclassid=""; 
			String interfacename=""; 
			String implementationclassid=""; 
			String implementationclassname=""; 
			String superclassid=""; 
			String superclassname=""; 
			String childclassid=""; 
			String childclassname=""; 
			String rowID=""; 
			ResultSet res2=st.executeQuery("SELECT * "+
					"			FROM "+ProgramNameLoweCase+".interfaces" ); 
			while(res2.next()) {
				
				interfaceclassid=res2.getString("interfaceclassid"); 
				interfacename=res2.getString("interfacename"); 
				implementationclassid=res2.getString("ownerclassid"); 
				implementationclassname=res2.getString("classname"); 
				
				ClassRepresentation2 implclass= new ClassRepresentation2(implementationclassid, implementationclassname); 
				ClassRepresentation2 interfaceclass= new ClassRepresentation2(interfaceclassid, interfacename); 
				Interface2 myinter= new Interface2(); 
				myinter.setInterfaceClass(interfaceclass);
				myinter.setImplementation(implclass);
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
					"			FROM "+ProgramNameLoweCase+".superclasses" ); 
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
					"			FROM "+ProgramNameLoweCase+".tracesclasses" ); 
			while(res.next()) {
				
				requirementid=res.getString("requirementid"); 
				classid=res.getString("classid"); 
				classname=res.getString("classname"); 
				if(ProgramName.equals("Chess")|| ProgramName.equals("iTrust")) {
					goldfinal=res.getString("goldfinal"); 
				}
				else if(ProgramName.equals("JHotDraw")|| ProgramName.equals("Gantt")) {
					goldfinal=res.getString("goldfinal"); 
				}
				
				SuperClass2 superclass= new SuperClass2(); 
				MethodTrace2 methodtrace= new MethodTrace2(); 
				Requirement2 req= new Requirement2(requirementid, requirement); 
				ClassRepresentation2 classrep = new ClassRepresentation2(classid, classname); 
				methodtrace.setRequirement(req);
				
				methodtrace.setClassRepresentation(classrep);
				methodtrace.setGoldFinal(goldfinal);
			
				for(String mykey: InterfacesImplementationsHashMap.keySet()) {

					String mykey2=mykey.substring(0, mykey.indexOf("-")); 
				
					if(classid.equals(mykey2)) {
						System.out.println("=================THIS IS AN INTERFACE");
						InterfacesTracesHashMap.put(requirementid+"/"+classid+"/"+classname, goldfinal); 
					}
					
					for(Interface2 impl: InterfacesImplementationsHashMap.get(mykey)) {
						

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
				
				
				for(String mykey: SuperclassesChildrenHashMap.keySet()) {

					String mykey2=mykey.substring(0, mykey.indexOf("-")); 
				
					if(classid.equals(mykey2)) {
						System.out.println("=================THIS IS A SUPERCLASS");
						SuperclassesTracesHashMap.put(requirementid+"/"+classid+"/"+classname, goldfinal); 
					}
					
					for(SuperClass2 impl: SuperclassesChildrenHashMap.get(mykey)) {
						

						if(impl.getOwnerClass().getClassid().equals(classid)) {
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
				String	goldfinalval=value.getGoldfinal(); 
				String	req=value.getRequirement().ID; 
				
				String	classIDTrace=value.getClassRepresentation().classid; 
				String	classnameTrace=value.getClassRepresentation().classname; 
				String	myinterfaceID=entry.getKey().substring(0, entry.getKey().indexOf("-")); 
				String	myinterfacename=entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
				System.out.println(counter);
				
					
				
					
						if(ImplementationsTracesHashMapFinal.get(req+"/"+myinterfaceID+"/"+myinterfacename)!=null) {
							
							list=ImplementationsTracesHashMapFinal.get(req+"/"+myinterfaceID+"/"+myinterfacename); 
							list.add(value.goldFinal+"-"+classIDTrace); 
//							list.add(value.goldfinal.trim()); 
							ImplementationsTracesHashMapFinal.put(req+"/"+myinterfaceID+"/"+myinterfacename, list); 
						}else {
							list = new ArrayList<String>();
							list.add(value.goldFinal+"-"+classIDTrace); 
//							list.add(value.goldfinal.trim()); 
							ImplementationsTracesHashMapFinal.put(req+"/"+myinterfaceID+"/"+myinterfacename, list); 
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
				String	goldfinalval=value.getGoldfinal(); 
				String	req=value.getRequirement().ID; 
				
				String	classIDTrace=value.getClassRepresentation().classid; 
				String	classnameTrace=value.getClassRepresentation().classname; 
				String	myinterfaceID=entry.getKey().substring(0, entry.getKey().indexOf("-")); 
				String	myinterfacename=entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
				System.out.println(counter);
				
					
				
					
						if(SuperclassesTracesHashMapFinal.get(req+"/"+myinterfaceID+"/"+myinterfacename)!=null) {
							
							list=SuperclassesTracesHashMapFinal.get(req+"/"+myinterfaceID+"/"+myinterfacename); 
							list.add(value.goldFinal+"-"+classIDTrace); 
							SuperclassesTracesHashMapFinal.put(req+"/"+myinterfaceID+"/"+myinterfacename, list); 
						}else {
							list = new ArrayList<String>();
							list.add(value.goldFinal+"-"+classIDTrace); 
							SuperclassesTracesHashMapFinal.put(req+"/"+myinterfaceID+"/"+myinterfacename, list); 
						}
					
				
	
			
					
				counter++; 
				}
				
				
				
			}
			
			
//			System.setOut(fileOut);
			  System.out.println("RequirementID, MethodName, InterfaceID, InterfaceName, Values");
		
			  bwfile5.write("RequirementID, InterfaceID, InterfaceTraceValue, #ImplementationT, #ImplementationN, #ImplementationE");
			  bwfile5.newLine();
			  CountTNE countInterface= new CountTNE(); 

			for (Entry<String, List<String>> entry : ImplementationsTracesHashMapFinal.entrySet()) {
				
			    String key = entry.getKey();
			    List<String> values = entry.getValue();
			    // now work with key and value...
			    String[] keys = key.split("/"); 
				 String RequirementID= keys[0]; 
				
				 String myclassid= keys[1]; 
				 String myclassname= keys[2]; 
				 System.out.print(RequirementID+","+myclassid+","+myclassname+" "); 
			
				 
				 countInterface= new CountTNE(); 
				 if(InterfacesTracesHashMap.get(RequirementID+"/"+myclassid+"/"+myclassname)!=null) {
					 System.out.print("------ "+InterfacesTracesHashMap.get(RequirementID+"/"+myclassid+"/"+myclassname)+"------ ");
				
					 String TraceVal=InterfacesTracesHashMap.get(RequirementID+"/"+myclassid+"/"+myclassname); 
					 if(TraceVal.trim().equals("T")) {
						 countInterface.CountT++; 
						
					 }else if(TraceVal.trim().equals("N")) {
						 countInterface.CountN++; 
						
					 }else if(TraceVal.trim().equals("E")) {
						 countInterface.CountE++; 
						
					 }
					
					 
				 }
				String myinterfacesIDsT= ""; 
				String myinterfacesIDsN= ""; 
				String myinterfacesIDsE= ""; 

				 CountTNE countImp= new CountTNE(); 
			
					 for(String val: values) {
						 String[] myinterfacesIDs = val.split("-"); 
						 val=myinterfacesIDs[0]; 
						 if(val.trim().equals("T")) {
							 countImp.CountT++; 
							 myinterfacesIDsT=myinterfacesIDs[1]+"-"+myinterfacesIDsT; 
						 }else  if(val.trim().equals("N")) {
							 countImp.CountN++; 
							 myinterfacesIDsN=myinterfacesIDs[1]+"-"+myinterfacesIDsN; 

						 }
						 else  if(val.trim().equals("E")) {
							 countImp.CountE++; 
							 myinterfacesIDsE=myinterfacesIDs[1]+"-"+myinterfacesIDsE; 

						 }
					 }

					
					
				
				 System.out.println(); 
				
				String countInterfaceVal=""; 
				 if(countInterface.CountT==1) {
					 countInterfaceVal="T"; 
				 }
				 else if(countInterface.CountN==1) {
					 countInterfaceVal="N"; 
				 }
				 else {
					 countInterfaceVal="E"; 
				 }
				
				 bwfile5.write(RequirementID+","+ myclassid+","+countInterfaceVal+" , "+countImp.CountT+"("+ myinterfacesIDsT+")"+", "+countImp.CountN+"("+ myinterfacesIDsN+")"+" , "+countImp.CountE
						 +"("+ myinterfacesIDsE+")");
//				 if(countInterface.CountT>0|| countInterface.CountN>0|| countInterface.CountE>0) {
//					 bwfile5.write("COUNT INTERFACE "+countInterface.toString()+"  ,");
//				 }
//				
//				 bwfile5.write("COUNT IMPLEMENTATION "+countImp.toString()+"  ");
//				 
//				 if(countImp.CountT>0 && countImp.CountN>0 && countImp.CountE==0) {
////					 System.out.println("T MIXED WITH N CountSuperclass "+countSuperclassVal);
//					 bwfile5.write("T MIXED WITH N  ");
//				 }if(countImp.CountT==1 && countImp.CountE==0 && countImp.CountN==0 ) {
////					 System.out.println("ALL T CountSuperclass "+countSuperclassVal);
//					 bwfile5.write("ONLY 1 IMPLEMENTATION T  ");
//				 } if(countImp.CountN==1 && countImp.CountT==0 && countImp.CountE==0 ) {
////					 System.out.println("ALL N CountSuperclass "+countSuperclassVal);
//					 bwfile5.write("ONLY 1 IMPLEMENTATION  N  "); 
//				 } if(countImp.CountE==1 && countImp.CountT==0 && countImp.CountN==0 ) {
////					 System.out.println("ALL E CountSuperclass "+countSuperclassVal);
//					 bwfile5.write("ONLY 1 IMPLEMENTATION  E  "); 
//				 }  
//				 
//				 if(countImp.CountT>1 && countImp.CountE==0 && countImp.CountN==0 ) {
////					 System.out.println("ALL T CountSuperclass "+countSuperclassVal);
//					 bwfile5.write("ALL T  ");
//				 } if(countImp.CountN>1 && countImp.CountT==0 && countImp.CountE==0 ) {
////					 System.out.println("ALL N CountSuperclass "+countSuperclassVal);
//					 bwfile5.write("ALL N  "); 
//				 } if(countImp.CountE>1 && countImp.CountT==0 && countImp.CountN==0 ) {
////					 System.out.println("ALL E CountSuperclass "+countSuperclassVal);
//					 bwfile5.write("ALL E  "); 
//				 } if(countImp.CountN>0 && countImp.CountE>0 && countImp.CountT==0) {
////					 System.out.println("N MIXED WITH E CountSuperclass "+countSuperclassVal);
//					 bwfile5.write("N MIXED WITH E  "); 
//				 }
//				  if(countImp.CountT>0 && countImp.CountE>0 && countImp.CountN==0) {
////					 System.out.println("T MIXED WITH E CountSuperclass "+countSuperclassVal);
//					  bwfile5.write("T MIXED WITH E  "); 
//				 }
//				  if(countImp.CountT>0 && countImp.CountE>0 && countImp.CountN>0) {
////					 System.out.println("T MIXED WITH N AND E CountSuperclass "+countSuperclassVal);
//					  bwfile5.write("T MIXED WITH N AND E  "); 
//				 }
				
				  bwfile5.newLine();
				
				
		    
			}
			
			
			
			
			
	
			
//			System.setOut(fileOut);
			bwfile2.write("RequirementID, SuperclassID, SuperclassTraceValue, #ChildClassT, #ChildClassN, #ChildClassE");
			bwfile2.newLine();
			 CountTNE countSuperclass= new CountTNE(); 
			for (Entry<String, List<String>> entry : SuperclassesTracesHashMapFinal.entrySet()) {
			    String key = entry.getKey();
			    List<String> values = entry.getValue();
			    // now work with key and value...
			    String[] keys = key.split("/"); 
				 String RequirementID= keys[0]; 
				 String myclassid= keys[1]; 
				 String myclassname= keys[2]; 
				String TraceVal=null; 
				 
				 countSuperclass= new CountTNE(); 
				 if(SuperclassesTracesHashMap.get(RequirementID+"/"+myclassid+"/"+myclassname)!=null) {
//					 bwfile2.write("------ "+SuperclassesTracesHashMap.get(RequirementID+"/"+myclassid+"/"+myclassname)+"------ ");
					  TraceVal=SuperclassesTracesHashMap.get(RequirementID+"/"+myclassid+"/"+myclassname); 
					
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
//						 bwfile2.write("*************** "); 
					}

			        System.out.print(value+" ");
//			        bwfile2.write(value+" "); 
			    }
				
				String myinterfacesIDsT= ""; 
				String myinterfacesIDsN= ""; 
				String myinterfacesIDsE= ""; 

			
					 for(String val: values) {
						 String[] myinterfacesIDs = val.split("-"); 
						 val=myinterfacesIDs[0]; 
						 if(val.trim().equals("T")) {
							 countImp.CountT++; 
							 myinterfacesIDsT=myinterfacesIDs[1]+"-"+myinterfacesIDsT; 
						 }else  if(val.trim().equals("N")) {
							 countImp.CountN++; 
							 myinterfacesIDsN=myinterfacesIDs[1]+"-"+myinterfacesIDsN; 

						 }
						 else  if(val.trim().equals("E")) {
							 countImp.CountE++; 
							 myinterfacesIDsE=myinterfacesIDs[1]+"-"+myinterfacesIDsE; 

						 }
					 }

				 System.out.println(); 
//				 bwfile2.newLine(); 
				
				 if(countSuperclass.CountT>0|| countSuperclass.CountN>0|| countSuperclass.CountE>0) {
				 }
				
				 String countSuperclassVal=""; 
				 if(countSuperclass.CountE==1) {
					 countSuperclassVal="E"; 
				 }
				if(countSuperclass.CountN==1) {
					 countSuperclassVal="N"; 		 
								 }
				if(countSuperclass.CountT==1) {
					countSuperclassVal="T"; 	
				}
				
				bwfile2.write(RequirementID+","+ myclassid+","+countSuperclassVal+" , "+countImp.CountT+"("+ myinterfacesIDsT+")"+", "+countImp.CountN+"("+ myinterfacesIDsN+")"+" , "+countImp.CountE
						 +"("+ myinterfacesIDsE+")");
				
				bwfile2.newLine(); 
//				 if(countImp.CountT>0 && countImp.CountN>0 && countImp.CountE==0) {
////					 System.out.println("T MIXED WITH N CountSuperclass "+countSuperclassVal);
//					 bwfile4.write("T MIXED WITH N  ");
//				 }if(countImp.CountT==1 && countImp.CountE==0 && countImp.CountN==0 ) {
////					 System.out.println("ALL T CountSuperclass "+countSuperclassVal);
//					 bwfile4.write("ONLY 1 CHILD T  ");
//				 } if(countImp.CountN==1 && countImp.CountT==0 && countImp.CountE==0 ) {
////					 System.out.println("ALL N CountSuperclass "+countSuperclassVal);
//					 bwfile4.write("ONLY 1 CHILD  N  "); 
//				 } if(countImp.CountE==1 && countImp.CountT==0 && countImp.CountN==0 ) {
////					 System.out.println("ALL E CountSuperclass "+countSuperclassVal);
//					 bwfile4.write("ONLY 1 CHILD  E  "); 
//				 }  
//				 
//				 if(countImp.CountT>1 && countImp.CountE==0 && countImp.CountN==0 ) {
////					 System.out.println("ALL T CountSuperclass "+countSuperclassVal);
//					 bwfile4.write("ALL T  ");
//				 } if(countImp.CountN>1 && countImp.CountT==0 && countImp.CountE==0 ) {
////					 System.out.println("ALL N CountSuperclass "+countSuperclassVal);
//					 bwfile4.write("ALL N  "); 
//				 } if(countImp.CountE>1 && countImp.CountT==0 && countImp.CountN==0 ) {
////					 System.out.println("ALL E CountSuperclass "+countSuperclassVal);
//					 bwfile4.write("ALL E  "); 
//				 } if(countImp.CountN>0 && countImp.CountE>0 && countImp.CountT==0) {
////					 System.out.println("N MIXED WITH E CountSuperclass "+countSuperclassVal);
//					 bwfile4.write("N MIXED WITH E  "); 
//				 }
//				  if(countImp.CountT>0 && countImp.CountE>0 && countImp.CountN==0) {
////					 System.out.println("T MIXED WITH E CountSuperclass "+countSuperclassVal);
//					  bwfile4.write("T MIXED WITH E  "); 
//				 }
//				  if(countImp.CountT>0 && countImp.CountE>0 && countImp.CountN>0) {
////					 System.out.println("T MIXED WITH N AND E CountSuperclass "+countSuperclassVal);
//					  bwfile4.write("T MIXED WITH N AND E  "); 
//				 }
//				
//				
//				  bwfile4.newLine();
				
			
			}
			
			
			
			
			System.out.println("finished");
			bwfile2.close();
			bwfile5.close();
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
		UnitedComparisonMethodInterfacesFinal app = new UnitedComparisonMethodInterfacesFinal();
		
		// Connect to MySQL
				Connection conn = null;
				try {
					conn = getConnection("chess");
					System.out.println("Connected to database");
					
				} catch (SQLException e) {
					System.out.println("ERROR: Could not connect to the database");
					e.printStackTrace();
					return;
				}
		app.run(conn, "Chess", "databasechess");
		Spoon(); 
		
		conn.close();
		
		
		
		
		 conn = null;
		try {
			conn = getConnection("gantt");
			System.out.println("Connected to database");
			
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}
		app.run(conn, "Gantt", "databasegantt");
		Spoon(); 
		conn.close();
		
		
		 conn = null;
			try {
				conn = getConnection("itrust");
				System.out.println("Connected to database");
				
			} catch (SQLException e) {
				System.out.println("ERROR: Could not connect to the database");
				e.printStackTrace();
				return;
			}
			app.run(conn, "iTrust", "databaseitrust");
			Spoon(); 
			conn.close();
			
			conn = null;
			try {
				conn = getConnection("jhotdraw");
				System.out.println("Connected to database");
				
			} catch (SQLException e) {
				System.out.println("ERROR: Could not connect to the database");
				e.printStackTrace();
				return;
			}
			app.run(conn, "JHotDraw", "databasejhotdraw");
			Spoon(); 
			conn.close();
	}
	
	

	static void Spoon() throws SQLException, IOException {
		
		
		
		
		
		
	}

	
}
