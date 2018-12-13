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
import java.lang.reflect.Method;
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
import mypackage.Clazz;
import mypackage.ClassTrace2;
import mypackage.ColumnGroup;
import mypackage.GroupableTableHeader;
import mypackage.Interface2;
import mypackage.Method2Details;
import mypackage.Method;
import mypackage.MethodTrace2;
import mypackage.MethodTraceSubjectTSubjectNOriginal;
import mypackage.MethodTraceSubjectTSubjectNOriginal;
import mypackage.Parameter2;
import mypackage.Requirement2;
import mypackage.RequirementClass;
import mypackage.RequirementGold;

public class TracesTableGantt2FINALReq10 extends JFrame {

	

	

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
	
	
	
	int Gold3=95; 
	int OwnerClassTGOLD3=96; 
	int OwnerClassNGOLD3=97; 
	int OwnerClassEGOLD3=98; 
	int CallerMethodsNumberGOLD3=99; 
	int CallerMethodsTGOLD3=100; 
	int CallerMethodsNGOLD3=101; 
	int CallerMethodsEGOLD3=102; 
	int CallerClassesNumberGOLD3=103; 
	int CallerClassesTGOLD3=104; 
	int CallerClassesNGOLD3=105; 
	int CallerClassesEGOLD3=106; 
	int CalleeMethodsNumberGOLD3=107; 
	int CalleeMethodsTGOLD3=108; 
	int CalleeMethodsNGOLD3=109; 
	int CalleeMethodsEGOLD3=110; 
	int CalleeClassesNumberGOLD3=111; 
	int CalleeClassesTGOLD3=112; 
	int CalleeClassesNGOLD3=113; 
	int CalleeClassesEGOLD3=114; 
	int OwnerClassPredictionGOLD3=115; 
	int MajorityClassLevelCalleesGOLD3=116; 
	int MajorityClassLevelCallersGOLD3=117; 
	int MajorityMethodLevelCalleesGOLD3=118; 
	int MajorityMethodLevelCallersGOLD3=119; 
	int AtLeast1NPredictionClassLevelCalleesGOLD3=120; 
	int AtLeast1NPredictionClassLevelCallersGOLD3=121; 
	int AtLeast1NPredictionMethodLevelCalleesGOLD3=122; 
	int AtLeast1NPredictionMethodLevelCallersGOLD3=123; 
	int AtLeast1TPredictionClassLevelCalleesGOLD3=124; 
	int AtLeast1TPredictionClassLevelCallersGOLD3=125; 
	int AtLeast1TPredictionMethodLevelCalleesGOLD3=126; 
	int AtLeast1TPredictionMethodLevelCallersGOLD3=127; 
	int AtLeast2NPredictionClassLevelCalleesGOLD3=128; 
	int AtLeast2NPredictionClassLevelCallersGOLD3=129; 
	int AtLeast2NPredictionMethodLevelCalleesGOLD3=130; 
	int AtLeast2NPredictionMethodLevelCallersGOLD3=131; 
	int AtLeast2TPredictionClassLevelCalleesGOLD3=132; 
	int AtLeast2TPredictionClassLevelCallersGOLD3=133; 
	int AtLeast2TPredictionMethodLevelCalleesGOLD3=134; 
	int AtLeast2TPredictionMethodLevelCallersGOLD3=135; 
	int AllNClassLevelCalleesGOLD3=136; 
	int AllNClassLevelCallersGOLD3=137; 
	int AllNMethodLevelCalleesGOLD3=138; 
	int AllNMethodLevelCallersGOLD3=139; 
	int AllTClassLevelCalleesGOLD3=140; 
	int AllTClassLevelCallersGOLD3=141; 
	int AllTMethodLevelCalleesGOLD3=142; 
	int AllTMethodLevelCallersGOLD3=143; 
	int CallersGOLD3=144; 
	int CalleesGOLD3=145; 
	int paramatersNumberGOLD3=146; 
	int CountParamaterTGOLD3=147; 
	int CountParamaterNGOLD3=148; 
	int CountParamaterEGOLD3=149; 
	int MajorityParametersGOLD3=150; 
	int AtLeast1NParameterGOLD3=151; 
	int AtLeast1TParameterGOLD3=152; 
	int AtLeast2TParameterGOLD3=153; 
	int AtLeast2NParameterGOLD3=154; 
	int AllNParametersGOLD3=155; 
	int AllTParametersGOLD3=156; 
	int ACHRAFTRACEPureGOLD3=157; 
	int ACHRAFTRACEMixedGOLD3=158; 
	int ACHRAFNOTRACEPureGOLD3=159; 
	int ACHRAFNOTRACEMixedGOLD3=160; 
	int AllNMethodLevelCallersCalleesGOLD3=161; 
	int AllTMethodLevelCallersCalleesGOLD3=162; 
	int AllTClassLevelCallersCalleesGOLD3=163; 
	int AllNClassLevelCallersCalleesGOLD3=164; 
	int AllNClassLevelCalleesAtLeast2NGOLD3=165; 
	int AllNClassLevelCallersAtLeast2NGOLD3=166; 
	int AllNMethodLevelCalleesAtLeast2NGOLD3=167; 
	int AllNMethodLevelCallersAtLeast2NGOLD3=168; 
	int AllTClassLevelCalleesAtLeast2TGOLD3=169; 
	int AllTClassLevelCallersAtLeast2TGOLD3=170; 
	int AllTMethodLevelCalleesAtLeast2TGOLD3=171; 
	int AllTMethodLevelCallersAtLeast2TGOLD3=172; 
	int CLASSTRACEMethodLevelPureGold3=173; 
	int CLASSTRACEMethodLevelMixedGold3=174; 
	int CLASSNOTRACEMethodLevelPureGold3=175; 
	int CLASSNOTRACEMethodLevelMixedGold3=176;
	int CLASSTRACEClassLevelPureGold3=177; 
	int CLASSTRACEClassLevelMixedGold3=178; 
	int CLASSNOTRACEClassLevelPureGold3=179; 
	int CLASSNOTRACEClassLevelMixedGold3=180;
	
	
	int Gold4=181; 
	int OwnerClassTGOLD4=182; 
	int OwnerClassNGOLD4=183; 
	int OwnerClassEGOLD4=184; 
	int CallerMethodsNumberGOLD4=185; 
	int CallerMethodsTGOLD4=186; 
	int CallerMethodsNGOLD4=187; 
	int CallerMethodsEGOLD4=188; 
	int CallerClassesNumberGOLD4=189; 
	int CallerClassesTGOLD4=190; 
	int CallerClassesNGOLD4=191; 
	int CallerClassesEGOLD4=192; 
	int CalleeMethodsNumberGOLD4=193; 
	int CalleeMethodsTGOLD4=194; 
	int CalleeMethodsNGOLD4=195; 
	int CalleeMethodsEGOLD4=196; 
	int CalleeClassesNumberGOLD4=197; 
	int CalleeClassesTGOLD4=198; 
	int CalleeClassesNGOLD4=199; 
	int CalleeClassesEGOLD4=200; 
	int OwnerClassPredictionGOLD4=201; 
	int MajorityClassLevelCalleesGOLD4=202; 
	int MajorityClassLevelCallersGOLD4=203; 
	int MajorityMethodLevelCalleesGOLD4=204; 
	int MajorityMethodLevelCallersGOLD4=205; 
	int AtLeast1NPredictionClassLevelCalleesGOLD4=206; 
	int AtLeast1NPredictionClassLevelCallersGOLD4=207; 
	int AtLeast1NPredictionMethodLevelCalleesGOLD4=208; 
	int AtLeast1NPredictionMethodLevelCallersGOLD4=209; 
	int AtLeast1TPredictionClassLevelCalleesGOLD4=210; 
	int AtLeast1TPredictionClassLevelCallersGOLD4=211; 
	int AtLeast1TPredictionMethodLevelCalleesGOLD4=212; 
	int AtLeast1TPredictionMethodLevelCallersGOLD4=213; 
	int AtLeast2NPredictionClassLevelCalleesGOLD4=214; 
	int AtLeast2NPredictionClassLevelCallersGOLD4=215; 
	int AtLeast2NPredictionMethodLevelCalleesGOLD4=216; 
	int AtLeast2NPredictionMethodLevelCallersGOLD4=217; 
	int AtLeast2TPredictionClassLevelCalleesGOLD4=218; 
	int AtLeast2TPredictionClassLevelCallersGOLD4=219; 
	int AtLeast2TPredictionMethodLevelCalleesGOLD4=220; 
	int AtLeast2TPredictionMethodLevelCallersGOLD4=221; 
	int AllNClassLevelCalleesGOLD4=222; 
	int AllNClassLevelCallersGOLD4=223; 
	int AllNMethodLevelCalleesGOLD4=224; 
	int AllNMethodLevelCallersGOLD4=225; 
	int AllTClassLevelCalleesGOLD4=226; 
	int AllTClassLevelCallersGOLD4=227; 
	int AllTMethodLevelCalleesGOLD4=228; 
	int AllTMethodLevelCallersGOLD4=229; 
	int CallersGOLD4=230; 
	int CalleesGOLD4=231; 
	int paramatersNumberGOLD4=232; 
	int CountParamaterTGOLD4=233; 
	int CountParamaterNGOLD4=234; 
	int CountParamaterEGOLD4=235; 
	int MajorityParametersGOLD4=236; 
	int AtLeast1NParameterGOLD4=237; 
	int AtLeast1TParameterGOLD4=238; 
	int AtLeast2TParameterGOLD4=239; 
	int AtLeast2NParameterGOLD4=240; 
	int AllNParametersGOLD4=241; 
	int AllTParametersGOLD4=242; 
	int ACHRAFTRACEPureGOLD4=243; 
	int ACHRAFTRACEMixedGOLD4=244; 
	int ACHRAFNOTRACEPureGOLD4=245; 
	int ACHRAFNOTRACEMixedGOLD4=246; 
	int AllNMethodLevelCallersCalleesGOLD4=247; 
	int AllTMethodLevelCallersCalleesGOLD4=248; 
	int AllTClassLevelCallersCalleesGOLD4=249; 
	int AllNClassLevelCallersCalleesGOLD4=250; 
	int AllNClassLevelCalleesAtLeast2NGOLD4=251; 
	int AllNClassLevelCallersAtLeast2NGOLD4=252; 
	int AllNMethodLevelCalleesAtLeast2NGOLD4=253; 
	int AllNMethodLevelCallersAtLeast2NGOLD4=254; 
	int AllTClassLevelCalleesAtLeast2TGOLD4=255; 
	int AllTClassLevelCallersAtLeast2TGOLD4=256; 
	int AllTMethodLevelCalleesAtLeast2TGOLD4=257; 
	int AllTMethodLevelCallersAtLeast2TGOLD4=258; 
	int CLASSTRACEMethodLevelPureGold4=259; 
	int CLASSTRACEMethodLevelMixedGold4=260; 
	int CLASSNOTRACEMethodLevelPureGold4=261; 
	int CLASSNOTRACEMethodLevelMixedGold4=262;
	int CLASSTRACEClassLevelPureGold4=263; 
	int CLASSTRACEClassLevelMixedGold4=264; 
	int CLASSNOTRACEClassLevelPureGold4=265; 
	int CLASSNOTRACEClassLevelMixedGold4=266;
	
	
	
	int counterFN=0; 
	double TracePureGold=0; 
	double NoTracePureGold=0; 
	double TraceMixedGold=0; 
	double NoTraceMixedGold=0; 
	
	double TracePureGoldTotal=0; 
	double NoTracePureGoldTotal=0; 
	double TraceMixedGoldTotal=0; 
	double NoTraceMixedGoldTotal=0; 
	
	double TracePureGold3=0; 
	double NoTracePureGold3=0; 
	double TraceMixedGold3=0; 
	double NoTraceMixedGold3=0; 
	
	
	double TracePureGold4=0; 
	double NoTracePureGold4=0; 
	double TraceMixedGold4=0; 
	double NoTraceMixedGold4=0; 
	
	double failGold=0; 
	double failGold3=0; 
	double failGold4=0; 
	double TraceCountTotal=0; 
	double NoTraceCountTotal=0; 
	double TraceCountTotalGold3=0; 
	double NoTraceCountTotalGold3=0; 
	double TraceCountTotalGold4=0; 
	double NoTraceCountTotalGold4=0; 
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
	PredictionEvaluation ACHRAFTracePureGold3= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFTraceMixedGold3= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTracePureGold3= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTraceMixedGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCallersCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCallersCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersCalleesClassGold3= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFGold3Trace= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFGold3NOTrace= new PredictionEvaluation(); 
	PredictionEvaluation PureNCallersGold3= new PredictionEvaluation(); 
	PredictionEvaluation PureTCallersGold3= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCalleesClassAtLeast2NGold3=new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersClassAtLeast2NGold3=new PredictionEvaluation();  
	PredictionEvaluation AllNMethodLevelCalleesClassAtLeast2NGold3=new PredictionEvaluation();  
	PredictionEvaluation AllNMethodLevelCallersClassAtLeast2NGold3=new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCalleesClassAtLeast2TGold3=new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersClassAtLeast2TGold3=new PredictionEvaluation();  
	PredictionEvaluation AllTMethodLevelCalleesClassAtLeast2TGold3=new PredictionEvaluation();  
	PredictionEvaluation AllTMethodLevelCallersClassAtLeast2TGold3=new PredictionEvaluation(); 
	PredictionEvaluation PredictionCLASSTRACEMethodLevelPureGold3=new PredictionEvaluation(); 
	PredictionEvaluation PredictionCLASSTRACEMethodLevelMixedGold3=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelPureGold3=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelMixedGold3=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSTRACEClassLevelPureGold3=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSTRACEClassLevelMixedGold3=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelPureGold3=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelMixedGold3=new PredictionEvaluation();  
	
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
	PredictionEvaluation ACHRAFTracePureGold4= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFTraceMixedGold4= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTracePureGold4= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTraceMixedGold4= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCallersCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCallersCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersCalleesClassGold4= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFGold4Trace= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFGold4NOTrace= new PredictionEvaluation(); 
	PredictionEvaluation PureNCallersGold4= new PredictionEvaluation(); 
	PredictionEvaluation PureTCallersGold4= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCalleesClassAtLeast2NGold4=new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersClassAtLeast2NGold4=new PredictionEvaluation();  
	PredictionEvaluation AllNMethodLevelCalleesClassAtLeast2NGold4=new PredictionEvaluation();  
	PredictionEvaluation AllNMethodLevelCallersClassAtLeast2NGold4=new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCalleesClassAtLeast2TGold4=new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersClassAtLeast2TGold4=new PredictionEvaluation();  
	PredictionEvaluation AllTMethodLevelCalleesClassAtLeast2TGold4=new PredictionEvaluation();  
	PredictionEvaluation AllTMethodLevelCallersClassAtLeast2TGold4=new PredictionEvaluation(); 	
	PredictionEvaluation PredictionCLASSTRACEMethodLevelPureGold4=new PredictionEvaluation(); 
	PredictionEvaluation PredictionCLASSTRACEMethodLevelMixedGold4=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelPureGold4=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelMixedGold4=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSTRACEClassLevelPureGold4=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSTRACEClassLevelMixedGold4=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelPureGold4=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelMixedGold4=new PredictionEvaluation();  	 
		
		
		
		
		
		
		
		
		
		
		ClassTrace2 myclasstrace = new ClassTrace2();
	static List<MethodTraceSubjectTSubjectNOriginal> methodtraces2 = new ArrayList<MethodTraceSubjectTSubjectNOriginal>();
	static List<ClassTrace2> classtraces2 = new ArrayList<ClassTrace2>();
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass = new  LinkedHashMap<String, ClassTrace2>(); 
	JTable table = new JTable(); 
	static List<Method2Details> methodlist = new ArrayList<Method2Details>();
	//File fout = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\GanttFiles\\TableLog.txt");
	File fout = new File("C:\\Users\\mouna\\dumps\\GANTT_REQUIREMENTS_SEPARATED\\TableLogGanttReq10.txt");
	FileOutputStream fos = new FileOutputStream(fout);
	
	//File fout2 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\GanttFiles\\PredictionEvaluation.txt");
	File fout2 = new File("C:\\Users\\mouna\\dumps\\GANTT_REQUIREMENTS_SEPARATED\\\\PredictionEvaluationGANTTReq10.txt");
	FileOutputStream fos2 = new FileOutputStream(fout2);
	
	//File fout3 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\GanttFiles\\PredictionEvaluationGold3.txt");
	File fout3 = new File("C:\\Users\\mouna\\dumps\\GANTT_REQUIREMENTS_SEPARATED\\\\PredictionEvaluationGold3GANTTReq10.txt");

	FileOutputStream fos3 = new FileOutputStream(fout3);
	
