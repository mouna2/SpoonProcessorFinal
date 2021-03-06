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

import ALGO.DatabaseInput;
import Chess.TracesTableChessFINALGeneticAlgorithm;
import Tables.CallerIDName;
import Tables.tracesmethods;
import Tables.tracesmethodscallees;
import mainPackage.ClassRepresentation;
import mypackage.ClassDetails2;
import mypackage.ClassTrace2;
import mypackage.MethodDetails;
import mypackage.Method;
import mypackage.MethodTraceSubjectTSubjectN;
import mypackage.MethodTraceSubjectTSubjectN;
import mypackage.Requirement;
import mypackage.RequirementGold;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.CtModel;
import spoon.reflect.factory.ClassFactory;

public class DatabaseReading2JHotDraw2 {
	public static HashMap<Integer, String> classesHashMap = new HashMap<Integer, String>();
	public static List<DatabaseInput> methodtraces2 = null;
	public static List<ClassTrace2> classestraces2 = null;
	public static List<MethodDetails> methodlist = null;
	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	public static List<MethodDetails> getMethodlist() {
		return methodlist;
	}

	public static void setMethodlist(List<MethodDetails> methodlist) {
		DatabaseReading2JHotDraw2.methodlist = methodlist;
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
		DatabaseReading2JHotDraw2.classestraces2 = classestraces2;
	}

	/**
	 * The name of the database we are testing with (this default is installed with
	 * MySQL)
	 */
	private final String dbName = "databasechess";

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
		DatabaseReading2JHotDraw2 DatabaseReading = new DatabaseReading2JHotDraw2();
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
		Requirement req = new Requirement();

		HashMap<String, Requirement> RequirementHashMap = req.ReadClassesRepresentations(conn);
		Set<String> keys2 = RequirementHashMap.keySet();
		for (String key : keys2) {
			System.out.println("Value of " + key + " is: " + RequirementHashMap.get(key).ID + "   "
					+ RequirementHashMap.get(key).RequirementName + "   ");
		}
		///////////////////////////////////////////////////////////////////////////////////////
		MethodDetails methoddet2 = new MethodDetails();
		HashMap<Integer, MethodDetails> methodhashmap = methoddet2.ReadClassesRepresentations(conn);
		List<MethodDetails> methodlist = new ArrayList<MethodDetails>(methodhashmap.values());
		setMethodlist(methodlist);
		///////////////////////////////////////////////////////////////////////////////////////
		ClassDetails2 classdet2 = new ClassDetails2();
		HashMap<Integer, ClassDetails2> classhashmap = classdet2.ReadClassesRepresentations(conn);
		List<ClassDetails2> classlist = new ArrayList<ClassDetails2>(classhashmap.values());
		///////////////////////////////////////////////////////////////////////////////////////

		ClassTrace2 myclasstrace2 = new ClassTrace2();
		HashMap<Integer, ClassTrace2> classtracehashmap = myclasstrace2.ReadClassesRepresentations(conn);
		List<ClassTrace2> classtraces = new ArrayList<ClassTrace2>(classtracehashmap.values());

		///////////////////////////////////////////////////////////////////////////////////////

		DatabaseInput MethodTraceSubjectTSubjectN = new DatabaseInput();
		HashMap<Integer, DatabaseInput> methodtracehashmap = MethodTraceSubjectTSubjectN.ReadClassesRepresentations(conn);
		List<DatabaseInput> methodtraces = new ArrayList<DatabaseInput>(methodtracehashmap.values());
		///////////////////////////////////////////////////////////////////////////////////////
		
