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

import mypackage.Children2;
import mypackage.ClassField2;
import mypackage.Clazz;
import mypackage.ClassTrace2;
import mypackage.ColumnGroup;
import mypackage.DatabaseReading2;
import mypackage.GroupableTableHeader;
import mypackage.Implementation2;
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

public class TracesTableChessFINALROUND2Superclasses extends JFrame {
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("root", this.userName);
		connectionProps.put("123456", this.password);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasechess","root","123456");

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
	
	
	int Gold2V2=95; 
	int OwnerClassTGold2V2=96; 
	int OwnerClassNGold2V2=97; 
	int OwnerClassEGold2V2=98; 
	int CallerMethodsNumberGold2V2=99; 
	int CallerMethodsTGold2V2=100; 
	int CallerMethodsNGold2V2=101; 
	int CallerMethodsEGold2V2=102; 
	int CallerClassesNumberGold2V2=103; 
	int CallerClassesTGold2V2=104; 
	int CallerClassesNGold2V2=105; 
	int CallerClassesEGold2V2=106; 
	int CalleeMethodsNumberGold2V2=107; 
	int CalleeMethodsTGold2V2=108; 
	int CalleeMethodsNGold2V2=109; 
	int CalleeMethodsEGold2V2=110; 
	int CalleeClassesNumberGold2V2=111; 
	int CalleeClassesTGold2V2=112; 
	int CalleeClassesNGold2V2=113; 
	int CalleeClassesEGold2V2=114; 
	int OwnerClassPredictionGold2V2=115; 
	int MajorityClassLevelCalleesGold2V2=116; 
	int MajorityClassLevelCallersGold2V2=117; 
	int MajorityMethodLevelCalleesGold2V2=118; 
	int MajorityMethodLevelCallersGold2V2=119; 
	int AtLeast1NPredictionClassLevelCalleesGold2V2=120; 
	int AtLeast1NPredictionClassLevelCallersGold2V2=121; 
	int AtLeast1NPredictionMethodLevelCalleesGold2V2=122; 
	int AtLeast1NPredictionMethodLevelCallersGold2V2=123; 
	int AtLeast1TPredictionClassLevelCalleesGold2V2=124; 
	int AtLeast1TPredictionClassLevelCallersGold2V2=125; 
	int AtLeast1TPredictionMethodLevelCalleesGold2V2=126; 
	int AtLeast1TPredictionMethodLevelCallersGold2V2=127; 
	int AtLeast2NPredictionClassLevelCalleesGold2V2=128; 
	int AtLeast2NPredictionClassLevelCallersGold2V2=129; 
	int AtLeast2NPredictionMethodLevelCalleesGold2V2=130; 
	int AtLeast2NPredictionMethodLevelCallersGold2V2=131; 
	int AtLeast2TPredictionClassLevelCalleesGold2V2=132; 
	int AtLeast2TPredictionClassLevelCallersGold2V2=133; 
	int AtLeast2TPredictionMethodLevelCalleesGold2V2=134; 
	int AtLeast2TPredictionMethodLevelCallersGold2V2=135; 
	int AllNClassLevelCalleesGold2V2=136; 
	int AllNClassLevelCallersGold2V2=137; 
	int AllNMethodLevelCalleesGold2V2=138; 
	int AllNMethodLevelCallersGold2V2=139; 
	int AllTClassLevelCalleesGold2V2=140; 
	int AllTClassLevelCallersGold2V2=141; 
	int AllTMethodLevelCalleesGold2V2=142; 
	int AllTMethodLevelCallersGold2V2=143; 
	int CallersGold2V2=144; 
	int CalleesGold2V2=145; 
	int paramatersNumberGold2V2=146; 
	int CountParamaterTGold2V2=147; 
	int CountParamaterNGold2V2=148; 
	int CountParamaterEGold2V2=149; 
	int MajorityParametersGold2V2=150; 
	int AtLeast1NParameterGold2V2=151; 
	int AtLeast1TParameterGold2V2=152; 
	int AtLeast2TParameterGold2V2=153; 
	int AtLeast2NParameterGold2V2=154; 
	int AllNParametersGold2V2=155; 
	int AllTParametersGold2V2=156; 
	int ACHRAFTRACEPureGold2V2=157; 
	int ACHRAFTRACEMixedGold2V2=158; 
	int ACHRAFNOTRACEPureGold2V2=159; 
	int ACHRAFNOTRACEMixedGold2V2=160; 
	int AllNMethodLevelCallersCalleesGold2V2=161; 
	int AllTMethodLevelCallersCalleesGold2V2=162; 
	int AllTClassLevelCallersCalleesGold2V2=163; 
	int AllNClassLevelCallersCalleesGold2V2=164; 
	int AllNClassLevelCalleesAtLeast2NGold2V2=165; 
	int AllNClassLevelCallersAtLeast2NGold2V2=166; 
	int AllNMethodLevelCalleesAtLeast2NGold2V2=167; 
	int AllNMethodLevelCallersAtLeast2NGold2V2=168; 
	int AllTClassLevelCalleesAtLeast2TGold2V2=169; 
	int AllTClassLevelCallersAtLeast2TGold2V2=170; 
	int AllTMethodLevelCalleesAtLeast2TGold2V2=171; 
	int AllTMethodLevelCallersAtLeast2TGold2V2=172; 
	int CLASSTRACEMethodLevelPureGold2V2=173; 
	int CLASSTRACEMethodLevelMixedGold2V2=174; 
	int CLASSNOTRACEMethodLevelPureGold2V2=175; 
	int CLASSNOTRACEMethodLevelMixedGold2V2=176;
	int CLASSTRACEClassLevelPureGold2V2=177; 
	int CLASSTRACEClassLevelMixedGold2V2=178; 
	int CLASSNOTRACEClassLevelPureGold2V2=179; 
	int CLASSNOTRACEClassLevelMixedGold2V2=180;
	int CLASSTRACEMethodLevelPureGold2V2ACROSS=181; 
	int CLASSTRACEMethodLevelMixedGold2V2ACROSS=182; 
	int CLASSNOTRACEMethodLevelPureGold2V2ACROSS=183; 
	int CLASSNOTRACEMethodLevelMixedGold2V2ACROSS=184;
	int CLASSTRACEClassLevelPureGold2V2ACROSS=185; 
	int CLASSTRACEClassLevelMixedGold2V2ACROSS=186; 
	int CLASSNOTRACEClassLevelPureGold2V2ACROSS=187; 
	int CLASSNOTRACEClassLevelMixedGold2V2ACROSS=188;
	int CallerMethodsNumberGold2V2ACROSS=189; 
	int CallerMethodsTGold2V2ACROSS=190; 
	int CallerMethodsNGold2V2ACROSS=191; 
	int CallerMethodsEGold2V2ACROSS=192; 
	int CallerClassesNumberGold2V2ACROSS=193; 
	int CallerClassesTGold2V2ACROSS=194; 
	int CallerClassesNGold2V2ACROSS=195; 
	int CallerClassesEGold2V2ACROSS=196; 
	int CalleeMethodsNumberGold2V2ACROSS=197; 
	int CalleeMethodsTGold2V2ACROSS=198; 
	int CalleeMethodsNGold2V2ACROSS=199; 
	int CalleeMethodsEGold2V2ACROSS=200; 
	int CalleeClassesNumberGold2V2ACROSS=201; 
	int CalleeClassesTGold2V2ACROSS=202; 
	int CalleeClassesNGold2V2ACROSS=203; 
	int CalleeClassesEGold2V2ACROSS=204; 
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
	int interfacesNumberGold2V2=221; 
	int CountInterfaceTGold2V2=222; 
	int CountInterfaceNGold2V2=223; 
	int CountInterfaceEGold2V2=224; 
	