	//File fout4 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\GanttFiles\\PredictionEvaluationGold4.txt");
	File fout4 = new File("C:\\Users\\mouna\\dumps\\GANTT_REQUIREMENTS_SEPARATED\\\\PredictionEvaluationGold4GANTTReq10.txt");
	FileOutputStream fos4 = new FileOutputStream(fout4);
	
	
	
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(fos2));
	BufferedWriter bwGold3 = new BufferedWriter(new OutputStreamWriter(fos3));
	BufferedWriter bwGold4 = new BufferedWriter(new OutputStreamWriter(fos4));

	
	File foutGold3TableLog = new File("C:\\Users\\mouna\\dumps\\GANTT_REQUIREMENTS_SEPARATED\\\\TableLogGanttGOLD3Req10.txt");
	FileOutputStream fosGold3 = new FileOutputStream(foutGold3TableLog);
	BufferedWriter bwGold3TableLog = new BufferedWriter(new OutputStreamWriter(fosGold3));
	
	
	File foutGold4TableLog = new File("C:\\Users\\mouna\\dumps\\GANTT_REQUIREMENTS_SEPARATED\\\\TableLogGanttGOLD4Req10.txt");
	FileOutputStream fosGold4 = new FileOutputStream(foutGold4TableLog);
	BufferedWriter bwGold4TableLog = new BufferedWriter(new OutputStreamWriter(fosGold4));
	
	File mylog = new File("C:\\Users\\mouna\\dumps\\GANTT_REQUIREMENTS_SEPARATED\\\\logs\\loggantt.txt");
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

	public TracesTableGantt2FINALReq10() throws SQLException, IOException {
	
		bwGold3TableLog.write("RowNumber, MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold2, Subject, OwnerClassT, OwnerClassN, "
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
				+ " OnlyInParsedCallers, OnlyInExecutedCallers, BothParsedAndExecutedCallers, "
				+ "OnlyInParsedCallees, OnlyInExecutedCallees, BothParsedAndExecutedCallees,"
				+ " #parameters, parameters, # Parameter T, # Parameter N, # Parameter E," 
				+ "MajorityParameter ,AtLeast1NParameterPrediction," + 
				"AtLeast1TParameterPrediction, AtLeast2TParameterPrediction, AtLeast2NParameterPrediction,  AllNParameterPrediction, AllTParameterPrediction, "
				+"ACHRAFTracePure, ACHRAFTraceMixed, ACHRAFNoTracePure,  ACHRAFNoTraceMixed, AllNMethodLevelCallersCallees, AllTMethodLevelCallersCallees, "
				+ "AllTClassLevelCallersCallees, AllNClassLevelCallersCallees,"
				+"ClassTraceMethodLevelPureGold, ClassTraceMethodLevelMixedGold, ClassNoTraceMethodLevelPureGold, ClassNoTraceMethodLevelMixedGold,"
				+"ClassTraceClassLevelPureGold, ClassTraceClassLevelMixedGold, ClassNoTraceClassLevelPureGold, ClassNoTraceClassLevelMixedGold, gold3"
				 );

		bwGold4TableLog.write("RowNumber, MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold2, Subject, OwnerClassT, OwnerClassN, "
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
				+ " OnlyInParsedCallers, OnlyInExecutedCallers, BothParsedAndExecutedCallers, "
				+ "OnlyInParsedCallees, OnlyInExecutedCallees, BothParsedAndExecutedCallees,"
				+ " #parameters, parameters, # Parameter T, # Parameter N, # Parameter E," 
				+ "MajorityParameter ,AtLeast1NParameterPrediction," + 
				"AtLeast1TParameterPrediction, AtLeast2TParameterPrediction, AtLeast2NParameterPrediction,  AllNParameterPrediction, AllTParameterPrediction, "
				+"ACHRAFTracePure, ACHRAFTraceMixed, ACHRAFNoTracePure,  ACHRAFNoTraceMixed, AllNMethodLevelCallersCallees, AllTMethodLevelCallersCallees, "
				+ "AllTClassLevelCallersCallees, AllNClassLevelCallersCallees,"
				+"ClassTraceMethodLevelPureGold, ClassTraceMethodLevelMixedGold, ClassNoTraceMethodLevelPureGold, ClassNoTraceMethodLevelMixedGold,"
				+"ClassTraceClassLevelPureGold, ClassTraceClassLevelMixedGold, ClassNoTraceClassLevelPureGold, ClassNoTraceClassLevelMixedGold, gold3"
				 );
		
		bw.write("RowNumber, MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold2, Subject, OwnerClassT, OwnerClassN, "
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
				+ " OnlyInParsedCallers, OnlyInExecutedCallers, BothParsedAndExecutedCallers, "
				+ "OnlyInParsedCallees, OnlyInExecutedCallees, BothParsedAndExecutedCallees,"
				+ " #parameters, parameters, # Parameter T, # Parameter N, # Parameter E," 
				+ "MajorityParameter ,AtLeast1NParameterPrediction," + 
				"AtLeast1TParameterPrediction, AtLeast2TParameterPrediction, AtLeast2NParameterPrediction,  AllNParameterPrediction, AllTParameterPrediction, "
				+"ACHRAFTracePure, ACHRAFTraceMixed, ACHRAFNoTracePure,  ACHRAFNoTraceMixed, AllNMethodLevelCallersCallees, AllTMethodLevelCallersCallees, "
				+ "AllTClassLevelCallersCallees, AllNClassLevelCallersCallees,"
				+"ClassTraceMethodLevelPureGold, ClassTraceMethodLevelMixedGold, ClassNoTraceMethodLevelPureGold, ClassNoTraceMethodLevelMixedGold,"
				+"ClassTraceClassLevelPureGold, ClassTraceClassLevelMixedGold, ClassNoTraceClassLevelPureGold, ClassNoTraceClassLevelMixedGold, gold3"
				 );
		
		bw.newLine();
		bwGold3TableLog.newLine();
		bwGold4TableLog.newLine();
		DatabaseReading2Gantt db = new DatabaseReading2Gantt();
		db.MakePredictions();
		methodtraces2 = db.getMethodtraces2();
		classtraces2 = db.getClassestraces2();
	//	methodlist = db.getMethodlist();
		 methodtracesRequirementClass = db.getClassesRequirementtraceshashmap(); 
		 HashMap InterfacesHashMap = db.getInterfaces();
		  LinkedHashMap<String, Method2Details> linkedmethodhashmap = db.getLinkedmethodhashmap(); 
		  

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
		int MethodTraceCountGold3=0; 
		// Create the editors to be used for each row
		for (MethodTraceSubjectTSubjectNOriginal methodtrace : methodtraces2) {
			data[j][Row] = j; 
			data[j][MethodID] = methodtrace.MethodRepresentation.getMethodid();
			data[j][MethodName] = methodtrace.MethodRepresentation.methodname; 
			data[j][MethodName] = data[j][MethodName].toString().replaceAll(",", "/"); 
			data[j][RequirementID] = methodtrace.Requirement.getID();
			data[j][RequirementName] = methodtrace.Requirement.getRequirementName();
			data[j][ClassID] = methodtrace.ClassRepresentation.ID;
			data[j][ClassName] = methodtrace.ClassRepresentation.classname;
			data[j][Gold] = methodtrace.gold;
			data[j][Subject] = methodtrace.subject;
			data[j][Gold3] = methodtrace.gold3;
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
			
			data[j][CallerClassesTGOLD3] = 0;
			data[j][CallerClassesNGOLD3] = 0;
			data[j][CallerClassesEGOLD3] = 0;
			data[j][CallerMethodsTGOLD3] = 0;
			data[j][CallerMethodsNGOLD3] = 0;
			data[j][CallerMethodsEGOLD3] = 0;
			data[j][CalleeClassesTGOLD3] = 0;
			data[j][CalleeClassesNGOLD3] = 0;
			data[j][CalleeClassesEGOLD3] = 0;
			data[j][CalleeMethodsTGOLD3] = 0;
			data[j][CalleeMethodsNGOLD3] = 0;
			data[j][CalleeMethodsEGOLD3] = 0;
			data[j][CalleeMethodsNumberGOLD3] = 0;
			data[j][CallerMethodsNumberGOLD3] = 0;
			data[j][CallerClassesNumberGOLD3] = 0;
			data[j][CalleeClassesNumberGOLD3] = 0;
			
			data[j][CallerClassesTGOLD4] = 0;
			data[j][CallerClassesNGOLD4] = 0;
			data[j][CallerClassesEGOLD4] = 0;
			data[j][CallerMethodsTGOLD4] = 0;
			data[j][CallerMethodsNGOLD4] = 0;
			data[j][CallerMethodsEGOLD4] = 0;
			data[j][CalleeClassesTGOLD4] = 0;
			data[j][CalleeClassesNGOLD4] = 0;
			data[j][CalleeClassesEGOLD4] = 0;
			data[j][CalleeMethodsTGOLD4] = 0;
			data[j][CalleeMethodsNGOLD4] = 0;
			data[j][CalleeMethodsEGOLD4] = 0;
			data[j][CalleeMethodsNumberGOLD4] = 0;
			data[j][CallerMethodsNumberGOLD4] = 0;
			data[j][CallerClassesNumberGOLD4] = 0;
			data[j][CalleeClassesNumberGOLD4] = 0;
			data[j][CLASSTRACEClassLevelMixedGold] = "null";
			data[j][CLASSTRACEClassLevelPureGold] = "null";
			data[j][CLASSNOTRACEClassLevelMixedGold] = "null";
			data[j][CLASSNOTRACEClassLevelPureGold] = "null";
			data[j][CLASSTRACEClassLevelMixedGold3] = "null";
			data[j][CLASSTRACEClassLevelPureGold3] = "null";
			data[j][CLASSNOTRACEClassLevelMixedGold3] = "null";
			data[j][CLASSNOTRACEClassLevelPureGold3] = "null";
			
			data[j][CLASSTRACEMethodLevelMixedGold] = "null";
			data[j][CLASSTRACEMethodLevelPureGold] = "null";
			data[j][CLASSNOTRACEMethodLevelMixedGold] = "null";
			data[j][CLASSNOTRACEMethodLevelPureGold] = "null";
			data[j][CLASSTRACEMethodLevelMixedGold3] = "null";
			data[j][CLASSTRACEMethodLevelPureGold3] = "null";
			data[j][CLASSNOTRACEMethodLevelMixedGold3] = "null";
			data[j][CLASSNOTRACEMethodLevelPureGold3] = "null";
			data[j][CLASSTRACEClassLevelMixedGold4] = "null";
			data[j][CLASSTRACEClassLevelPureGold4] = "null";
			data[j][CLASSNOTRACEClassLevelMixedGold4] = "null";
			data[j][CLASSNOTRACEClassLevelPureGold4] = "null";
			data[j][CLASSTRACEMethodLevelMixedGold4] = "null";
			data[j][CLASSTRACEMethodLevelPureGold4] = "null";
			data[j][CLASSNOTRACEMethodLevelMixedGold4] = "null";
			data[j][CLASSNOTRACEMethodLevelPureGold4] = "null";
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
			
			
			if(myclasstraceHashMap.getTrace3()!=null) {
				String traceGOLD3 = myclasstraceHashMap.getTrace3();
				traceGOLD3=traceGOLD3.trim(); 
				if (traceGOLD3.equals("T")) {
					data[j][OwnerClassTGOLD3] = "1";
					data[j][OwnerClassNGOLD3] = "0";
					data[j][OwnerClassEGOLD3] = "0";
					System.out.println("OWNERCLASS T  "+j +" set to 1");
				} else if (traceGOLD3.equals("N")) {
					data[j][OwnerClassTGOLD3] = "0";
					data[j][OwnerClassNGOLD3] = "1";
					data[j][OwnerClassEGOLD3] = "0";
					System.out.println("OWNERCLASS N  "+j +" set to 1");
				} else if (traceGOLD3.equals("E")) {
					data[j][OwnerClassTGOLD3] = "0";
					data[j][OwnerClassNGOLD3] = "0";
					data[j][OwnerClassEGOLD3] = "1";
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
			int counterParameterTGOLD3=0; 
			int counterParameterNGOLD3=0; 
			int counterParameterEGOLD3=0; 
			int counterParameterTGOLD4=0; 
			int counterParameterNGOLD4=0; 
			int counterParameterEGOLD4=0; 
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
					
					String mytrace2=mycallerclass.getTrace3(); 
					if(mytrace2!=null) {
						if(mytrace2.equals("T")) {
							counterParameterTGOLD3++; 
						}else if (mytrace2.equals("N")) {
							counterParameterNGOLD3++; 
						}else if (mytrace2.equals("E")){
							counterParameterEGOLD3++; 
						}
					}
					
					String mytrace4=mycallerclass.getTrace4(); 
					if(mytrace4!=null) {
						if(mytrace4.equals("T")) {
							counterParameterTGOLD4++; 
						}else if (mytrace4.equals("N")) {
							counterParameterNGOLD4++; 
						}else if (mytrace4.equals("E")){
							counterParameterEGOLD4++; 
						}
					}
					
				}
				

			}
			ParametersAppended=ParametersAppended.replaceAll(",", "/"); 
			data [j][CountParamaterT]= counterParameterT; 
			data [j][CountParamaterN]= counterParameterN; 
			data [j][CountParamaterE]= counterParameterE; 
			
			
			data [j][CountParamaterTGOLD3]= counterParameterTGOLD3; 
			data [j][CountParamaterNGOLD3]= counterParameterNGOLD3; 
			data [j][CountParamaterEGOLD3]= counterParameterEGOLD3; 
			
			data [j][CountParamaterTGOLD4]= counterParameterTGOLD4; 
			data [j][CountParamaterNGOLD4]= counterParameterNGOLD4; 
			data [j][CountParamaterEGOLD4]= counterParameterEGOLD4; 
			
			
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			/**************************************************************************************************************/
			//data [j][paramatersNumber]= myparametercount; 
			data [j][paramatersNumber]= counterParameterT+counterParameterN+counterParameterE; 

			data [j][paramatersNumberGOLD3]= counterParameterTGOLD3+counterParameterNGOLD3+counterParameterEGOLD3; 
			data [j][paramatersNumberGOLD4]= counterParameterTGOLD4+counterParameterNGOLD4+counterParameterEGOLD4; 
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
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
						items4[CountCalleesExecuted] = caller.toString2();
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
			
			

			
			
			
			
			
			
			
			//***********************************************CALLERS**************************************************//	
			//***********************************************CALLERS**************************************************//	
			//***********************************************CALLERS**************************************************//	
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
//			

			List<Method> CallerMethodsListFinalNoDuplicates = new ArrayList<Method>();

			Set<String> CallerMethodsListNoDuplicates = new HashSet<String>();

			for( Method item : CallerMethodListFinal ) {
				String val= item.classrep.ID+"-"+item.methodname;
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
			
			
			
			

			List<Method> CalleeMethodsListFinalNoDuplicates = new ArrayList<Method>();

			Set<String> CalleeMethodsListNoDuplicates = new HashSet<String>();
			for( Method item : CalleeMethodListFinal ) {
				String val= item.classrep.ID+"-"+item.methodname;
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
			int CounterTraceClassCallerTGOLD3 = 0;
			int CounterTraceClassCallerNGOLD3 = 0;
			int CounterTraceClassCallerEGOLD3 = 0;
			int CounterTraceClassCallerTGOLD4 = 0;
			int CounterTraceClassCallerNGOLD4 = 0;
			int CounterTraceClassCallerEGOLD4 = 0;
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
				if (mycallerclass.getTrace3()!=null) {
					if (mycallerclass.getTrace3().equals("T")) {
						CounterTraceClassCallerTGOLD3++;
					} else if (mycallerclass.getTrace3().equals("N")) {
						CounterTraceClassCallerNGOLD3++;
					} else if (mycallerclass.getTrace3().equals("E")) {
						CounterTraceClassCallerEGOLD3++;
					}
				}
				
				if (mycallerclass.getTrace4()!=null) {
					if (mycallerclass.getTrace4().equals("T")) {
						CounterTraceClassCallerTGOLD4++;
					} else if (mycallerclass.getTrace4().equals("N")) {
						CounterTraceClassCallerNGOLD4++;
					} else if (mycallerclass.getTrace4().equals("E")) {
						CounterTraceClassCallerEGOLD4++;
					}
				}
				
			}

			data[j][CallerClassesT] = CounterTraceClassCallerT;
			data[j][CallerClassesN] = CounterTraceClassCallerN;
			data[j][CallerClassesE] = CounterTraceClassCallerE;
			data[j][CallerClassesNumber] = CounterTraceClassCallerT+CounterTraceClassCallerN+CounterTraceClassCallerE;
			
			data[j][CallerClassesTGOLD3] = CounterTraceClassCallerTGOLD3;
			data[j][CallerClassesNGOLD3] = CounterTraceClassCallerNGOLD3;
			data[j][CallerClassesEGOLD3] = CounterTraceClassCallerEGOLD3;
			data[j][CallerClassesNumberGOLD3] = CounterTraceClassCallerTGOLD3+CounterTraceClassCallerNGOLD3+CounterTraceClassCallerEGOLD3;
			
			data[j][CallerClassesTGOLD4] = CounterTraceClassCallerTGOLD4;
			data[j][CallerClassesNGOLD4] = CounterTraceClassCallerNGOLD4;
			data[j][CallerClassesEGOLD4] = CounterTraceClassCallerEGOLD4;
			data[j][CallerClassesNumberGOLD4] = CounterTraceClassCallerTGOLD4+CounterTraceClassCallerNGOLD4+CounterTraceClassCallerEGOLD4;

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
			for (ClassTrace2 mycallerclass : mycallerclasses) {
				if (mycallerclass.gettrace().equals("T")) {
					CountMethodT++;
				} else if (mycallerclass.gettrace().equals("N")) {
					CountMethodN++;
				} else if (mycallerclass.gettrace().equals("E")) {
					CountMethodE++;
				}
				if(mycallerclass.getTrace3()!=null) {
					if (mycallerclass.getTrace3().equals("T")) {
						CountMethodTGOLD3++;
					} else if (mycallerclass.getTrace3().equals("N")) {
						CountMethodNGOLD3++;
					} else if (mycallerclass.getTrace3().equals("E")) {
						CountMethodEGOLD3++;
					}
				}
				
				if(mycallerclass.getTrace4()!=null) {
					if (mycallerclass.getTrace4().equals("T")) {
						CountMethodTGOLD4++;
					} else if (mycallerclass.getTrace4().equals("N")) {
						CountMethodNGOLD4++;
					} else if (mycallerclass.getTrace4().equals("E")) {
						CountMethodEGOLD4++;
					}
				}
				
			}
			int CountMethodTACHRAF = 0; 
			int CountMethodNACHRAF = 0; 
			int CountMethodEACHRAF = 0; 
			int CountMethodTACHRAFGold3 = 0; 
			int CountMethodNACHRAFGold3 = 0; 
			int CountMethodEACHRAFGold3 = 0; 
			int CountMethodTACHRAFGold4 = 0; 
			int CountMethodNACHRAFGold4 = 0; 
			int CountMethodEACHRAFGold4 = 0; 
			for (Method mycaller: CallerMethodListFinal) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.methodid); 
				 if(methdet!=null) {
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
			}
			
			int CountMethodTACHRAFCallee = 0; 
			int CountMethodNACHRAFCallee = 0; 
			int CountMethodEACHRAFCallee = 0; 
			for (Method mycaller: CalleeMethodListFinal) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.methodid); 
				 if(methdet!=null) {
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
		
			
			}
			
			
			
			

		
		
			for (Method mycaller: CallerMethodListFinal) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.methodid); 
				 if(methdet!=null) {
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null) {
					if(methtrace.gold3!=null) {
						if (methtrace.gold3.equals("T")) {
							CountMethodTACHRAFGold3++;
						} else if (methtrace.gold3.equals("N")) {
							CountMethodNACHRAFGold3++;
						} else if (methtrace.gold3.equals("E")) {
							CountMethodEACHRAFGold3++;
						}
					}
			
			}
				 }
			}
			
			
			
			int CountMethodTACHRAFCalleeGold3 = 0; 
			int CountMethodNACHRAFCalleeGold3 = 0; 
			int CountMethodEACHRAFCalleeGold3 = 0; 
			for (Method mycaller: CalleeMethodListFinal) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.methodid); 
				 if(methdet!=null) {
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null ) {
					if(methtrace.gold3!=null) {
						if (methtrace.gold3.equals("T")) {
							CountMethodTACHRAFCalleeGold3++;
						} else if (methtrace.gold3.equals("N")) {
							CountMethodNACHRAFCalleeGold3++;
						} else if (methtrace.gold3.equals("E")) {
							CountMethodEACHRAFCalleeGold3++;
						}
					}
					
				}
				 }
			
			}
			
			for (Method mycaller: methodtrace.getCallersListExecuted()) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.methodid); 
				 if(methdet!=null) {
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null) {
					if(methtrace.gold4!=null ) {
						
						if (methtrace.gold4.equals("T")) {
							CountMethodTACHRAFGold4++;
						} else if (methtrace.gold4.equals("N")) {
							CountMethodNACHRAFGold4++;
						} else if (methtrace.gold4.equals("E")) {
							CountMethodEACHRAFGold4++;
						}
					}
			
			}
				 }
			}
			
			
			
			int CountMethodTACHRAFCalleeGold4 = 0; 
			int CountMethodNACHRAFCalleeGold4 = 0; 
			int CountMethodEACHRAFCalleeGold4 = 0; 
			for (Method mycaller: methodtrace.getCalleesListExecuted()) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.methodid); 
				 if(methdet!=null) {
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null ) {
					if(methtrace.gold4!=null ) {
					if (methtrace.gold4.equals("T")) {
						CountMethodTACHRAFCalleeGold4++;
					} else if (methtrace.gold4.equals("N")) {
						CountMethodNACHRAFCalleeGold4++;
					} else if (methtrace.gold4.equals("E")) {
						CountMethodEACHRAFCalleeGold4++;
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
				
				if(mycalleeclass.getTrace3()!=null) {
					if (mycalleeclass.getTrace3().equals("T")) {
						CounterTraceClassCalleeTGOLD3++;
					} else if (mycalleeclass.getTrace3().equals("N")) {
						CounterTraceClassCalleeNGOLD3++;
					} else if (mycalleeclass.getTrace3().equals("E")) {
						CounterTraceClassCalleeEGOLD3++;
					}
				}
				
				if(mycalleeclass.getTrace4()!=null) {
					if (mycalleeclass.getTrace4().equals("T")) {
						CounterTraceClassCalleeTGOLD4++;
					} else if (mycalleeclass.getTrace4().equals("N")) {
						CounterTraceClassCalleeNGOLD4++;
					} else if (mycalleeclass.getTrace4().equals("E")) {
						CounterTraceClassCalleeEGOLD4++;
					}
				}
			
			}

			data[j][CalleeClassesT] = CounterTraceClassCalleeT;
			data[j][CalleeClassesN] = CounterTraceClassCalleeN;
			data[j][CalleeClassesE] = CounterTraceClassCalleeE;
			data[j][CalleeClassesNumber] = CounterTraceClassCalleeE+CounterTraceClassCalleeN+CounterTraceClassCalleeT;
			
			data[j][CalleeClassesTGOLD3] = CounterTraceClassCalleeTGOLD3;
			data[j][CalleeClassesNGOLD3] = CounterTraceClassCalleeNGOLD3;
			data[j][CalleeClassesEGOLD3] = CounterTraceClassCalleeEGOLD3;
			data[j][CalleeClassesNumberGOLD3] = CounterTraceClassCalleeEGOLD3+CounterTraceClassCalleeNGOLD3+CounterTraceClassCalleeTGOLD3;

			
			data[j][CalleeClassesTGOLD4] = CounterTraceClassCalleeTGOLD4;
			data[j][CalleeClassesNGOLD4] = CounterTraceClassCalleeNGOLD4;
			data[j][CalleeClassesEGOLD4] = CounterTraceClassCalleeEGOLD4;
			data[j][CalleeClassesNumberGOLD4] = CounterTraceClassCalleeEGOLD4+CounterTraceClassCalleeNGOLD4+CounterTraceClassCalleeTGOLD4;
			//DUPLICATE CLASSES
			int CountMethodTCallee = 0; 
			int CountMethodNCallee = 0; 
			int CountMethodECallee = 0; 
			
			int CountMethodTCalleeGOLD3 = 0; 
			int CountMethodNCalleeGOLD3 = 0; 
			int CountMethodECalleeGOLD3 = 0; 
			for (ClassTrace2 mycalleeclass : mycalleeclasses) {
				if(mycalleeclass.getTrace3()!=null) {
					if (mycalleeclass.getTrace3().equals("T")) {
						CountMethodTCalleeGOLD3++;
					} else if (mycalleeclass.getTrace3().equals("N")) {
						CountMethodNCalleeGOLD3++;
					} else if (mycalleeclass.getTrace3().equals("E")) {
						CountMethodECalleeGOLD3++;
					}
				}
			
			}
			
			int CountMethodTCalleeGOLD4 = 0; 
			int CountMethodNCalleeGOLD4 = 0; 
			int CountMethodECalleeGOLD4 = 0; 
			for (ClassTrace2 mycalleeclass : mycalleeclasses) {
				if(mycalleeclass.getTrace4()!=null) {
					if (mycalleeclass.getTrace4().equals("T")) {
						CountMethodTCalleeGOLD4++;
					} else if (mycalleeclass.getTrace4().equals("N")) {
						CountMethodNCalleeGOLD4++;
					} else if (mycalleeclass.getTrace4().equals("E")) {
						CountMethodECalleeGOLD4++;
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
			
			data[j][CalleeMethodsTGOLD3] = CountMethodTCalleeGOLD3;
			data[j][CalleeMethodsNGOLD3] = CountMethodNCalleeGOLD3;
			data[j][CalleeMethodsEGOLD3] = CountMethodECalleeGOLD3;
			data[j][CalleeMethodsNumberGOLD3] = CountMethodTCalleeGOLD3+CountMethodNCalleeGOLD3+CountMethodECalleeGOLD3;
			
			data[j][CallerMethodsTGOLD3] = CountMethodTGOLD3;
			data[j][CallerMethodsNGOLD3] = CountMethodNGOLD3;
			data[j][CallerMethodsEGOLD3] = CountMethodEGOLD3;
			data[j][CallerMethodsNumberGOLD3] = CountMethodTGOLD3+CountMethodNGOLD3+CountMethodEGOLD3;
			
			data[j][CalleeMethodsTGOLD4] = CountMethodTCalleeGOLD4;
			data[j][CalleeMethodsNGOLD4] = CountMethodNCalleeGOLD4;
			data[j][CalleeMethodsEGOLD4] = CountMethodECalleeGOLD4;
			data[j][CalleeMethodsNumberGOLD4] = CountMethodTCalleeGOLD4+CountMethodNCalleeGOLD4+CountMethodECalleeGOLD4;
			
			data[j][CallerMethodsTGOLD4] = CountMethodTGOLD4;
			data[j][CallerMethodsNGOLD4] = CountMethodNGOLD4;
			data[j][CallerMethodsEGOLD4] = CountMethodEGOLD4;
			data[j][CallerMethodsNumberGOLD4] = CountMethodTGOLD4+CountMethodNGOLD4+CountMethodEGOLD4;
			
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
		 Object OwnerClassNVarGOLD3 = data[j][OwnerClassNGOLD3]; 
		 Object OwnerClassNVarGOLD4 = data[j][OwnerClassNGOLD4]; 

			boolean flagGold=false; 
			boolean flagGold3=false; 
			boolean flagGold4=false; 
			if(OwnerClassNVar.toString().equals("1")) {
				data[j][OwnerClassPrediction]="N"; 
				String Result=OwnerClassPredictionClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][OwnerClassPrediction].toString()); 
				OwnerClassPredictionClass.UpdateCounters(Result, OwnerClassPredictionClass);
				flagGold=true; 
			
			}
			if(OwnerClassNVarGOLD3!=null) {
				if(OwnerClassNVarGOLD3.toString().equals("1") && methodtrace.getGold3()!=null){
					data[j][OwnerClassPredictionGOLD3]="N"; 
					String Result2=OwnerClassPredictionClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][OwnerClassPredictionGOLD3].toString()); 
					OwnerClassPredictionClassGold3.UpdateCounters(Result2, OwnerClassPredictionClassGold3);
					flagGold3=true; 
					}
				
				
			}
			
			if(OwnerClassNVarGOLD4!=null) {
				if(OwnerClassNVarGOLD4.toString().equals("1") && methodtrace.getGold4()!=null){
					data[j][OwnerClassPredictionGOLD4]="N"; 
					String Result2=OwnerClassPredictionClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][OwnerClassPredictionGOLD4].toString()); 
					OwnerClassPredictionClassGold4.UpdateCounters(Result2, OwnerClassPredictionClassGold4);
					flagGold4=true; 
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
						
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
				
					if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
							if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
							if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
						if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
			//ALL T METHOD LEVEL CALLEES AT LEAST 2T
			
			
			if(CountMethodNCallee==0 && CountMethodECallee==0 && CountMethodTCallee>=2) {
				
				
				
					
					data[j][AllTMethodLevelCalleesAtLeast2TGOLD] = "T";
					if(flagGold==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold()!=null) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold()!=null) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold()!=null) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold()!=null) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold()!=null) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold()!=null) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold()!=null) {
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
					if(flagGold==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold()!=null) {
						String Result=AllNMethodLevelCalleesClassAtLeast2NGold.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllNMethodLevelCalleesAtLeast2NGOLD].toString()); 
						AllNMethodLevelCalleesClassAtLeast2NGold.UpdateCounters(Result, AllNMethodLevelCalleesClassAtLeast2NGold);
					}
				
					
			}
		//}
				
				/**************************************************************************************************************/
				/**************************************************************************************************************/
				/**************************************************************************************************************/
					
					
					
					
					//ALL N METHOD LEVEL CALLERS CALLEES 
					
					
				
						
						if(CountMethodTCallee==0 && CountMethodT==0 && CountMethodNCallee>=1 && CountMethodN>=1) {
						
					
							data[j][AllNMethodLevelCallersCallees] = "N";
							if(flagGold==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold()!=null) {
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
								if(flagGold==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold()!=null) {
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
									if(flagGold==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold()!=null) {
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
										if(flagGold==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold()!=null) {
											String Result=AllTClassLevelCallersCalleesClass.ComparePredictionToGold(methodtrace.getGold().trim(), data[j][AllTClassLevelCallersCallees].toString()); 
											AllTClassLevelCallersCalleesClass.UpdateCounters(Result, AllTClassLevelCallersCalleesClass);
										}
									
										
								}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
									
									if((counterParameterTGOLD3!=0 || counterParameterNGOLD3!=0|| counterParameterEGOLD3!=0)
											/*	||
												(CounterTraceClassCallerN!=0 && CounterTraceClassCallerE!=0)
												||(CounterTraceClassCallerT!=0 && CounterTraceClassCallerE!=0)*/
												) {
											
											if(counterParameterTGOLD3==counterParameterNGOLD3 && counterParameterTGOLD3>0) {
												data[j][MajorityParametersGOLD3] = "T";
											}
											else if(counterParameterTGOLD3==0 && counterParameterNGOLD3==0 && counterParameterEGOLD3>0) {
												data[j][MajorityParametersGOLD3] = "E";
											}
											else if(counterParameterTGOLD3==0 && counterParameterNGOLD3>0 && counterParameterEGOLD3>0) {
												data[j][MajorityParametersGOLD3] = "N";
											}
											else if (((counterParameterTGOLD3 >= counterParameterNGOLD3
												//	&& counterParameterNGOLD3 >= counterParameterEGOLD3
													)
													//|| (counterParameterTGOLD3 >= counterParameterEGOLD3
														//	&& counterParameterEGOLD3 >= counterParameterNGOLD3
													//		)
													)
													) {
												data[j][MajorityParametersGOLD3] = "T";
											}/* else if (((counterParameterEGOLD3 >= counterParameterNGOLD3
													&& counterParameterNGOLD3 >= counterParameterTGOLD3)
													|| (counterParameterEGOLD3 >= counterParameterTGOLD3
															&& counterParameterTGOLD3 >= counterParameterNGOLD3))
												) {
												data[j][MajorityParametersGOLD3] = "E";
											} */else if ((counterParameterNGOLD3 >= counterParameterTGOLD3)) {
												data[j][MajorityParametersGOLD3] = "N";
											}
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
												String Result=MajorityParametersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][MajorityParametersGOLD3].toString()); 
												MajorityParametersClassGold3.UpdateCounters(Result, MajorityParametersClassGold3);
											}
											
										
											
										
										}
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									//AT LEAST 1N PREDICTION PARAMETER
									
									
									
									
									
									if (counterParameterNGOLD3 >=1 )
											 {
										data[j][AtLeast1NParameterGOLD3] = "N";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=AtLeast1NParameterClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1NParameterGOLD3].toString()); 
										AtLeast1NParameterClassGold3.UpdateCounters(Result, AtLeast1NParameterClassGold3);
										}
										
									} 
								
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									//AT LEAST 2N PREDICTION PARAMETER
									
									
									
									
									
									if (counterParameterNGOLD3 >=2 )
											 {
										data[j][AtLeast2NParameterGOLD3] = "N";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											
											String Result=AtLeast2NParameterClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2NParameterGOLD3].toString()); 
										AtLeast2NParameterClassGold3.UpdateCounters(Result, AtLeast2NParameterClassGold3);
										}
										
									} 
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//AT LEAST 1T PREDICTION PARAMETER
								
								
									
									
									
									if (counterParameterTGOLD3 >=1 )
											 {
										data[j][AtLeast1TParameterGOLD3] = "T";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=AtLeast1TParameterClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1TParameterGOLD3].toString()); 
										AtLeast1TParameterClassGold3.UpdateCounters(Result, AtLeast1TParameterClassGold3);
										}
									} 
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//AT LEAST 2T PREDICTION PARAMETER
									
									
										
										
										
										if (counterParameterTGOLD3 >=2 )
												 {
											data[j][AtLeast2TParameterGOLD3] = "T";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AtLeast2TParameterClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2TParameterGOLD3].toString()); 
											AtLeast2TParameterClassGold3.UpdateCounters(Result, AtLeast2TParameterClassGold3);
											}
										} 
									/**************************************************************************************************************/
									/**************************************************************************************************************/
								    /**************************************************************************************************************/	
									
									
									
									//ALL T PARAMETER PREDICTION
									
									
									if(counterParameterEGOLD3==0 && counterParameterNGOLD3==0 && counterParameterTGOLD3>=1) {
										
										
										
									
											data[j][AllTParametersGOLD3] = "T";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AllTParameterClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTParametersGOLD3].toString()); 
											AllTParameterClassGold3.UpdateCounters(Result, AllTParameterClassGold3);
											}
											
											
									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N PARAMETER PREDICTION
									
									
									if(counterParameterTGOLD3==0 && counterParameterEGOLD3==0 && counterParameterNGOLD3>=1) {
										
										
										
									
											data[j][AllNParametersGOLD3] = "N";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AllNParameterClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNParametersGOLD3].toString()); 
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
											data[j][MajorityClassLevelCalleesGOLD3] = "T";
										}
										else if(CounterTraceClassCalleeTGOLD3==0 && CounterTraceClassCalleeNGOLD3==0 && CounterTraceClassCalleeEGOLD3>0) {
											data[j][MajorityClassLevelCalleesGOLD3] = "E";
										}
										else if(CounterTraceClassCalleeTGOLD3==0 && CounterTraceClassCalleeNGOLD3>0 && CounterTraceClassCalleeEGOLD3>0) {
											data[j][MajorityClassLevelCalleesGOLD3] = "N";
										}
										else if ((CounterTraceClassCalleeTGOLD3 >= CounterTraceClassCalleeNGOLD3
												)
												) {
											data[j][MajorityClassLevelCalleesGOLD3] = "T";
										} /*else if (((CounterTraceClassCallerEGOLD3 >= CounterTraceClassCallerNGOLD3
												&& CounterTraceClassCallerNGOLD3 >= CounterTraceClassCallerTGOLD3)
												|| (CounterTraceClassCallerEGOLD3 >= CounterTraceClassCallerTGOLD3
														&& CounterTraceClassCallerTGOLD3 >= CounterTraceClassCallerNGOLD3))
											) {
											data[j][MajorityClassLevelCalleesGOLD3] = "E";
										}*/ else if (CounterTraceClassCalleeNGOLD3 >= CounterTraceClassCalleeTGOLD3) {
											data[j][MajorityClassLevelCalleesGOLD3] = "N";
										}
										if(true && methodtrace.getGold3()!=null && data[j][MajorityClassLevelCalleesGOLD3]!=null) {
										String Result=MajorityClassLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][MajorityClassLevelCalleesGOLD3].toString()); 
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
											data[j][MajorityClassLevelCallersGOLD3] = "T";
										}
										else if(CounterTraceClassCallerTGOLD3==0 && CounterTraceClassCallerNGOLD3==0 && CounterTraceClassCallerEGOLD3>0) {
											data[j][MajorityClassLevelCallersGOLD3] = "E";
										}
										else if(CounterTraceClassCallerTGOLD3==0 && CounterTraceClassCallerNGOLD3>0 && CounterTraceClassCallerEGOLD3>0) {
											data[j][MajorityClassLevelCallersGOLD3] = "N";
										}
										else if(CounterTraceClassCallerTGOLD3==0 && CounterTraceClassCallerNGOLD3>0 && CounterTraceClassCallerEGOLD3>0) {
											data[j][MajorityClassLevelCallersGOLD3] = "E";
										}
										else if (CounterTraceClassCallerTGOLD3 >= CounterTraceClassCallerNGOLD3) {
											data[j][MajorityClassLevelCallersGOLD3] = "T";
										} else if (CounterTraceClassCallerNGOLD3>=CounterTraceClassCallerTGOLD3)
											 {
											data[j][MajorityClassLevelCallersGOLD3] = "N";
										} 
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=MajorityClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][MajorityClassLevelCallersGOLD3].toString()); 
										MajorityClassLevelCallersClassGold3.UpdateCounters(Result, MajorityClassLevelCallersClassGold3);
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
											data[j][MajorityMethodLevelCalleesGOLD3] = "T";
										}
										else if(CountMethodTCalleeGOLD3==0 && CountMethodNCalleeGOLD3==0 && CountMethodECalleeGOLD3>0) {
											data[j][MajorityMethodLevelCalleesGOLD3] = "E";
										}
										else if(CountMethodTCalleeGOLD3==0 && CountMethodNCalleeGOLD3>0 && CountMethodECalleeGOLD3>0) {
											data[j][MajorityMethodLevelCalleesGOLD3] = "N";
										} 
										
										else if(CountMethodTCalleeGOLD3>=CountMethodNCalleeGOLD3)
										 {
											data[j][MajorityMethodLevelCalleesGOLD3] = "T";
										}  else if (CountMethodNCalleeGOLD3 >= CountMethodTCalleeGOLD3
											
												) {
											data[j][MajorityMethodLevelCalleesGOLD3] = "N";
										}
									
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=MajorityMethodLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][MajorityMethodLevelCalleesGOLD3].toString()); 
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
											data[j][MajorityMethodLevelCallersGOLD3] = "T";
										}
										else if(CountMethodTGOLD3==0 && CountMethodNGOLD3==0 && CountMethodEGOLD3>0) {
											data[j][MajorityMethodLevelCallersGOLD3] = "E";
										}
										else if(CountMethodTGOLD3==0 && CountMethodNGOLD3>0 && CountMethodEGOLD3>0) {
											data[j][MajorityMethodLevelCallersGOLD3] = "N";
										}
										
										else if (CountMethodTGOLD3 >= CountMethodNGOLD3){
											data[j][MajorityMethodLevelCallersGOLD3] = "T";
										}  else if (CountMethodNGOLD3 >= CountMethodTGOLD3
												
												) {
											data[j][MajorityMethodLevelCallersGOLD3] = "N";
										}
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=MajorityMethodLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][MajorityMethodLevelCallersGOLD3].toString()); 
										MajorityMethodLevelCallersClassGold3.UpdateCounters(Result, MajorityMethodLevelCallersClassGold3);
										}
									}
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//1AT LEAST 1N PREDICTION CLASS LEVEL CALLERS 
									
									
										
										
										
										if (CounterTraceClassCallerNGOLD3 >=1 )
												 {
											data[j][AtLeast1NPredictionClassLevelCallersGOLD3] = "N";
											Object var= 	data[j][AtLeast1NPredictionClassLevelCallersGOLD3]; 
											String NEWVAR=var.toString(); 
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AtLeastNPredictionClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1NPredictionClassLevelCallersGOLD3].toString()); 
											AtLeastNPredictionClassLevelCallersClassGold3.UpdateCounters(Result, AtLeastNPredictionClassLevelCallersClassGold3);
											}
										} 
									
										
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//2AT LEAST 1T PREDICTION CLASS LEVEL CALLERS 
									
									
										
										
										
										if (CounterTraceClassCallerTGOLD3 >=1 )
												 {
											data[j][AtLeast1TPredictionClassLevelCallersGOLD3] = "T";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AtLeastTPredictionClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1TPredictionClassLevelCallersGOLD3].toString()); 
											AtLeastTPredictionClassLevelCallersClassGold3.UpdateCounters(Result, AtLeastTPredictionClassLevelCallersClassGold3);
											}
										} 
										
											
										
									
									
							
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//3AT LEAST 1N PREDICTION CLASS LEVEL CALLEES 
								
									
										
										
										
										if (CounterTraceClassCalleeNGOLD3 >=1 )
												 {
											data[j][AtLeast1NPredictionClassLevelCalleesGOLD3] = "N";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AtLeastNPredictionClassLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1NPredictionClassLevelCalleesGOLD3].toString()); 
											AtLeastNPredictionClassLevelCalleesClassGold3.UpdateCounters(Result, AtLeastNPredictionClassLevelCalleesClassGold3);
											}
										} 
										
									
									
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
								
									//4AT LEAST 1T PREDICTION CLASS LEVEL CALLEES 
									
									
										
										
										
										if (CounterTraceClassCalleeTGOLD3 >=1 )
												 {
											data[j][AtLeast1TPredictionClassLevelCalleesGOLD3] = "T";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AtLeastTPredictionClassLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1TPredictionClassLevelCalleesGOLD3].toString()); 
											AtLeastTPredictionClassLevelCalleesClassGold3.UpdateCounters(Result, AtLeastTPredictionClassLevelCalleesClassGold3);
											}
										} 
										
										
									
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									//5AT LEAST 1N PREDICTION METHOD LEVEL CALLERS 
									
									
										
										
										if (CountMethodNGOLD3 >=1 )
												 {
											data[j][AtLeast1NPredictionMethodLevelCallersGOLD3] = "N";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AtLeastNPredictionMethodLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1NPredictionMethodLevelCallersGOLD3].toString()); 
											AtLeastNPredictionMethodLevelCallersClassGold3.UpdateCounters(Result, AtLeastNPredictionMethodLevelCallersClassGold3);
											}
										} 
										
										
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									//6AT LEAST 1T PREDICTION METHOD LEVEL CALLERS 
								
									
										
										
										
										if (CountMethodTGOLD3 >=1 )
												 {
											data[j][AtLeast1TPredictionMethodLevelCallersGOLD3] = "T";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AtLeastTPredictionMethodLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1TPredictionMethodLevelCallersGOLD3].toString()); 
											AtLeastTPredictionMethodLevelCallersClassGold3.UpdateCounters(Result, AtLeastTPredictionMethodLevelCallersClassGold3);
											}
										} 
										
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//7AT LEAST 1N PREDICTION METHOD LEVEL CALLEES 
									
									
										
										
										
										if (CountMethodNCalleeGOLD3 >=1 )
												 {
											data[j][AtLeast1NPredictionMethodLevelCalleesGOLD3] = "N";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AtLeastNPredictionMethodLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1NPredictionMethodLevelCalleesGOLD3].toString()); 
											AtLeastNPredictionMethodLevelCalleesClassGold3.UpdateCounters(Result, AtLeastNPredictionMethodLevelCalleesClassGold3);
											}
										} 
										
									
							
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//8AT LEAST 1T PREDICTION METHOD LEVEL CALLEES 
									
									
										
										
										
										if (CountMethodTCalleeGOLD3 >=1 )
												 {
											data[j][AtLeast1TPredictionMethodLevelCalleesGOLD3] = "T";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AtLeastTPredictionMethodLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast1TPredictionMethodLevelCalleesGOLD3].toString()); 
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
												data[j][AtLeast2NPredictionClassLevelCalleesGOLD3] = "N";
												Object var= 	data[j][AtLeast2NPredictionClassLevelCalleesGOLD3]; 
												String NEWVAR=var.toString(); 
												if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
													String Result=AtLeast2NPredictionClassLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2NPredictionClassLevelCalleesGOLD3].toString()); 
													AtLeast2NPredictionClassLevelCalleesClassGold3.UpdateCounters(Result, AtLeast2NPredictionClassLevelCalleesClassGold3);
												}
											} 
										
											
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										
										//AT LEAST 2T PREDICTION CLASS LEVEL CALLEES 
										
										
											
											
											
											if (CounterTraceClassCalleeTGOLD3 >=2 )
											 {
										data[j][AtLeast2TPredictionClassLevelCalleesGOLD3] = "T";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=AtLeast2TPredictionClassLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2TPredictionClassLevelCalleesGOLD3].toString()); 
										AtLeast2TPredictionClassLevelCalleesClassGold3.UpdateCounters(Result, AtLeast2TPredictionClassLevelCalleesClassGold3);
										}
									} 
												
											
										
										
								
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										
										//AT LEAST 2N PREDICTION METHOD LEVEL CALLERS 
									
										
											
											
											
											
											if (CountMethodNGOLD3 >=2 )
													 {
												data[j][AtLeast2NPredictionMethodLevelCallersGOLD3] = "N";
												if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
												String Result=AtLeast2NPredictionMethodLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2NPredictionMethodLevelCallersGOLD3].toString()); 
												AtLeast2NPredictionMethodLevelCallersClassGold3.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCallersClassGold3);
												}
											} 
											
											
										
											/**************************************************************************************************************/
											/**************************************************************************************************************/
											/**************************************************************************************************************/
										
											//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
											
											
												
												
												
												if (CounterTraceClassCallerTGOLD3 >=2 )
												 {
											data[j][AtLeast2TPredictionClassLevelCallersGOLD3] = "T";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AtLeast2TPredictionClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2TPredictionClassLevelCallersGOLD3].toString()); 
											AtLeast2TPredictionClassLevelCallersClassGold3.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClassGold3);
											}
										} 
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
									
										//AT LEAST 2T PREDICTION METHOD LEVEL CALLERS 
										
										
											
											
											
											if (CountMethodTGOLD3 >=2 )
											 {
										data[j][AtLeast2TPredictionMethodLevelCallersGOLD3] = "T";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=AtLeast2TPredictionMethodLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2TPredictionMethodLevelCallersGOLD3].toString()); 
										AtLeast2TPredictionMethodLevelCallersClassGold3.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClassGold3);
										}
									} 
											
											
										
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										//AT LEAST 2N PREDICTION METHOD LEVEL CALLEES 

											
											
											
											
											
											
											
											
											
											
											
											
											
											
											
											
											
										
											
											
											if (CountMethodNCalleeGOLD3 >=2 )
											 {
										data[j][AtLeast2NPredictionMethodLevelCalleesGOLD3] = "N";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=AtLeast2NPredictionMethodLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2NPredictionMethodLevelCalleesGOLD3].toString()); 
										AtLeast2NPredictionMethodLevelCalleesClassGold3.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCalleesClassGold3);
										}	
									} 
											
											
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										//AT LEAST 2T PREDICTION METHOD LEVEL CALLEES 
									
										
											
											
											
											if (CountMethodTCalleeGOLD3 >=2 )
											 {
										data[j][AtLeast2TPredictionMethodLevelCalleesGOLD3] = "T";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AtLeast2TPredictionMethodLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2TPredictionMethodLevelCalleesGOLD3].toString()); 
											AtLeast2TPredictionMethodLevelCalleesClassGold3.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCalleesClassGold3);

										}
										
									} 
											
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										
										//AT LEAST 2N PREDICTION CLASS LEVEL CALLERS 
										
										
											
											
											
											if (CounterTraceClassCallerNGOLD3 >=2 )
											 {
										data[j][AtLeast2NPredictionClassLevelCallersGOLD3] = "N";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=AtLeast2NPredictionClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2NPredictionClassLevelCallersGOLD3].toString()); 
										AtLeast2NPredictionClassLevelCallersClassGold3.UpdateCounters(Result, AtLeast2NPredictionClassLevelCallersClassGold3);
										
										}
									} 
									
										
								
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										
										//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
										
										
											
											
											
											if (CounterTraceClassCallerTGOLD3 >=2 )
											 {
										data[j][AtLeast2TPredictionClassLevelCallersGOLD3] = "T";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AtLeast2TPredictionClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AtLeast2TPredictionClassLevelCallersGOLD3].toString()); 
											AtLeast2TPredictionClassLevelCallersClassGold3.UpdateCounters(Result, AtLeast2TPredictionClassLevelCallersClassGold3);

										}
										
										}
											
											
											
											
											
											
											
											
											
											
											
											
											/**************************************************************************************************************/
											/**************************************************************************************************************/
											/**************************************************************************************************************/	 
									//ALL T METHOD LEVEL CALLEES 
									
									
									if(CountMethodNCalleeGOLD3==0 && CountMethodECalleeGOLD3==0 && CountMethodTCalleeGOLD3>=1) {
										
										
										
											
											data[j][AllTMethodLevelCalleesGOLD3] = "T";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AllTMethodLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTMethodLevelCalleesGOLD3].toString()); 
											AllTMethodLevelCalleesClassGold3.UpdateCounters(Result, AllTMethodLevelCalleesClassGold3);
											}
									}
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL T METHOD LEVEL CALLERS 
									
									if(CountMethodNGOLD3==0 && CountMethodEGOLD3==0  && CountMethodTGOLD3>=1) {
										
										
										
									
											data[j][AllTMethodLevelCallersGOLD3] = "T";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AllTMethodLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTMethodLevelCallersGOLD3].toString()); 
											AllTMethodLevelCallersClassGold3.UpdateCounters(Result, AllTMethodLevelCallersClassGold3);
											
											}
										
									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL T CLASS LEVEL CALLERS 
									
									
									if(CounterTraceClassCallerEGOLD3==0 && CounterTraceClassCallerNGOLD3==0 && CounterTraceClassCallerTGOLD3>=1) {
										
										
									
											data[j][AllTClassLevelCallersGOLD3] = "T";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AllTClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTClassLevelCallersGOLD3].toString()); 
											AllTClassLevelCallersClassGold3.UpdateCounters(Result, AllTClassLevelCallersClassGold3);
											System.out.println(methodtrace.toString());
											
											}
											
											
											}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL T CLASS LEVEL CALLEES 
									
									
									if(CounterTraceClassCalleeEGOLD3==0 && CounterTraceClassCalleeNGOLD3==0 && CounterTraceClassCalleeTGOLD3>=1) {
										
										
										
									
											data[j][AllTClassLevelCalleesGOLD3] = "T";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AllTClassLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTClassLevelCalleesGOLD3].toString()); 
											AllTClassLevelCalleesClassGold3.UpdateCounters(Result, AllTClassLevelCalleesClassGold3);
									
											
											}
									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N CLASS LEVEL CALLERS 
									
									
								
										
									if(CounterTraceClassCallerTGOLD3==0 && CounterTraceClassCallerEGOLD3==0 && CounterTraceClassCallerNGOLD3>=1) {
										
									
											data[j][AllNClassLevelCallersGOLD3] = "N";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AllNClassLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNClassLevelCallersGOLD3].toString()); 
											AllNClassLevelCallersClassGold3.UpdateCounters(Result, AllNClassLevelCallersClassGold3);
										
											}
											
											
									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N CLASS LEVEL CALLEES 
									
									
							
										
										if(CounterTraceClassCalleeTGOLD3==0 && CounterTraceClassCalleeEGOLD3==0 && CounterTraceClassCalleeNGOLD3>=1) {
										
									
											data[j][AllNClassLevelCalleesGOLD3] = "N";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AllNClassLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNClassLevelCalleesGOLD3].toString()); 
											AllNClassLevelCalleesClassGold3.UpdateCounters(Result, AllNClassLevelCalleesClassGold3);
											
											}
										
									}
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N METHOD LEVEL CALLERS 
									
									
								
										
										if(CountMethodTGOLD3==0 && CountMethodEGOLD3==0 && CountMethodNGOLD3>=1) {	
										
									
											data[j][AllNMethodLevelCallersGOLD3] = "N";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AllNMethodLevelCallersClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNMethodLevelCallersGOLD3].toString()); 
											AllNMethodLevelCallersClassGold3.UpdateCounters(Result, AllNMethodLevelCallersClassGold3);
											
											}
									}
									
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									/**************************************************************************************************************/
									
									//ALL N METHOD LEVEL CALLEES 
									
									
								
										
										if(CountMethodTCalleeGOLD3==0 && CountMethodECalleeGOLD3==0 && CountMethodNCalleeGOLD3>=1) {
										
									
											data[j][AllNMethodLevelCalleesGOLD3] = "N";
											if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
												String Result=AllNMethodLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNMethodLevelCalleesGOLD3].toString()); 
												AllNMethodLevelCalleesClassGold3.UpdateCounters(Result, AllNMethodLevelCalleesClassGold3);
											}
										
											
									}
								//}
										
										
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/	 
								//ALL T METHOD LEVEL CALLEES AT LEAST 2T
								
								
								if(CountMethodNCalleeGOLD3==0 && CountMethodECalleeGOLD3==0 && CountMethodTCalleeGOLD3>=2) {
									
									
									
										
										data[j][AllTMethodLevelCalleesAtLeast2TGOLD3] = "T";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=AllTMethodLevelCalleesClassAtLeast2TGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTMethodLevelCalleesAtLeast2TGOLD3].toString()); 
										AllTMethodLevelCalleesClassAtLeast2TGold3.UpdateCounters(Result, AllTMethodLevelCalleesClassAtLeast2TGold3);
										}
								}
								
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL T METHOD LEVEL CALLERS AT LEAST 2T
								
								if(CountMethodNGOLD3==0 && CountMethodEGOLD3==0  && CountMethodTGOLD3>=2) {
									
									
									
								
										data[j][AllTMethodLevelCallersAtLeast2TGOLD3] = "T";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=AllTMethodLevelCallersClassAtLeast2TGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTMethodLevelCallersAtLeast2TGOLD3].toString()); 
										AllTMethodLevelCallersClassAtLeast2TGold3.UpdateCounters(Result, AllTMethodLevelCallersClassAtLeast2TGold3);
										
										}
									
								}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL T CLASS LEVEL CALLERS AT LEAST 2T
								
								
								if(CounterTraceClassCallerEGOLD3==0 && CounterTraceClassCallerNGOLD3==0 && CounterTraceClassCallerTGOLD3>=2) {
									
									
								
										data[j][AllTClassLevelCallersAtLeast2TGOLD3] = "T";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=AllTClassLevelCallersClassAtLeast2TGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTClassLevelCallersAtLeast2TGOLD3].toString()); 
										AllTClassLevelCallersClassAtLeast2TGold3.UpdateCounters(Result, AllTClassLevelCallersClassAtLeast2TGold3);
										System.out.println(methodtrace.toString());
										
										}
										
										
										}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL T CLASS LEVEL CALLEES AT LEAST 2T
								
								
								if(CounterTraceClassCalleeEGOLD3==0 && CounterTraceClassCalleeNGOLD3==0 && CounterTraceClassCalleeTGOLD3>=2) {
									
									
									
								
										data[j][AllTClassLevelCalleesAtLeast2TGOLD3] = "T";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=AllTClassLevelCalleesClassAtLeast2TGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTClassLevelCalleesAtLeast2TGOLD3].toString()); 
										AllTClassLevelCalleesClassAtLeast2TGold3.UpdateCounters(Result, AllTClassLevelCalleesClassAtLeast2TGold3);
								
										
										}
								}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL N CLASS LEVEL CALLERS AT LEAST 2N
								
								
							
									
								if(CounterTraceClassCallerTGOLD3==0 && CounterTraceClassCallerEGOLD3==0 && CounterTraceClassCallerNGOLD3>=2) {
									
								
										data[j][AllNClassLevelCallersAtLeast2NGOLD3] = "N";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=AllNClassLevelCallersClassAtLeast2NGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNClassLevelCallersAtLeast2NGOLD3].toString()); 
										AllNClassLevelCallersClassAtLeast2NGold3.UpdateCounters(Result, AllNClassLevelCallersClassAtLeast2NGold3);
								
										}
										
										
								}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL N CLASS LEVEL CALLEES AT LEAST 2N
								
								
						
									
									if(CounterTraceClassCalleeTGOLD3==0 && CounterTraceClassCalleeEGOLD3==0 && CounterTraceClassCalleeNGOLD3>=2) {
									
								
										data[j][AllNClassLevelCalleesAtLeast2NGOLD3] = "N";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=AllNClassLevelCalleesClassAtLeast2NGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNClassLevelCalleesAtLeast2NGOLD3].toString()); 
										AllNClassLevelCalleesClassAtLeast2NGold3.UpdateCounters(Result, AllNClassLevelCalleesClassAtLeast2NGold3);
										
										}
									
								}
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL N METHOD LEVEL CALLERS AT LEAST 2N
								
								
							
									
									if(CountMethodTGOLD3==0 && CountMethodEGOLD3==0 && CountMethodNGOLD3>=2) {	
									
								
										data[j][AllNMethodLevelCallersAtLeast2NGOLD3] = "N";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
										String Result=AllNMethodLevelCallersClassAtLeast2NGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNMethodLevelCallersAtLeast2NGOLD3].toString()); 
										AllNMethodLevelCallersClassAtLeast2NGold3.UpdateCounters(Result, AllNMethodLevelCallersClassAtLeast2NGold3);
										
										}
								}
								
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								/**************************************************************************************************************/
								
								//ALL N METHOD LEVEL CALLEES AT LEAST 2N
								
								
							
									
									if(CountMethodTCalleeGOLD3==0 && CountMethodECalleeGOLD3==0 && CountMethodNCalleeGOLD3>=2) {
									
								
										data[j][AllNMethodLevelCalleesAtLeast2NGOLD3] = "N";
										if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
											String Result=AllNMethodLevelCalleesClassAtLeast2NGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNMethodLevelCalleesAtLeast2NGOLD3].toString()); 
											AllNMethodLevelCalleesClassAtLeast2NGold3.UpdateCounters(Result, AllNMethodLevelCalleesClassAtLeast2NGold3);
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
										
										
									
											
											if(CountMethodTCalleeGOLD3==0 && CountMethodTGOLD3==0 && CountMethodNCalleeGOLD3>=1 && CountMethodNGOLD3>=1) {
											
										
												data[j][AllNMethodLevelCallersCalleesGOLD3] = "N";
												if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
													String Result=AllNMethodLevelCallersCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNMethodLevelCallersCalleesGOLD3].toString()); 
													AllNMethodLevelCallersCalleesClassGold3.UpdateCounters(Result, AllNMethodLevelCallersCalleesClassGold3);
												}
											
												
										}
									//}
											
											
											/**************************************************************************************************************/
											/**************************************************************************************************************/
											/**************************************************************************************************************/
											
											//ALL T METHOD LEVEL CALLERS CALLEES 
											
											
										
												
												if(CountMethodNGOLD3==0 && CountMethodNCalleeGOLD3==0 && CountMethodTCalleeGOLD3>=1 && CountMethodTGOLD3>=1) {
												
											
													data[j][AllTMethodLevelCallersCalleesGOLD3] = "T";
													if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
														String Result=AllTMethodLevelCallersCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTMethodLevelCallersCalleesGOLD3].toString()); 
														AllTMethodLevelCallersCalleesClassGold3.UpdateCounters(Result, AllTMethodLevelCallersCalleesClassGold3);
													}
												
													
											}
												
												/**************************************************************************************************************/
												/**************************************************************************************************************/
												/**************************************************************************************************************/
												
												//ALL N CLASS LEVEL CALLERS CALLEES 
												
												
											
													
													if(CounterTraceClassCalleeTGOLD3==0 && CounterTraceClassCallerTGOLD3==0 && CounterTraceClassCalleeNGOLD3>=1 && CounterTraceClassCallerNGOLD3>=1) {
													
												
														data[j][AllNClassLevelCallersCalleesGOLD3] = "N";
														if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
															String Result=AllNClassLevelCallersCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNClassLevelCallersCalleesGOLD3].toString()); 
															AllNClassLevelCallersCalleesClassGold3.UpdateCounters(Result, AllNClassLevelCallersCalleesClassGold3);
														}
													
														
												}
											//}
													
													
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													
													//ALL T CLASS LEVEL CALLERS CALLEES 
													
													
												
														
														if(CounterTraceClassCalleeNGOLD3==0 && CounterTraceClassCallerNGOLD3==0 && CounterTraceClassCalleeTGOLD3>=1 && CounterTraceClassCallerTGOLD3>=1) {
														
													
															data[j][AllTClassLevelCallersCalleesGOLD3] = "T";
															if(flagGold3==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold3()!=null) {
																String Result=AllTClassLevelCallersCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllTClassLevelCallersCalleesGOLD3].toString()); 
																AllTClassLevelCallersCalleesClassGold3.UpdateCounters(Result, AllTClassLevelCallersCalleesClassGold3);
															}
														
															
													}
									

														
														if((counterParameterTGOLD4!=0 || counterParameterNGOLD4!=0|| counterParameterEGOLD4!=0)
																/*	||
																	(CounterTraceClassCallerN!=0 && CounterTraceClassCallerE!=0)
																	||(CounterTraceClassCallerT!=0 && CounterTraceClassCallerE!=0)*/
																	) {
																
																if(counterParameterTGOLD4==counterParameterNGOLD4 && counterParameterTGOLD4>0) {
																	data[j][MajorityParametersGOLD4] = "T";
																}
																else if(counterParameterTGOLD4==0 && counterParameterNGOLD4==0 && counterParameterEGOLD4>0) {
																	data[j][MajorityParametersGOLD4] = "E";
																}
																else if(counterParameterTGOLD4==0 && counterParameterNGOLD4>0 && counterParameterEGOLD4>0) {
																	data[j][MajorityParametersGOLD4] = "N";
																}
																else if (((counterParameterTGOLD4 >= counterParameterNGOLD4
																	//	&& counterParameterNGOLD4 >= counterParameterEGOLD4
																		)
																		//|| (counterParameterTGOLD4 >= counterParameterEGOLD4
																			//	&& counterParameterEGOLD4 >= counterParameterNGOLD4
																		//		)
																		)
																		) {
																	data[j][MajorityParametersGOLD4] = "T";
																}/* else if (((counterParameterEGOLD4 >= counterParameterNGOLD4
																		&& counterParameterNGOLD4 >= counterParameterTGOLD4)
																		|| (counterParameterEGOLD4 >= counterParameterTGOLD4
																				&& counterParameterTGOLD4 >= counterParameterNGOLD4))
																	) {
																	data[j][MajorityParametersGOLD4] = "E";
																} */else if ((counterParameterNGOLD4 >= counterParameterTGOLD4)) {
																	data[j][MajorityParametersGOLD4] = "N";
																}
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																	String Result=MajorityParametersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][MajorityParametersGOLD4].toString()); 
																	MajorityParametersClassGold4.UpdateCounters(Result, MajorityParametersClassGold4);
																}
																
															
																
															
															}
														
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														//AT LEAST 1N PREDICTION PARAMETER
														
														
														
														
														
														if (counterParameterNGOLD4 >=1 )
																 {
															data[j][AtLeast1NParameterGOLD4] = "N";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=AtLeast1NParameterClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1NParameterGOLD4].toString()); 
															AtLeast1NParameterClassGold4.UpdateCounters(Result, AtLeast1NParameterClassGold4);
															}
															
														} 
													
														
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														//AT LEAST 2N PREDICTION PARAMETER
														
														
														
														
														
														if (counterParameterNGOLD4 >=2 )
																 {
															data[j][AtLeast2NParameterGOLD4] = "N";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																
																String Result=AtLeast2NParameterClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2NParameterGOLD4].toString()); 
															AtLeast2NParameterClassGold4.UpdateCounters(Result, AtLeast2NParameterClassGold4);
															}
															
														} 
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													
													//AT LEAST 1T PREDICTION PARAMETER
													
													
														
														
														
														if (counterParameterTGOLD4 >=1 )
																 {
															data[j][AtLeast1TParameterGOLD4] = "T";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=AtLeast1TParameterClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1TParameterGOLD4].toString()); 
															AtLeast1TParameterClassGold4.UpdateCounters(Result, AtLeast1TParameterClassGold4);
															}
														} 
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														
														//AT LEAST 2T PREDICTION PARAMETER
														
														
															
															
															
															if (counterParameterTGOLD4 >=2 )
																	 {
																data[j][AtLeast2TParameterGOLD4] = "T";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AtLeast2TParameterClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2TParameterGOLD4].toString()); 
																AtLeast2TParameterClassGold4.UpdateCounters(Result, AtLeast2TParameterClassGold4);
																}
															} 
														/**************************************************************************************************************/
														/**************************************************************************************************************/
													    /**************************************************************************************************************/	
														
														
														
														//ALL T PARAMETER PREDICTION
														
														
														if(counterParameterEGOLD4==0 && counterParameterNGOLD4==0 && counterParameterTGOLD4>=1) {
															
															
															
														
																data[j][AllTParametersGOLD4] = "T";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AllTParameterClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTParametersGOLD4].toString()); 
																AllTParameterClassGold4.UpdateCounters(Result, AllTParameterClassGold4);
																}
																
																
														}
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														
														//ALL N PARAMETER PREDICTION
														
														
														if(counterParameterTGOLD4==0 && counterParameterEGOLD4==0 && counterParameterNGOLD4>=1) {
															
															
															
														
																data[j][AllNParametersGOLD4] = "N";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AllNParameterClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNParametersGOLD4].toString()); 
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
																data[j][MajorityClassLevelCalleesGOLD4] = "T";
															}
															else if(CounterTraceClassCalleeTGOLD4==0 && CounterTraceClassCalleeNGOLD4==0 && CounterTraceClassCalleeEGOLD4>0) {
																data[j][MajorityClassLevelCalleesGOLD4] = "E";
															}
															else if(CounterTraceClassCalleeTGOLD4==0 && CounterTraceClassCalleeNGOLD4>0 && CounterTraceClassCalleeEGOLD4>0) {
																data[j][MajorityClassLevelCalleesGOLD4] = "N";
															}
															else if ((CounterTraceClassCalleeTGOLD4 >= CounterTraceClassCalleeNGOLD4
																	)
																	) {
																data[j][MajorityClassLevelCalleesGOLD4] = "T";
															} /*else if (((CounterTraceClassCallerEGOLD4 >= CounterTraceClassCallerNGOLD4
																	&& CounterTraceClassCallerNGOLD4 >= CounterTraceClassCallerTGOLD4)
																	|| (CounterTraceClassCallerEGOLD4 >= CounterTraceClassCallerTGOLD4
																			&& CounterTraceClassCallerTGOLD4 >= CounterTraceClassCallerNGOLD4))
																) {
																data[j][MajorityClassLevelCalleesGOLD4] = "E";
															}*/ else if (CounterTraceClassCalleeNGOLD4 >= CounterTraceClassCalleeTGOLD4) {
																data[j][MajorityClassLevelCalleesGOLD4] = "N";
															}
															if(true && methodtrace.getGold4()!=null && data[j][MajorityClassLevelCalleesGOLD4]!=null) {
															String Result=MajorityClassLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][MajorityClassLevelCalleesGOLD4].toString()); 
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
																data[j][MajorityClassLevelCallersGOLD4] = "T";
															}
															else if(CounterTraceClassCallerTGOLD4==0 && CounterTraceClassCallerNGOLD4==0 && CounterTraceClassCallerEGOLD4>0) {
																data[j][MajorityClassLevelCallersGOLD4] = "E";
															}
															else if(CounterTraceClassCallerTGOLD4==0 && CounterTraceClassCallerNGOLD4>0 && CounterTraceClassCallerEGOLD4>0) {
																data[j][MajorityClassLevelCallersGOLD4] = "N";
															}
															else if(CounterTraceClassCallerTGOLD4==0 && CounterTraceClassCallerNGOLD4>0 && CounterTraceClassCallerEGOLD4>0) {
																data[j][MajorityClassLevelCallersGOLD4] = "E";
															}
															else if (CounterTraceClassCallerTGOLD4 >= CounterTraceClassCallerNGOLD4) {
																data[j][MajorityClassLevelCallersGOLD4] = "T";
															} else if (CounterTraceClassCallerNGOLD4>=CounterTraceClassCallerTGOLD4)
																 {
																data[j][MajorityClassLevelCallersGOLD4] = "N";
															} 
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=MajorityClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][MajorityClassLevelCallersGOLD4].toString()); 
															MajorityClassLevelCallersClassGold4.UpdateCounters(Result, MajorityClassLevelCallersClassGold4);
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
																data[j][MajorityMethodLevelCalleesGOLD4] = "T";
															}
															else if(CountMethodTCalleeGOLD4==0 && CountMethodNCalleeGOLD4==0 && CountMethodECalleeGOLD4>0) {
																data[j][MajorityMethodLevelCalleesGOLD4] = "E";
															}
															else if(CountMethodTCalleeGOLD4==0 && CountMethodNCalleeGOLD4>0 && CountMethodECalleeGOLD4>0) {
																data[j][MajorityMethodLevelCalleesGOLD4] = "N";
															} 
															
															else if(CountMethodTCalleeGOLD4>=CountMethodNCalleeGOLD4)
															 {
																data[j][MajorityMethodLevelCalleesGOLD4] = "T";
															}  else if (CountMethodNCalleeGOLD4 >= CountMethodTCalleeGOLD4
																
																	) {
																data[j][MajorityMethodLevelCalleesGOLD4] = "N";
															}
														
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=MajorityMethodLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][MajorityMethodLevelCalleesGOLD4].toString()); 
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
																data[j][MajorityMethodLevelCallersGOLD4] = "T";
															}
															else if(CountMethodTGOLD4==0 && CountMethodNGOLD4==0 && CountMethodEGOLD4>0) {
																data[j][MajorityMethodLevelCallersGOLD4] = "E";
															}
															else if(CountMethodTGOLD4==0 && CountMethodNGOLD4>0 && CountMethodEGOLD4>0) {
																data[j][MajorityMethodLevelCallersGOLD4] = "N";
															}
															
															else if (CountMethodTGOLD4 >= CountMethodNGOLD4){
																data[j][MajorityMethodLevelCallersGOLD4] = "T";
															}  else if (CountMethodNGOLD4 >= CountMethodTGOLD4
																	
																	) {
																data[j][MajorityMethodLevelCallersGOLD4] = "N";
															}
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=MajorityMethodLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][MajorityMethodLevelCallersGOLD4].toString()); 
															MajorityMethodLevelCallersClassGold4.UpdateCounters(Result, MajorityMethodLevelCallersClassGold4);
															}
														}
														
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														
														//1AT LEAST 1N PREDICTION CLASS LEVEL CALLERS 
														
														
															
															
															
															if (CounterTraceClassCallerNGOLD4 >=1 )
																	 {
																data[j][AtLeast1NPredictionClassLevelCallersGOLD4] = "N";
																Object var= 	data[j][AtLeast1NPredictionClassLevelCallersGOLD4]; 
																String NEWVAR=var.toString(); 
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AtLeastNPredictionClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1NPredictionClassLevelCallersGOLD4].toString()); 
																AtLeastNPredictionClassLevelCallersClassGold4.UpdateCounters(Result, AtLeastNPredictionClassLevelCallersClassGold4);
																}
															} 
														
															
														
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														
														//2AT LEAST 1T PREDICTION CLASS LEVEL CALLERS 
														
														
															
															
															
															if (CounterTraceClassCallerTGOLD4 >=1 )
																	 {
																data[j][AtLeast1TPredictionClassLevelCallersGOLD4] = "T";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AtLeastTPredictionClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1TPredictionClassLevelCallersGOLD4].toString()); 
																AtLeastTPredictionClassLevelCallersClassGold4.UpdateCounters(Result, AtLeastTPredictionClassLevelCallersClassGold4);
																}
															} 
															
																
															
														
														
												
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														
														//4AT LEAST 1N PREDICTION CLASS LEVEL CALLEES 
													
														
															
															
															
															if (CounterTraceClassCalleeNGOLD4 >=1 )
																	 {
																data[j][AtLeast1NPredictionClassLevelCalleesGOLD4] = "N";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AtLeastNPredictionClassLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1NPredictionClassLevelCalleesGOLD4].toString()); 
																AtLeastNPredictionClassLevelCalleesClassGold4.UpdateCounters(Result, AtLeastNPredictionClassLevelCalleesClassGold4);
																}
															} 
															
														
														
														
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
													
														//4AT LEAST 1T PREDICTION CLASS LEVEL CALLEES 
														
														
															
															
															
															if (CounterTraceClassCalleeTGOLD4 >=1 )
																	 {
																data[j][AtLeast1TPredictionClassLevelCalleesGOLD4] = "T";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AtLeastTPredictionClassLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1TPredictionClassLevelCalleesGOLD4].toString()); 
																AtLeastTPredictionClassLevelCalleesClassGold4.UpdateCounters(Result, AtLeastTPredictionClassLevelCalleesClassGold4);
																}
															} 
															
															
														
														
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														//5AT LEAST 1N PREDICTION METHOD LEVEL CALLERS 
														
														
															
															
															if (CountMethodNGOLD4 >=1 )
																	 {
																data[j][AtLeast1NPredictionMethodLevelCallersGOLD4] = "N";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AtLeastNPredictionMethodLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1NPredictionMethodLevelCallersGOLD4].toString()); 
																AtLeastNPredictionMethodLevelCallersClassGold4.UpdateCounters(Result, AtLeastNPredictionMethodLevelCallersClassGold4);
																}
															} 
															
															
														
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														//6AT LEAST 1T PREDICTION METHOD LEVEL CALLERS 
													
														
															
															
															
															if (CountMethodTGOLD4 >=1 )
																	 {
																data[j][AtLeast1TPredictionMethodLevelCallersGOLD4] = "T";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AtLeastTPredictionMethodLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1TPredictionMethodLevelCallersGOLD4].toString()); 
																AtLeastTPredictionMethodLevelCallersClassGold4.UpdateCounters(Result, AtLeastTPredictionMethodLevelCallersClassGold4);
																}
															} 
															
														
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														
														//7AT LEAST 1N PREDICTION METHOD LEVEL CALLEES 
														
														
															
															
															
															if (CountMethodNCalleeGOLD4 >=1 )
																	 {
																data[j][AtLeast1NPredictionMethodLevelCalleesGOLD4] = "N";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AtLeastNPredictionMethodLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1NPredictionMethodLevelCalleesGOLD4].toString()); 
																AtLeastNPredictionMethodLevelCalleesClassGold4.UpdateCounters(Result, AtLeastNPredictionMethodLevelCalleesClassGold4);
																}
															} 
															
														
												
														
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														
														//8AT LEAST 1T PREDICTION METHOD LEVEL CALLEES 
														
														
															
															
															
															if (CountMethodTCalleeGOLD4 >=1 )
																	 {
																data[j][AtLeast1TPredictionMethodLevelCalleesGOLD4] = "T";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AtLeastTPredictionMethodLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast1TPredictionMethodLevelCalleesGOLD4].toString()); 
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
																	data[j][AtLeast2NPredictionClassLevelCalleesGOLD4] = "N";
																	Object var= 	data[j][AtLeast2NPredictionClassLevelCalleesGOLD4]; 
																	String NEWVAR=var.toString(); 
																	if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																		String Result=AtLeast2NPredictionClassLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2NPredictionClassLevelCalleesGOLD4].toString()); 
																		AtLeast2NPredictionClassLevelCalleesClassGold4.UpdateCounters(Result, AtLeast2NPredictionClassLevelCalleesClassGold4);
																	}
																} 
															
																
															
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															
															//AT LEAST 2T PREDICTION CLASS LEVEL CALLEES 
															
															
																
																
																
																if (CounterTraceClassCalleeTGOLD4 >=2 )
																 {
															data[j][AtLeast2TPredictionClassLevelCalleesGOLD4] = "T";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=AtLeast2TPredictionClassLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2TPredictionClassLevelCalleesGOLD4].toString()); 
															AtLeast2TPredictionClassLevelCalleesClassGold4.UpdateCounters(Result, AtLeast2TPredictionClassLevelCalleesClassGold4);
															}
														} 
																	
																
															
															
													
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															
															//AT LEAST 2N PREDICTION METHOD LEVEL CALLERS 
														
															
																
																
																
																
																if (CountMethodNGOLD4 >=2 )
																		 {
																	data[j][AtLeast2NPredictionMethodLevelCallersGOLD4] = "N";
																	if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																	String Result=AtLeast2NPredictionMethodLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2NPredictionMethodLevelCallersGOLD4].toString()); 
																	AtLeast2NPredictionMethodLevelCallersClassGold4.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCallersClassGold4);
																	}
																} 
																
																
															
																/**************************************************************************************************************/
																/**************************************************************************************************************/
																/**************************************************************************************************************/
															
																//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
																
																
																	
																	
																	
																	if (CounterTraceClassCallerTGOLD4 >=2 )
																	 {
																data[j][AtLeast2TPredictionClassLevelCallersGOLD4] = "T";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AtLeast2TPredictionClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2TPredictionClassLevelCallersGOLD4].toString()); 
																AtLeast2TPredictionClassLevelCallersClassGold4.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClassGold4);
																}
															} 
															
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															/**************************************************************************************************************/
														
															//AT LEAST 2T PREDICTION METHOD LEVEL CALLERS 
															
															
																
																
																
																if (CountMethodTGOLD4 >=2 )
																 {
															data[j][AtLeast2TPredictionMethodLevelCallersGOLD4] = "T";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=AtLeast2TPredictionMethodLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2TPredictionMethodLevelCallersGOLD4].toString()); 
															AtLeast2TPredictionMethodLevelCallersClassGold4.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCallersClassGold4);
															}
														} 
																
																
															
															
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															//AT LEAST 2N PREDICTION METHOD LEVEL CALLEES 

																
																
																
																
																
																
																
																
																
																
																
																
																
																
																
																
																
															
																
																
																if (CountMethodNCalleeGOLD4 >=2 )
																 {
															data[j][AtLeast2NPredictionMethodLevelCalleesGOLD4] = "N";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=AtLeast2NPredictionMethodLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2NPredictionMethodLevelCalleesGOLD4].toString()); 
															AtLeast2NPredictionMethodLevelCalleesClassGold4.UpdateCounters(Result, AtLeast2NPredictionMethodLevelCalleesClassGold4);
															}	
														} 
																
																
															
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															//AT LEAST 2T PREDICTION METHOD LEVEL CALLEES 
														
															
																
																
																
																if (CountMethodTCalleeGOLD4 >=2 )
																 {
															data[j][AtLeast2TPredictionMethodLevelCalleesGOLD4] = "T";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AtLeast2TPredictionMethodLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2TPredictionMethodLevelCalleesGOLD4].toString()); 
																AtLeast2TPredictionMethodLevelCalleesClassGold4.UpdateCounters(Result, AtLeast2TPredictionMethodLevelCalleesClassGold4);

															}
															
														} 
																
															
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															
															//AT LEAST 2N PREDICTION CLASS LEVEL CALLERS 
															
															
																
																
																
																if (CounterTraceClassCallerNGOLD4 >=2 )
																 {
															data[j][AtLeast2NPredictionClassLevelCallersGOLD4] = "N";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=AtLeast2NPredictionClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2NPredictionClassLevelCallersGOLD4].toString()); 
															AtLeast2NPredictionClassLevelCallersClassGold4.UpdateCounters(Result, AtLeast2NPredictionClassLevelCallersClassGold4);
															
															}
														} 
														
															
													
															
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															
															//AT LEAST 2T PREDICTION CLASS LEVEL CALLERS 
															
															
																
																
																
																if (CounterTraceClassCallerTGOLD4 >=2 )
																 {
															data[j][AtLeast2TPredictionClassLevelCallersGOLD4] = "T";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AtLeast2TPredictionClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AtLeast2TPredictionClassLevelCallersGOLD4].toString()); 
																AtLeast2TPredictionClassLevelCallersClassGold4.UpdateCounters(Result, AtLeast2TPredictionClassLevelCallersClassGold4);

															}
															
															}
																
																
																
																
																
																
																
																
																
																
																
																
																/**************************************************************************************************************/
																/**************************************************************************************************************/
																/**************************************************************************************************************/	 
														//ALL T METHOD LEVEL CALLEES 
														
														
														if(CountMethodNCalleeGOLD4==0 && CountMethodECalleeGOLD4==0 && CountMethodTCalleeGOLD4>=1) {
															
															
															
																
																data[j][AllTMethodLevelCalleesGOLD4] = "T";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AllTMethodLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTMethodLevelCalleesGOLD4].toString()); 
																AllTMethodLevelCalleesClassGold4.UpdateCounters(Result, AllTMethodLevelCalleesClassGold4);
																}
														}
														
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														
														//ALL T METHOD LEVEL CALLERS 
														
														if(CountMethodNGOLD4==0 && CountMethodEGOLD4==0  && CountMethodTGOLD4>=1) {
															
															
															
														
																data[j][AllTMethodLevelCallersGOLD4] = "T";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AllTMethodLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTMethodLevelCallersGOLD4].toString()); 
																AllTMethodLevelCallersClassGold4.UpdateCounters(Result, AllTMethodLevelCallersClassGold4);
																
																}
															
														}
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														
														//ALL T CLASS LEVEL CALLERS 
														
														
														if(CounterTraceClassCallerEGOLD4==0 && CounterTraceClassCallerNGOLD4==0 && CounterTraceClassCallerTGOLD4>=1) {
															
															
														
																data[j][AllTClassLevelCallersGOLD4] = "T";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AllTClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTClassLevelCallersGOLD4].toString()); 
																AllTClassLevelCallersClassGold4.UpdateCounters(Result, AllTClassLevelCallersClassGold4);
																System.out.println(methodtrace.toString());
																
																}
																
																
																}
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														
														//ALL T CLASS LEVEL CALLEES 
														
														
														if(CounterTraceClassCalleeEGOLD4==0 && CounterTraceClassCalleeNGOLD4==0 && CounterTraceClassCalleeTGOLD4>=1) {
															
															
															
														
																data[j][AllTClassLevelCalleesGOLD4] = "T";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AllTClassLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTClassLevelCalleesGOLD4].toString()); 
																AllTClassLevelCalleesClassGold4.UpdateCounters(Result, AllTClassLevelCalleesClassGold4);
														
																
																}
														}
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														
														//ALL N CLASS LEVEL CALLERS 
														
														
													
															
														if(CounterTraceClassCallerTGOLD4==0 && CounterTraceClassCallerEGOLD4==0 && CounterTraceClassCallerNGOLD4>=1) {
															
														
																data[j][AllNClassLevelCallersGOLD4] = "N";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AllNClassLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNClassLevelCallersGOLD4].toString()); 
																AllNClassLevelCallersClassGold4.UpdateCounters(Result, AllNClassLevelCallersClassGold4);
															
																}
																
																
														}
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														
														//ALL N CLASS LEVEL CALLEES 
														
														
												
															
															if(CounterTraceClassCalleeTGOLD4==0 && CounterTraceClassCalleeEGOLD4==0 && CounterTraceClassCalleeNGOLD4>=1) {
															
														
																data[j][AllNClassLevelCalleesGOLD4] = "N";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AllNClassLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNClassLevelCalleesGOLD4].toString()); 
																AllNClassLevelCalleesClassGold4.UpdateCounters(Result, AllNClassLevelCalleesClassGold4);
																
																}
															
														}
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														
														//ALL N METHOD LEVEL CALLERS 
														
														
													
															
															if(CountMethodTGOLD4==0 && CountMethodEGOLD4==0 && CountMethodNGOLD4>=1) {	
															
														
																data[j][AllNMethodLevelCallersGOLD4] = "N";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AllNMethodLevelCallersClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNMethodLevelCallersGOLD4].toString()); 
																AllNMethodLevelCallersClassGold4.UpdateCounters(Result, AllNMethodLevelCallersClassGold4);
																
																}
														}
														
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														/**************************************************************************************************************/
														
														//ALL N METHOD LEVEL CALLEES 
														
														
													
															
															if(CountMethodTCalleeGOLD4==0 && CountMethodECalleeGOLD4==0 && CountMethodNCalleeGOLD4>=1) {
															
														
																data[j][AllNMethodLevelCalleesGOLD4] = "N";
																if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																	String Result=AllNMethodLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNMethodLevelCalleesGOLD4].toString()); 
																	AllNMethodLevelCalleesClassGold4.UpdateCounters(Result, AllNMethodLevelCalleesClassGold4);
																}
															
																
														}
													//}
															
														
															
															
															
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															/**************************************************************************************************************/	 
													//ALL T METHOD LEVEL CALLEES AT LEAST 2T
													
													
													if(CountMethodNCalleeGOLD4==0 && CountMethodECalleeGOLD4==0 && CountMethodTCalleeGOLD4>=2) {
														
														
														
															
															data[j][AllTMethodLevelCalleesAtLeast2TGOLD4] = "T";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=AllTMethodLevelCalleesClassAtLeast2TGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTMethodLevelCalleesAtLeast2TGOLD4].toString()); 
															AllTMethodLevelCalleesClassAtLeast2TGold4.UpdateCounters(Result, AllTMethodLevelCalleesClassAtLeast2TGold4);
															}
													}
													
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													
													//ALL T METHOD LEVEL CALLERS AT LEAST 2T
													
													if(CountMethodNGOLD4==0 && CountMethodEGOLD4==0  && CountMethodTGOLD4>=2) {
														
														
														
													
															data[j][AllTMethodLevelCallersAtLeast2TGOLD4] = "T";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=AllTMethodLevelCallersClassAtLeast2TGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTMethodLevelCallersAtLeast2TGOLD4].toString()); 
															AllTMethodLevelCallersClassAtLeast2TGold4.UpdateCounters(Result, AllTMethodLevelCallersClassAtLeast2TGold4);
															
															}
														
													}
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													
													//ALL T CLASS LEVEL CALLERS AT LEAST 2T
													
													
													if(CounterTraceClassCallerEGOLD4==0 && CounterTraceClassCallerNGOLD4==0 && CounterTraceClassCallerTGOLD4>=2) {
														
														
													
															data[j][AllTClassLevelCallersAtLeast2TGOLD4] = "T";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=AllTClassLevelCallersClassAtLeast2TGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTClassLevelCallersAtLeast2TGOLD4].toString()); 
															AllTClassLevelCallersClassAtLeast2TGold4.UpdateCounters(Result, AllTClassLevelCallersClassAtLeast2TGold4);
															System.out.println(methodtrace.toString());
															
															}
															
															
															}
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													
													//ALL T CLASS LEVEL CALLEES AT LEAST 2T
													
													
													if(CounterTraceClassCalleeEGOLD4==0 && CounterTraceClassCalleeNGOLD4==0 && CounterTraceClassCalleeTGOLD4>=2) {
														
														
														
													
															data[j][AllTClassLevelCalleesAtLeast2TGOLD4] = "T";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=AllTClassLevelCalleesClassAtLeast2TGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTClassLevelCalleesAtLeast2TGOLD4].toString()); 
															AllTClassLevelCalleesClassAtLeast2TGold4.UpdateCounters(Result, AllTClassLevelCalleesClassAtLeast2TGold4);
													
															
															}
													}
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													
													//ALL N CLASS LEVEL CALLERS AT LEAST 2N
													
													
												
														
													if(CounterTraceClassCallerTGOLD4==0 && CounterTraceClassCallerEGOLD4==0 && CounterTraceClassCallerNGOLD4>=2) {
														
													
															data[j][AllNClassLevelCallersAtLeast2NGOLD4] = "N";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=AllNClassLevelCallersClassAtLeast2NGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNClassLevelCallersAtLeast2NGOLD4].toString()); 
															AllNClassLevelCallersClassAtLeast2NGold4.UpdateCounters(Result, AllNClassLevelCallersClassAtLeast2NGold4);
													
															}
															
															
													}
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													
													//ALL N CLASS LEVEL CALLEES AT LEAST 2N
													
													
											
														
														if(CounterTraceClassCalleeTGOLD4==0 && CounterTraceClassCalleeEGOLD4==0 && CounterTraceClassCalleeNGOLD4>=2) {
														
													
															data[j][AllNClassLevelCalleesAtLeast2NGOLD4] = "N";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=AllNClassLevelCalleesClassAtLeast2NGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNClassLevelCalleesAtLeast2NGOLD4].toString()); 
															AllNClassLevelCalleesClassAtLeast2NGold4.UpdateCounters(Result, AllNClassLevelCalleesClassAtLeast2NGold4);
															
															}
														
													}
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													
													//ALL N METHOD LEVEL CALLERS AT LEAST 2N
													
													
												
														
														if(CountMethodTGOLD4==0 && CountMethodEGOLD4==0 && CountMethodNGOLD4>=2) {	
														
													
															data[j][AllNMethodLevelCallersAtLeast2NGOLD4] = "N";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
															String Result=AllNMethodLevelCallersClassAtLeast2NGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNMethodLevelCallersAtLeast2NGOLD4].toString()); 
															AllNMethodLevelCallersClassAtLeast2NGold4.UpdateCounters(Result, AllNMethodLevelCallersClassAtLeast2NGold4);
															
															}
													}
													
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													/**************************************************************************************************************/
													
													//ALL N METHOD LEVEL CALLEES AT LEAST 2N
													
													
												
														
														if(CountMethodTCalleeGOLD4==0 && CountMethodECalleeGOLD4==0 && CountMethodNCalleeGOLD4>=2) {
														
													
															data[j][AllNMethodLevelCalleesAtLeast2NGOLD4] = "N";
															if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																String Result=AllNMethodLevelCalleesClassAtLeast2NGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNMethodLevelCalleesAtLeast2NGOLD4].toString()); 
																AllNMethodLevelCalleesClassAtLeast2NGold4.UpdateCounters(Result, AllNMethodLevelCalleesClassAtLeast2NGold4);
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
															
															
														
																
																if(CountMethodTCalleeGOLD4==0 && CountMethodTGOLD4==0 && CountMethodNCalleeGOLD4>=1 && CountMethodNGOLD4>=1) {
																
															
																	data[j][AllNMethodLevelCallersCalleesGOLD4] = "N";
																	if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																		String Result=AllNMethodLevelCallersCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNMethodLevelCallersCalleesGOLD4].toString()); 
																		AllNMethodLevelCallersCalleesClassGold4.UpdateCounters(Result, AllNMethodLevelCallersCalleesClassGold4);
																	}
																
																	
															}
														//}
																
																
																/**************************************************************************************************************/
																/**************************************************************************************************************/
																/**************************************************************************************************************/
																
																//ALL T METHOD LEVEL CALLERS CALLEES 
																
																
															
																	
																	if(CountMethodNGOLD4==0 && CountMethodNCalleeGOLD4==0 && CountMethodTCalleeGOLD4>=1 && CountMethodTGOLD4>=1) {
																	
																
																		data[j][AllTMethodLevelCallersCalleesGOLD4] = "T";
																		if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																			String Result=AllTMethodLevelCallersCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTMethodLevelCallersCalleesGOLD4].toString()); 
																			AllTMethodLevelCallersCalleesClassGold4.UpdateCounters(Result, AllTMethodLevelCallersCalleesClassGold4);
																		}
																	
																		
																}
																	
																	/**************************************************************************************************************/
																	/**************************************************************************************************************/
																	/**************************************************************************************************************/
																	
																	//ALL N CLASS LEVEL CALLERS CALLEES 
																	
																	
																
																		
																		if(CounterTraceClassCalleeTGOLD4==0 && CounterTraceClassCallerTGOLD4==0 && CounterTraceClassCalleeNGOLD4>=1 && CounterTraceClassCallerNGOLD4>=1) {
																		
																	
																			data[j][AllNClassLevelCallersCalleesGOLD4] = "N";
																			if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																				String Result=AllNClassLevelCallersCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNClassLevelCallersCalleesGOLD4].toString()); 
																				AllNClassLevelCallersCalleesClassGold4.UpdateCounters(Result, AllNClassLevelCallersCalleesClassGold4);
																			}
																		
																			
																	}
																//}
																		
																		
																		/**************************************************************************************************************/
																		/**************************************************************************************************************/
																		/**************************************************************************************************************/
																		
																		//ALL T CLASS LEVEL CALLERS CALLEES 
																		
																		
																	
																			
																			if(CounterTraceClassCalleeNGOLD4==0 && CounterTraceClassCallerNGOLD4==0 && CounterTraceClassCalleeTGOLD4>=1 && CounterTraceClassCallerTGOLD4>=1) {
																			
																		
																				data[j][AllTClassLevelCallersCalleesGOLD4] = "T";
																				if(flagGold4==false && methodtrace.Requirement.getID().equals("10") && methodtrace.getGold4()!=null) {
																					String Result=AllTClassLevelCallersCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTClassLevelCallersCalleesGOLD4].toString()); 
																					AllTClassLevelCallersCalleesClassGold4.UpdateCounters(Result, AllTClassLevelCallersCalleesClassGold4);
																				}
																			
																				
																		}					
									String TracePureGoldValue="null"; 
									String TraceMixedGoldValue="null"; 
								
									String NOTracePureGoldValue="null"; 
									String NOTraceMixedGoldValue="null"; 
									String NOTracePureGold3Value="null"; 
									String NOTraceMixedGold3Value="null"; 
									String TracePureGold3Value="null"; 
									String TraceMixedGold3Value="null"; 
									
									String NOTracePureGold4Value="null"; 
									String NOTraceMixedGold4Value="null"; 
									String TracePureGold4Value="null"; 
									String TraceMixedGold4Value="null"; 
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
										
	if(CountMethodTACHRAFGold3>0 && CountMethodTACHRAFCalleeGold3>0) {
											
											boolean entered=false; 
											if(CountMethodNACHRAF+CountMethodNACHRAFCallee==0 && methodtrace.getGold3()!=null ) {
												
												TracePureGold3++; 
												TracePureGold3Value="T"; 
												entered=true; 
												
											} else if(methodtrace.getGold3()!=null ) {
												TraceMixedGold3++; 
												TraceMixedGold3Value="T"; 
												entered=true; 
											}
										
											if(entered==true) {
											if(methodtrace.getGold3()!=null && methodtrace.getGold3().trim().equals("T")) {
												TraceCountTotal++; 
												
											}
											else if(methodtrace.getGold3()!=null && methodtrace.getGold3().trim().equals("N")) {
												NoTraceCountTotal++; 
											}
											
											
											if(methodtrace.getGold3()!=null ) {
											data[j][ACHRAFTRACEPureGOLD3]=TracePureGold3Value; 
											String Result=ACHRAFTracePureGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), TracePureGold3Value); 
											ACHRAFTracePureGold3.UpdateCounters(Result, ACHRAFTracePureGold3);
											}
											
											if(methodtrace.getGold3()!=null ) {
												data[j][ACHRAFTRACEMixedGOLD3]=TraceMixedGold3Value; 
												String Result=ACHRAFTraceMixedGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), TraceMixedGold3Value); 
												ACHRAFTraceMixedGold3.UpdateCounters(Result, ACHRAFTraceMixedGold3);
												}
											}
											
									}else if(CountMethodNACHRAF>0 && CountMethodNACHRAFCallee>0) {
										
										boolean entered=false; 
										if(CountMethodTACHRAFGold3+CountMethodTACHRAFCalleeGold3==0 && methodtrace.getGold3()!=null ) {
											
											NoTracePureGold3++; 
											NOTracePureGold3Value="N"; 
											data[j][ACHRAFNOTRACEPureGOLD3]=NOTracePureGold3Value; 
											entered=true; 
											
											
										} else if(methodtrace.getGold3()!=null )  {
											NoTraceMixedGold3++; 
											NOTraceMixedGold3Value="N"; 
											data[j][ACHRAFNOTRACEMixedGOLD3]=NOTraceMixedGold3Value; 
											entered=true; 
										}
										
										if(entered==true) {
										if(methodtrace.getGold3()!=null && methodtrace.getGold3().trim().equals("N")) {
											
											NoTraceCountTotal++; 
										}
											else if(methodtrace.getGold3()!=null && methodtrace.getGold3().trim().equals("T")) {
											TraceCountTotal++; 
										}
										
										
										
										
										
							
										
										
										if(methodtrace.getGold3()!=null ) {
											String Result=ACHRAFNOTracePureGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), NOTracePureGold3Value); 
											ACHRAFNOTracePureGold3.UpdateCounters(Result, ACHRAFNOTracePureGold3);
											}
											
											if(methodtrace.getGold3()!=null ) {
												String Result=ACHRAFNOTraceMixedGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), NOTraceMixedGold3Value); 
												ACHRAFNOTraceMixedGold3.UpdateCounters(Result, ACHRAFNOTraceMixedGold3);
												}
										}
										
								}else {
									failGold3++; 
								}
	/********************************************************************************************************************/				
	
