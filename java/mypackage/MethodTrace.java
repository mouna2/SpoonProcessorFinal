package mypackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import ALGO.AlgoFinalRefactored;
import ALGO.DatabaseInput;
import ALGO.MethodList;
import ALGO.Methods;
import Chess.LogInfo;
import spoon.pattern.internal.SubstitutionRequestProvider;

public final class MethodTrace {
	public static boolean modified = false;
	public Method Method= new Method();
	public Requirement Requirement=new Requirement();
	public String gold;
	public String prediction; 
	public String goldfinal;
	public String likelihood;
	public String why;
	boolean SubjectDeveloperEqualityFlag;
	public Methods<String> SuperClassesListMethodTraces;
	public Methods<String> InterfaceListMethodTraces;
	public Methods<String> ChildrenListMethodTraces;
	public Methods<String> ImplementationListMethodTraces;

	public boolean TraceSet; 

	


	




	
	
	
	

	public boolean isSubjectDeveloperEqualityFlag() {
		return SubjectDeveloperEqualityFlag;
	}

	public String getPrediction() {
		return prediction;
	}



	public void setPrediction(String prediction) {
		this.prediction = prediction;
	}


	public void setSubjectDeveloperEqualityFlag(boolean subjectDeveloperEqualityFlag) {
		SubjectDeveloperEqualityFlag = subjectDeveloperEqualityFlag;
	}



	public boolean isTraceSet() {
		return TraceSet;
	}



	public void setTraceSet(boolean traceSet) {
		TraceSet = traceSet;
	}




	
	
	
	
	
	



	


	public MethodTrace() {
		
	}

	public Method getMethod() {
		return Method;
	}

	public void setMethod(Method method) {
		Method = method;
	}

	public Requirement getRequirement() {
		return Requirement;
	}

	public void setRequirement(Requirement requirement) {
		Requirement = requirement;
	}

	

	public String getGold() {
		return gold;
	}

