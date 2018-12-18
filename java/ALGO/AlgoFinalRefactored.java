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

	
		int j = 0;
//		List<MethodTrace> methodtracesNew = InitializePredictionsHashMap2(methodtraces2);
		TracePredictionFunction( ProgramName);

	}

	

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/**
	 * @throws Exception **********************************************************************************************************************************************/

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void TracePredictionFunction( String ProgramName) throws Exception {
		// TODO Auto-generated method stub
		
	
		
		
		

		// TODO Auto-generated method stub
		LogInfo.CreateLogFiles(ProgramName);

		
		

	
		
		DatabaseReading DatabaseReading= new DatabaseReading(ProgramName); 
		
		methodtraces2HashMap = DatabaseReading.getMethodtracehashmap();
		methodtraces = DatabaseReading.getMethodtracesList(); 

		
		

		LinkedHashMap<String, LogInfo> LogInfoHashMap = new LinkedHashMap<String, LogInfo>();
		

		LinkedHashMap<String, String> RequirementClassHashMapNewValues = new LinkedHashMap<String, String>();
		Collection<MethodTrace> MethodTracesHashmapValues = methodtraces2HashMap.values();


		
		
		PredictionValues TotalPredictionValues = new PredictionValues(); 
		PredictionValues RemainingpredictionValues = new PredictionValues(); 
		PredictionValues PredictionClassTraceBefore = new PredictionValues(); 
		PredictionValues PredictionClassTraceAfter = new PredictionValues(); 

		CountTracesClassesValues(PredictionClassTraceBefore, methodtracesRequirementClass, methodtraces2HashMap);
		LogInfo.InitializeLogInfoHashMap(LogInfoHashMap,MethodTracesHashmapValues, methodtraces2HashMap ); 

		LogInfo.bwTraceClass.write("BEFORE PATTERN 0 "+PredictionClassTraceBefore.toString());
		LogInfo.bwTraceClass.newLine();

		RequirementClassHashMapNewValues = GenerateNewValuesInTracesClasses(RequirementClassHashMapNewValues, methodtracesRequirementClass);
		CountTracesClassesValues(PredictionClassTraceAfter, methodtracesRequirementClass, methodtraces2HashMap);

		LogInfo.bwTraceClass.write("AFTER PATTERN 0 "+PredictionClassTraceAfter.toString());
		LogInfo.bwTraceClass.close();
	
		LogInfoHashMap=LogInfo.InitializeLogInfoHashMapTraceClassNewValue(LogInfoHashMap,MethodTracesHashmapValues, methodtraces2HashMap ); 

	
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
					
					
					
					
					
			
			
		
			if (methodtrace.Method.Owner.DeveloperGold != null) {
				
			
				
				if (methodtrace.Method.Owner.DeveloperGold.equals("T") ) {
						
					//DO NOTHING 
					
				

				} else if (methodtrace.Method.Owner.DeveloperGold.equals("N")) {
					methodtrace.SetPrediction(LogInfoHashMap, "N","N,Owner");
					
					
				}

				else {

					//DO NOTHING 
				}
			

		
			
			
		}
		}
		System.out.println(counter);
		SetSubjectGoldDeveloperGoldEqualityFlag(methodtraces2HashMap, TotalPattern, LogInfoHashMap, ProgramName); 
		 PredictionValues OwnerClassPredictionValues = new PredictionValues(); 
			

			LogInfo.ComputePrecisionAndRecall(methodtraces2HashMap,TotalPattern, ProgramName, OwnerClassPredictionValues);
			
			LogInfo.updateResultsLog(TotalPattern, OwnerClassPredictionValues, ProgramName, "OWNER CLASS PRED", "owner class prediction values");
		
		
		

		int ITERATION = 0;
	//	MethodTracesHashmapValues=methodtraces2HashMap.values(); 

		
		

