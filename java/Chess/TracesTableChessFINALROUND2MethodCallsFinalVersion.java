package Chess;

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
import org.eclipse.swt.widgets.Table;

import Gantt.DatabaseReading2Gantt;
import JHotDraw.DatabaseReading2JHotDraw3;
import iTrust.DatabaseReading2itrust;
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
import mypackage.MethodTraceSubjectTSubjectN;
import mypackage.Parameter2;
import mypackage.Requirement2;
import mypackage.RequirementGold;
import mypackage.SuperClass2;

public class TracesTableChessFINALROUND2MethodCallsFinalVersion extends JFrame {

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

	PredictionEvaluation NEWPATTERNMethodCallsFinal = new PredictionEvaluation();

	ClassTrace2 myclasstrace = new ClassTrace2();
	static List<MethodTrace> methodtraces2 = new ArrayList<MethodTrace>();
	HashMap<String, List<String>> classMethodsHashMap = new HashMap<String, List<String>>();
	static HashMap<String, MethodTrace> methodtraces2HashMap = new HashMap<String, MethodTrace>();
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

	public TracesTableChessFINALROUND2MethodCallsFinalVersion(String ProgramName) throws SQLException, IOException {

		LinkedHashMap<String, String> PredictionsOldHashMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> PredictionsNewHashMap = new LinkedHashMap<String, String>();

		int j = 0;
		List<MethodTrace> methodtracesNew = InitializePredictionsHashMap2(methodtraces2);
		TracePredictionFunction(j, PredictionsOldHashMap, PredictionsNewHashMap, methodtracesNew, ProgramName);

	}