if(CountMethodTACHRAFGold4>0 && CountMethodTACHRAFCalleeGold4>0) {
										
										boolean entered=false; 
										if(CountMethodNACHRAF+CountMethodNACHRAFCallee==0 && methodtrace.getGold4()!=null ) {
											
											TracePureGold4++; 
											TracePureGold4Value="T"; 
											entered=true; 
											
										} else if(methodtrace.getGold4()!=null )  {
											TraceMixedGold4++; 
											TraceMixedGold4Value="T"; 
											entered=true; 
										}
									
										if(entered==true) {
										if(methodtrace.getGold4()!=null && methodtrace.getGold4().trim().equals("T")) {
											TraceCountTotal++; 
											
										}
										else if(methodtrace.getGold4()!=null && methodtrace.getGold4().trim().equals("N")) {
											NoTraceCountTotal++; 
										}
										
										
										if(methodtrace.getGold4()!=null ) {
										data[j][ACHRAFTRACEPureGOLD4]=TracePureGold4Value; 
										String Result=ACHRAFTracePureGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), TracePureGold4Value); 
										ACHRAFTracePureGold4.UpdateCounters(Result, ACHRAFTracePureGold4);
										}
										
										if(methodtrace.getGold4()!=null ) {
											data[j][ACHRAFTRACEMixedGOLD4]=TraceMixedGold4Value; 
											String Result=ACHRAFTraceMixedGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), TraceMixedGold4Value); 
											ACHRAFTraceMixedGold4.UpdateCounters(Result, ACHRAFTraceMixedGold4);
											}
										}
										
								}else if(CountMethodNACHRAF>0 && CountMethodNACHRAFCallee>0) {
									
									boolean entered=false; 
									if(CountMethodTACHRAFGold4+CountMethodTACHRAFCalleeGold4==0 && methodtrace.getGold4()!=null ) {
										
										NoTracePureGold4++; 
										NOTracePureGold4Value="N"; 
										data[j][ACHRAFNOTRACEPureGOLD4]=NOTracePureGold4Value; 
										entered=true; 
										
										
									} else if(methodtrace.getGold4()!=null )  {
										NoTraceMixedGold4++; 
										NOTraceMixedGold4Value="N"; 
										data[j][ACHRAFNOTRACEMixedGOLD4]=NOTraceMixedGold4Value; 
										entered=true; 
									}
									
									if(entered==true) {
									if(methodtrace.getGold4()!=null && methodtrace.getGold4().trim().equals("N")) {
										
										NoTraceCountTotal++; 
									}
										else if(methodtrace.getGold4()!=null && methodtrace.getGold4().trim().equals("T")) {
										TraceCountTotal++; 
									}
									
									
									
									
									
						
									
									
									if(methodtrace.getGold4()!=null ) {
										String Result=ACHRAFNOTracePureGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), NOTracePureGold4Value); 
										ACHRAFNOTracePureGold4.UpdateCounters(Result, ACHRAFNOTracePureGold4);
										}
										
										if(methodtrace.getGold4()!=null ) {
											String Result=ACHRAFNOTraceMixedGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), NOTraceMixedGold4Value); 
											ACHRAFNOTraceMixedGold4.UpdateCounters(Result, ACHRAFNOTraceMixedGold4);
											}
									}
									
							}else {
								failGold4++; 
							}
				
					
					
					
					
					
					
					
					
					
					
					
					
