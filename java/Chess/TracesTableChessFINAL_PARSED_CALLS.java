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
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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

import mypackage.Clazz;
import mypackage.ClassTrace2;
import mypackage.ColumnGroup;
import mypackage.DatabaseReading2;
import mypackage.GroupableTableHeader;
import mypackage.Interface2;
import mypackage.Method2Details;
import mypackage.Method;
import mypackage.MethodTrace2;
import mypackage.Parameter2;
import mypackage.Requirement2;
import mypackage.RequirementGold;

public class TracesTableChessFINAL_PARSED_CALLS extends JFrame {
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
	
	int ACHRAFTRACEPureGold=71; 
	int ACHRAFTRACEMixedGold=72; 
	int ACHRAFNOTRACEPureGold=73; 
	int ACHRAFNOTRACEMixedGold=74; 
	int AllNMethodLevelCallersCallees=75; 
	int AllTMethodLevelCallersCallees=76; 
	int AllTClassLevelCallersCallees=77; 
	int AllNClassLevelCallersCallees=78; 
	int AllNClassLevelCalleesAtLeast2NGOLD=79; 
	int AllNClassLevelCallersAtLeast2NGOLD=80; 
	int AllNMethodLevelCalleesAtLeast2NGOLD=81; 
	int AllNMethodLevelCallersAtLeast2NGOLD=82;
	int AllTClassLevelCalleesAtLeast2TGOLD=83; 
	int AllTClassLevelCallersAtLeast2TGOLD=84; 
	int AllTMethodLevelCalleesAtLeast2TGOLD=85; 
	int AllTMethodLevelCallersAtLeast2TGOLD=86;
	int CLASSTRACEMethodLevelPureGold=87; 
	int CLASSTRACEMethodLevelMixedGold=88; 
	int CLASSNOTRACEMethodLevelPureGold=89; 
	int CLASSNOTRACEMethodLevelMixedGold=90;
	int CLASSTRACEClassLevelPureGold=91; 
	int CLASSTRACEClassLevelMixedGold=92; 
	int CLASSNOTRACEClassLevelPureGold=93; 
	int CLASSNOTRACEClassLevelMixedGold=94;
	
	
	
	int Gold2=95; 
	int OwnerClassTGOLD2=96; 
	int OwnerClassNGOLD2=97; 
	int OwnerClassEGOLD2=98; 
	int CallerMethodsNumberGOLD2=99; 
	int CallerMethodsTGOLD2=100; 
	int CallerMethodsNGOLD2=101; 
	int CallerMethodsEGOLD2=102; 
	int CallerClassesNumberGOLD2=103; 
	int CallerClassesTGOLD2=104; 
	int CallerClassesNGOLD2=105; 
	int CallerClassesEGOLD2=106; 
	int CalleeMethodsNumberGOLD2=107; 
	int CalleeMethodsTGOLD2=108; 
	int CalleeMethodsNGOLD2=109; 
	int CalleeMethodsEGOLD2=110; 
	int CalleeClassesNumberGOLD2=111; 
	int CalleeClassesTGOLD2=112; 
	int CalleeClassesNGOLD2=113; 
	int CalleeClassesEGOLD2=114; 
	int OwnerClassPredictionGOLD2=115; 
	int MajorityClassLevelCalleesGOLD2=116; 
	int MajorityClassLevelCallersGOLD2=117; 
	int MajorityMethodLevelCalleesGOLD2=118; 
	int MajorityMethodLevelCallersGOLD2=119; 
	int AtLeast1NPredictionClassLevelCalleesGOLD2=120; 
	int AtLeast1NPredictionClassLevelCallersGOLD2=121; 
	int AtLeast1NPredictionMethodLevelCalleesGOLD2=122; 
	int AtLeast1NPredictionMethodLevelCallersGOLD2=123; 
	int AtLeast1TPredictionClassLevelCalleesGOLD2=124; 
	int AtLeast1TPredictionClassLevelCallersGOLD2=125; 
	int AtLeast1TPredictionMethodLevelCalleesGOLD2=126; 
	int AtLeast1TPredictionMethodLevelCallersGOLD2=127; 
	int AtLeast2NPredictionClassLevelCalleesGOLD2=128; 
	int AtLeast2NPredictionClassLevelCallersGOLD2=129; 
	int AtLeast2NPredictionMethodLevelCalleesGOLD2=130; 
	int AtLeast2NPredictionMethodLevelCallersGOLD2=131; 
	int AtLeast2TPredictionClassLevelCalleesGOLD2=132; 
	int AtLeast2TPredictionClassLevelCallersGOLD2=133; 
	int AtLeast2TPredictionMethodLevelCalleesGOLD2=134; 
	int AtLeast2TPredictionMethodLevelCallersGOLD2=135; 
	int AllNClassLevelCalleesGOLD2=136; 
	int AllNClassLevelCallersGOLD2=137; 
	int AllNMethodLevelCalleesGOLD2=138; 
	int AllNMethodLevelCallersGOLD2=139; 
	int AllTClassLevelCalleesGOLD2=140; 
	int AllTClassLevelCallersGOLD2=141; 
	int AllTMethodLevelCalleesGOLD2=142; 
	int AllTMethodLevelCallersGOLD2=143; 
	int CallersGOLD2=144; 
	int CalleesGOLD2=145; 
	int paramatersNumberGOLD2=146; 
	int CountParamaterTGOLD2=147; 
	int CountParamaterNGOLD2=148; 
	int CountParamaterEGOLD2=149; 
	int MajorityParametersGOLD2=150; 
	int AtLeast1NParameterGOLD2=151; 
	int AtLeast1TParameterGOLD2=152; 
	int AtLeast2TParameterGOLD2=153; 
	int AtLeast2NParameterGOLD2=154; 
	int AllNParametersGOLD2=155; 
	int AllTParametersGOLD2=156; 
	int ACHRAFTRACEPureGOLD2=157; 
	int ACHRAFTRACEMixedGOLD2=158; 
	int ACHRAFNOTRACEPureGOLD2=159; 
	int ACHRAFNOTRACEMixedGOLD2=160; 
	int AllNMethodLevelCallersCalleesGOLD2=161; 
	int AllTMethodLevelCallersCalleesGOLD2=162; 
	int AllTClassLevelCallersCalleesGOLD2=163; 
	int AllNClassLevelCallersCalleesGOLD2=164; 
	int AllNClassLevelCalleesAtLeast2NGOLD2=165; 
	int AllNClassLevelCallersAtLeast2NGOLD2=166; 
	int AllNMethodLevelCalleesAtLeast2NGOLD2=167; 
	int AllNMethodLevelCallersAtLeast2NGOLD2=168; 
	int AllTClassLevelCalleesAtLeast2TGOLD2=169; 
	int AllTClassLevelCallersAtLeast2TGOLD2=170; 
	int AllTMethodLevelCalleesAtLeast2TGOLD2=171; 
	int AllTMethodLevelCallersAtLeast2TGOLD2=172; 
	int CLASSTRACEMethodLevelPureGold2=173; 
	int CLASSTRACEMethodLevelMixedGold2=174; 
	int CLASSNOTRACEMethodLevelPureGold2=175; 
	int CLASSNOTRACEMethodLevelMixedGold2=176;
	int CLASSTRACEClassLevelPureGold2=177; 
	int CLASSTRACEClassLevelMixedGold2=178; 
	int CLASSNOTRACEClassLevelPureGold2=179; 
	int CLASSNOTRACEClassLevelMixedGold2=180;
	
	
	
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
	PredictionEvaluation AllNClassLevelsCallersCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation AllNParameterClass= new PredictionEvaluation(); 
	PredictionEvaluation AllTParameterClass= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFTracePureGold= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFTraceMixedGold= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTracePureGold= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTraceMixedGold= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCalleesClassAtLeast2NGold=new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersClassAtLeast2NGold=new PredictionEvaluation();  
	PredictionEvaluation AllNMethodLevelCalleesClassAtLeast2NGold=new PredictionEvaluation();  
	PredictionEvaluation AllNMethodLevelCallersClassAtLeast2NGold=new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCalleesClassAtLeast2TGold=new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersClassAtLeast2TGold=new PredictionEvaluation();  
	PredictionEvaluation AllTMethodLevelCalleesClassAtLeast2TGold=new PredictionEvaluation();  
	PredictionEvaluation AllTMethodLevelCallersClassAtLeast2TGold=new PredictionEvaluation(); 
	PredictionEvaluation PredictionCLASSTRACEMethodLevelPureGold=new PredictionEvaluation(); 
	PredictionEvaluation PredictionCLASSTRACEMethodLevelMixedGold=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelPureGold=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelMixedGold=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSTRACEClassLevelPureGold=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSTRACEClassLevelMixedGold=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelPureGold=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelMixedGold=new PredictionEvaluation();  
	
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
	PredictionEvaluation AllNClassLevelCallersCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFTracePureGold2= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFTraceMixedGold2= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTracePureGold2= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTraceMixedGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCallersCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCallersCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersCalleesClassGold2= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFGold2Trace= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFGold2NOTrace= new PredictionEvaluation(); 
	PredictionEvaluation PureNCallersGold2= new PredictionEvaluation(); 
	PredictionEvaluation PureTCallersGold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCalleesClassAtLeast2NGold2=new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersClassAtLeast2NGold2=new PredictionEvaluation();  
	PredictionEvaluation AllNMethodLevelCalleesClassAtLeast2NGold2=new PredictionEvaluation();  
	PredictionEvaluation AllNMethodLevelCallersClassAtLeast2NGold2=new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCalleesClassAtLeast2TGold2=new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersClassAtLeast2TGold2=new PredictionEvaluation();  
	PredictionEvaluation AllTMethodLevelCalleesClassAtLeast2TGold2=new PredictionEvaluation();  
	PredictionEvaluation AllTMethodLevelCallersClassAtLeast2TGold2=new PredictionEvaluation(); 
	PredictionEvaluation PredictionCLASSTRACEMethodLevelPureGold2=new PredictionEvaluation(); 
	PredictionEvaluation PredictionCLASSTRACEMethodLevelMixedGold2=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelPureGold2=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelMixedGold2=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSTRACEClassLevelPureGold2=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSTRACEClassLevelMixedGold2=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelPureGold2=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelMixedGold2=new PredictionEvaluation();  

	
	ClassTrace2 myclasstrace = new ClassTrace2();
	static List<MethodTrace2> methodtraces2 = new ArrayList<MethodTrace2>();
	static List<ClassTrace2> classtraces2 = new ArrayList<ClassTrace2>();
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass = new  LinkedHashMap<String, ClassTrace2>(); 
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClassGOLD2 = new  LinkedHashMap<String, ClassTrace2>(); 

	 LinkedHashMap<String, Method2Details> linkedmethodhashmap= new LinkedHashMap<String, Method2Details>(); 
	 HashMap<String, Interface2> InterfacesHashMap= new HashMap<String, Interface2>();
	 HashMap<String, Interface2> InterfacesHashMapAlreadyImpl= new HashMap<String, Interface2>(); 


	JTable table = new JTable(); 
	static List<Method2Details> methodlist = new ArrayList<Method2Details>();
	//File fout = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\TableLog.txt");
	File fout = new File("C:\\Users\\mouna\\dumps\\TableLogChessPARSED.txt");

	FileOutputStream fos = new FileOutputStream(fout);
	
//	File fout2 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\PredictionEvaluationChess.txt");
	File fout2 = new File("C:\\Users\\mouna\\dumps\\PredictionEvaluationChessPARSED.txt");

	FileOutputStream fos2 = new FileOutputStream(fout2);
	
	//File foutGold2 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\PredictionEvaluationChessGold2.txt");
	File foutGold2 = new File("C:\\Users\\mouna\\dumps\\PredictionEvaluationChessGold2PARSED.txt");

	FileOutputStream fileGold2 = new FileOutputStream(foutGold2);
	
