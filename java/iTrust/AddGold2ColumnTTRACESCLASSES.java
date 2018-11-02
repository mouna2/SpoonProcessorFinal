package iTrust;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Pattern;

import Chess.DBDemo2;
import spoon.Launcher;
import spoon.SpoonAPI;

public class AddGold2ColumnTTRACESCLASSES {
	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";
	
	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "root";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */

	private final int portNumber = 3306;
	
	private final String dbName = "databaseitrust";

	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("root", this.userName);
		connectionProps.put("123456", this.password);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseitrust","root","123456");

		return conn;
	}

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(command); // This will throw a SQLException if it fails
	        return true;
	    } finally {

	    	// This will run whether we throw an exception or not
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	/**
	 * Connect to MySQL and do some stuff.
	 * @throws SQLException 
	 */
	public void run() throws SQLException {
		ResultSet rs = null; 
		// Connect to MySQL
		Connection conn = null;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}
	
		// Create a table
		try {
			Statement st= conn.createStatement();

		   
		  
			  
		
		  
		   
		   
		
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		}
		
		
	}
	
	public static void main(String[] args) throws SQLException, IOException {
		//AddColumns();
		AddColumns2(); 
	}

	public static void AddColumns() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		DBDemo3iTrust DatabaseReading = new DBDemo3iTrust();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
		//st.executeUpdate("ALTER TABLE `traces` DROP COLUMN SubjectT"); 
