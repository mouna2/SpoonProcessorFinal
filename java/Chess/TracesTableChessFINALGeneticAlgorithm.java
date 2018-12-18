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
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
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

import mypackage.ClassField2;
import mypackage.Clazz;
import mypackage.ClassTrace2;
import mypackage.ColumnGroup;
import mypackage.DatabaseReading2;
import mypackage.GroupableTableHeader;
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

public class TracesTableChessFINALGeneticAlgorithm extends JFrame {
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
	int CLASSTRACEMethodLevelPureGoldACROSS=87; 
	int CLASSTRACEMethodLevelMixedGoldACROSS=88; 
	int CLASSNOTRACEMethodLevelPureGoldACROSS=89; 
	int CLASSNOTRACEMethodLevelMixedGoldACROSS=90;
	int CLASSTRACEClassLevelPureGoldACROSS=91; 
	int CLASSTRACEClassLevelMixedGoldACROSS=92; 
	int CLASSNOTRACEClassLevelPureGoldACROSS=93; 
	int CLASSNOTRACEClassLevelMixedGoldACROSS=94;
	
	
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
	int CLASSTRACEMethodLevelPureGold2ACROSS=181; 
	int CLASSTRACEMethodLevelMixedGold2ACROSS=182; 
	int CLASSNOTRACEMethodLevelPureGold2ACROSS=183; 
	int CLASSNOTRACEMethodLevelMixedGold2ACROSS=184;
	int CLASSTRACEClassLevelPureGold2ACROSS=185; 
	int CLASSTRACEClassLevelMixedGold2ACROSS=186; 
	int CLASSNOTRACEClassLevelPureGold2ACROSS=187; 
	int CLASSNOTRACEClassLevelMixedGold2ACROSS=188;
	int CallerMethodsNumberGOLD2ACROSS=189; 
	int CallerMethodsTGOLD2ACROSS=190; 
	int CallerMethodsNGOLD2ACROSS=191; 
	int CallerMethodsEGOLD2ACROSS=192; 
	int CallerClassesNumberGOLD2ACROSS=193; 
	int CallerClassesTGOLD2ACROSS=194; 
	int CallerClassesNGOLD2ACROSS=195; 
	int CallerClassesEGOLD2ACROSS=196; 
	int CalleeMethodsNumberGOLD2ACROSS=197; 
	int CalleeMethodsTGOLD2ACROSS=198; 
	int CalleeMethodsNGOLD2ACROSS=199; 
	int CalleeMethodsEGOLD2ACROSS=200; 
	int CalleeClassesNumberGOLD2ACROSS=201; 
	int CalleeClassesTGOLD2ACROSS=202; 
	int CalleeClassesNGOLD2ACROSS=203; 
	int CalleeClassesEGOLD2ACROSS=204; 
	int CallerMethodsNumberACROSS=205; 
	int CallerMethodsTACROSS=206; 
	int CallerMethodsNACROSS=207; 
	int CallerMethodsEACROSS=208; 
	int CallerClassesNumberACROSS=209; 
	int CallerClassesTACROSS=210; 
	int CallerClassesNACROSS=211; 
	int CallerClassesEACROSS=212; 
	int CalleeMethodsNumberACROSS=213; 
	int CalleeMethodsTACROSS=214; 
	int CalleeMethodsNACROSS=215; 
	int CalleeMethodsEACROSS=216; 
	int CalleeClassesNumberACROSS=217; 
	int CalleeClassesTACROSS=218; 
	int CalleeClassesNACROSS=219; 
	int CalleeClassesEACROSS=220; 
	int interfacesNumberGOLD2=221; 
	int CountInterfaceTGOLD2=222; 
	int CountInterfaceNGOLD2=223; 
	int CountInterfaceEGOLD2=224; 
	
	int FieldClassesNumberGOLD2=225; 
	int CountFieldClassTGOLD2=226; 
	int CountFieldClassNGOLD2=227; 
	int CountFieldClassEGOLD2=228; 
	
	int FieldMethodsNumberGOLD2=229; 
	int CountFieldMethodTGOLD2=230; 
	int CountFieldMethodNGOLD2=231; 
	int CountFieldMethodEGOLD2=232; 
	
	int SuperClassesNumberGOLD2=233; 
	int CountFieldSuperClassTGOLD2=234; 
	int CountFieldSuperClassNGOLD2=235; 
	int CountFieldSuperClassEGOLD2=236; 
	
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
	PredictionEvaluation PredictionCLASSTRACEMethodLevelPureGoldACROSS=new PredictionEvaluation(); 
	PredictionEvaluation PredictionCLASSTRACEMethodLevelMixedGoldACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelPureGoldACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelMixedGoldACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSTRACEClassLevelPureGoldACROSS=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSTRACEClassLevelMixedGoldACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelPureGoldACROSS=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelMixedGoldACROSS=new PredictionEvaluation();  
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
	PredictionEvaluation PredictionCLASSTRACEMethodLevelPureGold2ACROSS=new PredictionEvaluation(); 
	PredictionEvaluation PredictionCLASSTRACEMethodLevelMixedGold2ACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelPureGold2ACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelMixedGold2ACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSTRACEClassLevelPureGold2ACROSS=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSTRACEClassLevelMixedGold2ACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelPureGold2ACROSS=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelMixedGold2ACROSS=new PredictionEvaluation();  

	
	
	
	
	
	LinkedHashMap<String, String> OwnerClassPredictionClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> MajorityClassLevelCallersClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> MajorityClassLevelCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> MajorityMethodLevelCallersClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> MajorityMethodLevelCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeastNPredictionClassLevelCallersClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeastNPredictionClassLevelCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeastNPredictionMethodLevelCallersClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeastNPredictionMethodLevelCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeastTPredictionClassLevelCallersClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeastTPredictionClassLevelCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeastTPredictionMethodLevelCallersClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeastTPredictionMethodLevelCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeast2NPredictionClassLevelCallersClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeast2NPredictionClassLevelCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeast2NPredictionMethodLevelCallersClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeast2NPredictionMethodLevelCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeast2TPredictionClassLevelCallersClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeast2TPredictionClassLevelCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeast2TPredictionMethodLevelCallersClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeast2TPredictionMethodLevelCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllNClassLevelCallersClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllNClassLevelCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllNMethodLevelCallersClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllNMethodLevelCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllTMethodLevelCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllTClassLevelCallersClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllTClassLevelCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllTMethodLevelCallersClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> MajorityParametersClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeast1NParameterClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeast2NParameterClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeast1TParameterClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AtLeast2TParameterClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllNParameterClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllTParameterClassGold2HashMap= new LinkedHashMap<String, String>(); 
//	LinkedHashMap<String, String> AllNClassLevelCallersCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> ACHRAFTracePureGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> ACHRAFTraceMixedGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> ACHRAFNOTracePureGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> ACHRAFNOTraceMixedGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllNMethodLevelCallersCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllTMethodLevelCallersCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllNClassLevelCallersCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllTClassLevelCallersCalleesClassGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> ACHRAFGold2HashMapTrace= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> ACHRAFGold2HashMapNOTrace= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> PureNCallersGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> PureTCallersGold2HashMap= new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllNClassLevelCalleesClassAtLeast2NGold2HashMap=new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllNClassLevelCallersClassAtLeast2NGold2HashMap=new LinkedHashMap<String, String>();  
	LinkedHashMap<String, String> AllNMethodLevelCalleesClassAtLeast2NGold2HashMap=new LinkedHashMap<String, String>();  
	LinkedHashMap<String, String> AllNMethodLevelCallersClassAtLeast2NGold2HashMap=new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllTClassLevelCalleesClassAtLeast2TGold2HashMap=new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> AllTClassLevelCallersClassAtLeast2TGold2HashMap=new LinkedHashMap<String, String>();  
	LinkedHashMap<String, String> AllTMethodLevelCalleesClassAtLeast2TGold2HashMap=new LinkedHashMap<String, String>();  
	LinkedHashMap<String, String> AllTMethodLevelCallersClassAtLeast2TGold2HashMap=new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> PredictionCLASSTRACEMethodLevelPureGold2HashMap=new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> PredictionCLASSTRACEMethodLevelMixedGold2HashMap=new LinkedHashMap<String, String>();  
	LinkedHashMap<String, String> PredictionCLASSNOTRACEMethodLevelPureGold2HashMap=new LinkedHashMap<String, String>();  
	LinkedHashMap<String, String> PredictionCLASSNOTRACEMethodLevelMixedGold2HashMap=new LinkedHashMap<String, String>();  
	LinkedHashMap<String, String> PredictionCLASSTRACEClassLevelPureGold2HashMap=new LinkedHashMap<String, String>();   
	LinkedHashMap<String, String> PredictionCLASSTRACEClassLevelMixedGold2HashMap=new LinkedHashMap<String, String>();  
	LinkedHashMap<String, String> PredictionCLASSNOTRACEClassLevelPureGold2HashMap=new LinkedHashMap<String, String>();   
	LinkedHashMap<String, String> PredictionCLASSNOTRACEClassLevelMixedGold2HashMap=new LinkedHashMap<String, String>();  
	LinkedHashMap<String, String> PredictionCLASSTRACEMethodLevelPureGold2HashMapACROSS=new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> PredictionCLASSTRACEMethodLevelMixedGold2HashMapACROSS=new LinkedHashMap<String, String>();  
	LinkedHashMap<String, String> PredictionCLASSNOTRACEMethodLevelPureGold2HashMapACROSS=new LinkedHashMap<String, String>();  
	LinkedHashMap<String, String> PredictionCLASSNOTRACEMethodLevelMixedGold2HashMapACROSS=new LinkedHashMap<String, String>();  
	LinkedHashMap<String, String> PredictionCLASSTRACEClassLevelPureGold2HashMapACROSS=new LinkedHashMap<String, String>();   
	LinkedHashMap<String, String> PredictionCLASSTRACEClassLevelMixedGold2HashMapACROSS=new LinkedHashMap<String, String>();  
	LinkedHashMap<String, String> PredictionCLASSNOTRACEClassLevelPureGold2HashMapACROSS=new LinkedHashMap<String, String>();   
	LinkedHashMap<String, String> PredictionCLASSNOTRACEClassLevelMixedGold2HashMapACROSS=new LinkedHashMap<String, String>();  
	
	
	
	
	LinkedHashMap<String, String> PredictionStandardHashMap=new LinkedHashMap<String, String>();  

	ClassTrace2 myclasstrace = new ClassTrace2();
	static HashMap<String, MethodTrace> methodtraces2 = new HashMap<String, MethodTrace>();
	static List<ClassTrace2> classtraces2 = new ArrayList<ClassTrace2>();
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass = new  LinkedHashMap<String, ClassTrace2>(); 
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClassGOLD2 = new  LinkedHashMap<String, ClassTrace2>(); 

	 LinkedHashMap<String, Method2Details> linkedmethodhashmap= new LinkedHashMap<String, Method2Details>(); 
	 HashMap<String, Interface2> InterfacesHashMap= new HashMap<String, Interface2>();
	 HashMap<String, Interface2> InterfacesHashMapAlreadyImpl= new HashMap<String, Interface2>(); 
	 HashMap<String, List<Interface2>>  InterfacesOwnerClassHashMap= new HashMap<String, List<Interface2>>(); 
	 HashMap<String, List< MethodField2>>  FieldMethodsHashMap= new HashMap<String, List< MethodField2>>(); 
	 HashMap<String, List< ClassField2>> FieldClassesHashMap=  new HashMap<String, List< ClassField2>>(); 
	 HashMap<String, List< SuperClass2>> SuperclassesHashMap=  new HashMap<String, List< SuperClass2>>(); 
	JTable table = new JTable(); 
	static List<Method2Details> methodlist = new ArrayList<Method2Details>();
	//File fout = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\TableLog.txt");
	File fout = new File("C:\\Users\\mouna\\dumps\\TableLogChess.txt");

	FileOutputStream fos = new FileOutputStream(fout);
	
//	File fout2 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\PredictionEvaluationChess.txt");
	File fout2 = new File("C:\\Users\\mouna\\dumps\\PredictionEvaluationChess.txt");

	FileOutputStream fos2 = new FileOutputStream(fout2);
	
	//File foutGold2 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\PredictionEvaluationChessGold2.txt");
	File foutGold2 = new File("C:\\Users\\mouna\\dumps\\PredictionEvaluationChessGold2.txt");

	FileOutputStream fileGold2 = new FileOutputStream(foutGold2);
	
