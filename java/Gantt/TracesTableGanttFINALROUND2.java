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

import Chess.PredictionEvaluation;
import Chess.TracesTableChessFINAL;
import Chess.TracesTableChessFINALROUND2MethodCalls;
import mypackage.ClassField2;
import mypackage.Clazz;
import mypackage.ClassTrace2;
import mypackage.ColumnGroup;
import mypackage.DatabaseReading2;
import mypackage.GroupableTableHeader;
import mypackage.Interface;
import mypackage.MethodDetails;
import mypackage.Method;
import mypackage.MethodField2;
import mypackage.MethodTrace2;
import mypackage.MethodTraceSubjectTSubjectN;
import mypackage.Parameter2;
import mypackage.Requirement;
import mypackage.RequirementGold;
import mypackage.SuperClass2;

public class TracesTableGanttFINALROUND2 extends JFrame {
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("root", this.userName);
		connectionProps.put("123456", this.password);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasegantt","root","123456");

		return conn;
	}

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
	Connection conn = this.getConnection(); 
	



	Statement st= conn.createStatement();	
	  
	   
	   
	
   
	
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
	int OwnerClassTGOLD4=96; 
	int OwnerClassNGOLD4=97; 
	int OwnerClassEGOLD4=98; 
	int CallerMethodsNumberGOLD4=99; 
	int CallerMethodsTGOLD4=100; 
	int CallerMethodsNGOLD4=101; 
	int CallerMethodsEGOLD4=102; 
	int CallerClassesNumberGOLD4=103; 
	int CallerClassesTGOLD4=104; 
	int CallerClassesNGOLD4=105; 
	int CallerClassesEGOLD4=106; 
	int CalleeMethodsNumberGOLD4=107; 
	int CalleeMethodsTGOLD4=108; 
	int CalleeMethodsNGOLD4=109; 
	int CalleeMethodsEGOLD4=110; 
	int CalleeClassesNumberGOLD4=111; 
	int CalleeClassesTGOLD4=112; 
	int CalleeClassesNGOLD4=113; 
	int CalleeClassesEGOLD4=114; 
	int OwnerClassPredictionGOLD4=115; 
	int MajorityClassLevelCalleesGOLD4=116; 
	int MajorityClassLevelCallersGOLD4=117; 
	int MajorityMethodLevelCalleesGOLD4=118; 
	int MajorityMethodLevelCallersGOLD4=119; 
	int AtLeast1NPredictionClassLevelCalleesGOLD4=120; 
	int AtLeast1NPredictionClassLevelCallersGOLD4=121; 
	int AtLeast1NPredictionMethodLevelCalleesGOLD4=122; 
	int AtLeast1NPredictionMethodLevelCallersGOLD4=123; 
	int AtLeast1TPredictionClassLevelCalleesGOLD4=124; 
	int AtLeast1TPredictionClassLevelCallersGOLD4=125; 
	int AtLeast1TPredictionMethodLevelCalleesGOLD4=126; 
	int AtLeast1TPredictionMethodLevelCallersGOLD4=127; 
	int AtLeast2NPredictionClassLevelCalleesGOLD4=128; 
	int AtLeast2NPredictionClassLevelCallersGOLD4=129; 
	int AtLeast2NPredictionMethodLevelCalleesGOLD4=130; 
	int AtLeast2NPredictionMethodLevelCallersGOLD4=131; 
	int AtLeast2TPredictionClassLevelCalleesGOLD4=132; 
	int AtLeast2TPredictionClassLevelCallersGOLD4=133; 
	int AtLeast2TPredictionMethodLevelCalleesGOLD4=134; 
	int AtLeast2TPredictionMethodLevelCallersGOLD4=135; 
	int AllNClassLevelCalleesGOLD4=136; 
	int AllNClassLevelCallersGOLD4=137; 
	int AllNMethodLevelCalleesGOLD4=138; 
	int AllNMethodLevelCallersGOLD4=139; 
	int AllTClassLevelCalleesGOLD4=140; 
	int AllTClassLevelCallersGOLD4=141; 
	int AllTMethodLevelCalleesGOLD4=142; 
	int AllTMethodLevelCallersGOLD4=143; 
	int CallersGOLD4=144; 
	int CalleesGOLD4=145; 
	int paramatersNumberGOLD4=146; 
	int CountParamaterTGOLD4=147; 
	int CountParamaterNGOLD4=148; 
	int CountParamaterEGOLD4=149; 
	int MajorityParametersGOLD4=150; 
	int AtLeast1NParameterGOLD4=151; 
	int AtLeast1TParameterGOLD4=152; 
	int AtLeast2TParameterGOLD4=153; 
	int AtLeast2NParameterGOLD4=154; 
	int AllNParametersGOLD4=155; 
	int AllTParametersGOLD4=156; 
	int ACHRAFTRACEPureGOLD4=157; 
	int ACHRAFTRACEMixedGOLD4=158; 
	int ACHRAFNOTRACEPureGOLD4=159; 
	int ACHRAFNOTRACEMixedGOLD4=160; 
	int AllNMethodLevelCallersCalleesGOLD4=161; 
	int AllTMethodLevelCallersCalleesGOLD4=162; 
	int AllTClassLevelCallersCalleesGOLD4=163; 
	int AllNClassLevelCallersCalleesGOLD4=164; 
	int AllNClassLevelCalleesAtLeast2NGOLD4=165; 
	int AllNClassLevelCallersAtLeast2NGOLD4=166; 
	int AllNMethodLevelCalleesAtLeast2NGOLD4=167; 
	int AllNMethodLevelCallersAtLeast2NGOLD4=168; 
	int AllTClassLevelCalleesAtLeast2TGOLD4=169; 
	int AllTClassLevelCallersAtLeast2TGOLD4=170; 
	int AllTMethodLevelCalleesAtLeast2TGOLD4=171; 
	int AllTMethodLevelCallersAtLeast2TGOLD4=172; 
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
	int CallerMethodsNumberGOLD4ACROSS=189; 
	int CallerMethodsTGOLD4ACROSS=190; 
	int CallerMethodsNGOLD4ACROSS=191; 
	int CallerMethodsEGOLD4ACROSS=192; 
	int CallerClassesNumberGOLD4ACROSS=193; 
	int CallerClassesTGOLD4ACROSS=194; 
	int CallerClassesNGOLD4ACROSS=195; 
	int CallerClassesEGOLD4ACROSS=196; 
	int CalleeMethodsNumberGOLD4ACROSS=197; 
	int CalleeMethodsTGOLD4ACROSS=198; 
	int CalleeMethodsNGOLD4ACROSS=199; 
	int CalleeMethodsEGOLD4ACROSS=200; 
	int CalleeClassesNumberGOLD4ACROSS=201; 
	int CalleeClassesTGOLD4ACROSS=202; 
	int CalleeClassesNGOLD4ACROSS=203; 
	int CalleeClassesEGOLD4ACROSS=204; 
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
	int interfacesNumberGOLD4=221; 
	int CountInterfaceTGOLD4=222; 
	int CountInterfaceNGOLD4=223; 
	int CountInterfaceEGOLD4=224; 
	
	int FieldClassesNumberGOLD4=225; 
	int CountFieldClassTGOLD4=226; 
	int CountFieldClassNGOLD4=227; 
	int CountFieldClassEGOLD4=228; 
	
	int FieldMethodsNumberGOLD4=229; 
	int CountFieldMethodTGOLD4=230; 
	int CountFieldMethodNGOLD4=231; 
	int CountFieldMethodEGOLD4=232; 
	
	int SuperClassesNumberGOLD4=233; 
	int CountFieldSuperClassTGOLD4=234; 
	int CountFieldSuperClassNGOLD4=235; 
	int CountFieldSuperClassEGOLD4=236; 
	
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
	PredictionEvaluation NEWPATTERNMethodCallsSetToT=new PredictionEvaluation();  
	PredictionEvaluation NEWPATTERNMethodCalls=new PredictionEvaluation();  
	ClassTrace2 myclasstrace = new ClassTrace2();
	static List<DatabaseInput> methodtraces2 = new ArrayList<DatabaseInput>();
	static HashMap<String, DatabaseInput> methodtraces2HashMap  = new HashMap<String, DatabaseInput>();

	static List<ClassTrace2> classtraces2 = new ArrayList<ClassTrace2>();
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass = new  LinkedHashMap<String, ClassTrace2>(); 
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClassGOLD4 = new  LinkedHashMap<String, ClassTrace2>(); 

	 LinkedHashMap<String, MethodDetails> linkedmethodhashmap= new LinkedHashMap<String, MethodDetails>(); 
	 HashMap<String, Interface> InterfacesHashMap= new HashMap<String, Interface>();
	 HashMap<String, Interface> InterfacesHashMapAlreadyImpl= new HashMap<String, Interface>(); 
	 HashMap<String, List<Interface>>  InterfacesOwnerClassHashMap= new HashMap<String, List<Interface>>(); 
	 HashMap<String, List< MethodField2>>  FieldMethodsHashMap= new HashMap<String, List< MethodField2>>(); 
	 HashMap<String, List< ClassField2>> FieldClassesHashMap=  new HashMap<String, List< ClassField2>>(); 
	 HashMap<String, List< SuperClass2>> SuperclassesHashMap=  new HashMap<String, List< SuperClass2>>(); 
	JTable table = new JTable(); 
	static List<MethodDetails> methodlist = new ArrayList<MethodDetails>();
	//File fout = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\TableLog.txt");
	File fout = new File("C:\\Users\\mouna\\dumps\\TableLogChess.txt");

	FileOutputStream fos = new FileOutputStream(fout);
	
