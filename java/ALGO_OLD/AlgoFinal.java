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
import iTrust.DatabaseReading2itrust;
import iTrust.DatabaseReading2itrustfinal;
import mypackage.Children2;
import mypackage.ClassField2;
import mypackage.ClassRepresentation2;
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
import mypackage.MethodTraceSubjectTSubjectN;
import mypackage.Parameter2;
import mypackage.Requirement2;
import mypackage.RequirementGold;
import mypackage.SuperClass2;

public class AlgoFinal extends JFrame {

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

	ClassTrace2 myclasstrace = new ClassTrace2();
	static List<MethodTraceSubjectTSubjectN> methodtraces2 = new ArrayList<MethodTraceSubjectTSubjectN>();
	HashMap<String, List<String>> classMethodsHashMap = new HashMap<String, List<String>>();
	static HashMap<String, MethodTraceSubjectTSubjectN> methodtraces2HashMap = new HashMap<String, MethodTraceSubjectTSubjectN>();
	static HashMap<String, List<Parameter2>> parameterHashMap = new HashMap<String, List<Parameter2>>();
	static List<ClassTrace2> classtraces2 = new ArrayList<ClassTrace2>();
	LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass = new LinkedHashMap<String, ClassTrace2>();
	LinkedHashMap<String, ClassTrace2> methodtracesRequirementClassgold2 = new LinkedHashMap<String, ClassTrace2>();

	LinkedHashMap<String, Method2Details> linkedmethodhashmap = new LinkedHashMap<String, Method2Details>();
	HashMap<String, Interface2> InterfacesHashMap = new HashMap<String, Interface2>();
	HashMap<String, Interface2> InterfacesHashMapAlreadyImpl = new HashMap<String, Interface2>();
	HashMap<String, List<Interface2>> InterfacesOwnerClassHashMap = new HashMap<String, List<Interface2>>();
	HashMap<String, List<MethodField2>> FieldMethodsHashMap = new HashMap<String, List<MethodField2>>();
	HashMap<String, List<ClassField2>> FieldClassesHashMap = new HashMap<String, List<ClassField2>>();
	HashMap<String, List<SuperClass2>> SuperclassesHashMap = new HashMap<String, List<SuperClass2>>();
	HashMap<String, List<Children2>> ChildrenHashMap = new HashMap<String, List<Children2>>();
	HashMap<String, List<Implementation2>> INTERFACEHASHMAPFINAL = new HashMap<String, List<Implementation2>>();
	HashMap<String, String> RequirementMethodNameClassIDHashMap = new HashMap<String, String>(); 
	
	
	HashMap<String, List<Interface2>> InterfacesOwnerClassHashMapMethodTraces = new HashMap<String, List<Interface2>>();
	HashMap<String, List<Implementation2>> INTERFACEHASHMAPFINALMethodTraces = new HashMap<String, List<Implementation2>>();
	HashMap<String, List<SuperClass2>> SuperclassesHashMapMethodTraces = new HashMap<String, List<SuperClass2>>();
	HashMap<String, List<Children2>> ChildrenHashMapMethodTraces = new HashMap<String, List<Children2>>();

	
	
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

	public AlgoFinal(String ProgramName) throws SQLException, IOException {

		LinkedHashMap<String, String> PredictionsOldHashMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> PredictionsNewHashMap = new LinkedHashMap<String, String>();

		int j = 0;
		List<MethodTraceSubjectTSubjectN> methodtracesNew = InitializePredictionsHashMap2(methodtraces2);
		TracePredictionFunction(j, PredictionsOldHashMap, PredictionsNewHashMap, methodtracesNew, ProgramName);

	}

	public List<MethodTraceSubjectTSubjectN> InitializePredictionsHashMap2(
			List<MethodTraceSubjectTSubjectN> methodtracesNew) {
		// TODO Auto-generated method stub

		for (MethodTraceSubjectTSubjectN meth : methodtracesNew) {
			meth.setPrediction("");
		}
		return methodtracesNew;
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public LinkedHashMap<String, String> TracePredictionFunction(int j,
			LinkedHashMap<String, String> PredictionsOldHashMap, LinkedHashMap<String, String> PredictionsNewHashMap,
			List<MethodTraceSubjectTSubjectN> methodtraces22, String ProgramName) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int ITERATION1 = 0;

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
			File filelogChess = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\TableLogChess.txt");
			FileOutputStream fosfilChess = new FileOutputStream(filelogChess);
			bwfileChess = new BufferedWriter(new OutputStreamWriter(fosfilChess));
			
			File filelogFPChess = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\FalsePositiveDetailsChess.txt");
			FileOutputStream fosfilaFPChess = new FileOutputStream(filelogFPChess);
			 bwfile3Chess = new BufferedWriter(new OutputStreamWriter(fosfilaFPChess));
		}

		if (ProgramName.equals("gantt")) {
			File filelog2 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\TableLogGantt.txt");
			FileOutputStream fosfila2 = new FileOutputStream(filelog2);
			bwfile2 = new BufferedWriter(new OutputStreamWriter(fosfila2));
			
			File filelogFP = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\FalsePositiveDetailsGantt.txt");
			FileOutputStream fosfilaFP = new FileOutputStream(filelogFP);
			 bwfileFP = new BufferedWriter(new OutputStreamWriter(fosfilaFP));
		}

		if (ProgramName.equals("itrust")) {
			File filelog3 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\TableLogiTrust.txt");
			FileOutputStream fosfila5 = new FileOutputStream(filelog3);
			bwfile3 = new BufferedWriter(new OutputStreamWriter(fosfila5));
			
			File filelog3iTrust = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\FalsePositiveDetailsiTrust.txt");
			FileOutputStream fosfila5iTrust = new FileOutputStream(filelog3iTrust);
			bwfile3iTrust = new BufferedWriter(new OutputStreamWriter(fosfila5iTrust));
		}

