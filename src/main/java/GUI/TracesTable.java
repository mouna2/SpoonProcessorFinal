package GUI;

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
import java.util.HashSet;
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

import mypackage.ClassRepresentation2;
import mypackage.ClassTrace2;
import mypackage.ColumnGroup;
import mypackage.DatabaseReading2;
import mypackage.GroupableTableHeader;
import mypackage.Method2Details;
import mypackage.Method2Representation;
import mypackage.MethodTrace2;
import mypackage.RequirementGold;

public class TracesTable extends JFrame {
	int MethodID=0; 
	int MethodName=1; 
	int RequirementID=2; 
	int RequirementName=3; 
	int ClassID=4; 
	int ClassName=5; 
	int Gold=6; 
	int Subject=7; 
	int OwnerClassT=8; 
	int OwnerClassN=9; 
	int OwnerClassE=10; 
	int CallerMethodsNumber=11; 
	int CallerMethodsT=12; 
	int CallerMethodsN=13; 
	int CallerMethodsE=14; 
	int CallerClassesNumber=15; 
	int CallerClassesT=16; 
	int CallerClassesN=17; 
	int CallerClassesE=18; 
	int CalleeMethodsNumber=19; 
	int CalleeMethodsT=20; 
	int CalleeMethodsN=21; 
	int CalleeMethodsE=22; 
	int CalleeClassesNumber=23; 
	int CalleeClassesT=24; 
	int CalleeClassesN=25; 
	int CalleeClassesE=26; 
	int OwnerClassPrediction=27; 
	int MajorityClassLevelCallers=28; 
	int MajorityClassLevelCallees=29; 
	int MajorityMethodLevelCallers=30; 
	int MajorityMethodLevelCallees=31; 
	int AtLeast1NPredictionClassLevelCallers=32; 
	int AtLeast1NPredictionClassLevelCallees=33; 
	int AtLeast1NPredictionMethodLevelCallers=34; 
	int AtLeast1NPredictionMethodLevelCallees=35; 
	int AtLeast1TPredictionClassLevelCallers=36; 
	int AtLeast1TPredictionClassLevelCallees=37; 
	int AtLeast1TPredictionMethodLevelCallers=38; 
	int AtLeast1TPredictionMethodLevelCallees=39; 
	int AllNClassLevelCallers=40; 
	int AllNClassLevelCallees=41; 
	int AllNMethodLevelCallers=42; 
	int AllNMethodLevelCallees=43; 
	int AllTClassLevelCallers=44; 
	int AllTClassLevelCallees=45; 
	int AllTMethodLevelCallers=46; 
	int AllTMethodLevelCallees=47; 
	int Callers=48; 
	int Callees=49; 
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
	PredictionEvaluation AllNClassLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCallersClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCalleesClass= new PredictionEvaluation(); 
	ClassTrace2 myclasstrace = new ClassTrace2();
	static List<MethodTrace2> methodtraces2 = new ArrayList<MethodTrace2>();
	static List<ClassTrace2> classtraces2 = new ArrayList<ClassTrace2>();
	JTable table = new JTable(); 
	static List<Method2Details> methodlist = new ArrayList<Method2Details>();
	File fout = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\out.txt");
	FileOutputStream fos = new FileOutputStream(fout);
	
	File fout2 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\PredictionEvaluation.txt");
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