	File foutGold2TableLog = new File("C:\\Users\\mouna\\dumps\\TableLogChessGOLD2.txt");
	FileOutputStream fosGold2 = new FileOutputStream(foutGold2TableLog);
	BufferedWriter bwGold2TableLog = new BufferedWriter(new OutputStreamWriter(fosGold2));

	
	
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(fos2));
	BufferedWriter bwGold2 = new BufferedWriter(new OutputStreamWriter(fileGold2));
	File mylog = new File("C:\\Users\\mouna\\dumps\\logs\\logChessAllTClassLevelCallers.txt");
	FileOutputStream mylogfile = new FileOutputStream(mylog);
	BufferedWriter bwlog = new BufferedWriter(new OutputStreamWriter(mylogfile));
	
	File mylog2 = new File("C:\\Users\\mouna\\dumps\\logs\\logChessTraceMixed.txt");
	FileOutputStream mylogfile2 = new FileOutputStream(mylog2);
	BufferedWriter bwlog2 = new BufferedWriter(new OutputStreamWriter(mylogfile2));
	
	File mylog3 = new File("C:\\Users\\mouna\\dumps\\logs\\logChessPure.txt");
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

	public TracesTableChessFINALGeneticAlgorithm() throws SQLException, IOException {
	
		bwGold2TableLog.write("RowNumber, MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold2, Subject, OwnerClassT, OwnerClassN, "
				+ "OwnerClassE, #callermethods, callers, "
				+ "#callermethodsT, #callermethodsN, #callermethodsE, #callerclasses, #callerclassesT, #callerclassesN, "
				+ "#callerclassesE, #calleemethods, callees, #calleemethodsT, #calleemethodsN, #calleemethodsE, #calleeclasses, #calleeclassesT, #calleeclassesN, "
				+ "#calleeclassesE, "
				
				+"#callermethodsACROSS, #callermethodsTACROSS, #callermethodsNACROSS, #callermethodsEACROSS, #callerclassesACROSS, #callerclassesTACROSS, #callerclassesNACROSS, "
				+ "#callerclassesEACROSS, #calleemethodsACROSS,#calleemethodsTACROSS, #calleemethodsNACROSS, #calleemethodsEACROSS, #calleeclassesACROSS, #calleeclassesTACROSS, #calleeclassesNACROSS, "
				+ "#calleeclassesEACROSS, "
				
				+ "OwnerClassPrediction, MajorityClassLevelCallees, MajorityClassLevelCallers, MajorityMethodLevelCallees, MajorityMethodLevelCallers,"
				+ "AtLeast1NPredictionClassLevelCallees, AtLeast1NPredictionClassLevelCallers, AtLeast1NPredictionMethodLevelCallees, AtLeast1NPredictionMethodLevelCallers, "
				+"AtLeast1TPredictionClassLevelCallees, AtLeast1TPredictionClassLevelCallers, AtLeast1TPredictionMethodLevelCallees, AtLeast1TPredictionMethodLevelCallers,"
				+ "AtLeast2NPredictionClassLevelCallees, AtLeast2NPredictionClassLevelCallers, AtLeast2NPredictionMethodLevelCallees, AtLeast2NPredictionMethodLevelCallers, "
				+"AtLeast2TPredictionClassLevelCallees, AtLeast2TPredictionClassLevelCallers, AtLeast2TPredictionMethodLevelCallees, AtLeast2TPredictionMethodLevelCallers,"
				+"AllNClassLevelCallees, AllNClassLevelCallers, AllNMethodLevelCallees, AllNMethodLevelCallers,"
				+"AllTClassLevelCallees, AllTClassLevelCallers, AllTMethodLevelCallees, AllTMethodLevelCallers,"
				+"AllNClassLevelCalleesAtLeast2, AllNClassLevelCallersAtLeast2, AllNMethodLevelCalleesAtLeast2, AllNMethodLevelCallersAtLeast2,"
				+"AllTClassLevelCalleesAtLeast2, AllTClassLevelCallersAtLeast2, AllTMethodLevelCalleesAtLeast2, AllTMethodLevelCallersAtLeast2,"
				+ " OnlyInParsedCallers, OnlyInExecutedCallers, BothParsedAndExecutedCallers, "
				+ "OnlyInParsedCallees, OnlyInExecutedCallees, BothParsedAndExecutedCallees,"
				
				
				
				+ " #parametersMethodLevel, parametersMethodLevel, # Parameter TMethodLevel, # Parameter NMethodLevel, # Parameter EMethodLevel," 
				+ " #interfacesMethodLevel,  # InterfaceTMethodLevel, # InterfaceNMethodLevel, # InterfaceEMethodLevel," 
				+ " #superclassesMethodLevel,  # SuperclassTMethodLevel, # SuperclassNMethodLevel, # SuperclassEMethodLevel," 
				+ " #FieldMethodsMethodLevel,  # FieldMethodsTMethodLevel, # FieldMethodsNMethodLevel, # FieldMethodsEMethodLevel," 
				+ " #FieldClassesMethodLevel,  # FieldClassesTMethodLevel, # FieldClassesNMethodLevel, # FieldClassesEMethodLevel," 
				
				+ "MajorityParameter ,AtLeast1NParameterPrediction," + 
				"AtLeast1TParameterPrediction, AtLeast2TParameterPrediction, AtLeast2NParameterPrediction,  AllNParameterPrediction, AllTParameterPrediction, "
				+"ACHRAFTracePure, ACHRAFTraceMixed, ACHRAFNoTracePure,  ACHRAFNoTraceMixed, AllNMethodLevelCallersCallees, AllTMethodLevelCallersCallees, "
				+ "AllTClassLevelCallersCallees, AllNClassLevelCallersCallees,"
				+"ClassTraceMethodLevelPure, ClassTraceMethodLevelMixed, ClassNoTraceMethodLevelPure, ClassNoTraceMethodLevelMixed,"
				+"ClassTraceClassLevelPure, ClassTraceClassLevelMixed, ClassNoTraceClassLevelPure, ClassNoTraceClassLevelMixed,"
				+"ClassTraceMethodLevelPureACROSS, ClassTraceMethodLevelMixedACROSS, ClassNoTraceMethodLevelPureACROSS, ClassNoTraceMethodLevelMixedACROSS,"
				+"ClassTraceClassLevelPureACROSS, ClassTraceClassLevelMixedACROSS, ClassNoTraceClassLevelPureACROSS, ClassNoTraceClassLevelMixedACROSS"
				 );

		bw.write("RowNumber, MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold, Gold2, Subject, OwnerClassT, OwnerClassN, "
				+ "OwnerClassE, #callermethods, callers, #callermethodsT, #callermethodsN, #callermethodsE, #callerclasses, #callerclassesT, #callerclassesN, "
				+ "#callerclassesE, #calleemethods, callees, #calleemethodsT, #calleemethodsN, #calleemethodsE, #calleeclasses, #calleeclassesT, #calleeclassesN, "
				+ "#calleeclassesE, "
				
				+"#callermethodsACROSS, #callermethodsTACROSS, #callermethodsNACROSS, #callermethodsEACROSS, #callerclassesACROSS, #callerclassesTACROSS, #callerclassesNACROSS, "
				+ "#callerclassesEACROSS, #calleemethodsACROSS,#calleemethodsTACROSS, #calleemethodsNACROSS, #calleemethodsEACROSS, #calleeclassesACROSS, #calleeclassesTACROSS, #calleeclassesNACROSS, "
				+ "#calleeclassesEACROSS, "
				
				+ "OwnerClassPrediction, MajorityClassLevelCallees, MajorityClassLevelCallers, MajorityMethodLevelCallees, MajorityMethodLevelCallers,"
				+ "AtLeast1NPredictionClassLevelCallees, AtLeast1NPredictionClassLevelCallers, AtLeast1NPredictionMethodLevelCallees, AtLeast1NPredictionMethodLevelCallers, "
				+"AtLeast1TPredictionClassLevelCallees, AtLeast1TPredictionClassLevelCallers, AtLeast1TPredictionMethodLevelCallees, AtLeast1TPredictionMethodLevelCallers,"
				+ "AtLeast2NPredictionClassLevelCallees, AtLeast2NPredictionClassLevelCallers, AtLeast2NPredictionMethodLevelCallees, AtLeast2NPredictionMethodLevelCallers, "
				+"AtLeast2TPredictionClassLevelCallees, AtLeast2TPredictionClassLevelCallers, AtLeast2TPredictionMethodLevelCallees, AtLeast2TPredictionMethodLevelCallers,"
				+"AllNClassLevelCallees, AllNClassLevelCallers, AllNMethodLevelCallees, AllNMethodLevelCallers,"
				+"AllTClassLevelCallees, AllTClassLevelCallers, AllTMethodLevelCallees, AllTMethodLevelCallers,"
				+"AllNClassLevelCalleesAtLeast2, AllNClassLevelCallersAtLeast2, AllNMethodLevelCalleesAtLeast2, AllNMethodLevelCallersAtLeast2,"
				+"AllTClassLevelCalleesAtLeast2, AllTClassLevelCallersAtLeast2, AllTMethodLevelCalleesAtLeast2, AllTMethodLevelCallersAtLeast2,"
				
				+ " OnlyInParsedCallers, OnlyInExecutedCallers, BothParsedAndExecutedCallers, "
				+ "OnlyInParsedCallees, OnlyInExecutedCallees, BothParsedAndExecutedCallees,"
				+ " #parametersMethodLevel, parametersMethodLevel, "
				+ "# Parameter TMethodLevel, # Parameter NMethodLevel, # Parameter EMethodLevel," 
				+ "MajorityParameter ,AtLeast1NParameterPrediction," + 
				"AtLeast1TParameterPrediction, AtLeast2TParameterPrediction, AtLeast2NParameterPrediction,  AllNParameterPrediction, AllTParameterPrediction, "
				+"ACHRAFTracePure, ACHRAFTraceMixed, ACHRAFNoTracePure,  ACHRAFNoTraceMixed, AllNMethodLevelCallersCallees, AllTMethodLevelCallersCallees, "
				+ "AllTClassLevelCallersCallees, AllNClassLevelCallersCallees,"
				+"ClassTraceMethodLevelPure, ClassTraceMethodLevelMixed, ClassNoTraceMethodLevelPure, ClassNoTraceMethodLevelMixed,"
				+"ClassTraceClassLevelPure, ClassTraceClassLevelMixed, ClassNoTraceClassLevelPure, ClassNoTraceClassLevelMixed,"
				+"ClassTraceMethodLevelPureACROSS, ClassTraceMethodLevelMixedACROSS, ClassNoTraceMethodLevelPureACROSS, ClassNoTraceMethodLevelMixedACROSS,"
				+"ClassTraceClassLevelPureACROSS, ClassTraceClassLevelMixedACROSS, ClassNoTraceClassLevelPureACROSS, ClassNoTraceClassLevelMixedACROSS"
				);





		
		bw.newLine();
		bwGold2TableLog.newLine();
		DatabaseReading2 db = new DatabaseReading2();
		DatabaseReading2.MakePredictions();
		methodtraces2 = db.getMethodtracehashmap(); 
		classtraces2 = db.getClassestraces2();
	//	methodlist = db.getMethodlist();
		 methodtracesRequirementClass = db.getClassesRequirementtraceshashmap(); 
		 InterfacesHashMap = db.getInterfaces();
		  linkedmethodhashmap = db.getLinkedmethodhashmap(); 
		  InterfacesHashMapAlreadyImpl = db.getInterfacehashmapAlreadyImpl();
		  //INTERFACES 
		  InterfacesOwnerClassHashMap = db.getInterfacehashmapOwnerClass(); 
		  //FIELD METHODS 
		  FieldMethodsHashMap= db.getMethodFieldHashMap();
		  //FIELD CLASSES 
		  FieldClassesHashMap= db.getClassFieldHashMap(); 
		  //SUPERCLASSES
		  SuperclassesHashMap= db.getSuperclassesHashMap(); 
		  
		  
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
		Collection<MethodTrace> methodtracesvalues = methodtraces2.values(); 
		for ( MethodTrace methodtrace : methodtracesvalues) {
			
		
			
			
			data[j][Row] = j; 
			data[j][MethodID] = methodtrace.MethodRepresentation.getMethodid();
			data[j][MethodName] = methodtrace.MethodRepresentation.getFullmethodname(); 
			data[j][MethodName] =	data[j][MethodName].toString().replaceAll(",", "/"); 
			data[j][RequirementID] = methodtrace.Requirement.getID();
			data[j][RequirementName] = methodtrace.Requirement.getRequirementName();
			data[j][ClassID] = methodtrace.ClassRepresentation.classid;
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
			
			
			data[j][CLASSTRACEClassLevelMixedGoldACROSS] = "null";
			data[j][CLASSTRACEClassLevelPureGoldACROSS] = "null";
			data[j][CLASSNOTRACEClassLevelMixedGoldACROSS] = "null";
			data[j][CLASSNOTRACEClassLevelPureGoldACROSS] = "null";
			data[j][CLASSTRACEClassLevelMixedGold2ACROSS] = "null";
			data[j][CLASSTRACEClassLevelPureGold2ACROSS] = "null";
			data[j][CLASSNOTRACEClassLevelMixedGold2ACROSS] = "null";
			data[j][CLASSNOTRACEClassLevelPureGold2ACROSS] = "null";
			
			data[j][CLASSTRACEMethodLevelMixedGoldACROSS] = "null";
			data[j][CLASSTRACEMethodLevelPureGoldACROSS] = "null";
			data[j][CLASSNOTRACEMethodLevelMixedGoldACROSS] = "null";
			data[j][CLASSNOTRACEMethodLevelPureGoldACROSS] = "null";
			data[j][CLASSTRACEMethodLevelMixedGold2ACROSS] = "null";
			data[j][CLASSTRACEMethodLevelPureGold2ACROSS] = "null";
			data[j][CLASSNOTRACEMethodLevelMixedGold2ACROSS] = "null";
			data[j][CLASSNOTRACEMethodLevelPureGold2ACROSS] = "null";
			data[j][OwnerClassT] = "0";
			data[j][OwnerClassN] = "0";
			data[j][OwnerClassE] = "1";
			data[j][OwnerClassTGOLD2] = "0";
			data[j][OwnerClassNGOLD2] = "0";
			data[j][OwnerClassEGOLD2] = "1";
			
			String reqclass= data[j][RequirementID].toString()+"-"+ data[j][ClassID].toString(); 
			ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
			String trace = myclasstraceHashMap.gettrace().trim().trim();
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
			
			
		
			
			int InterfacesNMethodLevelGold2=0; 
			int InterfacesTMethodLevelGold2=0; 
			int InterfacesEMethodLevelGold2=0; 
			List<Interface2> InterfacesList = InterfacesOwnerClassHashMap.get(methodtrace.ClassRepresentation.classid); 
			if(InterfacesList!=null) {
				for(Interface2 myinter: InterfacesList) {
					ClassTrace2 myinfo = myclasstrace.FindTrace2(methodtracesRequirementClass, myinter.InterfaceClass.ID,	methodtrace.Requirement.getID().trim());
					if(myinfo!=null && myinfo.getTrace2()!=null) {
					if(myinter.OwnerClass.ID.equals(methodtrace.ClassRepresentation.classid) && myinfo.getTrace2().trim().trim().equals("T")) {
						InterfacesTMethodLevelGold2++; 
					}
					else if(myinter.OwnerClass.ID.equals(methodtrace.ClassRepresentation.classid) && myinfo.getTrace2().trim().trim().equals("N")) {
						InterfacesNMethodLevelGold2++; 
					}
					else if(myinter.OwnerClass.ID.equals(methodtrace.ClassRepresentation.classid) && myinfo.getTrace2().trim().trim().equals("E")) {
						InterfacesEMethodLevelGold2++; 
					}
					else if(myinter.OwnerClass.ID.equals(methodtrace.ClassRepresentation.classid) ) {
						InterfacesEMethodLevelGold2++; 
					}
				}else {
					InterfacesEMethodLevelGold2++; 
				}
				}
			}
			
			
			
			data[j][CountInterfaceTGOLD2]=InterfacesTMethodLevelGold2; 
			data[j][CountInterfaceNGOLD2]=InterfacesNMethodLevelGold2; 
			data[j][CountInterfaceEGOLD2]=InterfacesEMethodLevelGold2; 
			data[j][interfacesNumberGOLD2]=InterfacesTMethodLevelGold2+InterfacesNMethodLevelGold2+InterfacesEMethodLevelGold2; 
			
			
			int SuperclassesNMethodLevelGold2=0; 
			int SuperclassesTMethodLevelGold2=0; 
			int SuperclassesEMethodLevelGold2=0; 
			List<SuperClass2> SuperclassesList = SuperclassesHashMap.get(methodtrace.ClassRepresentation.classid); 
			if(SuperclassesList!=null) {
			for(SuperClass2 superclass: SuperclassesList) {
				ClassTrace2 myinfo = myclasstrace.FindTrace2(methodtracesRequirementClass, superclass.SuperClass.ID,	methodtrace.Requirement.getID().trim());
				if(myinfo!=null&& myinfo.getTrace2()!=null) {
				if(superclass.OwnerClass.ID.equals(methodtrace.ClassRepresentation.classid) && myinfo.getTrace2().trim().trim().equals("T")) {
					SuperclassesTMethodLevelGold2++; 
				}
				else if(superclass.OwnerClass.ID.equals(methodtrace.ClassRepresentation.classid) && myinfo.getTrace2().trim().trim().equals("N")) {
					SuperclassesNMethodLevelGold2++; 
				}
				else if(superclass.OwnerClass.ID.equals(methodtrace.ClassRepresentation.classid) && myinfo.getTrace2().trim().trim().equals("E")) {
					SuperclassesEMethodLevelGold2++; 
				}
				else if(superclass.OwnerClass.ID.equals(methodtrace.ClassRepresentation.classid)) {
					SuperclassesEMethodLevelGold2++; 
				}
			}else {
				SuperclassesEMethodLevelGold2++; 
			}
			}
			}
			data[j][CountFieldSuperClassTGOLD2]=SuperclassesTMethodLevelGold2; 
			data[j][CountFieldSuperClassNGOLD2]=SuperclassesNMethodLevelGold2; 
			data[j][CountFieldSuperClassEGOLD2]=SuperclassesEMethodLevelGold2; 
			data[j][SuperClassesNumberGOLD2]=SuperclassesTMethodLevelGold2+SuperclassesNMethodLevelGold2+SuperclassesEMethodLevelGold2; 
			
			
			int FieldMethodsNMethodLevelGold2=0; 
			int FieldMethodsTMethodLevelGold2=0; 
			int FieldMethodsEMethodLevelGold2=0; 
			List<MethodField2> FieldMethodsList = FieldMethodsHashMap.get(methodtrace.ClassRepresentation.classid); 
			if(FieldMethodsList!=null) {
				for(MethodField2 fieldmethod: FieldMethodsList) {
					ClassTrace2 myinfo = myclasstrace.FindTrace2(methodtracesRequirementClass, fieldmethod.getOwnerClass().ID,	methodtrace.Requirement.getID().trim());
					if(myinfo!=null && myinfo.getTrace2()!=null) {
					if(fieldmethod.getOwnerClass().ID.equals(methodtrace.ClassRepresentation.classid) && myinfo.getTrace2().trim().trim().equals("T")) {
						FieldMethodsTMethodLevelGold2++; 
					}
					else if(fieldmethod.getOwnerClass().ID.equals(methodtrace.ClassRepresentation.classid) && myinfo.getTrace2().trim().trim().equals("N")) {
						FieldMethodsNMethodLevelGold2++; 
					}
					else if(fieldmethod.getOwnerClass().ID.equals(methodtrace.ClassRepresentation.classid) && myinfo.getTrace2().trim().trim().equals("E")) {
						FieldMethodsEMethodLevelGold2++; 
					}
					else if(fieldmethod.getOwnerClass().ID.equals(methodtrace.ClassRepresentation.classid)) {
						FieldMethodsEMethodLevelGold2++; 
					}
				}
					
				}
			}
			
			
			
			data[j][CountFieldMethodTGOLD2]=FieldMethodsTMethodLevelGold2; 
			data[j][CountFieldMethodNGOLD2]=FieldMethodsNMethodLevelGold2; 
			data[j][CountFieldMethodEGOLD2]=FieldMethodsEMethodLevelGold2; 
			data[j][FieldMethodsNumberGOLD2]=FieldMethodsTMethodLevelGold2+FieldMethodsNMethodLevelGold2+FieldMethodsEMethodLevelGold2; 
			
			int FieldClassesNMethodLevelGold2=0; 
			int FieldClassesTMethodLevelGold2=0; 
			int FieldClassesEMethodLevelGold2=0; 
			int counterloop=0; 
			List<ClassField2> FieldClassesList = FieldClassesHashMap.get(methodtrace.ClassRepresentation.classid); 
			if(FieldClassesList!=null) {
				for(ClassField2 fieldmethod: FieldClassesList) {
					ClassTrace2 myinfo = myclasstrace.FindTrace2(methodtracesRequirementClass, fieldmethod.getOwnerClass().ID,	methodtrace.Requirement.getID().trim()); 
					if(myinfo!=null && myinfo.getTrace2()!=null) {
						if(fieldmethod.getOwnerClass().ID.equals(methodtrace.ClassRepresentation.classid) && myinfo.getTrace2().trim().trim().equals("T")) {
							FieldClassesTMethodLevelGold2++; 
						}
						else if(fieldmethod.getOwnerClass().ID.equals(methodtrace.ClassRepresentation.classid) && myinfo.getTrace2().trim().trim().equals("N")) {
							FieldClassesNMethodLevelGold2++; 
						}
						else if(fieldmethod.getOwnerClass().ID.equals(methodtrace.ClassRepresentation.classid) && myinfo.getTrace2().trim().trim().equals("E")) {
							FieldClassesEMethodLevelGold2++; 
						}
						else if(fieldmethod.getOwnerClass().ID.equals(methodtrace.ClassRepresentation.classid)) {
							FieldClassesEMethodLevelGold2++; 
						}
					}else {
						FieldClassesEMethodLevelGold2++; 
					}
					counterloop++; 
					System.out.println("counterloop "+counterloop);
				}
				
			}
		
			data[j][CountFieldClassTGOLD2]=FieldClassesTMethodLevelGold2; 
			data[j][CountFieldClassNGOLD2]=FieldClassesNMethodLevelGold2; 
			data[j][CountFieldClassEGOLD2]=FieldClassesEMethodLevelGold2; 
			data[j][FieldClassesNumberGOLD2]=FieldClassesTMethodLevelGold2+FieldClassesNMethodLevelGold2+FieldClassesEMethodLevelGold2; 
			
			
			
			
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
			Method2Details mymethodobje = linkedmethodhashmap.get(methodtrace.MethodRepresentation.methodid); 
			String ParametersAppended=""; 
			for ( Parameter2 myparam : mymethodobje.getParameters()) {
				myparameters[myparametercount] = myparam.toString(); 
				ParametersAppended=ParametersAppended+myparam.toString()+"-"; 
				myparametercount++;
				
				
				String ParameterClassid = myparam.getParameterType().ID; 
				
				ClassTrace2 mycallerclass = myclasstrace.FindTrace2(methodtracesRequirementClass, ParameterClassid,	methodtrace.Requirement.getID());
				if(mycallerclass!=null) {
					String mytrace=mycallerclass.gettrace().trim().trim(); 
					if(mytrace.trim().equals("T")) {
						counterParameterT++; 
					}else if (mytrace.trim().equals("N")) {
						counterParameterN++; 
					} else {
						counterParameterE++; 
					}
					
					String mytrace2=mycallerclass.getTrace2(); 
					if(mytrace2!=null) {
						if(mytrace2.trim().equals("T")) {
							counterParameterTGOLD2++; 
						}else if (mytrace2.trim().equals("N")) {
							counterParameterNGOLD2++; 
						}else {
							counterParameterEGOLD2++; 
						}
					}else {
						counterParameterEGOLD2++; 
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
//			
			

			List<Method> CallerMethodsListFinalNoDuplicates = new ArrayList<Method>();

			Set<String> CallerMethodsListNoDuplicates = new HashSet<String>();

			for( Method item : CallerMethodListFinal ) {
				String val= item.Owner.ID+"-"+item.methodname;
			    if( CallerMethodsListNoDuplicates.add( val )) {
			    	CallerMethodsListFinalNoDuplicates.add( item );
			    }
			}
			
			
			
			
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
			
			
			
			

			List<Method> CalleeMethodsListFinalNoDuplicates = new ArrayList<Method>();

			Set<String> CalleeMethodsListNoDuplicates = new HashSet<String>();
			for( Method item : CalleeMethodListFinal ) {
				String val= item.Owner.ID+"-"+item.methodname;
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
			HashMap <String, Method> mymapCaller= new HashMap<String, Method>(); 
			List<ClassTrace2 > mylistACROSSCallerGOLD2= new ArrayList<ClassTrace2>(); 
			HashMap<String, Method> mymapACROSSCallerGOLD2= new HashMap<String, Method>(); 
			for (Method callermeth : CallerMethodListFinal) {
				Clazz classrep = callermeth.getClassrep();
			//	ClassTrace2 mycallerclass = myclasstrace.FindTrace(classtraces2, classrep.classid,methodtrace.Requirement.getID());
				//Sometimes, mycallerclass is null and cannot be found in the traces classes table 
				ClassTrace2 mycallerclass = myclasstrace.FindTrace2(methodtracesRequirementClass, classrep.ID,	methodtrace.Requirement.getID());
				if(mycallerclass!=null) {
					mycallerclasses.add(mycallerclass);
				}else if(mycallerclass!=null){
					mymapCaller.put(mycallerclass.getMyclass().ID, callermeth); 
				}
				
				
				
				if(mycallerclass==null && callermeth!=null && callermeth.Owner.ID!=null) {
					if(callermeth.Owner.ID.equals(methodtrace.ClassRepresentation.classid)==false)
					mylistACROSSCallerGOLD2.add(mycallerclass); 
				}
				if(mycallerclass==null && callermeth!=null && callermeth.Owner.ID!=null){
					if( callermeth.Owner.ID.equals(methodtrace.ClassRepresentation.classid)==false)
					mymapACROSSCallerGOLD2.put(callermeth.Owner.ID, callermeth) ; 
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


			int CountMethodTACHRAF = 0; 
			int CountMethodNACHRAF = 0; 
			int CountMethodEACHRAF = 0; 
			for (Method mycaller: CallerMethodListFinal) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.ID); 
				 if(methdet!=null) {
					 HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
						Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
						MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
						if(methtrace!=null) {
						if (methtrace.gold.trim().equals("T")) {
							CountMethodTACHRAF++;
						} else if (methtrace.gold.trim().equals("N")) {
							CountMethodNACHRAF++;
						} else  if (methtrace.gold.trim().equals("E")){
							CountMethodEACHRAF++;
						}
				 }else {
					 CountMethodEACHRAF++;
				 }
				
			}
			}
			
			int CountMethodTACHRAFCallee = 0; 
			int CountMethodNACHRAFCallee = 0; 
			int CountMethodEACHRAFCallee = 0; 
			for (Method mycaller: CalleeMethodListFinal) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.ID); 
				 if(methdet!=null) {
					 HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
						Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
						MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
						if(methtrace!=null) {
							if (methtrace.gold.trim().equals("T")) {
								CountMethodTACHRAFCallee++;
							} else if (methtrace.gold.trim().equals("N")) {
								CountMethodNACHRAFCallee++;
							}else if (methtrace.gold.trim().equals("E")) {
								CountMethodEACHRAFCallee++;
							} 
						}
						else {
							CountMethodEACHRAFCallee++;
						}
				 }
				
			
			}
			
			
			
			

		
			int CountMethodTACHRAFGold2 = 0; 
			int CountMethodNACHRAFGold2 = 0; 
			int CountMethodEACHRAFGold2 = 0; 
			for (Method mycaller: CallerMethodListFinal) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.ID); 
				 if(methdet!=null) {
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null) {
					if(methtrace.goldfinal!=null) {
						if (methtrace.goldfinal.equals("T")) {
							CountMethodTACHRAFGold2++;
						} else if (methtrace.goldfinal.equals("N")) {
							CountMethodNACHRAFGold2++;
						}
						else if (methtrace.goldfinal.equals("E")) {
							CountMethodEACHRAFGold2++;
						}
					}else  {
						CountMethodEACHRAFGold2++;
					}
			
			}
				 }
			}
			
			
			
			int CountMethodTACHRAFCalleeGold2 = 0; 
			int CountMethodNACHRAFCalleeGold2 = 0; 
			int CountMethodEACHRAFCalleeGold2 = 0; 
			for (Method mycaller: CalleeMethodListFinal) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.ID); 
				 if(methdet!=null) {
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null && methtrace.goldfinal!=null) {
					if (methtrace.goldfinal.equals("T")) {
						CountMethodTACHRAFCalleeGold2++;
					} else if (methtrace.goldfinal.equals("N")) {
						CountMethodNACHRAFCalleeGold2++;
					} 
					else if (methtrace.goldfinal.equals("E")) {
						CountMethodEACHRAFCalleeGold2++;
					} 
				}else  {
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
			HashMap<String, Method> mymap = new HashMap<String, Method>();
			List<ClassTrace2 > mylistACROSSCalleeGOLD2= new ArrayList<ClassTrace2>(); 
			HashMap<String, Method> mymapACROSSCalleeGOLD2= new HashMap<String, Method>(); 
			for (Method calleemeth : CalleeMethodListFinal) {
				Clazz classrep = calleemeth.getClassrep();
				ClassTrace2 mycalleeclass = myclasstrace.FindTrace2(methodtracesRequirementClass, classrep.ID,	methodtrace.Requirement.getID());

				//ClassTrace2 mycalleeclass = myclasstrace.FindTrace(classtraces2, classrep.classid,methodtrace.Requirement.getID());
				if(mycalleeclass!=null) {
					mycalleeclasses.add(mycalleeclass);
				}else if(calleemeth!=null){
					mymap.put(calleemeth.Owner.ID, calleemeth) ; 
				}
				if(mycalleeclass==null && calleemeth!=null && calleemeth.Owner.ID!=null) {
					if(calleemeth.Owner.ID.equals(methodtrace.ClassRepresentation.classid)==false)
					mylistACROSSCalleeGOLD2.add(mycalleeclass); 
				}
				if(mycalleeclass==null && calleemeth!=null && calleemeth.Owner.ID!=null){
					if( calleemeth.Owner.ID.equals(methodtrace.ClassRepresentation.classid)==false)
					mymapACROSSCalleeGOLD2.put(calleemeth.Owner.ID, calleemeth) ; 
				}
				
			}
			//data[j][CalleeMethodsNumber] = mycalleeclasses.size();
			
			
			ArrayList<ClassTrace2> myclasstracesCallees = new ArrayList<ClassTrace2>();// unique
			for (ClassTrace2 classtrace : mycalleeclasses) {
				if (!myclasstracesCallees.contains(classtrace)) {

					myclasstracesCallees.add(classtrace);
				}
			}
			
			
			
			
			
			//DUPLICATE CLASSES
			int CountMethodT = 0; 
			int CountMethodN = 0; 
			int CountMethodE = 0; 
			
			int CountMethodTGOLD2 = 0; 
			int CountMethodNGOLD2 = 0; 
			int CountMethodEGOLD2 = 0; 
			for (ClassTrace2 mycallerclass : mycallerclasses) {
				if (mycallerclass.gettrace().trim().equals("T")) {
					CountMethodT++;
				} else if (mycallerclass.gettrace().trim().equals("N")) {
					CountMethodN++;
				} else  {
					CountMethodE++;
				}
				if(mycallerclass.getTrace2()!=null) {
					if (mycallerclass.getTrace2().trim().trim().equals("T")) {
						CountMethodTGOLD2++;
					} else if (mycallerclass.getTrace2().trim().trim().equals("N")) {
						CountMethodNGOLD2++;
					}else if (mycallerclass.getTrace2().trim().trim().equals("E")) {
						CountMethodEGOLD2++;
					}  
					else  {
						CountMethodEGOLD2++;
					}
				}
				
			}
			
	
			int CountMethodTACROSS = 0; 
			int CountMethodNACROSS = 0; 
			int CountMethodEACROSS = 0; 
			
			int CountMethodTGOLD2ACROSS = 0; 
			int CountMethodNGOLD2ACROSS = 0; 
			int CountMethodEGOLD2ACROSS = 0; 
			for (ClassTrace2 mycallerclass : mycallerclasses) {
				if (mycallerclass.gettrace().trim().equals("T") && mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CountMethodTACROSS++;
				} else if (mycallerclass.gettrace().trim().equals("N") && mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CountMethodNACROSS++;
				} else if (mycallerclass.gettrace().trim().equals("E") && mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CountMethodEACROSS++;
				}
				else if ( mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CountMethodEACROSS++;
				}
				if(mycallerclass.getTrace2()!=null) {
					if (mycallerclass.getTrace2().trim().trim().equals("T")&& mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CountMethodTGOLD2ACROSS++;
					} else if (mycallerclass.getTrace2().trim().trim().equals("N")&& mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CountMethodNGOLD2ACROSS++;
					} else if (mycallerclass.getTrace2().trim().trim().equals("E")&& mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CountMethodEGOLD2ACROSS++;
					}
					else if ( mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CountMethodEGOLD2ACROSS++;
					}
				}
				else  {
					CountMethodEGOLD2ACROSS++;
				}
				
			}
			
			CountMethodEGOLD2ACROSS=CountMethodEGOLD2ACROSS+mylistACROSSCallerGOLD2.size(); 

			int CountMethodTACROSSCallee = 0; 
			int CountMethodNACROSSCallee = 0; 
			int CountMethodEACROSSCallee = 0; 
			
			int CountMethodTGOLD2ACROSSCallee = 0; 
			int CountMethodNGOLD2ACROSSCallee = 0; 
			int CountMethodEGOLD2ACROSSCallee = 0; 
			
			for (ClassTrace2 mycalleeclass : mycalleeclasses) {
				if (mycalleeclass.gettrace().trim().equals("T") && mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CountMethodTACROSSCallee++;
				} else if (mycalleeclass.gettrace().trim().equals("N") && mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CountMethodNACROSSCallee++;
				} else if (mycalleeclass.gettrace().trim().equals("E") && mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CountMethodEACROSSCallee++;
				}
				else if ( mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CountMethodEACROSSCallee++;
				}
				if(mycalleeclass.getTrace2()!=null) {
					if (mycalleeclass.getTrace2().trim().trim().equals("T")&& mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CountMethodTGOLD2ACROSSCallee++;
					} else if (mycalleeclass.getTrace2().trim().trim().equals("N")&& mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CountMethodNGOLD2ACROSSCallee++;
					} else if (mycalleeclass.getTrace2().trim().trim().equals("E")&& mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CountMethodEGOLD2ACROSSCallee++;
					}
					else if ( mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CountMethodEGOLD2ACROSSCallee++;
					}
				}
				
				
			}
			
			CountMethodEGOLD2ACROSSCallee=CountMethodEGOLD2ACROSSCallee+mylistACROSSCalleeGOLD2.size(); 
			
			
			int CounterTraceClassCalleeTACROSS = 0;
			int CounterTraceClassCalleeNACROSS = 0;
			int CounterTraceClassCalleeEACROSS = 0;
			
			int CounterTraceClassCalleeTGOLD2ACROSS = 0;
			int CounterTraceClassCalleeNGOLD2ACROSS = 0;
			int CounterTraceClassCalleeEGOLD2ACROSS = 0;
			
			
			int CounterTraceClassCallerTACROSS = 0;
			int CounterTraceClassCallerNACROSS = 0;
			int CounterTraceClassCallerEACROSS = 0;
			
			int CounterTraceClassCallerTGOLD2ACROSS = 0;
			int CounterTraceClassCallerNGOLD2ACROSS = 0;
			int CounterTraceClassCallerEGOLD2ACROSS = 0;
			
			for (ClassTrace2 mycalleeclass : myclasstracesCallees) {
				if (mycalleeclass.gettrace().trim().equals("T")&& mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CounterTraceClassCalleeTACROSS++;
				} else if (mycalleeclass.gettrace().trim().equals("N")&& mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CounterTraceClassCalleeNACROSS++;
				} else if (mycalleeclass.gettrace().trim().equals("E")&& mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CounterTraceClassCalleeEACROSS++;
				}
				else if ( mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CounterTraceClassCalleeEACROSS++;
				}
				
				if(mycalleeclass.getTrace2()!=null) {
					if (mycalleeclass.getTrace2().trim().equals("T")&& mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CounterTraceClassCalleeTGOLD2ACROSS++;
					} else if (mycalleeclass.getTrace2().trim().equals("N")&& mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CounterTraceClassCalleeNGOLD2ACROSS++;
					} else if (mycalleeclass.getTrace2().trim().equals("E")&& mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CounterTraceClassCalleeEGOLD2ACROSS++;
					}
					else if ( mycalleeclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CounterTraceClassCalleeEGOLD2ACROSS++;
					}
					
				}
				
			
			}
		
			
			CounterTraceClassCalleeEGOLD2ACROSS=CounterTraceClassCalleeEGOLD2ACROSS+mymapACROSSCalleeGOLD2.size(); 
			//NO DUPLICATE CLASSES 
			for (ClassTrace2 mycallerclass : myclasstracesCallers) {
				if (mycallerclass.gettrace().trim().equals("T")&& mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CounterTraceClassCallerTACROSS++;
				} else if (mycallerclass.gettrace().trim().equals("N")&& mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CounterTraceClassCallerNACROSS++;
				} else if (mycallerclass.gettrace().trim().equals("E")&& mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CounterTraceClassCallerEACROSS++;
				}else if ( mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
					CounterTraceClassCallerEACROSS++;
				}
				if (mycallerclass.getTrace2()!=null) {
					if (mycallerclass.getTrace2().trim().equals("T")&& mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CounterTraceClassCallerTGOLD2ACROSS++;
					} else if (mycallerclass.getTrace2().trim().equals("N")&& mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CounterTraceClassCallerNGOLD2ACROSS++;
					} else if (mycallerclass.getTrace2().trim().equals("E")&& mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CounterTraceClassCallerEGOLD2ACROSS++;
					}
					else if ( mycallerclass.getMyclass().getClassid().equals(methodtrace.ClassRepresentation.classid)==false) {
						CounterTraceClassCallerEGOLD2ACROSS++;
					}
				}
				
				
			}
			CounterTraceClassCallerEGOLD2ACROSS=CounterTraceClassCallerEGOLD2ACROSS+mymapACROSSCallerGOLD2.size(); 
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			//NO DUPLICATE CLASSES 
			int  diff=mymap.size(); 
			//data[j][CalleeClassesNumber] = myclasstracesCallees.size();
			System.out.println("FUINAL COIUNTER ===============>"+ myfinalcounter);
			for (ClassTrace2 mycalleeclass : myclasstracesCallees) {
				if (mycalleeclass.gettrace().trim().equals("T")) {
					CounterTraceClassCalleeT++;
				} else if (mycalleeclass.gettrace().trim().equals("N")) {
					CounterTraceClassCalleeN++;
				} else if (mycalleeclass.gettrace().trim().equals("E")) {
					CounterTraceClassCalleeE++;
				}
				else {
					CounterTraceClassCalleeE++;
				}
				
				if(mycalleeclass.getTrace2()!=null) {
					if (mycalleeclass.getTrace2().trim().equals("T")) {
						CounterTraceClassCalleeTGOLD2++;
					} else if (mycalleeclass.getTrace2().trim().equals("N")) {
						CounterTraceClassCalleeNGOLD2++;
					} else if (mycalleeclass.getTrace2().trim().equals("E")) {
						CounterTraceClassCalleeEGOLD2++;
					}
				}else {
					CounterTraceClassCalleeEGOLD2++;
				}
			
			}
			CounterTraceClassCalleeEGOLD2	=CounterTraceClassCalleeEGOLD2+mymap.size();
			
			
			
			
			  diff =CallerMethodListFinal.size()-mycallerclasses.size(); 
			 int diff2 =mymapCaller.size(); 
			
			//NO DUPLICATE CLASSES 
			for (ClassTrace2 mycallerclass : myclasstracesCallers) {
				if (mycallerclass.gettrace().trim().equals("T")) {
					CounterTraceClassCallerT++;
				} else if (mycallerclass.gettrace().trim().equals("N")) {
					CounterTraceClassCallerN++;
				} 
				else if (mycallerclass.gettrace().trim().equals("E")) {
					CounterTraceClassCallerE++;
				}else  {
					CounterTraceClassCallerE++;
				}
				if (mycallerclass.getTrace2()!=null) {
					if (mycallerclass.getTrace2().trim().equals("T")) {
						CounterTraceClassCallerTGOLD2++;
					} else if (mycallerclass.getTrace2().trim().equals("N")) {
						CounterTraceClassCallerNGOLD2++;
					} else if (mycallerclass.getTrace2().trim().equals("E")) {
						CounterTraceClassCallerEGOLD2++;
					}
					
				}
				else  {
					CounterTraceClassCallerEGOLD2++;
				}
				
			}
			CounterTraceClassCallerEGOLD2=CounterTraceClassCallerEGOLD2+diff; 
			CounterTraceClassCallerE=CounterTraceClassCallerE+diff2; 
			


			
			//DUPLICATE CLASSES
			int CountMethodTCallee = 0; 
			int CountMethodNCallee = 0; 
			int CountMethodECallee = 0; 
			
		
			
			int CountMethodTCalleeGOLD2 = 0; 
			int CountMethodNCalleeGOLD2 = 0; 
			int CountMethodECalleeGOLD2 = 0; 
			 diff =CalleeMethodListFinal.size()-mycalleeclasses.size(); 
			for (ClassTrace2 mycalleeclass : mycalleeclasses) {
				if(mycalleeclass.gettrace().trim()!=null) {
					if (mycalleeclass.gettrace().trim().equals("T")) {
						CountMethodTCallee++;
					} else if (mycalleeclass.gettrace().trim().equals("N")) {
						CountMethodNCallee++;
					} else if (mycalleeclass.gettrace().trim().equals("E")) {
						CountMethodECallee++;
					}
				}
				else  {
					CountMethodECallee++;
				}
				
				
				if(mycalleeclass.getTrace2()!=null) {
					if (mycalleeclass.getTrace2().trim().trim().equals("T")) {
						CountMethodTCalleeGOLD2++;
					} else if (mycalleeclass.getTrace2().trim().trim().equals("N")) {
						CountMethodNCalleeGOLD2++;
					} else if (mycalleeclass.getTrace2().trim().trim().equals("E")) {
						CountMethodECalleeGOLD2++;
					}
					
				}
				else  {
					CountMethodECalleeGOLD2++;
				}
			
			}
			CountMethodECalleeGOLD2=CountMethodECalleeGOLD2+diff; 
			CountMethodECallee=CountMethodECallee+diff; 
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
		
			
			data[j][CalleeClassesT] = CounterTraceClassCalleeT;
			data[j][CalleeClassesN] = CounterTraceClassCalleeN;
			data[j][CalleeClassesE] = CounterTraceClassCalleeE;
			data[j][CalleeClassesNumber] = CounterTraceClassCalleeT+CounterTraceClassCalleeN+CounterTraceClassCalleeE;
			
			data[j][CalleeClassesTGOLD2] = CounterTraceClassCalleeTGOLD2;
			data[j][CalleeClassesNGOLD2] = CounterTraceClassCalleeNGOLD2;
			data[j][CalleeClassesEGOLD2] = CounterTraceClassCalleeEGOLD2;
			data[j][CalleeClassesNumberGOLD2] = CounterTraceClassCalleeTGOLD2+CounterTraceClassCalleeNGOLD2+CounterTraceClassCalleeEGOLD2;
			
			data[j][CallerClassesT] = CounterTraceClassCallerT;
			data[j][CallerClassesN] = CounterTraceClassCallerN;
			data[j][CallerClassesE] = CounterTraceClassCallerE;
			data[j][CallerClassesNumber] = CounterTraceClassCallerT+CounterTraceClassCallerN+CounterTraceClassCallerE;
			
			data[j][CallerClassesTGOLD2] = CounterTraceClassCallerTGOLD2;
			data[j][CallerClassesNGOLD2] = CounterTraceClassCallerNGOLD2;
			data[j][CallerClassesEGOLD2] = CounterTraceClassCallerEGOLD2;
			data[j][CallerClassesNumberGOLD2] = CounterTraceClassCallerTGOLD2+CounterTraceClassCallerNGOLD2+CounterTraceClassCallerEGOLD2;
			
			
			data[j][CalleeMethodsTACROSS] = CountMethodTACROSSCallee;
			data[j][CalleeMethodsNACROSS] = CountMethodNACROSSCallee;
			data[j][CalleeMethodsEACROSS] = CountMethodEACROSSCallee;
			data[j][CalleeMethodsNumberACROSS] = CountMethodTACROSSCallee+CountMethodNACROSSCallee+CountMethodEACROSSCallee;
			
			data[j][CallerMethodsTACROSS] = CountMethodTACROSS;
			data[j][CallerMethodsNACROSS] = CountMethodNACROSS;
			data[j][CallerMethodsEACROSS] = CountMethodEACROSS;
			data[j][CallerMethodsNumberACROSS] = CountMethodTACROSS+CountMethodNACROSS+CountMethodEACROSS;
			
			data[j][CalleeMethodsTGOLD2ACROSS] = CountMethodTGOLD2ACROSSCallee;
			data[j][CalleeMethodsNGOLD2ACROSS] = CountMethodNGOLD2ACROSSCallee;
			data[j][CalleeMethodsEGOLD2ACROSS] = CountMethodEGOLD2ACROSSCallee;
			data[j][CalleeMethodsNumberGOLD2ACROSS] = CountMethodTGOLD2ACROSSCallee+CountMethodNGOLD2ACROSSCallee+CountMethodEGOLD2ACROSSCallee;
			
			data[j][CallerMethodsTGOLD2ACROSS] = CountMethodTGOLD2ACROSS;
			data[j][CallerMethodsNGOLD2ACROSS] = CountMethodNGOLD2ACROSS;
			data[j][CallerMethodsEGOLD2ACROSS] = CountMethodEGOLD2ACROSS;
			data[j][CallerMethodsNumberGOLD2ACROSS] = CountMethodTGOLD2ACROSS+CountMethodNGOLD2ACROSS+CountMethodEGOLD2ACROSS;
			
			data[j][CallerClassesTACROSS] = CounterTraceClassCallerTACROSS;
			data[j][CallerClassesNACROSS] = CounterTraceClassCallerNACROSS;
			data[j][CallerClassesEACROSS] = CounterTraceClassCallerEACROSS;
			data[j][CallerClassesNumberACROSS] = CounterTraceClassCallerTACROSS+CounterTraceClassCallerNACROSS+CounterTraceClassCallerEACROSS;
			
			data[j][CallerClassesTGOLD2ACROSS] = CounterTraceClassCallerTGOLD2ACROSS;
			data[j][CallerClassesNGOLD2ACROSS] = CounterTraceClassCallerNGOLD2ACROSS;
			data[j][CallerClassesEGOLD2ACROSS] = CounterTraceClassCallerEGOLD2ACROSS;
			data[j][CallerClassesNumberGOLD2ACROSS] = CounterTraceClassCallerTGOLD2ACROSS+CounterTraceClassCallerNGOLD2ACROSS+CounterTraceClassCallerEGOLD2ACROSS;

			
			
			data[j][CalleeClassesTACROSS] = CounterTraceClassCalleeTACROSS;
			data[j][CalleeClassesNACROSS] = CounterTraceClassCalleeNACROSS;
			data[j][CalleeClassesEACROSS] = CounterTraceClassCalleeEACROSS;
			data[j][CalleeClassesNumberACROSS] = CounterTraceClassCalleeEACROSS+CounterTraceClassCalleeNACROSS+CounterTraceClassCalleeTACROSS;
			
			data[j][CalleeClassesTGOLD2ACROSS] = CounterTraceClassCalleeTGOLD2ACROSS;
			data[j][CalleeClassesNGOLD2ACROSS] = CounterTraceClassCalleeNGOLD2ACROSS;
			data[j][CalleeClassesEGOLD2ACROSS] = CounterTraceClassCalleeEGOLD2ACROSS;
			data[j][CalleeClassesNumberGOLD2ACROSS] = CounterTraceClassCalleeEGOLD2ACROSS+CounterTraceClassCalleeNGOLD2ACROSS+CounterTraceClassCalleeTGOLD2ACROSS;
			
			
			
			
			
			
			
			
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
					
					
					
					
					
					
					
					
					
					
					
					
					
									String key= methodtrace.getMethodRepresentation().ID+"-"+methodtrace.getRequirement().ID; 
									PredictionStandardHashMap.put(key, methodtrace.goldfinal.trim()); 
									
									
									
									PredictionCLASSTRACEMethodLevelPureGold2HashMap.put(key,"");
									PredictionCLASSTRACEMethodLevelMixedGold2HashMap.put(key,""); 
									PredictionCLASSNOTRACEMethodLevelPureGold2HashMap.put(key,""); 
									PredictionCLASSNOTRACEMethodLevelMixedGold2HashMap.put(key,""); 
									PredictionCLASSTRACEClassLevelPureGold2HashMap.put(key,"");  
									PredictionCLASSTRACEClassLevelMixedGold2HashMap.put(key,""); 
									PredictionCLASSNOTRACEClassLevelPureGold2HashMap.put(key,"");  
									PredictionCLASSNOTRACEClassLevelMixedGold2HashMap.put(key,""); 
									PredictionCLASSTRACEMethodLevelPureGold2HashMapACROSS.put(key,"");
									PredictionCLASSTRACEMethodLevelMixedGold2HashMapACROSS.put(key,""); 
									PredictionCLASSNOTRACEMethodLevelPureGold2HashMapACROSS.put(key,""); 
									PredictionCLASSNOTRACEMethodLevelMixedGold2HashMapACROSS.put(key,""); 
									PredictionCLASSTRACEClassLevelPureGold2HashMapACROSS.put(key,"");  
									PredictionCLASSTRACEClassLevelMixedGold2HashMapACROSS.put(key,""); 
									PredictionCLASSNOTRACEClassLevelPureGold2HashMapACROSS.put(key,"");  
									PredictionCLASSNOTRACEClassLevelMixedGold2HashMapACROSS.put(key,"");
									
									
									
									flagGold2=false; 
									if(OwnerClassNVarGOLD2!=null) {
										if(methodtrace.getGoldfinal()!=null){
											data[j][OwnerClassPredictionGOLD2]="N"; 
											String Result2=OwnerClassPredictionClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][OwnerClassPredictionGOLD2].toString()); 
											OwnerClassPredictionClassGold2.UpdateCounters(Result2, OwnerClassPredictionClassGold2);
											 key= methodtrace.getMethodRepresentation().ID+"-"+methodtrace.getRequirement().ID; 
											OwnerClassPredictionClassGold2HashMap.put(key, data[j][OwnerClassPredictionGOLD2].toString()); 
											flagGold2=true; 
											}
									}
									
									else {
										OwnerClassPredictionClassGold2HashMap.put(key, "null"); 

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
											//if(methodtrace.getGoldfinal()!=null) {
												if( methodtrace.getGoldfinal()!=null) {
												String Result=MajorityParametersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][MajorityParametersGOLD2].toString()); 
												MajorityParametersClassGold2.UpdateCounters(Result, MajorityParametersClassGold2);
												MajorityParametersClassGold2HashMap.put(key, data[j][MajorityParametersGOLD2].toString()); 
											}
											
										
											
										
										}else {
											MajorityParametersClassGold2HashMap.put(key, "null"); 

										}
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									//AT LEAST 1N PREDICTION PARAMETER
									
									
									
									
									
									if (counterParameterNGOLD2 >=1 )
											 {
										data[j][AtLeast1NParameterGOLD2] = "N";
										if(methodtrace.getGoldfinal()!=null) {
										String Result=AtLeast1NParameterClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1NParameterGOLD2].toString()); 
										AtLeast1NParameterClassGold2.UpdateCounters(Result, AtLeast1NParameterClassGold2);
										AtLeast1NParameterClassGold2HashMap.put(key, data[j][AtLeast1NParameterGOLD2].toString()); 
										}
										
									} else {
										AtLeast1NParameterClassGold2HashMap.put(key, "null"); 

									}
								
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									//AT LEAST 2N PREDICTION PARAMETER
									
									
									
									
									
									if (counterParameterNGOLD2 >=2 )
											 {
										data[j][AtLeast2NParameterGOLD2] = "N";
										if(methodtrace.getGoldfinal()!=null) {
											
											String Result=AtLeast2NParameterClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2NParameterGOLD2].toString()); 
										AtLeast2NParameterClassGold2.UpdateCounters(Result, AtLeast2NParameterClassGold2);
										AtLeast2NParameterClassGold2HashMap.put(key, data[j][AtLeast2NParameterGOLD2].toString()); 
										}
										
									} else {
										AtLeast2NParameterClassGold2HashMap.put(key, "null"); 

									}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//AT LEAST 1T PREDICTION PARAMETER
								
								
									
									
									
									if (counterParameterTGOLD2 >=1 )
											 {
										data[j][AtLeast1TParameterGOLD2] = "T";
										if(methodtrace.getGoldfinal()!=null) {
										String Result=AtLeast1TParameterClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1TParameterGOLD2].toString()); 
										AtLeast1TParameterClassGold2.UpdateCounters(Result, AtLeast1TParameterClassGold2);
										AtLeast1TParameterClassGold2HashMap.put(key, data[j][AtLeast1TParameterGOLD2].toString()); 
										}
									} else {
										AtLeast1TParameterClassGold2HashMap.put(key, "null"); 

									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//AT LEAST 2T PREDICTION PARAMETER
									
									
										
										
										
										if (counterParameterTGOLD2 >=2 )
												 {
											data[j][AtLeast2TParameterGOLD2] = "T";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AtLeast2TParameterClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2TParameterGOLD2].toString()); 
											AtLeast2TParameterClassGold2.UpdateCounters(Result, AtLeast2TParameterClassGold2);
											AtLeast2TParameterClassGold2HashMap.put(key, data[j][AtLeast2TParameterGOLD2].toString()); 
											}
										} else {
											AtLeast2TParameterClassGold2HashMap.put(key, "null"); 

										}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
								    /**************************************************************************************************************/	
									
									
									
									//ALL T PARAMETER PREDICTION
									
									
									if(counterParameterEGOLD2==0 && counterParameterNGOLD2==0 && counterParameterTGOLD2>=1) {
										
										
										
									
											data[j][AllTParametersGOLD2] = "T";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AllTParameterClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTParametersGOLD2].toString()); 
											AllTParameterClassGold2.UpdateCounters(Result, AllTParameterClassGold2);
											AllTParameterClassGold2HashMap.put(key, data[j][AllTParametersGOLD2].toString()); 
											}
											
											
									}else {
										AllTParameterClassGold2HashMap.put(key, "null"); 

									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N PARAMETER PREDICTION
									
									
									if(counterParameterTGOLD2==0 && counterParameterEGOLD2==0 && counterParameterNGOLD2>=1) {
										
										
										
									
											data[j][AllNParametersGOLD2] = "N";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AllNParameterClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNParametersGOLD2].toString()); 
											AllNParameterClassGold2.UpdateCounters(Result, AllNParameterClassGold2);
											AllNParameterClassGold2HashMap.put(key, data[j][AllNParametersGOLD2].toString()); 

								
											
											
											}
									}else {
										AllNParameterClassGold2HashMap.put(key, "null"); 

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
										MajorityClassLevelCalleesClassGold2HashMap.put(key, data[j][MajorityClassLevelCalleesGOLD2].toString()); 
										}
									}
									else {
										MajorityClassLevelCalleesClassGold2HashMap.put(key, "null"); 

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
										if(methodtrace.getGoldfinal()!=null) {
										String Result=MajorityClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][MajorityClassLevelCallersGOLD2].toString()); 
										MajorityClassLevelCallersClassGold2.UpdateCounters(Result, MajorityClassLevelCallersClassGold2);
										MajorityClassLevelCallersClassGold2HashMap.put(key, data[j][MajorityClassLevelCallersGOLD2].toString()); 
										}
									}else {
										MajorityClassLevelCallersClassGold2HashMap.put(key, "null"); 

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
									
										if(methodtrace.getGoldfinal()!=null) {
										String Result=MajorityMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][MajorityMethodLevelCalleesGOLD2].toString()); 
										MajorityMethodLevelCalleesClassGold2.UpdateCounters(Result, MajorityMethodLevelCalleesClassGold2);
										MajorityMethodLevelCalleesClassGold2HashMap.put(key, data[j][MajorityMethodLevelCalleesGOLD2].toString()); 

										}
									}else {
										MajorityMethodLevelCalleesClassGold2HashMap.put(key, "null"); 

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
										if(methodtrace.getGoldfinal()!=null) {
										String Result=MajorityMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][MajorityMethodLevelCallersGOLD2].toString()); 
										MajorityMethodLevelCallersClassGold2.UpdateCounters(Result, MajorityMethodLevelCallersClassGold2);
										MajorityMethodLevelCallersClassGold2HashMap.put(key, data[j][MajorityMethodLevelCallersGOLD2].toString()); 

										}
									}else {
										MajorityMethodLevelCallersClassGold2HashMap.put(key, "null"); 

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
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastNPredictionClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1NPredictionClassLevelCallersGOLD2].toString()); 
											AtLeastNPredictionClassLevelCallersClassGold2.UpdateCounters(Result, AtLeastNPredictionClassLevelCallersClassGold2);
											AtLeastNPredictionClassLevelCallersClassGold2HashMap.put(key, data[j][AtLeast1NPredictionClassLevelCallersGOLD2].toString()); 

											}
										} 
										else {
											AtLeastNPredictionClassLevelCallersClassGold2HashMap.put(key, "null"); 

										}
										
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//2AT LEAST 1T PREDICTION CLASS LEVEL CALLERS 
									
									
										
										
										
										if (CounterTraceClassCallerTGOLD2 >=1 )
												 {
											data[j][AtLeast1TPredictionClassLevelCallersGOLD2] = "T";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastTPredictionClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1TPredictionClassLevelCallersGOLD2].toString()); 
											AtLeastTPredictionClassLevelCallersClassGold2.UpdateCounters(Result, AtLeastTPredictionClassLevelCallersClassGold2);
											AtLeastTPredictionClassLevelCallersClassGold2HashMap.put(key, data[j][AtLeast1TPredictionClassLevelCallersGOLD2].toString()); 

											}
										} 
										
										else {
											AtLeastTPredictionClassLevelCallersClassGold2HashMap.put(key, "null"); 

										}
										
									
									
							
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//3AT LEAST 1N PREDICTION CLASS LEVEL CALLEES 
								
									
										
										
										
										if (CounterTraceClassCalleeNGOLD2 >=1 )
												 {
											data[j][AtLeast1NPredictionClassLevelCalleesGOLD2] = "N";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastNPredictionClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1NPredictionClassLevelCalleesGOLD2].toString()); 
											AtLeastNPredictionClassLevelCalleesClassGold2.UpdateCounters(Result, AtLeastNPredictionClassLevelCalleesClassGold2);
											AtLeastNPredictionClassLevelCalleesClassGold2HashMap.put(key, data[j][AtLeast1NPredictionClassLevelCalleesGOLD2].toString()); 

											}
										} 
										else {
											AtLeastNPredictionClassLevelCalleesClassGold2HashMap.put(key, "null"); 

										}
									
									
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
								
									//4AT LEAST 1T PREDICTION CLASS LEVEL CALLEES 
									
									
										
										
										
										if (CounterTraceClassCalleeTGOLD2 >=1 )
												 {
											data[j][AtLeast1TPredictionClassLevelCalleesGOLD2] = "T";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastTPredictionClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1TPredictionClassLevelCalleesGOLD2].toString()); 
											AtLeastTPredictionClassLevelCalleesClassGold2.UpdateCounters(Result, AtLeastTPredictionClassLevelCalleesClassGold2);
											AtLeastTPredictionClassLevelCalleesClassGold2HashMap.put(key, data[j][AtLeast1TPredictionClassLevelCalleesGOLD2].toString()); 

											}
										} 
										
										else {
											AtLeastTPredictionClassLevelCalleesClassGold2HashMap.put(key, "null"); 

										}
									
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									//5AT LEAST 1N PREDICTION METHOD LEVEL CALLERS 
									
									
										
										
										if (CountMethodNGOLD2 >=1 )
												 {
											data[j][AtLeast1NPredictionMethodLevelCallersGOLD2] = "N";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastNPredictionMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1NPredictionMethodLevelCallersGOLD2].toString()); 
											AtLeastNPredictionMethodLevelCallersClassGold2.UpdateCounters(Result, AtLeastNPredictionMethodLevelCallersClassGold2);
											AtLeastNPredictionMethodLevelCallersClassGold2HashMap.put(key, data[j][AtLeast1NPredictionMethodLevelCallersGOLD2].toString()); 

											}
										} 
										else {
											AtLeastNPredictionMethodLevelCallersClassGold2HashMap.put(key, "null"); 

										}
										
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									//6AT LEAST 1T PREDICTION METHOD LEVEL CALLERS 
								
									
										
										
										
										if (CountMethodTGOLD2 >=1 )
												 {
											data[j][AtLeast1TPredictionMethodLevelCallersGOLD2] = "T";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastTPredictionMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1TPredictionMethodLevelCallersGOLD2].toString()); 
											AtLeastTPredictionMethodLevelCallersClassGold2.UpdateCounters(Result, AtLeastTPredictionMethodLevelCallersClassGold2);
											AtLeastTPredictionMethodLevelCallersClassGold2HashMap.put(key, data[j][AtLeast1TPredictionMethodLevelCallersGOLD2].toString()); 

											}
										} 
										else {
											AtLeastTPredictionMethodLevelCallersClassGold2HashMap.put(key, "null"); 

										}
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//7AT LEAST 1N PREDICTION METHOD LEVEL CALLEES 
									
									
										
										
										
										if (CountMethodNCalleeGOLD2 >=1 )
												 {
											data[j][AtLeast1NPredictionMethodLevelCalleesGOLD2] = "N";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastNPredictionMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1NPredictionMethodLevelCalleesGOLD2].toString()); 
											AtLeastNPredictionMethodLevelCalleesClassGold2.UpdateCounters(Result, AtLeastNPredictionMethodLevelCalleesClassGold2);
											AtLeastNPredictionMethodLevelCalleesClassGold2HashMap.put(key, data[j][AtLeast1NPredictionMethodLevelCalleesGOLD2].toString()); 

											}
										} 
										else {
											AtLeastNPredictionMethodLevelCalleesClassGold2HashMap.put(key, "null"); 

										}
									
							
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//8AT LEAST 1T PREDICTION METHOD LEVEL CALLEES 
									
									
										
										
										
										if (CountMethodTCalleeGOLD2 >=1 )
												 {
											data[j][AtLeast1TPredictionMethodLevelCalleesGOLD2] = "T";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AtLeastTPredictionMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast1TPredictionMethodLevelCalleesGOLD2].toString()); 
											AtLeastTPredictionMethodLevelCalleesClassGold2.UpdateCounters(Result, AtLeastTPredictionMethodLevelCalleesClassGold2);
											AtLeastTPredictionMethodLevelCalleesClassGold2HashMap.put(key, data[j][AtLeast1TPredictionMethodLevelCalleesGOLD2].toString()); 

											}
											}
										else {
											AtLeastTPredictionMethodLevelCalleesClassGold2HashMap.put(key, "null"); 

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
												if(methodtrace.getGoldfinal()!=null) {
													String Result=AtLeast2NPredictionClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2NPredictionClassLevelCalleesGOLD2].toString()); 
													AtLeast2NPredictionClassLevelCalleesClassGold2.UpdateCounters(Result, AtLeast2NPredictionClassLevelCalleesClassGold2);
													AtLeast2NPredictionClassLevelCalleesClassGold2HashMap.put(key, data[j][AtLeast2NPredictionClassLevelCalleesGOLD2].toString()); 

												}
											} 
											else {
												AtLeast2NPredictionClassLevelCalleesClassGold2HashMap.put(key, "null"); 

											}
											
										
											
											
											
											
											
											
											
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										
										//AT LEAST 2T PREDICTION CLASS LEVEL CALLEES 
										
										
											
											
											
											if (CounterTraceClassCalleeTGOLD2 >=2 )
											 {
										data[j][AtLeast2TPredictionClassLevelCalleesGOLD2] = "T";
										if(methodtrace.getGoldfinal()!=null) {
										String Result=AtLeast2TPredictionClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2TPredictionClassLevelCalleesGOLD2].toString()); 
										AtLeast2TPredictionClassLevelCalleesClassGold2.UpdateCounters(Result, AtLeast2TPredictionClassLevelCalleesClassGold2);
										AtLeast2TPredictionClassLevelCalleesClassGold2HashMap.put(key, data[j][AtLeast2TPredictionClassLevelCalleesGOLD2].toString()); 

										}
									} 
												
											else {
												AtLeast2TPredictionClassLevelCalleesClassGold2HashMap.put(key, "null"); 

											}	
										
										
								
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										
										//AT LEAST 2N PREDICTION METHOD LEVEL CALLERS 
									
										
											
											
											
											
											if (CountMethodNGOLD2 >=2 )
													 {
												data[j][AtLeast2NPredictionMethodLevelCallersGOLD2] = "N";
												if(methodtrace.getGoldfinal()!=null) {
												String Result=AtLeast2NPredictionMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2NPredictionMethodLevelCallersGOLD2].toString()); 
												AtLeast2NPredictionMethodLevelCallersClassGold2.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCallersClassGold2);
												AtLeast2NPredictionMethodLevelCallersClassGold2HashMap.put(key, data[j][AtLeast2NPredictionMethodLevelCallersGOLD2].toString()); 

												}
											} 
											else {
												AtLeast2NPredictionMethodLevelCallersClassGold2HashMap.put(key, "null"); 

											}
											
										
											/**************************************************************************************************************/
											/**************************************************************************************************************/
											/**************************************************************************************************************/
										
											//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
											
											
												
												
												
												if (CounterTraceClassCallerTGOLD2 >=2 )
												 {
											data[j][AtLeast2TPredictionClassLevelCallersGOLD2] = "T";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AtLeast2TPredictionClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2TPredictionClassLevelCallersGOLD2].toString()); 
											AtLeast2TPredictionClassLevelCallersClassGold2.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClassGold2);
											AtLeast2TPredictionClassLevelCallersClassGold2HashMap.put(key, data[j][AtLeast2TPredictionClassLevelCallersGOLD2].toString()); 

											}
										} 
												else {
													AtLeast2TPredictionClassLevelCallersClassGold2HashMap.put(key, "null"); 

												}
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
									
										//AT LEAST 2T PREDICTION METHOD LEVEL CALLERS 
										
										
											
											
											
											if (CountMethodTGOLD2 >=2 )
											 {
										data[j][AtLeast2TPredictionMethodLevelCallersGOLD2] = "T";
										if(methodtrace.getGoldfinal()!=null) {
										String Result=AtLeast2TPredictionMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2TPredictionMethodLevelCallersGOLD2].toString()); 
										AtLeast2TPredictionMethodLevelCallersClassGold2.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClassGold2);
										AtLeast2TPredictionMethodLevelCallersClassGold2HashMap.put(key, data[j][AtLeast2TPredictionMethodLevelCallersGOLD2].toString()); 

										}
									} 
											else {
												AtLeast2TPredictionMethodLevelCallersClassGold2HashMap.put(key, "null"); 

											}
											
										
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										//AT LEAST 2N PREDICTION METHOD LEVEL CALLEES 

											
											
											
											
											
											
											
											
											
											
											
											
											
											
											
											
											
										
											
											
											if (CountMethodNCalleeGOLD2 >=2 )
											 {
										data[j][AtLeast2NPredictionMethodLevelCalleesGOLD2] = "N";
										if(methodtrace.getGoldfinal()!=null) {
										String Result=AtLeast2NPredictionMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2NPredictionMethodLevelCalleesGOLD2].toString()); 
										AtLeast2NPredictionMethodLevelCalleesClassGold2.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCalleesClassGold2);
										AtLeast2NPredictionMethodLevelCalleesClassGold2HashMap.put(key, data[j][AtLeast2NPredictionMethodLevelCalleesGOLD2].toString()); 

										}
									} 
											
											else {
												AtLeast2NPredictionMethodLevelCalleesClassGold2HashMap.put(key, "null"); 

											}	
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										//AT LEAST 2T PREDICTION METHOD LEVEL CALLEES 
									
										
											
											
											
											if (CountMethodTCalleeGOLD2 >=2 )
											 {
										data[j][AtLeast2TPredictionMethodLevelCalleesGOLD2] = "T";
										if(methodtrace.getGoldfinal()!=null) {
											String Result=AtLeast2TPredictionMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2TPredictionMethodLevelCalleesGOLD2].toString()); 
											AtLeast2TPredictionMethodLevelCalleesClassGold2.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCalleesClassGold2);
											AtLeast2TPredictionMethodLevelCalleesClassGold2HashMap.put(key, data[j][AtLeast2TPredictionMethodLevelCalleesGOLD2].toString()); 

										}
										
										
									} 
											else {
												AtLeast2TPredictionMethodLevelCalleesClassGold2HashMap.put(key, "null"); 

											}	
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										
										//AT LEAST 2N PREDICTION CLASS LEVEL CALLERS 
										
										
											
											
											
											if (CounterTraceClassCallerNGOLD2 >=2 )
											 {
										data[j][AtLeast2NPredictionClassLevelCallersGOLD2] = "N";
										if(methodtrace.getGoldfinal()!=null) {
										String Result=AtLeast2NPredictionClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2NPredictionClassLevelCallersGOLD2].toString()); 
										AtLeast2NPredictionClassLevelCallersClassGold2.UpdateCounters(Result, AtLeast2NPredictionClassLevelCallersClassGold2);
										AtLeast2NPredictionClassLevelCallersClassGold2HashMap.put(key, data[j][AtLeast2NPredictionClassLevelCallersGOLD2].toString()); 

										}
										
									} 
											else {
												AtLeast2NPredictionClassLevelCallersClassGold2HashMap.put(key, "null"); 

											}
										
								
										
											
											
											
											
											
											
											
											
											
											
											
											
											
											
											
											
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										
										//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
										
										
											
											
											
											if (CounterTraceClassCallerTGOLD2 >=2 )
											 {
										data[j][AtLeast2TPredictionClassLevelCallersGOLD2] = "T";
										if(methodtrace.getGoldfinal()!=null) {
											String Result=AtLeast2TPredictionClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AtLeast2TPredictionClassLevelCallersGOLD2].toString()); 
											AtLeast2TPredictionClassLevelCallersClassGold2.UpdateCounters(Result, AtLeast2TPredictionClassLevelCallersClassGold2);
											AtLeast2TPredictionClassLevelCallersClassGold2HashMap.put(key, data[j][AtLeast2TPredictionClassLevelCallersGOLD2].toString()); 

										}
										
										}
											
											
											
											
											else {
												AtLeast2TPredictionClassLevelCallersClassGold2HashMap.put(key, "null"); 

											}
											
											
											
											
											
											
											
											/**************************************************************************************************************/
											/**************************************************************************************************************/
											/**************************************************************************************************************/	 
									//ALL T METHOD LEVEL CALLEES 
									
									
									if(CountMethodNCalleeGOLD2==0 && CountMethodECalleeGOLD2==0 && CountMethodTCalleeGOLD2>=1) {
										
										
										
											
											data[j][AllTMethodLevelCalleesGOLD2] = "T";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AllTMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTMethodLevelCalleesGOLD2].toString()); 
											AllTMethodLevelCalleesClassGold2.UpdateCounters(Result, AllTMethodLevelCalleesClassGold2);
											AllTMethodLevelCalleesClassGold2HashMap.put(key, data[j][AllTMethodLevelCalleesGOLD2].toString()); 

											}
									}
									else {
										AllTMethodLevelCalleesClassGold2HashMap.put(key, "null"); 

									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL T METHOD LEVEL CALLERS 
									
									if(CountMethodNGOLD2==0 && CountMethodEGOLD2==0  && CountMethodTGOLD2>=1) {
										
										
										
									
											data[j][AllTMethodLevelCallersGOLD2] = "T";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AllTMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTMethodLevelCallersGOLD2].toString()); 
											AllTMethodLevelCallersClassGold2.UpdateCounters(Result, AllTMethodLevelCallersClassGold2);
											AllTMethodLevelCallersClassGold2HashMap.put(key, data[j][AllTMethodLevelCallersGOLD2].toString()); 

											}
										
									}else {
										AllTMethodLevelCallersClassGold2HashMap.put(key, "null"); 

									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL T CLASS LEVEL CALLERS 
									
									
									if(CounterTraceClassCallerEGOLD2==0 && CounterTraceClassCallerNGOLD2==0 && CounterTraceClassCallerTGOLD2>=1) {
										
										
									
											data[j][AllTClassLevelCallersGOLD2] = "T";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AllTClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTClassLevelCallersGOLD2].toString()); 
											AllTClassLevelCallersClassGold2.UpdateCounters(Result, AllTClassLevelCallersClassGold2);
											System.out.println(methodtrace.toString());
											AllTClassLevelCallersClassGold2HashMap.put(key, data[j][AllTClassLevelCallersGOLD2].toString()); 

											}
											
											
											}else {
												AllTClassLevelCallersClassGold2HashMap.put(key, "null"); 

											}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL T CLASS LEVEL CALLEES 
									
									
									if(CounterTraceClassCalleeEGOLD2==0 && CounterTraceClassCalleeNGOLD2==0 && CounterTraceClassCalleeTGOLD2>=1) {
										
										
										
									
											data[j][AllTClassLevelCalleesGOLD2] = "T";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AllTClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTClassLevelCalleesGOLD2].toString()); 
											AllTClassLevelCalleesClassGold2.UpdateCounters(Result, AllTClassLevelCalleesClassGold2);
											AllTClassLevelCalleesClassGold2HashMap.put(key, data[j][AllTClassLevelCalleesGOLD2].toString()); 

											
											}
									}else {
										AllTClassLevelCalleesClassGold2HashMap.put(key, "null"); 

									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N CLASS LEVEL CALLERS 
									
									
								
										
									if(CounterTraceClassCallerTGOLD2==0 && CounterTraceClassCallerEGOLD2==0 && CounterTraceClassCallerNGOLD2>=1) {
										
									
											data[j][AllNClassLevelCallersGOLD2] = "N";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AllNClassLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNClassLevelCallersGOLD2].toString()); 
											AllNClassLevelCallersClassGold2.UpdateCounters(Result, AllNClassLevelCallersClassGold2);
											AllNClassLevelCallersClassGold2HashMap.put(key, data[j][AllNClassLevelCallersGOLD2].toString()); 

											}
											
											
									}else {
										AllNClassLevelCallersClassGold2HashMap.put(key, "null"); 

									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N CLASS LEVEL CALLEES 
									
									
							
										
										if(CounterTraceClassCalleeTGOLD2==0 && CounterTraceClassCalleeEGOLD2==0 && CounterTraceClassCalleeNGOLD2>=1) {
										
									
											data[j][AllNClassLevelCalleesGOLD2] = "N";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AllNClassLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNClassLevelCalleesGOLD2].toString()); 
											AllNClassLevelCalleesClassGold2.UpdateCounters(Result, AllNClassLevelCalleesClassGold2);
											AllNClassLevelCalleesClassGold2HashMap.put(key, data[j][AllNClassLevelCalleesGOLD2].toString()); 

											}
										
									}else {
										AllNClassLevelCalleesClassGold2HashMap.put(key, "null"); 

									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N METHOD LEVEL CALLERS 
									
									
								
										
										if(CountMethodTGOLD2==0 && CountMethodEGOLD2==0 && CountMethodNGOLD2>=1) {	
										
									
											data[j][AllNMethodLevelCallersGOLD2] = "N";
											if(methodtrace.getGoldfinal()!=null) {
											String Result=AllNMethodLevelCallersClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNMethodLevelCallersGOLD2].toString()); 
											AllNMethodLevelCallersClassGold2.UpdateCounters(Result, AllNMethodLevelCallersClassGold2);
											AllNMethodLevelCallersClassGold2HashMap.put(key, data[j][AllNMethodLevelCallersGOLD2].toString()); 

											}
									}else {
										AllNMethodLevelCallersClassGold2HashMap.put(key, "null"); 

									}
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N METHOD LEVEL CALLEES 
									
									
								
										
										if(CountMethodTCalleeGOLD2==0 && CountMethodECalleeGOLD2==0 && CountMethodNCalleeGOLD2>=1) {
										
									
											data[j][AllNMethodLevelCalleesGOLD2] = "N";
											if(methodtrace.getGoldfinal()!=null) {
												String Result=AllNMethodLevelCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNMethodLevelCalleesGOLD2].toString()); 
												AllNMethodLevelCalleesClassGold2.UpdateCounters(Result, AllNMethodLevelCalleesClassGold2);
												AllNMethodLevelCalleesClassGold2HashMap.put(key, data[j][AllNMethodLevelCalleesGOLD2].toString()); 

											}
										
											
									}else {
										AllNMethodLevelCalleesClassGold2HashMap.put(key, "null"); 

									}
								//}
										
										
										
										
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/	 
								//ALL T METHOD LEVEL CALLEES AT LEAST 2T
								
								
								if(CountMethodNCalleeGOLD2==0 && CountMethodECalleeGOLD2==0 && CountMethodTCalleeGOLD2>=2) {
									
									
									
										
										data[j][AllTMethodLevelCalleesAtLeast2TGOLD2] = "T";
										if(methodtrace.getGoldfinal()!=null) {
										String Result=AllTMethodLevelCalleesClassAtLeast2TGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTMethodLevelCalleesAtLeast2TGOLD2].toString()); 
										AllTMethodLevelCalleesClassAtLeast2TGold2.UpdateCounters(Result, AllTMethodLevelCalleesClassAtLeast2TGold2);
										AllTMethodLevelCalleesClassAtLeast2TGold2HashMap.put(key, data[j][AllTMethodLevelCalleesAtLeast2TGOLD2].toString()); 

										}
								}
								else {
									AllTMethodLevelCalleesClassAtLeast2TGold2HashMap.put(key, "null"); 

								}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL T METHOD LEVEL CALLERS AT LEAST 2T
								
								if(CountMethodNGOLD2==0 && CountMethodEGOLD2==0  && CountMethodTGOLD2>=2) {
									
									
									
								
										data[j][AllTMethodLevelCallersAtLeast2TGOLD2] = "T";
										if(methodtrace.getGoldfinal()!=null) {
										String Result=AllTMethodLevelCallersClassAtLeast2TGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTMethodLevelCallersAtLeast2TGOLD2].toString()); 
										AllTMethodLevelCallersClassAtLeast2TGold2.UpdateCounters(Result, AllTMethodLevelCallersClassAtLeast2TGold2);
										AllTMethodLevelCallersClassAtLeast2TGold2HashMap.put(key, data[j][AllTMethodLevelCallersAtLeast2TGOLD2].toString()); 

										}
									
								}else {
									AllTMethodLevelCallersClassAtLeast2TGold2HashMap.put(key, "null"); 

								}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL T CLASS LEVEL CALLERS AT LEAST 2T
								
								
								if(CounterTraceClassCallerEGOLD2==0 && CounterTraceClassCallerNGOLD2==0 && CounterTraceClassCallerTGOLD2>=2) {
									
									
								
										data[j][AllTClassLevelCallersAtLeast2TGOLD2] = "T";
										if(methodtrace.getGoldfinal()!=null) {
										String Result=AllTClassLevelCallersClassAtLeast2TGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTClassLevelCallersAtLeast2TGOLD2].toString()); 
										AllTClassLevelCallersClassAtLeast2TGold2.UpdateCounters(Result, AllTClassLevelCallersClassAtLeast2TGold2);
										System.out.println(methodtrace.toString());
										AllTClassLevelCallersClassAtLeast2TGold2HashMap.put(key, data[j][AllTClassLevelCallersAtLeast2TGOLD2].toString()); 

										}
										
										
										}else {
											AllTClassLevelCallersClassAtLeast2TGold2HashMap.put(key, "null"); 

										}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL T CLASS LEVEL CALLEES AT LEAST 2T
								
								
								if(CounterTraceClassCalleeEGOLD2==0 && CounterTraceClassCalleeNGOLD2==0 && CounterTraceClassCalleeTGOLD2>=2) {
									
									
									
								
										data[j][AllTClassLevelCalleesAtLeast2TGOLD2] = "T";
										if(methodtrace.getGoldfinal()!=null) {
										String Result=AllTClassLevelCalleesClassAtLeast2TGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTClassLevelCalleesAtLeast2TGOLD2].toString()); 
										AllTClassLevelCalleesClassAtLeast2TGold2.UpdateCounters(Result, AllTClassLevelCalleesClassAtLeast2TGold2);
										AllTClassLevelCalleesClassAtLeast2TGold2HashMap.put(key, data[j][AllTClassLevelCalleesAtLeast2TGOLD2].toString()); 

										
										}
								}else {
									AllTClassLevelCalleesClassAtLeast2TGold2HashMap.put(key, "null"); 

								}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL N CLASS LEVEL CALLERS AT LEAST 2N
								
								
							
									
								if(CounterTraceClassCallerTGOLD2==0 && CounterTraceClassCallerEGOLD2==0 && CounterTraceClassCallerNGOLD2>=2) {
									
								
										data[j][AllNClassLevelCallersAtLeast2NGOLD2] = "N";
										if(methodtrace.getGoldfinal()!=null) {
										String Result=AllNClassLevelCallersClassAtLeast2NGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNClassLevelCallersAtLeast2NGOLD2].toString()); 
										AllNClassLevelCallersClassAtLeast2NGold2.UpdateCounters(Result, AllNClassLevelCallersClassAtLeast2NGold2);
										AllNClassLevelCallersClassAtLeast2NGold2HashMap.put(key, data[j][AllNClassLevelCallersAtLeast2NGOLD2].toString()); 

										}
										
										
								}else {
									AllNClassLevelCallersClassAtLeast2NGold2HashMap.put(key, "null"); 

								}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL N CLASS LEVEL CALLEES AT LEAST 2N
								
								
						
									
									if(CounterTraceClassCalleeTGOLD2==0 && CounterTraceClassCalleeEGOLD2==0 && CounterTraceClassCalleeNGOLD2>=2) {
									
								
										data[j][AllNClassLevelCalleesAtLeast2NGOLD2] = "N";
										if(methodtrace.getGoldfinal()!=null) {
										String Result=AllNClassLevelCalleesClassAtLeast2NGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNClassLevelCalleesAtLeast2NGOLD2].toString()); 
										AllNClassLevelCalleesClassAtLeast2NGold2.UpdateCounters(Result, AllNClassLevelCalleesClassAtLeast2NGold2);
										AllNClassLevelCalleesClassAtLeast2NGold2HashMap.put(key, data[j][AllNClassLevelCalleesAtLeast2NGOLD2].toString()); 

										}
									
								}else {
									AllNClassLevelCalleesClassAtLeast2NGold2HashMap.put(key, "null"); 

								}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL N METHOD LEVEL CALLERS AT LEAST 2N
								
								
							
									
									if(CountMethodTGOLD2==0 && CountMethodEGOLD2==0 && CountMethodNGOLD2>=2) {	
									
								
										data[j][AllNMethodLevelCallersAtLeast2NGOLD2] = "N";
										if(methodtrace.getGoldfinal()!=null) {
										String Result=AllNMethodLevelCallersClassAtLeast2NGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNMethodLevelCallersAtLeast2NGOLD2].toString()); 
										AllNMethodLevelCallersClassAtLeast2NGold2.UpdateCounters(Result, AllNMethodLevelCallersClassAtLeast2NGold2);
										AllNMethodLevelCallersClassAtLeast2NGold2HashMap.put(key, data[j][AllNMethodLevelCallersAtLeast2NGOLD2].toString()); 

										}
								}else {
									AllNMethodLevelCallersClassAtLeast2NGold2HashMap.put(key, "null"); 

								}
								
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL N METHOD LEVEL CALLEES AT LEAST 2N
								
								
							
									
									if(CountMethodTCalleeGOLD2==0 && CountMethodECalleeGOLD2==0 && CountMethodNCalleeGOLD2>=2) {
									
								
										data[j][AllNMethodLevelCalleesAtLeast2NGOLD2] = "N";
										if(methodtrace.getGoldfinal()!=null) {
											String Result=AllNMethodLevelCalleesClassAtLeast2NGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNMethodLevelCalleesAtLeast2NGOLD2].toString()); 
											AllNMethodLevelCalleesClassAtLeast2NGold2.UpdateCounters(Result, AllNMethodLevelCalleesClassAtLeast2NGold2);
											AllNMethodLevelCalleesClassAtLeast2NGold2HashMap.put(key, data[j][AllNMethodLevelCalleesAtLeast2NGOLD2].toString()); 

										}
									
										
								}
							//}
									else {
										AllNMethodLevelCalleesClassAtLeast2NGold2HashMap.put(key, "null"); 

									}	
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										
										//ALL N METHOD LEVEL CALLERS CALLEES 
										
										
									
											
											if(CountMethodTCalleeGOLD2==0 && CountMethodTGOLD2==0 && CountMethodNCalleeGOLD2>=1 && CountMethodNGOLD2>=1) {
											
										
												data[j][AllNMethodLevelCallersCalleesGOLD2] = "N";
												if(methodtrace.getGoldfinal()!=null) {
													String Result=AllNMethodLevelCallersCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNMethodLevelCallersCalleesGOLD2].toString()); 
													AllNMethodLevelCallersCalleesClassGold2.UpdateCounters(Result, AllNMethodLevelCallersCalleesClassGold2);
													AllNMethodLevelCallersCalleesClassGold2HashMap.put(key, data[j][AllNMethodLevelCallersCalleesGOLD2].toString()); 

												}
											
												
										}else {
											AllNMethodLevelCallersCalleesClassGold2HashMap.put(key, "null"); 

										}
									//}
											
											
											/**************************************************************************************************************/
											/**************************************************************************************************************/
											/**************************************************************************************************************/
											
											//ALL T METHOD LEVEL CALLERS CALLEES 
											
											
										
												
												if(CountMethodNGOLD2==0 && CountMethodNCalleeGOLD2==0 && CountMethodTCalleeGOLD2>=1 && CountMethodTGOLD2>=1) {
												
											
													data[j][AllTMethodLevelCallersCalleesGOLD2] = "T";
													if(methodtrace.getGoldfinal()!=null) {
														String Result=AllTMethodLevelCallersCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTMethodLevelCallersCalleesGOLD2].toString()); 
														AllTMethodLevelCallersCalleesClassGold2.UpdateCounters(Result, AllTMethodLevelCallersCalleesClassGold2);
														AllTMethodLevelCallersCalleesClassGold2HashMap.put(key, data[j][AllTMethodLevelCallersCalleesGOLD2].toString()); 

													}
												
													
											}else {
												AllTMethodLevelCallersCalleesClassGold2HashMap.put(key, "null"); 

											}
												
												/**************************************************************************************************************/
												/**************************************************************************************************************/
												/**************************************************************************************************************/
												
												//ALL N CLASS LEVEL CALLERS CALLEES 
												
												
											
													
													if(CounterTraceClassCalleeTGOLD2==0 && CounterTraceClassCallerTGOLD2==0 && CounterTraceClassCalleeNGOLD2>=1 && CounterTraceClassCallerNGOLD2>=1) {
													
												
														data[j][AllNClassLevelCallersCalleesGOLD2] = "N";
														if(methodtrace.getGoldfinal()!=null) {
															String Result=AllNClassLevelCallersCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllNClassLevelCallersCalleesGOLD2].toString()); 
															AllNClassLevelCallersCalleesClassGold2.UpdateCounters(Result, AllNClassLevelCallersCalleesClassGold2);
															AllNClassLevelCallersCalleesClassGold2HashMap.put(key, data[j][AllNClassLevelCallersCalleesGOLD2].toString()); 

														}
														
												}else {
													AllNClassLevelCallersCalleesClassGold2HashMap.put(key, "null"); 

												}
											
											//}
													
													
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													
													//ALL T CLASS LEVEL CALLERS CALLEES 
													
													
												
														
														if(CounterTraceClassCalleeNGOLD2==0 && CounterTraceClassCallerNGOLD2==0 && CounterTraceClassCalleeTGOLD2>=1 && CounterTraceClassCallerTGOLD2>=1) {
														
													
															data[j][AllTClassLevelCallersCalleesGOLD2] = "T";
															if(methodtrace.getGoldfinal()!=null) {
																String Result=AllTClassLevelCallersCalleesClassGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), data[j][AllTClassLevelCallersCalleesGOLD2].toString()); 
																AllTClassLevelCallersCalleesClassGold2.UpdateCounters(Result, AllTClassLevelCallersCalleesClassGold2);
																AllTClassLevelCallersCalleesClassGold2HashMap.put(key, data[j][AllTClassLevelCallersCalleesGOLD2].toString()); 

															}
														
															
													}else {
														AllTClassLevelCallersCalleesClassGold2HashMap.put(key, "null"); 

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
	
	if(true) {
	
	
	
	
	

	
	
	if(methodtrace.getGold()!=null ) {
		String Result=PredictionCLASSNOTRACEMethodLevelPureGold.ComparePredictionToGold(methodtrace.getGold().trim(), NOTracePureGoldValueMethodLevel); 
		PredictionCLASSNOTRACEMethodLevelPureGold.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelPureGold);
		
	
	

	
	
	
	
	
	
	}
		
		if(methodtrace.getGold()!=null ) {
			String Result=PredictionCLASSNOTRACEMethodLevelMixedGold.ComparePredictionToGold(methodtrace.getGold().trim(), NOTraceMixedGoldValueMethodLevel); 
			PredictionCLASSNOTRACEMethodLevelMixedGold.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelMixedGold);
			
			if(Result!=null) {
				System.out.println("MY RESULT "+Result);
				if(Result.equals("FN")) {
					for(Method call: CallerMethodListFinal) {
						bwlog2.write("callerlist "+ call.toString2());
						
						 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.Owner.ID,methodtrace.Requirement.getID()); 
						 if(trace2!=null) {
							 bwlog2.newLine();
							 bwlog2.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.Owner.ID,methodtrace.Requirement.getID()).gettrace().trim());
							
							
						 }
						 bwlog2.newLine();
					}
		
					for(Method call: CalleeMethodListFinal) {
						bwlog2.write("calleelist "+ call.toString2());
						bwlog2.newLine();
						 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.Owner.ID,methodtrace.Requirement.getID()); 

						 if(trace2!=null) {
							 bwlog2.newLine();
							 bwlog2.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.Owner.ID,methodtrace.Requirement.getID()).gettrace().trim());
							
							
						 }
						 bwlog2.newLine();
					
					}
					bwlog2.write("***********************************"); 
					bwlog2.newLine();
				}
			}
			
			
			}
	}
	
}else {
failGold++; 
}
	}	
	