	File foutGold2TableLog = new File("C:\\Users\\mouna\\dumps\\TableLogChessGOLD2PARSED.txt");
	FileOutputStream fosGold2 = new FileOutputStream(foutGold2TableLog);
	BufferedWriter bwGold2TableLog = new BufferedWriter(new OutputStreamWriter(fosGold2));

	
	
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(fos2));
	BufferedWriter bwGold2 = new BufferedWriter(new OutputStreamWriter(fileGold2));
	File mylog = new File("C:\\Users\\mouna\\dumps\\logs\\logChessAllTClassLevelCallers.txt");
	FileOutputStream mylogfile = new FileOutputStream(mylog);
	BufferedWriter bwlog = new BufferedWriter(new OutputStreamWriter(mylogfile));
	
	File mylog2 = new File("C:\\Users\\mouna\\dumps\\logs\\logChessAllNClassLevelCallers.txt");
	FileOutputStream mylogfile2 = new FileOutputStream(mylog2);
	BufferedWriter bwlog2 = new BufferedWriter(new OutputStreamWriter(mylogfile2));
	
	File mylog3 = new File("C:\\Users\\mouna\\dumps\\logs\\logChessAllNParameters.txt");
	FileOutputStream mylogfile3 = new FileOutputStream(mylog3);
	BufferedWriter bwlog3 = new BufferedWriter(new OutputStreamWriter(mylogfile3));
	
	
	private final String userName = "root";
	private final String password = "123456";
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

	public TracesTableChessFINAL_PARSED_CALLS() throws SQLException, IOException {
	
		bwGold2TableLog.write("RowNumber, MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold2, Subject, OwnerClassT, OwnerClassN, "
				+ "OwnerClassE, #callermethods, callers, #callermethodsT, #callermethodsN, #callermethodsE, #callerclasses, #callerclassesT, #callerclassesN, "
				+ "#callerclassesE, #calleemethods, callees, #calleemethodsT, #calleemethodsN, #calleemethodsE, #calleeclasses, #calleeclassesT, #calleeclassesN, "
				+ "#calleeclassesE, OwnerClassPrediction, MajorityClassLevelCallees, MajorityClassLevelCallers, MajorityMethodLevelCallees, MajorityMethodLevelCallers,"
				+ "AtLeast1NPredictionClassLevelCallees, AtLeast1NPredictionClassLevelCallers, AtLeast1NPredictionMethodLevelCallees, AtLeast1NPredictionMethodLevelCallers, "
				+"AtLeast1TPredictionClassLevelCallees, AtLeast1TPredictionClassLevelCallers, AtLeast1TPredictionMethodLevelCallees, AtLeast1TPredictionMethodLevelCallers,"
				+ "AtLeast2NPredictionClassLevelCallees, AtLeast2NPredictionClassLevelCallers, AtLeast2NPredictionMethodLevelCallees, AtLeast2NPredictionMethodLevelCallers, "
				+"AtLeast2TPredictionClassLevelCallees, AtLeast2TPredictionClassLevelCallers, AtLeast2TPredictionMethodLevelCallees, AtLeast2TPredictionMethodLevelCallers,"
				+"AllNClassLevelCallees, AllNClassLevelCallers, AllNMethodLevelCallees, AllNMethodLevelCallers,"
				+"AllTClassLevelCallees, AllTClassLevelCallers, AllTMethodLevelCallees, AllTMethodLevelCallers,"
				+"AllNClassLevelCalleesAtLeast2, AllNClassLevelCallersAtLeast2, AllNMethodLevelCalleesAtLeast2, AllNMethodLevelCallersAtLeast2,"
				+"AllTClassLevelCalleesAtLeast2, AllTClassLevelCallersAtLeast2, AllTMethodLevelCalleesAtLeast2, AllTMethodLevelCallersAtLeast2,"
//				+ " OnlyInParsedCallers, OnlyInExecutedCallers, BothParsedAndExecutedCallers, "
//				+ "OnlyInParsedCallees, OnlyInExecutedCallees, BothParsedAndExecutedCallees,"
				+ " #parameters, parameters, # Parameter T, # Parameter N, # Parameter E," 
				+ "MajorityParameter ,AtLeast1NParameterPrediction," + 
				"AtLeast1TParameterPrediction, AtLeast2TParameterPrediction, AtLeast2NParameterPrediction,  AllNParameterPrediction, AllTParameterPrediction, "
				+"ACHRAFTracePure, ACHRAFTraceMixed, ACHRAFNoTracePure,  ACHRAFNoTraceMixed, AllNMethodLevelCallersCallees, AllTMethodLevelCallersCallees, "
				+ "AllTClassLevelCallersCallees, AllNClassLevelCallersCallees,"
				+"ClassTraceMethodLevelPure, ClassTraceMethodLevelMixed, ClassNoTraceMethodLevelPure, ClassNoTraceMethodLevelMixed,"
				+"ClassTraceClassLevelPure, ClassTraceClassLevelMixed, ClassNoTraceClassLevelPure, ClassNoTraceClassLevelMixed"
				 );

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
				+"AllNClassLevelCalleesAtLeast2, AllNClassLevelCallersAtLeast2, AllNMethodLevelCalleesAtLeast2, AllNMethodLevelCallersAtLeast2,"
				+"AllTClassLevelCalleesAtLeast2, AllTClassLevelCallersAtLeast2, AllTMethodLevelCalleesAtLeast2, AllTMethodLevelCallersAtLeast2,"
				
//				+ " OnlyInParsedCallers, OnlyInExecutedCallers, BothParsedAndExecutedCallers, "
//				+ "OnlyInParsedCallees, OnlyInExecutedCallees, BothParsedAndExecutedCallees,"
				+ " #parameters, parameters, # Parameter T, # Parameter N, # Parameter E," 
				+ "MajorityParameter ,AtLeast1NParameterPrediction," + 
				"AtLeast1TParameterPrediction, AtLeast2TParameterPrediction, AtLeast2NParameterPrediction,  AllNParameterPrediction, AllTParameterPrediction, "
				+"ACHRAFTracePure, ACHRAFTraceMixed, ACHRAFNoTracePure,  ACHRAFNoTraceMixed, AllNMethodLevelCallersCallees, AllTMethodLevelCallersCallees, "
				+ "AllTClassLevelCallersCallees, AllNClassLevelCallersCallees,"
				+"ClassTraceMethodLevelPure, ClassTraceMethodLevelMixed, ClassNoTraceMethodLevelPure, ClassNoTraceMethodLevelMixed,"
				+"ClassTraceClassLevelPure, ClassTraceClassLevelMixed, ClassNoTraceClassLevelPure, ClassNoTraceClassLevelMixed,"
				+"gold2" );





		
		bw.newLine();
		bwGold2TableLog.newLine();
		DatabaseReading2 db = new DatabaseReading2();
		DatabaseReading2.MakePredictions();
		methodtraces2 = db.getMethodtraces2();
		classtraces2 = db.getClassestraces2();
	//	methodlist = db.getMethodlist();
		 methodtracesRequirementClass = db.getClassesRequirementtraceshashmap(); 
		 InterfacesHashMap = db.getInterfaces();
		  linkedmethodhashmap = db.getLinkedmethodhashmap(); 
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
		Method[] callersarr = new Method[methodtraces2.size()];
		Method[] callersex = new Method[methodtraces2.size()];
		Method[] calleesarr = new Method[methodtraces2.size()];
		Method[] calleesex = new Method[methodtraces2.size()];
		Object[][] data = new Object[methodtraces2.size()][400];
		int myfinalcounter=1; 
		int MethodTraceCountGold=0; 
		int ClassTraceCount=0; 
		int MethodTraceCountGold2=0; 
		// Create the editors to be used for each row
		for (MethodTrace2 methodtrace : methodtraces2) {
			data[j][Row] = j; 
			data[j][MethodID] = methodtrace.MethodRepresentation.getMethodid();
			data[j][MethodName] = methodtrace.MethodRepresentation.getFullmethodname(); 
			data[j][MethodName] =	data[j][MethodName].toString().replaceAll(",", "/"); 
			data[j][RequirementID] = methodtrace.Requirement.getID();
			data[j][RequirementName] = methodtrace.Requirement.getRequirementName();
			data[j][ClassID] = methodtrace.ClassRepresentation.ID;
			data[j][ClassName] = methodtrace.ClassRepresentation.classname;
			data[j][Gold] = methodtrace.gold;
			data[j][Subject] = methodtrace.subject;
			data[j][Gold2] = methodtrace.goldfinal;
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
			
			data[j][CallerClassesTGOLD2] = 0;
			data[j][CallerClassesNGOLD2] = 0;
			data[j][CallerClassesEGOLD2] = 0;
			data[j][CallerMethodsTGOLD2] = 0;
			data[j][CallerMethodsNGOLD2] = 0;
			data[j][CallerMethodsEGOLD2] = 0;
			data[j][CalleeClassesTGOLD2] = 0;
			data[j][CalleeClassesNGOLD2] = 0;
			data[j][CalleeClassesEGOLD2] = 0;
			data[j][CalleeMethodsTGOLD2] = 0;
			data[j][CalleeMethodsNGOLD2] = 0;
			data[j][CalleeMethodsEGOLD2] = 0;
			data[j][CalleeMethodsNumberGOLD2] = 0;
			data[j][CallerMethodsNumberGOLD2] = 0;
			data[j][CallerClassesNumberGOLD2] = 0;
			data[j][CalleeClassesNumberGOLD2] = 0;
			data[j][CLASSTRACEClassLevelMixedGold] = "null";
			data[j][CLASSTRACEClassLevelPureGold] = "null";
			data[j][CLASSNOTRACEClassLevelMixedGold] = "null";
			data[j][CLASSNOTRACEClassLevelPureGold] = "null";
			data[j][CLASSTRACEClassLevelMixedGold2] = "null";
			data[j][CLASSTRACEClassLevelPureGold2] = "null";
			data[j][CLASSNOTRACEClassLevelMixedGold2] = "null";
			data[j][CLASSNOTRACEClassLevelPureGold2] = "null";
			
			data[j][CLASSTRACEMethodLevelMixedGold] = "null";
			data[j][CLASSTRACEMethodLevelPureGold] = "null";
			data[j][CLASSNOTRACEMethodLevelMixedGold] = "null";
			data[j][CLASSNOTRACEMethodLevelPureGold] = "null";
			data[j][CLASSTRACEMethodLevelMixedGold2] = "null";
			data[j][CLASSTRACEMethodLevelPureGold2] = "null";
			data[j][CLASSNOTRACEMethodLevelMixedGold2] = "null";
			data[j][CLASSNOTRACEMethodLevelPureGold2] = "null";
			String reqclass= data[j][RequirementID].toString()+"-"+ data[j][ClassID].toString(); 
			ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
			String trace = myclasstraceHashMap.gettrace().trim();
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
			
			
			if(myclasstraceHashMap.getTrace2()!=null) {
				String traceGOLD2 = myclasstraceHashMap.getTrace2();
				traceGOLD2=traceGOLD2.trim(); 
				if (traceGOLD2.equals("T")) {
					data[j][OwnerClassTGOLD2] = "1";
					data[j][OwnerClassNGOLD2] = "0";
					data[j][OwnerClassEGOLD2] = "0";
					System.out.println("OWNERCLASS T  "+j +" set to 1");
				} else if (traceGOLD2.equals("N")) {
					data[j][OwnerClassTGOLD2] = "0";
					data[j][OwnerClassNGOLD2] = "1";
					data[j][OwnerClassEGOLD2] = "0";
					System.out.println("OWNERCLASS N  "+j +" set to 1");
				} else if (traceGOLD2.equals("E")) {
					data[j][OwnerClassTGOLD2] = "0";
					data[j][OwnerClassNGOLD2] = "0";
					data[j][OwnerClassEGOLD2] = "1";
					System.out.println("OWNERCLASS E  "+j +" set to 1");
				}
				
			}
			
			
		
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
			int counterParameterTGOLD2=0; 
			int counterParameterNGOLD2=0; 
			int counterParameterEGOLD2=0; 
			 myparameters = new String[methodtraces2.size()];
			Method2Details mymethodobje = linkedmethodhashmap.get(methodtrace.MethodRepresentation.ID); 
			String ParametersAppended=""; 
			for ( Parameter2 myparam : mymethodobje.getParameters()) {
				myparameters[myparametercount] = myparam.toString(); 
				ParametersAppended=ParametersAppended+myparam.toString()+"-"; 
				myparametercount++;
				
				
				String ParameterClassid = myparam.getParameterType().ID; 
				
				ClassTrace2 mycallerclass = myclasstrace.FindTrace2(methodtracesRequirementClass, ParameterClassid,	methodtrace.Requirement.getID());
				if(mycallerclass!=null) {
					String mytrace=mycallerclass.gettrace().trim(); 
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
						}else if (mytrace2.equals("E")){
							counterParameterEGOLD2++; 
						}
					}
					
				}
				

			}
			ParametersAppended=ParametersAppended.replaceAll(",", "/"); 
			data [j][CountParamaterT]= counterParameterT; 
			data [j][CountParamaterN]= counterParameterN; 
			data [j][CountParamaterE]= counterParameterE; 
			
			
			data [j][CountParamaterTGOLD2]= counterParameterTGOLD2; 
			data [j][CountParamaterNGOLD2]= counterParameterNGOLD2; 
			data [j][CountParamaterEGOLD2]= counterParameterEGOLD2; 
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			//data [j][paramatersNumber]= myparametercount; 
			data [j][paramatersNumber]= counterParameterT+counterParameterN+counterParameterE; 

			data [j][paramatersNumberGOLD2]= counterParameterTGOLD2+counterParameterNGOLD2+counterParameterEGOLD2; 
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			for (Method caller : methodtrace.getCallersList()) {
				items1[CountCallers] = caller.toString2();
				callersarr[CountCallers] = caller;
				System.out.println(caller.toString2());
				CountCallers++;
				
				
				
				
				

			}

//			int CountCallersExecuted = 0;
//			items2 = new String[methodtrace.getCallersListExecuted().size()];
//			callersex = new Method2Representation[methodtrace.getCallersListExecuted().size()];
//			for (Method2Representation caller : methodtrace.getCallersListExecuted()) {
//
//				boolean equalbool = false;
//				if (items1.length == 0) {
//					items2[CountCallersExecuted] = caller.toString2();
//					callersex[CountCallersExecuted] = caller;
//				
//						
//					
//					CountCallersExecuted++;
//					OnlyinExecutedCallers++; 
//
//				} else {
//					for (String item : items1) {
//						item = item.replaceAll("\\(.*\\)", "");
//
//						if (item.equals(caller.toString2()) == true) {
//							BothParsedAndExecutedCallers++; 
//							equalbool = true;
//						}
//					}
//					if (equalbool == false) {
//						
//							
//						
//						items2[CountCallersExecuted] = caller.toString2();
//						callersex[CountCallersExecuted] = caller;
//						CountCallersExecuted++;
//						OnlyinExecutedCallers++; 
//					}
//				}
//
//			}
//		
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			int CountCallerExecuted=0; 
//			String[] itemsExecuted = new String[methodtrace.getCallersListExecuted().size()];
//			for (Method2Representation caller : methodtrace.getCallersListExecuted()) {
//				
//				itemsExecuted[CountCallerExecuted] = caller.toString2();	
//				System.out.println(caller.toString2());
//				CountCallerExecuted++;
//			}
//			
//			int Count=0; 
//			for (Method2Representation caller : methodtrace.getCallersList()) {
//
//				boolean equalbool = false;
//				if (itemsExecuted.length == 0) {
//					items5[Count] = caller.toString2();
//				
//						
//					
//					Count++; 
//					OnlyinParsedCallers++; 
//
//				} else {
//					for (String item : itemsExecuted) {
//					String	callerString = caller.toString2().replaceAll("\\(.*\\)", "");
//
//						if (item.equals(callerString) == true) {
//						
//							equalbool = true;
//						}
//					}
//					if (equalbool == false) {
//						
//							
//						
//						Count++; 
//						OnlyinParsedCallers++; 
//					}
//				}
//
//			}

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

//			int CountCalleesExecuted = 0;
//			items4 = new String[methodtrace.getCalleesListExecuted().size()];
//			calleesex = new Method2Representation[methodtrace.getCalleesListExecuted().size()];
//			for (Method2Representation caller : methodtrace.getCalleesListExecuted()) {
//				boolean equalbool = false;
//				if (items3.length == 0) {
//					items4[CountCalleesExecuted] = caller.toString2();
//					calleesex[CountCalleesExecuted] = caller;
//					CountCalleesExecuted++;
//					OnlyInExecutedCallees++; 
//					
//				} else {
//					for (String item : items3) {
//						item = item.replaceAll("\\(.*\\).*", "");
//						item = item.replaceAll(":", ",");
//						String mycaller=caller.toString(); 
//						 mycaller=mycaller.substring(0, mycaller.indexOf("[")); 
//						if (item.equals(mycaller) == true) {
//							equalbool = true;
//							BothInParsedAndExecutedCallees++; 
//						}
//					}
//					if (equalbool == false) {
//						items4[CountCalleesExecuted] = caller.toString2();
//						calleesex[CountCalleesExecuted] = caller;
//						OnlyInExecutedCallees++; 
//
//						CountCalleesExecuted++;
//				
//					}
//				}
//
//			}
//
//			int CountCalleeExecuted=0; 
//			String[] itemsExecutedCallees = new String[methodtrace.getCalleesListExecuted().size()];
//			for (Method2Representation callee : methodtrace.getCalleesListExecuted()) {
//				
//				itemsExecutedCallees[CountCalleeExecuted] = callee.toString2();	
//				System.out.println(callee.toString2());
//				CountCalleeExecuted++;
//			}
//			
//			 Count=0; 
//			for (Method2Representation callee : methodtrace.getCalleesList()) {
//
//				boolean equalbool = false;
//				if (itemsExecutedCallees.length == 0) {
//					items6[Count] = callee.toString2();
//				
//						
//					
//					Count++; 
//					OnlyInParsedCallees++; 
//
//				} else {
//					for (String item : itemsExecutedCallees) {
//					String	calleeString = callee.toString2().replaceAll("\\(.*\\)", "");
//
//						if (item.equals(calleeString) == true) {
//						
//							equalbool = true;
//						}
//					}
//					if (equalbool == false) {
//						
//							
//						
//						Count++; 
//						OnlyInParsedCallees++; 
//					}
//				}
//
//			}
			
			String[] items3And4 = new String[items3.length + items4.length];
			items3And4 = (String[]) ArrayUtils.addAll(items3, items4);
			Method[] CalleeMethods = new Method[items3.length + items4.length];
			CalleeMethods = (Method[]) ArrayUtils.addAll(calleesarr, calleesex);
			//=======> LIST OF CALLEES AFTER MERGING CALLEES + CALLEESEXECUTED 
			List<Method> CalleeMethodsList = Arrays.asList(CalleeMethods);

			
			
			