/**************************************************************************************************************/
/**************************************************************************************************************/
/**************************************************************************************************************/				
String TracePureGoldValueMethodLevel="null"; 
String TraceMixedGoldValueMethodLevel="null"; 
String TracePureGold3ValueMethodLevel="null"; 
String TraceMixedGold3ValueMethodLevel="null"; 
String NOTracePureGoldValueMethodLevel="null"; 
String NOTraceMixedGoldValueMethodLevel="null"; 
String NOTracePureGold3ValueMethodLevel="null"; 
String NOTraceMixedGold3ValueMethodLevel="null"; 
String TracePureGold4ValueMethodLevel="null"; 
String TraceMixedGold4ValueMethodLevel="null"; 
String NOTracePureGold4ValueMethodLevel="null"; 
String NOTraceMixedGold4ValueMethodLevel="null"; 
/**************************************************************************************************************/
/**************************************************************************************************************/
/**************************************************************************************************************/
//ACHRAF
if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
	

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
	if(methodtrace.getGold()!=null) {
	data[j][CLASSTRACEMethodLevelPureGold]=TracePureGoldValueMethodLevel; 
	String Result=PredictionCLASSTRACEMethodLevelPureGold.ComparePredictionToGold(methodtrace.getGold().trim(), TracePureGoldValueMethodLevel); 
	PredictionCLASSTRACEMethodLevelPureGold.UpdateCounters(Result, PredictionCLASSTRACEMethodLevelPureGold);
	}
	
	if(methodtrace.getGold()!=null) {
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
if(flagGold3==false && methodtrace.Requirement.getID().equals("10")) {
if(CountMethodTGOLD3>0 && CountMethodTCalleeGOLD3>0) {
	
	boolean entered=false; 
	if(CountMethodNGOLD3+CountMethodNCalleeGOLD3==0 && methodtrace.getGold3()!=null ) {
		
		TracePureGold3++; 
		TracePureGold3ValueMethodLevel="T"; 
		entered=true; 
		
	} else if(methodtrace.getGold3()!=null) {
		TraceMixedGold3++; 
		TraceMixedGold3ValueMethodLevel="T"; 
		entered=true; 
	}

	if(entered==true) {
	
	if(methodtrace.getGold3()!=null ) {
	data[j][CLASSTRACEMethodLevelPureGold3]=TracePureGold3ValueMethodLevel; 
	String Result=PredictionCLASSTRACEMethodLevelPureGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), TracePureGold3ValueMethodLevel); 
	PredictionCLASSTRACEMethodLevelPureGold3.UpdateCounters(Result, PredictionCLASSTRACEMethodLevelPureGold3);
	}
	
	if(methodtrace.getGold3()!=null ) {
		data[j][CLASSTRACEMethodLevelMixedGold3]=TraceMixedGold3ValueMethodLevel; 
		String Result=PredictionCLASSTRACEMethodLevelMixedGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), TraceMixedGold3ValueMethodLevel); 
		PredictionCLASSTRACEMethodLevelMixedGold3.UpdateCounters(Result, PredictionCLASSTRACEMethodLevelMixedGold3);
		}
	}
	
}else if(CountMethodNGOLD3>0 && CountMethodNCalleeGOLD3>0) {

boolean entered=false; 
if(CountMethodTGOLD3+CountMethodTCalleeGOLD3==0 && methodtrace.getGold3()!=null ) {
	
	NoTracePureGold3++; 
	NOTracePureGold3ValueMethodLevel="N"; 
	data[j][CLASSNOTRACEMethodLevelPureGold3]=NOTracePureGold3ValueMethodLevel; 
	entered=true; 
	
	
} else if(methodtrace.getGold3()!=null) {
	NoTraceMixedGold3++; 
	NOTraceMixedGold3ValueMethodLevel="N"; 
	data[j][CLASSNOTRACEMethodLevelMixedGold3]=NOTraceMixedGold3ValueMethodLevel; 
	entered=true; 
}

if(entered==true) {







if(methodtrace.getGold3()!=null ) {
	String Result=PredictionCLASSNOTRACEMethodLevelPureGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), NOTracePureGold3ValueMethodLevel); 
	PredictionCLASSNOTRACEMethodLevelPureGold3.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelPureGold3);
	}
	
	if(methodtrace.getGold3()!=null ) {
		String Result=PredictionCLASSNOTRACEMethodLevelMixedGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), NOTraceMixedGold3ValueMethodLevel); 
		PredictionCLASSNOTRACEMethodLevelMixedGold3.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelMixedGold3);
		}
}

}else {
failGold3++; 
}

}


