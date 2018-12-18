package Gantt;

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
import mypackage.*;
import mypackage.Children2;
import mypackage.ClassDetails2;
import mypackage.ClassField2;
import mypackage.ClassTrace2;
import mypackage.DatabaseReading2;
import mypackage.Implementation2;
import mypackage.Interface2;
import mypackage.MethodDetails;
import mypackage.Method;
import mypackage.MethodField2;
import mypackage.MethodTrace2;
import mypackage.MethodTraceSubjectTSubjectN;
import mypackage.MethodTraceSubjectTSubjectNOriginal;
import mypackage.Parameter2;
import mypackage.MethodTraceSubjectTSubjectNOriginal;
import mypackage.Requirement2;
import mypackage.RequirementClass;
import mypackage.RequirementGold;
import mypackage.SuperClass2;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.CtModel;
import spoon.reflect.factory.ClassFactory;

public class DatabaseReading2Gantt {
	
	public static HashMap<Integer, String> classesHashMap = new HashMap<Integer, String>();
	public static List<MethodTraceSubjectTSubjectNOriginal> methodtraces2 = null;
	public static List<MethodTrace> methodtraces2SubjectTSubjectN = null;
	public static List<ClassTrace2> classestraces2 = null;
	public static List<Interface2> interfaces2 = null;
	public static List<MethodDetails> methodlist = null;
	public static LinkedHashMap<String, ClassTrace2> classesRequirementtraceshashmap=null; 
	public static LinkedHashMap<String, MethodDetails> linkedmethodhashmap=null; 
	public static HashMap<String, List<Interface2>> interfacehashmapOwnerClass=null; 
	public static HashMap<String,Interface2> interfacehashmapAlreadyImpl=null; 
	public static HashMap<String, List<ClassField2>>  ClassFieldHashMap=null; 
	public static HashMap<String, List<MethodField2>>  MethodFieldHashMap=null; 
	public static HashMap<String, List<Parameter2>>  ParameterhashMap=null; 
	public static HashMap<String, List<Implementation2>> INTERFACEHASHMAPFINAL=null; 
	public static HashMap<String, List<Children2>> childrenHashMap=null; 
	public static HashMap<String, List<SuperClass2>>  SuperclassesHashMap=null; 
	static LinkedHashMap<String, MethodTrace> methodtracehashmap = null; 
	static HashMap<String, List<String>> ClassMethodsHashMap= new HashMap<String, List<String>>(); 
	public static HashMap<Method, HashMap<Requirement2, String>> FinalMethodHashMapReqGolds= new HashMap<Method, HashMap<Requirement2, String>>() ; 

	
	public static HashMap<String, List<String>> getClassMethodsHashMap() {
		return ClassMethodsHashMap;
	}

	public static void setClassMethodsHashMap(HashMap<String, List<String>> classMethodsHashMap) {
		ClassMethodsHashMap = classMethodsHashMap;
	}

	private final String userName = "root";

	public static HashMap<Method, HashMap<Requirement2, String>> getFinalMethodHashMapReqGolds() {
		return FinalMethodHashMapReqGolds;
	}

	public static void setFinalMethodHashMapReqGolds(
			HashMap<Method, HashMap<Requirement2, String>> finalMethodHashMapReqGolds) {
		FinalMethodHashMapReqGolds = finalMethodHashMapReqGolds;
	}


	public static HashMap<Integer, String> getClassesHashMap() {
		return classesHashMap;
	}

	public static void setClassesHashMap(HashMap<Integer, String> classesHashMap) {
		DatabaseReading2Gantt.classesHashMap = classesHashMap;
	}

	public static List<Interface2> getInterfaces2() {
		return interfaces2;
	}

	public static void setInterfaces2(List<Interface2> interfaces2) {
		DatabaseReading2Gantt.interfaces2 = interfaces2;
	}

	public static HashMap<String, List<Parameter2>> getParameterhashMap() {
		return ParameterhashMap;
	}

	public static void setParameterhashMap(HashMap<String, List<Parameter2>> parameterhashMap) {
		ParameterhashMap = parameterhashMap;
	}

	public static HashMap<String, List<Implementation2>> getINTERFACEHASHMAPFINAL() {
		return INTERFACEHASHMAPFINAL;
	}

	public static void setINTERFACEHASHMAPFINAL(HashMap<String, List<Implementation2>> iNTERFACEHASHMAPFINAL) {
		INTERFACEHASHMAPFINAL = iNTERFACEHASHMAPFINAL;
	}

