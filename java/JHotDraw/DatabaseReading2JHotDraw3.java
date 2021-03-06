package JHotDraw;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import Chess.TracesTableChessFINALGeneticAlgorithm;
import Tables.CallerIDName;
import Tables.tracesmethods;
import Tables.tracesmethodscallees;
import JHotDraw.*;
import mypackage.*;
import mypackage.Children2;
import mypackage.ClassDetails2;
import mypackage.ClassField2;
import mypackage.ClassTrace2;
import mypackage.DatabaseReading2;
import mypackage.Implementation2;
import mypackage.Interface;
import mypackage.MethodDetails;
import mypackage.Method;
import mypackage.MethodField2;
import mypackage.MethodTrace2;
import mypackage.MethodTrace;
import mypackage.MethodTraceSubjectTSubjectNOriginal;
import mypackage.Parameter2;
import mypackage.MethodTraceSubjectTSubjectNOriginal;
import mypackage.Requirement;
import mypackage.RequirementClass;
import mypackage.RequirementGold;
import mypackage.SuperClass2;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.CtModel;
import spoon.reflect.factory.ClassFactory;

public class DatabaseReading2JHotDraw3 {
	public static HashMap<Integer, String> classesHashMap = new HashMap<Integer, String>();
	public static List<MethodTrace2> methodtraces2 = null;
	public static List<MethodTrace> methodtraces2SubjectTSubjectN = null;
	public static List<ClassTrace2> classestraces2 = null;
	public static List<Interface> interfaces2 = null;
	public static List<MethodDetails> methodlist = null;
	public static LinkedHashMap<String, ClassTrace2> classesRequirementtraceshashmap=null; 
	public static LinkedHashMap<String, MethodDetails> linkedmethodhashmap=null; 
	public static HashMap<String, List<Interface>> interfacehashmapOwnerClass=null; 
	public static HashMap<String,Interface> interfacehashmapAlreadyImpl=null; 
	public static HashMap<String, List<ClassField2>>  ClassFieldHashMap=null; 
	public static HashMap<String, List<MethodField2>>  MethodFieldHashMap=null; 
	public static HashMap<String, List<Parameter2>>  ParameterhashMap=null; 
	public static HashMap<String, List<Implementation2>> INTERFACEHASHMAPFINAL=null; 
	public static HashMap<String, List<Children2>> childrenHashMap=null; 
	public static HashMap<String, List<SuperClass2>>  SuperclassesHashMap=null; 
	static LinkedHashMap<String, MethodTrace> methodtracehashmap = null; 
	static HashMap<String, List<String>> ClassMethodsHashMap= new HashMap<String, List<String>>(); 
	public static HashMap<Method, HashMap<Requirement, String>> FinalMethodHashMapReqGolds= new HashMap<Method, HashMap<Requirement, String>>() ; 

	/** The name of the MySQL account to use (or empty for anonymous) */
	
	
	
	
	private final String userName = "root";

	public static HashMap<Method, HashMap<Requirement, String>> getFinalMethodHashMapReqGolds() {
		return FinalMethodHashMapReqGolds;
	}

	public static void setFinalMethodHashMapReqGolds(
			HashMap<Method, HashMap<Requirement, String>> finalMethodHashMapReqGolds) {
		FinalMethodHashMapReqGolds = finalMethodHashMapReqGolds;
	}


	public static HashMap<String, List<String>> getClassMethodsHashMap() {
		return ClassMethodsHashMap;
	}

	public static void setClassMethodsHashMap(HashMap<String, List<String>> classMethodsHashMap) {
		ClassMethodsHashMap = classMethodsHashMap;
	}

	public static HashMap<Integer, String> getClassesHashMap() {
		return classesHashMap;
	}

	public static void setClassesHashMap(HashMap<Integer, String> classesHashMap) {
		DatabaseReading2JHotDraw3.classesHashMap = classesHashMap;
	}