//	File fout2 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\PredictionEvaluationChess.txt");
	File fout2 = new File("C:\\Users\\mouna\\dumps\\PredictionEvaluationChess.txt");

	FileOutputStream fos2 = new FileOutputStream(fout2);
	
	//File foutGold2 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\PredictionEvaluationChessGold2.txt");
	File foutGold2 = new File("C:\\Users\\mouna\\dumps\\PredictionEvaluationChessGold2.txt");

	FileOutputStream fileGold2 = new FileOutputStream(foutGold2);
	
	File foutGold2TableLog = new File("C:\\Users\\mouna\\dumps\\TableLogChessGOLD4.txt");
	FileOutputStream fosGold2 = new FileOutputStream(foutGold2TableLog);
	BufferedWriter bwGold2TableLog = new BufferedWriter(new OutputStreamWriter(fosGold2));

	
	File file1log = new File("C:\\Users\\mouna\\dumps\\file1.txt");
	FileOutputStream fosfila1 = new FileOutputStream(file1log);
	BufferedWriter bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));
	
	
	File file2log = new File("C:\\Users\\mouna\\dumps\\file2.txt");
	FileOutputStream fosfila2 = new FileOutputStream(file2log);
	BufferedWriter bwfile2 = new BufferedWriter(new OutputStreamWriter(fosfila2));
	
	File file3log = new File("C:\\Users\\mouna\\dumps\\file3.txt");
	FileOutputStream fosfila3 = new FileOutputStream(file3log);
	BufferedWriter bwfile3 = new BufferedWriter(new OutputStreamWriter(fosfila3));
	
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

	public TracesTableGanttFINALROUND2() throws SQLException, IOException {
	
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

	

		
		bw.newLine();
		bwGold2TableLog.newLine();
		DatabaseReading2Gantt db = new DatabaseReading2Gantt();
		db.MakePredictions();
		methodtraces2 = db.getMethodtraces2SubjectTSubjectN();
		methodtraces2HashMap=db.getMethodtracehashmap(); 
		classtraces2 = db.getClassestraces2();
	//	methodlist = db.getMethodlist();
		 methodtracesRequirementClass = db.getClassesRequirementtraceshashmap(); 
		 InterfacesHashMap = db.getInterfaces();
		  linkedmethodhashmap = db.getLinkedmethodhashmap(); 
		//  InterfacesHashMapAlreadyImpl = db.getInterfacehashmapAlreadyImpl();
		  //INTERFACES 
		  InterfacesOwnerClassHashMap = db.getInterfacehashmapOwnerClass(); 
		  //FIELD METHODS 
		  FieldMethodsHashMap= db.getMethodFieldHashMap();
		  //FIELD CLASSES 
		  FieldClassesHashMap= db.getClassFieldHashMap(); 
		  //SUPERCLASSES
		  SuperclassesHashMap= db.getSuperclassesHashMap(); 
		  
		LinkedHashMap<String, String> PredictionsOldHashMap= new LinkedHashMap<String, String>(); 
		LinkedHashMap<String, String> PredictionsNewHashMap= new LinkedHashMap<String, String>(); 

		List<TableCellEditor> editors1 = new ArrayList<TableCellEditor>(methodtraces2HashMap.size());
		List<TableCellEditor> editors2 = new ArrayList<TableCellEditor>(methodtraces2HashMap.size());
		List<TableCellEditor> editors3 = new ArrayList<TableCellEditor>(methodtraces2HashMap.size());
		List<TableCellEditor> editors4 = new ArrayList<TableCellEditor>(methodtraces2HashMap.size());
		List<TableCellEditor> myparametersEditor = new ArrayList<TableCellEditor>(methodtraces2HashMap.size());

		int j = 0;
		final int jfinal=0; 
		String[] items1 = new String[methodtraces2HashMap.size()];
		String[] items2 = new String[methodtraces2HashMap.size()];
		String[] items3 = new String[methodtraces2HashMap.size()];
		String[] items4 = new String[methodtraces2HashMap.size()];
		String[] items5 = new String[methodtraces2HashMap.size()];
		String[] items6 = new String[methodtraces2HashMap.size()];
		String[] myparameters = new String[methodtraces2HashMap.size()];
		Method[] callersarr = new Method[methodtraces2HashMap.size()];
		Method[] callersex = new Method[methodtraces2HashMap.size()];
		Method[] calleesarr = new Method[methodtraces2HashMap.size()];
		Method[] calleesex = new Method[methodtraces2HashMap.size()];
		Object[][] data = new Object[methodtraces2HashMap.size()][400];
		int myfinalcounter=1; 
		int MethodTraceCountGold=0; 
		int ClassTraceCount=0; 
		int MethodTraceCountGold2=0; 
		
			
		
	
		
		List<LinkedHashMap<String, String>> PredictionHashMaps= new ArrayList<LinkedHashMap<String, String>>(); 
//		LinkedHashMap<String, String> PredictionHashMap1 = round2.function1(data, j, PredictionsOldHashMap, PredictionsNewHashMap, methodtraces2); 
		List<DatabaseInput> methodtracesNew = InitializePredictionsHashMap2(methodtraces2); 
		function1SetToT(data, j, PredictionsOldHashMap, PredictionsNewHashMap, methodtraces2); 
//		methodtracesNew = round2.InitializePredictionsHashMap2(methodtraces2); 
//		LinkedHashMap<String, String> PredictionHashMap2 = round2.function2(data, j, PredictionsOldHashMap, PredictionsNewHashMap, methodtracesNew); 
		
		
		
		LinkedHashMap<String, DatabaseInput> MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN prediction"); 
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN likelihood");
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN why");
//		st.executeUpdate("ALTER TABLE `traces` ADD prediction LONGTEXT"); 
//		st.executeUpdate("ALTER TABLE `traces` ADD likelihood LONGTEXT");
//		st.executeUpdate("ALTER TABLE `traces` ADD why LONGTEXT");
		
		
		

		
		bwfile1.close();
		bwfile2.close();
		bwfile3.close();
		bw.close();
		bwlog3.close();
		bwlog2.close();
		bwlog.write(AllTClassLevelCallersClass.toString()); 
		bwlog.newLine();
		bwlog.close(); 
		
		System.out.println("NEW PATTERN METHOD CALLS: "+NEWPATTERNMethodCalls.toString()); 
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
		bw2.write("TRACE PURE METHOD LEVEL ACROSS: "+PredictionCLASSTRACEMethodLevelPureGold2ACROSS.toString()); 
		bw2.newLine();
		bw2.write("TRACE MIXED METHOD LEVEL ACROSS: "+PredictionCLASSTRACEMethodLevelMixedGold2ACROSS.toString()); 
		bw2.newLine();
		bw2.write("NO TRACE PURE METHOD LEVEL ACROSS: "+PredictionCLASSNOTRACEMethodLevelPureGold2ACROSS.toString()); 
		bw2.newLine();
		bw2.write("NO TRACE MIXED METHOD LEVEL ACROSS: "+PredictionCLASSNOTRACEMethodLevelMixedGold2ACROSS.toString()); 
		bw2.newLine();
		bw2.write("TRACE PURE CLASS LEVEL ACROSS: "+PredictionCLASSTRACEClassLevelPureGold2ACROSS.toString()); 
		bw2.newLine();
		bw2.write("TRACE MIXED CLASS LEVEL ACROSS: "+PredictionCLASSTRACEClassLevelMixedGold2ACROSS.toString()); 
		bw2.newLine();
		bw2.write("NO TRACE PURE CLASS LEVEL ACROSS: "+PredictionCLASSNOTRACEClassLevelPureGold2ACROSS.toString()); 
		bw2.newLine();
		bw2.write("NO TRACE MIXED CLASS LEVEL ACROSS: "+PredictionCLASSNOTRACEClassLevelMixedGold2ACROSS.toString()); 
		bw2.newLine();
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
				"87-CLASSTRACEMethodLevelPureGold","88-CLASSTRACEMethodLevelMixedGold","89-CLASSNOTRACEMethodLevelPureGold","90-CLASSNOTRACEMethodLevelMixedGold",
				"91-CLASSTRACEClassLevelPureGold","92-CLASSTRACEClassLevelMixedGold","93-CLASSNOTRACEClassLevelPureGold","94-CLASSNOTRACEClassLevelMixedGold",
				
				
				"95-GOLD4", "96-OwnerClass T GOLD4", "97-Owner Class N GOLD4", "98-Owner Class E GOLD4", "99-# caller methods GOLD4",
				"100-# caller methods T GOLD4", "101-#caller methods N GOLD4", "102-#caller methods E GOLD4", "103-# caller classes GOLD4",
				"104-# caller classes T GOLD4", "105-#caller classes N GOLD4", "106-#caller classes E GOLD4", "107-# callee methods GOLD4",
				"108-# callee methods T GOLD4", "109-#callee methods N GOLD4", "110-#callee methods E GOLD4", "111-# callee classes GOLD4",
				"112-# callee classes T GOLD4", "113-#callee classes N GOLD4", "114-#callee classes E GOLD4",  "115-OwnerClassPrediction GOLD4",
				"116-MajorityClassLevelCallees GOLD4","117-MajorityClassLevelCallers GOLD4", "118-MajorityMethodLevelCallees GOLD4","119-MajorityMethodLevelCallers GOLD4",
				"120->1NPredictionClassLevelCallees GOLD4", "121->1NPredictionClassLevelCallers GOLD4", "122->1NPredictionMethodLevelCallees GOLD4", 
				"123->1NPredictionMethodLevelCallers GOLD4", "124->1TPredictionClassLevelCallees GOLD4", "125->1TPredictionClassLevelCallers GOLD4", 
				"126->1TPredictionMethodLevelCallees GOLD4", "127->1TPredictionMethodLevelCallers GOLD4", 
				"128->2NPredictionClassLevelCallees GOLD4", "129->2NPredictionClassLevelCallers GOLD4", "130->2NPredictionMethodLevelCallees GOLD4", 
				"131->2NPredictionMethodLevelCallers GOLD4", "132->2TPredictionClassLevelCallees GOLD4", "133->2TPredictionClassLevelCallers GOLD4", 
				"134->2TPredictionMethodLevelCallees GOLD4", "135->2TPredictionMethodLevelCallers GOLD4", 
				"136-AllNClassLevelCallees GOLD4", "137-AllNClassLevelCallers GOLD4","138-AllNMethodLevelCallees GOLD4","139-AllNMethodLevelCallers GOLD4",
				"140-AllTClassLevelCallees GOLD4", "141-AllTClassLevelCallers GOLD4", "142-AllTMethodLevelCallees GOLD4", "143-AllTMethodLevelCallers  GOLD4"
				,"144-AllNAtLeast2NClassLevelCallees GOLD4", "145-AllNAtLeast2NClassLevelCallers GOLD4","146-AllNAtLeast2NMethodLevelCallees GOLD4","147-AllNAtLeast2NMethodLevelCallers GOLD4",
				"148-AllTAtLeast2TClassLevelCallees GOLD4", "149-AllTAtLeast2TClassLevelCallers GOLD4", "150-AllTAtLeast2TMethodLevelCallees GOLD4", "151-AllTAtLeast2TMethodLevelCallers GOLD4"
				
				,"152-Callers GOLD4", "153-Callees GOLD4", "154-#parameters GOLD4","155-# Parameter T" ,"156-# Parameter N" ,"157-# Parameter E" ,
				"158-MajorityParameterPrediction GOLD4", "159-AtLeast1NParameterPrediction GOLD4", 
				"160-AtLeast1TParameterPrediction GOLD4", "161-AtLeast2TParameterPrediction GOLD4", 
				"162-AtLeast2NParameterPrediction GOLD4", "163-AllNParameterPrediction GOLD4", "164-AllTParameterPrediction GOLD4",
				"165-ACHRAFTRACEPureGOLD 2", "166-ACHRAFTRACEMixedGOLD4", "167-ACHRAFNOTRACEPureGOLD 2", "168-ACHRAFNOTRACEMixed GOLD4", 
				"169-AllTMethodLevelCallersCalleesClass GOLD4", "170-AllNMethodLevelCallersCalleesClass GOLD4",
				"171-AllTClassLevelCallersCalleesClass GOLD4", "172-AllNClassLevelCallersCalleesClass GOLD4", 
				"173-CLASSTRACEMethodLevelPureGold2","174-CLASSTRACEMethodLevelMixedGold2","175-CLASSNOTRACEMethodLevelPureGold2","176-CLASSNOTRACEMethodLevelMixedGold2]",
				"177-CLASSTRACEClassLevelPureGold2","178-CLASSTRACEClassLevelMixedGold2","179-CLASSNOTRACEClassLevelPureGold2","180-CLASSNOTRACEClassLevelMixedGold2"
				};
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		 
		 
		    

		    
		table = new JTable(model) {
			// Determine editor to be used by row
			public TableCellEditor getCellEditor(int row, int column) {
				int modelColumn = convertColumnIndexToModel(column);

				if (modelColumn == 48 && row < methodtraces2HashMap.size())
					return editors1.get(row);
				if (modelColumn == 49 && row < methodtraces2HashMap.size())
					return editors3.get(row);
				if (modelColumn == 51 && row < methodtraces2HashMap.size())
					return myparametersEditor.get(row);
				/*
				 * if (modelColumn == 31 && row < methodtraces2HashMap.size()) return
				 * editors3.get(row); if (modelColumn == 32 && row < methodtraces2HashMap.size())
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



	public List<DatabaseInput> InitializePredictionsHashMap2(
			List<DatabaseInput> methodtracesNew) {
		// TODO Auto-generated method stub
		
		for(DatabaseInput meth: methodtracesNew) {
			meth.setPrediction("");
		}
		return methodtracesNew;
	}
	public void WriteInDatabaseAndComputePrecisionAndRecall(
			LinkedHashMap<String, DatabaseInput> MyfinalHashMap, PredictionEvaluation nEWPATTERNMethodFields2) throws SQLException {
		// TODO Auto-generated method stub
		nEWPATTERNMethodFields2.ResetCounters(nEWPATTERNMethodFields2);
		
		for(String mykey:MyfinalHashMap.keySet()) {
			DatabaseInput myvalue = MyfinalHashMap.get(mykey); 
			String methodid=myvalue.getMethodRepresentation().ID; 
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
			if(myvalue.getGold4()!=null && myvalue.getPrediction()!=null) {
				String Result=nEWPATTERNMethodFields2.ComparePredictionToGold(myvalue.getGold4().trim(), myvalue.getPrediction()); 
				nEWPATTERNMethodFields2.UpdateCounters(Result, nEWPATTERNMethodFields2);
			}
		
			
		}
		nEWPATTERNMethodFields2.toString(); 
		
		
	}

	private LinkedHashMap<String, String> InitializePredictionsHashMap(LinkedHashMap<String, String> predictionsOldHashMap, List<DatabaseInput> methodtraces22) {
		// TODO Auto-generated method stub

		for(DatabaseInput methodtrace: methodtraces22) {
			String RequirementID=methodtrace.Requirement.ID; 
			String MethodID= methodtrace.MethodRepresentation.methodid; 
			String key= MethodID+"-"+RequirementID; 
			predictionsOldHashMap.put(key, methodtrace.getPrediction()); 
		}
		return predictionsOldHashMap;
	}

	
	
	private LinkedHashMap<String, DatabaseInput> RetrievePredictionsHashMap( List<DatabaseInput> methodtraces22) {
		// TODO Auto-generated method stub

		LinkedHashMap<String, DatabaseInput> predictionsOldHashMap= new LinkedHashMap<String, DatabaseInput>();
		for(DatabaseInput methodtrace: methodtraces22) {
			String RequirementID=methodtrace.Requirement.ID; 
			String MethodID= methodtrace.MethodRepresentation.methodid; 
			String key= MethodID+"-"+RequirementID; 
			predictionsOldHashMap.put(key, methodtrace); 
		}
		return predictionsOldHashMap;
	}
	
	
	
	private void PatternSetVariables(String Prediction, DatabaseInput methodtrace, String Likelihood, String Why) {
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

	public LinkedHashMap<String, String>  function1SetToT(Object[][] data, int j, LinkedHashMap<String, String> PredictionsOldHashMap, LinkedHashMap<String, String> PredictionsNewHashMap, List<DatabaseInput> methodtraces22) throws SQLException {
		// TODO Auto-generated method stub
		Collection<DatabaseInput> MethodTracesHashmapValues = methodtraces2HashMap.values(); 
		int ITERATION1=0; 
		for (DatabaseInput methodtrace : MethodTracesHashmapValues) {
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
			data[j][OwnerClassTGOLD4] = "0";
			data[j][OwnerClassNGOLD4] = "0";
			data[j][OwnerClassEGOLD4] = "1";
			String reqclass= data[j][RequirementID].toString()+"-"+ data[j][ClassID].toString(); 
			ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
	
		
			//PATTERN 1
			if(myclasstraceHashMap.getTrace4()!=null) {
				String traceGOLD4 = myclasstraceHashMap.getTrace4();
				traceGOLD4=traceGOLD4.trim(); 
				if (traceGOLD4.equals("T")) {
					data[j][OwnerClassTGOLD4] = "1";
					data[j][OwnerClassNGOLD4] = "0";
					data[j][OwnerClassEGOLD4] = "0";
					
					PatternSetVariables("T",methodtrace,"100%","P1"); 
					
				//	System.out.println("OWNERCLASS T  "+j +" set to 1");
				} else if (traceGOLD4.equals("N")) {
					data[j][OwnerClassTGOLD4] = "0";
					data[j][OwnerClassNGOLD4] = "1";
					data[j][OwnerClassEGOLD4] = "0";
					
					PatternSetVariables("N",methodtrace,"100%","P1"); 
				
				//	System.out.println("OWNERCLASS N  "+j +" set to 1");
				} else if (traceGOLD4.equals("E")) {
					data[j][OwnerClassTGOLD4] = "0";
					data[j][OwnerClassNGOLD4] = "0";
					data[j][OwnerClassEGOLD4] = "1";
				//	System.out.println("OWNERCLASS E  "+j +" set to 1");
					
					PatternSetVariables("E", methodtrace,"100%","P1"); 
				
				}
				ITERATION1++; 
			}
			
			
		
			
			
			
			
			
			 LinkedHashMap<String, DatabaseInput> MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 
			 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNMethodCallsSetToT);
			 System.out.println("===============>PATTERNS 1 SET TO T   ITERATION "+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNMethodCallsSetToT.toString());

			j++;
			
		}
		
		int ITERATION=0; 
		
		PredictionsNewHashMap=InitializePredictionsHashMap(PredictionsNewHashMap, methodtraces2); 
		while(Equals(PredictionsOldHashMap, PredictionsNewHashMap)==false) {
		
			PredictionsOldHashMap=InitializePredictionsHashMap(PredictionsOldHashMap, methodtraces2); 

			
			System.out.println("-------------------------------------------");

			int k=0; 
			//PATTERN 3 AND PATTERN 5
			for (DatabaseInput methodtrace : methodtraces2) {
				//PATTERN 3 AND PATTERN 5
				
				List<Method> CalleesList = methodtrace.getCalleesList(); 
				List<Method> CallersList = methodtrace.getCallersList(); 
				
				List<String> PredictionCalleeList=new ArrayList<String>();
				for(Method callee: CalleesList) {
					String RequirementID=methodtrace.Requirement.ID; 
					String MethodID= callee.ID; 
					String key= MethodID+"-"+RequirementID; 
					if(methodtraces2HashMap.get(key)!=null) {
						String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
						PredictionCalleeList.add(predictionvalue); 
					}
				}
				
				
				
				List<String> PredictionCallerList=new ArrayList<String>();
				for(Method caller: CallersList) {
					String RequirementID=methodtrace.Requirement.ID; 
					String MethodID= caller.ID; 
					String key= MethodID+"-"+RequirementID; 
					if(methodtraces2HashMap.get(key)!=null) {
						String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
						PredictionCallerList.add(predictionvalue); 
					}
				}
				methodtrace.setPrediction("");
				//PATTERN 3
				if(PredictionCalleeList.contains("N")==true && PredictionCallerList.contains("N")==true ) {
					//methodtrace.setPrediction("N");
					PatternSetVariables("N", methodtrace, "80%", "P3");

					//System.out.println("yes");
				}else if(PredictionCalleeList.contains("T")==true && PredictionCallerList.contains("T")==true ) {
					//methodtrace.setPrediction("N");
					PatternSetVariables("T", methodtrace, "80%", "P3");

					//System.out.println("yes");
				}
				
				//PATTERN 5
				if(PredictionCalleeList.isEmpty() &&  PredictionCallerList.contains("N") ==true) {
					//methodtrace.setPrediction("N");
					//System.out.println("yes");
					PatternSetVariables("N", methodtrace, "80%", "P5");
				}else if(PredictionCalleeList.isEmpty() &&  PredictionCallerList.contains("T") ==true) {
					//methodtrace.setPrediction("N");
					//System.out.println("yes");
					PatternSetVariables("T", methodtrace, "80%", "P5");
				}
				k++; 
			}
			//InitializePredictionsHashMapBlankValues(PredictionsNewHashMap, methodtraces2); 
			//PRINT 
			 LinkedHashMap<String, DatabaseInput> MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 
			 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNMethodCallsSetToT);
			System.out.println("===============>PATTERNS 3 AND 5 ITERATION SET TO T  ITERATION "+ITERATION  +	"   PREDICTION VALUES "+NEWPATTERNMethodCallsSetToT.toString());

			 //END  PRINT 
			
			
			
			
			//////////////////////////////////////////////////////////////////////////////////////////
			 k=0; 
			//PATTERN 2 AND PATTERN 4
			// methodtraces2	=	InitializePredictionsHashMapBlankValues(PredictionsOldHashMap, methodtraces22); 
			for (DatabaseInput methodtrace : methodtraces2) {
				

				//PATTERN 2 AND PATTERN 4
				List<Method> CalleesList = methodtrace.getCalleesList(); 
				List<Method> CallersList = methodtrace.getCallersList(); 
				
				List<String> PredictionCalleeList=new ArrayList<String>();
				for(Method callee: CalleesList) {
					String RequirementID=methodtrace.Requirement.ID; 
					String MethodID= callee.ID; 
					String key= MethodID+"-"+RequirementID; 
					if(methodtraces2HashMap.get(key)!=null) {
						String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
						PredictionCalleeList.add(predictionvalue); 
					}
					
				}
				
				
				
				List<String> PredictionCallerList=new ArrayList<String>();
				for(Method caller: CallersList) {
					String RequirementID=methodtrace.Requirement.ID; 
					String MethodID= caller.ID; 
					String key= MethodID+"-"+RequirementID; 
					if(methodtraces2HashMap.get(key)!=null) {
						String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
						PredictionCallerList.add(predictionvalue); 
					}
				}
				methodtrace.setPrediction("");
				//PATTERN 2
				if(PredictionCalleeList.contains("N")==true && PredictionCallerList.contains("N")==true && PredictionCalleeList.contains("T")==false 
						&& PredictionCallerList.contains("E")==false && PredictionCallerList.contains("T")==false  && PredictionCalleeList.contains("E")==false) {
					//methodtrace.setPrediction("N");
					PatternSetVariables("N", methodtrace, "90%", "P2");
					//System.out.println("yes");
				}else 	if(PredictionCalleeList.contains("N")==false && PredictionCallerList.contains("N")==false && PredictionCalleeList.contains("T")==true 
						&&  PredictionCallerList.contains("T")==true  ) {
					//methodtrace.setPrediction("N");
					PatternSetVariables("T", methodtrace, "90%", "P2");
					//System.out.println("yes");
				}
				
				//PATTERN 4
				if(PredictionCalleeList.isEmpty() &&  PredictionCallerList.contains("N") ==true
						&& PredictionCallerList.contains("T")==false && PredictionCallerList.contains("E")==false) {
					//methodtrace.setPrediction("N");
					PatternSetVariables("N", methodtrace, "90%", "P4");

					//System.out.println("yes");
				}else 	if(PredictionCalleeList.isEmpty() && PredictionCallerList.contains("N")==false && PredictionCalleeList.isEmpty()
						&&  PredictionCallerList.contains("T")==true  ) {
					//methodtrace.setPrediction("N");
					PatternSetVariables("T", methodtrace, "90%", "P2");
					//System.out.println("yes");
				}
				k++; 
			

			}
			
			//PRINT 
			
			 MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 
			 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNMethodCallsSetToT);
			System.out.println("===============>PATTERNS 2 AND 4 ITERATION SET TO T   ITERATION  "+ITERATION  +	"   PREDICTION VALUES "+NEWPATTERNMethodCallsSetToT.toString());

			 //END  PRINT 
			ITERATION++; 
			//System.out.println("HEEEEEEY");
			PredictionsNewHashMap=InitializePredictionsHashMap(PredictionsNewHashMap, methodtraces2); 
			
		
		}
		for (DatabaseInput methodtrace : methodtraces2) {
				if(methodtrace.getPrediction().trim().equals("E")){
					methodtrace.setPrediction("T");
				}
		}
		LinkedHashMap<String, DatabaseInput> MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN prediction"); 
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN likelihood");
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN why");
//		st.executeUpdate("ALTER TABLE `traces` ADD prediction LONGTEXT"); 
//		st.executeUpdate("ALTER TABLE `traces` ADD likelihood LONGTEXT");
//		st.executeUpdate("ALTER TABLE `traces` ADD why LONGTEXT");
//		
		
		
		WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNMethodCallsSetToT);
		return PredictionsNewHashMap; 
	}
	

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	
	public static void main(String[] args) throws SQLException, IOException {

		TracesTableGanttFINALROUND2 frame = new TracesTableGanttFINALROUND2();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	 public boolean Equals(LinkedHashMap<String, String> OldHashMap, LinkedHashMap<String, String> newHashMap) {
			if(!OldHashMap.isEmpty()) {
	        for(String s: newHashMap.keySet()) {
	            //HANDLE NULLS if any
//	        	System.out.println(OldHashMap.get(s));
//	        	System.out.println(newHashMap.get(s));
	        	if(OldHashMap.get(s)!=null && newHashMap.get(s)!=null) {
	        		if( OldHashMap.get(s).equals(newHashMap.get(s))==false) {
		            	return false; 
		            }	
	        	}
	        	else if(OldHashMap.get(s)==null  && newHashMap.get(s)!=null) {
	        		return false; 
	        	}
	        	else if(OldHashMap.get(s)!=null  && newHashMap.get(s)==null) {
	        		return false; 
	        	}
	        	}
	            
	           
	        }
			else {
	        	return false; 
	        }
	        return true;
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