//			data[j][CallerMethodsNumber] = CountCallersExecuted + CountCallers;
//			data[j][CalleeMethodsNumber] = CountCalleesExecuted + CountCallees;
			//NEEDS TO BE ADDED IN OTHER PROJECTS 
			CallerMethodsList = CallerMethodsList.stream().filter(t -> t != null).collect(Collectors.toList()); 
			CalleeMethodsList = CalleeMethodsList.stream().filter(t -> t != null).collect(Collectors.toList()); 
			System.out.println("Caller Methods List Size: "+CallerMethodsList.size());
		
			
			CallerMethodListFinal = new ArrayList<Method>();
			CalleeMethodListFinal = new ArrayList<Method>();

			
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
			
			

			
			
			
			
			
			
//			
//			//***********************************************CALLERS**************************************************//	
//			//***********************************************CALLERS**************************************************//	
//			//***********************************************CALLERS**************************************************//	
//
//			for (Method2Representation methcaller : CallerMethodsList) {
//				if (methcaller != null) {
//							boolean flag=false; 
//							
//								for(Method2Representation item: CallerMethodsList) {
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
			
			

			List<Method> CallerMethodsListFinalNoDuplicates = new ArrayList<Method>();

			Set<String> CallerMethodsListNoDuplicates = new HashSet<String>();

			for( Method item : CallerMethodListFinal ) {
				String val= item.owner.ID+"-"+item.methodname;
			    if( CallerMethodsListNoDuplicates.add( val )) {
			    	CallerMethodsListFinalNoDuplicates.add( item );
			    }
			}
			
			
			
			
			
				//***********************************************CALLEES**************************************************//	
				//***********************************************CALLEES**************************************************//	
				//***********************************************CALLEES**************************************************//	

			
			
			
			
			
