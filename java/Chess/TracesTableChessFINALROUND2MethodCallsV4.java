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
import mypackage.ClassRepresentation2;
import mypackage.ClassTrace2;
import mypackage.ColumnGroup;
import mypackage.DatabaseReading2;
import mypackage.GroupableTableHeader;
import mypackage.Implementation2;
import mypackage.Interface2;
import mypackage.Method2Details;
import mypackage.Method2Representation;
import mypackage.MethodField2;
import mypackage.MethodTrace2;
import mypackage.MethodTraceSubjectTSubjectN;
import mypackage.Parameter2;
import mypackage.Requirement2;
import mypackage.RequirementGold;
import mypackage.SuperClass2;

public class TracesTableChessFINALROUND2MethodCallsV4 extends JFrame {
	
	

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(command); // This will throw a SQLException if it fails
	        return true;
	    } finally {

	    	// This will run whether we throw an exception or not
	        if (stmt != null) { stmt.close(); }
	    }
	}
	


	   
	  
	ResultSet rs = null; 
	// Connect to MySQL
	


	   
	   
	
   
	
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
	
	
	int gold2=95; 
	int OwnerClassTgold2=96; 
	int OwnerClassNgold2=97; 
	int OwnerClassEgold2=98; 
	int CallerMethodsNumbergold2=99; 
	int CallerMethodsTgold2=100; 
	int CallerMethodsNgold2=101; 
	int CallerMethodsEgold2=102; 
	int CallerClassesNumbergold2=103; 
	int CallerClassesTgold2=104; 
	int CallerClassesNgold2=105; 
	int CallerClassesEgold2=106; 
	int CalleeMethodsNumbergold2=107; 
	int CalleeMethodsTgold2=108; 
	int CalleeMethodsNgold2=109; 
	int CalleeMethodsEgold2=110; 
	int CalleeClassesNumbergold2=111; 
	int CalleeClassesTgold2=112; 
	int CalleeClassesNgold2=113; 
	int CalleeClassesEgold2=114; 
	int OwnerClassPredictiongold2=115; 
	int MajorityClassLevelCalleesgold2=116; 
	int MajorityClassLevelCallersgold2=117; 
	int MajorityMethodLevelCalleesgold2=118; 
	int MajorityMethodLevelCallersgold2=119; 
	int AtLeast1NPredictionClassLevelCalleesgold2=120; 
	int AtLeast1NPredictionClassLevelCallersgold2=121; 
	int AtLeast1NPredictionMethodLevelCalleesgold2=122; 
	int AtLeast1NPredictionMethodLevelCallersgold2=123; 
	int AtLeast1TPredictionClassLevelCalleesgold2=124; 
	int AtLeast1TPredictionClassLevelCallersgold2=125; 
	int AtLeast1TPredictionMethodLevelCalleesgold2=126; 
	int AtLeast1TPredictionMethodLevelCallersgold2=127; 
	int AtLeast2NPredictionClassLevelCalleesgold2=128; 
	int AtLeast2NPredictionClassLevelCallersgold2=129; 
	int AtLeast2NPredictionMethodLevelCalleesgold2=130; 
	int AtLeast2NPredictionMethodLevelCallersgold2=131; 
	int AtLeast2TPredictionClassLevelCalleesgold2=132; 
	int AtLeast2TPredictionClassLevelCallersgold2=133; 
	int AtLeast2TPredictionMethodLevelCalleesgold2=134; 
	int AtLeast2TPredictionMethodLevelCallersgold2=135; 
	int AllNClassLevelCalleesgold2=136; 
	int AllNClassLevelCallersgold2=137; 
	int AllNMethodLevelCalleesgold2=138; 
	int AllNMethodLevelCallersgold2=139; 
	int AllTClassLevelCalleesgold2=140; 
	int AllTClassLevelCallersgold2=141; 
	int AllTMethodLevelCalleesgold2=142; 
	int AllTMethodLevelCallersgold2=143; 
	int Callersgold2=144; 
	int Calleesgold2=145; 
	int paramatersNumbergold2=146; 
	int CountParamaterTgold2=147; 
	int CountParamaterNgold2=148; 
	int CountParamaterEgold2=149; 
	int MajorityParametersgold2=150; 
	int AtLeast1NParametergold2=151; 
	int AtLeast1TParametergold2=152; 
	int AtLeast2TParametergold2=153; 
	int AtLeast2NParametergold2=154; 
	int AllNParametersgold2=155; 
	int AllTParametersgold2=156; 
	int ACHRAFTRACEPuregold2=157; 
	int ACHRAFTRACEMixedgold2=158; 
	int ACHRAFNOTRACEPuregold2=159; 
	int ACHRAFNOTRACEMixedgold2=160; 
	int AllNMethodLevelCallersCalleesgold2=161; 
	int AllTMethodLevelCallersCalleesgold2=162; 
	int AllTClassLevelCallersCalleesgold2=163; 
	int AllNClassLevelCallersCalleesgold2=164; 
	int AllNClassLevelCalleesAtLeast2Ngold2=165; 
	int AllNClassLevelCallersAtLeast2Ngold2=166; 
	int AllNMethodLevelCalleesAtLeast2Ngold2=167; 
	int AllNMethodLevelCallersAtLeast2Ngold2=168; 
	int AllTClassLevelCalleesAtLeast2Tgold2=169; 
	int AllTClassLevelCallersAtLeast2Tgold2=170; 
	int AllTMethodLevelCalleesAtLeast2Tgold2=171; 
	int AllTMethodLevelCallersAtLeast2Tgold2=172; 
	int CLASSTRACEMethodLevelPuregold2=173; 
	int CLASSTRACEMethodLevelMixedgold2=174; 
	int CLASSNOTRACEMethodLevelPuregold2=175; 
	int CLASSNOTRACEMethodLevelMixedgold2=176;
	int CLASSTRACEClassLevelPuregold2=177; 
	int CLASSTRACEClassLevelMixedgold2=178; 
	int CLASSNOTRACEClassLevelPuregold2=179; 
	int CLASSNOTRACEClassLevelMixedgold2=180;
	int CLASSTRACEMethodLevelPuregold2ACROSS=181; 
	int CLASSTRACEMethodLevelMixedgold2ACROSS=182; 
	int CLASSNOTRACEMethodLevelPuregold2ACROSS=183; 
	int CLASSNOTRACEMethodLevelMixedgold2ACROSS=184;
	int CLASSTRACEClassLevelPuregold2ACROSS=185; 
	int CLASSTRACEClassLevelMixedgold2ACROSS=186; 
	int CLASSNOTRACEClassLevelPuregold2ACROSS=187; 
	int CLASSNOTRACEClassLevelMixedgold2ACROSS=188;
	int CallerMethodsNumbergold2ACROSS=189; 
	int CallerMethodsTgold2ACROSS=190; 
	int CallerMethodsNgold2ACROSS=191; 
	int CallerMethodsEgold2ACROSS=192; 
	int CallerClassesNumbergold2ACROSS=193; 
	int CallerClassesTgold2ACROSS=194; 
	int CallerClassesNgold2ACROSS=195; 
	int CallerClassesEgold2ACROSS=196; 
	int CalleeMethodsNumbergold2ACROSS=197; 
	int CalleeMethodsTgold2ACROSS=198; 
	int CalleeMethodsNgold2ACROSS=199; 
	int CalleeMethodsEgold2ACROSS=200; 
	int CalleeClassesNumbergold2ACROSS=201; 
	int CalleeClassesTgold2ACROSS=202; 
	int CalleeClassesNgold2ACROSS=203; 
	int CalleeClassesEgold2ACROSS=204; 
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
	int interfacesNumbergold2=221; 
	int CountInterfaceTgold2=222; 
	int CountInterfaceNgold2=223; 
	int CountInterfaceEgold2=224; 
	
	int FieldClassesNumbergold2=225; 
	int CountFieldClassTgold2=226; 
	int CountFieldClassNgold2=227; 
	int CountFieldClassEgold2=228; 
	
	int FieldMethodsNumbergold2=229; 
	int CountFieldMethodTgold2=230; 
	int CountFieldMethodNgold2=231; 
	int CountFieldMethodEgold2=232; 
	
	int SuperClassesNumbergold2=233; 
	int CountFieldSuperClassTgold2=234; 
	int CountFieldSuperClassNgold2=235; 
	int CountFieldSuperClassEgold2=236; 
	
	int counterFN=0; 
	double TracePureGold=0; 
	double NoTracePureGold=0; 
	double TraceMixedGold=0; 
	double NoTraceMixedGold=0; 
	
	double TracePureGoldTotal=0; 
	double NoTracePureGoldTotal=0; 
	double TraceMixedGoldTotal=0; 
	double NoTraceMixedGoldTotal=0; 
	
	double TracePuregold2=0; 
	double NoTracePuregold2=0; 
	double TraceMixedgold2=0; 
	double NoTraceMixedgold2=0; 
	
	double failGold=0; 
	double failgold2=0; 
	double TraceCountTotal=0; 
	double NoTraceCountTotal=0; 
	double TraceCountTotalgold2=0; 
	double NoTraceCountTotalgold2=0; 
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
	PredictionEvaluation OwnerClassPredictionClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation MajorityClassLevelCallersClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation MajorityClassLevelCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation MajorityMethodLevelCallersClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation MajorityMethodLevelCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionClassLevelCallersClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionClassLevelCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionMethodLevelCallersClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionMethodLevelCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionClassLevelCallersClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionClassLevelCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionMethodLevelCallersClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionMethodLevelCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionClassLevelCallersClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionClassLevelCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionMethodLevelCallersClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionMethodLevelCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionClassLevelCallersClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionClassLevelCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionMethodLevelCallersClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionMethodLevelCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCallersClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCallersClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation MajorityParametersClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast1NParameterClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NParameterClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast1TParameterClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TParameterClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNParameterClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTParameterClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFTracePuregold2= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFTraceMixedgold2= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTracePuregold2= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTraceMixedgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCallersCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCallersCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersCalleesClassgold2= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFgold2Trace= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFgold2NOTrace= new PredictionEvaluation(); 
	PredictionEvaluation PureNCallersgold2= new PredictionEvaluation(); 
	PredictionEvaluation PureTCallersgold2= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCalleesClassAtLeast2Ngold2=new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersClassAtLeast2Ngold2=new PredictionEvaluation();  
	PredictionEvaluation AllNMethodLevelCalleesClassAtLeast2Ngold2=new PredictionEvaluation();  
	PredictionEvaluation AllNMethodLevelCallersClassAtLeast2Ngold2=new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCalleesClassAtLeast2Tgold2=new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersClassAtLeast2Tgold2=new PredictionEvaluation();  
	PredictionEvaluation AllTMethodLevelCalleesClassAtLeast2Tgold2=new PredictionEvaluation();  
	PredictionEvaluation AllTMethodLevelCallersClassAtLeast2Tgold2=new PredictionEvaluation(); 
	PredictionEvaluation PredictionCLASSTRACEMethodLevelPuregold2=new PredictionEvaluation(); 
	PredictionEvaluation PredictionCLASSTRACEMethodLevelMixedgold2=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelPuregold2=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelMixedgold2=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSTRACEClassLevelPuregold2=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSTRACEClassLevelMixedgold2=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelPuregold2=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelMixedgold2=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSTRACEMethodLevelPuregold2ACROSS=new PredictionEvaluation(); 
	PredictionEvaluation PredictionCLASSTRACEMethodLevelMixedgold2ACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelPuregold2ACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelMixedgold2ACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSTRACEClassLevelPuregold2ACROSS=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSTRACEClassLevelMixedgold2ACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelPuregold2ACROSS=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelMixedgold2ACROSS=new PredictionEvaluation();  

	PredictionEvaluation NEWPATTERNMethodCalls=new PredictionEvaluation();  
	PredictionEvaluation NEWPATTERNMethodCallsSetToT=new PredictionEvaluation();  

	PredictionEvaluation NEWPATTERNMethodFields=new PredictionEvaluation();  
	
	ClassTrace2 myclasstrace = new ClassTrace2();
	static List<MethodTraceSubjectTSubjectN> methodtraces2 = new ArrayList<MethodTraceSubjectTSubjectN>();
	static HashMap<String, MethodTraceSubjectTSubjectN> methodtraces2HashMap  = new HashMap<String, MethodTraceSubjectTSubjectN>();
	static HashMap<String, List<Parameter2>> parameterHashMap  = new HashMap<String, List<Parameter2>>();
	static List<ClassTrace2> classtraces2 = new ArrayList<ClassTrace2>();
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass = new  LinkedHashMap<String, ClassTrace2>(); 
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClassgold2 = new  LinkedHashMap<String, ClassTrace2>(); 

	 LinkedHashMap<String, Method2Details> linkedmethodhashmap= new LinkedHashMap<String, Method2Details>(); 
	 HashMap<String, Interface2> InterfacesHashMap= new HashMap<String, Interface2>();
	 HashMap<String, Interface2> InterfacesHashMapAlreadyImpl= new HashMap<String, Interface2>(); 
	 HashMap<String, List<Interface2>>  InterfacesOwnerClassHashMap= new HashMap<String, List<Interface2>>(); 
	 HashMap<String, List< MethodField2>>  FieldMethodsHashMap= new HashMap<String, List< MethodField2>>(); 
	 HashMap<String, List< ClassField2>> FieldClassesHashMap=  new HashMap<String, List< ClassField2>>(); 
	 HashMap<String, List< SuperClass2>> SuperclassesHashMap=  new HashMap<String, List< SuperClass2>>(); 
	 HashMap<String, List< Children2>> ChildrenHashMap=  new HashMap<String, List< Children2>>(); 
	 HashMap<String, List< Implementation2>> INTERFACEHASHMAPFINAL=  new HashMap<String, List< Implementation2>>(); 
	JTable table = new JTable(); 
	static List<Method2Details> methodlist = new ArrayList<Method2Details>();
	//File fout = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\TableLog.txt");
	
	

	
	
	
	
	
	public final String userName = "root";
	public final String password = "123456";
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
	
	public TracesTableChessFINALROUND2MethodCallsV4(String ProgramName) throws SQLException, IOException {
	
		
	
		
		LinkedHashMap<String, String> PredictionsOldHashMap= new LinkedHashMap<String, String>(); 
		LinkedHashMap<String, String> PredictionsNewHashMap= new LinkedHashMap<String, String>(); 

	
	
		
int j=0;
		List<MethodTraceSubjectTSubjectN> methodtracesNew = InitializePredictionsHashMap2(methodtraces2); 
		function1SetToT(j, PredictionsOldHashMap, PredictionsNewHashMap, methodtracesNew, ProgramName); 
		


	}



	public List<MethodTraceSubjectTSubjectN> InitializePredictionsHashMap2(
			List<MethodTraceSubjectTSubjectN> methodtracesNew) {
		// TODO Auto-generated method stub
		
		for(MethodTraceSubjectTSubjectN meth: methodtracesNew) {
			meth.setPrediction("");
		}
		return methodtracesNew;
	}