/********************************************************************************************************************/				
	if(true) {
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
	
//		if(true) {
		
		if(methodtrace.getGoldfinal()!=null ) {
		data[j][CLASSTRACEMethodLevelPureGold2]=TracePureGold2ValueMethodLevel; 
		String Result=PredictionCLASSTRACEMethodLevelPureGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), TracePureGold2ValueMethodLevel); 
		PredictionCLASSTRACEMethodLevelPureGold2.UpdateCounters(Result, PredictionCLASSTRACEMethodLevelPureGold2);
		PredictionCLASSTRACEMethodLevelPureGold2HashMap.put(key, data[j][CLASSTRACEMethodLevelPureGold2].toString()); 

		}else {
			PredictionCLASSTRACEMethodLevelPureGold2HashMap.put(key, "null"); 

		}
		
		if(methodtrace.getGoldfinal()!=null ) {
			data[j][CLASSTRACEMethodLevelMixedGold2]=TraceMixedGold2ValueMethodLevel; 
			String Result=PredictionCLASSTRACEMethodLevelMixedGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), TraceMixedGold2ValueMethodLevel); 
			PredictionCLASSTRACEMethodLevelMixedGold2.UpdateCounters(Result, PredictionCLASSTRACEMethodLevelMixedGold2);
			PredictionCLASSTRACEMethodLevelMixedGold2HashMap.put(key, data[j][CLASSTRACEMethodLevelMixedGold2].toString()); 
	
		}else {
			PredictionCLASSTRACEMethodLevelMixedGold2HashMap.put(key, "null"); 

		}
