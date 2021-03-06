package Gantt;

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
import mypackage.Clazz;
import mypackage.ClassTrace2;
import mypackage.ColumnGroup;
import mypackage.GroupableTableHeader;
import mypackage.Interface;
import mypackage.MethodDetails;
import mypackage.Method;
import mypackage.MethodTrace2;
import mypackage.MethodTraceSubjectTSubjectNOriginal;
import mypackage.MethodTraceSubjectTSubjectNOriginal;
import mypackage.Parameter2;
import mypackage.Requirement;
import mypackage.RequirementClass;
import mypackage.RequirementGold;

public class TracesTableGantt2FINAL2 extends JFrame {
	double TracePureGold=0; 
	double NoTracePureGold=0; 
	double TraceMixedGold=0; 
	double NoTraceMixedGold=0; 
	
	double TracePureGold4=0; 
	double NoTracePureGold4=0; 
	double TraceMixedGold4=0; 
	double NoTraceMixedGold4=0; 
	double TracePureGold3=0; 
	double NoTracePureGold3=0; 
	double TraceMixedGold3=0; 
	double NoTraceMixedGold3=0; 
	double failGold=0; 
	double failGold3=0; 
	double failGold4=0; 
	
	
	
	double TraceCountTotal=0; 
	double NoTraceCountTotal=0; 
	double TraceCountTotalGold3=0; 
	double NoTraceCountTotalGold3=0; 
	double TraceCountTotalGold4=0; 
	double NoTraceCountTotalGold4=0; 
	
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
	int MajorityClassLevelCallees=29; 
	int MajorityClassLevelCallers=30; 
	int MajorityMethodLevelCallees=31; 
	int MajorityMethodLevelCallers=32; 
	int AtLeast1NPredictionClassLevelCallees=33; 
	int AtLeast1NPredictionClassLevelCallers=34; 
	int AtLeast1NPredictionMethodLevelCallees=35; 
	int AtLeast1NPredictionMethodLevelCallers=36; 
	int AtLeast1TPredictionClassLevelCallees=37; 
	int AtLeast1TPredictionClassLevelCallers=38; 
	int AtLeast1TPredictionMethodLevelCallees=39; 
	int AtLeast1TPredictionMethodLevelCallers=40; 
	int AtLeast2NPredictionClassLevelCallees=41; 
	int AtLeast2NPredictionClassLevelCallers=42; 
	int AtLeast2NPredictionMethodLevelCallees=43; 
	int AtLeast2NPredictionMethodLevelCallers=44; 
	int AtLeast2TPredictionClassLevelCallees=45; 
	int AtLeast2TPredictionClassLevelCallers=46; 
	int AtLeast2TPredictionMethodLevelCallees=47; 
	int AtLeast2TPredictionMethodLevelCallers=48; 
	int AllNClassLevelCallees=49; 
	int AllNClassLevelCallers=50; 
	int AllNMethodLevelCallees=51; 
	int AllNMethodLevelCallers=52; 
	int AllTClassLevelCallees=53; 
	int AllTClassLevelCallers=54; 
	int AllTMethodLevelCallees=55; 
	int AllTMethodLevelCallers=56; 
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
	int AllNMethodLevelCallersCallees=71; 
	int AllTMethodLevelCallersCallees=72; 
	int AllTClassLevelCallersCallees=73; 
	int AllNClassLevelsCallersCallees=74; 
	int ACHRAFTRACE=75; 
	int ACHRAFNOTRACE=76; 
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

	PredictionEvaluation ACHRAFTraceGold3= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTraceGold3= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTraceGold4= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFGold4Trace= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFTrace= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTrace= new PredictionEvaluation(); 
	

	PredictionEvaluation OwnerClassPredictionClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation MajorityClassLevelCallersClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation MajorityClassLevelCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation MajorityMethodLevelCallersClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation MajorityMethodLevelCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionClassLevelCallersClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionClassLevelCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionMethodLevelCallersClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionMethodLevelCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionClassLevelCallersClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionClassLevelCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionMethodLevelCallersClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionMethodLevelCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionClassLevelCallersClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionClassLevelCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionMethodLevelCallersClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionMethodLevelCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionClassLevelCallersClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionClassLevelCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionMethodLevelCallersClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionMethodLevelCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCallersClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCallersClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation MajorityParametersClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast1NParameterClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NParameterClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast1TParameterClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TParameterClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllNParameterClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllTParameterClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCallersCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCallersCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelsCallersCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersCalleesClass= new PredictionEvaluation(); 

	
	PredictionEvaluation OwnerClassPredictionClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation MajorityClassLevelCallersClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation MajorityClassLevelCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation MajorityMethodLevelCallersClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation MajorityMethodLevelCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionClassLevelCallersClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionClassLevelCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionMethodLevelCallersClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionMethodLevelCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionClassLevelCallersClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionClassLevelCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionMethodLevelCallersClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionMethodLevelCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionClassLevelCallersClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionClassLevelCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionMethodLevelCallersClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionMethodLevelCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionClassLevelCallersClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionClassLevelCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionMethodLevelCallersClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionMethodLevelCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCallersClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCallersClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation MajorityParametersClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast1NParameterClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NParameterClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast1TParameterClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TParameterClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AllNParameterClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AllTParameterClassGold4= new PredictionEvaluation(); 
	 HashMap<String, Interface> InterfacesHashMap= new HashMap<String, Interface>();
	 HashMap<String, Interface> InterfacesHashMapAlreadyImpl= new HashMap<String, Interface>(); 
		PredictionEvaluation AllNMethodLevelCallersCalleesClassGold4= new PredictionEvaluation(); 
		PredictionEvaluation AllTMethodLevelCallersCalleesClassGold4= new PredictionEvaluation(); 
		PredictionEvaluation AllNClassLevelsCallersCalleesClassGold4= new PredictionEvaluation(); 
		PredictionEvaluation AllTClassLevelCallersCalleesClassGold4= new PredictionEvaluation(); 
		
		PredictionEvaluation AllNMethodLevelCallersCalleesClassGold3= new PredictionEvaluation(); 
		PredictionEvaluation AllTMethodLevelCallersCalleesClassGold3= new PredictionEvaluation(); 
		PredictionEvaluation AllNClassLevelsCallersCalleesClassGold3= new PredictionEvaluation(); 
		PredictionEvaluation AllTClassLevelCallersCalleesClassGold3= new PredictionEvaluation(); 
	ClassTrace2 myclasstrace = new ClassTrace2();
	static List<MethodTraceSubjectTSubjectNOriginal> methodtraces2 = new ArrayList<MethodTraceSubjectTSubjectNOriginal>();
	static List<ClassTrace2> classtraces2 = new ArrayList<ClassTrace2>();
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass = new  LinkedHashMap<String, ClassTrace2>(); 
	JTable table = new JTable(); 
	static List<MethodDetails> methodlist = new ArrayList<MethodDetails>();
	//File fout = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\GanttFiles\\TableLog.txt");
	File fout = new File("C:\\Users\\mouna\\dumps\\TableLogGantt.txt");
	FileOutputStream fos = new FileOutputStream(fout);
	
	//File fout2 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\GanttFiles\\PredictionEvaluation.txt");
	File fout2 = new File("C:\\Users\\mouna\\dumps\\PredictionEvaluationGANTT.txt");
	FileOutputStream fos2 = new FileOutputStream(fout2);
	
	//File fout3 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\GanttFiles\\PredictionEvaluationGold3.txt");
	File fout3 = new File("C:\\Users\\mouna\\dumps\\PredictionEvaluationGold3GANTT.txt");

	FileOutputStream fos3 = new FileOutputStream(fout3);
	
