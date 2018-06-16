package mypackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClassTrace2 {
	String ID; 
		Requirement2 requirement; 
		ClassRepresentation2 myclass; 
		String trace; 
		String subject;
		
		
		
		HashMap<Integer, ClassTrace2> classtraceHashMap= new HashMap<Integer, ClassTrace2> (); 
		
		
		public ClassTrace2(String iD, Requirement2 requirement, ClassRepresentation2 myclass, String trace, String subject) {
			super();
			ID = iD;
			this.requirement = requirement;
			this.myclass = myclass;
			this.trace = trace;
			this.subject = subject;
		}
		
		public ClassTrace2() {
			// TODO Auto-generated constructor stub
		}
		public String getID() {
			return ID;
		}
		public void setID(String iD) {
			ID = iD;
		}
		public Requirement2 getRequirement() {
			return requirement;
		}
		public void setRequirement(Requirement2 requirement) {
			this.requirement = requirement;
		}
		public ClassRepresentation2 getMyclass() {
			return myclass;
		}
		public void setMyclass(ClassRepresentation2 myclass) {
			this.myclass = myclass;
		}
		public String gettrace() {
			return trace;
		}
		public void settrace(String trace) {
			this.trace = trace;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		
		
		public  HashMap<Integer, ClassTrace2> ReadClassesRepresentations(Connection conn) throws SQLException {
			DatabaseReading2 db = new DatabaseReading2(); 
			ClassDetails2 classdet= new ClassDetails2(); 
			//CLASSESHASHMAP
			String rowcount = null; 
			Statement st = conn.createStatement();
			ResultSet var = st.executeQuery("select count(*) from classes"); 
			while(var.next()){
				rowcount = var.getString("count(*)");
			}
			System.out.println("ROW COUNT::::::"+rowcount); 
			int rowcountint= Integer.parseInt(rowcount); 
		
			int index=1; 
			 ResultSet myresults = st.executeQuery("SELECT tracesclasses.* from tracesclasses where id='"+ index +"'"); 
			 while(myresults.next()) {
				 ClassTrace2 myclasstrace= new ClassTrace2(); 
				 Requirement2 requirement = new Requirement2(); 
				 requirement.setID(myresults.getString("requirementid"));
				 requirement.setRequirementName(myresults.getString("requirement"));
				 myclasstrace.setRequirement(requirement);
				 
				 ClassRepresentation2 classrep = new ClassRepresentation2(); 
				 classrep.setClassid(myresults.getString("classid"));
				 classrep.setClassname(myresults.getString("classname"));
				 myclasstrace.setMyclass(classrep);
				 
				 myclasstrace.settrace(myresults.getString("gold"));
				 
				 myclasstrace.setSubject(myresults.getString("subject"));
				 classtraceHashMap.put(index, myclasstrace); 
				 index++; 
				 myresults = st.executeQuery("SELECT tracesclasses.* from tracesclasses where id='"+ index +"'"); 
			 }
			 
			return classtraceHashMap;
		}
		
		
		public ClassTrace2 FindTrace(List<ClassTrace2> classtraces2, String ClassID, String RequirementID) {
			for(ClassTrace2 ct: classtraces2) {
				if(ct.myclass.getClassid().equals(ClassID) && ct.requirement.ID.equals(RequirementID)) {
					return ct; 
				}
			}
			return null;
			
		}
}
