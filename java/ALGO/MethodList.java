package ALGO;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import mypackage.MethodTraceSubjectTSubjectN;
import mypackage.Requirement2;
import mypackage.*;
public class MethodList extends ArrayList<Method2Representation>{

	
//	MethodList<String> MethodList; 
	
	
	
	
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

	
	
	
	public boolean AllCalleesAreT() {
		// TODO Auto-generated method stub
		
		if(!this.contains("N")  && this.contains("T") && !this.contains("E")) {
			return true;
		}
		return false;
	}
	
	public boolean AtLeast1T(Requirement2 requirement, MethodTraceSubjectTSubjectN methodtrace, HashMap<java.lang.String, MethodTraceSubjectTSubjectN> methodtraces2HashMap, List<Method2Representation> calls) {
		// TODO Auto-generated method stub
		
		for (Method2Representation callee : this) {
			String RequirementID = (String) methodtrace.Requirement.ID;
			String MethodID = callee.methodid; 
			String key = (String) (RequirementID + "-" + MethodID);
//			if (methodtraces2HashMap.get(key) == null) {
//				try {
//					throw new Exception();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} 
//			}
			if (methodtraces2HashMap.get(key) != null) {
				if (methodtraces2HashMap.get(key).getPrediction().equals("T")) 
					return true; 

			}else {
				
			}
		}

		return false;
		
		
		
		
		
//		List<String> PredictionList = new ArrayList<String>();
//		for (Method2Representation callee : calls) {
//			String RequirementID = (String) methodtrace.Requirement.ID;
//			String MethodID = (String) callee.methodid;
//			String key = (String) (RequirementID + "-" + MethodID);
//			if (methodtraces2HashMap.get(key) != null) {
//				String predictionvalue = (String) methodtraces2HashMap.get(key).getPrediction();
//				PredictionList.add(predictionvalue);
//			}
//		}
//
//		if(PredictionList.contains("T") ) {
//			return true;
//		}
//		return false;
	}
	public boolean AtLeast1N(MethodTraceSubjectTSubjectN methodtrace, HashMap<java.lang.String, MethodTraceSubjectTSubjectN> methodtraces2HashMap, Requirement2 requirement, List<Method2Representation> calls) {
		// TODO Auto-generated method stub
		
		for (Method2Representation callee : this) {
			String RequirementID = (String) methodtrace.Requirement.ID;
			String MethodID = callee.methodid; 
			String key = (String) (RequirementID + "-" + MethodID);
//			if (methodtraces2HashMap.get(key) == null) {
//				try {
//					throw new Exception();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} 
//			}
			if (methodtraces2HashMap.get(key) != null) {
				if (methodtraces2HashMap.get(key).getPrediction().equals("N"))
					return true; 

			}else {
				
			}
		}
		return false;
		
//		List<String> PredictionList = new ArrayList<String>();
//		for (Method2Representation callee : calls) {
//			String RequirementID = (String) methodtrace.Requirement.ID;
//			String MethodID = (String) callee.methodid;
//			String key = (String) (RequirementID + "-" + MethodID);
//			if (methodtraces2HashMap.get(key) != null) {
//				String predictionvalue = (String) methodtraces2HashMap.get(key).getPrediction();
//				PredictionList.add(predictionvalue);
//			}
//		}
//
//		if(PredictionList.contains("N") ) {
//			return true;
//		}
//		return false;

		
	}
	
	public boolean AllCallersAreT() {
		// TODO Auto-generated method stub
		
		if(!this.contains("N")  && this.contains("T") && !this.contains("E")) {
			return true;
		}
		return false;
	}
	public boolean AllTs() {
		// TODO Auto-generated method stub
		
		if(!this.contains("N")  && this.contains("T") && !this.contains("E")) {
			return true;
		}
		return false;
	}
	
	
	public boolean AllCalleesAreN() {
		// TODO Auto-generated method stub
		
		if(!this.contains("T")  && this.contains("N") && !this.contains("E")) {
			return true;
		}
		return false;
	}
	
	
	public boolean AllNs(Requirement2 requirement, MethodTraceSubjectTSubjectN methodtrace, HashMap<java.lang.String, MethodTraceSubjectTSubjectN> methodtraces2HashMap, List<Method2Representation> calls) {
		// TODO Auto-generated method stub
		int counter=0; 
		for (Method2Representation callee : this) {
			String RequirementID = (String) methodtrace.Requirement.ID;
			String MethodID = callee.methodid; 
			String key = (String) (RequirementID + "-" + MethodID);
//			if (methodtraces2HashMap.get(key) == null) {
//				try {
//					throw new Exception();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} 
//			}
			if (methodtraces2HashMap.get(key) != null) {
				if (!methodtraces2HashMap.get(key).getPrediction().equals("N")) return false; 

			}else if(methodtraces2HashMap.get(key) == null){
				
				counter++; 
				if(counter==this.size()) {
					return false; 
				}
			}
		}
		return true;
		
		
//		List<String> PredictionList = new ArrayList<String>();
//		for (Method2Representation callee : calls) {
//			String RequirementID = (String) methodtrace.Requirement.ID;
//			String MethodID = (String) callee.methodid;
//			String key = (String) (RequirementID + "-" + MethodID);
//			if (methodtraces2HashMap.get(key) != null) {
//				String predictionvalue = (String) methodtraces2HashMap.get(key).getPrediction();
//				PredictionList.add(predictionvalue);
//			}
//		}
//
//		if(!PredictionList.contains("T")  && PredictionList.contains("N") && !PredictionList.contains("E")) {
//			return true;
//		}
//		return false;
		
	}
	
	
	public boolean AllCallersN(MethodTraceSubjectTSubjectN methodtrace, HashMap<java.lang.String, MethodTraceSubjectTSubjectN> methodtraces2HashMap, Requirement2 requirement) {
		// TODO Auto-generated method stub
		List<Method2Representation> CalleesList = methodtrace.getCalleesList();
		List<Method2Representation> CallersList = methodtrace.getCallersList();
		 

		List<String> PredictionList = new ArrayList<String>();
		for (Method2Representation callee : CallersList) {
			String RequirementID = (String) methodtrace.Requirement.ID;
			String MethodID = (String) callee.methodid;
			String key = (String) (RequirementID + "-" + MethodID);
			if (methodtraces2HashMap.get(key) != null) {
				String predictionvalue = (String) methodtraces2HashMap.get(key).getPrediction();
				PredictionList.add(predictionvalue);
			}
		}

		if(!PredictionList.contains("T")  && PredictionList.contains("N") && !PredictionList.contains("E")) {
			return true;
		}
		return false;
	}
	
	
	