	public static HashMap<String, List<Children2>> getChildrenHashMap() {
		return childrenHashMap;
	}

	public static void setChildrenHashMap(HashMap<String, List<Children2>> childrenHashMap) {
		DatabaseReading2Gantt.childrenHashMap = childrenHashMap;
	}

	public static void setMethodtracehashmap(LinkedHashMap<String, MethodTrace> methodtracehashmap) {
		DatabaseReading2Gantt.methodtracehashmap = methodtracehashmap;
	}

	public static List<MethodDetails> getMethodlist() {
		return methodlist;
	}

	public static LinkedHashMap<String, MethodDetails> getLinkedmethodhashmap() {
		return linkedmethodhashmap;
	}

	public static void setLinkedmethodhashmap(LinkedHashMap<String, MethodDetails> linkedmethodhashmap) {
		DatabaseReading2Gantt.linkedmethodhashmap = linkedmethodhashmap;
	}

	public static void setMethodlist(List<MethodDetails> methodlist) {
		DatabaseReading2Gantt.methodlist = methodlist;
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
		DatabaseReading2Gantt.classestraces2 = classestraces2;
	}

	/**
	 * The name of the database we are testing with (this default is installed with
	 * MySQL)
	 */
	private final String dbName = "databasegantt";

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("root", this.userName);
		connectionProps.put("123456", this.password);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasegantt", "root", "123456");
		SpoonAPI spoon = new Launcher();
		spoon.addInputResource("C:\\Users\\mouna\\ownCloud\\Share\\ganttproject\\ganttprojectCopy");
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
		DatabaseReading2Gantt DatabaseReading = new DatabaseReading2Gantt();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
		int index = 0;
		mypackage.Clazz classrep = new mypackage.Clazz();

//		HashMap<Integer, mypackage.ClassRepresentation2> ClassRepresentationHashMap = classrep
//				.ReadClassesRepresentations(conn);
//		Set<Integer> keys = ClassRepresentationHashMap.keySet();
//		for (Integer key : keys) {
//			System.out.println("Value of " + key + " is: " + ClassRepresentationHashMap.get(key).classid + "   "
//					+ ClassRepresentationHashMap.get(key).classname + "   ");
//		}
//
//		///////////////////////////////////////////////////////////////////////////////////////
//		mypackage.ClassDetails2 classdet = new mypackage.ClassDetails2();
//
//		HashMap<Integer, mypackage.ClassDetails2> ClassDetailsHashMap = classdet.ReadClassesRepresentations(conn);
//		keys = ClassRepresentationHashMap.keySet();
//		for (Integer key : keys) {
//			System.out.println("Value of " + key + " is: " + ClassRepresentationHashMap.get(key).classid + "   "
//					+ ClassRepresentationHashMap.get(key).classname + "   ");
//		}
//
//		///////////////////////////////////////////////////////////////////////////////////////
//		Requirement2 req = new Requirement2();
//
//		HashMap<String, Requirement2> RequirementHashMap = req.ReadClassesRepresentations(conn);
//		Set<String> keys2 = RequirementHashMap.keySet();
//		for (String key : keys2) {
//			System.out.println("Value of " + key + " is: " + RequirementHashMap.get(key).ID + "   "
//					+ RequirementHashMap.get(key).RequirementName + "   ");
//		}
		///////////////////////////////////////////////////////////////////////////////////////
		MethodDetails methoddet2 = new MethodDetails();
		HashMap<String, MethodDetails> methodhashmap = methoddet2.ReadClassesRepresentations2(conn);
		List<MethodDetails> methodlist = new ArrayList<MethodDetails>(methodhashmap.values());
		setMethodlist(methodlist);
		
///////////////////////////////////////////////////////////////////////////////////////
 LinkedHashMap<String, MethodDetails> linkedmethodhashmap = methoddet2.ReadClassesRepresentations2(conn);
List<MethodDetails> methodlistlinked = new ArrayList<MethodDetails>(linkedmethodhashmap.values());
setLinkedmethodhashmap(linkedmethodhashmap);
		///////////////////////////////////////////////////////////////////////////////////////
		ClassDetails2 classdet2 = new ClassDetails2();
		HashMap<Integer, ClassDetails2> classhashmap = classdet2.ReadClassesRepresentations(conn);
		List<ClassDetails2> classlist = new ArrayList<ClassDetails2>(classhashmap.values());
		///////////////////////////////////////////////////////////////////////////////////////