//			for (Method2Representation methcaller : CalleeMethodsList) {
//				if (methcaller != null) {
//					
//				
//						
//					
//						
//							boolean flag=false; 
//							
//								for(Method2Representation item: CalleeMethodsList) {
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
			
			
			

			List<Method> CalleeMethodsListFinalNoDuplicates = new ArrayList<Method>();

			Set<String> CalleeMethodsListNoDuplicates = new HashSet<String>();
			for( Method item : CalleeMethodListFinal ) {
				String val= item.owner.ID+"-"+item.methodname;
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

			AppendedCallees=AppendedCallees.replaceAll(",", "/"); 
			int CounterTraceClassCallerT = 0;
			int CounterTraceClassCallerN = 0;
			int CounterTraceClassCallerE = 0;
			int CounterTraceClassCallerTGOLD2 = 0;
			int CounterTraceClassCallerNGOLD2 = 0;
			int CounterTraceClassCallerEGOLD2 = 0;
			List<ClassTrace2> mycallerclasses = new ArrayList<ClassTrace2>();

			for (Method callermeth : CallerMethodListFinal) {
				Clazz classrep = callermeth.getClassrep();
			//	ClassTrace2 mycallerclass = myclasstrace.FindTrace(classtraces2, classrep.classid,methodtrace.Requirement.getID());
				//Sometimes, mycallerclass is null and cannot be found in the traces classes table 
				ClassTrace2 mycallerclass = myclasstrace.FindTrace2(methodtracesRequirementClass, classrep.ID,	methodtrace.Requirement.getID());
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
			
			data[j][CallerClassesTGOLD2] = CounterTraceClassCallerTGOLD2;
			data[j][CallerClassesNGOLD2] = CounterTraceClassCallerNGOLD2;
			data[j][CallerClassesEGOLD2] = CounterTraceClassCallerEGOLD2;
			data[j][CallerClassesNumberGOLD2] = CounterTraceClassCallerTGOLD2+CounterTraceClassCallerNGOLD2+CounterTraceClassCallerEGOLD2;

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
			int CountMethodTACHRAF = 0; 
			int CountMethodNACHRAF = 0; 
			int CountMethodEACHRAF = 0; 
			for (Method mycaller: methodtrace.getCallersList()) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.ID); 
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
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
			for (Method mycaller: methodtrace.getCalleesList()) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.ID); 
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
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
			
			
			
			

		
			int CountMethodTACHRAFGold2 = 0; 
			int CountMethodNACHRAFGold2 = 0; 
			int CountMethodEACHRAFGold2 = 0; 
			for (Method mycaller: methodtrace.getCallersList()) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.ID); 
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null) {
					if(methtrace.goldfinal!=null) {
						if (methtrace.goldfinal.equals("T")) {
							CountMethodTACHRAFGold2++;
						} else if (methtrace.goldfinal.equals("N")) {
							CountMethodNACHRAFGold2++;
						} else if (methtrace.goldfinal.equals("E")) {
							CountMethodEACHRAFGold2++;
						}
					}
			
			}
			}
			
			
			
			int CountMethodTACHRAFCalleeGold2 = 0; 
			int CountMethodNACHRAFCalleeGold2 = 0; 
			int CountMethodEACHRAFCalleeGold2 = 0; 
			for (Method mycaller: methodtrace.getCalleesList()) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.ID); 
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null && methtrace.goldfinal!=null) {
					if (methtrace.goldfinal.equals("T")) {
						CountMethodTACHRAFCalleeGold2++;
					} else if (methtrace.goldfinal.equals("N")) {
						CountMethodNACHRAFCalleeGold2++;
					} else if (methtrace.goldfinal.equals("E")) {
						CountMethodEACHRAFCalleeGold2++;
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

			for (Method calleemeth : CalleeMethodListFinal) {
				Clazz classrep = calleemeth.getClassrep();
				ClassTrace2 mycalleeclass = myclasstrace.FindTrace2(methodtracesRequirementClass, classrep.ID,	methodtrace.Requirement.getID());

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
			
			data[j][CalleeClassesTGOLD2] = CounterTraceClassCalleeTGOLD2;
			data[j][CalleeClassesNGOLD2] = CounterTraceClassCalleeNGOLD2;
			data[j][CalleeClassesEGOLD2] = CounterTraceClassCalleeEGOLD2;
			data[j][CalleeClassesNumberGOLD2] = CounterTraceClassCalleeEGOLD2+CounterTraceClassCalleeNGOLD2+CounterTraceClassCalleeTGOLD2;

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
			
			data[j][CalleeMethodsTGOLD2] = CountMethodTCalleeGOLD2;
			data[j][CalleeMethodsNGOLD2] = CountMethodNCalleeGOLD2;
			data[j][CalleeMethodsEGOLD2] = CountMethodECalleeGOLD2;
			data[j][CalleeMethodsNumberGOLD2] = CountMethodTCalleeGOLD2+CountMethodNCalleeGOLD2+CountMethodECalleeGOLD2;
			
			data[j][CallerMethodsTGOLD2] = CountMethodTGOLD2;
			data[j][CallerMethodsNGOLD2] = CountMethodNGOLD2;
			data[j][CallerMethodsEGOLD2] = CountMethodEGOLD2;
			data[j][CallerMethodsNumberGOLD2] = CountMethodTGOLD2+CountMethodNGOLD2+CountMethodEGOLD2;
			
			
			
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
			 Object OwnerClassNVarGOLD2 = data[j][OwnerClassNGOLD2]; 
				boolean flagGold=false; 
				boolean flagGold2=false; 
				if(OwnerClassNVar.toString().equals("1") || data[j][OwnerClassE].toString().equals("1") ) {
					data[j][OwnerClassPrediction]="N"; 
					String Result=OwnerClassPredictionClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][OwnerClassPrediction].toString()); 
					OwnerClassPredictionClass.UpdateCounters(Result, OwnerClassPredictionClass);
					flagGold=true; 
				
				}
				if(OwnerClassNVarGOLD2!=null) {
					if((OwnerClassNVarGOLD2.toString().equals("1") || data[j][OwnerClassEGOLD2].toString().equals("1") )&& methodtrace.getGoldfinal()!=null){
						data[j][OwnerClassPredictionGOLD2]="N"; 
						String Result2=OwnerClassPredictionClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][OwnerClassPredictionGOLD2].toString()); 
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
								for(Method call: methodtrace.getCallersList()) {
									bwlog3.write("callerlist "+ call.toString2());
									
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()); 
									 if(trace2!=null) {
										 bwlog3.newLine();
										 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()).gettrace());
										
										
									 }
									 bwlog3.newLine();
								}
								for(Method call: methodtrace.getCallersListExecuted()) {
									bwlog3.write("callerlistEXEC "+ call.toString2());
									bwlog3.newLine();
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()); 

									 if(trace2!=null) {
										 bwlog3.newLine();
										 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()).gettrace());
										
										
									 }
									 bwlog3.newLine();
								}
								for(Method call: methodtrace.getCalleesList()) {
									bwlog3.write("calleelist "+ call.toString2());
									bwlog3.newLine();
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()); 

									 if(trace2!=null) {
										 bwlog3.newLine();
										 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()).gettrace());
										
										
									 }
									 bwlog3.newLine();
								}
								for(Method call: methodtrace.getCalleesListExecuted()) {
									bwlog3.write("calleelistEXEC "+ call.toString2());
									bwlog3.newLine();
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()); 

									 if(trace2!=null) {
										 bwlog3.newLine();
										 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()).gettrace());
										
										
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
								for(Method call: methodtrace.getCallersList()) {
									bwlog2.write("callerlist "+ call.toString2());
									
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()); 
									 if(trace2!=null) {
										 bwlog2.newLine();
										 bwlog2.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()).gettrace());
										
										
									 }
									 bwlog2.newLine();
								}
								for(Method call: methodtrace.getCallersListExecuted()) {
									bwlog2.write("callerlistEXEC "+ call.toString2());
									bwlog2.newLine();
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()); 

									 if(trace2!=null) {
										 bwlog2.newLine();
										 bwlog2.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()).gettrace());
										
										
									 }
									 bwlog2.newLine();
								}
								for(Method call: methodtrace.getCalleesList()) {
									bwlog2.write("calleelist "+ call.toString2());
									bwlog2.newLine();
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()); 

									 if(trace2!=null) {
										 bwlog2.newLine();
										 bwlog2.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()).gettrace());
										
										
									 }
									 bwlog2.newLine();
								}
								for(Method call: methodtrace.getCalleesListExecuted()) {
									bwlog2.write("calleelistEXEC "+ call.toString2());
									bwlog2.newLine();
									 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()); 

									 if(trace2!=null) {
										 bwlog2.newLine();
										 bwlog2.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()).gettrace());
										
										
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
			//ALL T METHOD LEVEL CALLEES AT LEAST 2T
			
			
			if(CountMethodNCallee==0 && CountMethodECallee==0 && CountMethodTCallee>=2) {
				
				
				
					
					data[j][AllTMethodLevelCalleesAtLeast2TGOLD] = "T";
					if(flagGold==false && methodtrace.getGold()!=null) {
					String Result=AllTMethodLevelCalleesClassAtLeast2TGold.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTMethodLevelCalleesAtLeast2TGOLD].toString()); 
					AllTMethodLevelCalleesClassAtLeast2TGold.UpdateCounters(Result, AllTMethodLevelCalleesClassAtLeast2TGold);
					}
			}
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL T METHOD LEVEL CALLERS AT LEAST 2T
			
			if(CountMethodN==0 && CountMethodE==0  && CountMethodT>=2) {
				
				
				
			
					data[j][AllTMethodLevelCallersAtLeast2TGOLD] = "T";
					if(flagGold==false && methodtrace.getGold()!=null) {
					String Result=AllTMethodLevelCallersClassAtLeast2TGold.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTMethodLevelCallersAtLeast2TGOLD].toString()); 
					AllTMethodLevelCallersClassAtLeast2TGold.UpdateCounters(Result, AllTMethodLevelCallersClassAtLeast2TGold);
					
					}
				
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL T CLASS LEVEL CALLERS AT LEAST 2T
			
			
			if(CounterTraceClassCallerE==0 && CounterTraceClassCallerN==0 && CounterTraceClassCallerT>=2) {
				
				
			
					data[j][AllTClassLevelCallersAtLeast2TGOLD] = "T";
					if(flagGold==false && methodtrace.getGold()!=null) {
					String Result=AllTClassLevelCallersClassAtLeast2TGold.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTClassLevelCallersAtLeast2TGOLD].toString()); 
					AllTClassLevelCallersClassAtLeast2TGold.UpdateCounters(Result, AllTClassLevelCallersClassAtLeast2TGold);
					System.out.println(methodtrace.toString());
					
					}
					
					
					}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL T CLASS LEVEL CALLEES AT LEAST 2T
			
			
			if(CounterTraceClassCalleeE==0 && CounterTraceClassCalleeN==0 && CounterTraceClassCalleeT>=2) {
				
				
				
			
					data[j][AllTClassLevelCalleesAtLeast2TGOLD] = "T";
					if(flagGold==false && methodtrace.getGold()!=null) {
					String Result=AllTClassLevelCalleesClassAtLeast2TGold.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTClassLevelCalleesAtLeast2TGOLD].toString()); 
					AllTClassLevelCalleesClassAtLeast2TGold.UpdateCounters(Result, AllTClassLevelCalleesClassAtLeast2TGold);
			
					
					}
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL N CLASS LEVEL CALLERS AT LEAST 2N
			
			
		
				
			if(CounterTraceClassCallerT==0 && CounterTraceClassCallerE==0 && CounterTraceClassCallerN>=2) {
				
			
					data[j][AllNClassLevelCallersAtLeast2NGOLD] = "N";
					if(flagGold==false && methodtrace.getGold()!=null) {
					String Result=AllNClassLevelCallersClassAtLeast2NGold.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNClassLevelCallersAtLeast2NGOLD].toString()); 
					AllNClassLevelCallersClassAtLeast2NGold.UpdateCounters(Result, AllNClassLevelCallersClassAtLeast2NGold);
			
					}
					
					
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL N CLASS LEVEL CALLEES AT LEAST 2N
			
			
	
				
				if(CounterTraceClassCalleeT==0 && CounterTraceClassCalleeE==0 && CounterTraceClassCalleeN>=2) {
				
			
					data[j][AllNClassLevelCalleesAtLeast2NGOLD] = "N";
					if(flagGold==false && methodtrace.getGold()!=null) {
					String Result=AllNClassLevelCalleesClassAtLeast2NGold.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNClassLevelCalleesAtLeast2NGOLD].toString()); 
					AllNClassLevelCalleesClassAtLeast2NGold.UpdateCounters(Result, AllNClassLevelCalleesClassAtLeast2NGold);
					
					}
				
			}
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL N METHOD LEVEL CALLERS AT LEAST 2N
			
			
		
				
				if(CountMethodT==0 && CountMethodE==0 && CountMethodN>=2) {	
				
			
					data[j][AllNMethodLevelCallersAtLeast2NGOLD] = "N";
					if(flagGold==false && methodtrace.getGold()!=null) {
					String Result=AllNMethodLevelCallersClassAtLeast2NGold.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNMethodLevelCallersAtLeast2NGOLD].toString()); 
					AllNMethodLevelCallersClassAtLeast2NGold.UpdateCounters(Result, AllNMethodLevelCallersClassAtLeast2NGold);
					
					}
			}
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			
			//ALL N METHOD LEVEL CALLEES AT LEAST 2N
			
			
		
				
				if(CountMethodTCallee==0 && CountMethodECallee==0 && CountMethodNCallee>=2) {
				
			
					data[j][AllNMethodLevelCalleesAtLeast2NGOLD] = "N";
					if(flagGold==false && methodtrace.getGold()!=null) {
						String Result=AllNMethodLevelCalleesClassAtLeast2NGold.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNMethodLevelCalleesAtLeast2NGOLD].toString()); 
						AllNMethodLevelCalleesClassAtLeast2NGold.UpdateCounters(Result, AllNMethodLevelCalleesClassAtLeast2NGold);
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
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
									
									
									
									
									
									
									
					
									
									if((counterParameterTGOLD2!=0 || counterParameterNGOLD2!=0|| counterParameterEGOLD2!=0)
											/*	||
												(CounterTraceClassCallerN!=0 && CounterTraceClassCallerE!=0)
												||(CounterTraceClassCallerT!=0 && CounterTraceClassCallerE!=0)*/
												) {
											
											if(counterParameterTGOLD2==counterParameterNGOLD2 && counterParameterTGOLD2>0) {
												data[j][MajorityParametersGOLD2] = "T";
											}
											else if(counterParameterTGOLD2==0 && counterParameterNGOLD2==0 && counterParameterEGOLD2>0) {
												data[j][MajorityParametersGOLD2] = "E";
											}
											else if(counterParameterTGOLD2==0 && counterParameterNGOLD2>0 && counterParameterEGOLD2>0) {
												data[j][MajorityParametersGOLD2] = "N";
											}
											else if (((counterParameterTGOLD2 >= counterParameterNGOLD2
												//	&& counterParameterNGOLD2 >= counterParameterEGOLD2
													)
													//|| (counterParameterTGOLD2 >= counterParameterEGOLD2
														//	&& counterParameterEGOLD2 >= counterParameterNGOLD2
													//		)
													)
													) {
												data[j][MajorityParametersGOLD2] = "T";
											}/* else if (((counterParameterEGOLD2 >= counterParameterNGOLD2
													&& counterParameterNGOLD2 >= counterParameterTGOLD2)
													|| (counterParameterEGOLD2 >= counterParameterTGOLD2
															&& counterParameterTGOLD2 >= counterParameterNGOLD2))
												) {
												data[j][MajorityParametersGOLD2] = "E";
											} */else if ((counterParameterNGOLD2 >= counterParameterTGOLD2)) {
												data[j][MajorityParametersGOLD2] = "N";
											}
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
												String Result=MajorityParametersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][MajorityParametersGOLD2].toString()); 
												MajorityParametersClassGold2.UpdateCounters(Result, MajorityParametersClassGold2);
											}
											
										
											
										
										}
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									//AT LEAST 1N PREDICTION PARAMETER
									
									
									
									
									
									if (counterParameterNGOLD2 >=1 )
											 {
										data[j][AtLeast1NParameterGOLD2] = "N";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=AtLeast1NParameterClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1NParameterGOLD2].toString()); 
										AtLeast1NParameterClassGold2.UpdateCounters(Result, AtLeast1NParameterClassGold2);
										}
										
									} 
								
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									//AT LEAST 2N PREDICTION PARAMETER
									
									
									
									
									
									if (counterParameterNGOLD2 >=2 )
											 {
										data[j][AtLeast2NParameterGOLD2] = "N";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											
											String Result=AtLeast2NParameterClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2NParameterGOLD2].toString()); 
										AtLeast2NParameterClassGold2.UpdateCounters(Result, AtLeast2NParameterClassGold2);
										}
										
									} 
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//AT LEAST 1T PREDICTION PARAMETER
								
								
									
									
									
									if (counterParameterTGOLD2 >=1 )
											 {
										data[j][AtLeast1TParameterGOLD2] = "T";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=AtLeast1TParameterClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1TParameterGOLD2].toString()); 
										AtLeast1TParameterClassGold2.UpdateCounters(Result, AtLeast1TParameterClassGold2);
										}
									} 
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//AT LEAST 2T PREDICTION PARAMETER
									
									
										
										
										
										if (counterParameterTGOLD2 >=2 )
												 {
											data[j][AtLeast2TParameterGOLD2] = "T";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AtLeast2TParameterClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2TParameterGOLD2].toString()); 
											AtLeast2TParameterClassGold2.UpdateCounters(Result, AtLeast2TParameterClassGold2);
											}
										} 
									/**************************************************************************************************************/
									/**************************************************************************************************************/
								    /**************************************************************************************************************/	
									
									
									
									//ALL T PARAMETER PREDICTION
									
									
									if(counterParameterEGOLD2==0 && counterParameterNGOLD2==0 && counterParameterTGOLD2>=1) {
										
										
										
									
											data[j][AllTParametersGOLD2] = "T";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AllTParameterClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTParametersGOLD2].toString()); 
											AllTParameterClassGold2.UpdateCounters(Result, AllTParameterClassGold2);
											}
											
											
									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N PARAMETER PREDICTION
									
									
									if(counterParameterTGOLD2==0 && counterParameterEGOLD2==0 && counterParameterNGOLD2>=1) {
										
										
										
									
											data[j][AllNParametersGOLD2] = "N";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AllNParameterClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNParametersGOLD2].toString()); 
											AllNParameterClassGold2.UpdateCounters(Result, AllNParameterClassGold2);
											
											if(Result!=null) {
												
												

												System.out.println("MY RESULT "+Result);
												if(Result.equals("FN")) {
													bwlog3.write("***********************************"); 
													bwlog3.newLine();
													bwlog3.write(methodtrace.toString());
													bwlog3.newLine();
													for(Method call: methodtrace.getCallersList()) {
														bwlog3.write("callerlist "+ call.toString2());
														
														 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()); 
														 if(trace2!=null) {
															 bwlog3.newLine();
															 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()).gettrace());
															
															
														 }
														 bwlog3.newLine();
													}
													for(Method call: methodtrace.getCallersListExecuted()) {
														bwlog3.write("callerlistEXEC "+ call.toString2());
														bwlog3.newLine();
														 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()); 

														 if(trace2!=null) {
															 bwlog3.newLine();
															 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()).gettrace());
															
															
														 }
														 bwlog3.newLine();
													}
													for(Method call: methodtrace.getCalleesList()) {
														bwlog3.write("calleelist "+ call.toString2());
														bwlog3.newLine();
														 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()); 

														 if(trace2!=null) {
															 bwlog3.newLine();
															 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()).gettrace());
															
															
														 }
														 bwlog3.newLine();
													}
													for(Method call: methodtrace.getCalleesListExecuted()) {
														bwlog3.write("calleelistEXEC "+ call.toString2());
														bwlog3.newLine();
														 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()); 

														 if(trace2!=null) {
															 bwlog3.newLine();
															 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.owner.ID,methodtrace.Requirement.getID()).gettrace());
															
															
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
											data[j][MajorityClassLevelCalleesGOLD2] = "T";
										}
										else if(CounterTraceClassCalleeTGOLD2==0 && CounterTraceClassCalleeNGOLD2==0 && CounterTraceClassCalleeEGOLD2>0) {
											data[j][MajorityClassLevelCalleesGOLD2] = "E";
										}
										else if(CounterTraceClassCalleeTGOLD2==0 && CounterTraceClassCalleeNGOLD2>0 && CounterTraceClassCalleeEGOLD2>0) {
											data[j][MajorityClassLevelCalleesGOLD2] = "N";
										}
										else if ((CounterTraceClassCalleeTGOLD2 >= CounterTraceClassCalleeNGOLD2
												)
												) {
											data[j][MajorityClassLevelCalleesGOLD2] = "T";
										} /*else if (((CounterTraceClassCallerEGOLD2 >= CounterTraceClassCallerNGOLD2
												&& CounterTraceClassCallerNGOLD2 >= CounterTraceClassCallerTGOLD2)
												|| (CounterTraceClassCallerEGOLD2 >= CounterTraceClassCallerTGOLD2
														&& CounterTraceClassCallerTGOLD2 >= CounterTraceClassCallerNGOLD2))
											) {
											data[j][MajorityClassLevelCalleesGOLD2] = "E";
										}*/ else if (CounterTraceClassCalleeNGOLD2 >= CounterTraceClassCalleeTGOLD2) {
											data[j][MajorityClassLevelCalleesGOLD2] = "N";
										}
										if(true && methodtrace.getGoldfinal()!=null && data[j][MajorityClassLevelCalleesGOLD2]!=null) {
										String Result=MajorityClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][MajorityClassLevelCalleesGOLD2].toString()); 
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
											data[j][MajorityClassLevelCallersGOLD2] = "T";
										}
										else if(CounterTraceClassCallerTGOLD2==0 && CounterTraceClassCallerNGOLD2==0 && CounterTraceClassCallerEGOLD2>0) {
											data[j][MajorityClassLevelCallersGOLD2] = "E";
										}
										else if(CounterTraceClassCallerTGOLD2==0 && CounterTraceClassCallerNGOLD2>0 && CounterTraceClassCallerEGOLD2>0) {
											data[j][MajorityClassLevelCallersGOLD2] = "N";
										}
										else if(CounterTraceClassCallerTGOLD2==0 && CounterTraceClassCallerNGOLD2>0 && CounterTraceClassCallerEGOLD2>0) {
											data[j][MajorityClassLevelCallersGOLD2] = "E";
										}
										else if (CounterTraceClassCallerTGOLD2 >= CounterTraceClassCallerNGOLD2) {
											data[j][MajorityClassLevelCallersGOLD2] = "T";
										} else if (CounterTraceClassCallerNGOLD2>=CounterTraceClassCallerTGOLD2)
											 {
											data[j][MajorityClassLevelCallersGOLD2] = "N";
										} 
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=MajorityClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][MajorityClassLevelCallersGOLD2].toString()); 
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
											data[j][MajorityMethodLevelCalleesGOLD2] = "T";
										}
										else if(CountMethodTCalleeGOLD2==0 && CountMethodNCalleeGOLD2==0 && CountMethodECalleeGOLD2>0) {
											data[j][MajorityMethodLevelCalleesGOLD2] = "E";
										}
										else if(CountMethodTCalleeGOLD2==0 && CountMethodNCalleeGOLD2>0 && CountMethodECalleeGOLD2>0) {
											data[j][MajorityMethodLevelCalleesGOLD2] = "N";
										} 
										
										else if(CountMethodTCalleeGOLD2>=CountMethodNCalleeGOLD2)
										 {
											data[j][MajorityMethodLevelCalleesGOLD2] = "T";
										}  else if (CountMethodNCalleeGOLD2 >= CountMethodTCalleeGOLD2
											
												) {
											data[j][MajorityMethodLevelCalleesGOLD2] = "N";
										}
									
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=MajorityMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][MajorityMethodLevelCalleesGOLD2].toString()); 
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
											data[j][MajorityMethodLevelCallersGOLD2] = "T";
										}
										else if(CountMethodTGOLD2==0 && CountMethodNGOLD2==0 && CountMethodEGOLD2>0) {
											data[j][MajorityMethodLevelCallersGOLD2] = "E";
										}
										else if(CountMethodTGOLD2==0 && CountMethodNGOLD2>0 && CountMethodEGOLD2>0) {
											data[j][MajorityMethodLevelCallersGOLD2] = "N";
										}
										
										else if (CountMethodTGOLD2 >= CountMethodNGOLD2){
											data[j][MajorityMethodLevelCallersGOLD2] = "T";
										}  else if (CountMethodNGOLD2 >= CountMethodTGOLD2
												
												) {
											data[j][MajorityMethodLevelCallersGOLD2] = "N";
										}
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=MajorityMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][MajorityMethodLevelCallersGOLD2].toString()); 
										MajorityMethodLevelCallersClassGold2.UpdateCounters(Result, MajorityMethodLevelCallersClassGold2);
										}
									}
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//1AT LEAST 1N PREDICTION CLASS LEVEL CALLERS 
									
									
										
										
										
										if (CounterTraceClassCallerNGOLD2 >=1 )
												 {
											data[j][AtLeast1NPredictionClassLevelCallersGOLD2] = "N";
											Object var= 	data[j][AtLeast1NPredictionClassLevelCallersGOLD2]; 
											String NEWVAR=var.toString(); 
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastNPredictionClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1NPredictionClassLevelCallersGOLD2].toString()); 
											AtLeastNPredictionClassLevelCallersClassGold2.UpdateCounters(Result, AtLeastNPredictionClassLevelCallersClassGold2);
											}
										} 
									
										
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//2AT LEAST 1T PREDICTION CLASS LEVEL CALLERS 
									
									
										
										
										
										if (CounterTraceClassCallerTGOLD2 >=1 )
												 {
											data[j][AtLeast1TPredictionClassLevelCallersGOLD2] = "T";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastTPredictionClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1TPredictionClassLevelCallersGOLD2].toString()); 
											AtLeastTPredictionClassLevelCallersClassGold2.UpdateCounters(Result, AtLeastTPredictionClassLevelCallersClassGold2);
											}
										} 
										
											
										
									
									
							
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//3AT LEAST 1N PREDICTION CLASS LEVEL CALLEES 
								
									
										
										
										
										if (CounterTraceClassCalleeNGOLD2 >=1 )
												 {
											data[j][AtLeast1NPredictionClassLevelCalleesGOLD2] = "N";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastNPredictionClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1NPredictionClassLevelCalleesGOLD2].toString()); 
											AtLeastNPredictionClassLevelCalleesClassGold2.UpdateCounters(Result, AtLeastNPredictionClassLevelCalleesClassGold2);
											}
										} 
										
									
									
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
								
									//4AT LEAST 1T PREDICTION CLASS LEVEL CALLEES 
									
									
										
										
										
										if (CounterTraceClassCalleeTGOLD2 >=1 )
												 {
											data[j][AtLeast1TPredictionClassLevelCalleesGOLD2] = "T";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastTPredictionClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1TPredictionClassLevelCalleesGOLD2].toString()); 
											AtLeastTPredictionClassLevelCalleesClassGold2.UpdateCounters(Result, AtLeastTPredictionClassLevelCalleesClassGold2);
											}
										} 
										
										
									
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									//5AT LEAST 1N PREDICTION METHOD LEVEL CALLERS 
									
									
										
										
										if (CountMethodNGOLD2 >=1 )
												 {
											data[j][AtLeast1NPredictionMethodLevelCallersGOLD2] = "N";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastNPredictionMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1NPredictionMethodLevelCallersGOLD2].toString()); 
											AtLeastNPredictionMethodLevelCallersClassGold2.UpdateCounters(Result, AtLeastNPredictionMethodLevelCallersClassGold2);
											}
										} 
										
										
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									//6AT LEAST 1T PREDICTION METHOD LEVEL CALLERS 
								
									
										
										
										
										if (CountMethodTGOLD2 >=1 )
												 {
											data[j][AtLeast1TPredictionMethodLevelCallersGOLD2] = "T";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastTPredictionMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1TPredictionMethodLevelCallersGOLD2].toString()); 
											AtLeastTPredictionMethodLevelCallersClassGold2.UpdateCounters(Result, AtLeastTPredictionMethodLevelCallersClassGold2);
											}
										} 
										
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//7AT LEAST 1N PREDICTION METHOD LEVEL CALLEES 
									
									
										
										
										
										if (CountMethodNCalleeGOLD2 >=1 )
												 {
											data[j][AtLeast1NPredictionMethodLevelCalleesGOLD2] = "N";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastNPredictionMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1NPredictionMethodLevelCalleesGOLD2].toString()); 
											AtLeastNPredictionMethodLevelCalleesClassGold2.UpdateCounters(Result, AtLeastNPredictionMethodLevelCalleesClassGold2);
											}
										} 
										
									
							
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//8AT LEAST 1T PREDICTION METHOD LEVEL CALLEES 
									
									
										
										
										
										if (CountMethodTCalleeGOLD2 >=1 )
												 {
											data[j][AtLeast1TPredictionMethodLevelCalleesGOLD2] = "T";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastTPredictionMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1TPredictionMethodLevelCalleesGOLD2].toString()); 
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
												data[j][AtLeast2NPredictionClassLevelCalleesGOLD2] = "N";
												Object var= 	data[j][AtLeast2NPredictionClassLevelCalleesGOLD2]; 
												String NEWVAR=var.toString(); 
												if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
													String Result=AtLeast2NPredictionClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2NPredictionClassLevelCalleesGOLD2].toString()); 
													AtLeast2NPredictionClassLevelCalleesClassGold2.UpdateCounters(Result, AtLeast2NPredictionClassLevelCalleesClassGold2);
												}
											} 
										
											
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										
										//AT LEAST 2T PREDICTION CLASS LEVEL CALLEES 
										
										
											
											
											
											if (CounterTraceClassCalleeTGOLD2 >=2 )
											 {
										data[j][AtLeast2TPredictionClassLevelCalleesGOLD2] = "T";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=AtLeast2TPredictionClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2TPredictionClassLevelCalleesGOLD2].toString()); 
										AtLeast2TPredictionClassLevelCalleesClassGold2.UpdateCounters(Result, AtLeast2TPredictionClassLevelCalleesClassGold2);
										}
									} 
												
											
										
										
								
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										
										//AT LEAST 2N PREDICTION METHOD LEVEL CALLERS 
									
										
											
											
											
											
											if (CountMethodNGOLD2 >=2 )
													 {
												data[j][AtLeast2NPredictionMethodLevelCallersGOLD2] = "N";
												if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
												String Result=AtLeast2NPredictionMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2NPredictionMethodLevelCallersGOLD2].toString()); 
												AtLeast2NPredictionMethodLevelCallersClassGold2.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCallersClassGold2);
												}
											} 
											
											
										
											/**************************************************************************************************************/
											/**************************************************************************************************************/
											/**************************************************************************************************************/
										
											//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
											
											
												
												
												
												if (CounterTraceClassCallerTGOLD2 >=2 )
												 {
											data[j][AtLeast2TPredictionClassLevelCallersGOLD2] = "T";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AtLeast2TPredictionClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2TPredictionClassLevelCallersGOLD2].toString()); 
											AtLeast2TPredictionClassLevelCallersClassGold2.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClassGold2);
											}
										} 
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
									
										//AT LEAST 2T PREDICTION METHOD LEVEL CALLERS 
										
										
											
											
											
											if (CountMethodTGOLD2 >=2 )
											 {
										data[j][AtLeast2TPredictionMethodLevelCallersGOLD2] = "T";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=AtLeast2TPredictionMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2TPredictionMethodLevelCallersGOLD2].toString()); 
										AtLeast2TPredictionMethodLevelCallersClassGold2.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClassGold2);
										}
									} 
											
											
										
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										//AT LEAST 2N PREDICTION METHOD LEVEL CALLEES 

											
											
											
											
											
											
											
											
											
											
											
											
											
											
											
											
											
										
											
											
											if (CountMethodNCalleeGOLD2 >=2 )
											 {
										data[j][AtLeast2NPredictionMethodLevelCalleesGOLD2] = "N";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=AtLeast2NPredictionMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2NPredictionMethodLevelCalleesGOLD2].toString()); 
										AtLeast2NPredictionMethodLevelCalleesClassGold2.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCalleesClassGold2);
										}	
									} 
											
											
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										//AT LEAST 2T PREDICTION METHOD LEVEL CALLEES 
									
										
											
											
											
											if (CountMethodTCalleeGOLD2 >=2 )
											 {
										data[j][AtLeast2TPredictionMethodLevelCalleesGOLD2] = "T";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AtLeast2TPredictionMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2TPredictionMethodLevelCalleesGOLD2].toString()); 
											AtLeast2TPredictionMethodLevelCalleesClassGold2.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCalleesClassGold2);

										}
										
									} 
											
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										
										//AT LEAST 2N PREDICTION CLASS LEVEL CALLERS 
										
										
											
											
											
											if (CounterTraceClassCallerNGOLD2 >=2 )
											 {
										data[j][AtLeast2NPredictionClassLevelCallersGOLD2] = "N";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=AtLeast2NPredictionClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2NPredictionClassLevelCallersGOLD2].toString()); 
										AtLeast2NPredictionClassLevelCallersClassGold2.UpdateCounters(Result, AtLeast2NPredictionClassLevelCallersClassGold2);
										
										}
									} 
									
										
								
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										
										//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
										
										
											
											
											
											if (CounterTraceClassCallerTGOLD2 >=2 )
											 {
										data[j][AtLeast2TPredictionClassLevelCallersGOLD2] = "T";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AtLeast2TPredictionClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2TPredictionClassLevelCallersGOLD2].toString()); 
											AtLeast2TPredictionClassLevelCallersClassGold2.UpdateCounters(Result, AtLeast2TPredictionClassLevelCallersClassGold2);

										}
										
										}
											
											
											
											
											
											
											
											
											
											
											
											
											/**************************************************************************************************************/
											/**************************************************************************************************************/
											/**************************************************************************************************************/	 
									//ALL T METHOD LEVEL CALLEES 
									
									
									if(CountMethodNCalleeGOLD2==0 && CountMethodECalleeGOLD2==0 && CountMethodTCalleeGOLD2>=1) {
										
										
										
											
											data[j][AllTMethodLevelCalleesGOLD2] = "T";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AllTMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTMethodLevelCalleesGOLD2].toString()); 
											AllTMethodLevelCalleesClassGold2.UpdateCounters(Result, AllTMethodLevelCalleesClassGold2);
											}
									}
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL T METHOD LEVEL CALLERS 
									
									if(CountMethodNGOLD2==0 && CountMethodEGOLD2==0  && CountMethodTGOLD2>=1) {
										
										
										
									
											data[j][AllTMethodLevelCallersGOLD2] = "T";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AllTMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTMethodLevelCallersGOLD2].toString()); 
											AllTMethodLevelCallersClassGold2.UpdateCounters(Result, AllTMethodLevelCallersClassGold2);
											
											}
										
									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL T CLASS LEVEL CALLERS 
									
									
									if(CounterTraceClassCallerEGOLD2==0 && CounterTraceClassCallerNGOLD2==0 && CounterTraceClassCallerTGOLD2>=1) {
										
										
									
											data[j][AllTClassLevelCallersGOLD2] = "T";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AllTClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTClassLevelCallersGOLD2].toString()); 
											AllTClassLevelCallersClassGold2.UpdateCounters(Result, AllTClassLevelCallersClassGold2);
											System.out.println(methodtrace.toString());
											
											}
											
											
											}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL T CLASS LEVEL CALLEES 
									
									
									if(CounterTraceClassCalleeEGOLD2==0 && CounterTraceClassCalleeNGOLD2==0 && CounterTraceClassCalleeTGOLD2>=1) {
										
										
										
									
											data[j][AllTClassLevelCalleesGOLD2] = "T";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AllTClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTClassLevelCalleesGOLD2].toString()); 
											AllTClassLevelCalleesClassGold2.UpdateCounters(Result, AllTClassLevelCalleesClassGold2);
									
											
											}
									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N CLASS LEVEL CALLERS 
									
									
								
										
									if(CounterTraceClassCallerTGOLD2==0 && CounterTraceClassCallerEGOLD2==0 && CounterTraceClassCallerNGOLD2>=1) {
										
									
											data[j][AllNClassLevelCallersGOLD2] = "N";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AllNClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNClassLevelCallersGOLD2].toString()); 
											AllNClassLevelCallersClassGold2.UpdateCounters(Result, AllNClassLevelCallersClassGold2);
									
											}
											
											
									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N CLASS LEVEL CALLEES 
									
									
							
										
										if(CounterTraceClassCalleeTGOLD2==0 && CounterTraceClassCalleeEGOLD2==0 && CounterTraceClassCalleeNGOLD2>=1) {
										
									
											data[j][AllNClassLevelCalleesGOLD2] = "N";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AllNClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNClassLevelCalleesGOLD2].toString()); 
											AllNClassLevelCalleesClassGold2.UpdateCounters(Result, AllNClassLevelCalleesClassGold2);
											
											}
										
									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N METHOD LEVEL CALLERS 
									
									
								
										
										if(CountMethodTGOLD2==0 && CountMethodEGOLD2==0 && CountMethodNGOLD2>=1) {	
										
									
											data[j][AllNMethodLevelCallersGOLD2] = "N";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AllNMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNMethodLevelCallersGOLD2].toString()); 
											AllNMethodLevelCallersClassGold2.UpdateCounters(Result, AllNMethodLevelCallersClassGold2);
											
											}
									}
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N METHOD LEVEL CALLEES 
									
									
								
										
										if(CountMethodTCalleeGOLD2==0 && CountMethodECalleeGOLD2==0 && CountMethodNCalleeGOLD2>=1) {
										
									
											data[j][AllNMethodLevelCalleesGOLD2] = "N";
											if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
												String Result=AllNMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNMethodLevelCalleesGOLD2].toString()); 
												AllNMethodLevelCalleesClassGold2.UpdateCounters(Result, AllNMethodLevelCalleesClassGold2);
											}
										
											
									}
								//}
										
										
										
										
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/	 
								//ALL T METHOD LEVEL CALLEES AT LEAST 2T
								
								
								if(CountMethodNCalleeGOLD2==0 && CountMethodECalleeGOLD2==0 && CountMethodTCalleeGOLD2>=2) {
									
									
									
										
										data[j][AllTMethodLevelCalleesAtLeast2TGOLD2] = "T";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=AllTMethodLevelCalleesClassAtLeast2TGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTMethodLevelCalleesAtLeast2TGOLD2].toString()); 
										AllTMethodLevelCalleesClassAtLeast2TGold2.UpdateCounters(Result, AllTMethodLevelCalleesClassAtLeast2TGold2);
										}
								}
								
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL T METHOD LEVEL CALLERS AT LEAST 2T
								
								if(CountMethodNGOLD2==0 && CountMethodEGOLD2==0  && CountMethodTGOLD2>=2) {
									
									
									
								
										data[j][AllTMethodLevelCallersAtLeast2TGOLD2] = "T";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=AllTMethodLevelCallersClassAtLeast2TGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTMethodLevelCallersAtLeast2TGOLD2].toString()); 
										AllTMethodLevelCallersClassAtLeast2TGold2.UpdateCounters(Result, AllTMethodLevelCallersClassAtLeast2TGold2);
										
										}
									
								}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL T CLASS LEVEL CALLERS AT LEAST 2T
								
								
								if(CounterTraceClassCallerEGOLD2==0 && CounterTraceClassCallerNGOLD2==0 && CounterTraceClassCallerTGOLD2>=2) {
									
									
								
										data[j][AllTClassLevelCallersAtLeast2TGOLD2] = "T";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=AllTClassLevelCallersClassAtLeast2TGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTClassLevelCallersAtLeast2TGOLD2].toString()); 
										AllTClassLevelCallersClassAtLeast2TGold2.UpdateCounters(Result, AllTClassLevelCallersClassAtLeast2TGold2);
										System.out.println(methodtrace.toString());
										
										}
										
										
										}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL T CLASS LEVEL CALLEES AT LEAST 2T
								
								
								if(CounterTraceClassCalleeEGOLD2==0 && CounterTraceClassCalleeNGOLD2==0 && CounterTraceClassCalleeTGOLD2>=2) {
									
									
									
								
										data[j][AllTClassLevelCalleesAtLeast2TGOLD2] = "T";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=AllTClassLevelCalleesClassAtLeast2TGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTClassLevelCalleesAtLeast2TGOLD2].toString()); 
										AllTClassLevelCalleesClassAtLeast2TGold2.UpdateCounters(Result, AllTClassLevelCalleesClassAtLeast2TGold2);
								
										
										}
								}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL N CLASS LEVEL CALLERS AT LEAST 2N
								
								
							
									
								if(CounterTraceClassCallerTGOLD2==0 && CounterTraceClassCallerEGOLD2==0 && CounterTraceClassCallerNGOLD2>=2) {
									
								
										data[j][AllNClassLevelCallersAtLeast2NGOLD2] = "N";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=AllNClassLevelCallersClassAtLeast2NGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNClassLevelCallersAtLeast2NGOLD2].toString()); 
										AllNClassLevelCallersClassAtLeast2NGold2.UpdateCounters(Result, AllNClassLevelCallersClassAtLeast2NGold2);
								
										}
										
										
								}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL N CLASS LEVEL CALLEES AT LEAST 2N
								
								
						
									
									if(CounterTraceClassCalleeTGOLD2==0 && CounterTraceClassCalleeEGOLD2==0 && CounterTraceClassCalleeNGOLD2>=2) {
									
								
										data[j][AllNClassLevelCalleesAtLeast2NGOLD2] = "N";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=AllNClassLevelCalleesClassAtLeast2NGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNClassLevelCalleesAtLeast2NGOLD2].toString()); 
										AllNClassLevelCalleesClassAtLeast2NGold2.UpdateCounters(Result, AllNClassLevelCalleesClassAtLeast2NGold2);
										
										}
									
								}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL N METHOD LEVEL CALLERS AT LEAST 2N
								
								
							
									
									if(CountMethodTGOLD2==0 && CountMethodEGOLD2==0 && CountMethodNGOLD2>=2) {	
									
								
										data[j][AllNMethodLevelCallersAtLeast2NGOLD2] = "N";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
										String Result=AllNMethodLevelCallersClassAtLeast2NGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNMethodLevelCallersAtLeast2NGOLD2].toString()); 
										AllNMethodLevelCallersClassAtLeast2NGold2.UpdateCounters(Result, AllNMethodLevelCallersClassAtLeast2NGold2);
										
										}
								}
								
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL N METHOD LEVEL CALLEES AT LEAST 2N
								
								
							
									
									if(CountMethodTCalleeGOLD2==0 && CountMethodECalleeGOLD2==0 && CountMethodNCalleeGOLD2>=2) {
									
								
										data[j][AllNMethodLevelCalleesAtLeast2NGOLD2] = "N";
										if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
											String Result=AllNMethodLevelCalleesClassAtLeast2NGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNMethodLevelCalleesAtLeast2NGOLD2].toString()); 
											AllNMethodLevelCalleesClassAtLeast2NGold2.UpdateCounters(Result, AllNMethodLevelCalleesClassAtLeast2NGold2);
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
										
										
									
											
											if(CountMethodTCalleeGOLD2==0 && CountMethodTGOLD2==0 && CountMethodNCalleeGOLD2>=1 && CountMethodNGOLD2>=1) {
											
										
												data[j][AllNMethodLevelCallersCalleesGOLD2] = "N";
												if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
													String Result=AllNMethodLevelCallersCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNMethodLevelCallersCalleesGOLD2].toString()); 
													AllNMethodLevelCallersCalleesClassGold2.UpdateCounters(Result, AllNMethodLevelCallersCalleesClassGold2);
												}
											
												
										}
									//}
											
											
											/**************************************************************************************************************/
											/**************************************************************************************************************/
											/**************************************************************************************************************/
											
											//ALL T METHOD LEVEL CALLERS CALLEES 
											
											
										
												
												if(CountMethodNGOLD2==0 && CountMethodNCalleeGOLD2==0 && CountMethodTCalleeGOLD2>=1 && CountMethodTGOLD2>=1) {
												
											
													data[j][AllTMethodLevelCallersCalleesGOLD2] = "T";
													if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
														String Result=AllTMethodLevelCallersCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTMethodLevelCallersCalleesGOLD2].toString()); 
														AllTMethodLevelCallersCalleesClassGold2.UpdateCounters(Result, AllTMethodLevelCallersCalleesClassGold2);
													}
												
													
											}
												
												/**************************************************************************************************************/
												/**************************************************************************************************************/
												/**************************************************************************************************************/
												
												//ALL N CLASS LEVEL CALLERS CALLEES 
												
												
											
													
													if(CounterTraceClassCalleeTGOLD2==0 && CounterTraceClassCallerTGOLD2==0 && CounterTraceClassCalleeNGOLD2>=1 && CounterTraceClassCallerNGOLD2>=1) {
													
												
														data[j][AllNClassLevelCallersCalleesGOLD2] = "N";
														if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
															String Result=AllNClassLevelCallersCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNClassLevelCallersCalleesGOLD2].toString()); 
															AllNClassLevelCallersCalleesClassGold2.UpdateCounters(Result, AllNClassLevelCallersCalleesClassGold2);
														}
													
														
												}
											//}
													
													
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													
													//ALL T CLASS LEVEL CALLERS CALLEES 
													
													
												
														
														if(CounterTraceClassCalleeNGOLD2==0 && CounterTraceClassCallerNGOLD2==0 && CounterTraceClassCalleeTGOLD2>=1 && CounterTraceClassCallerTGOLD2>=1) {
														
													
															data[j][AllTClassLevelCallersCalleesGOLD2] = "T";
															if(flagGold2==false && methodtrace.getGoldfinal()!=null) {
																String Result=AllTClassLevelCallersCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTClassLevelCallersCalleesGOLD2].toString()); 
																AllTClassLevelCallersCalleesClassGold2.UpdateCounters(Result, AllTClassLevelCallersCalleesClassGold2);
															}
														
															
													}
									
														
									String TracePureGoldValue="null"; 
									String TraceMixedGoldValue="null"; 
									String TracePureGold2Value="null"; 
									String TraceMixedGold2Value="null"; 
									String NOTracePureGoldValue="null"; 
									String NOTraceMixedGoldValue="null"; 
									String NOTracePureGold2Value="null"; 
									String NOTraceMixedGold2Value="null"; 
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										//ACHRAF
										if(CountMethodTACHRAF>0 && CountMethodTACHRAFCallee>0) {
											
											boolean entered=false; 
											if(CountMethodNACHRAF+CountMethodNACHRAFCallee==0 && methodtrace.getGold()!=null ) {
												
												TracePureGold++; 
												TracePureGoldValue="T"; 
												entered=true; 
												
											} else if(methodtrace.getGold()!=null){
												TraceMixedGold++; 
												TraceMixedGoldValue="T"; 
												entered=true; 
											}
										
											if(entered==true) {
											if(methodtrace.getGold()!=null && methodtrace.getGold().trim().equals("T")) {
												TraceCountTotal++; 
												
											}
											else if(methodtrace.getGold()!=null && methodtrace.getGold().trim().equals("N")) {
												NoTraceCountTotal++; 
											}
											
											
											if(methodtrace.getGold()!=null ) {
											data[j][ACHRAFTRACEPureGold]=TracePureGoldValue; 
											String Result=ACHRAFTracePureGold.ComparePredictionToGold(methodtrace.getGold().trim(), TracePureGoldValue); 
											ACHRAFTracePureGold.UpdateCounters(Result, ACHRAFTracePureGold);
											}
											
											if(methodtrace.getGold()!=null ) {
												data[j][ACHRAFTRACEMixedGold]=TraceMixedGoldValue; 
												String Result=ACHRAFTraceMixedGold.ComparePredictionToGold(methodtrace.getGold().trim(), TraceMixedGoldValue); 
												ACHRAFTraceMixedGold.UpdateCounters(Result, ACHRAFTraceMixedGold);
												}
											}
											
									}else if(CountMethodNACHRAF>0 && CountMethodNACHRAFCallee>0) {
										
										boolean entered=false; 
										if(CountMethodTACHRAF+CountMethodTACHRAFCallee==0 && methodtrace.getGold()!=null ) {
											
											NoTracePureGold++; 
											NOTracePureGoldValue="N"; 
											data[j][ACHRAFNOTRACEPureGold]=NOTracePureGoldValue; 
											entered=true; 
											
											
										} else if(methodtrace.getGold()!=null) {
											NoTraceMixedGold++; 
											NOTraceMixedGoldValue="N"; 
											data[j][ACHRAFNOTRACEMixedGold]=NOTraceMixedGoldValue; 
											entered=true; 
										}
										
										if(entered==true) {
										if(methodtrace.getGold()!=null && methodtrace.getGold().trim().equals("N")) {
											
											NoTraceCountTotal++; 
										}
											else if(methodtrace.getGold()!=null && methodtrace.getGold().trim().equals("T")) {
											TraceCountTotal++; 
										}
										
										
										
										
										
							
										
										
										if(methodtrace.getGold()!=null ) {
											String Result=ACHRAFNOTracePureGold.ComparePredictionToGold(methodtrace.getGold().trim(), NOTracePureGoldValue); 
											ACHRAFNOTracePureGold.UpdateCounters(Result, ACHRAFNOTracePureGold);
											}
											
											if(methodtrace.getGold()!=null ) {
												String Result=ACHRAFNOTraceMixedGold.ComparePredictionToGold(methodtrace.getGold().trim(), NOTraceMixedGoldValue); 
												ACHRAFNOTraceMixedGold.UpdateCounters(Result, ACHRAFNOTraceMixedGold);
												}
										}
										
								}else {
									failGold++; 
								}
										
										
						/********************************************************************************************************************/				
										
	if(CountMethodTACHRAFGold2>0 && CountMethodTACHRAFCalleeGold2>0) {
											
											boolean entered=false; 
											if(CountMethodNACHRAF+CountMethodNACHRAFCallee==0 && methodtrace.getGoldfinal()!=null ) {
												
												TracePureGold2++; 
												TracePureGold2Value="T"; 
												entered=true; 
												
											} else if(methodtrace.getGoldfinal()!=null) {
												TraceMixedGold2++; 
												TraceMixedGold2Value="T"; 
												entered=true; 
											}
										
											if(entered==true) {
											if(methodtrace.getGoldfinal()!=null && methodtrace.getGoldfinal().trim().equals("T")) {
												TraceCountTotal++; 
												
											}
											else if(methodtrace.getGoldfinal()!=null && methodtrace.getGoldfinal().trim().equals("N")) {
												NoTraceCountTotal++; 
											}
											
											
											if(methodtrace.getGoldfinal()!=null ) {
											data[j][ACHRAFTRACEPureGOLD2]=TracePureGold2Value; 
											String Result=ACHRAFTracePureGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), TracePureGold2Value); 
											ACHRAFTracePureGold2.UpdateCounters(Result, ACHRAFTracePureGold2);
											}
											
											if(methodtrace.getGoldfinal()!=null ) {
												data[j][ACHRAFTRACEMixedGOLD2]=TraceMixedGold2Value; 
												String Result=ACHRAFTraceMixedGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), TraceMixedGold2Value); 
												ACHRAFTraceMixedGold2.UpdateCounters(Result, ACHRAFTraceMixedGold2);
												}
											}
											
									}else if(CountMethodNACHRAF>0 && CountMethodNACHRAFCallee>0) {
										
										boolean entered=false; 
										if(CountMethodTACHRAFGold2+CountMethodTACHRAFCalleeGold2==0 && methodtrace.getGoldfinal()!=null ) {
											
											NoTracePureGold2++; 
											NOTracePureGold2Value="N"; 
											data[j][ACHRAFNOTRACEPureGOLD2]=NOTracePureGold2Value; 
											entered=true; 
											
											
										} else if(methodtrace.getGoldfinal()!=null) {
											NoTraceMixedGold2++; 
											NOTraceMixedGold2Value="N"; 
											data[j][ACHRAFNOTRACEMixedGOLD2]=NOTraceMixedGold2Value; 
											entered=true; 
										}
										
										if(entered==true) {
										if(methodtrace.getGoldfinal()!=null && methodtrace.getGoldfinal().trim().equals("N")) {
											
											NoTraceCountTotal++; 
										}
											else if(methodtrace.getGoldfinal()!=null && methodtrace.getGoldfinal().trim().equals("T")) {
											TraceCountTotal++; 
										}
										
										
										
										
										
							
										
										
										if(methodtrace.getGoldfinal()!=null ) {
											String Result=ACHRAFNOTracePureGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), NOTracePureGold2Value); 
											ACHRAFNOTracePureGold2.UpdateCounters(Result, ACHRAFNOTracePureGold2);
											}
											
											if(methodtrace.getGoldfinal()!=null ) {
												String Result=ACHRAFNOTraceMixedGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), NOTraceMixedGold2Value); 
												ACHRAFNOTraceMixedGold2.UpdateCounters(Result, ACHRAFNOTraceMixedGold2);
												}
										}
										
								}else {
									failGold2++; 
								}
					
					
	
	
	
	String TracePureGoldValueMethodLevel="null"; 
	String TraceMixedGoldValueMethodLevel="null"; 
	String TracePureGold2ValueMethodLevel="null"; 
	String TraceMixedGold2ValueMethodLevel="null"; 
	String NOTracePureGoldValueMethodLevel="null"; 
	String NOTraceMixedGoldValueMethodLevel="null"; 
	String NOTracePureGold2ValueMethodLevel="null"; 
	String NOTraceMixedGold2ValueMethodLevel="null"; 
	/**************************************************************************************************************/
	/**************************************************************************************************************/
	/**************************************************************************************************************/
	//ACHRAF
	if(flagGold==false) {
		
	
	if(CountMethodT>0 && CountMethodTCallee>0) {
		
		boolean entered=false; 
		if(CountMethodN+CountMethodNCallee==0 && methodtrace.getGold()!=null ) {
			
			TracePureGold++; 
			TracePureGoldValueMethodLevel="T"; 
			entered=true; 
			
		} else if(methodtrace.getGold()!=null){
			TraceMixedGold++; 
			TraceMixedGoldValueMethodLevel="T"; 
			entered=true; 
		}
	
		if(entered==true) {
		if(methodtrace.getGold()!=null ) {
		data[j][CLASSTRACEMethodLevelPureGold]=TracePureGoldValueMethodLevel; 
		String Result=PredictionCLASSTRACEMethodLevelPureGold.ComparePredictionToGold(methodtrace.getGold().trim(), TracePureGoldValueMethodLevel); 
		PredictionCLASSTRACEMethodLevelPureGold.UpdateCounters(Result, PredictionCLASSTRACEMethodLevelPureGold);
		}
		
		if(methodtrace.getGold()!=null ) {
			data[j][CLASSTRACEMethodLevelMixedGold]=TraceMixedGoldValueMethodLevel; 
			String Result=PredictionCLASSTRACEMethodLevelMixedGold.ComparePredictionToGold(methodtrace.getGold().trim(), TraceMixedGoldValueMethodLevel); 
			PredictionCLASSTRACEMethodLevelMixedGold.UpdateCounters(Result, PredictionCLASSTRACEMethodLevelMixedGold);
			}
		}
		
}else if(CountMethodN>0 && CountMethodNCallee>0) {
	
	boolean entered=false; 
	if(CountMethodT+CountMethodTCallee==0 && methodtrace.getGold()!=null ) {
		
		NoTracePureGold++; 
		NOTracePureGoldValueMethodLevel="N"; 
		data[j][CLASSNOTRACEMethodLevelPureGold]=NOTracePureGoldValueMethodLevel; 
		entered=true; 
		
		
	} else if(methodtrace.getGold()!=null) {
		NoTraceMixedGold++; 
		NOTraceMixedGoldValueMethodLevel="N"; 
		data[j][CLASSNOTRACEMethodLevelMixedGold]=NOTraceMixedGoldValueMethodLevel; 
		entered=true; 
	}
	
	if(entered==true) {
	
	
	
	
	

	
	
	if(methodtrace.getGold()!=null ) {
		String Result=PredictionCLASSNOTRACEMethodLevelPureGold.ComparePredictionToGold(methodtrace.getGold().trim(), NOTracePureGoldValueMethodLevel); 
		PredictionCLASSNOTRACEMethodLevelPureGold.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelPureGold);
		}
		
		if(methodtrace.getGold()!=null ) {
			String Result=PredictionCLASSNOTRACEMethodLevelMixedGold.ComparePredictionToGold(methodtrace.getGold().trim(), NOTraceMixedGoldValueMethodLevel); 
			PredictionCLASSNOTRACEMethodLevelMixedGold.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelMixedGold);
			}
	}
	
}else {
failGold++; 
}
	}	
	