	int FieldClassesNumberGold2V2=225; 
	int CountFieldClassTGold2V2=226; 
	int CountFieldClassNGold2V2=227; 
	int CountFieldClassEGold2V2=228; 
	
	int FieldMethodsNumberGold2V2=229; 
	int CountFieldMethodTGold2V2=230; 
	int CountFieldMethodNGold2V2=231; 
	int CountFieldMethodEGold2V2=232; 
	
	int SuperClassesNumberGold2V2=233; 
	int CountFieldSuperClassTGold2V2=234; 
	int CountFieldSuperClassNGold2V2=235; 
	int CountFieldSuperClassEGold2V2=236; 
	
	int counterFN=0; 
	double TracePureGold=0; 
	double NoTracePureGold=0; 
	double TraceMixedGold=0; 
	double NoTraceMixedGold=0; 
	
	double TracePureGoldTotal=0; 
	double NoTracePureGoldTotal=0; 
	double TraceMixedGoldTotal=0; 
	double NoTraceMixedGoldTotal=0; 
	
	double TracePureGold2V2=0; 
	double NoTracePureGold2V2=0; 
	double TraceMixedGold2V2=0; 
	double NoTraceMixedGold2V2=0; 
	
	double failGold=0; 
	double failGold2V2=0; 
	double TraceCountTotal=0; 
	double NoTraceCountTotal=0; 
	double TraceCountTotalGold2V2=0; 
	double NoTraceCountTotalGold2V2=0; 
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
	PredictionEvaluation OwnerClassPredictionClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation MajorityClassLevelCallersClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation MajorityClassLevelCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation MajorityMethodLevelCallersClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation MajorityMethodLevelCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionClassLevelCallersClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionClassLevelCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionMethodLevelCallersClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastNPredictionMethodLevelCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionClassLevelCallersClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionClassLevelCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionMethodLevelCallersClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeastTPredictionMethodLevelCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionClassLevelCallersClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionClassLevelCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionMethodLevelCallersClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NPredictionMethodLevelCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionClassLevelCallersClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionClassLevelCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionMethodLevelCallersClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TPredictionMethodLevelCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCallersClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCallersClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation MajorityParametersClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast1NParameterClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2NParameterClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast1TParameterClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AtLeast2TParameterClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllNParameterClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllTParameterClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersCalleesClass= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFTracePureGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFTraceMixedGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTracePureGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFNOTraceMixedGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllNMethodLevelCallersCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllTMethodLevelCallersCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersCalleesClassGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFGold2V2Trace= new PredictionEvaluation(); 
	PredictionEvaluation ACHRAFGold2V2NOTrace= new PredictionEvaluation(); 
	PredictionEvaluation PureNCallersGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation PureTCallersGold2V2= new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCalleesClassAtLeast2NGold2V2=new PredictionEvaluation(); 
	PredictionEvaluation AllNClassLevelCallersClassAtLeast2NGold2V2=new PredictionEvaluation();  
	PredictionEvaluation AllNMethodLevelCalleesClassAtLeast2NGold2V2=new PredictionEvaluation();  
	PredictionEvaluation AllNMethodLevelCallersClassAtLeast2NGold2V2=new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCalleesClassAtLeast2TGold2V2=new PredictionEvaluation(); 
	PredictionEvaluation AllTClassLevelCallersClassAtLeast2TGold2V2=new PredictionEvaluation();  
	PredictionEvaluation AllTMethodLevelCalleesClassAtLeast2TGold2V2=new PredictionEvaluation();  
	PredictionEvaluation AllTMethodLevelCallersClassAtLeast2TGold2V2=new PredictionEvaluation(); 
	PredictionEvaluation PredictionCLASSTRACEMethodLevelPureGold2V2=new PredictionEvaluation(); 
	PredictionEvaluation PredictionCLASSTRACEMethodLevelMixedGold2V2=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelPureGold2V2=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelMixedGold2V2=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSTRACEClassLevelPureGold2V2=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSTRACEClassLevelMixedGold2V2=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelPureGold2V2=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelMixedGold2V2=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSTRACEMethodLevelPureGold2V2ACROSS=new PredictionEvaluation(); 
	PredictionEvaluation PredictionCLASSTRACEMethodLevelMixedGold2V2ACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelPureGold2V2ACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEMethodLevelMixedGold2V2ACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSTRACEClassLevelPureGold2V2ACROSS=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSTRACEClassLevelMixedGold2V2ACROSS=new PredictionEvaluation();  
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelPureGold2V2ACROSS=new PredictionEvaluation();   
	PredictionEvaluation PredictionCLASSNOTRACEClassLevelMixedGold2V2ACROSS=new PredictionEvaluation();  

	PredictionEvaluation NEWPATTERNMethodCalls=new PredictionEvaluation();  

	PredictionEvaluation NEWPATTERNSuperclassesPure=new PredictionEvaluation();  
	PredictionEvaluation NEWPATTERNSuperclassesMixed=new PredictionEvaluation();  
	

	PredictionEvaluation NEWPATTERNSuperclassesInterfacesPure=new PredictionEvaluation();  
	PredictionEvaluation NEWPATTERNSuperclassesInterfacesMixed=new PredictionEvaluation();  
	PredictionEvaluation NEWPATTERNSuperClassFieldsComboMixed=new PredictionEvaluation();  

	
	PredictionEvaluation NEWPATTERNInterfacesPure=new PredictionEvaluation();  
	PredictionEvaluation NEWPATTERNInterfacesMixed=new PredictionEvaluation(); 

