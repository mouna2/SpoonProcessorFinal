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
		
		if(this.prediction.trim().equals("E")) {
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).getIterationValues().add(reason);
			LogInfoHashMap.get(this.Requirement.ID+"-"+this.Method.ID).setPrediction(Pred);
			
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