//		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN subject");
//		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold");
//		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold2");
//		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold3");
//		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold4");
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD subject LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold2 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold3 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold4 LONGTEXT"); 

		int  TracesNumber=0; 
		int counter=0; 
		String mytraceclass=""; 
		String classid=""; 
		String requirementid= ""; 
		String gold2=""; 
		String gold=""; 
		String subject=""; 
		Hashtable<String,List<String>> RequirementClassHashMap=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMap2=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMapSubject=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMap2Subject=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMapGOLD=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMap2GOLD=new Hashtable<String,List<String>>(); 
		List<String> mylist= new ArrayList<String>(); 
		ResultSet TracesCount=st.executeQuery("SELECT COUNT(*) FROM traces"); 
		while(TracesCount.next()) {
			 TracesNumber= TracesCount.getInt(1); 
			System.out.println(TracesNumber);
		}
		
		while(counter<TracesNumber) {
			ResultSet traces = st.executeQuery("SELECT traces.* from traces where id='"+counter+"'"); 
			while(traces.next()){		
				//THIS IS GOLD 2
				 requirementid=traces.getString("requirementid").trim(); 
				 classid=traces.getString("classid").trim(); 
				 gold=traces.getString("gold").trim(); 
				 subject=traces.getString("subject").trim(); 
				String ReqClass=requirementid+"-"+classid;
				RequirementClassHashMap.put(ReqClass, mylist); 

			
	   		   }
			counter++; 
		}
		
		counter=0; 
		for (Entry<String, List<String>> entry : RequirementClassHashMap.entrySet()) {
			   System.out.println(counter + " COUNTER " );

		    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
		     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
		     List<String> List= new ArrayList<String>(); 
		     List<String> SubjectList= new ArrayList<String>(); 
		     List<String> GoldList= new ArrayList<String>(); 
		 	ResultSet traces = st.executeQuery("SELECT traces.* from traces where requirementid='"+requirementid+"' and classid='"+classid+"'"); 
			while(traces.next()){		
				//THIS IS GOLD 2
				
				gold=null; 
				subject=null; 
				gold2=null; 
				
				
				 requirementid=traces.getString("requirementid").trim(); 
				 classid=traces.getString("classid").trim(); 
				 if(traces.getString("gold")!=null) {
					 gold=traces.getString("gold").trim(); 
				 }
				 if(traces.getString("subject")!=null) {
				 subject=traces.getString("subject").trim(); 
				 }
				 if(traces.getString("gold2")!=null) {
				 gold2=traces.getString("gold2").trim(); 
				 }
				 if(gold2!=null && gold2.equals("null")==false) {
					 List.add(gold2); 

				 }
				 if(subject!=null && subject.equals("null")==false) {
					 SubjectList.add(subject); 

				 }
				 if(gold!=null && gold.equals("null")==false) {
					 GoldList.add(gold); 

				 }
				
				
			
	   		   }
			String ReqClass=requirementid+"-"+classid;
			System.out.println(ReqClass);
			RequirementClassHashMap2.put(ReqClass, List); 
			RequirementClassHashMap2Subject.put(ReqClass, SubjectList); 
			RequirementClassHashMap2GOLD.put(ReqClass, GoldList); 
			counter++; 
		}
		
		
		
		counter=0; 
		for (Entry<String, List<String>> entry : RequirementClassHashMap2.entrySet()) {
			   System.out.println(counter + " COUNTER " );

			    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
			     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
			     
			     List<String> MyValues = entry.getValue(); 
			     
			     if(MyValues.contains("T")) {
						st.executeUpdate("UPDATE `tracesclasses` SET `gold2` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			     }else if(MyValues.contains("E")) {
						st.executeUpdate("UPDATE `tracesclasses` SET `gold2` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			    	 
			     }else if(MyValues.isEmpty()) {
			    	 //DO NOTHING 
			     }
			     
			     else {
						st.executeUpdate("UPDATE `tracesclasses` SET `gold2` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			     }
			     counter++; 
		}
	
		
		
		counter=0; 
		for (Entry<String, List<String>> entry : RequirementClassHashMap2GOLD.entrySet()) {
			   System.out.println(counter + " COUNTER " );
			    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
			     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
			     
			     List<String> MyValues = entry.getValue(); 
			     
			     if(MyValues.contains("T")) {
						st.executeUpdate("UPDATE `tracesclasses` SET `gold` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			     }else if(MyValues.contains("E")) {
						st.executeUpdate("UPDATE `tracesclasses` SET `gold` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			    	 
			     }else if(MyValues.isEmpty()) {
			    	 //DO NOTHING 
			     }
			     
			     else {
						st.executeUpdate("UPDATE `tracesclasses` SET `gold` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			     }
			     counter++; 
		}
		
		counter=0; 
		for (Entry<String, List<String>> entry : RequirementClassHashMap2Subject.entrySet()) {
			   System.out.println(counter + " COUNTER " );
			    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
			     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
			     
			     List<String> MyValues = entry.getValue(); 
			     
			     if(MyValues.contains("T")) {
						st.executeUpdate("UPDATE `tracesclasses` SET `subject` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			     }else if(MyValues.contains("E")) {
						st.executeUpdate("UPDATE `tracesclasses` SET `subject` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			    	 
			     }else if(MyValues.isEmpty()) {
			    	 //DO NOTHING 
			     }
			     
			     else {
						st.executeUpdate("UPDATE `tracesclasses` SET `subject` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			     }
			     counter++; 
		}
		
		
		//st.executeUpdate("SELECT * FROM `traces` where method LIKE `% %`"); 
	}
	
	/***********************************************************************/
	public static void AddColumns2() throws SQLException {

		// TODO Auto-generated method stub
		Connection conn = null;
		DBDemo2iTrust DatabaseReading = new DBDemo2iTrust();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN SubjectT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold2");
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold3");

		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold4");

		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold2 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold3 LONGTEXT"); 

		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold4 LONGTEXT"); 

		int  TracesNumber=0; 
		int counter=0; 
		String mytraceclass=""; 
		String classid=""; 
		String requirementid= ""; 
		String gold2=""; 
		
		Hashtable<String,List<String>> RequirementClassHashMap=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMap2=new Hashtable<String,List<String>>(); 
		List<String> mylist= new ArrayList<String>(); 
		ResultSet TracesCount=st.executeQuery("SELECT COUNT(*) FROM traces"); 
		while(TracesCount.next()) {
			 TracesNumber= TracesCount.getInt(1); 
			System.out.println(TracesNumber);
		}
		
		while(counter<TracesNumber) {
			ResultSet traces = st.executeQuery("SELECT traces.* from traces where id='"+counter+"'"); 
			while(traces.next()){		
				//THIS IS GOLD 2
				 requirementid=traces.getString("requirementid").trim(); 
				 classid=traces.getString("classid").trim(); 
				String ReqClass=requirementid+"-"+classid;
				RequirementClassHashMap.put(ReqClass, mylist); 

			
	   		   }
			counter++; 
		}
		
		int counter2=0; 
		for (Entry<String, List<String>> entry : RequirementClassHashMap.entrySet()) {
//		    System.out.println(counter2 + " = " );
		    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
		     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
		     List<String> List= new ArrayList<String>(); 
		 	ResultSet traces = st.executeQuery("SELECT traces.* from traces where requirementid='"+requirementid+"' and classid='"+classid+"'"); 
			while(traces.next()){		
				//THIS IS GOLD 2
				gold2=null; 
			
				 requirementid=traces.getString("requirementid").trim(); 
				 classid=traces.getString("classid").trim(); 
				if(traces.getString("gold2")!=null) {
					 gold2=traces.getString("gold2").trim(); 
					 if(gold2!=null) {
						 List.add(gold2); 
					 }
				}
				
				
				
			
	   		   }
			String ReqClass=requirementid+"-"+classid;
			
			RequirementClassHashMap2.put(ReqClass, List); 
			counter2++; 
		}
		
		
		
		 counter2=0; 
		for (Entry<String, List<String>> entry : RequirementClassHashMap2.entrySet()) {
			 System.out.println(" mmmmmmm "+counter2  );
			    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
			     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
			     
			     List<String> MyValues = entry.getValue(); 
			     java.util.Collections.sort(MyValues); 
			    
//				for(String val: MyValues) {
//			    	 System.out.println("VAL  "+val);
//			    	 
//			     }
			     if(MyValues.size()>0) {
//				     System.out.println(MyValues.size());
					    int newsize = MyValues.size()/2; 
//					    System.out.println(newsize);
					    	   String charac = MyValues.get(newsize); 
					    
					  
					     if(charac.trim().equals("T")) {
					    		for(String val: MyValues) {
							    	 System.out.println("VAL  "+val);
							    	 
							     }
					     
								st.executeUpdate("UPDATE `tracesclasses` SET `gold2` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

					     }   else  if(charac.trim().equals("N")) {
							    

								
							 st.executeUpdate("UPDATE `tracesclasses` SET `gold2` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

						

									     }else if(MyValues.contains("E")) {
								st.executeUpdate("UPDATE `tracesclasses` SET `gold2` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

					    	 
					     }else if(MyValues.isEmpty()) {
					    	 //DO NOTHING 
					     }
					  
			     }
counter2++; 
		}
	
		
		
		//st.executeUpdate("SELECT * FROM `traces` where method LIKE `% %`"); 
	
	}
}
