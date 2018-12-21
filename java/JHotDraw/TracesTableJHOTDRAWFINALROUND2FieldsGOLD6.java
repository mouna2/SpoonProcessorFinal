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

import Chess.CountTNE;
import Chess.PredictionEvaluation;
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

public class TracesTableJHOTDRAWFINALROUND2FieldsGOLD6 extends JFrame {
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("root", this.userName);
		connectionProps.put("123456", this.password);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasejhotdraw","root","123456");

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
	
	
	int Gold6=95; 
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

	PredictionEvaluation NEWPATTERNMethodCalls=new PredictionEvaluation();  

	PredictionEvaluation NEWPATTERNMethodFieldsPure=new PredictionEvaluation();  
	PredictionEvaluation NEWPATTERNMethodFieldsMixed=new PredictionEvaluation();  
	PredictionEvaluation NEWPATTERNMethodFieldsPureOWNER=new PredictionEvaluation();  
	PredictionEvaluation NEWPATTERNMethodFieldsMixedOWNER=new PredictionEvaluation();  
	
	PredictionEvaluation NEWPATTERNMethodFieldsPureOWNERType=new PredictionEvaluation();
	PredictionEvaluation NEWPATTERNMethodFieldsMixedOWNERType=new PredictionEvaluation();
	ClassTrace2 myclasstrace = new ClassTrace2();
	static List<DatabaseInput> methodtraces2 = new ArrayList<DatabaseInput>();
	static LinkedHashMap<String, DatabaseInput> methodtraces2HashMap  = new LinkedHashMap<String, DatabaseInput>();
	static HashMap<String, List<Parameter2>> parameterHashMap  = new HashMap<String, List<Parameter2>>();
	static List<ClassTrace2> classtraces2 = new ArrayList<ClassTrace2>();
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass = new  LinkedHashMap<String, ClassTrace2>(); 
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClassGOLD2 = new  LinkedHashMap<String, ClassTrace2>(); 

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
	
	File foutGold2TableLog = new File("C:\\Users\\mouna\\dumps\\TableLogChessGOLD2.txt");
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
	
	File mylog3 = new File("C:\\Users\\mouna\\dumps\\logs\\PredictionCounts.txt");
	FileWriter fr = new FileWriter(mylog3, true);
	BufferedWriter br = new BufferedWriter(fr);
	

	
	public final String userName = "root";
	public final String password = "123456";
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
	