//		}
		
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
	
	if(true) {
	
	
	
	

	
	
	if(methodtrace.getGoldfinal()!=null ) {
		String Result=PredictionCLASSNOTRACEMethodLevelPureGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), NOTracePureGold2ValueMethodLevel); 
		PredictionCLASSNOTRACEMethodLevelPureGold2.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelPureGold2);
		PredictionCLASSNOTRACEMethodLevelPureGold2HashMap.put(key, data[j][CLASSNOTRACEMethodLevelPureGold2].toString()); 
	
	}else {
		PredictionCLASSNOTRACEMethodLevelPureGold2HashMap.put(key, "null"); 

	}
		
		if(methodtrace.getGoldfinal()!=null ) {
			String Result=PredictionCLASSNOTRACEMethodLevelMixedGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), NOTraceMixedGold2ValueMethodLevel); 
			PredictionCLASSNOTRACEMethodLevelMixedGold2.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelMixedGold2);
			PredictionCLASSNOTRACEMethodLevelMixedGold2HashMap.put(key, data[j][CLASSNOTRACEMethodLevelMixedGold2].toString()); 
			PredictionCLASSTRACEMethodLevelPureGold2HashMap.put(key, "null"); 

		}else {
			PredictionCLASSNOTRACEMethodLevelMixedGold2HashMap.put(key, "null"); 
			PredictionCLASSTRACEMethodLevelPureGold2HashMap.put(key, "null"); 


		}
	}
	
}else {
failGold2++; 
PredictionCLASSNOTRACEMethodLevelMixedGold2HashMap.put(key, "null"); 
PredictionCLASSTRACEMethodLevelMixedGold2HashMap.put(key, "null"); 
PredictionCLASSTRACEMethodLevelPureGold2HashMap.put(key, "null"); 

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
		
		if(Result!=null) {
			
			

			System.out.println("MY RESULT "+Result);
			
				bwlog3.write("***********************************"); 
				bwlog3.newLine();
				bwlog3.write(methodtrace.toString());
				bwlog3.newLine();
				for(Method call: CallerMethodListFinal) {
					bwlog3.write("callerlist "+ call.toString2());
					
					 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.Owner.ID,methodtrace.Requirement.getID()); 
					 if(trace2!=null) {
						 bwlog3.newLine();
						 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.Owner.ID,methodtrace.Requirement.getID()).gettrace().trim());
						
						
					 }
					 bwlog3.newLine();
				}
	
				for(Method call: CalleeMethodListFinal) {
					bwlog3.write("calleelist "+ call.toString2());
					bwlog3.newLine();
					 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.Owner.ID,methodtrace.Requirement.getID()); 

					 if(trace2!=null) {
						 bwlog3.newLine();
						 bwlog3.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.Owner.ID,methodtrace.Requirement.getID()).gettrace().trim());
						
						
					 }
					 bwlog3.newLine();
				}
		
				bwlog3.write("***********************************"); 
				bwlog3.newLine();
			
		
		}
	
	
	
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

if(true) {








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
if(true) {
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
	PredictionCLASSTRACEClassLevelPureGold2HashMap.put(key, data[j][CLASSTRACEClassLevelPureGold2].toString()); 
	}else {
		PredictionCLASSTRACEClassLevelPureGold2HashMap.put(key, "null"); 

	}
	
	if(methodtrace.getGoldfinal()!=null ) {
		data[j][CLASSTRACEClassLevelMixedGold2]=TraceMixedGold2ValueClassLevel; 
		String Result=PredictionCLASSTRACEClassLevelMixedGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), TraceMixedGold2ValueClassLevel); 
		PredictionCLASSTRACEClassLevelMixedGold2.UpdateCounters(Result, PredictionCLASSTRACEClassLevelMixedGold2);
		PredictionCLASSTRACEClassLevelMixedGold2HashMap.put(key, data[j][CLASSTRACEClassLevelMixedGold2].toString()); 
	
	}else {
		PredictionCLASSTRACEClassLevelMixedGold2HashMap.put(key, "null"); 

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
	PredictionCLASSNOTRACEClassLevelPureGold2HashMap.put(key, data[j][CLASSNOTRACEClassLevelPureGold2].toString()); 
	
}else {
	PredictionCLASSNOTRACEClassLevelPureGold2HashMap.put(key, "null"); 

}
	
	if(methodtrace.getGoldfinal()!=null ) {
		String Result=PredictionCLASSNOTRACEClassLevelMixedGold2.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), NOTraceMixedGold2ValueClassLevel); 
		PredictionCLASSNOTRACEClassLevelMixedGold2.UpdateCounters(Result, PredictionCLASSNOTRACEClassLevelMixedGold2);
		PredictionCLASSNOTRACEClassLevelMixedGold2HashMap.put(key, data[j][CLASSNOTRACEClassLevelMixedGold2].toString()); 
	
	}else {
		PredictionCLASSNOTRACEClassLevelMixedGold2HashMap.put(key, "null"); 

	}
}

}else {
failGold2++; 
}
	
	
	
}
	
	
	
	





String TracePureGoldValueMethodLevelACROSS="null"; 
String TraceMixedGoldValueMethodLevelACROSS="null"; 
String TracePureGold2ValueMethodLevelACROSS="null"; 
String TraceMixedGold2ValueMethodLevelACROSS="null"; 
String NOTracePureGoldValueMethodLevelACROSS="null"; 
String NOTraceMixedGoldValueMethodLevelACROSS="null"; 
String NOTracePureGold2ValueMethodLevelACROSS="null"; 
String NOTraceMixedGold2ValueMethodLevelACROSS="null"; 
/**************************************************************************************************************/
/**************************************************************************************************************/
/**************************************************************************************************************/
//ACHRAF
if(flagGold==false) {


if(CountMethodTACROSS>0 && CountMethodTACROSSCallee>0) {

boolean entered=false; 
if(CountMethodNACROSS+CountMethodNACROSSCallee==0 && methodtrace.getGold()!=null ) {

 
TracePureGoldValueMethodLevelACROSS="T"; 
entered=true; 

} else if(methodtrace.getGold()!=null){

TraceMixedGoldValueMethodLevelACROSS="T"; 
entered=true; 
}

if(entered==true) {
if(methodtrace.getGold()!=null ) {
data[j][CLASSTRACEMethodLevelPureGoldACROSS]=TracePureGoldValueMethodLevelACROSS; 
String Result=PredictionCLASSTRACEMethodLevelPureGoldACROSS.ComparePredictionToGold(methodtrace.getGold().trim(), TracePureGoldValueMethodLevelACROSS); 
PredictionCLASSTRACEMethodLevelPureGoldACROSS.UpdateCounters(Result, PredictionCLASSTRACEMethodLevelPureGoldACROSS);
}

if(methodtrace.getGold()!=null ) {
data[j][CLASSTRACEMethodLevelMixedGoldACROSS]=TraceMixedGoldValueMethodLevelACROSS; 
String Result=PredictionCLASSTRACEMethodLevelMixedGoldACROSS.ComparePredictionToGold(methodtrace.getGold().trim(), TraceMixedGoldValueMethodLevelACROSS); 
PredictionCLASSTRACEMethodLevelMixedGoldACROSS.UpdateCounters(Result, PredictionCLASSTRACEMethodLevelMixedGoldACROSS);
}
}

}else if(CountMethodNACROSS>0 && CountMethodNACROSSCallee>0) {

boolean entered=false; 
if(CountMethodTACROSS+CountMethodTACROSSCallee==0 && methodtrace.getGold()!=null ) {


NOTracePureGoldValueMethodLevelACROSS="N"; 
data[j][CLASSNOTRACEMethodLevelPureGoldACROSS]=NOTracePureGoldValueMethodLevelACROSS; 
entered=true; 


} else if(methodtrace.getGold()!=null) {

NOTraceMixedGoldValueMethodLevelACROSS="N"; 
data[j][CLASSNOTRACEMethodLevelMixedGoldACROSS]=NOTraceMixedGoldValueMethodLevelACROSS; 
entered=true; 
}

if(entered==true) {








if(methodtrace.getGold()!=null ) {
String Result=PredictionCLASSNOTRACEMethodLevelPureGoldACROSS.ComparePredictionToGold(methodtrace.getGold().trim(), NOTracePureGoldValueMethodLevelACROSS); 
PredictionCLASSNOTRACEMethodLevelPureGoldACROSS.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelPureGoldACROSS);










}

if(methodtrace.getGold()!=null ) {
String Result=PredictionCLASSNOTRACEMethodLevelMixedGoldACROSS.ComparePredictionToGold(methodtrace.getGold().trim(), NOTraceMixedGoldValueMethodLevelACROSS); 
PredictionCLASSNOTRACEMethodLevelMixedGoldACROSS.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelMixedGoldACROSS);



}
}

}else {
failGold++; 
}
}	

