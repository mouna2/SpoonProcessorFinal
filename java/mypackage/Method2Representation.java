package mypackage;

import java.util.ArrayList;
import java.util.List;

public class Method2Representation {
	public String methodid; 
	public String methodname;
	public String fullmethodname;
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
		return  methodid + ", methodname=" + methodname + 
//				", requirementsGold="
//				+ requirementsGold.toString() + 
				classrep.toString()+"]";
	}
	
	public String toString2() {
		return "["+  methodid + ": methodname=" + methodname  + ": classname=" + classrep.classname + ": classid=" + classrep.classid +"]";
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
	public String getFullmethodname() {
		return fullmethodname;
	}
	public void setFullmethodname(String fullmethodname) {
		this.fullmethodname = fullmethodname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classrep == null) ? 0 : classrep.hashCode());
		result = prime * result + ((fullmethodname == null) ? 0 : fullmethodname.hashCode());
		result = prime * result + ((methodid == null) ? 0 : methodid.hashCode());
		result = prime * result + ((methodname == null) ? 0 : methodname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Method2Representation other = (Method2Representation) obj;
		if (classrep == null) {
			if (other.classrep != null)
				return false;
		} else if (!classrep.equals(other.classrep))
			return false;
		if (fullmethodname == null) {
			if (other.fullmethodname != null)
				return false;
		} else if (!fullmethodname.equals(other.fullmethodname))
			return false;
		if (methodid == null) {
			if (other.methodid != null)
				return false;
		} else if (!methodid.equals(other.methodid))
			return false;
		if (methodname == null) {
			if (other.methodname != null)
				return false;
		} else if (!methodname.equals(other.methodname))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