/************************************************************************************************************************************************/
/************************************************************************************************************************************************/
/************************************************************************************************************************************************/

	

public void SecondIteration(List<Parameter2> parameterlistE, List<Parameter2> parameterlistN, List<Parameter2> parameterlistT, List<MethodField2> methodfieldlistT, List<MethodField2> methodfieldlistN, List<MethodField2> methodfieldlistE, List<String> PredictionFields, List<String> PredictionParams, MethodTraceSubjectTSubjectN methodtrace) {
	// TODO Auto-generated method stub
	for(MethodField2 methodfield: methodfieldlistE) {
		String key=methodfield.getMethod().methodid+"-"+methodtrace.Requirement.ID; 
		if(methodtraces2HashMap.get(key)!=null) {
			String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
			PredictionFields.add(predictionvalue); 
		}
	}
	for(MethodField2 methodfield: methodfieldlistN) {
		String key=methodfield.getMethod().methodid+"-"+methodtrace.Requirement.ID; 
		if(methodtraces2HashMap.get(key)!=null) {
			String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
			PredictionFields.add(predictionvalue); 
		}
	}
	for(MethodField2 methodfield: methodfieldlistT) {
		String key=methodfield.getMethod().methodid+"-"+methodtrace.Requirement.ID; 
		if(methodtraces2HashMap.get(key)!=null) {
			String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
			PredictionFields.add(predictionvalue); 
		}
	}
	
	
	for(Parameter2 methodfield: parameterlistT) {
		String key=methodfield.getMethod().methodid+"-"+methodtrace.Requirement.ID; 
		if(methodtraces2HashMap.get(key)!=null) {
			String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
			PredictionParams.add(predictionvalue); 
		}
	}
	for(Parameter2 methodfield: parameterlistE) {
		String key=methodfield.getMethod().methodid+"-"+methodtrace.Requirement.ID; 
		if(methodtraces2HashMap.get(key)!=null) {
			String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
			PredictionParams.add(predictionvalue); 
		}
	}
	for(Parameter2 methodfield: parameterlistN) {
		String key=methodfield.getMethod().methodid+"-"+methodtrace.Requirement.ID; 
		if(methodtraces2HashMap.get(key)!=null) {
			String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
			PredictionParams.add(predictionvalue); 
		}
	}


}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public LinkedHashMap<String, String>  function1SetToT( int j, LinkedHashMap<String, String> PredictionsOldHashMap, LinkedHashMap<String, String> PredictionsNewHashMap, List<MethodTraceSubjectTSubjectN> methodtraces22, String ProgramName) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int ITERATION1=0; 

		DatabaseReading2 db = null; 
		DatabaseReading2Gantt dbgantt = null; 
		DatabaseReading2JHotDraw3 dbjhotdraw = null; 
		DatabaseReading2itrustfinal dbitrust = null; 
		BufferedWriter	 bwfile4=null; 
		BufferedWriter	 bwfile3=null; 
		BufferedWriter	 bwfile2=null; 
		BufferedWriter	 bwfile=null; 

		BufferedWriter bwfile1=null;
		if(ProgramName.equals("chess")) {
			File filelog = new File("C:\\Users\\mouna\\dumps\\TableLogChess.txt");
			FileOutputStream fosfila = new FileOutputStream(filelog);
				 bwfile = new BufferedWriter(new OutputStreamWriter(fosfila));
		}
	
		
		
		if(ProgramName.equals("gantt")) {
			File filelog2 = new File("C:\\Users\\mouna\\dumps\\TableLogGantt.txt");
			FileOutputStream fosfila2 = new FileOutputStream(filelog2);
				 bwfile2 = new BufferedWriter(new OutputStreamWriter(fosfila2));
		}
		
		
		
		if(ProgramName.equals("itrust")) {
		File filelog3 = new File("C:\\Users\\mouna\\dumps\\TableLogiTrust.txt");
		FileOutputStream fosfila5 = new FileOutputStream(filelog3);
			 bwfile3 = new BufferedWriter(new OutputStreamWriter(fosfila5));
		}
		
		
		if(ProgramName.equals("jhotdraw")) {
		File filelog4 = new File("C:\\Users\\mouna\\dumps\\TableLogJHotDraw.txt");
		FileOutputStream fosfila4 = new FileOutputStream(filelog4);
			 bwfile4 = new BufferedWriter(new OutputStreamWriter(fosfila4));
		}
		Collection<MethodTraceSubjectTSubjectN> MethodTracesHashmapValues = methodtraces2HashMap.values(); 