/********************************************************************************************************************/				
if(true) {
if(CountMethodTGOLD2ACROSS>0 && CountMethodTGOLD2ACROSSCallee>0) {

boolean entered=false; 
if(CountMethodNGOLD2ACROSS+CountMethodNGOLD2ACROSSCallee==0 && methodtrace.getGoldfinal()!=null ) {


TracePureGold2ValueMethodLevelACROSS="T"; 
entered=true; 

} else if(methodtrace.getGoldfinal()!=null) {

TraceMixedGold2ValueMethodLevelACROSS="T"; 
entered=true; 
}

if(entered==true) {

if(methodtrace.getGoldfinal()!=null ) {
data[j][CLASSTRACEMethodLevelPureGold2ACROSS]=TracePureGold2ValueMethodLevelACROSS; 
String Result=PredictionCLASSTRACEMethodLevelPureGold2ACROSS.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), TracePureGold2ValueMethodLevelACROSS); 
PredictionCLASSTRACEMethodLevelPureGold2ACROSS.UpdateCounters(Result, PredictionCLASSTRACEMethodLevelPureGold2ACROSS);
}

if(methodtrace.getGoldfinal()!=null ) {
data[j][CLASSTRACEMethodLevelMixedGold2ACROSS]=TraceMixedGold2ValueMethodLevelACROSS; 
String Result=PredictionCLASSTRACEMethodLevelMixedGold2ACROSS.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), TraceMixedGold2ValueMethodLevelACROSS); 
PredictionCLASSTRACEMethodLevelMixedGold2ACROSS.UpdateCounters(Result, PredictionCLASSTRACEMethodLevelMixedGold2ACROSS);
}
}

}else if(CountMethodNGOLD2ACROSS>0 && CountMethodNGOLD2ACROSSCallee>0) {

boolean entered=false; 
if(CountMethodTGOLD2ACROSS+CountMethodTGOLD2ACROSSCallee==0 && methodtrace.getGoldfinal()!=null ) {


NOTracePureGold2ValueMethodLevelACROSS="N"; 
data[j][CLASSNOTRACEMethodLevelPureGold2ACROSS]=NOTracePureGold2ValueMethodLevelACROSS; 
entered=true; 
PredictionCLASSTRACEMethodLevelPureGold2HashMapACROSS.put(key, data[j][CLASSNOTRACEMethodLevelPureGold2ACROSS].toString()); 

} else if(methodtrace.getGoldfinal()!=null) {

	NOTraceMixedGold2ValueMethodLevelACROSS="N"; 
data[j][CLASSNOTRACEMethodLevelMixedGold2ACROSS]=NOTraceMixedGold2ValueMethodLevelACROSS; 
entered=true; 
PredictionCLASSNOTRACEMethodLevelMixedGold2HashMapACROSS.put(key, data[j][CLASSNOTRACEMethodLevelMixedGold2ACROSS].toString()); 

}else {
	PredictionCLASSNOTRACEMethodLevelMixedGold2HashMapACROSS.put(key, "null"); 

}

if(entered==true) {







if(methodtrace.getGoldfinal()!=null ) {
String Result=PredictionCLASSNOTRACEMethodLevelPureGold2ACROSS.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), NOTracePureGold2ValueMethodLevelACROSS); 
PredictionCLASSNOTRACEMethodLevelPureGold2ACROSS.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelPureGold2ACROSS);
PredictionCLASSNOTRACEMethodLevelPureGold2HashMapACROSS.put(key, data[j][CLASSNOTRACEMethodLevelPureGold2ACROSS].toString()); 

}else {
	PredictionCLASSNOTRACEMethodLevelPureGold2HashMapACROSS.put(key, "null"); 

}

if(methodtrace.getGoldfinal()!=null ) {
String Result=PredictionCLASSNOTRACEMethodLevelMixedGold2ACROSS.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), NOTraceMixedGold2ValueMethodLevelACROSS); 
PredictionCLASSNOTRACEMethodLevelMixedGold2ACROSS.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelMixedGold2ACROSS);
PredictionCLASSNOTRACEMethodLevelMixedGold2HashMapACROSS.put(key, data[j][CLASSNOTRACEMethodLevelMixedGold2ACROSS].toString()); 

}else {
	PredictionCLASSNOTRACEMethodLevelMixedGold2HashMapACROSS.put(key, "null"); 

}
}

}else {
failGold2++; 
}

}







String TracePureGoldValueClassLevelACROSS="null"; 
String TraceMixedGoldValueClassLevelACROSS="null"; 
String TracePureGold2ValueClassLevelACROSS="null"; 
String TraceMixedGold2ValueClassLevelACROSS="null"; 
String NOTracePureGoldValueClassLevelACROSS="null"; 
String NOTraceMixedGoldValueClassLevelACROSS="null"; 
String NOTracePureGold2ValueClassLevelACROSS="null"; 
String NOTraceMixedGold2ValueClassLevelACROSS="null"; 
/**************************************************************************************************************/
/**************************************************************************************************************/
/**************************************************************************************************************/
//ACHRAF
if(flagGold==false) {
if(CounterTraceClassCallerTACROSS>0 && CounterTraceClassCalleeTACROSS>0) {

boolean entered=false; 
if(CounterTraceClassCallerNACROSS+CounterTraceClassCalleeNACROSS==0 && methodtrace.getGold()!=null ) {


TracePureGoldValueClassLevelACROSS="T"; 
entered=true; 

} else if(methodtrace.getGold()!=null){

TraceMixedGoldValueClassLevelACROSS="T"; 
entered=true; 
}

if(true) {
if(methodtrace.getGold()!=null ) {
data[j][CLASSTRACEClassLevelPureGoldACROSS]=TracePureGoldValueClassLevelACROSS; 
String Result=PredictionCLASSTRACEClassLevelPureGoldACROSS.ComparePredictionToGold(methodtrace.getGold().trim(), TracePureGoldValueClassLevelACROSS); 
PredictionCLASSTRACEClassLevelPureGoldACROSS.UpdateCounters(Result, PredictionCLASSTRACEClassLevelPureGoldACROSS);
}

if(methodtrace.getGold()!=null ) {
data[j][CLASSTRACEClassLevelMixedGoldACROSS]=TraceMixedGoldValueClassLevelACROSS; 
String Result=PredictionCLASSTRACEClassLevelMixedGoldACROSS.ComparePredictionToGold(methodtrace.getGold().trim(), TraceMixedGoldValueClassLevelACROSS); 
PredictionCLASSTRACEClassLevelMixedGoldACROSS.UpdateCounters(Result, PredictionCLASSTRACEClassLevelMixedGoldACROSS);
}
}

}else if(CounterTraceClassCallerNACROSS>0 && CounterTraceClassCalleeNACROSS>0) {

boolean entered=false; 
if(CounterTraceClassCallerTACROSS+CounterTraceClassCalleeTACROSS==0 && methodtrace.getGold()!=null ) {


NOTracePureGoldValueClassLevelACROSS="N"; 
data[j][CLASSNOTRACEClassLevelPureGoldACROSS]=NOTracePureGoldValueClassLevelACROSS; 
entered=true; 


} else if(methodtrace.getGold()!=null) {

NOTraceMixedGoldValueClassLevelACROSS="N"; 
data[j][CLASSNOTRACEClassLevelMixedGoldACROSS]=NOTraceMixedGoldValueClassLevelACROSS; 
entered=true; 
}

if(entered==true) {








if(methodtrace.getGold()!=null ) {
String Result=PredictionCLASSNOTRACEClassLevelPureGoldACROSS.ComparePredictionToGold(methodtrace.getGold().trim(), NOTracePureGoldValueClassLevelACROSS); 
PredictionCLASSNOTRACEClassLevelPureGoldACROSS.UpdateCounters(Result, PredictionCLASSNOTRACEClassLevelPureGoldACROSS);
}

if(methodtrace.getGold()!=null ) {
String Result=PredictionCLASSNOTRACEClassLevelMixedGoldACROSS.ComparePredictionToGold(methodtrace.getGold().trim(), NOTraceMixedGoldValueClassLevelACROSS); 
PredictionCLASSNOTRACEClassLevelMixedGoldACROSS.UpdateCounters(Result, PredictionCLASSNOTRACEClassLevelMixedGoldACROSS);
}
}

}else {
failGold++; 
}

}
/********************************************************************************************************************/				
if(true) {
if(CounterTraceClassCallerTGOLD2ACROSS>0 && CounterTraceClassCalleeTGOLD2ACROSS>0) {

boolean entered=false; 
if(CounterTraceClassCallerNGOLD2ACROSS+CounterTraceClassCalleeNGOLD2ACROSS==0 && methodtrace.getGoldfinal()!=null ) {


TracePureGold2ValueClassLevelACROSS="T"; 
entered=true; 

} else if(methodtrace.getGoldfinal()!=null) {

TraceMixedGold2ValueClassLevelACROSS="T"; 
entered=true; 
}

if(entered==true) {

if(methodtrace.getGoldfinal()!=null ) {
data[j][CLASSTRACEClassLevelPureGold2ACROSS]=TracePureGold2ValueClassLevelACROSS; 
String Result=PredictionCLASSTRACEClassLevelPureGold2ACROSS.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), TracePureGold2ValueClassLevelACROSS); 
PredictionCLASSTRACEClassLevelPureGold2ACROSS.UpdateCounters(Result, PredictionCLASSTRACEClassLevelPureGold2ACROSS);
PredictionCLASSTRACEClassLevelPureGold2HashMapACROSS.put(key, data[j][CLASSTRACEClassLevelPureGold2ACROSS].toString()); 

}else {
	PredictionCLASSTRACEClassLevelPureGold2HashMapACROSS.put(key, "null"); 

}

if(methodtrace.getGoldfinal()!=null ) {
data[j][CLASSTRACEClassLevelMixedGold2ACROSS]=TraceMixedGold2ValueClassLevelACROSS; 
String Result=PredictionCLASSTRACEClassLevelMixedGold2ACROSS.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), TraceMixedGold2ValueClassLevelACROSS); 
PredictionCLASSTRACEClassLevelMixedGold2ACROSS.UpdateCounters(Result, PredictionCLASSTRACEClassLevelMixedGold2ACROSS);
PredictionCLASSTRACEClassLevelMixedGold2HashMapACROSS.put(key, data[j][CLASSTRACEClassLevelMixedGold2ACROSS].toString()); 

}else {
	PredictionCLASSTRACEClassLevelMixedGold2HashMapACROSS.put(key, "null"); 

}
}

}else if(CounterTraceClassCallerNGOLD2ACROSS>0 && CounterTraceClassCalleeNGOLD2ACROSS>0) {

boolean entered=false; 
if(CounterTraceClassCallerTGOLD2ACROSS+CounterTraceClassCalleeTGOLD2ACROSS==0 && methodtrace.getGoldfinal()!=null ) {


NOTracePureGold2ValueClassLevelACROSS="N"; 
data[j][CLASSNOTRACEClassLevelPureGold2ACROSS]=NOTracePureGold2ValueClassLevelACROSS; 
entered=true; 


} else if(methodtrace.getGoldfinal()!=null) {

NOTraceMixedGold2ValueClassLevelACROSS="N"; 
data[j][CLASSNOTRACEClassLevelMixedGold2ACROSS]=NOTraceMixedGold2ValueClassLevelACROSS; 
entered=true; 
}

if(entered==true) {







if(methodtrace.getGoldfinal()!=null ) {
String Result=PredictionCLASSNOTRACEClassLevelPureGold2ACROSS.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), NOTracePureGold2ValueClassLevelACROSS); 
PredictionCLASSNOTRACEClassLevelPureGold2ACROSS.UpdateCounters(Result, PredictionCLASSNOTRACEClassLevelPureGold2ACROSS);
PredictionCLASSNOTRACEClassLevelPureGold2HashMapACROSS.put(key, data[j][CLASSNOTRACEClassLevelPureGold2ACROSS].toString()); 

}else {
	PredictionCLASSNOTRACEClassLevelPureGold2HashMapACROSS.put(key, "null"); 

}

if(methodtrace.getGoldfinal()!=null ) {
String Result=PredictionCLASSNOTRACEClassLevelMixedGold2ACROSS.ComparePredictionToGold(methodtrace.getGoldfinal().trim(), NOTraceMixedGold2ValueClassLevelACROSS); 
PredictionCLASSNOTRACEClassLevelMixedGold2ACROSS.UpdateCounters(Result, PredictionCLASSNOTRACEClassLevelMixedGold2ACROSS);
PredictionCLASSNOTRACEClassLevelMixedGold2HashMapACROSS.put(key, data[j][CLASSNOTRACEClassLevelMixedGold2ACROSS].toString()); 

}else {
	PredictionCLASSNOTRACEClassLevelMixedGold2HashMapACROSS.put(key, "null"); 

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
					+ data[j][OwnerClassEGOLD2] + "," 
					
					
					+ data[j][CallerMethodsNumberGOLD2]+ "," + AppendedCallers + "," + data[j][CallerMethodsTGOLD2] + "," +
					data[j][CallerMethodsNGOLD2] + "," + data[j][CallerMethodsEGOLD2] + ","
					+ data[j][CallerClassesNumberGOLD2] + "," + data[j][CallerClassesTGOLD2] + "," + data[j][CallerClassesNGOLD2] + "," + data[j][CallerClassesEGOLD2] + 
					"," + data[j][CalleeMethodsNumberGOLD2]+ "," + AppendedCallees +  ","
					+ data[j][CalleeMethodsTGOLD2] + "," + data[j][CalleeMethodsNGOLD2] + "," + data[j][CalleeMethodsEGOLD2] + "," + data[j][CalleeClassesNumberGOLD2] + 
					"," + data[j][CalleeClassesTGOLD2] + ","
					+ data[j][CalleeClassesNGOLD2] + "," + data[j][CalleeClassesEGOLD2] + ","
							
							
							
							+ data[j][CallerMethodsNumberGOLD2ACROSS]+  "," + data[j][CallerMethodsTGOLD2ACROSS] + "," +
							data[j][CallerMethodsNGOLD2ACROSS] + "," + data[j][CallerMethodsEGOLD2ACROSS] + ","
							+ data[j][CallerClassesNumberGOLD2ACROSS] + "," + data[j][CallerClassesTGOLD2ACROSS] + "," + data[j][CallerClassesNGOLD2ACROSS] + "," + data[j][CallerClassesEGOLD2ACROSS] + 
							"," + data[j][CalleeMethodsNumberGOLD2ACROSS]+ "," 
							+ data[j][CalleeMethodsTGOLD2ACROSS] + "," + data[j][CalleeMethodsNGOLD2ACROSS] + "," + data[j][CalleeMethodsEGOLD2ACROSS] + "," + data[j][CalleeClassesNumberGOLD2ACROSS] + 
							"," + data[j][CalleeClassesTGOLD2ACROSS] + ","
							+ data[j][CalleeClassesNGOLD2ACROSS] + "," + data[j][CalleeClassesEGOLD2ACROSS] 
							
							
							
							
							+ "," + data[j][OwnerClassPredictionGOLD2] + "," + data[j][MajorityClassLevelCallersGOLD2]+ "," +
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
								data[j][AllTClassLevelCallersAtLeast2TGOLD2]+ ","+		data[j][AllTClassLevelCalleesAtLeast2TGOLD2]+ ","+		data[j][AllTMethodLevelCallersAtLeast2TGOLD2]+ 
								","+
											
											OnlyinParsedCallers	+","+ OnlyinExecutedCallers+","+BothParsedAndExecutedCallers+","+OnlyInParsedCallees+","+OnlyInExecutedCallees
											+","+BothInParsedAndExecutedCallees+","
											+data[j][paramatersNumberGOLD2]+","+ParametersAppended+","+data [j][CountParamaterTGOLD2]+","+data [j][CountParamaterNGOLD2]+","+data [j][CountParamaterEGOLD2]+","
													
													
						
													
													
													
													
						+data[j][interfacesNumberGOLD2]+","+data [j][CountInterfaceTGOLD2]+","+data [j][CountInterfaceNGOLD2]+","+data [j][CountInterfaceEGOLD2]	+","	
						+data[j][SuperClassesNumberGOLD2]+","+data [j][CountFieldSuperClassTGOLD2]+","+data [j][CountFieldSuperClassNGOLD2]+","+data [j][CountFieldSuperClassEGOLD2]	+","	
						+data[j][FieldMethodsNumberGOLD2]+","+data [j][CountFieldMethodTGOLD2]+","+data [j][CountFieldMethodNGOLD2]+","+data [j][CountFieldMethodEGOLD2]+","
						+data[j][FieldClassesNumberGOLD2]+","+data [j][CountFieldClassTGOLD2]+","+data [j][CountFieldClassNGOLD2]+","+data [j][CountFieldClassEGOLD2]+","
													
													
													+data[j][MajorityParametersGOLD2]+","+data[j][AtLeast1NParameterGOLD2]+","+
													
													
													data[j][AtLeast1TParameter]+","+data[j][AtLeast2TParameter]+","+data[j][AtLeast2NParameter]+","+data[j][AllNParameters]+","+data[j][AllTParameters]+","+
													data[j][ACHRAFTRACEPureGOLD2]+","+data[j][ACHRAFTRACEMixedGOLD2]+","+data[j][ACHRAFNOTRACEPureGOLD2]+","+data[j][ACHRAFNOTRACEMixedGOLD2]+","+	
													data[j][AllNMethodLevelCallersCalleesGOLD2]+","+data[j][AllTMethodLevelCallersCalleesGOLD2]+","+data[j][AllTClassLevelCallersCalleesGOLD2]+","+data[j][AllNClassLevelCallersCalleesGOLD2]+","+	
													data[j][CLASSTRACEMethodLevelPureGold2]+","+data[j][CLASSTRACEMethodLevelMixedGold2]+","+data[j][CLASSNOTRACEMethodLevelPureGold2]+","+data[j][CLASSNOTRACEMethodLevelMixedGold2]+","+	
													data[j][CLASSTRACEClassLevelPureGold2]+","+data[j][CLASSTRACEClassLevelMixedGold2]+","+data[j][CLASSNOTRACEClassLevelPureGold2]+","+data[j][CLASSNOTRACEClassLevelMixedGold2]+","+
														
													
data[j][CLASSTRACEMethodLevelPureGold2ACROSS]+","+data[j][CLASSTRACEMethodLevelMixedGold2ACROSS]+","+data[j][CLASSNOTRACEMethodLevelPureGold2ACROSS]+","+data[j][CLASSNOTRACEMethodLevelMixedGold2ACROSS]+","+	
data[j][CLASSTRACEClassLevelPureGold2ACROSS]+","+data[j][CLASSTRACEClassLevelMixedGold2ACROSS]+","+data[j][CLASSNOTRACEClassLevelPureGold2ACROSS]+","+data[j][CLASSNOTRACEClassLevelMixedGold2ACROSS]
					);
			bwGold2TableLog.newLine();

			
			
			
			bw.write(data[j][Row] + "," +data[j][MethodID] + "," + data[j][MethodName] + "," + data[j][RequirementID] + "," + data[j][RequirementName] + "," + data[j][ClassID] + ","
					+ data[j][ClassName] + "," + data[j][Gold] +","+	
							methodtrace.goldfinal+ "," + data[j][Subject] + "," + data[j][OwnerClassT] + "," + data[j][OwnerClassN] + ","
					+ data[j][OwnerClassE] 
							
							+ "," + 
							
							
					
					
					data[j][CallerMethodsNumber]+ "," + AppendedCallers + "," + data[j][CallerMethodsT] + "," +
					data[j][CallerMethodsN] + "," + data[j][CallerMethodsE] + ","
					+ data[j][CallerClassesNumber] + "," + data[j][CallerClassesT] + "," + data[j][CallerClassesN] + "," + data[j][CallerClassesE] + 
					"," + data[j][CalleeMethodsNumber]+ "," + AppendedCallees +  ","
					+ data[j][CalleeMethodsT] + "," + data[j][CalleeMethodsN] + "," + data[j][CalleeMethodsE] + "," + data[j][CalleeClassesNumber] + 
					"," + data[j][CalleeClassesT] + ","
					+ data[j][CalleeClassesN] + "," + data[j][CalleeClassesE] 
							
							
							

							
					+ "," + data[j][CallerMethodsNumberACROSS] + "," + data[j][CallerMethodsTACROSS] + "," +
					data[j][CallerMethodsNACROSS] + "," + data[j][CallerMethodsEACROSS] + ","
					+ data[j][CallerClassesNumberACROSS] + "," + data[j][CallerClassesTACROSS] + "," + data[j][CallerClassesNACROSS] + "," + data[j][CallerClassesEACROSS] + 
					"," + data[j][CalleeMethodsNumberACROSS]+ "," 
					+ data[j][CalleeMethodsTACROSS] + "," + data[j][CalleeMethodsNACROSS] + "," + data[j][CalleeMethodsEACROSS] + "," + data[j][CalleeClassesNumberACROSS] + 
					"," + data[j][CalleeClassesTACROSS] + ","
					+ data[j][CalleeClassesNACROSS] + "," + data[j][CalleeClassesEACROSS] 	+ "," +	
							
							
							 data[j][OwnerClassPrediction] + "," + data[j][MajorityClassLevelCallers]+ "," +
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
		data[j][AllTClassLevelCallersAtLeast2TGOLD]+ ","+		data[j][AllTClassLevelCalleesAtLeast2TGOLD]+ ","+		data[j][AllTMethodLevelCallersAtLeast2TGOLD]+ 
		","+
					
					OnlyinParsedCallers	+","+ OnlyinExecutedCallers+","+BothParsedAndExecutedCallers+","+OnlyInParsedCallees+","+OnlyInExecutedCallees
					+","+BothInParsedAndExecutedCallees+","+data[j][paramatersNumber]+","+ParametersAppended+","+data [j][CountParamaterT]+","+data [j][CountParamaterN]+","+data [j][CountParamaterE]+","+data[j][MajorityParameters]+","+data[j][AtLeast1NParameter]
							+","+data[j][AtLeast1TParameter]+","+data[j][AtLeast2TParameter]+","+data[j][AtLeast2NParameter]+","+data[j][AllNParameters]+","+data[j][AllTParameters]+","+
							data[j][ACHRAFTRACEPureGold]+","+data[j][ACHRAFTRACEMixedGold]+","+data[j][ACHRAFNOTRACEPureGold]+","+data[j][ACHRAFNOTRACEMixedGold]+","+	
							data[j][AllNMethodLevelCallersCallees]+","+data[j][AllTMethodLevelCallersCallees]+","+data[j][AllTClassLevelCallersCallees]+","+data[j][AllNClassLevelCallersCallees]+","+	
							data[j][CLASSTRACEMethodLevelPureGold]+","+data[j][CLASSTRACEMethodLevelMixedGold]+","+data[j][CLASSNOTRACEMethodLevelPureGold]+","+data[j][CLASSNOTRACEMethodLevelMixedGold]+","+	
							data[j][CLASSTRACEClassLevelPureGold]+","+data[j][CLASSTRACEClassLevelMixedGold]+","+data[j][CLASSNOTRACEClassLevelPureGold]+","+data[j][CLASSNOTRACEClassLevelMixedGold]+","+
									data[j][CLASSTRACEMethodLevelPureGoldACROSS]+","+data[j][CLASSTRACEMethodLevelMixedGoldACROSS]+","+data[j][CLASSNOTRACEMethodLevelPureGoldACROSS]+","+data[j][CLASSNOTRACEMethodLevelMixedGoldACROSS]+","+	
									data[j][CLASSTRACEClassLevelPureGoldACROSS]+","+data[j][CLASSTRACEClassLevelMixedGoldACROSS]+","+data[j][CLASSNOTRACEClassLevelPureGoldACROSS]+","+data[j][CLASSNOTRACEClassLevelMixedGoldACROSS]
					
					);
				
			bw.newLine();

			j++;
			
		}

		
		
		
		//GENETIC ALGORITHM STARTING HERE 
		int OwnerValFitness=0;
		int MajorityClassLevelCallersClassGold2ValFitness=0;
		int MajorityClassLevelCalleesClassGold2ValFitness=0;
		int MajorityMethodLevelCallersClassGold2ValFitness=0;
		int MajorityMethodLevelCalleesClassGold2ValFitness=0;
		int AtLeastNPredictionClassLevelCallersClassGold2ValFitness=0;
		int AtLeastNPredictionClassLevelCalleesClassGold2ValFitness=0;
		int AtLeastNPredictionMethodLevelCallersClassGold2ValFitness= 0;
		int AtLeastNPredictionMethodLevelCalleesClassGold2ValFitness=0;
		int AtLeastTPredictionClassLevelCallersClassGold2ValFitness=0;
		int AtLeastTPredictionClassLevelCalleesClassGold2ValFitness=0;
		int AtLeastTPredictionMethodLevelCallersClassGold2ValFitness=0; 
		int AtLeastTPredictionMethodLevelCalleesClassGold2ValFitness=0; 
		int AtLeast2NPredictionClassLevelCallersClassGold2ValFitness=0; 
		int AtLeast2NPredictionClassLevelCalleesClassGold2ValFitness=0; 
		int AtLeast2NPredictionMethodLevelCallersClassGold2ValFitness=0; 
		int AtLeast2NPredictionMethodLevelCalleesClassGold2ValFitness=0;
		int AtLeast2TPredictionClassLevelCallersClassGold2ValFitness=0;
		int AtLeast2TPredictionClassLevelCalleesClassGold2ValFitness=0;
		int AtLeast2TPredictionMethodLevelCallersClassGold2ValFitness=0;
		int AtLeast2TPredictionMethodLevelCalleesClassGold2ValFitness=0;
		int  AllNClassLevelCallersClassGold2ValFitness=0; 
		int AllNClassLevelCalleesClassGold2ValFitness=0; 
		int AllNMethodLevelCalleesClassGold2ValFitness=0; 
		int AllTMethodLevelCalleesClassGold2ValFitness=0; 
		int AllTClassLevelCallersClassGold2ValFitness=0; 
		int AllTClassLevelCalleesClassGold2ValFitness=0; 
		int AllTMethodLevelCallersClassGold2ValFitness=0; 
		int MajorityParametersClassGold2ValFitness=0; 
		int AtLeast1NParameterClassGold2ValFitness=0; 
		int AtLeast2NParameterClassGold2ValFitness=0; 
		int AtLeast1TParameterClassGold2ValFitness=0; 
		int AtLeast2TParameterClassGold2ValFitness=0; 
		int AllNParameterClassGold2ValFitness=0; 
		int AllTParameterClassGold2ValFitness=0; 
		int AllNMethodLevelCallersCalleesClassGold2ValFitness=0; 
		int AllTMethodLevelCallersCalleesClassGold2ValFitness=0; 
		int AllNClassLevelCallersCalleesClassGold2ValFitness=0; 
		int AllTClassLevelCallersCalleesClassGold2ValFitness=0; 
		int PureNCallersGold2ValFitness=0; 
		int PureTCallersGold2ValFitness=0; 
		int AllNClassLevelCalleesClassAtLeast2NGold2ValFitness=0; 
		int AllNClassLevelCallersClassAtLeast2NGold2ValFitness=0; 
		int AllNMethodLevelCalleesClassAtLeast2NGold2ValFitness=0; 
		int AllNMethodLevelCallersClassAtLeast2NGold2ValFitness=0; 
		int AllTClassLevelCalleesClassAtLeast2TGold2ValFitness=0; 
		int AllTClassLevelCallersClassAtLeast2TGold2ValFitness=0; 
		int AllTMethodLevelCalleesClassAtLeast2TGold2ValFitness=0; 
		int AllTMethodLevelCallersClassAtLeast2TGold2ValFitness=0; 
		int PredictionCLASSTRACEMethodLevelPureGold2ValFitness=0; 
		int PredictionCLASSTRACEMethodLevelMixedGold2ValFitness=0; 
		int PredictionCLASSNOTRACEMethodLevelPureGold2ValFitness=0; 
		int PredictionCLASSNOTRACEMethodLevelMixedGold2ValFitness=0; 
		int PredictionCLASSTRACEClassLevelPureGold2ValFitness=0; 
		int PredictionCLASSTRACEClassLevelMixedGold2ValFitness=0; 
		int PredictionCLASSNOTRACEClassLevelPureGold2ValFitness=0; 
		int PredictionCLASSNOTRACEClassLevelMixedGold2ValFitness=0; 
		int PredictionCLASSTRACEMethodLevelPureGold2ACROSSValFitness=0; 
		int PredictionCLASSTRACEMethodLevelMixedGold2ACROSSValFitness=0; 
		int PredictionCLASSNOTRACEMethodLevelPureGold2ACROSSValFitness=0; 
		int PredictionCLASSNOTRACEMethodLevelMixedGold2ACROSSValFitness=0; 
		int PredictionCLASSTRACEClassLevelPureGold2ACROSSValFitness=0; 
		int PredictionCLASSTRACEClassLevelMixedGold2ACROSSValFitness=0; 
		int PredictionCLASSNOTRACEClassLevelPureGold2ACROSSValFitness=0; 
		int PredictionCLASSNOTRACEClassLevelMixedGold2ACROSSValFitness=0; 
		//LinkedHashMap<HashMapValue, LinkedHashMap<String, String>> FitnessList = new LinkedHashMap<HashMapValue, LinkedHashMap<String, String>>(); 
		LinkedHashMap<Integer, LinkedHashMap<String, String>> NameHashMap = new LinkedHashMap<Integer, LinkedHashMap<String, String>>(); 
		LinkedHashMap<Integer, Integer> FitnessHashMap = new LinkedHashMap<Integer, Integer>(); 
