package Chess;

import java.util.LinkedHashMap;

public class HashMapValue {
	String HashMapName; 
	Integer Fitness ;
	LinkedHashMap<String, String>  mylinkedHashMap= new LinkedHashMap<String, String>() ;
	public String getHashMapName() {
		return HashMapName;
	}
	public void setHashMapName(String hashMapName) {
		HashMapName = hashMapName;
	}
	public Integer getFitness() {
		return Fitness;
	}
	public void setFitness(Integer fitness) {
		Fitness = fitness;
	}
	public LinkedHashMap<String, String> getMylinkedHashMap() {
		return mylinkedHashMap;
	}
	public void setMylinkedHashMap(LinkedHashMap<String, String> mylinkedHashMap) {
		this.mylinkedHashMap = mylinkedHashMap;
	}
	public HashMapValue(String hashMapName, Integer fitness) {
		super();
		HashMapName = hashMapName;
		Fitness = fitness;
		//this.mylinkedHashMap = mylinkedHashMap;
	} 
	
	
	
	
	
	
	
}