	ClassTrace2 myclasstrace = new ClassTrace2();
	static List<DatabaseInput> methodtraces2 = new ArrayList<DatabaseInput>();
	static LinkedHashMap<String, DatabaseInput> methodtraces2HashMap  = new LinkedHashMap<String, DatabaseInput>();
	static HashMap<String, List<Parameter2>> parameterHashMap  = new HashMap<String, List<Parameter2>>();
	static List<ClassTrace2> classtraces2 = new ArrayList<ClassTrace2>();
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass = new  LinkedHashMap<String, ClassTrace2>(); 
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClassGold2V2 = new  LinkedHashMap<String, ClassTrace2>(); 

	 LinkedHashMap<String, MethodDetails> linkedmethodhashmap= new LinkedHashMap<String, MethodDetails>(); 
	 HashMap<String, Interface> InterfacesHashMap= new HashMap<String, Interface>();
	 HashMap<String, Interface> InterfacesHashMapAlreadyImpl= new HashMap<String, Interface>(); 
	 HashMap<String, List<Interface>>  InterfacesOwnerClassHashMap= new HashMap<String, List<Interface>>(); 
	 HashMap<String, List< MethodField2>>  FieldMethodsHashMap= new HashMap<String, List< MethodField2>>(); 
	 HashMap<String, List< ClassField2>> FieldClassesHashMap=  new HashMap<String, List< ClassField2>>(); 
	 HashMap<String, List< SuperClass2>> SuperclassesHashMap=  new HashMap<String, List< SuperClass2>>(); 
	 HashMap<String, List< Children2>> ChildrenHashMap=  new HashMap<String, List< Children2>>(); 
	 HashMap<String, List< Implementation2>> INTERFACEHASHMAPFINAL=  new HashMap<String, List< Implementation2>>(); 

	JTable table = new JTable(); 
	static List<MethodDetails> methodlist = new ArrayList<MethodDetails>();
	//File fout = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\TableLog.txt");
	File fout = new File("C:\\Users\\mouna\\dumps\\TableLogChess.txt");

	FileOutputStream fos = new FileOutputStream(fout);
	
//	File fout2 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\PredictionEvaluationChess.txt");
	File fout2 = new File("C:\\Users\\mouna\\dumps\\PredictionEvaluationChess.txt");

	FileOutputStream fos2 = new FileOutputStream(fout2);
	
	//File foutGold2V2 = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\PredictionEvaluationChessGold2V2.txt");
	File foutGold2V2 = new File("C:\\Users\\mouna\\dumps\\PredictionEvaluationChessGold2V2.txt");

	FileOutputStream fileGold2V2 = new FileOutputStream(foutGold2V2);
	
	File foutGold2V2TableLog = new File("C:\\Users\\mouna\\dumps\\TableLogChessGold2V2.txt");
	FileOutputStream fosGold2V2 = new FileOutputStream(foutGold2V2TableLog);
	BufferedWriter bwGold2V2TableLog = new BufferedWriter(new OutputStreamWriter(fosGold2V2));

	
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
	BufferedWriter bwGold2V2 = new BufferedWriter(new OutputStreamWriter(fileGold2V2));
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
	