//ASSIGN HASHMAPS AND FITNESS VALUES TO NAMEHASHMAP AND FITNESSHASHMAP 
		
		LinkedHashMap<Integer, Integer> SortedFitnesses = new LinkedHashMap<Integer, Integer>(); 
		for(String key: PredictionStandardHashMap.keySet()) {
			
			String OwnerVal = OwnerClassPredictionClassGold2HashMap.get(key);
			String MajorityClassLevelCallersClassGold2Val=MajorityClassLevelCallersClassGold2HashMap.get(key);
			String MajorityClassLevelCalleesClassGold2Val=MajorityClassLevelCalleesClassGold2HashMap.get(key);
			String MajorityMethodLevelCallersClassGold2Val=MajorityMethodLevelCallersClassGold2HashMap.get(key);
			String MajorityMethodLevelCalleesClassGold2Val=MajorityMethodLevelCalleesClassGold2HashMap.get(key);
			String AtLeastNPredictionClassLevelCallersClassGold2Val=AtLeastNPredictionClassLevelCallersClassGold2HashMap.get(key);
			String AtLeastNPredictionClassLevelCalleesClassGold2Val=AtLeastNPredictionClassLevelCalleesClassGold2HashMap.get(key);
			String AtLeastNPredictionMethodLevelCallersClassGold2Val= AtLeastNPredictionMethodLevelCallersClassGold2HashMap.get(key);
			String AtLeastNPredictionMethodLevelCalleesClassGold2Val=AtLeastNPredictionMethodLevelCalleesClassGold2HashMap.get(key);
			String AtLeastTPredictionClassLevelCallersClassGold2Val=AtLeastTPredictionClassLevelCallersClassGold2HashMap.get(key);
			String AtLeastTPredictionClassLevelCalleesClassGold2Val=AtLeastTPredictionClassLevelCalleesClassGold2HashMap.get(key);
			String AtLeastTPredictionMethodLevelCallersClassGold2Val=AtLeastTPredictionMethodLevelCallersClassGold2HashMap.get(key);
			String AtLeastTPredictionMethodLevelCalleesClassGold2Val=AtLeastTPredictionMethodLevelCalleesClassGold2HashMap.get(key);
			String AtLeast2NPredictionClassLevelCallersClassGold2Val=AtLeast2NPredictionClassLevelCallersClassGold2HashMap.get(key);
			String AtLeast2NPredictionClassLevelCalleesClassGold2Val=AtLeast2NPredictionClassLevelCalleesClassGold2HashMap.get(key);
			String AtLeast2NPredictionMethodLevelCallersClassGold2Val=AtLeast2NPredictionMethodLevelCallersClassGold2HashMap.get(key);
			String AtLeast2NPredictionMethodLevelCalleesClassGold2Val=AtLeast2NPredictionMethodLevelCalleesClassGold2HashMap.get(key);
			String AtLeast2TPredictionClassLevelCallersClassGold2Val=AtLeast2TPredictionClassLevelCallersClassGold2HashMap.get(key);
			String AtLeast2TPredictionClassLevelCalleesClassGold2Val=AtLeast2TPredictionClassLevelCalleesClassGold2HashMap.get(key);
			String AtLeast2TPredictionMethodLevelCallersClassGold2Val=AtLeast2TPredictionMethodLevelCallersClassGold2HashMap.get(key);
			String AtLeast2TPredictionMethodLevelCalleesClassGold2Val=AtLeast2TPredictionMethodLevelCalleesClassGold2HashMap.get(key);
			String AllNClassLevelCallersClassGold2Val=AllNClassLevelCallersClassGold2HashMap.get(key);
			String AllNClassLevelCalleesClassGold2Val=AllNClassLevelCalleesClassGold2HashMap.get(key);
			String AllNMethodLevelCalleesClassGold2Val=AllNMethodLevelCalleesClassGold2HashMap.get(key);
			String AllTMethodLevelCalleesClassGold2Val=AllTMethodLevelCalleesClassGold2HashMap.get(key);
			String AllTClassLevelCallersClassGold2Val=AllTClassLevelCallersClassGold2HashMap.get(key);
			String AllTClassLevelCalleesClassGold2Val=AllTClassLevelCalleesClassGold2HashMap.get(key);
			String AllTMethodLevelCallersClassGold2Val=AllTMethodLevelCallersClassGold2HashMap.get(key);
			String MajorityParametersClassGold2Val=MajorityParametersClassGold2HashMap.get(key);
			String AtLeast1NParameterClassGold2Val=AtLeast1NParameterClassGold2HashMap.get(key);
			String AtLeast2NParameterClassGold2Val=AtLeast2NParameterClassGold2HashMap.get(key);
			String AtLeast1TParameterClassGold2Val=AtLeast1TParameterClassGold2HashMap.get(key);
			String AtLeast2TParameterClassGold2Val=AtLeast2TParameterClassGold2HashMap.get(key);
			String AllNParameterClassGold2Val=AllNParameterClassGold2HashMap.get(key);
			String AllTParameterClassGold2Val=AllTParameterClassGold2HashMap.get(key);		
			String AllNMethodLevelCallersCalleesClassGold2Val=AllNMethodLevelCallersCalleesClassGold2HashMap.get(key);
			String AllTMethodLevelCallersCalleesClassGold2Val=AllTMethodLevelCallersCalleesClassGold2HashMap.get(key);
			String AllNClassLevelCallersCalleesClassGold2Val=AllNClassLevelCallersCalleesClassGold2HashMap.get(key);
			String AllTClassLevelCallersCalleesClassGold2Val=AllTClassLevelCallersCalleesClassGold2HashMap.get(key);	
			String PureNCallersGold2Val=PureNCallersGold2HashMap.get(key);
			String PureTCallersGold2Val=PureTCallersGold2HashMap.get(key);
			String AllNClassLevelCalleesClassAtLeast2NGold2Val=AllNClassLevelCalleesClassAtLeast2NGold2HashMap.get(key); 
			String AllNClassLevelCallersClassAtLeast2NGold2Val=AllNClassLevelCallersClassAtLeast2NGold2HashMap.get(key);  
			String AllNMethodLevelCalleesClassAtLeast2NGold2Val=AllNMethodLevelCalleesClassAtLeast2NGold2HashMap.get(key);  
			String AllNMethodLevelCallersClassAtLeast2NGold2Val=AllNMethodLevelCallersClassAtLeast2NGold2HashMap.get(key); 
			String AllTClassLevelCalleesClassAtLeast2TGold2Val=AllTClassLevelCalleesClassAtLeast2TGold2HashMap.get(key); 
			String AllTClassLevelCallersClassAtLeast2TGold2Val=AllTClassLevelCallersClassAtLeast2TGold2HashMap.get(key);  
			String AllTMethodLevelCalleesClassAtLeast2TGold2Val=AllTMethodLevelCalleesClassAtLeast2TGold2HashMap.get(key);  
			String AllTMethodLevelCallersClassAtLeast2TGold2Val=AllTMethodLevelCallersClassAtLeast2TGold2HashMap.get(key); 
			String PredictionCLASSTRACEMethodLevelPureGold2Val=PredictionCLASSTRACEMethodLevelPureGold2HashMap.get(key); 
			System.out.println("==========>VALUIEE"+PredictionCLASSTRACEMethodLevelPureGold2Val);

			String PredictionCLASSTRACEMethodLevelMixedGold2Val=PredictionCLASSTRACEMethodLevelMixedGold2HashMap.get(key);  
			String PredictionCLASSNOTRACEMethodLevelPureGold2Val=PredictionCLASSNOTRACEMethodLevelPureGold2HashMap.get(key);  
			String PredictionCLASSNOTRACEMethodLevelMixedGold2Val=PredictionCLASSNOTRACEMethodLevelMixedGold2HashMap.get(key);  
			String PredictionCLASSTRACEClassLevelPureGold2Val=PredictionCLASSTRACEClassLevelPureGold2HashMap.get(key);   
			String PredictionCLASSTRACEClassLevelMixedGold2Val=PredictionCLASSTRACEClassLevelMixedGold2HashMap.get(key);  
			String PredictionCLASSNOTRACEClassLevelPureGold2Val=PredictionCLASSNOTRACEClassLevelPureGold2HashMap.get(key);   
			String PredictionCLASSNOTRACEClassLevelMixedGold2Val=PredictionCLASSNOTRACEClassLevelMixedGold2HashMap.get(key);  
			String PredictionCLASSTRACEMethodLevelPureGold2HashMapACROSSVal=PredictionCLASSTRACEMethodLevelPureGold2HashMapACROSS.get(key); 
			String PredictionCLASSTRACEMethodLevelMixedGold2HashMapACROSSVal=PredictionCLASSTRACEMethodLevelMixedGold2HashMapACROSS.get(key);  
			String PredictionCLASSNOTRACEMethodLevelPureGold2HashMapACROSSVal=PredictionCLASSNOTRACEMethodLevelPureGold2HashMapACROSS.get(key);  
			String PredictionCLASSNOTRACEMethodLevelMixedGold2HashMapACROSSVal=PredictionCLASSNOTRACEMethodLevelMixedGold2HashMapACROSS.get(key);  
			String PredictionCLASSTRACEClassLevelPureGold2HashMapACROSSVal=PredictionCLASSTRACEClassLevelPureGold2HashMapACROSS.get(key);   
			String PredictionCLASSTRACEClassLevelMixedGold2HashMapACROSSVal=PredictionCLASSTRACEClassLevelMixedGold2HashMapACROSS.get(key);  
			String PredictionCLASSNOTRACEClassLevelPureGold2HashMapACROSSVal=PredictionCLASSNOTRACEClassLevelPureGold2HashMapACROSS.get(key);   
			String PredictionCLASSNOTRACEClassLevelMixedGold2HashMapACROSSVal=PredictionCLASSNOTRACEClassLevelMixedGold2HashMapACROSS.get(key);  
			String StandardVal= PredictionStandardHashMap.get(key); 
		if(OwnerVal!=null)
			if(!OwnerVal.equals(StandardVal)) {
				OwnerValFitness++; 
			
				
				FitnessHashMap.put(0,OwnerValFitness ); 
				NameHashMap.put(0,OwnerClassPredictionClassGold2HashMap ); 

			}
		if(MajorityClassLevelCallersClassGold2Val!=null)
			if(!MajorityClassLevelCallersClassGold2Val.equals(StandardVal)) {
				MajorityClassLevelCallersClassGold2ValFitness++; 
				
				FitnessHashMap.put(1,MajorityClassLevelCallersClassGold2ValFitness ); 
				NameHashMap.put(1,MajorityClassLevelCallersClassGold2HashMap ); 
			}
		
		
		
		
		
		
		
		if(MajorityClassLevelCalleesClassGold2Val!=null)
			if(!MajorityClassLevelCalleesClassGold2Val.equals(StandardVal)) {
				MajorityClassLevelCalleesClassGold2ValFitness++; 
				
				
				FitnessHashMap.put(2,MajorityClassLevelCalleesClassGold2ValFitness ); 
				NameHashMap.put(2,MajorityClassLevelCalleesClassGold2HashMap ); 
			}
		if(MajorityMethodLevelCallersClassGold2Val!=null)
			if(!MajorityMethodLevelCallersClassGold2Val.equals(StandardVal)) {
				MajorityMethodLevelCallersClassGold2ValFitness++; 	
			
				
				
				FitnessHashMap.put(3,MajorityMethodLevelCallersClassGold2ValFitness ); 
				NameHashMap.put(3,MajorityMethodLevelCallersClassGold2HashMap ); 	
			
			
			}
		if(MajorityMethodLevelCalleesClassGold2Val!=null)
			if(!MajorityMethodLevelCalleesClassGold2Val.equals(StandardVal)) {
				MajorityMethodLevelCalleesClassGold2ValFitness++; 
				
				
				FitnessHashMap.put(4,MajorityMethodLevelCalleesClassGold2ValFitness ); 
				NameHashMap.put(4,MajorityMethodLevelCalleesClassGold2HashMap ); 	
			}
		if(AtLeastNPredictionClassLevelCallersClassGold2Val!=null)
			if(!AtLeastNPredictionClassLevelCallersClassGold2Val.equals(StandardVal)) {
				AtLeastNPredictionClassLevelCallersClassGold2ValFitness++; 
				
				
				FitnessHashMap.put(5,AtLeastNPredictionClassLevelCallersClassGold2ValFitness ); 
				NameHashMap.put(5,AtLeastNPredictionClassLevelCallersClassGold2HashMap ); 	
			}
			System.out.println(AtLeastNPredictionClassLevelCalleesClassGold2Val);
			if(AtLeastNPredictionClassLevelCalleesClassGold2Val!=null)
			if(!AtLeastNPredictionClassLevelCalleesClassGold2Val.equals(StandardVal)) {
				AtLeastNPredictionClassLevelCalleesClassGold2ValFitness++; 
				
			
				FitnessHashMap.put(6,AtLeastNPredictionClassLevelCalleesClassGold2ValFitness ); 
				NameHashMap.put(6,AtLeastNPredictionClassLevelCalleesClassGold2HashMap ); 	
			}
			if(AtLeastNPredictionMethodLevelCallersClassGold2Val!=null)
			if(!AtLeastNPredictionMethodLevelCallersClassGold2Val.equals(StandardVal)) {
				AtLeastNPredictionMethodLevelCallersClassGold2ValFitness++; 
			
				
				FitnessHashMap.put(7,AtLeastNPredictionMethodLevelCallersClassGold2ValFitness ); 
				NameHashMap.put(7,AtLeastNPredictionMethodLevelCallersClassGold2HashMap ); 	
				}
			if(AtLeastNPredictionMethodLevelCalleesClassGold2Val!=null)
			if(!AtLeastNPredictionMethodLevelCalleesClassGold2Val.equals(StandardVal)) {
				AtLeastNPredictionMethodLevelCalleesClassGold2ValFitness++; 
				
			
				FitnessHashMap.put(8,AtLeastNPredictionMethodLevelCalleesClassGold2ValFitness ); 
				NameHashMap.put(8,AtLeastNPredictionMethodLevelCalleesClassGold2HashMap ); 	
			
			}
			if(AtLeastTPredictionClassLevelCallersClassGold2Val!=null)
			if(!AtLeastTPredictionClassLevelCallersClassGold2Val.equals(StandardVal)) {
				AtLeastTPredictionClassLevelCallersClassGold2ValFitness++; 
			
				
				FitnessHashMap.put(9,AtLeastTPredictionClassLevelCallersClassGold2ValFitness ); 
				NameHashMap.put(9,AtLeastTPredictionClassLevelCallersClassGold2HashMap ); 	
			}
			if(AtLeastTPredictionClassLevelCalleesClassGold2Val!=null)
			if(!AtLeastTPredictionClassLevelCalleesClassGold2Val.equals(StandardVal)) {
				AtLeastTPredictionClassLevelCalleesClassGold2ValFitness++; 
			
			
				FitnessHashMap.put(10,AtLeastTPredictionClassLevelCalleesClassGold2ValFitness ); 
				NameHashMap.put(10,AtLeastTPredictionClassLevelCalleesClassGold2HashMap ); 	
			}
			if(AtLeastTPredictionMethodLevelCallersClassGold2Val!=null)
				if(!AtLeastTPredictionMethodLevelCallersClassGold2Val.equals(StandardVal)) {
					AtLeastTPredictionMethodLevelCallersClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(11,AtLeastTPredictionMethodLevelCallersClassGold2ValFitness ); 
					NameHashMap.put(11,AtLeastTPredictionClassLevelCalleesClassGold2HashMap ); 	
				}
			if(AtLeastTPredictionMethodLevelCalleesClassGold2Val!=null)
				if(!AtLeastTPredictionMethodLevelCalleesClassGold2Val.equals(StandardVal)) {
					AtLeastTPredictionMethodLevelCalleesClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(12,AtLeastTPredictionMethodLevelCalleesClassGold2ValFitness ); 
					NameHashMap.put(12,AtLeastTPredictionMethodLevelCalleesClassGold2HashMap ); 	
				}
			
			if(AtLeast2NPredictionClassLevelCallersClassGold2Val!=null)
				if(!AtLeast2NPredictionClassLevelCallersClassGold2Val.equals(StandardVal)) {
					AtLeast2NPredictionClassLevelCallersClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(13,AtLeast2NPredictionClassLevelCallersClassGold2ValFitness ); 
					NameHashMap.put(13,AtLeast2NPredictionClassLevelCallersClassGold2HashMap ); 	
				}
			
			if(AtLeast2NPredictionClassLevelCalleesClassGold2Val!=null)
				if(!AtLeast2NPredictionClassLevelCalleesClassGold2Val.equals(StandardVal)) {
					AtLeast2NPredictionClassLevelCalleesClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(14,AtLeast2NPredictionClassLevelCalleesClassGold2ValFitness ); 
					NameHashMap.put(14,AtLeast2NPredictionClassLevelCalleesClassGold2HashMap ); 	
				}
			
			if(AtLeast2NPredictionMethodLevelCallersClassGold2Val!=null)
				if(!AtLeast2NPredictionMethodLevelCallersClassGold2Val.equals(StandardVal)) {
					AtLeast2NPredictionMethodLevelCallersClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(15,AtLeast2NPredictionMethodLevelCallersClassGold2ValFitness ); 
					NameHashMap.put(15,AtLeast2NPredictionMethodLevelCallersClassGold2HashMap ); 	
				}
			
			if(AtLeast2NPredictionMethodLevelCalleesClassGold2Val!=null)
				if(!AtLeast2NPredictionMethodLevelCalleesClassGold2Val.equals(StandardVal)) {
					AtLeast2NPredictionMethodLevelCalleesClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(16,AtLeast2NPredictionMethodLevelCalleesClassGold2ValFitness ); 
					NameHashMap.put(16,AtLeast2NPredictionMethodLevelCalleesClassGold2HashMap ); 	
				}
			
			
			if(AtLeast2NPredictionMethodLevelCallersClassGold2Val!=null)
				if(!AtLeast2NPredictionMethodLevelCallersClassGold2Val.equals(StandardVal)) {
					AtLeast2NPredictionMethodLevelCallersClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(17,AtLeast2NPredictionMethodLevelCallersClassGold2ValFitness ); 
					NameHashMap.put(17,AtLeast2NPredictionMethodLevelCallersClassGold2HashMap ); 	
				}
			if(AtLeast2TPredictionClassLevelCallersClassGold2Val!=null)
				if(!AtLeast2TPredictionClassLevelCallersClassGold2Val.equals(StandardVal)) {
					AtLeast2TPredictionClassLevelCallersClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(18,AtLeast2TPredictionClassLevelCallersClassGold2ValFitness ); 
					NameHashMap.put(18,AtLeast2TPredictionClassLevelCallersClassGold2HashMap ); 	
				}
			
			if(AtLeast2TPredictionClassLevelCalleesClassGold2Val!=null)
				if(!AtLeast2TPredictionClassLevelCalleesClassGold2Val.equals(StandardVal)) {
					AtLeast2TPredictionClassLevelCalleesClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(19,AtLeast2TPredictionClassLevelCalleesClassGold2ValFitness ); 
					NameHashMap.put(19,AtLeast2TPredictionClassLevelCalleesClassGold2HashMap ); 	
				}
			if(AtLeast2TPredictionMethodLevelCallersClassGold2Val!=null)
				if(!AtLeast2TPredictionMethodLevelCallersClassGold2Val.equals(StandardVal)) {
					AtLeast2TPredictionMethodLevelCallersClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(20,AtLeast2TPredictionMethodLevelCallersClassGold2ValFitness ); 
					NameHashMap.put(20,AtLeast2TPredictionMethodLevelCallersClassGold2HashMap ); 	
				}
			
			if(AtLeast2TPredictionMethodLevelCalleesClassGold2Val!=null)
				if(!AtLeast2TPredictionMethodLevelCalleesClassGold2Val.equals(StandardVal)) {
					AtLeast2TPredictionMethodLevelCalleesClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(21,AtLeast2TPredictionMethodLevelCalleesClassGold2ValFitness ); 
					NameHashMap.put(21,AtLeast2TPredictionMethodLevelCalleesClassGold2HashMap ); 	
				}
			
			
			if(AllNClassLevelCallersClassGold2Val!=null)
				if(!AllNClassLevelCallersClassGold2Val.equals(StandardVal)) {
					AllNClassLevelCallersClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(22,AllNClassLevelCallersClassGold2ValFitness ); 
					NameHashMap.put(22,AllNClassLevelCallersClassGold2HashMap ); 	
				}
			
			if(AllNClassLevelCalleesClassGold2Val!=null)
				if(!AllNClassLevelCalleesClassGold2Val.equals(StandardVal)) {
					AllNClassLevelCalleesClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(23,AllNClassLevelCalleesClassGold2ValFitness ); 
					NameHashMap.put(23,AllNClassLevelCalleesClassGold2HashMap ); 	
				}
			
			if(AllNMethodLevelCalleesClassGold2Val!=null)
				if(!AllNMethodLevelCalleesClassGold2Val.equals(StandardVal)) {
					AllNMethodLevelCalleesClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(24,AllNMethodLevelCalleesClassGold2ValFitness ); 
					NameHashMap.put(24,AllNMethodLevelCalleesClassGold2HashMap ); 	
				}
			
			if(AllTMethodLevelCalleesClassGold2Val!=null)
				if(!AllTMethodLevelCalleesClassGold2Val.equals(StandardVal)) {
					AllTMethodLevelCalleesClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(25,AllTMethodLevelCalleesClassGold2ValFitness ); 
					NameHashMap.put(25,AllTMethodLevelCalleesClassGold2HashMap ); 	
				}
			if(AllTClassLevelCallersClassGold2Val!=null)
				if(!AllTClassLevelCallersClassGold2Val.equals(StandardVal)) {
					AllTClassLevelCallersClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(26,AllTClassLevelCallersClassGold2ValFitness ); 
					NameHashMap.put(26,AllTClassLevelCallersClassGold2HashMap ); 	
				}
			
			if(AllTClassLevelCalleesClassGold2Val!=null)
				if(!AllTClassLevelCalleesClassGold2Val.equals(StandardVal)) {
					AllTClassLevelCalleesClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(27,AllTClassLevelCalleesClassGold2ValFitness ); 
					NameHashMap.put(27,AllTClassLevelCalleesClassGold2HashMap ); 	
				}
			if(AllTMethodLevelCallersClassGold2Val!=null)
				if(!AllTMethodLevelCallersClassGold2Val.equals(StandardVal)) {
					AllTMethodLevelCallersClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(28,AllTMethodLevelCallersClassGold2ValFitness ); 
					NameHashMap.put(28,AllTMethodLevelCallersClassGold2HashMap ); 	
				}
			
			if(MajorityParametersClassGold2Val!=null)
				if(!MajorityParametersClassGold2Val.equals(StandardVal)) {
					MajorityParametersClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(29,MajorityParametersClassGold2ValFitness ); 
					NameHashMap.put(29,MajorityParametersClassGold2HashMap ); 	
				}
			
			
			if(AtLeast1NParameterClassGold2Val!=null)
				if(!AtLeast1NParameterClassGold2Val.equals(StandardVal)) {
					AtLeast1NParameterClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(30,AtLeast1NParameterClassGold2ValFitness ); 
					NameHashMap.put(30,AtLeast1NParameterClassGold2HashMap ); 	
				}
			if(AtLeast2NParameterClassGold2Val!=null)
				if(!AtLeast2NParameterClassGold2Val.equals(StandardVal)) {
					AtLeast2NParameterClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(31,AtLeast2NParameterClassGold2ValFitness ); 
					NameHashMap.put(31,AtLeast2NParameterClassGold2HashMap ); 	
				}
			
			if(AtLeast1TParameterClassGold2Val!=null)
				if(!AtLeast1TParameterClassGold2Val.equals(StandardVal)) {
					AtLeast1TParameterClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(32,AtLeast1TParameterClassGold2ValFitness ); 
					NameHashMap.put(32,AtLeast1TParameterClassGold2HashMap ); 	
				}
			if(AtLeast2TParameterClassGold2Val!=null)
				if(!AtLeast2TParameterClassGold2Val.equals(StandardVal)) {
					AtLeast2TParameterClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(33,AtLeast2TParameterClassGold2ValFitness ); 
					NameHashMap.put(33,AtLeast2TParameterClassGold2HashMap ); 	
				}
			
			if(AllNParameterClassGold2Val!=null)
				if(!AllNParameterClassGold2Val.equals(StandardVal)) {
					AllNParameterClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(34,AllNParameterClassGold2ValFitness ); 
					NameHashMap.put(34,AllNParameterClassGold2HashMap ); 	
				}
			
			if(AllTParameterClassGold2Val!=null)
				if(!AllTParameterClassGold2Val.equals(StandardVal)) {
					AllTParameterClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(35,AllTParameterClassGold2ValFitness ); 
					NameHashMap.put(35,AllTParameterClassGold2HashMap ); 	
				}
			if(AllNMethodLevelCallersCalleesClassGold2Val!=null)
				if(!AllNMethodLevelCallersCalleesClassGold2Val.equals(StandardVal)) {
					AllNMethodLevelCallersCalleesClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(36,AllNMethodLevelCallersCalleesClassGold2ValFitness ); 
					NameHashMap.put(36,AllNMethodLevelCallersCalleesClassGold2HashMap ); 	
				}
			
			if(AllTMethodLevelCallersCalleesClassGold2Val!=null)
				if(!AllTMethodLevelCallersCalleesClassGold2Val.equals(StandardVal)) {
					AllTMethodLevelCallersCalleesClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(37,AllTMethodLevelCallersCalleesClassGold2ValFitness ); 
					NameHashMap.put(37,AllTMethodLevelCallersCalleesClassGold2HashMap ); 	
				}
			
			
			if(AllNClassLevelCallersCalleesClassGold2Val!=null)
				if(!AllNClassLevelCallersCalleesClassGold2Val.equals(StandardVal)) {
					AllNClassLevelCallersCalleesClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(38,AllNClassLevelCallersCalleesClassGold2ValFitness ); 
					NameHashMap.put(38,AllNClassLevelCallersCalleesClassGold2HashMap ); 	
				}
			
			if(AllTClassLevelCallersCalleesClassGold2Val!=null)
				if(!AllTClassLevelCallersCalleesClassGold2Val.equals(StandardVal)) {
					AllTClassLevelCallersCalleesClassGold2ValFitness++; 
				
				
					FitnessHashMap.put(39,AllTClassLevelCallersCalleesClassGold2ValFitness ); 
					NameHashMap.put(39,AllTClassLevelCallersCalleesClassGold2HashMap ); 	
				}
			if(PureNCallersGold2Val!=null)
				if(!PureNCallersGold2Val.equals(StandardVal)) {
					PureNCallersGold2ValFitness++; 
				
				
					FitnessHashMap.put(40,PureNCallersGold2ValFitness ); 
					NameHashMap.put(40,PureNCallersGold2HashMap ); 	
				}
			if(PureTCallersGold2Val!=null)
				if(!PureTCallersGold2Val.equals(StandardVal)) {
					PureTCallersGold2ValFitness++; 
				
				
					FitnessHashMap.put(41,PureTCallersGold2ValFitness ); 
					NameHashMap.put(41,PureTCallersGold2HashMap ); 	
				}
			if(AllNClassLevelCalleesClassAtLeast2NGold2Val!=null)
				if(!AllNClassLevelCalleesClassAtLeast2NGold2Val.equals(StandardVal)) {
					AllNClassLevelCalleesClassAtLeast2NGold2ValFitness++; 
				
				
					FitnessHashMap.put(42,AllNClassLevelCalleesClassAtLeast2NGold2ValFitness ); 
					NameHashMap.put(42,AllNClassLevelCalleesClassAtLeast2NGold2HashMap ); 	
				}
			
			if(AllNClassLevelCallersClassAtLeast2NGold2Val!=null)
				if(!AllNClassLevelCallersClassAtLeast2NGold2Val.equals(StandardVal)) {
					AllNClassLevelCallersClassAtLeast2NGold2ValFitness++; 
				
				
					FitnessHashMap.put(43,AllNClassLevelCallersClassAtLeast2NGold2ValFitness ); 
					NameHashMap.put(43,AllNClassLevelCallersClassAtLeast2NGold2HashMap ); 	
				}
			
			if(AllNMethodLevelCallersClassAtLeast2NGold2Val!=null)
				if(!AllNMethodLevelCallersClassAtLeast2NGold2Val.equals(StandardVal)) {
					AllNMethodLevelCallersClassAtLeast2NGold2ValFitness++; 
				
				
					FitnessHashMap.put(44,AllNMethodLevelCallersClassAtLeast2NGold2ValFitness ); 
					NameHashMap.put(44,AllNMethodLevelCallersClassAtLeast2NGold2HashMap ); 	
				}
			
			if(AllNMethodLevelCalleesClassAtLeast2NGold2Val!=null)
				if(!AllNMethodLevelCalleesClassAtLeast2NGold2Val.equals(StandardVal)) {
					AllNMethodLevelCalleesClassAtLeast2NGold2ValFitness++; 
				
				
					FitnessHashMap.put(45,AllNMethodLevelCalleesClassAtLeast2NGold2ValFitness ); 
					NameHashMap.put(45,AllNMethodLevelCalleesClassAtLeast2NGold2HashMap ); 	
				}
			
			
			if(AllTClassLevelCalleesClassAtLeast2TGold2Val!=null)
				if(!AllTClassLevelCalleesClassAtLeast2TGold2Val.equals(StandardVal)) {
					AllTClassLevelCalleesClassAtLeast2TGold2ValFitness++; 
				
				
					FitnessHashMap.put(46,AllTClassLevelCalleesClassAtLeast2TGold2ValFitness ); 
					NameHashMap.put(46,AllTClassLevelCalleesClassAtLeast2TGold2HashMap ); 	
				}
			
			if(AllTClassLevelCallersClassAtLeast2TGold2Val!=null)
				if(!AllTClassLevelCallersClassAtLeast2TGold2Val.equals(StandardVal)) {
					AllTClassLevelCallersClassAtLeast2TGold2ValFitness++; 
				
				
					FitnessHashMap.put(47,AllTClassLevelCallersClassAtLeast2TGold2ValFitness ); 
					NameHashMap.put(47,AllTClassLevelCallersClassAtLeast2TGold2HashMap ); 	
				}
			
			if(AllTMethodLevelCallersClassAtLeast2TGold2Val!=null)
				if(!AllTMethodLevelCallersClassAtLeast2TGold2Val.equals(StandardVal)) {
					AllTMethodLevelCallersClassAtLeast2TGold2ValFitness++; 
				
				
					FitnessHashMap.put(48,AllTMethodLevelCallersClassAtLeast2TGold2ValFitness ); 
					NameHashMap.put(48,AllTMethodLevelCallersClassAtLeast2TGold2HashMap ); 	
				}
			
			if(AllTMethodLevelCalleesClassAtLeast2TGold2Val!=null)
				if(!AllTMethodLevelCalleesClassAtLeast2TGold2Val.equals(StandardVal)) {
					AllTMethodLevelCalleesClassAtLeast2TGold2ValFitness++; 
				
				
					FitnessHashMap.put(49,AllTMethodLevelCalleesClassAtLeast2TGold2ValFitness ); 
					NameHashMap.put(49,AllTMethodLevelCalleesClassAtLeast2TGold2HashMap ); 	
				}
		
			
			if(PredictionCLASSTRACEMethodLevelPureGold2Val!=null)
				if(!PredictionCLASSTRACEMethodLevelPureGold2Val.equals(StandardVal)) {
					PredictionCLASSTRACEMethodLevelPureGold2ValFitness++; 
				
				
					FitnessHashMap.put(50,PredictionCLASSTRACEMethodLevelPureGold2ValFitness ); 
					NameHashMap.put(50,PredictionCLASSTRACEMethodLevelPureGold2HashMap ); 	
				}
		
			if(PredictionCLASSTRACEMethodLevelMixedGold2Val!=null)
				if(!PredictionCLASSTRACEMethodLevelMixedGold2Val.equals(StandardVal)) {
					PredictionCLASSTRACEMethodLevelMixedGold2ValFitness++; 
				
				
					FitnessHashMap.put(51,PredictionCLASSTRACEMethodLevelMixedGold2ValFitness ); 
					NameHashMap.put(51,PredictionCLASSTRACEMethodLevelMixedGold2HashMap ); 	
				}
			
			if(PredictionCLASSTRACEClassLevelPureGold2Val!=null)
				if(!PredictionCLASSTRACEClassLevelPureGold2Val.equals(StandardVal)) {
					PredictionCLASSTRACEClassLevelPureGold2ValFitness++; 
				
				
					FitnessHashMap.put(52,PredictionCLASSTRACEClassLevelPureGold2ValFitness ); 
					NameHashMap.put(52,PredictionCLASSTRACEClassLevelPureGold2HashMap ); 	
				}
		
			if(PredictionCLASSTRACEClassLevelMixedGold2Val!=null)
				if(!PredictionCLASSTRACEClassLevelMixedGold2Val.equals(StandardVal)) {
					PredictionCLASSTRACEClassLevelMixedGold2ValFitness++; 
				
				
					FitnessHashMap.put(53,PredictionCLASSTRACEClassLevelMixedGold2ValFitness ); 
					NameHashMap.put(53,PredictionCLASSTRACEClassLevelMixedGold2HashMap ); 	
				}
			
			if(PredictionCLASSNOTRACEMethodLevelPureGold2Val!=null)
				if(!PredictionCLASSNOTRACEMethodLevelPureGold2Val.equals(StandardVal)) {
					PredictionCLASSNOTRACEMethodLevelPureGold2ValFitness++; 
				
				
					FitnessHashMap.put(54,PredictionCLASSNOTRACEMethodLevelPureGold2ValFitness ); 
					NameHashMap.put(54,PredictionCLASSNOTRACEMethodLevelPureGold2HashMap ); 	
				}
		
			if(PredictionCLASSNOTRACEMethodLevelMixedGold2Val!=null)
				if(!PredictionCLASSNOTRACEMethodLevelMixedGold2Val.equals(StandardVal)) {
					PredictionCLASSNOTRACEMethodLevelMixedGold2ValFitness++; 
				
				
					FitnessHashMap.put(55,PredictionCLASSNOTRACEMethodLevelMixedGold2ValFitness ); 
					NameHashMap.put(55,PredictionCLASSNOTRACEMethodLevelMixedGold2HashMap ); 	
				}
			
			if(PredictionCLASSNOTRACEClassLevelPureGold2Val!=null)
				if(!PredictionCLASSNOTRACEClassLevelPureGold2Val.equals(StandardVal)) {
					PredictionCLASSNOTRACEClassLevelPureGold2ValFitness++; 
				
				
					FitnessHashMap.put(56,PredictionCLASSNOTRACEClassLevelPureGold2ValFitness ); 
					NameHashMap.put(56,PredictionCLASSNOTRACEClassLevelPureGold2HashMap ); 	
				}
		
			if(PredictionCLASSNOTRACEClassLevelMixedGold2Val!=null)
				if(!PredictionCLASSNOTRACEClassLevelMixedGold2Val.equals(StandardVal)) {
					PredictionCLASSNOTRACEClassLevelMixedGold2ValFitness++; 
				
				
					FitnessHashMap.put(57,PredictionCLASSNOTRACEClassLevelMixedGold2ValFitness ); 
					NameHashMap.put(57,PredictionCLASSNOTRACEClassLevelMixedGold2HashMap ); 	
				}
			
			
			
			
			
			if(PredictionCLASSNOTRACEMethodLevelPureGold2HashMapACROSSVal!=null)
				if(!PredictionCLASSNOTRACEMethodLevelPureGold2HashMapACROSSVal.equals(StandardVal)) {
					PredictionCLASSNOTRACEMethodLevelPureGold2ACROSSValFitness++; 
				
				
					FitnessHashMap.put(58,PredictionCLASSNOTRACEMethodLevelPureGold2ACROSSValFitness ); 
					NameHashMap.put(58,PredictionCLASSNOTRACEMethodLevelPureGold2HashMapACROSS ); 	
				}
		
			if(PredictionCLASSNOTRACEMethodLevelMixedGold2HashMapACROSSVal!=null)
				if(!PredictionCLASSNOTRACEMethodLevelMixedGold2HashMapACROSSVal.equals(StandardVal)) {
					PredictionCLASSNOTRACEMethodLevelMixedGold2ACROSSValFitness++; 
				
				
					FitnessHashMap.put(59,PredictionCLASSNOTRACEMethodLevelMixedGold2ACROSSValFitness ); 
					NameHashMap.put(59,PredictionCLASSNOTRACEMethodLevelMixedGold2HashMapACROSS ); 	
				}
			
			if(PredictionCLASSNOTRACEClassLevelPureGold2HashMapACROSSVal!=null)
				if(!PredictionCLASSNOTRACEClassLevelPureGold2HashMapACROSSVal.equals(StandardVal)) {
					PredictionCLASSNOTRACEClassLevelPureGold2ACROSSValFitness++; 
				
				
					FitnessHashMap.put(60,PredictionCLASSNOTRACEClassLevelPureGold2ACROSSValFitness ); 
					NameHashMap.put(60,PredictionCLASSNOTRACEClassLevelPureGold2HashMapACROSS ); 	
				}
		
			if(PredictionCLASSNOTRACEClassLevelMixedGold2HashMapACROSSVal!=null)
				if(!PredictionCLASSNOTRACEClassLevelMixedGold2HashMapACROSSVal.equals(StandardVal)) {
					PredictionCLASSNOTRACEClassLevelMixedGold2ACROSSValFitness++; 
				
				
					FitnessHashMap.put(61,PredictionCLASSNOTRACEClassLevelMixedGold2ACROSSValFitness ); 
					NameHashMap.put(61,PredictionCLASSNOTRACEClassLevelMixedGold2HashMapACROSS ); 	
				}
			
			
			if(PredictionCLASSTRACEMethodLevelPureGold2HashMapACROSSVal!=null)
				if(!PredictionCLASSTRACEMethodLevelPureGold2HashMapACROSSVal.equals(StandardVal)) {
					PredictionCLASSTRACEMethodLevelPureGold2ACROSSValFitness++; 
				
				
					FitnessHashMap.put(62,PredictionCLASSTRACEMethodLevelPureGold2ACROSSValFitness ); 
					NameHashMap.put(62,PredictionCLASSTRACEMethodLevelPureGold2HashMapACROSS ); 	
				}
		
			if(PredictionCLASSTRACEMethodLevelMixedGold2HashMapACROSSVal!=null)
				if(!PredictionCLASSTRACEMethodLevelMixedGold2HashMapACROSSVal.equals(StandardVal)) {
					PredictionCLASSTRACEMethodLevelMixedGold2ACROSSValFitness++; 
				
				
					FitnessHashMap.put(63,PredictionCLASSTRACEMethodLevelMixedGold2ACROSSValFitness ); 
					NameHashMap.put(63,PredictionCLASSTRACEMethodLevelMixedGold2HashMapACROSS ); 	
				}
			
			if(PredictionCLASSTRACEClassLevelPureGold2HashMapACROSSVal!=null)
				if(!PredictionCLASSTRACEClassLevelPureGold2HashMapACROSSVal.equals(StandardVal)) {
					PredictionCLASSTRACEClassLevelPureGold2ACROSSValFitness++; 
				
				
					FitnessHashMap.put(64,PredictionCLASSTRACEClassLevelPureGold2ACROSSValFitness ); 
					NameHashMap.put(64,PredictionCLASSTRACEClassLevelPureGold2HashMapACROSS ); 	
				}
		
			if(PredictionCLASSTRACEClassLevelMixedGold2HashMapACROSSVal!=null)
				if(!PredictionCLASSTRACEClassLevelMixedGold2HashMapACROSSVal.equals(StandardVal)) {
					PredictionCLASSTRACEClassLevelMixedGold2ACROSSValFitness++; 
				
				
					FitnessHashMap.put(65,PredictionCLASSTRACEClassLevelMixedGold2ACROSSValFitness ); 
					NameHashMap.put(65,PredictionCLASSTRACEClassLevelMixedGold2HashMapACROSS ); 	
				}
			
			
			

			
		
			
		}