/********************************************************************************************************************/				
if(flagGold4==false && methodtrace.Requirement.getID().equals("10")) {
if(CountMethodTGOLD4>0 && CountMethodTCalleeGOLD4>0) {
	
	boolean entered=false; 
	if(CountMethodNGOLD4+CountMethodNCalleeGOLD4==0 && methodtrace.getGold4()!=null ) {
		
		TracePureGold4++; 
		TracePureGold4ValueMethodLevel="T"; 
		entered=true; 
		
	} else if(methodtrace.getGold4()!=null) {
		TraceMixedGold4++; 
		TraceMixedGold4ValueMethodLevel="T"; 
		entered=true; 
	}

	if(entered==true) {
	
	if(methodtrace.getGold4()!=null) {
	data[j][CLASSTRACEMethodLevelPureGold4]=TracePureGold4ValueMethodLevel; 
	String Result=PredictionCLASSTRACEMethodLevelPureGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), TracePureGold4ValueMethodLevel); 
	PredictionCLASSTRACEMethodLevelPureGold4.UpdateCounters(Result, PredictionCLASSTRACEMethodLevelPureGold4);
	}
	}
	
	if(entered==true) {
	if(methodtrace.getGold4()!=null) {
		data[j][CLASSTRACEMethodLevelMixedGold4]=TraceMixedGold4ValueMethodLevel; 
		String Result=PredictionCLASSTRACEMethodLevelMixedGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), TraceMixedGold4ValueMethodLevel); 
		PredictionCLASSTRACEMethodLevelMixedGold4.UpdateCounters(Result, PredictionCLASSTRACEMethodLevelMixedGold4);
		
		if(Result!=null) {
			System.out.println("MY RESULT "+Result);
			if(Result.equals("FP")) {
				bwlog.write("***********************************"); 
				bwlog.newLine();
				bwlog.write(methodtrace.toString());
				bwlog.newLine();
				for(Method call: methodtrace.getCallersList()) {
					bwlog.write("callerlist "+ call.toString2());
					
					 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.ID,methodtrace.Requirement.getID()); 
					 if(trace2!=null) {
						 bwlog.newLine();
						 bwlog.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.ID,methodtrace.Requirement.getID()).getTrace4());
						
						
					 }
					 bwlog.newLine();
				}
				for(Method call: methodtrace.getCallersListExecuted()) {
					bwlog.write("callerlistEXEC "+ call.toString2());
					bwlog.newLine();
					 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.ID,methodtrace.Requirement.getID()); 

					 if(trace2!=null) {
						 bwlog.newLine();
						 bwlog.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.ID,methodtrace.Requirement.getID()).getTrace4());
						
						
					 }
					 bwlog.newLine();
				}
				for(Method call: methodtrace.getCalleesList()) {
					bwlog.write("calleelist "+ call.toString2());
					bwlog.newLine();
					 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.ID,methodtrace.Requirement.getID()); 

					 if(trace2!=null) {
						 bwlog.newLine();
						 bwlog.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.ID,methodtrace.Requirement.getID()).getTrace4());
						
						
					 }
					 bwlog.newLine();
				}
				for(Method call: methodtrace.getCalleesListExecuted()) {
					bwlog.write("calleelistEXEC "+ call.toString2());
					bwlog.newLine();
					 ClassTrace2 trace2 = myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.ID,methodtrace.Requirement.getID()); 

					 if(trace2!=null) {
						 bwlog.newLine();
						 bwlog.write("trace value "+myclasstrace.FindTrace2(methodtracesRequirementClass, call.classrep.ID,methodtrace.Requirement.getID()).getTrace4());
						
						
					 }
					 bwlog.newLine();
				}
				bwlog.write("***********************************"); 
				bwlog.newLine();
			}
		}
		
		}
	}
	
}else if(CountMethodNGOLD4>0 && CountMethodNCalleeGOLD4>0) {

boolean entered=false; 
if(CountMethodTGOLD4+CountMethodTCalleeGOLD4==0 && methodtrace.getGold4()!=null ) {
	
	NoTracePureGold4++; 
	NOTracePureGold4ValueMethodLevel="N"; 
	data[j][CLASSNOTRACEMethodLevelPureGold4]=NOTracePureGold4ValueMethodLevel; 
	entered=true; 
	
	
} else if(methodtrace.getGold4()!=null) {
	NoTraceMixedGold4++; 
	NOTraceMixedGold4ValueMethodLevel="N"; 
	data[j][CLASSNOTRACEMethodLevelMixedGold4]=NOTraceMixedGold4ValueMethodLevel; 
	entered=true; 
}

if(entered==true) {







if(methodtrace.getGold4()!=null ) {
	String Result=PredictionCLASSNOTRACEMethodLevelPureGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), NOTracePureGold4ValueMethodLevel); 
	PredictionCLASSNOTRACEMethodLevelPureGold4.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelPureGold4);
	}
	
	if(methodtrace.getGold4()!=null ) {
		String Result=PredictionCLASSNOTRACEMethodLevelMixedGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), NOTraceMixedGold4ValueMethodLevel); 
		PredictionCLASSNOTRACEMethodLevelMixedGold4.UpdateCounters(Result, PredictionCLASSNOTRACEMethodLevelMixedGold4);
		
		

		
		
		
		
		
		
		
		
		}
}

}else {
failGold4++; 
}

}




