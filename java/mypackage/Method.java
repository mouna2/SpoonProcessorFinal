package mypackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ALGO.MethodList;
import mypackage.*;

public class Method {
	public String ID; 
	public String methodname;
	public String fullmethodname;
	public Clazz owner= new Clazz(); 
	public MethodList Callees= new MethodList(); 
	public MethodList Callers= new MethodList(); 
	public MethodList Interfaces= new MethodList(); 
	public MethodList implementations= new MethodList(); 
	public MethodList Superclasses= new MethodList(); 
	public MethodList Children= new MethodList(); 
	public List<RequirementGold> requirementsGold= new ArrayList<RequirementGold>(); 
	public List<Requirement2> requirements= new ArrayList<Requirement2>(); 
	public	HashMap<Requirement2, String> FinalMethodHashMap= new HashMap<Requirement2, String>(); 
	
	public Clazz getOwner() {
		return owner;
	}
	public void setOwner(Clazz owner) {
		this.owner = owner;
	}
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
		this.ID = methodid;
		this.methodname = methodname;
	}
	public Method() {
		// TODO Auto-generated constructor stub
	}
	public String getMethodid() {
		return ID;
	}
	public void setMethodid(String methodid) {
		this.ID = methodid;
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
		return  ID + ", methodname=" + methodname + 
//				", requirementsGold="
//				+ requirementsGold.toString() + 
				owner.toString()+"]";
	}
	
	public String toString2() {
		return "["+  ID + ": methodname=" + methodname  + ": classname=" + owner.classname + ": classid=" + owner.ID +"]";
	}
	
	public String PrintList(List<Method> methods) {
		String s =""; 
		for(Method mymethod: methods) {
			 s= s +mymethod.toString(); 
		}
		return s; 
	}
	
	
	public Method(String methodid, String methodname, String fullmethodname,
			Clazz classrep, HashMap<Requirement2, String> finalMethodHashMap) {
		super();
		this.ID = methodid;
		this.methodname = methodname;
		this.fullmethodname = fullmethodname;
		this.owner = classrep;
		FinalMethodHashMap = finalMethodHashMap;
	}
	
	
	
	public Method(String methodid, String methodname, String fullmethodname,
			Clazz classrep) {
		super();
		this.ID = methodid;
		this.methodname = methodname;
		this.fullmethodname = fullmethodname;
		this.owner = classrep;
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
	public Clazz getClassrep() {
		return owner;
	}
	public void setClassrep(Clazz classrep) {
		this.owner = classrep;
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
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
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
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (methodname == null) {
			if (other.methodname != null)
				return false;
		} else if (!methodname.equals(other.methodname))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}