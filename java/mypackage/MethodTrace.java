package mypackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import ALGO.MethodList;
import ALGO.Methods;
import Chess.LogInfo;
import spoon.pattern.internal.SubstitutionRequestProvider;

public class MethodTrace {
	public static boolean modified = false;
	public Method Method;
	public Requirement2 Requirement;
	public Clazz Clazz;
	public String gold;
	public String subject;
	public String goldprediction;
	public String goldpredictionCaller;
	public String goldpredictionCallee;
	public String goldfinal;
	public String SubjectT;
	public String SubjectN;
	public String gold3;
	public String gold4;
	public String goldAtLeast2;
	public String gold6;
	Method methodrep2 = new Method();

	public void setPrediction(String prediction) {
		this.prediction = prediction;
	}

	String prediction;
	String prediction2;
	String likelihood;
	String why;
	boolean myflag;
	boolean SubjectDeveloperEqualityFlag;
	List<MethodField2> MethodFieldT;
	List<MethodField2> MethodFieldN;
	List<MethodField2> MethodFieldE;

	List<Parameter2> ParameterListT;
	List<Parameter2> ParameterListN;
	List<Parameter2> ParameterListE;

	List<String> PredictionParams;
	List<String> PredictionParamsOwnerClass;
	List<String> PredictionFields;
	List<String> PredictionFieldsOwnerClass;
	List<String> SuperClassesList;
	List<String> InterfaceList;
	List<String> ChildrenList;
	List<String> ImplementationList;

	public MethodList CalleeList;
	public MethodList PredictionCallerList;

	Methods<String> Interfaces;
	Methods<String> Implementations;
	Methods<String> Superclasses;
	Methods<String> Children;
	boolean TraceSet; 
	public boolean isMyflag() {
		return myflag;
	}

	public boolean isTraceSet() {
		return TraceSet;
	}

	public void setTraceSet(boolean traceSet) {
		TraceSet = traceSet;
	}

	public void setMyflag(boolean myflag) {
		this.myflag = myflag;
	}

	public boolean isSubjectDeveloperEqualityFlag() {
		return SubjectDeveloperEqualityFlag;
	}

	public void setSubjectDeveloperEqualityFlag(boolean subjectDeveloperEqualityFlag) {
		SubjectDeveloperEqualityFlag = subjectDeveloperEqualityFlag;
	}

	public MethodList getCallees() {
		return CalleeList;
	}

	public void setPredictionCalleeList(MethodList predictionCalleeList) {

		CalleeList = predictionCalleeList;
	}

	public MethodList getCallers() {
		return PredictionCallerList;
	}

	public void setPredictionCallerList(MethodList predictionCallerList) {
		PredictionCallerList = predictionCallerList;
	}

	public Methods<String> getInterfaces() {
		return Interfaces;
	}

	public void setInterfaces(Methods<String> interfaces) {
		Interfaces = interfaces;
	}

	public Methods<String> getImplementations() {
		return Implementations;
	}

	public void setImplementations(Methods<String> implementations) {
		Implementations = implementations;
	}

	public Methods<String> getSuperclasses() {
		return Superclasses;
	}

	public void setSuperclasses(Methods<String> superclasses) {
		Superclasses = superclasses;
	}

	public Methods<String> getChildren() {
		return Children;
	}

	public void setChildren(Methods<String> children) {
		Children = children;
	}

	MethodList callersList = new MethodList();
	MethodList calleesList = new MethodList();
	List<Method> callersListExecuted = new ArrayList<Method>();
	List<Method> calleesListExecuted = new ArrayList<Method>();
	HashMap<String, List<Interface2>> ImplementationHashMap = new HashMap<String, List<Interface2>>();
	HashMap<String, List<Interface2>> InterfaceHashMap = new HashMap<String, List<Interface2>>();
	HashMap<String, List<Interface2>> InterfaceHashMapFinal = new HashMap<String, List<Interface2>>();
	
	
	HashMap<String, List<SuperClass2>> SuperClassHashMap= new HashMap<String, List<SuperClass2> >(); 
	HashMap<String, List<SuperClass2>> ChildrenHashMap= new HashMap<String, List<SuperClass2>>(); 

	HashMap<String, Method2Details> MethodHashMap = new HashMap<String, Method2Details>();
	HashMap<String, HashMap<String, Method2Details>> MethodHashMapNameKey = new HashMap<String,HashMap<String, Method2Details>>();

	HashMap<String, Clazz> ClassHashMap = new HashMap<String, Clazz>();
	HashMap<String, Clazz> classTraceHashMap = new HashMap<String, Clazz>();

	HashMap<String, List<MethodCalls>> MethodCallsHashMapCaller = new HashMap<String, List<MethodCalls>>();
	HashMap<String, List<Parameter2>> ParameterHashMap = new HashMap<String, List<Parameter2>>();
	HashMap<String, List<MethodField2>> MethodFieldsHashMap = new HashMap<String, List<MethodField2>>();

	HashMap<String, List<MethodCalls>> MethodCallsHashMapCallee = new HashMap<String, List<MethodCalls>>();

	HashMap<String, List<MethodCalls>> MethodCallsEXECHashMapCaller = new HashMap<String, List<MethodCalls>>();
	HashMap<String, List<MethodCalls>> MethodCallsEXECHashMapCallee = new HashMap<String, List<MethodCalls>>();
	HashMap<String, List<MethodTrace2>> MethodTrace2HashMap = new HashMap<String, List<MethodTrace2>>();
	Methods<String> SuperClassesListMethodTraces;
	Methods<String> InterfaceListMethodTraces;
	Methods<String> ChildrenListMethodTraces;
	Methods<String> ImplementationListMethodTraces;

	public Methods<String> getSuperClassesFinalList() {
		return SuperClassesListMethodTraces;
	}

	public void setSuperClassesListMethodTraces(List<String> superClassesListMethodTraces) {
		SuperClassesListMethodTraces = new Methods<String>();
		SuperClassesListMethodTraces.addAll(superClassesListMethodTraces);
	}

	public Methods<String> getInterfacesFinalList() {
		return InterfaceListMethodTraces;
	}

	public void setInterfaceListMethodTraces(List<String> interfaceListMethodTraces) {
		InterfaceListMethodTraces = new Methods<String>();
		InterfaceListMethodTraces.addAll(interfaceListMethodTraces);
	}