String TracePureGoldValueClassLevel="null"; 
String TraceMixedGoldValueClassLevel="null"; 
String TracePureGold3ValueClassLevel="null"; 
String TraceMixedGold3ValueClassLevel="null"; 
String NOTracePureGoldValueClassLevel="null"; 
String NOTraceMixedGoldValueClassLevel="null"; 
String NOTracePureGold3ValueClassLevel="null"; 
String NOTraceMixedGold3ValueClassLevel="null"; 
String NOTracePureGold4ValueClassLevel="null"; 
String NOTraceMixedGold4ValueClassLevel="null"; 
String TracePureGold4ValueClassLevel="null"; 
String TraceMixedGold4ValueClassLevel="null"; 
/**************************************************************************************************************/
/**************************************************************************************************************/
/**************************************************************************************************************/
//ACHRAF
if(flagGold==false && methodtrace.Requirement.getID().equals("10")) {
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
if(flagGold3==false && methodtrace.Requirement.getID().equals("10")) {
if(CounterTraceClassCallerTGOLD3>0 && CounterTraceClassCalleeTGOLD3>0) {

boolean entered=false; 
if(CounterTraceClassCallerNGOLD3+CounterTraceClassCalleeNGOLD3==0 && methodtrace.getGold3()!=null ) {
	
	TracePureGold3++; 
	TracePureGold3ValueClassLevel="T"; 
	entered=true; 
	
} else if(methodtrace.getGold3()!=null) {
	TraceMixedGold3++; 
	TraceMixedGold3ValueClassLevel="T"; 
	entered=true; 
}

if(entered==true) {

if(methodtrace.getGold3()!=null ) {
data[j][CLASSTRACEClassLevelPureGold3]=TracePureGold3ValueClassLevel; 
String Result=PredictionCLASSTRACEClassLevelPureGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), TracePureGold3ValueClassLevel); 
PredictionCLASSTRACEClassLevelPureGold3.UpdateCounters(Result, PredictionCLASSTRACEClassLevelPureGold3);
}

if(methodtrace.getGold3()!=null ) {
	data[j][CLASSTRACEClassLevelMixedGold3]=TraceMixedGold3ValueClassLevel; 
	String Result=PredictionCLASSTRACEClassLevelMixedGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), TraceMixedGold3ValueClassLevel); 
	PredictionCLASSTRACEClassLevelMixedGold3.UpdateCounters(Result, PredictionCLASSTRACEClassLevelMixedGold3);
	}
}

}else if(CounterTraceClassCallerNGOLD3>0 && CounterTraceClassCalleeNGOLD3>0) {

boolean entered=false; 
if(CounterTraceClassCallerTGOLD3+CounterTraceClassCalleeTGOLD3==0 && methodtrace.getGold3()!=null ) {

NoTracePureGold3++; 
NOTracePureGold3ValueClassLevel="N"; 
data[j][CLASSNOTRACEClassLevelPureGold3]=NOTracePureGold3ValueClassLevel; 
entered=true; 


} else if(methodtrace.getGold3()!=null) {
NoTraceMixedGold3++; 
NOTraceMixedGold3ValueClassLevel="N"; 
data[j][CLASSNOTRACEClassLevelMixedGold3]=NOTraceMixedGold3ValueClassLevel; 
entered=true; 
}

if(entered==true) {







if(methodtrace.getGold3()!=null ) {
String Result=PredictionCLASSNOTRACEClassLevelPureGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), NOTracePureGold3ValueClassLevel); 
PredictionCLASSNOTRACEClassLevelPureGold3.UpdateCounters(Result, PredictionCLASSNOTRACEClassLevelPureGold3);
}