		if (ProgramName.equals("jhotdraw")) {
			File filelog4 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\TableLogJHotDraw.txt");
			FileOutputStream fosfila4 = new FileOutputStream(filelog4);
			bwfile4 = new BufferedWriter(new OutputStreamWriter(fosfila4));
			
			File filelogFN = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\FalseNegativeDetailsJHotDraw.txt");
			FileOutputStream fosfilaFN = new FileOutputStream(filelogFN);
			 bwfileFN = new BufferedWriter(new OutputStreamWriter(fosfilaFN));
			 
			 File filelog3JHotDraw = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\FalsePositiveDetailsJHotDraw.txt");
				FileOutputStream fosfila5JHotDraw = new FileOutputStream(filelog3JHotDraw);
				bwfile3jHotDraw = new BufferedWriter(new OutputStreamWriter(fosfila5JHotDraw));
		}
		Collection<MethodTraceSubjectTSubjectN> MethodTracesHashmapValues = methodtraces2HashMap.values();
		// bwfile2.newLine();
		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
			methodtrace.setPrediction("E");
		}
		if (ProgramName.equals("chess")) {

			File file1log = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\PrecisionRecallChess.txt");
			FileOutputStream fosfila1 = new FileOutputStream(file1log);
			bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

			
			File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\TracesClassesChess.txt");
			FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
			bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
			
			
			db = new DatabaseReading2();
			DatabaseReading2.MakePredictions();
			classMethodsHashMap = db.getClassMethodsHashMap();
			methodtraces2 = db.getMethodtraces2SubjectTSubjectN();
			methodtraces2HashMap = db.getMethodtracehashmap();
			classtraces2 = db.getClassestraces2();
			//System.out.println("yes");
			// methodlist = db.getMethodlist();
			methodtracesRequirementClass = db.getClassesRequirementtraceshashmap();
			InterfacesHashMap = db.getInterfaces();
			linkedmethodhashmap = db.getLinkedmethodhashmap();
			InterfacesHashMapAlreadyImpl = db.getInterfacehashmapAlreadyImpl();
			// INTERFACES
			InterfacesOwnerClassHashMap = db.getInterfacehashmapOwnerClass();
			// FIELD METHODS
			FieldMethodsHashMap = db.getMethodFieldHashMap();
			// FIELD CLASSES
			FieldClassesHashMap = db.getClassFieldHashMap();
			// SUPERCLASSES
			SuperclassesHashMap = db.getSuperclassesHashMap();
			// PARAMETERS

			parameterHashMap = db.getParameterhashMap();

			methodtraces2 = db.getMethodtraces2SubjectTSubjectN();
			methodtraces2HashMap = db.getMethodtracehashmap();
			classtraces2 = db.getClassestraces2();
			// methodlist = db.getMethodlist();
			methodtracesRequirementClass = db.getClassesRequirementtraceshashmap();
			InterfacesHashMap = db.getInterfaces();
			linkedmethodhashmap = db.getLinkedmethodhashmap();
			InterfacesHashMapAlreadyImpl = db.getInterfacehashmapAlreadyImpl();
			// INTERFACES
			InterfacesOwnerClassHashMap = db.getInterfacehashmapOwnerClass();
			// FIELD METHODS
			FieldMethodsHashMap = db.getMethodFieldHashMap();
			// FIELD CLASSES
			FieldClassesHashMap = db.getClassFieldHashMap();
			// SUPERCLASSES
			SuperclassesHashMap = db.getSuperclassesHashMap();
			// CHILDREN
			ChildrenHashMap = db.getChildrenHashMap();
			// IMPLEMENTATIONS
			INTERFACEHASHMAPFINAL = db.getINTERFACEHASHMAPFINAL();
			// PARAMETERS

			parameterHashMap = db.getParameterhashMap();

		} else if (ProgramName.equals("gantt")) {

			File file1log = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\PrecisionRecallGantt.txt");
			FileOutputStream fosfila1 = new FileOutputStream(file1log);
			bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

			
			File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\TracesClassesGantt.txt");
			FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
			bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
			
			
			dbgantt = new DatabaseReading2Gantt();
			DatabaseReading2Gantt.MakePredictions();
			classMethodsHashMap = dbgantt.getClassMethodsHashMap();

			methodtraces2 = dbgantt.getMethodtraces2SubjectTSubjectN();
			methodtraces2HashMap = dbgantt.getMethodtracehashmap();
			classtraces2 = dbgantt.getClassestraces2();
			// methodlist = dbgantt.getMethodlist();
			methodtracesRequirementClass = dbgantt.getClassesRequirementtraceshashmap();
			InterfacesHashMap = dbgantt.getInterfaces();
			linkedmethodhashmap = dbgantt.getLinkedmethodhashmap();
			InterfacesHashMapAlreadyImpl = dbgantt.getInterfacehashmapAlreadyImpl();
			// INTERFACES
			InterfacesOwnerClassHashMap = dbgantt.getInterfacehashmapOwnerClass();
			// FIELD METHODS
			FieldMethodsHashMap = dbgantt.getMethodFieldHashMap();
			// FIELD CLASSES
			FieldClassesHashMap = dbgantt.getClassFieldHashMap();
			// SUPERCLASSES
			SuperclassesHashMap = dbgantt.getSuperclassesHashMap();
			// PARAMETERS

			parameterHashMap = dbgantt.getParameterhashMap();

			methodtraces2 = dbgantt.getMethodtraces2SubjectTSubjectN();
			methodtraces2HashMap = dbgantt.getMethodtracehashmap();
			classtraces2 = dbgantt.getClassestraces2();
			// methodlist = dbgantt.getMethodlist();
			methodtracesRequirementClass = dbgantt.getClassesRequirementtraceshashmap();
			InterfacesHashMap = dbgantt.getInterfaces();
			linkedmethodhashmap = dbgantt.getLinkedmethodhashmap();
			InterfacesHashMapAlreadyImpl = dbgantt.getInterfacehashmapAlreadyImpl();
			// INTERFACES
			InterfacesOwnerClassHashMap = dbgantt.getInterfacehashmapOwnerClass();
			// FIELD METHODS
			FieldMethodsHashMap = dbgantt.getMethodFieldHashMap();
			// FIELD CLASSES
			FieldClassesHashMap = dbgantt.getClassFieldHashMap();
			// SUPERCLASSES
			SuperclassesHashMap = dbgantt.getSuperclassesHashMap();
			// CHILDREN
			ChildrenHashMap = dbgantt.getChildrenHashMap();
			// IMPLEMENTATIONS
			INTERFACEHASHMAPFINAL = dbgantt.getINTERFACEHASHMAPFINAL();
			// PARAMETERS

			parameterHashMap = dbgantt.getParameterhashMap();
		} else if (ProgramName.equals("jhotdraw")) {

			File file1log = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\PrecisionRecallJHotDraw.txt");
			FileOutputStream fosfila1 = new FileOutputStream(file1log);
			bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

			
			File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\TracesClassesJHotDraw.txt");
			FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
			bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
			
			
			dbjhotdraw = new DatabaseReading2JHotDraw3();
			DatabaseReading2JHotDraw3.MakePredictions();
			classMethodsHashMap = dbjhotdraw.getClassMethodsHashMap();

			methodtraces2 = dbjhotdraw.getMethodtraces2SubjectTSubjectN();
			methodtraces2HashMap = dbjhotdraw.getMethodtracehashmap();
			classtraces2 = dbjhotdraw.getClassestraces2();
			// methodlist = dbjhotdraw.getMethodlist();
			methodtracesRequirementClass = dbjhotdraw.getClassesRequirementtraceshashmap();
			InterfacesHashMap = dbjhotdraw.getInterfaces();
			linkedmethodhashmap = dbjhotdraw.getLinkedmethodhashmap();
			InterfacesHashMapAlreadyImpl = dbjhotdraw.getInterfacehashmapAlreadyImpl();
			// INTERFACES
			InterfacesOwnerClassHashMap = dbjhotdraw.getInterfacehashmapOwnerClass();
			// FIELD METHODS
			FieldMethodsHashMap = dbjhotdraw.getMethodFieldHashMap();
			// FIELD CLASSES
			FieldClassesHashMap = dbjhotdraw.getClassFieldHashMap();
			// SUPERCLASSES
			SuperclassesHashMap = dbjhotdraw.getSuperclassesHashMap();
			// PARAMETERS

			parameterHashMap = dbjhotdraw.getParameterhashMap();

			methodtraces2 = dbjhotdraw.getMethodtraces2SubjectTSubjectN();
			methodtraces2HashMap = dbjhotdraw.getMethodtracehashmap();
			classtraces2 = dbjhotdraw.getClassestraces2();
			// methodlist = dbjhotdraw.getMethodlist();
			methodtracesRequirementClass = dbjhotdraw.getClassesRequirementtraceshashmap();
			InterfacesHashMap = dbjhotdraw.getInterfaces();
			linkedmethodhashmap = dbjhotdraw.getLinkedmethodhashmap();
			InterfacesHashMapAlreadyImpl = dbjhotdraw.getInterfacehashmapAlreadyImpl();
			// INTERFACES
			InterfacesOwnerClassHashMap = dbjhotdraw.getInterfacehashmapOwnerClass();
			// FIELD METHODS
			FieldMethodsHashMap = dbjhotdraw.getMethodFieldHashMap();
			// FIELD CLASSES
			FieldClassesHashMap = dbjhotdraw.getClassFieldHashMap();
			// SUPERCLASSES
			SuperclassesHashMap = dbjhotdraw.getSuperclassesHashMap();
			// CHILDREN
			ChildrenHashMap = dbjhotdraw.getChildrenHashMap();
			// IMPLEMENTATIONS
			INTERFACEHASHMAPFINAL = dbjhotdraw.getINTERFACEHASHMAPFINAL();
			// PARAMETERS

			parameterHashMap = dbjhotdraw.getParameterhashMap();
		} else if (ProgramName.equals("itrust")) {

			File file1log = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\PrecisionRecalliTrust.txt");
			FileOutputStream fosfila1 = new FileOutputStream(file1log);
			bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

			
			File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\TracesClassesiTrust.txt");
			FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
			bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
			
			
			dbitrust = new DatabaseReading2itrustfinal();
			DatabaseReading2itrustfinal.MakePredictions();
			classMethodsHashMap = dbitrust.getClassMethodsHashMap();

			methodtraces2 = dbitrust.getMethodtraces2SubjectTSubjectN();
			methodtraces2HashMap = dbitrust.getMethodtracehashmap();
			classtraces2 = dbitrust.getClassestraces2();
			// methodlist = dbitrust.getMethodlist();
			methodtracesRequirementClass = dbitrust.getClassesRequirementtraceshashmap();
			InterfacesHashMap = dbitrust.getInterfaces();
			linkedmethodhashmap = dbitrust.getLinkedmethodhashmap();
			InterfacesHashMapAlreadyImpl = dbitrust.getInterfacehashmapAlreadyImpl();
			// INTERFACES
			InterfacesOwnerClassHashMap = dbitrust.getInterfacehashmapOwnerClass();
			// FIELD METHODS
			FieldMethodsHashMap = dbitrust.getMethodFieldHashMap();
			// FIELD CLASSES
			FieldClassesHashMap = dbitrust.getClassFieldHashMap();
			// SUPERCLASSES
			SuperclassesHashMap = dbitrust.getSuperclassesHashMap();
			// PARAMETERS

			parameterHashMap = dbitrust.getParameterhashMap();

			methodtraces2 = dbitrust.getMethodtraces2SubjectTSubjectN();
			methodtraces2HashMap = dbitrust.getMethodtracehashmap();
			classtraces2 = dbitrust.getClassestraces2();
			// methodlist = dbitrust.getMethodlist();
			methodtracesRequirementClass = dbitrust.getClassesRequirementtraceshashmap();
			InterfacesHashMap = dbitrust.getInterfaces();
			linkedmethodhashmap = dbitrust.getLinkedmethodhashmap();
			InterfacesHashMapAlreadyImpl = dbitrust.getInterfacehashmapAlreadyImpl();
			// INTERFACES
			InterfacesOwnerClassHashMap = dbitrust.getInterfacehashmapOwnerClass();
			// FIELD METHODS
			FieldMethodsHashMap = dbitrust.getMethodFieldHashMap();
			// FIELD CLASSES
			FieldClassesHashMap = dbitrust.getClassFieldHashMap();
			// SUPERCLASSES
			SuperclassesHashMap = dbitrust.getSuperclassesHashMap();
			// CHILDREN
			ChildrenHashMap = dbitrust.getChildrenHashMap();
			// IMPLEMENTATIONS
			INTERFACEHASHMAPFINAL = dbitrust.getINTERFACEHASHMAPFINAL();
			// PARAMETERS

			parameterHashMap = dbitrust.getParameterhashMap();
		}

		CalculateChildrenInterfacesTracesClasses();
		LinkedHashMap<String, LogInfo> LogInfoHashMap = new LinkedHashMap<String, LogInfo>();
		LinkedHashMap<String, LogInfo> LogHashMapRemaining = new LinkedHashMap<String, LogInfo>();
		LinkedHashMap<String, String> LogHashMapRemainingNewVals = new LinkedHashMap<String, String>();

		LinkedHashMap<String, String> RequirementClassHashMapNewValues = new LinkedHashMap<String, String>();
		MethodTracesHashmapValues = methodtraces2HashMap.values();

		LogInfoHashMap=InitializeLogInfoHashMap(LogInfoHashMap,MethodTracesHashmapValues ); 

		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {

			String reqclass = methodtrace.Requirement.getID() + "-" + methodtrace.getClassRepresentation().classid;
			String reqmethod = methodtrace.Requirement.getID() + "-" + methodtrace.getMethod().methodid;
			//System.out.println(reqclass);

			ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);
			//System.out.println(myclasstraceHashMap);

			String traceClassOldValue = myclasstraceHashMap.getTraceFinal(); 
			LogInfo LogInfo= new LogInfo(); 
			 if(LogInfoHashMap.get(reqmethod)!=null) {
				  LogInfo= LogInfoHashMap.get(reqmethod); 
			 }else {
				 LogInfo= new LogInfo(); 
			 }
			LogInfo.setTraceClassOldValue(traceClassOldValue);
			LogInfoHashMap.put(reqmethod, LogInfo); 
			
		}
		
		PredictionValues TotalPredictionValues = new PredictionValues(); 
		PredictionValues RemainingpredictionValues = new PredictionValues(); 
		PredictionValues PredictionClassTraceBefore = new PredictionValues(); 
		PredictionValues PredictionClassTraceAfter = new PredictionValues(); 

		CountTracesClassesValues(PredictionClassTraceBefore, methodtracesRequirementClass); 
		bwTraceClass.write("BEFORE PATTERN 0 "+PredictionClassTraceBefore.toString());
		bwTraceClass.newLine();

		RequirementClassHashMapNewValues = GenerateNewValuesInTracesClasses(RequirementClassHashMapNewValues, methodtracesRequirementClass);
		CountTracesClassesValues(PredictionClassTraceAfter, methodtracesRequirementClass); 

		bwTraceClass.write("AFTER PATTERN 0 "+PredictionClassTraceAfter.toString());
		bwTraceClass.close();
		j = 0;

		LogInfoHashMap = IntroduceNewValuesWithinLogInfoHashMap(RequirementClassHashMapNewValues, classMethodsHashMap,
				LogInfoHashMap);

		MethodTracesHashmapValues = methodtraces2HashMap.values();
		RequirementMethodNameClassIDHashMap=InitializeRequirementMethodNameClassIDHashMap(RequirementMethodNameClassIDHashMap, MethodTracesHashmapValues); 
		LogInfoHashMap=InitializeHashMapWithPrecisionRecall(MethodTracesHashmapValues, LogInfoHashMap);
		HashMap<String, HashMap<String, String>> mystorageValues= new HashMap<String, HashMap<String, String>>(); 
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// OWNER CLASS PATTERN
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
	int counter=0;
		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {

			String reqclass = methodtrace.Requirement.getID() + "-" + methodtrace.getClassRepresentation().classid;
			ClassTrace2 myclasstrace = methodtracesRequirementClass.get(reqclass);
			String reqMethod = methodtrace.Requirement.getID() + "-" + methodtrace.getMethod().methodid;
			ITERATION1 = 0;
			LogInfo loginfo = new LogInfo();
			if (LogInfoHashMap.get(reqMethod) != null) {
				loginfo = LogInfoHashMap.get(reqMethod);
			}

			loginfo.setRequirementID(methodtrace.getRequirement().ID);
			loginfo.setRequirementName(methodtrace.getRequirement().RequirementName);
			loginfo.setMethodID(methodtrace.getMethod().methodid);
			loginfo.setMethodName(methodtrace.getMethod().methodname);
			loginfo.setClassID(methodtrace.getClassRepresentation().classid);
			loginfo.setClassName(methodtrace.getClassRepresentation().classname);
			loginfo.setTraceValue(methodtrace.getGoldfinal());
			loginfo.setGoldFinal(myclasstrace.getGoldfinal());
			loginfo.setSubjectGold(myclasstrace.getSubjectGold());

			//System.out.println("Trace Class New Value "+loginfo.getTraceClassNewValue());
			String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethod().methodname+"-"+methodtrace.getClassRepresentation().classid; 
			//System.out.println("myclasstraceHashMap.getTraceFinal()"+myclasstrace.getTraceFinal());
			//System.out.println("REQ METHOD ==========================="+reqmethod);
			LogInfoHashMap.put(reqMethod, loginfo); 
			if (myclasstrace.getTraceFinal() != null) {
				
			
				//System.out.println("goldfinal"+methodtrace.getGoldfinal()+"--gold"+methodtrace.getGold());
			// PATTERN 1
		
				
			
				
				String tracegold2 = myclasstrace.getTraceFinal();
				tracegold2 = tracegold2.trim();
//				System.out.println(tracegold2);
				if (tracegold2.equals("T") ) {
						
						SetPredictionFinal(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, "E", methodtraces2HashMap); 
						
						
					
				

				} else if (tracegold2.equals("N")) {
//					System.out.println("ReqMethod "+reqmethod);
					SetPredictionFinal(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, "N", methodtraces2HashMap); 
					counter++; 

				}

				else {
					SetPredictionFinal(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, "E", methodtraces2HashMap); 


				}
				ITERATION1++;
			

			j++;
			
			
		}
		}
		System.out.println(counter);
		LinkedHashMap<String, MethodTraceSubjectTSubjectN> MyfinalHashMap = RetrievePredictionsHashMap(methodtraces2);
		MyfinalHashMap=SetFlagOwnerClassPattern(MyfinalHashMap, TotalPattern, LogInfoHashMap, ProgramName); 
		 PredictionValues OwnerClassPredictionValues = new PredictionValues(); 

		WriteInDatabaseAndComputePrecisionAndRecallOwner(MyfinalHashMap,TotalPattern, ProgramName, LogInfoHashMap, OwnerClassPredictionValues);
		 bwfile1.write("OWNER CLASS PRED 				"+ProgramName+" "+TotalPattern.toString());
		 bwfile1.newLine();
		 bwfile1.write("owner class prediction values	"+ProgramName+" "+OwnerClassPredictionValues.toString());
		 bwfile1.newLine();
		
		
		//System.out.println("===============>PATTERNS 1 SET TO T   ITERATION " + ITERATION1 + "   PREDICTION VALUES "+ TotalPattern.toString());

		int ITERATION = 0;
		MethodTracesHashmapValues=methodtraces2HashMap.values(); 

		SetPredictionCallersCallees(MethodTracesHashmapValues, LogInfoHashMap); 
		
		PredictionsNewHashMap = InitializePredictionsHashMap(PredictionsNewHashMap, MethodTracesHashmapValues);
		
		

		 LogHashMapRemaining = new LinkedHashMap<String, LogInfo>();
		LogHashMapRemaining=InitializeHashMapWithPrecisionRecallRemaining(MethodTracesHashmapValues, LogHashMapRemaining, LogInfoHashMap); 
		
		while (Equals(PredictionsOldHashMap, PredictionsNewHashMap) == false) {

			PredictionsOldHashMap = InitializePredictionsHashMap(PredictionsOldHashMap, MethodTracesHashmapValues);

			//System.out.println("-------------------------------------------");
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
			for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
				String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.getMethod().methodid;
				String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethod().methodname+"-"+methodtrace.getClassRepresentation().classid; 
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				// PURE PATTERNS
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////


				// PURE T PATTERN


				if (    !methodtrace.getMethod().getExtendedCallees().isEmpty() && !methodtrace.getMethod().getExtendedCallers().isEmpty()
						&& methodtrace.getMethod().getExtendedCallees().AllTs(methodtrace.Requirement, methodtrace, methodtraces2HashMap)
						&& methodtrace.getMethod().getExtendedCallers().AllTs(methodtrace.Requirement, methodtrace, methodtraces2HashMap)					
						

				) {
					SetPredictionFinalNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
							LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,PureT", methodtraces2HashMap); 

					

				}
				// PURE N PATTERN
				else if ( !methodtrace.getMethod().getExtendedCallees().isEmpty() && !methodtrace.getMethod().getExtendedCallers().isEmpty()
						&& methodtrace.getMethod().getExtendedCallees().AllNs(methodtrace.Requirement, methodtrace, methodtraces2HashMap)
						&& methodtrace.getMethod().getExtendedCallers().AllNs(methodtrace.Requirement, methodtrace, methodtraces2HashMap)

				) {
					SetPredictionFinalNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
							LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "N", "N,PureN", methodtraces2HashMap); 
				

				}

				 
				// PURE T LEAF PATTERN
				 if (	methodtrace.getMethod().getExtendedCallees().isEmpty() && !methodtrace.getMethod().getExtendedCallers().isEmpty()
						 && methodtrace.getMethod().getExtendedCallers().AllTs(methodtrace.Requirement,methodtrace, methodtraces2HashMap)

				) {
					 SetPredictionFinalNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,PureTLeaf", methodtraces2HashMap); 

				}
				// PURE N LEAF PATTERN
				 else if (methodtrace.getMethod().getExtendedCallees().isEmpty() && !methodtrace.getMethod().getExtendedCallers().isEmpty()
						 && methodtrace.getMethod().getExtendedCallers().AllNs(methodtrace.Requirement, methodtrace, methodtraces2HashMap)

				) {

					 SetPredictionFinalNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "N", "N,PureNLeaf", methodtraces2HashMap); 
				}

				
				k++;

			}

			k = 0;
			
			for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
				String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.getMethod().methodid;
				String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethod().methodname+"-"+methodtrace.getClassRepresentation().classid; 
				//System.out.println();
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				// MIXED PATTERNS
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				// MIXED T PATTERN
				 if (!methodtrace.getMethod().getExtendedCallees().isEmpty() && !methodtrace.getMethod().getExtendedCallers().isEmpty() 
					&& methodtrace.getMethod().getExtendedCallees().AtLeast1T(methodtrace.Requirement, methodtrace, methodtraces2HashMap) 
					&& methodtrace.getMethod().getExtendedCallers().AtLeast1T(methodtrace.Requirement, methodtrace, methodtraces2HashMap) 

				) {
					// methodtrace.setPrediction("N");
					 SetPredictionFinalNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,MixedT", methodtraces2HashMap); 

					// //System.out.println("yes");
				}
				// MIXED N PATTERN
				 else if (!methodtrace.getMethod().getExtendedCallees().isEmpty() && !methodtrace.getMethod().getExtendedCallers().isEmpty()
						
						&& methodtrace.getMethod().getExtendedCallees().AllNs(methodtrace.Requirement, methodtrace, methodtraces2HashMap) 
						&& methodtrace.getMethod().getExtendedCallers().AllNs(methodtrace.Requirement, methodtrace, methodtraces2HashMap) 
						

				) {

					 SetPredictionFinalNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "N", "N,MixedN", methodtraces2HashMap); 

					// //System.out.println("yes");
				}
				

				
				 
				// MIXED T LEAF PATTERN
				 if (methodtrace.getMethod().getExtendedCallees().isEmpty() && !methodtrace.getMethod().getExtendedCallers().isEmpty() 
						 && methodtrace.getMethod().getExtendedCallers().AtLeast1T(methodtrace.Requirement, methodtrace, methodtraces2HashMap) 

				) {
					 SetPredictionFinalNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,MixedTLeaf", methodtraces2HashMap); 

				}// MIXED N LEAF PATTERN
				 else if(methodtrace.getMethod().getExtendedCallees().isEmpty() && !methodtrace.getMethod().getExtendedCallers().isEmpty() 
						 && methodtrace.getMethod().getExtendedCallers().AllNs(methodtrace.Requirement, methodtrace, methodtraces2HashMap) 

				) {
					 SetPredictionFinalNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "N", "N,MixedNLeaf", methodtraces2HashMap); 

				}
				k++;
			}
			
			// PRINT

			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
			//the following line should not be moved when putting 3 before 1-2 (3-1-2 combination)
			MyfinalHashMap = RetrievePredictionsHashMap(methodtraces2);
			// WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap,
			// NEWPATTERNMethodCallsSetToT);
			//System.out.println("===============>PATTERNS 3 AND 5 ITERATION SET TO T  ITERATION " + ITERATION+ "   PREDICTION VALUES " + TotalPattern.toString());
			// END PRINT
			CalculateChildrenInterfacesMethodTraces(RequirementMethodNameClassIDHashMap);
			
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			
			
			for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
				String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.Method.methodid;
