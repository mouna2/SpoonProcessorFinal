package JHotDraw;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import Chess.TracesTableChessFINALGeneticAlgorithm;
import Tables.CallerIDName;
import Tables.tracesmethods;
import Tables.tracesmethodscallees;
import mainPackage.ClassRepresentation;
import mypackage.ClassDetails2;
import mypackage.ClassField2;
import mypackage.ClassTrace2;
import mypackage.DatabaseReading2;
import mypackage.Interface2;
import mypackage.MethodDetails;
import mypackage.Method;
import mypackage.MethodField2;
import mypackage.MethodTraceSubjectTSubjectNOriginal;
import mypackage.Requirement2;
import mypackage.RequirementClass;
import mypackage.RequirementGold;
import mypackage.SuperClass2;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.CtModel;
import spoon.reflect.factory.ClassFactory;

public class DatabaseReading2JHotDraw {
	public static HashMap<Integer, String> classesHashMap = new HashMap<Integer, String>();
	public static List<MethodTraceSubjectTSubjectNOriginal> methodtraces2 = null;
	public static List<ClassTrace2> classestraces2 = null;
	public static List<MethodDetails> methodlist = null;
	public static LinkedHashMap<String, ClassTrace2> classesRequirementtraceshashmap=null; 
	public static LinkedHashMap<String, MethodDetails> linkedmethodhashmap=null; 
	public static HashMap<String, Interface2> interfacehashmap=null; 
	public static HashMap<String, List<Interface2>> interfacehashmapOwnerClass=null; 
	public static HashMap<String, List<ClassField2>>  ClassFieldHashMap=null; 
	public static HashMap<String, List<MethodField2>>  MethodFieldHashMap=null; 
	public static HashMap<String, List<SuperClass2>>  SuperclassesHashMap=null; 

	
	
	public static List<MethodTraceSubjectTSubjectNOriginal> getMethodtraces2() {
		return methodtraces2;
	}



	public static void setMethodtraces2(List<MethodTraceSubjectTSubjectNOriginal> methodtraces2) {
		DatabaseReading2JHotDraw.methodtraces2 = methodtraces2;
	}



	public static HashMap<String, List<SuperClass2>> getSuperclassesHashMap() {
		return SuperclassesHashMap;
	}



	public static void setSuperclassesHashMap(HashMap<String, List<SuperClass2>> superclassesHashMap) {
		SuperclassesHashMap = superclassesHashMap;
	}

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	public static List<MethodDetails> getMethodlist() {
		return methodlist;
	}



	public static LinkedHashMap<String, MethodDetails> getLinkedmethodhashmap() {
		return linkedmethodhashmap;
	}



	public static void setLinkedmethodhashmap(LinkedHashMap<String, MethodDetails> linkedmethodhashmap) {
		DatabaseReading2JHotDraw.linkedmethodhashmap = linkedmethodhashmap;
	}



	public static void setMethodlist(List<MethodDetails> methodlist) {
		DatabaseReading2JHotDraw.methodlist = methodlist;
	}

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "root";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */

	private final int portNumber = 3306;

	public static List<ClassTrace2> getClassestraces2() {
		return classestraces2;
	}

	public static void setClassestraces2(List<ClassTrace2> classestraces2) {
		DatabaseReading2JHotDraw.classestraces2 = classestraces2;
	}

	/**
	 * The name of the database we are testing with (this default is installed with
	 * MySQL)
	 */
	private final String dbName = "databasejhotdraw";

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("root", this.userName);
		connectionProps.put("123456", this.password);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasejhotdraw", "root", "123456");
		SpoonAPI spoon = new Launcher();
		spoon.addInputResource("C:\\Users\\mouna\\ownCloud\\Share\\jHotDraw_sources\\src_jhotdraw");
		spoon.getEnvironment().setAutoImports(true);
		spoon.getEnvironment().setNoClasspath(true);

		// Interact with model

