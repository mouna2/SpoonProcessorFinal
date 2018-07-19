package JHotDraw;

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
import java.util.Properties;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.sql.Connection;
import java.sql.DriverManager;

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

import Chess.PredictionEvaluation;
import mypackage.ClassRepresentation2;
import mypackage.ClassTrace2;
import mypackage.ColumnGroup;
import mypackage.GroupableTableHeader;
import mypackage.Method2Details;
import mypackage.Method2Representation;
import mypackage.MethodTraceSubjectTSubjectN;
import mypackage.Parameter2;
import mypackage.RequirementClass;
import mypackage.RequirementGold;

public class TracesTableJHotDraw extends JFrame {
	
	int Row=0; 
	int MethodID=1; 
	int MethodName=2; 
	int RequirementID=3; 
	int RequirementName=4; 
	int ClassID=5; 
	int ClassName=6; 
	int Gold=7; 
	int Subject=8; 
	int OwnerClassT=9; 
	int OwnerClassN=10; 
	int OwnerClassE=11; 
	int CallerMethodsNumber=12; 
	int CallerMethodsT=13; 
	int CallerMethodsN=14; 
	int CallerMethodsE=15; 
	int CallerClassesNumber=16; 
	int CallerClassesT=17; 
	int CallerClassesN=18; 
	int CallerClassesE=19; 
	int CalleeMethodsNumber=20; 
	int CalleeMethodsT=21; 
	int CalleeMethodsN=22; 
	int CalleeMethodsE=23; 
	int CalleeClassesNumber=24; 
	int CalleeClassesT=25; 
	int CalleeClassesN=26; 
	int CalleeClassesE=27; 
	int OwnerClassPrediction=28; 
	int MajorityClassLevelCallers=29; 
	int MajorityClassLevelCallees=30; 
	int MajorityMethodLevelCallers=31; 
	int MajorityMethodLevelCallees=32; 
	int AtLeast1NPredictionClassLevelCallers=33; 
	int AtLeast1NPredictionClassLevelCallees=34; 
	int AtLeast1NPredictionMethodLevelCallers=35; 
	int AtLeast1NPredictionMethodLevelCallees=36; 
	int AtLeast1TPredictionClassLevelCallers=37; 
	int AtLeast1TPredictionClassLevelCallees=38; 
	int AtLeast1TPredictionMethodLevelCallers=39; 
	int AtLeast1TPredictionMethodLevelCallees=40; 
	int AtLeast2NPredictionClassLevelCallers=41; 
	int AtLeast2NPredictionClassLevelCallees=42; 
	int AtLeast2NPredictionMethodLevelCallers=43; 
	int AtLeast2NPredictionMethodLevelCallees=44; 
	int AtLeast2TPredictionClassLevelCallers=45; 
	int AtLeast2TPredictionClassLevelCallees=46; 
	int AtLeast2TPredictionMethodLevelCallers=47; 
	int AtLeast2TPredictionMethodLevelCallees=48; 
	int AllNClassLevelCallers=49; 
	int AllNClassLevelCallees=50; 
	int AllNMethodLevelCallers=51; 
	int AllNMethodLevelCallees=52; 
	int AllTClassLevelCallers=53; 
	int AllTClassLevelCallees=54; 
	int AllTMethodLevelCallers=55; 
	int AllTMethodLevelCallees=56; 
	int Callers=57; 
	int Callees=58; 
	int paramatersNumber=59; 
	int CountParamaterT=61; 
	int CountParamaterN=62; 
	int CountParamaterE=63; 
	int MajorityParameters=64; 
	int AtLeast1NParameter=65; 
	int AtLeast1TParameter=66; 
	
	int AtLeast2TParameter=67; 
	int AtLeast2NParameter=68; 
	int AllNParameters=69; 
	int AllTParameters=70; 
	PredictionEvaluation OwnerClassPredictionClass= new PredictionEvaluation(); 
	PredictionEvaluation MajorityClassLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation MajorityClassLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation MajorityMethodLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation MajorityMethodLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionClassLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionClassLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionMethodLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionMethodLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionClassLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionClassLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionMethodLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionMethodLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionClassLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionClassLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionMethodLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionMethodLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionClassLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionClassLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionMethodLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionMethodLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation MajorityParametersClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast1NParameterClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NParameterClass= new PredictionEvaluation(); 

	PredictionEvaluation AtLeast1TParameterClass= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TParameterClass= new PredictionEvaluation(); 

	PredictionEvaluation AllNParameterClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTParameterClass= new PredictionEvaluation(); 
	ClassTrace2 myclasstrace = new ClassTrace2();
	static List<MethodTraceSubjectTSubjectN> methodtraces2 = new ArrayList<MethodTraceSubjectTSubjectN>();
	static List<ClassTrace2> classtraces2 = new ArrayList<ClassTrace2>();
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass = new  LinkedHashMap<String, ClassTrace2>(); 
	JTable table = new JTable(); 
	static List<Method2Details> methodlist = new ArrayList<Method2Details>();
	//File fout = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\GanttFiles\\TableLog.txt");
	File fout = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\TableLogJHotDraw.txt");
	FileOutputStream fos = new FileOutputStream(fout);
	