	public TracesTableChessFINALROUND2Superclasses() throws SQLException, IOException {
	
		bwGold2V2TableLog.write("RowNumber, MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold2V2, Subject, OwnerClassT, OwnerClassN, "
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
		bwGold2V2TableLog.newLine();
		DatabaseReading2 db = new DatabaseReading2();
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
		  //CHILDREN 
		  ChildrenHashMap= db.getChildrenHashMap(); 
		  //IMPLEMENTATIONS 
		  INTERFACEHASHMAPFINAL= db.getINTERFACEHASHMAPFINAL(); 
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
		int MethodTraceCountGold2V2=0; 
		// Create the editors to be used for each row
		
		
		List<DatabaseInput> methodtracesNew = InitializePredictionsHashMap2(methodtraces2); 
		LinkedHashMap<String, String> PredictionHashMap2 = function2(data, j, PredictionsOldHashMap, PredictionsNewHashMap, methodtracesNew); 
		
//		PredictionHashMaps.add(PredictionHashMap1); 
//		PredictionHashMaps.add(PredictionHashMap2); 
		
		
		bwfile1.close();
		bwfile2.close();
		bwfile3.close();
		br.newLine(); 
		br.write("NEW PATTERN SUPERCLASSES INTERFACES PURE : "+NEWPATTERNSuperclassesInterfacesPure.toString());
		br.newLine(); 
		br.write("NEW PATTERN SUPERCLASSES INTERFACES MIXED : "+NEWPATTERNSuperclassesInterfacesMixed.toString());
		br.newLine(); 
		br.write("NEW PATTERN  INTERFACES PURE : "+NEWPATTERNInterfacesPure.toString());
		br.newLine(); 
		br.write("NEW PATTERN  INTERFACES MIXED : "+NEWPATTERNInterfacesMixed.toString());
		br.newLine(); 
		br.write("NEW PATTERN SUPERCLASSES MIXED : "+NEWPATTERNSuperclassesMixed.toString());
		br.newLine(); 
		br.write("NEW PATTERN SUPERCLASSES PURE : "+NEWPATTERNSuperclassesPure.toString());
		br.newLine(); 
		br.write("NEW PATTERN SUPERCLASSES COMBO MIXED : "+NEWPATTERNSuperClassFieldsComboMixed.toString());
	
		

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
		System.out.println("NEW PATTERN SUPERCLASSES PURE : "+NEWPATTERNSuperclassesPure.toString()); 
		System.out.println("NEW PATTERN SUPERCLASSES MIXED: "+NEWPATTERNSuperclassesMixed.toString()); 
		
		bw2.close();
		
		
		
		
		
		
		bwGold2V2.close();
		
		
//		String[] columnNames = {"Row",  "MethodID", "MethodName", "RequirementID", "RequirementName", "ClassID", "ClassName",
//				"Gold", "Subject", "OwnerClass T", "Owner Class N", "Owner Class E", "# caller methods",
//				"# caller methods T", "#caller methods N", "#caller methods E", "# caller classes",
//				"# caller classes T", "#caller classes N", "#caller classes E", "# callee methods",
//				"# callee methods T", "#callee methods N", "#callee methods E", "# callee classes",
//				"# callee classes T", "#callee classes N", "#callee classes E",  "OwnerClassPrediction",
//				"MajorityClassLevelCallers","MajorityClassLevelCallees", "MajorityMethodLevelCallers","MajorityMethodLevelCallees",
//				">0NPredictionClassLevelCallers", ">0NPredictionClassLevelCallees", ">0NPredictionMethodLevelCallers", 
//				">0NPredictionMethodLevelCallees", ">0TPredictionClassLevelCallers", ">0TPredictionClassLevelCallees", 
//				">0TPredictionMethodLevelCallers", ">0TPredictionMethodLevelCallees", 
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
				"33->0NPredictionClassLevelCallees", "34->0NPredictionClassLevelCallers", "35->0NPredictionMethodLevelCallees", 
				"36->0NPredictionMethodLevelCallers", "37->0TPredictionClassLevelCallees", "38->0TPredictionClassLevelCallers", 
				"39->0TPredictionMethodLevelCallees", "40->0TPredictionMethodLevelCallers", 
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
				
				
				"95-Gold2V2", "96-OwnerClass T Gold2V2", "97-Owner Class N Gold2V2", "98-Owner Class E Gold2V2", "99-# caller methods Gold2V2",
				"100-# caller methods T Gold2V2", "101-#caller methods N Gold2V2", "102-#caller methods E Gold2V2", "103-# caller classes Gold2V2",
				"104-# caller classes T Gold2V2", "105-#caller classes N Gold2V2", "106-#caller classes E Gold2V2", "107-# callee methods Gold2V2",
				"108-# callee methods T Gold2V2", "109-#callee methods N Gold2V2", "110-#callee methods E Gold2V2", "111-# callee classes Gold2V2",
				"112-# callee classes T Gold2V2", "113-#callee classes N Gold2V2", "114-#callee classes E Gold2V2",  "115-OwnerClassPrediction Gold2V2",
				"116-MajorityClassLevelCallees Gold2V2","117-MajorityClassLevelCallers Gold2V2", "118-MajorityMethodLevelCallees Gold2V2","119-MajorityMethodLevelCallers Gold2V2",
				"120->0NPredictionClassLevelCallees Gold2V2", "121->0NPredictionClassLevelCallers Gold2V2", "122->0NPredictionMethodLevelCallees Gold2V2", 
				"123->0NPredictionMethodLevelCallers Gold2V2", "124->0TPredictionClassLevelCallees Gold2V2", "125->0TPredictionClassLevelCallers Gold2V2", 
				"126->0TPredictionMethodLevelCallees Gold2V2", "127->0TPredictionMethodLevelCallers Gold2V2", 
				"128->2NPredictionClassLevelCallees Gold2V2", "129->2NPredictionClassLevelCallers Gold2V2", "130->2NPredictionMethodLevelCallees Gold2V2", 
				"131->2NPredictionMethodLevelCallers Gold2V2", "132->2TPredictionClassLevelCallees Gold2V2", "133->2TPredictionClassLevelCallers Gold2V2", 
				"134->2TPredictionMethodLevelCallees Gold2V2", "135->2TPredictionMethodLevelCallers Gold2V2", 
				"136-AllNClassLevelCallees Gold2V2", "137-AllNClassLevelCallers Gold2V2","138-AllNMethodLevelCallees Gold2V2","139-AllNMethodLevelCallers Gold2V2",
				"140-AllTClassLevelCallees Gold2V2", "141-AllTClassLevelCallers Gold2V2", "142-AllTMethodLevelCallees Gold2V2", "143-AllTMethodLevelCallers  Gold2V2"
				,"144-AllNAtLeast2NClassLevelCallees Gold2V2", "145-AllNAtLeast2NClassLevelCallers Gold2V2","146-AllNAtLeast2NMethodLevelCallees Gold2V2","147-AllNAtLeast2NMethodLevelCallers Gold2V2",
				"148-AllTAtLeast2TClassLevelCallees Gold2V2", "149-AllTAtLeast2TClassLevelCallers Gold2V2", "150-AllTAtLeast2TMethodLevelCallees Gold2V2", "151-AllTAtLeast2TMethodLevelCallers Gold2V2"
				
				,"152-Callers Gold2V2", "153-Callees Gold2V2", "154-#parameters Gold2V2","155-# Parameter T" ,"156-# Parameter N" ,"157-# Parameter E" ,
				"158-MajorityParameterPrediction Gold2V2", "159-AtLeast1NParameterPrediction Gold2V2", 
				"160-AtLeast1TParameterPrediction Gold2V2", "161-AtLeast2TParameterPrediction Gold2V2", 
				"162-AtLeast2NParameterPrediction Gold2V2", "163-AllNParameterPrediction Gold2V2", "164-AllTParameterPrediction Gold2V2",
				"165-ACHRAFTRACEPureGOLD 2", "166-ACHRAFTRACEMixedGold2V2", "167-ACHRAFNOTRACEPureGOLD 2", "168-ACHRAFNOTRACEMixed Gold2V2", 
				"169-AllTMethodLevelCallersCalleesClass Gold2V2", "170-AllNMethodLevelCallersCalleesClass Gold2V2",
				"171-AllTClassLevelCallersCalleesClass Gold2V2", "172-AllNClassLevelCallersCalleesClass Gold2V2", 
				"173-CLASSTRACEMethodLevelPureGold2V2","174-CLASSTRACEMethodLevelMixedGold2V2","175-CLASSNOTRACEMethodLevelPureGold2V2","176-CLASSNOTRACEMethodLevelMixedGold2V2]",
				"177-CLASSTRACEClassLevelPureGold2V2","178-CLASSTRACEClassLevelMixedGold2V2","179-CLASSNOTRACEClassLevelPureGold2V2","180-CLASSNOTRACEClassLevelMixedGold2V2"
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

		
		
		
		
		// TODO Auto-generated method stub
		MethodTracesHashmapValues = methodtraces2HashMap.values(); 
		/*******************************************************************************************************************************************/
		/*******************************************************************************************************************************************/
		/*******************************************************************************************************************************************/
		/*******************************************************************************************************************************************/

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
				if(myclasstraceHashMap.getTrace2()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTrace2().trim();
					PredictionFields.add(traceGold2V2); 
				}
			}
		if( paramlist!=null) {
			for(Parameter2 mymeth: paramlist) {
				String reqclass= methodtrace.Requirement.ID+"-"+ mymeth.getParameterType().ID; 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTrace2()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTrace2().trim();
					PredictionParams.add(traceGold2V2); 
				}
			}
		}
		
