package iTrust;

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
import java.util.stream.Collectors;
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
import mypackage.DatabaseReading2;
import mypackage.GroupableTableHeader;
import mypackage.Interface2;
import mypackage.Method2Details;
import mypackage.Method2Representation;
import mypackage.MethodTrace2;
import mypackage.MethodTraceOld;
import mypackage.MethodTraceOld;
import mypackage.Parameter2;
import mypackage.Requirement2;
import mypackage.RequirementClass;
import mypackage.RequirementGold;

public class TracesTableiTrustGold2PredictionFINAL extends JFrame {
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
	int ACHRAFTRACE=71; 
	int ACHRAFNOTRACE=72; 
	int AllNMethodLevelCallersCallees=73; 
	int AllTMethodLevelCallersCallees=74; 
	int AllTClassLevelCallersCallees=75; 
	int AllNClassLevelCallersCallees=76; 
	int counterFN=0; 
	double TracePureGold=0; 
	double NoTracePureGold=0; 
	double TraceMixedGold=0; 
	double NoTraceMixedGold=0; 
	
	double TracePureGoldTotal=0; 
	double NoTracePureGoldTotal=0; 
	double TraceMixedGoldTotal=0; 
	double NoTraceMixedGoldTotal=0; 
	
	double TracePureGold2=0; 
	double NoTracePureGold2=0; 
	double TraceMixedGold2=0; 
	double NoTraceMixedGold2=0; 
	
	double failGold=0; 
	double failGold2=0; 
	double TraceCountTotal=0; 
	double NoTraceCountTotal=0; 
	double TraceCountTotalGold2=0; 
	double NoTraceCountTotalGold2=0; 
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
	PredictionEvaluation AllNMethodLevelCallersCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCallersCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllNParameterClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTParameterClass= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFTrace= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTrace= new PredictionEvaluation(); 

	
	PredictionEvaluation OwnerClassPredictionClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation MajorityClassLevelCallersClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation MajorityClassLevelCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation MajorityMethodLevelCallersClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation MajorityMethodLevelCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionClassLevelCallersClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionClassLevelCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionMethodLevelCallersClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionMethodLevelCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionClassLevelCallersClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionClassLevelCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionMethodLevelCallersClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionMethodLevelCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionClassLevelCallersClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionClassLevelCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionMethodLevelCallersClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionMethodLevelCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionClassLevelCallersClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionClassLevelCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionMethodLevelCallersClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionMethodLevelCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCallersClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCallersClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation MajorityParametersClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast1NParameterClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NParameterClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast1TParameterClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TParameterClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNParameterClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTParameterClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFGold2Trace= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFGold2NOTrace= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCallersCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCallersCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersCalleesClassGold2= new PredictionEvaluation(); 
	
	ClassTrace2 myclasstrace = new ClassTrace2();
	static List<MethodTraceOld> methodtraces2 = new ArrayList<MethodTraceOld>();
	static List<ClassTrace2> classtraces2 = new ArrayList<ClassTrace2>();
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass = new  LinkedHashMap<String, ClassTrace2>(); 
	 
	 LinkedHashMap<String, Method2Details> linkedmethodhashmap= new LinkedHashMap<String, Method2Details>(); 
	 HashMap<String, Interface2> InterfacesHashMap= new HashMap<String, Interface2>();
	 HashMap<String, Interface2> InterfacesHashMapAlreadyImpl= new HashMap<String, Interface2>(); 


	JTable table = new JTable(); 
	static List<Method2Details> methodlist = new ArrayList<Method2Details>();
	//File fout = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\TableLog.txt");
	File fout = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\TableLogiTrust.txt");

	FileOutputStream fos = new FileOutputStream(fout);
	
//	File fout2 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\PredictionEvaluationChess.txt");
	File fout2 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\PredictionEvaluationiTrust.txt");

	FileOutputStream fos2 = new FileOutputStream(fout2);
	
	//File foutGold2 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\PredictionEvaluationChessGold2.txt");
	File foutGold2 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\PredictionEvaluationiTrustGold2.txt");

