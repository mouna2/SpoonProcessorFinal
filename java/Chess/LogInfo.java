package Chess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import ALGO.MethodList;
import ALGO.PredictionValues;
import mypackage.ClassTrace2;
import mypackage.Method;
import mypackage.MethodTrace;

public class LogInfo {
	String MethodID; 
	String MethodName; 
	String RequirementID; 
	String RequirementName; 
	String ClassID; 
	String ClassName; 
	String TraceValue;
	String TraceClassOldValue; 
	String TraceClassNewValue; 
	String Prediction; 
	public String PrecisionRecall; 
	String GoldFinal; 
	String SubjectGold; 
	List<String> IterationValues= new ArrayList<String>();
	boolean SubjectDeveloperEqualityFlag; 
	String Reason; 
	List<String> Callers;
	List<String> CallerPredictions;
	List<String> Callees;
	List<String> CalleePredictions;
	List<String> OuterCalleesPredictions;
	List<String> OuterCallersPredictions;
	
	
	List<String> ImplementationCallees;
	List<String> ImplementationCalleePredictions;
	List<String> InterfaceCallers;
	List<String> InterfaceCallerPredictions;
	
	List<String> ChildrenCallees;
	List<String> ChildrenCalleePredictions;
	List<String> SuperclassCallers;
	List<String> SuperclassCallerPredictions;
	
	public List<String> OriginalCallers;
	public List<String> OriginalCallerPredictions;
	public List<String> OriginalCallees;
	public List<String> OriginalCalleePredictions;
	
	
	public List<String> getImplementationCallees() {
		return ImplementationCallees;
	}
	public void setImplementationCallees(List<String> implementationCallees) {
		ImplementationCallees = implementationCallees;
	}
	public List<String> getImplementationCalleePredictions() {
		return ImplementationCalleePredictions;
	}
	public void setImplementationCalleePredictions(List<String> implementationCalleePredictions) {
		ImplementationCalleePredictions = implementationCalleePredictions;
	}
	public List<String> getInterfaceCallers() {
		return InterfaceCallers;
	}
	public void setInterfaceCallers(List<String> interfaceCallers) {
		InterfaceCallers = interfaceCallers;
	}
	public List<String> getInterfaceCallerPredictions() {
		return InterfaceCallerPredictions;
	}
	public void setInterfaceCallerPredictions(List<String> interfaceCallerPredictions) {
		InterfaceCallerPredictions = interfaceCallerPredictions;
	}
	public List<String> getChildrenCallees() {
		return ChildrenCallees;
	}
	public void setChildrenCallees(List<String> childrenCallees) {
		ChildrenCallees = childrenCallees;
	}
	public List<String> getChildrenCalleePredictions() {
		return ChildrenCalleePredictions;
	}
	public void setChildrenCalleePredictions(List<String> childrenCalleePredictions) {
		ChildrenCalleePredictions = childrenCalleePredictions;
	}
	public List<String> getSuperclassCallers() {
		return SuperclassCallers;
	}
	public void setSuperclassCallers(List<String> superclassCallers) {
		SuperclassCallers = superclassCallers;
	}
	public List<String> getSuperclassCallerPredictions() {
		return SuperclassCallerPredictions;
	}
	public void setSuperclassCallerPredictions(List<String> superclassCallerPredictions) {
		SuperclassCallerPredictions = superclassCallerPredictions;
	}
	public List<String> getOriginalCallers() {
		return OriginalCallers;
	}
	public void setOriginalCallers(List<String> originalCallers) {
		OriginalCallers = originalCallers;
	}
	public List<String> getOriginalCallerPredictions() {
		return OriginalCallerPredictions;
	}
	public void setOriginalCallerPredictions(List<String> originalCallerPredictions) {
		OriginalCallerPredictions = originalCallerPredictions;
	}
	public List<String> getOriginalCallees() {
		return OriginalCallees;
	}
	public void setOriginalCallees(List<String> originalCallees) {
		OriginalCallees = originalCallees;
	}
	public List<String> getOriginalCalleePredictions() {
		return OriginalCalleePredictions;
	}
	public void setOriginalCalleePredictions(List<String> originalCalleePredictions) {
		OriginalCalleePredictions = originalCalleePredictions;
	}
	public static BufferedWriter bwfile4 = null;
	public static BufferedWriter bwfile3 = null;
	public static BufferedWriter bwfile2 = null;
	public static BufferedWriter bwfileChess = null;