	//File fout4 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\GanttFiles\\PredictionEvaluationGold4.txt");
	File fout4 = new File("C:\\Users\\mouna\\dumps\\PredictionEvaluationGold4GANTT.txt");
	FileOutputStream fos4 = new FileOutputStream(fout4);
	
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(fos2));
	BufferedWriter bwGold3 = new BufferedWriter(new OutputStreamWriter(fos3));
	BufferedWriter bwGold4 = new BufferedWriter(new OutputStreamWriter(fos4));

	File mylog = new File("C:\\Users\\mouna\\dumps\\logs\\loggantt.txt");
	FileOutputStream mylogfile = new FileOutputStream(mylog); 
	BufferedWriter bwlog = new BufferedWriter(new OutputStreamWriter(mylogfile));
	
	private final String userName = "root";
	private final String password = "123456";
	List<Method> CallerMethodListFinal = new ArrayList<Method>();
	List<Method> CalleeMethodListFinal = new ArrayList<Method>();
	List<Method> CallerMethodListFinal2 = new ArrayList<Method>();
	List<Method> CalleeMethodListFinal2 = new ArrayList<Method>();

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

	public TracesTableGantt2FINAL2() throws SQLException, IOException {
//	
//		bw.write("RowNumber, MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold, Subject, OwnerClassT, OwnerClassN, "
//				+ "OwnerClassE, #callermethods, callers, #callermethodsT, #callermethodsN, #callermethodsE, #callerclasses, #callerclassesT, #callerclassesN, "
//				+ "#callerclassesE, #calleemethods, callees, #calleemethodsT, #calleemethodsN, #calleemethodsE, #calleeclasses, #calleeclassesT, #calleeclassesN, "
//				+ "#calleeclassesE, OwnerClassPrediction, MajorityClassLevelCallers, MajorityClassLevelCallees, MajorityMethodLevelCallers, MajorityMethodLevelCallees,"
//				+ "AtLeast1NPredictionClassLevelCallers, AtLeast1NPredictionClassLevelCallees, AtLeast1NPredictionMethodLevelCallers, AtLeast1NPredictionMethodLevelCallees, "
//				+"AtLeast1TPredictionClassLevelCallers, AtLeast1TPredictionClassLevelCallees, AtLeast1TPredictionMethodLevelCallers, AtLeast1TPredictionMethodLevelCallees,"
//				+ "AtLeast2NPredictionClassLevelCallers, AtLeast2NPredictionClassLevelCallees, AtLeast2NPredictionMethodLevelCallers, AtLeast2NPredictionMethodLevelCallees, "
//				+"AtLeast2TPredictionClassLevelCallers, AtLeast2TPredictionClassLevelCallees, AtLeast2TPredictionMethodLevelCallers, AtLeast2TPredictionMethodLevelCallees,"
//				+"AllNClassLevelCallers, AllNClassLevelCallees, AllNMethodLevelCallers, AllNMethodLevelCallees,"
//				+"AllTClassLevelCallers, AllTClassLevelCallees, AllTMethodLevelCallers, AllTMethodLevelCallees,"
//				+ " OnlyInParsedCallers, OnlyInExecutedCallers, BothParsedAndExecutedCallers, "
//				+ "OnlyInParsedCallees, OnlyInExecutedCallees, BothParsedAndExecutedCallees"
//				+ " #parameters, parameters, # Parameter T, # Parameter N, # Parameter E" 
//				+ "MajorityParameter ,AtLeast1NParameterPrediction" + 
//				"AtLeast1TParameterPrediction, AtLeast2TParameterPrediction, AtLeast2NParameterPrediction,  AllNParameterPrediction, AllTParameterPrediction, SubjectT, SubjectN" );

		bw.write("RowNumber, MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold, Subject, OwnerClassT, OwnerClassN, "
				+ "OwnerClassE, #callermethods, callers, #callermethodsT, #callermethodsN, #callermethodsE, #callerclasses, #callerclassesT, #callerclassesN, "
				+ "#callerclassesE, #calleemethods, callees, #calleemethodsT, #calleemethodsN, #calleemethodsE, #calleeclasses, #calleeclassesT, #calleeclassesN, "
				+ "#calleeclassesE, OwnerClassPrediction, MajorityClassLevelCallees, MajorityClassLevelCallers, MajorityMethodLevelCallees, MajorityMethodLevelCallers,"
				+ "AtLeast1NPredictionClassLevelCallees, AtLeast1NPredictionClassLevelCallers, AtLeast1NPredictionMethodLevelCallees, AtLeast1NPredictionMethodLevelCallers, "
				+"AtLeast1TPredictionClassLevelCallees, AtLeast1TPredictionClassLevelCallers, AtLeast1TPredictionMethodLevelCallees, AtLeast1TPredictionMethodLevelCallers,"
				+ "AtLeast2NPredictionClassLevelCallees, AtLeast2NPredictionClassLevelCallers, AtLeast2NPredictionMethodLevelCallees, AtLeast2NPredictionMethodLevelCallers, "
				+"AtLeast2TPredictionClassLevelCallees, AtLeast2TPredictionClassLevelCallers, AtLeast2TPredictionMethodLevelCallees, AtLeast2TPredictionMethodLevelCallers,"
				+"AllNClassLevelCallees, AllNClassLevelCallers, AllNMethodLevelCallees, AllNMethodLevelCallers,"
				+"AllTClassLevelCallees, AllTClassLevelCallers, AllTMethodLevelCallees, AllTMethodLevelCallers,"
				+ " OnlyInParsedCallers, OnlyInExecutedCallers, BothParsedAndExecutedCallers, "
				+ "OnlyInParsedCallees, OnlyInExecutedCallees, BothParsedAndExecutedCallees"
				+ " #parameters, parameters, # Parameter T, # Parameter N, # Parameter E" 
				+ "MajorityParameter ,AtLeast1NParameterPrediction" + 
				"AtLeast1TParameterPrediction, AtLeast2TParameterPrediction, AtLeast2NParameterPrediction,  AllNParameterPrediction, AllTParameterPrediction, Gold4" );


		
		bw.newLine();
		
		DatabaseReading2Gantt db = new DatabaseReading2Gantt();
		DatabaseReading2Gantt.MakePredictions();
		methodtraces2 = db.getMethodtraces2();
		 methodtracesRequirementClass = db.getClassesRequirementtraceshashmap(); 
		 
		 InterfacesHashMap = db.getInterfaces();
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
		Method[] callersarr = new Method[methodtraces2.size()];
		Method[] callersex = new Method[methodtraces2.size()];
		Method[] calleesarr = new Method[methodtraces2.size()];
		Method[] calleesex = new Method[methodtraces2.size()];
		Object[][] data = new Object[methodtraces2.size()][100];
	

		// Create the editors to be used for each row
		for (MethodTraceSubjectTSubjectNOriginal methodtrace : methodtraces2) {
			System.out.println("LOOP INDEX===========> "+j); 
			data[j][Row] = j; 
			data[j][MethodID] = methodtrace.MethodRepresentation.getMethodid();
			data[j][MethodName] = methodtrace.MethodRepresentation.getMethodname();
			data[j][RequirementID] = methodtrace.Requirement.getID();
			data[j][RequirementName] = methodtrace.Requirement.getRequirementName();
			data[j][ClassID] = methodtrace.ClassRepresentation.ID;
			data[j][ClassName] = methodtrace.ClassRepresentation.classname;
			data[j][Gold] = methodtrace.gold;
			data[j][Subject] = methodtrace.subject;
			
			data[j][CallerClassesT] = 0;
			data[j][CallerClassesN] = 0;
			data[j][CallerClassesE] = 0;
			data[j][CallerMethodsT] = 0;
			data[j][CallerMethodsN] = 0;
			data[j][CallerMethodsE] = 0;
			data[j][CalleeClassesT] = 0;
			data[j][CalleeClassesN] = 0;
			data[j][CalleeClassesE] = 0;
			data[j][CalleeMethodsT] = 0;
			data[j][CalleeMethodsN] = 0;
			data[j][CalleeMethodsE] = 0;
			data[j][CalleeMethodsNumber] = 0;
			data[j][CallerMethodsNumber] = 0;
			data[j][CallerClassesNumber] = 0;
			data[j][CalleeClassesNumber] = 0;
			
			
			// data[j][CalleePrediction]= methodtrace.goldpredictionCaller;
			// data[j][CallerPrediction]= methodtrace.goldpredictionCallee;
			String reqclass= data[j][RequirementID].toString()+"-"+ data[j][ClassID].toString(); 
			ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
			LinkedHashMap<String, MethodDetails> linkedmethodhashmap= new LinkedHashMap<String, MethodDetails>(); 
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
			
			System.out.println("METHOD TRACE CLASS REPRESENTATION CLASS ID "+methodtrace.ClassRepresentation.ID);
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
			callersarr = new Method[methodtrace.getCallersList().size()];
			
			
			
			int myparametercount=0; 
			/////////////////////////////////	
				
				int counterParameterT=0; 
				int counterParameterN=0; 
				int counterParameterE=0; 
				
				int counterParameterTGOLD3=0; 
				int counterParameterNGOLD3=0; 
				int counterParameterEGOLD3=0; 
				
				
				int counterParameterTGOLD4=0; 
				int counterParameterNGOLD4=0; 
				int counterParameterEGOLD4=0; 
				
				
				 myparameters = new String[methodtraces2.size()];
				 String ParametersAppended=""; 
				MethodDetails mymethodobje = linkedmethodhashmap.get(methodtrace.MethodRepresentation.ID); 
				for ( Parameter2 myparam : mymethodobje.getParameters()) {
					myparameters[myparametercount] = myparam.toString(); 
					
					myparametercount++;
					
					ParametersAppended=ParametersAppended+myparam.toString()+"-"; 
					String ParameterClassid = myparam.getParameterType().ID; 
					
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
						
						
						String mytrace3=mycallerclass.getTrace3(); 
						if(mytrace3!=null) {
							if(mytrace3.equals("T")) {
								counterParameterTGOLD3++; 
							}else if (mytrace3.equals("N")) {
								counterParameterNGOLD3++; 
							}else {
								counterParameterEGOLD3++; 
							}
						}
						
						String mytrace4=mycallerclass.getTrace4(); 
						if(mytrace4!=null) {
							if(mytrace4.equals("T")) {
								counterParameterTGOLD4++; 
							}else if (mytrace4.equals("N")) {
								counterParameterNGOLD4++; 
							}else {
								counterParameterEGOLD4++; 
							}
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
			//	data [j][paramatersNumber]= myparametercount; 
				data [j][paramatersNumber]= counterParameterT+counterParameterN+counterParameterE; 

				
				
				
				
				
			for (Method caller : methodtrace.getCallersList()) {
				items1[CountCallers] = caller.toString2();
				callersarr[CountCallers] = caller;
				System.out.println(caller.toString2());
				CountCallers++;
				
				
				
				
				

			}

			int CountCallersExecuted = 0;
			items2 = new String[methodtrace.getCallersListExecuted().size()];
			callersex = new Method[methodtrace.getCallersListExecuted().size()];
			for (Method caller : methodtrace.getCallersListExecuted()) {

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
			for (Method caller : methodtrace.getCallersListExecuted()) {
				
				itemsExecuted[CountCallerExecuted] = caller.toString2();	
				System.out.println(caller.toString2());
				CountCallerExecuted++;
			}
			
			int Count=0; 
			for (Method caller : methodtrace.getCallersList()) {

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
			Method[] CallerMethods = new Method[items1.length + items2.length];
			CallerMethods = (Method[]) ArrayUtils.addAll(callersarr, callersex);
			//=======> LIST OF CALLERS AFTER MERGING CALLERS + CALLERSEXECUTED 
			List<Method> CallerMethodsList = Arrays.asList(CallerMethods);

			
			int BothInParsedAndExecutedCallees=0; 
			int OnlyInParsedCallees=0; 
			int OnlyInExecutedCallees=0; 
			// data[j][OwnerClassE]=items1;
			int CountCallees = 0;
			items3 = new String[methodtrace.getCalleesList().size()];
			calleesarr = new Method[methodtrace.getCalleesList().size()];
			for (Method caller : methodtrace.getCalleesList()) {
				items3[CountCallees] = caller.toString2();
				calleesarr[CountCallees] = caller;
				System.out.println(caller.toString2());
				CountCallees++;
			
			}

			int CountCalleesExecuted = 0;
			items4 = new String[methodtrace.getCalleesListExecuted().size()];
			calleesex = new Method[methodtrace.getCalleesListExecuted().size()];
			for (Method caller : methodtrace.getCalleesListExecuted()) {
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
			for (Method callee : methodtrace.getCalleesListExecuted()) {
				
				itemsExecutedCallees[CountCalleeExecuted] = callee.toString2();	
				System.out.println(callee.toString2());
				CountCalleeExecuted++;
			}
			
			 Count=0; 
			for (Method callee : methodtrace.getCalleesList()) {

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
			Method[] CalleeMethods = new Method[items3.length + items4.length];
			CalleeMethods = (Method[]) ArrayUtils.addAll(calleesarr, calleesex);
			//=======> LIST OF CALLEES AFTER MERGING CALLEES + CALLEESEXECUTED 
			List<Method> CalleeMethodsList = Arrays.asList(CalleeMethods);

//			data[j][CallerMethodsNumber] = CountCallersExecuted + CountCallers;
//			data[j][CalleeMethodsNumber] = CountCalleesExecuted + CountCallees;

			
//			data[j][CallerMethodsNumber] = CallerMethodsList.size();
//			data[j][CalleeMethodsNumber] = CalleeMethodsList.size();
			
			
			CallerMethodListFinal = new ArrayList<Method>();
			CalleeMethodListFinal = new ArrayList<Method>();
			
			CallerMethodListFinal2 = new ArrayList<Method>();
			CalleeMethodListFinal2 = new ArrayList<Method>();

			for (Method methcaller : CallerMethodsList) {
				if (methcaller != null) {
					CallerMethodListFinal.add(methcaller);
				}
			}

			for (Method methcaller : CalleeMethodsList) {
				if (methcaller != null) {
					CalleeMethodListFinal.add(methcaller);
				}
			}
			for (Method methcaller : CallerMethodsList) {
				if (methcaller != null) {
					CallerMethodListFinal2.add(methcaller);
				}
			}

			for (Method methcaller : CalleeMethodsList) {
				if (methcaller != null) {
					CalleeMethodListFinal2.add(methcaller);
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
			
			
			
			
			
//			//***********************************************CALLERS**************************************************//	
//			//***********************************************CALLERS**************************************************//	
//			//***********************************************CALLERS**************************************************//	
//
//			for (Method2Representation methcaller : CallerMethodListFinal2) {
//				if (methcaller != null) {
//							boolean flag=false; 
//							
//								for(Method2Representation item: CallerMethodListFinal2) {
//									String key =methcaller.classrep.getClassid()+"-"+methcaller.classrep.getClassname();
//									Interface2 value = InterfacesHashMapAlreadyImpl.get(key);
//									
//									if(value!=null) {
//										String ownerclassid=value.InterfaceClass.classid;
//									if(item.classrep.classid.equals(ownerclassid) && item.getMethodname().equals(methcaller.methodname)) {
//										CallerMethodListFinal.remove(item); 
//									}
//									}
//								}
//						
//				
//							
//			
//					
//				}
//			}
//			
//			
//
//			List<Method2Representation> CallerMethodsListFinalNoDuplicates = new ArrayList<Method2Representation>();
//
//			Set<String> CallerMethodsListNoDuplicates = new HashSet<String>();
//
//			for( Method2Representation item : CallerMethodListFinal ) {
//				String val= item.classrep.classid+"-"+item.methodname;
//			    if( CallerMethodsListNoDuplicates.add( val )) {
//			    	CallerMethodsListFinalNoDuplicates.add( item );
//			    }
//			}
//			
//			
//			
//			
//			
//				//***********************************************CALLEES**************************************************//	
//				//***********************************************CALLEES**************************************************//	
//				//***********************************************CALLEES**************************************************//	
//
//			
//			
//			
//			
//			
//			for (Method2Representation methcaller : CalleeMethodListFinal2) {
//				if (methcaller != null) {
//					
//				
//						
//					
//						
//							boolean flag=false; 
//							
//								for(Method2Representation item: CalleeMethodListFinal2) {
//									String key =methcaller.classrep.getClassid()+"-"+methcaller.classrep.getClassname();
//									Interface2 value = InterfacesHashMapAlreadyImpl.get(key);
//									
//									if(value!=null) {
//										String ownerclassid=value.InterfaceClass.classid;
//									if(item.classrep.classid.equals(ownerclassid) && item.getMethodname().equals(methcaller.methodname)) {
//										CalleeMethodListFinal.remove(item); 
//									}
//									}
//								}
//						
//				
//							
//			
//					
//				}
//			}
//			
//			List<Method2Representation> CalleeMethodsListFinalNoDuplicates = new ArrayList<Method2Representation>();
//
//			Set<String> CalleeMethodsListNoDuplicates = new HashSet<String>();
//
//			for( Method2Representation item : CalleeMethodListFinal ) {
//				String val= item.classrep.classid+"-"+item.methodname;
//			    if( CalleeMethodsListNoDuplicates.add( val )) {
//			    	CalleeMethodsListFinalNoDuplicates.add( item );
//			    }
//			}
//			
//			
//			
//			
//			
//			
//			
			
			
			
			
			
			
			
			
			
			
			
			
			

			
			int CountMethodTACHRAF = 0; 
			int CountMethodNACHRAF = 0; 
			int CountMethodEACHRAF = 0; 
			
			
			for (Method mycaller: CallerMethodListFinal) {
				 MethodDetails methdet = linkedmethodhashmap.get(mycaller.ID); 
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement r= new Requirement(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null) {
				if (methtrace.gold.trim().equals("T")) {
					CountMethodTACHRAF++;
				} else if (methtrace.gold.trim().equals("N")) {
					CountMethodNACHRAF++;
				} else if (methtrace.gold.trim().equals("E")) {
					CountMethodEACHRAF++;
				}
				
				
			}
			}
			
			
			
			
			
			
			int CountMethodTACHRAFCallee = 0; 
			int CountMethodNACHRAFCallee = 0; 
			int CountMethodEACHRAFCallee = 0; 
			for (Method mycaller: CalleeMethodListFinal) {
				 MethodDetails methdet = linkedmethodhashmap.get(mycaller.ID); 
				 if(methdet!=null) {
						HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
						Requirement r= new Requirement(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
						MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
						if(methtrace!=null) {
							if (methtrace.gold.trim().equals("T")) {
								CountMethodTACHRAFCallee++;
							} else if (methtrace.gold.trim().equals("N")) {
								CountMethodNACHRAFCallee++;
							} else if (methtrace.gold.trim().equals("E")) {
								CountMethodEACHRAFCallee++;
							}
						}
				 }
			
			
			}
			
			
			
			int CountMethodTACHRAFgold3 = 0; 
			int CountMethodNACHRAFgold3 = 0; 
			int CountMethodEACHRAFgold3 = 0; 
			for (Method mycaller: CallerMethodListFinal) {
				 MethodDetails methdet = linkedmethodhashmap.get(mycaller.ID); 
				 if(methdet!=null) {
					 HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
						Requirement r= new Requirement(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
						MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
						if(methtrace!=null && methtrace.gold3!=null) {
						if (methtrace.gold3.trim().equals("T")) {
							CountMethodTACHRAFgold3++;
						} else if (methtrace.gold3.trim().equals("N")) {
							CountMethodNACHRAFgold3++;
						} else if (methtrace.gold3.trim().equals("E")) {
							CountMethodEACHRAFgold3++;
						}
					}
				 }
				
			}
			
			int CountMethodTACHRAFgold3Callee = 0; 
			int CountMethodNACHRAFgold3Callee = 0; 
			int CountMethodEACHRAFgold3Callee = 0; 
			for (Method mycaller: CalleeMethodListFinal) {
				 MethodDetails methdet = linkedmethodhashmap.get(mycaller.ID); 
				 if(methdet!=null) {
					 HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
						Requirement r= new Requirement(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
						MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
						if(methtrace!=null && methtrace.gold3!=null) {
							if (methtrace.gold3.trim().equals("T")) {
								CountMethodTACHRAFgold3Callee++;
							} else if (methtrace.gold3.trim().equals("N")) {
								CountMethodNACHRAFgold3Callee++;
							} else if (methtrace.gold3.trim().equals("E")) {
								CountMethodEACHRAFgold3Callee++;
							}
						} 
				 }
				
			
			}
			
			
			int CountMethodTACHRAFgold4 = 0; 
			int CountMethodNACHRAFgold4 = 0; 
			int CountMethodEACHRAFgold4 = 0; 
			for (Method mycaller: CallerMethodListFinal) {
				 MethodDetails methdet = linkedmethodhashmap.get(mycaller.ID); 
				 if(methdet!=null) {
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement r= new Requirement(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null && methtrace.gold4!=null) {
				if (methtrace.gold4.trim().equals("T")) {
					CountMethodTACHRAFgold4++;
				} else if (methtrace.gold4.trim().equals("N")) {
					CountMethodNACHRAFgold4++;
				} else if (methtrace.gold4.trim().equals("E")) {
					CountMethodEACHRAFgold4++;
				}
			}
			}
			}
			
			int CountMethodTACHRAFgold4Callee = 0; 
			int CountMethodNACHRAFgold4Callee = 0; 
			int CountMethodEACHRAFgold4Callee = 0; 
			for (Method mycaller: CalleeMethodListFinal) {
				 MethodDetails methdet = linkedmethodhashmap.get(mycaller.ID); 
				 if(methdet!=null) {
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement r= new Requirement(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null  && methtrace.gold4!=null) {
					if (methtrace.gold4.trim().equals("T")) {
						CountMethodTACHRAFgold4Callee++;
					} else if (methtrace.gold4.trim().equals("N")) {
						CountMethodNACHRAFgold4Callee++;
					} else if (methtrace.gold4.trim().equals("E")) {
						CountMethodEACHRAFgold4Callee++;
					}
				}
			
			}
			}
			
			
			CallerMethodListFinal=removeDuplicates(CallerMethodListFinal); 

			String AppendedCallers=""; 
			for(Method CallerMethod: CallerMethodListFinal) {
				if(CallerMethod!=null) {
					AppendedCallers=AppendedCallers+CallerMethod.toString2()+"-"; 
				}
				
			}
			CalleeMethodListFinal=removeDuplicates(CalleeMethodListFinal); 
			AppendedCallers=AppendedCallers.replaceAll(",", "/"); 
			String AppendedCallees=""; 
			for(Method CalleeMethod: CalleeMethodListFinal) {
				if(CalleeMethod!=null) {
					AppendedCallees=AppendedCallees+CalleeMethod.toString2()+"-"; 
				}
				
			}
			
			
			
			AppendedCallers=AppendedCallers.replaceAll(",", "/"); 
			AppendedCallees=AppendedCallees.replaceAll(",", "/"); 
			int CounterTraceClassCallerT = 0;
			int CounterTraceClassCallerN = 0;
			int CounterTraceClassCallerE = 0;
			int CounterTraceClassCallerTGOLD3 = 0;
			int CounterTraceClassCallerNGOLD3 = 0;
			int CounterTraceClassCallerEGOLD3 = 0;
			int CounterTraceClassCallerTGOLD4 = 0;
			int CounterTraceClassCallerNGOLD4 = 0;
			int CounterTraceClassCallerEGOLD4 = 0;
			List<ClassTrace2> mycallerclasses = new ArrayList<ClassTrace2>();
			if(CallerMethodListFinal.isEmpty()==false && CallerMethodListFinal!=null ) {
				for (Method callermeth : CallerMethodListFinal) {
					Clazz classrep = callermeth.getClassrep();
				//	ClassTrace2 mycallerclass = myclasstrace.FindTrace(classtraces2, classrep.classid, methodtrace.Requirement.getID());
					ClassTrace2 mycallerclass = myclasstrace.FindTrace2(methodtracesRequirementClass, classrep.ID,	methodtrace.Requirement.getID());
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

		//	data[j][CallerClassesNumber] = myclasstracesCallers.size();
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
					
					String trace3= mycallerclass.getTrace3(); 
					if(trace3!=null) {
						trace3=trace3.trim(); 
						if (trace3.equals("T")) {
							CounterTraceClassCallerTGOLD3++;
						} else if (trace3.equals("N")) {
							CounterTraceClassCallerNGOLD3++;
						} else if (trace3.equals("E")) {
							CounterTraceClassCallerEGOLD3++;
						}
					}
					
					String trace4= mycallerclass.getTrace4(); 
					if(trace4!=null) {
						trace4=trace4.trim(); 
						if (trace4.equals("T")) {
							CounterTraceClassCallerTGOLD4++;
						} else if (trace4.equals("N")) {
							CounterTraceClassCallerNGOLD4++;
						} else if (trace4.equals("E")) {
							CounterTraceClassCallerEGOLD4++;
						}
					}
					
				}

				data[j][CallerClassesT] = CounterTraceClassCallerT;
				data[j][CallerClassesN] = CounterTraceClassCallerN;
				data[j][CallerClassesE] = CounterTraceClassCallerE;
				data[j][CallerClassesNumber] = CounterTraceClassCallerT+CounterTraceClassCallerN+CounterTraceClassCallerE;

			}
			
//DUPLICATE CLASSES
			int CountMethodT = 0; 
			int CountMethodN = 0; 
			int CountMethodE = 0; 
			int CountMethodTGOLD3 = 0; 
			int CountMethodNGOLD3 = 0; 
			int CountMethodEGOLD3 = 0; 
			int CountMethodTGOLD4 = 0; 
			int CountMethodNGOLD4 = 0; 
			int CountMethodEGOLD4 = 0; 
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
					
					
					
					
					String trace3= mycallerclass.gettrace(); 
					if(trace3!=null) {
						trace3=trace3.trim(); 

						if (trace3.equals("T")) {
							CountMethodTGOLD3++;
						} else if (trace3.equals("N")) {
							CountMethodNGOLD3++;
						} else if (trace3.equals("E")) {
							CountMethodEGOLD3++;
						}
					}
				
					
					
					
					String trace4= mycallerclass.gettrace(); 
					
					if(trace4!=null) {
						trace4=trace4.trim(); 
						if (trace4.equals("T")) {
							CountMethodTGOLD4++;
						} else if (trace4.equals("N")) {
							CountMethodNGOLD4++;
						} else if (trace4.equals("E")) {
							CountMethodEGOLD4++;
						}
					}
				}
			
			}
			}
		

			int CounterTraceClassCalleeT = 0;
			int CounterTraceClassCalleeN = 0;
			int CounterTraceClassCalleeE = 0;
			
			int CounterTraceClassCalleeTGOLD3 = 0;
			int CounterTraceClassCalleeNGOLD3 = 0;
			int CounterTraceClassCalleeEGOLD3 = 0;
			
			int CounterTraceClassCalleeTGOLD4 = 0;
			int CounterTraceClassCalleeNGOLD4 = 0;
			int CounterTraceClassCalleeEGOLD4 = 0;
			List<ClassTrace2> mycalleeclasses = new ArrayList<ClassTrace2>();

			for (Method calleemeth : CalleeMethodListFinal) {
				Clazz classrep = calleemeth.getClassrep();
				//ClassTrace2 mycalleeclass = myclasstrace.FindTrace(classtraces2, classrep.classid,
				//		methodtrace.Requirement.getID());
				ClassTrace2 mycalleeclass = myclasstrace.FindTrace2(methodtracesRequirementClass, classrep.ID,methodtrace.Requirement.getID());
				mycalleeclasses.add(mycalleeclass);
			}

			ArrayList<ClassTrace2> myclasstracesCallees = new ArrayList<ClassTrace2>();// unique
			for (ClassTrace2 classtrace : mycalleeclasses) {
				if (!myclasstracesCallees.contains(classtrace) && classtrace!=null) {

					myclasstracesCallees.add(classtrace);
				}
			}
			//NO DUPLICATE CLASSES 

		//	data[j][CalleeClassesNumber] = myclasstracesCallees.size();
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
					
					
					
					String mytrace3=mycalleeclass.getTrace3(); 
					if(mytrace3!=null) {
						if(mytrace3!=null) {
							mytrace3=mytrace3.trim(); 

							if (mytrace3.equals("T")) {
								CounterTraceClassCalleeTGOLD3++;
							} else if (mytrace3.equals("N")) {
								CounterTraceClassCalleeNGOLD3++;
							} else if (mytrace3.equals("E")) {
								CounterTraceClassCalleeEGOLD3++;
							}
						}
					}
			
				
					
					
					
					
					
					String mytrace4=mycalleeclass.getTrace4(); 
					
					if(mytrace4!=null) {
						mytrace4=mytrace4.trim(); 
						if (mytrace4.equals("T")) {
							CounterTraceClassCalleeTGOLD4++;
						} else if (mytrace4.equals("N")) {
							CounterTraceClassCalleeNGOLD4++;
						} else if (mytrace4.equals("E")) {
							CounterTraceClassCalleeEGOLD4++;
						}
					}
				
					
					
				}

				data[j][CalleeClassesT] = CounterTraceClassCalleeT;
				data[j][CalleeClassesN] = CounterTraceClassCalleeN;
				data[j][CalleeClassesE] = CounterTraceClassCalleeE;
				data[j][CalleeClassesNumber] = CounterTraceClassCalleeE+CounterTraceClassCalleeN+CounterTraceClassCalleeT;

			}
			
			//DUPLICATE CLASSES
			int CountMethodTCallee = 0; 
			int CountMethodNCallee = 0; 
			int CountMethodECallee = 0; 
			
			int CountMethodTCalleeGOLD3 = 0; 
			int CountMethodNCalleeGOLD3 = 0; 
			int CountMethodECalleeGOLD3 = 0; 
			
			
			int CountMethodTCalleeGOLD4 = 0; 
			int CountMethodNCalleeGOLD4 = 0; 
			int CountMethodECalleeGOLD4 = 0; 
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
						
						String mytrace3=mycalleeclass.getTrace3(); 
						
						if(mytrace3!=null) {
							mytrace3=mytrace3.trim(); 
							if (mytrace3.equals("T")) {
								CountMethodTCalleeGOLD3++;
							} else if (mytrace3.equals("N")) {
								CountMethodNCalleeGOLD3++;
							} else if (mytrace3.equals("E")) {
								CountMethodECalleeGOLD3++;
							}
						}
						
						
						
						String mytrace4=mycalleeclass.getTrace4(); 
						
						if(mytrace4!=null) {
							mytrace4=mytrace4.trim(); 
							if (mytrace4.equals("T")) {
								CountMethodTCalleeGOLD4++;
							} else if (mytrace4.equals("N")) {
								CountMethodNCalleeGOLD4++;
							} else if (mytrace4.equals("E")) {
								CountMethodECalleeGOLD4++;
							}
						}
						
						
						
						
						
						
					}
					
				}
				
				data[j][CalleeMethodsT] = CountMethodTCallee;
				data[j][CalleeMethodsN] = CountMethodNCallee;
				data[j][CalleeMethodsE] = CountMethodECallee;
			}
			
			
//			data[j][CallerMethodsNumber] = mycallerclasses.size();
//			data[j][CalleeMethodsNumber] = mycalleeclasses.size();
			data[j][CalleeMethodsNumber] = CountMethodTCallee+CountMethodNCallee+CountMethodECallee;

			
			data[j][CallerMethodsT] = CountMethodT;
			data[j][CallerMethodsN] = CountMethodN;
			data[j][CallerMethodsE] = CountMethodE;
			data[j][CallerMethodsNumber] = CountMethodT+CountMethodN+CountMethodE;

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
		
		
	
		 boolean flagGold=false; 
		 boolean flagGold3=false; 
		 boolean flagGold4=false; 
		 if(OwnerClassNVar.toString().equals("1")) {
				data[j][OwnerClassPrediction]="N"; 
				String Result=OwnerClassPredictionClass.ComparePredictionToGold(methodtrace.getGold().trim().trim(), data[j][OwnerClassPrediction].toString()); 
				OwnerClassPredictionClass.UpdateCounters(Result, OwnerClassPredictionClass);
				flagGold=true; 
				if(methodtrace.getGold3()!=null && methodtrace.getGold3().equals("null")==false){
					String Result2=OwnerClassPredictionClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][OwnerClassPrediction].toString()); 
					OwnerClassPredictionClassGold3.UpdateCounters(Result2, OwnerClassPredictionClassGold3);
					flagGold3=true; 	
				}
				
				if(methodtrace.getGold4()!=null && methodtrace.getGold4().equals("null")==false){
					String Result2=OwnerClassPredictionClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][OwnerClassPrediction].toString()); 
					OwnerClassPredictionClassGold4.UpdateCounters(Result2, OwnerClassPredictionClassGold4);
					flagGold4=true; 	
				}
			}
			//else {
				
			
			//else {
				
				
				
				
				
			//MAJORITY PARAMETER PREDICTION 

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
						if(true) {
							String Result=MajorityParametersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][MajorityParameters].toString()); 
							MajorityParametersClass.UpdateCounters(Result, MajorityParametersClass);
						}
						
					
						
					
					}
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				//AT LEAST 1N PREDICTION PARAMETER
				
				
				
				
				
				if (counterParameterN >=1 )
						 {
					data[j][AtLeast1NParameter] = "N";
					if(true) {
					String Result=AtLeast1NParameterClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast1NParameter].toString()); 
					AtLeast1NParameterClass.UpdateCounters(Result, AtLeast1NParameterClass);
					}
					
				} 
			
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				//AT LEAST 2N PREDICTION PARAMETER
				
				
				
				
				
				if (counterParameterN >=2 )
						 {
					data[j][AtLeast2NParameter] = "N";
					if(true) {
						
						String Result=AtLeast2NParameterClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast2NParameter].toString()); 
					AtLeast2NParameterClass.UpdateCounters(Result, AtLeast2NParameterClass);
					}
					
				} 
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//AT LEAST 1T PREDICTION PARAMETER
			
			
				
				
				
				if (counterParameterT >=1 )
						 {
					data[j][AtLeast1TParameter] = "T";
					if(true) {
					String Result=AtLeast1TParameterClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast1TParameter].toString()); 
					AtLeast1TParameterClass.UpdateCounters(Result, AtLeast1TParameterClass);
					}
				} 
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 2T PREDICTION PARAMETER
				
				
					
					
					
					if (counterParameterT >=2 )
							 {
						data[j][AtLeast2TParameter] = "T";
						if(true) {
						String Result=AtLeast2TParameterClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast2TParameter].toString()); 
						AtLeast2TParameterClass.UpdateCounters(Result, AtLeast2TParameterClass);
						}
					} 
				/**************************************************************************************************************/
				/**************************************************************************************************************/
			    /**************************************************************************************************************/	
				
				
				
				//ALL T PARAMETER PREDICTION
				
				
				if(counterParameterE==0 && counterParameterN==0 && counterParameterT>=1) {
					
					
					
				
						data[j][AllTParameters] = "T";
						if(true) {
						String Result=AllTParameterClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTParameters].toString()); 
						AllTParameterClass.UpdateCounters(Result, AllTParameterClass);
						}
						
						
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL N PARAMETER PREDICTION
				
				
				if(counterParameterT==0 && counterParameterE==0 && counterParameterN>=1) {
					
					
					
				
						data[j][AllNParameters] = "N";
						if(true) {
						String Result=AllNParameterClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNParameters].toString()); 
						AllNParameterClass.UpdateCounters(Result, AllNParameterClass);
						}
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				//MAJORITY CLASS LEVEL CALLEES PREDICTION 

				//FIRST IF makes sure there is a mixture 
				if((CounterTraceClassCalleeT!=0 || CounterTraceClassCalleeN!=0 || CounterTraceClassCalleeE!=0)
					/*	||
						(CounterTraceClassCallerN!=0 && CounterTraceClassCallerE!=0)
						||(CounterTraceClassCallerT!=0 && CounterTraceClassCallerE!=0)*/
						) {
					
					if(CounterTraceClassCalleeT==CounterTraceClassCalleeN && CounterTraceClassCalleeT>0) {
						data[j][MajorityClassLevelCallees] = "T";
					}
					else if(CounterTraceClassCalleeT==0 && CounterTraceClassCalleeN==0 && CounterTraceClassCalleeE>0) {
						data[j][MajorityClassLevelCallees] = "E";
					}
					else if(CounterTraceClassCalleeT==0 && CounterTraceClassCalleeN>0 && CounterTraceClassCalleeE>0) {
						data[j][MajorityClassLevelCallees] = "N";
					}
					else if ((CounterTraceClassCalleeT >= CounterTraceClassCalleeN
							)
							) {
						data[j][MajorityClassLevelCallees] = "T";
					} /*else if (((CounterTraceClassCallerE >= CounterTraceClassCallerN
							&& CounterTraceClassCallerN >= CounterTraceClassCallerT)
							|| (CounterTraceClassCallerE >= CounterTraceClassCallerT
									&& CounterTraceClassCallerT >= CounterTraceClassCallerN))
						) {
						data[j][MajorityClassLevelCallees] = "E";
					}*/ else if (CounterTraceClassCalleeN >= CounterTraceClassCalleeT) {
						data[j][MajorityClassLevelCallees] = "N";
					}
					if(true) {
					String Result=MajorityClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][MajorityClassLevelCallees].toString()); 
					MajorityClassLevelCalleesClass.UpdateCounters(Result, MajorityClassLevelCalleesClass);
					}
				}
			
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//MAJORITY CLASS LEVEL CALLERS PREDICTION 

				//FIRST IF makes sure there is a mixture 
				if((CounterTraceClassCallerT!=0 || CounterTraceClassCallerN!=0 ||CounterTraceClassCallerE!=0)
						/*||
						(CounterTraceClassCalleeN!=0 && CounterTraceClassCalleeE!=0)
						||(CounterTraceClassCalleeT!=0 && CounterTraceClassCalleeE!=0)*/) {
					
					if(CounterTraceClassCallerT==CounterTraceClassCallerN && CounterTraceClassCallerT>0) {
						data[j][MajorityClassLevelCallers] = "T";
					}
					else if(CounterTraceClassCallerT==0 && CounterTraceClassCallerN==0 && CounterTraceClassCallerE>0) {
						data[j][MajorityClassLevelCallers] = "E";
					}
					else if(CounterTraceClassCallerT==0 && CounterTraceClassCallerN>0 && CounterTraceClassCallerE>0) {
						data[j][MajorityClassLevelCallers] = "N";
					}
					else if(CounterTraceClassCallerT==0 && CounterTraceClassCallerN>0 && CounterTraceClassCallerE>0) {
						data[j][MajorityClassLevelCallers] = "E";
					}
					else if (CounterTraceClassCallerT >= CounterTraceClassCallerN) {
						data[j][MajorityClassLevelCallers] = "T";
					} else if (CounterTraceClassCallerN>=CounterTraceClassCallerT)
						 {
						data[j][MajorityClassLevelCallers] = "N";
					} 
					if(true) {
					String Result=MajorityClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][MajorityClassLevelCallers].toString()); 
					MajorityClassLevelCallersClass.UpdateCounters(Result, MajorityClassLevelCallersClass);
					}if(methodtrace.getGold3()!=null && true && methodtrace.getGold3()!=null){
					String Result2=MajorityClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][MajorityClassLevelCallers].toString()); 
					MajorityClassLevelCallersClassGold3.UpdateCounters(Result2, MajorityClassLevelCallersClassGold3);
					}
					
					
					
					
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				//MAJORITY METHOD LEVEL CALLEES PREDICTION 

				
				//FIRST IF makes sure there is a mixture 
				if((CountMethodTCallee!=0 || CountMethodNCallee!=0 || CountMethodECallee!=0)/*||
						(CountMethodNCallee!=0 && CountMethodECallee!=0)
						||(CountMethodTCallee!=0 && CountMethodECallee!=0)*/) {
					if(CountMethodTCallee==CountMethodNCallee && CountMethodTCallee>0) {
						data[j][MajorityMethodLevelCallees] = "T";
					}
					else if(CountMethodTCallee==0 && CountMethodNCallee==0 && CountMethodECallee>0) {
						data[j][MajorityMethodLevelCallees] = "E";
					}
					else if(CountMethodTCallee==0 && CountMethodNCallee>0 && CountMethodECallee>0) {
						data[j][MajorityMethodLevelCallees] = "N";
					} 
					
					else if(CountMethodTCallee>=CountMethodNCallee)
					 {
						data[j][MajorityMethodLevelCallees] = "T";
					}  else if (CountMethodNCallee >= CountMethodTCallee
						
							) {
						data[j][MajorityMethodLevelCallees] = "N";
					}
				
					if(true) {
					String Result=MajorityMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][MajorityMethodLevelCallees].toString()); 
					MajorityMethodLevelCalleesClass.UpdateCounters(Result, MajorityMethodLevelCalleesClass);
					}
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//MAJORITY METHOD LEVEL CALLERS PREDICTION 
				
				//FIRST IF makes sure there is a mixture 
				if((CountMethodT!=0 || CountMethodN!=0|| CountMethodE!=0 )/*||
						(CountMethodN!=0 && CountMethodE!=0)
						||(CountMethodT!=0 && CountMethodE!=0)*/) {
					
					if(CountMethodT==CountMethodN && CountMethodT>0) {
						data[j][MajorityMethodLevelCallers] = "T";
					}
					else if(CountMethodT==0 && CountMethodN==0 && CountMethodE>0) {
						data[j][MajorityMethodLevelCallers] = "E";
					}
					else if(CountMethodT==0 && CountMethodN>0 && CountMethodE>0) {
						data[j][MajorityMethodLevelCallers] = "N";
					}
					
					else if (CountMethodT >= CountMethodN){
						data[j][MajorityMethodLevelCallers] = "T";
					}  else if (CountMethodN >= CountMethodT
							
							) {
						data[j][MajorityMethodLevelCallers] = "N";
					}
					if(true) {
					String Result=MajorityMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][MajorityMethodLevelCallers].toString()); 
					MajorityMethodLevelCallersClass.UpdateCounters(Result, MajorityMethodLevelCallersClass);
					}
				}
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//1AT LEAST 1N PREDICTION CLASS LEVEL CALLERS 
				
				
					
					
					
					if (CounterTraceClassCallerN >=1 )
							 {
						data[j][AtLeast1NPredictionClassLevelCallers] = "N";
						Object var= 	data[j][AtLeast1NPredictionClassLevelCallers]; 
						String NEWVAR=var.toString(); 
						if(true) {
						String Result=AtLeastNPredictionClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast1NPredictionClassLevelCallers].toString()); 
						AtLeastNPredictionClassLevelCallersClass.UpdateCounters(Result, AtLeastNPredictionClassLevelCallersClass);
						}
					} 
				
					
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//2AT LEAST 1T PREDICTION CLASS LEVEL CALLERS 
				
				
					
					
					
					if (CounterTraceClassCallerT >=1 )
							 {
						data[j][AtLeast1TPredictionClassLevelCallers] = "T";
						if(true) {
						String Result=AtLeastTPredictionClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast1TPredictionClassLevelCallers].toString()); 
						AtLeastTPredictionClassLevelCallersClass.UpdateCounters(Result, AtLeastTPredictionClassLevelCallersClass);
						}
					} 
					
						
					
				
				
		
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//3AT LEAST 1N PREDICTION CLASS LEVEL CALLEES 
			
				
					
					
					
					if (CounterTraceClassCalleeN >=1 )
							 {
						data[j][AtLeast1NPredictionClassLevelCallees] = "N";
						if(true) {
						String Result=AtLeastNPredictionClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast1NPredictionClassLevelCallees].toString()); 
						AtLeastNPredictionClassLevelCalleesClass.UpdateCounters(Result, AtLeastNPredictionClassLevelCalleesClass);
						}
					} 
					
				
				
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
			
				//4AT LEAST 1T PREDICTION CLASS LEVEL CALLEES 
				
				
					
					
					
					if (CounterTraceClassCalleeT >=1 )
							 {
						data[j][AtLeast1TPredictionClassLevelCallees] = "T";
						if(true) {
						String Result=AtLeastTPredictionClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast1TPredictionClassLevelCallees].toString()); 
						AtLeastTPredictionClassLevelCalleesClass.UpdateCounters(Result, AtLeastTPredictionClassLevelCalleesClass);
						}
					} 
					
					
				
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				//5AT LEAST 1N PREDICTION METHOD LEVEL CALLERS 
				
				
					
					
					if (CountMethodN >=1 )
							 {
						data[j][AtLeast1NPredictionMethodLevelCallers] = "N";
						if(true) {
						String Result=AtLeastNPredictionMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast1NPredictionMethodLevelCallers].toString()); 
						AtLeastNPredictionMethodLevelCallersClass.UpdateCounters(Result, AtLeastNPredictionMethodLevelCallersClass);
						}
					} 
					
					
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				//6AT LEAST 1T PREDICTION METHOD LEVEL CALLERS 
			
				
					
					
					
					if (CountMethodT >=1 )
							 {
						data[j][AtLeast1TPredictionMethodLevelCallers] = "T";
						if(true) {
						String Result=AtLeastTPredictionMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast1TPredictionMethodLevelCallers].toString()); 
						AtLeastTPredictionMethodLevelCallersClass.UpdateCounters(Result, AtLeastTPredictionMethodLevelCallersClass);
						}
					} 
					
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//7AT LEAST 1N PREDICTION METHOD LEVEL CALLEES 
				
				
					
					
					
					if (CountMethodNCallee >=1 )
							 {
						data[j][AtLeast1NPredictionMethodLevelCallees] = "N";
						if(true) {
						String Result=AtLeastNPredictionMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast1NPredictionMethodLevelCallees].toString()); 
						AtLeastNPredictionMethodLevelCalleesClass.UpdateCounters(Result, AtLeastNPredictionMethodLevelCalleesClass);
						}
					} 
					
				
		
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//8AT LEAST 1T PREDICTION METHOD LEVEL CALLEES 
				
				
					
					
					
					if (CountMethodTCallee >=1 )
							 {
						data[j][AtLeast1TPredictionMethodLevelCallees] = "T";
						if(true) {
						String Result=AtLeastTPredictionMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast1TPredictionMethodLevelCallees].toString()); 
						AtLeastTPredictionMethodLevelCalleesClass.UpdateCounters(Result, AtLeastTPredictionMethodLevelCalleesClass);
						}
						}
					 
					
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//AT LEAST 2N PREDICTION CLASS LEVEL CALLEES 
					
					
						
						
						
						if (CounterTraceClassCalleeN >=2 )
								 {
							data[j][AtLeast2NPredictionClassLevelCallees] = "N";
							Object var= 	data[j][AtLeast2NPredictionClassLevelCallees]; 
							String NEWVAR=var.toString(); 
							if(true) {
								String Result=AtLeast2NPredictionClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast2NPredictionClassLevelCallees].toString()); 
								AtLeast2NPredictionClassLevelCalleesClass.UpdateCounters(Result, AtLeast2NPredictionClassLevelCalleesClass);
							}
						} 
					
						
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//AT LEAST 2T PREDICTION CLASS LEVEL CALLEES 
					
					
						
						
						
						if (CounterTraceClassCalleeT >=2 )
						 {
					data[j][AtLeast2TPredictionClassLevelCallees] = "T";
					if(true) {
					String Result=AtLeast2TPredictionClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast2TPredictionClassLevelCallees].toString()); 
					AtLeast2TPredictionClassLevelCalleesClass.UpdateCounters(Result, AtLeast2TPredictionClassLevelCalleesClass);
					}
				} 
							
						
					
					
			
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//AT LEAST 2N PREDICTION METHOD LEVEL CALLERS 
				
					
						
						
						
						
						if (CountMethodN >=2 )
								 {
							data[j][AtLeast2NPredictionMethodLevelCallers] = "N";
							if(true) {
							String Result=AtLeast2NPredictionMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast2NPredictionMethodLevelCallers].toString()); 
							AtLeast2NPredictionMethodLevelCallersClass.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCallersClass);
							}
						} 
						
						
					
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/
					
						//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
						
						
							
							
							
							if (CounterTraceClassCallerT >=2 )
							 {
						data[j][AtLeast2TPredictionClassLevelCallers] = "T";
						if(true) {
						String Result=AtLeast2TPredictionClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast2TPredictionClassLevelCallers].toString()); 
						AtLeast2TPredictionClassLevelCallersClass.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClass);
						}
					} 
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
				
					//AT LEAST 2T PREDICTION METHOD LEVEL CALLERS 
					
					
						
						
						
						if (CountMethodT >=2 )
						 {
					data[j][AtLeast2TPredictionMethodLevelCallers] = "T";
					if(true) {
					String Result=AtLeast2TPredictionMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast2TPredictionMethodLevelCallers].toString()); 
					AtLeast2TPredictionMethodLevelCallersClass.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClass);
					}
				} 
						
						
					
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					//AT LEAST 2N PREDICTION METHOD LEVEL CALLEES 

						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					
						
						
						if (CountMethodNCallee >=2 )
						 {
					data[j][AtLeast2NPredictionMethodLevelCallees] = "N";
					if(true) {
					String Result=AtLeast2NPredictionMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast2NPredictionMethodLevelCallees].toString()); 
					AtLeast2NPredictionMethodLevelCalleesClass.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCalleesClass);
					}	
				} 
						
						
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					//AT LEAST 2T PREDICTION METHOD LEVEL CALLEES 
				
					
						
						
						
						if (CountMethodTCallee >=2 )
						 {
					data[j][AtLeast2TPredictionMethodLevelCallees] = "T";
					if(true) {
						String Result=AtLeast2TPredictionMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast2TPredictionMethodLevelCallees].toString()); 
						AtLeast2TPredictionMethodLevelCalleesClass.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCalleesClass);

					}
					
				} 
						
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//AT LEAST 2N PREDICTION CLASS LEVEL CALLERS 
					
					
						
						
						
						if (CounterTraceClassCallerN >=2 )
						 {
					data[j][AtLeast2NPredictionClassLevelCallers] = "N";
					if(true) {
					String Result=AtLeast2NPredictionClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast2NPredictionClassLevelCallers].toString()); 
					AtLeast2NPredictionClassLevelCallersClass.UpdateCounters(Result, AtLeast2NPredictionClassLevelCallersClass);
					
					}
				} 
				
					
			
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
					
					
						
						
						
						if (CounterTraceClassCallerT >=2 )
						 {
					data[j][AtLeast2TPredictionClassLevelCallers] = "T";
					if(true) {
						String Result=AtLeast2TPredictionClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast2TPredictionClassLevelCallers].toString()); 
						AtLeast2TPredictionClassLevelCallersClass.UpdateCounters(Result, AtLeast2TPredictionClassLevelCallersClass);

					}
					
					}
						
						
						
						
						
						
						
						
						
						
						
						
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/	 
				//ALL T METHOD LEVEL CALLEES 
				
				
				if(CountMethodNCallee==0 && CountMethodECallee==0 && CountMethodTCallee>=4) {
					
					
					
						
						data[j][AllTMethodLevelCallees] = "T";
						if(true) {
						String Result=AllTMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTMethodLevelCallees].toString()); 
						AllTMethodLevelCalleesClass.UpdateCounters(Result, AllTMethodLevelCalleesClass);
						}
				}
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL T METHOD LEVEL CALLERS 
				
				if(CountMethodN==0 && CountMethodE==0  && CountMethodT>=4) {
					
					
					
				
						data[j][AllTMethodLevelCallers] = "T";
						if(true) {
						String Result=AllTMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTMethodLevelCallers].toString()); 
						AllTMethodLevelCallersClass.UpdateCounters(Result, AllTMethodLevelCallersClass);
						
						}
					
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL T CLASS LEVEL CALLERS 
				
				
				if(CounterTraceClassCallerE==0 && CounterTraceClassCallerN==0 && CounterTraceClassCallerT>=4) {
					
					
				
						data[j][AllTClassLevelCallers] = "T";
						if(true) {
						String Result=AllTClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTClassLevelCallers].toString()); 
						AllTClassLevelCallersClass.UpdateCounters(Result, AllTClassLevelCallersClass);
						System.out.println(AllTClassLevelCallersClass.toString());
				
						
						
						
							
						
						
						}
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL T CLASS LEVEL CALLEES 
				
				
				if(CounterTraceClassCalleeE==0 && CounterTraceClassCalleeN==0 && CounterTraceClassCalleeT>=4) {
					
					
					
				
						data[j][AllTClassLevelCallees] = "T";
						if(true) {
						String Result=AllTClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTClassLevelCallees].toString()); 
						AllTClassLevelCalleesClass.UpdateCounters(Result, AllTClassLevelCalleesClass);
				
						
						
						
						
						}
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL N CLASS LEVEL CALLERS 
				
				
				if(CounterTraceClassCallerT==0 && CounterTraceClassCallerE==0 && CounterTraceClassCallerN>=4) {
					
					
					
				
						data[j][AllNClassLevelCallers] = "N";
						if(true) {
						String Result=AllNClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNClassLevelCallers].toString()); 
						AllNClassLevelCallersClass.UpdateCounters(Result, AllNClassLevelCallersClass);
						
						}
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL N CLASS LEVEL CALLEES 
				
				
				if(CounterTraceClassCalleeT==0 && CounterTraceClassCalleeE==0 && CounterTraceClassCalleeN>=4) {
					
					
					
				
						data[j][AllNClassLevelCallees] = "N";
						if(true) {
						String Result=AllNClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNClassLevelCallees].toString()); 
						AllNClassLevelCalleesClass.UpdateCounters(Result, AllNClassLevelCalleesClass);
						
						}
					
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL N METHOD LEVEL CALLERS 
				
				
				if(CountMethodT==0 && CountMethodE==0 && CountMethodN>=4) {
					
					
					
				
						data[j][AllNMethodLevelCallers] = "N";
						if(true) {
						String Result=AllNMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNMethodLevelCallers].toString()); 
						AllNMethodLevelCallersClass.UpdateCounters(Result, AllNMethodLevelCallersClass);
						
						}
				}
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL N METHOD LEVEL CALLEES 
				
				
				if(CountMethodTCallee==0 && CountMethodECallee==0 && CountMethodNCallee>=4) {
					
					
					
				
						data[j][AllNMethodLevelCallees] = "N";
						if(true) {
							String Result=AllNMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNMethodLevelCallees].toString()); 
							AllNMethodLevelCalleesClass.UpdateCounters(Result, AllNMethodLevelCalleesClass);
						}
					
						
				}
				
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL N METHOD LEVEL CALLERS CALLEES 
				
				
			
					
					if(CountMethodTCallee==0 && CountMethodECallee==0 && CountMethodNCallee>=3 && CountMethodN>=3) {
					
				
						data[j][AllNMethodLevelCallersCallees] = "N";
						if(true) {
							String Result=AllTMethodLevelCallersCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNMethodLevelCallersCallees].toString()); 
							AllTMethodLevelCallersCalleesClass.UpdateCounters(Result, AllTMethodLevelCallersCalleesClass);
						}
					
						
				}
			//}
					
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//ALL T METHOD LEVEL CALLERS CALLEES 
					
					
				
						
						if(CountMethodT==0 && CountMethodE==0 && CountMethodTCallee>=3 && CountMethodT>=3) {
						
					
							data[j][AllTMethodLevelCallersCallees] = "T";
							if(true) {
								String Result=AllTMethodLevelCallersCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTMethodLevelCallersCallees].toString()); 
								AllTMethodLevelCallersCalleesClass.UpdateCounters(Result, AllTMethodLevelCallersCalleesClass);
							}
						
							
					}
						
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						
						//ALL N CLASS LEVEL CALLERS CALLEES 
						
						
					
							
							if(CountMethodTCallee==0 && CountMethodECallee==0 && CounterTraceClassCalleeN>=3 && CounterTraceClassCallerN>=3) {
							
						
								data[j][AllNMethodLevelCallersCallees] = "N";
								if(true) {
									String Result=AllTMethodLevelCallersCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNMethodLevelCallersCallees].toString()); 
									AllTMethodLevelCallersCalleesClass.UpdateCounters(Result, AllTMethodLevelCallersCalleesClass);
								}
							
								
						}
					//}
							
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//ALL T CLASS LEVEL CALLERS CALLEES 
							
							
						
								
								if(CountMethodT==0 && CountMethodE==0 && CounterTraceClassCalleeT>=3 && CounterTraceClassCallerT>=3) {
								
							
									data[j][AllTMethodLevelCallersCallees] = "T";
									if(true) {
										String Result=AllTMethodLevelCallersCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTMethodLevelCallersCallees].toString()); 
										AllTMethodLevelCallersCalleesClass.UpdateCounters(Result, AllTMethodLevelCallersCalleesClass);
									}
								
									
							}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								//ACHRAF
								//ACHRAF
								if(CountMethodTACHRAF>0 && CountMethodTACHRAFCallee>0) {
									
									boolean entered=false; 
									if(CountMethodNACHRAF+CountMethodNACHRAFCallee==0 && methodtrace.getGold()!=null) {
										
										TracePureGold++; 
										entered=true; 
										
									} else {
										TraceMixedGold++; 
										entered=true; 
									}
								
									if(entered==true) {
										if(methodtrace.getGold()!=null && methodtrace.getGold().trim().equals("T")) {
											TraceCountTotal++; 
											
										}else if(methodtrace.getGold()!=null && methodtrace.getGold().trim().equals("N")) {
											NoTraceCountTotal++; 
										}
										data[j][ACHRAFTRACE]="T"; 
										if(methodtrace.getGold()!=null ) {
										String Result=ACHRAFTrace.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][ACHRAFTRACE].toString()); 
										ACHRAFTrace.UpdateCounters(Result, ACHRAFTrace);
										}
									}
									
									
							}else if(CountMethodNACHRAF>0 && CountMethodNACHRAFCallee>0) {
								
								boolean entered=false; 
								if(CountMethodTACHRAF+CountMethodTACHRAFCallee==0 && methodtrace.getGold()!=null) {
									NoTracePureGold++; 
									entered=true; 
									
									
								} else {
									NoTraceMixedGold++; 
									entered=true; 
								}
								if(entered==true) {
								if(methodtrace.getGold()!=null && methodtrace.getGold().trim().equals("N")) {
									
									NoTraceCountTotal++; 
								}else if(methodtrace.getGold()!=null && methodtrace.getGold().trim().equals("T")) {
									TraceCountTotal++; 
								}
								data[j][ACHRAFNOTRACE]="N"; 
								if(methodtrace.getGold()!=null ) {
									String Result=ACHRAFNOTrace.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][ACHRAFNOTRACE].toString()); 
									ACHRAFNOTrace.UpdateCounters(Result, ACHRAFNOTrace);
								}
								}
								
						}else {
							failGold++; 
						}
								
								
				/********************************************************************************************************************/				
								
			if(CountMethodTACHRAFgold3>0 && CountMethodTACHRAFgold3Callee>0) {
									
				boolean entered=false; 
									if(CountMethodNACHRAFgold3+CountMethodNACHRAFgold3Callee==0 && methodtrace.getGold3()!=null) {
									
										TracePureGold3++; 
										entered=true; 
										
									} else {
										TraceMixedGold3++; 
										entered=true; 
									}
									if(entered==true) {
									data[j][ACHRAFTRACE]="T"; 
									if(methodtrace.getGold3()!=null ) {
									String Result=ACHRAFTraceGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][ACHRAFTRACE].toString()); 
									ACHRAFTraceGold3.UpdateCounters(Result, ACHRAFTraceGold3);	
									}
									
									if(methodtrace.getGold3()!=null && methodtrace.getGold3().trim().equals("T")) {
										TraceCountTotalGold3++; 
									}
									else if(methodtrace.getGold3()!=null && methodtrace.getGold3().trim().equals("N")) {
										NoTraceCountTotalGold3++; 
									}
									}
							}


			else if(CountMethodNACHRAFgold3>0 && CountMethodNACHRAFgold3Callee>0) {
								
				boolean entered=false; 
								if(CountMethodTACHRAFgold3+CountMethodTACHRAFgold3Callee==0 && methodtrace.getGold3()!=null) {
									NoTracePureGold3++; 
									entered=true; 
									}else {
										NoTraceMixedGold3++; 
										entered=true; 
									}
								if(entered==true) {
									data[j][ACHRAFNOTRACE]="N"; 
									if(methodtrace.getGold3()!=null ) {
									String Result=ACHRAFNOTraceGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][ACHRAFNOTRACE].toString()); 
									ACHRAFNOTraceGold3.UpdateCounters(Result, ACHRAFNOTraceGold3);
									}
									if(methodtrace.getGold3()!=null && methodtrace.getGold3().trim().equals("N")) {
										NoTraceCountTotalGold3++; 
										
									
								} 
									else	if(methodtrace.getGold3()!=null && methodtrace.getGold3().trim().equals("T")) {
										TraceCountTotalGold3++; 
									}
								}
						}else {
							failGold3++; 
						}
						
							/********************************************************************************************************************/				
								
			if(CountMethodTACHRAFgold4>0 && CountMethodTACHRAFgold4Callee>0) {
									
				boolean entered=false; 
									if(CountMethodNACHRAFgold4+CountMethodNACHRAFgold4Callee==0 && methodtrace.getGold4()!=null) {
									
										TracePureGold4++; 
										entered=true; 
										
									} else {
										TraceMixedGold4++; 
										entered=true; 
									}
									if(entered==true) {
									data[j][ACHRAFTRACE]="T"; 
									if(methodtrace.getGold4()!=null ) {
									String Result=ACHRAFGold4Trace.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][ACHRAFTRACE].toString()); 
									ACHRAFGold4Trace.UpdateCounters(Result, ACHRAFGold4Trace);	
									}
									
									if(methodtrace.getGold4()!=null && methodtrace.getGold4().trim().equals("T")) {
										TraceCountTotalGold4++; 
									}
									else if(methodtrace.getGold4()!=null && methodtrace.getGold4().trim().equals("N")) {
										NoTraceCountTotalGold4++; 
									}
									}
							}


			else if(CountMethodNACHRAFgold4>0 && CountMethodNACHRAFgold4Callee>0) {
								
								boolean entered=false; 
								if(CountMethodTACHRAFgold4+CountMethodTACHRAFgold4Callee==0 && methodtrace.getGold4()!=null) {
									NoTracePureGold4++; 
									entered=true; 
									}else {
										NoTraceMixedGold4++; 
										entered=true; 
									}
								if(entered==true) {
									data[j][ACHRAFNOTRACE]="N"; 
									if(methodtrace.getGold4()!=null ) {
									String Result=ACHRAFNOTraceGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][ACHRAFNOTRACE].toString()); 
									ACHRAFNOTraceGold4.UpdateCounters(Result, ACHRAFNOTraceGold4);
									}
									if(methodtrace.getGold4()!=null && methodtrace.getGold4().trim().equals("N")) {
										NoTraceCountTotalGold4++; 
										
									
								} 
									else	if(methodtrace.getGold4()!=null && methodtrace.getGold4().trim().equals("T")) {
										TraceCountTotalGold4++; 
									}
								}
						}else {
							failGold4++; 
						}
								
							
								
																/**************************************************************************************************************/
																/**************************************************************************************************************/
																/**************************************************************************************************************/				

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

			//MAJORITY PARAMETER PREDICTION 

			if((counterParameterTGOLD3!=0 || counterParameterNGOLD3!=0|| counterParameterEGOLD3!=0)
					/*	||
						(CounterTraceClassCallerN!=0 && CounterTraceClassCallerE!=0)
						||(CounterTraceClassCallerT!=0 && CounterTraceClassCallerE!=0)*/
						) {
					
					if(counterParameterTGOLD3==counterParameterNGOLD3 && counterParameterTGOLD3>0) {
						data[j][MajorityParameters] = "T";
					}
					else if(counterParameterTGOLD3==0 && counterParameterNGOLD3==0 && counterParameterEGOLD3>0) {
						data[j][MajorityParameters] = "E";
					}
					else if(counterParameterTGOLD3==0 && counterParameterNGOLD3>0 && counterParameterEGOLD3>0) {
						data[j][MajorityParameters] = "N";
					}
					else if (((counterParameterTGOLD3 >= counterParameterNGOLD3
						//	&& counterParameterNGOLD3 >= counterParameterEGOLD3
							)
							//|| (counterParameterTGOLD3 >= counterParameterEGOLD3
								//	&& counterParameterEGOLD3 >= counterParameterNGOLD3
							//		)
							)
							) {
						data[j][MajorityParameters] = "T";
					}/* else if (((counterParameterEGOLD3 >= counterParameterNGOLD3
							&& counterParameterNGOLD3 >= counterParameterTGOLD3)
							|| (counterParameterEGOLD3 >= counterParameterTGOLD3
									&& counterParameterTGOLD3 >= counterParameterNGOLD3))
						) {
						data[j][MajorityParameters] = "E";
					} */else if ((counterParameterNGOLD3 >= counterParameterTGOLD3)) {
						data[j][MajorityParameters] = "N";
					}
					if(true && methodtrace.getGold3()!=null) {
						String Result=MajorityParametersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][MajorityParameters].toString()); 
						MajorityParametersClassGold3.UpdateCounters(Result, MajorityParametersClassGold3);
					}
					
				
					
				
				}
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			//AT LEAST 1N PREDICTION PARAMETER
			
			
			
			
			
			if (counterParameterNGOLD3 >=1 )
					 {
				data[j][AtLeast1NParameter] = "N";
				if(true && methodtrace.getGold3()!=null) {
				String Result=AtLeast1NParameterClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1NParameter].toString()); 
				AtLeast1NParameterClassGold3.UpdateCounters(Result, AtLeast1NParameterClassGold3);
				}
				
			} 
		
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			//AT LEAST 2N PREDICTION PARAMETER
			
			
			
			
			
			if (counterParameterNGOLD3 >=2 )
					 {
				data[j][AtLeast2NParameter] = "N";
				if(true && methodtrace.getGold3()!=null) {
					
					String Result=AtLeast2NParameterClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2NParameter].toString()); 
				AtLeast2NParameterClassGold3.UpdateCounters(Result, AtLeast2NParameterClassGold3);
				}
				
			} 
		/**************************************************************************************************************/
		/**************************************************************************************************************/
		/**************************************************************************************************************/
		
		//AT LEAST 1T PREDICTION PARAMETER
		
		
			
			
			
			if (counterParameterTGOLD3 >=1 )
					 {
				data[j][AtLeast1TParameter] = "T";
				if(true && methodtrace.getGold3()!=null) {
				String Result=AtLeast1TParameterClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1TParameter].toString()); 
				AtLeast1TParameterClassGold3.UpdateCounters(Result, AtLeast1TParameterClassGold3);
				}
			} 
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//AT LEAST 2T PREDICTION PARAMETER
			
			
				
				
				
				if (counterParameterTGOLD3 >=2 )
						 {
					data[j][AtLeast2TParameter] = "T";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AtLeast2TParameterClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2TParameter].toString()); 
					AtLeast2TParameterClassGold3.UpdateCounters(Result, AtLeast2TParameterClassGold3);
					}
				} 
			/**************************************************************************************************************/
			/**************************************************************************************************************/
		    /**************************************************************************************************************/	
			
			
			
			//ALL T PARAMETER PREDICTION
			
			
			if(counterParameterEGOLD3==0 && counterParameterNGOLD3==0 && counterParameterTGOLD3>=1) {
				
				
				
			
					data[j][AllTParameters] = "T";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AllTParameterClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTParameters].toString()); 
					AllTParameterClassGold3.UpdateCounters(Result, AllTParameterClassGold3);
					}
					
					
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL N PARAMETER PREDICTION
			
			
			if(counterParameterTGOLD3==0 && counterParameterEGOLD3==0 && counterParameterNGOLD3>=1) {
				
				
				
			
					data[j][AllNParameters] = "N";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AllNParameterClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNParameters].toString()); 
					AllNParameterClassGold3.UpdateCounters(Result, AllNParameterClassGold3);
					}
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			//MAJORITY CLASS LEVEL CALLEES PREDICTION 

			//FIRST IF makes sure there is a mixture 
			if((CounterTraceClassCalleeTGOLD3!=0 || CounterTraceClassCalleeNGOLD3!=0 || CounterTraceClassCalleeEGOLD3!=0)
				/*	||
					(CounterTraceClassCallerNGOLD3!=0 && CounterTraceClassCallerEGOLD3!=0)
					||(CounterTraceClassCallerTGOLD3!=0 && CounterTraceClassCallerEGOLD3!=0)*/
					) {
				
				if(CounterTraceClassCalleeTGOLD3==CounterTraceClassCalleeNGOLD3 && CounterTraceClassCalleeTGOLD3>0) {
					data[j][MajorityClassLevelCallees] = "T";
				}
				else if(CounterTraceClassCalleeTGOLD3==0 && CounterTraceClassCalleeNGOLD3==0 && CounterTraceClassCalleeEGOLD3>0) {
					data[j][MajorityClassLevelCallees] = "E";
				}
				else if(CounterTraceClassCalleeTGOLD3==0 && CounterTraceClassCalleeNGOLD3>0 && CounterTraceClassCalleeEGOLD3>0) {
					data[j][MajorityClassLevelCallees] = "N";
				}
				else if ((CounterTraceClassCalleeTGOLD3 >= CounterTraceClassCalleeNGOLD3
						)
						) {
					data[j][MajorityClassLevelCallees] = "T";
				} /*else if (((CounterTraceClassCallerEGOLD3 >= CounterTraceClassCallerNGOLD3
						&& CounterTraceClassCallerNGOLD3 >= CounterTraceClassCallerTGOLD3)
						|| (CounterTraceClassCallerEGOLD3 >= CounterTraceClassCallerTGOLD3
								&& CounterTraceClassCallerTGOLD3 >= CounterTraceClassCallerNGOLD3))
					) {
					data[j][MajorityClassLevelCallees] = "E";
				}*/ else if (CounterTraceClassCalleeNGOLD3 >= CounterTraceClassCalleeTGOLD3) {
					data[j][MajorityClassLevelCallees] = "N";
				}
				if(true && methodtrace.getGold3()!=null) {
				String Result=MajorityClassLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][MajorityClassLevelCallees].toString()); 
				MajorityClassLevelCalleesClassGold3.UpdateCounters(Result, MajorityClassLevelCalleesClassGold3);
				}
			}
		
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//MAJORITY CLASS LEVEL CALLERS PREDICTION 

			//FIRST IF makes sure there is a mixture 
			if((CounterTraceClassCallerTGOLD3!=0 || CounterTraceClassCallerNGOLD3!=0 ||CounterTraceClassCallerEGOLD3!=0)
					/*||
					(CounterTraceClassCalleeNGOLD3!=0 && CounterTraceClassCalleeEGOLD3!=0)
					||(CounterTraceClassCalleeTGOLD3!=0 && CounterTraceClassCalleeEGOLD3!=0)*/) {
				
				if(CounterTraceClassCallerTGOLD3==CounterTraceClassCallerNGOLD3 && CounterTraceClassCallerTGOLD3>0) {
					data[j][MajorityClassLevelCallers] = "T";
				}
				else if(CounterTraceClassCallerTGOLD3==0 && CounterTraceClassCallerNGOLD3==0 && CounterTraceClassCallerEGOLD3>0) {
					data[j][MajorityClassLevelCallers] = "E";
				}
				else if(CounterTraceClassCallerTGOLD3==0 && CounterTraceClassCallerNGOLD3>0 && CounterTraceClassCallerEGOLD3>0) {
					data[j][MajorityClassLevelCallers] = "N";
				}
				else if(CounterTraceClassCallerTGOLD3==0 && CounterTraceClassCallerNGOLD3>0 && CounterTraceClassCallerEGOLD3>0) {
					data[j][MajorityClassLevelCallers] = "E";
				}
				else if (CounterTraceClassCallerTGOLD3 >= CounterTraceClassCallerNGOLD3) {
					data[j][MajorityClassLevelCallers] = "T";
				} else if (CounterTraceClassCallerNGOLD3>=CounterTraceClassCallerTGOLD3)
					 {
					data[j][MajorityClassLevelCallers] = "N";
				} 
				if(true && methodtrace.getGold3()!=null) {
				String Result=MajorityClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][MajorityClassLevelCallers].toString()); 
				MajorityClassLevelCallersClassGold3.UpdateCounters(Result, MajorityClassLevelCallersClassGold3);
				}if(methodtrace.getGold3()!=null && true && methodtrace.getGold3()!=null){
				String Result2=MajorityClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][MajorityClassLevelCallers].toString()); 
				MajorityClassLevelCallersClassGold3.UpdateCounters(Result2, MajorityClassLevelCallersClassGold3);
				}
				
				
				
				
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			//MAJORITY METHOD LEVEL CALLEES PREDICTION 

			
			//FIRST IF makes sure there is a mixture 
			if((CountMethodTCalleeGOLD3!=0 || CountMethodNCalleeGOLD3!=0 || CountMethodECalleeGOLD3!=0)/*||
					(CountMethodNCalleeGOLD3!=0 && CountMethodECalleeGOLD3!=0)
					||(CountMethodTCalleeGOLD3!=0 && CountMethodECalleeGOLD3!=0)*/) {
				if(CountMethodTCalleeGOLD3==CountMethodNCalleeGOLD3 && CountMethodTCalleeGOLD3>0) {
					data[j][MajorityMethodLevelCallees] = "T";
				}
				else if(CountMethodTCalleeGOLD3==0 && CountMethodNCalleeGOLD3==0 && CountMethodECalleeGOLD3>0) {
					data[j][MajorityMethodLevelCallees] = "E";
				}
				else if(CountMethodTCalleeGOLD3==0 && CountMethodNCalleeGOLD3>0 && CountMethodECalleeGOLD3>0) {
					data[j][MajorityMethodLevelCallees] = "N";
				} 
				
				else if(CountMethodTCalleeGOLD3>=CountMethodNCalleeGOLD3)
				 {
					data[j][MajorityMethodLevelCallees] = "T";
				}  else if (CountMethodNCalleeGOLD3 >= CountMethodTCalleeGOLD3
					
						) {
					data[j][MajorityMethodLevelCallees] = "N";
				}
			
				if(true && methodtrace.getGold3()!=null) {
				String Result=MajorityMethodLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][MajorityMethodLevelCallees].toString()); 
				MajorityMethodLevelCalleesClassGold3.UpdateCounters(Result, MajorityMethodLevelCalleesClassGold3);
				}
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//MAJORITY METHOD LEVEL CALLERS PREDICTION 
			
			//FIRST IF makes sure there is a mixture 
			if((CountMethodTGOLD3!=0 || CountMethodNGOLD3!=0|| CountMethodEGOLD3!=0 )/*||
					(CountMethodNGOLD3!=0 && CountMethodEGOLD3!=0)
					||(CountMethodTGOLD3!=0 && CountMethodEGOLD3!=0)*/) {
				
				if(CountMethodTGOLD3==CountMethodNGOLD3 && CountMethodTGOLD3>0) {
					data[j][MajorityMethodLevelCallers] = "T";
				}
				else if(CountMethodTGOLD3==0 && CountMethodNGOLD3==0 && CountMethodEGOLD3>0) {
					data[j][MajorityMethodLevelCallers] = "E";
				}
				else if(CountMethodTGOLD3==0 && CountMethodNGOLD3>0 && CountMethodEGOLD3>0) {
					data[j][MajorityMethodLevelCallers] = "N";
				}
				
				else if (CountMethodTGOLD3 >= CountMethodNGOLD3){
					data[j][MajorityMethodLevelCallers] = "T";
				}  else if (CountMethodNGOLD3 >= CountMethodTGOLD3
						
						) {
					data[j][MajorityMethodLevelCallers] = "N";
				}
				if(true && methodtrace.getGold3()!=null) {
				String Result=MajorityMethodLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][MajorityMethodLevelCallers].toString()); 
				MajorityMethodLevelCallersClassGold3.UpdateCounters(Result, MajorityMethodLevelCallersClassGold3);
				}
			}
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//1AT LEAST 1N PREDICTION CLASS LEVEL CALLERS 
			
			
				
				
				
				if (CounterTraceClassCallerNGOLD3 >=1 )
						 {
					data[j][AtLeast1NPredictionClassLevelCallers] = "N";
					Object var= 	data[j][AtLeast1NPredictionClassLevelCallers]; 
					String NEWVAR=var.toString(); 
					if(true && methodtrace.getGold3()!=null) {
					String Result=AtLeastNPredictionClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1NPredictionClassLevelCallers].toString()); 
					AtLeastNPredictionClassLevelCallersClassGold3.UpdateCounters(Result, AtLeastNPredictionClassLevelCallersClassGold3);
					}
				} 
			
				
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//2AT LEAST 1T PREDICTION CLASS LEVEL CALLERS 
			
			
				
				
				
				if (CounterTraceClassCallerTGOLD3 >=1 )
						 {
					data[j][AtLeast1TPredictionClassLevelCallers] = "T";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AtLeastTPredictionClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1TPredictionClassLevelCallers].toString()); 
					AtLeastTPredictionClassLevelCallersClassGold3.UpdateCounters(Result, AtLeastTPredictionClassLevelCallersClassGold3);
					}
				} 
				
					
				
			
			
	
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//3AT LEAST 1N PREDICTION CLASS LEVEL CALLEES 
		
			
				
				
				
				if (CounterTraceClassCalleeNGOLD3 >=1 )
						 {
					data[j][AtLeast1NPredictionClassLevelCallees] = "N";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AtLeastNPredictionClassLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1NPredictionClassLevelCallees].toString()); 
					AtLeastNPredictionClassLevelCalleesClassGold3.UpdateCounters(Result, AtLeastNPredictionClassLevelCalleesClassGold3);
					}
				} 
				
			
			
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
		
			//4AT LEAST 1T PREDICTION CLASS LEVEL CALLEES 
			
			
				
				
				
				if (CounterTraceClassCalleeTGOLD3 >=1 )
						 {
					data[j][AtLeast1TPredictionClassLevelCallees] = "T";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AtLeastTPredictionClassLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1TPredictionClassLevelCallees].toString()); 
					AtLeastTPredictionClassLevelCalleesClassGold3.UpdateCounters(Result, AtLeastTPredictionClassLevelCalleesClassGold3);
					}
				} 
				
				
			
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			//5AT LEAST 1N PREDICTION METHOD LEVEL CALLERS 
			
			
				
				
				if (CountMethodNGOLD3 >=1 )
						 {
					data[j][AtLeast1NPredictionMethodLevelCallers] = "N";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AtLeastNPredictionMethodLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1NPredictionMethodLevelCallers].toString()); 
					AtLeastNPredictionMethodLevelCallersClassGold3.UpdateCounters(Result, AtLeastNPredictionMethodLevelCallersClassGold3);
					}
				} 
				
				
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			//6AT LEAST 1T PREDICTION METHOD LEVEL CALLERS 
		
			
				
				
				
				if (CountMethodTGOLD3 >=1 )
						 {
					data[j][AtLeast1TPredictionMethodLevelCallers] = "T";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AtLeastTPredictionMethodLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1TPredictionMethodLevelCallers].toString()); 
					AtLeastTPredictionMethodLevelCallersClassGold3.UpdateCounters(Result, AtLeastTPredictionMethodLevelCallersClassGold3);
					}
				} 
				
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//7AT LEAST 1N PREDICTION METHOD LEVEL CALLEES 
			
			
				
				
				
				if (CountMethodNCalleeGOLD3 >=1 )
						 {
					data[j][AtLeast1NPredictionMethodLevelCallees] = "N";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AtLeastNPredictionMethodLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1NPredictionMethodLevelCallees].toString()); 
					AtLeastNPredictionMethodLevelCalleesClassGold3.UpdateCounters(Result, AtLeastNPredictionMethodLevelCalleesClassGold3);
					}
				} 
				
			
	
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//8AT LEAST 1T PREDICTION METHOD LEVEL CALLEES 
			
			
				
				
				
				if (CountMethodTCalleeGOLD3 >=1 )
						 {
					data[j][AtLeast1TPredictionMethodLevelCallees] = "T";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AtLeastTPredictionMethodLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1TPredictionMethodLevelCallees].toString()); 
					AtLeastTPredictionMethodLevelCalleesClassGold3.UpdateCounters(Result, AtLeastTPredictionMethodLevelCalleesClassGold3);
					}
					}
				 
				
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 2N PREDICTION CLASS LEVEL CALLEES 
				
				
					
					
					
					if (CounterTraceClassCalleeNGOLD3 >=2 )
							 {
						data[j][AtLeast2NPredictionClassLevelCallees] = "N";
						Object var= 	data[j][AtLeast2NPredictionClassLevelCallees]; 
						String NEWVAR=var.toString(); 
						if(true && methodtrace.getGold3()!=null) {
							String Result=AtLeast2NPredictionClassLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2NPredictionClassLevelCallees].toString()); 
							AtLeast2NPredictionClassLevelCalleesClassGold3.UpdateCounters(Result, AtLeast2NPredictionClassLevelCalleesClassGold3);
						}
					} 
				
					
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 2T PREDICTION CLASS LEVEL CALLEES 
				
				
					
					
					
					if (CounterTraceClassCalleeTGOLD3 >=2 )
					 {
				data[j][AtLeast2TPredictionClassLevelCallees] = "T";
				if(true && methodtrace.getGold3()!=null) {
				String Result=AtLeast2TPredictionClassLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2TPredictionClassLevelCallees].toString()); 
				AtLeast2TPredictionClassLevelCalleesClassGold3.UpdateCounters(Result, AtLeast2TPredictionClassLevelCalleesClassGold3);
				}
			} 
						
					
				
				
		
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 2N PREDICTION METHOD LEVEL CALLERS 
			
				
					
					
					
					
					if (CountMethodNGOLD3 >=2 )
							 {
						data[j][AtLeast2NPredictionMethodLevelCallers] = "N";
						if(true && methodtrace.getGold3()!=null) {
						String Result=AtLeast2NPredictionMethodLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2NPredictionMethodLevelCallers].toString()); 
						AtLeast2NPredictionMethodLevelCallersClassGold3.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCallersClassGold3);
						}
					} 
					
					
				
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
				
					//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
					
					
						
						
						
						if (CounterTraceClassCallerTGOLD3 >=2 )
						 {
					data[j][AtLeast2TPredictionClassLevelCallers] = "T";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AtLeast2TPredictionClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2TPredictionClassLevelCallers].toString()); 
					AtLeast2TPredictionClassLevelCallersClassGold3.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClassGold3);
					}
				} 
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
			
				//AT LEAST 2T PREDICTION METHOD LEVEL CALLERS 
				
				
					
					
					
					if (CountMethodTGOLD3 >=2 )
					 {
				data[j][AtLeast2TPredictionMethodLevelCallers] = "T";
				if(true && methodtrace.getGold3()!=null) {
				String Result=AtLeast2TPredictionMethodLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2TPredictionMethodLevelCallers].toString()); 
				AtLeast2TPredictionMethodLevelCallersClassGold3.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClassGold3);
				}
			} 
					
					
				
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				//AT LEAST 2N PREDICTION METHOD LEVEL CALLEES 

					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				
					
					
					if (CountMethodNCalleeGOLD3 >=2 )
					 {
				data[j][AtLeast2NPredictionMethodLevelCallees] = "N";
				if(true && methodtrace.getGold3()!=null) {
				String Result=AtLeast2NPredictionMethodLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2NPredictionMethodLevelCallees].toString()); 
				AtLeast2NPredictionMethodLevelCalleesClassGold3.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCalleesClassGold3);
				}	
			} 
					
					
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				//AT LEAST 2T PREDICTION METHOD LEVEL CALLEES 
			
				
					
					
					
					if (CountMethodTCalleeGOLD3 >=2 )
					 {
				data[j][AtLeast2TPredictionMethodLevelCallees] = "T";
				if(true && methodtrace.getGold3()!=null) {
					String Result=AtLeast2TPredictionMethodLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2TPredictionMethodLevelCallees].toString()); 
					AtLeast2TPredictionMethodLevelCalleesClassGold3.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCalleesClassGold3);

				}
				
			} 
					
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 2N PREDICTION CLASS LEVEL CALLERS 
				
				
					
					
					
					if (CounterTraceClassCallerNGOLD3 >=2 )
					 {
				data[j][AtLeast2NPredictionClassLevelCallers] = "N";
				if(true && methodtrace.getGold3()!=null) {
				String Result=AtLeast2NPredictionClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2NPredictionClassLevelCallers].toString()); 
				AtLeast2NPredictionClassLevelCallersClassGold3.UpdateCounters(Result, AtLeast2NPredictionClassLevelCallersClassGold3);
				
				}
			} 
			
				
		
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
				
				
					
					
					
					if (CounterTraceClassCallerTGOLD3 >=2 )
					 {
				data[j][AtLeast2TPredictionClassLevelCallers] = "T";
				if(true && methodtrace.getGold3()!=null) {
					String Result=AtLeast2TPredictionClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2TPredictionClassLevelCallers].toString()); 
					AtLeast2TPredictionClassLevelCallersClassGold3.UpdateCounters(Result, AtLeast2TPredictionClassLevelCallersClassGold3);

				}
				
				}
					
					
					
					
					
					
					
					
					
					
					
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/	 
			//ALL T METHOD LEVEL CALLEES 
			
			
			if(CountMethodNCalleeGOLD3==0 && CountMethodECalleeGOLD3==0 && CountMethodTCalleeGOLD3>=1) {
				
				
				
					
					data[j][AllTMethodLevelCallees] = "T";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AllTMethodLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTMethodLevelCallees].toString()); 
					AllTMethodLevelCalleesClassGold3.UpdateCounters(Result, AllTMethodLevelCalleesClassGold3);
					}
			}
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL T METHOD LEVEL CALLERS 
			
			if(CountMethodNGOLD3==0 && CountMethodEGOLD3==0  && CountMethodTGOLD3>=1) {
				
				
				
			
					data[j][AllTMethodLevelCallers] = "T";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AllTMethodLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTMethodLevelCallers].toString()); 
					AllTMethodLevelCallersClassGold3.UpdateCounters(Result, AllTMethodLevelCallersClassGold3);
					
					}
				
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL T CLASS LEVEL CALLERS 
			
			
			if(CounterTraceClassCallerEGOLD3==0 && CounterTraceClassCallerNGOLD3==0 && CounterTraceClassCallerTGOLD3>=1) {
				
				
			
					data[j][AllTClassLevelCallers] = "T";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AllTClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTClassLevelCallers].toString()); 
					AllTClassLevelCallersClassGold3.UpdateCounters(Result, AllTClassLevelCallersClassGold3);
					System.out.println(AllTClassLevelCallersClassGold3.toString());
			
					
					
					
						
					
					
					}
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL T CLASS LEVEL CALLEES 
			
			
			if(CounterTraceClassCalleeEGOLD3==0 && CounterTraceClassCalleeNGOLD3==0 && CounterTraceClassCalleeTGOLD3>=1) {
				
				
				
			
					data[j][AllTClassLevelCallees] = "T";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AllTClassLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTClassLevelCallees].toString()); 
					AllTClassLevelCalleesClassGold3.UpdateCounters(Result, AllTClassLevelCalleesClassGold3);
			
					
					
					
					
					}
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL N CLASS LEVEL CALLERS 
			
			
			if(CounterTraceClassCallerTGOLD3==0 && CounterTraceClassCallerEGOLD3==0 && CounterTraceClassCallerNGOLD3>=1) {
				
				
				
			
					data[j][AllNClassLevelCallers] = "N";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AllNClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNClassLevelCallers].toString()); 
					AllNClassLevelCallersClassGold3.UpdateCounters(Result, AllNClassLevelCallersClassGold3);
					
					}
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL N CLASS LEVEL CALLEES 
			
			
			if(CounterTraceClassCalleeTGOLD3==0 && CounterTraceClassCalleeEGOLD3==0 && CounterTraceClassCalleeNGOLD3>=1) {
				
				
				
			
					data[j][AllNClassLevelCallees] = "N";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AllNClassLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNClassLevelCallees].toString()); 
					AllNClassLevelCalleesClassGold3.UpdateCounters(Result, AllNClassLevelCalleesClassGold3);
					
					}
				
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL N METHOD LEVEL CALLERS 
			
			
			if(CountMethodTGOLD3==0 && CountMethodEGOLD3==0 && CountMethodNGOLD3>=1) {
				
				
				
			
					data[j][AllNMethodLevelCallers] = "N";
					if(true && methodtrace.getGold3()!=null) {
					String Result=AllNMethodLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNMethodLevelCallers].toString()); 
					AllNMethodLevelCallersClassGold3.UpdateCounters(Result, AllNMethodLevelCallersClassGold3);
					
					}
			}
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL N METHOD LEVEL CALLEES 
			
			
			if(CountMethodTCalleeGOLD3==0 && CountMethodECalleeGOLD3==0 && CountMethodNCalleeGOLD3>=1) {
				
				
				
			
					data[j][AllNMethodLevelCallees] = "N";
					if(true && methodtrace.getGold3()!=null) {
						String Result=AllNMethodLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNMethodLevelCallees].toString()); 
						AllNMethodLevelCalleesClassGold3.UpdateCounters(Result, AllNMethodLevelCalleesClassGold3);
					}
				
					
			}
			
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL N METHOD LEVEL CALLERS CALLEES 
			
			
		
				
				if(CountMethodTCalleeGOLD3==0 && CountMethodECalleeGOLD3==0 && CountMethodNCalleeGOLD3>=1 && CountMethodNGOLD3>=1) {
				
			
					data[j][AllNMethodLevelCallersCallees] = "N";
					if(true && methodtrace.getGold3()!=null) {
						String Result=AllTMethodLevelCallersCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNMethodLevelCallersCallees].toString()); 
						AllTMethodLevelCallersCalleesClassGold3.UpdateCounters(Result, AllTMethodLevelCallersCalleesClassGold3);
					}
				
					
			}
		//}
				
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL T METHOD LEVEL CALLERS CALLEES 
				
				
			
					
					if(CountMethodTGOLD3==0 && CountMethodEGOLD3==0 && CountMethodTCalleeGOLD3>=1 && CountMethodTGOLD3>=1) {
					
				
						data[j][AllTMethodLevelCallersCallees] = "T";
						if(true && methodtrace.getGold3()!=null) {
							String Result=AllTMethodLevelCallersCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTMethodLevelCallersCallees].toString()); 
							AllTMethodLevelCallersCalleesClassGold3.UpdateCounters(Result, AllTMethodLevelCallersCalleesClassGold3);
						}
					
						
				}
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//ALL N CLASS LEVEL CALLERS CALLEES 
					
					
				
						
						if(CountMethodTCalleeGOLD3==0 && CountMethodECalleeGOLD3==0 && CounterTraceClassCalleeNGOLD3>=1 && CounterTraceClassCallerNGOLD3>=1) {
						
					
							data[j][AllNMethodLevelCallersCallees] = "N";
							if(true && methodtrace.getGold3()!=null) {
								String Result=AllTMethodLevelCallersCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNMethodLevelCallersCallees].toString()); 
								AllTMethodLevelCallersCalleesClassGold3.UpdateCounters(Result, AllTMethodLevelCallersCalleesClassGold3);
							}
						
							
					}
				//}
						
						
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						
						//ALL T CLASS LEVEL CALLERS CALLEES 
						
						
					
							
							if(CountMethodTGOLD3==0 && CountMethodEGOLD3==0 && CounterTraceClassCalleeTGOLD3>=1 && CounterTraceClassCallerTGOLD3>=1) {
							
						
								data[j][AllTMethodLevelCallersCallees] = "T";
								if(true && methodtrace.getGold3()!=null) {
									String Result=AllTMethodLevelCallersCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTMethodLevelCallersCallees].toString()); 
									AllTMethodLevelCallersCalleesClassGold3.UpdateCounters(Result, AllTMethodLevelCallersCalleesClassGold3);
								}
							
								
						}
			
			
			
			
			
			
			
			
			
			
			
							
							
							
							
							
							
							
							
							
							
							
							

							//MAJORITY PARAMETER PREDICTION 

							if((counterParameterTGOLD4!=0 || counterParameterNGOLD4!=0|| counterParameterEGOLD4!=0)
									/*	||
										(CounterTraceClassCallerN!=0 && CounterTraceClassCallerE!=0)
										||(CounterTraceClassCallerT!=0 && CounterTraceClassCallerE!=0)*/
										) {
									
									if(counterParameterTGOLD4==counterParameterNGOLD4 && counterParameterTGOLD4>0) {
										data[j][MajorityParameters] = "T";
									}
									else if(counterParameterTGOLD4==0 && counterParameterNGOLD4==0 && counterParameterEGOLD4>0) {
										data[j][MajorityParameters] = "E";
									}
									else if(counterParameterTGOLD4==0 && counterParameterNGOLD4>0 && counterParameterEGOLD4>0) {
										data[j][MajorityParameters] = "N";
									}
									else if (((counterParameterTGOLD4 >= counterParameterNGOLD4
										//	&& counterParameterNGOLD4 >= counterParameterEGOLD4
											)
											//|| (counterParameterTGOLD4 >= counterParameterEGOLD4
												//	&& counterParameterEGOLD4 >= counterParameterNGOLD4
											//		)
											)
											) {
										data[j][MajorityParameters] = "T";
									}/* else if (((counterParameterEGOLD4 >= counterParameterNGOLD4
											&& counterParameterNGOLD4 >= counterParameterTGOLD4)
											|| (counterParameterEGOLD4 >= counterParameterTGOLD4
													&& counterParameterTGOLD4 >= counterParameterNGOLD4))
										) {
										data[j][MajorityParameters] = "E";
									} */else if ((counterParameterNGOLD4 >= counterParameterTGOLD4)) {
										data[j][MajorityParameters] = "N";
									}
									if(true && methodtrace.getGold4()!=null) {
										String Result=MajorityParametersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][MajorityParameters].toString()); 
										MajorityParametersClassGold4.UpdateCounters(Result, MajorityParametersClassGold4);
									}
									
								
									
								
								}
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							//AT LEAST 1N PREDICTION PARAMETER
							
							
							
							
							
							if (counterParameterNGOLD4 >=1 )
									 {
								data[j][AtLeast1NParameter] = "N";
								if(true && methodtrace.getGold4()!=null) {
								String Result=AtLeast1NParameterClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1NParameter].toString()); 
								AtLeast1NParameterClassGold4.UpdateCounters(Result, AtLeast1NParameterClassGold4);
								}
								
							} 
						
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							//AT LEAST 2N PREDICTION PARAMETER
							
							
							
							
							
							if (counterParameterNGOLD4 >=2 )
									 {
								data[j][AtLeast2NParameter] = "N";
								if(true && methodtrace.getGold4()!=null) {
									
									String Result=AtLeast2NParameterClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2NParameter].toString()); 
								AtLeast2NParameterClassGold4.UpdateCounters(Result, AtLeast2NParameterClassGold4);
								}
								
							} 
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						
						//AT LEAST 1T PREDICTION PARAMETER
						
						
							
							
							
							if (counterParameterTGOLD4 >=1 )
									 {
								data[j][AtLeast1TParameter] = "T";
								if(true && methodtrace.getGold4()!=null) {
								String Result=AtLeast1TParameterClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1TParameter].toString()); 
								AtLeast1TParameterClassGold4.UpdateCounters(Result, AtLeast1TParameterClassGold4);
								}
							} 
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//AT LEAST 2T PREDICTION PARAMETER
							
							
								
								
								
								if (counterParameterTGOLD4 >=2 )
										 {
									data[j][AtLeast2TParameter] = "T";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AtLeast2TParameterClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2TParameter].toString()); 
									AtLeast2TParameterClassGold4.UpdateCounters(Result, AtLeast2TParameterClassGold4);
									}
								} 
							/**************************************************************************************************************/
							/**************************************************************************************************************/
						    /**************************************************************************************************************/	
							
							
							
							//ALL T PARAMETER PREDICTION
							
							
							if(counterParameterEGOLD4==0 && counterParameterNGOLD4==0 && counterParameterTGOLD4>=1) {
								
								
								
							
									data[j][AllTParameters] = "T";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AllTParameterClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTParameters].toString()); 
									AllTParameterClassGold4.UpdateCounters(Result, AllTParameterClassGold4);
									}
									
									
							}
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//ALL N PARAMETER PREDICTION
							
							
							if(counterParameterTGOLD4==0 && counterParameterEGOLD4==0 && counterParameterNGOLD4>=1) {
								
								
								
							
									data[j][AllNParameters] = "N";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AllNParameterClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNParameters].toString()); 
									AllNParameterClassGold4.UpdateCounters(Result, AllNParameterClassGold4);
									}
							}
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							//MAJORITY CLASS LEVEL CALLEES PREDICTION 

							//FIRST IF makes sure there is a mixture 
							if((CounterTraceClassCalleeTGOLD4!=0 || CounterTraceClassCalleeNGOLD4!=0 || CounterTraceClassCalleeEGOLD4!=0)
								/*	||
									(CounterTraceClassCallerNGOLD4!=0 && CounterTraceClassCallerEGOLD4!=0)
									||(CounterTraceClassCallerTGOLD4!=0 && CounterTraceClassCallerEGOLD4!=0)*/
									) {
								
								if(CounterTraceClassCalleeTGOLD4==CounterTraceClassCalleeNGOLD4 && CounterTraceClassCalleeTGOLD4>0) {
									data[j][MajorityClassLevelCallees] = "T";
								}
								else if(CounterTraceClassCalleeTGOLD4==0 && CounterTraceClassCalleeNGOLD4==0 && CounterTraceClassCalleeEGOLD4>0) {
									data[j][MajorityClassLevelCallees] = "E";
								}
								else if(CounterTraceClassCalleeTGOLD4==0 && CounterTraceClassCalleeNGOLD4>0 && CounterTraceClassCalleeEGOLD4>0) {
									data[j][MajorityClassLevelCallees] = "N";
								}
								else if ((CounterTraceClassCalleeTGOLD4 >= CounterTraceClassCalleeNGOLD4
										)
										) {
									data[j][MajorityClassLevelCallees] = "T";
								} /*else if (((CounterTraceClassCallerEGOLD4 >= CounterTraceClassCallerNGOLD4
										&& CounterTraceClassCallerNGOLD4 >= CounterTraceClassCallerTGOLD4)
										|| (CounterTraceClassCallerEGOLD4 >= CounterTraceClassCallerTGOLD4
												&& CounterTraceClassCallerTGOLD4 >= CounterTraceClassCallerNGOLD4))
									) {
									data[j][MajorityClassLevelCallees] = "E";
								}*/ else if (CounterTraceClassCalleeNGOLD4 >= CounterTraceClassCalleeTGOLD4) {
									data[j][MajorityClassLevelCallees] = "N";
								}
								if(true && methodtrace.getGold4()!=null) {
								String Result=MajorityClassLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][MajorityClassLevelCallees].toString()); 
								MajorityClassLevelCalleesClassGold4.UpdateCounters(Result, MajorityClassLevelCalleesClassGold4);
								}
							}
						
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//MAJORITY CLASS LEVEL CALLERS PREDICTION 

							//FIRST IF makes sure there is a mixture 
							if((CounterTraceClassCallerTGOLD4!=0 || CounterTraceClassCallerNGOLD4!=0 ||CounterTraceClassCallerEGOLD4!=0)
									/*||
									(CounterTraceClassCalleeNGOLD4!=0 && CounterTraceClassCalleeEGOLD4!=0)
									||(CounterTraceClassCalleeTGOLD4!=0 && CounterTraceClassCalleeEGOLD4!=0)*/) {
								
								if(CounterTraceClassCallerTGOLD4==CounterTraceClassCallerNGOLD4 && CounterTraceClassCallerTGOLD4>0) {
									data[j][MajorityClassLevelCallers] = "T";
								}
								else if(CounterTraceClassCallerTGOLD4==0 && CounterTraceClassCallerNGOLD4==0 && CounterTraceClassCallerEGOLD4>0) {
									data[j][MajorityClassLevelCallers] = "E";
								}
								else if(CounterTraceClassCallerTGOLD4==0 && CounterTraceClassCallerNGOLD4>0 && CounterTraceClassCallerEGOLD4>0) {
									data[j][MajorityClassLevelCallers] = "N";
								}
								else if(CounterTraceClassCallerTGOLD4==0 && CounterTraceClassCallerNGOLD4>0 && CounterTraceClassCallerEGOLD4>0) {
									data[j][MajorityClassLevelCallers] = "E";
								}
								else if (CounterTraceClassCallerTGOLD4 >= CounterTraceClassCallerNGOLD4) {
									data[j][MajorityClassLevelCallers] = "T";
								} else if (CounterTraceClassCallerNGOLD4>=CounterTraceClassCallerTGOLD4)
									 {
									data[j][MajorityClassLevelCallers] = "N";
								} 
								if(true && methodtrace.getGold4()!=null) {
								String Result=MajorityClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][MajorityClassLevelCallers].toString()); 
								MajorityClassLevelCallersClassGold4.UpdateCounters(Result, MajorityClassLevelCallersClassGold4);
								}if(methodtrace.getGold4()!=null && true && methodtrace.getGold4()!=null){
								String Result2=MajorityClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][MajorityClassLevelCallers].toString()); 
								MajorityClassLevelCallersClassGold4.UpdateCounters(Result2, MajorityClassLevelCallersClassGold4);
								}
								
								
								
								
							}
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							//MAJORITY METHOD LEVEL CALLEES PREDICTION 

							
							//FIRST IF makes sure there is a mixture 
							if((CountMethodTCalleeGOLD4!=0 || CountMethodNCalleeGOLD4!=0 || CountMethodECalleeGOLD4!=0)/*||
									(CountMethodNCalleeGOLD4!=0 && CountMethodECalleeGOLD4!=0)
									||(CountMethodTCalleeGOLD4!=0 && CountMethodECalleeGOLD4!=0)*/) {
								if(CountMethodTCalleeGOLD4==CountMethodNCalleeGOLD4 && CountMethodTCalleeGOLD4>0) {
									data[j][MajorityMethodLevelCallees] = "T";
								}
								else if(CountMethodTCalleeGOLD4==0 && CountMethodNCalleeGOLD4==0 && CountMethodECalleeGOLD4>0) {
									data[j][MajorityMethodLevelCallees] = "E";
								}
								else if(CountMethodTCalleeGOLD4==0 && CountMethodNCalleeGOLD4>0 && CountMethodECalleeGOLD4>0) {
									data[j][MajorityMethodLevelCallees] = "N";
								} 
								
								else if(CountMethodTCalleeGOLD4>=CountMethodNCalleeGOLD4)
								 {
									data[j][MajorityMethodLevelCallees] = "T";
								}  else if (CountMethodNCalleeGOLD4 >= CountMethodTCalleeGOLD4
									
										) {
									data[j][MajorityMethodLevelCallees] = "N";
								}
							
								if(true && methodtrace.getGold4()!=null) {
								String Result=MajorityMethodLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][MajorityMethodLevelCallees].toString()); 
								MajorityMethodLevelCalleesClassGold4.UpdateCounters(Result, MajorityMethodLevelCalleesClassGold4);
								}
							}
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//MAJORITY METHOD LEVEL CALLERS PREDICTION 
							
							//FIRST IF makes sure there is a mixture 
							if((CountMethodTGOLD4!=0 || CountMethodNGOLD4!=0|| CountMethodEGOLD4!=0 )/*||
									(CountMethodNGOLD4!=0 && CountMethodEGOLD4!=0)
									||(CountMethodTGOLD4!=0 && CountMethodEGOLD4!=0)*/) {
								
								if(CountMethodTGOLD4==CountMethodNGOLD4 && CountMethodTGOLD4>0) {
									data[j][MajorityMethodLevelCallers] = "T";
								}
								else if(CountMethodTGOLD4==0 && CountMethodNGOLD4==0 && CountMethodEGOLD4>0) {
									data[j][MajorityMethodLevelCallers] = "E";
								}
								else if(CountMethodTGOLD4==0 && CountMethodNGOLD4>0 && CountMethodEGOLD4>0) {
									data[j][MajorityMethodLevelCallers] = "N";
								}
								
								else if (CountMethodTGOLD4 >= CountMethodNGOLD4){
									data[j][MajorityMethodLevelCallers] = "T";
								}  else if (CountMethodNGOLD4 >= CountMethodTGOLD4
										
										) {
									data[j][MajorityMethodLevelCallers] = "N";
								}
								if(true && methodtrace.getGold4()!=null) {
								String Result=MajorityMethodLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][MajorityMethodLevelCallers].toString()); 
								MajorityMethodLevelCallersClassGold4.UpdateCounters(Result, MajorityMethodLevelCallersClassGold4);
								}
							}
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//1AT LEAST 1N PREDICTION CLASS LEVEL CALLERS 
							
							
								
								
								
								if (CounterTraceClassCallerNGOLD4 >=1 )
										 {
									data[j][AtLeast1NPredictionClassLevelCallers] = "N";
									Object var= 	data[j][AtLeast1NPredictionClassLevelCallers]; 
									String NEWVAR=var.toString(); 
									if(true && methodtrace.getGold4()!=null) {
									String Result=AtLeastNPredictionClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1NPredictionClassLevelCallers].toString()); 
									AtLeastNPredictionClassLevelCallersClassGold4.UpdateCounters(Result, AtLeastNPredictionClassLevelCallersClassGold4);
									}
								} 
							
								
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//2AT LEAST 1T PREDICTION CLASS LEVEL CALLERS 
							
							
								
								
								
								if (CounterTraceClassCallerTGOLD4 >=1 )
										 {
									data[j][AtLeast1TPredictionClassLevelCallers] = "T";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AtLeastTPredictionClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1TPredictionClassLevelCallers].toString()); 
									AtLeastTPredictionClassLevelCallersClassGold4.UpdateCounters(Result, AtLeastTPredictionClassLevelCallersClassGold4);
									}
								} 
								
									
								
							
							
					
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//3AT LEAST 1N PREDICTION CLASS LEVEL CALLEES 
						
							
								
								
								
								if (CounterTraceClassCalleeNGOLD4 >=1 )
										 {
									data[j][AtLeast1NPredictionClassLevelCallees] = "N";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AtLeastNPredictionClassLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1NPredictionClassLevelCallees].toString()); 
									AtLeastNPredictionClassLevelCalleesClassGold4.UpdateCounters(Result, AtLeastNPredictionClassLevelCalleesClassGold4);
									}
								} 
								
							
							
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
						
							//4AT LEAST 1T PREDICTION CLASS LEVEL CALLEES 
							
							
								
								
								
								if (CounterTraceClassCalleeTGOLD4 >=1 )
										 {
									data[j][AtLeast1TPredictionClassLevelCallees] = "T";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AtLeastTPredictionClassLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1TPredictionClassLevelCallees].toString()); 
									AtLeastTPredictionClassLevelCalleesClassGold4.UpdateCounters(Result, AtLeastTPredictionClassLevelCalleesClassGold4);
									}
								} 
								
								
							
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							//5AT LEAST 1N PREDICTION METHOD LEVEL CALLERS 
							
							
								
								
								if (CountMethodNGOLD4 >=1 )
										 {
									data[j][AtLeast1NPredictionMethodLevelCallers] = "N";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AtLeastNPredictionMethodLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1NPredictionMethodLevelCallers].toString()); 
									AtLeastNPredictionMethodLevelCallersClassGold4.UpdateCounters(Result, AtLeastNPredictionMethodLevelCallersClassGold4);
									}
								} 
								
								
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							//6AT LEAST 1T PREDICTION METHOD LEVEL CALLERS 
						
							
								
								
								
								if (CountMethodTGOLD4 >=1 )
										 {
									data[j][AtLeast1TPredictionMethodLevelCallers] = "T";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AtLeastTPredictionMethodLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1TPredictionMethodLevelCallers].toString()); 
									AtLeastTPredictionMethodLevelCallersClassGold4.UpdateCounters(Result, AtLeastTPredictionMethodLevelCallersClassGold4);
									}
								} 
								
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//7AT LEAST 1N PREDICTION METHOD LEVEL CALLEES 
							
							
								
								
								
								if (CountMethodNCalleeGOLD4 >=1 )
										 {
									data[j][AtLeast1NPredictionMethodLevelCallees] = "N";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AtLeastNPredictionMethodLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1NPredictionMethodLevelCallees].toString()); 
									AtLeastNPredictionMethodLevelCalleesClassGold4.UpdateCounters(Result, AtLeastNPredictionMethodLevelCalleesClassGold4);
									}
								} 
								
							
					
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//8AT LEAST 1T PREDICTION METHOD LEVEL CALLEES 
							
							
								
								
								
								if (CountMethodTCalleeGOLD4 >=1 )
										 {
									data[j][AtLeast1TPredictionMethodLevelCallees] = "T";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AtLeastTPredictionMethodLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1TPredictionMethodLevelCallees].toString()); 
									AtLeastTPredictionMethodLevelCalleesClassGold4.UpdateCounters(Result, AtLeastTPredictionMethodLevelCalleesClassGold4);
									}
									}
								 
								
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//AT LEAST 2N PREDICTION CLASS LEVEL CALLEES 
								
								
									
									
									
									if (CounterTraceClassCalleeNGOLD4 >=2 )
											 {
										data[j][AtLeast2NPredictionClassLevelCallees] = "N";
										Object var= 	data[j][AtLeast2NPredictionClassLevelCallees]; 
										String NEWVAR=var.toString(); 
										if(true && methodtrace.getGold4()!=null) {
											String Result=AtLeast2NPredictionClassLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2NPredictionClassLevelCallees].toString()); 
											AtLeast2NPredictionClassLevelCalleesClassGold4.UpdateCounters(Result, AtLeast2NPredictionClassLevelCalleesClassGold4);
										}
									} 
								
									
								
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//AT LEAST 2T PREDICTION CLASS LEVEL CALLEES 
								
								
									
									
									
									if (CounterTraceClassCalleeTGOLD4 >=2 )
									 {
								data[j][AtLeast2TPredictionClassLevelCallees] = "T";
								if(true && methodtrace.getGold4()!=null) {
								String Result=AtLeast2TPredictionClassLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2TPredictionClassLevelCallees].toString()); 
								AtLeast2TPredictionClassLevelCalleesClassGold4.UpdateCounters(Result, AtLeast2TPredictionClassLevelCalleesClassGold4);
								}
							} 
										
									
								
								
						
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//AT LEAST 2N PREDICTION METHOD LEVEL CALLERS 
							
								
									
									
									
									
									if (CountMethodNGOLD4 >=2 )
											 {
										data[j][AtLeast2NPredictionMethodLevelCallers] = "N";
										if(true && methodtrace.getGold4()!=null) {
										String Result=AtLeast2NPredictionMethodLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2NPredictionMethodLevelCallers].toString()); 
										AtLeast2NPredictionMethodLevelCallersClassGold4.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCallersClassGold4);
										}
									} 
									
									
								
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
								
									//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
									
									
										
										
										
										if (CounterTraceClassCallerTGOLD4 >=2 )
										 {
									data[j][AtLeast2TPredictionClassLevelCallers] = "T";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AtLeast2TPredictionClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2TPredictionClassLevelCallers].toString()); 
									AtLeast2TPredictionClassLevelCallersClassGold4.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClassGold4);
									}
								} 
								
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
							
								//AT LEAST 2T PREDICTION METHOD LEVEL CALLERS 
								
								
									
									
									
									if (CountMethodTGOLD4 >=2 )
									 {
								data[j][AtLeast2TPredictionMethodLevelCallers] = "T";
								if(true && methodtrace.getGold4()!=null) {
								String Result=AtLeast2TPredictionMethodLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2TPredictionMethodLevelCallers].toString()); 
								AtLeast2TPredictionMethodLevelCallersClassGold4.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClassGold4);
								}
							} 
									
									
								
								
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								//AT LEAST 2N PREDICTION METHOD LEVEL CALLEES 

									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
								
									
									
									if (CountMethodNCalleeGOLD4 >=2 )
									 {
								data[j][AtLeast2NPredictionMethodLevelCallees] = "N";
								if(true && methodtrace.getGold4()!=null) {
								String Result=AtLeast2NPredictionMethodLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2NPredictionMethodLevelCallees].toString()); 
								AtLeast2NPredictionMethodLevelCalleesClassGold4.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCalleesClassGold4);
								}	
							} 
									
									
								
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								//AT LEAST 2T PREDICTION METHOD LEVEL CALLEES 
							
								
									
									
									
									if (CountMethodTCalleeGOLD4 >=2 )
									 {
								data[j][AtLeast2TPredictionMethodLevelCallees] = "T";
								if(true && methodtrace.getGold4()!=null) {
									String Result=AtLeast2TPredictionMethodLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2TPredictionMethodLevelCallees].toString()); 
									AtLeast2TPredictionMethodLevelCalleesClassGold4.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCalleesClassGold4);

								}
								
							} 
									
								
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//AT LEAST 2N PREDICTION CLASS LEVEL CALLERS 
								
								
									
									
									
									if (CounterTraceClassCallerNGOLD4 >=2 )
									 {
								data[j][AtLeast2NPredictionClassLevelCallers] = "N";
								if(true && methodtrace.getGold4()!=null) {
								String Result=AtLeast2NPredictionClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2NPredictionClassLevelCallers].toString()); 
								AtLeast2NPredictionClassLevelCallersClassGold4.UpdateCounters(Result, AtLeast2NPredictionClassLevelCallersClassGold4);
								
								}
							} 
							
								
						
								
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
								
								
									
									
									
									if (CounterTraceClassCallerTGOLD4 >=2 )
									 {
								data[j][AtLeast2TPredictionClassLevelCallers] = "T";
								if(true && methodtrace.getGold4()!=null) {
									String Result=AtLeast2TPredictionClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2TPredictionClassLevelCallers].toString()); 
									AtLeast2TPredictionClassLevelCallersClassGold4.UpdateCounters(Result, AtLeast2TPredictionClassLevelCallersClassGold4);

								}
								
								}
									
									
									
									
									
									
									
									
									
									
									
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/	 
							//ALL T METHOD LEVEL CALLEES 
							
							
							if(CountMethodNCalleeGOLD4==0 && CountMethodECalleeGOLD4==0 && CountMethodTCalleeGOLD4>=4) {
								
								
								
									
									data[j][AllTMethodLevelCallees] = "T";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AllTMethodLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTMethodLevelCallees].toString()); 
									AllTMethodLevelCalleesClassGold4.UpdateCounters(Result, AllTMethodLevelCalleesClassGold4);
									}
							}
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//ALL T METHOD LEVEL CALLERS 
							
							if(CountMethodNGOLD4==0 && CountMethodEGOLD4==0  && CountMethodTGOLD4>=7) {
								
								
								
							
									data[j][AllTMethodLevelCallers] = "T";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AllTMethodLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTMethodLevelCallers].toString()); 
									AllTMethodLevelCallersClassGold4.UpdateCounters(Result, AllTMethodLevelCallersClassGold4);
									
									}
								
							}
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//ALL T CLASS LEVEL CALLERS 
							
							
							if(CounterTraceClassCallerEGOLD4==0 && CounterTraceClassCallerNGOLD4==0 && CounterTraceClassCallerTGOLD4>=4) {
								
								
							
									data[j][AllTClassLevelCallers] = "T";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AllTClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTClassLevelCallers].toString()); 
									AllTClassLevelCallersClassGold4.UpdateCounters(Result, AllTClassLevelCallersClassGold4);
									System.out.println(AllTClassLevelCallersClassGold4.toString());
							
									
									
									
										
									
									
									}
							}
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//ALL T CLASS LEVEL CALLEES 
							
							
							if(CounterTraceClassCalleeEGOLD4==0 && CounterTraceClassCalleeNGOLD4==0 && CounterTraceClassCalleeTGOLD4>=4) {
								
								
								
							
									data[j][AllTClassLevelCallees] = "T";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AllTClassLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTClassLevelCallees].toString()); 
									AllTClassLevelCalleesClassGold4.UpdateCounters(Result, AllTClassLevelCalleesClassGold4);
							
									
									
									
									
									}
							}
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//ALL N CLASS LEVEL CALLERS 
							
							
							if(CounterTraceClassCallerTGOLD4==0 && CounterTraceClassCallerEGOLD4==0 && CounterTraceClassCallerNGOLD4>=4) {
								
								
								
							
									data[j][AllNClassLevelCallers] = "N";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AllNClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNClassLevelCallers].toString()); 
									AllNClassLevelCallersClassGold4.UpdateCounters(Result, AllNClassLevelCallersClassGold4);
									
									}
							}
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//ALL N CLASS LEVEL CALLEES 
							
							
							if(CounterTraceClassCalleeTGOLD4==0 && CounterTraceClassCalleeEGOLD4==0 && CounterTraceClassCalleeNGOLD4>=4) {
								
								
								
							
									data[j][AllNClassLevelCallees] = "N";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AllNClassLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNClassLevelCallees].toString()); 
									AllNClassLevelCalleesClassGold4.UpdateCounters(Result, AllNClassLevelCalleesClassGold4);
									
									}
								
							}
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//ALL N METHOD LEVEL CALLERS 
							
							
							if(CountMethodTGOLD4==0 && CountMethodEGOLD4==0 && CountMethodNGOLD4>=4) {
								
								
								
							
									data[j][AllNMethodLevelCallers] = "N";
									if(true && methodtrace.getGold4()!=null) {
									String Result=AllNMethodLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNMethodLevelCallers].toString()); 
									AllNMethodLevelCallersClassGold4.UpdateCounters(Result, AllNMethodLevelCallersClassGold4);
									
									}
							}
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//ALL N METHOD LEVEL CALLEES 
							
							
							if(CountMethodTCalleeGOLD4==0 && CountMethodECalleeGOLD4==0 && CountMethodNCalleeGOLD4>=4) {
								
								
								
							
									data[j][AllNMethodLevelCallees] = "N";
									if(true && methodtrace.getGold4()!=null) {
										String Result=AllNMethodLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNMethodLevelCallees].toString()); 
										AllNMethodLevelCalleesClassGold4.UpdateCounters(Result, AllNMethodLevelCalleesClassGold4);
									}
								
									
							}
							
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//ALL N METHOD LEVEL CALLERS CALLEES 
							
							
						
								
								if(CountMethodTCalleeGOLD4==0 && CountMethodECalleeGOLD4==0 && CountMethodNCalleeGOLD4>=3 && CountMethodNGOLD4>=3) {
								
							
									data[j][AllNMethodLevelCallersCallees] = "N";
									if(true && methodtrace.getGold4()!=null) {
										String Result=AllTMethodLevelCallersCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNMethodLevelCallersCallees].toString()); 
										AllTMethodLevelCallersCalleesClassGold4.UpdateCounters(Result, AllTMethodLevelCallersCalleesClassGold4);
									}
								
									
							}
						//}
								
								
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL T METHOD LEVEL CALLERS CALLEES 
								
								
							
									
									if(CountMethodTGOLD4==0 && CountMethodEGOLD4==0 && CountMethodTCalleeGOLD4>=3 && CountMethodTGOLD4>=3) {
									
								
										data[j][AllTMethodLevelCallersCallees] = "T";
										if(true && methodtrace.getGold4()!=null) {
											String Result=AllTMethodLevelCallersCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTMethodLevelCallersCallees].toString()); 
											AllTMethodLevelCallersCalleesClassGold4.UpdateCounters(Result, AllTMethodLevelCallersCalleesClassGold4);
										}
									
										
								}
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N CLASS LEVEL CALLERS CALLEES 
									
									
								
										
										if(CountMethodTCalleeGOLD4==0 && CountMethodECalleeGOLD4==0 && CounterTraceClassCalleeNGOLD4>=3 && CounterTraceClassCallerNGOLD4>=3) {
										
									
											data[j][AllNMethodLevelCallersCallees] = "N";
											if(true && methodtrace.getGold4()!=null) {
												String Result=AllTMethodLevelCallersCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNMethodLevelCallersCallees].toString()); 
												AllTMethodLevelCallersCalleesClassGold4.UpdateCounters(Result, AllTMethodLevelCallersCalleesClassGold4);
											}
										
											
									}
								//}
										
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										
										//ALL T CLASS LEVEL CALLERS CALLEES 
										
										
									
											
											if(CountMethodTGOLD4==0 && CountMethodEGOLD4==0 && CounterTraceClassCalleeTGOLD4>=3 && CounterTraceClassCallerTGOLD4>=3) {
											
										
												data[j][AllTMethodLevelCallersCallees] = "T";
												if(true && methodtrace.getGold4()!=null) {
													String Result=AllTMethodLevelCallersCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTMethodLevelCallersCallees].toString()); 
													AllTMethodLevelCallersCalleesClassGold4.UpdateCounters(Result, AllTMethodLevelCallersCalleesClassGold4);
												}
											
												
										}
							
							  
			
			
			
			
			
			
			
			
			//if(CountMethodTACHRAF>0 && CountMethodTACHRAFCallee>0) {
