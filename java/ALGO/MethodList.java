package ALGO;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import mypackage.*;
public class MethodList extends ArrayList<Method>{

	
	
	
	




	
	

	
	public boolean AtLeast1T(Requirement requirement,  HashMap<java.lang.String, MethodTrace> methodtraces2HashMap) throws Exception {
		// TODO Auto-generated method stub
		if(!this.isEmpty()) {
		for (Method method : this) {
			String RequirementID = (String) requirement.ID; 
			String MethodID = method.ID; 
			String key = (String) (RequirementID + "-" + MethodID);
			if (methodtraces2HashMap.get(key) == null) throw new Exception();
				if (methodtraces2HashMap.get(key).getPrediction().equals("T")) 
					return true; 

			
		}
		}
		return false;
		
		
		
		
		

	}
	
	
	
	
	public boolean AtLeast1N(Requirement requirement,  HashMap<java.lang.String, MethodTrace> methodtraces2HashMap) throws Exception {
		// TODO Auto-generated method stub
		if(!this.isEmpty()) {
			for (Method method : this) {
				String RequirementID = (String) requirement.ID; 
				String MethodID = method.ID; 
				String key = (String) (RequirementID + "-" + MethodID);
				if (methodtraces2HashMap.get(key) == null) throw new Exception();
					if (methodtraces2HashMap.get(key).getPrediction().equals("N")) 
						return true; 

				
			}
		}
		

		return false;
		
		
		
		
		

	}
	
	
	
	
	
	
	
	public boolean AllNs(Requirement requirement,  HashMap<java.lang.String, MethodTrace> methodtraces2HashMap) throws Exception {
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
	
	
	
	
	public boolean AllTs(Requirement requirement, HashMap<java.lang.String, MethodTrace> methodtraces2HashMap) throws Exception {
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
	

	
	
	
	
	
	
	





	public MethodList AddAll(MethodList MethodList) {
		
		this.addAll(MethodList); 
//		for(Method meth: MethodList) {
//			this.add(meth); 
//		}
		MethodList NewMethodList = removeDuplicates(this); 
		return NewMethodList; 
	}


	 // Function to remove duplicates from an ArrayList 
    public static MethodList removeDuplicates(MethodList list) 
    { 
  
        // Create a new ArrayList 
    	MethodList newList = new MethodList(); 
  
        // Traverse through the first list 
        for (Method element : list) { 
  
            // If this element is not present in newList 
            // then add it 
            if (!newList.contains(element)) { 
  
                newList.add(element); 
            } 
        } 
  
        // return the new list 
        return newList; 
    } 










	
























	

	
}