	public static BufferedWriter bwfileFP =null; 
	public static BufferedWriter bwfileFN =null; 
	public static BufferedWriter bwfile3Chess =null; 
	public static BufferedWriter bwfile3iTrust =null; 
	public static BufferedWriter bwfile3jHotDraw =null; 

	
	public List<String> getOuterCalleesPredictions() {
		return OuterCalleesPredictions;
	}
	public void setOuterCalleesPredictions(List<String> outerCalleesPredictions) {
		OuterCalleesPredictions = outerCalleesPredictions;
	}
	public List<String> getOuterCallersPredictions() {
		return OuterCallersPredictions;
	}
	public void setOuterCallersPredictions(List<String> outerCallersPredictions) {
		OuterCallersPredictions = outerCallersPredictions;
	}
	
	
	public static BufferedWriter bwfile1 = null;
	public static BufferedWriter bwTraceClass = null;
	
	public List<String> getCallers() {
		return Callers;
	}
	public void setCallers(List<String> callers) {
		Callers = callers;
	}
	public List<String> getCallerPredictions() {
		return CallerPredictions;
	}
	public void setCallerPredictions(List<String> callerPredictions) {
		CallerPredictions = callerPredictions;
	}
	public List<String> getCallees() {
		return Callees;
	}
	public void setCallees(List<String> callees) {
		Callees = callees;
	}
	public List<String> getCalleePredictions() {
		return CalleePredictions;
	}
	public void setCalleePredictions(List<String> calleePredictions) {
		CalleePredictions = calleePredictions;
	}
	public boolean isSubjectDeveloperEqual() {
		return SubjectDeveloperEqualityFlag;
	}
	public void setSubjectDeveloperEqualityFlag(boolean myFlag) {
		this.SubjectDeveloperEqualityFlag = myFlag;
	}
	public String getGoldFinal() {
		return GoldFinal;
	}
	public void setGoldFinal(String goldFinal) {
		GoldFinal = goldFinal;
	}
	public String getSubjectGold() {
		return SubjectGold;
	}
	public void setSubjectGold(String subjectGold) {
		SubjectGold = subjectGold;
	}
	public String getPrediction() {
		return Prediction;
	}
	public void setPrediction(String prediction) {
		Prediction = prediction;
	}
	public String getTraceClassOldValue() {
		return TraceClassOldValue;
	}
	public void setTraceClassOldValue(String traceClassOldValue) {
		TraceClassOldValue = traceClassOldValue;
	}
	public String getTraceClassNewValue() {
		return TraceClassNewValue;
	}
	public void setTraceClassNewValue(String traceClassNewValue) {
		TraceClassNewValue = traceClassNewValue;
	}
	public String getMethodID() {
		return MethodID;
	}
	public void setMethodID(String methodID) {
		MethodID = methodID;
	}
	public String getMethodName() {
		return MethodName;
	}
	public void setMethodName(String methodName) {
		MethodName = methodName;
	}
	public String getClassID() {
		return ClassID;
	}
	public void setClassID(String classID) {
		ClassID = classID;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getTraceValue() {
		return TraceValue;
	}
	public void setTraceValue(String traceValue) {
		TraceValue = traceValue;
	}
	public List<String> getIterationValues() {
		return IterationValues;
	}
	public void setIterationValues(List<String> iterationValues) {
		IterationValues = iterationValues;
	}
	
	
	
	
	public String getPrecisionRecall() {
		return PrecisionRecall;
	}
	public void setPrecisionRecall(String precisionRecall) {
		PrecisionRecall = precisionRecall;
	}
	public LogInfo() {
		super();
	}
	
	
	
	
	@Override
	public String toString() {
		System.out.println(MethodName);
		MethodName=MethodName.replaceAll(",", "/"); 
		RequirementName=RequirementName.replaceAll(",", "/"); 
		String CallerList=toString3(Callers); 
		String CalleeList=toString3(Callees); 
		String CallerPredictionList=toString3(CallerPredictions); 
		String CalleePredictionList=toString3(CalleePredictions); 

		String OriginalCallerList=toString3(OriginalCallers); 
		String OriginalCalleeList=toString3(OriginalCallees); 
		String OriginalCallerPredictionList=toString3(OriginalCallerPredictions); 
		String OriginalCalleePredictionList=toString3(OriginalCalleePredictions); 
		
		
//		String interfaceCallerList=toString3(InterfaceCallers); 
//		String interfaceCallerPredictionList=toString3(InterfaceCallerPredictions); 
//		String ImplementationCalleesList=toString3(ImplementationCallees); 
//		String ImplementationCalleesPredictionList=toString3(ImplementationCalleePredictions); 
//		
//		
//		String SuperclassCallerList=toString3(SuperclassCallers); 
//		String SuperclassCallerPredictionList=toString3(SuperclassCallerPredictions); 
//		String ChildrenCalleesList=toString3(ChildrenCallees); 
//		String ChildrenCalleesPredictionList=toString3(ChildrenCalleePredictions); 
		
		return MethodID+","+MethodName+","+RequirementID+","+RequirementName+","+ClassID+","+ClassName+","+TraceValue+","+TraceClassOldValue+","+TraceClassNewValue+","+
		PrecisionRecall	
//		+","+interfaceCallerList+","+interfaceCallerPredictionList+","+ImplementationCalleesList+","+ImplementationCalleesPredictionList
//		+","+SuperclassCallerList+","+SuperclassCallerPredictionList+","+ChildrenCalleesList+","+ChildrenCalleesPredictionList
		

		+","+OriginalCallerList+","+OriginalCallerPredictionList+","+OriginalCalleeList+","+OriginalCalleePredictionList+","+CallerList+","+CallerPredictionList+","+CalleeList+","+CalleePredictionList+","+toString2(IterationValues); 
//		return MethodID+","+MethodName+","+RequirementID+","+RequirementName+","+ClassID+","+ClassName+","+TraceValue+","+TraceClassOldValue+","+TraceClassNewValue+","+
//				PrecisionRecall	+","+toString2(IterationValues)+","+TraceValue+"-"+Reason+"-" +PrecisionRecall;
		
	}
	
	public String toString3(List<String> values) {
		// TODO Auto-generated method stub
		String s= ""; 
		int counter=0; 
		for(String value: values) {
		
			counter++; 
			if(counter==values.size()) {
				s=s+value; 
			}
			else {
				s=s+value+"/"; 
			}
			
		}
		s=s.replaceAll(",", "_"); 

		return s;
	}
	public String getRequirementID() {
		return RequirementID;
	}
	public void setRequirementID(String requirementID) {
		RequirementID = requirementID;
	}
	public String getRequirementName() {
		return RequirementName;
	}
	public void setRequirementName(String requirementName) {
		RequirementName = requirementName;
	}
	public String toString2(List<String> IterationValues) {
		 String FinalString=""; 
		 int it=0; 
		 Reason=""; 
		for(String s: IterationValues) {
			if(it+1<IterationValues.size()) {
				FinalString=FinalString+s+","; 
				
				it++; 	
			}
			
			else if(it+1==IterationValues.size()) {
				FinalString=FinalString+s; 
				
			}
			if(!s.equals(" ")) {
				Reason=s; 
			}
		}
		return FinalString;
		
	}
	
	
	/************************************************************************************************************************************************/
	/**
	 * @param methodtraces2HashMap **********************************************************************************************************************************************/
	public static LinkedHashMap<String, LogInfo> InitializeLogInfoHashMap(LinkedHashMap<String, LogInfo> LogInfoHashMap,
			Collection<MethodTrace> methodTracesHashmapValues, HashMap<String, MethodTrace> methodtraces2HashMap) {
		// TODO Auto-generated method stub
		for(MethodTrace methodtrace: methodTracesHashmapValues) {
			String Req= methodtrace.getRequirement().ID; 
			String Method= methodtrace.getMethod().ID; 
			LogInfo loginfo= new LogInfo(); 
			String reqMethod= Req+"-"+Method; 
			if (LogInfoHashMap.get(reqMethod) != null) {
				loginfo = LogInfoHashMap.get(reqMethod);
			}

			loginfo.setRequirementID(methodtrace.getRequirement().ID);
			loginfo.setRequirementName(methodtrace.getRequirement().RequirementName);
			loginfo.setMethodID(methodtrace.getMethod().ID);
			loginfo.setMethodName(methodtrace.getMethod().methodname);
			loginfo.setClassID(methodtrace.Method.Owner.ID);
			loginfo.setClassName(methodtrace.Method.Owner.classname);
			loginfo.setTraceValue(methodtrace.getGold());
			loginfo.setGoldFinal(methodtrace.Method.Owner.DeveloperGold);
			loginfo.setSubjectGold(methodtrace.Method.Owner.SubjectGold);
			loginfo.setPrecisionRecall("E");

			
		
			LogInfoHashMap.put(Req+"-"+Method, loginfo); 
			methodtrace.setPrediction("E");

			String traceClassOldValue= methodtrace.Method.Owner.DeveloperGold; 

			
		
			loginfo.setTraceClassOldValue(traceClassOldValue);
			LogInfoHashMap.put(reqMethod, loginfo); 
		}
		return LogInfoHashMap; 
	}
	public static LinkedHashMap<String, LogInfo> InitializeLogInfoHashMapTraceClassNewValue(
			LinkedHashMap<String, LogInfo> LogInfoHashMap, Collection<MethodTrace> methodTracesHashmapValues,
			HashMap<String, MethodTrace> methodtraces2HashMap) {
		// TODO Auto-generated method stub
		for(MethodTrace methodtrace: methodTracesHashmapValues) {
			String Req= methodtrace.getRequirement().ID; 
			String Method= methodtrace.getMethod().ID; 
			
			String reqMethod= Req+"-"+Method; 
		
			
			

			
		
			
			if(LogInfoHashMap.get(reqMethod)!=null) {
				LogInfo	  LogInfo= LogInfoHashMap.get(reqMethod); 
				
				
				if(LogInfo.getTraceClassOldValue().equals("E") && !methodtrace.Method.Owner.DeveloperGold.equals("E")) {
					String traceClassNewValue= methodtrace.Method.Owner.DeveloperGold; 
					LogInfo.setTraceClassNewValue(traceClassNewValue);
					LogInfoHashMap.put(reqMethod, LogInfo); 
				}
				
				
			 }
			
		}
		return LogInfoHashMap;
	}
	public  static void CreateLogFiles(String ProgramName) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	

		if (ProgramName.equals("chess")) {
			File filelogChess = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\TableLogChess.txt");
			FileOutputStream fosfilChess = new FileOutputStream(filelogChess);
			bwfileChess = new BufferedWriter(new OutputStreamWriter(fosfilChess));
			
			File filelogFPChess = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\FalsePositiveDetailsChess.txt");
			FileOutputStream fosfilaFPChess = new FileOutputStream(filelogFPChess);
			 bwfile3Chess = new BufferedWriter(new OutputStreamWriter(fosfilaFPChess));
			 
			 
			 File file1log = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\PrecisionRecallChess.txt");
				FileOutputStream fosfila1 = new FileOutputStream(file1log);
				bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

				
				File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\TracesClassesChess.txt");
				FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
				bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
				
				System.out.println("yes");
		}

		if (ProgramName.equals("gantt")) {
			File filelog2 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\TableLogGantt.txt");
			FileOutputStream fosfila2 = new FileOutputStream(filelog2);
			bwfile2 = new BufferedWriter(new OutputStreamWriter(fosfila2));
			
			File filelogFP = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\FalsePositiveDetailsGantt.txt");
			FileOutputStream fosfilaFP = new FileOutputStream(filelogFP);
			 bwfileFP = new BufferedWriter(new OutputStreamWriter(fosfilaFP));
			 
			 File file1log = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\PrecisionRecallGantt.txt");
				FileOutputStream fosfila1 = new FileOutputStream(file1log);
				bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

				
				File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\TracesClassesGantt.txt");
				FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
				bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
		}

		if (ProgramName.equals("itrust")) {
			File filelog3 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\TableLogiTrust.txt");
			FileOutputStream fosfila5 = new FileOutputStream(filelog3);
			bwfile3 = new BufferedWriter(new OutputStreamWriter(fosfila5));
			
			File filelog3iTrust = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\FalsePositiveDetailsiTrust.txt");
			FileOutputStream fosfila5iTrust = new FileOutputStream(filelog3iTrust);
			bwfile3iTrust = new BufferedWriter(new OutputStreamWriter(fosfila5iTrust));
			
			
			File file1log = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\PrecisionRecalliTrust.txt");
			FileOutputStream fosfila1 = new FileOutputStream(file1log);
			bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

			
			File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\TracesClassesiTrust.txt");
			FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
			bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
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
				
				
				File file1log = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\PrecisionRecallJHotDraw.txt");
				FileOutputStream fosfila1 = new FileOutputStream(file1log);
				bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

				
				File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\LatestLogFiles\\TracesClassesJHotDraw.txt");
				FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
				bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
				
		}
		// bwfile2.newLine();
		

	}
	
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/**
	 * @param ownerClassPredictionValues 
	 * @param logInfoHashMap 
	 * @param string2 
	 * @param string **********************************************************************************************************************************************/

