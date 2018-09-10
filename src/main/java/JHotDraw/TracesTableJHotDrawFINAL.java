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
import Gantt.DatabaseReading2Gantt;
import mypackage.ClassRepresentation2;
import mypackage.ClassTrace2;
import mypackage.ColumnGroup;
import mypackage.GroupableTableHeader;
import mypackage.Interface2;
import mypackage.Method2Details;
import mypackage.Method2Representation;
import mypackage.MethodTrace2;
import mypackage.MethodTraceSubjectTSubjectNOriginal;
import mypackage.Parameter2;
import mypackage.Requirement2;
import mypackage.RequirementClass;
import mypackage.RequirementGold; 

public class TracesTableJHotDrawFINAL extends JFrame {
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
	
	int Gold3=79; 
	int OwnerClassTGOLD3=80; 
	int OwnerClassNGOLD3=81; 
	int OwnerClassEGOLD3=82; 
	int CallerMethodsNumberGOLD3=83; 
	int CallerMethodsTGOLD3=84; 
	int CallerMethodsNGOLD3=85; 
	int CallerMethodsEGOLD3=86; 
	int CallerClassesNumberGOLD3=87; 
	int CallerClassesTGOLD3=88; 
	int CallerClassesNGOLD3=89; 
	int CallerClassesEGOLD3=90; 
	int CalleeMethodsNumberGOLD3=91; 
	int CalleeMethodsTGOLD3=92; 
	int CalleeMethodsNGOLD3=93; 
	int CalleeMethodsEGOLD3=94; 
	int CalleeClassesNumberGOLD3=95; 
	int CalleeClassesTGOLD3=96; 
	int CalleeClassesNGOLD3=97; 
	int CalleeClassesEGOLD3=98; 
	int OwnerClassPredictionGOLD3=99; 
	int MajorityClassLevelCalleesGOLD3=100; 
	int MajorityClassLevelCallersGOLD3=101; 
	int MajorityMethodLevelCalleesGOLD3=102; 
	int MajorityMethodLevelCallersGOLD3=103; 
	int AtLeast1NPredictionClassLevelCalleesGOLD3=104; 
	int AtLeast1NPredictionClassLevelCallersGOLD3=105; 
	int AtLeast1NPredictionMethodLevelCalleesGOLD3=106; 
	int AtLeast1NPredictionMethodLevelCallersGOLD3=107; 
	int AtLeast1TPredictionClassLevelCalleesGOLD3=108; 
	int AtLeast1TPredictionClassLevelCallersGOLD3=109; 
	int AtLeast1TPredictionMethodLevelCalleesGOLD3=110; 
	int AtLeast1TPredictionMethodLevelCallersGOLD3=111; 
	int AtLeast2NPredictionClassLevelCalleesGOLD3=112; 
	int AtLeast2NPredictionClassLevelCallersGOLD3=113; 
	int AtLeast2NPredictionMethodLevelCalleesGOLD3=114; 
	int AtLeast2NPredictionMethodLevelCallersGOLD3=115; 
	int AtLeast2TPredictionClassLevelCalleesGOLD3=116; 
	int AtLeast2TPredictionClassLevelCallersGOLD3=117; 
	int AtLeast2TPredictionMethodLevelCalleesGOLD3=118; 
	int AtLeast2TPredictionMethodLevelCallersGOLD3=119; 
	int AllNClassLevelCalleesGOLD3=120; 
	int AllNClassLevelCallersGOLD3=122; 
	int AllNMethodLevelCalleesGOLD3=123; 
	int AllNMethodLevelCallersGOLD3=124; 
	int AllTClassLevelCalleesGOLD3=125; 
	int AllTClassLevelCallersGOLD3=126; 
	int AllTMethodLevelCalleesGOLD3=127; 
	int AllTMethodLevelCallersGOLD3=128; 
	int CallersGOLD3=129; 
	int CalleesGOLD3=130; 
	int paramatersNumberGOLD3=131; 
	int CountParamaterTGOLD3=132; 
	int CountParamaterNGOLD3=133; 
	int CountParamaterEGOLD3=134; 
	int MajorityParametersGOLD3=135; 
	int AtLeast1NParameterGOLD3=136; 
	int AtLeast1TParameterGOLD3=137; 
	int AtLeast2TParameterGOLD3=138; 
	int AtLeast2NParameterGOLD3=139; 
	int AllNParametersGOLD3=140; 
	int AllTParametersGOLD3=141; 
	int ACHRAFTRACEPureGOLD3=142; 
	int ACHRAFTRACEMixedGOLD3=143; 
	int ACHRAFNOTRACEPureGOLD3=144; 
	int ACHRAFNOTRACEMixedGOLD3=145; 
	int AllNMethodLevelCallersCalleesGOLD3=146; 
	int AllTMethodLevelCallersCalleesGOLD3=147; 
	int AllTClassLevelCallersCalleesGOLD3=148; 
	int AllNClassLevelCallersCalleesGOLD3=149; 
	
	
	int Gold4=150; 
	int OwnerClassTGOLD4=151; 
	int OwnerClassNGOLD4=152; 
	int OwnerClassEGOLD4=153; 
	int CallerMethodsNumberGOLD4=154; 
	int CallerMethodsTGOLD4=155; 
	int CallerMethodsNGOLD4=156; 
	int CallerMethodsEGOLD4=157; 
	int CallerClassesNumberGOLD4=158; 
	int CallerClassesTGOLD4=159; 
	int CallerClassesNGOLD4=160; 
	int CallerClassesEGOLD4=161; 
	int CalleeMethodsNumberGOLD4=162; 
	int CalleeMethodsTGOLD4=163; 
	int CalleeMethodsNGOLD4=164; 
	int CalleeMethodsEGOLD4=165; 
	int CalleeClassesNumberGOLD4=166; 
	int CalleeClassesTGOLD4=167; 
	int CalleeClassesNGOLD4=168; 
	int CalleeClassesEGOLD4=169; 
	int OwnerClassPredictionGOLD4=170; 
	int MajorityClassLevelCalleesGOLD4=171; 
	int MajorityClassLevelCallersGOLD4=172; 
	int MajorityMethodLevelCalleesGOLD4=173; 
	int MajorityMethodLevelCallersGOLD4=174; 
	int AtLeast1NPredictionClassLevelCalleesGOLD4=175; 
	int AtLeast1NPredictionClassLevelCallersGOLD4=176; 
	int AtLeast1NPredictionMethodLevelCalleesGOLD4=177; 
	int AtLeast1NPredictionMethodLevelCallersGOLD4=178; 
	int AtLeast1TPredictionClassLevelCalleesGOLD4=179; 
	int AtLeast1TPredictionClassLevelCallersGOLD4=180; 
	int AtLeast1TPredictionMethodLevelCalleesGOLD4=181; 
	int AtLeast1TPredictionMethodLevelCallersGOLD4=182; 
	int AtLeast2NPredictionClassLevelCalleesGOLD4=183; 
	int AtLeast2NPredictionClassLevelCallersGOLD4=184; 
	int AtLeast2NPredictionMethodLevelCalleesGOLD4=185; 
	int AtLeast2NPredictionMethodLevelCallersGOLD4=186; 
	int AtLeast2TPredictionClassLevelCalleesGOLD4=187; 
	int AtLeast2TPredictionClassLevelCallersGOLD4=188; 
	int AtLeast2TPredictionMethodLevelCalleesGOLD4=189; 
	int AtLeast2TPredictionMethodLevelCallersGOLD4=190; 
	int AllNClassLevelCalleesGOLD4=191; 
	int AllNClassLevelCallersGOLD4=192; 
	int AllNMethodLevelCalleesGOLD4=193; 
	int AllNMethodLevelCallersGOLD4=194; 
	int AllTClassLevelCalleesGOLD4=195; 
	int AllTClassLevelCallersGOLD4=196; 
	int AllTMethodLevelCalleesGOLD4=197; 
	int AllTMethodLevelCallersGOLD4=198; 
	int CallersGOLD4=199; 
	int CalleesGOLD4=200; 
	int paramatersNumberGOLD4=201; 
	int CountParamaterTGOLD4=202; 
	int CountParamaterNGOLD4=203; 
	int CountParamaterEGOLD4=204; 
	int MajorityParametersGOLD4=205; 
	int AtLeast1NParameterGOLD4=206; 
	int AtLeast1TParameterGOLD4=207; 
	int AtLeast2TParameterGOLD4=208; 
	int AtLeast2NParameterGOLD4=209; 
	int AllNParametersGOLD4=210; 
	int AllTParametersGOLD4=211; 
	int ACHRAFTRACEPureGOLD4=212; 
	int ACHRAFTRACEMixedGOLD4=213; 
	int ACHRAFNOTRACEPureGOLD4=214; 
	int ACHRAFNOTRACEMixedGOLD4=215; 
	int AllNMethodLevelCallersCalleesGOLD4=216; 
	int AllTMethodLevelCallersCalleesGOLD4=217; 
	int AllTClassLevelCallersCalleesGOLD4=218; 
	int AllNClassLevelCallersCalleesGOLD4=219; 
	
	
	
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
		
		
	ClassTrace2 myclasstrace = new ClassTrace2();
	static List<MethodTraceSubjectTSubjectNOriginal> methodtraces2 = new ArrayList<MethodTraceSubjectTSubjectNOriginal>();
	static List<ClassTrace2> classtraces2 = new ArrayList<ClassTrace2>();
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass = new  LinkedHashMap<String, ClassTrace2>(); 
	JTable table = new JTable(); 
	static List<Method2Details> methodlist = new ArrayList<Method2Details>();
	//File fout = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\GanttFiles\\TableLog.txt");
	File fout = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\TableLogJHotDraw.txt");
	FileOutputStream fos = new FileOutputStream(fout);
	