	public Methods<String> getChildrenFinalList() {
		return ChildrenListMethodTraces;
	}

	public void setChildrenListMethodTraces(List<String> childrenListMethodTraces) {

		ChildrenListMethodTraces = new Methods<String>();
		ChildrenListMethodTraces.addAll(childrenListMethodTraces);
	}

	public Methods<String> getImplementationFinalList() {
		return ImplementationListMethodTraces;
	}

	public void setImplementationListMethodTraces(List<String> implementationListMethodTraces) {

		ImplementationListMethodTraces = new Methods<String>();
		ImplementationListMethodTraces.addAll(implementationListMethodTraces);
	}

	public List<String> getPredictionParamsOwnerClass() {
		return PredictionParamsOwnerClass;
	}

	public void setPredictionParamsOwnerClass(List<String> predictionParamsOwnerClass) {
		PredictionParamsOwnerClass = predictionParamsOwnerClass;
	}

	public List<String> getSuperClassesList() {
		return SuperClassesList;
	}

	public void setSuperClassesList(List<String> superClassesList) {
		SuperClassesList = superClassesList;
	}

	public List<String> getInterfaceList() {
		return InterfaceList;
	}

	public void setInterfaceList(List<String> interfaceList) {
		InterfaceList = interfaceList;
	}

	public List<String> getChildrenList() {
		return ChildrenList;
	}

	public String getGoldAtLeast2() {
		return goldAtLeast2;
	}

	public void setGoldAtLeast2(String goldAtLeast2) {
		this.goldAtLeast2 = goldAtLeast2;
	}

	public String getGold6() {
		return gold6;
	}

	public void setGold6(String gold6) {
		this.gold6 = gold6;
	}

	public void setChildrenList(List<String> childrenList) {
		ChildrenList = childrenList;
	}

	public List<String> getImplementationList() {
		return ImplementationList;
	}

	public void setImplementationList(List<String> implementationList) {
		ImplementationList = implementationList;
	}

	public List<Parameter2> getParameterListT() {
		return ParameterListT;
	}

	public List<String> getPredictionFieldsOwnerClass() {
		return PredictionFieldsOwnerClass;
	}

	public void setPredictionFieldsOwnerClass(List<String> predictionFieldsOwnerClass) {
		PredictionFieldsOwnerClass = predictionFieldsOwnerClass;
	}

	public void setParameterListT(List<Parameter2> parameterListT) {
		ParameterListT = parameterListT;
	}

	public List<Parameter2> getParameterListN() {
		return ParameterListN;
	}

	public void setParameterListN(List<Parameter2> parameterListN) {
		ParameterListN = parameterListN;
	}

	public List<Parameter2> getParameterListE() {
		return ParameterListE;
	}

	public void setParameterListE(List<Parameter2> parameterListE) {
		ParameterListE = parameterListE;
	}

	public List<MethodField2> getMethodFieldT() {
		return MethodFieldT;
	}

	public List<String> getPredictionParams() {
		return PredictionParams;
	}

	public void setPredictionParams(List<String> predictionParams) {
		PredictionParams = predictionParams;
	}

	public List<String> getPredictionFields() {
		return PredictionFields;
	}

	public void setPredictionFields(List<String> predictionFields) {
		PredictionFields = predictionFields;
	}

	public void setMethodFieldT(List<MethodField2> methodFieldT) {
		MethodFieldT = methodFieldT;
	}

	public List<MethodField2> getMethodFieldN() {
		return MethodFieldN;
	}

	public void setMethodFieldN(List<MethodField2> methodFieldN) {
		MethodFieldN = methodFieldN;
	}

	public List<MethodField2> getMethodFieldE() {
		return MethodFieldE;
	}

	public void setMethodFieldE(List<MethodField2> methodFieldE) {
		MethodFieldE = methodFieldE;
	}

	public String getPrediction() {
		return prediction;
	}


	public String getPrediction2() {
		return prediction2;
	}

	public void setPrediction2(String prediction2) {
		this.prediction2 = prediction2;
	}

	public String getLikelihood() {
		return likelihood;
	}

	public void setLikelihood(String likelihood) {
		this.likelihood = likelihood;
	}

	public String getWhy() {
		return why;
	}

	public void setWhy(String why) {
		this.why = why;
	}

	public String getGold3() {
		return gold3;
	}

	public void setGold3(String gold3) {
		this.gold3 = gold3;
	}

	public String getGold4() {
		return gold4;
	}

	public void setGold4(String gold4) {
		this.gold4 = gold4;
	}

	public String getGoldfinal() {
		return goldfinal;
	}

	public void setGoldfinal(String goldfinal) {
		this.goldfinal = goldfinal;
	}

	public String getGoldpredictionCaller() {
		return goldpredictionCaller;
	}

	public void setGoldpredictionCaller(String goldpredictionCaller) {
		this.goldpredictionCaller = goldpredictionCaller;
	}

	public String getGoldpredictionCallee() {
		return goldpredictionCallee;
	}

	public void setGoldpredictionCallee(String goldpredictionCallee) {
		this.goldpredictionCallee = goldpredictionCallee;
	}

	public MethodList getCallersList() {
		return callersList;
	}

	public String getSubjectT() {
		return SubjectT;
	}

	public void setSubjectT(String subjectT) {
		SubjectT = subjectT;
	}

	public String getSubjectN() {
		return SubjectN;
	}

	public void setSubjectN(String subjectN) {
		SubjectN = subjectN;
	}

	public void setCallersList(MethodList callersList) {
		this.callersList = callersList;
	}

	public MethodList getCalleesList() {
		return calleesList;
	}

	public void setCalleesList(MethodList calleesList) {
		this.calleesList = calleesList;
	}

	public List<Method> getCallersListExecuted() {
		return callersListExecuted;
	}

	public void setCallersListExecuted(List<Method> callersListExecuted) {
		this.callersListExecuted = callersListExecuted;
	}

	public List<Method> getCalleesListExecuted() {
		return calleesListExecuted;
	}

	public void setCalleesListExecuted(List<Method> calleesListExecuted) {
		this.calleesListExecuted = calleesListExecuted;
	}

	public ArrayList<MethodTrace> getMethodtraces() {
		return methodtraces;
	}