	public TracesTableJHOTDRAWFINALROUND2FieldsGOLD6() throws SQLException, IOException {
	
		bwGold2TableLog.write("RowNumber, MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold6, Subject, OwnerClassT, OwnerClassN, "
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
		 DatabaseReading2JHotDraw3 db = new DatabaseReading2JHotDraw3();
		db.MakePredictions();
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
		LinkedHashMap<String, String> PredictionsOldHashMap= new LinkedHashMap<String, String>(); 
		LinkedHashMap<String, String> PredictionsNewHashMap= new LinkedHashMap<String, String>(); 

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
		Object[][] data = new Object[methodtraces2.size()][6000];
		int myfinalcounter=1; 
		int MethodTraceCountGold=0; 
		int ClassTraceCount=0; 
		int MethodTraceCountGold2=0; 
		// Create the editors to be used for each row
		
		
		List<DatabaseInput> methodtracesNew = InitializePredictionsHashMap2(methodtraces2); 
		LinkedHashMap<String, String> PredictionHashMap2 = function2(data, j, PredictionsOldHashMap, PredictionsNewHashMap, methodtracesNew); 
		
//		PredictionHashMaps.add(PredictionHashMap1); 
//		PredictionHashMaps.add(PredictionHashMap2); 
		
		
		bwfile1.close();
		bwfile2.close();
		bwfile3.close();
		br.newLine(); 
		br.write("NEW PATTERN METHOD FIELDS PURE: "+NEWPATTERNMethodFieldsPure.toString());
		br.newLine(); 
		br.write("NEW PATTERN METHOD FIELDS MIXED: "+NEWPATTERNMethodFieldsMixed.toString());
		br.newLine(); 
		br.write("NEW PATTERN METHOD FIELDS PURE OWNER: "+NEWPATTERNMethodFieldsPureOWNER.toString());
		br.newLine(); 
		br.write("NEW PATTERN METHOD FIELDS MIXED OWNER: "+NEWPATTERNMethodFieldsMixedOWNER.toString());
		br.newLine(); 
		br.write("NEW PATTERN METHOD FIELDS MIXED OWNERTYPE: "+NEWPATTERNMethodFieldsMixedOWNERType.toString());
		br.newLine(); 
		br.write("NEW PATTERN METHOD FIELDS PURE OWNERTYPE: "+NEWPATTERNMethodFieldsPureOWNERType.toString());
		br.close();
		bwlog2.close();
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
		System.out.println("NEW PATTERN METHOD CALLS: "+NEWPATTERNMethodCalls.toString()); 
		System.out.println("NEW PATTERN METHOD FIELDS PURE : "+NEWPATTERNMethodFieldsPure.toString()); 
		System.out.println("NEW PATTERN METHOD FIELDS MIXED: "+NEWPATTERNMethodFieldsMixed.toString()); 
		
		bw2.close();
		
		
		
		
		
		
		bwGold2.close();
		
		
//		String[] columnNames = {"Row",  "MethodID", "MethodName", "RequirementID", "RequirementName", "ClassID", "ClassName",
//				"Gold", "Subject", "OwnerClass T", "Owner Class N", "Owner Class E", "# caller methods",
//				"# caller methods T", "#caller methods N", "#caller methods E", "# caller classes",
//				"# caller classes T", "#caller classes N", "#caller classes E", "# callee methods",
//				"# callee methods T", "#callee methods N", "#callee methods E", "# callee classes",
//				"# callee classes T", "#callee classes N", "#callee classes E",  "OwnerClassPrediction",
//				"MajorityClassLevelCallers","MajorityClassLevelCallees", "MajorityMethodLevelCallers","MajorityMethodLevelCallees",
//				">=0NPredictionClassLevelCallers", ">=0NPredictionClassLevelCallees", ">=0NPredictionMethodLevelCallers", 
//				">=0NPredictionMethodLevelCallees", ">=0TPredictionClassLevelCallers", ">=0TPredictionClassLevelCallees", 
//				">=0TPredictionMethodLevelCallers", ">=0TPredictionMethodLevelCallees", 
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
				"33->=0NPredictionClassLevelCallees", "34->=0NPredictionClassLevelCallers", "35->=0NPredictionMethodLevelCallees", 
				"36->=0NPredictionMethodLevelCallers", "37->=0TPredictionClassLevelCallees", "38->=0TPredictionClassLevelCallers", 
				"39->=0TPredictionMethodLevelCallees", "40->=0TPredictionMethodLevelCallers", 
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
				
				
				"95-Gold6", "96-OwnerClass T Gold6", "97-Owner Class N Gold6", "98-Owner Class E Gold6", "99-# caller methods Gold6",
				"100-# caller methods T Gold6", "101-#caller methods N Gold6", "102-#caller methods E Gold6", "103-# caller classes Gold6",
				"104-# caller classes T Gold6", "105-#caller classes N Gold6", "106-#caller classes E Gold6", "107-# callee methods Gold6",
				"108-# callee methods T Gold6", "109-#callee methods N Gold6", "110-#callee methods E Gold6", "111-# callee classes Gold6",
				"112-# callee classes T Gold6", "113-#callee classes N Gold6", "114-#callee classes E Gold6",  "115-OwnerClassPrediction Gold6",
				"116-MajorityClassLevelCallees Gold6","117-MajorityClassLevelCallers Gold6", "118-MajorityMethodLevelCallees Gold6","119-MajorityMethodLevelCallers Gold6",
				"120->=0NPredictionClassLevelCallees Gold6", "121->=0NPredictionClassLevelCallers Gold6", "122->=0NPredictionMethodLevelCallees Gold6", 
				"123->=0NPredictionMethodLevelCallers Gold6", "124->=0TPredictionClassLevelCallees Gold6", "125->=0TPredictionClassLevelCallers Gold6", 
				"126->=0TPredictionMethodLevelCallees Gold6", "127->=0TPredictionMethodLevelCallers Gold6", 
				"128->2NPredictionClassLevelCallees Gold6", "129->2NPredictionClassLevelCallers Gold6", "130->2NPredictionMethodLevelCallees Gold6", 
				"131->2NPredictionMethodLevelCallers Gold6", "132->2TPredictionClassLevelCallees Gold6", "133->2TPredictionClassLevelCallers Gold6", 
				"134->2TPredictionMethodLevelCallees Gold6", "135->2TPredictionMethodLevelCallers Gold6", 
				"136-AllNClassLevelCallees Gold6", "137-AllNClassLevelCallers Gold6","138-AllNMethodLevelCallees Gold6","139-AllNMethodLevelCallers Gold6",
				"140-AllTClassLevelCallees Gold6", "141-AllTClassLevelCallers Gold6", "142-AllTMethodLevelCallees Gold6", "143-AllTMethodLevelCallers  Gold6"
				,"144-AllNAtLeast2NClassLevelCallees Gold6", "145-AllNAtLeast2NClassLevelCallers Gold6","146-AllNAtLeast2NMethodLevelCallees Gold6","147-AllNAtLeast2NMethodLevelCallers Gold6",
				"148-AllTAtLeast2TClassLevelCallees Gold6", "149-AllTAtLeast2TClassLevelCallers Gold6", "150-AllTAtLeast2TMethodLevelCallees Gold6", "151-AllTAtLeast2TMethodLevelCallers Gold6"
				
				,"152-Callers Gold6", "153-Callees Gold6", "154-#parameters Gold6","155-# Parameter T" ,"156-# Parameter N" ,"157-# Parameter E" ,
				"158-MajorityParameterPrediction Gold6", "159-AtLeast1NParameterPrediction Gold6", 
				"160-AtLeast1TParameterPrediction Gold6", "161-AtLeast2TParameterPrediction Gold6", 
				"162-AtLeast2NParameterPrediction Gold6", "163-AllNParameterPrediction Gold6", "164-AllTParameterPrediction Gold6",
				"165-ACHRAFTRACEPureGOLD 2", "166-ACHRAFTRACEMixedGOLD2", "167-ACHRAFNOTRACEPureGOLD 2", "168-ACHRAFNOTRACEMixed Gold6", 
				"169-AllTMethodLevelCallersCalleesClass Gold6", "170-AllNMethodLevelCallersCalleesClass Gold6",
				"171-AllTClassLevelCallersCalleesClass Gold6", "172-AllNClassLevelCallersCalleesClass Gold6", 
				"173-CLASSTRACEMethodLevelPureGold2","174-CLASSTRACEMethodLevelMixedGold2","175-CLASSNOTRACEMethodLevelPureGold2","176-CLASSNOTRACEMethodLevelMixedGold2]",
				"177-CLASSTRACEClassLevelPureGold2","178-CLASSTRACEClassLevelMixedGold2","179-CLASSNOTRACEClassLevelPureGold2","180-CLASSNOTRACEClassLevelMixedGold2"
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
/************************************************************************************************************************************************/
/************************************************************************************************************************************************/
/************************************************************************************************************************************************/

	public LinkedHashMap<String, String> function2(Object[][] data, int j, LinkedHashMap<String, String> PredictionsOldHashMap,
			LinkedHashMap<String, String> PredictionsNewHashMap, List<DatabaseInput> methodtracesNew) throws SQLException {
		
		Collection<DatabaseInput> MethodTracesHashmapValues = methodtraces2HashMap.values(); 
//		for (MethodTraceSubjectTSubjectN methodtrace : MethodTracesHashmapValues) {
//			
//			String reqclass= methodtrace.Requirement.ID+"-"+ methodtrace.ClassRepresentation.classid; 
//			ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
//	
//		int ITERATION1=0; 
//			//PATTERN 1
//			if(myclasstraceHashMap.getTrace6()!=null) {
//				String traceGOLD2 = myclasstraceHashMap.getTrace6();
//				traceGOLD2=traceGOLD2.trim(); 
//				if (traceGOLD2.equals("T")) {
//					data[j][OwnerClassTGOLD2] = "1";
//					data[j][OwnerClassNGOLD2] = "0";
//					data[j][OwnerClassEGOLD2] = "0";
//					
//					PatternSetVariables("T",methodtrace,"100%","P1"); 
//					
//				//	System.out.println("OWNERCLASS T  "+j +" set to 1");
//				} else if (traceGOLD2.equals("N")) {
//					data[j][OwnerClassTGOLD2] = "0";
//					data[j][OwnerClassNGOLD2] = "1";
//					data[j][OwnerClassEGOLD2] = "0";
//					
//					PatternSetVariables("N",methodtrace,"100%","P1"); 
//				
//				//	System.out.println("OWNERCLASS N  "+j +" set to 1");
//				} else if (traceGOLD2.equals("E")) {
//					data[j][OwnerClassTGOLD2] = "0";
//					data[j][OwnerClassNGOLD2] = "0";
//					data[j][OwnerClassEGOLD2] = "1";
//				//	System.out.println("OWNERCLASS E  "+j +" set to 1");
//					
//					PatternSetVariables("E", methodtrace,"100%","P1"); 
//				
//				}
//				ITERATION1++; 
//			}
//			
//			
//		
//			
//			
//			
//			
//			
//			 System.out.println("===============>PATTERNS 1 SET TO T   ITERATION "+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNMethodFields.toString());
//			 LinkedHashMap<String, MethodTraceSubjectTSubjectN> MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 
//			 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNMethodFields);
//			j++;
//			
//		}
		
		
		
		
		// TODO Auto-generated method stub
		MethodTracesHashmapValues = methodtraces2HashMap.values(); 
		
		for (DatabaseInput methodtrace : MethodTracesHashmapValues) {
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
				String reqclass= methodtrace.Requirement.ID+"-"+ mymeth.getMethodFieldType().ID; 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTrace6()!=null) {
					String traceGOLD2 = myclasstraceHashMap.getTrace6().trim();
					System.out.println("trace GOLD2 "+traceGOLD2);
					PredictionFields.add(traceGOLD2); 
				}
			}
		if( paramlist!=null) {
			for(Parameter2 mymeth: paramlist) {
				String reqclass= methodtrace.Requirement.ID+"-"+ mymeth.getParameterType().ID; 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTrace6()!=null) {
					String traceGOLD2 = myclasstraceHashMap.getTrace6().trim();
					System.out.println("trace GOLD2 "+traceGOLD2);
					PredictionParams.add(traceGOLD2); 
				}
			}
		}
		
		if( paramlist!=null) {
			for(Parameter2 mymeth: paramlist) {
				String reqclass= methodtrace.Requirement.ID+"-"+ mymeth.getOwnerClass().ID; 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTrace6()!=null) {
					String traceGOLD2 = myclasstraceHashMap.getTrace6().trim();
					System.out.println("trace GOLD2 "+traceGOLD2);
					PredictionParamsOwnerClass.add(traceGOLD2); 
				}
			}
		}
		
