package ALGO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import mypackage.Method2Representation;
import mypackage.MethodTraceSubjectTSubjectN;
import mypackage.Requirement2;

public class MethodList<String> extends ArrayList<String>{

	
//	MethodList<String> MethodList; 
	
	public MethodList<String> ConvertToMethodList(List<String> inputString)
	{	this.clear();
		for(String st: inputString) {
			this.add(st); 
		}
		return this; 
	}
	
	
	
	public boolean AllCallersAreNWithAtLeast2N() {
		// TODO Auto-generated method stub
		
		int occurrences = Collections.frequency(this, "N");

		if(!this.contains("T")  && this.contains("N") && !this.contains("E") && occurrences>=2) {
			return true;
		}
		return false;
	}



	public boolean AllCallersAreTWithAtLeast2T() {
		// TODO Auto-generated method stub
	
		int occurrences = Collections.frequency(this, "T");

		if(!this.contains("N")  && this.contains("T") && !this.contains("E") && occurrences>=2) {
			return true;
		}
		return false;
	}

	
	
	
	
	
	public boolean SomeCallerIsT() {
		// TODO Auto-generated method stub
		
		if(this.contains("T") ) {
			return true;
		}
		return false;
	}
	public boolean SomeCalleeIsT() {
		// TODO Auto-generated method stub
		
		if(this.contains("T") ) {
			return true;
		}
		return false;
	}
	
	public boolean AllCallersAreT(Requirement2 requirement, HashMap<Method2Representation, HashMap<Requirement2, String>> finalMethodHashMapReqGolds, Method2Representation methodrep, MethodTraceSubjectTSubjectN method) {
		// TODO Auto-generated method stub
		
		List<String> mycallers= new ArrayList<String>(); 
		for( Method2Representation mycaller: method.getCallersList()) {
			HashMap<Requirement2, String> reqPredictionsHashMap = finalMethodHashMapReqGolds.get(methodrep); 
			String value=reqPredictionsHashMap.get(requirement); 
			mycallers.add(value); 
		}
		
		if(!mycallers.contains("N")  && mycallers.contains("T") && !mycallers.contains("E")) {
			return true;
		}
		return false;
	}
	
	
	public boolean AllCalleesAreT(Requirement2 requirement, HashMap<Method2Representation, HashMap<Requirement2, String>> finalMethodHashMapReqGolds, Method2Representation methodrep, MethodTraceSubjectTSubjectN method) {
		// TODO Auto-generated method stub
		
		List<String> mycallers= new ArrayList<String>(); 
		for( Method2Representation mycaller: method.getCalleesList()) {
			HashMap<Requirement2, String> reqPredictionsHashMap = finalMethodHashMapReqGolds.get(methodrep); 
			String value=reqPredictionsHashMap.get(requirement); 
			mycallers.add(value); 
		}
		
		if(!mycallers.contains("N")  && mycallers.contains("T") && !mycallers.contains("E")) {
			return true;
		}
		return false;
	}
	
	
	public boolean AllNs(Requirement2 requirement, HashMap<Method2Representation, HashMap<Requirement2, String>> finalMethodHashMapReqGolds, Method2Representation methodrep, MethodTraceSubjectTSubjectN method) {
		// TODO Auto-generated method stub
		
		List<String> mycallers= new ArrayList<String>(); 
		for( Method2Representation mycaller: method.getCallersList()) {
			HashMap<Requirement2, String> reqPredictionsHashMap = finalMethodHashMapReqGolds.get(methodrep); 
			String value=reqPredictionsHashMap.get(requirement); 
			mycallers.add(value); 
		}
		
		if(mycallers.contains("N")  && !mycallers.contains("T") && !mycallers.contains("E")) {
			return true;
		}
		return false;
	}
	
	
	
	
	public boolean AllNs() {
		// TODO Auto-generated method stub
		
		if(!this.contains("T")  && this.contains("N") && !this.contains("E")) {
			return true;
		}
		return false;
	}
	
	
	public boolean AllTs() {
		// TODO Auto-generated method stub
		
		if(this.contains("T") && !this.contains("N")&& !this.contains("E")) {
			return true; 
		}

		return false; 
	}
	
	
	
	


	public boolean AllTs(boolean InterfacesFlag, List<String> interfaceTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(InterfacesFlag == true && interfaceTraceValues.get(0).equals("T")
				&& methodtrace.getPrediction().trim().equals("E")) {
			return true;
		}

		return false; 
	}
	
	
	
	public boolean AllImplementationsAreT(boolean ImplementationFlag, List<String> implementationTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(ImplementationFlag == true && implementationTraceValues.get(0).equals("T")
				&& methodtrace.getPrediction().trim().equals("E")) {
			return true;
		}
		

		return false; 
	}
	
	public boolean AllSuperclassesAreT(boolean SuperclassFlag, List<String> superclassTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(SuperclassFlag == true && superclassTraceValues.get(0).equals("T")
				&& methodtrace.getPrediction().trim().equals("E")) {
			return true;
		}

		return false; 
	}
	
	public boolean AllChildrenAreT(boolean ChildFlag, List<String> childTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(ChildFlag == true && childTraceValues.get(0).equals("T")
				&& methodtrace.getPrediction().trim().equals("E")) {
			return true;
		}
		

		return false; 
	}
	
	
	
	
	
	
	public boolean AllNs(boolean InterfacesFlag, List<String> interfaceTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(InterfacesFlag == true && interfaceTraceValues.get(0).equals("N")
				&& methodtrace.getPrediction().trim().equals("E")) {
			return true;
		}

		return false; 
	}
	
	
	
	public boolean AllImplementationsAreN(boolean ImplementationFlag, List<String> implementationTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(ImplementationFlag == true && implementationTraceValues.get(0).equals("N")
				&& methodtrace.getPrediction().trim().equals("E")) {
			return true;
		}
		

		return false; 
	}
	
	public boolean AllSuperclassesAreN(boolean SuperclassFlag, List<String> superclassTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(SuperclassFlag == true && superclassTraceValues.get(0).equals("N")
				&& methodtrace.getPrediction().trim().equals("E")) {
			return true;
		}
		

		return false; 
	}
	
	public boolean AllChildrenAreN(boolean ChildFlag, List<String> childTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(ChildFlag == true && childTraceValues.get(0).equals("N")
				&& methodtrace.getPrediction().trim().equals("E")) {
			return true;
		}
		

		return false; 
	}










	public java.lang.String[] split(java.lang.String string) {
		// TODO Auto-generated method stub
		java.lang.String[] splitted = string.split("-");
		return splitted;
	}










	
























	

	
}