		ClassTrace2 myclasstrace2 = new ClassTrace2();
		HashMap<Integer, ClassTrace2> classtracehashmap = myclasstrace2.ReadClassesRepresentations(conn);
		List<ClassTrace2> classtraces = new ArrayList<ClassTrace2>(classtracehashmap.values());

		///////////////////////////////////////////////////////////////////////////////////////
//COMMENTED OUT CODE OLD CODE USED WHEN IT WAS SLOW 
//		MethodTrace2 methodtrace2 = new MethodTrace2();
//		HashMap<Integer, MethodTrace2> methodtracehashmap = methodtrace2.ReadClassesRepresentations(conn);
//		List<MethodTrace2> methodtraces = new ArrayList<MethodTrace2>(methodtracehashmap.values());
//		setMethodtraces2(methodtraces);
		
		//SWITCHED TO MethodTraceSubjectTSubjectN
		MethodTrace methodtrace2 = new MethodTrace();
		LinkedHashMap<String, MethodTrace> methodtracehashmap = methodtrace2.ReadMethodTraces(conn, ClassMethodsHashMap,FinalMethodHashMapReqGolds);
		List<MethodTrace> methodtraces = new ArrayList<MethodTrace>(methodtracehashmap.values());
		setMethodtraces2SubjectTSubjectN(methodtraces);
		setMethodtracehashmap(methodtracehashmap); 
		///////////////////////////////////////////////////////////////////////////////////////
		
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		/*ClassTrace2 classtrace2= new ClassTrace2(); 
		HashMap<Integer, ClassTrace2> classestraceshashmap = classtrace2.ReadClassesRepresentations(conn);
		List<ClassTrace2> classestraces = new ArrayList<ClassTrace2>(classestraceshashmap.values());
		setClassestraces2(classestraces);*/
		///////////////////////////////////////////////////////////////////////////////////////
		ClassTrace2 classtrace2= new ClassTrace2(); 
		classesRequirementtraceshashmap = classtrace2.ReadClassesRepresentationsRequirementClass(conn); 
		List<ClassTrace2> classestracesRequirementClass = new ArrayList<ClassTrace2>(classesRequirementtraceshashmap.values());
		setClassestraces2(classestracesRequirementClass);
		///////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////
		Interface2 myinterface2= new Interface2(); 
		interfacehashmapOwnerClass = myinterface2.ReadInterfacesRepresentations(conn);
//		List<Interface2>  myinterfaces = new ArrayList<Interface2>(interfacehashmapOwnerClass.values());
		setInterfacehashmapOwnerClass(interfacehashmapOwnerClass);
		///////////////////////////////////////////////////////////////////////////////////////
				
		///////////////////////////////////////////////////////////////////////////////////////
		interfacehashmapAlreadyImpl = myinterface2.ReadInterfacesRepresentationsAlreadyImpl(conn);
		setInterfaces(interfacehashmapAlreadyImpl);
		///////////////////////////////////////////////////////////////////////////////////////
		ClassField2 classfield= new ClassField2(); 
		 HashMap<String, List<ClassField2>> myclassfields = classfield.ReadClassFields(conn); 
		setClassFieldHashMap(myclassfields);
		///////////////////////////////////////////////////////////////////////////////////////
		MethodField2 methodfield= new MethodField2(); 
		 HashMap<String, List<MethodField2>> mymethodfields = methodfield.ReadMethodFields(conn); 
		setMethodFieldHashMap(mymethodfields);
		
		
		///////////////////////////////////////////////////////////////////////////////////////
		Parameter2 parameter= new Parameter2(); 
		 HashMap<String, List<Parameter2>> myparams = parameter.ReadParams(conn) ; 
		setParameterhashMap(myparams);
///////////////////////////////////////////////////////////////////////////////////////
		SuperClass2 superclass= new SuperClass2(); 
		 HashMap<String, List<SuperClass2>> mysuperclasses = superclass.ReadSuperClasses(conn);  
		setSuperclassesHashMap(mysuperclasses);
		/////////////////////////////////////////////
		
		
///////////////////////////////////////////////////////////////////////////////////////
Implementation2 myimplementation= new Implementation2(); 
HashMap<String, List<Implementation2>> myimplementations = myimplementation.ReadImplementationsRepresentations(conn); 
setINTERFACEHASHMAPFINAL(myimplementations);

///////////////////////////////////////////////////////////////////////////////////////
Children2 children2= new Children2(); 
HashMap<String, List<Children2>> mychildren = children2.ReadChildren(conn); 
setChildrenHashMap(mychildren);
/////////////////////////////////////////////