	//File fout2 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\JHotDrawFiles\\PredictionEvaluation.txt");
	File fout2 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\PredictionEvaluationJHotDraw.txt");
	FileOutputStream fos2 = new FileOutputStream(fout2);
	
	//File fout3 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\JHotDrawFiles\\PredictionEvaluationGold3.txt");
	File fout3 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\PredictionEvaluationGold3JHOTDRAW.txt");
	FileOutputStream fos3 = new FileOutputStream(fout3);
	
	//File fout4 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\JHotDrawFiles\\PredictionEvaluationGold4.txt");
	File fout4 = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\PredictionEvaluationGold4JHOTDRAW.txt");
	FileOutputStream fos4 = new FileOutputStream(fout4);
	
	File mylog = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logjhotdrawALLTCALLERSFP.txt");
	FileOutputStream mylogfile = new FileOutputStream(mylog);
	BufferedWriter bwlog = new BufferedWriter(new OutputStreamWriter(mylogfile));

	
	File mylogcallees = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logjhotdrawALLTCALLEESFP.txt");
	FileOutputStream mylogfilecallees = new FileOutputStream(mylogcallees);
	BufferedWriter bwlogcallees = new BufferedWriter(new OutputStreamWriter(mylogfilecallees));
	
	
	
	File MajorityCallersLogFP = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logjhotdrawMajorityClassCallersFP.txt");
	FileOutputStream MajorityCallersFP = new FileOutputStream(MajorityCallersLogFP);
	BufferedWriter bwlogMajorityCallersFP = new BufferedWriter(new OutputStreamWriter(MajorityCallersFP));
	