//									
//									
//									if(CountMethodNACHRAF+CountMethodNACHRAFCallee==0) {
//										if(methodtrace.getGold4()!=null) {
//											if(methodtrace.getGold4().trim().equals("T")) {
//												TracePureGold4++; 
//											}
//										}
//										
//										
//										
//										
//									} else {
//										TraceMixedGold4++; 
//									}
//									data[j][ACHRAFTRACE]="T"; 
//									if(methodtrace.getGold4()!=null) {
//									String Result=ACHRAFGold4Trace.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][ACHRAFTRACE].toString()); 
//									ACHRAFGold4Trace.UpdateCounters(Result, ACHRAFGold4Trace);	
//									}
//							}else if(CountMethodNACHRAF>0 && CountMethodNACHRAFCallee>0) {
//								
//								
//								if(CountMethodTACHRAF+CountMethodTACHRAFCallee==0) {
//									if(methodtrace.getGold4()!=null) {
//										if(methodtrace.getGold4().trim().equals("N")) {
//											NoTracePureGold4++; 
//										}
//									}
//								
//									
//							
//									
//								} else {
//									NoTraceMixedGold4++; 
//								}
//								data[j][ACHRAFNOTRACE]="N"; 
//								if(methodtrace.getGold4()!=null) {
//								String Result=ACHRAFGold4NOTrace.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][ACHRAFNOTRACE].toString()); 
//								ACHRAFGold4NOTrace.UpdateCounters(Result, ACHRAFGold4NOTrace);		
//								}
//						}else {
//							failGold4++; 
//						}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
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

			List<Method> callers = methodtrace.getCallersList();
			List<Method> callersmerged = new ArrayList<Method>();
			List<Method> callersExecuted = methodtrace.getCallersListExecuted();

			for (Method methrep : callers) {
				String methodname = methrep.getMethodname();
				if (methodname.contains("(")) {
					methodname = methodname.replaceAll("\\(.*\\)", "");
					methrep.setMethodname(methodname);
				}

			}
			for (Method caller : callers) {
				callersmerged.add(caller);
			}
			for (Method caller : callersExecuted) {
				callersmerged.add(caller);
			}

			
			List<Method> callees = methodtrace.getCalleesList();
			List<Method> calleesExecuted = methodtrace.getCalleesListExecuted();
			for (Method methrep : callees) {
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
		
		bwlog.write(AllTClassLevelCallersClass.toString()); 
		bwlog.newLine();
		bwlog.close(); 
		
		
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
		bw2.write("ALL T METHOD LEVEL CALLEES: "+AllTMethodLevelCalleesClass.toString()); 
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
		bw2.write("ALL T METHOD LEVEL CALLERS CALLEES: "+AllTMethodLevelCallersCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("ALL N METHOD LEVEL CALLERS CALLEES: "+AllNMethodLevelCallersCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("ALL T CLASS LEVEL CALLERS CALLEES: "+AllTClassLevelCallersCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("ALL N CLASS LEVEL CALLERS CALLEES: "+AllNClassLevelsCallersCalleesClass.toString()); 
		bw2.newLine();
		bw2.close();
		
		
		
		
		bwGold3.write("OWNER CLASS PREDICTION: "+OwnerClassPredictionClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("MAJORITY CLASS LEVEL CALLERS PREDICTION: "+MajorityClassLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("MAJORITY CLASS LEVEL CALLEES PREDICTION: "+MajorityClassLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("MAJORITY METHOD LEVEL CALLERS PREDICTION: "+MajorityMethodLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("MAJORITY METHOD LEVEL CALLEES PREDICTION: "+MajorityMethodLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 1 N PREDICTION CLASS LEVEL CALLERS: "+AtLeastNPredictionClassLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 1 N PREDICTION CLASS LEVEL CALLEES: "+AtLeastNPredictionClassLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 1 N PREDICTION METHOD LEVEL CALLERS: "+AtLeastNPredictionMethodLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 1 N PREDICTION METHOD LEVEL CALLEES: "+AtLeastNPredictionMethodLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 1 T PREDICTION CLASS LEVEL CALLERS: "+AtLeastTPredictionClassLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 1 T PREDICTION CLASS LEVEL CALLEES: "+AtLeastTPredictionClassLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 1 T PREDICTION METHOD LEVEL CALLERS: "+AtLeastTPredictionMethodLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 1 T PREDICTION METHOD LEVEL CALLEES: "+AtLeastTPredictionMethodLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 2 N PREDICTION CLASS LEVEL CALLERS: "+AtLeast2NPredictionClassLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 2 N PREDICTION CLASS LEVEL CALLEES: "+AtLeast2NPredictionClassLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 2 N PREDICTION METHOD LEVEL CALLERS: "+AtLeast2NPredictionMethodLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 2 N PREDICTION METHOD LEVEL CALLEES: "+AtLeast2NPredictionMethodLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 2 T PREDICTION CLASS LEVEL CALLERS: "+AtLeast2TPredictionClassLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 2 T PREDICTION CLASS LEVEL CALLEES: "+AtLeast2TPredictionClassLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 2 T PREDICTION METHOD LEVEL CALLERS: "+AtLeast2TPredictionMethodLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 2 T PREDICTION METHOD LEVEL CALLEES: "+AtLeast2TPredictionMethodLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL N CLASS LEVEL CALLERS: "+AllNClassLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL N CLASS LEVEL CALLEES: "+AllNClassLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL N METHOD LEVEL CALLERS: "+AllNMethodLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL N METHOD LEVEL CALLEES: "+AllNMethodLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL T METHOD LEVEL CALLEES: "+AllTMethodLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL T CLASS LEVEL CALLERS: "+AllTClassLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL T CLASS LEVEL CALLEES: "+AllTClassLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL T METHOD LEVEL CALLERS: "+AllTMethodLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("MAJORITY PARAMETERS CLASS: "+MajorityParametersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 1N PARAMETER CLASS: "+AtLeast1NParameterClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 1T PARAMETER CLASS: "+AtLeast1TParameterClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 2T PARAMETER CLASS: "+AtLeast2TParameterClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("AT LEAST 2N PARAMETER CLASS: "+AtLeast2NParameterClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL N PARAMETERS: "+AllNParameterClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL T PARAMETERS: "+AllTParameterClassGold3.toString()); 
		bwGold3.newLine();
		
		bwGold3.close();
		
		
		
		
		bwGold4.write("OWNER CLASS PREDICTION: "+OwnerClassPredictionClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("MAJORITY CLASS LEVEL CALLERS PREDICTION: "+MajorityClassLevelCallersClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("MAJORITY CLASS LEVEL CALLEES PREDICTION: "+MajorityClassLevelCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("MAJORITY METHOD LEVEL CALLERS PREDICTION: "+MajorityMethodLevelCallersClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("MAJORITY METHOD LEVEL CALLEES PREDICTION: "+MajorityMethodLevelCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 1 N PREDICTION CLASS LEVEL CALLERS: "+AtLeastNPredictionClassLevelCallersClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 1 N PREDICTION CLASS LEVEL CALLEES: "+AtLeastNPredictionClassLevelCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 1 N PREDICTION METHOD LEVEL CALLERS: "+AtLeastNPredictionMethodLevelCallersClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 1 N PREDICTION METHOD LEVEL CALLEES: "+AtLeastNPredictionMethodLevelCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 1 T PREDICTION CLASS LEVEL CALLERS: "+AtLeastTPredictionClassLevelCallersClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 1 T PREDICTION CLASS LEVEL CALLEES: "+AtLeastTPredictionClassLevelCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 1 T PREDICTION METHOD LEVEL CALLERS: "+AtLeastTPredictionMethodLevelCallersClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 1 T PREDICTION METHOD LEVEL CALLEES: "+AtLeastTPredictionMethodLevelCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 2 N PREDICTION CLASS LEVEL CALLERS: "+AtLeast2NPredictionClassLevelCallersClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 2 N PREDICTION CLASS LEVEL CALLEES: "+AtLeast2NPredictionClassLevelCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 2 N PREDICTION METHOD LEVEL CALLERS: "+AtLeast2NPredictionMethodLevelCallersClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 2 N PREDICTION METHOD LEVEL CALLEES: "+AtLeast2NPredictionMethodLevelCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 2 T PREDICTION CLASS LEVEL CALLERS: "+AtLeast2TPredictionClassLevelCallersClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 2 T PREDICTION CLASS LEVEL CALLEES: "+AtLeast2TPredictionClassLevelCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 2 T PREDICTION METHOD LEVEL CALLERS: "+AtLeast2TPredictionMethodLevelCallersClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 2 T PREDICTION METHOD LEVEL CALLEES: "+AtLeast2TPredictionMethodLevelCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL N CLASS LEVEL CALLERS: "+AllNClassLevelCallersClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL N CLASS LEVEL CALLEES: "+AllNClassLevelCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL N METHOD LEVEL CALLERS: "+AllNMethodLevelCallersClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL N METHOD LEVEL CALLEES: "+AllNMethodLevelCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL T CLASS LEVEL CALLERS: "+AllTClassLevelCallersClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL T CLASS LEVEL CALLEES: "+AllTClassLevelCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL T METHOD LEVEL CALLERS: "+AllTMethodLevelCallersClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL T METHOD LEVEL CALLEES: "+AllTMethodLevelCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("MAJORITY PARAMETERS CLASS: "+MajorityParametersClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 1N PARAMETER CLASS: "+AtLeast1NParameterClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 1T PARAMETER CLASS: "+AtLeast1TParameterClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 2T PARAMETER CLASS: "+AtLeast2TParameterClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("AT LEAST 2N PARAMETER CLASS: "+AtLeast2NParameterClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL N PARAMETERS: "+AllNParameterClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL T PARAMETERS: "+AllTParameterClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL T METHOD LEVEL CALLERS CALLEES: "+AllTMethodLevelCallersCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL N METHOD LEVEL CALLERS CALLEES: "+AllNMethodLevelCallersCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL T CLASS LEVEL CALLERS CALLEES: "+AllTClassLevelCallersCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL N CLASS LEVEL CALLERS CALLEES: "+AllNClassLevelsCallersCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.close();
		bwGold4.close();
		
		
		
		
		
		
		
		
		
		
		
		
//		String[] columnNames = { "Row","MethodID", "MethodName", "RequirementID", "RequirementName", "ClassID", "ClassName",
//				"Gold", "Subject", "OwnerClass T", "Owner Class N", "Owner Class E", "# caller methods",
//				"# caller methods T", "#caller methods N", "#caller methods E", "# caller classes",
//				"# caller classes T", "#caller classes N", "#caller classes E", "# callee methods",
//				"# callee methods T", "#callee methods N", "#callee methods E", "# callee classes",
//				"# callee classes T", "#callee classes N", "#callee classes E",  "OwnerClassPrediction",
//				"MajorityClassLevelCallers","MajorityClassLevelCallees", "MajorityMethodLevelCallers","MajorityMethodLevelCallees",
//				">1NPredictionClassLevelCallers", ">1NPredictionClassLevelCallees", ">1NPredictionMethodLevelCallers", 
//				">1NPredictionMethodLevelCallees", ">1TPredictionClassLevelCallers", ">1TPredictionClassLevelCallees", 
//				">1TPredictionMethodLevelCallers", ">1TPredictionMethodLevelCallees", 
//				">2NPredictionClassLevelCallers", ">2NPredictionClassLevelCallees", ">2NPredictionMethodLevelCallers", 
//				">2NPredictionMethodLevelCallees", ">2TPredictionClassLevelCallers", ">2TPredictionClassLevelCallees", 
//				">2TPredictionMethodLevelCallers", ">2TPredictionMethodLevelCallees", 
//				"AllNClassLevelCallers", "AllNClassLevelCallees","AllNMethodLevelCallers","AllNMethodLevelCallees",
//				"AllTClassLevelCallers", "AllTClassLevelCallees", "AllTMethodLevelCallers", "AllTMethodLevelCallees"
//				,"Callers", "Callees", "#parameters", "Parameters","# Parameter T" ,"# Parameter N" ,"# Parameter E" ,
//				"MajorityParameterPrediction", "AtLeast1NParameterPrediction", 
//				"AtLeast1TParameterPrediction", "AtLeast2TParameterPrediction", 
//				"AtLeast2NParameterPrediction", "AllNParameterPrediction", "AllTParameterPrediction"
//				};
		String[] columnNames = {"Row",  "MethodID", "MethodName", "RequirementID", "RequirementName", "ClassID", "ClassName",
				"Gold", "Subject", "OwnerClass T", "Owner Class N", "Owner Class E", "# caller methods",
				"# caller methods T", "#caller methods N", "#caller methods E", "# caller classes",
				"# caller classes T", "#caller classes N", "#caller classes E", "# callee methods",
				"# callee methods T", "#callee methods N", "#callee methods E", "# callee classes",
				"# callee classes T", "#callee classes N", "#callee classes E",  "OwnerClassPrediction",
				"MajorityClassLevelCallees","MajorityClassLevelCallers", "MajorityMethodLevelCallees","MajorityMethodLevelCallers",
				">1NPredictionClassLevelCallees", ">1NPredictionClassLevelCallers", ">1NPredictionMethodLevelCallees", 
				">1NPredictionMethodLevelCallers", ">1TPredictionClassLevelCallees", ">1TPredictionClassLevelCallers", 
				">1TPredictionMethodLevelCallees", ">1TPredictionMethodLevelCallers", 
				">2NPredictionClassLevelCallees", ">2NPredictionClassLevelCallers", ">2NPredictionMethodLevelCallees", 
				">2NPredictionMethodLevelCallers", ">2TPredictionClassLevelCallees", ">2TPredictionClassLevelCallers", 
				">2TPredictionMethodLevelCallees", ">2TPredictionMethodLevelCallers", 
				"AllNClassLevelCallees", "AllNClassLevelCallers","AllNMethodLevelCallees","AllNMethodLevelCallers",
				"AllTClassLevelCallees", "AllTClassLevelCallers", "AllTMethodLevelCallees", "AllTMethodLevelCallers"
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

		TracesTableGantt2FINAL2 frame = new TracesTableGantt2FINAL2();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static List<Method> removeDuplicates(List<Method> list) {
		  // convert input array to populated list

		  // convert list to populated set
		  
		  
		
		  HashSet<Method> set=new HashSet(list); 
		  set.addAll(list);
		 
		  list = new ArrayList<Method>(set);
		  // convert set to array & return, 
		  // use cast because you can't create generic arrays
		  return list;
		}	
}



