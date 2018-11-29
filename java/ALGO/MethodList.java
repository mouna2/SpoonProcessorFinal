package ALGO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import mypackage.MethodTraceSubjectTSubjectN;

public class MethodList<String> extends ArrayList<String>{

	
	
//	MethodList<String> MethodList; 
	
	public MethodList<String> ConvertToMethodList(List<String> inputString)
	{
		this.addAll(inputString); 
		return this; 
	}
	
	
	






	
	
	
	public boolean AllMethodTracePredictionCalleesEqualT() {
		// TODO Auto-generated method stub
		
		if(!this.contains("N")  && this.contains("T") && !this.contains("E")) {
			return true;
		}
		return false;
	}
	
	public boolean AllMethodTracePredictionCallersContainsAtLeast1T() {
		// TODO Auto-generated method stub
		
		if(this.contains("T") ) {
			return true;
		}
		return false;
	}
	public boolean AllMethodTracePredictionCalleesContainsAtLeast1T() {
		// TODO Auto-generated method stub
		
		if(this.contains("T") ) {
			return true;
		}
		return false;
	}
	
	public boolean AllMethodTracePredictionCallersEqualT() {
		// TODO Auto-generated method stub
		
		if(!this.contains("N")  && this.contains("T") && !this.contains("E")) {
			return true;
		}
		return false;
	}
	
	
	public boolean AllMethodTracePredictionCalleesEqualN() {
		// TODO Auto-generated method stub
		
		if(!this.contains("T")  && this.contains("N") && !this.contains("E")) {
			return true;
		}
		return false;
	}
	
	
	
	
	public boolean AllMethodTracePredictionCallersEqualN() {
		// TODO Auto-generated method stub
		
		if(!this.contains("T")  && this.contains("N") && !this.contains("E")) {
			return true;
		}
		return false;
	}



	public boolean InterfaceMethodTraceValuesAllEqualT(boolean InterfacesFlag, List<String> interfaceTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(InterfacesFlag == true && interfaceTraceValues.get(0).equals("T")
				&& methodtrace.getPrediction().trim().equals("E")) {
			return true;
		}
		return false; 
	}
	
	
	
	public boolean ImplementationMethodTraceValuesAllEqualT(boolean ImplementationFlag, List<String> implementationTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(ImplementationFlag == true && implementationTraceValues.get(0).equals("T")
				&& methodtrace.getPrediction().trim().equals("E")) {
			return true;
		}
		return false; 
	}
	
	public boolean SuperclassMethodTraceValuesAllEqualT(boolean SuperclassFlag, List<String> superclassTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(SuperclassFlag == true && superclassTraceValues.get(0).equals("T")
				&& methodtrace.getPrediction().trim().equals("E")) {
			return true;
		}
		return false; 
	}
	
	public boolean ChildMethodTraceValuesAllEqualT(boolean ChildFlag, List<String> childTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(ChildFlag == true && childTraceValues.get(0).equals("T")
				&& methodtrace.getPrediction().trim().equals("E")) {
			return true;
		}
		return false; 
	}
	
	
	
	
	
	
	public boolean InterfaceMethodTraceValuesAllEqualN(boolean InterfacesFlag, List<String> interfaceTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(InterfacesFlag == true && interfaceTraceValues.get(0).equals("N")
				&& methodtrace.getPrediction().trim().equals("E")) {
			return true;
		}
		return false; 
	}
	
	
	
	public boolean ImplementationMethodTraceValuesAllEqualN(boolean ImplementationFlag, List<String> implementationTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(ImplementationFlag == true && implementationTraceValues.get(0).equals("N")
				&& methodtrace.getPrediction().trim().equals("E")) {
			return true;
		}
		return false; 
	}
	
	public boolean SuperclassMethodTraceValuesAllEqualN(boolean SuperclassFlag, List<String> superclassTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(SuperclassFlag == true && superclassTraceValues.get(0).equals("N")
				&& methodtrace.getPrediction().trim().equals("E")) {
			return true;
		}
		return false; 
	}
	
	public boolean ChildMethodTraceValuesAllEqualN(boolean ChildFlag, List<String> childTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
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