//		bwfile2.newLine();
		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
					methodtrace.setPrediction("E");
		}
	if(ProgramName.equals("chess")) {
			
			
			File file1log = new File("C:\\Users\\mouna\\dumps\\MethodCallsChess.txt");
			FileOutputStream fosfila1 = new FileOutputStream(file1log);
			 bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));
			
			
			
			db = new DatabaseReading2();
			DatabaseReading2.MakePredictions();
			
			methodtraces2 = db.getMethodtraces2SubjectTSubjectN();
			methodtraces2HashMap=db.getMethodtracehashmap(); 
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
			  //PARAMETERS 
			  
			  parameterHashMap= db.getParameterhashMap(); 
			  
				methodtraces2 = db.getMethodtraces2SubjectTSubjectN();
				methodtraces2HashMap=db.getMethodtracehashmap(); 
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
				  //CHILDREN 
				  ChildrenHashMap= db.getChildrenHashMap(); 
				  //IMPLEMENTATIONS 
				  INTERFACEHASHMAPFINAL= db.getINTERFACEHASHMAPFINAL(); 
				  //PARAMETERS 
				  
				  parameterHashMap= db.getParameterhashMap(); 
				  
				
		}else if(ProgramName.equals("gantt")) {
			
			File file1log = new File("C:\\Users\\mouna\\dumps\\MethodCallsGantt.txt");
			FileOutputStream fosfila1 = new FileOutputStream(file1log);
			 bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));
			 
			 
			 
			 
				 
				 
			dbgantt = new DatabaseReading2Gantt();
			DatabaseReading2Gantt.MakePredictions();
			
			methodtraces2 = dbgantt.getMethodtraces2SubjectTSubjectN();
			methodtraces2HashMap=dbgantt.getMethodtracehashmap(); 
			classtraces2 = dbgantt.getClassestraces2();
		//	methodlist = dbgantt.getMethodlist();
			 methodtracesRequirementClass = dbgantt.getClassesRequirementtraceshashmap(); 
			 InterfacesHashMap = dbgantt.getInterfaces();
			  linkedmethodhashmap = dbgantt.getLinkedmethodhashmap(); 
			  InterfacesHashMapAlreadyImpl = dbgantt.getInterfacehashmapAlreadyImpl();
			  //INTERFACES 
			  InterfacesOwnerClassHashMap = dbgantt.getInterfacehashmapOwnerClass(); 
			  //FIELD METHODS 
			  FieldMethodsHashMap= dbgantt.getMethodFieldHashMap();
			  //FIELD CLASSES 
			  FieldClassesHashMap= dbgantt.getClassFieldHashMap(); 
			  //SUPERCLASSES
			  SuperclassesHashMap= dbgantt.getSuperclassesHashMap(); 
			  //PARAMETERS 
			  
			  parameterHashMap= dbgantt.getParameterhashMap(); 
			  
				methodtraces2 = dbgantt.getMethodtraces2SubjectTSubjectN();
				methodtraces2HashMap=dbgantt.getMethodtracehashmap(); 
				classtraces2 = dbgantt.getClassestraces2();
			//	methodlist = dbgantt.getMethodlist();
				 methodtracesRequirementClass = dbgantt.getClassesRequirementtraceshashmap(); 
				 InterfacesHashMap = dbgantt.getInterfaces();
				  linkedmethodhashmap = dbgantt.getLinkedmethodhashmap(); 
				  InterfacesHashMapAlreadyImpl = dbgantt.getInterfacehashmapAlreadyImpl();
				  //INTERFACES 
				  InterfacesOwnerClassHashMap = dbgantt.getInterfacehashmapOwnerClass(); 
				  //FIELD METHODS 
				  FieldMethodsHashMap= dbgantt.getMethodFieldHashMap();
				  //FIELD CLASSES 
				  FieldClassesHashMap= dbgantt.getClassFieldHashMap(); 
				  //SUPERCLASSES
				  SuperclassesHashMap= dbgantt.getSuperclassesHashMap(); 
				  //CHILDREN 
				  ChildrenHashMap= dbgantt.getChildrenHashMap(); 
				  //IMPLEMENTATIONS 
				  INTERFACEHASHMAPFINAL= dbgantt.getINTERFACEHASHMAPFINAL(); 
				  //PARAMETERS 
				  
				  parameterHashMap= dbgantt.getParameterhashMap(); 
		}else if(ProgramName.equals("jhotdraw")) {
			
			File file1log = new File("C:\\Users\\mouna\\dumps\\MethodCallsJHotDraw.txt");
			FileOutputStream fosfila1 = new FileOutputStream(file1log);
			 bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));
			
			 
			
				 
				 
				 
			dbjhotdraw = new DatabaseReading2JHotDraw3(); 
			DatabaseReading2JHotDraw3.MakePredictions();
			methodtraces2 = dbjhotdraw.getMethodtraces2SubjectTSubjectN();
			methodtraces2HashMap=dbjhotdraw.getMethodtracehashmap(); 
			classtraces2 = dbjhotdraw.getClassestraces2();
		//	methodlist = dbjhotdraw.getMethodlist();
			 methodtracesRequirementClass = dbjhotdraw.getClassesRequirementtraceshashmap(); 
			 InterfacesHashMap = dbjhotdraw.getInterfaces();
			  linkedmethodhashmap = dbjhotdraw.getLinkedmethodhashmap(); 
			  InterfacesHashMapAlreadyImpl = dbjhotdraw.getInterfacehashmapAlreadyImpl();
			  //INTERFACES 
			  InterfacesOwnerClassHashMap = dbjhotdraw.getInterfacehashmapOwnerClass(); 
			  //FIELD METHODS 
			  FieldMethodsHashMap= dbjhotdraw.getMethodFieldHashMap();
			  //FIELD CLASSES 
			  FieldClassesHashMap= dbjhotdraw.getClassFieldHashMap(); 
			  //SUPERCLASSES
			  SuperclassesHashMap= dbjhotdraw.getSuperclassesHashMap(); 
			  //PARAMETERS 
			  
			  parameterHashMap= dbjhotdraw.getParameterhashMap(); 
			  
				methodtraces2 = dbjhotdraw.getMethodtraces2SubjectTSubjectN();
				methodtraces2HashMap=dbjhotdraw.getMethodtracehashmap(); 
				classtraces2 = dbjhotdraw.getClassestraces2();
			//	methodlist = dbjhotdraw.getMethodlist();
				 methodtracesRequirementClass = dbjhotdraw.getClassesRequirementtraceshashmap(); 
				 InterfacesHashMap = dbjhotdraw.getInterfaces();
				  linkedmethodhashmap = dbjhotdraw.getLinkedmethodhashmap(); 
				  InterfacesHashMapAlreadyImpl = dbjhotdraw.getInterfacehashmapAlreadyImpl();
				  //INTERFACES 
				  InterfacesOwnerClassHashMap = dbjhotdraw.getInterfacehashmapOwnerClass(); 
				  //FIELD METHODS 
				  FieldMethodsHashMap= dbjhotdraw.getMethodFieldHashMap();
				  //FIELD CLASSES 
				  FieldClassesHashMap= dbjhotdraw.getClassFieldHashMap(); 
				  //SUPERCLASSES
				  SuperclassesHashMap= dbjhotdraw.getSuperclassesHashMap(); 
				  //CHILDREN 
				  ChildrenHashMap= dbjhotdraw.getChildrenHashMap(); 
				  //IMPLEMENTATIONS 
				  INTERFACEHASHMAPFINAL= dbjhotdraw.getINTERFACEHASHMAPFINAL(); 
				  //PARAMETERS 
				  
				  parameterHashMap= dbjhotdraw.getParameterhashMap(); 
		}else if(ProgramName.equals("itrust")) {
			
			File file1log = new File("C:\\Users\\mouna\\dumps\\MethodCallsiTrust.txt");
			FileOutputStream fosfila1 = new FileOutputStream(file1log);
			 bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));
			 
			 
			 
			
				 
				 
				 
			dbitrust = new DatabaseReading2itrustfinal();
			DatabaseReading2itrustfinal.MakePredictions();
			methodtraces2 = dbitrust.getMethodtraces2SubjectTSubjectN();
			methodtraces2HashMap=dbitrust.getMethodtracehashmap(); 
			classtraces2 = dbitrust.getClassestraces2();
		//	methodlist = dbitrust.getMethodlist();
			 methodtracesRequirementClass = dbitrust.getClassesRequirementtraceshashmap(); 
			 InterfacesHashMap = dbitrust.getInterfaces();
			  linkedmethodhashmap = dbitrust.getLinkedmethodhashmap(); 
			  InterfacesHashMapAlreadyImpl = dbitrust.getInterfacehashmapAlreadyImpl();
			  //INTERFACES 
			  InterfacesOwnerClassHashMap = dbitrust.getInterfacehashmapOwnerClass(); 
			  //FIELD METHODS 
			  FieldMethodsHashMap= dbitrust.getMethodFieldHashMap();
			  //FIELD CLASSES 
			  FieldClassesHashMap= dbitrust.getClassFieldHashMap(); 
			  //SUPERCLASSES
			  SuperclassesHashMap= dbitrust.getSuperclassesHashMap(); 
			  //PARAMETERS 
			  
			  parameterHashMap= dbitrust.getParameterhashMap(); 
			  
				methodtraces2 = dbitrust.getMethodtraces2SubjectTSubjectN();
				methodtraces2HashMap=dbitrust.getMethodtracehashmap(); 
				classtraces2 = dbitrust.getClassestraces2();
			//	methodlist = dbitrust.getMethodlist();
				 methodtracesRequirementClass = dbitrust.getClassesRequirementtraceshashmap(); 
				 InterfacesHashMap = dbitrust.getInterfaces();
				  linkedmethodhashmap = dbitrust.getLinkedmethodhashmap(); 
				  InterfacesHashMapAlreadyImpl = dbitrust.getInterfacehashmapAlreadyImpl();
				  //INTERFACES 
				  InterfacesOwnerClassHashMap = dbitrust.getInterfacehashmapOwnerClass(); 
				  //FIELD METHODS 
				  FieldMethodsHashMap= dbitrust.getMethodFieldHashMap();
				  //FIELD CLASSES 
				  FieldClassesHashMap= dbitrust.getClassFieldHashMap(); 
				  //SUPERCLASSES
				  SuperclassesHashMap= dbitrust.getSuperclassesHashMap(); 
				  //CHILDREN 
				  ChildrenHashMap= dbitrust.getChildrenHashMap(); 
				  //IMPLEMENTATIONS 
				  INTERFACEHASHMAPFINAL= dbitrust.getINTERFACEHASHMAPFINAL(); 
				  //PARAMETERS 
				  
				  parameterHashMap= dbitrust.getParameterhashMap(); 
		}
		
		
	
