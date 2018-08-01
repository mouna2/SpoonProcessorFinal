package mypackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Interface2 {
	String ID; 
	public ClassRepresentation2 InterfaceClass; 
	public ClassRepresentation2 OwnerClass;
	 HashMap<String, Interface2> ClassRepresentationHashMap= new HashMap<String, Interface2>(); 

	public Interface2(String iD, ClassRepresentation2 interfaceClass, ClassRepresentation2 ownerClass) {
		super();
		ID = iD;
		InterfaceClass = interfaceClass;
		OwnerClass = ownerClass;
	}
	public Interface2() {
		// TODO Auto-generated constructor stub
	}
	public String getID() {
		return ID;
	}
	public void setID(String id) {
		ID = id;
	}
	public ClassRepresentation2 getInterfaceClass() {
		return InterfaceClass;
	}
	public void setInterfaceClass(ClassRepresentation2 interfaceClass) {
		InterfaceClass = interfaceClass;
	}
	public ClassRepresentation2 getOwnerClass() {
		return OwnerClass;
	}
	public void setOwnerClass(ClassRepresentation2 ownerClass) {
		OwnerClass = ownerClass;
	}
	@Override
	public String toString() {
		return "Interface2 [ID=" + ID + ", InterfaceClass=" + InterfaceClass + ", OwnerClass=" + OwnerClass + "]";
	}
	 
	
	public  HashMap<String, Interface2> ReadInterfacesRepresentations(Connection conn) throws SQLException {
		// Rule: if method A calls method B and method A implements requirement X, then I can just assume that method B implements requirement X as well 
		// Retrieving the calleeid
		DatabaseReading2 db = new DatabaseReading2(); 
	
		//CLASSESHASHMAP
		String rowcount = null; 
		Statement st = conn.createStatement();
		ResultSet var = st.executeQuery("select count(*) from interfaces"); 
		while(var.next()){
			rowcount = var.getString("count(*)");
		}
		System.out.println("ROW COUNT::::::"+rowcount); 
		int rowcountint= Integer.parseInt(rowcount); 
	
		int index=1; 
		 ResultSet myresults = st.executeQuery("SELECT interfaces.* from interfaces "); 
		 while(myresults.next()) {
			 	Interface2 myinterface= new Interface2();
			 	ClassRepresentation2 InterfaceClass= new ClassRepresentation2();
			     String interfaceclassid = myresults.getString("interfaceclassid"); 			
				 String interfacename = myresults.getString("interfacename"); 
				 InterfaceClass.setClassid(interfaceclassid);
				 InterfaceClass.setClassname(interfacename);
				 
				 ClassRepresentation2 OwnerClass= new ClassRepresentation2();
				 String ownerclassid = myresults.getString("ownerclassid"); 			
				 String classname = myresults.getString("classname"); 
				 OwnerClass.setClassid(ownerclassid);
				 OwnerClass.setClassname(classname);
				 
				 myinterface.setInterfaceClass(InterfaceClass);
				 myinterface.setOwnerClass(OwnerClass);
				 
				 String key=ownerclassid+"-"+classname;
				 
				
				 ClassRepresentationHashMap.put(key, myinterface); 
				 index++; 
		 }
		
			System.out.println("FIELD TYPE CLASSES");
			/* for(Integer key: keys){
		            System.out.println("Value of "+key+" is: "+ resultFieldClasses.get(key).classid+ "   "+resultFieldClasses.get(key).classname+ "   ");
		        }*/
		
		 return ClassRepresentationHashMap; 
	}
	
	
	
	public  HashMap<String, Interface2> ReadInterfacesRepresentationsAlreadyImpl(Connection conn) throws SQLException {
		// Rule: if method A calls method B and method A implements requirement X, then I can just assume that method B implements requirement X as well 
		// Retrieving the calleeid
		DatabaseReading2 db = new DatabaseReading2(); 
	
		//CLASSESHASHMAP
		String rowcount = null; 
		Statement st = conn.createStatement();
		ResultSet var = st.executeQuery("select count(*) from interfaces"); 
		while(var.next()){
			rowcount = var.getString("count(*)");
		}
		System.out.println("ROW COUNT::::::"+rowcount); 
		int rowcountint= Integer.parseInt(rowcount); 
	
		int index=1; 
		 ResultSet myresults = st.executeQuery("SELECT interfaces.* from interfaces "); 
		 while(myresults.next()) {
			 	Interface2 myinterface= new Interface2();
			 	ClassRepresentation2 InterfaceClass= new ClassRepresentation2();
			     String interfaceclassid = myresults.getString("interfaceclassid"); 			
				 String interfacename = myresults.getString("interfacename"); 
				 InterfaceClass.setClassid(interfaceclassid);
				 InterfaceClass.setClassname(interfacename);
				 
				 ClassRepresentation2 OwnerClass= new ClassRepresentation2();
				 String ownerclassid = myresults.getString("ownerclassid"); 			
				 String classname = myresults.getString("classname"); 
				 OwnerClass.setClassid(ownerclassid);
				 OwnerClass.setClassname(classname);
				 
				 myinterface.setInterfaceClass(InterfaceClass);
				 myinterface.setOwnerClass(OwnerClass);
				 
				 String key=interfaceclassid+"-"+interfacename;
				 
				
				 ClassRepresentationHashMap.put(key, myinterface); 
				 index++; 
		 }
		
			System.out.println("FIELD TYPE CLASSES");
			/* for(Integer key: keys){
		            System.out.println("Value of "+key+" is: "+ resultFieldClasses.get(key).classid+ "   "+resultFieldClasses.get(key).classname+ "   ");
		        }*/
		
		 return ClassRepresentationHashMap; 
	}
	
}
