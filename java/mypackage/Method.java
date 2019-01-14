package mypackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ALGO.AlgoFinalRefactored;
import ALGO.MethodList;
import mypackage.*;

public class Method {
	public String ID; 
	public boolean NewPatternFlag= false; 
	public boolean CalleeImplementationFlag= false; 
	public boolean CalleeChildFlag= false; 
	public boolean CallerInterfaceFlag= false; 
	public boolean CallerSuperclassFlag= false; 

	public String methodname;
	public String fullmethodname;
	public Clazz Owner= new Clazz(); 
	public MethodList Callees= new MethodList(); 
	public MethodList Callers= new MethodList(); 
	public MethodList CallersofCallers= new MethodList(); 
	public MethodList Interfaces= new MethodList(); 
	public MethodList Implementations= new MethodList(); 
	public MethodList Superclasses= new MethodList(); 
	public MethodList Children= new MethodList(); 
	//	public List<RequirementGold> requirementsGold= new ArrayList<RequirementGold>(); 
	//	public List<Requirement2> requirements= new ArrayList<Requirement2>(); 
	//	public	HashMap<Requirement2, String> FinalMethodHashMap= new HashMap<Requirement2, String>(); 
	public MethodList CalleesofCallees= new MethodList(); 


	public Clazz getOwner() {
		return Owner;
	}
	public void setOwner(Clazz owner) {
		this.Owner = owner;
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
		return Implementations;
	}
	public void setImplementations(MethodList implementations) {
		this.Implementations = implementations;
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

	@Override
	public String toString() {
		return  ID + ", methodname=" + methodname + 
				//				", requirementsGold="
				//				+ requirementsGold.toString() + 
				Owner.toString()+"]";
	}

	public String toString2() {
		return "["+  ID + ": methodname=" + methodname  + ": classname=" + Owner.classname + ": classid=" + Owner.ID +"]";
	}

	public String PrintList(List<Method> methods) {
		String s =""; 
		for(Method mymethod: methods) {
			s= s +mymethod.toString(); 
		}
		return s; 
	}


	public Method(String methodid, String methodname, String fullmethodname,
			Clazz classrep, HashMap<Requirement, String> finalMethodHashMap) {
		super();
		this.ID = methodid;
		this.methodname = methodname;
		this.fullmethodname = fullmethodname;
		this.Owner = classrep;
	}



	public Method(String methodid, String methodname, String fullmethodname,
			Clazz classrep) {
		super();
		this.ID = methodid;
		this.methodname = methodname;
		this.fullmethodname = fullmethodname;
		this.Owner = classrep;
	}

	public Clazz getClassrep() {
		return Owner;
	}
	public void setClassrep(Clazz classrep) {
		this.Owner = classrep;
	}
	public String getFullmethodname() {
		return fullmethodname;
	}
	public void setFullmethodname(String fullmethodname) {
		this.fullmethodname = fullmethodname;
	}


	/////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	//////////////////////////////ORIGINAL VERSION ///////////////////////	
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
//		public MethodList getCallees(Requirement requirement) {
//			MethodList NewCallees= new MethodList();
//			NewCallees.addAll(Callees);
//	
//			if(!this.Implementations.isEmpty()) {
//				for(Method imp: this.Implementations) {
//	
//					NewCallees=NewCallees.AddAll(imp.Callees); 
//				
//				}
//				
//				
//			}
//			
//			if(!this.Children.isEmpty()) {
//				for(Method child: this.Children) {
//					
//					NewCallees=	NewCallees.AddAll(child.Callees); 
//
//				}
//			}
//				
//				
//				return NewCallees; 
//		}


	/////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	//			FILTER OUT INNER CALLS SILLY FILTERING 
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
//		public MethodList getCallees(Requirement requirement) {
//			MethodList NewCallees= new MethodList();
//			NewCallees.addAll(Callees);
//	
//			if(!this.Implementations.isEmpty()) {
//				for(Method imp: this.Implementations) {
//	
//					if(!imp.Callees.isEmpty()) {
//						NewCallees=NewCallees.AddAll(imp.Callees); 
//						imp.CalleeImplementationFlag=true; 
//					}
//	
//				
//				}
//				
//				
//			}
//			
//				if(!this.Children.isEmpty()) {
//					
//	
//				for(Method child: this.Children) {
//					if(!child.Callees.isEmpty()) {
//						child.CalleeChildFlag=true; 
//						NewCallees=	NewCallees.AddAll(child.Callees); 
//	
//					}
//	
//				
//				}
//			}
//				
//				MethodList OuterCallees = new MethodList();
//				for(Method Callee: NewCallees) {
//					if(AlgoFinalRefactored.methodtraces2HashMap.get(requirement.ID+"-"+Callee.ID).prediction.equals("N") || 
//							!this.Owner.ID.equals(Callee.Owner.ID) ) {
//						OuterCallees.add(Callee); 
//					}
//				}
//				return OuterCallees; 
//		}

	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	////////////////////////////// VERSION 3 SMART FILTERING///////////////////////	
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////

	public MethodList getCallees(Requirement requirement) {
		MethodList NewCallees= new MethodList();
		NewCallees.addAll(Callees);

		if(!this.Implementations.isEmpty()) {
			for(Method imp: this.Implementations) {

				if(!imp.Callees.isEmpty()) {
					NewCallees=NewCallees.AddAll(imp.Callees); 
					imp.CalleeImplementationFlag=true; 
				}


			}


		}

		if(!this.Children.isEmpty()) {


			for(Method child: this.Children) {
				if(!child.Callees.isEmpty()) {
					child.CalleeChildFlag=true; 
					NewCallees=	NewCallees.AddAll(child.Callees); 

				}


			}
		}

		MethodList FinalCallees = new MethodList();

		for(Method Callee: NewCallees) {
			if(AlgoFinalRefactored.methodtraces2HashMap.get(requirement.ID+"-"+Callee.ID).prediction.equals("T") 
					||AlgoFinalRefactored.methodtraces2HashMap.get(requirement.ID+"-"+Callee.ID).prediction.equals("N")) {
				FinalCallees.add(Callee); 
			}
			else if(AlgoFinalRefactored.methodtraces2HashMap.get(requirement.ID+"-"+Callee.ID).prediction.equals("E") ) {
				if(!Callee.Owner.ID.equals(this.Owner.ID)){
					FinalCallees.add(Callee); 
				}else {


					for(Method CalleeOfCallee: Callee.Callees) {
//						for(Method CalleeOfCallee: Callee.getCallees(requirement)) {
//							FinalCallees.add(CalleeOfCallee);
						if(AlgoFinalRefactored.methodtraces2HashMap.get(requirement.ID+"-"+CalleeOfCallee.ID).prediction.equals("T") 
								||AlgoFinalRefactored.methodtraces2HashMap.get(requirement.ID+"-"+CalleeOfCallee.ID).prediction.equals("N")) {
							FinalCallees.add(CalleeOfCallee); 
						}
						else if(!CalleeOfCallee.Owner.ID.equals(Callee.Owner.ID)
								&& AlgoFinalRefactored.methodtraces2HashMap.get(requirement.ID+"-"+CalleeOfCallee.ID).prediction.equals("E")){
							FinalCallees.add(CalleeOfCallee); 
						}
					}
				}
			}
		}
		return FinalCallees; 
	}
	/////////////////////////////////////////////////////////
	public void setCallees(MethodList callees) {
		Callees = callees;
	}




	//	
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	//////////////////////////////ORIGINAL VERSION ///////////////////////	
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
//		public MethodList getCallers(Requirement requirement) {
//			MethodList NewCallers= new MethodList();
//			NewCallers.addAll(Callers);
//			if(!this.Interfaces.isEmpty()) {
//				for(Method inter: this.Interfaces) {
//					NewCallers=NewCallers.AddAll(inter.Callers); 
//				}
//			}
//			
//			if(!this.Superclasses.isEmpty()) {
//				for(Method superclass: this.Superclasses) {
//					NewCallers=NewCallers.AddAll(superclass.Callers); 
//				}
//			}
//			return NewCallers;
//	
//		}
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	//			FILTER OUT INNER CALLS SILLY FILTERING 
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
//		public MethodList getCallers(Requirement requirement) {
//			MethodList NewCallers= new MethodList();
//			NewCallers.addAll(Callers);
//			if(!this.Interfaces.isEmpty()) {
//				for(Method inter: this.Interfaces) {
//					if(!inter.Callers.isEmpty()) {
//						inter.CallerInterfaceFlag=true; 
//	
//	
//						NewCallers=NewCallers.AddAll(inter.Callers); 
//	
//					}
//				}
//		}
//			
//				if(!this.Superclasses.isEmpty()) {
//				for(Method superclass: this.Superclasses) {
//					if(!superclass.Callers.isEmpty()) {
//						superclass.CallerSuperclassFlag=true; 
//	
//						NewCallers=NewCallers.AddAll(superclass.Callers); 
//	
//					}
//				}
//		}
//				MethodList OuterCallers = new MethodList();
//				for(Method Caller: NewCallers) {
//					if(AlgoFinalRefactored.methodtraces2HashMap.get(requirement.ID+"-"+Caller.ID).prediction.equals("N") || 
//							!this.Owner.ID.equals(Caller.Owner.ID)) {
//						OuterCallers.add(Caller); 
//					}
//				}
//				return OuterCallers; 
//	
//		}

	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	//////////////////////////////VERSION 3 SMART FILTERING///////////////////////	
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	public MethodList getCallers(Requirement requirement) {
		MethodList NewCallers= new MethodList();
		NewCallers.addAll(Callers);
		if(!this.Interfaces.isEmpty()) {
			for(Method inter: this.Interfaces) {
				if(!inter.Callers.isEmpty()) {
					inter.CallerInterfaceFlag=true; 


					NewCallers=NewCallers.AddAll(inter.Callers); 

				}
			}
		}

		if(!this.Superclasses.isEmpty()) {
			for(Method superclass: this.Superclasses) {
				if(!superclass.Callers.isEmpty()) {
					superclass.CallerSuperclassFlag=true; 

					NewCallers=NewCallers.AddAll(superclass.Callers); 

				}
			}
		}
		
		
		MethodList FinalCallers = new MethodList();
		for(Method Caller: NewCallers) {
			if(AlgoFinalRefactored.methodtraces2HashMap.get(requirement.ID+"-"+Caller.ID).prediction.equals("T") 
					||AlgoFinalRefactored.methodtraces2HashMap.get(requirement.ID+"-"+Caller.ID).prediction.equals("N")) {
				FinalCallers.add(Caller); 
			}
			else if(AlgoFinalRefactored.methodtraces2HashMap.get(requirement.ID+"-"+Caller.ID).prediction.equals("E") ) {
				if(!Caller.Owner.ID.equals(this.Owner.ID)){
					FinalCallers.add(Caller); 
				}else {


//					for(Method CallerOfCaller: Caller.getCallers(requirement)) {
//						FinalCallers.add(CallerOfCaller);
					for(Method CallerOfCaller: Caller.Callers) {
						if(AlgoFinalRefactored.methodtraces2HashMap.get(requirement.ID+"-"+CallerOfCaller.ID).prediction.equals("T") 
								||AlgoFinalRefactored.methodtraces2HashMap.get(requirement.ID+"-"+CallerOfCaller.ID).prediction.equals("N")) {
							FinalCallers.add(CallerOfCaller); 
						}
						else if(!CallerOfCaller.Owner.ID.equals(Caller.Owner.ID)
								&& AlgoFinalRefactored.methodtraces2HashMap.get(requirement.ID+"-"+CallerOfCaller.ID).prediction.equals("E")){
							FinalCallers.add(CallerOfCaller); 
						}
					}
				}
			}
		}
		return FinalCallers; 

	}
	
	
	
	
	
	
	
	
	
	public void setCallers(MethodList callers) {
		Callers = callers;
	}









}