CalculateChildrenInterfaces(); 
		
GenerateNewValuesInTracesClasses(); 
		HashMap<String, LogInfo> LogInfoHashMap= new HashMap<String, LogInfo>(); 
		j=0; 
		 MethodTracesHashmapValues = methodtraces2HashMap.values(); 

		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {

			String reqclass= methodtrace.Requirement.getID()+"-"+ methodtrace.getClassRepresentation().classid; 
			ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
			String reqmethod= methodtrace.Requirement.getID()+"-"+ methodtrace.getMethodRepresentation().methodid; 
		 ITERATION1=0; 
		 LogInfo loginfo = new LogInfo(); 
		 
		 loginfo.setMethodID( methodtrace.getMethodRepresentation().methodid);
		 loginfo.setMethodName(methodtrace.getMethodRepresentation().methodname); 
		 loginfo.setClassID(methodtrace.getClassRepresentation().classid);
		 loginfo.setClassName(methodtrace.getClassRepresentation().classname);
		 loginfo.setTraceValue(methodtrace.getGoldfinal());

			//PATTERN 1
			if(myclasstraceHashMap.getTraceFinal()!=null) {
				
				String tracegold2 = myclasstraceHashMap.getTraceFinal(); 
				tracegold2=tracegold2.trim(); 
				if (tracegold2.equals("T")) {
					
					loginfo.setOwnerClassPrediction("E");
					PatternSetVariables("E",methodtrace,"100%","P1"); 
					LogInfoHashMap.put(reqmethod, loginfo); 
					
				} else if (tracegold2.equals("N")) {
					
					loginfo.setOwnerClassPrediction("N");
					PatternSetVariables("N",methodtrace,"100%","P1"); 
					LogInfoHashMap.put(reqmethod, loginfo); 
				} 
				

				
				else {
					loginfo.setOwnerClassPrediction("E");
					PatternSetVariables("E", methodtrace,"100%","P1"); 
					LogInfoHashMap.put(reqmethod, loginfo); 
				}
				ITERATION1++; 
			}
			

			
			
			
			
			
			
			
			j++;
			
		}
		 LinkedHashMap<String, MethodTraceSubjectTSubjectN> MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 
