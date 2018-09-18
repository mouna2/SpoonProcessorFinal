package mypackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MethodField2 {
	String ID; 
	 String FieldName;
	 ClassRepresentation2 MethodFieldType; 
	 ClassRepresentation2 OwnerClass;
		List<MethodField2> myfieldmethods= new ArrayList<MethodField2>(); 
		HashMap<String, List<MethodField2>> ClassRepresentationHashMapMethodField= new HashMap<String, List<MethodField2>>(); 
		
		
	
	public List<MethodField2> getMyfieldmethods() {
			return myfieldmethods;
		}
		public void setMyfieldmethods(List<MethodField2> myfieldmethods) {
			this.myfieldmethods = myfieldmethods;
		}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFieldName() {
		return FieldName;
	}
	public void setFieldName(String fieldName) {
		FieldName = fieldName;
	}
	public ClassRepresentation2 getMethodFieldType() {
		return MethodFieldType;
	}
	public void setMethodFieldType(ClassRepresentation2 methodFieldType) {
		MethodFieldType = methodFieldType;
	}
	public ClassRepresentation2 getOwnerClass() {
		return OwnerClass;
	}
	public void setOwnerClass(ClassRepresentation2 ownerClass) {
		OwnerClass = ownerClass;
	}
	public MethodField2(String iD, String fieldName, ClassRepresentation2 methodFieldType,
			ClassRepresentation2 ownerClass) {
		super();
		ID = iD;
		FieldName = fieldName;
		MethodFieldType = methodFieldType;
		OwnerClass = ownerClass;
	}
	public MethodField2() {
		// TODO Auto-generated constructor stub
	}
	 
	public  HashMap<String, List<MethodField2>> ReadMethodFields(Connection conn) throws SQLException {
		// Rule: if method A calls method B and method A implements requirement X, then I can just assume that method B implements requirement X as well 
		// Retrieving the calleeid
		DatabaseReading2 db = new DatabaseReading2(); 
	
		//CLASSESHASHMAP
		String rowcount = null; 
		Statement st = conn.createStatement();
		ResultSet var = st.executeQuery("select count(*) from fieldmethods"); 
		while(var.next()){
			rowcount = var.getString("count(*)");
		}
		System.out.println("ROW COUNT::::::"+rowcount); 
		int rowcountint= Integer.parseInt(rowcount); 
	
		int index=1; 
		 ResultSet myresults = st.executeQuery("SELECT fieldmethods.* from fieldmethods "); 
		 while(myresults.next()) {
			 	MethodField2 mymethodfield = new MethodField2(); 
			 
			 	ClassRepresentation2 FieldType= new ClassRepresentation2();
			     String fieldtypeclassid = myresults.getString("fieldtypeclassid"); 			
				 String fieldtype = myresults.getString("fieldtype"); 
				 FieldType.setClassid(fieldtypeclassid);
				 FieldType.setClassname(fieldtype);
				 
				 ClassRepresentation2 OwnerClass= new ClassRepresentation2();
				 String ownerclassid = myresults.getString("ownerclassid"); 			
				 String classname = myresults.getString("classname"); 
				 OwnerClass.setClassid(ownerclassid);
				 OwnerClass.setClassname(classname);
				 
				 mymethodfield.setMethodFieldType(FieldType);
				 mymethodfield.setOwnerClass(OwnerClass);
				 
				 String key=ownerclassid;
				 if(ClassRepresentationHashMapMethodField.get(key)!=null) {
					 List<MethodField2> mymethodfields= ClassRepresentationHashMapMethodField.get(key); 
					 mymethodfields.add(mymethodfield); 
					 ClassRepresentationHashMapMethodField.put(key, mymethodfields); 
				 }else {
					 List<MethodField2> mymethodfields= new ArrayList<MethodField2>(); 
					 mymethodfields.add(mymethodfield); 
					 ClassRepresentationHashMapMethodField.put(key, mymethodfields); 
				 }
				 
				 
				 index++; 
				 System.out.println("index 6 "+index);
		 }
		
			System.out.println("FIELD TYPE CLASSES");
			/* for(Integer key: keys){
		            System.out.println("Value of "+key+" is: "+ resultFieldClasses.get(key).classid+ "   "+resultFieldClasses.get(key).classname+ "   ");
		        }*/
		
		 return ClassRepresentationHashMapMethodField; 
	}
	 
	 
	 
}