	File fout2 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\JHotDrawFiles\\PredictionEvaluation.txt");
	FileOutputStream fos2 = new FileOutputStream(fout2);
	
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(fos2));
	
	private final String userName = "root";
	private final String password = "123456";
	List<Method2Representation> CallerMethodListFinal = new ArrayList<Method2Representation>();
	List<Method2Representation> CalleeMethodListFinal = new ArrayList<Method2Representation>();

	public List<Method2Representation> getCallerMethodListFinal() {
		return CallerMethodListFinal;
	}

	public void setCallerMethodListFinal(List<Method2Representation> callerMethodListFinal) {
		CallerMethodListFinal = callerMethodListFinal;
	}

	public List<Method2Representation> getCalleeMethodListFinal() {
		return CalleeMethodListFinal;
	}

	public void setCalleeMethodListFinal(List<Method2Representation> calleeMethodListFinal) {
		CalleeMethodListFinal = calleeMethodListFinal;
	}

	public TracesTableJHotDraw() throws SQLException, IOException {
	
		bw.write("Row, MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold, Subject, OwnerClassT, OwnerClassN, "
				+ "OwnerClassE, #callermethods, callers, #callermethodsT, #callermethodsN, #callermethodsE, #callerclasses, #callerclassesT, #callerclassesN, "
				+ "#callerclassesE, #calleemethods, callees, #calleemethodsT, #calleemethodsN, #calleemethodsE, #calleeclasses, #calleeclassesT, #calleeclassesN, "
				+ "#calleeclassesE, OwnerClassPrediction, MajorityClassLevelCallers, MajorityClassLevelCallees, MajorityMethodLevelCallers, MajorityMethodLevelCallees,"
				+ "AtLeast1NPredictionClassLevelCallers, AtLeast1NPredictionClassLevelCallees, AtLeast1NPredictionMethodLevelCallers, AtLeast1NPredictionMethodLevelCallees, "
				+"AtLeast1TPredictionClassLevelCallers, AtLeast1TPredictionClassLevelCallees, AtLeast1TPredictionMethodLevelCallers, AtLeast1TPredictionMethodLevelCallees,"
				+ "AtLeast2NPredictionClassLevelCallers, AtLeast2NPredictionClassLevelCallees, AtLeast2NPredictionMethodLevelCallers, AtLeast2NPredictionMethodLevelCallees, "
				+"AtLeast2TPredictionClassLevelCallers, AtLeast2TPredictionClassLevelCallees, AtLeast2TPredictionMethodLevelCallers, AtLeast2TPredictionMethodLevelCallees,"
				+"AllNClassLevelCallers, AllNClassLevelCallees, AllNMethodLevelCallers, AllNMethodLevelCallees,"
				+"AllTClassLevelCallers, AllTClassLevelCallees, AllTMethodLevelCallers, AllTMethodLevelCallees,"
				+ " OnlyInParsedCallers, OnlyInExecutedCallers, BothParsedAndExecutedCallers, "
				+ "OnlyInParsedCallees, OnlyInExecutedCallees, BothParsedAndExecutedCallees"
				+ " #parameters, parameters, # Parameter T, # Parameter N, # Parameter E" 
				+ "MajorityParameter ,AtLeast1NParameterPrediction" + 
				"AtLeast1TParameterPrediction, AtLeast2TParameterPrediction, AtLeast2NParameterPrediction,  AllNParameterPrediction, AllTParameterPrediction, SubjectT, SubjectN" );
		bw.newLine();
		DatabaseReading2JHotDraw db = new DatabaseReading2JHotDraw();
		DatabaseReading2JHotDraw.MakePredictions();
		methodtraces2 = db.getMethodtraces2();
		 methodtracesRequirementClass = db.getClassesRequirementtraceshashmap(); 
		//classtraces2 = db.getClassestraces2();
		//methodlist = db.getMethodlist();
		List<TableCellEditor> editors1 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> editors2 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> editors3 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> editors4 = new ArrayList<TableCellEditor>(methodtraces2.size());
		int j = 0;
		//int j=24090; 
		final int jfinal=0; 
		String[] items1 = new String[methodtraces2.size()];
		String[] items2 = new String[methodtraces2.size()];
		String[] items3 = new String[methodtraces2.size()];
		String[] items4 = new String[methodtraces2.size()];
		String[] items5 = new String[methodtraces2.size()];
		String[] items6 = new String[methodtraces2.size()];
//		String[] items1 = new String[100];
//		String[] items2 = new String[100];
//		String[] items3 = new String[100];
//		String[] items4 = new String[100];
//		String[] items5 = new String[100];
//		String[] items6 = new String[100];
		String[] myparameters = new String[methodtraces2.size()];
		Method2Representation[] callersarr = new Method2Representation[methodtraces2.size()];
		Method2Representation[] callersex = new Method2Representation[methodtraces2.size()];
		Method2Representation[] calleesarr = new Method2Representation[methodtraces2.size()];
		Method2Representation[] calleesex = new Method2Representation[methodtraces2.size()];
		Object[][] data = new Object[methodtraces2.size()][100];
		// Create the editors to be used for each row
		for (MethodTraceSubjectTSubjectN methodtrace : methodtraces2) {
			System.out.println("LOOP INDEX===========> "+j); 
			data[j][Row] = j; 
			data[j][MethodID] = methodtrace.MethodRepresentation.getMethodid();
			data[j][MethodName] = methodtrace.MethodRepresentation.getMethodname();
			data[j][RequirementID] = methodtrace.Requirement.getID();
			data[j][RequirementName] = methodtrace.Requirement.getRequirementName();
			data[j][ClassID] = methodtrace.ClassRepresentation.classid;
			data[j][ClassName] = methodtrace.ClassRepresentation.classname;
			data[j][Gold] = methodtrace.gold;
			data[j][Subject] = methodtrace.subject;
			// data[j][CalleePrediction]= methodtrace.goldpredictionCaller;
			// data[j][CallerPrediction]= methodtrace.goldpredictionCallee;
			String reqclass= data[j][RequirementID].toString()+"-"+ data[j][ClassID].toString(); 
			ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
			LinkedHashMap<String, Method2Details> linkedmethodhashmap= new LinkedHashMap<String, Method2Details>(); 
			 linkedmethodhashmap = db.getLinkedmethodhashmap(); 
			/*for (ClassTrace2 classtrace : classtraces2) {
				System.out.println("METHOD TRACE CLASS REPRESENTATION CLASS ID "+methodtrace.ClassRepresentation.classid);
				System.out.println("CLASS TRACE REPRESENTATION CLASS ID "+classtrace.getMyclass().classid);
				System.out.println("METHOD TRACE REQUIREMENT  ID "+methodtrace.Requirement.getID());
				System.out.println("CLASS TRACE REQUIREMENT  ID "+classtrace.getRequirement().getID());
				if (methodtrace.ClassRepresentation.classid.equals(classtrace.getMyclass().classid)
						&& methodtrace.Requirement.getID().equals(classtrace.getRequirement().getID())) {
					String trace = classtrace.gettrace();
					trace=trace.trim(); 
					if (trace.equals("T")) {
						data[j][OwnerClassT] = "1";
						data[j][OwnerClassN] = "0";
						data[j][OwnerClassE] = "0";
						System.out.println("OWNERCLASS T  "+j +" set to 1");
					} else if (trace.equals("N")) {
						data[j][OwnerClassT] = "0";
						data[j][OwnerClassN] = "1";
						data[j][OwnerClassE] = "0";
						System.out.println("OWNERCLASS N  "+j +" set to 1");
					} else if (trace.equals("E")) {
						data[j][OwnerClassT] = "0";
						data[j][OwnerClassN] = "0";
						data[j][OwnerClassE] = "1";
						System.out.println("OWNERCLASS E  "+j +" set to 1");
					}
				break; 
				}

			}*/

			data[j][OwnerClassT] = "";
			data[j][OwnerClassN] = "";
			data[j][OwnerClassE] = "";
			
			System.out.println("METHOD TRACE CLASS REPRESENTATION CLASS ID "+methodtrace.ClassRepresentation.classid);
		//	System.out.println("CLASS TRACE REPRESENTATION CLASS ID "+myclasstraceHashMap.getMyclass().classid);
			System.out.println("METHOD TRACE REQUIREMENT  ID "+methodtrace.Requirement.getID());
		//	System.out.println("CLASS TRACE REQUIREMENT  ID "+myclasstraceHashMap.getRequirement().getID());
			//if (methodtrace.ClassRepresentation.classid.equals(myclasstraceHashMap.getMyclass().classid)
			//		&& methodtrace.Requirement.getID().equals(myclasstraceHashMap.getRequirement().getID())) {
			if(myclasstraceHashMap!=null) {
				String trace = myclasstraceHashMap.gettrace();
				trace=trace.trim(); 
				if (trace.equals("T")) {
					data[j][OwnerClassT] = "1";
					data[j][OwnerClassN] = "0";
					data[j][OwnerClassE] = "0";
					System.out.println("OWNERCLASS T  "+j +" set to 1");
				} else if (trace.equals("N")) {
					data[j][OwnerClassT] = "0";
					data[j][OwnerClassN] = "1";
					data[j][OwnerClassE] = "0";
					System.out.println("OWNERCLASS N  "+j +" set to 1");
				} else if (trace.equals("E")) {
					data[j][OwnerClassT] = "0";
					data[j][OwnerClassN] = "0";
					data[j][OwnerClassE] = "1";
					System.out.println("OWNERCLASS E  "+j +" set to 1");
				}
			}
			
			
			//}
			
			
			/*int count = 0;
			String classID = "";
			int ClassCountCaller = 0;
			for (Method2Representation caller : methodtrace.getCallersList()) {

				for (Method2Details meth : methodlist) {
					if (meth.getMethodrep().getMethodid().equals(caller.getMethodid()) && count == 0) {
						classID = meth.getOwnerClass().classid;
						ClassCountCaller++;
					} else if (meth.getMethodrep().getMethodid().equals(caller.getMethodid())
							&& (classID.equals(meth.getOwnerClass().classid)) == false) {
						ClassCountCaller++;
					}
				}

				count++;

			}

			for (Method2Representation caller : methodtrace.getCallersListExecuted()) {

				for (Method2Details meth : methodlist) {
					if (meth.getMethodrep().getMethodid().equals(caller.getMethodid()) && count == 0) {
						classID = meth.getOwnerClass().classid;
						ClassCountCaller++;
					} else if (meth.getMethodrep().getMethodid().equals(caller.getMethodid())
							&& (classID.equals(meth.getOwnerClass().classid)) == false) {
						ClassCountCaller++;
					}
				}

				count++;

			}
			count = 0;
			classID = "";
			int ClassCountCallee = 0;
			for (Method2Representation callee : methodtrace.getCalleesList()) {

				for (Method2Details meth : methodlist) {
					if (meth.getMethodrep().getMethodid().equals(callee.getMethodid()) && count == 0) {
						classID = meth.getOwnerClass().classid;
						ClassCountCallee++;
					} else if (meth.getMethodrep().getMethodid().equals(callee.getMethodid())
							&& (classID.equals(meth.getOwnerClass().classid)) == false) {
						ClassCountCallee++;
					}
				}

				count++;

			}
			*/

		
			int BothParsedAndExecutedCallers=0; 
			int OnlyinParsedCallers=0;
			int OnlyinExecutedCallers=0; 
			int CountCallers = 0;
			items1 = new String[methodtrace.getCallersList().size()];
			callersarr = new Method2Representation[methodtrace.getCallersList().size()];
			
			
			
			int myparametercount=0; 
			/////////////////////////////////	
				
				int counterParameterT=0; 
				int counterParameterN=0; 
				int counterParameterE=0; 
				 myparameters = new String[methodtraces2.size()];
				 String ParametersAppended=""; 
				Method2Details mymethodobje = linkedmethodhashmap.get(methodtrace.MethodRepresentation.methodid); 
				for ( Parameter2 myparam : mymethodobje.getParameters()) {
					myparameters[myparametercount] = myparam.toString(); 
					
					myparametercount++;
					
					ParametersAppended=ParametersAppended+myparam.toString()+"-"; 
					String ParameterClassid = myparam.getParameterType().classid; 
					
					ClassTrace2 mycallerclass = myclasstrace.FindTrace2(methodtracesRequirementClass, ParameterClassid,	methodtrace.Requirement.getID());
					if(mycallerclass!=null) {
						String mytrace=mycallerclass.gettrace(); 
						if(mytrace.equals("T")) {
							counterParameterT++; 
						}else if (mytrace.equals("N")) {
							counterParameterN++; 
						}else {
							counterParameterE++; 
						}
					}
					

				}
				ParametersAppended=ParametersAppended.replaceAll(",", "/"); 

				data [j][CountParamaterT]= counterParameterT; 
				data [j][CountParamaterN]= counterParameterN; 
				data [j][CountParamaterE]= counterParameterE; 
				
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				data [j][paramatersNumber]= myparametercount; 
				
				
				
				
				
				
			for (Method2Representation caller : methodtrace.getCallersList()) {
				items1[CountCallers] = caller.toString2();
				callersarr[CountCallers] = caller;
				System.out.println(caller.toString2());
				CountCallers++;
				
				
				
				
				

			}

			int CountCallersExecuted = 0;
			items2 = new String[methodtrace.getCallersListExecuted().size()];
			callersex = new Method2Representation[methodtrace.getCallersListExecuted().size()];
			for (Method2Representation caller : methodtrace.getCallersListExecuted()) {

				boolean equalbool = false;
				if (items1.length == 0) {
					items2[CountCallersExecuted] = caller.toString2();
					callersex[CountCallersExecuted] = caller;
				
						
					
					CountCallersExecuted++;
					OnlyinExecutedCallers++; 

				} else {
					for (String item : items1) {
						item = item.replaceAll("\\(.*\\)", "");

						if (item.equals(caller.toString2()) == true) {
							BothParsedAndExecutedCallers++; 
							equalbool = true;
						}
					}
					if (equalbool == false) {
						
							
						
						items2[CountCallersExecuted] = caller.toString2();
						callersex[CountCallersExecuted] = caller;
						CountCallersExecuted++;
						OnlyinExecutedCallers++; 
					}
				}

			}
		
			
			
			
			
			
			
			int CountCallerExecuted=0; 
			String[] itemsExecuted = new String[methodtrace.getCallersListExecuted().size()];
			for (Method2Representation caller : methodtrace.getCallersListExecuted()) {
				
				itemsExecuted[CountCallerExecuted] = caller.toString2();	
				System.out.println(caller.toString2());
				CountCallerExecuted++;
			}
			
			int Count=0; 
			for (Method2Representation caller : methodtrace.getCallersList()) {

				boolean equalbool = false;
				if (itemsExecuted.length == 0) {
					items5[Count] = caller.toString2();
				
						
					
					Count++; 
					OnlyinParsedCallers++; 

				} else {
					for (String item : itemsExecuted) {
					String	callerString = caller.toString2().replaceAll("\\(.*\\)", "");

						if (item.equals(callerString) == true) {
						
							equalbool = true;
						}
					}
					if (equalbool == false) {
						
							
						
						Count++; 
						OnlyinParsedCallers++; 
					}
				}

			}

			String[] items1And2 = new String[items1.length + items2.length];
			items1And2 = (String[]) ArrayUtils.addAll(items1, items2);
			Method2Representation[] CallerMethods = new Method2Representation[items1.length + items2.length];
			CallerMethods = (Method2Representation[]) ArrayUtils.addAll(callersarr, callersex);
			//=======> LIST OF CALLERS AFTER MERGING CALLERS + CALLERSEXECUTED 
			List<Method2Representation> CallerMethodsList = Arrays.asList(CallerMethods);

			
			int BothInParsedAndExecutedCallees=0; 
			int OnlyInParsedCallees=0; 
			int OnlyInExecutedCallees=0; 
			// data[j][OwnerClassE]=items1;
			int CountCallees = 0;
			items3 = new String[methodtrace.getCalleesList().size()];
			calleesarr = new Method2Representation[methodtrace.getCalleesList().size()];
			for (Method2Representation caller : methodtrace.getCalleesList()) {
				items3[CountCallees] = caller.toString2();
				calleesarr[CountCallees] = caller;
				System.out.println(caller.toString2());
				CountCallees++;
			
			}

			int CountCalleesExecuted = 0;
			items4 = new String[methodtrace.getCalleesListExecuted().size()];
			calleesex = new Method2Representation[methodtrace.getCalleesListExecuted().size()];
			for (Method2Representation caller : methodtrace.getCalleesListExecuted()) {
				boolean equalbool = false;
				if (items3.length == 0) {
					items4[CountCalleesExecuted] = caller.toString2();
					calleesex[CountCalleesExecuted] = caller;
					CountCalleesExecuted++;
					OnlyInExecutedCallees++; 
					
				} else {
					for (String item : items3) {
						item = item.replaceAll("\\(.*\\).*", "");
						item = item.replaceAll(":", ",");
						String mycaller=caller.toString(); 
						 mycaller=mycaller.substring(0, mycaller.indexOf("[")); 
						if (item.equals(mycaller) == true) {
							equalbool = true;
							BothInParsedAndExecutedCallees++; 
						}
					}
					if (equalbool == false) {
						items4[CountCalleesExecuted] = caller.toString();
						calleesex[CountCalleesExecuted] = caller;
						OnlyInExecutedCallees++; 

						CountCalleesExecuted++;
				
					}
				}

			}

			int CountCalleeExecuted=0; 
			String[] itemsExecutedCallees = new String[methodtrace.getCalleesListExecuted().size()];
			for (Method2Representation callee : methodtrace.getCalleesListExecuted()) {
				
				itemsExecutedCallees[CountCalleeExecuted] = callee.toString2();	
				System.out.println(callee.toString2());
				CountCalleeExecuted++;
			}
			
			 Count=0; 
			for (Method2Representation callee : methodtrace.getCalleesList()) {

				boolean equalbool = false;
				if (itemsExecutedCallees.length == 0) {
					items6[Count] = callee.toString2();
				
						
					
					Count++; 
					OnlyInParsedCallees++; 

				} else {
					for (String item : itemsExecutedCallees) {
					String	calleeString = callee.toString2().replaceAll("\\(.*\\)", "");

						if (item.equals(calleeString) == true) {
						
							equalbool = true;
						}
					}
					if (equalbool == false) {
						
							
						
						Count++; 
						OnlyInParsedCallees++; 
					}
				}

			}

			String[] items3And4 = new String[items3.length + items4.length];
			items3And4 = (String[]) ArrayUtils.addAll(items3, items4);
			Method2Representation[] CalleeMethods = new Method2Representation[items3.length + items4.length];
			CalleeMethods = (Method2Representation[]) ArrayUtils.addAll(calleesarr, calleesex);
			//=======> LIST OF CALLEES AFTER MERGING CALLEES + CALLEESEXECUTED 
			List<Method2Representation> CalleeMethodsList = Arrays.asList(CalleeMethods);

//			data[j][CallerMethodsNumber] = CountCallersExecuted + CountCallers;
//			data[j][CalleeMethodsNumber] = CountCalleesExecuted + CountCallees;

			
//			data[j][CallerMethodsNumber] = CallerMethodsList.size();
//			data[j][CalleeMethodsNumber] = CalleeMethodsList.size();
			
			
			CallerMethodListFinal = new ArrayList<Method2Representation>();
			CalleeMethodListFinal = new ArrayList<Method2Representation>();

			for (Method2Representation methcaller : CallerMethodsList) {
				if (methcaller != null) {
					CallerMethodListFinal.add(methcaller);
				}
			}

			for (Method2Representation methcaller : CalleeMethodsList) {
				if (methcaller != null) {
					CalleeMethodListFinal.add(methcaller);
				}
			}
			int lengthitems1And2 = items1And2.length;
			Set<String> setitems1And2 = new HashSet<String>();

			for(int i = 0; i < lengthitems1And2; i++){
				setitems1And2.add(items1And2[i]);
			}
			
			int lengthitems3And4 = items3And4.length;
			Set<String> setitems3And4 = new HashSet<String>();

			for(int i = 0; i < lengthitems3And4; i++){
				
					setitems3And4.add(items3And4[i]);
				
				
			}
			String AppendedCallers=""; 
			for(String CallerMethod: setitems1And2) {
				if(CallerMethod!=null) {
					AppendedCallers=AppendedCallers+CallerMethod+"-"; 
				}
				
			}
			
			String AppendedCallees=""; 
			for(String CalleeMethod: setitems3And4) {
				if(CalleeMethod!=null) {
					AppendedCallees=AppendedCallees+CalleeMethod+"-"; 
				}
				
			}
			AppendedCallers=AppendedCallers.replaceAll(",", "/"); 
			AppendedCallees=AppendedCallees.replaceAll(",", "/"); 
			int CounterTraceClassCallerT = 0;
			int CounterTraceClassCallerN = 0;
			int CounterTraceClassCallerE = 0;
			List<ClassTrace2> mycallerclasses = new ArrayList<ClassTrace2>();
			if(CallerMethodListFinal.isEmpty()==false && CallerMethodListFinal!=null ) {
				for (Method2Representation callermeth : CallerMethodListFinal) {
					ClassRepresentation2 classrep = callermeth.getClassrep();
				//	ClassTrace2 mycallerclass = myclasstrace.FindTrace(classtraces2, classrep.classid, methodtrace.Requirement.getID());
					ClassTrace2 mycallerclass = myclasstrace.FindTrace2(methodtracesRequirementClass, classrep.classid,	methodtrace.Requirement.getID());
					mycallerclasses.add(mycallerclass);
				}
			}
	

			ArrayList<ClassTrace2> myclasstracesCallers = new ArrayList<ClassTrace2>();// unique
			for (ClassTrace2 classtrace : mycallerclasses) {
				if (!myclasstracesCallers.contains(classtrace) && classtrace!=null) {

					myclasstracesCallers.add(classtrace);
				}
				else {
					System.out.println("YESS");
				}
			}

			int mysize = myclasstracesCallers.size();

			data[j][CallerClassesNumber] = myclasstracesCallers.size();
//NO DUPLICATE CLASSES 
			if(myclasstracesCallers!=null && myclasstracesCallers.isEmpty()==false) {
				for (ClassTrace2 mycallerclass : myclasstracesCallers) {
					String trace2= mycallerclass.gettrace(); 
					trace2=trace2.trim(); 
					if (trace2.equals("T")) {
						CounterTraceClassCallerT++;
					} else if (trace2.equals("N")) {
						CounterTraceClassCallerN++;
					} else if (trace2.equals("E")) {
						CounterTraceClassCallerE++;
					}
				}

				data[j][CallerClassesT] = CounterTraceClassCallerT;
				data[j][CallerClassesN] = CounterTraceClassCallerN;
				data[j][CallerClassesE] = CounterTraceClassCallerE;
			}
			
//DUPLICATE CLASSES
			int CountMethodT = 0; 
			int CountMethodN = 0; 
			int CountMethodE = 0; 
			if(mycallerclasses!=null && mycallerclasses.isEmpty()==false) {
			for (ClassTrace2 mycallerclass : mycallerclasses) {
				if(mycallerclass!=null) {
					String trace2= mycallerclass.gettrace(); 
					trace2=trace2.trim(); 
					if (trace2.equals("T")) {
						CountMethodT++;
					} else if (trace2.equals("N")) {
						CountMethodN++;
					} else if (trace2.equals("E")) {
						CountMethodE++;
					}
				}
			
			}
			}
		

			int CounterTraceClassCalleeT = 0;
			int CounterTraceClassCalleeN = 0;
			int CounterTraceClassCalleeE = 0;
			List<ClassTrace2> mycalleeclasses = new ArrayList<ClassTrace2>();

			for (Method2Representation calleemeth : CalleeMethodListFinal) {
				ClassRepresentation2 classrep = calleemeth.getClassrep();
				//ClassTrace2 mycalleeclass = myclasstrace.FindTrace(classtraces2, classrep.classid,
				//		methodtrace.Requirement.getID());
				ClassTrace2 mycalleeclass = myclasstrace.FindTrace2(methodtracesRequirementClass, classrep.classid,methodtrace.Requirement.getID());
				mycalleeclasses.add(mycalleeclass);
			}

			ArrayList<ClassTrace2> myclasstracesCallees = new ArrayList<ClassTrace2>();// unique
			for (ClassTrace2 classtrace : mycalleeclasses) {
				if (!myclasstracesCallees.contains(classtrace) && classtrace!=null) {

					myclasstracesCallees.add(classtrace);
				}
			}
			//NO DUPLICATE CLASSES 

			data[j][CalleeClassesNumber] = myclasstracesCallees.size();
			if(myclasstracesCallees!=null && myclasstracesCallees.isEmpty()==false) {
				for (ClassTrace2 mycalleeclass : myclasstracesCallees) {
					String mytrace=mycalleeclass.gettrace(); 
					mytrace=mytrace.trim(); 
					if (mytrace.equals("T")) {
						CounterTraceClassCalleeT++;
					} else if (mytrace.equals("N")) {
						CounterTraceClassCalleeN++;
					} else if (mytrace.equals("E")) {
						CounterTraceClassCalleeE++;
					}
				}

				data[j][CalleeClassesT] = CounterTraceClassCalleeT;
				data[j][CalleeClassesN] = CounterTraceClassCalleeN;
				data[j][CalleeClassesE] = CounterTraceClassCalleeE;
			}
			
			//DUPLICATE CLASSES
			int CountMethodTCallee = 0; 
			int CountMethodNCallee = 0; 
			int CountMethodECallee = 0; 
			if(mycalleeclasses!=null && mycalleeclasses.isEmpty()==false) {
				for (ClassTrace2 mycalleeclass : mycalleeclasses) {
					if(mycalleeclass!=null) {
						String mytrace=mycalleeclass.gettrace(); 
						mytrace=mytrace.trim(); 
						if (mytrace.equals("T")) {
							CountMethodTCallee++;
						} else if (mytrace.equals("N")) {
							CountMethodNCallee++;
						} else if (mytrace.equals("E")) {
							CountMethodECallee++;
						}
					}
					
				}
				
				data[j][CalleeMethodsT] = CountMethodTCallee;
				data[j][CalleeMethodsN] = CountMethodNCallee;
				data[j][CalleeMethodsE] = CountMethodECallee;
			}
			
			
			data[j][CallerMethodsNumber] = mycallerclasses.size();
			data[j][CalleeMethodsNumber] = mycalleeclasses.size();
			
			
			data[j][CallerMethodsT] = CountMethodT;
			data[j][CallerMethodsN] = CountMethodN;
			data[j][CallerMethodsE] = CountMethodE;
			
			 System.out.println("OwnerClassNVarString: "+data[j][OwnerClassN].toString());
			 System.out.println("OwnerClassTVarString: "+data[j][OwnerClassT].toString());		 
			 System.out.println("OwnerClassEVarString: "+data[j][OwnerClassE].toString());
			 System.out.println("MethodID: "+data[j][MethodID] );
			 System.out.println("MethodName: "+data[j][MethodName] );	
			 System.out.println("RequirementID: "+data[j][RequirementID] );	
			 System.out.println("RequirementName: "+data[j][RequirementName] );	
			 System.out.println("ClassID: "+data[j][ClassID] );	
			 System.out.println("ClassName: "+data[j][ClassName] );	
		//OWNER CLASS PREDICTION 
		 Object OwnerClassNVar = data[j][OwnerClassN]; 
		 String OwnerClassNVarString = data[j][OwnerClassN].toString(); 
		 String OwnerClassTVarString = data[j][OwnerClassT].toString(); 
		 String OwnerClassEVarString = data[j][OwnerClassE].toString(); 
		
		
	
			if(OwnerClassNVar.toString().equals("1")) {
				data[j][OwnerClassPrediction]="N"; 
				String Result=OwnerClassPredictionClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][OwnerClassPrediction].toString()); 
				OwnerClassPredictionClass.UpdateCounters(Result, OwnerClassPredictionClass);
			}
			//else {
				
			if((counterParameterT!=0 || counterParameterN!=0|| counterParameterE!=0)
					/*	||
						(CounterTraceClassCallerN!=0 && CounterTraceClassCallerE!=0)
						||(CounterTraceClassCallerT!=0 && CounterTraceClassCallerE!=0)*/
						) {
					
					if(counterParameterT==counterParameterN && counterParameterT>0) {
						data[j][MajorityParameters] = "T";
					}
					else if(counterParameterT==0 && counterParameterN==0 && counterParameterE>0) {
						data[j][MajorityParameters] = "E";
					}
					else if(counterParameterT==0 && counterParameterN>0 && counterParameterE>0) {
						data[j][MajorityParameters] = "N";
					}
					else if (((counterParameterT >= counterParameterN
						//	&& counterParameterN >= counterParameterE
							)
							//|| (counterParameterT >= counterParameterE
								//	&& counterParameterE >= counterParameterN
							//		)
							)
							) {
						data[j][MajorityParameters] = "T";
					}/* else if (((counterParameterE >= counterParameterN
							&& counterParameterN >= counterParameterT)
							|| (counterParameterE >= counterParameterT
									&& counterParameterT >= counterParameterN))
						) {
						data[j][MajorityParameters] = "E";
					} */else if ((counterParameterN >= counterParameterT)) {
						data[j][MajorityParameters] = "N";
					}
					
					String Result=MajorityParametersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][MajorityParameters].toString()); 
					MajorityParametersClass.UpdateCounters(Result, MajorityParametersClass);
				
				}
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			//AT LEAST 1N PREDICTION PARAMETER
			
			
			
			
			
			if (counterParameterN >=1 )
					 {
				data[j][AtLeast1NParameter] = "N";
				String Result=AtLeast1NParameterClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1NParameter].toString()); 
				AtLeast1NParameterClass.UpdateCounters(Result, AtLeast1NParameterClass);
			} 
		
			
		
		/**************************************************************************************************************/
		/**************************************************************************************************************/
		/**************************************************************************************************************/
		
		//AT LEAST 1T PREDICTION PARAMETER
		
		
			
			
			
			if (counterParameterT >=1 )
					 {
				data[j][AtLeast1TParameter] = "T";
				String Result=AtLeast1TParameterClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1TParameter].toString()); 
				AtLeast1TParameterClass.UpdateCounters(Result, AtLeast1TParameterClass);
			} 
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			//AT LEAST 2N PREDICTION PARAMETER
			
			
			
			
			
			if (counterParameterN >=2 )
					 {
				data[j][AtLeast2NParameter] = "N";
				String Result=AtLeast2NParameterClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast2NParameter].toString()); 
				AtLeast2NParameterClass.UpdateCounters(Result, AtLeast2NParameterClass);
			} 
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//AT LEAST 2T PREDICTION PARAMETER
			
			
				
				
				
				if (counterParameterT >=2 )
						 {
					data[j][AtLeast2TParameter] = "T";
					String Result=AtLeast2TParameterClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast2TParameter].toString()); 
					AtLeast2TParameterClass.UpdateCounters(Result, AtLeast2TParameterClass);
				} 
			/**************************************************************************************************************/
			/**************************************************************************************************************/
		    /**************************************************************************************************************/	
			
			
			
			//ALL T PARAMETER PREDICTION
			
			
			if(counterParameterE==0 && counterParameterN==0 && counterParameterT>=1) {
				
				
				
			
					data[j][AllTParameters] = "T";
					String Result=AllTParameterClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllTParameters].toString()); 
					AllTParameterClass.UpdateCounters(Result, AllTParameterClass);
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL N PARAMETER PREDICTION
			
			
			if(counterParameterT==0 && counterParameterE==0 && counterParameterN>=1) {
				
				
				
			
					data[j][AllNParameters] = "N";
					String Result=AllNParameterClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllNParameters].toString()); 
					AllNParameterClass.UpdateCounters(Result, AllNParameterClass);
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			//MAJORITY CLASS LEVEL CALLEES PREDICTION 

			//FIRST IF makes sure there is a mixture 
			if((CounterTraceClassCallerT!=0 || CounterTraceClassCallerN!=0 || CounterTraceClassCallerE!=0)
				/*	||
					(CounterTraceClassCallerN!=0 && CounterTraceClassCallerE!=0)
					||(CounterTraceClassCallerT!=0 && CounterTraceClassCallerE!=0)*/
					) {
				
				if(CounterTraceClassCallerT==CounterTraceClassCallerN && CounterTraceClassCallerT>0) {
					data[j][MajorityClassLevelCallees] = "T";
				}
				else if(CounterTraceClassCallerT==0 && CounterTraceClassCallerN==0 && CounterTraceClassCallerE>0) {
					data[j][MajorityClassLevelCallees] = "E";
				}
				else if(CounterTraceClassCallerT==0 && CounterTraceClassCallerN>0 && CounterTraceClassCallerE>0) {
					data[j][MajorityClassLevelCallees] = "N";
				}
				else if ((CounterTraceClassCallerT >= CounterTraceClassCallerN
						)
						) {
					data[j][MajorityClassLevelCallees] = "T";
				} /*else if (((CounterTraceClassCallerE >= CounterTraceClassCallerN
						&& CounterTraceClassCallerN >= CounterTraceClassCallerT)
						|| (CounterTraceClassCallerE >= CounterTraceClassCallerT
								&& CounterTraceClassCallerT >= CounterTraceClassCallerN))
					) {
					data[j][MajorityClassLevelCallees] = "E";
				}*/ else if (CounterTraceClassCallerN >= CounterTraceClassCallerT) {
					data[j][MajorityClassLevelCallees] = "N";
				}
				String Result=MajorityClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][MajorityClassLevelCallees].toString()); 
				MajorityClassLevelCalleesClass.UpdateCounters(Result, MajorityClassLevelCalleesClass);
			}
		
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//MAJORITY CLASS LEVEL CALLERS PREDICTION 

			//FIRST IF makes sure there is a mixture 
			if((CounterTraceClassCalleeT!=0 || CounterTraceClassCalleeN!=0 ||CounterTraceClassCalleeE!=0)
					/*||
					(CounterTraceClassCalleeN!=0 && CounterTraceClassCalleeE!=0)
					||(CounterTraceClassCalleeT!=0 && CounterTraceClassCalleeE!=0)*/) {
				
				if(CounterTraceClassCalleeT==CounterTraceClassCalleeN && CounterTraceClassCalleeT>0) {
					data[j][MajorityClassLevelCallers] = "T";
				}
				else if(CounterTraceClassCalleeT==0 && CounterTraceClassCalleeN==0 && CounterTraceClassCalleeE>0) {
					data[j][MajorityClassLevelCallers] = "E";
				}
				else if(CounterTraceClassCalleeT==0 && CounterTraceClassCalleeN>0 && CounterTraceClassCalleeE>0) {
					data[j][MajorityClassLevelCallers] = "N";
				}
				else if(CounterTraceClassCalleeT==0 && CounterTraceClassCalleeN>0 && CounterTraceClassCalleeE>0) {
					data[j][MajorityClassLevelCallers] = "E";
				}
				else if (CounterTraceClassCalleeT >= CounterTraceClassCalleeN) {
					data[j][MajorityClassLevelCallers] = "T";
				} else if (CounterTraceClassCalleeN>=CounterTraceClassCalleeT)
					 {
					data[j][MajorityClassLevelCallers] = "N";
				} 
				String Result=MajorityClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][MajorityClassLevelCallers].toString()); 
				MajorityClassLevelCallersClass.UpdateCounters(Result, MajorityClassLevelCallersClass);
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			//MAJORITY METHOD LEVEL CALLEES PREDICTION 

			
			//FIRST IF makes sure there is a mixture 
			if((CountMethodT!=0 || CountMethodN!=0|| CountMethodE!=0 )/*||
					(CountMethodN!=0 && CountMethodE!=0)
					||(CountMethodT!=0 && CountMethodE!=0)*/) {
				
				if(CountMethodT==CountMethodN && CountMethodT>0) {
					data[j][MajorityMethodLevelCallees] = "T";
				}
				else if(CountMethodT==0 && CountMethodN==0 && CountMethodE>0) {
					data[j][MajorityMethodLevelCallees] = "E";
				}
				else if(CountMethodT==0 && CountMethodN>0 && CountMethodE>0) {
					data[j][MajorityMethodLevelCallees] = "N";
				}
				
				else if (CountMethodT >= CountMethodN){
					data[j][MajorityMethodLevelCallees] = "T";
				}  else if (CountMethodN >= CountMethodT
						
						) {
					data[j][MajorityMethodLevelCallees] = "N";
				}
				String Result=MajorityMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][MajorityMethodLevelCallees].toString()); 
				MajorityMethodLevelCalleesClass.UpdateCounters(Result, MajorityMethodLevelCalleesClass);
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//MAJORITY METHOD LEVEL CALLERS PREDICTION 
			
			//FIRST IF makes sure there is a mixture 
			if((CountMethodTCallee!=0 || CountMethodNCallee!=0 || CountMethodECallee!=0)/*||
					(CountMethodNCallee!=0 && CountMethodECallee!=0)
					||(CountMethodTCallee!=0 && CountMethodECallee!=0)*/) {
				if(CountMethodTCallee==CountMethodNCallee && CountMethodTCallee>0) {
					data[j][MajorityMethodLevelCallers] = "T";
				}
				else if(CountMethodTCallee==0 && CountMethodNCallee==0 && CountMethodECallee>0) {
					data[j][MajorityMethodLevelCallers] = "E";
				}
				else if(CountMethodTCallee==0 && CountMethodNCallee>0 && CountMethodECallee>0) {
					data[j][MajorityMethodLevelCallers] = "N";
				} 
				
				else if(CountMethodTCallee>=CountMethodNCallee)
				 {
					data[j][MajorityMethodLevelCallers] = "T";
				}  else if (CountMethodNCallee >= CountMethodTCallee
					
						) {
					data[j][MajorityMethodLevelCallers] = "N";
				}
				String Result=MajorityMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][MajorityMethodLevelCallers].toString()); 
				MajorityMethodLevelCallersClass.UpdateCounters(Result, MajorityMethodLevelCallersClass);
			}
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//AT LEAST 1N PREDICTION CLASS LEVEL CALLERS 
			
			
				
				
				
				if (CounterTraceClassCalleeN >=1 )
						 {
					data[j][AtLeast1NPredictionClassLevelCallers] = "N";
					Object var= 	data[j][AtLeast1NPredictionClassLevelCallers]; 
					String NEWVAR=var.toString(); 
					String Result=AtLeastNPredictionClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1NPredictionClassLevelCallers].toString()); 
					AtLeastNPredictionClassLevelCallersClass.UpdateCounters(Result, AtLeastNPredictionClassLevelCallersClass);
				} 
			
				
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//AT LEAST 1T PREDICTION CLASS LEVEL CALLERS 
			
			
				
				
				
				if (CounterTraceClassCalleeT >=1 )
						 {
					data[j][AtLeast1TPredictionClassLevelCallers] = "T";
					String Result=AtLeastTPredictionClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1TPredictionClassLevelCallers].toString()); 
					AtLeastTPredictionClassLevelCallersClass.UpdateCounters(Result, AtLeastTPredictionClassLevelCallersClass);
				} 
				
					
				
			
			
	
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//AT LEAST 1N PREDICTION CLASS LEVEL CALLEES 
		
			
				
				
				
				if (CounterTraceClassCallerN >=1 )
						 {
					data[j][AtLeast1NPredictionClassLevelCallees] = "N";
					String Result=AtLeastNPredictionClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1NPredictionClassLevelCallees].toString()); 
					AtLeastNPredictionClassLevelCalleesClass.UpdateCounters(Result, AtLeastNPredictionClassLevelCalleesClass);
				} 
				
			
			
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
		
			//AT LEAST 1T PREDICTION CLASS LEVEL CALLEES 
			
			
				
				
				
				if (CounterTraceClassCallerT >=1 )
						 {
					data[j][AtLeast1TPredictionClassLevelCallees] = "T";
					String Result=AtLeastTPredictionClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1TPredictionClassLevelCallees].toString()); 
					AtLeastTPredictionClassLevelCalleesClass.UpdateCounters(Result, AtLeastTPredictionClassLevelCalleesClass);
				} 
				
				
			
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			//AT LEAST 1N PREDICTION METHOD LEVEL CALLERS 
			
			
				
				
				if (CountMethodN >=1 )
						 {
					data[j][AtLeast1NPredictionMethodLevelCallees] = "N";
					String Result=AtLeastNPredictionMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1NPredictionMethodLevelCallees].toString()); 
					AtLeastNPredictionMethodLevelCalleesClass.UpdateCounters(Result, AtLeastNPredictionMethodLevelCalleesClass);
				} 
				
				
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			//AT LEAST 1T PREDICTION METHOD LEVEL CALLERS 
		
			
				
				
				
				if (CountMethodT >=1 )
						 {
					data[j][AtLeast1TPredictionMethodLevelCallees] = "T";
					String Result=AtLeastTPredictionMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1TPredictionMethodLevelCallees].toString()); 
					AtLeastTPredictionMethodLevelCalleesClass.UpdateCounters(Result, AtLeastTPredictionMethodLevelCalleesClass);
				} 
				
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//AT LEAST 1N PREDICTION CLASS LEVEL CALLEES 
			
			
				
				
				
				if (CountMethodNCallee >=1 )
						 {
					data[j][AtLeast1NPredictionMethodLevelCallers] = "N";
					String Result=AtLeastNPredictionMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1NPredictionMethodLevelCallers].toString()); 
					AtLeastNPredictionMethodLevelCallersClass.UpdateCounters(Result, AtLeastNPredictionMethodLevelCallersClass);
				} 
				
			
	
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//AT LEAST 1T PREDICTION CLASS LEVEL CALLEES 
			
			
				
				
				
				if (CountMethodTCallee >=1 )
						 {
					data[j][AtLeast1TPredictionMethodLevelCallers] = "T";
					String Result=AtLeastTPredictionMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1TPredictionMethodLevelCallers].toString()); 
					AtLeastTPredictionMethodLevelCallersClass.UpdateCounters(Result, AtLeastTPredictionMethodLevelCallersClass);
					}
				 
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 2N PREDICTION CLASS LEVEL CALLERS 
				
				
					
					
					
					if (CounterTraceClassCalleeN >=2 )
							 {
						data[j][AtLeast2NPredictionClassLevelCallers] = "N";
						Object var= 	data[j][AtLeast2NPredictionClassLevelCallers]; 
						String NEWVAR=var.toString(); 
						String Result=AtLeast2NPredictionClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast2NPredictionClassLevelCallers].toString()); 
						AtLeast2NPredictionClassLevelCallersClass.UpdateCounters(Result, AtLeast2NPredictionClassLevelCallersClass);
					} 
				
					
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
				
				
					
					
					
					if (CounterTraceClassCalleeT >=2 )
					 {
				data[j][AtLeast2TPredictionClassLevelCallers] = "T";
				String Result=AtLeast2TPredictionClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast2TPredictionClassLevelCallers].toString()); 
				AtLeast2TPredictionClassLevelCallersClass.UpdateCounters(Result, AtLeast2TPredictionClassLevelCallersClass);
			} 
						
					
				
				
		
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 2N PREDICTION CLASS LEVEL CALLEES 
			
				
					
					
					
					
					if (CounterTraceClassCallerN >=2 )
							 {
						data[j][AtLeast2NPredictionClassLevelCallees] = "N";
						String Result=AtLeast2NPredictionClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast2NPredictionClassLevelCallees].toString()); 
						AtLeast2NPredictionClassLevelCalleesClass.UpdateCounters(Result, AtLeast2NPredictionClassLevelCalleesClass);
					} 
					
					
				
				
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
			
				//AT LEAST 2T PREDICTION CLASS LEVEL CALLEES 
				
				
					
					
					
					if (CounterTraceClassCallerT >=2 )
					 {
				data[j][AtLeast2TPredictionClassLevelCallees] = "T";
				String Result=AtLeast2TPredictionClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast2TPredictionClassLevelCallees].toString()); 
				AtLeast2TPredictionClassLevelCalleesClass.UpdateCounters(Result, AtLeast2TPredictionClassLevelCalleesClass);
			} 
					
					
				
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				//AT LEAST 2N PREDICTION METHOD LEVEL CALLERS 
				
				
					
					
					if (CountMethodN >=2 )
					 {
				data[j][AtLeast2NPredictionMethodLevelCallees] = "N";
				String Result=AtLeast2NPredictionMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast2NPredictionMethodLevelCallees].toString()); 
				AtLeast2NPredictionMethodLevelCalleesClass.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCalleesClass);
			} 
					
					
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				//AT LEAST 2T PREDICTION METHOD LEVEL CALLERS 
			
				
					
					
					
					if (CountMethodT >=2 )
					 {
				data[j][AtLeast2TPredictionMethodLevelCallees] = "T";
				String Result=AtLeast2TPredictionMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast2TPredictionMethodLevelCallees].toString()); 
				AtLeast2TPredictionMethodLevelCalleesClass.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCalleesClass);
			} 
					
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 2N PREDICTION CLASS LEVEL CALLEES 
				
				
					
					
					
					if (CountMethodNCallee >=2 )
					 {
				data[j][AtLeast2NPredictionMethodLevelCallers] = "N";
				String Result=AtLeast2NPredictionMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast2NPredictionMethodLevelCallers].toString()); 
				AtLeast2NPredictionMethodLevelCallersClass.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCallersClass);
			} 
			
				
		
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 2T PREDICTION CLASS LEVEL CALLEES 
				
				
					
					
					
					if (CountMethodTCallee >=2 )
					 {
				data[j][AtLeast2TPredictionMethodLevelCallers] = "T";
				String Result=AtLeast2TPredictionMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast2TPredictionMethodLevelCallers].toString()); 
				AtLeast2TPredictionMethodLevelCallersClass.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClass);
				}
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL T METHOD LEVEL CALLEES 
			
			
			if(CountMethodN==0 && CountMethodE==0 && CountMethodT>=1) {
				
				
				
					
					data[j][AllTMethodLevelCallees] = "T";
					String Result=AllTMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllTMethodLevelCallees].toString()); 
					AllTMethodLevelCalleesClass.UpdateCounters(Result, AllTMethodLevelCalleesClass);
			}
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL T METHOD LEVEL CALLERS 
			
			if(CountMethodNCallee==0 && CountMethodECallee==0  && CountMethodTCallee>=1) {
				
				
				
			
					data[j][AllTMethodLevelCallers] = "T";
					
					String Result=AllTMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllTMethodLevelCallers].toString()); 
					AllTMethodLevelCallersClass.UpdateCounters(Result, AllTMethodLevelCallersClass);
				
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL T CLASS LEVEL CALLERS 
			
			
			if(CounterTraceClassCalleeE==0 && CounterTraceClassCalleeN==0 && CounterTraceClassCalleeT>=1) {
				
				
				
			
					data[j][AllTClassLevelCallers] = "T";
					String Result=AllTClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllTClassLevelCallers].toString()); 
					AllTClassLevelCallersClass.UpdateCounters(Result, AllTClassLevelCallersClass);
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL T CLASS LEVEL CALLEES 
			
			
			if(CounterTraceClassCallerE==0 && CounterTraceClassCallerN==0 && CounterTraceClassCallerT>=1) {
				
				
				
			
					data[j][AllTClassLevelCallees] = "T";
					String Result=AllTClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllTClassLevelCallees].toString()); 
					AllTClassLevelCalleesClass.UpdateCounters(Result, AllTClassLevelCalleesClass);
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL N CLASS LEVEL CALLERS 
			
			
			if(CounterTraceClassCalleeT==0 && CounterTraceClassCalleeE==0 && CounterTraceClassCalleeN>=1) {
				
				
				
			
					data[j][AllNClassLevelCallers] = "N";
					String Result=AllNClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllNClassLevelCallers].toString()); 
					AllNClassLevelCallersClass.UpdateCounters(Result, AllNClassLevelCallersClass);
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL N CLASS LEVEL CALLEES 
			
			
			if(CounterTraceClassCallerT==0 && CounterTraceClassCallerE==0 && CounterTraceClassCallerN>=1) {
				
				
				
			
					data[j][AllNClassLevelCallees] = "N";
					String Result=AllNClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllNClassLevelCallees].toString()); 
					AllNClassLevelCalleesClass.UpdateCounters(Result, AllNClassLevelCalleesClass);
				
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL N METHOD LEVEL CALLERS 
			
			
			if(CountMethodTCallee==0 && CountMethodECallee==0 && CountMethodNCallee>=1) {
				
				
				
			
					data[j][AllNMethodLevelCallers] = "N";
					String Result=AllNMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllNMethodLevelCallers].toString()); 
					AllNMethodLevelCallersClass.UpdateCounters(Result, AllNMethodLevelCallersClass);
			}
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL N METHOD LEVEL CALLEES 
			
			
			if(CountMethodT==0 && CountMethodE==0 && CountMethodN>=1) {
				
				
				
			
					data[j][AllNMethodLevelCallees] = "N";
					String Result=AllNMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllNMethodLevelCallees].toString()); 
					AllNMethodLevelCalleesClass.UpdateCounters(Result, AllNMethodLevelCalleesClass);
			}
			//}
			
		//NEEDS TO BE UNCOMMENTED 
		//WAS COMMENTED TO SPEED THE PROGRAM'S EXECUTION 
			
			
