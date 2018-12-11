package mypackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ALGO.MethodList;

public class Method {
	public String methodid; 
	public String methodname;
	public String fullmethodname;
	public ClassRepresentation2 classrep= new ClassRepresentation2(); 
	public MethodList Callees= new MethodList(); 
	public MethodList Callers= new MethodList(); 
	public MethodList Interfaces= new MethodList(); 
	public MethodList implementations= new MethodList(); 
	public MethodList Superclasses= new MethodList(); 
	public MethodList Children= new MethodList(); 
	public List<RequirementGold> requirementsGold= new ArrayList<RequirementGold>(); 
	public List<Requirement2> requirements= new ArrayList<Requirement2>(); 
	public	HashMap<Requirement2, String> FinalMethodHashMap= new HashMap<Requirement2, String>(); 
	
	public MethodList getSuperclasses() {
		return Superclasses;
	}
	public void setSuperclasses(MethodList superclasses) {
		Superclasses = superclasses;
	}
	public MethodList getChildren() {
		return Children;
	}
	public void setChildren(MethodList children) {
		Children = children;
	}
	public MethodList getInterfaces() {
		return Interfaces;
	}
	public void setInterfaces(MethodList interfaces) {
		Interfaces = interfaces;
	}
	public MethodList getImplementations() {
		return implementations;
	}
	public void setImplementations(MethodList implementations) {
		this.implementations = implementations;
	}
	public Method(String methodid, String methodname) {
		super();
		this.methodid = methodid;
		this.methodname = methodname;
	}
	public Method() {
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
	public HashMap<Requirement2, String> getFinalMethodHashMap() {
		return FinalMethodHashMap;
	}
	public void setFinalMethodHashMap(HashMap<Requirement2, String> finalMethodHashMap) {
		FinalMethodHashMap = finalMethodHashMap;
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
	
	public String PrintList(List<Method> methods) {
		String s =""; 
		for(Method mymethod: methods) {
			 s= s +mymethod.toString(); 
		}
		return s; 
	}
	
	
	public Method(String methodid, String methodname, String fullmethodname,
			ClassRepresentation2 classrep, HashMap<Requirement2, String> finalMethodHashMap) {
		super();
		this.methodid = methodid;
		this.methodname = methodname;
		this.fullmethodname = fullmethodname;
		this.classrep = classrep;
		FinalMethodHashMap = finalMethodHashMap;
	}
	
	
	
	public Method(String methodid, String methodname, String fullmethodname,
			ClassRepresentation2 classrep) {
		super();
		this.methodid = methodid;
		this.methodname = methodname;
		this.fullmethodname = fullmethodname;
		this.classrep = classrep;
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
	
	
	
	public MethodList getCallees() {
		return Callees;
	}
	public void setCallees(MethodList callees) {
		Callees = callees;
	}
	public MethodList getCallers() {
		return Callers;
	}
	public void setCallers(MethodList callers) {
		Callers = callers;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classrep == null) ? 0 : classrep.hashCode());
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
		Method other = (Method) obj;
		if (classrep == null) {
			if (other.classrep != null)
				return false;
		} else if (!classrep.equals(other.classrep))
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