		if(mymethodfields!=null)
			for(MethodField2 mymeth: mymethodfields) {
				String reqclass= methodtrace.Requirement.ID+"-"+ mymeth.getOwnerClass().ID;  
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTrace6()!=null) {
					String traceGOLD2 = myclasstraceHashMap.getTrace6().trim();
					System.out.println("trace GOLD2 "+traceGOLD2);
					PredictionFieldsOwnerClass.add(traceGOLD2); 
				}
			}
			methodtrace.setPredictionParams(PredictionParams);
			methodtrace.setPredictionFields(PredictionFields);
			methodtrace.setPredictionFieldsOwnerClass(PredictionFieldsOwnerClass);
			methodtrace.setPredictionParamsOwnerClass(PredictionParamsOwnerClass);
			j++; 
		}
		
		PredictionsNewHashMap=InitializePredictionsHashMap(PredictionsNewHashMap, methodtraces2HashMap); 
		int ITERATION1=0; 
		//while(Equals(PredictionsOldHashMap, PredictionsNewHashMap)==false) {
			
			PredictionsOldHashMap=InitializePredictionsHashMap(PredictionsOldHashMap, methodtraces2HashMap); 
	
			
			 MethodTracesHashmapValues = methodtraces2HashMap.values(); 
			for (DatabaseInput methodtrace : MethodTracesHashmapValues) {
				methodtrace.setPrediction("");
			
				List<String> methodfields = methodtrace.getPredictionFields(); 
				List<String> methodparams = methodtrace.getPredictionParams(); 
				//MY MIXED PATTERNS 
				
				//PATTERN 1	MIXED T
				//MIXED 
				CountTNE methodfieldsCount = GenerateCounts(methodfields); 
				CountTNE methodparamsCount=GenerateCounts(methodparams); 
				 if((methodfieldsCount.CountN>methodfieldsCount.CountT && methodfieldsCount.CountT>=0)
							|| (methodparamsCount.CountN>methodparamsCount.CountT && methodparamsCount.CountT>=0))
						{
							PatternSetVariables("N", methodtrace,"100%","P2"); 
						}
				 else	if((methodfieldsCount.CountT>methodfieldsCount.CountN && methodfieldsCount.CountN>=0)
				|| (methodparamsCount.CountT>methodparamsCount.CountN && methodparamsCount.CountN>=0) )
				{
					PatternSetVariables("T", methodtrace,"100%","P2"); 
				}
				
				
				
			
					
				
					
		
		
		
	//	 System.out.println("===============>PATTERNS 1 AND 2 METHOD FIELDS MIXED  ITERATION "+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNMethodFields.toString());

		 ITERATION1++; }
			
			 LinkedHashMap<String, DatabaseInput> MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 		
			 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNMethodFieldsMixed);
			
			
			
			
			PredictionsNewHashMap=InitializePredictionsHashMap(PredictionsNewHashMap, methodtraces2HashMap); 
			 ITERATION1=0; 
			//while(Equals(PredictionsOldHashMap, PredictionsNewHashMap)==false) {
				
				PredictionsOldHashMap=InitializePredictionsHashMap(PredictionsOldHashMap, methodtraces2HashMap); 
		
				
				 MethodTracesHashmapValues = methodtraces2HashMap.values(); 
				for (DatabaseInput methodtrace : MethodTracesHashmapValues) {
					methodtrace.setPrediction("");
				
					List<String> methodfields = methodtrace.getPredictionFieldsOwnerClass(); 
					List<String> methodparams = methodtrace.getPredictionParamsOwnerClass(); 
					//MY MIXED PATTERNS 
					
					//PATTERN 1	MIXED T
					//MIXED 
					CountTNE methodfieldsCount = GenerateCounts(methodfields); 
					CountTNE methodparamsCount=GenerateCounts(methodparams); 
					 if((methodfieldsCount.CountN>methodfieldsCount.CountT && methodfieldsCount.CountT>=0)
								|| (methodparamsCount.CountN>methodparamsCount.CountT && methodparamsCount.CountT>=0))
							{
								PatternSetVariables("N", methodtrace,"100%","P2"); 
							}
							
					 else	if((methodfieldsCount.CountT>methodfieldsCount.CountN && methodfieldsCount.CountN>=0)
					|| (methodparamsCount.CountT>methodparamsCount.CountN && methodparamsCount.CountN>=0) )
					{
						PatternSetVariables("T", methodtrace,"100%","P2"); 
					}
					
					
				
						
					
						
			
			
			
		//	 System.out.println("===============>PATTERNS 1 AND 2 METHOD FIELDS MIXED  ITERATION "+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNMethodFields.toString());

			 ITERATION1++; }
			
				 MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 		
				 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNMethodFieldsMixedOWNER);
				
				
				for (DatabaseInput methodtrace : MethodTracesHashmapValues) {
					methodtrace.setPrediction("");
				
					List<String> methodfields = methodtrace.getPredictionFields(); 
					List<String> methodparams = methodtrace.getPredictionParams(); 
					List<String> methodfieldsOWNER = methodtrace.getPredictionFieldsOwnerClass(); 
					List<String> methodparamsOWNER = methodtrace.getPredictionParamsOwnerClass(); 
					//MY MIXED PATTERNS 
					
					//PATTERN 1	MIXED T
					//MIXED 
					CountTNE methodfieldsCount = GenerateCounts(methodfields); 
					CountTNE methodparamsCount=GenerateCounts(methodparams); 
					CountTNE methodfieldsCountOWNER = GenerateCounts(methodfieldsOWNER); 
					CountTNE methodparamsCountOWNER=GenerateCounts(methodparamsOWNER); 
					if(
							(methodfieldsCount.CountN>methodfieldsCount.CountT && methodfieldsCount.CountT>=0)
							|| (methodparamsCount.CountN>methodparamsCount.CountT && methodparamsCount.CountT>=0)
							||	(methodfieldsCountOWNER.CountN>methodfieldsCountOWNER.CountT && methodfieldsCountOWNER.CountT>=0)
							|| (methodparamsCountOWNER.CountN>methodparamsCountOWNER.CountT && methodparamsCountOWNER.CountT>=0)
								
								)
						{
							PatternSetVariables("N", methodtrace,"100%","P2"); 
						}
					else	if((methodfieldsCount.CountT>methodfieldsCount.CountN && methodfieldsCount.CountN>=0)
					|| (methodparamsCount.CountT>methodparamsCount.CountN && methodparamsCount.CountN>=0) 
					|| (methodfieldsCountOWNER.CountT>methodfieldsCountOWNER.CountN && methodfieldsCountOWNER.CountN>=0)
					|| (methodparamsCountOWNER.CountT>methodparamsCountOWNER.CountN && methodparamsCountOWNER.CountN>=0) )
					{
						PatternSetVariables("T", methodtrace,"100%","P2"); 
					}
					 
					
					
				
						
					
						
			
			
			
		//	 System.out.println("===============>PATTERNS 1 AND 2 METHOD FIELDS MIXED  ITERATION "+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNMethodFields.toString());

			 ITERATION1++; }
				
				 MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 		
				 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNMethodFieldsMixedOWNERType);
			
			//PURE PATTERN 
	
			for (DatabaseInput methodtrace : MethodTracesHashmapValues) {
				methodtrace.setPrediction("");
				List<String> methodfields = methodtrace.getPredictionFields(); 
				List<String> methodparams = methodtrace.getPredictionParams(); 
				CountTNE methodfieldsCount = GenerateCounts(methodfields); 
				CountTNE methodparamsCount=GenerateCounts(methodparams); 
				
				//PURE 
//				if((methodfieldsCount.CountT>=1 && methodfieldsCount.CountN==0 && methodfieldsCount.CountE==0) 
//				|| (methodparamsCount.CountT>=1 && methodparamsCount.CountN==0 && methodparamsCount.CountE==0) ) {
//					PatternSetVariables("T", methodtrace,"100%","P4"); 
//				}
//				if((methodfieldsCount.CountN>=1 && methodfieldsCount.CountT==0 && methodfieldsCount.CountE==0) 
//				|| (methodparamsCount.CountN>=1 && methodparamsCount.CountT==0 && methodparamsCount.CountE==0) ) {
//					PatternSetVariables("N", methodtrace,"100%","P4"); 
//				}
				
				
				if((methodfieldsCount.CountN>=1 && methodfieldsCount.CountT==0 ) 
						|| (methodparamsCount.CountN>=1 && methodparamsCount.CountT==0 ) ) {
							PatternSetVariables("N", methodtrace,"100%","P4"); 
						}
				else	if((methodfieldsCount.CountT>=1 && methodfieldsCount.CountN==0 ) 
						|| (methodparamsCount.CountT>=1 && methodparamsCount.CountN==0 ) ) {
							PatternSetVariables("T", methodtrace,"100%","P4"); 
						}
					
		
		
		
		
	//	 System.out.println("===============>PATTERNS 3 AND  4 METHOD FIELDS MIXED  ITERATION "+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNMethodFields.toString());

			}
			
			MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 		
			 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNMethodFieldsPure);
			
			
			for (DatabaseInput methodtrace : MethodTracesHashmapValues) {
				methodtrace.setPrediction("");
				List<String> methodfields = methodtrace.getPredictionFields(); 
				List<String> methodparams = methodtrace.getPredictionParams(); 
				List<String> methodfieldsOwner = methodtrace.getPredictionFieldsOwnerClass(); 
				List<String> methodparamsOwner = methodtrace.getPredictionParamsOwnerClass(); 
				CountTNE methodfieldsCount = GenerateCounts(methodfields); 
				CountTNE methodparamsCount=GenerateCounts(methodparams); 
				CountTNE methodfieldsCountOWNER = GenerateCounts(methodfieldsOwner); 
				CountTNE methodparamsCountOWNER=GenerateCounts(methodparamsOwner); 
				//PURE 

				
				
				if((methodfieldsCount.CountN>=1 && methodfieldsCount.CountT==0 ) 
						|| (methodparamsCount.CountN>=1 && methodparamsCount.CountT==0 ) 
						||(methodfieldsCountOWNER.CountN>=1 && methodfieldsCountOWNER.CountT==0 ) 
						|| (methodparamsCountOWNER.CountN>=1 && methodparamsCountOWNER.CountT==0 )
								) {
							PatternSetVariables("N", methodtrace,"100%","P4"); 
						}
		
				else	if(
						(methodfieldsCount.CountT>=1 && methodfieldsCount.CountN==0 ) 
						|| (methodparamsCount.CountT>=1 && methodparamsCount.CountN==0 )
						||(methodfieldsCountOWNER.CountT>=1 && methodfieldsCountOWNER.CountN==0 ) 
						|| (methodparamsCountOWNER.CountT>=1 && methodparamsCountOWNER.CountN==0 )
						
						) {
							PatternSetVariables("T", methodtrace,"100%","P4"); 
						}
					
		
		
	
	//	 System.out.println("===============>PATTERNS 3 AND  4 METHOD FIELDS MIXED  ITERATION "+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNMethodFields.toString());

			}
			
			
			 MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 		
			 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNMethodFieldsPureOWNERType);
			
			
			
			//PURE PATTERN 
			
			for (DatabaseInput methodtrace : MethodTracesHashmapValues) {
				methodtrace.setPrediction("");
				List<String> methodfields = methodtrace.getPredictionFieldsOwnerClass(); 
				List<String> methodparams = methodtrace.getPredictionParamsOwnerClass(); 
				CountTNE methodfieldsCount = GenerateCounts(methodfields); 
				CountTNE methodparamsCount=GenerateCounts(methodparams); 
				
				//PURE 

				
				
				if((methodfieldsCount.CountN>=1 && methodfieldsCount.CountT==0 ) 
						|| (methodparamsCount.CountN>=1 && methodparamsCount.CountT==0 ) ) {
							PatternSetVariables("N", methodtrace,"100%","P4"); 
						}
				else	if(		(methodfieldsCount.CountT>=1 && methodfieldsCount.CountN==0 ) 
						|| (methodparamsCount.CountT>=1 && methodparamsCount.CountN==0 ) ) {
							PatternSetVariables("T", methodtrace,"100%","P4"); 
						}
				
		
		
		
		

			}
			
			MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 		
			 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNMethodFieldsPureOWNER);
			
			
			
			
			
			
			
			
			
			
			
			