//			JComboBox comboBox1 = new JComboBox(items1And2);
//			DefaultCellEditor dce1 = new DefaultCellEditor(comboBox1);
//			editors1.add(dce1);
//
//			/*
//			 * JComboBox comboBox2 = new JComboBox( items2 ); DefaultCellEditor dce2 = new
//			 * DefaultCellEditor( comboBox2 ); editors2.add( dce2 );
//			 */
//
//			JComboBox comboBox4 = new JComboBox(items3And4);
//			DefaultCellEditor dce3 = new DefaultCellEditor(comboBox4);
//			editors3.add(dce3);
//
//			/*
//			 * JComboBox comboBox4 = new JComboBox( items4); DefaultCellEditor dce4 = new
//			 * DefaultCellEditor( comboBox4 ); editors4.add( dce4 );
//			 */
//
//			comboBox1.setEditor(new MyEditor());
//			comboBox1.setEditable(true);
//
//			/*
//			 * comboBox2.setEditor(new MyEditor()); comboBox2.setEditable(true);
//			 */
//
//			comboBox4.setEditor(new MyEditor());
//			comboBox4.setEditable(true);

			 
			/*
			 ActionListener cbActionListener = new ActionListener() {//add actionlistner to listen for change
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            		
		                 String s = (String) comboBox1.getSelectedItem();//get the selected item
		                 if(s!=null) {
		                	   System.out.println(s);
				              
				               
		                	  String methid = s.substring(0, s.indexOf(",")); 
				              int row=table.getSelectedRow();
				              TableModel model = table.getModel();

				              // Object methodid = model.getValueAt(row, 0); 
				               Object requirementID = model.getValueAt(row, 2); 
				               
				              Method2Details meth = methodlist.get((Integer.parseInt(methid.toString()))-1); 
				              
				            ClassTrace2 classtrace = myclasstrace.FindTrace(classtraces2, meth.getOwnerClass().classid,
										requirementID.toString());
				            String goldval=classtrace.gettrace();  
				            System.out.println("goldval: "+goldval);
				            System.out.println("CELL method id : "+methid.toString());
				            System.out.println("CELL  Requirement ID: "+requirementID.toString());
				            //data[j][CalleePrediction]=goldval; 
				           model.setValueAt(goldval, row, 27);
		                 }
		                
		            }

					
		         
		        };
		       
		        comboBox1.addActionListener(cbActionListener);
		        
		        
		        
		   	 ActionListener cbActionListener2 = new ActionListener() {//add actionlistner to listen for change
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            		
		                 String s = (String) comboBox4.getSelectedItem();//get the selected item
		                 if(s!=null) {
		                	   System.out.println(s);
				              
				               
		                	  String methid = s.substring(0, s.indexOf(",")); 
				              int row=table.getSelectedRow();
				              TableModel model = table.getModel();

				              // Object methodid = model.getValueAt(row, 0); 
				               Object requirementID = model.getValueAt(row, 2); 
				               
				               
				              Method2Details meth = methodlist.get((Integer.parseInt(methid.toString()))-1); 
				              
				            ClassTrace2 classtrace = myclasstrace.FindTrace(classtraces2, meth.getOwnerClass().classid,
										requirementID.toString());
				            String goldval=classtrace.gettrace();  
				            System.out.println("goldval: "+goldval);
				            System.out.println("CELL method id : "+methid.toString());
				            System.out.println("CELL  Requirement ID: "+requirementID.toString());
				            //data[j][CalleePrediction]=goldval; 
				           model.setValueAt(goldval, row, 28);
		                 }
		                
		            }

					
		         
		        };
		       
		        comboBox4.addActionListener(cbActionListener2);
		*/

			List<Method2Representation> callers = methodtrace.getCallersList();
			List<Method2Representation> callersmerged = new ArrayList<Method2Representation>();
			List<Method2Representation> callersExecuted = methodtrace.getCallersListExecuted();

			for (Method2Representation methrep : callers) {
				String methodname = methrep.getMethodname();
				if (methodname.contains("(")) {
					methodname = methodname.replaceAll("\\(.*\\)", "");
					methrep.setMethodname(methodname);
				}

			}
			for (Method2Representation caller : callers) {
				callersmerged.add(caller);
			}
			for (Method2Representation caller : callersExecuted) {
				callersmerged.add(caller);
			}

			
			List<Method2Representation> callees = methodtrace.getCalleesList();
			List<Method2Representation> calleesExecuted = methodtrace.getCalleesListExecuted();
			for (Method2Representation methrep : callees) {
				String methodname = methrep.getMethodname();
				if (methodname.contains("(")) {
					methodname = methodname.replaceAll("\\(.*\\)", "");
					methrep.setMethodname(methodname);
				}
			}

	

			bw.write(data[j][Row] + ","+data[j][MethodID] + "," + data[j][MethodName] + "," + data[j][RequirementID] + "," + data[j][RequirementName] + "," + data[j][ClassID] + ","
					+ data[j][ClassName] + "," + data[j][Gold] + "," + data[j][Subject] + "," + data[j][OwnerClassT] + "," + data[j][OwnerClassN] + ","
					+ data[j][OwnerClassE] + "," + data[j][CallerMethodsNumber]+ "," + AppendedCallers + "," + data[j][CallerMethodsT] + "," +
					data[j][CallerMethodsN] + "," + data[j][CallerMethodsE] + ","
					+ data[j][CallerClassesNumber] + "," + data[j][CallerClassesT] + "," + data[j][CallerClassesN] + "," + data[j][CallerClassesE] + 
					"," + data[j][CalleeMethodsNumber]+ "," + AppendedCallees +  ","
					+ data[j][CalleeMethodsT] + "," + data[j][CalleeMethodsN] + "," + data[j][CalleeMethodsE] + "," + data[j][CalleeClassesNumber] + 
					"," + data[j][CalleeClassesT] + ","
					+ data[j][CalleeClassesN] + "," + data[j][CalleeClassesE] + "," + data[j][OwnerClassPrediction] + "," + data[j][MajorityClassLevelCallers]+ "," +
					data[j][MajorityClassLevelCallees]+","+data[j][MajorityMethodLevelCallers]+","+data[j][MajorityMethodLevelCallees]
							+ "," + 
					data[j][AtLeast1NPredictionClassLevelCallers]+ "," + data[j][AtLeast1NPredictionClassLevelCallees] 
					+ "," + data[j][AtLeast1NPredictionMethodLevelCallers]+ "," + data[j][AtLeast1NPredictionMethodLevelCallees]
					+ "," +data[j][AtLeast1TPredictionClassLevelCallers]+ "," + data[j][AtLeast1TPredictionClassLevelCallees]
					+ "," + data[j][AtLeast1TPredictionMethodLevelCallers]
					+ "," + data[j][AtLeast1TPredictionMethodLevelCallees]
							+ "," + 
							data[j][AtLeast2NPredictionClassLevelCallers]+ "," + data[j][AtLeast2NPredictionClassLevelCallees] 
							+ "," + data[j][AtLeast2NPredictionMethodLevelCallers]+ "," + data[j][AtLeast2NPredictionMethodLevelCallees]
							+ "," +data[j][AtLeast2TPredictionClassLevelCallers]+ "," + data[j][AtLeast2TPredictionClassLevelCallees]
							+ "," + data[j][AtLeast2TPredictionMethodLevelCallers]
							+ "," + data[j][AtLeast2TPredictionMethodLevelCallees]	
							+ "," + data[j][AllNClassLevelCallers]
					+ "," +data[j][AllNClassLevelCallees]+ "," + data[j][AllNMethodLevelCallers]+ "," + data[j][AllNMethodLevelCallees]+ "," +
					data[j][AllTClassLevelCallers]+ ","+		data[j][AllTClassLevelCallees]+ ","+		data[j][AllTMethodLevelCallers]+ 
					","+		data[j][AllTMethodLevelCallees]+","+
					OnlyinParsedCallers	+","+ OnlyinExecutedCallers+","+BothParsedAndExecutedCallers+","+OnlyInParsedCallees+","+OnlyInExecutedCallees
					+","+BothInParsedAndExecutedCallees+","+data[j][paramatersNumber]+","+ParametersAppended+","+data [j][CountParamaterT]+","+data [j][CountParamaterN]+","+data [j][CountParamaterE]+","+data[j][MajorityParameters]+","+data[j][AtLeast1NParameter]
							+","+data[j][AtLeast1TParameter]+","+data[j][AtLeast2TParameter]+","+data[j][AtLeast2NParameter]+","+data[j][AllNParameters]+","+data[j][AllTParameters]+","+data[j][AllTParameters]+","+methodtrace.SubjectT
							+","+methodtrace.SubjectN);
				
				
			bw.newLine();

			j++;
			
		}

		bw.close();
		/*
		 * String[] items2 = { "Circle", "Square", "Triangle" }; JComboBox comboBox2 =
		 * new JComboBox( items2 ); DefaultCellEditor dce2 = new DefaultCellEditor(
		 * comboBox2 ); editors.add( dce2 );
		 * 
		 * String[] items3 = { "Apple", "Orange", "Banana" }; JComboBox comboBox3 = new
		 * JComboBox( items3 ); DefaultCellEditor dce3 = new DefaultCellEditor(
		 * comboBox3 ); editors.add( dce3 );
		 */

		// Create the table with default data

		/*
		 * Object[][] data = { {"Color", "Red"}, {"Shape", "Square"}, {"Fruit",
		 * "Banana"}, {"Plain", "Text"} };
		 */
		System.out.println("OWNER CLASS PREDICTION: "+OwnerClassPredictionClass.toString()); 
		System.out.println("MAJORITY CLASS LEVEL CALLERS PREDICTION: "+MajorityClassLevelCallersClass.toString()); 
		System.out.println("MAJORITY CLASS LEVEL CALLEES PREDICTION: "+MajorityClassLevelCalleesClass.toString()); 
		System.out.println("MAJORITY METHOD LEVEL CALLERS PREDICTION: "+MajorityMethodLevelCallersClass.toString()); 
		System.out.println("MAJORITY METHOD LEVEL CALLEES PREDICTION: "+MajorityMethodLevelCalleesClass.toString()); 
		System.out.println("AT LEAST 1 N PREDICTION CLASS LEVEL CALLERS: "+AtLeastNPredictionClassLevelCallersClass.toString()); 
		System.out.println("AT LEAST 1 N PREDICTION CLASS LEVEL CALLEES: "+AtLeastNPredictionClassLevelCalleesClass.toString()); 
		System.out.println("AT LEAST 1 N PREDICTION METHOD LEVEL CALLERS: "+AtLeastNPredictionMethodLevelCallersClass.toString()); 
		System.out.println("AT LEAST 1 N PREDICTION METHOD LEVEL CALLEES: "+AtLeastNPredictionMethodLevelCalleesClass.toString()); 
		System.out.println("AT LEAST 1 T PREDICTION CLASS LEVEL CALLERS: "+AtLeastTPredictionClassLevelCallersClass.toString()); 
		System.out.println("AT LEAST 1 T PREDICTION CLASS LEVEL CALLEES: "+AtLeastTPredictionClassLevelCalleesClass.toString()); 
		System.out.println("AT LEAST 1 T PREDICTION METHOD LEVEL CALLERS: "+AtLeastTPredictionMethodLevelCallersClass.toString()); 
		System.out.println("AT LEAST 1 T PREDICTION METHOD LEVEL CALLEES: "+AtLeastTPredictionMethodLevelCalleesClass.toString()); 
		System.out.println("AT LEAST 2 N PREDICTION CLASS LEVEL CALLERS: "+AtLeast2NPredictionClassLevelCallersClass.toString()); 
		System.out.println("AT LEAST 2 N PREDICTION CLASS LEVEL CALLEES: "+AtLeast2NPredictionClassLevelCalleesClass.toString()); 
		System.out.println("AT LEAST 2 N PREDICTION METHOD LEVEL CALLERS: "+AtLeast2NPredictionMethodLevelCallersClass.toString()); 
		System.out.println("AT LEAST 2 N PREDICTION METHOD LEVEL CALLEES: "+AtLeast2NPredictionMethodLevelCalleesClass.toString()); 
		System.out.println("AT LEAST 2 T PREDICTION CLASS LEVEL CALLERS: "+AtLeast2TPredictionClassLevelCallersClass.toString()); 
		System.out.println("AT LEAST 2 T PREDICTION CLASS LEVEL CALLEES: "+AtLeast2TPredictionClassLevelCalleesClass.toString()); 
		System.out.println("AT LEAST 2 T PREDICTION METHOD LEVEL CALLERS: "+AtLeast2TPredictionMethodLevelCallersClass.toString()); 
		System.out.println("AT LEAST 2 T PREDICTION METHOD LEVEL CALLEES: "+AtLeast2TPredictionMethodLevelCalleesClass.toString()); 
		System.out.println("ALL N CLASS LEVEL CALLERS: "+AllNClassLevelCallersClass.toString()); 
		System.out.println("ALL N CLASS LEVEL CALLEES: "+AllNClassLevelCalleesClass.toString()); 
		System.out.println("ALL N METHOD LEVEL CALLERS: "+AllNMethodLevelCallersClass.toString()); 
		System.out.println("ALL N METHOD LEVEL CALLEES: "+AllNMethodLevelCalleesClass.toString()); 
		System.out.println("ALL T CLASS LEVEL CALLERS: "+AllTClassLevelCallersClass.toString()); 
		System.out.println("ALL T CLASS LEVEL CALLEES: "+AllTClassLevelCalleesClass.toString()); 
		System.out.println("ALL T METHOD LEVEL CALLERS: "+AllTMethodLevelCallersClass.toString()); 
		System.out.println("ALL T METHOD LEVEL CALLEES: "+AllTMethodLevelCalleesClass.toString()); 
		System.out.println("MAJORITY PARAMETERS CLASS: "+MajorityParametersClass.toString()); 
		System.out.println("AT LEAST 1N PARAMETER CLASS: "+AtLeast1NParameterClass.toString()); 
		System.out.println("AT LEAST 1T PARAMETER CLASS: "+AtLeast1TParameterClass.toString()); 
		System.out.println("AT LEAST 2T PARAMETER CLASS: "+AtLeast2TParameterClass.toString()); 
		System.out.println("AT LEAST 2N PARAMETER CLASS: "+AtLeast2NParameterClass.toString()); 
		System.out.println("ALL N PARAMETERS: "+AllNParameterClass.toString()); 
		System.out.println("ALL T PARAMETERS: "+AllTParameterClass.toString()); 
		
		bw2.write("OWNER CLASS PREDICTION: "+OwnerClassPredictionClass.toString()); 
		bw2.newLine();
		bw2.write("MAJORITY CLASS LEVEL CALLERS PREDICTION: "+MajorityClassLevelCallersClass.toString()); 
		bw2.newLine();
		bw2.write("MAJORITY CLASS LEVEL CALLEES PREDICTION: "+MajorityClassLevelCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("MAJORITY METHOD LEVEL CALLERS PREDICTION: "+MajorityMethodLevelCallersClass.toString()); 
		bw2.newLine();
		bw2.write("MAJORITY METHOD LEVEL CALLEES PREDICTION: "+MajorityMethodLevelCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 1 N PREDICTION CLASS LEVEL CALLERS: "+AtLeastNPredictionClassLevelCallersClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 1 N PREDICTION CLASS LEVEL CALLEES: "+AtLeastNPredictionClassLevelCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 1 N PREDICTION METHOD LEVEL CALLERS: "+AtLeastNPredictionMethodLevelCallersClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 1 N PREDICTION METHOD LEVEL CALLEES: "+AtLeastNPredictionMethodLevelCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 1 T PREDICTION CLASS LEVEL CALLERS: "+AtLeastTPredictionClassLevelCallersClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 1 T PREDICTION CLASS LEVEL CALLEES: "+AtLeastTPredictionClassLevelCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 1 T PREDICTION METHOD LEVEL CALLERS: "+AtLeastTPredictionMethodLevelCallersClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 1 T PREDICTION METHOD LEVEL CALLEES: "+AtLeastTPredictionMethodLevelCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 2 N PREDICTION CLASS LEVEL CALLERS: "+AtLeast2NPredictionClassLevelCallersClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 2 N PREDICTION CLASS LEVEL CALLEES: "+AtLeast2NPredictionClassLevelCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 2 N PREDICTION METHOD LEVEL CALLERS: "+AtLeast2NPredictionMethodLevelCallersClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 2 N PREDICTION METHOD LEVEL CALLEES: "+AtLeast2NPredictionMethodLevelCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 2 T PREDICTION CLASS LEVEL CALLERS: "+AtLeast2TPredictionClassLevelCallersClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 2 T PREDICTION CLASS LEVEL CALLEES: "+AtLeast2TPredictionClassLevelCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 2 T PREDICTION METHOD LEVEL CALLERS: "+AtLeast2TPredictionMethodLevelCallersClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 2 T PREDICTION METHOD LEVEL CALLEES: "+AtLeast2TPredictionMethodLevelCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("ALL N CLASS LEVEL CALLERS: "+AllNClassLevelCallersClass.toString()); 
		bw2.newLine();
		bw2.write("ALL N CLASS LEVEL CALLEES: "+AllNClassLevelCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("ALL N METHOD LEVEL CALLERS: "+AllNMethodLevelCallersClass.toString()); 
		bw2.newLine();
		bw2.write("ALL N METHOD LEVEL CALLEES: "+AllNMethodLevelCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("ALL T CLASS LEVEL CALLERS: "+AllTClassLevelCallersClass.toString()); 
		bw2.newLine();
		bw2.write("ALL T CLASS LEVEL CALLEES: "+AllTClassLevelCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("ALL T METHOD LEVEL CALLERS: "+AllTMethodLevelCallersClass.toString()); 
		bw2.newLine();
		bw2.write("MAJORITY PARAMETERS CLASS: "+MajorityParametersClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 1N PARAMETER CLASS: "+AtLeast1NParameterClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 1T PARAMETER CLASS: "+AtLeast1TParameterClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 2T PARAMETER CLASS: "+AtLeast2TParameterClass.toString()); 
		bw2.newLine();
		bw2.write("AT LEAST 2N PARAMETER CLASS: "+AtLeast2NParameterClass.toString()); 
		bw2.newLine();
		bw2.write("ALL N PARAMETERS: "+AllNParameterClass.toString()); 
		bw2.newLine();
		bw2.write("ALL T PARAMETERS: "+AllTParameterClass.toString()); 
		bw2.newLine();
		bw2.close();
		String[] columnNames = { "Row","MethodID", "MethodName", "RequirementID", "RequirementName", "ClassID", "ClassName",
				"Gold", "Subject", "OwnerClass T", "Owner Class N", "Owner Class E", "# caller methods",
				"# caller methods T", "#caller methods N", "#caller methods E", "# caller classes",
				"# caller classes T", "#caller classes N", "#caller classes E", "# callee methods",
				"# callee methods T", "#callee methods N", "#callee methods E", "# callee classes",
				"# callee classes T", "#callee classes N", "#callee classes E",  "OwnerClassPrediction",
				"MajorityClassLevelCallers","MajorityClassLevelCallees", "MajorityMethodLevelCallers","MajorityMethodLevelCallees",
				">1NPredictionClassLevelCallers", ">1NPredictionClassLevelCallees", ">1NPredictionMethodLevelCallers", 
				">1NPredictionMethodLevelCallees", ">1TPredictionClassLevelCallers", ">1TPredictionClassLevelCallees", 
				">1TPredictionMethodLevelCallers", ">1TPredictionMethodLevelCallees", 
				">2NPredictionClassLevelCallers", ">2NPredictionClassLevelCallees", ">2NPredictionMethodLevelCallers", 
				">2NPredictionMethodLevelCallees", ">2TPredictionClassLevelCallers", ">2TPredictionClassLevelCallees", 
				">2TPredictionMethodLevelCallers", ">2TPredictionMethodLevelCallees", 
				"AllNClassLevelCallers", "AllNClassLevelCallees","AllNMethodLevelCallers","AllNMethodLevelCallees",
				"AllTClassLevelCallers", "AllTClassLevelCallees", "AllTMethodLevelCallers", "AllTMethodLevelCallees"
				,"Callers", "Callees", "#parameters", "Parameters","# Parameter T" ,"# Parameter N" ,"# Parameter E" ,
				"MajorityParameterPrediction", "AtLeast1NParameterPrediction", 
				"AtLeast1TParameterPrediction", "AtLeast2TParameterPrediction", 
				"AtLeast2NParameterPrediction", "AllNParameterPrediction", "AllTParameterPrediction"
				};
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table = new JTable(model) {
			// Determine editor to be used by row
			public TableCellEditor getCellEditor(int row, int column) {
				int modelColumn = convertColumnIndexToModel(column);
				//
				if (modelColumn == 48 )
					return editors1.get(row);
				if (modelColumn == 49 )
					return editors3.get(row);
				
				
				
				/*
				 * if (modelColumn == 31 && row < methodtraces2.size()) return
				 * editors3.get(row); if (modelColumn == 32 && row < methodtraces2.size())
				 * return editors4.get(row);
				 */

				else
					return super.getCellEditor(row, column);
			}

			
			  public  final Color VERY_LIGHT_RED = new Color(255,153,153);
			  public  final Color EXTRA_LIGHT_RED = new Color(220,156,156);
			  public  final Color YELLOW = new Color(236,236,153);
			  public  final Color GREEN = new Color(204,255,204);
			  public  final Color BLUE = new Color(189,216,232);	
			  public  final Color LIGHTBLUE = new Color(204,255,229);	
			  public  final Color PURPLE = new Color(204,204,255);	
			  public  final Color VERY_LIGHT_PINK = new Color(255,204,204);	
			  public  final Color VERY_LIGHT_YELLOW = new Color(225,229,170);
			  public  final Color LIGHT_GREEN = new Color(217,246,201);
			  public  final Color BEIGE = new Color(223,201,140);
			  public  final Color YELLOW_GREEN = new Color(215,222,157);
			  public  final Color LIGHT_GRAY = new Color(192,192,192);
			  public  final Color LIGHT_PURPLE = new Color(226,207,252);
			  public  final Color EXTRA_LIGHT_PINK = new Color(250,214,252);
			@Override
			   public Component prepareRenderer(TableCellRenderer renderer,
			         int row, int column) {
			      Component label = (Component) super.prepareRenderer(renderer, row, column);
			   
			int rownum=table.getSelectedRow(); 
			if(rownum==row) {
			    	  label.setBackground(Color.ORANGE);
			    	  
			}
			else { 
				if(column==RequirementID || column==RequirementName) {
					label.setBackground(GREEN);
				}
				else if (column==Gold || column==Subject) {
					 label.setBackground(EXTRA_LIGHT_RED);
			    	  
			      } 
				else if (column==ClassID || column==ClassName) {
					 label.setBackground(EXTRA_LIGHT_PINK);
			    	  
			      } 
				else if (column==OwnerClassT || column==OwnerClassN || column==OwnerClassE) {
					 label.setBackground(YELLOW_GREEN);
			    	  
			      } 
			      else if (column==CallerMethodsNumber || column==CallerMethodsT ||column==CallerMethodsN || column==CallerMethodsE) {
			    	  label.setBackground(BEIGE);
				      } 
			      else if(column==CallerClassesNumber || column==CallerClassesT || column==CallerClassesN || column==CallerClassesE) {
			    	   label.setBackground(LIGHT_PURPLE);
				      } 
			      else if (column==CalleeMethodsNumber || column==CalleeMethodsT || column==CalleeMethodsN ||column==CalleeMethodsE) {
			    	   label.setBackground(BLUE);
				      } 
			      else if (column==CalleeClassesNumber || column==CalleeClassesT || column==CalleeClassesN ||column==CalleeClassesE) {
			    	   label.setBackground(LIGHT_GREEN);
				      } 
			  
				
			      else if(column==OwnerClassPrediction){
			    	  label.setBackground(VERY_LIGHT_RED);
			      }
			      else if(column==MajorityClassLevelCallers || column==MajorityClassLevelCallees|| column==MajorityMethodLevelCallers || column==MajorityMethodLevelCallees){
			    	  label.setBackground(YELLOW);
			      }
			      
			      else if(column==AtLeast1NPredictionClassLevelCallees || column==AtLeast1NPredictionClassLevelCallers || column==AtLeast1NPredictionMethodLevelCallers || column==AtLeast1NPredictionMethodLevelCallees){
			    	  label.setBackground(LIGHTBLUE);
			      }
			      
			      else if(column==AtLeast1TPredictionClassLevelCallers || column==AtLeast1TPredictionClassLevelCallees || column==AtLeast1TPredictionMethodLevelCallers || column==AtLeast1TPredictionMethodLevelCallees){
			    	  label.setBackground(PURPLE);
			      }
			      
			      else if(column==AllNClassLevelCallers || column==AllNClassLevelCallees || column==AllNMethodLevelCallers || column==AllNMethodLevelCallees){
			    	  label.setBackground(VERY_LIGHT_YELLOW);
			      }
			      
			      else if(column==AllTClassLevelCallers || column==AllTClassLevelCallees || column==AllTMethodLevelCallers || column==AllTMethodLevelCallees){
			    	  label.setBackground(VERY_LIGHT_PINK);
			      }
			    
			      else if (column==Callers || column==Callees ) {
			    	   label.setBackground(Color.pink);
				      }
			      else {
			    	  //This corresponds to the first 2 columns MethodID and MethodName 
			    	  label.setBackground(LIGHT_GRAY);
			      }
				}
			
			    	 
			     
			      table.setRowSelectionAllowed(true);
			      return label;
			   }
		};
		
		//Sets the width of each column to the size of the column header 
		TableColumnModel columnModel = table.getColumnModel();
        for (int col = 0; col < table.getColumnCount(); col++) {
            int maxWidth = 0;
           
            TableColumn column = columnModel.getColumn(col);
            TableCellRenderer headerRenderer = column.getHeaderRenderer();
            if (headerRenderer == null) {
                headerRenderer = table.getTableHeader().getDefaultRenderer();
            }
            Object headerValue = column.getHeaderValue();
            Component headerComp = headerRenderer.getTableCellRendererComponent(table, headerValue, false, false, 0, col);
            maxWidth =  headerComp.getPreferredSize().width;
            // note some extra padding
            column.setPreferredWidth(maxWidth + 6);//IntercellSpacing * 2 + 2 * 2 pixel instead of taking this value from Borders
        }
        DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
        stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
    //    table.setPreferredScrollableViewportSize(table.getPreferredSize());
    
		 
		   
		/*
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(8).setPreferredWidth(150);
		table.getColumnModel().getColumn(9).setPreferredWidth(150);
		table.getColumnModel().getColumn(14).setPreferredWidth(150);
		table.getColumnModel().getColumn(15).setPreferredWidth(150);
		table.getColumnModel().getColumn(16).setPreferredWidth(150);
		table.getColumnModel().getColumn(17).setPreferredWidth(150);
		table.getColumnModel().getColumn(10).setPreferredWidth(200);
		table.getColumnModel().getColumn(11).setPreferredWidth(200);
		table.getColumnModel().getColumn(12).setPreferredWidth(200);
		table.getColumnModel().getColumn(13).setPreferredWidth(200);
		table.getColumnModel().getColumn(18).setPreferredWidth(150);
		table.getColumnModel().getColumn(19).setPreferredWidth(150);
		table.getColumnModel().getColumn(20).setPreferredWidth(150);
		table.getColumnModel().getColumn(21).setPreferredWidth(150);
		table.getColumnModel().getColumn(22).setPreferredWidth(150);
		table.getColumnModel().getColumn(23).setPreferredWidth(150);
		table.getColumnModel().getColumn(24).setPreferredWidth(150);
		table.getColumnModel().getColumn(25).setPreferredWidth(150);
		table.getColumnModel().getColumn(26).setPreferredWidth(150);
		table.getColumnModel().getColumn(27).setPreferredWidth(150);
		table.getColumnModel().getColumn(28).setPreferredWidth(150);
		table.getColumnModel().getColumn(29).setPreferredWidth(150);
		table.getColumnModel().getColumn(30).setPreferredWidth(200);
		table.getColumnModel().getColumn(31).setPreferredWidth(200);
		table.getColumnModel().getColumn(32).setPreferredWidth(200);
		table.getColumnModel().getColumn(33).setPreferredWidth(200);
		table.getColumnModel().getColumn(34).setPreferredWidth(200);
		table.getColumnModel().getColumn(35).setPreferredWidth(200);
		table.getColumnModel().getColumn(36).setPreferredWidth(200);
		table.getColumnModel().getColumn(37).setPreferredWidth(200);
		table.getColumnModel().getColumn(38).setPreferredWidth(200);
		table.getColumnModel().getColumn(39).setPreferredWidth(200);
		table.getColumnModel().getColumn(40).setPreferredWidth(150);
		table.getColumnModel().getColumn(41).setPreferredWidth(150);
		table.getColumnModel().getColumn(42).setPreferredWidth(150);
		table.getColumnModel().getColumn(43).setPreferredWidth(150);
		table.getColumnModel().getColumn(44).setPreferredWidth(150);
		table.getColumnModel().getColumn(45).setPreferredWidth(150);
		table.getColumnModel().getColumn(46).setPreferredWidth(150);
		table.getColumnModel().getColumn(47).setPreferredWidth(150);*/
		//table.getColumnModel().getColumn(48).setPreferredWidth(150);
		//table.getColumnModel().getColumn(49).setPreferredWidth(150);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		table.setRowSelectionAllowed(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);
		JScrollPane horizontalscroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		getContentPane().add(horizontalscroll);
		// table.getColumnModel().getColumn(1).setCellRenderer(new ComboBoxRenderer() );
		table.setRowHeight(50);

		
		
		/*
		 * getContentPane().add(comboBox); getContentPane().add(field); }
		 */

	}



	static class MyEditor extends BasicComboBoxEditor {
		JScrollPane scroller = new JScrollPane();
		// NOTE: editor is a JTextField defined in BasicComboBoxEditor

		public MyEditor() {
			super();
			scroller.setViewportView(editor);
			scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		}

		/** Return a JScrollPane containing the JTextField instead of the JTextField **/
		@Override
		public Component getEditorComponent() {
			return scroller;
		}

		/** Override to create your own JTextField. **/
		@Override
		protected JTextField createEditorComponent() {
			JTextField editor = new JTextField();
			editor.setBorder(null);
			/* editor.setEditable(false); //If you want it not to be editable */
			return editor;
		}
	}

	class ComboBoxRenderer extends JComboBox implements TableCellRenderer {

		public ComboBoxRenderer() {
			setBorder(new EmptyBorder(0, 0, 0, 0));
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// setFocusable(false);
			removeAllItems();
			addItem(value);
			return this;
		}
	}

	public static void main(String[] args) throws SQLException, IOException {

		TracesTableJHotDraw frame = new TracesTableJHotDraw();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}



