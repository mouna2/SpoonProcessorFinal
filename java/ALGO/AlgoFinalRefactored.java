package ALGO;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.table.*;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.maven.model.Model;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Table;

import Chess.LogInfo;
import Chess.PredictionEvaluation;
import Gantt.DatabaseReading2Gantt;
import JHotDraw.DatabaseReading2JHotDraw3;
import iTrust.DatabaseReading2itrustfinal;
import mypackage.Children2;
import mypackage.ClassField2;
import mypackage.Clazz;
import mypackage.ClassTrace2;
import mypackage.ColumnGroup;
import mypackage.DatabaseReading2;
import mypackage.GroupableTableHeader;
import mypackage.Implementation2;
import mypackage.Interface2;
import mypackage.Method2Details;
import mypackage.Method;
import mypackage.MethodField2;
import mypackage.MethodTrace2;
import mypackage.MethodTrace;
import mypackage.Parameter2;
import mypackage.Requirement2;
import mypackage.RequirementGold;
import mypackage.SuperClass2;

public class AlgoFinalRefactored extends JFrame {

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException
	 *             If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(command); // This will throw a SQLException if it fails
			return true;
		} finally {

			// This will run whether we throw an exception or not
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	ResultSet rs = null;
	// Connect to MySQL

	PredictionEvaluation TotalPattern = new PredictionEvaluation();
	PredictionEvaluation RemainingPattern = new PredictionEvaluation();
	PredictionEvaluation NonOwnerClassPattern = new PredictionEvaluation();

	
	
	
	
	static List<MethodTrace> methodtraces = new ArrayList<MethodTrace>();
	HashMap<String, List<String>> classMethodsHashMap = new HashMap<String, List<String>>();
	static HashMap<String, MethodTrace> methodtraces2HashMap = new HashMap<String, MethodTrace>();
	LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass = new LinkedHashMap<String, ClassTrace2>();


	
	
	

	
	
	JTable table = new JTable();
	static List<Method2Details> methodlist = new ArrayList<Method2Details>();
	// File fout = new
	// File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\TableLog.txt");

	public final String userName = "root";
	public final String password = "123456";
	List<Method> CallerMethodListFinal = new ArrayList<Method>();
	List<Method> CalleeMethodListFinal = new ArrayList<Method>();

	public List<Method> getCallerMethodListFinal() {
		return CallerMethodListFinal;
	}

	public void setCallerMethodListFinal(List<Method> callerMethodListFinal) {
		CallerMethodListFinal = callerMethodListFinal;
	}

	public List<Method> getCalleeMethodListFinal() {
		return CalleeMethodListFinal;
	}

	public void setCalleeMethodListFinal(List<Method> calleeMethodListFinal) {
		CalleeMethodListFinal = calleeMethodListFinal;
	}

	public AlgoFinalRefactored(String ProgramName) throws Exception {

		LinkedHashMap<String, String> PredictionsOldHashMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> PredictionsNewHashMap = new LinkedHashMap<String, String>();

		int j = 0;
//		List<MethodTrace> methodtracesNew = InitializePredictionsHashMap2(methodtraces2);
		TracePredictionFunction(j, PredictionsOldHashMap, PredictionsNewHashMap, ProgramName);

	}

	

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/**
	 * @throws Exception **********************************************************************************************************************************************/

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public LinkedHashMap<String, String> TracePredictionFunction(int j,
			LinkedHashMap<String, String> PredictionsOldHashMap, LinkedHashMap<String, String> PredictionsNewHashMap,
			 String ProgramName) throws Exception {
		// TODO Auto-generated method stub

		DatabaseReading2 db = null;
		DatabaseReading2Gantt dbgantt = null;
		DatabaseReading2JHotDraw3 dbjhotdraw = null;
		DatabaseReading2itrustfinal dbitrust = null;
		BufferedWriter bwfile4 = null;
		BufferedWriter bwfile3 = null;
		BufferedWriter bwfile2 = null;
		BufferedWriter bwfileChess = null;

		BufferedWriter bwfileFP =null; 
		BufferedWriter bwfileFN =null; 
		BufferedWriter bwfile3Chess =null; 
		BufferedWriter bwfile3iTrust =null; 
		BufferedWriter bwfile3jHotDraw =null; 

		
		BufferedWriter bwfile1 = null;
		BufferedWriter bwTraceClass = null;
	

		if (ProgramName.equals("chess")) {
			File filelogChess = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\TableLogChess.txt");
			FileOutputStream fosfilChess = new FileOutputStream(filelogChess);
			bwfileChess = new BufferedWriter(new OutputStreamWriter(fosfilChess));
			
			File filelogFPChess = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\FalsePositiveDetailsChess.txt");
			FileOutputStream fosfilaFPChess = new FileOutputStream(filelogFPChess);
			 bwfile3Chess = new BufferedWriter(new OutputStreamWriter(fosfilaFPChess));
		}

		if (ProgramName.equals("gantt")) {
			File filelog2 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\TableLogGantt.txt");
			FileOutputStream fosfila2 = new FileOutputStream(filelog2);
			bwfile2 = new BufferedWriter(new OutputStreamWriter(fosfila2));
			
			File filelogFP = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\FalsePositiveDetailsGantt.txt");
			FileOutputStream fosfilaFP = new FileOutputStream(filelogFP);
			 bwfileFP = new BufferedWriter(new OutputStreamWriter(fosfilaFP));
		}

		if (ProgramName.equals("itrust")) {
			File filelog3 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\TableLogiTrust.txt");
			FileOutputStream fosfila5 = new FileOutputStream(filelog3);
			bwfile3 = new BufferedWriter(new OutputStreamWriter(fosfila5));
			
			File filelog3iTrust = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\FalsePositiveDetailsiTrust.txt");
			FileOutputStream fosfila5iTrust = new FileOutputStream(filelog3iTrust);
			bwfile3iTrust = new BufferedWriter(new OutputStreamWriter(fosfila5iTrust));
		}

		if (ProgramName.equals("jhotdraw")) {
			File filelog4 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\TableLogJHotDraw.txt");
			FileOutputStream fosfila4 = new FileOutputStream(filelog4);
			bwfile4 = new BufferedWriter(new OutputStreamWriter(fosfila4));
			
			File filelogFN = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\FalseNegativeDetailsJHotDraw.txt");
			FileOutputStream fosfilaFN = new FileOutputStream(filelogFN);
			 bwfileFN = new BufferedWriter(new OutputStreamWriter(fosfilaFN));
			 
			 File filelog3JHotDraw = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\FalsePositiveDetailsJHotDraw.txt");
				FileOutputStream fosfila5JHotDraw = new FileOutputStream(filelog3JHotDraw);
				bwfile3jHotDraw = new BufferedWriter(new OutputStreamWriter(fosfila5JHotDraw));
		}
		Collection<MethodTrace> MethodTracesHashmapValues = methodtraces2HashMap.values();
		// bwfile2.newLine();
		
		if (ProgramName.equals("chess")) {

			File file1log = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\PrecisionRecallChess.txt");
			FileOutputStream fosfila1 = new FileOutputStream(file1log);
			bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

			
			File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\TracesClassesChess.txt");
			FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
			bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
			
			System.out.println("yes");
			
			
		

		} else if (ProgramName.equals("gantt")) {

			File file1log = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\PrecisionRecallGantt.txt");
			FileOutputStream fosfila1 = new FileOutputStream(file1log);
			bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

			
			File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\TracesClassesGantt.txt");
			FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
			bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
			
			
		
		} else if (ProgramName.equals("jhotdraw")) {

			File file1log = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\PrecisionRecallJHotDraw.txt");
			FileOutputStream fosfila1 = new FileOutputStream(file1log);
			bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

			
			File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\TracesClassesJHotDraw.txt");
			FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
			bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
			
			
		
			
			
		} else if (ProgramName.equals("itrust")) {

			File file1log = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\PrecisionRecalliTrust.txt");
			FileOutputStream fosfila1 = new FileOutputStream(file1log);
			bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

			
			File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\TracesClassesiTrust.txt");
			FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
			bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
			
			
			

			
			
		}
		DatabaseReading DatabaseReading= new DatabaseReading(ProgramName); 
		
		methodtraces2HashMap = DatabaseReading.getMethodtracehashmap();
		methodtraces = DatabaseReading.getMethodtracesList(); 

		

		LinkedHashMap<String, LogInfo> LogInfoHashMap = new LinkedHashMap<String, LogInfo>();
		LinkedHashMap<String, LogInfo> LogHashMapRemaining = new LinkedHashMap<String, LogInfo>();
		LinkedHashMap<String, String> LogHashMapRemainingNewVals = new LinkedHashMap<String, String>();

		LinkedHashMap<String, String> RequirementClassHashMapNewValues = new LinkedHashMap<String, String>();
		MethodTracesHashmapValues = methodtraces2HashMap.values();


		
		
		PredictionValues TotalPredictionValues = new PredictionValues(); 
		PredictionValues RemainingpredictionValues = new PredictionValues(); 
		PredictionValues PredictionClassTraceBefore = new PredictionValues(); 
		PredictionValues PredictionClassTraceAfter = new PredictionValues(); 

		CountTracesClassesValues(PredictionClassTraceBefore, methodtracesRequirementClass, methodtraces2HashMap); 
		LogInfo log= new LogInfo(); 
		LogInfoHashMap=log.InitializeLogInfoHashMap(LogInfoHashMap,MethodTracesHashmapValues, methodtraces2HashMap ); 

		bwTraceClass.write("BEFORE PATTERN 0 "+PredictionClassTraceBefore.toString());
		bwTraceClass.newLine();

		RequirementClassHashMapNewValues = GenerateNewValuesInTracesClasses(RequirementClassHashMapNewValues, methodtracesRequirementClass);
		CountTracesClassesValues(PredictionClassTraceAfter, methodtracesRequirementClass, methodtraces2HashMap); 

		bwTraceClass.write("AFTER PATTERN 0 "+PredictionClassTraceAfter.toString());
		bwTraceClass.close();
		j = 0;
		LogInfoHashMap=log.InitializeLogInfoHashMapTraceClassNewValue(LogInfoHashMap,MethodTracesHashmapValues, methodtraces2HashMap ); 

//		LogInfoHashMap = IntroduceNewValuesWithinLogInfoHashMap(RequirementClassHashMapNewValues, classMethodsHashMap,LogInfoHashMap);
	
		MethodTracesHashmapValues = methodtraces2HashMap.values();
		LogInfoHashMap=InitializeHashMapWithPrecisionRecall(MethodTracesHashmapValues, LogInfoHashMap);
	
		

	
		
		
		//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// OWNER CLASS PATTERN
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
	int counter=0;
		for (MethodTrace methodtrace : MethodTracesHashmapValues) {

//			if *methodtrace.method.owner.getGold*()=N methodtrace.Method.setPrediction N
					
					
					
					
					
			String reqMethod = methodtrace.Requirement.getID() + "-" + methodtrace.getMethod().ID;
			
			
		
			if (methodtrace.Method.owner.DeveloperGold != null) {
				
			
				
				if (methodtrace.Method.owner.DeveloperGold.equals("T") ) {
						
					//DO NOTHING 
					
				

				} else if (methodtrace.Method.owner.DeveloperGold.equals("N")) {
					methodtrace.SetPredictionOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, "N", methodtraces2HashMap); 
					
					
				}

				else {

					//DO NOTHING 
				}
			

		
			
			
		}
		}
		System.out.println(counter);
		LinkedHashMap<String, MethodTrace> MyfinalHashMap = RetrievePredictionsHashMap(methodtraces);
		SetSubjectGoldDeveloperGoldEqualityFlag(methodtraces2HashMap, TotalPattern, LogInfoHashMap, ProgramName); 
		 PredictionValues OwnerClassPredictionValues = new PredictionValues(); 
			PrecisionRecall PrecisionRecall= new PrecisionRecall(); 

			PrecisionRecall.ComputePrecisionAndRecall(methodtraces2HashMap,TotalPattern, ProgramName, OwnerClassPredictionValues);
		 bwfile1.write("OWNER CLASS PRED 				"+ProgramName+" "+TotalPattern.toString());
		 bwfile1.newLine();
		 bwfile1.write("owner class prediction values	"+ProgramName+" "+OwnerClassPredictionValues.toString());
		 bwfile1.newLine();
		
		

		int ITERATION = 0;
		MethodTracesHashmapValues=methodtraces2HashMap.values(); 

		
		PredictionsNewHashMap = InitializePredictionsHashMap(PredictionsNewHashMap, MethodTracesHashmapValues);
		
		

//		 LogHashMapRemaining = new LinkedHashMap<String, LogInfo>();
//		LogHashMapRemaining=InitializeHashMapWithPrecisionRecallRemaining(MethodTracesHashmapValues, LogHashMapRemaining, LogInfoHashMap); 
		
		while (Equals(PredictionsOldHashMap, PredictionsNewHashMap) == false) {

			PredictionsOldHashMap = InitializePredictionsHashMap(PredictionsOldHashMap, MethodTracesHashmapValues);

			////////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// PURE AND MIXED PATTERNS	PATTERN 1-2
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////

			//////////////////////////////////////////////////////////////////////////////////////////
			int k = 0;
			

			MethodTracesHashmapValues=methodtraces2HashMap.values(); 
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// PURE PATTERNS
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			for (MethodTrace methodtrace : MethodTracesHashmapValues) {
				String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.getMethod().ID;
			


				// PURE T PATTERN


				if (    !methodtrace.getMethod().getCallees().isEmpty() && !methodtrace.getMethod().getCallers().isEmpty()
						&& methodtrace.Method.getCallees().AllTs(methodtrace.Requirement, methodtraces2HashMap)
						&& methodtrace.getMethod().getCallers().AllTs(methodtrace.Requirement, methodtraces2HashMap)					
						

				) {
					methodtrace.SetPredictionNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
							LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,PureT", methodtraces2HashMap); 

					

				}
				// PURE N PATTERN
				else if ( !methodtrace.getMethod().getCallees().isEmpty() && !methodtrace.getMethod().getCallers().isEmpty()
						&& methodtrace.getMethod().getCallees().AllNs(methodtrace.Requirement, methodtraces2HashMap)
						&& methodtrace.getMethod().getCallers().AllNs(methodtrace.Requirement, methodtraces2HashMap)

				) {
					methodtrace.SetPredictionNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
							LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "N", "N,PureN", methodtraces2HashMap); 
				

				}

				 
				// PURE T LEAF PATTERN
				 if (	methodtrace.getMethod().getCallees().isEmpty() && !methodtrace.getMethod().getCallers().isEmpty()
						 && methodtrace.getMethod().getCallers().AllTs(methodtrace.Requirement,methodtraces2HashMap)

				) {
					 methodtrace.SetPredictionNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,PureTLeaf", methodtraces2HashMap); 

				}
				// PURE N LEAF PATTERN
				 else if (methodtrace.getMethod().getCallees().isEmpty() && !methodtrace.getMethod().getCallers().isEmpty()
						 && methodtrace.getMethod().getCallers().AllNs(methodtrace.Requirement, methodtraces2HashMap)

				) {

					 methodtrace.SetPredictionNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "N", "N,PureNLeaf", methodtraces2HashMap); 
				}

				
				k++;

			}

			k = 0;
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// MIXED PATTERNS
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			for (MethodTrace methodtrace : MethodTracesHashmapValues) {
				String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.getMethod().ID;
				//System.out.println();

				// MIXED T PATTERN
				 if (!methodtrace.getMethod().getCallees().isEmpty() && !methodtrace.getMethod().getCallers().isEmpty() 
					&& methodtrace.getMethod().getCallees().AtLeast1T(methodtrace.Requirement, methodtraces2HashMap) 
					&& methodtrace.getMethod().getCallers().AtLeast1T(methodtrace.Requirement, methodtraces2HashMap) 

				) {
					 methodtrace.SetPredictionNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,MixedT", methodtraces2HashMap); 

				}
				// MIXED N PATTERN
				 else if (!methodtrace.getMethod().getCallees().isEmpty() && !methodtrace.getMethod().getCallers().isEmpty()
						
						&& methodtrace.getMethod().getCallees().AllNs(methodtrace.Requirement, methodtraces2HashMap) 
						&& methodtrace.getMethod().getCallers().AllNs(methodtrace.Requirement, methodtraces2HashMap) 
						

				) {

					 methodtrace.SetPredictionNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "N", "N,MixedN", methodtraces2HashMap); 

				}
				

				
				 
				// MIXED T LEAF PATTERN
				 if (methodtrace.getMethod().getCallees().isEmpty() && !methodtrace.getMethod().getCallers().isEmpty() 
						 && methodtrace.getMethod().getCallers().AtLeast1T(methodtrace.Requirement, methodtraces2HashMap) 

				) {
					 methodtrace.SetPredictionNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,MixedTLeaf", methodtraces2HashMap); 

				}// MIXED N LEAF PATTERN
				 else if(methodtrace.getMethod().getCallees().isEmpty() && !methodtrace.getMethod().getCallers().isEmpty() 
						 && methodtrace.getMethod().getCallers().AllNs(methodtrace.Requirement, methodtraces2HashMap) 

				) {
					 methodtrace.SetPredictionNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "N", "N,MixedNLeaf", methodtraces2HashMap); 

				}
				k++;
			}
			
			// PRINT

			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
			//the following line should not be moved when putting 3 before 1-2 (3-1-2 combination)
			MyfinalHashMap = RetrievePredictionsHashMap(methodtraces);
			
			// END PRINT
			
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// SUPERCLASSES , CHILDREN , INTERFACES , IMPLEMENTATIONS  PATTERN 3
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			
			for (MethodTrace methodtrace : MethodTracesHashmapValues) {
				String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.Method.ID;

			
					
					if (
							methodtrace.getMethod().getInterfaces().AllTs(methodtrace.Requirement,methodtraces2HashMap)
							||methodtrace.getMethod().getImplementations().AllTs(methodtrace.Requirement,methodtraces2HashMap)
							||methodtrace.getMethod().getSuperclasses().AllTs(methodtrace.Requirement,methodtraces2HashMap)
							||methodtrace.getMethod().getChildren().AllTs(methodtrace.Requirement,methodtraces2HashMap)
							
							)
							
						

					{

						
						
						 methodtrace.SetPredictionNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
									LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,AllTInheritance", methodtraces2HashMap); 

					}
					else if (
							
							methodtrace.getMethod().getInterfaces().AllNs(methodtrace.Requirement,methodtraces2HashMap)
							||methodtrace.getMethod().getImplementations().AllNs(methodtrace.Requirement,methodtraces2HashMap)
							||methodtrace.getMethod().getSuperclasses().AllNs(methodtrace.Requirement,methodtraces2HashMap)
							||methodtrace.getMethod().getChildren().AllNs(methodtrace.Requirement,methodtraces2HashMap)

					)

					{
						
						
						 methodtrace.SetPredictionNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
									LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining,"N", "N,AllNInheritance", methodtraces2HashMap); 
					
						 //DEBUGGING PURPOSES 
//						 if(methodtrace.getGoldfinal().equals("T") && methodtrace.Method.owner.DeveloperGold.equals(methodtrace.Method.owner.SubjectGold)) {
//								System.out.println("fullmethodname   "+methodtrace.Method.fullmethodname+" Requirement  "+methodtrace.Requirement.ID+" DeveloperGold "+methodtrace.getGoldfinal()+" Prediction "+methodtrace.getPrediction()+"   gold final  "+methodtrace.getGoldfinal());
//								if(methodtrace.getMethod().getInterfaces().AllNs(methodtrace.Requirement,methodtraces2HashMap)){
//									System.out.println("interfaces");
//									System.out.println(methodtrace.getMethod().getInterfaces());
//									System.out.println();
//								}
//								if(methodtrace.getMethod().getImplementations().AllNs(methodtrace.Requirement,methodtraces2HashMap)) {
//									System.out.println("implementations");
//									System.out.println(methodtrace.getMethod().getImplementations());
//									System.out.println();
//
//								}
//								if(methodtrace.getMethod().getSuperclasses().AllNs(methodtrace.Requirement,methodtraces2HashMap)) {
//									System.out.println("superclasses");
//									System.out.println(methodtrace.getMethod().getSuperclasses());
//									System.out.println();
//
//
//								}
//								if(methodtrace.getMethod().getChildren().AllNs(methodtrace.Requirement,methodtraces2HashMap)) {
//									System.out.println("children");
//									System.out.println(methodtrace.getMethod().getChildren());
//									System.out.println();
//
//								}
//							}
					
					}

			}
	
			
			
			
			
			
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
				

					
				
			
	

				
			
			

		
		
				

		
				
				

			
		
			
			
				
				
			
				System.out.println("yes");
				

				
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// ALL CALLERS PATTERN 4.1
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
				
				
			for (MethodTrace methodtrace : MethodTracesHashmapValues) {
				String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.getMethod().ID;
				//System.out.println();
				
				
			
			
				
				// ALL T CALLERS 
				 if (!methodtrace.getMethod().getCallers().isEmpty() 
					&& methodtrace.getMethod().getCallers().AllTs(methodtrace.Requirement, methodtraces2HashMap) 
					

				) {
					 methodtrace.SetPredictionNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,AllTCallers", methodtraces2HashMap); 

				}
				// ALL N CALLERS
				 else if (!methodtrace.getMethod().getCallers().isEmpty() 
							&& methodtrace.getMethod().getCallers().AllNs(methodtrace.Requirement, methodtraces2HashMap) 
							

						) {

					 methodtrace.SetPredictionNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "N", "N,AllNCallers", methodtraces2HashMap); 


				}
				

				
				 
			
				
			}
				
			
			
			
			
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				//ALL CALLEES PATTERN 5
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
			
			for (MethodTrace methodtrace : MethodTracesHashmapValues) {
				String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.getMethod().ID;
				
				
				
				
				
				
				
				
				
				
				
				//ALL T CALLEES 
				if (!methodtrace.getMethod().getCallees().isEmpty() 
				&& methodtrace.getMethod().getCallees().AllTs(methodtrace.Requirement, methodtraces2HashMap) 
				
				
				) {
				methodtrace.SetPredictionNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
				LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,AllTCallees", methodtraces2HashMap); 
				
				
				}
				//ALL N CALLEES
				else if (!methodtrace.getMethod().getCallees().isEmpty() 
				&& methodtrace.getMethod().getCallees().AllNs(methodtrace.Requirement, methodtraces2HashMap) 
				
				
				) {
				
				methodtrace.SetPredictionNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
				LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "N", "N,AllNCallees", methodtraces2HashMap); 
				
				
				}
				k++;
				}	
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// END PATTERNS 
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			
			
			
			
			
			
			
			
			
			
			// PRINT
			SetLogFileIterations(MethodTracesHashmapValues, methodtraces, LogInfoHashMap, ITERATION); 
			
			MyfinalHashMap = RetrievePredictionsHashMap(methodtraces);

			// END PRINT
			ITERATION++;

			PredictionsNewHashMap = InitializePredictionsHashMap(PredictionsNewHashMap, MethodTracesHashmapValues);
		}
		
		
		
		
		
		
		//SET EVERYTHING ELSE TO T IF THE OWNER CLASS IS T 
		for (MethodTrace methodtrace : MethodTracesHashmapValues) {
			String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.Method.ID;
			
			if( methodtrace.getPrediction().equals("E") && methodtrace.Method.owner.DeveloperGold.equals("T") ) {
				LogInfo loginfo = LogInfoHashMap.get(reqMethod); 
				
				methodtrace.SetPredictionNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
						LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,Remaining", methodtraces2HashMap); 
				LogInfoHashMap.put(reqMethod, loginfo); 
			}
			
			
		}
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	
	
	Set<Entry<String, LogInfo>> remainingvals = LogHashMapRemaining.entrySet(); 
	Set<Entry<String, LogInfo>> logvals = LogInfoHashMap.entrySet(); 
	