//				LogInfo LogInfo = LogInfoHashMap.get(reqMethod);
//				List<String> IterationValues = LogInfo.getIterationValues();
//				Methods<String> interfaces = methodtrace.getInterfacesFinalList();
//				Methods<String> implementations = methodtrace.getImplementationFinalList(); 
//				Methods<String> superclasses = methodtrace.getSuperClassesFinalList(); 
//				Methods<String> children = methodtrace.getChildrenFinalList(); 
//				String reqClass = methodtrace.Requirement.ID + "-" + methodtrace.ClassRepresentation.classid; 
//				List<String> interfaceTraceValues = new ArrayList<String>();
//				List<String> implementationsTraceValues = new ArrayList<String>();
//				List<String> superclassesTraceValues = new ArrayList<String>();
//				List<String> childrenTraceValues = new ArrayList<String>();
//				boolean InterfacesFlag=false, ImplementationsFlag=false, SuperclassesFlag=false, ChildrenFlag=false; 
//
//				
//				computeVariables(InterfacesFlag, ImplementationsFlag, SuperclassesFlag, ChildrenFlag, interfaces, implementations, superclasses, children, implementationsTraceValues, childrenTraceValues, superclassesTraceValues, interfaceTraceValues); 
//			
//				System.out.println(implementationsTraceValues);
//
//				InterfacesFlag = interfaceTraceValues.stream().distinct().limit(2).count() <= 1
//					&& interfaceTraceValues.size() >= 1;
//			 ImplementationsFlag = implementationsTraceValues.stream().distinct().limit(2).count() <= 1
//					&& implementationsTraceValues.size() >= 1;
//			SuperclassesFlag = superclassesTraceValues.stream().distinct().limit(2).count() <= 1
//					&& superclassesTraceValues.size() >= 1;
//			 ChildrenFlag = childrenTraceValues.stream().distinct().limit(2).count() <= 1
//					&& childrenTraceValues.size() >= 1;
					
					
					
					
				
					
					