//			for (MethodTraceSubjectTSubjectN methodtrace : methodtraces2) {
//					if(methodtrace.getPrediction().trim().equals("E")){
//						methodtrace.setPrediction("T");
//					}
//			}

			//PRINT 
			
//			 LinkedHashMap<String, MethodTraceSubjectTSubjectN> MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 
//			 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNMethodFields);
			System.out.println("===============>PATTERNS METHOD FIELDS  ITERATION  "+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNMethodFieldsPure.toString());

			 //END  PRINT 
			ITERATION1++; 
			//System.out.println("HEEEEEEY");
			PredictionsNewHashMap=InitializePredictionsHashMap(PredictionsNewHashMap, methodtraces2HashMap); 
		
		//}
		
		
		
		
//		 LinkedHashMap<String, MethodTraceSubjectTSubjectN> MyfinalHashMap = RetrievePredictionsHashMap( methodtracesNew); 
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN prediction"); 
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN likelihood");
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN why");
//		st.executeUpdate("ALTER TABLE `traces` ADD prediction LONGTEXT"); 
//		st.executeUpdate("ALTER TABLE `traces` ADD likelihood LONGTEXT");
//		st.executeUpdate("ALTER TABLE `traces` ADD why LONGTEXT");
		
		
		
//		WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNMethodFields);
		return PredictionsNewHashMap; 
	
	}