	public void setMethodtraces(ArrayList<MethodTrace> methodtraces) {
		this.methodtraces = methodtraces;
	}

	public HashMap<Integer, MethodTrace> getMethodtraceHashMap() {
		return methodtraceHashMap;
	}

	public void setMethodtraceHashMap(HashMap<Integer, MethodTrace> methodtraceHashMap) {
		this.methodtraceHashMap = methodtraceHashMap;
	}

	public ArrayList<MethodTrace> methodtraces;

	public String getGoldprediction() {
		return goldprediction;
	}

	public void setGoldprediction(String goldprediction) {
		this.goldprediction = goldprediction;
	}

	HashMap<Integer, MethodTrace> methodtraceHashMap = new HashMap<Integer, MethodTrace>();
	LinkedHashMap<String, MethodTrace> methodtraceHashMap2 = new LinkedHashMap<String, MethodTrace>();

	public MethodTrace() {
		super();
	}

	public Method getMethod() {
		return Method;
	}

	public void setMethod(Method method) {
		Method = method;
	}

	public Requirement2 getRequirement() {
		return Requirement;
	}

	public void setRequirement(Requirement2 requirement) {
		Requirement = requirement;
	}

	public Clazz getClassRepresentation() {
		return Clazz;
	}

	public void setClassRepresentation(Clazz classRepresentation) {
		Clazz = classRepresentation;
	}

	public String getGold() {
		return gold;
	}