	public static List<Interface> getInterfaces2() {
		return interfaces2;
	}

	public static void setInterfaces2(List<Interface> interfaces2) {
		DatabaseReading2JHotDraw3.interfaces2 = interfaces2;
	}

	public static HashMap<String, List<Parameter2>> getParameterhashMap() {
		return ParameterhashMap;
	}

	public static void setParameterhashMap(HashMap<String, List<Parameter2>> parameterhashMap) {
		ParameterhashMap = parameterhashMap;
	}

	public static HashMap<String, List<Implementation2>> getINTERFACEHASHMAPFINAL() {
		return INTERFACEHASHMAPFINAL;
	}

	public static void setINTERFACEHASHMAPFINAL(HashMap<String, List<Implementation2>> iNTERFACEHASHMAPFINAL) {
		INTERFACEHASHMAPFINAL = iNTERFACEHASHMAPFINAL;
	}

	public static HashMap<String, List<Children2>> getChildrenHashMap() {
		return childrenHashMap;
	}

	public static void setChildrenHashMap(HashMap<String, List<Children2>> childrenHashMap) {
		DatabaseReading2JHotDraw3.childrenHashMap = childrenHashMap;
	}

	public static void setMethodtracehashmap(LinkedHashMap<String, MethodTrace> methodtracehashmap) {
		DatabaseReading2JHotDraw3.methodtracehashmap = methodtracehashmap;
	}

	public static List<MethodDetails> getMethodlist() {
		return methodlist;
	}

	public static LinkedHashMap<String, MethodDetails> getLinkedmethodhashmap() {
		return linkedmethodhashmap;
	}

	public static void setLinkedmethodhashmap(LinkedHashMap<String, MethodDetails> linkedmethodhashmap) {
		DatabaseReading2JHotDraw3.linkedmethodhashmap = linkedmethodhashmap;
	}

	public static void setMethodlist(List<MethodDetails> methodlist) {
		DatabaseReading2JHotDraw3.methodlist = methodlist;
	}

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "root";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */

	private final int portNumber = 3306;

	public static List<ClassTrace2> getClassestraces2() {
		return classestraces2;
	}

	public static void setClassestraces2(List<ClassTrace2> classestraces2) {
		DatabaseReading2JHotDraw3.classestraces2 = classestraces2;
	}

	/**
	 * The name of the database we are testing with (this default is installed with
	 * MySQL)
	 */
	private final String dbName = "databasejhotdraw";

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("root", this.userName);
		connectionProps.put("123456", this.password);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasejhotdraw", "root", "123456");
		SpoonAPI spoon = new Launcher();
		spoon.addInputResource("C:\\Users\\mouna\\ownCloud\\Share\\jHotDraw_sources\\src_jhotdraw");
		spoon.getEnvironment().setAutoImports(true);
		spoon.getEnvironment().setNoClasspath(true);

		// Interact with model

