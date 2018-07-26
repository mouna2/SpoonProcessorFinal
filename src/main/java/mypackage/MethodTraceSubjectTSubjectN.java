package mypackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MethodTraceSubjectTSubjectN {
	
	public Method2Representation MethodRepresentation; 
	public Requirement2 Requirement; 
	public ClassRepresentation2 ClassRepresentation; 
	public String gold; 
	public String subject;
	public String goldprediction; 
	public String goldpredictionCaller; 
	public String goldpredictionCallee; 
	public String gold2; 
	public String SubjectT; 
	public String SubjectN; 
	public String gold3; 
	public String gold4; 
	List<Method2Representation> callersList= new ArrayList<Method2Representation>(); 
	List<Method2Representation> calleesList= new ArrayList<Method2Representation>(); 
	List<Method2Representation> callersListExecuted= new ArrayList<Method2Representation>(); 
	List<Method2Representation> calleesListExecuted= new ArrayList<Method2Representation>(); 
	
	
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

	public String getGold2() {
		return gold2;
	}

	public void setGold2(String gold2) {
		this.gold2 = gold2;
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

	public List<Method2Representation> getCallersList() {
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

	public void setCallersList(List<Method2Representation> callersList) {
		this.callersList = callersList;
	}

	public List<Method2Representation> getCalleesList() {
		return calleesList;
	}

	public void setCalleesList(List<Method2Representation> calleesList) {
		this.calleesList = calleesList;
	}

	public List<Method2Representation> getCallersListExecuted() {
		return callersListExecuted;
	}

	public void setCallersListExecuted(List<Method2Representation> callersListExecuted) {
		this.callersListExecuted = callersListExecuted;
	}

	public List<Method2Representation> getCalleesListExecuted() {
		return calleesListExecuted;
	}

	public void setCalleesListExecuted(List<Method2Representation> calleesListExecuted) {
		this.calleesListExecuted = calleesListExecuted;
	}

	public ArrayList<MethodTraceSubjectTSubjectN> getMethodtraces() {
		return methodtraces;
	}

	public void setMethodtraces(ArrayList<MethodTraceSubjectTSubjectN> methodtraces) {
		this.methodtraces = methodtraces;
	}

	public HashMap<Integer, MethodTraceSubjectTSubjectN> getMethodtraceHashMap() {
		return methodtraceHashMap;
	}

	public void setMethodtraceHashMap(HashMap<Integer, MethodTraceSubjectTSubjectN> methodtraceHashMap) {
		this.methodtraceHashMap = methodtraceHashMap;
	}

	public ArrayList<MethodTraceSubjectTSubjectN> methodtraces; 
	
	public String getGoldprediction() {
		return goldprediction;
	}

	public void setGoldprediction(String goldprediction) {
		this.goldprediction = goldprediction;
	}

	HashMap<Integer, MethodTraceSubjectTSubjectN> methodtraceHashMap= new HashMap<Integer, MethodTraceSubjectTSubjectN> (); 
	
	public MethodTraceSubjectTSubjectN() {
		super();
	}

	public Method2Representation getMethodRepresentation() {
		return MethodRepresentation;
	}

	public void setMethodRepresentation(Method2Representation methodRepresentation) {
		MethodRepresentation = methodRepresentation;
	}

	public Requirement2 getRequirement() {
		return Requirement;
	}

	public void setRequirement(Requirement2 requirement) {
		Requirement = requirement;
	}

	public ClassRepresentation2 getClassRepresentation() {
		return ClassRepresentation;
	}

	public void setClassRepresentation(ClassRepresentation2 classRepresentation) {
		ClassRepresentation = classRepresentation;
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

	public MethodTraceSubjectTSubjectN(Method2Representation methodRepresentation, Requirement2 requirement,
			ClassRepresentation2 classRepresentation, String gold, String subject) {
		super();
		MethodRepresentation = methodRepresentation;
		Requirement = requirement;
		ClassRepresentation = classRepresentation;
		this.gold = gold;
		this.subject = subject;
	}
	
	public  HashMap<Integer, MethodTraceSubjectTSubjectN> ReadClassesRepresentations(Connection conn) throws SQLException {
		DatabaseReading2 db = new DatabaseReading2(); 
		ClassDetails2 classdet= new ClassDetails2(); 
		//CLASSESHASHMAP
		
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
		ResultSet var = st.executeQuery("select count(*) from classes"); 
		
	
		int index=1; 
	
		//END OF TEST 
			 ResultSet myresults = st.executeQuery("SELECT traces.* from traces where id='"+ index +"'"); 
			 while(myresults.next() ) {
				 MethodTraceSubjectTSubjectN mytrace= new MethodTraceSubjectTSubjectN(); 
				 RequirementGold RequirementGold = new RequirementGold(); 
				 Requirement2 requirement = new Requirement2(); 
				 requirement.setID(myresults.getString("requirementid"));
				 requirement.setRequirementName(myresults.getString("requirement"));
				 mytrace.setRequirement(requirement);
				 
				 ClassRepresentation2 classrep = new ClassRepresentation2(); 
				 classrep.setClassid(myresults.getString("classid"));
				 classrep.setClassname(myresults.getString("classname"));
				 
				 Method2Representation methodrep= new Method2Representation(); 
				 methodrep.setMethodid(myresults.getString("methodid"));
				 methodrep.setMethodname(myresults.getString("method"));
				 mytrace.setMethodRepresentation(methodrep);
				 
				 mytrace.setClassRepresentation(classrep);
				 
				 mytrace.setGold(myresults.getString("gold"));

				 mytrace.setGold3(myresults.getString("gold3"));
				 
				 mytrace.setGold4(myresults.getString("gold4"));
				 
				 mytrace.setSubject(myresults.getString("subject"));
				 
				 mytrace.setSubjectT(myresults.getString("SubjectT"));
				 mytrace.setSubjectN(myresults.getString("SubjectN"));

				 String id= mytrace.getMethodRepresentation().methodid; 
				 ResultSet callers=st.executeQuery("select methodcalls.* from methodcalls where calleemethodid='" + id+"'"); 
				 this.callersList= new  ArrayList<Method2Representation>(); 
				 while(callers.next()) {
//					 List<RequirementGold> requirementsGold = new ArrayList<RequirementGold>(); 
//					 ResultSet methodtraces=st2.executeQuery("select traces.* from traces where methodid='" + id+"'"); 
//					 while(methodtraces.next()) {
//						 
//						  requirement= new Requirement2(); 
//						  RequirementGold= new RequirementGold(); 
//						 requirement.setID(methodtraces.getString("requirementid"));
//						 requirement.setRequirementName(methodtraces.getString("requirement"));
//						 RequirementGold.setRequirement(requirement);
//						 RequirementGold.setGold(methodtraces.getString("gold"));
//						 requirementsGold.add(RequirementGold); 
//					 }
					 Method2Representation meth= new Method2Representation(); 	
					 meth.setMethodid(callers.getString("callermethodid"));
					 meth.setMethodname(callers.getString("callername"));
					
					 ResultSet myclass=st2.executeQuery("select methods.* from methods where id='" + meth.getMethodid()+"'"); 
					 while(myclass.next()) {
						 ClassRepresentation2 myclassrep= new ClassRepresentation2(); 
						 myclassrep.setClassid(myclass.getString("classid"));
						 myclassrep.setClassname(myclass.getString("classname"));
						 meth.setClassrep(myclassrep);
					 }
					
				//	 meth.setRequirementsGold(requirementsGold);
					 this.callersList.add(meth); 					 
					 mytrace.setCallersList(this.callersList);
				 }
				 
				 ResultSet callees=st.executeQuery("select methodcalls.* from methodcalls where callermethodid='" + id+"'"); 
				 this.calleesList= new  ArrayList<Method2Representation>(); 
				 while(callees.next()) {
//					 List<RequirementGold> requirementsGold = new ArrayList<RequirementGold>(); 
//					 ResultSet methodtraces=st2.executeQuery("select traces.* from traces where methodid='" + id+"'"); 
//					 while(methodtraces.next()) {
//						 
//						 requirement= new Requirement2(); 
//						  RequirementGold= new RequirementGold(); 
//						 requirement.setID(methodtraces.getString("requirementid"));
//						 requirement.setRequirementName(methodtraces.getString("requirement"));
//						 RequirementGold.setRequirement(requirement);
//						 RequirementGold.setGold(methodtraces.getString("gold"));
//						 requirementsGold.add(RequirementGold); 
//					 }
					 Method2Representation meth= new Method2Representation(); 	
					 meth.setMethodid(callees.getString("calleemethodid"));
					 meth.setMethodname(callees.getString("calleename"));
					 
					 ResultSet myclass=st2.executeQuery("select methods.* from methods where id='" + meth.getMethodid()+"'"); 
					 while(myclass.next()) {
						 ClassRepresentation2 myclassrep= new ClassRepresentation2(); 
						 myclassrep.setClassid(myclass.getString("classid"));
						 myclassrep.setClassname(myclass.getString("classname"));
						 meth.setClassrep(myclassrep); 
					 }
					
					 
					 
			//		 meth.setRequirementsGold(requirementsGold);
					 this.calleesList.add(meth); 					 
					 mytrace.setCalleesList(this.calleesList);
				 }
				 
				 
				 ResultSet callersExecuted=st.executeQuery("select methodcallsexecuted.* from methodcallsexecuted where calleemethodid='" + id+"'"); 
				 this.calleesListExecuted= new  ArrayList<Method2Representation>(); 
				 while(callersExecuted.next()) {
//					 List<RequirementGold> requirementsGold = new ArrayList<RequirementGold>(); 
//					 ResultSet methodtraces=st2.executeQuery("select traces.* from traces where methodid='" + id+"'"); 
//					 while(methodtraces.next()) {
//						 
//						 requirement= new Requirement2(); 
//						  RequirementGold= new RequirementGold(); 
//						 requirement.setID(methodtraces.getString("requirementid"));
//						 requirement.setRequirementName(methodtraces.getString("requirement"));
//						 RequirementGold.setRequirement(requirement);
//						 RequirementGold.setGold(methodtraces.getString("gold"));
//						 requirementsGold.add(RequirementGold); 
//					 }
					 Method2Representation meth= new Method2Representation(); 	
					 meth.setMethodid(callersExecuted.getString("callermethodid"));
					 meth.setMethodname(callersExecuted.getString("callername"));
					 
					 ResultSet myclass=st2.executeQuery("select methods.* from methods where id='" + meth.getMethodid()+"'"); 
					 while(myclass.next()) {
						 ClassRepresentation2 myclassrep= new ClassRepresentation2(); 
						 myclassrep.setClassid(myclass.getString("classid"));
						 myclassrep.setClassname(myclass.getString("classname"));
						 meth.setClassrep(myclassrep); 
					 }
					
					 
				//	 meth.setRequirementsGold(requirementsGold);
					 this.calleesListExecuted.add(meth); 					 
					 mytrace.setCallersListExecuted(this.calleesListExecuted);
				 }
				 
				 ResultSet calleesExecuted=st.executeQuery("select methodcallsexecuted.* from methodcallsexecuted where callermethodid='" + id+"'"); 
				 this.callersListExecuted= new  ArrayList<Method2Representation>(); 
				 while(calleesExecuted.next()) {
//					 List<RequirementGold> requirementsGold = new ArrayList<RequirementGold>(); 
//					 ResultSet methodtraces=st2.executeQuery("select traces.* from traces where methodid='" + id+"'"); 
//					 while(methodtraces.next()) {
//						 
//						 requirement= new Requirement2(); 
//						  RequirementGold= new RequirementGold(); 
//						 requirement.setID(methodtraces.getString("requirementid"));
//						 requirement.setRequirementName(methodtraces.getString("requirement"));
//						 RequirementGold.setRequirement(requirement);
//						 RequirementGold.setGold(methodtraces.getString("gold"));
//						 requirementsGold.add(RequirementGold); 
//					 }
					 Method2Representation meth= new Method2Representation(); 	
					 meth.setMethodid(calleesExecuted.getString("calleemethodid"));
					 meth.setMethodname(calleesExecuted.getString("calleename"));
					 
					 ResultSet myclass=st2.executeQuery("select methods.* from methods where id='" + meth.getMethodid()+"'"); 
					 while(myclass.next()) {
						 ClassRepresentation2 myclassrep= new ClassRepresentation2(); 
						 myclassrep.setClassid(myclass.getString("classid"));
						 myclassrep.setClassname(myclass.getString("classname"));
						 meth.setClassrep(myclassrep); 
					 }
				
					 
				//	 meth.setRequirementsGold(requirementsGold);
					 this.callersListExecuted.add(meth); 					 
					 mytrace.setCalleesListExecuted(this.callersListExecuted);
				 }
				 
				 
				 methodtraceHashMap.put(index, mytrace); 
				 index++; 
			//	 MethodTraceSubjectTSubjectN methtrace= new MethodTraceSubjectTSubjectN(); 
				// System.out.println("my trace tostring: "+mytrace.toString());
				
				 myresults = st.executeQuery("SELECT traces.* from traces where id='"+ index +"'"); 
			
			 }
		

		 
		return methodtraceHashMap;
	}
	
	public List<MethodTraceSubjectTSubjectN> getElement(List<MethodTraceSubjectTSubjectN> methodtraces2, String ID, String goldpred, String goldprediction2, String RequirementID) {
		for(MethodTraceSubjectTSubjectN methodtrace: methodtraces2) {
			if(methodtrace.getMethodRepresentation().methodid.equals(ID) && methodtrace.Requirement.ID.equals(RequirementID)) {
				if(goldprediction2.equals("goldpredictionCallee")){
					methodtrace.setGoldpredictionCallee(goldpred);
				}
				else if(goldprediction2.equals("goldpredictionCaller")) {
					methodtrace.setGoldpredictionCaller(goldpred);
				}
				
			}
		}
		
		return methodtraces2; 
		
	}

	public String toString(MethodTraceSubjectTSubjectN methtr) {
		String mycaller = ""; 
		String mycallee = ""; 
		String mycallerexecuted = ""; 
		String mycalleeexecuted = ""; 
		String requicallee = ""; 
		String requicaller = ""; 
		String requicalleeexecuted = ""; 
		String requicallerexecuted = ""; 
		String st= "MethodTrace [MethodRepresentation=" + MethodRepresentation.toString() 
		
		+ ", Requirement=" + methtr.Requirement.toString()
			+ ", ClassRepresentation=" + methtr.ClassRepresentation.toString() + ", gold=" + methtr.gold + ", subject=" + methtr.subject 
				+ ", goldpredictionCaller=" + methtr.goldpredictionCaller+ ", goldpredictionCallee=" + methtr.goldpredictionCallee ; 
		for(Method2Representation caller: methtr.callersList) {
		 mycaller=	mycaller+caller.getMethodid() +" "+caller.getMethodname(); 
		for(RequirementGold req: caller.requirementsGold) {
			 requicaller= requicaller+ " "+ req.Requirement.ID+ "  "+ req.Requirement.RequirementName; 
		}
		}
		
		for(Method2Representation callee: methtr.calleesList) {
			 mycallee=	mycallee+callee.getMethodid() +" "+callee.getMethodname(); 
			for(RequirementGold req: callee.requirementsGold) {
				 requicallee= requicallee+ " "+ req.Requirement.ID+ "  "+ req.Requirement.RequirementName; 
			}
			}
		
		for(Method2Representation callerexecuted: methtr.callersListExecuted) {
			 mycallerexecuted=	mycallerexecuted+callerexecuted.getMethodid() +" "+callerexecuted.getMethodname(); 
			for(RequirementGold req: callerexecuted.requirementsGold) {
				 requicallerexecuted=requicallerexecuted+ " "+ req.Requirement.ID+ "  "+ req.Requirement.RequirementName; 
			}
			}
			
			for(Method2Representation calleeexecuted: methtr.calleesListExecuted) {
				 mycalleeexecuted=	mycalleeexecuted+calleeexecuted.getMethodid() +" "+calleeexecuted.getMethodname(); 
				for(RequirementGold req: calleeexecuted.requirementsGold) {
					 requicalleeexecuted=requicalleeexecuted+ " "+ req.Requirement.ID+ "  "+ req.Requirement.RequirementName; 
				}
				}
		return st+"   CALLER: "+mycaller +"  "+requicaller+"CALLEE: "+mycallee+"   "+requicallee+"CALLER EXECUTED :"+mycallerexecuted+ "  " +requicallerexecuted+"CALLEE EXCUTED: "+mycalleeexecuted+"  "+requicalleeexecuted; 
			
	}
	
	
	
	
	
}