		if( paramlist!=null) {
			for(Parameter2 mymeth: paramlist) {
				String reqclass= methodtrace.Requirement.ID+"-"+ mymeth.getOwnerClass().ID; 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTrace2()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTrace2().trim();
					PredictionParamsOwnerClass.add(traceGold2V2); 
				}
			}
		}
		
		if(mymethodfields!=null)
			for(MethodField2 mymeth: mymethodfields) {
				String reqclass= methodtrace.Requirement.ID+"-"+ mymeth.getOwnerClass().ID;  
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTrace2()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTrace2().trim();
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

			
			List<Interface> myinterfaces = InterfacesOwnerClassHashMap.get(methodtrace.ClassRepresentation.classid); 
			 List<SuperClass2> mysuperclasses = SuperclassesHashMap.get(methodtrace.ClassRepresentation.classid); 
			 List<Implementation2> myimplementations = INTERFACEHASHMAPFINAL.get(methodtrace.ClassRepresentation.classid); 
			 List<Children2> mychildren = ChildrenHashMap.get(methodtrace.ClassRepresentation.classid); 
			 System.out.println("Methodtrace class id "+methodtrace.ClassRepresentation.classid);
		if(myinterfaces!=null)
			for(Interface myinterface: myinterfaces) {
				String reqclass= methodtrace.Requirement.ID+"-"+ myinterface.getInterfaceClass().getClassid(); 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTrace2()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTrace2().trim();
					InterfaceList.add(traceGold2V2); 
				}
			}
		if( mysuperclasses!=null)
			for(SuperClass2 mysuperclass: mysuperclasses) {
				String reqclass= methodtrace.Requirement.ID+"-"+ mysuperclass.getSuperClass().ID; 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTrace2()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTrace2().trim();
					SuperClassesList.add(traceGold2V2); 
				}
			}
		if(mychildren!=null)
			for(Children2 mychild: mychildren) {
				String reqclass= methodtrace.Requirement.ID+"-"+ mychild.getOwnerClass().ID; 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTrace2()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTrace2().trim();
					ChildrenList.add(traceGold2V2); 
				}
			}
		if( myimplementations!=null)
			for(Implementation2 myimplementation: myimplementations) {
				String reqclass= methodtrace.Requirement.ID+"-"+ myimplementation.getImplementation().ID; 
				ClassTrace2 myclasstraceHashMap = methodtracesRequirementClass.get(reqclass); 
				if(myclasstraceHashMap!=null)
				if(myclasstraceHashMap.getTrace2()!=null) {
					String traceGold2V2 = myclasstraceHashMap.getTrace2().trim();
					ImplementationList.add(traceGold2V2); 
				}
			}
			methodtrace.setSuperClassesList(SuperClassesList);
			methodtrace.setInterfaceList(InterfaceList);
			methodtrace.setImplementationList(ImplementationList);
			methodtrace.setChildrenList(ChildrenList);
			j++; 
		}
		
		
		/*******************************************************************************************************************************************/
		/*******************************************************************************************************************************************/
		/*******************************************************************************************************************************************/
		/*******************************************************************************************************************************************/
		PredictionsNewHashMap=InitializePredictionsHashMap(PredictionsNewHashMap, methodtraces2HashMap); 
		int ITERATION1=0; 
		//while(Equals(PredictionsOldHashMap, PredictionsNewHashMap)==false) {
			
			PredictionsOldHashMap=InitializePredictionsHashMap(PredictionsOldHashMap, methodtraces2HashMap); 
	
			
			 MethodTracesHashmapValues = methodtraces2HashMap.values(); 
			for (DatabaseInput methodtrace : MethodTracesHashmapValues) {
				methodtrace.setPrediction("");
			
				List<String> childrenList = methodtrace.getChildrenList(); 
				List<String> ImplementationList = methodtrace.getImplementationList(); 
				List<String> InterfaceList = methodtrace.getInterfaceList(); 
				List<String> SuperclassList = methodtrace.getSuperClassesList(); 
				List<String> methodfields = methodtrace.getPredictionFields(); 
				List<String> methodparams = methodtrace.getPredictionParams(); 
				List<String> methodfieldsOwner = methodtrace.getPredictionFieldsOwnerClass(); 
				List<String> methodparamsOwner = methodtrace.getPredictionParamsOwnerClass(); 
			
				//MY MIXED PATTERNS 
				
				//PATTERN 1	MIXED T
				CountTNE childrenListCount = GenerateCounts(childrenList); 
				CountTNE SuperclassListCount=GenerateCounts(SuperclassList); 
				CountTNE InterfaceListCount = GenerateCounts(InterfaceList); 
				CountTNE ImplementationListCount=GenerateCounts(ImplementationList); 
				CountTNE methodfieldsCount = GenerateCounts(methodfields); 
				CountTNE methodparamsCount=GenerateCounts(methodparams); 
				CountTNE methodfieldsOwnerCount = GenerateCounts(methodfieldsOwner); 
				CountTNE methodparamsOwnerCount=GenerateCounts(methodparamsOwner); 
				
				if(
					((	(childrenListCount.CountT>childrenListCount.CountN && childrenListCount.CountN>=0)
						||(SuperclassListCount.CountT>SuperclassListCount.CountN && SuperclassListCount.CountN>=0)
						||(ImplementationListCount.CountT>ImplementationListCount.CountN && ImplementationListCount.CountN>=0)
						|| (InterfaceListCount.CountT>InterfaceListCount.CountN && InterfaceListCount.CountN>=0)
						) && (methodfieldsCount.CountT>=1))
					
||
					
					((	(childrenListCount.CountT>childrenListCount.CountN && childrenListCount.CountN>=0)
							||(SuperclassListCount.CountT>SuperclassListCount.CountN && SuperclassListCount.CountN>=0)
							||(ImplementationListCount.CountT>ImplementationListCount.CountN && ImplementationListCount.CountN>=0)
							|| (InterfaceListCount.CountT>InterfaceListCount.CountN && InterfaceListCount.CountN>=0)
							) && (methodparamsCount.CountT>=1))
					
||
					
					((	(childrenListCount.CountT>childrenListCount.CountN && childrenListCount.CountN>=0)
							||(SuperclassListCount.CountT>SuperclassListCount.CountN && SuperclassListCount.CountN>=0)
							||(ImplementationListCount.CountT>ImplementationListCount.CountN && ImplementationListCount.CountN>=0)
							|| (InterfaceListCount.CountT>InterfaceListCount.CountN && InterfaceListCount.CountN>=0)
							) && (methodfieldsOwnerCount.CountT>=1))
					
||
					
					((	(childrenListCount.CountT>childrenListCount.CountN && childrenListCount.CountN>=0)
							||(SuperclassListCount.CountT>SuperclassListCount.CountN && SuperclassListCount.CountN>=0)
							||(ImplementationListCount.CountT>ImplementationListCount.CountN && ImplementationListCount.CountN>=0)
							|| (InterfaceListCount.CountT>InterfaceListCount.CountN && InterfaceListCount.CountN>=0)
							) && (methodparamsOwnerCount.CountT>=1))
					
			)
					{
						PatternSetVariables("T", methodtrace,"100%","P2"); 
					}
					else if(
							(SuperclassListCount.CountN>SuperclassListCount.CountT && SuperclassListCount.CountT>=0)
							|| (childrenListCount.CountN>childrenListCount.CountT && childrenListCount.CountT>=0)
							||(InterfaceListCount.CountN>InterfaceListCount.CountT && InterfaceListCount.CountT>=0)
							||(ImplementationListCount.CountN>ImplementationListCount.CountT && ImplementationListCount.CountT>=0)
							)
					{
						PatternSetVariables("N", methodtrace,"100%","P2"); 
					}
			
					
				
					
		
		
		
		 ITERATION1++; }
			
			
			 LinkedHashMap<String, DatabaseInput> MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 		
			 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNSuperClassFieldsComboMixed);
			 System.out.println("===============>PATTERNS 1 AND 2 SUPERCLASSES MIXED  ITERATION MIXED"+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNSuperClassFieldsComboMixed.toString());

			
			
			 
			 
				/*******************************************************************************************************************************************/
				/*******************************************************************************************************************************************/
				/*******************************************************************************************************************************************/
				/*******************************************************************************************************************************************/
				PredictionsNewHashMap=InitializePredictionsHashMap(PredictionsNewHashMap, methodtraces2HashMap); 
				 ITERATION1=0; 
				//while(Equals(PredictionsOldHashMap, PredictionsNewHashMap)==false) {
					
					PredictionsOldHashMap=InitializePredictionsHashMap(PredictionsOldHashMap, methodtraces2HashMap); 
			
					
					 MethodTracesHashmapValues = methodtraces2HashMap.values(); 
					for (DatabaseInput methodtrace : MethodTracesHashmapValues) {
						methodtrace.setPrediction("");
					
						List<String> childrenList = methodtrace.getChildrenList(); 
						List<String> ImplementationList = methodtrace.getImplementationList(); 
						List<String> InterfaceList = methodtrace.getInterfaceList(); 
						List<String> SuperclassList = methodtrace.getSuperClassesList(); 
						List<String> methodfields = methodtrace.getPredictionFields(); 
						List<String> methodparams = methodtrace.getPredictionParams(); 
						List<String> methodfieldsOwner = methodtrace.getPredictionFieldsOwnerClass(); 
						List<String> methodparamsOwner = methodtrace.getPredictionParamsOwnerClass(); 
					
						//MY MIXED PATTERNS 
						
						//PATTERN 1	MIXED T
						CountTNE childrenListCount = GenerateCounts(childrenList); 
						CountTNE SuperclassListCount=GenerateCounts(SuperclassList); 
						CountTNE InterfaceListCount = GenerateCounts(InterfaceList); 
						CountTNE ImplementationListCount=GenerateCounts(ImplementationList); 
						CountTNE methodfieldsCount = GenerateCounts(methodfields); 
						CountTNE methodparamsCount=GenerateCounts(methodparams); 
						CountTNE methodfieldsOwnerCount = GenerateCounts(methodfieldsOwner); 
						CountTNE methodparamsOwnerCount=GenerateCounts(methodparamsOwner); 
						
				if(
									(SuperclassListCount.CountN>SuperclassListCount.CountT && SuperclassListCount.CountT>=0)
									|| (childrenListCount.CountN>childrenListCount.CountT && childrenListCount.CountT>=0)
								
									)
							{
								PatternSetVariables("N", methodtrace,"100%","P2"); 
							}
					
				else 	if(
						((childrenListCount.CountT>childrenListCount.CountN && childrenListCount.CountN>=0)
							||(SuperclassListCount.CountT>SuperclassListCount.CountN && SuperclassListCount.CountN>=0)
						
						
	
						
				))
						{
							PatternSetVariables("T", methodtrace,"100%","P2"); 
						}
						
						
							
				
				
				
				 ITERATION1++; }
					
					
					 MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 		
					 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNSuperclassesMixed);
					 System.out.println("===============>PATTERNS 1 AND 2 SUPERCLASSES MIXED  ITERATION MIXED"+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNSuperclassesMixed.toString());

					
					
					 
					 
						/*******************************************************************************************************************************************/
						/*******************************************************************************************************************************************/
						/*******************************************************************************************************************************************/
						/*******************************************************************************************************************************************/
						PredictionsNewHashMap=InitializePredictionsHashMap(PredictionsNewHashMap, methodtraces2HashMap); 
						 ITERATION1=0; 
						//while(Equals(PredictionsOldHashMap, PredictionsNewHashMap)==false) {
							
							PredictionsOldHashMap=InitializePredictionsHashMap(PredictionsOldHashMap, methodtraces2HashMap); 
					
							
							 MethodTracesHashmapValues = methodtraces2HashMap.values(); 
							for (DatabaseInput methodtrace : MethodTracesHashmapValues) {
								methodtrace.setPrediction("");
							
								List<String> childrenList = methodtrace.getChildrenList(); 
								List<String> ImplementationList = methodtrace.getImplementationList(); 
								List<String> InterfaceList = methodtrace.getInterfaceList(); 
								List<String> SuperclassList = methodtrace.getSuperClassesList(); 
								List<String> methodfields = methodtrace.getPredictionFields(); 
								List<String> methodparams = methodtrace.getPredictionParams(); 
								List<String> methodfieldsOwner = methodtrace.getPredictionFieldsOwnerClass(); 
								List<String> methodparamsOwner = methodtrace.getPredictionParamsOwnerClass(); 
							
								//MY MIXED PATTERNS 
								
								//PATTERN 1	MIXED T
								CountTNE childrenListCount = GenerateCounts(childrenList); 
								CountTNE SuperclassListCount=GenerateCounts(SuperclassList); 
								CountTNE InterfaceListCount = GenerateCounts(InterfaceList); 
								CountTNE ImplementationListCount=GenerateCounts(ImplementationList); 
								CountTNE methodfieldsCount = GenerateCounts(methodfields); 
								CountTNE methodparamsCount=GenerateCounts(methodparams); 
								CountTNE methodfieldsOwnerCount = GenerateCounts(methodfieldsOwner); 
								CountTNE methodparamsOwnerCount=GenerateCounts(methodparamsOwner); 
								
							
									 if(
											(SuperclassListCount.CountN>SuperclassListCount.CountT && SuperclassListCount.CountT==0)
											|| (childrenListCount.CountN>childrenListCount.CountT && childrenListCount.CountT==0)
										
											)
									{
										PatternSetVariables("N", methodtrace,"100%","P2"); 
									}
							
									 else	if(
											((childrenListCount.CountT>childrenListCount.CountN && childrenListCount.CountN==0)
												||(SuperclassListCount.CountT>SuperclassListCount.CountN && SuperclassListCount.CountN==0)
											
											
						
											
									))
											{
												PatternSetVariables("T", methodtrace,"100%","P2"); 
											}
								
									
						
						
						
						 ITERATION1++; }
							
							
							 MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 		
							 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNSuperclassesPure);
							 System.out.println("===============>PATTERNS 1 AND 2 SUPERCLASSES MIXED  ITERATION MIXED"+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNSuperclassesPure.toString());

							
							
							 
							 
								/*******************************************************************************************************************************************/
								/*******************************************************************************************************************************************/
								/*******************************************************************************************************************************************/	  
				
								PredictionsNewHashMap=InitializePredictionsHashMap(PredictionsNewHashMap, methodtraces2HashMap); 
								 ITERATION1=0; 
								//while(Equals(PredictionsOldHashMap, PredictionsNewHashMap)==false) {
									
									PredictionsOldHashMap=InitializePredictionsHashMap(PredictionsOldHashMap, methodtraces2HashMap); 
							
									
									 MethodTracesHashmapValues = methodtraces2HashMap.values(); 
									for (DatabaseInput methodtrace : MethodTracesHashmapValues) {
										methodtrace.setPrediction("");
									
										List<String> childrenList = methodtrace.getChildrenList(); 
										List<String> ImplementationList = methodtrace.getImplementationList(); 
										List<String> InterfaceList = methodtrace.getInterfaceList(); 
										List<String> SuperclassList = methodtrace.getSuperClassesList(); 
										List<String> methodfields = methodtrace.getPredictionFields(); 
										List<String> methodparams = methodtrace.getPredictionParams(); 
										List<String> methodfieldsOwner = methodtrace.getPredictionFieldsOwnerClass(); 
										List<String> methodparamsOwner = methodtrace.getPredictionParamsOwnerClass(); 
									
										//MY MIXED PATTERNS 
										
										//PATTERN 1	MIXED T
										CountTNE childrenListCount = GenerateCounts(childrenList); 
										CountTNE SuperclassListCount=GenerateCounts(SuperclassList); 
										CountTNE InterfaceListCount = GenerateCounts(InterfaceList); 
										CountTNE ImplementationListCount=GenerateCounts(ImplementationList); 
										CountTNE methodfieldsCount = GenerateCounts(methodfields); 
										CountTNE methodparamsCount=GenerateCounts(methodparams); 
										if(
												
												 (InterfaceListCount.CountN>InterfaceListCount.CountT && InterfaceListCount.CountT>=0)
												||(ImplementationListCount.CountN>ImplementationListCount.CountT && ImplementationListCount.CountT>=0)
												)
										{
											PatternSetVariables("N", methodtrace,"100%","P2"); 
										}
										else	if(
												
												 (ImplementationListCount.CountT>ImplementationListCount.CountN && ImplementationListCount.CountN>=0)
												|| (InterfaceListCount.CountT>InterfaceListCount.CountN && InterfaceListCount.CountN>=0)
												)
											{
												PatternSetVariables("T", methodtrace,"100%","P2"); 
											}
											 
									
											
										
											
								
								
								
								 ITERATION1++; }
									
									
									  MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 		
									 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNInterfacesMixed);
									 System.out.println("===============>PATTERNS 1 AND 2 SUPERCLASSES MIXED  ITERATION MIXED"+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNInterfacesMixed.toString());
							 
									 
										/*******************************************************************************************************************************************/
										/*******************************************************************************************************************************************/
										/*******************************************************************************************************************************************/	  
						
										PredictionsNewHashMap=InitializePredictionsHashMap(PredictionsNewHashMap, methodtraces2HashMap); 
										 ITERATION1=0; 
										//while(Equals(PredictionsOldHashMap, PredictionsNewHashMap)==false) {
											
											PredictionsOldHashMap=InitializePredictionsHashMap(PredictionsOldHashMap, methodtraces2HashMap); 
									
											
											 MethodTracesHashmapValues = methodtraces2HashMap.values(); 
											for (DatabaseInput methodtrace : MethodTracesHashmapValues) {
												methodtrace.setPrediction("");
											
												List<String> childrenList = methodtrace.getChildrenList(); 
												List<String> ImplementationList = methodtrace.getImplementationList(); 
												List<String> InterfaceList = methodtrace.getInterfaceList(); 
												List<String> SuperclassList = methodtrace.getSuperClassesList(); 
												List<String> methodfields = methodtrace.getPredictionFields(); 
												List<String> methodparams = methodtrace.getPredictionParams(); 
												List<String> methodfieldsOwner = methodtrace.getPredictionFieldsOwnerClass(); 
												List<String> methodparamsOwner = methodtrace.getPredictionParamsOwnerClass(); 
											
												//MY MIXED PATTERNS 
												
												//PATTERN 1	MIXED T
												CountTNE childrenListCount = GenerateCounts(childrenList); 
												CountTNE SuperclassListCount=GenerateCounts(SuperclassList); 
												CountTNE InterfaceListCount = GenerateCounts(InterfaceList); 
												CountTNE ImplementationListCount=GenerateCounts(ImplementationList); 
												CountTNE methodfieldsCount = GenerateCounts(methodfields); 
												CountTNE methodparamsCount=GenerateCounts(methodparams); 
												if(
														
														 (InterfaceListCount.CountN>InterfaceListCount.CountT && InterfaceListCount.CountT==0)
														||(ImplementationListCount.CountN>ImplementationListCount.CountT && ImplementationListCount.CountT==0)
														)
												{
													PatternSetVariables("N", methodtrace,"100%","P2"); 
												}	
												else	if(
														
														 (ImplementationListCount.CountT>ImplementationListCount.CountN && ImplementationListCount.CountN==0)
														|| (InterfaceListCount.CountT>InterfaceListCount.CountN && InterfaceListCount.CountN==0)
														)
													{
														PatternSetVariables("T", methodtrace,"100%","P2"); 
													}
													 
											
													
												
													
										
										
										
										 ITERATION1++; }
											
											
											  MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 		
											 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNInterfacesPure);
											 System.out.println("===============>PATTERNS 1 AND 2 SUPERCLASSES MIXED  ITERATION MIXED"+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNInterfacesPure.toString());
									 
									 
										/*******************************************************************************************************************************************/
										/*******************************************************************************************************************************************/
										/*******************************************************************************************************************************************/
										/*******************************************************************************************************************************************/
							 
							 
							 
							 PredictionsNewHashMap=InitializePredictionsHashMap(PredictionsNewHashMap, methodtraces2HashMap); 
				 ITERATION1=0; 
				//while(Equals(PredictionsOldHashMap, PredictionsNewHashMap)==false) {
					
					PredictionsOldHashMap=InitializePredictionsHashMap(PredictionsOldHashMap, methodtraces2HashMap); 
			
					
					 MethodTracesHashmapValues = methodtraces2HashMap.values(); 
					for (DatabaseInput methodtrace : MethodTracesHashmapValues) {
						methodtrace.setPrediction("");
					
						List<String> childrenList = methodtrace.getChildrenList(); 
						List<String> ImplementationList = methodtrace.getImplementationList(); 
						List<String> InterfaceList = methodtrace.getInterfaceList(); 
						List<String> SuperclassList = methodtrace.getSuperClassesList(); 
						List<String> methodfields = methodtrace.getPredictionFields(); 
						List<String> methodparams = methodtrace.getPredictionParams(); 
						List<String> methodfieldsOwner = methodtrace.getPredictionFieldsOwnerClass(); 
						List<String> methodparamsOwner = methodtrace.getPredictionParamsOwnerClass(); 
					
						//MY MIXED PATTERNS 
						
						//PATTERN 1	MIXED T
						CountTNE childrenListCount = GenerateCounts(childrenList); 
						CountTNE SuperclassListCount=GenerateCounts(SuperclassList); 
						CountTNE InterfaceListCount = GenerateCounts(InterfaceList); 
						CountTNE ImplementationListCount=GenerateCounts(ImplementationList); 
						CountTNE methodfieldsCount = GenerateCounts(methodfields); 
						CountTNE methodparamsCount=GenerateCounts(methodparams); 
						if(
								(SuperclassListCount.CountN>SuperclassListCount.CountT && SuperclassListCount.CountT>=0)
								|| (childrenListCount.CountN>childrenListCount.CountT && childrenListCount.CountT>=0)
								|| (InterfaceListCount.CountN>InterfaceListCount.CountT && InterfaceListCount.CountT>=0)
								||(ImplementationListCount.CountN>ImplementationListCount.CountT && ImplementationListCount.CountT>=0)
								)
						{
							PatternSetVariables("N", methodtrace,"100%","P2"); 
						}
						else	if(
								(childrenListCount.CountT>childrenListCount.CountN && childrenListCount.CountN>=0)
								||(SuperclassListCount.CountT>SuperclassListCount.CountN && SuperclassListCount.CountN>=0)
								|| (ImplementationListCount.CountT>ImplementationListCount.CountN && ImplementationListCount.CountN>=0)
								|| (InterfaceListCount.CountT>InterfaceListCount.CountN && InterfaceListCount.CountN>=0)
								)
							{
								PatternSetVariables("T", methodtrace,"100%","P2"); 
							}
							 
					
							
						
							
				
				
				
				 ITERATION1++; }
					
					
					  MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 		
					 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNSuperclassesInterfacesMixed);
					 System.out.println("===============>PATTERNS 1 AND 2 SUPERCLASSES MIXED  ITERATION MIXED"+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNSuperclassesInterfacesMixed.toString());
			 
						/*******************************************************************************************************************************************/
						/*******************************************************************************************************************************************/
						/*******************************************************************************************************************************************/
						/*******************************************************************************************************************************************/
			 
			//PURE PATTERN 
	
			for (DatabaseInput methodtrace : MethodTracesHashmapValues) {
				methodtrace.setPrediction("");
				List<String> superclassesList = methodtrace.getSuperClassesList(); 
				List<String> childrenList = methodtrace.getChildrenList(); 
				List<String> implementationList = methodtrace.getImplementationList(); 
				List<String> interfaceList = methodtrace.getInterfaceList(); 
				CountTNE SuperclassCount = GenerateCounts(superclassesList); 
				CountTNE ChildrenCount = GenerateCounts(childrenList); 
				CountTNE ImplementationCount = GenerateCounts(implementationList); 
				CountTNE InterfaceCount = GenerateCounts(interfaceList); 
				
				//	PURE 
				if(		
						(SuperclassCount.CountN>=1 && SuperclassCount.CountT==0) 
						|| (ChildrenCount.CountN>=1 && ChildrenCount.CountT==0)
						||
						(ImplementationCount.CountN>=1 && ImplementationCount.CountT==0) 
						|| (InterfaceCount.CountN>=1 && InterfaceCount.CountT==0)
						
						) {
					PatternSetVariables("N", methodtrace,"100%","P4"); 
				}
				else	if(			
				(SuperclassCount.CountT>=1 && SuperclassCount.CountN==0 ) 
						|| (ChildrenCount.CountT>=1 && ChildrenCount.CountN==0 ) 
						|| 
						(ImplementationCount.CountT>=1 && ImplementationCount.CountN==0 ) 
						|| (InterfaceCount.CountT>=1 && InterfaceCount.CountN==0 ) 
						
						) {
					PatternSetVariables("T", methodtrace,"100%","P4"); 
				}
				 
				
				
		
		
		

			}
			

			//PRINT 
			
			 MyfinalHashMap = RetrievePredictionsHashMap( methodtraces2); 
			 WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNSuperclassesInterfacesPure);
			System.out.println("===============>PATTERNS SUPERCLASSES PURE ITERATION  "+ITERATION1  +	"   PREDICTION VALUES "+NEWPATTERNSuperclassesInterfacesPure.toString());

			 //END  PRINT 
			ITERATION1++; 
			//System.out.println("HEEEEEEY");
			PredictionsNewHashMap=InitializePredictionsHashMap(PredictionsNewHashMap, methodtraces2HashMap); 
		
		//}
		
		
		
		
		 MyfinalHashMap = RetrievePredictionsHashMap( methodtracesNew); 
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN prediction"); 
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN likelihood");
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN why");
//		st.executeUpdate("ALTER TABLE `traces` ADD prediction LONGTEXT"); 
//		st.executeUpdate("ALTER TABLE `traces` ADD likelihood LONGTEXT");
//		st.executeUpdate("ALTER TABLE `traces` ADD why LONGTEXT");
		
		
		
		WriteInDatabaseAndComputePrecisionAndRecall(MyfinalHashMap, NEWPATTERNSuperclassesPure);
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

			//System.out.println(myvalue.getGold2V2()+"   "+myvalue.getPrediction());
				//st.executeUpdate("UPDATE `traces` SET  +"'WHERE requirementid='"+entry.RequirementID+"' AND method='"+name+"'"); 
			if(myvalue.getGoldfinal()!=null && myvalue.getPrediction()!=null) {
				String Result=nEWPATTERNMethodFields2.ComparePredictionToGold(myvalue.getGoldfinal().trim(), myvalue.getPrediction()); 
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

		TracesTableChessFINALROUND2Superclasses frame = new TracesTableChessFINALROUND2Superclasses();
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