/********************************************************************************************************************/				
	if(flagGold2==false) {
if(CountMethodTGOLD2>0 && CountMethodTCalleeGOLD2>0) {
		
		boolean entered=false; 
		if(CountMethodNGOLD2+CountMethodNCalleeGOLD2==0 && methodtrace.getGoldfinal()!=null ) {
			
			TracePureGold2++; 
			TracePureGold2ValueMethodLevel="T"; 
			entered=true; 
			
		} else if(methodtrace.getGoldfinal()!=null) {
			TraceMixedGold2++; 
			TraceMixedGold2ValueMethodLevel="T"; 
			entered=true; 
		}
	
		if(entered==true) {
		
		if(methodtrace.getGoldfinal()!=null ) {
		data[j][CLASSTRACEMethodLevelPureGold2]=TracePureGold2ValueMethodLevel; 
		String Result=PredictionCLASSTRACEMethodLevelPureGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), TracePureGold2ValueMethodLevel); 
		PredictionCLASSTRACEMethodLevelPureGold2.UpdateCounters(Result, PredictionCLASSTRACEMethodLevelPureGold2);
		}
		
		if(methodtrace.getGoldfinal()!=null ) {
			data[j][CLASSTRACEMethodLevelMixedGold2]=TraceMixedGold2ValueMethodLevel; 
			String Result=PredictionCLASSTRACEMethodLevelMixedGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), TraceMixedGold2ValueMethodLevel); 
			PredictionCLASSTRACEMethodLevelMixedGold2.UpdateCounters(Result, PredictionCLASSTRACEMethodLevelMixedGold2);
			}
		}
		
}else if(CountMethodNGOLD2>0 && CountMethodNCalleeGOLD2>0) {
	
	boolean entered=false; 
	if(CountMethodTGOLD2+CountMethodTCalleeGOLD2==0 && methodtrace.getGoldfinal()!=null ) {
		
		NoTracePureGold2++; 
		NOTracePureGold2ValueMethodLevel="N"; 
		data[j][CLASSNOTRACEMethodLevelPureGold2]=NOTracePureGold2ValueMethodLevel; 
		entered=true; 
		
		
	} else if(methodtrace.getGoldfinal()!=null) {
		NoTraceMixedGold2++; 
		NOTraceMixedGold2ValueMethodLevel="N"; 
		data[j][CLASSNOTRACEMethodLevelMixedGold2]=NOTraceMixedGold2ValueMethodLevel; 
		entered=true; 
	}
	
	if(entered==true) {
	
	
	
	

	
	
	if(methodtrace.getGoldfinal()!=null ) {
		String Result=PredictionCLASSNOTRACEMethodLevelPureGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), NOTracePureGold2ValueMethodLevel); 
		PredictionCLASSNOTRACEMethodLevelPureGold2.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelPureGold2);
		}
		
		if(methodtrace.getGoldfinal()!=null ) {
			String Result=PredictionCLASSNOTRACEMethodLevelMixedGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), NOTraceMixedGold2ValueMethodLevel); 
			PredictionCLASSNOTRACEMethodLevelMixedGold2.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelMixedGold2);
			}
	}
	
}else {
failGold2++; 
}

	}

	
	
	
	