//		PrintStream fileOut = new PrintStream("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\out.txt");
//		System.setOut(fileOut);
		LinkedHashMap<Integer, LinkedHashMap<String, String>> OrderedNameHashMap = new LinkedHashMap<Integer, LinkedHashMap<String, String>>(); 
		int myval=1000; 
		int ITERATION=0; 
		while(myval>0) {
		
//			LinkedHashMap<Integer, LinkedHashMap<String, String>> testlinkedHashmap = TestPurposes(); 
//			DoublePopulationCrossover(testlinkedHashmap); 
			
			
			
			
			
		

		System.out.println("ITERATION  "+ITERATION);
		 OrderedNameHashMap = new LinkedHashMap<Integer, LinkedHashMap<String, String>>(); 
			LinkedHashMap<Integer, LinkedHashMap<String, String>> NameHashMap2= new LinkedHashMap<Integer, LinkedHashMap<String, String>>();
			LinkedHashMap<Integer, Integer> sortedfitnesses2= new LinkedHashMap<Integer, Integer> ();
			System.out.println("changing keys");
			ChangeKeys(NameHashMap, FitnessHashMap, NameHashMap2, sortedfitnesses2); 

//			for(Integer entry: NameHashMap2.keySet()) {
//				System.out.println("heeeeey "+entry+ "   "+ NameHashMap2.get(entry));
//			}
//			for(Integer entry: sortedfitnesses2.keySet()) {
//				System.out.println("heeeeey "+entry+ "   "+ sortedfitnesses2.get(entry));
//			}
			LinkedHashMap<Integer, Integer> fitnessHashMapSorted= new LinkedHashMap<Integer, Integer>();
			System.out.println("BubbleSort");
		SortedFitnesses = BubbleSort(sortedfitnesses2, NameHashMap2, OrderedNameHashMap, fitnessHashMapSorted); 
//		for(Integer entry: OrderedNameHashMap.keySet()) {
//			System.out.println("heeeeey2 "+entry+ "   "+ NameHashMap2.get(entry));
//		}
//		for(Integer entry: fitnessHashMapSorted.keySet()) {
//			System.out.println("heeeeey2 "+entry+ "   "+ sortedfitnesses2.get(entry));
//		}
		
		
		
//		System.out.println(" SORTING");
//		  for (Integer orderedkey : OrderedNameHashMap.keySet()) {
//			  System.out.println(orderedkey+ "  "+OrderedNameHashMap.get(orderedkey));
//		    }
		
		System.out.println("SelectFittestHalf");
		SelectFittestHalf(OrderedNameHashMap, fitnessHashMapSorted); 
		   
//		System.out.println(" SELECTING THE FITTEST HALF ");
//		  for (Integer orderedkey : OrderedNameHashMap.keySet()) {
//			  System.out.println(orderedkey+ "  "+OrderedNameHashMap.get(orderedkey));
//		    }
		LinkedHashMap<Integer, LinkedHashMap<String, String>> orderedNameHashMap2 = new LinkedHashMap<Integer, LinkedHashMap<String, String>>(); 
		LinkedHashMap<Integer, Integer> sortedFitnesses2 = new LinkedHashMap<Integer, Integer>(); 
		
		
		
		System.out.println("ChangeKeys");
		ChangeKeys(OrderedNameHashMap, fitnessHashMapSorted, orderedNameHashMap2, sortedFitnesses2); 
//		System.out.println(" CHANGING KEYS");
//		  for (Integer orderedkey : orderedNameHashMap2.keySet()) {
//			  System.out.println(orderedkey+ "  ----"+orderedNameHashMap2.get(orderedkey));
//		    }
		System.out.println("DoublePopulationCrossover");
			DoublePopulationCrossover(orderedNameHashMap2); 

//			System.out.println(" CROSSOVER");
//
//		 for (Integer orderedkey : orderedNameHashMap2.keySet()) {
//			  System.out.println(orderedkey+ "  "+orderedNameHashMap2.get(orderedkey));
//		    }
		LinkedHashMap<Integer, Integer> NewFitnesses = new LinkedHashMap<Integer, Integer>(); 
		LinkedHashMap<Integer, LinkedHashMap<String, String>> NewOrderedHashMap = new LinkedHashMap<Integer, LinkedHashMap<String, String>>(); 
//		System.out.println("ComputeFitnesses");
//		ComputeFitnesses(orderedNameHashMap2, NewFitnesses); 

		System.out.println("introduceMutation");
		LinkedHashMap<Integer, LinkedHashMap<String, String>> MyHashMapAfterMutation = introduceMutation(orderedNameHashMap2); 
		System.out.println("ComputeFitnesses");
		ComputeFitnesses(MyHashMapAfterMutation, NewFitnesses); 
		System.out.println("ITERATION  "+ITERATION);
//		System.out.println("NEW FITNESSES COMPUTED ");
//		for(Integer myfitnesskey: NewFitnesses.keySet()) {
//			System.out.println(myfitnesskey +"  "+ NewFitnesses.get(myfitnesskey));
//		}
//		System.out.println("NEW ORDERED HASHMAP COMPUTED ");
//		for(Integer myhash: NewOrderedHashMap.keySet()) {
//			System.out.println(myhash +"  "+ NewOrderedHashMap.get(myhash));
//		}
		FitnessHashMap=NewFitnesses; 
		NameHashMap=orderedNameHashMap2;
		
		OrderedNameHashMap = new LinkedHashMap<Integer, LinkedHashMap<String, String>>(); 
		System.out.println("ChangeKeys");
		ChangeKeys(NameHashMap, FitnessHashMap, orderedNameHashMap2, sortedFitnesses2);
		fitnessHashMapSorted= new LinkedHashMap<Integer, Integer>();
		System.out.println("BubbleSort");
		SortedFitnesses = BubbleSort(FitnessHashMap, NameHashMap, OrderedNameHashMap, fitnessHashMapSorted); 
			System.out.println(" COMPUTING NEW FITNESSES");

		  for (Integer newfi : fitnessHashMapSorted.keySet()) {
			  System.out.println(newfi+ " NEW FI "+fitnessHashMapSorted.get(newfi));
		    }
		Collection<Integer> mykeys = fitnessHashMapSorted.values();
		Integer[] arr = new Integer[mykeys.size()]; 
		 arr = mykeys.toArray(arr); 
		 myval=arr[0]; 
		
		ITERATION++; 
		System.out.println("ITERATIOOOOOOON "+ITERATION +" MYVAL "+ myval);
		}
		 
		
		
		
		
		
		
		
		
		
		
//		System.out.println(SortedFitnesses.size());
//		System.out.println(OrderedNameHashMap.size());
for(Integer name: OrderedNameHashMap.keySet()){
	    System.out.println("name hashmap "+name);
	    System.out.println("linked list size "+  OrderedNameHashMap.get(name).size());
	} 

for(Integer name: SortedFitnesses.keySet()){
    System.out.println("FITNESS "+ name);
} 
		System.out.println("**************START22**************");		
		
//		for ( Integer  HashMapName : SortedFitnesses.keySet()) { 
//      //      System.out.println("Name HashMap = " + HashMapName +  
//      //                     "   hashmap "+SortedFitnesses.get(HashMapName) + "  HASHMAP ISTSELD  " + NameHashMap.get(HashMapName)); 
//            
//           
//        } 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

//		LinkedHashMap<Integer, LinkedHashMap<String, String>> CorrespondingHashMapsList2 = new LinkedHashMap<Integer, LinkedHashMap<String, String>>(); 
//		
//		HashMap<Integer, LinkedHashMap<String, String>> CorrespondingHashMapsList = new HashMap<Integer, LinkedHashMap<String, String>>(); 
//		LinkedHashMap<Integer, LinkedHashMap<String, String>> NewCorrespondingHashMaps = new 	LinkedHashMap<Integer, LinkedHashMap<String, String>> (); 
//boolean FirstIteration=true; 
//		boolean cond=false; 
//		while(cond==false) {
//			if(FirstIteration==true) {
//				CorrespondingHashMapsList2=NameHashMap; 
//		
//		
//			LinkedHashMap<Integer, Integer> fitnesshashmaps = new LinkedHashMap<Integer, Integer>(); 
//			
//			
//			// TODO Auto-generated method stub
//			//SELECT THE FITTEST HALF OF THE POPULATION 
//
//			int newsize =SortedFitnesses.size()/2; 		
//			int k=0; 
//			LinkedHashMap<String, Integer> NewPopulation = new LinkedHashMap<String, Integer>(); 
//			LinkedHashMap<String, Integer> CrossoverNewPopulation = new LinkedHashMap<String, Integer>(); 
//
//				   Iterator it = SortedFitnesses.entrySet().iterator();
//				   System.out.println(SortedFitnesses.size());
//			while(k<=newsize && it.hasNext()) {
//				Map.Entry pair = (Map.Entry)it.next();
//				NewPopulation.put(pair.getKey().toString(), Integer.parseInt(pair.getValue().toString())); 
//				System.out.println("FITNESS VAL===> "+Integer.parseInt(pair.getValue().toString()));
//				k++; 
//				
//			
//			}
//				int p= 0; 
//				NewCorrespondingHashMaps = new 	LinkedHashMap<Integer, LinkedHashMap<String, String>> (); 
//				//CorrespondingHashMapsList2= new HashMap<Integer, LinkedHashMap<String, String>>(); 
//			for(String item: NewPopulation.keySet()) {
//				
//			//	System.out.println(item+ "  "+NewPopulation.get(item));
//				
//				LinkedHashMap<String, String> CorrespondingHashMaps = CorrespondingHashMapsList2.get(Integer.parseInt(item)); 
//				NewCorrespondingHashMaps.put(p, CorrespondingHashMaps); 
//				p++; 
//				
//			}
//			int InitialPopSize = NewCorrespondingHashMaps.size(); 
//			}else {
//				int InitialPopSize = NewCorrespondingHashMaps.size(); 
//				
//				int newsize =SortedFitnesses.size()/2; 		
//				int k=0; 
//				LinkedHashMap<Integer, LinkedHashMap<String, String>> NewPopulation = new LinkedHashMap<Integer, LinkedHashMap<String, String>>(); 
//				LinkedHashMap<String, Integer> CrossoverNewPopulation = new LinkedHashMap<String, Integer>(); 
//
//					   Iterator it = SortedFitnesses.entrySet().iterator();
//					   System.out.println(SortedFitnesses.size());	
//					   
//						while(k<=newsize && it.hasNext()) {
//							LinkedHashMap<String, String> val = NewCorrespondingHashMaps.get(k); 
//							NewPopulation.put(k, val); 
//							Map.Entry pair = (Map.Entry)it.next();
//							System.out.println("FITNESS VAL===> "+Integer.parseInt(pair.getValue().toString()));
//							k++; 
//							
//						
//						}
//						
//						NewCorrespondingHashMaps= NewPopulation; 
//			}
//			
//		
//			
//			
//			int InitialPopSize = NewCorrespondingHashMaps.size(); 
//	for(int i=0; i<=InitialPopSize; i+=2) {
//		LinkedHashMap<String, String> DuplicatedHashMap1 = new LinkedHashMap<String, String>(); 
//		LinkedHashMap<String, String> DuplicatedHashMap2 = new LinkedHashMap<String, String>(); 
//		
//		LinkedHashMap<String, String> HashMap1 = NewCorrespondingHashMaps.get(i); 
//		LinkedHashMap<String, String> HashMap2 = NewCorrespondingHashMaps.get(i+1); 
//		//System.out.println(HashMap1);
//		//System.out.println(HashMap2);
//		int size1=HashMap1.size()/2; 
//		int size2=HashMap2.size()/2; 
//		int   k = 0; 
//		   Iterator<Entry<String, String>> it = HashMap1.entrySet().iterator();
//				while(k<size1 && it.hasNext()) {
//					Map.Entry pair = (Map.Entry)it.next();
//					DuplicatedHashMap1.put(pair.getKey().toString(), pair.getValue().toString()); 
//					k++; 
//				}
//				k=0; 
//				
//				
//				 it = HashMap2.entrySet().iterator();
//				while(k<size1 && it.hasNext()) {
//					Map.Entry pair = (Map.Entry)it.next();
//					k++; 
//				}
//				while(k<HashMap2.size() && it.hasNext()) {
//					Map.Entry pair = (Map.Entry)it.next();
//					DuplicatedHashMap1.put(pair.getKey().toString(), pair.getValue().toString()); 
//					k++; 
//				}
//				
//				
//				//System.out.println(DuplicatedHashMap1);
//				
//				
//				
//				
//				k=0; 
//				 it = HashMap2.entrySet().iterator();
//				while(k<size2 && it.hasNext()) {
//					Map.Entry pair = (Map.Entry)it.next();
//					DuplicatedHashMap2.put(pair.getKey().toString(), pair.getValue().toString()); 
//					k++; 
//				}
//				k=0; 
//				
//				
//				 it = HashMap1.entrySet().iterator();
//				while(k<size2 && it.hasNext()) {
//					Map.Entry pair = (Map.Entry)it.next();
//					k++; 
//				}
//				while(k<HashMap1.size() && it.hasNext()) {
//					Map.Entry pair = (Map.Entry)it.next();
//					DuplicatedHashMap2.put(pair.getKey().toString(), pair.getValue().toString()); 
//					k++; 
//				}
//				
//				//System.out.println(DuplicatedHashMap2);
//				int index =NewCorrespondingHashMaps.size(); 
//				NewCorrespondingHashMaps.put(index, DuplicatedHashMap1); 
//				NewCorrespondingHashMaps.put(index+1, DuplicatedHashMap2); 
//	}
//	//CorrespondingHashMapsList2=CorrespondingHashMapsList; 
//	Random rand = new Random();
//	int  n = rand.nextInt(2000) + 1;
//	int  n2 = rand.nextInt(1000) + 1;
//	boolean entered=false; 
//	
//	for(Integer elem: NewCorrespondingHashMaps.keySet()) {
//		//System.out.println("elem "+elem);
//		LinkedHashMap<String, String> value = NewCorrespondingHashMaps.get(elem); 
//		for(String item: value.keySet()) {
//			if(200<=n2 && n2<=500 && entered==false) {
//				//System.out.println("item  "+item);
//				//System.out.println(NewCorrespondingHashMaps);
//				if(value.get(item).equals("T")) {
//					value.put(item, "N"); 
//					NewCorrespondingHashMaps.put(elem, value); 
//					entered=true; 
//				}
//						
//			}
//		}
//	}
//	LinkedHashMap<Integer, Integer> fitnesshashmaps = new LinkedHashMap<Integer, Integer>(); 
//	int i=0; 
//
//		for(Integer key1: NewCorrespondingHashMaps.keySet()) {
//			LinkedHashMap<String, String> list = NewCorrespondingHashMaps.get(key1); 
//			int DiffCounter=0; 
//			for(String key: PredictionStandardHashMap.keySet()) {
//			if(list.get(key)!=null)
//			if(!PredictionStandardHashMap.get(key).equals(list.get(key))) {
//				
//				DiffCounter++; 
//				fitnesshashmaps.put(i, DiffCounter); 
//			}
//		}
//	  i++;   
//	}
//		System.out.println("yes");
//		
//		
//		
//		
//		
//
//
//		
//		 OrderedNameHashMap = new LinkedHashMap<Integer, LinkedHashMap<String, String>>(); 
//
//		
//		SortedFitnesses = BubbleSort(fitnesshashmaps, NewCorrespondingHashMaps, OrderedNameHashMap); 
//			
//			Collection<Integer> fitnessvalues = SortedFitnesses.values();
//			for(Integer val: fitnessvalues) {
//				if(val<=20) {
//					cond=true; 
//				}
//			}
//			
//			int z=0; 
//			for(Integer keyfitness: fitnessvalues) {
//			
//			
//				CorrespondingHashMapsList2.put(z, NewCorrespondingHashMaps.get(keyfitness)); 
//				z++; 
//			
//			}
//			CorrespondingHashMapsList2 = NewCorrespondingHashMaps; 
//			NewCorrespondingHashMaps= new LinkedHashMap<Integer, LinkedHashMap<String, String>>(); 
//			NewCorrespondingHashMaps=CorrespondingHashMapsList2; 
//			//CorrespondingHashMapsList = CorrespondingHashMapsList2; 
//			FirstIteration=false; 
//		}
		
        System.out.println("**************END**************");
		bw.close();
		bwlog3.close();
		bwlog2.close();
		bwlog.write(AllTClassLevelCallersClass.toString()); 
		bwlog.newLine();
		bwlog.close(); 

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


		bwGold2.write("TRACE PURE METHOD LEVEL ACROSS: "+PredictionCLASSTRACEMethodLevelPureGold2ACROSS.toString()); 
		bwGold2.newLine();
		bwGold2.write("TRACE MIXED METHOD LEVEL ACROSS: "+PredictionCLASSTRACEMethodLevelMixedGold2ACROSS.toString()); 
		bwGold2.newLine();
		bwGold2.write("NO TRACE PURE METHOD LEVEL ACROSS: "+PredictionCLASSNOTRACEMethodLevelPureGold2ACROSS.toString()); 
		bwGold2.newLine();
		bwGold2.write("NO TRACE MIXED METHOD LEVEL ACROSS: "+PredictionCLASSNOTRACEMethodLevelMixedGold2ACROSS.toString()); 
		bwGold2.newLine();
		bwGold2.write("TRACE PURE CLASS LEVEL ACROSS: "+PredictionCLASSTRACEClassLevelPureGold2ACROSS.toString()); 
		bwGold2.newLine();
		bwGold2.write("TRACE MIXED CLASS LEVEL ACROSS: "+PredictionCLASSTRACEClassLevelMixedGold2ACROSS.toString()); 
		bwGold2.newLine();
		bwGold2.write("NO TRACE PURE CLASS LEVEL ACROSS: "+PredictionCLASSNOTRACEClassLevelPureGold2ACROSS.toString()); 
		bwGold2.newLine();
		bwGold2.write("NO TRACE MIXED CLASS LEVEL ACROSS: "+PredictionCLASSNOTRACEClassLevelMixedGold2ACROSS.toString()); 
		bwGold2.newLine();
		bwGold2.close();
		
bw2.close();
bwGold2.close();

	
		 
		 
		    

		    
		
			
			 
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
//		table.getColumnModel().getColumn(48).setPreferredWidth(150);
//		table.getColumnModel().getColumn(49).setPreferredWidth(150);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//
//		table.setRowSelectionAllowed(true);
		
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



	




	public LinkedHashMap<Integer, LinkedHashMap<String, String>> introduceMutation(LinkedHashMap<Integer, LinkedHashMap<String, String>> orderedNameHashMap2) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int x = random.nextInt(orderedNameHashMap2.size()) + 0;
		LinkedHashMap<Integer, LinkedHashMap<String, String>> orderedNameHashMapCopy = orderedNameHashMap2; 