	public static void ComputePrecisionAndRecall(
			HashMap<String, MethodTrace> methodTraceHashMap,
			PredictionEvaluation Pattern, String ProgramName,  PredictionValues ownerClassPredictionValues, LinkedHashMap<String, LogInfo> logInfoHashMap) throws SQLException {
		// TODO Auto-generated method stub
	Pattern.ResetCounters(Pattern);

		for (String mykey : methodTraceHashMap.keySet()) {
			MethodTrace methodTrace = methodTraceHashMap.get(mykey);
			
			if(ProgramName.equals("gantt")|| ProgramName.equals("jhotdraw")){
				if (methodTrace.getGold() != null && methodTrace.getPrediction() != null 
						&& methodTraceHashMap.get(mykey).isSubjectDeveloperEqualityFlag()
						&& !methodTrace.isTraceSet() ) {
					String Result = Pattern.ComparePredictionToGold(methodTrace.getGold().trim(),methodTrace.getPrediction().trim());
					logInfoHashMap.get(mykey).setPrecisionRecall(Result);
					Pattern.UpdateCounters(Result, Pattern);
					if(!Result.equals("E")) {
						methodTrace.setTraceSet(true);
					}


				}
				
				ownerClassPredictionValues.ComputePredictionValues(ownerClassPredictionValues, methodTrace.getPrediction().trim());

			}else if(ProgramName.equals("chess")|| ProgramName.equals("itrust") ) {
			
				if (methodTrace.getGold() != null && methodTrace.getPrediction() != null 
						&& !methodTrace.isTraceSet()) {
					String Result = Pattern.ComparePredictionToGold(methodTrace.getGold().trim(),
							methodTrace.getPrediction().trim());
					logInfoHashMap.get(mykey).setPrecisionRecall(Result);
					Pattern.UpdateCounters(Result, Pattern);
					if(!Result.equals("E")) {
						methodTrace.setTraceSet(true);

					}
				


				}
				ownerClassPredictionValues.ComputePredictionValues(ownerClassPredictionValues, methodTrace.getPrediction().trim());

			}

		

			


		}
		System.out.println(Pattern.toString());

	}
	
	
	public static void updateResultsLog(PredictionEvaluation TotalPattern,  PredictionValues ownerClassPredictionValues, String ProgramName, String precisionRecall, String PredictionValues) throws IOException {
		// TODO Auto-generated method stub

		LogInfo.bwfile1.write(precisionRecall+"                  "+ProgramName+"                     "+TotalPattern.toString());
		LogInfo.bwfile1.newLine();
		LogInfo.bwfile1.write(PredictionValues+"     "+ProgramName+"                     "+ownerClassPredictionValues.toString());
		LogInfo.bwfile1.newLine();

	}
	public static void updateTableLog(String ProgramName, Collection<MethodTrace> MethodTracesHashmapValues, LinkedHashMap<String, LogInfo> LogInfoHashMap) throws IOException {
		// TODO Auto-generated method stub
		if (ProgramName.equals("chess")) {
			LogInfo.bwfileChess.write(
					"MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold, TraceClassOldValue, TraceClassNewValue, PrecisionRecall"
//					+"	,interfaceCallerList,interfaceCallerPredictionList,ImplementationCalleesList,ImplementationCalleesPredictionList"
//	+"	,SuperclassCallerList,SuperclassCallerPredictionList,ChildrenCalleesList,ChildrenCalleesPredictionList"
					+ ",OriginalCallers, OriginalCallerPredictions, OriginalCallees, OriginalCalleePredictions, Callers, CallerPredictions, Callees, CalleePredictions, IterationValues");
			LogInfo.bwfileChess.newLine();
		}
		if (ProgramName.equals("gantt")) {
			LogInfo.bwfile2.write(
					"MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold, TraceClassOldValue, TraceClassNewValue, PrecisionRecall"
//					+"	,interfaceCallerList,interfaceCallerPredictionList,ImplementationCalleesList,ImplementationCalleesPredictionList"
//	+"	,SuperclassCallerList,SuperclassCallerPredictionList,ChildrenCalleesList,ChildrenCalleesPredictionList"
					+ ",OriginalCallers, OriginalCallerPredictions, OriginalCallees, OriginalCalleePredictions, Callers, CallerPredictions, Callees, CalleePredictions, IterationValues");
			LogInfo.bwfile2.newLine();
		}
		if (ProgramName.equals("itrust")) {
			LogInfo.bwfile3.write(
					"MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold, TraceClassOldValue, TraceClassNewValue, PrecisionRecall"
//					+"	,interfaceCallerList,interfaceCallerPredictionList,ImplementationCalleesList,ImplementationCalleesPredictionList"
//	+"	,SuperclassCallerList,SuperclassCallerPredictionList,ChildrenCalleesList,ChildrenCalleesPredictionList"
					+ ",OriginalCallers, OriginalCallerPredictions, OriginalCallees, OriginalCalleePredictions, Callers, CallerPredictions, Callees, CalleePredictions, IterationValues");
			LogInfo.bwfile3.newLine();
		}
		if (ProgramName.equals("jhotdraw")) {
			LogInfo.bwfile4.write(
					"MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold, TraceClassOldValue, TraceClassNewValue, PrecisionRecall"
//					+"	,interfaceCallerList,interfaceCallerPredictionList,ImplementationCalleesList,ImplementationCalleesPredictionList"
//	+"	,SuperclassCallerList,SuperclassCallerPredictionList,ChildrenCalleesList,ChildrenCalleesPredictionList"
					+ ",OriginalCallers, OriginalCallerPredictions, OriginalCallees, OriginalCalleePredictions, Callers, CallerPredictions, Callees, CalleePredictions, IterationValues");
			LogInfo.bwfile4.newLine();
		}

		for (MethodTrace methodtrace : MethodTracesHashmapValues) {
			String reqmethod = methodtrace.Requirement.ID + "-" + methodtrace.Method.ID;
			LogInfoHashMap.get(reqmethod);
			
			if (ProgramName.equals("gantt")) {
				LogInfo.bwfile2.write(LogInfoHashMap.get(reqmethod).toString());
				LogInfo.bwfile2.newLine();
				
				if(LogInfoHashMap.get(reqmethod).PrecisionRecall.equals("FP")) {
					LogInfo.bwfileFP.write(LogInfoHashMap.get(reqmethod).toString());
					LogInfo.bwfileFP.newLine();
				}
				
			}
			if (ProgramName.equals("chess")) {
				LogInfo.bwfileChess.write(LogInfoHashMap.get(reqmethod).toString());
				LogInfo.bwfileChess.newLine();
				
				
				if(LogInfoHashMap.get(reqmethod).PrecisionRecall.equals("FP")) {
					LogInfo.bwfile3Chess.write(LogInfoHashMap.get(reqmethod).toString());
					LogInfo.bwfile3Chess.newLine();
				}
			}
			if (ProgramName.equals("itrust")) {
				LogInfo.bwfile3.write(LogInfoHashMap.get(reqmethod).toString());
				LogInfo.bwfile3.newLine();
				
				if(LogInfoHashMap.get(reqmethod).PrecisionRecall.equals("FP")) {
					LogInfo.bwfile3iTrust.write(LogInfoHashMap.get(reqmethod).toString());
					LogInfo.bwfile3iTrust.newLine();
				}
			}
			if (ProgramName.equals("jhotdraw")) {
				LogInfo.bwfile4.write(LogInfoHashMap.get(reqmethod).toString());
				LogInfo.bwfile4.newLine();
				
				
				
				if(LogInfoHashMap.get(reqmethod).PrecisionRecall.equals("FN")) {
					LogInfo.bwfileFN.write(LogInfoHashMap.get(reqmethod).toString());
					LogInfo.bwfileFN.newLine();
				}
				
				if(LogInfoHashMap.get(reqmethod).PrecisionRecall.equals("FP")) {
					LogInfo.bwfile3jHotDraw.write(LogInfoHashMap.get(reqmethod).toString());
					LogInfo.bwfile3jHotDraw.newLine();
				}
			}
		}

		if (ProgramName.equals("chess")) {
			LogInfo.bwfileChess.close();
			LogInfo.bwfile3Chess.close();
		} else if (ProgramName.equals("gantt")) {
			LogInfo.bwfile2.close();
			LogInfo.bwfileFP.close();
			

		} else if (ProgramName.equals("itrust")) {
			LogInfo.bwfile3.close();
			LogInfo.bwfile3iTrust.close(); 
		} else if (ProgramName.equals("jhotdraw")) {
			LogInfo.bwfile4.close();
			LogInfo.bwfileFN.close();
			LogInfo.bwfile3jHotDraw.close();

		}
	}
	public static void CloseFiles(String ProgramName) throws IOException {
		// TODO Auto-generated method stub
		if (ProgramName.equals("chess")) {
			LogInfo.bwfileChess.close();
			LogInfo.bwfile3Chess.close();
		} else if (ProgramName.equals("gantt")) {
			LogInfo.bwfile2.close();
			LogInfo.bwfileFP.close();
			

		} else if (ProgramName.equals("itrust")) {
			LogInfo.bwfile3.close();
			LogInfo.bwfile3iTrust.close(); 
		} else if (ProgramName.equals("jhotdraw")) {
			LogInfo.bwfile4.close();
			LogInfo.bwfileFN.close();
			LogInfo.bwfile3jHotDraw.close();

		}
	}
	public static void closeLogFile() throws IOException {
		// TODO Auto-generated method stub
		LogInfo.bwfile1.newLine();
		LogInfo.bwfile1.close(); 
	}



}