//		 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNMethodCallsSetToT);
		 System.out.println("===============>PATTERNS 1 SET TO T   ITERATION "+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNMethodCallsSetToT.toString());

		 int ITERATION=0; 
		
		PredictionsNewHashMap=InitializePredictionsHashMap(PredictionsNewHashMap, MethodTracesHashmapValues); 
		while(Equals(PredictionsOldHashMap, PredictionsNewHashMap)==false) {
		
			PredictionsOldHashMap=InitializePredictionsHashMap(PredictionsOldHashMap, MethodTracesHashmapValues); 

			
			System.out.println("-------------------------------------------");

			
			
			
					//////////////////////////////////////////////////////////////////////////////////////////
					int k=0; 
					//PATTERN 2 AND PATTERN 4 PURE 
					// methodtraces2	=	InitializePredictionsHashMapBlankValues(PredictionsOldHashMap, methodtraces22); 
					for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
						String reqMethod= methodtrace.Requirement.ID+"-"+ methodtrace.getMethodRepresentation().methodid; 
						LogInfo LogInfo = LogInfoHashMap.get(reqMethod); 
					//methodtrace.setPrediction("");
					//PATTERN 2 AND PATTERN 4
					List<Method2Representation> CalleesList = methodtrace.getCalleesList(); 
					List<Method2Representation> CallersList = methodtrace.getCallersList(); 
					
					List<String> PredictionCalleeList=new ArrayList<String>();
					for(Method2Representation callee: CalleesList) {
					String RequirementID=methodtrace.Requirement.ID; 
					String MethodID= callee.methodid; 
					String key= MethodID+"-"+RequirementID; 
					if(methodtraces2HashMap.get(key)!=null) {
					String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
					PredictionCalleeList.add(predictionvalue); 
					}
					
					}
					
					
					
					List<String> PredictionCallerList=new ArrayList<String>();
					for(Method2Representation caller: CallersList) {
					String RequirementID=methodtrace.Requirement.ID; 
					String MethodID= caller.methodid; 
					String key= MethodID+"-"+RequirementID; 
					if(methodtraces2HashMap.get(key)!=null) {
					String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
					PredictionCallerList.add(predictionvalue); 
					}
					}
					
					
					
					
						 List<String> iterationValues = LogInfo.getIterationValues(); 
						 
					
					
					//methodtrace.setPrediction("");
					//PATTERN 2
					if(			PredictionCalleeList.contains("N") 
					&& PredictionCallerList.contains("N")
					&& !PredictionCalleeList.contains("T") 
					&& !PredictionCallerList.contains("T") 						
					&& !methodtrace.getPrediction().equals("T") 
					&& !methodtrace.getPrediction().equals("N")
					
					
					) {
					//methodtrace.setPrediction("N");
					
					
					
					PatternSetVariables("N", methodtrace, "90%", "P2");
					
					
					iterationValues.add("N-PureN"); 
					LogInfo.setIterationValues(iterationValues);
					LogInfoHashMap.put(reqMethod, LogInfo);
					//System.out.println("yes");
					}
					else 	if(!PredictionCalleeList.contains("N") 
					&& !PredictionCallerList.contains("N") 
					&& PredictionCalleeList.contains("T") 
					&&  PredictionCallerList.contains("T") 
					&& !methodtrace.getPrediction().equals("T") 
					&& !methodtrace.getPrediction().equals("N")
					
					
					) {
					//methodtrace.setPrediction("N");
					
					PatternSetVariables("T", methodtrace, "90%", "P2");
					
					iterationValues.add("T-PureT"); 
					LogInfo.setIterationValues(iterationValues);
					LogInfoHashMap.put(reqMethod, LogInfo);
					
					
					//System.out.println("yes");
					}
					
					//PATTERN 4
					if(		PredictionCalleeList.isEmpty() 
					&&  PredictionCallerList.contains("N")
					&& !PredictionCallerList.contains("T") 
					&& !methodtrace.getPrediction().equals("T") 
					&& !methodtrace.getPrediction().equals("N")
					
					
					
					) {
					//methodtrace.setPrediction("N");
						
						iterationValues.add("N-PureNLeaf"); 
						LogInfo.setIterationValues(iterationValues);
						LogInfoHashMap.put(reqMethod, LogInfo);
						
						
					PatternSetVariables("N", methodtrace, "90%", "P4");
					
					//System.out.println("yes");
					}
					else 	if(PredictionCalleeList.isEmpty() 
					&& !PredictionCallerList.contains("N") 
					&&  PredictionCallerList.contains("T")  
					&& !methodtrace.getPrediction().equals("T") 
					&& !methodtrace.getPrediction().equals("N")
					
					
					
					) {
					//methodtrace.setPrediction("N");
					PatternSetVariables("T", methodtrace, "90%", "P2");
					
					iterationValues.add("T-PureTLeaf"); 
					LogInfo.setIterationValues(iterationValues);
					LogInfoHashMap.put(reqMethod, LogInfo);
					
					
					//System.out.println("yes");
					}
					k++; 
					
					
					}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			 k=0; 
			//PATTERN 3 AND PATTERN 5 MIXED 
			for (MethodTraceSubjectTSubjectN methodtrace : methodtraces2) {
				String reqMethod= methodtrace.Requirement.ID+"-"+ methodtrace.getMethodRepresentation().methodid; 
				LogInfo LogInfo = LogInfoHashMap.get(reqMethod); 
			
				//PATTERN 3 AND PATTERN 5
				//MIXED PATTERNS 
				List<Method2Representation> CalleesList = methodtrace.getCalleesList(); 
				List<Method2Representation> CallersList = methodtrace.getCallersList(); 
				
				List<String> PredictionCalleeList=new ArrayList<String>();
				for(Method2Representation callee: CalleesList) {
					String RequirementID=methodtrace.Requirement.ID; 
					String MethodID= callee.methodid; 
					String key= MethodID+"-"+RequirementID; 
					if(methodtraces2HashMap.get(key)!=null) {
						String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
						PredictionCalleeList.add(predictionvalue); 
					}
				}
				
				
				
				List<String> PredictionCallerList=new ArrayList<String>();
				for(Method2Representation caller: CallersList) {
					String RequirementID=methodtrace.Requirement.ID; 
					String MethodID= caller.methodid; 
					String key= MethodID+"-"+RequirementID; 
					
					if(methodtraces2HashMap.get(key)!=null) {
						String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
						PredictionCallerList.add(predictionvalue); 
					}
				}
//				methodtrace.setPrediction("");
				
				//PATTERN 3
				
				
				List<String> mylist;
			List<String> iterationValues = LogInfo.getIterationValues(); 
			for(String it: iterationValues) {
				System.out.print(it+", ");
			}
			System.out.println();
				if(		PredictionCalleeList.contains("N") 
						&& PredictionCallerList.contains("N") 	
						&& !methodtrace.getPrediction().equals("T") 
						&& !methodtrace.getPrediction().equals("N") 
						
						)
						{
					
					PatternSetVariables("N", methodtrace, "80%", "P3");
					iterationValues.add("N-MixedN"); 
					LogInfo.setIterationValues(iterationValues);
					LogInfoHashMap.put(reqMethod, LogInfo);

					//System.out.println("yes");
				}
				else if(PredictionCalleeList.contains("T")
						&& PredictionCallerList.contains("T") 	
						&& !methodtrace.getPrediction().equals("T") 
						&& !methodtrace.getPrediction().equals("N")
						
						) {
					//methodtrace.setPrediction("N");
					PatternSetVariables("T", methodtrace, "80%", "P3");
					iterationValues.add("T-MixedT"); 
					LogInfo.setIterationValues(iterationValues);
					LogInfoHashMap.put(reqMethod, LogInfo);

					//System.out.println("yes");
				}
				
				//PATTERN 5
				if(			PredictionCalleeList.isEmpty() 
						&&  PredictionCallerList.contains("N") 
						&& !methodtrace.getPrediction().equals("T") 
						&& !methodtrace.getPrediction().equals("N")
						
						) {
					iterationValues.add("N-MixedNLeaf"); 
					LogInfo.setIterationValues(iterationValues);
					PatternSetVariables("N", methodtrace, "80%", "P5");
					LogInfoHashMap.put(reqMethod, LogInfo);

				}
				else if(PredictionCalleeList.isEmpty() 
						&&  PredictionCallerList.contains("T")  
						&& !methodtrace.getPrediction().equals("T") 
						&& !methodtrace.getPrediction().equals("N") 
					
						
						
						) {
					iterationValues.add("T-MixedTLeaf"); 
					LogInfo.setIterationValues(iterationValues);
					PatternSetVariables("T", methodtrace, "80%", "P5");
					LogInfoHashMap.put(reqMethod, LogInfo);

				}
				k++; 
			}
			//InitializePredictionsHashMapBlankValues(PredictionsNewHashMap, methodtraces2); 
			//PRINT 
			
			  MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 
