package ALGO;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import mypackage.MethodTrace;
import mypackage.Requirement2;
import mypackage.*;
public class MethodList extends ArrayList<Method>{

	
//	MethodList<String> MethodList; 
	
	
	




	
	

	
	public boolean AtLeast1T(Requirement2 requirement,  HashMap<java.lang.String, MethodTrace> methodtraces2HashMap) throws Exception {
		// TODO Auto-generated method stub
		
		for (Method method : this) {
			String RequirementID = (String) requirement.ID; 
			String MethodID = method.ID; 
			String key = (String) (RequirementID + "-" + MethodID);
			if (methodtraces2HashMap.get(key) == null) throw new Exception();
				if (methodtraces2HashMap.get(key).getPrediction().equals("T")) 
					return true; 

			
		}

		return false;
		
		
		
		
		

	}
	public boolean AtLeast1N(HashMap<java.lang.String, MethodTrace> methodtraces2HashMap, Requirement2 requirement) throws Exception {
		// TODO Auto-generated method stub
		
		for (Method method : this) {
			String RequirementID = (String) requirement.ID;
			String MethodID = method.ID; 
			String key = (String) (RequirementID + "-" + MethodID);
			if (methodtraces2HashMap.get(key) == null) throw new Exception();
				if (methodtraces2HashMap.get(key).getPrediction().equals("N"))
					return true; 

			
		}
		return false;


		
	}
	
	
	
	
	
	
	public boolean AllNs(Requirement2 requirement,  HashMap<java.lang.String, MethodTrace> methodtraces2HashMap) throws Exception {
		// TODO Auto-generated method stub
		if(!this.isEmpty()) {
			for (Method method : this) {
				String RequirementID = (String) requirement.ID;
				String MethodID = method.ID; 
				String key = (String) (RequirementID + "-" + MethodID);
				if (methodtraces2HashMap.get(key) == null) throw new Exception();
					if (!methodtraces2HashMap.get(key).getPrediction().equals("N")) return false; 

				
			}
			return true;
		}
		
		return false; 
		

		
	}
	
	
	
	
	public boolean AllTs(Requirement2 requirement, HashMap<java.lang.String, MethodTrace> methodtraces2HashMap) throws Exception {
		// TODO Auto-generated method stub
		if(!this.isEmpty()) {
			for (Method method : this) {

				MethodTrace trace = methodtraces2HashMap.get(requirement.ID + "-" + method.ID);
				if (trace == null) 	throw new Exception();
				if (!trace.getPrediction().equals("T")) return false; 
			}
			return true;
		}
		
		return false; 
		

		
	}
	

	
	
	
	
	
	
	



















	
























	

	
}