	public void setGold(String gold) {
		this.gold = gold;
	}

	
	





	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////


	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	public void SetPrediction(LinkedHashMap<String, LogInfo> LogInfoHashMap, String Pred, String reason)
			
			
			{
		// TODO Auto-generated method stub
		List<String> CallerList= new ArrayList<String>(); 
		List<String> CalleeList= new ArrayList<String>(); 
		List<String> PredictionCallerList= new ArrayList<String>(); 
		List<String> PredictionCalleeList= new ArrayList<String>(); 
		
		
		List<String> OriginalCallerList= new ArrayList<String>(); 
		List<String> OriginalCalleeList= new ArrayList<String>(); 
		List<String> OriginalPredictionCallerList= new ArrayList<String>(); 
		List<String> OriginalPredictionCalleeList= new ArrayList<String>(); 
		
		
		List<String> CallerClassList= new ArrayList<String>(); 
		List<String> CalleeClassList= new ArrayList<String>(); 
		List<String> CallerClassPredictionList= new ArrayList<String>(); 
		List<String> CalleeClassPredictionList= new ArrayList<String>(); 
		
		
		List<String> SuperclassOwnerList= new ArrayList<String>(); 
		List<String> SuperclassOwnerPredictionList= new ArrayList<String>(); 
		List<String> ChildrenOwnerList= new ArrayList<String>(); 
		List<String> ChildrenOwnerPredictionList= new ArrayList<String>(); 
		List<String> InterfaceOwnerList= new ArrayList<String>(); 
		List<String> InterfaceOwnerPredictionList= new ArrayList<String>(); 
		List<String> ImplementationOwnerList= new ArrayList<String>(); 
		List<String> ImplementationOwnerPredictionList= new ArrayList<String>(); 
		
		List<String> PredictionOuterCallerList= new ArrayList<String>(); 
		List<String> PredictionOuterCalleeList= new ArrayList<String>(); 
		
		
		List<String> InterfaceCallerList= new ArrayList<String>(); 
		List<String> ImplementationCalleeList= new ArrayList<String>(); 
		List<String> InterfacePredictionCallerList= new ArrayList<String>(); 
		List<String> ImplementationPredictionCalleeList= new ArrayList<String>(); 
		
		
		List<String> SuperclassCallerList= new ArrayList<String>(); 
		List<String> ChildrenCalleeList= new ArrayList<String>(); 
		List<String> SuperclassPredictionCallerList= new ArrayList<String>(); 
		List<String> ChildrenPredictionCalleeList= new ArrayList<String>(); 
		
		if(this.prediction.trim().equals("E")) {
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).getIterationValues().add(reason);

			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setPrediction(Pred);
			for(Method caller: this.Method.getCallers(Requirement)) {
				CallerList.add(caller.toString()); 
				PredictionCallerList.add(AlgoFinalRefactored.methodtraces2HashMap.get(this.Requirement.ID+"-"+caller.ID).getPrediction()); 
			}
			for(Method callee: this.Method.getCallees(Requirement)) {
				CalleeList.add(callee.toString()); 
				PredictionCalleeList.add(AlgoFinalRefactored.methodtraces2HashMap.get(this.Requirement.ID+"-"+callee.ID).getPrediction()); 

			}
			for(Method caller: this.Method.getCallers(Requirement)) {
				if(!this.Method.Owner.ID.equals(caller.Owner.ID)) {
					PredictionOuterCallerList.add(AlgoFinalRefactored.methodtraces2HashMap.get(this.Requirement.ID+"-"+caller.ID).getPrediction()); 

				}
			}
			for(Method callee: this.Method.getCallees(Requirement)) {
				if(!this.Method.Owner.ID.equals(callee.Owner.ID)) {
					PredictionOuterCalleeList.add(AlgoFinalRefactored.methodtraces2HashMap.get(this.Requirement.ID+"-"+callee.ID).getPrediction()); 

				}

			}
			
			
			for(Method caller: this.Method.Callers) {
				OriginalCallerList.add(caller.toString()); 
				OriginalPredictionCallerList.add(AlgoFinalRefactored.methodtraces2HashMap.get(this.Requirement.ID+"-"+caller.ID).getPrediction()); 
			}
			for(Method callee: this.Method.Callees) {
				OriginalCalleeList.add(callee.toString()); 
				OriginalPredictionCalleeList.add(AlgoFinalRefactored.methodtraces2HashMap.get(this.Requirement.ID+"-"+callee.ID).getPrediction()); 

			}
			
			
			
			for(Clazz callerClass: this.Method.getOuterCallers(Requirement).getOwnerClasses(Requirement)) {
				CallerClassList.add(callerClass.toString()); 
				CallerClassPredictionList.add(DatabaseInput.classTraceHashMap.get(this.Requirement.ID+"-"+callerClass.ID).DeveloperGold); 
			}
			for(Clazz calleeClass: this.Method.getOuterCallees(Requirement).getOwnerClasses(Requirement)) {
				CalleeClassList.add(calleeClass.toString()); 
				CalleeClassPredictionList.add(DatabaseInput.classTraceHashMap.get(this.Requirement.ID+"-"+calleeClass.ID).DeveloperGold); 

			}
			
			
			
			for(Clazz imp: this.Method.Implementations.getOwnerClasses(Requirement)) {
				ImplementationOwnerList.add(imp.toString()); 
				ImplementationOwnerPredictionList.add(DatabaseInput.classTraceHashMap.get(this.Requirement.ID+"-"+imp.ID).DeveloperGold); 
			}
			for(Clazz inter: this.Method.Interfaces.getOwnerClasses(Requirement)) {
				InterfaceOwnerList.add(inter.toString()); 
				InterfaceOwnerPredictionList.add(DatabaseInput.classTraceHashMap.get(this.Requirement.ID+"-"+inter.ID).DeveloperGold); 
			}
			
			for(Clazz superclass: this.Method.Superclasses.getOwnerClasses(Requirement)) {
				SuperclassOwnerList.add(superclass.toString()); 
				SuperclassOwnerPredictionList.add(DatabaseInput.classTraceHashMap.get(this.Requirement.ID+"-"+superclass.ID).DeveloperGold); 
			}
			for(Clazz child: this.Method.Children.getOwnerClasses(Requirement)) {
				ChildrenOwnerList.add(child.toString()); 
				ChildrenOwnerList.add(DatabaseInput.classTraceHashMap.get(this.Requirement.ID+"-"+child.ID).DeveloperGold); 
			}
			
			
			
			
			
			
			
			
			for(Method caller: this.Method.getSuperclassCallers(Requirement)) {
				SuperclassCallerList.add(caller.toString()); 
				SuperclassPredictionCallerList.add(AlgoFinalRefactored.methodtraces2HashMap.get(this.Requirement.ID+"-"+caller.ID).getPrediction()); 

			}
			
			for(Method callee: this.Method.getChildrenCallees(Requirement)) {
				ChildrenCalleeList.add(callee.toString()); 
				ChildrenPredictionCalleeList.add(AlgoFinalRefactored.methodtraces2HashMap.get(this.Requirement.ID+"-"+callee.ID).getPrediction()); 
			}
		
			
			
			for(Method caller: this.Method.getInterfaceCallers(Requirement)) {
				InterfaceCallerList.add(caller.toString()); 
				InterfacePredictionCallerList.add(AlgoFinalRefactored.methodtraces2HashMap.get(this.Requirement.ID+"-"+caller.ID).getPrediction()); 

			}
			
			for(Method callee: this.Method.getImplementationCallees(Requirement)) {
				ImplementationCalleeList.add(callee.toString()); 
				ImplementationPredictionCalleeList.add(AlgoFinalRefactored.methodtraces2HashMap.get(this.Requirement.ID+"-"+callee.ID).getPrediction()); 
			}
			
			
			
			
			
			
			
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setOuterOwnerCallers(CallerClassList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setOuterOwnerCallersPredictions(CallerClassPredictionList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setOuterOwnerCallees(CalleeClassList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setOuterOwnerCalleesPredictions(CalleeClassPredictionList);
		
			
			
			
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setCallers(CallerList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setCallees(CalleeList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setCalleePredictions(PredictionCalleeList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setCallerPredictions(PredictionCallerList);
			
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setOriginalCallers(OriginalCallerList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setOriginalCallees(OriginalCalleeList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setOriginalCallerPredictions(OriginalPredictionCallerList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setOriginalCalleePredictions(OriginalPredictionCalleeList);
			
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setChildrenOwners(ChildrenOwnerList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setSuperclassOwners(SuperclassOwnerList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setImplementationOwners(ImplementationOwnerList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setInterfaceOwners(InterfaceOwnerList);
			
			
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setChildrenOwnersPredictions(ChildrenOwnerPredictionList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setSuperclassOwnersPredictions(SuperclassOwnerPredictionList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setImplementationOwnersPredictions(ImplementationOwnerPredictionList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setInterfaceOwnersPredictions(InterfaceOwnerPredictionList);
			
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setChildrenCallees(ChildrenCalleeList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setSuperclassCallers(SuperclassCallerList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setChildrenCalleePredictions(ChildrenPredictionCalleeList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setSuperclassCallerPredictions(SuperclassPredictionCallerList);
			
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setInterfaceCallers(InterfaceCallerList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setImplementationCallees(ImplementationCalleeList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setInterfaceCallerPredictions(InterfacePredictionCallerList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setImplementationCalleePredictions(ImplementationPredictionCalleeList);
			
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setOuterCalleesPredictions(PredictionCalleeList);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setOuterCallersPredictions(PredictionCallerList);
			this.prediction=Pred; 
			modified=true; 
		}
		

		
		
	}

	@Override
	public String toString() {
		return "MethodTrace [Method=" + Method.toString() + ", Requirement=" + Requirement + ", gold=" + gold + ", prediction="
				+ prediction + ", goldfinal=" + goldfinal + "]";
	}
	

}