		return conn;
	}

	public static void main(String[] args) throws SQLException, IOException {
		MakePredictions();

	}
	/**
	 * @throws SQLException 
	 * @throws IOException ***********************************************************************************************************************/
	public static void MakePredictions() throws SQLException, IOException {
		Connection conn = null;
		DatabaseReading2JHotDraw DatabaseReading = new DatabaseReading2JHotDraw();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
		int index = 0;
		mypackage.Clazz classrep = new mypackage.Clazz();

		HashMap<Integer, mypackage.Clazz> ClassRepresentationHashMap = classrep
				.ReadClassesRepresentations(conn);
		Set<Integer> keys = ClassRepresentationHashMap.keySet();
		for (Integer key : keys) {
			System.out.println("Value of " + key + " is: " + ClassRepresentationHashMap.get(key).ID + "   "
					+ ClassRepresentationHashMap.get(key).classname + "   ");
		}

		///////////////////////////////////////////////////////////////////////////////////////
		mypackage.ClassDetails2 classdet = new mypackage.ClassDetails2();

		HashMap<Integer, mypackage.ClassDetails2> ClassDetailsHashMap = classdet.ReadClassesRepresentations(conn);
		keys = ClassRepresentationHashMap.keySet();
		for (Integer key : keys) {
			System.out.println("Value of " + key + " is: " + ClassRepresentationHashMap.get(key).ID + "   "
					+ ClassRepresentationHashMap.get(key).classname + "   ");
		}

		///////////////////////////////////////////////////////////////////////////////////////
		Requirement2 req = new Requirement2();

		HashMap<String, Requirement2> RequirementHashMap = req.ReadClassesRepresentations(conn);
		Set<String> keys2 = RequirementHashMap.keySet();
		for (String key : keys2) {
			System.out.println("Value of " + key + " is: " + RequirementHashMap.get(key).ID + "   "
					+ RequirementHashMap.get(key).RequirementName + "   ");
		}
		///////////////////////////////////////////////////////////////////////////////////////
		/*Method2Details methoddet2 = new Method2Details();
		HashMap<Integer, Method2Details> methodhashmap = methoddet2.ReadClassesRepresentations(conn);
		List<Method2Details> methodlist = new ArrayList<Method2Details>(methodhashmap.values());
		setMethodlist(methodlist);*/
		///////////////////////////////////////////////////////////////////////////////////////
	/*	ClassDetails2 classdet2 = new ClassDetails2();
		HashMap<Integer, ClassDetails2> classhashmap = classdet2.ReadClassesRepresentations(conn);
		List<ClassDetails2> classlist = new ArrayList<ClassDetails2>(classhashmap.values());
		///////////////////////////////////////////////////////////////////////////////////////

		ClassTrace2 myclasstrace2 = new ClassTrace2();
		HashMap<Integer, ClassTrace2> classtracehashmap = myclasstrace2.ReadClassesRepresentations(conn);
		List<ClassTrace2> classtraces = new ArrayList<ClassTrace2>(classtracehashmap.values());*/
		System.out.println("***************0");

		MethodDetails methoddet2 = new MethodDetails();
		///////////////////////////////////////////////////////////////////////////////////////

		MethodTraceSubjectTSubjectNOriginal methodtrace2 = new MethodTraceSubjectTSubjectNOriginal();
		HashMap<Integer, MethodTraceSubjectTSubjectNOriginal> methodtracehashmap = methodtrace2.ReadClassesRepresentations(conn);
		List<MethodTraceSubjectTSubjectNOriginal> methodtraces = new ArrayList<MethodTraceSubjectTSubjectNOriginal>(methodtracehashmap.values());
		setMethodtraces2(methodtraces);
		///////////////////////////////////////////////////////////////////////////////////////
		
		/*ClassTrace2 classtrace2= new ClassTrace2(); 
		HashMap<Integer, ClassTrace2> classestraceshashmap = classtrace2.ReadClassesRepresentations(conn);
		List<ClassTrace2> classestraces = new ArrayList<ClassTrace2>(classestraceshashmap.values());
		setClassestraces2(classestraces);*/
		///////////////////////////////////////////////////////////////////////////////////////
		LinkedHashMap<String, MethodDetails> linkedmethodhashmap = methoddet2.ReadClassesRepresentations2(conn);
		List<MethodDetails> methodlistlinked = new ArrayList<MethodDetails>(linkedmethodhashmap.values());
		setLinkedmethodhashmap(linkedmethodhashmap);
		///////////////////////////////////////////////////////////////////////////////////////
		ClassTrace2 classtrace2= new ClassTrace2(); 
		classesRequirementtraceshashmap = classtrace2.ReadClassesRepresentationsRequirementClass(conn); 
		List<ClassTrace2> classestracesRequirementClass = new ArrayList<ClassTrace2>(classesRequirementtraceshashmap.values());
		setClassestraces2(classestracesRequirementClass);
//		setClassesRequirementtraceshashmap(classesRequirementtraceshashmap); 
		///////////////////////////////////////////////////////////////////////////////////////
		Interface2 myinterface2= new Interface2(); 
		interfacehashmapOwnerClass = myinterface2.ReadInterfacesRepresentations(conn);
//		List<Interface2>  myinterfaces = new ArrayList<Interface2>(interfacehashmapOwnerClass.values());
		setInterfacehashmapOwnerClass(interfacehashmapOwnerClass);
		///////////////////////////////////////////////////////////////////////////////////////
				
///////////////////////////////////////////////////////////////////////////////////////
ClassField2 classfield= new ClassField2(); 
HashMap<String, List<ClassField2>> myclassfields = classfield.ReadClassFields(conn); 
setClassFieldHashMap(myclassfields);
///////////////////////////////////////////////////////////////////////////////////////
MethodField2 methodfield= new MethodField2(); 
HashMap<String, List<MethodField2>> mymethodfields = methodfield.ReadMethodFields(conn); 
setMethodFieldHashMap(mymethodfields);

///////////////////////////////////////////////////////////////////////////////////////
SuperClass2 superclass= new SuperClass2(); 
HashMap<String, List<SuperClass2>> mysuperclasses = superclass.ReadSuperClasses(conn);  
setSuperclassesHashMap(mysuperclasses);
/////////////////////////////////////////////
System.out.println("MOUNA");
		
		
		/*String goldprediction=""; 
		for (MethodTraceSubjectTSubjectNOriginal tracemeth : methodtraces) {
			Requirement2 requirement = tracemeth.getRequirement();
			Method2Representation MethodRepresentation = tracemeth.getMethodRepresentation();
			String gold = tracemeth.getGold();
			for (Method2Details method : methodlist) {
				Method2Representation MethodRepresentation2 = method.getMethodrep();
				List<Method2Representation> Callees = method.calleesList;
				for (Method2Representation Callee : Callees) {
					if (Callee.methodid.equals(tracemeth.getMethodRepresentation().methodid)) {
						HashMap<Requirement2, MethodTraceSubjectTSubjectNOriginal> methodtracesHash = method.getMethodtraces();
						List<MethodTraceSubjectTSubjectNOriginal> methodtracesList = new ArrayList<MethodTraceSubjectTSubjectNOriginal>(methodtracesHash.values());
						for (MethodTraceSubjectTSubjectNOriginal methtrace : methodtracesList) {
							if (methtrace.getRequirement().ID.equals(tracemeth.getRequirement().ID)) {
								System.out.println("HEYYYYYYYYYYYYYYYY CALLEE");
								goldprediction="goldpredictionCallee"; 
								methodtraces2 = methtrace.getElement(methodtraces, Callee.methodid, methtrace.gold, goldprediction, tracemeth.getRequirement().ID);
							}
						}
					}
				}
				List<Method2Representation> Callers = method.callersList;
				for (Method2Representation Caller : Callers) {
					if (Caller.methodid.equals(tracemeth.getMethodRepresentation().methodid)) {
						HashMap<Requirement2, MethodTraceSubjectTSubjectNOriginal> methodtracesHashCallers = method.getMethodtraces();
						List<MethodTraceSubjectTSubjectNOriginal> methodtracesCallersList = new ArrayList<MethodTraceSubjectTSubjectNOriginal>(
								methodtracesHashCallers.values());
						for (MethodTraceSubjectTSubjectNOriginal methtrace : methodtracesCallersList) {
							if (methtrace.getRequirement().ID.equals(tracemeth.getRequirement().ID)) {
								System.out.println("HEYYYYYYYYYYYYYYYY CALLER ");
								goldprediction="goldpredictionCaller"; 
								methodtraces2 = methtrace.getElement(methodtraces, Caller.methodid, methtrace.gold, goldprediction, tracemeth.getRequirement().ID);
							}
						}
					}
				}
			}
		}
*/
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
	/*	
		String goldprediction=""; 
		String GoldVal=""; 
		for (MethodTraceSubjectTSubjectNOriginal tracemeth : methodtraces) { 
			
			for (Method2Details method : methodlist) {
				List<Method2Representation> Callees = method.calleesList;
				for (Method2Representation Callee : Callees) {
					if (Callee.methodid.equals(tracemeth.getMethodRepresentation().methodid) ) {
						
							for(RequirementGold reqgoldCallee: Callee.getRequirementsGold()) {
								if(reqgoldCallee.Requirement.ID.equals(tracemeth.Requirement.ID)) {
									goldprediction="goldpredictionCaller"; 
									GoldVal= reqgoldCallee.gold; 
									methodtraces2 = tracemeth.getElement(methodtraces, method.methodrep.methodid,
											GoldVal, goldprediction, tracemeth.getRequirement().ID);
								}
							}
						
						
						
				

					}

				}
			}
		}
				 GoldVal=""; 
				for (MethodTraceSubjectTSubjectNOriginal tracemeth2 : methodtraces) {
					
					for (Method2Details method2 : methodlist) {
						List<Method2Representation> Callers = method2.callersList;
						for (Method2Representation Caller : Callers) {
							if (Caller.methodid.equals(tracemeth2.getMethodRepresentation().methodid) ) {
								
									for(RequirementGold reqgoldCaller: Caller.getRequirementsGold()) {
										if(reqgoldCaller.Requirement.ID.equals(tracemeth2.Requirement.ID)) {
											goldprediction="goldpredictionCallee"; 
											GoldVal= reqgoldCaller.gold; 
											methodtraces2 = tracemeth2.getElement(methodtraces, method2.methodrep.methodid,
													GoldVal, goldprediction, tracemeth2.getRequirement().ID);
										}
									}
								
								
								
						

							}

						}

			}

		}*/
		/***********************************************************************************************************************/
		/***********************************************************************************************************************/
		/***********************************************************************************************************************/
		/* GoldVal=""; 
		for (MethodTraceSubjectTSubjectNOriginal tracemeth : methodtraces) {
			
			for (Method2Details method : methodlist) {
				List<Method2Representation> CalleesExecuted = method.calleesListExecuted;
				for (Method2Representation CalleeExecuted : CalleesExecuted) {
					if (CalleeExecuted.methodid.equals(tracemeth.getMethodRepresentation().methodid) ) {
						
							for(RequirementGold reqgoldCallee: CalleeExecuted.getRequirementsGold()) {
								if(reqgoldCallee.Requirement.ID.equals(tracemeth.Requirement.ID)) {
									goldprediction="goldpredictionCaller"; 
									GoldVal= reqgoldCallee.gold; 
									methodtraces2 = tracemeth.getElement(methodtraces, method.methodrep.methodid,
											GoldVal, goldprediction, tracemeth.getRequirement().ID);
								}
							}
						
						
						
				

					}

				}
			}
		}
				 GoldVal=""; 
				for (MethodTraceSubjectTSubjectNOriginal tracemeth2 : methodtraces) {
					
					for (Method2Details method2 : methodlist) {
						List<Method2Representation> CallersExecuted = method2.callersListExecuted;
						for (Method2Representation CallerExecuted : CallersExecuted) {
							if (CallerExecuted.methodid.equals(tracemeth2.getMethodRepresentation().methodid) ) {
								
									for(RequirementGold reqgoldCaller: CallerExecuted.getRequirementsGold()) {
										if(reqgoldCaller.Requirement.ID.equals(tracemeth2.Requirement.ID)) {
											goldprediction="goldpredictionCallee"; 
											GoldVal= reqgoldCaller.gold; 
											methodtraces2 = tracemeth2.getElement(methodtraces, method2.methodrep.methodid,
													GoldVal, goldprediction, tracemeth2.getRequirement().ID);
										}
									}
								
								
								
						

							}

						}

			}

		}

		for (MethodTraceSubjectTSubjectNOriginal methtr : methodtraces2) {
			System.out.println(methtr.toString(methtr));
		}

		int MethodTracesSize = methodtraces.size();
		int GoldMatchingCaller = 0;
		int GoldMatchingCallee = 0;
		int MethodTracesSizeNotNullCaller = 0;
		int MethodTracesSizeNotNullCallee = 0;
		for (int i = 0; i < MethodTracesSize - 4; i++) {
			if (methodtraces2.get(i).getGold().equals(methodtraces2.get(i).getGoldpredictionCaller())) {
				GoldMatchingCaller++;
			}
		}
		
		for (int i = 0; i < MethodTracesSize - 4; i++) {
			if (methodtraces2.get(i).getGold().equals(methodtraces2.get(i).getGoldpredictionCallee())) {
				GoldMatchingCallee++;
			}
		}
		MethodTracesSize = MethodTracesSize - 4;
		System.out.println("GOLDMATCHINGCALLER/TOTAL : =====> " + GoldMatchingCaller + " / " + MethodTracesSize);
		System.out.println("GOLDMATCHINGCALLEE/TOTAL : =====> " + GoldMatchingCallee + " / " + MethodTracesSize);

		for (int i = 0; i < MethodTracesSize ; i++) {
			//System.out.println("GOLD PRED "+i +"   "+methodtraces2.get(i).getGoldprediction());
			if (methodtraces2.get(i).getGoldpredictionCaller()!=null) {
				MethodTracesSizeNotNullCaller++;
			}
		}
		
		for (int i = 0; i < MethodTracesSize ; i++) {
			//System.out.println("GOLD PRED "+i +"   "+methodtraces2.get(i).getGoldprediction());
			if (methodtraces2.get(i).getGoldpredictionCallee()!=null) {
				MethodTracesSizeNotNullCallee++;
			}
		}
		System.out.println("GOLDMATCHINGCALLER/TOTAL NOT NULL: =====> " + GoldMatchingCaller + " / " + MethodTracesSizeNotNullCaller);
		System.out.println("GOLDMATCHINGCALLEE/TOTAL NOT NULL: =====> " + GoldMatchingCallee + " / " + MethodTracesSizeNotNullCallee);

	*/
	}



	public static HashMap<Integer, String> getClassesHashMap() {
		return classesHashMap;
	}



	public static void setClassesHashMap(HashMap<Integer, String> classesHashMap) {
		DatabaseReading2JHotDraw.classesHashMap = classesHashMap;
	}



	public static LinkedHashMap<String, ClassTrace2> getClassesRequirementtraceshashmap() {
		return classesRequirementtraceshashmap;
	}



	public static void setClassesRequirementtraceshashmap(
			LinkedHashMap<String, ClassTrace2> classesRequirementtraceshashmap) {
		DatabaseReading2JHotDraw.classesRequirementtraceshashmap = classesRequirementtraceshashmap;
	}



	public static HashMap<String, Interface2> getInterfacehashmap() {
		return interfacehashmap;
	}



	public static void setInterfacehashmap(HashMap<String, Interface2> interfacehashmap) {
		DatabaseReading2JHotDraw.interfacehashmap = interfacehashmap;
	}



	public static HashMap<String, List<Interface2>> getInterfacehashmapOwnerClass() {
		return interfacehashmapOwnerClass;
	}



	public static void setInterfacehashmapOwnerClass(HashMap<String, List<Interface2>> interfacehashmapOwnerClass) {
		DatabaseReading2JHotDraw.interfacehashmapOwnerClass = interfacehashmapOwnerClass;
	}



	public static HashMap<String, List<ClassField2>> getClassFieldHashMap() {
		return ClassFieldHashMap;
	}



	public static void setClassFieldHashMap(HashMap<String, List<ClassField2>> classFieldHashMap) {
		ClassFieldHashMap = classFieldHashMap;
	}



	public static HashMap<String, List<MethodField2>> getMethodFieldHashMap() {
		return MethodFieldHashMap;
	}



	public static void setMethodFieldHashMap(HashMap<String, List<MethodField2>> methodFieldHashMap) {
		MethodFieldHashMap = methodFieldHashMap;
	}


	
}