	public TracesTable() throws SQLException, IOException {
	
		bw.write("MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold, Subject, OwnerClassT, OwnerClassN, "
						+ "OwnerClassE, #callermethods, #callermethodsT, #callermethodsN, #callermethodsE, #callerclasses, #callerclassesT, #callerclassesN, "
						+ "#callerclassesE, #calleemethods, #calleemethodsT, #calleemethodsN, #calleemethodsE, #calleeclasses, #calleeclassesT, #calleeclassesN, "
						+ "#calleeclassesE, OwnerClassPrediction, MajorityClassLevelCallers, MajorityClassLevelCallees, MajorityMethodLevelCallers, MajorityMethodLevelCallees,"
						+ "AtLeast1NPredictionClassLevelCallers, AtLeast1NPredictionClassLevelCallees, AtLeast1NPredictionMethodLevelCallers, AtLeast1NPredictionMethodLevelCallees, "
						+"AtLeast1TPredictionClassLevelCallers, AtLeast1TPredictionClassLevelCallees, AtLeast1TPredictionMethodLevelCallers, AtLeast1TPredictionMethodLevelCallees,"
						+"AllNClassLevelCallers, AllNClassLevelCallees, AllNMethodLevelCallers, AllNMethodLevelCallees,"
						+"AllTClassLevelCallers, AllTClassLevelCallees, AllTMethodLevelCallers, AllTMethodLevelCallees,"
						+ " OnlyInParsedCallers, OnlyInExecutedCallers, BothParsedAndExecutedCallers, "
						+ "OnlyInParsedCallees, OnlyInExecutedCallees, BothParsedAndExecutedCallees" );
		bw.newLine();
		DatabaseReading2 db = new DatabaseReading2();
		DatabaseReading2.MakePredictions();
		methodtraces2 = db.getMethodtraces2();
		classtraces2 = db.getClassestraces2();
		methodlist = db.getMethodlist();
		List<TableCellEditor> editors1 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> editors2 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> editors3 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> editors4 = new ArrayList<TableCellEditor>(methodtraces2.size());
		int j = 0;
		final int jfinal=0; 
		String[] items1 = new String[methodtraces2.size()];
		String[] items2 = new String[methodtraces2.size()];
		String[] items3 = new String[methodtraces2.size()];
		String[] items4 = new String[methodtraces2.size()];
		String[] items5 = new String[methodtraces2.size()];
		String[] items6 = new String[methodtraces2.size()];

		Method2Representation[] callersarr = new Method2Representation[methodtraces2.size()];
		Method2Representation[] callersex = new Method2Representation[methodtraces2.size()];
		Method2Representation[] calleesarr = new Method2Representation[methodtraces2.size()];
		Method2Representation[] calleesex = new Method2Representation[methodtraces2.size()];
		Object[][] data = new Object[methodtraces2.size()][10000];
		// Create the editors to be used for each row
		for (MethodTrace2 methodtrace : methodtraces2) {
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

			for (ClassTrace2 classtrace : classtraces2) {

				if (methodtrace.ClassRepresentation.classid.equals(classtrace.getMyclass().classid)
						&& methodtrace.Requirement.getID().equals(classtrace.getRequirement().getID())) {
					String trace = classtrace.gettrace();
					if (trace.equals("T")) {
						data[j][OwnerClassT] = "1";
						data[j][OwnerClassN] = "0";
						data[j][OwnerClassE] = "0";
					} else if (trace.equals("N")) {
						data[j][OwnerClassT] = "0";
						data[j][OwnerClassN] = "1";
						data[j][OwnerClassE] = "0";
					} else if (trace.equals("E")) {
						data[j][OwnerClassT] = "0";
						data[j][OwnerClassN] = "0";
						data[j][OwnerClassE] = "1";
					}
				}

			}

			int count = 0;
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
			

		
			int BothParsedAndExecutedCallers=0; 
			int OnlyinParsedCallers=0;
			int OnlyinExecutedCallers=0; 
			int CountCallers = 0;
			items1 = new String[methodtrace.getCallersList().size()];
			callersarr = new Method2Representation[methodtrace.getCallersList().size()];
			for (Method2Representation caller : methodtrace.getCallersList()) {
				items1[CountCallers] = caller.toString();
				callersarr[CountCallers] = caller;
				System.out.println(caller.toString());
				CountCallers++;
				
				
				
				
				

			}

			int CountCallersExecuted = 0;
			items2 = new String[methodtrace.getCallersListExecuted().size()];
			callersex = new Method2Representation[methodtrace.getCallersListExecuted().size()];
			for (Method2Representation caller : methodtrace.getCallersListExecuted()) {

				boolean equalbool = false;
				if (items1.length == 0) {
					items2[CountCallersExecuted] = caller.toString();
					callersex[CountCallersExecuted] = caller;
				
						
					
					CountCallersExecuted++;
					OnlyinExecutedCallers++; 

				} else {
					for (String item : items1) {
						item = item.replaceAll("\\(.*\\)", "");

						if (item.equals(caller.toString()) == true) {
							BothParsedAndExecutedCallers++; 
							equalbool = true;
						}
					}
					if (equalbool == false) {
						
							
						
						items2[CountCallersExecuted] = caller.toString();
						callersex[CountCallersExecuted] = caller;
						CountCallersExecuted++;
						OnlyinExecutedCallers++; 
					}
				}

			}
		
			
			
			
			
			
			
			int CountCallerExecuted=0; 
			String[] itemsExecuted = new String[methodtrace.getCallersListExecuted().size()];
			for (Method2Representation caller : methodtrace.getCallersListExecuted()) {
				
				itemsExecuted[CountCallerExecuted] = caller.toString();	
				System.out.println(caller.toString());
				CountCallerExecuted++;
			}
			
			int Count=0; 
			for (Method2Representation caller : methodtrace.getCallersList()) {

				boolean equalbool = false;
				if (itemsExecuted.length == 0) {
					items5[Count] = caller.toString();
				
						
					
					Count++; 
					OnlyinParsedCallers++; 

				} else {
					for (String item : itemsExecuted) {
					String	callerString = caller.toString().replaceAll("\\(.*\\)", "");

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
				items3[CountCallees] = caller.toString();
				calleesarr[CountCallees] = caller;
				System.out.println(caller.toString());
				CountCallees++;
			
			}

			int CountCalleesExecuted = 0;
			items4 = new String[methodtrace.getCalleesListExecuted().size()];
			calleesex = new Method2Representation[methodtrace.getCalleesListExecuted().size()];
			for (Method2Representation caller : methodtrace.getCalleesListExecuted()) {
				boolean equalbool = false;
				if (items3.length == 0) {
					items4[CountCalleesExecuted] = caller.toString();
					calleesex[CountCalleesExecuted] = caller;
					CountCalleesExecuted++;
					OnlyInExecutedCallees++; 
					
				} else {
					for (String item : items3) {
						item = item.replaceAll("\\(.*\\)", "");
						if (item.equals(caller.toString()) == true) {
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
				
				itemsExecutedCallees[CountCalleeExecuted] = callee.toString();	
				System.out.println(callee.toString());
				CountCalleeExecuted++;
			}
			
			 Count=0; 
			for (Method2Representation callee : methodtrace.getCalleesList()) {

				boolean equalbool = false;
				if (itemsExecutedCallees.length == 0) {
					items6[Count] = callee.toString();
				
						
					
					Count++; 
					OnlyInParsedCallees++; 

				} else {
					for (String item : itemsExecutedCallees) {
					String	calleeString = callee.toString().replaceAll("\\(.*\\)", "");

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

			data[j][CallerMethodsNumber] = CountCallersExecuted + CountCallers;
			data[j][CalleeMethodsNumber] = CountCalleesExecuted + CountCallees;

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

			int CounterTraceClassCallerT = 0;
			int CounterTraceClassCallerN = 0;
			int CounterTraceClassCallerE = 0;
			List<ClassTrace2> mycallerclasses = new ArrayList<ClassTrace2>();

			for (Method2Representation callermeth : CallerMethodListFinal) {
				ClassRepresentation2 classrep = callermeth.getClassrep();
				ClassTrace2 mycallerclass = myclasstrace.FindTrace(classtraces2, classrep.classid,
						methodtrace.Requirement.getID());
				mycallerclasses.add(mycallerclass);
			}

			ArrayList<ClassTrace2> myclasstracesCallers = new ArrayList<ClassTrace2>();// unique
			for (ClassTrace2 classtrace : mycallerclasses) {
				if (!myclasstracesCallers.contains(classtrace)) {

					myclasstracesCallers.add(classtrace);
				}
				else {
					System.out.println("YESS");
				}
			}

			int mysize = myclasstracesCallers.size();

			data[j][CallerClassesNumber] = myclasstracesCallers.size();
//NO DUPLICATE CLASSES 
			for (ClassTrace2 mycallerclass : myclasstracesCallers) {
				if (mycallerclass.gettrace().equals("T")) {
					CounterTraceClassCallerT++;
				} else if (mycallerclass.gettrace().equals("N")) {
					CounterTraceClassCallerN++;
				} else if (mycallerclass.gettrace().equals("E")) {
					CounterTraceClassCallerE++;
				}
			}

			data[j][CallerClassesT] = CounterTraceClassCallerT;
			data[j][CallerClassesN] = CounterTraceClassCallerN;
			data[j][CallerClassesE] = CounterTraceClassCallerE;
//DUPLICATE CLASSES
			int CountMethodT = 0; 
			int CountMethodN = 0; 
			int CountMethodE = 0; 
			for (ClassTrace2 mycallerclass : mycallerclasses) {
				if (mycallerclass.gettrace().equals("T")) {
					CountMethodT++;
				} else if (mycallerclass.gettrace().equals("N")) {
					CountMethodN++;
				} else if (mycallerclass.gettrace().equals("E")) {
					CountMethodE++;
				}
			}

		

			int CounterTraceClassCalleeT = 0;
			int CounterTraceClassCalleeN = 0;
			int CounterTraceClassCalleeE = 0;
			List<ClassTrace2> mycalleeclasses = new ArrayList<ClassTrace2>();

			for (Method2Representation calleemeth : CalleeMethodListFinal) {
				ClassRepresentation2 classrep = calleemeth.getClassrep();
				ClassTrace2 mycalleeclass = myclasstrace.FindTrace(classtraces2, classrep.classid,
						methodtrace.Requirement.getID());
				mycalleeclasses.add(mycalleeclass);
			}

			ArrayList<ClassTrace2> myclasstracesCallees = new ArrayList<ClassTrace2>();// unique
			for (ClassTrace2 classtrace : mycalleeclasses) {
				if (!myclasstracesCallees.contains(classtrace)) {

					myclasstracesCallees.add(classtrace);
				}
			}
			//NO DUPLICATE CLASSES 

			data[j][CalleeClassesNumber] = myclasstracesCallees.size();

			for (ClassTrace2 mycalleeclass : myclasstracesCallees) {
				if (mycalleeclass.gettrace().equals("T")) {
					CounterTraceClassCalleeT++;
				} else if (mycalleeclass.gettrace().equals("N")) {
					CounterTraceClassCalleeN++;
				} else if (mycalleeclass.gettrace().equals("E")) {
					CounterTraceClassCalleeE++;
				}
			}

			data[j][CalleeClassesT] = CounterTraceClassCalleeT;
			data[j][CalleeClassesN] = CounterTraceClassCalleeN;
			data[j][CalleeClassesE] = CounterTraceClassCalleeE;
			//DUPLICATE CLASSES
			int CountMethodTCallee = 0; 
			int CountMethodNCallee = 0; 
			int CountMethodECallee = 0; 
			for (ClassTrace2 mycalleeclass : mycalleeclasses) {
				if (mycalleeclass.gettrace().equals("T")) {
					CountMethodTCallee++;
				} else if (mycalleeclass.gettrace().equals("N")) {
					CountMethodNCallee++;
				} else if (mycalleeclass.gettrace().equals("E")) {
					CountMethodECallee++;
				}
			}
			
			data[j][CalleeMethodsT] = CountMethodTCallee;
			data[j][CalleeMethodsN] = CountMethodNCallee;
			data[j][CalleeMethodsE] = CountMethodECallee;
			
			
			data[j][CallerMethodsT] = CountMethodT;
			data[j][CallerMethodsN] = CountMethodN;
			data[j][CallerMethodsE] = CountMethodE;
			
			
		
		 Object OwnerClassNVar = data[j][OwnerClassN]; 
			
			if(OwnerClassNVar.toString().equals("1")) {
				data[j][OwnerClassPrediction]="N"; 
				String Result=OwnerClassPredictionClass.ComparePredictionToGold(methodtrace.getGold(), data[j][OwnerClassPrediction].toString()); 
				OwnerClassPredictionClass.UpdateCounters(Result, OwnerClassPredictionClass);
			}
			else {
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/

				//MAJORITY CLASS LEVEL CALLERS PREDICTION 

				//FIRST IF makes sure there is a mixture 
				if((CounterTraceClassCallerT!=0 && CounterTraceClassCallerN!=0)||
						(CounterTraceClassCallerN!=0 && CounterTraceClassCallerE!=0)
						||(CounterTraceClassCallerT!=0 && CounterTraceClassCallerE!=0)) {
					
					
					
					if (((CounterTraceClassCallerT >= CounterTraceClassCallerN
							&& CounterTraceClassCallerN >= CounterTraceClassCallerE)
							|| (CounterTraceClassCallerT >= CounterTraceClassCallerE
									&& CounterTraceClassCallerE >= CounterTraceClassCallerN))
							) {
						data[j][MajorityClassLevelCallees] = "T";
					} else if (((CounterTraceClassCallerE >= CounterTraceClassCallerN
							&& CounterTraceClassCallerN >= CounterTraceClassCallerT)
							|| (CounterTraceClassCallerE >= CounterTraceClassCallerT
									&& CounterTraceClassCallerT >= CounterTraceClassCallerN))
						) {
						data[j][MajorityClassLevelCallees] = "E";
					} else if (((CounterTraceClassCallerN >= CounterTraceClassCallerE
							&& CounterTraceClassCallerE >= CounterTraceClassCallerT)
							|| (CounterTraceClassCallerN >= CounterTraceClassCallerT
									&& CounterTraceClassCallerT >= CounterTraceClassCallerE))
							) {
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
				if((CounterTraceClassCalleeT!=0 && CounterTraceClassCalleeN!=0)||
						(CounterTraceClassCalleeN!=0 && CounterTraceClassCalleeE!=0)
						||(CounterTraceClassCalleeT!=0 && CounterTraceClassCalleeE!=0)) {
					
					
					
					if (((CounterTraceClassCalleeT >= CounterTraceClassCalleeN
							&& CounterTraceClassCalleeN >= CounterTraceClassCalleeE)
							|| (CounterTraceClassCalleeT >= CounterTraceClassCalleeE
									&& CounterTraceClassCalleeE >= CounterTraceClassCalleeN))
							) {
						data[j][MajorityClassLevelCallers] = "T";
					} else if (((CounterTraceClassCalleeE >= CounterTraceClassCalleeN
							&& CounterTraceClassCalleeN >= CounterTraceClassCalleeT)
							|| (CounterTraceClassCalleeE >= CounterTraceClassCalleeT
									&& CounterTraceClassCalleeT >= CounterTraceClassCalleeN))
						) {
						data[j][MajorityClassLevelCallers] = "E";
					} else if (((CounterTraceClassCalleeN >= CounterTraceClassCalleeE
							&& CounterTraceClassCalleeE >= CounterTraceClassCalleeT)
							|| (CounterTraceClassCalleeN >= CounterTraceClassCalleeT
									&& CounterTraceClassCalleeT >= CounterTraceClassCalleeE))
							) {
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
				if((CountMethodT!=0 && CountMethodN!=0)||
						(CountMethodN!=0 && CountMethodE!=0)
						||(CountMethodT!=0 && CountMethodE!=0)) {
					
					
					
					if (((CountMethodT >= CountMethodN
							&& CountMethodN >= CountMethodE)
							|| (CountMethodT >= CountMethodE
									&& CountMethodE >= CountMethodN))
							) {
						data[j][MajorityMethodLevelCallees] = "T";
					} else if (((CountMethodE >= CountMethodN
							&& CountMethodN >= CountMethodT)
							|| (CountMethodE >= CountMethodT
									&& CountMethodT >= CountMethodN))
						) {
						data[j][MajorityMethodLevelCallees] = "E";
					} else if (((CountMethodN >= CountMethodE
							&& CountMethodE >= CountMethodT)
							|| (CountMethodN >= CountMethodT
									&& CountMethodT >= CountMethodE))
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
				if((CountMethodTCallee!=0 && CountMethodNCallee!=0)||
						(CountMethodNCallee!=0 && CountMethodECallee!=0)
						||(CountMethodTCallee!=0 && CountMethodECallee!=0)) {
					
					
					
					if (((CountMethodTCallee >= CountMethodNCallee
							&& CountMethodNCallee >= CountMethodECallee)
							|| (CountMethodTCallee >= CountMethodECallee
									&& CountMethodECallee >= CountMethodNCallee))
							) {
						data[j][MajorityMethodLevelCallers] = "T";
					} else if (((CountMethodECallee >= CountMethodNCallee
							&& CountMethodNCallee >= CountMethodTCallee)
							|| (CountMethodECallee >= CountMethodTCallee
									&& CountMethodTCallee >= CountMethodNCallee))
						) {
						data[j][MajorityMethodLevelCallers] = "E";
					} else if (((CountMethodNCallee >= CountMethodECallee
							&& CountMethodECallee >= CountMethodTCallee)
							|| (CountMethodNCallee >= CountMethodTCallee
									&& CountMethodTCallee >= CountMethodECallee))
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
				
				//FIRST IF makes sure there is a mixture 
				if((CounterTraceClassCalleeT!=0 && CounterTraceClassCalleeN!=0)||
						(CounterTraceClassCalleeN!=0 && CounterTraceClassCalleeE!=0)
						||(CounterTraceClassCalleeT!=0 && CounterTraceClassCalleeE!=0)) {
					
					
					
					if (CounterTraceClassCalleeN >=1 )
							 {
						data[j][AtLeast1NPredictionClassLevelCallers] = "N";
						Object var= 	data[j][AtLeast1NPredictionClassLevelCallers]; 
						String NEWVAR=var.toString(); 
						String Result=AtLeastNPredictionClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1NPredictionClassLevelCallers].toString()); 
						AtLeastNPredictionClassLevelCallersClass.UpdateCounters(Result, AtLeastNPredictionClassLevelCallersClass);
					} 
				
					
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 1T PREDICTION CLASS LEVEL CALLERS 
				
				//FIRST IF makes sure there is a mixture 
				if((CounterTraceClassCalleeT!=0 && CounterTraceClassCalleeN!=0)||
						(CounterTraceClassCalleeN!=0 && CounterTraceClassCalleeE!=0)
						||(CounterTraceClassCalleeT!=0 && CounterTraceClassCalleeE!=0)) {
					
					
					
					if (CounterTraceClassCalleeT >=1 )
							 {
						data[j][AtLeast1TPredictionClassLevelCallers] = "T";
						String Result=AtLeastTPredictionClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1TPredictionClassLevelCallers].toString()); 
						AtLeastTPredictionClassLevelCallersClass.UpdateCounters(Result, AtLeastTPredictionClassLevelCallersClass);
					} 
					
						
					
				
				}
		
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 1N PREDICTION CLASS LEVEL CALLEES 
			
				//FIRST IF makes sure there is a mixture 
				if((CounterTraceClassCallerT!=0 && CounterTraceClassCallerN!=0)||
						(CounterTraceClassCallerN!=0 && CounterTraceClassCallerE!=0)
						||(CounterTraceClassCallerT!=0 && CounterTraceClassCallerE!=0)) {
					
					
					
					if (CounterTraceClassCallerN >=1 )
							 {
						data[j][AtLeast1NPredictionClassLevelCallees] = "N";
						String Result=AtLeastNPredictionClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1NPredictionClassLevelCallees].toString()); 
						AtLeastNPredictionClassLevelCalleesClass.UpdateCounters(Result, AtLeastNPredictionClassLevelCalleesClass);
					} 
					
				
				}
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
			
				//AT LEAST 1T PREDICTION CLASS LEVEL CALLEES 
				
				//FIRST IF makes sure there is a mixture 
				if((CounterTraceClassCallerT!=0 && CounterTraceClassCallerN!=0)||
						(CounterTraceClassCallerN!=0 && CounterTraceClassCallerE!=0)
						||(CounterTraceClassCallerT!=0 && CounterTraceClassCallerE!=0)) {
					
					
					
					if (CounterTraceClassCallerT >=1 )
							 {
						data[j][AtLeast1TPredictionClassLevelCallees] = "N";
						String Result=AtLeastTPredictionClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1TPredictionClassLevelCallees].toString()); 
						AtLeastTPredictionClassLevelCalleesClass.UpdateCounters(Result, AtLeastTPredictionClassLevelCalleesClass);
					} 
					
					
				}
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				//AT LEAST 1N PREDICTION METHOD LEVEL CALLERS 
				
				//FIRST IF makes sure there is a mixture 
				if((CountMethodT!=0 && CountMethodN!=0)||
						(CountMethodN!=0 && CountMethodE!=0)
						||(CountMethodT!=0 && CountMethodE!=0)) {
					
					
					
					if (CountMethodN >=1 )
							 {
						data[j][AtLeast1NPredictionMethodLevelCallees] = "N";
						String Result=AtLeastNPredictionMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1NPredictionMethodLevelCallees].toString()); 
						AtLeastNPredictionMethodLevelCalleesClass.UpdateCounters(Result, AtLeastNPredictionMethodLevelCalleesClass);
					} 
					
					
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				//AT LEAST 1T PREDICTION METHOD LEVEL CALLERS 
			
				//FIRST IF makes sure there is a mixture 
				if((CountMethodT!=0 && CountMethodN!=0)||
						(CountMethodN!=0 && CountMethodE!=0)
						||(CountMethodT!=0 && CountMethodE!=0)) {
					
					
					
					if (CountMethodT >=1 )
							 {
						data[j][AtLeast1TPredictionMethodLevelCallees] = "N";
						String Result=AtLeastTPredictionMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1TPredictionMethodLevelCallees].toString()); 
						AtLeastTPredictionMethodLevelCalleesClass.UpdateCounters(Result, AtLeastTPredictionMethodLevelCalleesClass);
					} 
					
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 1N PREDICTION CLASS LEVEL CALLEES 
				
				//FIRST IF makes sure there is a mixture 
				if((CountMethodTCallee!=0 && CountMethodNCallee!=0)||
						(CountMethodNCallee!=0 && CountMethodECallee!=0)
						||(CountMethodTCallee!=0 && CountMethodECallee!=0)) {
					
					
					
					if (CountMethodNCallee >=1 )
							 {
						data[j][AtLeast1NPredictionMethodLevelCallers] = "N";
						String Result=AtLeastNPredictionMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1NPredictionMethodLevelCallers].toString()); 
						AtLeastNPredictionMethodLevelCallersClass.UpdateCounters(Result, AtLeastNPredictionMethodLevelCallersClass);
					} 
					
				}
		
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 1T PREDICTION CLASS LEVEL CALLEES 
				
				//FIRST IF makes sure there is a mixture 
				if((CountMethodTCallee!=0 && CountMethodNCallee!=0)||
						(CountMethodNCallee!=0 && CountMethodECallee!=0)
						||(CountMethodTCallee!=0 && CountMethodECallee!=0)) {
					
					
					
					if (CountMethodTCallee >=1 )
							 {
						data[j][AtLeast1TPredictionMethodLevelCallers] = "N";
						String Result=AtLeastTPredictionMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AtLeast1TPredictionMethodLevelCallers].toString()); 
						AtLeastTPredictionMethodLevelCallersClass.UpdateCounters(Result, AtLeastTPredictionMethodLevelCallersClass);
						}
					} 
					
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL T METHOD LEVEL CALLEES 
				
				//FIRST IF makes sure there is a mixture 
				if(CountMethodN==0 && CountMethodE==0) {
					
					
					
						
						data[j][AllTMethodLevelCallees] = "T";
						String Result=AllTMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllTMethodLevelCallees].toString()); 
						AllTMethodLevelCalleesClass.UpdateCounters(Result, AllTMethodLevelCalleesClass);
				}
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL T METHOD LEVEL CALLERS 
				
				//FIRST IF makes sure there is a mixture 
				if(CountMethodNCallee==0 && CountMethodECallee==0) {
					
					
					
				
						data[j][AllTMethodLevelCallers] = "T";
						
						String Result=AllTMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllTMethodLevelCallers].toString()); 
						AllTMethodLevelCallersClass.UpdateCounters(Result, AllTMethodLevelCallersClass);
					
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL T CLASS LEVEL CALLERS 
				
				
				if(CounterTraceClassCalleeE==0 && CounterTraceClassCalleeN==0) {
					
					
					
				
						data[j][AllTClassLevelCallers] = "T";
						String Result=AllTClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllTClassLevelCallers].toString()); 
						AllTClassLevelCallersClass.UpdateCounters(Result, AllTClassLevelCallersClass);
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL T CLASS LEVEL CALLEES 
				
				
				if(CounterTraceClassCallerE==0 && CounterTraceClassCallerN==0) {
					
					
					
				
						data[j][AllTClassLevelCallees] = "T";
						String Result=AllTClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllTClassLevelCallees].toString()); 
						AllTClassLevelCalleesClass.UpdateCounters(Result, AllTClassLevelCalleesClass);
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL N CLASS LEVEL CALLERS 
				
				
				if(CounterTraceClassCalleeT==0 && CounterTraceClassCalleeE==0) {
					
					
					
				
						data[j][AllNClassLevelCallers] = "N";
						String Result=AllNClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllNClassLevelCallers].toString()); 
						AllNClassLevelCallersClass.UpdateCounters(Result, AllNClassLevelCallersClass);
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL N CLASS LEVEL CALLEES 
				
				
				if(CounterTraceClassCallerT==0 && CounterTraceClassCallerE==0) {
					
					
					
				
						data[j][AllNClassLevelCallees] = "N";
						String Result=AllNClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllNClassLevelCallees].toString()); 
						AllNClassLevelCalleesClass.UpdateCounters(Result, AllNClassLevelCalleesClass);
					
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL N METHOD LEVEL CALLERS 
				
				
				if(CountMethodTCallee==0 && CountMethodECallee==0) {
					
					
					
				
						data[j][AllNMethodLevelCallers] = "N";
						String Result=AllNMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllNMethodLevelCallers].toString()); 
						AllNMethodLevelCallersClass.UpdateCounters(Result, AllNMethodLevelCallersClass);
				}
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL N METHOD LEVEL CALLEES 
				
				
				if(CountMethodT==0 && CountMethodE==0) {
					
					
					
				
						data[j][AllNMethodLevelCallees] = "N";
						String Result=AllNMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold(), data[j][AllNMethodLevelCallees].toString()); 
						AllNMethodLevelCalleesClass.UpdateCounters(Result, AllNMethodLevelCalleesClass);
				}
			}
			
			
			JComboBox comboBox1 = new JComboBox(items1And2);
			DefaultCellEditor dce1 = new DefaultCellEditor(comboBox1);
			editors1.add(dce1);

			/*
			 * JComboBox comboBox2 = new JComboBox( items2 ); DefaultCellEditor dce2 = new
			 * DefaultCellEditor( comboBox2 ); editors2.add( dce2 );
			 */

			JComboBox comboBox4 = new JComboBox(items3And4);
			DefaultCellEditor dce3 = new DefaultCellEditor(comboBox4);
			editors3.add(dce3);

			/*
			 * JComboBox comboBox4 = new JComboBox( items4); DefaultCellEditor dce4 = new
			 * DefaultCellEditor( comboBox4 ); editors4.add( dce4 );
			 */

			comboBox1.setEditor(new MyEditor());
			comboBox1.setEditable(true);

			/*
			 * comboBox2.setEditor(new MyEditor()); comboBox2.setEditable(true);
			 */

			comboBox4.setEditor(new MyEditor());
			comboBox4.setEditable(true);

			 
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

	

			bw.write(data[j][MethodID] + "," + data[j][MethodName] + "," + data[j][RequirementID] + "," + data[j][RequirementName] + "," + data[j][ClassID] + ","
					+ data[j][ClassName] + "," + data[j][Gold] + "," + data[j][Subject] + "," + data[j][OwnerClassT] + "," + data[j][OwnerClassN] + ","
					+ data[j][OwnerClassE] + "," + data[j][CallerMethodsNumber] + "," + data[j][CallerMethodsT] + "," +
					data[j][CallerMethodsN] + "," + data[j][CallerMethodsE] + ","
					+ data[j][CallerClassesNumber] + "," + data[j][CallerClassesT] + "," + data[j][CallerClassesN] + "," + data[j][CallerClassesE] + 
					"," + data[j][CalleeMethodsNumber] + ","
					+ data[j][CalleeMethodsT] + "," + data[j][CalleeMethodsN] + "," + data[j][CalleeMethodsE] + "," + data[j][CalleeClassesNumber] + 
					"," + data[j][CalleeClassesT] + ","
					+ data[j][CalleeClassesN] + "," + data[j][CalleeClassesE] + "," + data[j][OwnerClassPrediction] + "," + data[j][MajorityClassLevelCallers]+ "," +
					data[j][MajorityClassLevelCallees]+","+data[j][MajorityMethodLevelCallers]+","+data[j][MajorityMethodLevelCallees]+ "," + 
					data[j][AtLeast1NPredictionClassLevelCallers]+ "," + data[j][AtLeast1NPredictionClassLevelCallees] 
					+ "," + data[j][AtLeast1NPredictionMethodLevelCallers]+ "," + data[j][AtLeast1NPredictionMethodLevelCallees]
					+ "," +data[j][AtLeast1TPredictionClassLevelCallers]+ "," + data[j][AtLeast1TPredictionClassLevelCallees]
					+ "," + data[j][AtLeast1TPredictionMethodLevelCallers]
					+ "," + data[j][AtLeast1TPredictionMethodLevelCallees]+ "," + data[j][AllNClassLevelCallers]
					+ "," +data[j][AllNClassLevelCallees]+ "," + data[j][AllNMethodLevelCallers]+ "," + data[j][AllNMethodLevelCallees]+ "," +
					data[j][AllTClassLevelCallers]+ ","+		data[j][AllTClassLevelCallees]+ ","+		data[j][AllTMethodLevelCallers]+ 
					","+		data[j][AllTMethodLevelCallees]+","+
					OnlyinParsedCallers	+","+ OnlyinExecutedCallers+","+BothParsedAndExecutedCallers+","+OnlyInParsedCallees+","+OnlyInExecutedCallees
					+","+BothInParsedAndExecutedCallees);
				
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
		System.out.println("ALL N CLASS LEVEL CALLERS: "+AllNClassLevelCallersClass.toString()); 
		System.out.println("ALL N CLASS LEVEL CALLEES: "+AllNClassLevelCalleesClass.toString()); 
		System.out.println("ALL N METHOD LEVEL CALLERS: "+AllNMethodLevelCallersClass.toString()); 
		System.out.println("ALL N METHOD LEVEL CALLEES: "+AllNMethodLevelCalleesClass.toString()); 
		System.out.println("ALL T CLASS LEVEL CALLERS: "+AllTClassLevelCallersClass.toString()); 
		System.out.println("ALL T CLASS LEVEL CALLEES: "+AllTClassLevelCalleesClass.toString()); 
		System.out.println("ALL T METHOD LEVEL CALLERS: "+AllTMethodLevelCallersClass.toString()); 
		System.out.println("ALL T METHOD LEVEL CALLEES: "+AllTMethodLevelCalleesClass.toString()); 
		
		
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
		bw2.write("ALL T METHOD LEVEL CALLEES: "+AllTMethodLevelCalleesClass.toString()); 
		bw2.newLine();
		bw2.close();
		String[] columnNames = { "MethodID", "MethodName", "RequirementID", "RequirementName", "ClassID", "ClassName",
				"Gold", "Subject", "OwnerClass T", "Owner Class N", "Owner Class E", "# caller methods",
				"# caller methods T", "#caller methods N", "#caller methods E", "# caller classes",
				"# caller classes T", "#caller classes N", "#caller classes E", "# callee methods",
				"# callee methods T", "#callee methods N", "#callee methods E", "# callee classes",
				"# callee classes T", "#callee classes N", "#callee classes E",  "OwnerClassPrediction",
				"MajorityClassLevelCallers","MajorityClassLevelCallees", "MajorityMethodLevelCallers","MajorityMethodLevelCallees",
				">1NPredictionClassLevelCallers", ">1NPredictionClassLevelCallees", ">1NPredictionMethodLevelCallers", 
				">1NPredictionMethodLevelCallees", ">1TPredictionClassLevelCallers", ">1TPredictionClassLevelCallees", 
				">1TPredictionMethodLevelCallers", ">1TPredictionMethodLevelCallees", 
				"AllNClassLevelCallers", "AllNClassLevelCallees","AllNMethodLevelCallers","AllNMethodLevelCallees",
				"AllTClassLevelCallers", "AllTClassLevelCallees", "AllTMethodLevelCallers", "AllTMethodLevelCallees"
				,"Callers", "Callees"
				};
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table = new JTable(model) {
			// Determine editor to be used by row
			public TableCellEditor getCellEditor(int row, int column) {
				int modelColumn = convertColumnIndexToModel(column);

				if (modelColumn == 48 && row < methodtraces2.size())
					return editors1.get(row);
				if (modelColumn == 49 && row < methodtraces2.size())
					return editors3.get(row);
				/*
				 * if (modelColumn == 31 && row < methodtraces2.size()) return
				 * editors3.get(row); if (modelColumn == 32 && row < methodtraces2.size())
				 * return editors4.get(row);
				 */

				else
					return super.getCellEditor(row, column);
			}

			
			
			@Override
			   public Component prepareRenderer(TableCellRenderer renderer,
			         int row, int column) {
			      Component label = (Component) super.prepareRenderer(renderer, row, column);
			   
			int rownum=table.getSelectedRow(); 
			if(rownum==row) {
			    	  label.setBackground(Color.ORANGE);
			    	  
			}
			else { 
				if (column==OwnerClassT || column==OwnerClassN || column==OwnerClassE) {
					 label.setBackground(Color.pink);
			    	  
			      } 
			      else if (column==CallerMethodsNumber || column==CallerMethodsT ||column==CallerMethodsN || column==CallerMethodsE) {
			    	  label.setBackground(Color.lightGray);
				      } 
			      else if(column==CallerClassesNumber || column==CallerClassesT || column==CallerClassesN || column==CallerClassesE) {
			    	   label.setBackground(Color.pink);
				      } 
			      else if (column==CalleeMethodsNumber || column==CalleeMethodsT || column==CalleeMethodsN ||column==CalleeMethodsE) {
			    	   label.setBackground(Color.lightGray);
				      } 
			      else if (column==CalleeClassesNumber || column==CalleeClassesT || column==CalleeClassesN ||column==CalleeClassesE) {
			    	   label.setBackground(Color.pink);
				      } 
			  
			 
			      else if(column==OwnerClassPrediction){
			    	  label.setBackground(Color.lightGray);
			      }
			      else if(column==MajorityClassLevelCallers || column==MajorityClassLevelCallees){
			    	  label.setBackground(Color.pink);
			      }
			      else if(column==MajorityMethodLevelCallers || column==MajorityMethodLevelCallees){
			    	  label.setBackground(Color.lightGray);
			      }
			      else if(column==AtLeast1NPredictionClassLevelCallees || column==AtLeast1NPredictionClassLevelCallers){
			    	  label.setBackground(Color.pink);
			      }
			      else if(column==AtLeast1NPredictionMethodLevelCallers || column==AtLeast1NPredictionMethodLevelCallees){
			    	  label.setBackground(Color.lightGray);
			      }
			     
			      else if(column==AtLeast1TPredictionClassLevelCallers || column==AtLeast1TPredictionClassLevelCallees){
			    	  label.setBackground(Color.pink);
			      }
			      else if(column==AtLeast1TPredictionMethodLevelCallers || column==AtLeast1TPredictionMethodLevelCallees){
			    	  label.setBackground(Color.lightGray);
			      }
			      else if(column==AllNClassLevelCallers || column==AllNClassLevelCallees){
			    	  label.setBackground(Color.pink);
			      }
			      else if(column==AllNMethodLevelCallers || column==AllNMethodLevelCallees){
			    	  label.setBackground(Color.lightGray);
			      }
			      else if(column==AllTClassLevelCallers || column==AllTClassLevelCallees){
			    	  label.setBackground(Color.pink);
			      }
			      else if(column==AllTMethodLevelCallers || column==AllTMethodLevelCallees){
			    	  label.setBackground(Color.lightGray);
			      }
			      else if (column==Callers || column==Callees ) {
			    	   label.setBackground(Color.pink);
				      }
			      else {
			    	  label.setBackground(Color.lightGray);
			      }
				}
			
			    	 
			     
			      table.setRowSelectionAllowed(true);
			      return label;
			   }
		};

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
		table.getColumnModel().getColumn(47).setPreferredWidth(150);
		table.getColumnModel().getColumn(48).setPreferredWidth(150);
		table.getColumnModel().getColumn(49).setPreferredWidth(150);
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

		TracesTable frame = new TracesTable();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}