		ClassTrace2 classtrace2= new ClassTrace2(); 
		HashMap<Integer, ClassTrace2> classestraceshashmap = classtrace2.ReadClassesRepresentations(conn);
		List<ClassTrace2> classestraces = new ArrayList<ClassTrace2>(classestraceshashmap.values());
		setClassestraces2(classestraces);
		///////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("MOUNA");
		/*String goldprediction=""; 
		for (MethodTraceSubjectTSubjectN tracemeth : methodtraces) {
			Requirement2 requirement = tracemeth.getRequirement();
			Method2Representation MethodRepresentation = tracemeth.getMethodRepresentation();
			String gold = tracemeth.getGold();
			for (Method2Details method : methodlist) {
				Method2Representation MethodRepresentation2 = method.getMethodrep();
				List<Method2Representation> Callees = method.calleesList;
				for (Method2Representation Callee : Callees) {
					if (Callee.methodid.equals(tracemeth.getMethodRepresentation().methodid)) {
						HashMap<Requirement2, MethodTraceSubjectTSubjectN> methodtracesHash = method.getMethodtraces();
						List<MethodTraceSubjectTSubjectN> methodtracesList = new ArrayList<MethodTraceSubjectTSubjectN>(methodtracesHash.values());
						for (MethodTraceSubjectTSubjectN methtrace : methodtracesList) {
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
						HashMap<Requirement2, MethodTraceSubjectTSubjectN> methodtracesHashCallers = method.getMethodtraces();
						List<MethodTraceSubjectTSubjectN> methodtracesCallersList = new ArrayList<MethodTraceSubjectTSubjectN>(
								methodtracesHashCallers.values());
						for (MethodTraceSubjectTSubjectN methtrace : methodtracesCallersList) {
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
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		String goldprediction=""; 
//		String GoldVal=""; 
//		for (MethodTraceSubjectTSubjectN tracemeth : methodtraces) { 
//			
//			for (Method2Details method : methodlist) {
//				List<Method2Representation> Callees = method.calleesList;
//				for (Method2Representation Callee : Callees) {
//					if (Callee.methodid.equals(tracemeth.getMethodRepresentation().methodid) ) {
//						
//							for(RequirementGold reqgoldCallee: Callee.getRequirementsGold()) {
//								if(reqgoldCallee.Requirement.ID.equals(tracemeth.Requirement.ID)) {
//									goldprediction="goldpredictionCaller"; 
//									GoldVal= reqgoldCallee.gold; 
//									methodtraces2 = tracemeth.getElement(methodtraces, method.methodrep.methodid,
//											GoldVal, goldprediction, tracemeth.getRequirement().ID);
//								}
//							}
//						
//						
//						
//				
//
//					}
//
//				}
//			}
//		}
//				 GoldVal=""; 
//				for (MethodTraceSubjectTSubjectN tracemeth2 : methodtraces) {
//					
//					for (Method2Details method2 : methodlist) {
//						List<Method2Representation> Callers = method2.callersList;
//						for (Method2Representation Caller : Callers) {
//							if (Caller.methodid.equals(tracemeth2.getMethodRepresentation().methodid) ) {
//								
//									for(RequirementGold reqgoldCaller: Caller.getRequirementsGold()) {
//										if(reqgoldCaller.Requirement.ID.equals(tracemeth2.Requirement.ID)) {
//											goldprediction="goldpredictionCallee"; 
//											GoldVal= reqgoldCaller.gold; 
//											methodtraces2 = tracemeth2.getElement(methodtraces, method2.methodrep.methodid,
//													GoldVal, goldprediction, tracemeth2.getRequirement().ID);
//										}
//									}
//								
//								
//								
//						
//
//							}
//
//						}
//
//			}
//
//		}
//		/***********************************************************************************************************************/
//		/***********************************************************************************************************************/
//		/***********************************************************************************************************************/
//		 GoldVal=""; 
//		for (MethodTraceSubjectTSubjectN tracemeth : methodtraces) {
//			
//			for (Method2Details method : methodlist) {
//				List<Method2Representation> CalleesExecuted = method.calleesListExecuted;
//				for (Method2Representation CalleeExecuted : CalleesExecuted) {
//					if (CalleeExecuted.methodid.equals(tracemeth.getMethodRepresentation().methodid) ) {
//						
//							for(RequirementGold reqgoldCallee: CalleeExecuted.getRequirementsGold()) {
//								if(reqgoldCallee.Requirement.ID.equals(tracemeth.Requirement.ID)) {
//									goldprediction="goldpredictionCaller"; 
//									GoldVal= reqgoldCallee.gold; 
//									methodtraces2 = tracemeth.getElement(methodtraces, method.methodrep.methodid,
//											GoldVal, goldprediction, tracemeth.getRequirement().ID);
//								}
//							}
//						
//						
//						
//				
//
//					}
//
//				}
//			}
//		}
//				 GoldVal=""; 
//				for (MethodTraceSubjectTSubjectN tracemeth2 : methodtraces) {
//					
//					for (Method2Details method2 : methodlist) {
//						List<Method2Representation> CallersExecuted = method2.callersListExecuted;
//						for (Method2Representation CallerExecuted : CallersExecuted) {
//							if (CallerExecuted.methodid.equals(tracemeth2.getMethodRepresentation().methodid) ) {
//								
//									for(RequirementGold reqgoldCaller: CallerExecuted.getRequirementsGold()) {
//										if(reqgoldCaller.Requirement.ID.equals(tracemeth2.Requirement.ID)) {
//											goldprediction="goldpredictionCallee"; 
//											GoldVal= reqgoldCaller.gold; 
//											methodtraces2 = tracemeth2.getElement(methodtraces, method2.methodrep.methodid,
//													GoldVal, goldprediction, tracemeth2.getRequirement().ID);
//										}
//									}
//								
//								
//								
//						
//
//							}
//
//						}
//
//			}
//
//		}

		for (DatabaseInput methtr : methodtraces2) {
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

	
	}

	public static List<DatabaseInput> getMethodtraces2() {
		return methodtraces2;
	}

	public static void setMethodtraces2(List<DatabaseInput> methodtraces2) {
		DatabaseReading2JHotDraw2.methodtraces2 = methodtraces2;
	}
	
	
	
	
}