if(methodtrace.getGold3()!=null ) {
	String Result=PredictionCLASSNOTRACEClassLevelMixedGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), NOTraceMixedGold3ValueClassLevel); 
	PredictionCLASSNOTRACEClassLevelMixedGold3.UpdateCounters(Result, PredictionCLASSNOTRACEClassLevelMixedGold3);
	}
}

}else {
failGold3++; 
}



}
/********************************************************************************************************************/				
if(flagGold4==false && methodtrace.Requirement.getID().equals("10")) {
if(CounterTraceClassCallerTGOLD4>0 && CounterTraceClassCalleeTGOLD4>0) {

boolean entered=false; 
if(CounterTraceClassCallerNGOLD4+CounterTraceClassCalleeNGOLD4==0 && methodtrace.getGold4()!=null ) {
	
	TracePureGold4++; 
	TracePureGold4ValueClassLevel="T"; 
	entered=true; 
	
} else if(methodtrace.getGold4()!=null) {
	TraceMixedGold4++; 
	TraceMixedGold4ValueClassLevel="T"; 
	entered=true; 
}

if(entered==true) {

if(methodtrace.getGold4()!=null ) {
data[j][CLASSTRACEClassLevelPureGold4]=TracePureGold4ValueClassLevel; 
String Result=PredictionCLASSTRACEClassLevelPureGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), TracePureGold4ValueClassLevel); 
PredictionCLASSTRACEClassLevelPureGold4.UpdateCounters(Result, PredictionCLASSTRACEClassLevelPureGold4);
}

if(methodtrace.getGold4()!=null ) {
	data[j][CLASSTRACEClassLevelMixedGold4]=TraceMixedGold4ValueClassLevel; 
	String Result=PredictionCLASSTRACEClassLevelMixedGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), TraceMixedGold4ValueClassLevel); 
	PredictionCLASSTRACEClassLevelMixedGold4.UpdateCounters(Result, PredictionCLASSTRACEClassLevelMixedGold4);
	}
}

}else if(CounterTraceClassCallerNGOLD4>0 && CounterTraceClassCalleeNGOLD4>0) {

boolean entered=false; 
if(CounterTraceClassCallerTGOLD4+CounterTraceClassCalleeTGOLD4==0 && methodtrace.getGold4()!=null ) {

NoTracePureGold4++; 
NOTracePureGold4ValueClassLevel="N"; 
data[j][CLASSNOTRACEClassLevelPureGold4]=NOTracePureGold4ValueClassLevel; 
entered=true; 


} else if(methodtrace.getGold4()!=null) {
NoTraceMixedGold4++; 
NOTraceMixedGold4ValueClassLevel="N"; 
data[j][CLASSNOTRACEClassLevelMixedGold4]=NOTraceMixedGold4ValueClassLevel; 
entered=true; 
}

if(entered==true) {







if(methodtrace.getGold4()!=null ) {
String Result=PredictionCLASSNOTRACEClassLevelPureGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), NOTracePureGold4ValueClassLevel); 
PredictionCLASSNOTRACEClassLevelPureGold4.UpdateCounters(Result, PredictionCLASSNOTRACEClassLevelPureGold4);
}