//				if (
//						methodtrace.getInterfacesFinalList().AllTs(InterfacesFlag, interfaceTraceValues, methodtrace) 
//						||methodtrace.getImplementationFinalList().AllTs(ImplementationsFlag, implementationsTraceValues, methodtrace)
//						||methodtrace.getSuperClassesFinalList().AllTs(SuperclassesFlag, superclassesTraceValues, methodtrace)
//						||methodtrace.getChildrenFinalList().AllTs(ChildrenFlag, childrenTraceValues, methodtrace))
//						
//					
//
//				{
//					System.out.println("==========T  "+reqMethod);
//					 SetPredictionFinalNonOwnerInheritance(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, RequirementMethodNameClassIDHashMap, 
//								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,AllTInheritance"); 
//					
//
//				}
//				else if (methodtrace.getInterfacesFinalList().AllNs(InterfacesFlag, interfaceTraceValues, methodtrace) 
//						||methodtrace.getImplementationFinalList().AllNs(ImplementationsFlag, implementationsTraceValues, methodtrace)
//						||methodtrace.getSuperClassesFinalList().AllNs(SuperclassesFlag, superclassesTraceValues, methodtrace)
//						||methodtrace.getChildrenFinalList().AllNs(ChildrenFlag, childrenTraceValues, methodtrace)
//
//				)
//
//				{
//					System.out.println("==========N  "+reqMethod);
//					 SetPredictionFinalNonOwnerInheritance(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, RequirementMethodNameClassIDHashMap, 
//								LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "N", "N,AllNInheritance"); 
//					
//
//				}

				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				// SUPERCLASSES , CHILDREN , INTERFACES , IMPLEMENTATIONS  PATTERN 3
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
					
					if (
							methodtrace.getMethod().getInterfaces().AllTs(methodtrace.Requirement,methodtrace, methodtraces2HashMap)
							||methodtrace.getMethod().getImplementations().AllTs(methodtrace.Requirement,methodtrace, methodtraces2HashMap)
							||methodtrace.getMethod().getSuperclasses().AllTs(methodtrace.Requirement,methodtrace, methodtraces2HashMap)
							||methodtrace.getMethod().getChildren().AllTs(methodtrace.Requirement,methodtrace, methodtraces2HashMap)
							
							)
							
						

					{
//						System.out.println("==========T  "+reqMethod);
						 SetPredictionFinalNonOwnerInheritance(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod,  
									LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,AllTInheritance"); 
						

					}
					else if (
							
							methodtrace.getMethod().getInterfaces().AllNs(methodtrace.Requirement,methodtrace, methodtraces2HashMap)
							||methodtrace.getMethod().getImplementations().AllNs(methodtrace.Requirement,methodtrace, methodtraces2HashMap)
							||methodtrace.getMethod().getSuperclasses().AllNs(methodtrace.Requirement,methodtrace, methodtraces2HashMap)
							||methodtrace.getMethod().getChildren().AllNs(methodtrace.Requirement,methodtrace, methodtraces2HashMap)

					)

					{
//						System.out.println("==========N  "+reqMethod);
						 SetPredictionFinalNonOwnerInheritance(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod,
									LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "N", "N,AllNInheritance"); 
						

					}

			}
	
			
			
			
			
			
			
				
			
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
				
				for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
					String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.getMethod().methodid;
					String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethod().methodname+"-"+methodtrace.getClassRepresentation().classid; 
					//System.out.println();
					
					
					//////////////////////////////////////////////////////////////////////////////////////////
					//////////////////////////////////////////////////////////////////////////////////////////
					// ALL CALLERS PATTERN 4.1
					//////////////////////////////////////////////////////////////////////////////////////////
					//////////////////////////////////////////////////////////////////////////////////////////
				
					
					// ALL T CALLERS 
					 if (!methodtrace.getMethod().getExtendedCallers().isEmpty() 
						&& methodtrace.getMethod().getExtendedCallers().AllTs(methodtrace.Requirement, methodtrace, methodtraces2HashMap) 
						&& methodtrace.getPrediction().trim().equals("E")
	
					) {
						// methodtrace.setPrediction("N");
						 SetPredictionFinalNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
									LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,AllTCallers", methodtraces2HashMap); 

						// //System.out.println("yes");
					}
					// ALL N CALLERS
					 else if (!methodtrace.getMethod().getExtendedCallers().isEmpty() 
								&& methodtrace.getMethod().getExtendedCallers().AllNs(methodtrace.Requirement, methodtrace, methodtraces2HashMap) 
								&& methodtrace.getPrediction().trim().equals("E")
	
							) {
	
						 SetPredictionFinalNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
									LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "N", "N,AllNCallers", methodtraces2HashMap); 

	
						// //System.out.println("yes");
					}
					
	
					
					 
				
					k++;
				}
				

				
			
			
			for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
				String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.getMethod().methodid;
				String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethod().methodname+"-"+methodtrace.getClassRepresentation().classid; 
				
				
				
				
				
				
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				//ALL CALLEES PATTERN 5
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				
				
				
				
				//ALL T CALLEES 
				if (!methodtrace.getMethod().getExtendedCallees().isEmpty() 
				&& methodtrace.getMethod().getExtendedCallees().AllTs(methodtrace.Requirement, methodtrace, methodtraces2HashMap) 
				&& methodtrace.getPrediction().trim().equals("E")
				
				) {
				//methodtrace.setPrediction("N");
				SetPredictionFinalNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
				LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "T", "T,AllTCallees", methodtraces2HashMap); 
				
				
				////System.out.println("yes");
				}
				//ALL N CALLEES
				else if (!methodtrace.getMethod().getExtendedCallees().isEmpty() 
				&& methodtrace.getMethod().getExtendedCallees().AllNs(methodtrace.Requirement, methodtrace, methodtraces2HashMap) 
				&& methodtrace.getPrediction().trim().equals("E")
				
				) {
				
				SetPredictionFinalNonOwner(LogInfoHashMap.get(reqMethod), methodtrace, LogInfoHashMap, reqMethod, 
				LogInfoHashMap.get(reqMethod).getIterationValues(), LogHashMapRemainingNewVals,LogHashMapRemaining, "N", "N,AllNCallees", methodtraces2HashMap); 
				
				
				////System.out.println("yes");
				}
				k++;
				}	
		
		
				

		
				
				
			
			
			
			
			
				
				
				
				
				

				
				
				
				
			
				
		
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// END PATTERNS 
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			
			
			
			
			
			
			
			
			
			
			// PRINT

			for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
				String ReqMethod = methodtrace.Requirement.ID + "-" + methodtrace.Method.methodid;
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
			MyfinalHashMap = RetrievePredictionsHashMap(methodtraces2);

			// END PRINT
			ITERATION++;
			//System.out.println("HEEEEEEY  " + ITERATION);

			PredictionsNewHashMap = InitializePredictionsHashMap(PredictionsNewHashMap, MethodTracesHashmapValues);
		}
		
		
		
		
		
	
		
		
		
		
		
		
		
		//SET EVERYTHING ELSE TO T 
//		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
//
//			if(methodtrace.getPrediction().equals("") || methodtrace.getPrediction()==null|| methodtrace.getPrediction().equals("E")) {
//				methodtrace.setPrediction("T");
//			}
//		}
//		
//		//set everything else to T 
//	for(String mykey : LogInfoHashMap.keySet()) {
//		if( LogInfoHashMap.get(mykey).getPrediction().equals("E")) {
//			LogInfo loginfo = LogInfoHashMap.get(mykey); 
//			loginfo.setPrediction("T");
//			LogInfoHashMap.put(mykey, loginfo); 
//		}
//	}
//	
//	
//	//set everything else to T in loghashmapRemaining
//	for(String mykey : LogHashMapRemaining.keySet()) {
//		if( LogHashMapRemaining.get(mykey).getPrediction().equals("E")) {
//			LogInfo loginfo = LogHashMapRemaining.get(mykey); 
//			loginfo.setPrediction("T");
//			LogHashMapRemaining.put(mykey, loginfo); 
//		}
//	}
	
	
	Set<Entry<String, LogInfo>> remainingvals = LogHashMapRemaining.entrySet(); 
	Set<Entry<String, LogInfo>> logvals = LogInfoHashMap.entrySet(); 
	