//	LinkedHashMap<String, LogInfo> LogHashMapRemaining3 = SetFlagRemainingPattern(LogHashMapRemaining, RemainingPattern, ProgramName, LogHashMapRemaining); 

		
		
		LogInfoHashMap=SetFlagTotalPattern(LogInfoHashMap, RemainingPattern, ProgramName); 
		System.out.println("RemainingpredictionValues"+RemainingpredictionValues);
		PrecisionRecall.ComputePrecisionAndRecall(methodtraces2HashMap, RemainingPattern, ProgramName, RemainingpredictionValues);
		System.out.println("RemainingpredictionValues"+TotalPattern);

		//		WriteInDatabaseAndComputePrecisionAndRecall(methodtraces2, RemainingPattern, LogHashMapRemaining, ProgramName);
		//System.out.println("here 2");
	
		ResetAllTraceSetFlags(methodtraces2HashMap);  
		 TotalPredictionValues = new PredictionValues(); 
//		WriteInDatabaseAndComputePrecisionAndRecall(methodtraces2, TotalPattern, LogInfoHashMap, ProgramName, TotalPredictionValues);
		 TotalPattern = new PredictionEvaluation();
		PrecisionRecall.ComputePrecisionAndRecall(methodtraces2HashMap, TotalPattern, ProgramName, TotalPredictionValues);
		 RemainingpredictionValues = new PredictionValues(); 
		
		RemainingpredictionValues=SubstractPredictionValues(TotalPredictionValues, OwnerClassPredictionValues); 

		//System.out.println("===============>PATTERNS 2 AND 4 ITERATION SET TO T   ITERATION  " + ITERATION+ "   PREDICTION VALUES " + RemainingPattern.toString());
		bwfile1.write("NON OWNER CLASS PREDICTION 		"+ProgramName+" "+RemainingPattern.toString());
		bwfile1.newLine();
		bwfile1.write("Remaining Prediction Values 	"+ProgramName+" "+RemainingpredictionValues.toString());
		bwfile1.newLine();
		
		
		bwfile1.write("TOTAL PREDICTION 				"+ProgramName+" "+TotalPattern.toString());
		bwfile1.newLine();
		bwfile1.write("Prediction Values 				"+ProgramName+" "+TotalPredictionValues.toString());
		bwfile1.close();
		if (ProgramName.equals("chess")) {
			bwfileChess.write(
					"MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, TraceValue, TraceClassOldValue, TraceClassNewValue, OwnerClassPrediction, PrecisionRecall, IterationValues");
			bwfileChess.newLine();
		}
		if (ProgramName.equals("gantt")) {
			bwfile2.write(
					"MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, TraceValue,TraceClassOldValue,TraceClassNewValue,  OwnerClassPrediction, PrecisionRecall, IterationValues");
			bwfile2.newLine();
		}
		if (ProgramName.equals("itrust")) {
			bwfile3.write(
					"MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, TraceValue,TraceClassOldValue, TraceClassNewValue, OwnerClassPrediction, PrecisionRecall, IterationValues");
			bwfile3.newLine();
		}
		if (ProgramName.equals("jhotdraw")) {
			bwfile4.write(
					"MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, TraceValue,TraceClassOldValue, TraceClassNewValue, OwnerClassPrediction, PrecisionRecall, IterationValues");
			bwfile4.newLine();
		}

		PredictionsNewHashMap = InitializePredictionsHashMap(PredictionsNewHashMap, methodtraces);
		 counter=0; 
		for (MethodTrace methodtrace : MethodTracesHashmapValues) {
			System.out.println(counter);
			String reqmethod = methodtrace.Requirement.ID + "-" + methodtrace.Method.ID;
			LogInfoHashMap.get(reqmethod);
			
			if (ProgramName.equals("gantt")) {
				bwfile2.write(LogInfoHashMap.get(reqmethod).toString());
				bwfile2.newLine();
				
				if(LogInfoHashMap.get(reqmethod).PrecisionRecall.equals("FP")) {
					bwfileFP.write(LogInfoHashMap.get(reqmethod).toString());
					bwfileFP.newLine();
				}
				
			}
			if (ProgramName.equals("chess")) {
				bwfileChess.write(LogInfoHashMap.get(reqmethod).toString());
				bwfileChess.newLine();
				counter++; 
				
				if(LogInfoHashMap.get(reqmethod).PrecisionRecall.equals("FP")) {
					bwfile3Chess.write(LogInfoHashMap.get(reqmethod).toString());
					bwfile3Chess.newLine();
				}
			}
			if (ProgramName.equals("itrust")) {
				bwfile3.write(LogInfoHashMap.get(reqmethod).toString());
				bwfile3.newLine();
				
				if(LogInfoHashMap.get(reqmethod).PrecisionRecall.equals("FP")) {
					bwfile3iTrust.write(LogInfoHashMap.get(reqmethod).toString());
					bwfile3iTrust.newLine();
				}
			}
			if (ProgramName.equals("jhotdraw")) {
				bwfile4.write(LogInfoHashMap.get(reqmethod).toString());
				bwfile4.newLine();
				
				
				
				if(LogInfoHashMap.get(reqmethod).PrecisionRecall.equals("FN")) {
					bwfileFN.write(LogInfoHashMap.get(reqmethod).toString());
					bwfileFN.newLine();
				}
				
				if(LogInfoHashMap.get(reqmethod).PrecisionRecall.equals("FP")) {
					bwfile3jHotDraw.write(LogInfoHashMap.get(reqmethod).toString());
					bwfile3jHotDraw.newLine();
				}
			}
		}

		if (ProgramName.equals("chess")) {
			bwfileChess.close();
			bwfile3Chess.close();
		} else if (ProgramName.equals("gantt")) {
			bwfile2.close();
			bwfileFP.close();
			

		} else if (ProgramName.equals("itrust")) {
			bwfile3.close();
			bwfile3iTrust.close(); 
		} else if (ProgramName.equals("jhotdraw")) {
			bwfile4.close();
			bwfileFN.close();
			bwfile3jHotDraw.close();

		}
		return PredictionsNewHashMap;
	}
	
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	public void SetLogFileIterations(Collection<MethodTrace> methodTracesHashmapValues, List<MethodTrace> methodtraces22, LinkedHashMap<String, LogInfo> LogInfoHashMap, int ITERATION ) {
		// TODO Auto-generated method stub
		for (MethodTrace methodtrace : methodTracesHashmapValues) {
			String ReqMethod = methodtrace.Requirement.ID + "-" + methodtrace.Method.ID;
			LogInfo LogInfo = LogInfoHashMap.get(ReqMethod);
			List<String> myits = LogInfo.getIterationValues();
			if (myits.size() == ITERATION + 1) {
				//System.out.println(myits.get(ITERATION));

			} else {
				myits.add(" ");
				LogInfo.setIterationValues(myits);
			}

			for (String it : myits) {
				//System.out.println("it" + it + " it");
			}
			LogInfoHashMap.put(ReqMethod, LogInfo);
		}
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	public PredictionValues SubstractPredictionValues(PredictionValues totalPredictionValues,
			PredictionValues ownerClassPredictionValues) {
			
		int totalT = totalPredictionValues.T; 
		int totalN=totalPredictionValues.N; 
		int totalE=totalPredictionValues.E;
		
		int ownerT=ownerClassPredictionValues.T; 
		int ownerN=ownerClassPredictionValues.N; 
		int ownerE=ownerClassPredictionValues.E; 

		
		int remainingT= totalT-ownerT; 
		int remainingN= totalN-ownerN;
		int remainingE= totalE-ownerE;
		PredictionValues RemainingPredictionValues= new PredictionValues(); 
		RemainingPredictionValues.setT(remainingT);
		RemainingPredictionValues.setN(remainingN);
		RemainingPredictionValues.setE(totalE);
				return RemainingPredictionValues;
		// TODO Auto-generated method stub
		
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	public void ResetAllTraceSetFlags(HashMap<String, MethodTrace> methodtraces2HashMap2) {
		// TODO Auto-generated method stub
		
		for(String key: methodtraces2HashMap2.keySet()) {
			MethodTrace MethodTrace = methodtraces2HashMap2.get(key); 
			MethodTrace.setTraceSet(false);
		}
		
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	
	/************************************************************************************************************************************************/
	/**
	 * @param methodtraces2HashMap2 **********************************************************************************************************************************************/
	public void CountTracesClassesValues(PredictionValues PredictionClassTraceBefore, LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass2, HashMap<String, MethodTrace> methodtraces2HashMap2) {
		// TODO Auto-generated method stub
		HashMap<String, String> myhashmap= new HashMap<String, String> (); 
		
		for(String mykey: methodtraces2HashMap2.keySet()) {
			String reqClass= methodtraces2HashMap2.get(mykey).Requirement.ID+"-"+methodtraces2HashMap2.get(mykey).Clazz.ID; 
			myhashmap.put(reqClass, methodtraces2HashMap2.get(mykey).Method.owner.DeveloperGold);
		
		}
		
		
		
		
			for(String mykey: myhashmap.keySet()) {
				 String value = myhashmap.get(mykey); 
				
				PredictionClassTraceBefore.ComputePredictionValues(PredictionClassTraceBefore,value);
			}
		
		
		
		
	}
	
	
	

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	private LinkedHashMap<String, LogInfo> InitializeHashMapWithPrecisionRecall(
			Collection<MethodTrace> methodTracesHashmapValues, LinkedHashMap<String, LogInfo> logHashMapRemaining) {
		// TODO Auto-generated method stub
		
		for (MethodTrace methodtrace : methodTracesHashmapValues) {
			
			String reqID= methodtrace.getRequirement().ID; 
			String methodID= methodtrace.getMethod().ID; 
			String key= reqID+"-"+methodID; 
			//System.out.println("Key "+ key);
			
		}
	
		return logHashMapRemaining;
	}
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	
	
	

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	private LinkedHashMap<String, LogInfo> IntroduceNewValuesWithinLogInfoHashMap(
			LinkedHashMap<String, String> requirementClassHashMapNewValues,
			HashMap<String, List<String>> classMethodsHashMap2, LinkedHashMap<String, LogInfo> logInfoHashMap) {
		// TODO Auto-generated method stub

		for (Entry<String, String> entry : requirementClassHashMapNewValues.entrySet()) {
			String ReqClass = entry.getKey();
			String[] splitted = ReqClass.split("-");
			String ReqID = splitted[0];
			String ClassID = splitted[1];

			String NewValue = entry.getValue();

			List<String> MethodListIds = classMethodsHashMap.get(ClassID);

			for (String MethodID : MethodListIds) {
				LogInfo log = new LogInfo();
				log.setTraceClassNewValue(NewValue);
				String key = ReqID + "-" + MethodID;
				logInfoHashMap.put(key, log);
			}
		}
		return logInfoHashMap;
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/**
	 * @param requirementClassHashMapNewValues
	 * @param methodtracesRequirementClass2 
	 * @return
	 **********************************************************************************************************************************************/

	private LinkedHashMap<String, String> GenerateNewValuesInTracesClasses(
			LinkedHashMap<String, String> requirementClassHashMapNewValues, LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass2) {
		// TODO Auto-generated method stub
		int j = 0;
		Collection<MethodTrace> MethodTracesHashmapValues = methodtraces2HashMap.values();

		for (MethodTrace methodtrace : MethodTracesHashmapValues) {

			String reqclass = methodtrace.Requirement.getID() + "-" + methodtrace.Clazz.ID;
			ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);

			// PATTERN 1
			
			MethodList children = methodtrace.Method.Children; 
			MethodList parents = methodtrace.Method.Superclasses; 
			MethodList implementations = methodtrace.Method.implementations; 
			MethodList interfaces = methodtrace.Method.Interfaces; 
			List<String> ChilrenGold= new ArrayList<String>(); 
			List<String> ParentsGold= new ArrayList<String>(); 
			List<String> ImplementationsGold= new ArrayList<String>(); 
			List<String> InterfacesGold= new ArrayList<String>(); 
			for(Method child:children) {
				String ChildGold = child.owner.DeveloperGold; 
				ChilrenGold.add(ChildGold); 
			}
			
			
			for(Method parent:parents) {
				String ParentGold = parent.owner.DeveloperGold; 
				ParentsGold.add(ParentGold); 
			}
			for(Method myinterface:interfaces) {
				String InterfaceGold = myinterface.owner.DeveloperGold; 
				InterfacesGold.add(InterfaceGold); 

			}
			for(Method implementation:implementations) {
				String ImplementationGold = implementation.owner.DeveloperGold; 
				ImplementationsGold.add(ImplementationGold); 
			}
			
			
			
			if(methodtrace.Method.owner.DeveloperGold.equals("E") ) {
				if(!ImplementationsGold.contains("N") && !ImplementationsGold.contains("E")  &&  ImplementationsGold.contains("T") && !ImplementationsGold.isEmpty()) {
					methodtrace.Method.owner.setDeveloperGold("T");
				}else if(!InterfacesGold.contains("N") && !InterfacesGold.contains("E")  &&  InterfacesGold.contains("T") && !InterfacesGold.isEmpty()) {
					methodtrace.Method.owner.setDeveloperGold("T");

				}else if(!ParentsGold.contains("N") && !ParentsGold.contains("E")  &&  ParentsGold.contains("T") && !ParentsGold.isEmpty()) {
					methodtrace.Method.owner.setDeveloperGold("T");

				}else if(!ChilrenGold.contains("N") && !ChilrenGold.contains("E")  &&  ChilrenGold.contains("T") && !ChilrenGold.isEmpty()) {
					methodtrace.Method.owner.setDeveloperGold("T");

				}
				
				
				 if(!ImplementationsGold.contains("T") && !ImplementationsGold.contains("E") && ImplementationsGold.contains("N") && !ImplementationsGold.isEmpty()) {
					methodtrace.Method.owner.setDeveloperGold("N");
				}else if(!InterfacesGold.contains("T") && !InterfacesGold.contains("E")&& InterfacesGold.contains("N") && !InterfacesGold.isEmpty()) {
					methodtrace.Method.owner.setDeveloperGold("N");

				}else if(!ParentsGold.contains("T") && !ParentsGold.contains("E")&& ParentsGold.contains("N") &&  !ParentsGold.isEmpty()) {
					methodtrace.Method.owner.setDeveloperGold("N");

				}else if(!ChilrenGold.contains("T") && !ChilrenGold.contains("E")&&  !ChilrenGold.contains("N") && !ChilrenGold.isEmpty()) {
					methodtrace.Method.owner.setDeveloperGold("N");

				}
			}
			
		}
		return requirementClassHashMapNewValues;
	}
	
	
	
	
	
	
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/**
	 * @param logInfoHashMap 
	 * @param programName **********************************************************************************************************************************************/
	public void SetSubjectGoldDeveloperGoldEqualityFlag(HashMap<String, MethodTrace> methodTraceHashMap,
			PredictionEvaluation nEWPATTERNMethodFields2, LinkedHashMap<String, LogInfo> logInfoHashMap, String programName) {
		for (String mykey : methodTraceHashMap.keySet()) {
			 LogInfo loginfo = logInfoHashMap.get(mykey);
			MethodTrace methodtraceValue = methodTraceHashMap.get(mykey); 
			if( programName.equals("gantt")||programName.equals("jhotdraw") ) {
				if (methodtraceValue.Method.owner.DeveloperGold.equals(methodtraceValue.Method.owner.SubjectGold) ) {
					loginfo.setSubjectDeveloperEqualityFlag(true);
					logInfoHashMap.put(mykey, loginfo); 
					
					
					System.out.println(mykey);
					MethodTrace methodtrace = methodTraceHashMap.get(mykey); 
					methodtrace.setMyflag(true);
					methodtrace.setSubjectDeveloperEqualityFlag(true);
					methodTraceHashMap.put(mykey, methodtrace); 
				}
			}
			

		}
		
	}
	
	
	
	
	
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/**
	 * @param logHashMapRemaining2 **********************************************************************************************************************************************/
	public LinkedHashMap<String, LogInfo> SetFlagTotalPattern(LinkedHashMap<String, LogInfo> loginfohash,
			PredictionEvaluation nEWPATTERNMethodFields2, String programName) {
		for (String mykey : loginfohash.keySet()) {
			 LogInfo loginfo = loginfohash.get(mykey);
			 //System.out.println("mykey "+mykey);
			if(programName.equals("gantt")||programName.equals("jhotdraw")){
				//System.out.println("loginfo.getGoldFinal()  "+loginfo.getGoldFinal()+"loginfo.getSubjectGold()  "+loginfo.getSubjectGold());
				if (loginfo.getGoldFinal().equals(loginfo.getSubjectGold()))  {
				loginfo.setSubjectDeveloperEqualityFlag(true);
				loginfohash.put(mykey, loginfo); 
				
			}
			}
				

		}
		return loginfohash;
	}
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/**
	 * @param logHashMapRemaining2 **********************************************************************************************************************************************/
	public LinkedHashMap<String, LogInfo> SetFlagRemainingPattern(LinkedHashMap<String, LogInfo> loginfohash,
			PredictionEvaluation nEWPATTERNMethodFields2, String programName, LinkedHashMap<String, LogInfo> logHashMapRemaining2) {
		for (String mykey : loginfohash.keySet()) {
			 LogInfo loginfo = loginfohash.get(mykey);
			 //System.out.println("mykey "+mykey);
			if(programName.equals("gantt")||programName.equals("jhotdraw")){
				//System.out.println("loginfo.getGoldFinal()  "+loginfo.getGoldFinal()+"loginfo.getSubjectGold()  "+loginfo.getSubjectGold());
			
				
				if (loginfo.getGoldFinal().equals(loginfo.getSubjectGold()) && loginfo.getPrediction()!=null)  {
				loginfo.setSubjectDeveloperEqualityFlag(true);
				logHashMapRemaining2.put(mykey, loginfo); 
				
			}
			}
				

		}
		return logHashMapRemaining2;
	}
	

	

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/

	public LinkedHashMap<String, String> InitializePredictionsHashMap(
			LinkedHashMap<String, String> predictionsOldHashMap,
			Collection<MethodTrace> methodtraces22) {
		// TODO Auto-generated method stub

		for (MethodTrace methodtrace : methodtraces22) {
			String RequirementID = methodtrace.Requirement.ID;
			String MethodID = methodtrace.Method.ID;
			String key = MethodID + "-" + RequirementID;
			predictionsOldHashMap.put(key, methodtrace.getPrediction());
		}
		return predictionsOldHashMap;
	}

	
	

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	public LinkedHashMap<String, MethodTrace> RetrievePredictionsHashMap(
			List<MethodTrace> methodtraces22) {
		// TODO Auto-generated method stub

		LinkedHashMap<String, MethodTrace> predictionsOldHashMap = new LinkedHashMap<String, MethodTrace>();
		for (MethodTrace methodtrace : methodtraces22) {
			String RequirementID = methodtrace.Requirement.ID;
			String MethodID = methodtrace.Method.ID;
			String key = RequirementID+"-"+MethodID  ;
			predictionsOldHashMap.put(key, methodtrace);
		}
		return predictionsOldHashMap;
	}


	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/**
	 * @throws Exception **********************************************************************************************************************************************/
	public static void main(String[] args) throws Exception {
		String ProgramName = "chess";
		AlgoFinalRefactored frame = new AlgoFinalRefactored(
				ProgramName);

		String ProgramName2 = "gantt";
			 frame = new AlgoFinalRefactored(ProgramName2);

		String ProgramName3 = "itrust";
			 frame = new AlgoFinalRefactored(ProgramName3);

		
		String ProgramName4 = "jhotdraw";
			frame = new AlgoFinalRefactored(ProgramName4);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	public boolean Equals(LinkedHashMap<String, String> OldHashMap, LinkedHashMap<String, String> newHashMap) {
		if (OldHashMap != null && newHashMap != null) {
			if (!OldHashMap.isEmpty()) {
				for (String s : newHashMap.keySet()) {
					// HANDLE NULLS if any
					if (OldHashMap.get(s) != null && newHashMap.get(s) != null)
						if (OldHashMap.get(s).equals(newHashMap.get(s)) == false) {
							if (OldHashMap.get(s).equals("T") || OldHashMap.get(s).equals("N")) {
								//System.out.println("YEEEEEEEEEEEEEEEEEEEEEES IT IS EQUAL");
							}
							return false;
						}
				}

			} else {
				return false;
			}
		}

		return true;
	}

}