if(methodtrace.getGold4()!=null ) {
	String Result=PredictionCLASSNOTRACEClassLevelMixedGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), NOTraceMixedGold4ValueClassLevel); 
	PredictionCLASSNOTRACEClassLevelMixedGold4.UpdateCounters(Result, PredictionCLASSNOTRACEClassLevelMixedGold4);
	}
}

}else {
failGold4++; 
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

			bwGold4TableLog.write(data[j][Row] + "," +data[j][MethodID] + "," + data[j][MethodName] + "," + data[j][RequirementID] + "," + data[j][RequirementName] + "," + data[j][ClassID] + ","
					+ data[j][ClassName] + "," + data[j][Gold4] + "," + data[j][Subject] + "," + data[j][OwnerClassTGOLD4] + "," + data[j][OwnerClassNGOLD4] + ","
					+ data[j][OwnerClassEGOLD4] + "," + data[j][CallerMethodsNumberGOLD4]+ "," + AppendedCallers + "," + data[j][CallerMethodsTGOLD4] + "," +
					data[j][CallerMethodsNGOLD4] + "," + data[j][CallerMethodsEGOLD4] + ","
					+ data[j][CallerClassesNumberGOLD4] + "," + data[j][CallerClassesTGOLD4] + "," + data[j][CallerClassesNGOLD4] + "," + data[j][CallerClassesEGOLD4] + 
					"," + data[j][CalleeMethodsNumberGOLD4]+ "," + AppendedCallees +  ","
					+ data[j][CalleeMethodsTGOLD4] + "," + data[j][CalleeMethodsNGOLD4] + "," + data[j][CalleeMethodsEGOLD4] + "," + data[j][CalleeClassesNumberGOLD4] + 
					"," + data[j][CalleeClassesTGOLD4] + ","
					+ data[j][CalleeClassesNGOLD4] + "," + data[j][CalleeClassesEGOLD4] + "," + data[j][OwnerClassPredictionGOLD4] + "," + data[j][MajorityClassLevelCallersGOLD4]+ "," +
					data[j][MajorityClassLevelCalleesGOLD4]+","+data[j][MajorityMethodLevelCallersGOLD4]+","+data[j][MajorityMethodLevelCalleesGOLD4]
							+ "," + 
					data[j][AtLeast1NPredictionClassLevelCallersGOLD4]+ "," + data[j][AtLeast1NPredictionClassLevelCalleesGOLD4] 
					+ "," + data[j][AtLeast1NPredictionMethodLevelCallersGOLD4]+ "," + data[j][AtLeast1NPredictionMethodLevelCalleesGOLD4]
					+ "," +data[j][AtLeast1TPredictionClassLevelCallersGOLD4]+ "," + data[j][AtLeast1TPredictionClassLevelCalleesGOLD4]
					+ "," + data[j][AtLeast1TPredictionMethodLevelCallersGOLD4]
					+ "," + data[j][AtLeast1TPredictionMethodLevelCalleesGOLD4]
							+ "," + 
							data[j][AtLeast2NPredictionClassLevelCallersGOLD4]+ "," + data[j][AtLeast2NPredictionClassLevelCalleesGOLD4] 
							+ "," + data[j][AtLeast2NPredictionMethodLevelCallersGOLD4]+ "," + data[j][AtLeast2NPredictionMethodLevelCalleesGOLD4]
							+ "," +data[j][AtLeast2TPredictionClassLevelCallersGOLD4]+ "," + data[j][AtLeast2TPredictionClassLevelCalleesGOLD4]
							+ "," + data[j][AtLeast2TPredictionMethodLevelCallersGOLD4]
							+ "," + data[j][AtLeast2TPredictionMethodLevelCalleesGOLD4]	
									+ "," + data[j][AllNClassLevelCallersGOLD4]
											+ "," +data[j][AllNClassLevelCalleesGOLD4]+ "," + data[j][AllNMethodLevelCallersGOLD4]+ "," + data[j][AllNMethodLevelCalleesGOLD4]+ "," +
											data[j][AllTClassLevelCallersGOLD4]+ ","+		data[j][AllTClassLevelCalleesGOLD4]+ ","+		data[j][AllTMethodLevelCallersGOLD4]+ 
											","+		data[j][AllTMethodLevelCalleesGOLD4]+","+
											
						","+data[j][AllNClassLevelCallersAtLeast2NGOLD4]
								+ "," +data[j][AllNClassLevelCallersAtLeast2NGOLD4]+ "," + data[j][AllNMethodLevelCallersAtLeast2NGOLD4]+ "," + data[j][AllNMethodLevelCalleesAtLeast2NGOLD4]+ "," +
								data[j][AllTClassLevelCallersAtLeast2TGOLD4]+ ","+		data[j][AllTClassLevelCalleesAtLeast2TGOLD4]+ ","+		data[j][AllTMethodLevelCallersAtLeast2TGOLD4]+ 
								","+
											
											OnlyinParsedCallers	+","+ OnlyinExecutedCallers+","+BothParsedAndExecutedCallers+","+OnlyInParsedCallees+","+OnlyInExecutedCallees
											+","+BothInParsedAndExecutedCallees+","+data[j][paramatersNumber]+","+ParametersAppended+","+data [j][CountParamaterTGOLD4]+","+data [j][CountParamaterNGOLD4]+","+data [j][CountParamaterEGOLD4]+","+data[j][MajorityParametersGOLD4]+","+data[j][AtLeast1NParameterGOLD4]
													+","+data[j][AtLeast1TParameter]+","+data[j][AtLeast2TParameter]+","+data[j][AtLeast2NParameter]+","+data[j][AllNParameters]+","+data[j][AllTParameters]+","+
													data[j][ACHRAFTRACEPureGOLD4]+","+data[j][ACHRAFTRACEMixedGOLD4]+","+data[j][ACHRAFNOTRACEPureGOLD4]+","+data[j][ACHRAFNOTRACEMixedGOLD4]+","+	
													data[j][AllNMethodLevelCallersCalleesGOLD4]+","+data[j][AllTMethodLevelCallersCalleesGOLD4]+","+data[j][AllTClassLevelCallersCalleesGOLD4]+","+data[j][AllNClassLevelCallersCalleesGOLD4]+","+	
													data[j][CLASSTRACEMethodLevelPureGold4]+","+data[j][CLASSTRACEMethodLevelMixedGold4]+","+data[j][CLASSNOTRACEMethodLevelPureGold4]+","+data[j][CLASSNOTRACEMethodLevelMixedGold4]+","+	
													data[j][CLASSTRACEClassLevelPureGold4]+","+data[j][CLASSTRACEClassLevelMixedGold4]+","+data[j][CLASSNOTRACEClassLevelPureGold4]+","+data[j][CLASSNOTRACEClassLevelMixedGold4]
					
					);
			bwGold4TableLog.newLine();
			bwGold3TableLog.write(data[j][Row] + "," +data[j][MethodID] + "," + data[j][MethodName] + "," + data[j][RequirementID] + "," + data[j][RequirementName] + "," + data[j][ClassID] + ","
					+ data[j][ClassName] + "," + data[j][Gold3] + "," + data[j][Subject] + "," + data[j][OwnerClassTGOLD3] + "," + data[j][OwnerClassNGOLD3] + ","
					+ data[j][OwnerClassEGOLD3] + "," + data[j][CallerMethodsNumberGOLD3]+ "," + AppendedCallers + "," + data[j][CallerMethodsTGOLD3] + "," +
					data[j][CallerMethodsNGOLD3] + "," + data[j][CallerMethodsEGOLD3] + ","
					+ data[j][CallerClassesNumberGOLD3] + "," + data[j][CallerClassesTGOLD3] + "," + data[j][CallerClassesNGOLD3] + "," + data[j][CallerClassesEGOLD3] + 
					"," + data[j][CalleeMethodsNumberGOLD3]+ "," + AppendedCallees +  ","
					+ data[j][CalleeMethodsTGOLD3] + "," + data[j][CalleeMethodsNGOLD3] + "," + data[j][CalleeMethodsEGOLD3] + "," + data[j][CalleeClassesNumberGOLD3] + 
					"," + data[j][CalleeClassesTGOLD3] + ","
					+ data[j][CalleeClassesNGOLD3] + "," + data[j][CalleeClassesEGOLD3] + "," + data[j][OwnerClassPredictionGOLD3] + "," + data[j][MajorityClassLevelCallersGOLD3]+ "," +
					data[j][MajorityClassLevelCalleesGOLD3]+","+data[j][MajorityMethodLevelCallersGOLD3]+","+data[j][MajorityMethodLevelCalleesGOLD3]
							+ "," + 
					data[j][AtLeast1NPredictionClassLevelCallersGOLD3]+ "," + data[j][AtLeast1NPredictionClassLevelCalleesGOLD3] 
					+ "," + data[j][AtLeast1NPredictionMethodLevelCallersGOLD3]+ "," + data[j][AtLeast1NPredictionMethodLevelCalleesGOLD3]
					+ "," +data[j][AtLeast1TPredictionClassLevelCallersGOLD3]+ "," + data[j][AtLeast1TPredictionClassLevelCalleesGOLD3]
					+ "," + data[j][AtLeast1TPredictionMethodLevelCallersGOLD3]
					+ "," + data[j][AtLeast1TPredictionMethodLevelCalleesGOLD3]
							+ "," + 
							data[j][AtLeast2NPredictionClassLevelCallersGOLD3]+ "," + data[j][AtLeast2NPredictionClassLevelCalleesGOLD3] 
							+ "," + data[j][AtLeast2NPredictionMethodLevelCallersGOLD3]+ "," + data[j][AtLeast2NPredictionMethodLevelCalleesGOLD3]
							+ "," +data[j][AtLeast2TPredictionClassLevelCallersGOLD3]+ "," + data[j][AtLeast2TPredictionClassLevelCalleesGOLD3]
							+ "," + data[j][AtLeast2TPredictionMethodLevelCallersGOLD3]
							+ "," + data[j][AtLeast2TPredictionMethodLevelCalleesGOLD3]	
									+ "," + data[j][AllNClassLevelCallersGOLD3]
											+ "," +data[j][AllNClassLevelCalleesGOLD3]+ "," + data[j][AllNMethodLevelCallersGOLD3]+ "," + data[j][AllNMethodLevelCalleesGOLD3]+ "," +
											data[j][AllTClassLevelCallersGOLD3]+ ","+		data[j][AllTClassLevelCalleesGOLD3]+ ","+		data[j][AllTMethodLevelCallersGOLD3]+ 
											","+		data[j][AllTMethodLevelCalleesGOLD3]+","+
											
						","+data[j][AllNClassLevelCallersAtLeast2NGOLD3]
								+ "," +data[j][AllNClassLevelCallersAtLeast2NGOLD3]+ "," + data[j][AllNMethodLevelCallersAtLeast2NGOLD3]+ "," + data[j][AllNMethodLevelCalleesAtLeast2NGOLD3]+ "," +
								data[j][AllTClassLevelCallersAtLeast2TGOLD3]+ ","+		data[j][AllTClassLevelCalleesAtLeast2TGOLD3]+ ","+		data[j][AllTMethodLevelCallersAtLeast2TGOLD3]+ 
								","+
											
											OnlyinParsedCallers	+","+ OnlyinExecutedCallers+","+BothParsedAndExecutedCallers+","+OnlyInParsedCallees+","+OnlyInExecutedCallees
											+","+BothInParsedAndExecutedCallees+","+data[j][paramatersNumber]+","+ParametersAppended+","+data [j][CountParamaterTGOLD3]+","+data [j][CountParamaterNGOLD3]+","+data [j][CountParamaterEGOLD3]+","+data[j][MajorityParametersGOLD3]+","+data[j][AtLeast1NParameterGOLD3]
													+","+data[j][AtLeast1TParameter]+","+data[j][AtLeast2TParameter]+","+data[j][AtLeast2NParameter]+","+data[j][AllNParameters]+","+data[j][AllTParameters]+","+
													data[j][ACHRAFTRACEPureGOLD3]+","+data[j][ACHRAFTRACEMixedGOLD3]+","+data[j][ACHRAFNOTRACEPureGOLD3]+","+data[j][ACHRAFNOTRACEMixedGOLD3]+","+	
													data[j][AllNMethodLevelCallersCalleesGOLD3]+","+data[j][AllTMethodLevelCallersCalleesGOLD3]+","+data[j][AllTClassLevelCallersCalleesGOLD3]+","+data[j][AllNClassLevelCallersCalleesGOLD3]+","+	
													data[j][CLASSTRACEMethodLevelPureGold3]+","+data[j][CLASSTRACEMethodLevelMixedGold3]+","+data[j][CLASSNOTRACEMethodLevelPureGold3]+","+data[j][CLASSNOTRACEMethodLevelMixedGold3]+","+	
													data[j][CLASSTRACEClassLevelPureGold3]+","+data[j][CLASSTRACEClassLevelMixedGold3]+","+data[j][CLASSNOTRACEClassLevelPureGold3]+","+data[j][CLASSNOTRACEClassLevelMixedGold3]
					
					);
			bwGold3TableLog.newLine();

			
			
			
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
							methodtrace.gold3);
				
			bw.newLine();


			j++;
			
		}

		bw.close();
		
		
		
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
		bw2.write("ALL N CLASS LEVEL CALLERS CALLEES: "+AllNClassLevelCallersCalleesClass.toString()); 
		bw2.newLine();
		bw2.write("ACHRAF TRACE PURE: "+ACHRAFTracePureGold.toString()); 
		bw2.newLine();
		bw2.write("ACHRAF TRACE MIXED GOLD: "+ACHRAFTraceMixedGold.toString()); 
		bw2.newLine();
		bw2.write("ACHRAF NO TRACE PURE: "+ACHRAFNOTracePureGold.toString()); 
		bw2.newLine();
		bw2.write("ACHRAF NO TRACE MIXED GOLD: "+ACHRAFNOTraceMixedGold.toString()); 
		bw2.newLine();
		bw2.newLine();
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
		bwGold3.write("ALL T CLASS LEVEL CALLERS: "+AllTClassLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL T CLASS LEVEL CALLEES: "+AllTClassLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL T METHOD LEVEL CALLERS: "+AllTMethodLevelCallersClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL T METHOD LEVEL CALLEES: "+AllTMethodLevelCalleesClassGold3.toString()); 
		bwGold3.newLine();
		
		bwGold3.write("ALL N CLASS LEVEL CALLERS AT LEAST 2N : "+AllNClassLevelCallersClassAtLeast2NGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL N CLASS LEVEL CALLEES AT LEAST 2N : "+AllNClassLevelCalleesClassAtLeast2NGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL N METHOD LEVEL CALLERS AT LEAST 2N: "+AllNMethodLevelCallersClassAtLeast2NGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL N METHOD LEVEL CALLEES AT LEAST 2N: "+AllNMethodLevelCalleesClassAtLeast2NGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL T CLASS LEVEL CALLERS AT LEAST 2T : "+AllTClassLevelCallersClassAtLeast2TGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL T CLASS LEVEL CALLEES AT LEAST 2T : "+AllTClassLevelCalleesClassAtLeast2TGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL T METHOD LEVEL CALLERS AT LEAST 2T: "+AllTMethodLevelCallersClassAtLeast2TGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL T METHOD LEVEL CALLEES AT LEAST 2T: "+AllTMethodLevelCalleesClassAtLeast2TGold3.toString()); 
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
		bwGold3.write("ALL T METHOD LEVEL CALLERS CALLEES: "+AllTMethodLevelCallersCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL N METHOD LEVEL CALLERS CALLEES: "+AllNMethodLevelCallersCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL T CLASS LEVEL CALLERS CALLEES: "+AllTClassLevelCallersCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("ALL N CLASS LEVEL CALLERS CALLEES: "+AllNClassLevelCallersCalleesClassGold3.toString()); 
		bwGold3.newLine();
		bwGold3.newLine();
		bwGold3.newLine();
		bwGold3.write("TRACE PURE METHOD LEVEL: "+PredictionCLASSTRACEMethodLevelPureGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("TRACE MIXED METHOD LEVEL: "+PredictionCLASSTRACEMethodLevelMixedGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("NO TRACE PURE METHOD LEVEL: "+PredictionCLASSNOTRACEMethodLevelPureGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("NO TRACE MIXED METHOD LEVEL: "+PredictionCLASSNOTRACEMethodLevelMixedGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("TRACE PURE CLASS LEVEL: "+PredictionCLASSTRACEClassLevelPureGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("TRACE MIXED CLASS LEVEL: "+PredictionCLASSTRACEClassLevelMixedGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("NO TRACE PURE CLASS LEVEL: "+PredictionCLASSNOTRACEClassLevelPureGold3.toString()); 
		bwGold3.newLine();
		bwGold3.write("NO TRACE MIXED CLASS LEVEL: "+PredictionCLASSNOTRACEClassLevelMixedGold3.toString()); 
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
		
		bwGold4.write("ALL N CLASS LEVEL CALLERS AT LEAST 2N : "+AllNClassLevelCallersClassAtLeast2NGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL N CLASS LEVEL CALLEES AT LEAST 2N : "+AllNClassLevelCalleesClassAtLeast2NGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL N METHOD LEVEL CALLERS AT LEAST 2N: "+AllNMethodLevelCallersClassAtLeast2NGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL N METHOD LEVEL CALLEES AT LEAST 2N: "+AllNMethodLevelCalleesClassAtLeast2NGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL T CLASS LEVEL CALLERS AT LEAST 2T : "+AllTClassLevelCallersClassAtLeast2TGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL T CLASS LEVEL CALLEES AT LEAST 2T : "+AllTClassLevelCalleesClassAtLeast2TGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL T METHOD LEVEL CALLERS AT LEAST 2T: "+AllTMethodLevelCallersClassAtLeast2TGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("ALL T METHOD LEVEL CALLEES AT LEAST 2T: "+AllTMethodLevelCalleesClassAtLeast2TGold4.toString()); 
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
		bwGold4.write("ALL N CLASS LEVEL CALLERS CALLEES: "+AllNClassLevelCallersCalleesClassGold4.toString()); 
		bwGold4.newLine();
		bwGold4.newLine();
		bwGold4.newLine();
		bwGold4.write("TRACE PURE METHOD LEVEL: "+PredictionCLASSTRACEMethodLevelPureGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("TRACE MIXED METHOD LEVEL: "+PredictionCLASSTRACEMethodLevelMixedGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("NO TRACE PURE METHOD LEVEL: "+PredictionCLASSNOTRACEMethodLevelPureGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("NO TRACE MIXED METHOD LEVEL: "+PredictionCLASSNOTRACEMethodLevelMixedGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("TRACE PURE CLASS LEVEL: "+PredictionCLASSTRACEClassLevelPureGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("TRACE MIXED CLASS LEVEL: "+PredictionCLASSTRACEClassLevelMixedGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("NO TRACE PURE CLASS LEVEL: "+PredictionCLASSNOTRACEClassLevelPureGold4.toString()); 
		bwGold4.newLine();
		bwGold4.write("NO TRACE MIXED CLASS LEVEL: "+PredictionCLASSNOTRACEClassLevelMixedGold4.toString()); 
		bwGold4.newLine();
		bwGold4.close();
		
		
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
				
				
				"87-GOLD3", "88-OwnerClass T GOLD3", "89-Owner Class N GOLD3", "90-Owner Class E GOLD3", "91-# caller methods GOLD3",
				"92-# caller methods T GOLD3", "93-#caller methods N GOLD3", "94-#caller methods E GOLD3", "95-# caller classes GOLD3",
				"96-# caller classes T GOLD3", "97-#caller classes N GOLD3", "98-#caller classes E GOLD3", "99-# callee methods GOLD3",
				"100-# callee methods T GOLD3", "101-#callee methods N GOLD3", "102-#callee methods E GOLD3", "103-# callee classes GOLD3",
				"104-# callee classes T GOLD3", "105-#callee classes N GOLD3", "106-#callee classes E GOLD3",  "107-OwnerClassPrediction GOLD3",
				"108-MajorityClassLevelCallees GOLD3","109-MajorityClassLevelCallers GOLD3", "110-MajorityMethodLevelCallees GOLD3","111-MajorityMethodLevelCallers GOLD3",
				"112->1NPredictionClassLevelCallees GOLD3", "113->1NPredictionClassLevelCallers GOLD3", "114->1NPredictionMethodLevelCallees GOLD3", 
				"115->1NPredictionMethodLevelCallers GOLD3", "116->1TPredictionClassLevelCallees GOLD3", "117->1TPredictionClassLevelCallers GOLD3", 
				"118->1TPredictionMethodLevelCallees GOLD3", "119->1TPredictionMethodLevelCallers GOLD3", 
				"120->2NPredictionClassLevelCallees GOLD3", "121->2NPredictionClassLevelCallers GOLD3", "122->2NPredictionMethodLevelCallees GOLD3", 
				"123->2NPredictionMethodLevelCallers GOLD3", "124->2TPredictionClassLevelCallees GOLD3", "125->2TPredictionClassLevelCallers GOLD3", 
				"126->2TPredictionMethodLevelCallees GOLD3", "127->2TPredictionMethodLevelCallers GOLD3", 
				"128-AllNClassLevelCallees GOLD3", "129-AllNClassLevelCallers GOLD3","130-AllNMethodLevelCallees GOLD3","131-AllNMethodLevelCallers GOLD3",
				"132-AllTClassLevelCallees GOLD3", "133-AllTClassLevelCallers GOLD3", "134-AllTMethodLevelCallees GOLD3", "135-AllTMethodLevelCallers  GOLD3"
				,"136-AllNAtLeast2NClassLevelCallees GOLD3", "137-AllNAtLeast2NClassLevelCallers GOLD3","138-AllNAtLeast2NMethodLevelCallees GOLD3","139-AllNAtLeast2NMethodLevelCallers GOLD3",
				"140-AllTAtLeast2TClassLevelCallees GOLD3", "141-AllTAtLeast2TClassLevelCallers GOLD3", "142-AllTAtLeast2TMethodLevelCallees GOLD3", "143-AllTAtLeast2TMethodLevelCallers GOLD3"	
				,"144-Callers GOLD3", "145-Callees GOLD3", "146-#parameters GOLD3","147-# Parameter T" ,"148-# Parameter N" ,"149-# Parameter E" ,
				"150-MajorityParameterPrediction GOLD3", "151-AtLeast1NParameterPrediction GOLD3", 
				"152-AtLeast1TParameterPrediction GOLD3", "153-AtLeast2TParameterPrediction GOLD3", 
				"154-AtLeast2NParameterPrediction GOLD3", "155-AllNParameterPrediction GOLD3", "156-AllTParameterPrediction GOLD3",
				"157-ACHRAFTRACEPureGOLD3", "158-ACHRAFTRACEMixedGOLD3", "159-ACHRAFNOTRACEPureGOLD3", "160-ACHRAFNOTRACEMixed GOLD3", 
				"161-AllTMethodLevelCallersCalleesClass GOLD3", "162-AllNMethodLevelCallersCalleesClass GOLD3",
				"163-AllTClassLevelCallersCalleesClass GOLD3", "164-AllNClassLevelCallersCalleesClass GOLD3", 
				
				
				
				"165-GOLD4", "166-OwnerClass T GOLD4", "167-Owner Class N GOLD4", "168-Owner Class E GOLD4", "169-# caller methods GOLD4",
				"170-# caller methods T GOLD4", "171-#caller methods N GOLD4", "172-#caller methods E GOLD4", "173-# caller classes GOLD4",
				"174-# caller classes T GOLD4", "175-#caller classes N GOLD4", "176-#caller classes E GOLD4", "177-# callee methods GOLD4",
				"178-# callee methods T GOLD4", "179-#callee methods N GOLD4", "180-#callee methods E GOLD4", "181-# callee classes GOLD4",
				"182-# callee classes T GOLD4", "183-#callee classes N GOLD4", "184-#callee classes E GOLD4",  "185-OwnerClassPrediction GOLD4",
				"186-MajorityClassLevelCallees GOLD4","187-MajorityClassLevelCallers GOLD4", "188-MajorityMethodLevelCallees GOLD4","189-MajorityMethodLevelCallers GOLD4",
				"190->1NPredictionClassLevelCallees GOLD4", "191->1NPredictionClassLevelCallers GOLD4", "192->1NPredictionMethodLevelCallees GOLD4", 
				"193->1NPredictionMethodLevelCallers GOLD4", "194->1TPredictionClassLevelCallees GOLD4", "195->1TPredictionClassLevelCallers GOLD4", 
				"197->1TPredictionMethodLevelCallees GOLD4", "198->1TPredictionMethodLevelCallers GOLD4", 
				"199->2NPredictionClassLevelCallees GOLD4", "203->2NPredictionClassLevelCallers GOLD4", "204->2NPredictionMethodLevelCallees GOLD4", 
				"205->2NPredictionMethodLevelCallers GOLD4", "206->2TPredictionClassLevelCallees GOLD4", "207->2TPredictionClassLevelCallers GOLD4", 
				"208->2TPredictionMethodLevelCallees GOLD4", "209->2TPredictionMethodLevelCallers GOLD4", 
				"210-AllNClassLevelCallees GOLD4", "211-AllNClassLevelCallers GOLD4","212-AllNMethodLevelCallees GOLD4","213-AllNMethodLevelCallers GOLD4",
				"214-AllTClassLevelCallees GOLD4", "215-AllTClassLevelCallers GOLD4", "216-AllTMethodLevelCallees GOLD4", "217-AllTMethodLevelCallers  GOLD4"
				,"218-AllNAtLeast2NClassLevelCallees GOLD4", "219-AllNAtLeast2NClassLevelCallers GOLD4","220-AllNAtLeast2NMethodLevelCallees GOLD4","221-AllNAtLeast2NMethodLevelCallers GOLD4",
				"222-AllTAtLeast2TClassLevelCallees GOLD4", "223-AllTAtLeast2TClassLevelCallers GOLD4", "224-AllTAtLeast2TMethodLevelCallees GOLD4", "225-AllTAtLeast2TMethodLevelCallers GOLD4"	
				,"226-Callers GOLD4", "227-Callees GOLD4", "228-#parameters GOLD4","229-# Parameter T" ,"230-# Parameter N" ,"231-# Parameter E" ,
				"232-MajorityParameterPrediction GOLD4", "233-AtLeast1NParameterPrediction GOLD4", 
				"234-AtLeast1TParameterPrediction GOLD4", "235-AtLeast2TParameterPrediction GOLD4", 
				"236-AtLeast2NParameterPrediction GOLD4", "237-AllNParameterPrediction GOLD4", "238-AllTParameterPrediction GOLD4",
				"239-ACHRAFTRACEPureGOLD4", "240-ACHRAFTRACEMixedGOLD4", "241-ACHRAFNOTRACEPureGOLD4", "242-ACHRAFNOTRACEMixed GOLD4", 
				"243-AllTMethodLevelCallersCalleesClass GOLD4", "244-AllNMethodLevelCallersCalleesClass GOLD4",
				"245-AllTClassLevelCallersCalleesClass GOLD4", "246-AllNClassLevelCallersCalleesClass GOLD4", 
				
				
				
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

		TracesTableGantt2FINALReq10 frame = new TracesTableGantt2FINALReq10();
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