		System.out.println("MOUNA");
		System.out.println("MOUNA");
		/*String goldprediction=""; 
		for (MethodTrace2 tracemeth : methodtraces) {
			Requirement2 requirement = tracemeth.getRequirement();
			Method2Representation MethodRepresentation = tracemeth.getMethodRepresentation();
			String gold = tracemeth.getGold();
			for (Method2Details method : methodlist) {
				Method2Representation MethodRepresentation2 = method.getMethodrep();
				List<Method2Representation> Callees = method.calleesList;
				for (Method2Representation Callee : Callees) {
					if (Callee.methodid.equals(tracemeth.getMethodRepresentation().methodid)) {
						HashMap<Requirement2, MethodTrace2> methodtracesHash = method.getMethodtraces();
						List<MethodTrace2> methodtracesList = new ArrayList<MethodTrace2>(methodtracesHash.values());
						for (MethodTrace2 methtrace : methodtracesList) {
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
						HashMap<Requirement2, MethodTrace2> methodtracesHashCallers = method.getMethodtraces();
						List<MethodTrace2> methodtracesCallersList = new ArrayList<MethodTrace2>(
								methodtracesHashCallers.values());
						for (MethodTrace2 methtrace : methodtracesCallersList) {
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
		for (MethodTrace2 tracemeth : methodtraces) { 
			
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
				for (MethodTrace2 tracemeth2 : methodtraces) {
					
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
		for (MethodTrace2 tracemeth : methodtraces) {
			
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
				for (MethodTrace2 tracemeth2 : methodtraces) {
					
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
*/
		/*for (MethodTrace2 methtr : methodtraces2) {
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

	

	public static LinkedHashMap<String, MethodTrace> getMethodtracehashmap() {
		return methodtracehashmap;
	}

	

	public static void setInterfaces(HashMap ínterfacehashmap) {
		// TODO Auto-generated method stub
		DatabaseReading2Gantt.interfacehashmapAlreadyImpl=ínterfacehashmap;
		
	}
	

	public static HashMap  getInterfaces() {
		// TODO Auto-generated method stub
		return interfacehashmapAlreadyImpl;
		
	}

	public static void setClassesRequirementtraceshashmap(
			LinkedHashMap<String, ClassTrace2> classesRequirementtraceshashmap) {
		DatabaseReading2Gantt.classesRequirementtraceshashmap = classesRequirementtraceshashmap;
	}

	public static List<MethodTraceSubjectTSubjectNOriginal> getMethodtraces2() {
		return methodtraces2;
	}

	public static void setMethodtraces2(List<MethodTraceSubjectTSubjectNOriginal> methodtraces2) {
		DatabaseReading2Gantt.methodtraces2 = methodtraces2;
	}
	
	
	public static List<MethodTrace> getMethodtraces2SubjectTSubjectN() {
		return methodtraces2SubjectTSubjectN;
	}

	public static void setMethodtraces2SubjectTSubjectN(List<MethodTrace> methodtraces) {
		DatabaseReading2Gantt.methodtraces2SubjectTSubjectN = methodtraces;
	}

	public static LinkedHashMap<String, ClassTrace2> getClassesRequirementtraceshashmap() {
		return classesRequirementtraceshashmap;
	}

	public static HashMap<String, Interface2> getInterfacehashmapAlreadyImpl() {
		return interfacehashmapAlreadyImpl;
	}

	public static void setInterfacehashmapAlreadyImpl(HashMap<String, Interface2> interfacehashmapAlreadyImpl) {
		DatabaseReading2Gantt.interfacehashmapAlreadyImpl = interfacehashmapAlreadyImpl;
	}

	public static HashMap<String, List<Interface2>> getInterfacehashmapOwnerClass() {
		return interfacehashmapOwnerClass;
	}

	public static void setInterfacehashmapOwnerClass(HashMap<String, List<Interface2>> interfacehashmapOwnerClass) {
		DatabaseReading2Gantt.interfacehashmapOwnerClass = interfacehashmapOwnerClass;
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

	public static HashMap<String, List<SuperClass2>> getSuperclassesHashMap() {
		return SuperclassesHashMap;
	}

	public static void setSuperclassesHashMap(HashMap<String, List<SuperClass2>> superclassesHashMap) {
		SuperclassesHashMap = superclassesHashMap;
	}

	

	
	
	
	
	
}