	FileOutputStream fileGold2 = new FileOutputStream(foutGold2);
	
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(fos2));
	BufferedWriter bwGold2 = new BufferedWriter(new OutputStreamWriter(fileGold2));
	File mylog = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logiTrustAllTClassLevelCallers.txt");
	FileOutputStream mylogfile = new FileOutputStream(mylog);
	BufferedWriter bwlog = new BufferedWriter(new OutputStreamWriter(mylogfile));
	
	File mylog2 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logiTrustAllNClassLevelCallers.txt");
	FileOutputStream mylogfile2 = new FileOutputStream(mylog2);
	BufferedWriter bwlog2 = new BufferedWriter(new OutputStreamWriter(mylogfile2));
	
	File mylog3 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logiTrustAllNParameters.txt");
	FileOutputStream mylogfile3 = new FileOutputStream(mylog3);
	BufferedWriter bwlog3 = new BufferedWriter(new OutputStreamWriter(mylogfile3));
	
	
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

	public TracesTableiTrustGold2PredictionFINAL() throws SQLException, IOException {
	

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
				"AtLeast1TParameterPrediction, AtLeast2TParameterPrediction, AtLeast2NParameterPrediction,  AllNParameterPrediction, AllTParameterPrediction, gold2" );





		
		bw.newLine();
		DatabaseReading2itrust db = new DatabaseReading2itrust();
		DatabaseReading2itrust.MakePredictions();
		methodtraces2 = db.getMethodtraces2();
		 methodtracesRequirementClass = db.getClassesRequirementtraceshashmap(); 
		 linkedmethodhashmap= db.getLinkedmethodhashmap(); 
		 InterfacesHashMap = db.getInterfaces();
		  InterfacesHashMapAlreadyImpl = db.getInterfacehashmapAlreadyImpl();

		List<TableCellEditor> editors1 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> editors2 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> editors3 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> editors4 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> myparametersEditor = new ArrayList<TableCellEditor>(methodtraces2.size());

		int j = 0;
		final int jfinal=0; 
		String[] items1 = new String[methodtraces2.size()];
		String[] items2 = new String[methodtraces2.size()];
		String[] items3 = new String[methodtraces2.size()];
		String[] items4 = new String[methodtraces2.size()];
		String[] items5 = new String[methodtraces2.size()];
		String[] items6 = new String[methodtraces2.size()];
		String[] myparameters = new String[methodtraces2.size()];
		Method2Representation[] callersarr = new Method2Representation[methodtraces2.size()];
		Method2Representation[] callersex = new Method2Representation[methodtraces2.size()];
		Method2Representation[] calleesarr = new Method2Representation[methodtraces2.size()];
		Method2Representation[] calleesex = new Method2Representation[methodtraces2.size()];
		Object[][] data = new Object[methodtraces2.size()][100];
		int myfinalcounter=1; 
		int MethodTraceCountGold=0; 
		int ClassTraceCount=0; 
		int MethodTraceCountGold2=0; 
		// Create the editors to be used for each row
		for (MethodTraceOld methodtrace : methodtraces2) {
			data[j][Row] = j; 
			data[j][MethodID] = methodtrace.MethodRepresentation.getMethodid();
			data[j][MethodName] = methodtrace.MethodRepresentation.methodname; 
			data[j][RequirementID] = methodtrace.Requirement.getID();
			data[j][RequirementName] = methodtrace.Requirement.getRequirementName();
			data[j][ClassID] = methodtrace.ClassRepresentation.classid;
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

			String reqclass= data[j][RequirementID].toString()+"-"+ data[j][ClassID].toString(); 
			ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
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
			int counterParameterTGOLD2=0; 
			int counterParameterNGOLD2=0; 
			int counterParameterEGOLD2=0; 
			 myparameters = new String[20];
			Method2Details mymethodobje = linkedmethodhashmap.get(methodtrace.MethodRepresentation.methodid); 
			String ParametersAppended=""; 
			if(mymethodobje!=null) {
				for ( Parameter2 myparam : mymethodobje.getParameters()) {
					myparameters[myparametercount] = myparam.toString(); 
					ParametersAppended=ParametersAppended+myparam.toString()+"-"; 
					myparametercount++;
					
					
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
						
						String mytrace2=mycallerclass.getTrace2(); 
						if(mytrace2!=null) {
							if(mytrace2.equals("T")) {
								counterParameterTGOLD2++; 
							}else if (mytrace2.equals("N")) {
								counterParameterNGOLD2++; 
							}else {
								counterParameterEGOLD2++; 
							}
						}
						
					}
					

				}
			}
	
			ParametersAppended=ParametersAppended.replaceAll(",", "/"); 
			data[j][CountParamaterT]= counterParameterT; 
			data[j][CountParamaterN]= counterParameterN; 
			data[j][CountParamaterE]= counterParameterE; 
			
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			//data [j][paramatersNumber]= myparametercount; 
			data[j][paramatersNumber]= counterParameterT+counterParameterN+counterParameterE; 

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
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
						items4[CountCalleesExecuted] = caller.toString2();
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

			
			
			

			//NEEDS TO BE ADDED IN OTHER PROJECTS 
			CallerMethodsList = CallerMethodsList.stream().filter(t -> t != null).collect(Collectors.toList()); 
			CalleeMethodsList = CalleeMethodsList.stream().filter(t -> t != null).collect(Collectors.toList()); 
			System.out.println("Caller Methods List Size: "+CallerMethodsList.size());
		
			
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
			
			

			
			
			
			
			
			
			
			//***********************************************CALLERS**************************************************//	
			//***********************************************CALLERS**************************************************//	
			//***********************************************CALLERS**************************************************//	

			for (Method2Representation methcaller : CallerMethodsList) {
				if (methcaller != null) {
							boolean flag=false; 
							
								for(Method2Representation item: CallerMethodsList) {
									String key =methcaller.classrep.getClassid()+"-"+methcaller.classrep.getClassname();
									Interface2 value = InterfacesHashMapAlreadyImpl.get(key);
									
									if(value!=null) {
										String ownerclassid=value.InterfaceClass.classid;
									if(item.classrep.classid.equals(ownerclassid) && item.getMethodname().equals(methcaller.methodname)) {
										CallerMethodListFinal.remove(item); 
									}
									}
								}
						
				
							
			
					
				}
			}
			
			

			List<Method2Representation> CallerMethodsListFinalNoDuplicates = new ArrayList<Method2Representation>();

			Set<String> CallerMethodsListNoDuplicates = new HashSet<String>();

			for( Method2Representation item : CallerMethodListFinal ) {
				String val= item.classrep.classid+"-"+item.methodname;
			    if( CallerMethodsListNoDuplicates.add( val )) {
			    	CallerMethodsListFinalNoDuplicates.add( item );
			    }
			}
			
			
			
			
			
				//***********************************************CALLEES**************************************************//	
				//***********************************************CALLEES**************************************************//	
				//***********************************************CALLEES**************************************************//	

			
			
			
			
			
			for (Method2Representation methcaller : CalleeMethodsList) {
				if (methcaller != null) {
					
				
						
					
						
							boolean flag=false; 
							
								for(Method2Representation item: CalleeMethodsList) {
									String key =methcaller.classrep.getClassid()+"-"+methcaller.classrep.getClassname();
									Interface2 value = InterfacesHashMapAlreadyImpl.get(key);
									
									if(value!=null) {
										String ownerclassid=value.InterfaceClass.classid;
									if(item.classrep.classid.equals(ownerclassid) && item.getMethodname().equals(methcaller.methodname)) {
										CalleeMethodListFinal.remove(item); 
									}
									}
								}
						
				
							
			
					
				}
			}
			
			
			
			

			List<Method2Representation> CalleeMethodsListFinalNoDuplicates = new ArrayList<Method2Representation>();

			Set<String> CalleeMethodsListNoDuplicates = new HashSet<String>();
			for( Method2Representation item : CalleeMethodListFinal ) {
				String val= item.classrep.classid+"-"+item.methodname;
			    if( CalleeMethodsListNoDuplicates.add( val )) {
			    	CalleeMethodsListFinalNoDuplicates.add( item );
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
			CallerMethodListFinal=removeDuplicates(CallerMethodListFinal); 

			String AppendedCallers=""; 
			for(Method2Representation CallerMethod: CallerMethodListFinal) {
				if(CallerMethod!=null) {
					AppendedCallers=AppendedCallers+CallerMethod.toString2()+"-"; 
				}
				
			}
			CalleeMethodListFinal=removeDuplicates(CalleeMethodListFinal); 
			AppendedCallers=AppendedCallers.replaceAll(",", "/"); 
			String AppendedCallees=""; 
			for(Method2Representation CalleeMethod: CalleeMethodListFinal) {
				if(CalleeMethod!=null) {
					AppendedCallees=AppendedCallees+CalleeMethod.toString2()+"-"; 
				}
				
			}

			AppendedCallees=AppendedCallees.replaceAll(",", "/"); 
			int CounterTraceClassCallerT = 0;
			int CounterTraceClassCallerN = 0;
			int CounterTraceClassCallerE = 0;
			int CounterTraceClassCallerTGOLD2 = 0;
			int CounterTraceClassCallerNGOLD2 = 0;
			int CounterTraceClassCallerEGOLD2 = 0;
			List<ClassTrace2> mycallerclasses = new ArrayList<ClassTrace2>();

			for (Method2Representation callermeth : CallerMethodListFinal) {
				ClassRepresentation2 classrep = callermeth.getClassrep();
			//	ClassTrace2 mycallerclass = myclasstrace.FindTrace(classtraces2, classrep.classid,methodtrace.Requirement.getID());
				//Sometimes, mycallerclass is null and cannot be found in the traces classes table 
				ClassTrace2 mycallerclass = myclasstrace.FindTrace2(methodtracesRequirementClass, classrep.classid,	methodtrace.Requirement.getID());
				if(mycallerclass!=null) {
					mycallerclasses.add(mycallerclass);
				}
				
			}

			//data[j][CallerMethodsNumber] = mycallerclasses.size();
			
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

		//	data[j][CallerClassesNumber] = myclasstracesCallers.size();
//NO DUPLICATE CLASSES 
			for (ClassTrace2 mycallerclass : myclasstracesCallers) {
				if (mycallerclass.gettrace().equals("T")) {
					CounterTraceClassCallerT++;
				} else if (mycallerclass.gettrace().equals("N")) {
					CounterTraceClassCallerN++;
				} else if (mycallerclass.gettrace().equals("E")) {
					CounterTraceClassCallerE++;
				}
				if (mycallerclass.getTrace2()!=null) {
					if (mycallerclass.getTrace2().equals("T")) {
						CounterTraceClassCallerTGOLD2++;
					} else if (mycallerclass.getTrace2().equals("N")) {
						CounterTraceClassCallerNGOLD2++;
					} else if (mycallerclass.getTrace2().equals("E")) {
						CounterTraceClassCallerEGOLD2++;
					}
				}
				
			}

			data[j][CallerClassesT] = CounterTraceClassCallerT;
			data[j][CallerClassesN] = CounterTraceClassCallerN;
			data[j][CallerClassesE] = CounterTraceClassCallerE;
			data[j][CallerClassesNumber] = CounterTraceClassCallerT+CounterTraceClassCallerN+CounterTraceClassCallerE;

//DUPLICATE CLASSES
			int CountMethodT = 0; 
			int CountMethodN = 0; 
			int CountMethodE = 0; 
			
			int CountMethodTGOLD2 = 0; 
			int CountMethodNGOLD2 = 0; 
			int CountMethodEGOLD2 = 0; 
			for (ClassTrace2 mycallerclass : mycallerclasses) {
				if (mycallerclass.gettrace().equals("T")) {
					CountMethodT++;
				} else if (mycallerclass.gettrace().equals("N")) {
					CountMethodN++;
				} else if (mycallerclass.gettrace().equals("E")) {
					CountMethodE++;
				}
				if(mycallerclass.getTrace2()!=null) {
					if (mycallerclass.getTrace2().equals("T")) {
						CountMethodTGOLD2++;
					} else if (mycallerclass.getTrace2().equals("N")) {
						CountMethodNGOLD2++;
					} else if (mycallerclass.getTrace2().equals("E")) {
						CountMethodEGOLD2++;
					}
				}
				
			}

		

			int CounterTraceClassCalleeT = 0;
			int CounterTraceClassCalleeN = 0;
			int CounterTraceClassCalleeE = 0;
			
			int CounterTraceClassCalleeTGOLD2 = 0;
			int CounterTraceClassCalleeNGOLD2 = 0;
			int CounterTraceClassCalleeEGOLD2 = 0;
			List<ClassTrace2> mycalleeclasses = new ArrayList<ClassTrace2>();

			for (Method2Representation calleemeth : CalleeMethodListFinal) {
				ClassRepresentation2 classrep = calleemeth.getClassrep();
				ClassTrace2 mycalleeclass = myclasstrace.FindTrace2(methodtracesRequirementClass, classrep.classid,	methodtrace.Requirement.getID());

				//ClassTrace2 mycalleeclass = myclasstrace.FindTrace(classtraces2, classrep.classid,methodtrace.Requirement.getID());
				if(mycalleeclass!=null) {
					mycalleeclasses.add(mycalleeclass);
				}
				
			}
			//data[j][CalleeMethodsNumber] = mycalleeclasses.size();
			
			
			ArrayList<ClassTrace2> myclasstracesCallees = new ArrayList<ClassTrace2>();// unique
			for (ClassTrace2 classtrace : mycalleeclasses) {
				if (!myclasstracesCallees.contains(classtrace)) {

					myclasstracesCallees.add(classtrace);
				}
			}
			//NO DUPLICATE CLASSES 

			//data[j][CalleeClassesNumber] = myclasstracesCallees.size();
			System.out.println("FUINAL COIUNTER ===============>"+ myfinalcounter);
			for (ClassTrace2 mycalleeclass : myclasstracesCallees) {
				if (mycalleeclass.gettrace().equals("T")) {
					CounterTraceClassCalleeT++;
				} else if (mycalleeclass.gettrace().equals("N")) {
					CounterTraceClassCalleeN++;
				} else if (mycalleeclass.gettrace().equals("E")) {
					CounterTraceClassCalleeE++;
				}
				
				if(mycalleeclass.getTrace2()!=null) {
					if (mycalleeclass.getTrace2().equals("T")) {
						CounterTraceClassCalleeTGOLD2++;
					} else if (mycalleeclass.getTrace2().equals("N")) {
						CounterTraceClassCalleeNGOLD2++;
					} else if (mycalleeclass.getTrace2().equals("E")) {
						CounterTraceClassCalleeEGOLD2++;
					}
				}
			
			}

			data[j][CalleeClassesT] = CounterTraceClassCalleeT;
			data[j][CalleeClassesN] = CounterTraceClassCalleeN;
			data[j][CalleeClassesE] = CounterTraceClassCalleeE;
			data[j][CalleeClassesNumber] = CounterTraceClassCalleeE+CounterTraceClassCalleeN+CounterTraceClassCalleeT;

			//DUPLICATE CLASSES
			int CountMethodTCallee = 0; 
			int CountMethodNCallee = 0; 
			int CountMethodECallee = 0; 
			
			int CountMethodTCalleeGOLD2 = 0; 
			int CountMethodNCalleeGOLD2 = 0; 
			int CountMethodECalleeGOLD2 = 0; 
			for (ClassTrace2 mycalleeclass : mycalleeclasses) {
				if(mycalleeclass.getTrace2()!=null) {
					if (mycalleeclass.getTrace2().equals("T")) {
						CountMethodTCalleeGOLD2++;
					} else if (mycalleeclass.getTrace2().equals("N")) {
						CountMethodNCalleeGOLD2++;
					} else if (mycalleeclass.getTrace2().equals("E")) {
						CountMethodECalleeGOLD2++;
					}
				}
			
			}
			
			
			int CountMethodTACHRAF = 0; 
			int CountMethodNACHRAF = 0; 
			int CountMethodEACHRAF = 0; 
			for (Method2Representation mycaller: methodtrace.getCallersListExecuted()) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.methodid); 
				 if(methdet!=null) {
						HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
						Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
						MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
						if(methtrace!=null) {
						if (methtrace.gold.equals("T")) {
							CountMethodTACHRAF++;
						} else if (methtrace.gold.equals("N")) {
							CountMethodNACHRAF++;
						} else if (methtrace.gold.equals("E")) {
							CountMethodEACHRAF++;
						}
					} 
				 }
		
			}
			
			int CountMethodTACHRAFCallee = 0; 
			int CountMethodNACHRAFCallee = 0; 
			int CountMethodEACHRAFCallee = 0; 
			for (Method2Representation mycaller: methodtrace.getCalleesListExecuted()) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.methodid); 
				 if(methdet!=null) {
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null) {
					if (methtrace.gold.equals("T")) {
						CountMethodTACHRAFCallee++;
					} else if (methtrace.gold.equals("N")) {
						CountMethodNACHRAFCallee++;
					} else if (methtrace.gold.equals("E")) {
						CountMethodEACHRAFCallee++;
					}
				}
				 }
			
			}
			
			
			
			

		
			int CountMethodTACHRAFGold2 = 0; 
			int CountMethodNACHRAFGold2 = 0; 
			int CountMethodEACHRAFGold2 = 0; 
			for (Method2Representation mycaller: methodtrace.getCallersListExecuted()) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.methodid); 
				 if(methdet!=null) {
					 HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
						Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
						MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
						if(methtrace!=null) {
							if(methtrace.gold2!=null) {
								if (methtrace.gold2.equals("T")) {
									CountMethodTACHRAFGold2++;
								} else if (methtrace.gold2.equals("N")) {
									CountMethodNACHRAFGold2++;
								} else if (methtrace.gold2.equals("E")) {
									CountMethodEACHRAFGold2++;
								}
							}
				 }
				
			
			}
			}
			
			
			
			int CountMethodTACHRAFCalleeGold2 = 0; 
			int CountMethodNACHRAFCalleeGold2 = 0; 
			int CountMethodEACHRAFCalleeGold2 = 0; 
			for (Method2Representation mycaller: methodtrace.getCalleesListExecuted()) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.methodid); 
				 if(methdet!=null) {
					 HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
						Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
						MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
						if(methtrace!=null) {
							if (methtrace.gold.equals("T")) {
								CountMethodTACHRAFCalleeGold2++;
							} else if (methtrace.gold.equals("N")) {
								CountMethodNACHRAFCalleeGold2++;
							} else if (methtrace.gold.equals("E")) {
								CountMethodEACHRAFCalleeGold2++;
							}
						}
				 }
				
			
			}
			
			
			
			
			
			for (ClassTrace2 mycalleeclass : mycalleeclasses) {
				if(mycalleeclass.gettrace()!=null) {
					if (mycalleeclass.gettrace().equals("T")) {
						CountMethodTCallee++;
					} else if (mycalleeclass.gettrace().equals("N")) {
						CountMethodNCallee++;
					} else if (mycalleeclass.gettrace().equals("E")) {
						CountMethodECallee++;
					}
				}
			
			}
			
			data[j][CalleeMethodsT] = CountMethodTCallee;
			data[j][CalleeMethodsN] = CountMethodNCallee;
			data[j][CalleeMethodsE] = CountMethodECallee;
			data[j][CalleeMethodsNumber] = CountMethodTCallee+CountMethodNCallee+CountMethodECallee;
			
			data[j][CallerMethodsT] = CountMethodT;
			data[j][CallerMethodsN] = CountMethodN;
			data[j][CallerMethodsE] = CountMethodE;
			data[j][CallerMethodsNumber] = CountMethodT+CountMethodN+CountMethodE;

			myfinalcounter++; 
		//OWNER CLASS PREDICTION 
		 Object OwnerClassNVar = data[j][OwnerClassN]; 
			boolean flagGold=false; 
			boolean flagGold2=false; 
			if(OwnerClassNVar.toString().equals("1")) {
				data[j][OwnerClassPrediction]="N"; 
				String Result=OwnerClassPredictionClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][OwnerClassPrediction].toString()); 
				OwnerClassPredictionClass.UpdateCounters(Result, OwnerClassPredictionClass);
				flagGold=true; 
				if(methodtrace.getGold2()!=null){
				String Result2=OwnerClassPredictionClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][OwnerClassPrediction].toString()); 
				OwnerClassPredictionClassGold2.UpdateCounters(Result2, OwnerClassPredictionClassGold2);
				flagGold2=true; 
				}
			}
			//else {
				
				
				
			int countParamT=Integer.parseInt(data[j][CountParamaterT].toString()); 
			int countParamN=Integer.parseInt(data[j][CountParamaterN].toString()); 
			int countParamE=Integer.parseInt(data[j][CountParamaterE].toString()); 

			
			
			//MAJORITY PARAMETER PREDICTION 

				if((countParamT!=0 || countParamN!=0|| countParamE!=0)
						/*	||
							(CounterTraceClassCallerN!=0 && CounterTraceClassCallerE!=0)
							||(CounterTraceClassCallerT!=0 && CounterTraceClassCallerE!=0)*/
							) {
						
						if(countParamT==countParamN && countParamT>0) {
							data[j][MajorityParameters] = "T";
						}
						else if(countParamT==0 && countParamN==0 && countParamE>0) {
							data[j][MajorityParameters] = "E";
						}
						else if(countParamT==0 && countParamN>0 && countParamE>0) {
							data[j][MajorityParameters] = "N";
						}
						else if (((countParamT >= countParamN
							//	&& countParamN >= countParamE
								)
								//|| (countParamT >= countParamE
									//	&& countParamE >= countParamN
								//		)
								)
								) {
							data[j][MajorityParameters] = "T";
						}/* else if (((countParamE >= countParamN
								&& countParamN >= countParamT)
								|| (countParamE >= countParamT
										&& countParamT >= countParamN))
							) {
							data[j][MajorityParameters] = "E";
						} */else if ((countParamN > countParamT)) {
							data[j][MajorityParameters] = "N";
						}
						if(flagGold==false) {
							String Result=MajorityParametersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][MajorityParameters].toString()); 
							MajorityParametersClass.UpdateCounters(Result, MajorityParametersClass);
						}
						
					
						
					
					}
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				//AT LEAST 1N PREDICTION PARAMETER
				
				
				
				
				
				if (countParamN >=1 )
						 {
					data[j][AtLeast1NParameter] = "N";
					if(flagGold==false) {
					String Result=AtLeast1NParameterClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast1NParameter].toString()); 
					AtLeast1NParameterClass.UpdateCounters(Result, AtLeast1NParameterClass);
					}
					
				} 
			
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				//AT LEAST 2N PREDICTION PARAMETER
				
				
				
				
				
				if (countParamN >=2 )
						 {
					data[j][AtLeast2NParameter] = "N";
					if(flagGold==false) {
						
						String Result=AtLeast2NParameterClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast2NParameter].toString()); 
					AtLeast2NParameterClass.UpdateCounters(Result, AtLeast2NParameterClass);
					}
					
				} 
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//AT LEAST 1T PREDICTION PARAMETER
			
			
				
				
				
				if (countParamT >=1 )
						 {
					data[j][AtLeast1TParameter] = "T";
					if(flagGold==false) {
					String Result=AtLeast1TParameterClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast1TParameter].toString()); 
					AtLeast1TParameterClass.UpdateCounters(Result, AtLeast1TParameterClass);
					}
				} 
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 2T PREDICTION PARAMETER
				
				
					
					
					
					if (countParamT >=2 )
							 {
						data[j][AtLeast2TParameter] = "T";
						if(flagGold==false) {
						String Result=AtLeast2TParameterClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast2TParameter].toString()); 
						AtLeast2TParameterClass.UpdateCounters(Result, AtLeast2TParameterClass);
						}
					} 
				/**************************************************************************************************************/
				/**************************************************************************************************************/
			    /**************************************************************************************************************/	
				
				
				
				//ALL T PARAMETER PREDICTION
				
				
				if(countParamE==0 && countParamN==0 && countParamT>=1) {
					
					
					
				
						data[j][AllTParameters] = "T";
						if(flagGold==false) {
						String Result=AllTParameterClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTParameters].toString()); 
						AllTParameterClass.UpdateCounters(Result, AllTParameterClass);
						}
						
						
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL N PARAMETER PREDICTION
				
				
				if(countParamT==0 && countParamE==0 && countParamN>=1) {
					
					
					
				
						data[j][AllNParameters] = "N";
						if(flagGold==false) {
						String Result=AllNParameterClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNParameters].toString()); 
						AllNParameterClass.UpdateCounters(Result, AllNParameterClass);
						
						if(Result!=null) {
							
							

							System.out.println("MY RESULT "+Result);
							if(Result.equals("FN")) {
								bwlog3.write("***********************************"); 
								bwlog3.newLine();
								bwlog3.write(methodtrace.toString());
								bwlog3.newLine();
								for(Method2Representation call: methodtrace.getCallersList()) {
									bwlog3.write("callerlist "+ call.toString2());
									
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 
									 if(trace2!=null) {
										 bwlog3.newLine();
										 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
										
										
									 }
									 bwlog3.newLine();
								}
								for(Method2Representation call: methodtrace.getCallersListExecuted()) {
									bwlog3.write("callerlistEXEC "+ call.toString2());
									bwlog3.newLine();
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 

									 if(trace2!=null) {
										 bwlog3.newLine();
										 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
										
										
									 }
									 bwlog3.newLine();
								}
								for(Method2Representation call: methodtrace.getCalleesList()) {
									bwlog3.write("calleelist "+ call.toString2());
									bwlog3.newLine();
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 

									 if(trace2!=null) {
										 bwlog3.newLine();
										 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
										
										
									 }
									 bwlog3.newLine();
								}
								for(Method2Representation call: methodtrace.getCalleesListExecuted()) {
									bwlog3.write("calleelistEXEC "+ call.toString2());
									bwlog3.newLine();
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 

									 if(trace2!=null) {
										 bwlog3.newLine();
										 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
										
										
									 }
									 bwlog3.newLine();
								}
								bwlog3.write("***********************************"); 
								bwlog3.newLine();
							}
						
						}
						
						
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
					if(flagGold==false) {
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
					if(flagGold==false) {
					String Result=MajorityClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][MajorityClassLevelCallers].toString()); 
					MajorityClassLevelCallersClass.UpdateCounters(Result, MajorityClassLevelCallersClass);
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
				
					if(flagGold==false) {
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
					if(flagGold==false) {
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
						if(flagGold==false) {
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
						if(flagGold==false) {
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
						if(flagGold==false) {
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
						if(flagGold==false) {
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
						if(flagGold==false) {
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
						if(flagGold==false) {
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
						if(flagGold==false) {
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
						if(flagGold==false) {
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
							if(flagGold==false) {
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
					if(flagGold==false) {
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
							if(flagGold==false) {
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
						if(flagGold==false) {
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
					if(flagGold==false) {
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
					if(flagGold==false) {
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
					if(flagGold==false) {
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
					if(flagGold==false) {
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
					if(flagGold==false) {
						String Result=AtLeast2TPredictionClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AtLeast2TPredictionClassLevelCallers].toString()); 
						AtLeast2TPredictionClassLevelCallersClass.UpdateCounters(Result, AtLeast2TPredictionClassLevelCallersClass);

					}
					
					}
						
						
						
						
						
						
						
						
						
						
						
						
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/	 
				//ALL T METHOD LEVEL CALLEES 
				
				
				if(CountMethodNCallee==0 && CountMethodECallee==0 && CountMethodTCallee>=1) {
					
					
					
						
						data[j][AllTMethodLevelCallees] = "T";
						if(flagGold==false) {
						String Result=AllTMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTMethodLevelCallees].toString()); 
						AllTMethodLevelCalleesClass.UpdateCounters(Result, AllTMethodLevelCalleesClass);
						}
				}
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL T METHOD LEVEL CALLERS 
				
				if(CountMethodN==0 && CountMethodE==0  && CountMethodT>=1) {
					
					
					
				
						data[j][AllTMethodLevelCallers] = "T";
						if(flagGold==false) {
						String Result=AllTMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTMethodLevelCallers].toString()); 
						AllTMethodLevelCallersClass.UpdateCounters(Result, AllTMethodLevelCallersClass);
						
						}
					
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL T CLASS LEVEL CALLERS 
				
				
				if(CounterTraceClassCallerE==0 && CounterTraceClassCallerN==0 && CounterTraceClassCallerT>=1) {
					
					
				
						data[j][AllTClassLevelCallers] = "T";
						if(flagGold==false) {
						String Result=AllTClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTClassLevelCallers].toString()); 
						AllTClassLevelCallersClass.UpdateCounters(Result, AllTClassLevelCallersClass);
						System.out.println(methodtrace.toString());
						
						}
						
						
						}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL T CLASS LEVEL CALLEES 
				
				
				if(CounterTraceClassCalleeE==0 && CounterTraceClassCalleeN==0 && CounterTraceClassCalleeT>=1) {
					
					
					
				
						data[j][AllTClassLevelCallees] = "T";
						if(flagGold==false) {
						String Result=AllTClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTClassLevelCallees].toString()); 
						AllTClassLevelCalleesClass.UpdateCounters(Result, AllTClassLevelCalleesClass);
				
						
						}
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL N CLASS LEVEL CALLERS 
				
				
			
					
				if(CounterTraceClassCallerT==0 && CounterTraceClassCallerE==0 && CounterTraceClassCallerN>=1) {
					
				
						data[j][AllNClassLevelCallers] = "N";
						if(flagGold==false) {
						String Result=AllNClassLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNClassLevelCallers].toString()); 
						AllNClassLevelCallersClass.UpdateCounters(Result, AllNClassLevelCallersClass);
						if(Result!=null) {
							System.out.println("MY RESULT "+Result);
							if(Result.equals("FN")) {
								bwlog2.write("***********************************"); 
								bwlog2.newLine();
								bwlog2.write(methodtrace.toString());
								bwlog2.newLine();
								for(Method2Representation call: methodtrace.getCallersList()) {
									bwlog2.write("callerlist "+ call.toString2());
									
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 
									 if(trace2!=null) {
										 bwlog2.newLine();
										 bwlog2.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
										
										
									 }
									 bwlog2.newLine();
								}
								for(Method2Representation call: methodtrace.getCallersListExecuted()) {
									bwlog2.write("callerlistEXEC "+ call.toString2());
									bwlog2.newLine();
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 

									 if(trace2!=null) {
										 bwlog2.newLine();
										 bwlog2.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
										
										
									 }
									 bwlog2.newLine();
								}
								for(Method2Representation call: methodtrace.getCalleesList()) {
									bwlog2.write("calleelist "+ call.toString2());
									bwlog2.newLine();
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 

									 if(trace2!=null) {
										 bwlog2.newLine();
										 bwlog2.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
										
										
									 }
									 bwlog2.newLine();
								}
								for(Method2Representation call: methodtrace.getCalleesListExecuted()) {
									bwlog2.write("calleelistEXEC "+ call.toString2());
									bwlog2.newLine();
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 

									 if(trace2!=null) {
										 bwlog2.newLine();
										 bwlog2.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
										
										
									 }
									 bwlog2.newLine();
								}
								bwlog2.write("***********************************"); 
								bwlog2.newLine();
							}
						}
						}
						
						
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL N CLASS LEVEL CALLEES 
				
				
		
					
					if(CounterTraceClassCalleeT==0 && CounterTraceClassCalleeE==0 && CounterTraceClassCalleeN>=1) {
					
				
						data[j][AllNClassLevelCallees] = "N";
						if(flagGold==false) {
						String Result=AllNClassLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNClassLevelCallees].toString()); 
						AllNClassLevelCalleesClass.UpdateCounters(Result, AllNClassLevelCalleesClass);
						
						}
					
				}
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL N METHOD LEVEL CALLERS 
				
				
			
					
					if(CountMethodT==0 && CountMethodE==0 && CountMethodN>=1) {	
					
				
						data[j][AllNMethodLevelCallers] = "N";
						if(flagGold==false) {
						String Result=AllNMethodLevelCallersClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNMethodLevelCallers].toString()); 
						AllNMethodLevelCallersClass.UpdateCounters(Result, AllNMethodLevelCallersClass);
						
						}
				}
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//ALL N METHOD LEVEL CALLEES 
				
				
			
					
					if(CountMethodTCallee==0 && CountMethodECallee==0 && CountMethodNCallee>=1) {
					
				
						data[j][AllNMethodLevelCallees] = "N";
						if(flagGold==false) {
							String Result=AllNMethodLevelCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNMethodLevelCallees].toString()); 
							AllNMethodLevelCalleesClass.UpdateCounters(Result, AllNMethodLevelCalleesClass);
						}
					
						
				}
			//}
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//ALL N METHOD LEVEL CALLERS CALLEES 
					
					
				
						
						if(CountMethodTCallee==0 && CountMethodT==0 && CountMethodNCallee>=1 && CountMethodN>=1) {
						
					
							data[j][AllNMethodLevelCallersCallees] = "N";
							if(flagGold==false && methodtrace.getGold()!=null) {
								String Result=AllNMethodLevelCallersCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNMethodLevelCallersCallees].toString()); 
								AllNMethodLevelCallersCalleesClass.UpdateCounters(Result, AllNMethodLevelCallersCalleesClass);
							}
						
							
					}
				//}
						
						
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						
						//ALL T METHOD LEVEL CALLERS CALLEES 
						
						
					
							
							if(CountMethodN==0 && CountMethodNCallee==0 && CountMethodTCallee>=1 && CountMethodT>=1) {
							
						
								data[j][AllTMethodLevelCallersCallees] = "T";
								if(flagGold==false && methodtrace.getGold()!=null) {
									String Result=AllTMethodLevelCallersCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTMethodLevelCallersCallees].toString()); 
									AllTMethodLevelCallersCalleesClass.UpdateCounters(Result, AllTMethodLevelCallersCalleesClass);
								}
							
								
						}
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//ALL N CLASS LEVEL CALLERS CALLEES 
							
							
						
								
								if(CounterTraceClassCalleeT==0 && CounterTraceClassCallerT==0 && CounterTraceClassCalleeN>=1 && CounterTraceClassCallerN>=1) {
								
							
									data[j][AllNClassLevelCallersCallees] = "N";
									if(flagGold==false && methodtrace.getGold()!=null) {
										String Result=AllNClassLevelCallersCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNClassLevelCallersCallees].toString()); 
										AllNClassLevelCallersCalleesClass.UpdateCounters(Result, AllNClassLevelCallersCalleesClass);
									}
								
									
							}
						//}
								
								
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL T CLASS LEVEL CALLERS CALLEES 
								
								
							
									
									if(CounterTraceClassCalleeN==0 && CounterTraceClassCallerN==0 && CounterTraceClassCalleeT>=1 && CounterTraceClassCallerT>=1) {
									
								
										data[j][AllTClassLevelCallersCallees] = "T";
										if(flagGold==false && methodtrace.getGold()!=null) {
											String Result=AllTClassLevelCallersCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTClassLevelCallersCallees].toString()); 
											AllTClassLevelCallersCalleesClass.UpdateCounters(Result, AllTClassLevelCallersCalleesClass);
										}
									
										
								}
					
					
					
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					/***********************************************************************************************************************************/
									/***********************************************************************************************************************************/
									/***********************************************************************************************************************************/

									/***********************************************************************************************************************************/

					
					if((counterParameterTGOLD2!=0 || counterParameterNGOLD2!=0|| counterParameterEGOLD2!=0)
							/*	||
								(CounterTraceClassCallerN!=0 && CounterTraceClassCallerE!=0)
								||(CounterTraceClassCallerT!=0 && CounterTraceClassCallerE!=0)*/
								) {
							
							if(counterParameterTGOLD2==counterParameterNGOLD2 && counterParameterTGOLD2>0) {
								data[j][MajorityParameters] = "T";
							}
							else if(counterParameterTGOLD2==0 && counterParameterNGOLD2==0 && counterParameterEGOLD2>0) {
								data[j][MajorityParameters] = "E";
							}
							else if(counterParameterTGOLD2==0 && counterParameterNGOLD2>0 && counterParameterEGOLD2>0) {
								data[j][MajorityParameters] = "N";
							}
							else if (((counterParameterTGOLD2 >= counterParameterNGOLD2
								//	&& counterParameterNGOLD2 >= counterParameterEGOLD2
									)
									//|| (counterParameterTGOLD2 >= counterParameterEGOLD2
										//	&& counterParameterEGOLD2 >= counterParameterNGOLD2
									//		)
									)
									) {
								data[j][MajorityParameters] = "T";
							}/* else if (((counterParameterEGOLD2 >= counterParameterNGOLD2
									&& counterParameterNGOLD2 >= counterParameterTGOLD2)
									|| (counterParameterEGOLD2 >= counterParameterTGOLD2
											&& counterParameterTGOLD2 >= counterParameterNGOLD2))
								) {
								data[j][MajorityParameters] = "E";
							} */else if ((counterParameterNGOLD2 >= counterParameterTGOLD2)) {
								data[j][MajorityParameters] = "N";
							}
							if(flagGold2==true && methodtrace.getGold2()!=null) {
								String Result=MajorityParametersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][MajorityParameters].toString()); 
								MajorityParametersClassGold2.UpdateCounters(Result, MajorityParametersClassGold2);
							}
							
						
							
						
						}
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					//AT LEAST 1N PREDICTION PARAMETER
					
					
					
					
					
					if (counterParameterNGOLD2 >=1 )
							 {
						data[j][AtLeast1NParameter] = "N";
						if(flagGold2==false && methodtrace.getGold2()!=null) {
						String Result=AtLeast1NParameterClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast1NParameter].toString()); 
						AtLeast1NParameterClassGold2.UpdateCounters(Result, AtLeast1NParameterClassGold2);
						}
						
					} 
				
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					//AT LEAST 2N PREDICTION PARAMETER
					
					
					
					
					
					if (counterParameterNGOLD2 >=2 )
							 {
						data[j][AtLeast2NParameter] = "N";
						if(flagGold2==false && methodtrace.getGold2()!=null) {
							
							String Result=AtLeast2NParameterClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast2NParameter].toString()); 
						AtLeast2NParameterClassGold2.UpdateCounters(Result, AtLeast2NParameterClassGold2);
						}
						
					} 
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				
				//AT LEAST 1T PREDICTION PARAMETER
				
				
					
					
					
					if (counterParameterTGOLD2 >=1 )
							 {
						data[j][AtLeast1TParameter] = "T";
						if(flagGold2==false && methodtrace.getGold2()!=null) {
						String Result=AtLeast1TParameterClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast1TParameter].toString()); 
						AtLeast1TParameterClassGold2.UpdateCounters(Result, AtLeast1TParameterClassGold2);
						}
					} 
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//AT LEAST 2T PREDICTION PARAMETER
					
					
						
						
						
						if (counterParameterTGOLD2 >=2 )
								 {
							data[j][AtLeast2TParameter] = "T";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AtLeast2TParameterClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast2TParameter].toString()); 
							AtLeast2TParameterClassGold2.UpdateCounters(Result, AtLeast2TParameterClassGold2);
							}
						} 
					/**************************************************************************************************************/
					/**************************************************************************************************************/
				    /**************************************************************************************************************/	
					
					
					
					//ALL T PARAMETER PREDICTION
					
					
					if(counterParameterEGOLD2==0 && counterParameterNGOLD2==0 && counterParameterTGOLD2>=1) {
						
						
						
					
							data[j][AllTParameters] = "T";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AllTParameterClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AllTParameters].toString()); 
							AllTParameterClassGold2.UpdateCounters(Result, AllTParameterClassGold2);
							}
							
							
					}
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//ALL N PARAMETER PREDICTION
					
					
					if(counterParameterTGOLD2==0 && counterParameterEGOLD2==0 && counterParameterNGOLD2>=1) {
						
						
						
					
							data[j][AllNParameters] = "N";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AllNParameterClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AllNParameters].toString()); 
							AllNParameterClassGold2.UpdateCounters(Result, AllNParameterClassGold2);
							
							if(Result!=null) {
								
								

								System.out.println("MY RESULT "+Result);
								if(Result.equals("FN")) {
									bwlog3.write("***********************************"); 
									bwlog3.newLine();
									bwlog3.write(methodtrace.toString());
									bwlog3.newLine();
									for(Method2Representation call: methodtrace.getCallersList()) {
										bwlog3.write("callerlist "+ call.toString2());
										
										 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 
										 if(trace2!=null) {
											 bwlog3.newLine();
											 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
											
											
										 }
										 bwlog3.newLine();
									}
									for(Method2Representation call: methodtrace.getCallersListExecuted()) {
										bwlog3.write("callerlistEXEC "+ call.toString2());
										bwlog3.newLine();
										 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 

										 if(trace2!=null) {
											 bwlog3.newLine();
											 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
											
											
										 }
										 bwlog3.newLine();
									}
									for(Method2Representation call: methodtrace.getCalleesList()) {
										bwlog3.write("calleelist "+ call.toString2());
										bwlog3.newLine();
										 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 

										 if(trace2!=null) {
											 bwlog3.newLine();
											 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
											
											
										 }
										 bwlog3.newLine();
									}
									for(Method2Representation call: methodtrace.getCalleesListExecuted()) {
										bwlog3.write("calleelistEXEC "+ call.toString2());
										bwlog3.newLine();
										 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 

										 if(trace2!=null) {
											 bwlog3.newLine();
											 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
											
											
										 }
										 bwlog3.newLine();
									}
									bwlog3.write("***********************************"); 
									bwlog3.newLine();
								}
							
							}
							
							
							}
					}
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					//MAJORITY CLASS LEVEL CALLEES PREDICTION 

					//FIRST IF makes sure there is a mixture 
					if((CounterTraceClassCalleeTGOLD2!=0 || CounterTraceClassCalleeNGOLD2!=0 || CounterTraceClassCalleeEGOLD2!=0)
						/*	||
							(CounterTraceClassCallerNGOLD2!=0 && CounterTraceClassCallerEGOLD2!=0)
							||(CounterTraceClassCallerTGOLD2!=0 && CounterTraceClassCallerEGOLD2!=0)*/
							) {
						
						if(CounterTraceClassCalleeTGOLD2==CounterTraceClassCalleeNGOLD2 && CounterTraceClassCalleeTGOLD2>0) {
							data[j][MajorityClassLevelCallees] = "T";
						}
						else if(CounterTraceClassCalleeTGOLD2==0 && CounterTraceClassCalleeNGOLD2==0 && CounterTraceClassCalleeEGOLD2>0) {
							data[j][MajorityClassLevelCallees] = "E";
						}
						else if(CounterTraceClassCalleeTGOLD2==0 && CounterTraceClassCalleeNGOLD2>0 && CounterTraceClassCalleeEGOLD2>0) {
							data[j][MajorityClassLevelCallees] = "N";
						}
						else if ((CounterTraceClassCalleeTGOLD2 >= CounterTraceClassCalleeNGOLD2
								)
								) {
							data[j][MajorityClassLevelCallees] = "T";
						} /*else if (((CounterTraceClassCallerEGOLD2 >= CounterTraceClassCallerNGOLD2
								&& CounterTraceClassCallerNGOLD2 >= CounterTraceClassCallerTGOLD2)
								|| (CounterTraceClassCallerEGOLD2 >= CounterTraceClassCallerTGOLD2
										&& CounterTraceClassCallerTGOLD2 >= CounterTraceClassCallerNGOLD2))
							) {
							data[j][MajorityClassLevelCallees] = "E";
						}*/ else if (CounterTraceClassCalleeNGOLD2 >= CounterTraceClassCalleeTGOLD2) {
							data[j][MajorityClassLevelCallees] = "N";
						}
						if(true && methodtrace.getGold2()!=null && data[j][MajorityClassLevelCallees]!=null) {
						String Result=MajorityClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][MajorityClassLevelCallees].toString()); 
						MajorityClassLevelCalleesClassGold2.UpdateCounters(Result, MajorityClassLevelCalleesClassGold2);
						}
					}
				
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//MAJORITY CLASS LEVEL CALLERS PREDICTION 

					//FIRST IF makes sure there is a mixture 
					if((CounterTraceClassCallerTGOLD2!=0 || CounterTraceClassCallerNGOLD2!=0 ||CounterTraceClassCallerEGOLD2!=0)
							/*||
							(CounterTraceClassCalleeNGOLD2!=0 && CounterTraceClassCalleeEGOLD2!=0)
							||(CounterTraceClassCalleeTGOLD2!=0 && CounterTraceClassCalleeEGOLD2!=0)*/) {
						
						if(CounterTraceClassCallerTGOLD2==CounterTraceClassCallerNGOLD2 && CounterTraceClassCallerTGOLD2>0) {
							data[j][MajorityClassLevelCallers] = "T";
						}
						else if(CounterTraceClassCallerTGOLD2==0 && CounterTraceClassCallerNGOLD2==0 && CounterTraceClassCallerEGOLD2>0) {
							data[j][MajorityClassLevelCallers] = "E";
						}
						else if(CounterTraceClassCallerTGOLD2==0 && CounterTraceClassCallerNGOLD2>0 && CounterTraceClassCallerEGOLD2>0) {
							data[j][MajorityClassLevelCallers] = "N";
						}
						else if(CounterTraceClassCallerTGOLD2==0 && CounterTraceClassCallerNGOLD2>0 && CounterTraceClassCallerEGOLD2>0) {
							data[j][MajorityClassLevelCallers] = "E";
						}
						else if (CounterTraceClassCallerTGOLD2 >= CounterTraceClassCallerNGOLD2) {
							data[j][MajorityClassLevelCallers] = "T";
						} else if (CounterTraceClassCallerNGOLD2>=CounterTraceClassCallerTGOLD2)
							 {
							data[j][MajorityClassLevelCallers] = "N";
						} 
						if(flagGold2==false && methodtrace.getGold2()!=null) {
						String Result=MajorityClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][MajorityClassLevelCallers].toString()); 
						MajorityClassLevelCallersClassGold2.UpdateCounters(Result, MajorityClassLevelCallersClassGold2);
						}
					}
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					//MAJORITY METHOD LEVEL CALLEES PREDICTION 

					
					//FIRST IF makes sure there is a mixture 
					if((CountMethodTCalleeGOLD2!=0 || CountMethodNCalleeGOLD2!=0 || CountMethodECalleeGOLD2!=0)/*||
							(CountMethodNCalleeGOLD2!=0 && CountMethodECalleeGOLD2!=0)
							||(CountMethodTCalleeGOLD2!=0 && CountMethodECalleeGOLD2!=0)*/) {
						if(CountMethodTCalleeGOLD2==CountMethodNCalleeGOLD2 && CountMethodTCalleeGOLD2>0) {
							data[j][MajorityMethodLevelCallees] = "T";
						}
						else if(CountMethodTCalleeGOLD2==0 && CountMethodNCalleeGOLD2==0 && CountMethodECalleeGOLD2>0) {
							data[j][MajorityMethodLevelCallees] = "E";
						}
						else if(CountMethodTCalleeGOLD2==0 && CountMethodNCalleeGOLD2>0 && CountMethodECalleeGOLD2>0) {
							data[j][MajorityMethodLevelCallees] = "N";
						} 
						
						else if(CountMethodTCalleeGOLD2>=CountMethodNCalleeGOLD2)
						 {
							data[j][MajorityMethodLevelCallees] = "T";
						}  else if (CountMethodNCalleeGOLD2 >= CountMethodTCalleeGOLD2
							
								) {
							data[j][MajorityMethodLevelCallees] = "N";
						}
					
						if(flagGold2==false && methodtrace.getGold2()!=null) {
						String Result=MajorityMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][MajorityMethodLevelCallees].toString()); 
						MajorityMethodLevelCalleesClassGold2.UpdateCounters(Result, MajorityMethodLevelCalleesClassGold2);
						}
					}
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//MAJORITY METHOD LEVEL CALLERS PREDICTION 
					
					//FIRST IF makes sure there is a mixture 
					if((CountMethodTGOLD2!=0 || CountMethodNGOLD2!=0|| CountMethodEGOLD2!=0 )/*||
							(CountMethodNGOLD2!=0 && CountMethodEGOLD2!=0)
							||(CountMethodTGOLD2!=0 && CountMethodEGOLD2!=0)*/) {
						
						if(CountMethodTGOLD2==CountMethodNGOLD2 && CountMethodTGOLD2>0) {
							data[j][MajorityMethodLevelCallers] = "T";
						}
						else if(CountMethodTGOLD2==0 && CountMethodNGOLD2==0 && CountMethodEGOLD2>0) {
							data[j][MajorityMethodLevelCallers] = "E";
						}
						else if(CountMethodTGOLD2==0 && CountMethodNGOLD2>0 && CountMethodEGOLD2>0) {
							data[j][MajorityMethodLevelCallers] = "N";
						}
						
						else if (CountMethodTGOLD2 >= CountMethodNGOLD2){
							data[j][MajorityMethodLevelCallers] = "T";
						}  else if (CountMethodNGOLD2 >= CountMethodTGOLD2
								
								) {
							data[j][MajorityMethodLevelCallers] = "N";
						}
						if(flagGold2==false && methodtrace.getGold2()!=null) {
						String Result=MajorityMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][MajorityMethodLevelCallers].toString()); 
						MajorityMethodLevelCallersClassGold2.UpdateCounters(Result, MajorityMethodLevelCallersClassGold2);
						}
					}
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//1AT LEAST 1N PREDICTION CLASS LEVEL CALLERS 
					
					
						
						
						
						if (CounterTraceClassCallerNGOLD2 >=1 )
								 {
							data[j][AtLeast1NPredictionClassLevelCallers] = "N";
							Object var= 	data[j][AtLeast1NPredictionClassLevelCallers]; 
							String NEWVAR=var.toString(); 
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AtLeastNPredictionClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast1NPredictionClassLevelCallers].toString()); 
							AtLeastNPredictionClassLevelCallersClassGold2.UpdateCounters(Result, AtLeastNPredictionClassLevelCallersClassGold2);
							}
						} 
					
						
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//2AT LEAST 1T PREDICTION CLASS LEVEL CALLERS 
					
					
						
						
						
						if (CounterTraceClassCallerTGOLD2 >=1 )
								 {
							data[j][AtLeast1TPredictionClassLevelCallers] = "T";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AtLeastTPredictionClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast1TPredictionClassLevelCallers].toString()); 
							AtLeastTPredictionClassLevelCallersClassGold2.UpdateCounters(Result, AtLeastTPredictionClassLevelCallersClassGold2);
							}
						} 
						
							
						
					
					
			
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//3AT LEAST 1N PREDICTION CLASS LEVEL CALLEES 
				
					
						
						
						
						if (CounterTraceClassCalleeNGOLD2 >=1 )
								 {
							data[j][AtLeast1NPredictionClassLevelCallees] = "N";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AtLeastNPredictionClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast1NPredictionClassLevelCallees].toString()); 
							AtLeastNPredictionClassLevelCalleesClassGold2.UpdateCounters(Result, AtLeastNPredictionClassLevelCalleesClassGold2);
							}
						} 
						
					
					
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
				
					//4AT LEAST 1T PREDICTION CLASS LEVEL CALLEES 
					
					
						
						
						
						if (CounterTraceClassCalleeTGOLD2 >=1 )
								 {
							data[j][AtLeast1TPredictionClassLevelCallees] = "T";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AtLeastTPredictionClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast1TPredictionClassLevelCallees].toString()); 
							AtLeastTPredictionClassLevelCalleesClassGold2.UpdateCounters(Result, AtLeastTPredictionClassLevelCalleesClassGold2);
							}
						} 
						
						
					
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					//5AT LEAST 1N PREDICTION METHOD LEVEL CALLERS 
					
					
						
						
						if (CountMethodNGOLD2 >=1 )
								 {
							data[j][AtLeast1NPredictionMethodLevelCallers] = "N";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AtLeastNPredictionMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast1NPredictionMethodLevelCallers].toString()); 
							AtLeastNPredictionMethodLevelCallersClassGold2.UpdateCounters(Result, AtLeastNPredictionMethodLevelCallersClassGold2);
							}
						} 
						
						
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					//6AT LEAST 1T PREDICTION METHOD LEVEL CALLERS 
				
					
						
						
						
						if (CountMethodTGOLD2 >=1 )
								 {
							data[j][AtLeast1TPredictionMethodLevelCallers] = "T";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AtLeastTPredictionMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast1TPredictionMethodLevelCallers].toString()); 
							AtLeastTPredictionMethodLevelCallersClassGold2.UpdateCounters(Result, AtLeastTPredictionMethodLevelCallersClassGold2);
							}
						} 
						
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//7AT LEAST 1N PREDICTION METHOD LEVEL CALLEES 
					
					
						
						
						
						if (CountMethodNCalleeGOLD2 >=1 )
								 {
							data[j][AtLeast1NPredictionMethodLevelCallees] = "N";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AtLeastNPredictionMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast1NPredictionMethodLevelCallees].toString()); 
							AtLeastNPredictionMethodLevelCalleesClassGold2.UpdateCounters(Result, AtLeastNPredictionMethodLevelCalleesClassGold2);
							}
						} 
						
					
			
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//8AT LEAST 1T PREDICTION METHOD LEVEL CALLEES 
					
					
						
						
						
						if (CountMethodTCalleeGOLD2 >=1 )
								 {
							data[j][AtLeast1TPredictionMethodLevelCallees] = "T";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AtLeastTPredictionMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast1TPredictionMethodLevelCallees].toString()); 
							AtLeastTPredictionMethodLevelCalleesClassGold2.UpdateCounters(Result, AtLeastTPredictionMethodLevelCalleesClassGold2);
							}
							}
						 
						
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						
						//AT LEAST 2N PREDICTION CLASS LEVEL CALLEES 
						
						
							
							
							
							if (CounterTraceClassCalleeNGOLD2 >=2 )
									 {
								data[j][AtLeast2NPredictionClassLevelCallees] = "N";
								Object var= 	data[j][AtLeast2NPredictionClassLevelCallees]; 
								String NEWVAR=var.toString(); 
								if(flagGold2==true && methodtrace.getGold2()!=null) {
									String Result=AtLeast2NPredictionClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast2NPredictionClassLevelCallees].toString()); 
									AtLeast2NPredictionClassLevelCalleesClassGold2.UpdateCounters(Result, AtLeast2NPredictionClassLevelCalleesClassGold2);
								}
							} 
						
							
						
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						
						//AT LEAST 2T PREDICTION CLASS LEVEL CALLEES 
						
						
							
							
							
							if (CounterTraceClassCalleeTGOLD2 >=2 )
							 {
						data[j][AtLeast2TPredictionClassLevelCallees] = "T";
						if(flagGold2==false && methodtrace.getGold2()!=null) {
						String Result=AtLeast2TPredictionClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast2TPredictionClassLevelCallees].toString()); 
						AtLeast2TPredictionClassLevelCalleesClassGold2.UpdateCounters(Result, AtLeast2TPredictionClassLevelCalleesClassGold2);
						}
					} 
								
							
						
						
				
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						
						//AT LEAST 2N PREDICTION METHOD LEVEL CALLERS 
					
						
							
							
							
							
							if (CountMethodNGOLD2 >=2 )
									 {
								data[j][AtLeast2NPredictionMethodLevelCallers] = "N";
								if(flagGold2==true && methodtrace.getGold2()!=null) {
								String Result=AtLeast2NPredictionMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast2NPredictionMethodLevelCallers].toString()); 
								AtLeast2NPredictionMethodLevelCallersClassGold2.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCallersClassGold2);
								}
							} 
							
							
						
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
						
							//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
							
							
								
								
								
								if (CounterTraceClassCallerTGOLD2 >=2 )
								 {
							data[j][AtLeast2TPredictionClassLevelCallers] = "T";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AtLeast2TPredictionClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast2TPredictionClassLevelCallers].toString()); 
							AtLeast2TPredictionClassLevelCallersClassGold2.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClassGold2);
							}
						} 
						
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/
					
						//AT LEAST 2T PREDICTION METHOD LEVEL CALLERS 
						
						
							
							
							
							if (CountMethodTGOLD2 >=2 )
							 {
						data[j][AtLeast2TPredictionMethodLevelCallers] = "T";
						if(flagGold2==false && methodtrace.getGold2()!=null) {
						String Result=AtLeast2TPredictionMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast2TPredictionMethodLevelCallers].toString()); 
						AtLeast2TPredictionMethodLevelCallersClassGold2.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClassGold2);
						}
					} 
							
							
						
						
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						//AT LEAST 2N PREDICTION METHOD LEVEL CALLEES 

							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
						
							
							
							if (CountMethodNCalleeGOLD2 >=2 )
							 {
						data[j][AtLeast2NPredictionMethodLevelCallees] = "N";
						if(flagGold2==false && methodtrace.getGold2()!=null) {
						String Result=AtLeast2NPredictionMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast2NPredictionMethodLevelCallees].toString()); 
						AtLeast2NPredictionMethodLevelCalleesClassGold2.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCalleesClassGold2);
						}	
					} 
							
							
						
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						//AT LEAST 2T PREDICTION METHOD LEVEL CALLEES 
					
						
							
							
							
							if (CountMethodTCalleeGOLD2 >=2 )
							 {
						data[j][AtLeast2TPredictionMethodLevelCallees] = "T";
						if(flagGold2==false && methodtrace.getGold2()!=null) {
							String Result=AtLeast2TPredictionMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast2TPredictionMethodLevelCallees].toString()); 
							AtLeast2TPredictionMethodLevelCalleesClassGold2.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCalleesClassGold2);

						}
						
					} 
							
						
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						
						//AT LEAST 2N PREDICTION CLASS LEVEL CALLERS 
						
						
							
							
							
							if (CounterTraceClassCallerNGOLD2 >=2 )
							 {
						data[j][AtLeast2NPredictionClassLevelCallers] = "N";
						if(flagGold2==false && methodtrace.getGold2()!=null) {
						String Result=AtLeast2NPredictionClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast2NPredictionClassLevelCallers].toString()); 
						AtLeast2NPredictionClassLevelCallersClassGold2.UpdateCounters(Result, AtLeast2NPredictionClassLevelCallersClassGold2);
						
						}
					} 
					
						
				
						
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						
						//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
						
						
							
							
							
							if (CounterTraceClassCallerTGOLD2 >=2 )
							 {
						data[j][AtLeast2TPredictionClassLevelCallers] = "T";
						if(flagGold2==false && methodtrace.getGold2()!=null) {
							String Result=AtLeast2TPredictionClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AtLeast2TPredictionClassLevelCallers].toString()); 
							AtLeast2TPredictionClassLevelCallersClassGold2.UpdateCounters(Result, AtLeast2TPredictionClassLevelCallersClassGold2);

						}
						
						}
							
							
							
							
							
							
							
							
							
							
							
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/	 
					//ALL T METHOD LEVEL CALLEES 
					
					
					if(CountMethodNCalleeGOLD2==0 && CountMethodECalleeGOLD2==0 && CountMethodTCalleeGOLD2>=1) {
						
						
						
							
							data[j][AllTMethodLevelCallees] = "T";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AllTMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AllTMethodLevelCallees].toString()); 
							AllTMethodLevelCalleesClassGold2.UpdateCounters(Result, AllTMethodLevelCalleesClassGold2);
							}
					}
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//ALL T METHOD LEVEL CALLERS 
					
					if(CountMethodNGOLD2==0 && CountMethodEGOLD2==0  && CountMethodTGOLD2>=1) {
						
						
						
					
							data[j][AllTMethodLevelCallers] = "T";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AllTMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AllTMethodLevelCallers].toString()); 
							AllTMethodLevelCallersClassGold2.UpdateCounters(Result, AllTMethodLevelCallersClassGold2);
							
							}
						
					}
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//ALL T CLASS LEVEL CALLERS 
					
					
					if(CounterTraceClassCallerEGOLD2==0 && CounterTraceClassCallerNGOLD2==0 && CounterTraceClassCallerTGOLD2>=1) {
						
						
					
							data[j][AllTClassLevelCallers] = "T";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AllTClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AllTClassLevelCallers].toString()); 
							AllTClassLevelCallersClassGold2.UpdateCounters(Result, AllTClassLevelCallersClassGold2);
							System.out.println(methodtrace.toString());
							
							}
							
							
							}
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//ALL T CLASS LEVEL CALLEES 
					
					
					if(CounterTraceClassCalleeEGOLD2==0 && CounterTraceClassCalleeNGOLD2==0 && CounterTraceClassCalleeTGOLD2>=1) {
						
						
						
					
							data[j][AllTClassLevelCallees] = "T";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AllTClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AllTClassLevelCallees].toString()); 
							AllTClassLevelCalleesClassGold2.UpdateCounters(Result, AllTClassLevelCalleesClassGold2);
					
							
							}
					}
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//ALL N CLASS LEVEL CALLERS 
					
					
				
						
					if(CounterTraceClassCallerTGOLD2==0 && CounterTraceClassCallerEGOLD2==0 && CounterTraceClassCallerNGOLD2>=1) {
						
					
							data[j][AllNClassLevelCallers] = "N";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AllNClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AllNClassLevelCallers].toString()); 
							AllNClassLevelCallersClassGold2.UpdateCounters(Result, AllNClassLevelCallersClassGold2);
							if(Result!=null) {
								System.out.println("MY RESULT "+Result);
								if(Result.equals("FN")) {
									bwlog2.write("***********************************"); 
									bwlog2.newLine();
									bwlog2.write(methodtrace.toString());
									bwlog2.newLine();
									for(Method2Representation call: methodtrace.getCallersList()) {
										bwlog2.write("callerlist "+ call.toString2());
										
										 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 
										 if(trace2!=null) {
											 bwlog2.newLine();
											 bwlog2.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
											
											
										 }
										 bwlog2.newLine();
									}
									for(Method2Representation call: methodtrace.getCallersListExecuted()) {
										bwlog2.write("callerlistEXEC "+ call.toString2());
										bwlog2.newLine();
										 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 

										 if(trace2!=null) {
											 bwlog2.newLine();
											 bwlog2.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
											
											
										 }
										 bwlog2.newLine();
									}
									for(Method2Representation call: methodtrace.getCalleesList()) {
										bwlog2.write("calleelist "+ call.toString2());
										bwlog2.newLine();
										 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 

										 if(trace2!=null) {
											 bwlog2.newLine();
											 bwlog2.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
											
											
										 }
										 bwlog2.newLine();
									}
									for(Method2Representation call: methodtrace.getCalleesListExecuted()) {
										bwlog2.write("calleelistEXEC "+ call.toString2());
										bwlog2.newLine();
										 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()); 

										 if(trace2!=null) {
											 bwlog2.newLine();
											 bwlog2.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.classid,methodtrace.Requirement.getID()).gettrace());
											
											
										 }
										 bwlog2.newLine();
									}
									bwlog2.write("***********************************"); 
									bwlog2.newLine();
								}
							}
							}
							
							
					}
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//ALL N CLASS LEVEL CALLEES 
					
					
			
						
						if(CounterTraceClassCalleeTGOLD2==0 && CounterTraceClassCalleeEGOLD2==0 && CounterTraceClassCalleeNGOLD2>=1) {
						
					
							data[j][AllNClassLevelCallees] = "N";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AllNClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AllNClassLevelCallees].toString()); 
							AllNClassLevelCalleesClassGold2.UpdateCounters(Result, AllNClassLevelCalleesClassGold2);
							
							}
						
					}
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//ALL N METHOD LEVEL CALLERS 
					
					
				
						
						if(CountMethodTGOLD2==0 && CountMethodEGOLD2==0 && CountMethodNGOLD2>=1) {	
						
					
							data[j][AllNMethodLevelCallers] = "N";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
							String Result=AllNMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AllNMethodLevelCallers].toString()); 
							AllNMethodLevelCallersClassGold2.UpdateCounters(Result, AllNMethodLevelCallersClassGold2);
							
							}
					}
					
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					/**************************************************************************************************************/
					
					//ALL N METHOD LEVEL CALLEES 
					
					
				
						
						if(CountMethodTCalleeGOLD2==0 && CountMethodECalleeGOLD2==0 && CountMethodNCalleeGOLD2>=1) {
						
					
							data[j][AllNMethodLevelCallees] = "N";
							if(flagGold2==true && methodtrace.getGold2()!=null) {
								String Result=AllNMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AllNMethodLevelCallees].toString()); 
								AllNMethodLevelCalleesClassGold2.UpdateCounters(Result, AllNMethodLevelCalleesClassGold2);
							}
						
							
					}
				//}
						
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						/**************************************************************************************************************/
						
						//ALL N METHOD LEVEL CALLERS CALLEES 
						
						
					
							
							if(CountMethodTCalleeGOLD2==0 && CountMethodTGOLD2==0 && CountMethodNCalleeGOLD2>=1 && CountMethodNGOLD2>=1) {
							
						
								data[j][AllNMethodLevelCallersCallees] = "N";
								if(flagGold2==false && methodtrace.getGold2()!=null) {
									String Result=AllNMethodLevelCallersCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AllNMethodLevelCallersCallees].toString()); 
									AllNMethodLevelCallersCalleesClassGold2.UpdateCounters(Result, AllNMethodLevelCallersCalleesClassGold2);
								}
							
								
						}
					//}
							
							
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							/**************************************************************************************************************/
							
							//ALL T METHOD LEVEL CALLERS CALLEES 
							
							
						
								
								if(CountMethodNGOLD2==0 && CountMethodNCalleeGOLD2==0 && CountMethodTCalleeGOLD2>=1 && CountMethodTGOLD2>=1) {
								
							
									data[j][AllTMethodLevelCallersCallees] = "T";
									if(flagGold2==false && methodtrace.getGold2()!=null) {
										String Result=AllTMethodLevelCallersCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AllTMethodLevelCallersCallees].toString()); 
										AllTMethodLevelCallersCalleesClassGold2.UpdateCounters(Result, AllTMethodLevelCallersCalleesClassGold2);
									}
								
									
							}
								
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL N CLASS LEVEL CALLERS CALLEES 
								
								
							
									
									if(CounterTraceClassCalleeTGOLD2==0 && CounterTraceClassCallerTGOLD2==0 && CounterTraceClassCalleeNGOLD2>=1 && CounterTraceClassCallerNGOLD2>=1) {
									
								
										data[j][AllNClassLevelCallersCallees] = "N";
										if(flagGold2==false && methodtrace.getGold2()!=null) {
											String Result=AllNClassLevelCallersCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AllNClassLevelCallersCallees].toString()); 
											AllNClassLevelCallersCalleesClassGold2.UpdateCounters(Result, AllNClassLevelCallersCalleesClassGold2);
										}
									
										
								}
							//}
									
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL T CLASS LEVEL CALLERS CALLEES 
									
									
								
										
										if(CounterTraceClassCalleeNGOLD2==0 && CounterTraceClassCallerNGOLD2==0 && CounterTraceClassCalleeTGOLD2>=1 && CounterTraceClassCallerTGOLD2>=1) {
										
									
											data[j][AllTClassLevelCallersCallees] = "T";
											if(flagGold2==false && methodtrace.getGold2()!=null) {
												String Result=AllTClassLevelCallersCalleesClassGold2.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][AllTClassLevelCallersCallees].toString()); 
												AllTClassLevelCallersCalleesClassGold2.UpdateCounters(Result, AllTClassLevelCallersCalleesClassGold2);
											}
										
											
									}
					
										
					
					
					
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										//ACHRAF
										if(CountMethodTACHRAF>0 && CountMethodTACHRAFCallee>0) {
											
											boolean entered=false; 
											if(CountMethodNACHRAF+CountMethodNACHRAFCallee==0 && methodtrace.getGold()!=null ) {
												
												TracePureGold++; 
												entered=true; 
												
											} else {
												TraceMixedGold++; 
												entered=true; 
											}
										
											if(entered==true) {
											if(methodtrace.getGold()!=null && methodtrace.getGold().trim().equals("T")) {
												TraceCountTotal++; 
												
											}
											else if(methodtrace.getGold()!=null && methodtrace.getGold().trim().equals("N")) {
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
										if(CountMethodTACHRAF+CountMethodTACHRAFCallee==0 && methodtrace.getGold()!=null ) {
											NoTracePureGold++; 
											entered=true; 
											
											
										} else {
											NoTraceMixedGold++; 
											entered=true; 
										}
										
										if(entered==true) {
										if(methodtrace.getGold()!=null && methodtrace.getGold().trim().equals("N")) {
											
											NoTraceCountTotal++; 
										}
											else if(methodtrace.getGold()!=null && methodtrace.getGold().trim().equals("T")) {
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
										
					if(CountMethodTACHRAFGold2>0 && CountMethodTACHRAFCalleeGold2>0) {
											
						boolean entered=false; 
											if(CountMethodNACHRAFGold2+CountMethodNACHRAFCalleeGold2==0 && methodtrace.getGold2()!=null ) {
											
												TracePureGold2++; 
												
												entered=true; 
											} else {
												TraceMixedGold2++; 
												entered=true; 
											}
											if(entered==true) {
											data[j][ACHRAFTRACE]="T"; 
											if(methodtrace.getGold2()!=null ) {
											String Result=ACHRAFGold2Trace.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][ACHRAFTRACE].toString()); 
											ACHRAFGold2Trace.UpdateCounters(Result, ACHRAFGold2Trace);	
											}
											
											if(methodtrace.getGold2()!=null && methodtrace.getGold2().trim().equals("T")) {
												TraceCountTotalGold2++; 
											}
											else if(methodtrace.getGold2()!=null && methodtrace.getGold2().trim().equals("N")) {
												NoTraceCountTotalGold2++; 
											}
											}
									}


					else if(CountMethodNACHRAFGold2>0 && CountMethodNACHRAFCalleeGold2>0) {
										
										boolean entered=false; 
										if(CountMethodTACHRAFGold2+CountMethodTACHRAFCalleeGold2==0 && methodtrace.getGold2()!=null ) {
											NoTracePureGold2++; 
											entered=true; 
											}else {
												NoTraceMixedGold2++; 
												entered=true; 
											}
											if(entered==true) {
												data[j][ACHRAFNOTRACE]="N"; 
												if(methodtrace.getGold2()!=null ) {
												String Result=ACHRAFGold2NOTrace.ComparePredictionToGold(methodtrace.getGold2().trim(), data[j][ACHRAFNOTRACE].toString()); 
												ACHRAFGold2NOTrace.UpdateCounters(Result, ACHRAFGold2NOTrace);
											
										
											}
											if(methodtrace.getGold2()!=null && methodtrace.getGold2().trim().equals("N")) {
												NoTraceCountTotalGold2++; 
												
											
										} 
											else	if(methodtrace.getGold2()!=null && methodtrace.getGold2().trim().equals("T")) {
												TraceCountTotalGold2++; 
											}
											}
								}else {
									failGold2++; 
								}
									
									
									
									
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					


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

	

			bw.write(data[j][Row] + "," +data[j][MethodID] + "," + data[j][MethodName] + "," + data[j][RequirementID] + "," + data[j][RequirementName] + "," + data[j][ClassID] + ","
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
							+","+data[j][AtLeast1TParameter]+","+data[j][AtLeast2TParameter]+","+data[j][AtLeast2NParameter]+","+data[j][AllNParameters]+","+data[j][AllTParameters]+","+methodtrace.gold2);
				
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
		bw2.write("ALL N CLASS LEVEL CALLERS CALLEES: "+AllNClassLevelCallersCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("ACHRAF TRACE: "+ACHRAFTrace.toString()); 
		bw2.newLine();
		bw2.write("ACHRAF NO TRACE: "+ACHRAFNOTrace.toString()); 
		bw2.newLine();
		bw2.close();
		
		
		
		
		
		bwGold2.write("OWNER CLASS PREDICTION: "+OwnerClassPredictionClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("MAJORITY CLASS LEVEL CALLERS PREDICTION: "+MajorityClassLevelCallersClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("MAJORITY CLASS LEVEL CALLEES PREDICTION: "+MajorityClassLevelCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("MAJORITY METHOD LEVEL CALLERS PREDICTION: "+MajorityMethodLevelCallersClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("MAJORITY METHOD LEVEL CALLEES PREDICTION: "+MajorityMethodLevelCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 1 N PREDICTION CLASS LEVEL CALLERS: "+AtLeastNPredictionClassLevelCallersClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 1 N PREDICTION CLASS LEVEL CALLEES: "+AtLeastNPredictionClassLevelCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 1 N PREDICTION METHOD LEVEL CALLERS: "+AtLeastNPredictionMethodLevelCallersClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 1 N PREDICTION METHOD LEVEL CALLEES: "+AtLeastNPredictionMethodLevelCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 1 T PREDICTION CLASS LEVEL CALLERS: "+AtLeastTPredictionClassLevelCallersClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 1 T PREDICTION CLASS LEVEL CALLEES: "+AtLeastTPredictionClassLevelCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 1 T PREDICTION METHOD LEVEL CALLERS: "+AtLeastTPredictionMethodLevelCallersClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 1 T PREDICTION METHOD LEVEL CALLEES: "+AtLeastTPredictionMethodLevelCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 2 N PREDICTION CLASS LEVEL CALLERS: "+AtLeast2NPredictionClassLevelCallersClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 2 N PREDICTION CLASS LEVEL CALLEES: "+AtLeast2NPredictionClassLevelCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 2 N PREDICTION METHOD LEVEL CALLERS: "+AtLeast2NPredictionMethodLevelCallersClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 2 N PREDICTION METHOD LEVEL CALLEES: "+AtLeast2NPredictionMethodLevelCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 2 T PREDICTION CLASS LEVEL CALLERS: "+AtLeast2TPredictionClassLevelCallersClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 2 T PREDICTION CLASS LEVEL CALLEES: "+AtLeast2TPredictionClassLevelCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 2 T PREDICTION METHOD LEVEL CALLERS: "+AtLeast2TPredictionMethodLevelCallersClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 2 T PREDICTION METHOD LEVEL CALLEES: "+AtLeast2TPredictionMethodLevelCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL N CLASS LEVEL CALLERS: "+AllNClassLevelCallersClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL N CLASS LEVEL CALLEES: "+AllNClassLevelCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL N METHOD LEVEL CALLERS: "+AllNMethodLevelCallersClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL N METHOD LEVEL CALLEES: "+AllNMethodLevelCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL T CLASS LEVEL CALLERS: "+AllTClassLevelCallersClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL T CLASS LEVEL CALLEES: "+AllTClassLevelCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL T METHOD LEVEL CALLERS: "+AllTMethodLevelCallersClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL T METHOD LEVEL CALLEES: "+AllTMethodLevelCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("MAJORITY PARAMETERS CLASS: "+MajorityParametersClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 1N PARAMETER CLASS: "+AtLeast1NParameterClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 1T PARAMETER CLASS: "+AtLeast1TParameterClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 2T PARAMETER CLASS: "+AtLeast2TParameterClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("AT LEAST 2N PARAMETER CLASS: "+AtLeast2NParameterClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL N PARAMETERS: "+AllNParameterClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL T PARAMETERS: "+AllTParameterClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL T METHOD LEVEL CALLERS CALLEES: "+AllTMethodLevelCallersCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL N METHOD LEVEL CALLERS CALLEES: "+AllNMethodLevelCallersCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL T CLASS LEVEL CALLERS CALLEES: "+AllTClassLevelCallersCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL N CLASS LEVEL CALLERS CALLEES: "+AllNClassLevelCallersCalleesClassGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ACHRAF TRACE: "+ACHRAFTrace.toString()); 
		bwGold2.newLine();
		bwGold2.write("ACHRAF NO TRACE: "+ACHRAFNOTrace.toString()); 
		bwGold2.newLine();
		bwGold2.close();
		

		
		
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

				if (modelColumn == 48 && row < methodtraces2.size())
					return editors1.get(row);
				if (modelColumn == 49 && row < methodtraces2.size())
					return editors3.get(row);
				if (modelColumn == 51 && row < methodtraces2.size())
					return myparametersEditor.get(row);
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
			      else if(column==AtLeast2NPredictionClassLevelCallees || column==AtLeast2NPredictionClassLevelCallers || column==AtLeast2NPredictionMethodLevelCallers || column==AtLeast2NPredictionMethodLevelCallees){
			    	  label.setBackground(LIGHTBLUE);
			      }
			      
			      else if(column==AtLeast2TPredictionClassLevelCallers || column==AtLeast2TPredictionClassLevelCallees || column==AtLeast2TPredictionMethodLevelCallers || column==AtLeast2TPredictionMethodLevelCallees){
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

		TracesTableiTrustGold2PredictionFINAL frame = new TracesTableiTrustGold2PredictionFINAL();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static List<Method2Representation> removeDuplicates(List<Method2Representation> list) {
		  // convert input array to populated list

		  // convert list to populated set
		  
		  
		
		  HashSet<Method2Representation> set=new HashSet(list); 
		  set.addAll(list);
		 
		  list = new ArrayList<Method2Representation>(set);
		  // convert set to array & return, 
		  // use cast because you can't create generic arrays
		  return list;
		}	
}



