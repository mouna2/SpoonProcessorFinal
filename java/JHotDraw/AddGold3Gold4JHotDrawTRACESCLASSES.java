package JHotDraw;

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

import Chess.CountTNE;
import spoon.Launcher;
import spoon.SpoonAPI;

public class AddGold3Gold4JHotDrawTRACESCLASSES {
	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";
	
	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "root";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */

	private final int portNumber = 3306;
	
	private final String dbName = "databasegantt";

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
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasejhotdraw","root","123456");

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

		   
		  
//			   AddColumns();
		
		  
		   
		   
		
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		}
		
		
	}
	
	public static void main(String[] args) throws SQLException, IOException {
		AddColumns2();

	}

	public static void AddColumns2() throws SQLException {
		// TODO Auto-generated method stub


		// TODO Auto-generated method stub
		Connection conn = null;
		DatabaseReading2JHotDraw3 DatabaseReading = new DatabaseReading2JHotDraw3();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold4");
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold");
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold3");
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold5");
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold5V2");
		
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold4 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold3 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold5 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold5V2 LONGTEXT"); 

		int  TracesNumber=0; 
		int counter=0; 
		String mytraceclass=""; 
		String classid=""; 
		String requirementid= ""; 
		String gold4=""; 
		String gold3=""; 
		String gold5=""; 
		String gold6=""; 
		String gold=""; 
		Hashtable<String,List<String>> RequirementClassHashMap=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMap2=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMapGold3=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMapGold5=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMapGold=new Hashtable<String,List<String>>(); 

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
		
		
		for (Entry<String, List<String>> entry : RequirementClassHashMap.entrySet()) {
		    System.out.println(entry.getKey() + " = " );
		    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
		     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
		     List<String> List= new ArrayList<String>(); 
		     List<String> ListGold3= new ArrayList<String>(); 
		     List<String> ListGold5= new ArrayList<String>(); 
		     List<String> ListGold6= new ArrayList<String>(); 
		     List<String> ListGold= new ArrayList<String>(); 

		 	ResultSet traces = st.executeQuery("SELECT traces.* from traces where requirementid='"+requirementid+"' and classid='"+classid+"'"); 
			while(traces.next()){		
				//THIS IS GOLD 2
				gold4=null; 
				gold3=null; 
				gold5=null; 
				gold6=null; 
				gold=null; 
				 requirementid=traces.getString("requirementid").trim(); 
				 classid=traces.getString("classid").trim(); 
				if(traces.getString("gold4")!=null) {
					 gold4=traces.getString("gold4").trim(); 
					 if(gold4!=null) {
						 List.add(gold4); 
					 }
					 
					 gold3=traces.getString("gold3").trim(); 
					 if(gold3!=null) {
						 ListGold3.add(gold3); 
					 }
					 
					 gold5=traces.getString("gold5").trim(); 
					 if(gold5!=null) {
						 ListGold5.add(gold5); 
					 }
					 if(traces.getString("gold")!=null) {
						 gold=traces.getString("gold").trim(); 
						 if(gold!=null) {
							 ListGold.add(gold); 
						 }
					}	
					
				}
				
				
				
			
	   		   }
			String ReqClass=requirementid+"-"+classid;
			System.out.println(ReqClass);
			RequirementClassHashMap2.put(ReqClass, List); 
			RequirementClassHashMapGold3.put(ReqClass, ListGold3); 
			RequirementClassHashMapGold5.put(ReqClass, ListGold5); 
			RequirementClassHashMapGold.put(ReqClass, ListGold); 


		}
		
		
		
		
		for (Entry<String, List<String>> entry : RequirementClassHashMap2.entrySet()) {
			   System.out.println(entry.getKey() + " = " );
			    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
			     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
			     
			     List<String> MyValues = entry.getValue(); 
			     java.util.Collections.sort(MyValues); 
			    
//				for(String val: MyValues) {
//			    	 System.out.println("VAL  "+val);
//			    	 
//			     }
			     if(MyValues.size()>0) {
				     System.out.println(MyValues.size());
					    int newsize = MyValues.size()/2; 
					    System.out.println(newsize);
					    	   String charac = MyValues.get(newsize); 
					    
					  
					     if(charac.trim().equals("T")) {
					    		
					     
								st.executeUpdate("UPDATE `tracesclasses` SET `gold4` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

					     }			     else  if(charac.trim().equals("N")) {
							    

								
								 st.executeUpdate("UPDATE `tracesclasses` SET `gold4` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

							//}

										     }
					     
					     else if(MyValues.contains("E")) {
								st.executeUpdate("UPDATE `tracesclasses` SET `gold4` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

					    	 
					     }else if(MyValues.isEmpty()) {
					    	 //DO NOTHING 
					     }
		
			     }

		}
	
		
		for(Entry<String, List<String>>  entry: RequirementClassHashMapGold3.entrySet()) {

			   System.out.println(entry.getKey() + " = " );
			    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
			     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
			     
			     List<String> MyValues = entry.getValue(); 
			     java.util.Collections.sort(MyValues); 
			    
//				for(String val: MyValues) {
//			    	 System.out.println("VAL  "+val);
//			    	 
//			     }
			     if(MyValues.size()>0) {
				     System.out.println(MyValues.size());
					    int newsize = MyValues.size()/2; 
					    System.out.println(newsize);
					    	   String charac = MyValues.get(newsize); 
					    
					  
					     if(charac.trim().equals("T")) {
					    		
					     
								st.executeUpdate("UPDATE `tracesclasses` SET `gold3` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

					     }			     else  if(charac.trim().equals("N")) {
					    

			 st.executeUpdate("UPDATE `tracesclasses` SET `gold3` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

		//}

					     }else if(MyValues.contains("E")) {
								st.executeUpdate("UPDATE `tracesclasses` SET `gold3` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

					    	 
					     }else if(MyValues.isEmpty()) {
					    	 //DO NOTHING 
					     }
		
			     }

		
		}
		
		
		
		for(Entry<String, List<String>>  entry: RequirementClassHashMapGold.entrySet()) {

			   System.out.println(entry.getKey() + " = " );
			    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
			     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
			     
			     List<String> MyValues = entry.getValue(); 
			     java.util.Collections.sort(MyValues); 
			    
//				for(String val: MyValues) {
//			    	 System.out.println("VAL  "+val);
//			    	 
//			     }
			     if(MyValues.size()>0) {
			    	 
			    	  int CountT=0, CountN=0, CountE=0; 
					     CountTNE count=ComputeProportions(MyValues, CountT, CountN, CountE); 
					
					    System.out.println("hhCountT "+count.CountT);
					    System.out.println("hhCountN "+count.CountN);
					    System.out.println("hhCountE "+count.CountE);
					     
					     if(MyValues.size()>0) {
						     System.out.println(MyValues.size());
							    int newsize = MyValues.size()/2; 
							    System.out.println(newsize);
							    	   String charac = MyValues.get(newsize); 
							    
							  
							    	   if(count.CountT>0) {		
											st.executeUpdate("UPDATE `tracesclasses` SET `gold` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

								     } 
//								    else  if(charac.trim().equals("N")) {

								    else  if(count.CountN>0 && count.CountT==0 && count.CountE==0) {
								    		
								    		
								    		
								    	 st.executeUpdate("UPDATE `tracesclasses` SET `gold` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 



								    			     }
								     else {
											st.executeUpdate("UPDATE `tracesclasses` SET `gold` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

								    	 
								     }
							     
					     }
			    	 
					     else {
								st.executeUpdate("UPDATE `tracesclasses` SET `gold` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

					    	 
					     }
			    	 
			    	 
			     }

		
		}
		for(Entry<String, List<String>>  entry: RequirementClassHashMapGold5.entrySet()) {

			   System.out.println(entry.getKey() + " = " );
			    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
			     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
			     
			     List<String> MyValues = entry.getValue(); 
			     java.util.Collections.sort(MyValues); 
			    
//				for(String val: MyValues) {
//			    	 System.out.println("VAL  "+val);
//			    	 
//			     }
			     int CountT=0, CountN=0, CountE=0; 
			     CountTNE count=ComputeProportions(MyValues, CountT, CountN, CountE); 
			
//			    System.out.println("CountT "+count.CountT);
//			    System.out.println("CountN "+count.CountN);
//			    System.out.println("CountE "+count.CountE);
			     
			     if(MyValues.size()>0) {
				     System.out.println(MyValues.size());
					    int newsize = MyValues.size()/2; 
					    System.out.println(newsize);
					    	   String charac = MyValues.get(newsize); 
					    
					  
					    	   if(count.CountT>count.CountN && count.CountT>count.CountE) {		
									st.executeUpdate("UPDATE `tracesclasses` SET `gold5` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

						     } 
//						    else  if(charac.trim().equals("N")) {

						    else  if(count.CountN>count.CountE && count.CountN>count.CountT) {
						    		
						    		
						    		
						    	 st.executeUpdate("UPDATE `tracesclasses` SET `gold5` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 



						    			     }
						     else if(MyValues.contains("E")) {
									st.executeUpdate("UPDATE `tracesclasses` SET `gold5` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

						    	 
						     }else if(MyValues.isEmpty()) {
					    	 //DO NOTHING 
					     }
					     
			     }  else{
						st.executeUpdate("UPDATE `tracesclasses` SET `gold5` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

				    	 
			     }

			     
			     if(MyValues.size()>0) {
				     System.out.println(MyValues.size());
					    int newsize = MyValues.size()/2; 
					    System.out.println(newsize);
					    	   String charac = MyValues.get(newsize); 
					    
					  
					    	   if(count.CountT>0) {		
									st.executeUpdate("UPDATE `tracesclasses` SET `gold5V2` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

						     } 
//						    else  if(charac.trim().equals("N")) {

						    else  if(count.CountN>0 && count.CountT==0 && count.CountE==0) {
						    		
						    		
						    		
						    	 st.executeUpdate("UPDATE `tracesclasses` SET `gold5V2` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 



						    			     }
						     else {
									st.executeUpdate("UPDATE `tracesclasses` SET `gold5V2` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

						    	 
						     }
					     
			     }
			     else {
						st.executeUpdate("UPDATE `tracesclasses` SET `gold5V2` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			    	 
			     }
		}
		
		
		
		//st.executeUpdate("SELECT * FROM `traces` where method LIKE `% %`"); 
	
	
	}

	public static CountTNE ComputeProportions(List<String> myValues, int countT, int countN, int countE) {
		// TODO Auto-generated method stub
		
		for(String s: myValues) {
//			System.out.println("=====>"+s);
			if(s.trim().equals("T")) {
				countT++; 
			}
			else if(s.trim().equals("N")) {
				countN++; 
			}
			else if(s.trim().equals("E")) {
				countE++; 
			}
		}
		CountTNE count= new CountTNE(); 
		count.setCountT(countT);
		count.setCountN(countN);
		count.setCountE(countE);
		return count; 

	}

	public static void AddColumns() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		DBDemo3JHotDraw3 DatabaseReading = new DBDemo3JHotDraw3();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN subject"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold4"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold2"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold3");
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
		String gold3=""; 
		String gold4=""; 
		String gold=""; 
		String subject=""; 
		Hashtable<String,List<String>> RequirementClassHashMap=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMap2Gold3=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMapGOLD4=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMap2GOLD4=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMapGOLD=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMap2GOLD=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMapSubject=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMap2Subject=new Hashtable<String,List<String>>(); 
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
				 requirementid=traces.getString("requirementid"); 
				 classid=traces.getString("classid"); 
				String ReqClass=requirementid+"-"+classid;
				RequirementClassHashMap.put(ReqClass, mylist); 

			
	   		   }
			counter++; 
		}
		
		
		for (Entry<String, List<String>> entry : RequirementClassHashMap.entrySet()) {
		    System.out.println(entry.getKey() + " = " );
		    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
		     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
		     List<String> ListGold3= new ArrayList<String>(); 
		     List<String> ListGold4= new ArrayList<String>(); 
		     List<String> ListGold= new ArrayList<String>(); 
		     List<String> ListSubject= new ArrayList<String>(); 
		 	ResultSet traces = st.executeQuery("SELECT traces.* from traces where requirementid='"+requirementid+"' and classid='"+classid+"'"); 
			while(traces.next()){		
				//THIS IS GOLD 2
				 requirementid=traces.getString("requirementid"); 
				 classid=traces.getString("classid"); 
				 if(traces.getString("gold3")!=null) {
				 gold3=traces.getString("gold3").trim(); 
				 }
				 if(traces.getString("gold4")!=null) {
				 gold4=traces.getString("gold4").trim(); 
				 }
				 if(traces.getString("gold")!=null) {
				 gold=traces.getString("gold").trim(); 
				 }
				 if(traces.getString("subject")!=null) {
				 subject=traces.getString("subject").trim(); 
				 }
				 if(gold3!=null && gold3.equals("null")==false) {
					 ListGold3.add(gold3); 

				 }
				if(gold4!=null && gold4.equals("null")==false) {
					 ListGold4.add(gold4); 

				}
				if(gold!=null && gold.equals("null")==false) { 
					 ListGold.add(gold); 

				}
				if(subject!=null && subject.equals("null")==false) {
					 ListSubject.add(subject); 

				}
	   		   }
			String ReqClass=requirementid+"-"+classid;
			System.out.println(ReqClass);
			RequirementClassHashMap2Gold3.put(ReqClass, ListGold3); 
			RequirementClassHashMap2GOLD4.put(ReqClass, ListGold4); 
			RequirementClassHashMap2GOLD.put(ReqClass, ListGold); 
			RequirementClassHashMap2Subject.put(ReqClass, ListSubject); 
		}
		
		
		
		
		for (Entry<String, List<String>> entry : RequirementClassHashMap2Gold3.entrySet()) {
			   System.out.println(entry.getKey() + " = " );
			    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
			     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
			     
			     List<String> MyValues = entry.getValue(); 
			     
			     if(MyValues.contains("T")) {
						st.executeUpdate("UPDATE `tracesclasses` SET `gold3` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			     }else if(MyValues.contains("E")) {
						st.executeUpdate("UPDATE `tracesclasses` SET `gold3` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			    	 
			     }else if(MyValues.isEmpty()) {
			    	 //DO NOTHING 
			     }
			     
			     
			     else {
						st.executeUpdate("UPDATE `tracesclasses` SET `gold3` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			     }
		}
	
		
		for (Entry<String, List<String>> entry : RequirementClassHashMap2GOLD4.entrySet()) {
			   System.out.println(entry.getKey() + " = " );
			    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
			     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
			     
			     List<String> MyValues = entry.getValue(); 
			     
			     if(MyValues.contains("T")) {
						st.executeUpdate("UPDATE `tracesclasses` SET `gold4` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			     }else if(MyValues.contains("E")) {
						st.executeUpdate("UPDATE `tracesclasses` SET `gold4` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			    	 
			     }else if(MyValues.isEmpty()) {
			    	 //DO NOTHING 
			     }
			     
			     else {
						st.executeUpdate("UPDATE `tracesclasses` SET `gold4` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			     }
		}
		
		
		
		for (Entry<String, List<String>> entry : RequirementClassHashMap2GOLD.entrySet()) {
			   System.out.println(entry.getKey() + " = " );
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
		}
		
		
		for (Entry<String, List<String>> entry : RequirementClassHashMap2Subject.entrySet()) {
			   System.out.println(entry.getKey() + " = " );
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
		}
		
		
		//st.executeUpdate("SELECT * FROM `traces` where method LIKE `% %`"); 
	}
}