	File MajorityCallersLogFN = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\logjhotdrawMajorityClassCallersFN.txt");
	FileOutputStream MajorityCallersFN = new FileOutputStream(MajorityCallersLogFN);
	BufferedWriter bwlogMajorityCallersFN = new BufferedWriter(new OutputStreamWriter(MajorityCallersFN));
	File foutGold3TableLog = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\TableLogJHOTDRAWGOLD3.txt");
	FileOutputStream fosGold3 = new FileOutputStream(foutGold3TableLog);
	BufferedWriter bwGold3TableLog = new BufferedWriter(new OutputStreamWriter(fosGold3));
	
	
	File foutGold4TableLog = new File("C:\\Users\\mouna\\ownCloud\\Share\\dumps\\TableLogJHOTDRAWGOLD4.txt");
	FileOutputStream fosGold4 = new FileOutputStream(foutGold4TableLog);
	BufferedWriter bwGold4TableLog = new BufferedWriter(new OutputStreamWriter(fosGold4));
	
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(fos2));
	BufferedWriter bwGold3 = new BufferedWriter(new OutputStreamWriter(fos3));
	BufferedWriter bwGold4 = new BufferedWriter(new OutputStreamWriter(fos4));
	
	private final String userName = "root";
	private final String password = "123456";
	List<Method2Representation> CallerMethodListFinal = new ArrayList<Method2Representation>();
	List<Method2Representation> CalleeMethodListFinal = new ArrayList<Method2Representation>();
	
	List<Method2Representation> CallerMethodListFinal2 = new ArrayList<Method2Representation>();
	List<Method2Representation> CalleeMethodListFinal2 = new ArrayList<Method2Representation>();

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

	public TracesTableJHotDrawFINAL() throws SQLException, IOException {
	

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
				"AtLeast1TParameterPrediction, AtLeast2TParameterPrediction, AtLeast2NParameterPrediction,  AllNParameterPrediction, AllTParameterPrediction, "
				+"ACHRAFTracePure, ACHRAFTraceMixed, ACHRAFNoTracePure,  ACHRAFNoTraceMixed, AllNMethodLevelCallersCallees, AllTMethodLevelCallersCallees, "
				+ "AllTClassLevelCallersCallees, AllNClassLevelCallersCallees"
				+"gold3" );





		
		bw.newLine();
		DatabaseReading2JHotDraw db = new DatabaseReading2JHotDraw();
		DatabaseReading2JHotDraw.MakePredictions();
		methodtraces2 = db.getMethodtraces2();
		classtraces2 = db.getClassestraces2();
	//	methodlist = db.getMethodlist();
		 methodtracesRequirementClass = db.getClassesRequirementtraceshashmap(); 
		 HashMap InterfacesHashMap = db.getInterfaces();
		  LinkedHashMap<String, Method2Details> linkedmethodhashmap = db.getLinkedmethodhashmap(); 
		  HashMap<String, Interface2> InterfacesHashMapAlreadyImpl = db.getInterfacehashmapAlreadyImpl();

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
			data[j][RequirementID] = methodtrace.Requirement.getID();
			data[j][RequirementName] = methodtrace.Requirement.getRequirementName();
			data[j][ClassID] = methodtrace.ClassRepresentation.classid;
			data[j][ClassName] = methodtrace.ClassRepresentation.classname;
			data[j][Gold] = methodtrace.gold.trim(); 
			data[j][Subject] = methodtrace.subject;
			data[j][Gold3] = methodtrace.gold3;
			data[j][Gold4] = methodtrace.gold4;
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
			callersarr = new Method2Representation[methodtrace.getCallersList().size()];
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
			Method2Details mymethodobje = linkedmethodhashmap.get(methodtrace.MethodRepresentation.methodid); 
			String ParametersAppended=""; 
			for ( Parameter2 myparam : mymethodobje.getParameters()) {
				myparameters[myparametercount] = myparam.toString(); 
				ParametersAppended=ParametersAppended+myparam.toString()+"-"; 
				myparametercount++;
				
				
				String ParameterClassid = myparam.getParameterType().classid; 
				
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

			
			
			
//			data[j][CallerMethodsNumber] = CountCallersExecuted + CountCallers;
//			data[j][CalleeMethodsNumber] = CountCalleesExecuted + CountCallees;
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
//			
			
			
			

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
			int CounterTraceClassCallerTGOLD3 = 0;
			int CounterTraceClassCallerNGOLD3 = 0;
			int CounterTraceClassCallerEGOLD3 = 0;
			int CounterTraceClassCallerTGOLD4 = 0;
			int CounterTraceClassCallerNGOLD4 = 0;
			int CounterTraceClassCallerEGOLD4 = 0;
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
				if (mycallerclass.gettrace().trim().equals("T")) {
					CounterTraceClassCallerT++;
				} else if (mycallerclass.gettrace().trim().equals("N")) {
					CounterTraceClassCallerN++;
				} else if (mycallerclass.gettrace().trim().equals("E")) {
					CounterTraceClassCallerE++;
				}
				if (mycallerclass.getTrace3()!=null) {
					if (mycallerclass.getTrace3().trim().equals("T")) {
						CounterTraceClassCallerTGOLD3++;
					} else if (mycallerclass.getTrace3().trim().equals("N")) {
						CounterTraceClassCallerNGOLD3++;
					} else if (mycallerclass.getTrace3().trim().equals("E")) {
						CounterTraceClassCallerEGOLD3++;
					}
				}
				
				if (mycallerclass.getTrace4()!=null) {
					if (mycallerclass.getTrace4().trim().equals("T")) {
						CounterTraceClassCallerTGOLD4++;
					} else if (mycallerclass.getTrace4().trim().equals("N")) {
						CounterTraceClassCallerNGOLD4++;
					} else if (mycallerclass.getTrace4().trim().equals("E")) {
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
				if (mycallerclass.gettrace().trim().equals("T")) {
					CountMethodT++;
				} else if (mycallerclass.gettrace().trim().equals("N")) {
					CountMethodN++;
				} else if (mycallerclass.gettrace().trim().equals("E")) {
					CountMethodE++;
				}
				if(mycallerclass.getTrace3()!=null) {
					if (mycallerclass.getTrace3().trim().equals("T")) {
						CountMethodTGOLD3++;
					} else if (mycallerclass.getTrace3().trim().equals("N")) {
						CountMethodNGOLD3++;
					} else if (mycallerclass.getTrace3().trim().equals("E")) {
						CountMethodEGOLD3++;
					}
				}
				
				if(mycallerclass.getTrace4()!=null) {
					if (mycallerclass.getTrace4().trim().equals("T")) {
						CountMethodTGOLD4++;
					} else if (mycallerclass.getTrace4().trim().equals("N")) {
						CountMethodNGOLD4++;
					} else if (mycallerclass.getTrace4().trim().equals("E")) {
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
			for (Method2Representation mycaller: methodtrace.getCallersListExecuted()) {
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
			for (Method2Representation mycaller: methodtrace.getCalleesListExecuted()) {
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
			
			
			
			

		
		
			for (Method2Representation mycaller: methodtrace.getCallersListExecuted()) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.methodid); 
				 if(methdet!=null) {
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null) {
					if(methtrace.gold3!=null) {
						if (methtrace.gold3.trim().equals("T")) {
							CountMethodTACHRAFGold3++;
						} else if (methtrace.gold3.trim().equals("N")) {
							CountMethodNACHRAFGold3++;
						} else if (methtrace.gold3.trim().equals("E")) {
							CountMethodEACHRAFGold3++;
						}
					}
			
			}
				 }
			}
			
			
			
			int CountMethodTACHRAFCalleeGold3 = 0; 
			int CountMethodNACHRAFCalleeGold3 = 0; 
			int CountMethodEACHRAFCalleeGold3 = 0; 
			for (Method2Representation mycaller: methodtrace.getCalleesListExecuted()) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.methodid); 
				 if(methdet!=null) {
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null && methtrace.gold3!=null) {
					if (methtrace.gold3.trim().equals("T")) {
						CountMethodTACHRAFCalleeGold3++;
					} else if (methtrace.gold3.trim().equals("N")) {
						CountMethodNACHRAFCalleeGold3++;
					} else if (methtrace.gold3.trim().equals("E")) {
						CountMethodEACHRAFCalleeGold3++;
					}
				}
				 }
			
			}
			
			for (Method2Representation mycaller: methodtrace.getCallersListExecuted()) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.methodid); 
				 if(methdet!=null) {
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null) {
					if(methtrace.gold4!=null) {
						if (methtrace.gold4.trim().equals("T")) {
							CountMethodTACHRAFGold4++;
						} else if (methtrace.gold4.trim().equals("N")) {
							CountMethodNACHRAFGold4++;
						} else if (methtrace.gold4.trim().equals("E")) {
							CountMethodEACHRAFGold4++;
						}
					}
			
			}
				 }
			}
			
			
			
			int CountMethodTACHRAFCalleeGold4 = 0; 
			int CountMethodNACHRAFCalleeGold4 = 0; 
			int CountMethodEACHRAFCalleeGold4 = 0; 
			for (Method2Representation mycaller: methodtrace.getCalleesListExecuted()) {
				 Method2Details methdet = linkedmethodhashmap.get(mycaller.methodid); 
				 if(methdet!=null) {
				HashMap<String, MethodTrace2> myhashmap = methdet.methodtraces; 
				Requirement2 r= new Requirement2(methodtrace.Requirement.ID, methodtrace.Requirement.RequirementName); 
				MethodTrace2 methtrace = myhashmap.get(methodtrace.Requirement.ID); 
				if(methtrace!=null && methtrace.gold4!=null) {
					if (methtrace.gold4.trim().equals("T")) {
						CountMethodTACHRAFCalleeGold4++;
					} else if (methtrace.gold4.trim().equals("N")) {
						CountMethodNACHRAFCalleeGold4++;
					} else if (methtrace.gold4.trim().equals("E")) {
						CountMethodEACHRAFCalleeGold4++;
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
				if (mycalleeclass.gettrace().trim().equals("T")) {
					CounterTraceClassCalleeT++;
				} else if (mycalleeclass.gettrace().trim().equals("N")) {
					CounterTraceClassCalleeN++;
				} else if (mycalleeclass.gettrace().trim().equals("E")) {
					CounterTraceClassCalleeE++;
				}
				
				if(mycalleeclass.getTrace3()!=null) {
					if (mycalleeclass.getTrace3().trim().equals("T")) {
						CounterTraceClassCalleeTGOLD3++;
					} else if (mycalleeclass.getTrace3().trim().equals("N")) {
						CounterTraceClassCalleeNGOLD3++;
					} else if (mycalleeclass.getTrace3().trim().equals("E")) {
						CounterTraceClassCalleeEGOLD3++;
					}
				}
				
				if(mycalleeclass.getTrace4()!=null) {
					if (mycalleeclass.getTrace4().trim().equals("T")) {
						CounterTraceClassCalleeTGOLD4++;
					} else if (mycalleeclass.getTrace4().trim().equals("N")) {
						CounterTraceClassCalleeNGOLD4++;
					} else if (mycalleeclass.getTrace4().trim().equals("E")) {
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
					if (mycalleeclass.getTrace3().trim().equals("T")) {
						CountMethodTCalleeGOLD3++;
					} else if (mycalleeclass.getTrace3().trim().equals("N")) {
						CountMethodNCalleeGOLD3++;
					} else if (mycalleeclass.getTrace3().trim().equals("E")) {
						CountMethodECalleeGOLD3++;
					}
				}
			
			}
			
			int CountMethodTCalleeGOLD4 = 0; 
			int CountMethodNCalleeGOLD4 = 0; 
			int CountMethodECalleeGOLD4 = 0; 
			for (ClassTrace2 mycalleeclass : mycalleeclasses) {
				if(mycalleeclass.getTrace4()!=null) {
					if (mycalleeclass.getTrace4().trim().equals("T")) {
						CountMethodTCalleeGOLD4++;
					} else if (mycalleeclass.getTrace4().trim().equals("N")) {
						CountMethodNCalleeGOLD4++;
					} else if (mycalleeclass.getTrace4().trim().equals("E")) {
						CountMethodECalleeGOLD4++;
					}
				}
			
			}
			
			
			for (ClassTrace2 mycalleeclass : mycalleeclasses) {
				if(mycalleeclass.gettrace()!=null) {
					if (mycalleeclass.gettrace().trim().equals("T")) {
						CountMethodTCallee++;
					} else if (mycalleeclass.gettrace().trim().equals("N")) {
						CountMethodNCallee++;
					} else if (mycalleeclass.gettrace().trim().equals("E")) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
										if(flagGold3==false && methodtrace.getGold3()!=null) {
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
										if(flagGold3==false && methodtrace.getGold3()!=null) {
											
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
										if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
										if(flagGold3==false && methodtrace.getGold3()!=null) {
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
									
										if(flagGold3==false && methodtrace.getGold3()!=null) {
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
										if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
												if(flagGold3==false && methodtrace.getGold3()!=null) {
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
										if(flagGold3==false && methodtrace.getGold3()!=null) {
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
												if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
										if(flagGold3==false && methodtrace.getGold3()!=null) {
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
										if(flagGold3==false && methodtrace.getGold3()!=null) {
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
										if(flagGold3==false && methodtrace.getGold3()!=null) {
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
										if(flagGold3==false && methodtrace.getGold3()!=null) {
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
										if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
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
											if(flagGold3==false && methodtrace.getGold3()!=null) {
												String Result=AllNMethodLevelCalleesClassGold3.ComparePredictionToGold(methodtrace.getGold3().trim(), data[j][AllNMethodLevelCalleesGOLD3].toString()); 
												AllNMethodLevelCalleesClassGold3.UpdateCounters(Result, AllNMethodLevelCalleesClassGold3);
											}
										
											
									}
								//}
										
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										
										//ALL N METHOD LEVEL CALLERS CALLEES 
										
										
									
											
											if(CountMethodTCalleeGOLD3==0 && CountMethodTGOLD3==0 && CountMethodNCalleeGOLD3>=1 && CountMethodNGOLD3>=1) {
											
										
												data[j][AllNMethodLevelCallersCalleesGOLD3] = "N";
												if(flagGold3==false && methodtrace.getGold3()!=null) {
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
													if(flagGold3==false && methodtrace.getGold3()!=null) {
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
														if(flagGold3==false && methodtrace.getGold3()!=null) {
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
															if(flagGold3==false && methodtrace.getGold3()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
															if(flagGold4==false && methodtrace.getGold4()!=null) {
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
															if(flagGold4==false && methodtrace.getGold4()!=null) {
																
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
															if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
															if(flagGold4==false && methodtrace.getGold4()!=null) {
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
														
															if(flagGold4==false && methodtrace.getGold4()!=null) {
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
															if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																	if(flagGold4==false && methodtrace.getGold4()!=null) {
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
															if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																	if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
															if(flagGold4==false && methodtrace.getGold4()!=null) {
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
															if(flagGold4==false && methodtrace.getGold4()!=null) {
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
															if(flagGold4==false && methodtrace.getGold4()!=null) {
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
															if(flagGold4==false && methodtrace.getGold4()!=null) {
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
															if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																if(flagGold4==false && methodtrace.getGold4()!=null) {
																	String Result=AllNMethodLevelCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllNMethodLevelCalleesGOLD4].toString()); 
																	AllNMethodLevelCalleesClassGold4.UpdateCounters(Result, AllNMethodLevelCalleesClassGold4);
																}
															
																
														}
													//}
															
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															/**************************************************************************************************************/
															
															//ALL N METHOD LEVEL CALLERS CALLEES 
															
															
														
																
																if(CountMethodTCalleeGOLD4==0 && CountMethodTGOLD4==0 && CountMethodNCalleeGOLD4>=1 && CountMethodNGOLD4>=1) {
																
															
																	data[j][AllNMethodLevelCallersCalleesGOLD4] = "N";
																	if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																		if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																			if(flagGold4==false && methodtrace.getGold4()!=null) {
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
																				if(flagGold4==false && methodtrace.getGold4()!=null) {
																					String Result=AllTClassLevelCallersCalleesClassGold4.ComparePredictionToGold(methodtrace.getGold4().trim(), data[j][AllTClassLevelCallersCalleesGOLD4].toString()); 
																					AllTClassLevelCallersCalleesClassGold4.UpdateCounters(Result, AllTClassLevelCallersCalleesClassGold4);
																				}
																			
																				
																		}					
									String TracePureGoldValue=""; 
									String TraceMixedGoldValue=""; 
								
									String NOTracePureGoldValue=""; 
									String NOTraceMixedGoldValue=""; 
									String NOTracePureGold3Value=""; 
									String NOTraceMixedGold3Value=""; 
									String TracePureGold3Value=""; 
									String TraceMixedGold3Value=""; 
									
									String NOTracePureGold4Value=""; 
									String NOTraceMixedGold4Value=""; 
									String TracePureGold4Value=""; 
									String TraceMixedGold4Value=""; 
										/**************************************************************************************************************/
										/**************************************************************************************************************/
										/**************************************************************************************************************/
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

			bwGold3TableLog.write("RowNumber, MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold3, Subject, OwnerClassT, OwnerClassN, "
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
					"AtLeast1TParameterPrediction, AtLeast2TParameterPrediction, AtLeast2NParameterPrediction,  AllNParameterPrediction, AllTParameterPrediction, "
					+"ACHRAFTracePure, ACHRAFTraceMixed, ACHRAFNoTracePure,  ACHRAFNoTraceMixed, AllNMethodLevelCallersCallees, AllTMethodLevelCallersCallees, "
					+ "AllTClassLevelCallersCallees, AllNClassLevelCallersCallees"
					 );

			
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
					OnlyinParsedCallers	+","+ OnlyinExecutedCallers+","+BothParsedAndExecutedCallers+","+OnlyInParsedCallees+","+OnlyInExecutedCallees
					+","+BothInParsedAndExecutedCallees+","+data[j][paramatersNumberGOLD3]+","+ParametersAppended+","+data [j][CountParamaterTGOLD3]+","+data [j][CountParamaterNGOLD3]+","+data [j][CountParamaterEGOLD3]+","+data[j][MajorityParametersGOLD3]+","+data[j][AtLeast1NParameterGOLD3]
							+","+data[j][AtLeast1TParameterGOLD3]+","+data[j][AtLeast2TParameterGOLD3]+","+data[j][AtLeast2NParameterGOLD3]+","+data[j][AllNParametersGOLD3]+","+data[j][AllTParametersGOLD3]+","+
							data[j][ACHRAFTRACEPureGOLD3]+","+data[j][ACHRAFTRACEMixedGOLD3]+","+data[j][ACHRAFNOTRACEPureGOLD3]+","+data[j][ACHRAFNOTRACEMixedGOLD3]+","+	
							data[j][AllNMethodLevelCallersCalleesGOLD3]+","+data[j][AllTMethodLevelCallersCalleesGOLD3]+","+data[j][AllTClassLevelCallersCalleesGOLD3]+","+data[j][AllNClassLevelCallersCalleesGOLD3]);
			bwGold3TableLog.newLine();

			
			
			

			bwGold4TableLog.write("RowNumber, MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold4, Subject, OwnerClassT, OwnerClassN, "
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
					"AtLeast1TParameterPrediction, AtLeast2TParameterPrediction, AtLeast2NParameterPrediction,  AllNParameterPrediction, AllTParameterPrediction, "
					+"ACHRAFTracePure, ACHRAFTraceMixed, ACHRAFNoTracePure,  ACHRAFNoTraceMixed, AllNMethodLevelCallersCallees, AllTMethodLevelCallersCallees, "
					+ "AllTClassLevelCallersCallees, AllNClassLevelCallersCallees"
					 );

			
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
					OnlyinParsedCallers	+","+ OnlyinExecutedCallers+","+BothParsedAndExecutedCallers+","+OnlyInParsedCallees+","+OnlyInExecutedCallees
					+","+BothInParsedAndExecutedCallees+","+data[j][paramatersNumberGOLD4]+","+ParametersAppended+","+data [j][CountParamaterTGOLD4]+","+data [j][CountParamaterNGOLD4]+","+data [j][CountParamaterEGOLD4]+","+data[j][MajorityParametersGOLD4]+","+data[j][AtLeast1NParameterGOLD4]
							+","+data[j][AtLeast1TParameterGOLD4]+","+data[j][AtLeast2TParameterGOLD4]+","+data[j][AtLeast2NParameterGOLD4]+","+data[j][AllNParametersGOLD4]+","+data[j][AllTParametersGOLD4]+","+
							data[j][ACHRAFTRACEPureGOLD4]+","+data[j][ACHRAFTRACEMixedGOLD4]+","+data[j][ACHRAFNOTRACEPureGOLD4]+","+data[j][ACHRAFNOTRACEMixedGOLD4]+","+	
							data[j][AllNMethodLevelCallersCalleesGOLD4]+","+data[j][AllTMethodLevelCallersCalleesGOLD4]+","+data[j][AllTClassLevelCallersCalleesGOLD4]+","+data[j][AllNClassLevelCallersCalleesGOLD4]);
			bwGold4TableLog.newLine();
			
			
			
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
							+","+data[j][AtLeast1TParameter]+","+data[j][AtLeast2TParameter]+","+data[j][AtLeast2NParameter]+","+data[j][AllNParameters]+","+data[j][AllTParameters]+","+
							data[j][ACHRAFTRACEPureGold]+","+data[j][ACHRAFTRACEMixedGold]+","+data[j][ACHRAFNOTRACEPureGold]+","+data[j][ACHRAFNOTRACEMixedGold]+","+	
							data[j][AllNMethodLevelCallersCallees]+","+data[j][AllTMethodLevelCallersCallees]+","+data[j][AllTClassLevelCallersCallees]+","+data[j][AllNClassLevelCallersCallees]+","+	
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
		bw2.write("ACHRAF TRACE PURE GOLD: "+ACHRAFTracePureGold.toString()); 
		bw2.newLine();
		bw2.write("ACHRAF TRACE MIXED GOLD: "+ACHRAFTraceMixedGold.toString()); 
		bw2.newLine();
		bw2.write("ACHRAF NO TRACE PURE GOLD: "+ACHRAFNOTracePureGold.toString()); 
		bw2.newLine();
		bw2.write("ACHRAF NO TRACE MIXED GOLD: "+ACHRAFNOTraceMixedGold.toString()); 
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
		bwGold4.write("ALL N CLASS LEVEL CALLERS CALLEES: "+AllNClassLevelCallersCalleesClassGold4.toString()); 
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
				,"57-Callers", "58-Callees", "59-#parameters", "60-Parameters","61-# Parameter T" ,"62-# Parameter N" ,"63-# Parameter E" ,
				"64-MajorityParameterPrediction", "65-AtLeast1NParameterPrediction", 
				"66-AtLeast1TParameterPrediction", "67-AtLeast2TParameterPrediction", 
				"68-AtLeast2NParameterPrediction", "69-AllNParameterPrediction", "70-AllTParameterPrediction", 
				"71-ACHRAFTRACEPureGOLD", "72-ACHRAFTRACEMixedGOLD", "73-ACHRAFNOTRACEPureGOLD", "74-ACHRAFNOTRACEMixedGOLD", 
				"75-AllTMethodLevelCallersCalleesClass ", "76-AllNMethodLevelCallersCalleesClass",
				"77-AllTClassLevelCallersCalleesClass", "78-AllNClassLevelCallersCalleesClass", 
				
				
				"79-GOLD3", "80-OwnerClass T GOLD3", "81-Owner Class N GOLD3", "82-Owner Class E GOLD3", "83-# caller methods GOLD3",
				"84-# caller methods T GOLD3", "85-#caller methods N GOLD3", "86-#caller methods E GOLD3", "87-# caller classes GOLD3",
				"88-# caller classes T GOLD3", "89-#caller classes N GOLD3", "90-#caller classes E GOLD3", "91-# callee methods GOLD3",
				"92-# callee methods T GOLD3", "93-#callee methods N GOLD3", "94-#callee methods E GOLD3", "95-# callee classes GOLD3",
				"96-# callee classes T GOLD3", "97-#callee classes N GOLD3", "98-#callee classes E GOLD3",  "99-OwnerClassPrediction GOLD3",
				"100-MajorityClassLevelCallees GOLD3","101-MajorityClassLevelCallers GOLD3", "102-MajorityMethodLevelCallees GOLD3","103-MajorityMethodLevelCallers GOLD3",
				"104->1NPredictionClassLevelCallees GOLD3", "105->1NPredictionClassLevelCallers GOLD3", "106->1NPredictionMethodLevelCallees GOLD3", 
				"107->1NPredictionMethodLevelCallers GOLD3", "108->1TPredictionClassLevelCallees GOLD3", "109->1TPredictionClassLevelCallers GOLD3", 
				"110->1TPredictionMethodLevelCallees GOLD3", "111->1TPredictionMethodLevelCallers GOLD3", 
				"112->2NPredictionClassLevelCallees GOLD3", "113->2NPredictionClassLevelCallers GOLD3", "114->2NPredictionMethodLevelCallees GOLD3", 
				"115->2NPredictionMethodLevelCallers GOLD3", "116->2TPredictionClassLevelCallees GOLD3", "117->2TPredictionClassLevelCallers GOLD3", 
				"118->2TPredictionMethodLevelCallees GOLD3", "119->2TPredictionMethodLevelCallers GOLD3", 
				"120-AllNClassLevelCallees GOLD3", "121-AllNClassLevelCallers GOLD3","122-AllNMethodLevelCallees GOLD3","123-AllNMethodLevelCallers GOLD3",
				"124-AllTClassLevelCallees GOLD3", "125-AllTClassLevelCallers GOLD3", "126-AllTMethodLevelCallees GOLD3", "127-AllTMethodLevelCallers  GOLD3"
				,"128-Callers GOLD3", "129-Callees GOLD3", "130-#parameters GOLD3","131-# Parameter T" ,"132-# Parameter N" ,"133-# Parameter E" ,
				"134-MajorityParameterPrediction GOLD3", "135-AtLeast1NParameterPrediction GOLD3", 
				"136-AtLeast1TParameterPrediction GOLD3", "137-AtLeast2TParameterPrediction GOLD3", 
				"138-AtLeast2NParameterPrediction GOLD3", "139-AllNParameterPrediction GOLD3", "140-AllTParameterPrediction GOLD3",
				"141-ACHRAFTRACEPureGOLD 2", "142-ACHRAFTRACEMixedGOLD3", "143-ACHRAFNOTRACEPureGOLD 2", "144-ACHRAFNOTRACEMixed GOLD3", 
				"145-AllTMethodLevelCallersCalleesClass GOLD3", "146-AllNMethodLevelCallersCalleesClass GOLD3",
				"147-AllTClassLevelCallersCalleesClass GOLD3", "148-AllNClassLevelCallersCalleesClass GOLD3", 
				
		
				"149-GOLD4", "150-OwnerClass T GOLD4", "151-Owner Class N GOLD4", "152-Owner Class E GOLD4", "153-# caller methods GOLD4",
				"154-# caller methods T GOLD4", "155-#caller methods N GOLD4", "156-#caller methods E GOLD4", "157-# caller classes GOLD4",
				"158-# caller classes T GOLD4", "159-#caller classes N GOLD4", "160-#caller classes E GOLD4", "161-# callee methods GOLD4",
				"162-# callee methods T GOLD4", "163-#callee methods N GOLD4", "164-#callee methods E GOLD4", "165-# callee classes GOLD4",
				"166-# callee classes T GOLD4", "167-#callee classes N GOLD4", "168-#callee classes E GOLD4",  "169-OwnerClassPrediction GOLD4",
				"170-MajorityClassLevelCallees GOLD4","171-MajorityClassLevelCallers GOLD4", "172-MajorityMethodLevelCallees GOLD4","173-MajorityMethodLevelCallers GOLD4",
				"174->1NPredictionClassLevelCallees GOLD4", "175->1NPredictionClassLevelCallers GOLD4", "176->1NPredictionMethodLevelCallees GOLD4", 
				"177->1NPredictionMethodLevelCallers GOLD4", "178->1TPredictionClassLevelCallees GOLD4", "179->1TPredictionClassLevelCallers GOLD4", 
				"180->1TPredictionMethodLevelCallees GOLD4", "181->1TPredictionMethodLevelCallers GOLD4", 
				"182->2NPredictionClassLevelCallees GOLD4", "183->2NPredictionClassLevelCallers GOLD4", "184->2NPredictionMethodLevelCallees GOLD4", 
				"185->2NPredictionMethodLevelCallers GOLD4", "186->2TPredictionClassLevelCallees GOLD4", "187->2TPredictionClassLevelCallers GOLD4", 
				"188->2TPredictionMethodLevelCallees GOLD4", "189->2TPredictionMethodLevelCallers GOLD4", 
				"190-AllNClassLevelCallees GOLD4", "191-AllNClassLevelCallers GOLD4","192-AllNMethodLevelCallees GOLD4","193-AllNMethodLevelCallers GOLD4",
				"194-AllTClassLevelCallees GOLD4", "195-AllTClassLevelCallers GOLD4", "196-AllTMethodLevelCallees GOLD4", "197-AllTMethodLevelCallers  GOLD4"
				,"198-Callers GOLD4", "199-Callees GOLD4", "200-#parameters GOLD4","201-# Parameter T" ,"202-# Parameter N" ,"203-# Parameter E" ,
				"204-MajorityParameterPrediction GOLD4", "205-AtLeast1NParameterPrediction GOLD4", 
				"206-AtLeast1TParameterPrediction GOLD4", "207-AtLeast2TParameterPrediction GOLD4", 
				"208-AtLeast2NParameterPrediction GOLD4", "209-AllNParameterPrediction GOLD4", "210-AllTParameterPrediction GOLD4",
				"211-ACHRAFTRACEPureGOLD 2", "212-ACHRAFTRACEMixedGOLD4", "213-ACHRAFNOTRACEPureGOLD 2", "214-ACHRAFNOTRACEMixed GOLD4", 
				"215-AllTMethodLevelCallersCalleesClass GOLD4", "216-AllNMethodLevelCallersCalleesClass GOLD4",
				"217-AllTClassLevelCallersCalleesClass GOLD4", "218-AllNClassLevelCallersCalleesClass GOLD4",
		
		
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

		TracesTableJHotDrawFINAL frame = new TracesTableJHotDrawFINAL();
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