public CountTNE GenerateCounts(List<String> methodparams) {
	// TODO Auto-generated method stub
	CountTNE count= new CountTNE(); 
	for(String methodparam: methodparams) {
		if(methodparam.equals("T")) {
			count.CountT++;
		}
		if(methodparam.equals("N")) {
			count.CountN++;
		}
		if(methodparam.equals("E")) {
			count.CountE++;
		}
	}
	
	return count; 
}



public void SecondIteration(List<Parameter2> parameterlistE, List<Parameter2> parameterlistN, List<Parameter2> parameterlistT, List<MethodField2> methodfieldlistT, List<MethodField2> methodfieldlistN, List<MethodField2> methodfieldlistE, List<String> PredictionFields, List<String> PredictionParams, DatabaseInput methodtrace) {
	// TODO Auto-generated method stub
	for(MethodField2 methodfield: methodfieldlistE) {
		String key=methodfield.getMethod().ID+"-"+methodtrace.Requirement.ID; 
		if(methodtraces2HashMap.get(key)!=null) {
			String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
			PredictionFields.add(predictionvalue); 
		}
	}
	for(MethodField2 methodfield: methodfieldlistN) {
		String key=methodfield.getMethod().ID+"-"+methodtrace.Requirement.ID; 
		if(methodtraces2HashMap.get(key)!=null) {
			String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
			PredictionFields.add(predictionvalue); 
		}
	}
	for(MethodField2 methodfield: methodfieldlistT) {
		String key=methodfield.getMethod().ID+"-"+methodtrace.Requirement.ID; 
		if(methodtraces2HashMap.get(key)!=null) {
			String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
			PredictionFields.add(predictionvalue); 
		}
	}
	
	
	for(Parameter2 methodfield: parameterlistT) {
		String key=methodfield.getMethod().ID+"-"+methodtrace.Requirement.ID; 
		if(methodtraces2HashMap.get(key)!=null) {
			String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
			PredictionParams.add(predictionvalue); 
		}
	}
	for(Parameter2 methodfield: parameterlistE) {
		String key=methodfield.getMethod().ID+"-"+methodtrace.Requirement.ID; 
		if(methodtraces2HashMap.get(key)!=null) {
			String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
			PredictionParams.add(predictionvalue); 
		}
	}
	for(Parameter2 methodfield: parameterlistN) {
		String key=methodfield.getMethod().ID+"-"+methodtrace.Requirement.ID; 
		if(methodtraces2HashMap.get(key)!=null) {
			String predictionvalue=methodtraces2HashMap.get(key).getPrediction(); 
			PredictionParams.add(predictionvalue); 
		}
	}


}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	/******************************************************************************************************************************/
	
	
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

			//System.out.println(myvalue.getGold6()+"   "+myvalue.getPrediction());
				//st.executeUpdate("UPDATE `traces` SET  +"'WHERE requirementid='"+entry.RequirementID+"' AND method='"+name+"'"); 
			if(myvalue.getGold6()!=null && myvalue.getPrediction()!=null) {
				String Result=nEWPATTERNMethodFields2.ComparePredictionToGold(myvalue.getGold6().trim(), myvalue.getPrediction()); 
				nEWPATTERNMethodFields2.UpdateCounters(Result, nEWPATTERNMethodFields2);
			}
		
			
		}
		nEWPATTERNMethodFields2.toString(); 
		
		
	}

	
	
	
	public LinkedHashMap<String, String> InitializePredictionsHashMap(LinkedHashMap<String, String> predictionsOldHashMap, LinkedHashMap<String, DatabaseInput> methodtraces2HashMap2) {
		// TODO Auto-generated method stub

		
		for( String key: methodtraces2HashMap2.keySet()) {
			
		
			predictionsOldHashMap.put(key, methodtraces2HashMap2.get(key).getPrediction()); 
		}
		return predictionsOldHashMap;
	}

	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	
	public List<DatabaseInput> InitializePredictionsHashMapBlankValues(LinkedHashMap<String, String> predictionsOldHashMap, List<DatabaseInput> methodtraces22) {
		// TODO Auto-generated method stub

		for(DatabaseInput methodtrace: methodtraces22) {
			methodtrace.setPrediction("");
		}
		return methodtraces22;
	}
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	public LinkedHashMap<String, DatabaseInput> RetrievePredictionsHashMap( List<DatabaseInput> methodtraces22) {
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
	
	
	
	public void PatternSetVariables(String Prediction, DatabaseInput methodtrace, String Likelihood, String Why) {
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

		TracesTableJHOTDRAWFINALROUND2FieldsGOLD6 frame = new TracesTableJHOTDRAWFINALROUND2FieldsGOLD6();
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



