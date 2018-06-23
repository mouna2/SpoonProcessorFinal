package mypackage;

import java.util.ArrayList;
import java.util.List;

public class Method2Representation {
	public String methodid; 
	public String methodname;
	public List<RequirementGold> requirementsGold= new ArrayList<RequirementGold>(); 
	public List<Requirement2> requirements= new ArrayList<Requirement2>(); 
	public ClassRepresentation2 classrep= new ClassRepresentation2(); 
	public Method2Representation(String methodid, String methodname) {
		super();
		this.methodid = methodid;
		this.methodname = methodname;
	}
	public Method2Representation() {
		// TODO Auto-generated constructor stub
	}
	public String getMethodid() {
		return methodid;
	}
	public void setMethodid(String methodid) {
		this.methodid = methodid;
	}
	public String getMethodname() {
		return methodname;
	}
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}
	@Override
	public String toString() {
		return  methodid + ", methodname=" + methodname + ", requirementsGold="
				+ requirementsGold.toString() + classrep.toString()+"]";
	}
	
	
	public String PrintList(List<Method2Representation> methods) {
		String s =""; 
		for(Method2Representation mymethod: methods) {
			 s= s +mymethod.toString(); 
		}
		return s; 
	}
	
	
	public List<RequirementGold> getRequirementsGold() {
		return requirementsGold;
	}
	public void setRequirementsGold(List<RequirementGold> requirementsGold) {
		this.requirementsGold = requirementsGold;
	}
	public List<Requirement2> getRequirements() {
		return requirements;
	}
	public void setRequirements(List<Requirement2> requirements) {
		this.requirements = requirements;
	}
	public ClassRepresentation2 getClassrep() {
		return classrep;
	}
	public void setClassrep(ClassRepresentation2 classrep) {
		this.classrep = classrep;
	}
	
	
	
	
	
	
}