//		for( Entry<String, LogInfo> ent: logvals) {
//			String keyent = ent.getKey(); 
//			if( LogInfoHashMap.get(keyent).getPrediction()!=null)
//			if(!LogHashMapRemaining.get(keyent).getPrediction().equals(LogInfoHashMap.get(keyent).getPrediction())) {
//				//System.out.println("here");
//			}
//		
//		}
	//System.out.println("here 1");
	LinkedHashMap<String, LogInfo> LogHashMapRemaining3 = SetFlagRemainingPattern(LogHashMapRemaining, RemainingPattern, ProgramName, LogHashMapRemaining); 

		

		LogInfoHashMap=SetFlagTotalPattern(LogInfoHashMap, TotalPattern, ProgramName); 
		System.out.println("RemainingpredictionValues"+RemainingpredictionValues);
		WriteInDatabaseAndComputePrecisionAndRecallRemaining(MyfinalHashMap, LogHashMapRemaining, RemainingPattern, ProgramName, LogHashMapRemaining3, LogHashMapRemainingNewVals, RemainingpredictionValues);
		System.out.println("RemainingpredictionValues"+RemainingpredictionValues);

		//		WriteInDatabaseAndComputePrecisionAndRecall(methodtraces2, RemainingPattern, LogHashMapRemaining, ProgramName);
		//System.out.println("here 2");
		bwfile1.write("NON OWNER CLASS PREDICTION 		"+ProgramName+" "+RemainingPattern.toString());
		bwfile1.newLine();
		bwfile1.write("Remaining Prediction Values 	"+ProgramName+" "+RemainingpredictionValues.toString());
		bwfile1.newLine();
		WriteInDatabaseAndComputePrecisionAndRecall(methodtraces2, TotalPattern, LogInfoHashMap, ProgramName, TotalPredictionValues);
		//System.out.println("===============>PATTERNS 2 AND 4 ITERATION SET TO T   ITERATION  " + ITERATION+ "   PREDICTION VALUES " + RemainingPattern.toString());
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

		PredictionsNewHashMap = InitializePredictionsHashMap(PredictionsNewHashMap, methodtraces2);
		 counter=0; 
		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
			String reqmethod = methodtrace.Requirement.ID + "-" + methodtrace.Method.methodid;
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


	public void computeFlags(boolean InterfacesFlag, boolean ImplementationsFlag, boolean SuperclassesFlag,
			boolean ChildrenFlag, List<String> implementationsTraceValues, List<String> childrenTraceValues, List<String> superclassesTraceValues, List<String> interfaceTraceValues) {
		// TODO Auto-generated method stub
		InterfacesFlag = interfaceTraceValues.stream().distinct().limit(2).count() <= 1
				&& interfaceTraceValues.size() >= 1;
		 ImplementationsFlag = implementationsTraceValues.stream().distinct().limit(2).count() <= 1
				&& implementationsTraceValues.size() >= 1;
		SuperclassesFlag = superclassesTraceValues.stream().distinct().limit(2).count() <= 1
				&& superclassesTraceValues.size() >= 1;
		 ChildrenFlag = childrenTraceValues.stream().distinct().limit(2).count() <= 1
				&& childrenTraceValues.size() >= 1;
	}

	public void computeVariables(boolean InterfacesFlag, boolean ImplementationsFlag, boolean SuperclassesFlag,
			boolean ChildrenFlag, Methods<String> interfaces, Methods<String> implementations,
			Methods<String> superclasses, Methods<String> children, List<String> implementationsTraceValues, List<String> childrenTraceValues, List<String> superclassesTraceValues, List<String> interfaceTraceValues) {
		// TODO Auto-generated method stub
		for (String inter : interfaces) {
			String[] inters = inter.split("-");
			String interVal = inters[0];
			
			interfaceTraceValues.add(interVal);
		}

		for (String inter : implementations) {
			String[] inters = inter.split("-");
			String interVal = inters[0];
			
			implementationsTraceValues.add(interVal);
		}

		for (String inter : superclasses) {
			String[] inters = inter.split("-");
			String interVal = inters[0];
			
			superclassesTraceValues.add(interVal);
		}

		for (String inter : children) {
			String[] inters = inter.split("-");
			String interVal = inters[0];
		
			childrenTraceValues.add(interVal);
		}
		 
	}

	public void CountTracesClassesValues(PredictionValues PredictionClassTraceBefore, LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass2) {
		// TODO Auto-generated method stub
		
			for(String mykey: methodtracesRequirementClass.keySet()) {
				ClassTrace2 classtrace = methodtracesRequirementClass.get(mykey); 
				
				PredictionClassTraceBefore.ComputePredictionValues(PredictionClassTraceBefore, classtrace.getTraceFinal().trim());
			}
		
		
		
		
	}

	private void SetPredictionFinalNonOwnerInheritance(LogInfo LogInfo, MethodTraceSubjectTSubjectN methodtrace,
			LinkedHashMap<String, LogInfo> LogInfoHashMap, String reqMethod,
			 List<String> IterationValues,
			LinkedHashMap<String, String> LogHashMapRemainingNewVals,
			LinkedHashMap<String, LogInfo> LogHashMapRemaining, String pred, String reason) {
		// TODO Auto-generated method stub
		if(methodtrace.getPrediction().trim().equals("E")) {

		if (IterationValues != null) {
			IterationValues.add(reason);
			LogInfo.setIterationValues(IterationValues);
			LogInfo.setPrediction(pred);
			LogHashMapRemainingNewVals.put(reqMethod, pred);

			LogInfoHashMap.put(reqMethod, LogInfo);
			LogHashMapRemaining.put(reqMethod, LogInfo);
			
			

		} else {
			IterationValues = new ArrayList<String>();
			IterationValues.add(reason);
			LogInfo.setPrediction(pred);
			LogHashMapRemainingNewVals.put(reqMethod, pred);

			LogInfo.setIterationValues(IterationValues);
			LogHashMapRemaining.put(reqMethod, LogInfo);

			LogInfoHashMap.put(reqMethod, LogInfo);
		}
			PatternSetVariables(pred, methodtrace, "90%", "P2");

		}
	}

	private void SetPredictionFinalNonOwner(LogInfo LogInfo, MethodTraceSubjectTSubjectN methodtrace,
			LinkedHashMap<String, LogInfo> LogInfoHashMap, String reqMethod, 
			 List<String> iterationValues,
			LinkedHashMap<String, String> LogHashMapRemainingNewVals,
			LinkedHashMap<String, LogInfo> LogHashMapRemaining, String Pred, String Reason, HashMap<String, MethodTraceSubjectTSubjectN> methodtraces2HashMap2) {
		// TODO Auto-generated method stub
		
		if(methodtrace.getPrediction().trim().equals("E")) {
			PatternSetVariables(Pred, methodtrace, "90%", "P2");

			iterationValues.add(Reason);
			LogInfo.setPrediction(Pred);
			methodtrace.setPrediction(Pred);
			LogInfo.setIterationValues(iterationValues);
			LogInfoHashMap.put(reqMethod, LogInfo);
			LogHashMapRemaining.put(reqMethod, LogInfo);
			LogHashMapRemainingNewVals.put(reqMethod, Pred);
//			RequirementMethodNameClassIDHashMap.put(ReqMethodClasskey, Pred); 
			methodtraces2HashMap2.put(reqMethod, methodtrace); 
		}
		
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	private LinkedHashMap<String, LogInfo> InitializeHashMapWithPrecisionRecallRemaining(
			Collection<MethodTraceSubjectTSubjectN> methodTracesHashmapValues,
			LinkedHashMap<String, LogInfo> logHashMapRemaining, LinkedHashMap<String, LogInfo> logInfoHashMap) {

		// TODO Auto-generated method stub
		
		for (MethodTraceSubjectTSubjectN methodtrace : methodTracesHashmapValues) {
			
			String reqID= methodtrace.getRequirement().ID; 
			String methodID= methodtrace.getMethod().methodid; 
			String key= reqID+"-"+methodID; 
			//System.out.println("Key "+ key);
			LogInfo log = new LogInfo(); 
			log.setPrecisionRecall("E");
			log.setPrediction("E");
			log.setGoldFinal(logInfoHashMap.get(key).getGoldFinal());
			log.setSubjectGold(logInfoHashMap.get(key).getSubjectGold());

			logHashMapRemaining.put(key, log); 
		}
	
		return logHashMapRemaining;
	
	}
	/************************************************************************************************************************************************/
	/**
	 * @param remainingpredictionValues **********************************************************************************************************************************************/
	private void WriteInDatabaseAndComputePrecisionAndRecallRemaining(
			LinkedHashMap<String, MethodTraceSubjectTSubjectN> MyfinalHashMap,
			LinkedHashMap<String, LogInfo> logHashMapRemaining, PredictionEvaluation Pattern,
			String ProgramName, LinkedHashMap<String, LogInfo> logHashMapRemaining3, LinkedHashMap<String, String>loghashmapNewVals, PredictionValues remainingpredictionValues) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Pattern.ResetCounters(Pattern);

		for (String mykey : logHashMapRemaining.keySet()) {
			MethodTraceSubjectTSubjectN myvalue = MyfinalHashMap.get(mykey);
			String methodid = myvalue.getMethod().methodid;
			String requirementID = myvalue.getRequirement().ID;
			// String query= "UPDATE `traces` SET `prediction` ='"+ myvalue.getPrediction()
			// +"'WHERE requirementid='"+RequirementID+"' AND methodid ='"+methodid+"'";
			String likelihood = myvalue.getLikelihood();
			String why = myvalue.getWhy();
			String reqMethod= requirementID+"-"+methodid; 
			
			
		//	System.out.println(Pattern.toString());

			
			//System.out.println("PREDICTION  " + myvalue.getPrediction() + " ------------  gold2  " + myvalue.goldfinal);
			if(ProgramName.equals("gantt")|| ProgramName.equals("jhotdraw")){
				if (myvalue.getGoldfinal() != null && myvalue.getPrediction() != null && logHashMapRemaining3.get(mykey).isMyFlag()
						&& logHashMapRemaining.get(mykey)!=null) {
					String Result = Pattern.ComparePredictionToGold(myvalue.getGoldfinal().trim(),
							logHashMapRemaining.get(mykey).getPrediction().trim());
					Pattern.UpdateCounters(Result, Pattern);
				//	System.out.println(Pattern.toString());
					if(Result.equals("TN")) {
						System.out.println("REQMETHOD========>"+reqMethod);

					}
					
					
				
				}
			}else if(ProgramName.equals("chess")|| ProgramName.equals("itrust")) {
				if (myvalue.getGoldfinal() != null && myvalue.getPrediction() != null 
						&& loghashmapNewVals.get(mykey)!=null) {
					String Result = Pattern.ComparePredictionToGold(myvalue.getGoldfinal().trim(),
							myvalue.getPrediction().trim());
					Pattern.UpdateCounters(Result, Pattern);
					
					
					

				}
			}
			
			remainingpredictionValues.ComputePredictionValues(remainingpredictionValues, logHashMapRemaining.get(mykey).getPrediction().trim()); 

		}
		Pattern.toString();

		//System.out.println("FINAL RESULT ====== " + Pattern.toString());
	}
	/************************************************************************************************************************************************/
	/**
	 * @param methodtraces2HashMap2 **********************************************************************************************************************************************/
	public void SetPredictionFinal(LogInfo loginfo, MethodTraceSubjectTSubjectN methodtrace,
			LinkedHashMap<String, LogInfo> LogInfoHashMap, String reqmethod,  String value, HashMap<String, MethodTraceSubjectTSubjectN> methodtraces2HashMap2) {
		// TODO Auto-generated method stub
		loginfo.setOwnerClassPrediction(value);
		methodtrace.setPrediction(value);
		loginfo.setPrediction(value);
		LogInfoHashMap.put(reqmethod, loginfo);
		methodtraces2HashMap.put(reqmethod, methodtrace); 
		PatternSetVariables(value, methodtrace, "90%", "P2");
	}
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	private LinkedHashMap<String, LogInfo> InitializeHashMapWithPrecisionRecall(
			Collection<MethodTraceSubjectTSubjectN> methodTracesHashmapValues, LinkedHashMap<String, LogInfo> logHashMapRemaining) {
		// TODO Auto-generated method stub
		
		for (MethodTraceSubjectTSubjectN methodtrace : methodTracesHashmapValues) {
			
			String reqID= methodtrace.getRequirement().ID; 
			String methodID= methodtrace.getMethod().methodid; 
			String key= reqID+"-"+methodID; 
			//System.out.println("Key "+ key);
			LogInfo log = new LogInfo(); 
			log.setPrecisionRecall("E");
			log.setPrediction("E");
			
			logHashMapRemaining.put(key, log); 
		}
	
		return logHashMapRemaining;
	}
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	private void SetPredictionCallersCallees(Collection<MethodTraceSubjectTSubjectN> MethodTracesHashmapValues, HashMap<String, LogInfo> LogInfoHashMap) {
		// TODO Auto-generated method stub
		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
			String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.getMethod().methodid;
			LogInfo LogInfo = LogInfoHashMap.get(reqMethod);
			// methodtrace.setPrediction("");
			MethodList  CalleesList = methodtrace.getCalleesList();
			MethodList CallersList = methodtrace.getCallersList();

//			MethodList MethodPredictionCalleeList = new MethodList();
//			for (Method2Representation callee : CalleesList) {
//				String RequirementID = methodtrace.getRequirement().ID; 
//				String MethodID = callee.methodid; 
//				String key = RequirementID+ "-" +MethodID  ;
//				if (methodtraces2HashMap.get(key) != null) {
//					String predictionvalue = methodtraces2HashMap.get(key).getPrediction();
//					MethodPredictionCalleeList.add(predictionvalue);
//				}
//
//			}
//
//			MethodList<String> MethodPredictionCallerList = new MethodList<String>();
//			for (Method2Representation caller : CallersList) {
//				String RequirementID = methodtrace.getRequirement().ID; 
//				String MethodID = caller.methodid; 
//				String key = RequirementID+ "-" +MethodID  ;
//				if (methodtraces2HashMap.get(key) != null) {
//					String predictionvalue = methodtraces2HashMap.get(key).getPrediction();
//					MethodPredictionCallerList.add(predictionvalue);
//				}
//			}
			MethodList ml = new MethodList(); 
			methodtrace.setPredictionCalleeList(CalleesList);
			//System.out.println(methodtrace.getCalleeList());
			methodtrace.setPredictionCallerList(CallersList);
			//System.out.println(methodtrace.getCallerList());

			
		}
		
		for(MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
			//System.out.println(methodtrace.Method.methodid+"-"+methodtrace.Requirement.ID);
			//System.out.println(methodtrace.getCalleeList());
			//System.out.println(methodtrace.getCallerList());
		}
	}
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	private LinkedHashMap<String, LogInfo> InitializeLogInfoHashMap(LinkedHashMap<String, LogInfo> logInfoHashMap,
			Collection<MethodTraceSubjectTSubjectN> methodTracesHashmapValues) {
		// TODO Auto-generated method stub
		for(MethodTraceSubjectTSubjectN methval: methodTracesHashmapValues) {
			String Req= methval.getRequirement().ID; 
			String Method= methval.getMethod().methodid; 
			LogInfo loginfo= new LogInfo(); 
			//System.out.println(Req+"-"+Method);
			logInfoHashMap.put(Req+"-"+Method, loginfo); 
		}
		return logInfoHashMap; 
	}
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	public HashMap<String, String> InitializeRequirementMethodNameClassIDHashMap(
			HashMap<String, String> requirementMethodNameClassIDHashMap2, Collection<MethodTraceSubjectTSubjectN> methodTracesHashmapValues) {
		
		for(MethodTraceSubjectTSubjectN methodtrace: methodTracesHashmapValues){
			String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethod().methodname+"-"+methodtrace.ClassRepresentation.classid; 

			requirementMethodNameClassIDHashMap2.put(ReqMethodClasskey, "E"); 
		}
		
				return requirementMethodNameClassIDHashMap2;
		// TODO Auto-generated method stub
		
	}

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
		Collection<MethodTraceSubjectTSubjectN> MethodTracesHashmapValues = methodtraces2HashMap.values();

		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {

			String reqclass = methodtrace.Requirement.getID() + "-" + methodtrace.ClassRepresentation.classid;
			ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);

			// PATTERN 1

			List<String> ImplementationList = methodtrace.getImplementationList();
			List<String> ChildrenList = methodtrace.getChildrenList();
			List<String> SuperClassesList = methodtrace.getSuperClassesList();
			List<String> InterfaceList = methodtrace.getInterfaceList();

			List<String> childrenListOwners = new ArrayList<String>();
			List<String> TraceValues = new ArrayList<String>();
			List<String> SuperClassListOwners = new ArrayList<String>();

			List<String> SuperClassListOwners2 = new ArrayList<String>();
			List<String> childrenListOwners2 = new ArrayList<String>();
			List<String> TraceValues2 = new ArrayList<String>();

			List<String> InterfacesListOwners = new ArrayList<String>();
			List<String> ImplementationListOwners = new ArrayList<String>();
			List<String> TraceValuesInterfaces = new ArrayList<String>();

			List<String> InterfacesListOwners2 = new ArrayList<String>();
			List<String> ImplementationListOwners2 = new ArrayList<String>();
			List<String> TraceValuesInterfaces2 = new ArrayList<String>();

			// CHILDREN
			for (String childVal : ChildrenList) {
				String[] Vals = childVal.split("-");
				String myvalue = Vals[0];
				String ownerclassChild = Vals[1];
				String superclassownerID = Vals[2];
				TraceValues.add(myvalue);
				childrenListOwners.add(ownerclassChild);
				SuperClassListOwners.add(superclassownerID);
			}
			boolean allEqual = TraceValues.stream().distinct().limit(2).count() <= 1 && TraceValues.size() >= 1;
			if (allEqual) {

				ClassTrace2 myclasstraceNew = methodtracesRequirementClass
						.get(methodtrace.Requirement.getID() + "-" + methodtrace.ClassRepresentation.classid);
				if ((myclasstraceNew.getTraceFinal() == null || myclasstraceNew.getTraceFinal().equals("E")
						|| myclasstraceNew.getTraceFinal().equals("null"))
						&& (TraceValues.get(0).equals("T") || TraceValues.get(0).equals("N"))) {
					myclasstraceNew.setTraceFinal(TraceValues.get(0));
					methodtracesRequirementClass.put(methodtrace.Requirement.getID() + "-" + methodtrace.ClassRepresentation.classid,myclasstraceNew);
					requirementClassHashMapNewValues.put(
							methodtrace.Requirement.getID() + "-" + methodtrace.ClassRepresentation.classid,
							myclasstraceNew.getTraceFinal());
				}

			}

			// SUPERCLASSES

			for (String SuperclassVal : SuperClassesList) {
				String[] Vals = SuperclassVal.split("-");
				String myvalue = Vals[0];
				String ownerclassSuperclass = Vals[1];
				String childclassownerID = Vals[2];
				TraceValues2.add(myvalue);
				childrenListOwners2.add(childclassownerID);
				SuperClassListOwners2.add(ownerclassSuperclass);
			}

			allEqual = TraceValues2.stream().distinct().limit(2).count() <= 1 && TraceValues2.size() >= 1;
			if (allEqual) {

				ClassTrace2 myclasstraceNew = methodtracesRequirementClass
						.get(methodtrace.Requirement.getID() + "-" + methodtrace.ClassRepresentation.classid);
				if ((myclasstraceNew.getTraceFinal() == null || myclasstraceNew.getTraceFinal().equals("E")
						|| myclasstraceNew.getTraceFinal().equals("null"))
						&& (TraceValues2.get(0).equals("T") || TraceValues2.get(0).equals("N"))) {
					myclasstraceNew.setTraceFinal(TraceValues2.get(0));
					methodtracesRequirementClass.put(
							methodtrace.Requirement.getID() + "-" + methodtrace.ClassRepresentation.classid,
							myclasstraceNew);
					requirementClassHashMapNewValues.put(
							methodtrace.Requirement.getID() + "-" + methodtrace.ClassRepresentation.classid,
							myclasstraceNew.getTraceFinal());

				}

			}

			// INTERFACES

			for (String interfaceVal : InterfaceList) {
				String[] Vals = interfaceVal.split("-");
				String myvalue = Vals[0];
				String InterfaceID = Vals[1];
				String ImplementationID = Vals[2];
				TraceValuesInterfaces.add(myvalue);
				InterfacesListOwners.add(InterfaceID);
				ImplementationListOwners.add(ImplementationID);
			}

			allEqual = TraceValuesInterfaces.stream().distinct().limit(2).count() <= 1
					&& TraceValuesInterfaces.size() >= 1;
			if (allEqual) {

				ClassTrace2 myclasstraceNew = methodtracesRequirementClass
						.get(methodtrace.Requirement.getID() + "-" + methodtrace.ClassRepresentation.classid);
				if ((myclasstraceNew.getTraceFinal() == null || myclasstraceNew.getTraceFinal().equals("E")
						|| myclasstraceNew.getTraceFinal().equals("null"))
						&& (TraceValuesInterfaces.get(0).equals("T") || TraceValuesInterfaces.get(0).equals("N"))) {
					myclasstraceNew.setTraceFinal(TraceValuesInterfaces.get(0));
					methodtracesRequirementClass.put(
							methodtrace.Requirement.getID() + "-" + methodtrace.ClassRepresentation.classid,
							myclasstraceNew);
					requirementClassHashMapNewValues.put(
							methodtrace.Requirement.getID() + "-" + methodtrace.ClassRepresentation.classid,
							myclasstraceNew.getTraceFinal());

				}

			}

			// IMPLEMENTATIONS

			for (String ImplementationVal : ImplementationList) {
				String[] Vals = ImplementationVal.split("-");
				String myvalue = Vals[0];
				String ImplementationID = Vals[1];
				String InterfaceID = Vals[2];
				TraceValuesInterfaces2.add(myvalue);
				InterfacesListOwners2.add(InterfaceID);
				ImplementationListOwners2.add(ImplementationID);
			}
			allEqual = TraceValuesInterfaces2.stream().distinct().limit(2).count() <= 1
					&& TraceValuesInterfaces2.size() >= 1;
			if (allEqual) {

				ClassTrace2 myclasstraceNew = methodtracesRequirementClass
						.get(methodtrace.Requirement.getID() + "-" + methodtrace.ClassRepresentation.classid);
				if ((myclasstraceNew.getTraceFinal() == null || myclasstraceNew.getTraceFinal().equals("E")
						|| myclasstraceNew.getTraceFinal().equals("null"))
						&& (TraceValuesInterfaces2.get(0).equals("T") || TraceValuesInterfaces2.get(0).equals("N"))) {
					myclasstraceNew.setTraceFinal(TraceValuesInterfaces2.get(0));
					methodtracesRequirementClass.put(
							methodtrace.Requirement.getID() + "-" + methodtrace.ClassRepresentation.classid,
							myclasstraceNew);
					requirementClassHashMapNewValues.put(
							methodtrace.Requirement.getID() + "-" + methodtrace.ClassRepresentation.classid,
							myclasstraceNew.getTraceFinal());

				}

			}

			j++;

		}
		return requirementClassHashMapNewValues;
	}
	
	
	
	
	
	
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/**
	 * @param logInfoHashMap 
	 * @param programName **********************************************************************************************************************************************/
	public LinkedHashMap<String, MethodTraceSubjectTSubjectN> SetFlagOwnerClassPattern(LinkedHashMap<String, MethodTraceSubjectTSubjectN> logHashMapRemaining,
			PredictionEvaluation nEWPATTERNMethodFields2, LinkedHashMap<String, LogInfo> logInfoHashMap, String programName) {
		for (String mykey : logInfoHashMap.keySet()) {
			 LogInfo loginfo = logInfoHashMap.get(mykey);
			 
			if( programName.equals("gantt")||programName.equals("jhotdraw") ) {
				if (loginfo.getGoldFinal().equals(loginfo.getSubjectGold()) ) {
					loginfo.setMyFlag(true);
					logInfoHashMap.put(mykey, loginfo); 
					MethodTraceSubjectTSubjectN myval = logHashMapRemaining.get(mykey); 
					myval.setMyflag(true);
					logHashMapRemaining.put(mykey, myval); 
				}
			}
			

		}
		return logHashMapRemaining;
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
				loginfo.setMyFlag(true);
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
				loginfo.setMyFlag(true);
				logHashMapRemaining2.put(mykey, loginfo); 
				
			}
			}
				

		}
		return logHashMapRemaining2;
	}
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/**
	 * @param requirementMethodNameClassIDHashMap2 **********************************************************************************************************************************************/
	public void CalculateChildrenInterfacesMethodTraces(HashMap<String, String> requirementMethodNameClassIDHashMap2) {
		// TODO Auto-generated method stub
		int j = 0;
		Collection<MethodTraceSubjectTSubjectN> MethodTracesHashmapValues = methodtraces2HashMap.values();
		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
		

			List<String> SuperClassesList = new ArrayList<String>();
			List<String> InterfaceList = new ArrayList<String>();
			List<String> ChildrenList = new ArrayList<String>();
			List<String> ImplementationList = new ArrayList<String>();
			//System.out.println(methodtraces2.size());
			//System.out.println(j);
			//System.out.println(methodtraces2HashMap.size());
			String ReqID= methodtrace.Requirement.ID; 
			String MethodName= methodtrace.Method.methodname; 


			String ReqMethod=ReqID+"-"+MethodName; 
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			List<Interface2> myinterfaces = InterfacesOwnerClassHashMap.get(methodtrace.ClassRepresentation.classid);
			List<SuperClass2> mysuperclasses = SuperclassesHashMap.get(methodtrace.ClassRepresentation.classid);
			List<Implementation2> myimplementations = INTERFACEHASHMAPFINAL.get(methodtrace.ClassRepresentation.classid);
			List<Children2> mychildren = ChildrenHashMap.get(methodtrace.ClassRepresentation.classid);
			
			
			//System.out.println("Methodtrace class id " + methodtrace.ClassRepresentation.classid);
			if (myinterfaces != null)
				for (Interface2 myinterface : myinterfaces) {
					String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethod().methodname+"-"+myinterface.InterfaceClass.classid; 
					String TraceValue = requirementMethodNameClassIDHashMap2.get(ReqMethodClasskey);
					
					InterfaceList.add(TraceValue + "-" + myinterface.getInterfaceClass().getClassid() + "-"
									+ methodtrace.ClassRepresentation.classid);
						
				}
			if (mysuperclasses != null)
				for (SuperClass2 mysuperclass : mysuperclasses) {
					String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethod().methodname+"-"+mysuperclass.SuperClass.classid; 
							
					String TraceValue = requirementMethodNameClassIDHashMap2.get(ReqMethodClasskey);
					
					SuperClassesList.add(TraceValue + "-" + mysuperclass.getSuperClass().classid + "-"
									+ methodtrace.ClassRepresentation.classid);
					
					
					
				}
			if (mychildren != null)
				for (Children2 mychild : mychildren) {
				String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethod().methodname+"-"+mychild.OwnerClass.classid; 
				
				String TraceValue = requirementMethodNameClassIDHashMap2.get(ReqMethodClasskey);
		
				ChildrenList.add(TraceValue + "-" + mychild.getOwnerClass().classid + "-"
						+ methodtrace.ClassRepresentation.classid);
				
				}
			if (myimplementations != null)
				for (Implementation2 myimplementation : myimplementations) {
					String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethod().methodname+"-"+myimplementation.Implementation.classid;  
					
					String TraceValue = requirementMethodNameClassIDHashMap2.get(ReqMethodClasskey);
			
					ImplementationList.add(TraceValue + "-" + myimplementation.getImplementation().classid + "-"
							+ methodtrace.ClassRepresentation.classid);
				}
			methodtrace.setSuperClassesListMethodTraces(SuperClassesList);
			methodtrace.setInterfaceListMethodTraces(InterfaceList);
			methodtrace.setImplementationListMethodTraces(ImplementationList);
			methodtrace.setChildrenListMethodTraces(ChildrenList);
			j++;
		}
	}
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	public void CalculateChildrenInterfacesTracesClasses() {
		// TODO Auto-generated method stub
		int j = 0;
		Collection<MethodTraceSubjectTSubjectN> MethodTracesHashmapValues = methodtraces2HashMap.values();
		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
			List<String> PredictionParams = new ArrayList<String>();
			List<String> PredictionParamsOwnerClass = new ArrayList<String>();
			List<String> PredictionFields = new ArrayList<String>();
			List<String> PredictionFieldsOwnerClass = new ArrayList<String>();
			//System.out.println(methodtraces2.size());
			//System.out.println(j);
			//System.out.println(methodtraces2HashMap.size());

			List<MethodField2> mymethodfields = FieldMethodsHashMap.get(methodtrace.Method.methodid);
			List<Parameter2> paramlist = parameterHashMap.get(methodtrace.Method.methodid);
			if (mymethodfields != null)
				for (MethodField2 mymeth : mymethodfields) {
					String reqclass = methodtrace.Requirement.ID + "-" + mymeth.getMethodFieldType().classid;
					ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);
					if (myclasstraceHashMap != null)
						if (myclasstraceHashMap.getTraceFinal() != null) {
							String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
							PredictionFields.add(traceGold2V2);
						}
				}
			if (paramlist != null) {
				for (Parameter2 mymeth : paramlist) {
					String reqclass = methodtrace.Requirement.ID + "-" + mymeth.getParameterType().classid;
					ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);
					if (myclasstraceHashMap != null)
						if (myclasstraceHashMap.getTraceFinal() != null) {
							String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
							PredictionParams.add(traceGold2V2);
						}
				}
			}

			if (paramlist != null) {
				for (Parameter2 mymeth : paramlist) {
					String reqclass = methodtrace.Requirement.ID + "-" + mymeth.getOwnerClass().classid;
					ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);
					if (myclasstraceHashMap != null)
						if (myclasstraceHashMap.getTraceFinal() != null) {
							String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
							PredictionParamsOwnerClass.add(traceGold2V2);
						}
				}
			}

			if (mymethodfields != null)
				for (MethodField2 mymeth : mymethodfields) {
					String reqclass = methodtrace.Requirement.ID + "-" + mymeth.getOwnerClass().classid;
					ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);
					if (myclasstraceHashMap != null)
						if (myclasstraceHashMap.getTraceFinal() != null) {
							String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
							PredictionFieldsOwnerClass.add(traceGold2V2);
						}
				}
			methodtrace.setPredictionParams(PredictionParams);
			methodtrace.setPredictionFields(PredictionFields);
			methodtrace.setPredictionFieldsOwnerClass(PredictionFieldsOwnerClass);
			methodtrace.setPredictionParamsOwnerClass(PredictionParamsOwnerClass);

			List<String> SuperClassesList = new ArrayList<String>();
			List<String> InterfaceList = new ArrayList<String>();
			List<String> ChildrenList = new ArrayList<String>();
			List<String> ImplementationList = new ArrayList<String>();
			//System.out.println(methodtraces2.size());
			//System.out.println(j);
			//System.out.println(methodtraces2HashMap.size());

			List<Interface2> myinterfaces = InterfacesOwnerClassHashMap.get(methodtrace.ClassRepresentation.classid);
			List<SuperClass2> mysuperclasses = SuperclassesHashMap.get(methodtrace.ClassRepresentation.classid);
			List<Implementation2> myimplementations = INTERFACEHASHMAPFINAL
					.get(methodtrace.ClassRepresentation.classid);
			List<Children2> mychildren = ChildrenHashMap.get(methodtrace.ClassRepresentation.classid);
			//System.out.println("Methodtrace class id " + methodtrace.ClassRepresentation.classid);
			if (myinterfaces != null)
				for (Interface2 myinterface : myinterfaces) {
					String reqclass = methodtrace.Requirement.ID + "-" + myinterface.getInterfaceClass().getClassid();
					ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);
					if (myclasstraceHashMap != null)
						if (myclasstraceHashMap.getTraceFinal() != null) {
							String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
							InterfaceList.add(traceGold2V2 + "-" + myinterface.getInterfaceClass().getClassid() + "-"
									+ methodtrace.ClassRepresentation.classid);
						}
				}
			if (mysuperclasses != null)
				for (SuperClass2 mysuperclass : mysuperclasses) {
					String reqclass = methodtrace.Requirement.ID + "-" + mysuperclass.getSuperClass().classid;
					ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);
					if (myclasstraceHashMap != null)
						if (myclasstraceHashMap.getTraceFinal() != null) {
							String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
							SuperClassesList.add(traceGold2V2 + "-" + mysuperclass.getSuperClass().classid + "-"
									+ methodtrace.ClassRepresentation.classid);
						}
				}
			if (mychildren != null)
				for (Children2 mychild : mychildren) {
					String reqclass = methodtrace.Requirement.ID + "-" + mychild.getOwnerClass().classid;
					ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);
					if (myclasstraceHashMap != null)
						if (myclasstraceHashMap.getTraceFinal() != null) {
							String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
							ChildrenList.add(traceGold2V2 + "-" + mychild.getOwnerClass().classid + "-"
									+ methodtrace.ClassRepresentation.classid);
						}
				}
			if (myimplementations != null)
				for (Implementation2 myimplementation : myimplementations) {
					String reqclass = methodtrace.Requirement.ID + "-" + myimplementation.getImplementation().classid;
					ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);
					if (myclasstraceHashMap != null)
						if (myclasstraceHashMap.getTraceFinal() != null) {
							String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
							ImplementationList.add(traceGold2V2 + "-" + myimplementation.getImplementation().classid
									+ "-" + methodtrace.ClassRepresentation.classid);
						}
				}
			methodtrace.setSuperClassesList(SuperClassesList);
			methodtrace.setInterfaceList(InterfaceList);
			methodtrace.setImplementationList(ImplementationList);
			methodtrace.setChildrenList(ChildrenList);
			j++;
		}
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/**
	 * @param logInfoHashMap
	 * @param totalPredictionValues 
	 **********************************************************************************************************************************************/
	public void WriteInDatabaseAndComputePrecisionAndRecall(List<MethodTraceSubjectTSubjectN> methodtraces22,
			PredictionEvaluation nEWPATTERNMethodCallsSetToT2, HashMap<String, LogInfo> logInfoHashMap, String ProgramName, PredictionValues totalPredictionValues) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		nEWPATTERNMethodCallsSetToT2.ResetCounters(nEWPATTERNMethodCallsSetToT2);

		for (MethodTraceSubjectTSubjectN mykey : methodtraces22) {
			String methodid = mykey.getMethod().methodid;
			String requirementID = mykey.getRequirement().ID;
			String ReqMethod = requirementID + "-" + methodid;
			LogInfo logInfo = logInfoHashMap.get(ReqMethod);
			
			String likelihood = mykey.getLikelihood();
			String why = mykey.getWhy();
			System.out.println("gold  " + mykey.getGoldfinal().trim() + " ------------  prediction  " + logInfo.getPrediction().trim());

		if(ProgramName.equals("gantt")|| ProgramName.equals("jhotdraw")) {
			if (mykey.getGoldfinal() != null && logInfo.getPrediction() != null && logInfo.isMyFlag()) {
				String Result = nEWPATTERNMethodCallsSetToT2.ComparePredictionToGold(mykey.getGoldfinal().trim(),
						logInfo.getPrediction().trim());
				logInfo.setPrecisionRecall(Result);
				nEWPATTERNMethodCallsSetToT2.UpdateCounters(Result, nEWPATTERNMethodCallsSetToT2);
				logInfoHashMap.put(ReqMethod, logInfo);
			}
		}
		else if(ProgramName.equals("itrust")|| ProgramName.equals("chess")) {
			if (mykey.getGoldfinal() != null && logInfo.getPrediction() != null ) {
				String Result = nEWPATTERNMethodCallsSetToT2.ComparePredictionToGold(mykey.getGoldfinal().trim(),
						logInfo.getPrediction().trim());
				logInfo.setPrecisionRecall(Result);
				nEWPATTERNMethodCallsSetToT2.UpdateCounters(Result, nEWPATTERNMethodCallsSetToT2);
				logInfoHashMap.put(ReqMethod, logInfo);

			}
		}
		
		totalPredictionValues.ComputePredictionValues(totalPredictionValues, logInfo.getPrediction().trim());

		System.out.println("MY PRED====>"+logInfo.getPrediction().trim());

		}
		nEWPATTERNMethodCallsSetToT2.toString();
		//System.out.println("FINAL RESULT ====== " + nEWPATTERNMethodCallsSetToT2.toString());

	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/**
	 * @param ownerClassPredictionValues **********************************************************************************************************************************************/

	public void WriteInDatabaseAndComputePrecisionAndRecallOwner(
			LinkedHashMap<String, MethodTraceSubjectTSubjectN> MyfinalHashMap,
			PredictionEvaluation Pattern, String ProgramName, LinkedHashMap<String, LogInfo> logHashMapRemaining3, PredictionValues ownerClassPredictionValues) throws SQLException {
		// TODO Auto-generated method stub
		Pattern.ResetCounters(Pattern);

		for (String mykey : MyfinalHashMap.keySet()) {
			MethodTraceSubjectTSubjectN myvalue = MyfinalHashMap.get(mykey);
			String methodid = myvalue.getMethod().methodid;
			String requirementID = myvalue.getRequirement().ID;
			// String query= "UPDATE `traces` SET `prediction` ='"+ myvalue.getPrediction()
			// +"'WHERE requirementid='"+RequirementID+"' AND methodid ='"+methodid+"'";
			String likelihood = myvalue.getLikelihood();
			String why = myvalue.getWhy();

			

//			System.out.println("PREDICTION  " + myvalue.getPrediction() + " ------------  gold2  " + myvalue.goldfinal);
			if(ProgramName.equals("gantt")|| ProgramName.equals("jhotdraw")){
				if (myvalue.getGoldfinal() != null && myvalue.getPrediction() != null && logHashMapRemaining3.get(mykey).isMyFlag()
						) {
					String Result = Pattern.ComparePredictionToGold(myvalue.getGoldfinal().trim(),
							myvalue.getPrediction().trim());
					Pattern.UpdateCounters(Result, Pattern);
				}
			}else if(ProgramName.equals("chess")|| ProgramName.equals("itrust")) {
				if (myvalue.getGoldfinal() != null && myvalue.getPrediction() != null 
						) {
					String Result = Pattern.ComparePredictionToGold(myvalue.getGoldfinal().trim(),
							myvalue.getPrediction().trim());
					Pattern.UpdateCounters(Result, Pattern);

				}

			}
			ownerClassPredictionValues.ComputePredictionValues(ownerClassPredictionValues, myvalue.getPrediction().trim());


		}
		Pattern.toString();

		//System.out.println("FINAL RESULT ====== " + Pattern.toString());
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/

	public LinkedHashMap<String, String> InitializePredictionsHashMap(
			LinkedHashMap<String, String> predictionsOldHashMap,
			Collection<MethodTraceSubjectTSubjectN> methodtraces22) {
		// TODO Auto-generated method stub

		for (MethodTraceSubjectTSubjectN methodtrace : methodtraces22) {
			String RequirementID = methodtrace.Requirement.ID;
			String MethodID = methodtrace.Method.methodid;
			String key = MethodID + "-" + RequirementID;
			predictionsOldHashMap.put(key, methodtrace.getPrediction());
		}
		return predictionsOldHashMap;
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/

	public List<MethodTraceSubjectTSubjectN> InitializePredictionsHashMapBlankValues(
			LinkedHashMap<String, String> predictionsOldHashMap, List<MethodTraceSubjectTSubjectN> methodtraces22) {
		// TODO Auto-generated method stub

		for (MethodTraceSubjectTSubjectN methodtrace : methodtraces22) {
			methodtrace.setPrediction("");
		}
		return methodtraces22;
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	public LinkedHashMap<String, MethodTraceSubjectTSubjectN> RetrievePredictionsHashMap(
			List<MethodTraceSubjectTSubjectN> methodtraces22) {
		// TODO Auto-generated method stub

		LinkedHashMap<String, MethodTraceSubjectTSubjectN> predictionsOldHashMap = new LinkedHashMap<String, MethodTraceSubjectTSubjectN>();
		for (MethodTraceSubjectTSubjectN methodtrace : methodtraces22) {
			String RequirementID = methodtrace.Requirement.ID;
			String MethodID = methodtrace.Method.methodid;
			String key = RequirementID+"-"+MethodID  ;
			predictionsOldHashMap.put(key, methodtrace);
		}
		return predictionsOldHashMap;
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	public void PatternSetVariables(String Prediction, MethodTraceSubjectTSubjectN methodtrace, String Likelihood,
			String Why) {
		// TODO Auto-generated method stub
		methodtrace.setPrediction(Prediction);
		methodtrace.setLikelihood(Likelihood);
		methodtrace.setWhy(Why);
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	public static void main(String[] args) throws SQLException, IOException {
		String ProgramName = "chess";
		AlgoFinal frame = new AlgoFinal(
				ProgramName);

		String ProgramName2 = "gantt";
			 frame = new AlgoFinal(ProgramName2);

		String ProgramName3 = "itrust";
			 frame = new AlgoFinal(ProgramName3);

		String ProgramName4 = "jhotdraw";
			frame = new AlgoFinal(ProgramName4);
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