	public List<MethodTrace> InitializePredictionsHashMap2(
			List<MethodTrace> methodtracesNew) {
		// TODO Auto-generated method stub

		for (MethodTrace meth : methodtracesNew) {
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
			List<MethodTrace> methodtraces22, String ProgramName) throws SQLException, IOException {
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
		Collection<MethodTrace> MethodTracesHashmapValues = methodtraces2HashMap.values();
		// bwfile2.newLine();
		for (MethodTrace methodtrace : MethodTracesHashmapValues) {
			methodtrace.setPrediction("E");
		}
		if (ProgramName.equals("chess")) {

			File file1log = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\FinalLogFiles\\PrecisionRecallChess.txt");
			FileOutputStream fosfila1 = new FileOutputStream(file1log);
			bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

			db = new DatabaseReading2();
			DatabaseReading2.MakePredictions();
			classMethodsHashMap = db.getClassMethodsHashMap();
			methodtraces2 = db.getMethodtraces2SubjectTSubjectN();
			methodtraces2HashMap = db.getMethodtracehashmap();
			classtraces2 = db.getClassestraces2();
			System.out.println("yes");
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
		HashMap<String, LogInfo> LogInfoHashMap = new HashMap<String, LogInfo>();
		HashMap<String, String> RequirementClassHashMapNewValues = new HashMap<String, String>();
		
		LogInfoHashMap=InitializeLogInfoHashMap(LogInfoHashMap,MethodTracesHashmapValues ); 
		MethodTracesHashmapValues = methodtraces2HashMap.values();

		for (MethodTrace methodtrace : MethodTracesHashmapValues) {

			String reqclass = methodtrace.Requirement.getID() + "-" + methodtrace.getClassRepresentation().ID;
			String reqmethod = methodtrace.Requirement.getID() + "-" + methodtrace.getMethodRepresentation().ID;
			System.out.println(reqclass);

			ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);
			System.out.println(myclasstraceHashMap);

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
		
		
		RequirementClassHashMapNewValues = GenerateNewValuesInTracesClasses(RequirementClassHashMapNewValues);
		j = 0;

		LogInfoHashMap = IntroduceNewValuesWithinLogInfoHashMap(RequirementClassHashMapNewValues, classMethodsHashMap,
				LogInfoHashMap);

		MethodTracesHashmapValues = methodtraces2HashMap.values();
		RequirementMethodNameClassIDHashMap=InitializeRequirementMethodNameClassIDHashMap(RequirementMethodNameClassIDHashMap, MethodTracesHashmapValues); 

		for (MethodTrace methodtrace : MethodTracesHashmapValues) {

			String reqclass = methodtrace.Requirement.getID() + "-" + methodtrace.getClassRepresentation().ID;
			ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);
			String reqmethod = methodtrace.Requirement.getID() + "-" + methodtrace.getMethodRepresentation().ID;
			ITERATION1 = 0;
			LogInfo loginfo = new LogInfo();
			if (LogInfoHashMap.get(reqmethod) != null) {
				loginfo = LogInfoHashMap.get(reqmethod);
			}

			loginfo.setRequirementID(methodtrace.getRequirement().ID);
			loginfo.setRequirementName(methodtrace.getRequirement().RequirementName);
			loginfo.setMethodID(methodtrace.getMethodRepresentation().ID);
			loginfo.setMethodName(methodtrace.getMethodRepresentation().methodname);
			loginfo.setClassID(methodtrace.getClassRepresentation().ID);
			loginfo.setClassName(methodtrace.getClassRepresentation().classname);
			loginfo.setTraceValue(methodtrace.getGoldfinal());
			System.out.println("Trace Class New Value "+loginfo.getTraceClassNewValue());
			String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethodRepresentation().methodname+"-"+methodtrace.getClassRepresentation().ID; 
			// PATTERN 1
			if (myclasstraceHashMap.getTraceFinal() != null) {

				String tracegold2 = myclasstraceHashMap.getTraceFinal();
				tracegold2 = tracegold2.trim();

				if (tracegold2.equals("T") ) {
						loginfo.setOwnerClassPrediction("E");
						PatternSetVariables("E", methodtrace, "100%", "P1");
						LogInfoHashMap.put(reqmethod, loginfo);
						RequirementMethodNameClassIDHashMap.put(ReqMethodClasskey, "E"); 
					
				

				} else if (tracegold2.equals("N")) {

					loginfo.setOwnerClassPrediction("N");
					PatternSetVariables("N", methodtrace, "100%", "P1");
					LogInfoHashMap.put(reqmethod, loginfo);
					RequirementMethodNameClassIDHashMap.put(ReqMethodClasskey, "N"); 

				}

				else {
					loginfo.setOwnerClassPrediction("E");
					PatternSetVariables("E", methodtrace, "100%", "P1");
					LogInfoHashMap.put(reqmethod, loginfo);
					RequirementMethodNameClassIDHashMap.put(ReqMethodClasskey, "E"); 

				}
				ITERATION1++;
			}

			j++;

		}
		LinkedHashMap<String, MethodTrace> MyfinalHashMap = RetrievePredictionsHashMap(methodtraces2);
		// WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap,
		// NEWPATTERNMethodCallsSetToT);
		System.out.println("===============>PATTERNS 1 SET TO T   ITERATION " + ITERATION1 + "   PREDICTION VALUES "
				+ NEWPATTERNMethodCallsFinal.toString());

		int ITERATION = 0;

		PredictionsNewHashMap = InitializePredictionsHashMap(PredictionsNewHashMap, MethodTracesHashmapValues);
		while (Equals(PredictionsOldHashMap, PredictionsNewHashMap) == false) {

			PredictionsOldHashMap = InitializePredictionsHashMap(PredictionsOldHashMap, MethodTracesHashmapValues);

			System.out.println("-------------------------------------------");

			//////////////////////////////////////////////////////////////////////////////////////////
			int k = 0;
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// PURE PATTERNS
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////

			// methodtraces2 =
			// InitializePredictionsHashMapBlankValues(PredictionsOldHashMap,
			// methodtraces22);
			for (MethodTrace methodtrace : MethodTracesHashmapValues) {
				String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.getMethodRepresentation().ID;
				LogInfo LogInfo = LogInfoHashMap.get(reqMethod);
				// methodtrace.setPrediction("");
				List<Method> CalleesList = methodtrace.getCalleesList();
				List<Method> CallersList = methodtrace.getCallersList();

				List<String> PredictionCalleeList = new ArrayList<String>();
				for (Method callee : CalleesList) {
					String RequirementID = methodtrace.Requirement.ID;
					String MethodID = callee.ID;
					String key = MethodID + "-" + RequirementID;
					if (methodtraces2HashMap.get(key) != null) {
						String predictionvalue = methodtraces2HashMap.get(key).getPrediction();
						PredictionCalleeList.add(predictionvalue);
					}

				}

				List<String> PredictionCallerList = new ArrayList<String>();
				for (Method caller : CallersList) {
					String RequirementID = methodtrace.Requirement.ID;
					String MethodID = caller.ID;
					String key = MethodID + "-" + RequirementID;
					if (methodtraces2HashMap.get(key) != null) {
						String predictionvalue = methodtraces2HashMap.get(key).getPrediction();
						PredictionCallerList.add(predictionvalue);
					}
				}

				List<String> iterationValues = LogInfo.getIterationValues();
				String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethodRepresentation().methodname+"-"+methodtrace.getClassRepresentation().ID; 

				// methodtrace.setPrediction("");
				// PURE N PATTERN
				if (PredictionCalleeList.contains("N") && PredictionCallerList.contains("N")
						&& !PredictionCalleeList.contains("T") && !PredictionCallerList.contains("T")
						&& !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N")

				) {
					// methodtrace.setPrediction("N");

					PatternSetVariables("N", methodtrace, "90%", "P2");

					iterationValues.add("N,PureN");
					LogInfo.setIterationValues(iterationValues);
					LogInfoHashMap.put(reqMethod, LogInfo);
					RequirementMethodNameClassIDHashMap.put(ReqMethodClasskey, "N"); 

					// System.out.println("yes");
				}

				// PURE T PATTERN
				else if (!PredictionCalleeList.contains("N") && !PredictionCallerList.contains("N")
						&& PredictionCalleeList.contains("T") && PredictionCallerList.contains("T")
						&& !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N")

				) {
					// methodtrace.setPrediction("N");

					PatternSetVariables("T", methodtrace, "90%", "P2");

					iterationValues.add("T,PureT");
					LogInfo.setIterationValues(iterationValues);
					LogInfoHashMap.put(reqMethod, LogInfo);
					RequirementMethodNameClassIDHashMap.put(ReqMethodClasskey, "T"); 

					// System.out.println("yes");
				}

				// PURE N LEAF PATTERN
				if (PredictionCalleeList.isEmpty() && PredictionCallerList.contains("N")
						&& !PredictionCallerList.contains("T") && !methodtrace.getPrediction().equals("T")
						&& !methodtrace.getPrediction().equals("N")

				) {
					// methodtrace.setPrediction("N");

					iterationValues.add("N,PureNLeaf");
					LogInfo.setIterationValues(iterationValues);
					LogInfoHashMap.put(reqMethod, LogInfo);

					PatternSetVariables("N", methodtrace, "90%", "P4");
					RequirementMethodNameClassIDHashMap.put(ReqMethodClasskey, "N"); 

					// System.out.println("yes");
				}

				// PURE T LEAF PATTERN
				else if (PredictionCalleeList.isEmpty() && !PredictionCallerList.contains("N")
						&& PredictionCallerList.contains("T") && !methodtrace.getPrediction().equals("T")
						&& !methodtrace.getPrediction().equals("N")

				) {
					// methodtrace.setPrediction("N");
					PatternSetVariables("T", methodtrace, "90%", "P2");

					iterationValues.add("T,PureTLeaf");
					LogInfo.setIterationValues(iterationValues);
					LogInfoHashMap.put(reqMethod, LogInfo);
					RequirementMethodNameClassIDHashMap.put(ReqMethodClasskey, "T"); 

					// System.out.println("yes");
				}
				k++;

			}

			k = 0;
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// MIXED PATTERNS
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			for (MethodTrace methodtrace : methodtraces2) {
				String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.getMethodRepresentation().ID;
				LogInfo LogInfo = LogInfoHashMap.get(reqMethod);

				// MIXED PATTERNS
				List<Method> CalleesList = methodtrace.getCalleesList();
				List<Method> CallersList = methodtrace.getCallersList();
				String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethodRepresentation().methodname+"-"+methodtrace.getClassRepresentation().ID; 

				List<String> PredictionCalleeList = new ArrayList<String>();
				for (Method callee : CalleesList) {
					String RequirementID = methodtrace.Requirement.ID;
					String MethodID = callee.ID;
					String key = MethodID + "-" + RequirementID;
					if (methodtraces2HashMap.get(key) != null) {
						String predictionvalue = methodtraces2HashMap.get(key).getPrediction();
						PredictionCalleeList.add(predictionvalue);
					}
				}

				List<String> PredictionCallerList = new ArrayList<String>();
				for (Method caller : CallersList) {
					String RequirementID = methodtrace.Requirement.ID;
					String MethodID = caller.ID;
					String key = MethodID + "-" + RequirementID;

					if (methodtraces2HashMap.get(key) != null) {
						String predictionvalue = methodtraces2HashMap.get(key).getPrediction();
						PredictionCallerList.add(predictionvalue);
					}
				}
				// methodtrace.setPrediction("");

				List<String> mylist;
				List<String> iterationValues = LogInfo.getIterationValues();
				for (String it : iterationValues) {
					System.out.print(it + ", ");
				}
				System.out.println();
				// MIXED N PATTERN
				if (PredictionCalleeList.contains("N") && PredictionCallerList.contains("N")
						&& !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N")

				) {

					PatternSetVariables("N", methodtrace, "80%", "P3");
					iterationValues.add("N,MixedN");
					LogInfo.setIterationValues(iterationValues);
					LogInfoHashMap.put(reqMethod, LogInfo);
					RequirementMethodNameClassIDHashMap.put(ReqMethodClasskey, "N"); 

					// System.out.println("yes");
				}
				// MIXED T PATTERN
				else if (PredictionCalleeList.contains("T") && PredictionCallerList.contains("T")
						&& !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N")

				) {
					// methodtrace.setPrediction("N");
					PatternSetVariables("T", methodtrace, "80%", "P3");
					iterationValues.add("T,MixedT");
					LogInfo.setIterationValues(iterationValues);
					LogInfoHashMap.put(reqMethod, LogInfo);
					RequirementMethodNameClassIDHashMap.put(ReqMethodClasskey, "T"); 

					// System.out.println("yes");
				}

				// MIXED N LEAF PATTERN
				if (PredictionCalleeList.isEmpty() && PredictionCallerList.contains("N")
						&& !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N")

				) {
					iterationValues.add("N,MixedNLeaf");
					LogInfo.setIterationValues(iterationValues);
					PatternSetVariables("N", methodtrace, "80%", "P5");
					LogInfoHashMap.put(reqMethod, LogInfo);
					RequirementMethodNameClassIDHashMap.put(ReqMethodClasskey, "N"); 

				}
				// MIXED T LEAF PATTERN
				else if (PredictionCalleeList.isEmpty() && PredictionCallerList.contains("T")
						&& !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N")

				) {
					iterationValues.add("T,MixedTLeaf");
					LogInfo.setIterationValues(iterationValues);
					PatternSetVariables("T", methodtrace, "80%", "P5");
					LogInfoHashMap.put(reqMethod, LogInfo);
					RequirementMethodNameClassIDHashMap.put(ReqMethodClasskey, "T"); 

				}
				k++;
			}
			// InitializePredictionsHashMapBlankValues(PredictionsNewHashMap,
			// methodtraces2);
			// PRINT

			MyfinalHashMap = RetrievePredictionsHashMap(methodtraces2);
			// WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap,
			// NEWPATTERNMethodCallsSetToT);
			System.out.println("===============>PATTERNS 3 AND 5 ITERATION SET TO T  ITERATION " + ITERATION
					+ "   PREDICTION VALUES " + NEWPATTERNMethodCallsFinal.toString());
			// END PRINT
			CalculateChildrenInterfacesMethodTraces(RequirementMethodNameClassIDHashMap);
			
			
			
			
			for (MethodTrace methodtrace : MethodTracesHashmapValues) {
				String ReqMethod = methodtrace.Requirement.ID + "-" + methodtrace.MethodRepresentation.methodid;
				LogInfo LogInfo = LogInfoHashMap.get(ReqMethod);
				List<String> IterationValues = LogInfo.getIterationValues();
				List<String> interfaces = methodtrace.getInterfaceList();
				List<String> implementations = methodtrace.getImplementationList(); 
				List<String> superclasses = methodtrace.getSuperClassesList(); 
				List<String> children = methodtrace.getChildrenList(); 

				List<String> interfaceTraceValues = new ArrayList<String>();
				for (String inter : interfaces) {
					String[] inters = inter.split("-");
					String interVal = inters[0];
					interfaceTraceValues.add(interVal);
				}

				List<String> implementationsTraceValues = new ArrayList<String>();
				for (String inter : implementations) {
					String[] inters = inter.split("-");
					String interVal = inters[0];
					implementationsTraceValues.add(interVal);
				}

				List<String> superclassesTraceValues = new ArrayList<String>();
				for (String inter : superclasses) {
					String[] inters = inter.split("-");
					String interVal = inters[0];
					superclassesTraceValues.add(interVal);
				}

				List<String> childrenTraceValues = new ArrayList<String>();
				for (String inter : children) {
					String[] inters = inter.split("-");
					String interVal = inters[0];
					childrenTraceValues.add(interVal);
				}
				boolean allEqualInterfaces = interfaceTraceValues.stream().distinct().limit(2).count() <= 1
						&& interfaceTraceValues.size() >= 1;
				boolean allEqualImplementations = implementationsTraceValues.stream().distinct().limit(2).count() <= 1
						&& implementationsTraceValues.size() >= 1;
				boolean allEqualSuperclasses = superclassesTraceValues.stream().distinct().limit(2).count() <= 1
						&& superclassesTraceValues.size() >= 1;
				boolean allEqualChildren = childrenTraceValues.stream().distinct().limit(2).count() <= 1
						&& childrenTraceValues.size() >= 1;

				int interfaceCountT = 0;
				int interfaceCountN = 0;
				int interfaceCountE = 0;
				for (String interfaceval : interfaceTraceValues) {
					if (interfaceval.trim().equals("T")) {
						interfaceCountT++;
					} else if (interfaceval.trim().equals("N")) {
						interfaceCountN++;
					} else {
						interfaceCountE++;
					}
				}
				int impplementationCountT = 0;
				int impplementationCountN = 0;
				int impplementationCountE = 0;
				for (String interfaceval : implementationsTraceValues) {
					if (interfaceval.trim().equals("T")) {
						impplementationCountT++;
					} else if (interfaceval.trim().equals("N")) {
						impplementationCountN++;
					} else {
						impplementationCountE++;
					}
				}
				int superclassCountT = 0;
				int superclassCountN = 0;
				int superclassCountE = 0;
				for (String interfaceval : superclassesTraceValues) {
					if (interfaceval.trim().equals("T")) {
						superclassCountT++;
					} else if (interfaceval.trim().equals("N")) {
						superclassCountN++;
					} else {
						superclassCountE++;
					}
				}

				int childrenCountT = 0;
				int childrenCountN = 0;
				int childrenCountE = 0;
				for (String interfaceval : childrenTraceValues) {
					if (interfaceval.trim().equals("T")) {
						childrenCountT++;
					} else if (interfaceval.trim().equals("N")) {
						childrenCountN++;
					} else {
						childrenCountE++;
					}
				}

				if (((allEqualInterfaces == true && interfaceTraceValues.get(0).equals("N"))
						&& !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N"))
						|| (allEqualImplementations == true && implementationsTraceValues.get(0).equals("N")
								&& !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N"))
						|| (allEqualSuperclasses == true && superclassesTraceValues.get(0).equals("N")
								&& !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N"))
						|| (allEqualChildren == true && childrenTraceValues.get(0).equals("N")
								&& !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N"))

				)

				{
					if (IterationValues != null) {
						IterationValues.add("N,AllNInheritance");
						LogInfo.setIterationValues(IterationValues);
						LogInfoHashMap.put(ReqMethod, LogInfo);
					} else {
						IterationValues = new ArrayList<String>();
						IterationValues.add("N,AllNInheritance");
						LogInfo.setIterationValues(IterationValues);
						LogInfoHashMap.put(ReqMethod, LogInfo);
					}
					PatternSetVariables("N", methodtrace, "90%", "P2");

				}

				if ((allEqualInterfaces == true && interfaceTraceValues.get(0).equals("T")
						&& !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N"))
						|| (allEqualImplementations == true && implementationsTraceValues.get(0).equals("T")
								&& !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N"))
						|| (allEqualSuperclasses == true && superclassesTraceValues.get(0).equals("T")
								&& !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N"))
						|| (allEqualChildren == true && childrenTraceValues.get(0).equals("T")
								&& !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N"))

				)

				{

					if (IterationValues != null) {
						IterationValues.add("T,AllTInheritance");
						LogInfo.setIterationValues(IterationValues);
						LogInfoHashMap.put(ReqMethod, LogInfo);
					} else {
						IterationValues = new ArrayList<String>();
						IterationValues.add("T,AllTInheritance");
						LogInfo.setIterationValues(IterationValues);
						LogInfoHashMap.put(ReqMethod, LogInfo);
					}
					PatternSetVariables("T", methodtrace, "90%", "P2");

				}
			}

			// PRINT

			for (MethodTrace methodtrace : MethodTracesHashmapValues) {
				String ReqMethod = methodtrace.Requirement.ID + "-" + methodtrace.MethodRepresentation.methodid;
				LogInfo LogInfo = LogInfoHashMap.get(ReqMethod);
				List<String> myits = LogInfo.getIterationValues();
				if (myits.size() == ITERATION + 1) {
					System.out.println(myits.get(ITERATION));

				} else {
					myits.add(" ");
					LogInfo.setIterationValues(myits);
				}

				for (String it : myits) {
					System.out.println("it" + it + " it");
				}
				LogInfoHashMap.put(ReqMethod, LogInfo);
			}
			MyfinalHashMap = RetrievePredictionsHashMap(methodtraces2);

			// END PRINT
			ITERATION++;
			System.out.println("HEEEEEEY  " + ITERATION);

			PredictionsNewHashMap = InitializePredictionsHashMap(PredictionsNewHashMap, MethodTracesHashmapValues);
		}
		
		
		//SET EVERYTHING ELSE TO T 
//		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
//
//			if(methodtrace.getPrediction().equals("") || methodtrace.getPrediction()==null|| methodtrace.getPrediction().equals("E")) {
//				methodtrace.setPrediction("T");
//			}
//		}

		WriteInDatabaseAndComputePrecisionAndRecall(methodtraces2, NEWPATTERNMethodCallsFinal, LogInfoHashMap);
		System.out.println("===============>PATTERNS 2 AND 4 ITERATION SET TO T   ITERATION  " + ITERATION
				+ "   PREDICTION VALUES " + NEWPATTERNMethodCallsFinal.toString());

		bwfile1.write(NEWPATTERNMethodCallsFinal.toString());
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
		int counter=0; 
		for (MethodTrace methodtrace : MethodTracesHashmapValues) {
			String reqmethod = methodtrace.Requirement.ID + "-" + methodtrace.MethodRepresentation.methodid;
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

	private HashMap<String, LogInfo> InitializeLogInfoHashMap(HashMap<String, LogInfo> logInfoHashMap,
			Collection<MethodTrace> methodTracesHashmapValues) {
		// TODO Auto-generated method stub
		for(MethodTrace methval: methodTracesHashmapValues) {
			String Req= methval.getRequirement().ID; 
			String Method= methval.getMethodRepresentation().ID; 
			LogInfo loginfo= new LogInfo(); 			
			logInfoHashMap.put(Req+"-"+Method, loginfo); 
		}
		return logInfoHashMap; 
	}

	public HashMap<String, String> InitializeRequirementMethodNameClassIDHashMap(
			HashMap<String, String> requirementMethodNameClassIDHashMap2, Collection<MethodTrace> methodTracesHashmapValues) {
		
		for(MethodTrace methodtrace: methodTracesHashmapValues){
			String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethodRepresentation().methodname+"-"+methodtrace.ClassRepresentation.classid; 

			requirementMethodNameClassIDHashMap2.put(ReqMethodClasskey, "E"); 
		}
		
				return requirementMethodNameClassIDHashMap2;
		// TODO Auto-generated method stub
		
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	private HashMap<String, LogInfo> IntroduceNewValuesWithinLogInfoHashMap(
			HashMap<String, String> requirementClassHashMapNewValues,
			HashMap<String, List<String>> classMethodsHashMap2, HashMap<String, LogInfo> logInfoHashMap) {
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
	 * @return
	 **********************************************************************************************************************************************/

	private HashMap<String, String> GenerateNewValuesInTracesClasses(
			HashMap<String, String> requirementClassHashMapNewValues) {
		// TODO Auto-generated method stub
		int j = 0;
		Collection<MethodTrace> MethodTracesHashmapValues = methodtraces2HashMap.values();

		for (MethodTrace methodtrace : MethodTracesHashmapValues) {

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
					methodtracesRequirementClass.put(
							methodtrace.Requirement.getID() + "-" + methodtrace.ClassRepresentation.classid,
							myclasstraceNew);
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
	 * @param requirementMethodNameClassIDHashMap2 **********************************************************************************************************************************************/
	public void CalculateChildrenInterfacesMethodTraces(HashMap<String, String> requirementMethodNameClassIDHashMap2) {
		// TODO Auto-generated method stub
		int j = 0;
		Collection<MethodTrace> MethodTracesHashmapValues = methodtraces2HashMap.values();
		for (MethodTrace methodtrace : MethodTracesHashmapValues) {
		

			List<String> SuperClassesList = new ArrayList<String>();
			List<String> InterfaceList = new ArrayList<String>();
			List<String> ChildrenList = new ArrayList<String>();
			List<String> ImplementationList = new ArrayList<String>();
			System.out.println(methodtraces2.size());
			System.out.println(j);
			System.out.println(methodtraces2HashMap.size());
			String ReqID= methodtrace.Requirement.ID; 
			String MethodName= methodtrace.MethodRepresentation.methodname; 


			String ReqMethod=ReqID+"-"+MethodName; 
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			List<Interface2> myinterfaces = InterfacesOwnerClassHashMap.get(methodtrace.ClassRepresentation.classid);
			List<SuperClass2> mysuperclasses = SuperclassesHashMap.get(methodtrace.ClassRepresentation.classid);
			List<Implementation2> myimplementations = INTERFACEHASHMAPFINAL.get(methodtrace.ClassRepresentation.classid);
			List<Children2> mychildren = ChildrenHashMap.get(methodtrace.ClassRepresentation.classid);
			
			
			System.out.println("Methodtrace class id " + methodtrace.ClassRepresentation.classid);
			if (myinterfaces != null)
				for (Interface2 myinterface : myinterfaces) {
					String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethodRepresentation().methodname+"-"+myinterface.InterfaceClass.ID; 
					String TraceValue = requirementMethodNameClassIDHashMap2.get(ReqMethodClasskey);
					
					InterfaceList.add(TraceValue + "-" + myinterface.getInterfaceClass().getClassid() + "-"
									+ methodtrace.ClassRepresentation.classid);
						
				}
			if (mysuperclasses != null)
				for (SuperClass2 mysuperclass : mysuperclasses) {
					String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethodRepresentation().methodname+"-"+mysuperclass.SuperClass.ID; 
							
					String TraceValue = requirementMethodNameClassIDHashMap2.get(ReqMethodClasskey);
					
					SuperClassesList.add(TraceValue + "-" + mysuperclass.getSuperClass().ID + "-"
									+ methodtrace.ClassRepresentation.classid);
					
					
					
				}
			if (mychildren != null)
				for (Children2 mychild : mychildren) {
				String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethodRepresentation().methodname+"-"+mychild.OwnerClass.ID; 
				
				String TraceValue = requirementMethodNameClassIDHashMap2.get(ReqMethodClasskey);
		
				ChildrenList.add(TraceValue + "-" + mychild.getOwnerClass().ID + "-"
						+ methodtrace.ClassRepresentation.classid);
				
				}
			if (myimplementations != null)
				for (Implementation2 myimplementation : myimplementations) {
					String ReqMethodClasskey=methodtrace.Requirement.ID+"-"+methodtrace.getMethodRepresentation().methodname+"-"+myimplementation.Implementation.ID;  
					
					String TraceValue = requirementMethodNameClassIDHashMap2.get(ReqMethodClasskey);
			
					ImplementationList.add(TraceValue + "-" + myimplementation.getImplementation().ID + "-"
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
		Collection<MethodTrace> MethodTracesHashmapValues = methodtraces2HashMap.values();
		for (MethodTrace methodtrace : MethodTracesHashmapValues) {
			List<String> PredictionParams = new ArrayList<String>();
			List<String> PredictionParamsOwnerClass = new ArrayList<String>();
			List<String> PredictionFields = new ArrayList<String>();
			List<String> PredictionFieldsOwnerClass = new ArrayList<String>();
			System.out.println(methodtraces2.size());
			System.out.println(j);
			System.out.println(methodtraces2HashMap.size());

			List<MethodField2> mymethodfields = FieldMethodsHashMap.get(methodtrace.MethodRepresentation.methodid);
			List<Parameter2> paramlist = parameterHashMap.get(methodtrace.MethodRepresentation.methodid);
			if (mymethodfields != null)
				for (MethodField2 mymeth : mymethodfields) {
					String reqclass = methodtrace.Requirement.ID + "-" + mymeth.getMethodFieldType().ID;
					ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);
					if (myclasstraceHashMap != null)
						if (myclasstraceHashMap.getTraceFinal() != null) {
							String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
							PredictionFields.add(traceGold2V2);
						}
				}
			if (paramlist != null) {
				for (Parameter2 mymeth : paramlist) {
					String reqclass = methodtrace.Requirement.ID + "-" + mymeth.getParameterType().ID;
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
					String reqclass = methodtrace.Requirement.ID + "-" + mymeth.getOwnerClass().ID;
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
					String reqclass = methodtrace.Requirement.ID + "-" + mymeth.getOwnerClass().ID;
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
			System.out.println(methodtraces2.size());
			System.out.println(j);
			System.out.println(methodtraces2HashMap.size());

			List<Interface2> myinterfaces = InterfacesOwnerClassHashMap.get(methodtrace.ClassRepresentation.classid);
			List<SuperClass2> mysuperclasses = SuperclassesHashMap.get(methodtrace.ClassRepresentation.classid);
			List<Implementation2> myimplementations = INTERFACEHASHMAPFINAL
					.get(methodtrace.ClassRepresentation.classid);
			List<Children2> mychildren = ChildrenHashMap.get(methodtrace.ClassRepresentation.classid);
			System.out.println("Methodtrace class id " + methodtrace.ClassRepresentation.classid);
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
					String reqclass = methodtrace.Requirement.ID + "-" + mysuperclass.getSuperClass().ID;
					ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);
					if (myclasstraceHashMap != null)
						if (myclasstraceHashMap.getTraceFinal() != null) {
							String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
							SuperClassesList.add(traceGold2V2 + "-" + mysuperclass.getSuperClass().ID + "-"
									+ methodtrace.ClassRepresentation.classid);
						}
				}
			if (mychildren != null)
				for (Children2 mychild : mychildren) {
					String reqclass = methodtrace.Requirement.ID + "-" + mychild.getOwnerClass().ID;
					ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);
					if (myclasstraceHashMap != null)
						if (myclasstraceHashMap.getTraceFinal() != null) {
							String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
							ChildrenList.add(traceGold2V2 + "-" + mychild.getOwnerClass().ID + "-"
									+ methodtrace.ClassRepresentation.classid);
						}
				}
			if (myimplementations != null)
				for (Implementation2 myimplementation : myimplementations) {
					String reqclass = methodtrace.Requirement.ID + "-" + myimplementation.getImplementation().ID;
					ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass);
					if (myclasstraceHashMap != null)
						if (myclasstraceHashMap.getTraceFinal() != null) {
							String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
							ImplementationList.add(traceGold2V2 + "-" + myimplementation.getImplementation().ID
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
	 **********************************************************************************************************************************************/
	public void WriteInDatabaseAndComputePrecisionAndRecall(List<MethodTrace> methodtraces22,
			PredictionEvaluation nEWPATTERNMethodCallsSetToT2, HashMap<String, LogInfo> logInfoHashMap) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		nEWPATTERNMethodCallsSetToT2.ResetCounters(nEWPATTERNMethodCallsSetToT2);

		for (MethodTrace mykey : methodtraces22) {
			String methodid = mykey.getMethodRepresentation().ID;
			String requirementID = mykey.getRequirement().ID;
			String ReqMethod = requirementID + "-" + methodid;
			LogInfo logInfo = logInfoHashMap.get(ReqMethod);
			// String query= "UPDATE `traces` SET `prediction` ='"+ myvalue.getPrediction()
			// +"'WHERE requirementid='"+RequirementID+"' AND methodid ='"+methodid+"'";
			String likelihood = mykey.getLikelihood();
			String why = mykey.getWhy();

			// String query="UPDATE `traces` SET `prediction` ='"+ myvalue.getPrediction()
			// +"',"+"`likelihood` ='"+ likelihood+"',"+"`why` ='"+ why
			// +"'WHERE requirementid='"+myvalue.Requirement.ID+"' AND
			// methodid='"+myvalue.MethodRepresentation.methodid+"'";
			//
			// st.executeUpdate(query);

			// System.out.println(myvalue.getGoldfinal()+" "+myvalue.getPrediction());
			// st.executeUpdate("UPDATE `traces` SET +"'WHERE
			// requirementid='"+entry.RequirementID+"' AND method='"+name+"'");

			// System.out.println("PREDICTION "+mykey.getPrediction()+" ------------ gold2
			// "+mykey.goldfinal);
			if (mykey.getGoldfinal() != null && mykey.getPrediction() != null) {
				String Result = nEWPATTERNMethodCallsSetToT2.ComparePredictionToGold(mykey.getGoldfinal().trim(),
						mykey.getPrediction().trim());
				logInfo.setPrecisionRecall(Result);
				nEWPATTERNMethodCallsSetToT2.UpdateCounters(Result, nEWPATTERNMethodCallsSetToT2);
				logInfoHashMap.put(ReqMethod, logInfo);
			}

		}
		nEWPATTERNMethodCallsSetToT2.toString();

		System.out.println("FINAL RESULT ====== " + nEWPATTERNMethodCallsSetToT2.toString());

	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/

	public void WriteInDatabaseAndComputePrecisionAndRecall(
			LinkedHashMap<String, MethodTrace> MyfinalHashMap,
			PredictionEvaluation nEWPATTERNMethodFields2) throws SQLException {
		// TODO Auto-generated method stub
		nEWPATTERNMethodFields2.ResetCounters(nEWPATTERNMethodFields2);

		for (String mykey : MyfinalHashMap.keySet()) {
			MethodTrace myvalue = MyfinalHashMap.get(mykey);
			String methodid = myvalue.getMethodRepresentation().ID;
			String requirementID = myvalue.getRequirement().ID;
			// String query= "UPDATE `traces` SET `prediction` ='"+ myvalue.getPrediction()
			// +"'WHERE requirementid='"+RequirementID+"' AND methodid ='"+methodid+"'";
			String likelihood = myvalue.getLikelihood();
			String why = myvalue.getWhy();

			// String query="UPDATE `traces` SET `prediction` ='"+ myvalue.getPrediction()
			// +"',"+"`likelihood` ='"+ likelihood+"',"+"`why` ='"+ why
			// +"'WHERE requirementid='"+myvalue.Requirement.ID+"' AND
			// methodid='"+myvalue.MethodRepresentation.methodid+"'";
			//
			// st.executeUpdate(query);

			// System.out.println(myvalue.getGoldfinal()+" "+myvalue.getPrediction());
			// st.executeUpdate("UPDATE `traces` SET +"'WHERE
			// requirementid='"+entry.RequirementID+"' AND method='"+name+"'");

			System.out.println("PREDICTION  " + myvalue.getPrediction() + " ------------  gold2  " + myvalue.goldfinal);
			if (myvalue.getGoldfinal() != null && myvalue.getPrediction() != null) {
				String Result = nEWPATTERNMethodFields2.ComparePredictionToGold(myvalue.getGoldfinal().trim(),
						myvalue.getPrediction().trim());
				nEWPATTERNMethodFields2.UpdateCounters(Result, nEWPATTERNMethodFields2);
			}

		}
		nEWPATTERNMethodFields2.toString();

		System.out.println("FINAL RESULT ====== " + nEWPATTERNMethodFields2.toString());
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
			String MethodID = methodtrace.MethodRepresentation.methodid;
			String key = MethodID + "-" + RequirementID;
			predictionsOldHashMap.put(key, methodtrace.getPrediction());
		}
		return predictionsOldHashMap;
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/

	public List<MethodTrace> InitializePredictionsHashMapBlankValues(
			LinkedHashMap<String, String> predictionsOldHashMap, List<MethodTrace> methodtraces22) {
		// TODO Auto-generated method stub

		for (MethodTrace methodtrace : methodtraces22) {
			methodtrace.setPrediction("");
		}
		return methodtraces22;
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
			String MethodID = methodtrace.MethodRepresentation.methodid;
			String key = MethodID + "-" + RequirementID;
			predictionsOldHashMap.put(key, methodtrace);
		}
		return predictionsOldHashMap;
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	public void PatternSetVariables(String Prediction, MethodTrace methodtrace, String Likelihood,
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
		TracesTableChessFINALROUND2MethodCallsFinalVersion frame = new TracesTableChessFINALROUND2MethodCallsFinalVersion(
				ProgramName);

		String ProgramName2 = "gantt";
			 frame = new TracesTableChessFINALROUND2MethodCallsFinalVersion(ProgramName2);

		String ProgramName3 = "itrust";
			 frame = new TracesTableChessFINALROUND2MethodCallsFinalVersion(ProgramName3);

		String ProgramName4 = "jhotdraw";
			frame = new TracesTableChessFINALROUND2MethodCallsFinalVersion(ProgramName4);
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
								System.out.println("YEEEEEEEEEEEEEEEEEEEEEES IT IS EQUAL");
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