	public void setGold(String gold) {
		this.gold = gold;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public MethodTrace(Method Method, Requirement2 requirement,
			Clazz classRepresentation, String gold, String subject) {
		super();
		Method = Method;
		Requirement = requirement;
		Clazz = classRepresentation;
		this.gold = gold;
		this.subject = subject;
	}

	

	public HashMap<String, List<Interface2>> CreateImplementationsHashMap(Connection conn) throws SQLException {
		Statement st = conn.createStatement();

		ResultSet var = st.executeQuery("select count(*) from interfaces");

		ResultSet myinterfaces = st.executeQuery("select interfaces.* from interfaces ");

		List<Interface2> mylist = new ArrayList<Interface2>();
		ImplementationHashMap=  new HashMap<String, List<Interface2>>();
		while (myinterfaces.next()) {
			Interface2 myinterface = new Interface2();
			Clazz myclassrepinterface = new Clazz();
			Clazz myimplementation = new Clazz();
			myclassrepinterface.setClassid(myinterfaces.getString("interfaceclassid"));
			myclassrepinterface.setClassname(myinterfaces.getString("interfacename"));

			myimplementation.setClassid(myinterfaces.getString("ownerclassid"));
			myimplementation.setClassname(myinterfaces.getString("classname"));
			myinterface.setInterfaceClass(myclassrepinterface);
			myinterface.setImplementation(myimplementation);
			String key1 = myclassrepinterface.getClassid();
			String key2 = myimplementation.getClassid();
			if (ImplementationHashMap.get(key1) != null) {
				mylist = ImplementationHashMap.get(key1);
			} else {
				mylist = new ArrayList<Interface2>();
			}
			mylist.add(myinterface);
			ImplementationHashMap.put(key1, mylist);
			
		}

		return ImplementationHashMap;

	}

	
	
	
	public HashMap<String, List<Interface2>> CreateInterfacesHashMap(Connection conn) throws SQLException {
		Statement st = conn.createStatement();
		int index = 1;
		int count = 1;
		ResultSet var = st.executeQuery("select count(*) from interfaces");
		while (var.next()) {
			count = var.getInt(1);
		}
		
		InterfaceHashMap = new HashMap<String, List<Interface2>>();
		ResultSet myinterfaces = st.executeQuery("select interfaces.* from interfaces ");

	
			List<Interface2> mylist = new ArrayList<Interface2>();

			while (myinterfaces.next()) {
				Interface2 myinterface = new Interface2();
				Clazz myclassrepinterface = new Clazz();
				Clazz ownerclass = new Clazz();
				myclassrepinterface.setClassid(myinterfaces.getString("interfaceclassid"));
				myclassrepinterface.setClassname(myinterfaces.getString("interfacename"));

				ownerclass.setClassid(myinterfaces.getString("ownerclassid"));
				ownerclass.setClassname(myinterfaces.getString("classname"));
				myinterface.setInterfaceClass(myclassrepinterface);
				myinterface.setImplementation(ownerclass);
				String key1 = myclassrepinterface.getClassid();
				String key2 = ownerclass.getClassid();
				if (InterfaceHashMap.get(key2) != null) {
					mylist = InterfaceHashMap.get(key2);
				} else {
					mylist = new ArrayList<Interface2>();
				}
				mylist.add(myinterface);
				InterfaceHashMap.put(key2, mylist);

			}
			
	
		return InterfaceHashMap;

	}

	
	public HashMap<String, List<SuperClass2>> CreateSuperClassesHashMap(Connection conn) throws SQLException {

		Statement st = conn.createStatement();
		int index = 1;
		int count = 1;
		ResultSet var = st.executeQuery("select count(*) from superclasses");
		while (var.next()) {
			count = var.getInt(1);
		}
		
		SuperClassHashMap = new HashMap<String, List<SuperClass2>>();
		ResultSet mysuperclasses = st.executeQuery("select superclasses.* from superclasses ");

	
			List<SuperClass2> mylist = new ArrayList<SuperClass2>();

			while (mysuperclasses.next()) {
				SuperClass2 superclass = new SuperClass2();
				Clazz mysuperclass = new Clazz();
				Clazz mychild = new Clazz();
				mysuperclass.setClassid(mysuperclasses.getString("superclassid"));
				mysuperclass.setClassname(mysuperclasses.getString("superclassname"));

				
				superclass.setSuperClass(mysuperclass);
				
				
				String key1 =mysuperclasses.getString("ownerclassid").trim();
			
				if (SuperClassHashMap.get(key1) != null) {
					mylist = SuperClassHashMap.get(key1);
				} else {
					mylist = new ArrayList<SuperClass2>();
				}
				mylist.add(superclass);
				SuperClassHashMap.put(key1, mylist);

			}
			
	
		return SuperClassHashMap;

	
		
		
	}
	
	
	public HashMap<String, List<SuperClass2>> CreateChildrenHashMap(Connection conn) throws SQLException {
		

		Statement st = conn.createStatement();
		int index = 1;
		int count = 1;
		ResultSet var = st.executeQuery("select count(*) from superclasses");
		while (var.next()) {
			count = var.getInt(1);
		}
		
		ChildrenHashMap = new HashMap<String, List<SuperClass2>>();
		ResultSet mysuperclasses = st.executeQuery("select superclasses.* from superclasses ");

	
			List<SuperClass2> mylist = new ArrayList<SuperClass2>();

			while (mysuperclasses.next()) {
				SuperClass2 superclass = new SuperClass2();
				Clazz mysuperclass = new Clazz();
				Clazz mychild = new Clazz();
				

				mychild.setClassid(mysuperclasses.getString("ownerclassid"));
				mychild.setClassname(mysuperclasses.getString("childclassname"));
				superclass.setOwnerClass(mychild);
				
				
				String key1 = mysuperclasses.getString("superclassid").trim();
			
				if (ChildrenHashMap.get(key1) != null) {
					mylist = ChildrenHashMap.get(key1);
				} else {
					mylist = new ArrayList<SuperClass2>();
				}
				mylist.add(superclass);
				ChildrenHashMap.put(key1, mylist);

			}
			
	
		return ChildrenHashMap;

	
		
		
		
	}
	public HashMap<String, List<Parameter2>> CreateParametersHashMap(Connection conn) throws SQLException {
		Statement st = conn.createStatement();
		int index = 1;
		int count = 1;
		ResultSet var = st.executeQuery("select count(*) from parameters");
		while (var.next()) {
			count = var.getInt(1);
		}
		ResultSet parameters = st.executeQuery("select parameters.* from parameters where id='" + index + "'");

		while (index < count) {
			List<Parameter2> parametersList = new ArrayList<Parameter2>();
			while (parameters.next()) {
				Parameter2 param = new Parameter2();
				String parametername = parameters.getString("parametername");
				String parametertype = parameters.getString("parametertype");
				String parameterclass = parameters.getString("parameterclass");
				String classid = parameters.getString("classid");
				String classname = parameters.getString("classname");
				String methodid = parameters.getString("methodid");
				String methodname = parameters.getString("methodname");
				String isreturn = parameters.getString("isreturn");

				param.setParameterName(parametername);
				Clazz ParamType = new Clazz();
				ParamType.setClassid(parameterclass);
				ParamType.setClassname(parametertype);
				param.setParameterType(ParamType);

				Clazz OwnerType = new Clazz();
				OwnerType.setClassid(parameters.getString("classid"));
				OwnerType.setClassname(parameters.getString("classname"));
				param.setOwnerClass(OwnerType);

				param.setMethodname(parameters.getString("methodname"));

				param.setIsReturn(parameters.getString("isreturn"));

				if (ParameterHashMap.get(methodid) != null) {
					parametersList = ParameterHashMap.get(methodid);
				}

				parametersList.add(param);
				ParameterHashMap.put(methodid, parametersList);

			}
			index++;
			parameters = st.executeQuery("select parameters.* from parameters where id='" + index + "'");
		}

		return ParameterHashMap;

	}

	public HashMap<String, List<MethodField2>> CreateFieldtypeHashMap(Connection conn) throws SQLException {
		Statement st = conn.createStatement();
		int index = 1;
		int count = 1;
		ResultSet var = st.executeQuery("select count(*) from fieldmethods");
		while (var.next()) {
			count = var.getInt(1);
		}
		ResultSet methodFields = st.executeQuery("select fieldmethods.* from fieldmethods where id='" + index + "'");

		while (index < count) {
			List<MethodField2> methodfieldsList = new ArrayList<MethodField2>();
			while (methodFields.next()) {
				MethodField2 methfield = new MethodField2();
				methfield.setFieldName(methodFields.getString("fieldaccess"));

				Clazz FieldType = new Clazz();
				FieldType.setClassid(methodFields.getString("fieldtypeclassid"));
				FieldType.setClassname(methodFields.getString("fieldtype"));
				methfield.setMethodFieldType(FieldType);

				Clazz OwnerType = new Clazz();
				OwnerType.setClassid(methodFields.getString("ownerclassid"));
				OwnerType.setClassname(methodFields.getString("classname"));
				methfield.setOwnerClass(OwnerType);

				String methid = methodFields.getString("ownermethodid");

				if (MethodFieldsHashMap.get(methodFields.getString("ownermethodid")) != null) {
					methodfieldsList = MethodFieldsHashMap.get(methid);
				}

				methodfieldsList.add(methfield);
				MethodFieldsHashMap.put(methid, methodfieldsList);

			}
			index++;
			methodFields = st.executeQuery("select fieldmethods.* from fieldmethods where id='" + index + "'");
		}

		return MethodFieldsHashMap;

	}

	public HashMap<String, List<MethodCalls>> CreateMethodCallsHashMapCaller(Connection conn) throws SQLException {
		Statement st = conn.createStatement();
		int index = 1;
		int count = 1;
		ResultSet var = st.executeQuery("select count(*) from methodcalls");
		while (var.next()) {
			count = var.getInt(1);
		}
		ResultSet methodcalls = st.executeQuery("select methodcalls.* from methodcalls where id='" + index + "'");

		while (index < count) {

			while (methodcalls.next()) {
				List<MethodCalls> mylist = new ArrayList<MethodCalls>();
				String callerid = methodcalls.getString("callermethodid");
				String calleeid = methodcalls.getString("calleemethodid");
				String callername = methodcalls.getString("callername");
				String calleename = methodcalls.getString("calleename");

				Method callerclass = new Method();
				callerclass.setMethodid(callerid);
				callerclass.setMethodname(callername);

				Method calleeclass = new Method();
				calleeclass.setMethodid(calleeid);
				calleeclass.setMethodname(calleename);

				MethodCalls methodcall = new MethodCalls();
				methodcall.setCaller(callerclass);
				methodcall.setCallee(calleeclass);
				if (MethodCallsHashMapCaller.get(callerid) != null) {
					mylist = MethodCallsHashMapCaller.get(callerid);
				}

				String key = callerid + "-" + calleeid;
				mylist.add(methodcall);
				MethodCallsHashMapCaller.put(calleeid, mylist);

			}
			index++;
			methodcalls = st.executeQuery("select methodcalls.* from methodcalls where id='" + index + "'");
		}

		return MethodCallsHashMapCaller;

	}

	public HashMap<String, List<MethodCalls>> CreateMethodCallsHashMapCallee(Connection conn) throws SQLException {
		Statement st = conn.createStatement();
		int index = 1;
		int count = 1;
		ResultSet var = st.executeQuery("select count(*) from methodcalls");
		while (var.next()) {
			count = var.getInt(1);
		}
		ResultSet methodcalls = st.executeQuery("select methodcalls.* from methodcalls where id='" + index + "'");

		while (index < count) {

			while (methodcalls.next()) {
				List<MethodCalls> mylist = new ArrayList<MethodCalls>();
				String callerid = methodcalls.getString("callermethodid");
				String calleeid = methodcalls.getString("calleemethodid");
				String callername = methodcalls.getString("callername");
				String calleename = methodcalls.getString("calleename");

				Method callerclass = new Method();
				callerclass.setMethodid(callerid);
				callerclass.setMethodname(callername);

				Method calleeclass = new Method();
				calleeclass.setMethodid(calleeid);
				calleeclass.setMethodname(calleename);

				MethodCalls methodcall = new MethodCalls();
				methodcall.setCaller(callerclass);
				methodcall.setCallee(calleeclass);
				if (MethodCallsHashMapCallee.get(callerid) != null) {
					mylist = MethodCallsHashMapCallee.get(callerid);
				}

				String key = callerid + "-" + calleeid;
				mylist.add(methodcall);
				MethodCallsHashMapCallee.put(callerid, mylist);

			}
			index++;
			methodcalls = st.executeQuery("select methodcalls.* from methodcalls where id='" + index + "'");
		}

		return MethodCallsHashMapCallee;

	}



	

	public HashMap<String, Method2Details> CreateMethodHashMap(Connection conn) throws SQLException {
		Statement st = conn.createStatement();
		int index = 1;
		List<String> MethodIDs= new ArrayList<String>(); 
		ResultSet methods = st.executeQuery("select methods.* from methods ");
		while (methods.next()) {

			String methodid = methods.getString("id");
			String methodname = methods.getString("methodname");
			
			String classid = methods.getString("classid");
			String classname = methods.getString("classname");

			Clazz classrep = new Clazz();
			
			classrep.setClassid(classid);
			classrep.setClassname(classname);

			Method methodrep = new Method();
			String key = methodid;

			methodrep.setMethodid(methodid);
			methodrep.setMethodname(methodname);
			Method2Details methdetails = new Method2Details();
			methdetails.setOwnerClass(classrep);
			methdetails.setMethodrep(methodrep);

			MethodHashMap.put(key, methdetails);
			HashMap<String, Method2Details> methdetailsList;
			if(MethodHashMapNameKey.get(methodrep.getMethodname())!=null) {
				methdetailsList = MethodHashMapNameKey.get(methodrep.getMethodname()); 
			}else {
				
				methdetailsList= new HashMap<String, Method2Details> (); 
			}
			methdetailsList.put(methdetails.getOwnerClass().ID, methdetails); 
			MethodHashMapNameKey.put(methodrep.getMethodname(), methdetailsList); 

		}

		return MethodHashMap;

	}

	public HashMap<String, Clazz> CreateClassHashMap(Connection conn) throws SQLException {
		Statement st = conn.createStatement();
		int index = 1;

		ResultSet classes = st.executeQuery("select classes.* from classes where id='" + index + "'");
		while (classes.next()) {

			String classid = classes.getString("id");
			String classname = classes.getString("classname");

			String key = classid;

			Clazz classrep = new Clazz();
			classrep.setClassid(classid);
			classrep.setClassname(classname);

			ClassHashMap.put(key, classrep);
			index++;
			classes = st.executeQuery("select classes.* from classes where id='" + index + "'");

		}

		return ClassHashMap;

	}

	
	
	public  HashMap<String, Clazz> CreateClassTraces(Connection conn) throws SQLException {
		
		//CLASSESHASHMAP
		String rowcount = null; 
		Statement st = conn.createStatement();
		ResultSet var = st.executeQuery("select count(*) from classes"); 
		while(var.next()){
			rowcount = var.getString("count(*)");
		}
		System.out.println("ROW COUNT::::::"+rowcount); 
		
		 ResultSet myresults = st.executeQuery("SELECT tracesclasses.* from tracesclasses"); 
		 while(myresults.next()) {
			 ClassTrace2 myclasstrace= new ClassTrace2(); 
			 Requirement2 requirement = new Requirement2(); 
			 requirement.setID(myresults.getString("requirementid"));
			 requirement.setRequirementName(myresults.getString("requirement"));
			 myclasstrace.setRequirement(requirement);
			 
			 Clazz classrep = new Clazz(); 
			 classrep.setClassid(myresults.getString("classid"));
			 classrep.setClassname(myresults.getString("classname"));
			 myclasstrace.setMyclass(classrep);
			 
			 myclasstrace.setTraceFinal(myresults.getString("goldfinal"));
			 myclasstrace.setSubjectGold(myresults.getString("SubjectGold"));
			 myclasstrace.setSubject(myresults.getString("subject"));
			 Clazz clazz= new Clazz(); 
			 clazz.setClassid(myresults.getString("classid"));
			 clazz.setClassname(myresults.getString("classname"));
			 clazz.setGold(myresults.getString("goldfinal"));
			 clazz.setSubjectGold(myresults.getString("SubjectGold"));

			 classTraceHashMap.put(requirement.ID.trim()+"-"+classrep.ID.trim(), clazz); 
			 System.out.println("my classtrace toString: "+myclasstrace.toString()); 
			
		 }
		 
		return classTraceHashMap;
	}
	public LinkedHashMap<String, MethodTrace> ReadMethodTraces(Connection conn,
			HashMap<String, List<String>> classMethodsHashMap,
			HashMap<Method, HashMap<Requirement2, String>> FinalMethodHashMapReqGolds) throws SQLException {
		// CLASSESHASHMAP

		Statement st = conn.createStatement();

		int index = 1;

		// END OF TEST
		classTraceHashMap= CreateClassTraces(conn); 
		ClassHashMap = CreateClassHashMap(conn);
		InterfaceHashMap = CreateInterfacesHashMap(conn);
		 ImplementationHashMap = CreateImplementationsHashMap(conn);
		
		MethodHashMap = CreateMethodHashMap(conn);
		MethodCallsHashMapCaller = CreateMethodCallsHashMapCaller(conn);
		MethodCallsHashMapCallee = CreateMethodCallsHashMapCallee(conn);
		
		
		SuperClassHashMap=CreateSuperClassesHashMap(conn); 
		ChildrenHashMap=CreateChildrenHashMap(conn); 
		ResultSet myresults = st.executeQuery("SELECT traces.* from traces where id='" + index + "'");

		while (myresults.next()) {
			MethodTrace mytrace = new MethodTrace();
			Requirement2 requirement = new Requirement2();
			requirement.setID(myresults.getString("requirementid"));
			requirement.setRequirementName(myresults.getString("requirement"));
			mytrace.setRequirement(requirement);
			
			Clazz classrep = new Clazz();
			classrep.setClassid(myresults.getString("classid"));
			classrep.setClassname(myresults.getString("classname"));

			Method methodrep = new Method();
			methodrep.setMethodid(myresults.getString("methodid"));
			methodrep.setMethodname(myresults.getString("method"));
			methodrep.setMethodname(myresults.getString("methodname"));
			methodrep.setFullmethodname(myresults.getString("fullmethod"));
//			System.out.println(requirement.ID.trim()+"-"+classrep.ID.trim());
			
			Clazz OwnerClass = classTraceHashMap.get(requirement.ID.trim()+"-"+classrep.ID.trim()); 
//			System.out.println(OwnerClass.DeveloperGold);
			methodrep.setOwner(OwnerClass);
			mytrace.setMethod(methodrep);

			mytrace.setClassRepresentation(classrep);
			if (classMethodsHashMap.get(mytrace.getClassRepresentation().ID) != null) {
				List<String> MethodList = classMethodsHashMap.get(mytrace.getClassRepresentation().ID);
				if (!MethodList.contains(mytrace.getMethod().ID)) {
					MethodList.add(mytrace.getMethod().ID);

				}
				classMethodsHashMap.put(mytrace.getClassRepresentation().ID, MethodList);
			} else {
				List<String> MethodList = new ArrayList<String>();
				MethodList.add(mytrace.getMethod().ID);
				classMethodsHashMap.put(mytrace.getClassRepresentation().ID, MethodList);
			}

			List<Interface2> ImplementationList = ImplementationHashMap.get(mytrace.getClassRepresentation().ID);

			List<Interface2> InterfaceList = InterfaceHashMap.get(mytrace.getClassRepresentation().ID);
			
			
			List<SuperClass2> superclassList = SuperClassHashMap.get(mytrace.getClassRepresentation().ID);

			List<SuperClass2> ChildrenList = ChildrenHashMap.get(mytrace.getClassRepresentation().ID);
			
			
			List<Clazz> interfaces = new ArrayList<Clazz>();
			if (InterfaceList != null) {
				for (Interface2 myinterface : InterfaceList) {
					Clazz myclassrepinterface = new Clazz();
					myclassrepinterface.setClassid(myinterface.getInterfaceClass().ID);
					myclassrepinterface.setClassname(myinterface.getInterfaceClass().classname);
					if(classTraceHashMap.get(requirement.ID.trim()+"-"+myclassrepinterface.ID.trim())!=null){
						myclassrepinterface.setDeveloperGold(classTraceHashMap.get(requirement.ID.trim()+"-"+myclassrepinterface.ID.trim()).DeveloperGold);
						interfaces.add(myclassrepinterface);

					}

				}

			}

			List<Clazz> implementations = new ArrayList<Clazz>();

			if (ImplementationList != null) {
				for (Interface2 myinterface : ImplementationList) {
					Clazz myclassrepinterface = new Clazz();
					myclassrepinterface.setClassid(myinterface.getImplementation().ID);
					myclassrepinterface.setClassname(myinterface.getImplementation().classname);
					if(classTraceHashMap.get(requirement.ID.trim()+"-"+myclassrepinterface.ID.trim())!=null){
					myclassrepinterface.setDeveloperGold(classTraceHashMap.get(requirement.ID.trim()+"-"+myclassrepinterface.ID.trim()).DeveloperGold);

					implementations.add(myclassrepinterface);
					}
				}
			}
			
			
			List<Clazz> superclasses = new ArrayList<Clazz>();
			if (superclassList != null) {
				for (SuperClass2 superclass : superclassList) {
					Clazz myclassrepinterface = new Clazz();
					myclassrepinterface.setClassid(superclass.getSuperClass().ID);
					myclassrepinterface.setClassname(superclass.getSuperClass().classname);
					if(classTraceHashMap.get(requirement.ID.trim()+"-"+myclassrepinterface.ID.trim())!=null){

					myclassrepinterface.setDeveloperGold(classTraceHashMap.get(requirement.ID.trim()+"-"+myclassrepinterface.ID.trim()).DeveloperGold);

					superclasses.add(myclassrepinterface);
					}
				}

			}

			List<Clazz> children = new ArrayList<Clazz>();

			if (ChildrenList != null) {
				for (SuperClass2 child : ChildrenList) {
					Clazz myclassrepinterface = new Clazz();
					myclassrepinterface.setClassid(child.getOwnerClass().ID);
					myclassrepinterface.setClassname(child.getOwnerClass().classname);
					if(classTraceHashMap.get(requirement.ID.trim()+"-"+myclassrepinterface.ID.trim())!=null){

					myclassrepinterface.setDeveloperGold(classTraceHashMap.get(requirement.ID.trim()+"-"+myclassrepinterface.ID.trim()).DeveloperGold);

					children.add(myclassrepinterface);
					}
				}
			}
			
			
			MethodList methodrepinterfaces= new MethodList(); 
			for(Clazz myinterface: interfaces) {
				//the classes to which this methodname belongs 
				 HashMap<String, Method2Details> CorrespondingClasses = MethodHashMapNameKey.get(mytrace.Method.methodname); 
				if(CorrespondingClasses!=null) {
					Method2Details methodDetails = CorrespondingClasses.get(myinterface.ID); 
					if(CorrespondingClasses.get(myinterface.ID)!=null) {
						Method m = new Method(); 
						m.setMethodid(methodDetails.methodrep.ID); 
						m.setOwner(myinterface);
						methodrepinterfaces.add(m); 
					}
				}
			}
			
			MethodList methodrepImplementations= new MethodList(); 
			for(Clazz myimplementation: implementations) {
				 HashMap<String, Method2Details> CorrespondingClasses = MethodHashMapNameKey.get(mytrace.Method.methodname); 
				if(CorrespondingClasses!=null) {
					Method2Details methodDetails = CorrespondingClasses.get(myimplementation.ID); 
					if(CorrespondingClasses.get(myimplementation.ID)!=null) {
						Method m = new Method(); 
						m.setMethodid(methodDetails.methodrep.ID); 
						m.setOwner(myimplementation);
						methodrepImplementations.add(m); 
					}
				}
			}
			
			
			
			
			MethodList methodrepsuperclasses= new MethodList(); 
			for(Clazz mysuperclass: superclasses) {
				//the classes to which this methodname belongs 
				 HashMap<String, Method2Details> CorrespondingClasses = MethodHashMapNameKey.get(mytrace.Method.methodname); 
				if(CorrespondingClasses!=null) {
					Method2Details methodDetails = CorrespondingClasses.get(mysuperclass.ID); 
					if(CorrespondingClasses.get(mysuperclass.ID)!=null) {
						Method m = new Method(); 
						m.setMethodid(methodDetails.methodrep.ID); 
						m.setOwner(mysuperclass);
						methodrepsuperclasses.add(m); 
					}
				}
			}
			
			MethodList methodrepChildren= new MethodList(); 
			for(Clazz child: children) {
				//the classes to which this methodname belongs 
				 HashMap<String, Method2Details> CorrespondingClasses = MethodHashMapNameKey.get(mytrace.Method.methodname); 
				if(CorrespondingClasses!=null) {
					Method2Details methodDetails = CorrespondingClasses.get(child.ID); 
					if(CorrespondingClasses.get(child.ID)!=null) {
						Method m = new Method(); 
						m.setOwner(child);
						m.setMethodid(methodDetails.methodrep.ID); 
						methodrepChildren.add(m); 
					}
				}
			}
			
			
		
			methodrep.setImplementations(methodrepImplementations);
			methodrep.setInterfaces(methodrepinterfaces); 
			methodrep.setChildren(methodrepChildren);
			methodrep.setSuperclasses(methodrepsuperclasses);
			mytrace.setMethod(methodrep);
			
			
			
			mytrace.setGold(myresults.getString("gold"));

			mytrace.setGoldfinal(myresults.getString("goldfinal"));
			// mytrace.setGold3(myresults.getString("gold3"));
			mytrace.setGoldfinal(myresults.getString("goldfinal"));
			// mytrace.setGold4(myresults.getString("gold4"));

			mytrace.setSubject(myresults.getString("subject"));

			String id = mytrace.getMethod().ID;

			methodrep2.setMethodid(myresults.getString("methodid"));
			methodrep2.setMethodname(myresults.getString("methodname"));
			methodrep2.setClassrep(classrep);

			List<MethodCalls> mycalleelist = MethodCallsHashMapCallee.get(id);
			MethodList mycalleelistrep = new MethodList();
			if (mycalleelist != null) {
				for (MethodCalls mycallee : mycalleelist) {

					Method meth = new Method();
					meth.setMethodid(mycallee.Callee.ID);
					meth.setMethodname(mycallee.Callee.methodname);
					Method2Details val = MethodHashMap.get(meth.getMethodid());
					meth.setClassrep(val.OwnerClass);
					mycalleelistrep.add(meth);
				}

				mytrace.setCalleesList(mycalleelistrep);
				methodrep.setCallees(mycalleelistrep);
			}

			List<MethodCalls> mycallerlist = MethodCallsHashMapCaller.get(id);
			MethodList mycallerlistrep = new MethodList();
			if (mycallerlist != null) {
				for (MethodCalls mycaller : mycallerlist) {
					Method meth = new Method();
					meth.setMethodid(mycaller.Caller.ID);
					meth.setMethodname(mycaller.Caller.methodname);
					Method2Details val = MethodHashMap.get(meth.getMethodid());
					meth.setClassrep(val.OwnerClass);
					mycallerlistrep.add(meth);
				}
				mytrace.setCallersList(mycallerlistrep);
				methodrep.setCallers(mycallerlistrep);
			}

			mytrace.setMethod(methodrep);

			

			String methodid = mytrace.Method.ID;
			String RequirementID = mytrace.Requirement.getID();
			String key = RequirementID + "-" + methodid;
			// System.out.println("HEY");
			if (methodtraceHashMap2.get(key) != null) {
				System.out.println("KEY COMMON " + key);
				System.out.println("yes");
			}
			methodtraceHashMap2.put(key, mytrace);
			index++;
			// MethodTraceSubjectTSubjectN33 methtrace= new MethodTraceSubjectTSubjectN33();
			// System.out.println("my trace tostring: "+mytrace.toString());

			myresults = st.executeQuery("SELECT traces.* from traces where id='" + index + "'");
			System.out.println("index 1 " + index);

		}

		return methodtraceHashMap2;
	}

	///////////////////////////////////////////
	public HashMap<Integer, MethodTrace> ReadClassesRepresentations(Connection conn)
			throws SQLException {
		DatabaseReading2 db = new DatabaseReading2();
		ClassDetails2 classdet = new ClassDetails2();
		// CLASSESHASHMAP

		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
		// ResultSet var = st.executeQuery("select count(*) from classes");

		int index = 1;

		// END OF TEST
	

		ResultSet myresults = st.executeQuery("SELECT traces.* from traces where id='" + index + "'");

		while (myresults.next()) {
			MethodTrace mytrace = new MethodTrace();
			RequirementGold RequirementGold = new RequirementGold();
			Requirement2 requirement = new Requirement2();
			requirement.setID(myresults.getString("requirementid"));
			requirement.setRequirementName(myresults.getString("requirement"));
			mytrace.setRequirement(requirement);

			Clazz classrep = new Clazz();
			classrep.setClassid(myresults.getString("classid"));
			classrep.setClassname(myresults.getString("classname"));
			String fullmethodname = myresults.getString("fullmethod");

			Method methodrep = new Method();
			methodrep.setMethodid(myresults.getString("methodid"));
			methodrep.setMethodname(myresults.getString("method"));
			methodrep.setMethodname(myresults.getString("methodname"));
			methodrep.setFullmethodname(myresults.getString("fullmethod"));

			mytrace.setMethod(methodrep);

			mytrace.setClassRepresentation(classrep);

			List<Interface2> myownerinterfaceList = ImplementationHashMap.get(mytrace.getClassRepresentation().ID);

			List<Interface2> myinterfacelist = InterfaceHashMap.get(mytrace.getClassRepresentation().ID);
			List<Clazz> interfaceclassreps = new ArrayList<Clazz>();
			if (myinterfacelist != null) {
				for (Interface2 myinterface : myinterfacelist) {
					Clazz myclassrepinterface = new Clazz();
					myclassrepinterface.setClassid(myinterface.getInterfaceClass().ID);
					myclassrepinterface.setClassname(myinterface.getInterfaceClass().classname);
					interfaceclassreps.add(myclassrepinterface);
				}

			}

			List<Clazz> interfaceclassrepsOwner = new ArrayList<Clazz>();

			if (myownerinterfaceList != null) {
				for (Interface2 myinterface : myownerinterfaceList) {
					Clazz myclassrepinterface = new Clazz();
					myclassrepinterface.setClassid(myinterface.getImplementation().ID);
					myclassrepinterface.setClassname(myinterface.getImplementation().classname);
					interfaceclassrepsOwner.add(myclassrepinterface);
				}
			}

			mytrace.setGold(myresults.getString("gold"));

			mytrace.setGoldfinal(myresults.getString("goldfinal"));

			mytrace.setSubject(myresults.getString("subject"));

			String id = mytrace.getMethod().ID;

			List<MethodCalls> mycalleelist = MethodCallsHashMapCallee.get(id);
			MethodList mycalleelistrep = new MethodList();
			if (mycalleelist != null) {
				for (MethodCalls mycallee : mycalleelist) {

					Method meth = new Method();
					meth.setMethodid(mycallee.Callee.ID);
					meth.setMethodname(mycallee.Callee.methodname);
					Method2Details val = MethodHashMap.get(meth.getMethodid());
					meth.setClassrep(val.OwnerClass);
					mycalleelistrep.add(meth);
				}

				mytrace.setCalleesList(mycalleelistrep);
			}

			List<MethodCalls> mycallerlist = MethodCallsHashMapCaller.get(id);
			MethodList mycallerlistrep = new MethodList();
			if (mycallerlist != null) {
				for (MethodCalls mycaller : mycallerlist) {
					Method meth = new Method();
					meth.setMethodid(mycaller.Caller.ID);
					meth.setMethodname(mycaller.Caller.methodname);
					Method2Details val = MethodHashMap.get(meth.getMethodid());
					meth.setClassrep(val.OwnerClass);
					mycallerlistrep.add(meth);
				}
				mytrace.setCallersList(mycallerlistrep);
			}

			List<MethodCalls> mycallerlistexecuted = MethodCallsEXECHashMapCaller.get(id);
			MethodList mycallerlistrepexecuted = new MethodList();
			if (mycallerlistexecuted != null) {
				for (MethodCalls mycaller : mycallerlistexecuted) {
					Method meth = new Method();
					meth.setMethodid(mycaller.Caller.ID);
					meth.setMethodname(mycaller.Caller.methodname);
					Method2Details val = MethodHashMap.get(meth.getMethodid());
					meth.setClassrep(val.OwnerClass);
					mycallerlistrepexecuted.add(meth);
				}
				mytrace.setCallersList(mycallerlistrepexecuted);
			}

			List<MethodCalls> mycalleelistexecuted = MethodCallsEXECHashMapCallee.get(id);
			MethodList mycalleelistrepexecuted = new MethodList();
			if (mycalleelistexecuted != null) {
				for (MethodCalls mycallee : mycalleelistexecuted) {
					Method meth = new Method();
					meth.setMethodid(mycallee.Callee.ID);
					meth.setMethodname(mycallee.Callee.methodname);
					Method2Details val = MethodHashMap.get(meth.getMethodid());
					meth.setClassrep(val.OwnerClass);
					mycalleelistrepexecuted.add(meth);
				}
				mytrace.setCalleesList(mycalleelistrepexecuted);

			}

			// System.out.println("HEY");
			methodtraceHashMap.put(index, mytrace);
			index++;
			// MethodTraceSubjectTSubjectN33 methtrace= new MethodTraceSubjectTSubjectN33();
			// System.out.println("my trace tostring: "+mytrace.toString());

			myresults = st.executeQuery("SELECT traces.* from traces where id='" + index + "'");
			System.out.println("index 1 " + index);

		}

		return methodtraceHashMap;
	}

	

	public String toString(MethodTrace methtr) {
		String mycaller = "";
		String mycallee = "";
		String mycallerexecuted = "";
		String mycalleeexecuted = "";
		String requicallee = "";
		String requicaller = "";
		String requicalleeexecuted = "";
		String requicallerexecuted = "";
		String st = "MethodTrace [Method=" + Method.toString()

				+ ", Requirement=" + methtr.Requirement.toString() + ", ClassRepresentation="
				+ methtr.Clazz.toString() + ", gold=" + methtr.gold + ", subject=" + methtr.subject
				+ ", goldpredictionCaller=" + methtr.goldpredictionCaller + ", goldpredictionCallee="
				+ methtr.goldpredictionCallee;

		return st + "   CALLER: " + mycaller + "  " + requicaller + "CALLEE: " + mycallee + "   " + requicallee
				+ "CALLER EXECUTED :" + mycallerexecuted + "  " + requicallerexecuted + "CALLEE EXCUTED: "
				+ mycalleeexecuted + "  " + requicalleeexecuted;

	}


	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	public void SetPrediction(LinkedHashMap<String, LogInfo> LogInfoHashMap, String Pred, String reason)
			
			
			{
		// TODO Auto-generated method stub
		
		if(this.prediction.trim().equals("E")) {
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).getIterationValues().add(reason);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setPrediction(Pred);
			
			this.prediction=Pred; 
			modified=true; 
		}
		
//			RequirementMethodNameClassIDHashMap.put(ReqMethodClasskey, Pred); 
//			methodtraces2HashMap2.put(reqMethod, methodtrace); 
		
		
	}
	

}