//			 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNMethodCallsSetToT);
			System.out.println("===============>PATTERNS 3 AND 5 ITERATION SET TO T  ITERATION "+ITERATION  +	"   PREDICTION VALUES "+NEWPATTERNMethodCallsSetToT.toString());
			 //END  PRINT 
			
			
			
			
			
			
			
			for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
			String ReqMethod=	methodtrace.Requirement.ID+"-"+methodtrace.MethodRepresentation.methodid; 
				LogInfo LogInfo = LogInfoHashMap.get(ReqMethod); 
				List<String> IterationValues = LogInfo.getIterationValues();
				List<String> interfaces = methodtrace.getInterfaceList(); 
				List<String> implementations=methodtrace.getImplementationList(); 
				List<String> superclasses=methodtrace.getSuperClassesList(); 
				List<String> children=methodtrace.getChildrenList();
			
				List<String> interfaceTraceValues = new ArrayList<String>(); 
				for(String inter: interfaces) {
						String[] inters = inter.split("-"); 
						String interVal = inters[0]; 
						interfaceTraceValues.add(interVal); 
				}
				
				
				List<String> implementationsTraceValues = new ArrayList<String>(); 
				for(String inter: implementations) {
						String[] inters = inter.split("-"); 
						String interVal = inters[0]; 
						implementationsTraceValues.add(interVal); 
				}
				
				List<String> superclassesTraceValues = new ArrayList<String>(); 
				for(String inter: superclasses) {
						String[] inters = inter.split("-"); 
						String interVal = inters[0]; 
						superclassesTraceValues.add(interVal); 
				}
				
				List<String> childrenTraceValues = new ArrayList<String>(); 
				for(String inter: children) {
						String[] inters = inter.split("-"); 
						String interVal = inters[0]; 
						childrenTraceValues.add(interVal); 
				}
				 boolean allEqualInterfaces = interfaceTraceValues.stream().distinct().limit(2).count() <= 1 && interfaceTraceValues.size()>=1; 
				 boolean allEqualImplementations = implementationsTraceValues.stream().distinct().limit(2).count() <= 1 && implementationsTraceValues.size()>=1; 
				 boolean allEqualSuperclasses = superclassesTraceValues.stream().distinct().limit(2).count() <= 1 && superclassesTraceValues.size()>=1; 
				 boolean allEqualChildren = childrenTraceValues.stream().distinct().limit(2).count() <= 1 && childrenTraceValues.size()>=1; 
				

				 
				 int interfaceCountT=0; 
				 int interfaceCountN=0;
				 int interfaceCountE=0; 
				 for(String interfaceval: interfaceTraceValues) {
					 if(interfaceval.trim().equals("T")) {
						 interfaceCountT++; 
					 }else if(interfaceval.trim().equals("N")) {
						 interfaceCountN++; 
					 }else {
						 interfaceCountE++; 
					 }
				 }
				 int impplementationCountT=0; 
				 int impplementationCountN=0;
				 int impplementationCountE=0; 
				 for(String interfaceval: implementationsTraceValues) {
					 if(interfaceval.trim().equals("T")) {
						 impplementationCountT++; 
					 }else if(interfaceval.trim().equals("N")) {
						 impplementationCountN++; 
					 }else {
						 impplementationCountE++; 
					 }
				 }
				 int superclassCountT=0; 
				 int superclassCountN=0;
				 int superclassCountE=0; 
				 for(String interfaceval: superclassesTraceValues) {
					 if(interfaceval.trim().equals("T")) {
						 superclassCountT++; 
					 }else if(interfaceval.trim().equals("N")) {
						 superclassCountN++; 
					 }else {
						 superclassCountE++; 
					 }
				 }
				 
				 int childrenCountT=0; 
				 int childrenCountN=0;
				 int childrenCountE=0; 
				 for(String interfaceval: childrenTraceValues) {
					 if(interfaceval.trim().equals("T")) {
						 childrenCountT++; 
					 }else if(interfaceval.trim().equals("N")) {
						 childrenCountN++; 
					 }else {
						 childrenCountE++; 
					 }
				 }

					 
					 
			
					 if(
								((allEqualInterfaces==true &&  interfaceTraceValues.get(0).equals("N")) && !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N"))
								|| (allEqualImplementations==true &&  implementationsTraceValues.get(0).equals("N") && !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N")) 
								|| (allEqualSuperclasses==true &&  superclassesTraceValues.get(0).equals("N") && !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N"))
								|| (allEqualChildren==true && childrenTraceValues.get(0).equals("N")&& !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N"))
								
									 ) 
			
				 
				 
				 

				 
				 {
						 if(IterationValues!=null) {
							 IterationValues.add("N-AllNInheritance"); 
							 LogInfo.setIterationValues(IterationValues);
							 LogInfoHashMap.put(ReqMethod, LogInfo);
						 }else {
							 IterationValues= new ArrayList<String>(); 
							 IterationValues.add("N-AllNInheritance"); 
							 LogInfo.setIterationValues(IterationValues);
							 LogInfoHashMap.put(ReqMethod, LogInfo);
						 }
						PatternSetVariables("N", methodtrace, "90%", "P2");

				 }
				 

				  
					  if(
								(allEqualInterfaces==true &&  interfaceTraceValues.get(0).equals("T") && !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N"))
								|| (allEqualImplementations==true &&  implementationsTraceValues.get(0).equals("T") && !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N")) 
								|| (allEqualSuperclasses==true &&  superclassesTraceValues.get(0).equals("T") && !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N"))
								|| (allEqualChildren==true && childrenTraceValues.get(0).equals("T") && !methodtrace.getPrediction().equals("T") && !methodtrace.getPrediction().equals("N"))
								
									 ) 
		

				  {
						  
						  if(IterationValues!=null) {
								 IterationValues.add("T-AllTInheritance"); 
								 LogInfo.setIterationValues(IterationValues);
								 LogInfoHashMap.put(ReqMethod, LogInfo);
							 }else {
								 IterationValues= new ArrayList<String>(); 
								 IterationValues.add("T-AllTInheritance"); 
								 LogInfo.setIterationValues(IterationValues);
								 LogInfoHashMap.put(ReqMethod, LogInfo);
							 }
								PatternSetVariables("T", methodtrace, "90%", "P2");

						 }
			}
			
			
			//PRINT 
			
			

				
			
			
			
			
			
			
			for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {	
				String ReqMethod=methodtrace.Requirement.ID+"-"+methodtrace.MethodRepresentation.methodid; 
				LogInfo LogInfo = LogInfoHashMap.get(ReqMethod); 
				List<String> myits = LogInfo.getIterationValues(); 
				if(myits.size()==ITERATION+1) {
					System.out.println(myits.get(ITERATION));

				}
				else {
					myits.add(" "); 
					LogInfo.setIterationValues(myits);
				}
		
			for(String it: myits) {
				System.out.println("it"+ it+ " it");
			}
			LogInfoHashMap.put(ReqMethod, LogInfo);
			}			
			 MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 

			 //END  PRINT 
			ITERATION++; 
			System.out.println("HEEEEEEY  " +ITERATION);
			
			PredictionsNewHashMap=InitializePredictionsHashMap(PredictionsNewHashMap, MethodTracesHashmapValues); 
		}
		
		
		WriteInDatabaseAndComputePrecisionAndRecall(methodtraces2, NEWPATTERNMethodCallsSetToT, LogInfoHashMap);
		System.out.println("===============>PATTERNS 2 AND 4 ITERATION SET TO T   ITERATION  "+ITERATION  +	"   PREDICTION VALUES "+NEWPATTERNMethodCallsSetToT.toString());
		
		
		
		bwfile1.write(NEWPATTERNMethodCallsSetToT.toString());
		bwfile1.close();
		if(ProgramName.equals("chess")) {
		bwfile.write("MethodID, MethodName, ClassID, ClassName, TraceValue, OwnerClassPrediction, PrecisionRecall, IterationValues");	
		bwfile.newLine();
		}
		if(ProgramName.equals("gantt")) {
		bwfile2.write("MethodID, MethodName, ClassID, ClassName, TraceValue, OwnerClassPrediction, PrecisionRecall, IterationValues");	
		bwfile2.newLine();
		}
		if(ProgramName.equals("itrust")) {
		bwfile3.write("MethodID, MethodName, ClassID, ClassName, TraceValue, OwnerClassPrediction, PrecisionRecall, IterationValues");	
		bwfile3.newLine();
	}
		if(ProgramName.equals("jhotdraw")) {
		bwfile4.write("MethodID, MethodName, ClassID, ClassName, TraceValue, OwnerClassPrediction, PrecisionRecall, IterationValues");	
		bwfile4.newLine();
		}
		
		PredictionsNewHashMap=InitializePredictionsHashMap(PredictionsNewHashMap, methodtraces2); 
		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {	
				String	reqmethod=methodtrace.Requirement.ID+"-"+methodtrace.MethodRepresentation.methodid; 
				LogInfoHashMap.get(reqmethod); 
				if(ProgramName.equals("gantt")) {
					bwfile2.write(LogInfoHashMap.get(reqmethod).toString());
					bwfile2.newLine();
				}
				if(ProgramName.equals("chess")) {
					bwfile.write(LogInfoHashMap.get(reqmethod).toString());
					bwfile.newLine();
				}
				if(ProgramName.equals("itrust")) {
					bwfile3.write(LogInfoHashMap.get(reqmethod).toString());
					bwfile3.newLine();
				}
				if(ProgramName.equals("jhotdraw")) {
					bwfile4.write(LogInfoHashMap.get(reqmethod).toString());
					bwfile4.newLine();
				}
		}
		
		
		if(ProgramName.equals("chess")) {
			bwfile.close();

		}else if(ProgramName.equals("gantt")) {
			bwfile2.close();
		}else if(ProgramName.equals("itrust")) {
			bwfile3.close();
		}else if(ProgramName.equals("jhotdraw")) {
			bwfile4.close();
		}
		
		return PredictionsNewHashMap; 
	}
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/	
	
	private void GenerateNewValuesInTracesClasses() {
	// TODO Auto-generated method stub
		int j=0; 
		Collection<MethodTraceSubjectTSubjectN> MethodTracesHashmapValues = methodtraces2HashMap.values(); 

		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {

		
		
			String reqclass= methodtrace.Requirement.getID()+"-"+ methodtrace.ClassRepresentation.classid;
			ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
	
			//PATTERN 1
		 
		 List<String> ImplementationList = methodtrace.getImplementationList(); 
		 List<String> ChildrenList=methodtrace.getChildrenList();
		 List<String> SuperClassesList=methodtrace.getSuperClassesList(); 
		 List<String> InterfaceList=methodtrace.getInterfaceList(); 
		 
		 
		 
		 List<String> childrenListOwners= new ArrayList<String>(); 
		 List<String> TraceValues= new ArrayList<String>(); 
		 List<String> SuperClassListOwners= new ArrayList<String>(); 
		 
		 List<String> SuperClassListOwners2= new ArrayList<String>(); 
		 List<String> childrenListOwners2= new ArrayList<String>(); 
		 List<String> TraceValues2= new ArrayList<String>(); 
		 
		 
		 
		 List<String> InterfacesListOwners= new ArrayList<String>(); 
		 List<String> ImplementationListOwners= new ArrayList<String>(); 
		 List<String> TraceValuesInterfaces= new ArrayList<String>(); 
		 
		 List<String> InterfacesListOwners2= new ArrayList<String>(); 
		 List<String> ImplementationListOwners2= new ArrayList<String>(); 
		 List<String> TraceValuesInterfaces2= new ArrayList<String>(); 

//CHILDREN 
		 for(String childVal: ChildrenList) {
			  String[] Vals = childVal.split("-"); 
			  String myvalue = Vals[0]; 
			  String ownerclassChild = Vals[1]; 
			  String superclassownerID = Vals[2]; 
			  TraceValues.add(myvalue); 
			  childrenListOwners.add(ownerclassChild); 
			  SuperClassListOwners.add(superclassownerID); 
		 }
		 boolean allEqual = TraceValues.stream().distinct().limit(2).count() <= 1 && TraceValues.size()>=1; 
		 if(allEqual) {
			
				ClassTrace2 myclasstraceNew = methodtracesRequirementClass.get(methodtrace.Requirement.getID()+"-"+methodtrace.ClassRepresentation.classid); 
				if( (myclasstraceNew.getTraceFinal()==null  
						 ||	myclasstraceNew.getTraceFinal().equals("E")
						 ||	myclasstraceNew.getTraceFinal().equals("null")) &&
						 (TraceValues.get(0).equals("T")|| TraceValues.get(0).equals("N"))) {
					 myclasstraceNew.setTraceFinal(TraceValues.get(0));
					 methodtracesRequirementClass.put(methodtrace.Requirement.getID()+"-"+methodtrace.ClassRepresentation.classid, myclasstraceNew); 
				 }
			 
		 }
		
		 
			
		 
	//SUPERCLASSES	 
		 
		 for(String SuperclassVal: SuperClassesList) {
			  String[] Vals = SuperclassVal.split("-"); 
			  String myvalue = Vals[0]; 
			  String ownerclassSuperclass = Vals[1]; 
			  String childclassownerID = Vals[2]; 
			  TraceValues2.add(myvalue); 
			  childrenListOwners2.add(childclassownerID); 
			  SuperClassListOwners2.add(ownerclassSuperclass); 
		 }
		  allEqual = TraceValues2.stream().distinct().limit(2).count() <= 1 && TraceValues2.size()>=1; 
		 if(allEqual) {
			
				ClassTrace2 myclasstraceNew = methodtracesRequirementClass.get(methodtrace.Requirement.getID()+"-"+methodtrace.ClassRepresentation.classid); 
				 if( (myclasstraceNew.getTraceFinal()==null  
						 ||	myclasstraceNew.getTraceFinal().equals("E")
						 ||	myclasstraceNew.getTraceFinal().equals("null")) &&
						 (TraceValues2.get(0).equals("T")|| TraceValues2.get(0).equals("N"))) {
					 myclasstraceNew.setTraceFinal(TraceValues2.get(0));
					 methodtracesRequirementClass.put(methodtrace.Requirement.getID()+"-"+methodtrace.ClassRepresentation.classid, myclasstraceNew); 
				 }
			 
		 }
		 
		 
			
		 
//INTERFACES	 
		 
		 for(String interfaceVal: InterfaceList) {
			  String[] Vals = interfaceVal.split("-"); 
			  String myvalue = Vals[0]; 
			  String InterfaceID = Vals[1]; 
			  String ImplementationID = Vals[2]; 
			  TraceValuesInterfaces.add(myvalue); 
			  InterfacesListOwners.add(InterfaceID); 
			  ImplementationListOwners.add(ImplementationID); 
		 }
		  allEqual = TraceValuesInterfaces.stream().distinct().limit(2).count() <= 1 && TraceValuesInterfaces.size()>=1; 
		 if(allEqual) {
			
				ClassTrace2 myclasstraceNew = methodtracesRequirementClass.get(methodtrace.Requirement.getID()+"-"+methodtrace.ClassRepresentation.classid); 
				 if( (myclasstraceNew.getTraceFinal()==null  
						 ||	myclasstraceNew.getTraceFinal().equals("E")
						 ||	myclasstraceNew.getTraceFinal().equals("null")) &&
						 (TraceValuesInterfaces.get(0).equals("T")|| TraceValuesInterfaces.get(0).equals("N"))) {
					 myclasstraceNew.setTraceFinal(TraceValuesInterfaces.get(0));
					 methodtracesRequirementClass.put(methodtrace.Requirement.getID()+"-"+methodtrace.ClassRepresentation.classid, myclasstraceNew); 
				 }
			 
		 }
		 
			
		 
//IMPLEMENTATIONS	 
		 
		 for(String ImplementationVal: ImplementationList) {
			  String[] Vals = ImplementationVal.split("-"); 
			  String myvalue = Vals[0]; 
			  String ImplementationID = Vals[1]; 
			  String InterfaceID = Vals[2]; 
			  TraceValuesInterfaces2.add(myvalue); 
			  InterfacesListOwners2.add(InterfaceID); 
			  ImplementationListOwners2.add(ImplementationID); 
		 }
		  allEqual = TraceValuesInterfaces2.stream().distinct().limit(2).count() <= 1 && TraceValuesInterfaces2.size()>=1; 
		 if(allEqual) {
			
				ClassTrace2 myclasstraceNew = methodtracesRequirementClass.get(methodtrace.Requirement.getID()+"-"+methodtrace.ClassRepresentation.classid); 
				 if( (myclasstraceNew.getTraceFinal()==null  
						 ||	myclasstraceNew.getTraceFinal().equals("E")
						 ||	myclasstraceNew.getTraceFinal().equals("null")) &&
						 (TraceValuesInterfaces2.get(0).equals("T")|| TraceValuesInterfaces2.get(0).equals("N"))) {
					 myclasstraceNew.setTraceFinal(TraceValuesInterfaces2.get(0));
					 methodtracesRequirementClass.put(methodtrace.Requirement.getID()+"-"+methodtrace.ClassRepresentation.classid, myclasstraceNew); 
				 }
			 
		 }
			
		
			
			
			
			
			
			
			j++;
			
		
		}
}
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/	
	public void CalculateChildrenInterfaces() {
	// TODO Auto-generated method stub
		int j=0; 
		Collection<MethodTraceSubjectTSubjectN> MethodTracesHashmapValues = methodtraces2HashMap.values(); 
		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
			List<String> PredictionParams= new ArrayList<String>(); 
			List<String> PredictionParamsOwnerClass= new ArrayList<String>(); 
			List<String> PredictionFields= new ArrayList<String>(); 
			List<String> PredictionFieldsOwnerClass= new ArrayList<String>(); 
			System.out.println(methodtraces2.size());
			System.out.println(j);
			System.out.println(Row);
			System.out.println(methodtraces2HashMap.size());

			
			List<MethodField2> mymethodfields = FieldMethodsHashMap.get(methodtrace.MethodRepresentation.methodid); 
			List<Parameter2> paramlist = parameterHashMap.get(methodtrace.MethodRepresentation.methodid); 
		if(mymethodfields!=null)
			for(MethodField2 mymeth: mymethodfields) {
				String reqclass= methodtrace.Requirement.ID+"-"+ mymeth.getMethodFieldType().classid; 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTraceFinal()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
					PredictionFields.add(traceGold2V2); 
				}
			}
		if( paramlist!=null) {
			for(Parameter2 mymeth: paramlist) {
				String reqclass= methodtrace.Requirement.ID+"-"+ mymeth.getParameterType().classid; 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTraceFinal()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
					PredictionParams.add(traceGold2V2); 
				}
			}
		}
		
		if( paramlist!=null) {
			for(Parameter2 mymeth: paramlist) {
				String reqclass= methodtrace.Requirement.ID+"-"+ mymeth.getOwnerClass().classid; 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTraceFinal()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
					PredictionParamsOwnerClass.add(traceGold2V2); 
				}
			}
		}
		
		if(mymethodfields!=null)
			for(MethodField2 mymeth: mymethodfields) {
				String reqclass= methodtrace.Requirement.ID+"-"+ mymeth.getOwnerClass().classid;  
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTraceFinal()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
					PredictionFieldsOwnerClass.add(traceGold2V2); 
				}
			}
			methodtrace.setPredictionParams(PredictionParams);
			methodtrace.setPredictionFields(PredictionFields);
			methodtrace.setPredictionFieldsOwnerClass(PredictionFieldsOwnerClass);
			methodtrace.setPredictionParamsOwnerClass(PredictionParamsOwnerClass);
			
			List<String> SuperClassesList= new ArrayList<String>(); 
			List<String> InterfaceList= new ArrayList<String>(); 
			List<String> ChildrenList= new ArrayList<String>(); 
			List<String> ImplementationList= new ArrayList<String>(); 
			System.out.println(methodtraces2.size());
			System.out.println(j);
			System.out.println(Row);
			System.out.println(methodtraces2HashMap.size());

			
			List<Interface2> myinterfaces = InterfacesOwnerClassHashMap.get(methodtrace.ClassRepresentation.classid); 
			 List<SuperClass2> mysuperclasses = SuperclassesHashMap.get(methodtrace.ClassRepresentation.classid); 
			 List<Implementation2> myimplementations = INTERFACEHASHMAPFINAL.get(methodtrace.ClassRepresentation.classid); 
			 List<Children2> mychildren = ChildrenHashMap.get(methodtrace.ClassRepresentation.classid); 
			 System.out.println("Methodtrace class id "+methodtrace.ClassRepresentation.classid);
		if(myinterfaces!=null)
			for(Interface2 myinterface: myinterfaces) {
				String reqclass= methodtrace.Requirement.ID+"-"+ myinterface.getInterfaceClass().getClassid(); 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTraceFinal()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
					InterfaceList.add(traceGold2V2+"-"+myinterface.getInterfaceClass().getClassid()+"-"+methodtrace.ClassRepresentation.classid); 
				}
			}
		if( mysuperclasses!=null)
			for(SuperClass2 mysuperclass: mysuperclasses) {
				String reqclass= methodtrace.Requirement.ID+"-"+ mysuperclass.getSuperClass().classid; 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTraceFinal()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
					SuperClassesList.add(traceGold2V2+"-"+ mysuperclass.getSuperClass().classid+"-"+methodtrace.ClassRepresentation.classid); 
				}
			}
		if(mychildren!=null)
			for(Children2 mychild: mychildren) {
				String reqclass= methodtrace.Requirement.ID+"-"+ mychild.getOwnerClass().classid; 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTraceFinal()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
					ChildrenList.add(traceGold2V2+"-"+mychild.getOwnerClass().classid+"-"+methodtrace.ClassRepresentation.classid); 
				}
			}
		if( myimplementations!=null)
			for(Implementation2 myimplementation: myimplementations) {
				String reqclass= methodtrace.Requirement.ID+"-"+ myimplementation.getImplementation().classid; 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTraceFinal()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTraceFinal().trim();
					ImplementationList.add(traceGold2V2+"-"+myimplementation.getImplementation().classid+"-"+methodtrace.ClassRepresentation.classid); 
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
	 * @param logInfoHashMap **********************************************************************************************************************************************/	
	public void WriteInDatabaseAndComputePrecisionAndRecall(List<MethodTraceSubjectTSubjectN> methodtraces22,
		PredictionEvaluation nEWPATTERNMethodCallsSetToT2, HashMap<String, LogInfo> logInfoHashMap) {
	// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		nEWPATTERNMethodCallsSetToT2.ResetCounters(nEWPATTERNMethodCallsSetToT2);
		
		for(MethodTraceSubjectTSubjectN mykey:methodtraces22) {
			String methodid=mykey.getMethodRepresentation().methodid; 
			String requirementID= mykey.getRequirement().ID; 
			String ReqMethod= requirementID+"-"+methodid; 
			LogInfo logInfo = logInfoHashMap.get(ReqMethod); 
			//String query= "UPDATE `traces` SET `prediction` ='"+ myvalue.getPrediction() +"'WHERE requirementid='"+RequirementID+"' AND methodid ='"+methodid+"'"; 
			String likelihood= mykey.getLikelihood(); 
			String why= mykey.getWhy(); 
			
//			String query="UPDATE `traces` SET `prediction` ='"+ myvalue.getPrediction() 
//			+"',"+"`likelihood` ='"+ likelihood+"',"+"`why` ='"+ why
//			+"'WHERE requirementid='"+myvalue.Requirement.ID+"' AND methodid='"+myvalue.MethodRepresentation.methodid+"'"; 
//			
//			st.executeUpdate(query); 

			//System.out.println(myvalue.getGoldfinal()+"   "+myvalue.getPrediction());
				//st.executeUpdate("UPDATE `traces` SET  +"'WHERE requirementid='"+entry.RequirementID+"' AND method='"+name+"'"); 
			
//			System.out.println("PREDICTION  "+mykey.getPrediction()+" ------------  gold2  "+mykey.goldfinal);
			if(mykey.getGoldfinal()!=null && mykey.getPrediction()!=null) {
				String Result=nEWPATTERNMethodCallsSetToT2.ComparePredictionToGold(mykey.getGoldfinal().trim(), mykey.getPrediction().trim()); 
				logInfo.setPrecisionRecall(Result);
				nEWPATTERNMethodCallsSetToT2.UpdateCounters(Result, nEWPATTERNMethodCallsSetToT2);
				logInfoHashMap.put(ReqMethod, logInfo); 
			}
		
			
		}
		nEWPATTERNMethodCallsSetToT2.toString(); 
		
		System.out.println("FINAL RESULT ====== "+nEWPATTERNMethodCallsSetToT2.toString());
	
}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/	
	
	public void WriteInDatabaseAndComputePrecisionAndRecall(
			LinkedHashMap<String, MethodTraceSubjectTSubjectN> MyfinalHashMap, PredictionEvaluation nEWPATTERNMethodFields2) throws SQLException {
		// TODO Auto-generated method stub
		nEWPATTERNMethodFields2.ResetCounters(nEWPATTERNMethodFields2);
		
		for(String mykey:MyfinalHashMap.keySet()) {
			MethodTraceSubjectTSubjectN myvalue = MyfinalHashMap.get(mykey); 
			String methodid=myvalue.getMethodRepresentation().methodid; 
			String requirementID= myvalue.getRequirement().ID; 
			//String query= "UPDATE `traces` SET `prediction` ='"+ myvalue.getPrediction() +"'WHERE requirementid='"+RequirementID+"' AND methodid ='"+methodid+"'"; 
			String likelihood= myvalue.getLikelihood(); 
			String why= myvalue.getWhy(); 
			
//			String query="UPDATE `traces` SET `prediction` ='"+ myvalue.getPrediction() 
//			+"',"+"`likelihood` ='"+ likelihood+"',"+"`why` ='"+ why
//			+"'WHERE requirementid='"+myvalue.Requirement.ID+"' AND methodid='"+myvalue.MethodRepresentation.methodid+"'"; 
//			
//			st.executeUpdate(query); 

			//System.out.println(myvalue.getGoldfinal()+"   "+myvalue.getPrediction());
				//st.executeUpdate("UPDATE `traces` SET  +"'WHERE requirementid='"+entry.RequirementID+"' AND method='"+name+"'"); 
			
			System.out.println("PREDICTION  "+myvalue.getPrediction()+" ------------  gold2  "+myvalue.goldfinal);
			if(myvalue.getGoldfinal()!=null && myvalue.getPrediction()!=null) {
				String Result=nEWPATTERNMethodFields2.ComparePredictionToGold(myvalue.getGoldfinal().trim(), myvalue.getPrediction().trim()); 
				nEWPATTERNMethodFields2.UpdateCounters(Result, nEWPATTERNMethodFields2);
			}
		
			
		}
		nEWPATTERNMethodFields2.toString(); 
		
		System.out.println("FINAL RESULT ====== "+nEWPATTERNMethodFields2.toString());
	}

	
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	
	public LinkedHashMap<String, String> InitializePredictionsHashMap(LinkedHashMap<String, String> predictionsOldHashMap, Collection<MethodTraceSubjectTSubjectN> methodtraces22) {
		// TODO Auto-generated method stub

		for(MethodTraceSubjectTSubjectN methodtrace: methodtraces22) {
			String RequirementID=methodtrace.Requirement.ID; 
			String MethodID= methodtrace.MethodRepresentation.methodid; 
			String key= MethodID+"-"+RequirementID; 
			predictionsOldHashMap.put(key, methodtrace.getPrediction()); 
		}
		return predictionsOldHashMap;
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	
	public List<MethodTraceSubjectTSubjectN> InitializePredictionsHashMapBlankValues(LinkedHashMap<String, String> predictionsOldHashMap, List<MethodTraceSubjectTSubjectN> methodtraces22) {
		// TODO Auto-generated method stub

		for(MethodTraceSubjectTSubjectN methodtrace: methodtraces22) {
			methodtrace.setPrediction("");
		}
		return methodtraces22;
	}
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	public LinkedHashMap<String, MethodTraceSubjectTSubjectN> RetrievePredictionsHashMap( List<MethodTraceSubjectTSubjectN> methodtraces22) {
		// TODO Auto-generated method stub

		LinkedHashMap<String, MethodTraceSubjectTSubjectN> predictionsOldHashMap= new LinkedHashMap<String, MethodTraceSubjectTSubjectN>();
		for(MethodTraceSubjectTSubjectN methodtrace: methodtraces22) {
			String RequirementID=methodtrace.Requirement.ID; 
			String MethodID= methodtrace.MethodRepresentation.methodid; 
			String key= MethodID+"-"+RequirementID; 
			predictionsOldHashMap.put(key, methodtrace); 
		}
		return predictionsOldHashMap;
	}
	
	
	
	public void PatternSetVariables(String Prediction, MethodTraceSubjectTSubjectN methodtrace, String Likelihood, String Why) {
		// TODO Auto-generated method stub
		methodtrace.setPrediction(Prediction);
		methodtrace.setLikelihood(Likelihood);
		methodtrace.setWhy(Why);
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
		String ProgramName="chess"; 
		TracesTableChessFINALROUND2MethodCallsV4 frame = new TracesTableChessFINALROUND2MethodCallsV4(ProgramName);
		
		String ProgramName2="gantt"; 
		 frame = new TracesTableChessFINALROUND2MethodCallsV4(ProgramName2);
		
		String ProgramName3="itrust"; 
			 frame = new TracesTableChessFINALROUND2MethodCallsV4(ProgramName3);
		
		String ProgramName4="jhotdraw"; 
		 frame = new TracesTableChessFINALROUND2MethodCallsV4(ProgramName4);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	 public boolean Equals(LinkedHashMap<String, String> OldHashMap, LinkedHashMap<String, String> newHashMap) {
		if(OldHashMap!=null && newHashMap!=null) {
			 if(!OldHashMap.isEmpty()) {
			        for(String s: newHashMap.keySet()) {
			            //HANDLE NULLS if any
			        if( OldHashMap.get(s)!=null && newHashMap.get(s)!=null)
			        		if( OldHashMap.get(s).equals(newHashMap.get(s))==false) {
			        			if(OldHashMap.get(s).equals("T")|| OldHashMap.get(s).equals("N")) {
			        				System.out.println("YEEEEEEEEEEEEEEEEEEEEEES IT IS EQUAL");
			        			}
				            	return false; 
				            }	
			        	}
			            
			           
			        }
					else {
			        	return false; 
			        }
		}
		
	        return true;
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