		return conn;
	}

	public static void main(String[] args) throws SQLException, IOException {
		MakePredictions();

	}
	/**
	 * @throws SQLException 
	 * @throws IOException ***********************************************************************************************************************/
	public static void MakePredictions() throws SQLException, IOException {
		Connection conn = null;
		DatabaseReading2JHotDraw3 DatabaseReading = new DatabaseReading2JHotDraw3();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
		int index = 0;
		mypackage.Clazz classrep = new mypackage.Clazz();


		///////////////////////////////////////////////////////////////////////////////////////
		MethodDetails methoddet2 = new MethodDetails();
		HashMap<String, MethodDetails> methodhashmap = methoddet2.ReadClassesRepresentations2(conn);
		List<MethodDetails> methodlist = new ArrayList<MethodDetails>(methodhashmap.values());
		setMethodlist(methodlist);
		
		///////////////////////////////////////////////////////////////////////////////////////
		 LinkedHashMap<String, MethodDetails> linkedmethodhashmap = methoddet2.ReadClassesRepresentations2(conn);
		List<MethodDetails> methodlistlinked = new ArrayList<MethodDetails>(linkedmethodhashmap.values());
		setLinkedmethodhashmap(linkedmethodhashmap);
		///////////////////////////////////////////////////////////////////////////////////////
		ClassDetails2 classdet2 = new ClassDetails2();
		HashMap<Integer, ClassDetails2> classhashmap = classdet2.ReadClassesRepresentations(conn);
		List<ClassDetails2> classlist = new ArrayList<ClassDetails2>(classhashmap.values());
		///////////////////////////////////////////////////////////////////////////////////////

		ClassTrace2 myclasstrace2 = new ClassTrace2();
		HashMap<Integer, ClassTrace2> classtracehashmap = myclasstrace2.ReadClassesRepresentations(conn);
		List<ClassTrace2> classtraces = new ArrayList<ClassTrace2>(classtracehashmap.values());


		
		//SWITCHED TO MethodTraceSubjectTSubjectN
		MethodTrace methodtrace2 = new MethodTrace();
		LinkedHashMap<String, MethodTrace> methodtracehashmap = methodtrace2.ReadMethodTraces(conn, ClassMethodsHashMap, FinalMethodHashMapReqGolds);
		List<MethodTrace> methodtraces = new ArrayList<MethodTrace>(methodtracehashmap.values());
		setMethodtraces2SubjectTSubjectN(methodtraces);
		setMethodtracehashmap(methodtracehashmap); 
		///////////////////////////////////////////////////////////////////////////////////////
		
		
		
		///////////////////////////////////////////////////////////////////////////////////////
		ClassTrace2 classtrace2= new ClassTrace2(); 
		classesRequirementtraceshashmap = classtrace2.ReadClassesRepresentationsRequirementClass(conn); 
		List<ClassTrace2> classestracesRequirementClass = new ArrayList<ClassTrace2>(classesRequirementtraceshashmap.values());
		setClassestraces2(classestracesRequirementClass);
		///////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////
		Interface myinterface2= new Interface(); 
		interfacehashmapOwnerClass = myinterface2.ReadInterfacesRepresentations(conn);
//		List<Interface2>  myinterfaces = new ArrayList<Interface2>(interfacehashmapOwnerClass.values());
		setInterfacehashmapOwnerClass(interfacehashmapOwnerClass);
		///////////////////////////////////////////////////////////////////////////////////////
				
		///////////////////////////////////////////////////////////////////////////////////////
		interfacehashmapAlreadyImpl = myinterface2.ReadInterfacesRepresentationsAlreadyImpl(conn);
		setInterfaces(interfacehashmapAlreadyImpl);
		///////////////////////////////////////////////////////////////////////////////////////
		ClassField2 classfield= new ClassField2(); 
		 HashMap<String, List<ClassField2>> myclassfields = classfield.ReadClassFields(conn); 
		setClassFieldHashMap(myclassfields);
		///////////////////////////////////////////////////////////////////////////////////////
		MethodField2 methodfield= new MethodField2(); 
		 HashMap<String, List<MethodField2>> mymethodfields = methodfield.ReadMethodFields(conn); 
		setMethodFieldHashMap(mymethodfields);
		
		
		///////////////////////////////////////////////////////////////////////////////////////
		Parameter2 parameter= new Parameter2(); 
		 HashMap<String, List<Parameter2>> myparams = parameter.ReadParams(conn) ; 
		setParameterhashMap(myparams);
		///////////////////////////////////////////////////////////////////////////////////////
		SuperClass2 superclass= new SuperClass2(); 
		 HashMap<String, List<SuperClass2>> mysuperclasses = superclass.ReadSuperClasses(conn);  
		setSuperclassesHashMap(mysuperclasses);
		/////////////////////////////////////////////
		
		
		///////////////////////////////////////////////////////////////////////////////////////
		Implementation2 myimplementation= new Implementation2(); 
		HashMap<String, List<Implementation2>> myimplementations = myimplementation.ReadImplementationsRepresentations(conn); 
		setINTERFACEHASHMAPFINAL(myimplementations);
		
		///////////////////////////////////////////////////////////////////////////////////////
		Children2 children2= new Children2(); 
		HashMap<String, List<Children2>> mychildren = children2.ReadChildren(conn); 
		setChildrenHashMap(mychildren);
		/////////////////////////////////////////////




		System.out.println("MOUNA");
		System.out.println("MOUNA");
		
	
	}

	

	public static LinkedHashMap<String, MethodTrace> getMethodtracehashmap() {
		return methodtracehashmap;
	}

	

	public static void setInterfaces(HashMap ínterfacehashmap) {
		// TODO Auto-generated method stub
		DatabaseReading2JHotDraw3.interfacehashmapAlreadyImpl=ínterfacehashmap;
		
	}
	

	public static HashMap  getInterfaces() {
		// TODO Auto-generated method stub
		return interfacehashmapAlreadyImpl;
		
	}

	public static void setClassesRequirementtraceshashmap(
			LinkedHashMap<String, ClassTrace2> classesRequirementtraceshashmap) {
		DatabaseReading2JHotDraw3.classesRequirementtraceshashmap = classesRequirementtraceshashmap;
	}

	public static List<MethodTrace2> getMethodtraces2() {
		return methodtraces2;
	}

	public static void setMethodtraces2(List<MethodTrace2> methodtraces2) {
		DatabaseReading2JHotDraw3.methodtraces2 = methodtraces2;
	}
	
	
	public static List<MethodTrace> getMethodtraces2SubjectTSubjectN() {
		return methodtraces2SubjectTSubjectN;
	}

	public static void setMethodtraces2SubjectTSubjectN(List<MethodTrace> methodtraces) {
		DatabaseReading2JHotDraw3.methodtraces2SubjectTSubjectN = methodtraces;
	}

	public static LinkedHashMap<String, ClassTrace2> getClassesRequirementtraceshashmap() {
		return classesRequirementtraceshashmap;
	}

	public static HashMap<String, Interface> getInterfacehashmapAlreadyImpl() {
		return interfacehashmapAlreadyImpl;
	}

	public static void setInterfacehashmapAlreadyImpl(HashMap<String, Interface> interfacehashmapAlreadyImpl) {
		DatabaseReading2JHotDraw3.interfacehashmapAlreadyImpl = interfacehashmapAlreadyImpl;
	}

	public static HashMap<String, List<Interface>> getInterfacehashmapOwnerClass() {
		return interfacehashmapOwnerClass;
	}

	public static void setInterfacehashmapOwnerClass(HashMap<String, List<Interface>> interfacehashmapOwnerClass) {
		DatabaseReading2JHotDraw3.interfacehashmapOwnerClass = interfacehashmapOwnerClass;
	}

	public static HashMap<String, List<ClassField2>> getClassFieldHashMap() {
		return ClassFieldHashMap;
	}

	public static void setClassFieldHashMap(HashMap<String, List<ClassField2>> classFieldHashMap) {
		ClassFieldHashMap = classFieldHashMap;
	}

	public static HashMap<String, List<MethodField2>> getMethodFieldHashMap() {
		return MethodFieldHashMap;
	}

	public static void setMethodFieldHashMap(HashMap<String, List<MethodField2>> methodFieldHashMap) {
		MethodFieldHashMap = methodFieldHashMap;
	}

	public static HashMap<String, List<SuperClass2>> getSuperclassesHashMap() {
		return SuperclassesHashMap;
	}

	public static void setSuperclassesHashMap(HashMap<String, List<SuperClass2>> superclassesHashMap) {
		SuperclassesHashMap = superclassesHashMap;
	}

	

	
	
	
	
	
}