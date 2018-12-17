package ALGO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

import mypackage.Children2;
import mypackage.ClassDetails2;
import mypackage.ClassField2;
import mypackage.ClassTrace2;
import mypackage.Implementation2;
import mypackage.Interface2;
import mypackage.Method;
import mypackage.Method2Details;
import mypackage.MethodField2;
import mypackage.MethodTrace;
import mypackage.MethodTrace2;
import mypackage.Parameter2;
import mypackage.Requirement2;
import mypackage.SuperClass2;
import spoon.Launcher;
import spoon.SpoonAPI;

public class DatabaseReading {
	private final String userName = "root";
	private final String password = "123456";
	String ProgramName=""; 
	public static List<MethodTrace> methodtracesList = null;

	static LinkedHashMap<String, MethodTrace> methodtracehashmap = null; 
	static HashMap<String, List<String>> ClassMethodsHashMap= new HashMap<String, List<String>>(); 
	public static HashMap<Method, HashMap<Requirement2, String>> FinalMethodHashMapReqGolds= new HashMap<Method, HashMap<Requirement2, String>>() ; 
	public Connection getConnection(String programName) throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("root", this.userName);
		connectionProps.put("123456", this.password);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database"+programName, "root", "123456");
	

		// Interact with model

		return conn;
	}
	
	
	public DatabaseReading(String ProgramName) throws SQLException {
		this.ProgramName=ProgramName; 
		Connection conn=getConnection(ProgramName); 
		




		
		//SWITCHED TO MethodTraceSubjectTSubjectN
		MethodTrace methodtrace2 = new MethodTrace();
		LinkedHashMap<String, MethodTrace> methodtracehashmap = methodtrace2.ReadMethodTraces(conn, ClassMethodsHashMap, FinalMethodHashMapReqGolds);
		List<MethodTrace> methodtraces = new ArrayList<MethodTrace>(methodtracehashmap.values());
		setMethodtracesList(methodtraces);
		setMethodtracehashmap(methodtracehashmap); 
		///////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
	}


	public static List<MethodTrace> getMethodtracesList() {
		return methodtracesList;
	}


	public static void setMethodtracesList(List<MethodTrace> methodtracesList) {
		DatabaseReading.methodtracesList = methodtracesList;
	}


	public String getProgramName() {
		return ProgramName;
	}


	public void setProgramName(String programName) {
		ProgramName = programName;
	}


	

	public static LinkedHashMap<String, MethodTrace> getMethodtracehashmap() {
		return methodtracehashmap;
	}


	public static void setMethodtracehashmap(LinkedHashMap<String, MethodTrace> methodtracehashmap) {
		DatabaseReading.methodtracehashmap = methodtracehashmap;
	}


	public static HashMap<String, List<String>> getClassMethodsHashMap() {
		return ClassMethodsHashMap;
	}


	public static void setClassMethodsHashMap(HashMap<String, List<String>> classMethodsHashMap) {
		ClassMethodsHashMap = classMethodsHashMap;
	}


	public static HashMap<Method, HashMap<Requirement2, String>> getFinalMethodHashMapReqGolds() {
		return FinalMethodHashMapReqGolds;
	}


	public static void setFinalMethodHashMapReqGolds(
			HashMap<Method, HashMap<Requirement2, String>> finalMethodHashMapReqGolds) {
		FinalMethodHashMapReqGolds = finalMethodHashMapReqGolds;
	}


	public String getUserName() {
		return userName;
	}


	public String getPassword() {
		return password;
	}
	
	
}
