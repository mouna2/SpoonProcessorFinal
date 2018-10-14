package mypackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parameter2 {
	String parameterName; 
	ClassRepresentation2 ParameterType;
	ClassRepresentation2 OwnerClass;
	String isReturn;
	Method2Representation method; 
	List<Parameter2> myparameters= new ArrayList<Parameter2>(); 
	String methodname; 
	
	public String getMethodname() {
		return methodname;
	}
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}
	HashMap<String, List<Parameter2>> ParameterHashMap= new HashMap<String, List<Parameter2>>();  
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	
	
	public Method2Representation getMethod() {
		return method;
	}
	public void setMethod(Method2Representation method) {
		this.method = method;
	}
	public ClassRepresentation2 getParameterType() {
		return ParameterType;
	}
	public void setParameterType(ClassRepresentation2 parameterType) {
		ParameterType = parameterType;
	}
	public ClassRepresentation2 getOwnerClass() {
		return OwnerClass;
	}
	public void setOwnerClass(ClassRepresentation2 ownerClass) {
		OwnerClass = ownerClass;
	}
	public String getIsReturn() {
		return isReturn;
	}
	public void setIsReturn(String isReturn) {
		this.isReturn = isReturn;
	}
	public Parameter2(String parameterName, ClassRepresentation2 parameterType, ClassRepresentation2 ownerClass,
			String isReturn) {
		super();
		this.parameterName = parameterName;
		ParameterType = parameterType;
		OwnerClass = ownerClass;
		this.isReturn = isReturn;
	}
	public Parameter2() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "Parameter2 [parameterName=" + parameterName + ", ParameterType=" + ParameterType + ", OwnerClass="
				+ OwnerClass + ", isReturn=" + isReturn + ", method=" + method + ", ParameterHashMap="
				+ ParameterHashMap + "]";
	}
	public  HashMap<String, List<Parameter2>> ReadParams(Connection conn) throws SQLException {
		// Rule: if method A calls method B and method A implements requirement X, then I can just assume that method B implements requirement X as well 
		// Retrieving the calleeid
		DatabaseReading2 db = new DatabaseReading2(); 
	
		//CLASSESHASHMAP
		String rowcount = null; 
		Statement st = conn.createStatement();
		ResultSet var = st.executeQuery("select count(*) from parameters"); 
		while(var.next()){
			rowcount = var.getString("count(*)");
		}
		System.out.println("ROW COUNT::::::"+rowcount); 
		int rowcountint= Integer.parseInt(rowcount); 
	
		int index=1; 
		 ResultSet myresults = st.executeQuery("SELECT parameters.* from parameters "); 
		 while(myresults.next()) {
			 	Parameter2 parameter = new Parameter2(); 
			 
			 	ClassRepresentation2 ParameterType= new ClassRepresentation2();
			     String fieldtypeclassid = myresults.getString("parameterclass"); 			
				 String fieldtype = myresults.getString("parametertype"); 
//				 String fieldtype = myresults.getString("fieldtype"); 

				 ParameterType.setClassid(fieldtypeclassid);
				 ParameterType.setClassname(fieldtype);
				 
				 ClassRepresentation2 OwnerClass= new ClassRepresentation2();
				 String ownerclassid = myresults.getString("classid"); 			
				 String classname = myresults.getString("classname"); 
//				 String classname = myresults.getString("classname"); 
				 OwnerClass.setClassid(ownerclassid);
				 OwnerClass.setClassname(classname);
				 
				 
				 Method2Representation methodrep= new Method2Representation();
				 String ownermethodid = myresults.getString("methodid"); 			
				 String ownermethodname = myresults.getString("methodname"); 
//				 String classname = myresults.getString("classname"); 
				 methodrep.setMethodid(ownermethodid);
				 methodrep.setMethodname(ownermethodname);
				 String isReturn = myresults.getString("isreturn"); 
				 
				 parameter.setParameterType(ParameterType);
				 parameter.setOwnerClass(OwnerClass);
				 parameter.setMethod(methodrep);
				 parameter.setIsReturn(isReturn);
				 
				 
				 String key=ownermethodid;
				 if(ParameterHashMap.get(key)!=null) {
					 List<Parameter2> myparams= ParameterHashMap.get(key); 
					 myparams.add(parameter); 
					 ParameterHashMap.put(key, myparams); 
				 }else {
					 List<Parameter2> myparams= new ArrayList<Parameter2>(); 
					 myparams.add(parameter); 
					 ParameterHashMap.put(key, myparams); 
				 }
				 
				 
				 index++; 
				 System.out.println("index 6 "+index);
		 }
		
			System.out.println("FIELD TYPE CLASSES");
			/* for(Integer key: keys){
		            System.out.println("Value of "+key+" is: "+ resultFieldClasses.get(key).classid+ "   "+resultFieldClasses.get(key).classname+ "   ");
		        }*/
		
		 return ParameterHashMap; 
	}
	 
	
	
}