//		for(Integer key: orderedNameHashMap2.keySet()) {
//			LinkedHashMap<String, String> mylinkedhashmap = orderedNameHashMap2.get(key); 
//			for(String key2: mylinkedhashmap.keySet()) {
//				System.out.print(mylinkedhashmap.get(key2));
//			}
//			System.out.println(); 
//			System.out.println("-------");
//		}
		
		int z=0;
			for(Integer key: orderedNameHashMap2.keySet()) {
//				if(z==x) {
				int k=0;
					LinkedHashMap<String, String> mylinkedhashmap = orderedNameHashMap2.get(key); 
					for(String key2: mylinkedhashmap.keySet()) {
						int y = random.nextInt(mylinkedhashmap.size()) + 0;
					
						if(mylinkedhashmap.get(key2).equals("T") && k==y )  {
//							System.out.println(mylinkedhashmap.get(key2));
//							System.out.println("hey i am here N");
							mylinkedhashmap.put(key2, "N"); 
//							System.out.println(mylinkedhashmap.get(key2));
							
						}else if (mylinkedhashmap.get(key2).equals("N")&& k==y) {
//							System.out.println(mylinkedhashmap.get(key2));
//							System.out.println("hey i am here T");
							mylinkedhashmap.put(key2, "T"); 
							
//							System.out.println(mylinkedhashmap.get(key2));
						}				else if (
								(mylinkedhashmap.get(key2).equals("null")&& k==y) ||
								 (mylinkedhashmap.get(key2).equals("")&& k==y)||
								 (mylinkedhashmap.get(key2).equals("E")&& k==y)) {

//						System.out.println(mylinkedhashmap.get(key2));
//						System.out.println("hey i am here T");
						int num = random.nextInt(10) + 0;
						System.out.println(num);
						System.out.println("NUM=========  "+num);
						if(num<5) {
							mylinkedhashmap.put(key2, "T"); 
						}
						else if(num>=5) {
							mylinkedhashmap.put(key2, "N"); 
						}
						
//						System.out.println(mylinkedhashmap.get(key2));
					}
						k++;
					}
					orderedNameHashMap2.put(key, mylinkedhashmap); 
				}
//			for(Integer key: orderedNameHashMap2.keySet()) {
//				LinkedHashMap<String, String> mylinkedhashmap = orderedNameHashMap2.get(key); 
//				for(String key2: mylinkedhashmap.keySet()) {
//					System.out.print(mylinkedhashmap.get(key2));
//				}
//				System.out.println(); 
//				System.out.println("-------");
//			}
//				z++;
//			}
//			for(Integer key: orderedNameHashMap2.keySet()) {
//				LinkedHashMap<String, String> mylinkedhashmap = orderedNameHashMap2.get(key); 
//				for(String key2: mylinkedhashmap.keySet()) {
//					for(Integer key3: orderedNameHashMapCopy.keySet()) {
//						LinkedHashMap<String, String> mylinkedhashmap2 = orderedNameHashMapCopy.get(key3); 
//						for(String key4: mylinkedhashmap2.keySet()) {
//							if(mylinkedhashmap2.get(key4).equals(mylinkedhashmap.get(key2)) && key4.equals(key2) ) {
//								
//							}else if(key4.equals(key2)){
//								System.out.println("N000 "+mylinkedhashmap2.get(key4)+" "+mylinkedhashmap.get(key2)+ " "+key4+ "   "+key2);
//							}
//				}
//			}
//				}
//			}
	return orderedNameHashMap2;
	}

	public void ChangeKeys(LinkedHashMap<Integer, LinkedHashMap<String, String>> orderedNameHashMap,
			LinkedHashMap<Integer, Integer> sortedFitnesses, LinkedHashMap<Integer, LinkedHashMap<String, String>> orderedNameHashMap2, LinkedHashMap<Integer, Integer> sortedFitnesses2) {
		// TODO Auto-generated method stub
		
		List<LinkedHashMap<String, String>> mynewlist= new ArrayList<LinkedHashMap<String, String>>(); 
		List<Integer> mynewfitnesslist= new ArrayList<Integer>(); 

		for(LinkedHashMap<String, String> val: orderedNameHashMap.values()) {
			mynewlist.add(val); 
		}
		int k =0; 
		for(LinkedHashMap<String, String> val: mynewlist) {
			orderedNameHashMap2.put(k, val); 
			k++; 
		}
		
		
		
		for(Integer val: sortedFitnesses.values()) {
			mynewfitnesslist.add(val); 
		}
		 k =0; 
		for(Integer val: mynewfitnesslist) {
			sortedFitnesses2.put(k, val); 
			k++; 
		}
		System.out.println("finished");
	}

	public void ComputeFitnesses(LinkedHashMap<Integer, LinkedHashMap<String, String>> orderedNameHashMap,
			LinkedHashMap<Integer, Integer> newFitnesses) {
		// TODO Auto-generated method stub
		int OwnerValFitness=0; 
		int k=0; 
		int fitnessscore=0; 
		for(Integer key: orderedNameHashMap.keySet()) {
			LinkedHashMap<String, String> mychromosome = orderedNameHashMap.get(key); 
			fitnessscore=0; 
//			for(String chromosomekey: mychromosome.keySet()) {
//				System.out.println(key);
				for(String key2: PredictionStandardHashMap.keySet()) {
//					System.out.println(key2);

					if(!(mychromosome.get(key2).equals(PredictionStandardHashMap.get(key2)))
//						&&	 !mychromosome.get(key2).equals("null")
							&& (PredictionStandardHashMap.get(key2).equals("T") || PredictionStandardHashMap.get(key2).equals("N"))
							) {
//						System.out.println("---------------------");
//						System.out.println(PredictionStandardHashMap.get(key2));
//						System.out.println(mychromosome.get(key2));
						fitnessscore++; 
					}

				}
				//System.out.println("fitness score intriduce d");
				
//			}
			newFitnesses.put(k, fitnessscore); 
//			for(Integer myfitness: newFitnesses.keySet()) {
//				System.out.println("myftiness "+ myfitness+ newFitnesses.get(key));
//			}
			k++; 
			}
			
//		System.out.println("FITNESS VALUES ");
//		for(Integer key: newFitnesses.keySet()) {
//			System.out.println(key+ "  "+ newFitnesses.get(key));
//		}
//	
		
//		int MajorityClassLevelCallersClassGold2ValFitness=0;
//		int MajorityClassLevelCalleesClassGold2ValFitness=0;
//		int MajorityMethodLevelCallersClassGold2ValFitness=0;
//		int MajorityMethodLevelCalleesClassGold2ValFitness=0;
//		int AtLeastNPredictionClassLevelCallersClassGold2ValFitness=0;
//		int AtLeastNPredictionClassLevelCalleesClassGold2ValFitness=0;
//		int AtLeastNPredictionMethodLevelCallersClassGold2ValFitness= 0;
//		int AtLeastNPredictionMethodLevelCalleesClassGold2ValFitness=0;
//		int AtLeastTPredictionClassLevelCallersClassGold2ValFitness=0;
//		int AtLeastTPredictionClassLevelCalleesClassGold2ValFitness=0;
//		for(String key: PredictionStandardHashMap.keySet()) {
//			
//			String OwnerVal = OwnerClassPredictionClassGold2HashMap.get(key);
//			String MajorityClassLevelCallersClassGold2Val=MajorityClassLevelCallersClassGold2HashMap.get(key);
//			String MajorityClassLevelCalleesClassGold2Val=MajorityClassLevelCalleesClassGold2HashMap.get(key);
//			String MajorityMethodLevelCallersClassGold2Val=MajorityMethodLevelCallersClassGold2HashMap.get(key);
//			String MajorityMethodLevelCalleesClassGold2Val=MajorityMethodLevelCalleesClassGold2HashMap.get(key);
//			String AtLeastNPredictionClassLevelCallersClassGold2Val=AtLeastNPredictionClassLevelCallersClassGold2HashMap.get(key);
//			String AtLeastNPredictionClassLevelCalleesClassGold2Val=AtLeastNPredictionClassLevelCalleesClassGold2HashMap.get(key);
//			String AtLeastNPredictionMethodLevelCallersClassGold2Val= AtLeastNPredictionMethodLevelCallersClassGold2HashMap.get(key);
//			String AtLeastNPredictionMethodLevelCalleesClassGold2Val=AtLeastNPredictionMethodLevelCalleesClassGold2HashMap.get(key);
//			String AtLeastTPredictionClassLevelCallersClassGold2Val=AtLeastTPredictionClassLevelCallersClassGold2HashMap.get(key);
//			String AtLeastTPredictionClassLevelCalleesClassGold2Val=AtLeastTPredictionClassLevelCalleesClassGold2HashMap.get(key);
//  
//			String StandardVal= PredictionStandardHashMap.get(key); 
//		if(OwnerVal!=null)
//			if(!OwnerVal.equals(StandardVal)) {
//			
//				OwnerValFitness++; 
//			
//				
//				newFitnesses.put(0,OwnerValFitness ); 
//				newOrderedHashMap.put(0,OwnerClassPredictionClassGold2HashMap ); 
//
//			}
//		if(MajorityClassLevelCallersClassGold2Val!=null)
//			if(!MajorityClassLevelCallersClassGold2Val.equals(StandardVal)) {
//				MajorityClassLevelCallersClassGold2ValFitness++; 
//				
//				newFitnesses.put(1,MajorityClassLevelCallersClassGold2ValFitness ); 
//				newOrderedHashMap.put(1,MajorityClassLevelCallersClassGold2HashMap ); 
//			}
//		
//		
//		
//		
//		
//		
//		
//		if(MajorityClassLevelCalleesClassGold2Val!=null)
//			if(!MajorityClassLevelCalleesClassGold2Val.equals(StandardVal)) {
//				MajorityClassLevelCalleesClassGold2ValFitness++; 
//				
//				
//				newFitnesses.put(2,MajorityClassLevelCalleesClassGold2ValFitness ); 
//				newOrderedHashMap.put(2,MajorityClassLevelCalleesClassGold2HashMap ); 
//			}
//		if(MajorityMethodLevelCallersClassGold2Val!=null)
//			if(!MajorityMethodLevelCallersClassGold2Val.equals(StandardVal)) {
//				MajorityMethodLevelCallersClassGold2ValFitness++; 	
//			
//				
//				
//				newFitnesses.put(3,MajorityMethodLevelCallersClassGold2ValFitness ); 
//				newOrderedHashMap.put(3,MajorityMethodLevelCallersClassGold2HashMap ); 	
//			
//			
//			}
//		if(MajorityMethodLevelCalleesClassGold2Val!=null)
//			if(!MajorityMethodLevelCalleesClassGold2Val.equals(StandardVal)) {
//				MajorityMethodLevelCalleesClassGold2ValFitness++; 
//				
//				
//				newFitnesses.put(4,MajorityMethodLevelCalleesClassGold2ValFitness ); 
//				newOrderedHashMap.put(4,MajorityMethodLevelCalleesClassGold2HashMap ); 	
//			}
//		if(AtLeastNPredictionClassLevelCallersClassGold2Val!=null)
//			if(!AtLeastNPredictionClassLevelCallersClassGold2Val.equals(StandardVal)) {
//				AtLeastNPredictionClassLevelCallersClassGold2ValFitness++; 
//				
//				
//				newFitnesses.put(5,AtLeastNPredictionClassLevelCallersClassGold2ValFitness ); 
//				newOrderedHashMap.put(5,AtLeastNPredictionClassLevelCallersClassGold2HashMap ); 	
//			}
////			System.out.println(AtLeastNPredictionClassLevelCalleesClassGold2Val);
//			if(AtLeastNPredictionClassLevelCalleesClassGold2Val!=null)
//			if(!AtLeastNPredictionClassLevelCalleesClassGold2Val.equals(StandardVal)) {
//				AtLeastNPredictionClassLevelCalleesClassGold2ValFitness++; 
//				
//			
//				newFitnesses.put(6,AtLeastNPredictionClassLevelCalleesClassGold2ValFitness ); 
//				newOrderedHashMap.put(6,AtLeastNPredictionClassLevelCalleesClassGold2HashMap ); 	
//			}
//			if(AtLeastNPredictionMethodLevelCallersClassGold2Val!=null)
//			if(!AtLeastNPredictionMethodLevelCallersClassGold2Val.equals(StandardVal)) {
//				AtLeastNPredictionMethodLevelCallersClassGold2ValFitness++; 
//			
//				
//				newFitnesses.put(7,AtLeastNPredictionMethodLevelCallersClassGold2ValFitness ); 
//				newOrderedHashMap.put(7,AtLeastNPredictionMethodLevelCallersClassGold2HashMap ); 	
//				}
//			if(AtLeastNPredictionMethodLevelCalleesClassGold2Val!=null)
//			if(!AtLeastNPredictionMethodLevelCalleesClassGold2Val.equals(StandardVal)) {
//				AtLeastNPredictionMethodLevelCalleesClassGold2ValFitness++; 
//				
//			
//				newFitnesses.put(8,AtLeastNPredictionMethodLevelCalleesClassGold2ValFitness ); 
//				newOrderedHashMap.put(8,AtLeastNPredictionMethodLevelCalleesClassGold2HashMap ); 	
//			
//			}
//			if(AtLeastTPredictionClassLevelCallersClassGold2Val!=null)
//			if(!AtLeastTPredictionClassLevelCallersClassGold2Val.equals(StandardVal)) {
//				AtLeastTPredictionClassLevelCallersClassGold2ValFitness++; 
//			
//				
//				newFitnesses.put(9,AtLeastTPredictionClassLevelCallersClassGold2ValFitness ); 
//				newOrderedHashMap.put(9,AtLeastTPredictionClassLevelCallersClassGold2HashMap ); 	
//			}
//			if(AtLeastTPredictionClassLevelCalleesClassGold2Val!=null)
//			if(!AtLeastTPredictionClassLevelCalleesClassGold2Val.equals(StandardVal)) {
//				AtLeastTPredictionClassLevelCalleesClassGold2ValFitness++; 
//			
//			
//				newFitnesses.put(10,AtLeastTPredictionClassLevelCalleesClassGold2ValFitness ); 
//				newOrderedHashMap.put(10,AtLeastTPredictionClassLevelCalleesClassGold2HashMap ); 	
//			}
//	        
//		}
	}

	public LinkedHashMap<Integer, LinkedHashMap<String, String>> TestPurposes() {
		// TODO Auto-generated method stub
		LinkedHashMap<Integer, LinkedHashMap<String, String>> linkedhashmap = new LinkedHashMap<Integer, LinkedHashMap<String, String>>(); 
		LinkedHashMap<String, String> mylist1 = new LinkedHashMap<String, String>(); 
		mylist1.put("0", "1"); 
		mylist1.put("1", "8"); 
		mylist1.put("2", "7"); 
		mylist1.put("3", "9"); 
		
		LinkedHashMap<String, String> mylist2 = new LinkedHashMap<String, String>(); 
		mylist2.put("0", "hi"); 
		mylist2.put("1", "kk"); 
		mylist2.put("2", "sdjh"); 
		mylist2.put("3", "asdjhasd"); 
		LinkedHashMap<String, String> mylist3 = new LinkedHashMap<String, String>(); 
		mylist3.put("0", "dhjhmf"); 
		mylist3.put("1", "LL"); 
		mylist3.put("2", "MM"); 
		mylist3.put("3", "PP"); 
		LinkedHashMap<String, String> mylist4 = new LinkedHashMap<String, String>(); 
		mylist4.put("0", "OO"); 
		mylist4.put("1", "QQ"); 
		mylist4.put("2", "YY"); 
		mylist4.put("3", "II"); 
		linkedhashmap.put(0, mylist1); 
		linkedhashmap.put(1, mylist2); 
		linkedhashmap.put(2, mylist3); 
		linkedhashmap.put(3, mylist4); 
		return linkedhashmap; 
	}

	public void DoublePopulationCrossover(LinkedHashMap<Integer, LinkedHashMap<String, String>> linkedhashmap) {
		// TODO Auto-generated method stub
		int InitialPopSize = linkedhashmap.size(); 
		Set<Integer> keys = linkedhashmap.keySet(); 
		Integer[] myarr= new Integer[keys.size()]; 
		 myarr = keys.toArray(myarr); 
		 System.out.println("BEFORE CROSSOVER*************************** "+myarr.length);
//			Set<Integer> mykeystest = linkedhashmap.keySet(); 
//			 for(Integer mykey: mykeystest) {
//				 LinkedHashMap<String, String> myval = linkedhashmap.get(mykey);
//				 
//				 
//				 for(String mykey2: myval.keySet()) {
//					 System.out.println(mykey2+"   "+ myval.get(mykey2));
//				 }
//				 System.out.println("----------------");
//			 }
			 System.out.println();
for(int i=0; i<InitialPopSize; i+=2) {
	LinkedHashMap<String, String> DuplicatedHashMap1 = new LinkedHashMap<String, String>(); 
	LinkedHashMap<String, String> DuplicatedHashMap2 = new LinkedHashMap<String, String>(); 
//	System.out.println("myarr[i] "+myarr[i]);
//	System.out.println("myarr[i+1] "+myarr[i+1]);
	 if(i+1<myarr.length) {
		 LinkedHashMap<String, String> HashMap1 = linkedhashmap.get(myarr[i]); 
			LinkedHashMap<String, String> HashMap2 = linkedhashmap.get(myarr[i+1]); 
			//System.out.println(HashMap1);
			//System.out.println(HashMap2);
			int size1=HashMap1.size()/2; 
			int size2=HashMap2.size()/2; 
			int totalsize1=HashMap1.size(); 
			int totalsize2=HashMap2.size(); 
			Random r = new Random();
			int Low = 0;
			int High = totalsize1;
			int random1 = r.nextInt(High-Low) + Low;
			int Low2 = 0;
			int High2 = totalsize2;
			int random2 = r.nextInt(High2-Low2) + Low2;
//			System.out.println("RANDOM 1 "+random1);
//			System.out.println("RANDOM 2 "+random2);

			int   k = 0; 
			   Iterator<Entry<String, String>> it = HashMap1.entrySet().iterator();
			   Iterator<Entry<String, String>> it2 = HashMap2.entrySet().iterator();
			   Iterator<Entry<String, String>> itSecondChromosome = HashMap1.entrySet().iterator();
			   Iterator<Entry<String, String>> itSecondChromosome2 = HashMap2.entrySet().iterator();
					while(k<random1 && it.hasNext()) {
						Map.Entry pair = (Map.Entry)it.next();
						DuplicatedHashMap1.put(pair.getKey().toString(), pair.getValue().toString()); 
						k++; 
					}
					k=0; 
					
					
					while(k<random1 && it2.hasNext()) {
						Map.Entry pair = (Map.Entry)it2.next();
						k++; 
					}
					while(k<HashMap2.size() && it2.hasNext()) {
						Map.Entry pair = (Map.Entry)it2.next();
						DuplicatedHashMap1.put(pair.getKey().toString(), pair.getValue().toString()); 
						k++; 
					}
					
					
					//System.out.println(DuplicatedHashMap1);
					
					
					
					
					
					
					
					
					
					
					
					
					k=0; 
					while(k<random1 && itSecondChromosome2.hasNext()) {
						Map.Entry pair = (Map.Entry)itSecondChromosome2.next();
						DuplicatedHashMap2.put(pair.getKey().toString(), pair.getValue().toString()); 
						k++; 
					}
					k=0; 
					Iterator<Entry<String, String>> itSecondChromosomeNEW1 = HashMap1.entrySet().iterator();
					
					while(k<random1 && itSecondChromosomeNEW1.hasNext()) {
						Map.Entry pair = (Map.Entry)itSecondChromosomeNEW1.next();
						k++; 
					}
					while(k<HashMap1.size() && itSecondChromosomeNEW1.hasNext()) {
						Map.Entry pair = (Map.Entry)itSecondChromosomeNEW1.next();
						DuplicatedHashMap2.put(pair.getKey().toString(), pair.getValue().toString()); 
						k++; 
					}
					
					
					
					
				
					
					//System.out.println(DuplicatedHashMap2);
					int index =linkedhashmap.size(); 
					linkedhashmap.put(index, DuplicatedHashMap1); 
					linkedhashmap.put(index+1, DuplicatedHashMap2); 
	 }
	
	
} System.out.println("AFTER CROSSOVER***************************");
//mykeystest = linkedhashmap.keySet(); 
//for(Integer mykey: mykeystest) {
//	 LinkedHashMap<String, String> myval = linkedhashmap.get(mykey);
//	 
//	 
//	 for(String mykey2: myval.keySet()) {
//		 System.out.println(mykey2+"   "+ myval.get(mykey2));
//	 }
//	 System.out.println("----------------");
//}
//System.out.println();
	}

	public void SelectFittestHalf(LinkedHashMap<Integer, LinkedHashMap<String, String>> orderedNameHashMap,
			LinkedHashMap<Integer, Integer> sortedFitnesses) {
		// TODO Auto-generated method stub
		int NewSize=orderedNameHashMap.size()/2; 
		int k=0; 
		Iterator<Integer> it = orderedNameHashMap.keySet().iterator();
		Iterator<Integer> itFitness = sortedFitnesses.keySet().iterator();
//		  for (Integer orderedkey : orderedNameHashMap.keySet()) {
//			  System.out.println(orderedkey+ "  "+orderedNameHashMap.get(orderedkey));
//		    }
//		  for (Integer key : sortedFitnesses.keySet()) {
//			  System.out.println(key+ "  "+sortedFitnesses.get(key));
//		    }
//		  System.out.println("SDFSDFSDFSDFSDFSDFSDFSDFSDFSDFSDFSDFSDF");
boolean entered=false; 
	int ITERATION=0; 
//		while (it.hasNext()) {
//			 if (k<NewSize) {
//			    	k++; 
//			    	it.next();
//			    	itFitness.next(); 
//			    }
//			      
//			 else{
//			
//				 entered=true; 
//				 it.remove();
//				   
//				  itFitness.remove();
//				it.next();
//				
//			    itFitness.next(); 
////			    for (Integer orderedkey : orderedNameHashMap.keySet()) {
////					  System.out.println(orderedkey+ "  "+orderedNameHashMap.get(orderedkey));
////				    }
////			    for (Integer key : sortedFitnesses.keySet()) {
////					  System.out.println(key+ "  "+sortedFitnesses.get(key));
////				    }
//			}
////			 System.out.println("ITERATION "+ITERATION);
//			 ITERATION++; 
//		}
		k=0; 
		List<Integer> keysToRemove= new ArrayList<Integer>(); 
		for(Integer key: orderedNameHashMap.keySet()) {
			if(k<NewSize) {
				k++; 
			}else {
				keysToRemove.add(key); 
			}
		}
		
		for(Integer mykey: keysToRemove) {
			orderedNameHashMap.remove(mykey); 
			sortedFitnesses.remove(mykey); 
		}
		
		
	}

	private LinkedHashMap<Integer, Integer> BubbleSort(HashMap<Integer, Integer> fitnesshashmaps,
			HashMap<Integer, LinkedHashMap<String, String>> correspondingHashMapsList, LinkedHashMap<Integer, LinkedHashMap<String, String>> orderedNameHashMap, LinkedHashMap<Integer, Integer> fitnessHashMapSorted) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, LinkedHashMap<String, String>> fitnessListFinal = new LinkedHashMap<String, LinkedHashMap<String, String>>(); 
		 int n = fitnesshashmaps.size(); 
		 boolean swapped=false; 
		 LinkedHashMap<Integer, Integer > mymapping = new  LinkedHashMap<Integer, Integer >(); 
		 LinkedHashMap<Integer, Integer > mymappingOdered = new  LinkedHashMap<Integer, Integer >(); 

		 List<Integer> keyList = new ArrayList<Integer>(fitnesshashmaps.keySet());
		 List<Integer> fitnessIntList = new ArrayList<Integer>(); 
		 List<Integer> fitnessIntListKey = new ArrayList<Integer>(); 
		 List<Integer> fitnessIntListVal = new ArrayList<Integer>(); 
		List<LinkedHashMap<String, String>> NeworderedNameHashMap= new ArrayList< LinkedHashMap<String, String>>(); 
		 for(Integer key: keyList) {
			 fitnessIntList.add(fitnesshashmaps.get(key)); 
			 fitnessIntListVal.add(fitnesshashmaps.get(key)); 
			 fitnessIntListKey.add(key); 
			 NeworderedNameHashMap.add(correspondingHashMapsList.get(key)); 
		 }

		 Collections.sort(fitnessIntList);
//		 for(Integer key: fitnessIntList){
//			 System.out.println(key+" my key ");
//		 }
//		 for(int i=0; i<fitnessIntList.size();i++ )
//	        {
////	            System.out.println(fitnessIntList.get(i));
//	            mymappingOdered.put(mymapping.get(fitnessIntList.get(i)), fitnessIntList.get(i)); 
//				 orderedNameHashMap.put(mymapping.get(fitnessIntList.get(i)), correspondingHashMapsList.get(mymapping.get(fitnessIntList.get(i)))); 
//
//	        }
		int K=0; 
		 for(int i=0; i<fitnessIntList.size();i++ )
	        {
	           for(int j=0; j<fitnessIntListVal.size(); j++) {
	        	   if(fitnessIntList.get(i).equals(fitnessIntListVal.get(j))) {
	        		   fitnessHashMapSorted.put(K, fitnessIntListVal.get(j)); 
	        		   orderedNameHashMap.put(K, NeworderedNameHashMap.get(j)); 
	        		   fitnessIntListVal.remove(j); 
	        		  // fitnessIntList.remove(i); 
	        		   NeworderedNameHashMap.remove(j); 
	        		   K++; 
	        	   }
	           }

	        } 
		 
//		 for(Integer key: orderedNameHashMap.keySet()){
//			 System.out.println(key+"ORDERED HASHMAP "+ orderedNameHashMap.get(key));
//		 }
//		 for(Integer key: fitnessHashMapSorted.keySet()){
//			 System.out.println(key+" FITNESS"+ fitnessHashMapSorted.get(key));
//		 }

	return mymappingOdered; 
	}



	private LinkedHashMap<String, LinkedHashMap<String, String>> BubbleSort(LinkedHashMap<HashMapValue, LinkedHashMap<String, String>> fitnessList) {
		// TODO Auto-generated method stub
		
		LinkedHashMap<String, LinkedHashMap<String, String>> fitnessListFinal = new LinkedHashMap<String, LinkedHashMap<String, String>>(); 
		 int n = fitnessList.size(); 
		 boolean swapped=false; 
		 LinkedHashMap<Integer, String > mymapping = new  LinkedHashMap<Integer, String >(); 
		 LinkedHashMap<String, Integer > mymappingOdered = new  LinkedHashMap<String, Integer >(); 

		 List<HashMapValue> valueList = new ArrayList<HashMapValue>(fitnessList.keySet());
		 List<Integer> fitnessIntList = new ArrayList<Integer>(); 
		 for(HashMapValue myvalint: valueList) {
			 fitnessIntList.add(myvalint.Fitness); 
			 mymapping.put(myvalint.Fitness, myvalint.HashMapName); 
		 }

		 Collections.sort(fitnessIntList);
		 
		 for(int i=0; i<fitnessIntList.size();i++ )
	        {
	      //      System.out.println(fitnessIntList.get(i));
	            mymappingOdered.put(mymapping.get(fitnessIntList.get(i)), fitnessIntList.get(i)); 
	        }
		 
		 
		 
		 for(String key: mymappingOdered.keySet() )
	        {
	     //       System.out.println(mymappingOdered.get(key)+"    "+key );
	            HashMapValue hashmapval = new HashMapValue(key, mymappingOdered.get(key)); 
	            fitnessListFinal.put(key, fitnessList.get(hashmapval)); 
	        }
	
	return fitnessListFinal; 
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

		TracesTableChessFINALGeneticAlgorithm frame = new TracesTableChessFINALGeneticAlgorithm();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
//	 public static HashMap<String, Integer> sortByValue(HashMap<LinkedHashMap<String, String>, Integer> fitnessList) 
//	    { 
//	        // Create a list from elements of HashMap 
//	        List<Map.Entry<String, Integer> > list = 
//	               new LinkedList<Map.Entry<String, Integer> >((Collection<? extends Entry<String, Integer>>) fitnessList.entrySet()); 
//	  
//	        // Sort the list 
//	        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
//	            public int compare(Map.Entry<String, Integer> o1,  
//	                               Map.Entry<String, Integer> o2) 
//	            { 
//	                return (o1.getValue()).compareTo(o2.getValue()); 
//	            } 
//	        }); 
//	          
//	        // put data from sorted list to hashmap  
//	        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
//	        for (Map.Entry<String, Integer> aa : list) { 
//	            temp.put(aa.getKey(), aa.getValue()); 
//	        } 
//	        return temp; 
//	    } 
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