//		 LogHashMapRemaining = new LinkedHashMap<String, LogInfo>();
//		LogHashMapRemaining=InitializeHashMapWithPrecisionRecallRemaining(MethodTracesHashmapValues, LogHashMapRemaining, LogInfoHashMap); 
		MethodTracesHashmapValues=methodtraces2HashMap.values(); 

		while (MethodTrace.modified) {
			MethodTrace.modified = false;
			////////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// PURE AND MIXED PATTERNS	PATTERN 1-2
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////

			//////////////////////////////////////////////////////////////////////////////////////////
		

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
			


				// PURE T PATTERN


				if (    !methodtrace.Method.Callees.isEmpty() && !methodtrace.Method.Callers.isEmpty()
						&& methodtrace.Method.Callees.AllTs(methodtrace.Requirement, methodtraces2HashMap)
						&& methodtrace.Method.Callers.AllTs(methodtrace.Requirement, methodtraces2HashMap)					
						

				) {
					methodtrace.SetPrediction(LogInfoHashMap, "T", "T,PureT");

					

				}
				// PURE N PATTERN
				else if ( !methodtrace.Method.Callees.isEmpty() && !methodtrace.Method.Callers.isEmpty()
						&& methodtrace.Method.Callees.AllNs(methodtrace.Requirement, methodtraces2HashMap)
						&& methodtrace.Method.Callers.AllNs(methodtrace.Requirement, methodtraces2HashMap)

				) {
					methodtrace.SetPrediction(LogInfoHashMap,"N", "N,PureN");
				

				}

				 
				// PURE T LEAF PATTERN
				 if (	methodtrace.Method.Callees.isEmpty() && !methodtrace.Method.Callers.isEmpty()
						 && methodtrace.Method.Callers.AllTs(methodtrace.Requirement,methodtraces2HashMap)

				) {
						methodtrace.SetPrediction(LogInfoHashMap,"T", "T,PureTLeaf");

				}
				// PURE N LEAF PATTERN
				 else if (methodtrace.Method.Callees.isEmpty() && !methodtrace.Method.Callers.isEmpty()
						 && methodtrace.Method.Callers.AllNs(methodtrace.Requirement, methodtraces2HashMap)

				) {

						methodtrace.SetPrediction(LogInfoHashMap,"N", "N,PureNLeaf");

				}

				
			

			}

			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// MIXED PATTERNS
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			for (MethodTrace methodtrace : MethodTracesHashmapValues) {
				//System.out.println();

				// MIXED T PATTERN
				 if (!methodtrace.Method.Callees.isEmpty() && !methodtrace.Method.Callers.isEmpty() 
					&& methodtrace.Method.Callees.AtLeast1T(methodtrace.Requirement, methodtraces2HashMap) 
					&& methodtrace.Method.Callers.AtLeast1T(methodtrace.Requirement, methodtraces2HashMap) 

				) {
						methodtrace.SetPrediction(LogInfoHashMap,"T", "T,MixedT");

				}
				 
				// MIXED N PATTERN
				 else if (!methodtrace.Method.Callees.isEmpty() && !methodtrace.Method.Callers.isEmpty()
						
						&& methodtrace.Method.Callees.AtLeast1N(methodtrace.Requirement, methodtraces2HashMap) 
						&& methodtrace.Method.Callers.AtLeast1N(methodtrace.Requirement, methodtraces2HashMap) 
						

				) {

						methodtrace.SetPrediction(LogInfoHashMap,"N", "N,MixedN");


				}
				

				
				 
				// MIXED T LEAF PATTERN
				 if (methodtrace.Method.Callees.isEmpty() && !methodtrace.Method.Callers.isEmpty() 
						 && methodtrace.Method.Callers.AtLeast1T(methodtrace.Requirement, methodtraces2HashMap) 

				) {
						methodtrace.SetPrediction(LogInfoHashMap,"T", "T,MixedTLeaf");


				}// MIXED N LEAF PATTERN
				 else if(methodtrace.Method.Callees.isEmpty() && !methodtrace.Method.Callers.isEmpty() 
						 && methodtrace.Method.Callers.AtLeast1N(methodtrace.Requirement, methodtraces2HashMap) 

				) {
						methodtrace.SetPrediction(LogInfoHashMap,"N", "N,MixedNLeaf");


				}
			}
			
			// PRINT

			
			
			
			
			
			
			
			
			
			
			
			
			
			
		

			
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

			
					
					if (
							methodtrace.Method.Interfaces.AllTs(methodtrace.Requirement,methodtraces2HashMap)
							||methodtrace.Method.Implementations.AllTs(methodtrace.Requirement,methodtraces2HashMap)
							||methodtrace.Method.Superclasses.AllTs(methodtrace.Requirement,methodtraces2HashMap)
							||methodtrace.Method.Children.AllTs(methodtrace.Requirement,methodtraces2HashMap)
							
							)
							
						

					{

						
						
						methodtrace.SetPrediction(LogInfoHashMap,"T", "T,AllTInheritance");


					}
					else if (
							
							methodtrace.Method.Interfaces.AllNs(methodtrace.Requirement,methodtraces2HashMap)
							||methodtrace.Method.Implementations.AllNs(methodtrace.Requirement,methodtraces2HashMap)
							||methodtrace.Method.Superclasses.AllNs(methodtrace.Requirement,methodtraces2HashMap)
							||methodtrace.Method.Children.AllNs(methodtrace.Requirement,methodtraces2HashMap)

					)

					{
						
						
						methodtrace.SetPrediction(LogInfoHashMap,"N", "N,AllNInheritance");

						 //DEBUGGING PURPOSES 
//						 if(methodtrace.getGoldfinal().equals("T") && methodtrace.Method.owner.DeveloperGold.equals(methodtrace.Method.owner.SubjectGold)) {
//								System.out.println("fullmethodname   "+methodtrace.Method.fullmethodname+" Requirement  "+methodtrace.Requirement.ID+" DeveloperGold "+methodtrace.getGoldfinal()+" Prediction "+methodtrace.getPrediction()+"   gold final  "+methodtrace.getGoldfinal());
//								if(methodtrace.Method.Interfaces.AllNs(methodtrace.Requirement,methodtraces2HashMap)){
//									System.out.println("interfaces");
//									System.out.println(methodtrace.Method.Interfaces);
//									System.out.println();
//								}
//								if(methodtrace.Method.Implementations.AllNs(methodtrace.Requirement,methodtraces2HashMap)) {
//									System.out.println("implementations");
//									System.out.println(methodtrace.Method.Implementations);
//									System.out.println();
//
//								}
//								if(methodtrace.Method.getSuperclasses().AllNs(methodtrace.Requirement,methodtraces2HashMap)) {
//									System.out.println("superclasses");
//									System.out.println(methodtrace.Method.getSuperclasses());
//									System.out.println();
//
//
//								}
//								if(methodtrace.Method.getChildren().AllNs(methodtrace.Requirement,methodtraces2HashMap)) {
//									System.out.println("children");
//									System.out.println(methodtrace.Method.getChildren());
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
				

					
				
			
	

				
			
			

		
		
				

		
				
				

			
		
			
			
				
				
			
				

				
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// ALL CALLERS PATTERN 4.1
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
				
				
			for (MethodTrace methodtrace : MethodTracesHashmapValues) {
				//System.out.println();
				
				
			
			
				
				// ALL T CALLERS 
				 if (!methodtrace.Method.Callers.isEmpty() 
					&& methodtrace.Method.Callers.AllTs(methodtrace.Requirement, methodtraces2HashMap) 
					

				) {
						methodtrace.SetPrediction(LogInfoHashMap,"T", "T,AllTCallers");

				}
				// ALL N CALLERS
				 else if (!methodtrace.Method.Callers.isEmpty() 
							&& methodtrace.Method.Callers.AllNs(methodtrace.Requirement, methodtraces2HashMap) 
							

						) {

						methodtrace.SetPrediction(LogInfoHashMap,"N", "N,AllNCallers");



				}
				

				
				 
			
				
			}
				
			
			
			
			
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				//ALL CALLEES PATTERN 5
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
			
			for (MethodTrace methodtrace : MethodTracesHashmapValues) {
				
				
				
				
				
				
				
				
				
				
				
				//ALL T CALLEES 
				if (!methodtrace.Method.Callees.isEmpty() 
				&& methodtrace.Method.Callees.AllTs(methodtrace.Requirement, methodtraces2HashMap) 
				
				
				) {
					methodtrace.SetPrediction(LogInfoHashMap,"T", "T,AllTCallees");

				
				
				}
				//ALL N CALLEES
				else if (!methodtrace.Method.Callees.isEmpty() 
				&& methodtrace.Method.Callees.AllNs(methodtrace.Requirement, methodtraces2HashMap) 
				
				
				) {
				
					methodtrace.SetPrediction(LogInfoHashMap,"N", "N,AllNCallees");

				
				
				}
			
				}	
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// END PATTERNS 
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			
			
			
			
			
			
			
			
			
			
			// PRINT
			SetLogFileIterations(MethodTracesHashmapValues, methodtraces, LogInfoHashMap, ITERATION); 
			

			// END PRINT
			ITERATION++;

		}
		
		
		
		
		
		
		//SET EVERYTHING ELSE TO T IF THE OWNER CLASS IS T 
		for (MethodTrace methodtrace : MethodTracesHashmapValues) {
			String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.Method.ID;
			
			if( methodtrace.getPrediction().equals("E") && methodtrace.Method.Owner.DeveloperGold.equals("T") ) {
				LogInfo loginfo = LogInfoHashMap.get(reqMethod); 
				
				methodtrace.SetPrediction(LogInfoHashMap,"T", "T,Remaining");

		LogInfoHashMap.put(reqMethod, loginfo); 
			}
			
			
		}
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	
	
	


		
		
		System.out.println("RemainingpredictionValues"+RemainingpredictionValues);
		LogInfo.ComputePrecisionAndRecall(methodtraces2HashMap, RemainingPattern, ProgramName, RemainingpredictionValues);
		System.out.println("RemainingpredictionValues"+TotalPattern);


	
		 TotalPredictionValues = new PredictionValues(); 
		 TotalPattern = new PredictionEvaluation();
		 RemainingpredictionValues = new PredictionValues(); 
		
		RemainingpredictionValues=SubstractPredictionValues(TotalPredictionValues, OwnerClassPredictionValues); 

		
		LogInfo.updateResultsLog(RemainingPattern, RemainingpredictionValues, ProgramName, "NON OWNER CLASS PRED", "non owner class prediction values");

		ResetAllTraceSetFlags(methodtraces2HashMap);
		 LogInfo.ComputePrecisionAndRecall(methodtraces2HashMap, TotalPattern, ProgramName, TotalPredictionValues);

		LogInfo.updateResultsLog(TotalPattern, TotalPredictionValues, ProgramName,"TOTAL  PREDICTION", "total prediction values");
		LogInfo.closeLogFile(); 
		
		
		
		
		LogInfo.CloseFiles(ProgramName); 
		
		
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
			myhashmap.put(reqClass, methodtraces2HashMap2.get(mykey).Method.Owner.DeveloperGold);
		
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
			
			
			methodtrace.setPrediction("E");
			
		}
	
		return logHashMapRemaining;
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
		Collection<MethodTrace> MethodTracesHashmapValues = methodtraces2HashMap.values();

		for (MethodTrace methodtrace : MethodTracesHashmapValues) {


			// PATTERN 1
			
			MethodList children = methodtrace.Method.Children; 
			MethodList parents = methodtrace.Method.Superclasses; 
			MethodList implementations = methodtrace.Method.Implementations; 
			MethodList interfaces = methodtrace.Method.Interfaces; 
			List<String> ChilrenGold= new ArrayList<String>(); 
			List<String> ParentsGold= new ArrayList<String>(); 
			List<String> ImplementationsGold= new ArrayList<String>(); 
			List<String> InterfacesGold= new ArrayList<String>(); 
			for(Method child:children) {
				String ChildGold = child.Owner.DeveloperGold; 
				ChilrenGold.add(ChildGold); 
			}
			
			
			for(Method parent:parents) {
				String ParentGold = parent.Owner.DeveloperGold; 
				ParentsGold.add(ParentGold); 
			}
			for(Method myinterface:interfaces) {
				String InterfaceGold = myinterface.Owner.DeveloperGold; 
				InterfacesGold.add(InterfaceGold); 

			}
			for(Method implementation:implementations) {
				String ImplementationGold = implementation.Owner.DeveloperGold; 
				ImplementationsGold.add(ImplementationGold); 
			}
			
			
			
			if(methodtrace.Method.Owner.DeveloperGold.equals("E") ) {
				if(!ImplementationsGold.contains("N") && !ImplementationsGold.contains("E")  &&  ImplementationsGold.contains("T") && !ImplementationsGold.isEmpty()) {
					methodtrace.Method.Owner.setDeveloperGold("T");
				}else if(!InterfacesGold.contains("N") && !InterfacesGold.contains("E")  &&  InterfacesGold.contains("T") && !InterfacesGold.isEmpty()) {
					methodtrace.Method.Owner.setDeveloperGold("T");

				}else if(!ParentsGold.contains("N") && !ParentsGold.contains("E")  &&  ParentsGold.contains("T") && !ParentsGold.isEmpty()) {
					methodtrace.Method.Owner.setDeveloperGold("T");

				}else if(!ChilrenGold.contains("N") && !ChilrenGold.contains("E")  &&  ChilrenGold.contains("T") && !ChilrenGold.isEmpty()) {
					methodtrace.Method.Owner.setDeveloperGold("T");

				}
				
				
				 if(!ImplementationsGold.contains("T") && !ImplementationsGold.contains("E") && ImplementationsGold.contains("N") && !ImplementationsGold.isEmpty()) {
					methodtrace.Method.Owner.setDeveloperGold("N");
				}else if(!InterfacesGold.contains("T") && !InterfacesGold.contains("E")&& InterfacesGold.contains("N") && !InterfacesGold.isEmpty()) {
					methodtrace.Method.Owner.setDeveloperGold("N");

				}else if(!ParentsGold.contains("T") && !ParentsGold.contains("E")&& ParentsGold.contains("N") &&  !ParentsGold.isEmpty()) {
					methodtrace.Method.Owner.setDeveloperGold("N");

				}else if(!ChilrenGold.contains("T") && !ChilrenGold.contains("E")&&  !ChilrenGold.contains("N") && !ChilrenGold.isEmpty()) {
					methodtrace.Method.Owner.setDeveloperGold("N");

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
				if (methodtraceValue.Method.Owner.DeveloperGold.equals(methodtraceValue.Method.Owner.SubjectGold) ) {
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

//	/************************************************************************************************************************************************/
//	/************************************************************************************************************************************************/
//	/************************************************************************************************************************************************/
//	public boolean Equals(LinkedHashMap<String, String> OldHashMap, LinkedHashMap<String, String> newHashMap) {
//		if (OldHashMap != null && newHashMap != null) {
//			if (!OldHashMap.isEmpty()) {
//				for (String s : newHashMap.keySet()) {
//					// HANDLE NULLS if any
//					if (OldHashMap.get(s) != null && newHashMap.get(s) != null)
//						if (OldHashMap.get(s).equals(newHashMap.get(s)) == false) {
//							if (OldHashMap.get(s).equals("T") || OldHashMap.get(s).equals("N")) {
//								//System.out.println("YEEEEEEEEEEEEEEEEEEEEEES IT IS EQUAL");
//							}
//							return false;
//						}
//				}
//
//			} else {
//				return false;
//			}
//		}
//
//		return true;
//	}

}