	public boolean AllCalleesT(MethodTraceSubjectTSubjectN methodtrace, HashMap<java.lang.String, MethodTraceSubjectTSubjectN> methodtraces2HashMap, Requirement2 requirement) {
		// TODO Auto-generated method stub
		List<Method2Representation> CalleesList = methodtrace.getCalleesList();
		List<Method2Representation> CallersList = methodtrace.getCallersList();
		 

		List<String> PredictionList = new ArrayList<String>();
		for (Method2Representation callee : CalleesList) {
			String RequirementID = (String) methodtrace.Requirement.ID;
			String MethodID = (String) callee.methodid;
			String key = (String) (RequirementID + "-" + MethodID);
			if (methodtraces2HashMap.get(key) != null) {
				String predictionvalue = (String) methodtraces2HashMap.get(key).getPrediction();
				PredictionList.add(predictionvalue);
			}
		}

		if(PredictionList.contains("T")  && !PredictionList.contains("N") && !PredictionList.contains("E")) {
			return true;
		}
		return false;
	}
	
	public boolean AllTs(Requirement2 requirement, MethodTraceSubjectTSubjectN methodtrace, HashMap<java.lang.String, MethodTraceSubjectTSubjectN> methodtraces2HashMap, List<Method2Representation> calls) {
		// TODO Auto-generated method stub
		int counter=0; 
		for (Method2Representation callee : this) {
			String RequirementID = (String) methodtrace.Requirement.ID;
			String MethodID = callee.methodid; 
			String key = (String) (RequirementID + "-" + MethodID);

			if (methodtraces2HashMap.get(key) != null) {
				if (!methodtraces2HashMap.get(key).getPrediction().equals("T")) return false; 

			}else if(methodtraces2HashMap.get(key) == null){
				
				counter++; 
				if(counter==this.size()) {
					return false; 
				}
			}
		}
		return true;
		
		

		
	}
	
//	public boolean AllTs(Requirement2 requirement, MethodTraceSubjectTSubjectN methodtrace, HashMap<java.lang.String, MethodTraceSubjectTSubjectN> methodtraces2HashMap, List<Method2Representation> calls) {
//		// TODO Auto-generated method stub
//		
//		for (Method2Representation callee : this) {
//			String RequirementID = (String) methodtrace.Requirement.ID;
//			String MethodID = callee.methodid; 
//			String key = (String) (RequirementID + "-" + MethodID);
////			if (methodtraces2HashMap.get(key) == null) {
////				try {
////					throw new Exception();
////				} catch (Exception e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				} 
////			}
//			if (methodtraces2HashMap.get(key) != null) {
//				if (!methodtraces2HashMap.get(key).getPrediction().equals("T")) 
//					return false; 
//
//			}else {
//				return false; 
//			}
//		}
//
//		return true;
//		
//		
//		
////		List<String> PredictionList = new ArrayList<String>();
////		for (Method2Representation callee : calls) {
////			String RequirementID = (String) methodtrace.Requirement.ID;
////			String MethodID = (String) callee.methodid;
////			String key = (String) (RequirementID + "-" + MethodID);
////			if (methodtraces2HashMap.get(key) != null) {
////				String predictionvalue = (String) methodtraces2HashMap.get(key).getPrediction();
////				PredictionList.add(predictionvalue);
////			}
////		}
////
////		if(PredictionList.contains("T") && !PredictionList.contains("E") && !PredictionList.contains("N") ) {
////			return true;
////		}
////		return false;
//	}
//	public boolean AllCallersAreN() {
//		// TODO Auto-generated method stub
//		
//		if(!this.contains("T")  && this.contains("N") && !this.contains("E")) {
//			return true;
//		}
//		return false;
//	}
//
//
//
//	public boolean AllTs(boolean InterfacesFlag, List<String> interfaceTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
//		// TODO Auto-generated method stub
//		
//		if(InterfacesFlag == true && interfaceTraceValues.get(0).equals("T")
//				&& methodtrace.getPrediction().trim().equals("E")) {
//			return true;
//		}
//
//		return false; 
//	}
//	
//	

	
	
	
	
	
	
	public boolean AllNs(boolean InterfacesFlag, List<String> interfaceTraceValues, MethodTraceSubjectTSubjectN methodtrace) {
		// TODO Auto-generated method stub
		
		if(InterfacesFlag == true && interfaceTraceValues.get(0).equals("N")
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