String TracePureGoldValueClassLevel="null"; 
String TraceMixedGoldValueClassLevel="null"; 
String TracePureGold2ValueClassLevel="null"; 
String TraceMixedGold2ValueClassLevel="null"; 
String NOTracePureGoldValueClassLevel="null"; 
String NOTraceMixedGoldValueClassLevel="null"; 
String NOTracePureGold2ValueClassLevel="null"; 
String NOTraceMixedGold2ValueClassLevel="null"; 
/**************************************************************************************************************/
/**************************************************************************************************************/
/**************************************************************************************************************/
//ACHRAF
if(flagGold==false) {
if(CounterTraceClassCallerT>0 && CounterTraceClassCalleeT>0) {
	
	boolean entered=false; 
	if(CounterTraceClassCallerN+CounterTraceClassCalleeN==0 && methodtrace.getGold()!=null ) {
		
		TracePureGold++; 
		TracePureGoldValueClassLevel="T"; 
		entered=true; 
		
	} else if(methodtrace.getGold()!=null){
		TraceMixedGold++; 
		TraceMixedGoldValueClassLevel="T"; 
		entered=true; 
	}

	if(entered==true) {
	if(methodtrace.getGold()!=null ) {
	data[j][CLASSTRACEClassLevelPureGold]=TracePureGoldValueClassLevel; 
	String Result=PredictionCLASSTRACEClassLevelPureGold.ComparePredictionToGold(methodtrace.getGold().trim(), TracePureGoldValueClassLevel); 
	PredictionCLASSTRACEClassLevelPureGold.UpdateCounters(Result, PredictionCLASSTRACEClassLevelPureGold);
	}
	
	if(methodtrace.getGold()!=null ) {
		data[j][CLASSTRACEClassLevelMixedGold]=TraceMixedGoldValueClassLevel; 
		String Result=PredictionCLASSTRACEClassLevelMixedGold.ComparePredictionToGold(methodtrace.getGold().trim(), TraceMixedGoldValueClassLevel); 
		PredictionCLASSTRACEClassLevelMixedGold.UpdateCounters(Result, PredictionCLASSTRACEClassLevelMixedGold);
		}
	}
	
}else if(CounterTraceClassCallerN>0 && CounterTraceClassCalleeN>0) {

boolean entered=false; 
if(CounterTraceClassCallerT+CounterTraceClassCalleeT==0 && methodtrace.getGold()!=null ) {
	
	NoTracePureGold++; 
	NOTracePureGoldValueClassLevel="N"; 
	data[j][CLASSNOTRACEClassLevelPureGold]=NOTracePureGoldValueClassLevel; 
	entered=true; 
	
	
} else if(methodtrace.getGold()!=null) {
	NoTraceMixedGold++; 
	NOTraceMixedGoldValueClassLevel="N"; 
	data[j][CLASSNOTRACEClassLevelMixedGold]=NOTraceMixedGoldValueClassLevel; 
	entered=true; 
}

if(entered==true) {








if(methodtrace.getGold()!=null ) {
	String Result=PredictionCLASSNOTRACEClassLevelPureGold.ComparePredictionToGold(methodtrace.getGold().trim(), NOTracePureGoldValueClassLevel); 
	PredictionCLASSNOTRACEClassLevelPureGold.UpdateCounters(Result, PredictionCLASSNOTRACEClassLevelPureGold);
	}
	
	if(methodtrace.getGold()!=null ) {
		String Result=PredictionCLASSNOTRACEClassLevelMixedGold.ComparePredictionToGold(methodtrace.getGold().trim(), NOTraceMixedGoldValueClassLevel); 
		PredictionCLASSNOTRACEClassLevelMixedGold.UpdateCounters(Result, PredictionCLASSNOTRACEClassLevelMixedGold);
		}
}

}else {
failGold++; 
}

}
/********************************************************************************************************************/				
if(flagGold2==false) {
if(CounterTraceClassCallerTGOLD2>0 && CounterTraceClassCalleeTGOLD2>0) {
	
	boolean entered=false; 
	if(CounterTraceClassCallerNGOLD2+CounterTraceClassCalleeNGOLD2==0 && methodtrace.getGoldfinal()!=null ) {
		
		TracePureGold2++; 
		TracePureGold2ValueClassLevel="T"; 
		entered=true; 
		
	} else if(methodtrace.getGoldfinal()!=null) {
		TraceMixedGold2++; 
		TraceMixedGold2ValueClassLevel="T"; 
		entered=true; 
	}

	if(entered==true) {
	
	if(methodtrace.getGoldfinal()!=null ) {
	data[j][CLASSTRACEClassLevelPureGold2]=TracePureGold2ValueClassLevel; 
	String Result=PredictionCLASSTRACEClassLevelPureGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), TracePureGold2ValueClassLevel); 
	PredictionCLASSTRACEClassLevelPureGold2.UpdateCounters(Result, PredictionCLASSTRACEClassLevelPureGold2);
	}
	
	if(methodtrace.getGoldfinal()!=null ) {
		data[j][CLASSTRACEClassLevelMixedGold2]=TraceMixedGold2ValueClassLevel; 
		String Result=PredictionCLASSTRACEClassLevelMixedGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), TraceMixedGold2ValueClassLevel); 
		PredictionCLASSTRACEClassLevelMixedGold2.UpdateCounters(Result, PredictionCLASSTRACEClassLevelMixedGold2);
		}
	}
	
}else if(CounterTraceClassCallerNGOLD2>0 && CounterTraceClassCalleeNGOLD2>0) {

boolean entered=false; 
if(CounterTraceClassCallerTGOLD2+CounterTraceClassCalleeTGOLD2==0 && methodtrace.getGoldfinal()!=null ) {
	
	NoTracePureGold2++; 
	NOTracePureGold2ValueClassLevel="N"; 
	data[j][CLASSNOTRACEClassLevelPureGold2]=NOTracePureGold2ValueClassLevel; 
	entered=true; 
	
	
} else if(methodtrace.getGoldfinal()!=null) {
	NoTraceMixedGold2++; 
	NOTraceMixedGold2ValueClassLevel="N"; 
	data[j][CLASSNOTRACEClassLevelMixedGold2]=NOTraceMixedGold2ValueClassLevel; 
	entered=true; 
}

if(entered==true) {







if(methodtrace.getGoldfinal()!=null ) {
	String Result=PredictionCLASSNOTRACEClassLevelPureGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), NOTracePureGold2ValueClassLevel); 
	PredictionCLASSNOTRACEClassLevelPureGold2.UpdateCounters(Result, PredictionCLASSNOTRACEClassLevelPureGold2);
	}
	
	if(methodtrace.getGoldfinal()!=null ) {
		String Result=PredictionCLASSNOTRACEClassLevelMixedGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), NOTraceMixedGold2ValueClassLevel); 
		PredictionCLASSNOTRACEClassLevelMixedGold2.UpdateCounters(Result, PredictionCLASSNOTRACEClassLevelMixedGold2);
		}
}

}else {
failGold2++; 
}
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
			
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

			

			

			bwGold2TableLog.write(data[j][Row] + "," +data[j][MethodID] + "," + data[j][MethodName] + "," + data[j][RequirementID] + "," + data[j][RequirementName] + "," + data[j][ClassID] + ","
					+ data[j][ClassName] + "," + data[j][Gold2] + "," + data[j][Subject] + "," + data[j][OwnerClassTGOLD2] + "," + data[j][OwnerClassNGOLD2] + ","
					+ data[j][OwnerClassEGOLD2] + "," + data[j][CallerMethodsNumberGOLD2]+ "," + AppendedCallers + "," + data[j][CallerMethodsTGOLD2] + "," +
					data[j][CallerMethodsNGOLD2] + "," + data[j][CallerMethodsEGOLD2] + ","
					+ data[j][CallerClassesNumberGOLD2] + "," + data[j][CallerClassesTGOLD2] + "," + data[j][CallerClassesNGOLD2] + "," + data[j][CallerClassesEGOLD2] + 
					"," + data[j][CalleeMethodsNumberGOLD2]+ "," + AppendedCallees +  ","
					+ data[j][CalleeMethodsTGOLD2] + "," + data[j][CalleeMethodsNGOLD2] + "," + data[j][CalleeMethodsEGOLD2] + "," + data[j][CalleeClassesNumberGOLD2] + 
					"," + data[j][CalleeClassesTGOLD2] + ","
					+ data[j][CalleeClassesNGOLD2] + "," + data[j][CalleeClassesEGOLD2] + "," + data[j][OwnerClassPredictionGOLD2] + "," + data[j][MajorityClassLevelCallersGOLD2]+ "," +
					data[j][MajorityClassLevelCalleesGOLD2]+","+data[j][MajorityMethodLevelCallersGOLD2]+","+data[j][MajorityMethodLevelCalleesGOLD2]
							+ "," + 
					data[j][AtLeast1NPredictionClassLevelCallersGOLD2]+ "," + data[j][AtLeast1NPredictionClassLevelCalleesGOLD2] 
					+ "," + data[j][AtLeast1NPredictionMethodLevelCallersGOLD2]+ "," + data[j][AtLeast1NPredictionMethodLevelCalleesGOLD2]
					+ "," +data[j][AtLeast1TPredictionClassLevelCallersGOLD2]+ "," + data[j][AtLeast1TPredictionClassLevelCalleesGOLD2]
					+ "," + data[j][AtLeast1TPredictionMethodLevelCallersGOLD2]
					+ "," + data[j][AtLeast1TPredictionMethodLevelCalleesGOLD2]
							+ "," + 
							data[j][AtLeast2NPredictionClassLevelCallersGOLD2]+ "," + data[j][AtLeast2NPredictionClassLevelCalleesGOLD2] 
							+ "," + data[j][AtLeast2NPredictionMethodLevelCallersGOLD2]+ "," + data[j][AtLeast2NPredictionMethodLevelCalleesGOLD2]
							+ "," +data[j][AtLeast2TPredictionClassLevelCallersGOLD2]+ "," + data[j][AtLeast2TPredictionClassLevelCalleesGOLD2]
							+ "," + data[j][AtLeast2TPredictionMethodLevelCallersGOLD2]
							+ "," + data[j][AtLeast2TPredictionMethodLevelCalleesGOLD2]	
									+ "," + data[j][AllNClassLevelCallersGOLD2]
											+ "," +data[j][AllNClassLevelCalleesGOLD2]+ "," + data[j][AllNMethodLevelCallersGOLD2]+ "," + data[j][AllNMethodLevelCalleesGOLD2]+ "," +
											data[j][AllTClassLevelCallersGOLD2]+ ","+		data[j][AllTClassLevelCalleesGOLD2]+ ","+		data[j][AllTMethodLevelCallersGOLD2]+ 
											","+		data[j][AllTMethodLevelCalleesGOLD2]+","+
											
						","+data[j][AllNClassLevelCallersAtLeast2NGOLD2]
								+ "," +data[j][AllNClassLevelCallersAtLeast2NGOLD2]+ "," + data[j][AllNMethodLevelCallersAtLeast2NGOLD2]+ "," + data[j][AllNMethodLevelCalleesAtLeast2NGOLD2]+ "," +
								data[j][AllTClassLevelCallersAtLeast2TGOLD2]+ ","+		data[j][AllTClassLevelCalleesAtLeast2TGOLD2]+ ","+		data[j][AllTMethodLevelCallersAtLeast2TGOLD2]
//										+ 
//								","+
//											
//											OnlyinParsedCallers	+","+ OnlyinExecutedCallers+","+BothParsedAndExecutedCallers+","+OnlyInParsedCallees+","+OnlyInExecutedCallees
//											+","+BothInParsedAndExecutedCallees
										
										+","+data[j][paramatersNumber]+","+ParametersAppended+","+data [j][CountParamaterTGOLD2]+","+data [j][CountParamaterNGOLD2]+","+data [j][CountParamaterEGOLD2]+","+data[j][MajorityParametersGOLD2]+","+data[j][AtLeast1NParameterGOLD2]
													+","+data[j][AtLeast1TParameter]+","+data[j][AtLeast2TParameter]+","+data[j][AtLeast2NParameter]+","+data[j][AllNParameters]+","+data[j][AllTParameters]+","+
													data[j][ACHRAFTRACEPureGOLD2]+","+data[j][ACHRAFTRACEMixedGOLD2]+","+data[j][ACHRAFNOTRACEPureGOLD2]+","+data[j][ACHRAFNOTRACEMixedGOLD2]+","+	
													data[j][AllNMethodLevelCallersCalleesGOLD2]+","+data[j][AllTMethodLevelCallersCalleesGOLD2]+","+data[j][AllTClassLevelCallersCalleesGOLD2]+","+data[j][AllNClassLevelCallersCalleesGOLD2]+","+	
													data[j][CLASSTRACEMethodLevelPureGold2]+","+data[j][CLASSTRACEMethodLevelMixedGold2]+","+data[j][CLASSNOTRACEMethodLevelPureGold2]+","+data[j][CLASSNOTRACEMethodLevelMixedGold2]+","+	
													data[j][CLASSTRACEClassLevelPureGold2]+","+data[j][CLASSTRACEClassLevelMixedGold2]+","+data[j][CLASSNOTRACEClassLevelPureGold2]+","+data[j][CLASSNOTRACEClassLevelMixedGold2]
					
					);
			bwGold2TableLog.newLine();

			
			
			
			bw.write(data[j][Row] + "," +data[j][MethodID] + "," + data[j][MethodName] + "," + data[j][RequirementID] + "," + data[j][RequirementName] + "," + data[j][ClassID] + ","
					+ data[j][ClassName] + "," + data[j][Gold] +","+	
							methodtrace.goldfinal+ "," + data[j][Subject] + "," + data[j][OwnerClassT] + "," + data[j][OwnerClassN] + ","
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
					
","+data[j][AllNClassLevelCallersAtLeast2NGOLD]
		+ "," +data[j][AllNClassLevelCallersAtLeast2NGOLD]+ "," + data[j][AllNMethodLevelCallersAtLeast2NGOLD]+ "," + data[j][AllNMethodLevelCalleesAtLeast2NGOLD]+ "," +
		data[j][AllTClassLevelCallersAtLeast2TGOLD]+ ","+		data[j][AllTClassLevelCalleesAtLeast2TGOLD]+ ","+		data[j][AllTMethodLevelCallersAtLeast2TGOLD]
//		+","+
//					
//					OnlyinParsedCallers	+","+ OnlyinExecutedCallers+","+BothParsedAndExecutedCallers+","+OnlyInParsedCallees+","+OnlyInExecutedCallees
//					+","+BothInParsedAndExecutedCallees
					
					
					
					+","+data[j][paramatersNumber]+","+ParametersAppended+","+data [j][CountParamaterT]+","+data [j][CountParamaterN]+","+data [j][CountParamaterE]+","+data[j][MajorityParameters]+","+data[j][AtLeast1NParameter]
							+","+data[j][AtLeast1TParameter]+","+data[j][AtLeast2TParameter]+","+data[j][AtLeast2NParameter]+","+data[j][AllNParameters]+","+data[j][AllTParameters]+","+
							data[j][ACHRAFTRACEPureGold]+","+data[j][ACHRAFTRACEMixedGold]+","+data[j][ACHRAFNOTRACEPureGold]+","+data[j][ACHRAFNOTRACEMixedGold]+","+	
							data[j][AllNMethodLevelCallersCallees]+","+data[j][AllTMethodLevelCallersCallees]+","+data[j][AllTClassLevelCallersCallees]+","+data[j][AllNClassLevelCallersCallees]+","+	
							data[j][CLASSTRACEMethodLevelPureGold]+","+data[j][CLASSTRACEMethodLevelMixedGold]+","+data[j][CLASSNOTRACEMethodLevelPureGold]+","+data[j][CLASSNOTRACEMethodLevelMixedGold]+","+	
							data[j][CLASSTRACEClassLevelPureGold]+","+data[j][CLASSTRACEClassLevelMixedGold]+","+data[j][CLASSNOTRACEClassLevelPureGold]+","+data[j][CLASSNOTRACEClassLevelMixedGold]);
				
			bw.newLine();


			j++;
		}

		bw.close();
		
		
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
		bw2.write("ALL N CLASS LEVEL CALLERS AT LEAST 2N : "+AllNClassLevelCallersClassAtLeast2NGold.toString()); 
		bw2.newLine();
		bw2.write("ALL N CLASS LEVEL CALLEES AT LEAST 2N : "+AllNClassLevelCalleesClassAtLeast2NGold.toString()); 
		bw2.newLine();
		bw2.write("ALL N METHOD LEVEL CALLERS AT LEAST 2N: "+AllNMethodLevelCallersClassAtLeast2NGold.toString()); 
		bw2.newLine();
		bw2.write("ALL N METHOD LEVEL CALLEES AT LEAST 2N: "+AllNMethodLevelCalleesClassAtLeast2NGold.toString()); 
		bw2.newLine();
		bw2.write("ALL T CLASS LEVEL CALLERS AT LEAST 2T : "+AllTClassLevelCallersClassAtLeast2TGold.toString()); 
		bw2.newLine();
		bw2.write("ALL T CLASS LEVEL CALLEES AT LEAST 2T : "+AllTClassLevelCalleesClassAtLeast2TGold.toString()); 
		bw2.newLine();
		bw2.write("ALL T METHOD LEVEL CALLERS AT LEAST 2T: "+AllTMethodLevelCallersClassAtLeast2TGold.toString()); 
		bw2.newLine();
		bw2.write("ALL T METHOD LEVEL CALLEES AT LEAST 2T: "+AllTMethodLevelCalleesClassAtLeast2TGold.toString()); 
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
		bw2.write("TRACE PURE METHOD LEVEL: "+PredictionCLASSTRACEMethodLevelPureGold.toString()); 
		bw2.newLine();
		bw2.write("TRACE MIXED METHOD LEVEL: "+PredictionCLASSTRACEMethodLevelMixedGold.toString()); 
		bw2.newLine();
		bw2.write("NO TRACE PURE METHOD LEVEL: "+PredictionCLASSNOTRACEMethodLevelPureGold.toString()); 
		bw2.newLine();
		bw2.write("NO TRACE MIXED METHOD LEVEL: "+PredictionCLASSNOTRACEMethodLevelMixedGold.toString()); 
		bw2.newLine();
		bw2.write("TRACE PURE CLASS LEVEL: "+PredictionCLASSTRACEClassLevelPureGold.toString()); 
		bw2.newLine();
		bw2.write("TRACE MIXED CLASS LEVEL: "+PredictionCLASSTRACEClassLevelMixedGold.toString()); 
		bw2.newLine();
		bw2.write("NO TRACE PURE CLASS LEVEL: "+PredictionCLASSNOTRACEClassLevelPureGold.toString()); 
		bw2.newLine();
		bw2.write("NO TRACE MIXED CLASS LEVEL: "+PredictionCLASSNOTRACEClassLevelMixedGold.toString()); 
		bw2.newLine();
		bw2.newLine();
		bw2.newLine();
		bw2.write("ACHRAF TRACE PURE: "+ACHRAFTracePureGold.toString()); 
		bw2.newLine();
		bw2.write("ACHRAF TRACE MIXED GOLD: "+ACHRAFTraceMixedGold.toString()); 
		bw2.newLine();
		bw2.write("ACHRAF NO TRACE PURE: "+ACHRAFNOTracePureGold.toString()); 
		bw2.newLine();
		bw2.write("ACHRAF NO TRACE MIXED GOLD: "+ACHRAFNOTraceMixedGold.toString()); 
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
		bwGold2.write("ALL N CLASS LEVEL CALLERS AT LEAST 2N : "+AllNClassLevelCallersClassAtLeast2NGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL N CLASS LEVEL CALLEES AT LEAST 2N : "+AllNClassLevelCalleesClassAtLeast2NGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL N METHOD LEVEL CALLERS AT LEAST 2N: "+AllNMethodLevelCallersClassAtLeast2NGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL N METHOD LEVEL CALLEES AT LEAST 2N: "+AllNMethodLevelCalleesClassAtLeast2NGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL T CLASS LEVEL CALLERS AT LEAST 2T : "+AllTClassLevelCallersClassAtLeast2TGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL T CLASS LEVEL CALLEES AT LEAST 2T : "+AllTClassLevelCalleesClassAtLeast2TGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL T METHOD LEVEL CALLERS AT LEAST 2T: "+AllTMethodLevelCallersClassAtLeast2TGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("ALL T METHOD LEVEL CALLEES AT LEAST 2T: "+AllTMethodLevelCalleesClassAtLeast2TGold2.toString()); 
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
		bwGold2.write("TRACE PURE METHOD LEVEL: "+PredictionCLASSTRACEMethodLevelPureGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("TRACE MIXED METHOD LEVEL: "+PredictionCLASSTRACEMethodLevelMixedGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("NO TRACE PURE METHOD LEVEL: "+PredictionCLASSNOTRACEMethodLevelPureGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("NO TRACE MIXED METHOD LEVEL: "+PredictionCLASSNOTRACEMethodLevelMixedGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("TRACE PURE CLASS LEVEL: "+PredictionCLASSTRACEClassLevelPureGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("TRACE MIXED CLASS LEVEL: "+PredictionCLASSTRACEClassLevelMixedGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("NO TRACE PURE CLASS LEVEL: "+PredictionCLASSNOTRACEClassLevelPureGold2.toString()); 
		bwGold2.newLine();
		bwGold2.write("NO TRACE MIXED CLASS LEVEL: "+PredictionCLASSNOTRACEClassLevelMixedGold2.toString()); 
		bwGold2.newLine();
		bwGold2.close();
		
		
//		String[] columnNames = {"Row",  "MethodID", "MethodName", "RequirementID", "RequirementName", "ClassID", "ClassName",
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
		
		
		String[] columnNames = {"0-Row",  "1-MethodID", "2-MethodName", "3-RequirementID", "4-RequirementName", "5-ClassID", "6-ClassName",
				"7-Gold", "8-Subject", "9-OwnerClass T", "10-Owner Class N", "11-Owner Class E", "12-# caller methods",
				"13-# caller methods T", "14-#caller methods N", "15-#caller methods E", "16-# caller classes",
				"17-# caller classes T", "18-#caller classes N", "19-#caller classes E", "20-# callee methods",
				"21-# callee methods T", "22-#callee methods N", "23-#callee methods E", "24-# callee classes",
				"25-# callee classes T", "26-#callee classes N", "27-#callee classes E",  "28-OwnerClassPrediction",
				"29-MajorityClassLevelCallees","30-MajorityClassLevelCallers", "31-MajorityMethodLevelCallees","32-MajorityMethodLevelCallers",
				"33->1NPredictionClassLevelCallees", "34->1NPredictionClassLevelCallers", "35->1NPredictionMethodLevelCallees", 
				"36->1NPredictionMethodLevelCallers", "37->1TPredictionClassLevelCallees", "38->1TPredictionClassLevelCallers", 
				"39->1TPredictionMethodLevelCallees", "40->1TPredictionMethodLevelCallers", 
				"41->2NPredictionClassLevelCallees", "42->2NPredictionClassLevelCallers", "43->2NPredictionMethodLevelCallees", 
				"44->2NPredictionMethodLevelCallers", "45->2TPredictionClassLevelCallees", "46->2TPredictionClassLevelCallers", 
				"47->2TPredictionMethodLevelCallees", "48->2TPredictionMethodLevelCallers", 
				"49-AllNClassLevelCallees", "50-AllNClassLevelCallers","51-AllNMethodLevelCallees","52-AllNMethodLevelCallers",
				"53-AllTClassLevelCallees", "54-AllTClassLevelCallers", "55-AllTMethodLevelCallees", "56-AllTMethodLevelCallers"
				,"57-AllNAtLeast2NClassLevelCallees", "58-AllNAtLeast2NClassLevelCallers","59-AllNAtLeast2NMethodLevelCallees","60-AllNAtLeast2NMethodLevelCallers",
				"61-AllTAtLeast2TClassLevelCallees", "62-AllTAtLeast2TClassLevelCallers", "63-AllTAtLeast2TMethodLevelCallees", "64-AllTAtLeast2TMethodLevelCallers"
				,"65-Callers", "66-Callees", "67-#parameters", "68-Parameters","69-# Parameter T" ,"70-# Parameter N" ,"71-# Parameter E" ,
				"72-MajorityParameterPrediction", "73-AtLeast1NParameterPrediction", 
				"74-AtLeast1TParameterPrediction", "75-AtLeast2TParameterPrediction", 
				"76-AtLeast2NParameterPrediction", "77-AllNParameterPrediction", "78-AllTParameterPrediction", 
				"79-ACHRAFTRACEPureGOLD", "80-ACHRAFTRACEMixedGOLD", "81-ACHRAFNOTRACEPureGOLD", "82-ACHRAFNOTRACEMixedGOLD", 
				"83-AllTMethodLevelCallersCalleesClass ", "84-AllNMethodLevelCallersCalleesClass",
				"85-AllTClassLevelCallersCalleesClass", "86-AllNClassLevelCallersCalleesClass", 
				"CLASSTRACEMethodLevelPureGold","CLASSTRACEMethodLevelMixedGold","CLASSNOTRACEMethodLevelPureGold","CLASSNOTRACEMethodLevelMixedGold",
				"CLASSTRACEClassLevelPureGold","CLASSTRACEClassLevelMixedGold","CLASSNOTRACEClassLevelPureGold","CLASSNOTRACEClassLevelMixedGold",
				
				
				"87-GOLD2", "88-OwnerClass T GOLD2", "89-Owner Class N GOLD2", "90-Owner Class E GOLD2", "91-# caller methods GOLD2",
				"92-# caller methods T GOLD2", "93-#caller methods N GOLD2", "94-#caller methods E GOLD2", "95-# caller classes GOLD2",
				"96-# caller classes T GOLD2", "97-#caller classes N GOLD2", "98-#caller classes E GOLD2", "99-# callee methods GOLD2",
				"100-# callee methods T GOLD2", "101-#callee methods N GOLD2", "102-#callee methods E GOLD2", "103-# callee classes GOLD2",
				"104-# callee classes T GOLD2", "105-#callee classes N GOLD2", "106-#callee classes E GOLD2",  "107-OwnerClassPrediction GOLD2",
				"108-MajorityClassLevelCallees GOLD2","109-MajorityClassLevelCallers GOLD2", "110-MajorityMethodLevelCallees GOLD2","111-MajorityMethodLevelCallers GOLD2",
				"112->1NPredictionClassLevelCallees GOLD2", "113->1NPredictionClassLevelCallers GOLD2", "114->1NPredictionMethodLevelCallees GOLD2", 
				"115->1NPredictionMethodLevelCallers GOLD2", "116->1TPredictionClassLevelCallees GOLD2", "117->1TPredictionClassLevelCallers GOLD2", 
				"118->1TPredictionMethodLevelCallees GOLD2", "119->1TPredictionMethodLevelCallers GOLD2", 
				"120->2NPredictionClassLevelCallees GOLD2", "121->2NPredictionClassLevelCallers GOLD2", "122->2NPredictionMethodLevelCallees GOLD2", 
				"123->2NPredictionMethodLevelCallers GOLD2", "124->2TPredictionClassLevelCallees GOLD2", "125->2TPredictionClassLevelCallers GOLD2", 
				"126->2TPredictionMethodLevelCallees GOLD2", "127->2TPredictionMethodLevelCallers GOLD2", 
				"128-AllNClassLevelCallees GOLD2", "129-AllNClassLevelCallers GOLD2","130-AllNMethodLevelCallees GOLD2","131-AllNMethodLevelCallers GOLD2",
				"132-AllTClassLevelCallees GOLD2", "133-AllTClassLevelCallers GOLD2", "134-AllTMethodLevelCallees GOLD2", "135-AllTMethodLevelCallers  GOLD2"
				,"136-AllNAtLeast2NClassLevelCallees GOLD2", "137-AllNAtLeast2NClassLevelCallers GOLD2","138-AllNAtLeast2NMethodLevelCallees GOLD2","139-AllNAtLeast2NMethodLevelCallers GOLD2",
				"140-AllTAtLeast2TClassLevelCallees GOLD2", "141-AllTAtLeast2TClassLevelCallers GOLD2", "142-AllTAtLeast2TMethodLevelCallees GOLD2", "143-AllTAtLeast2TMethodLevelCallers GOLD2"
				
				,"144-Callers GOLD2", "145-Callees GOLD2", "146-#parameters GOLD2","147-# Parameter T" ,"148-# Parameter N" ,"149-# Parameter E" ,
				"150-MajorityParameterPrediction GOLD2", "151-AtLeast1NParameterPrediction GOLD2", 
				"152-AtLeast1TParameterPrediction GOLD2", "153-AtLeast2TParameterPrediction GOLD2", 
				"154-AtLeast2NParameterPrediction GOLD2", "155-AllNParameterPrediction GOLD2", "156-AllTParameterPrediction GOLD2",
				"157-ACHRAFTRACEPureGOLD 2", "158-ACHRAFTRACEMixedGOLD2", "159-ACHRAFNOTRACEPureGOLD 2", "160-ACHRAFNOTRACEMixed GOLD2", 
				"161-AllTMethodLevelCallersCalleesClass GOLD2", "162-AllNMethodLevelCallersCalleesClass GOLD2",
				"163-AllTClassLevelCallersCalleesClass GOLD2", "164-AllNClassLevelCallersCalleesClass GOLD2", 
				"CLASSTRACEMethodLevelPureGold2","CLASSTRACEMethodLevelMixedGold2","CLASSNOTRACEMethodLevelPureGold2","CLASSNOTRACEMethodLevelMixedGold2]",
				"CLASSTRACEClassLevelPureGold2","CLASSTRACEClassLevelMixedGold2","CLASSNOTRACEClassLevelPureGold2","CLASSNOTRACEClassLevelMixedGold2"
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

		TracesTableChessFINAL_PARSED_CALLS frame = new TracesTableChessFINAL_PARSED_CALLS();
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



