package Gantt;

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

public class AddGold3Gold4GanttTRACESCLASSES {
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
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasegantt","root","123456");

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
		
			AddColumns2();
		   
		   
		
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		}
		
		
	}
	
	public static void main(String[] args) throws SQLException, IOException {
		AddColumns2();
	}

	
	/***********************************************************************/
	public static void AddColumns2() throws SQLException {
		// TODO Auto-generated method stub


		// TODO Auto-generated method stub
		Connection conn = null;
		DatabaseReading2Gantt DatabaseReading = new DatabaseReading2Gantt();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
	
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN goldAlexAtLeast3");
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN goldAlex");
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN goldAtLeast3");
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN goldfinal");
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN goldAtLeast2");
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold");
		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN gold2");
		
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold2 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD gold LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD goldAtLeast2 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD goldfinal LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD goldAtLeast3 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD goldAlex LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `tracesclasses` ADD goldAlexAtLeast3 LONGTEXT"); 


		int  TracesNumber=0; 
		int counter=0; 
		String mytraceclass=""; 
		String classid=""; 
		String classname=""; 
		String requirementid= ""; 
		String requirementname= ""; 
		String gold4=""; 
		String gold3=""; 
		String goldAtLeast3=""; 
		String gold6=""; 
		String gold=""; 
		String goldfinalAlex=""; 
		String goldAlexAtLeast3=""; 

		String goldAtLeast2=""; 
		Hashtable<String,String> RequirementClassHashMapNames=new Hashtable<String,String>(); 

		Hashtable<String,List<String>> RequirementClassHashMap=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMapGold=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMapGoldAlex=new Hashtable<String,List<String>>(); 

		Hashtable<String,List<String>> RequirementClassHashMapGoldAtLeast3=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMapGoldAtLeast3Alex=new Hashtable<String,List<String>>(); 

		Hashtable<String,List<String>> RequirementClassHashMapGoldAtLeast2=new Hashtable<String,List<String>>(); 

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
				 requirementname=traces.getString("requirement").trim(); 
				 classname=traces.getString("classname").trim(); 
				String ReqClass=requirementid+"-"+classid;
				String ReqClassNames=requirementid+"-"+requirementname+"-"+classid+"-"+classname;

				RequirementClassHashMap.put(ReqClass, mylist); 
				RequirementClassHashMapNames.put(ReqClass, ReqClassNames); 

			
	   		   }
			counter++; 
		}
		
		int index=0; 
		for (Entry<String, List<String>> entry : RequirementClassHashMap.entrySet()) {
//		    System.out.println(entry.getKey() + " = " );
		    requirementid= entry.getKey().substring(0, entry.getKey().indexOf("-")); 
		     classid= entry.getKey().substring(entry.getKey().indexOf("-")+1, entry.getKey().length()); 
		     List<String> List= new ArrayList<String>(); 
		     List<String> ListGold= new ArrayList<String>(); 

		     List<String> ListGoldAlex= new ArrayList<String>(); 
		     List<String> ListGold3= new ArrayList<String>(); 
		     List<String> ListGoldAtLeast3= new ArrayList<String>(); 
		     List<String> ListGoldAlexAtLeast3= new ArrayList<String>(); 
		     List<String> ListGold6= new ArrayList<String>(); 
		     List<String> ListGoldAtLeast2= new ArrayList<String>(); 

		 	ResultSet traces = st.executeQuery("SELECT traces.* from traces where requirementid='"+requirementid+"' and classid='"+classid+"'"); 
			while(traces.next()){		
				//THIS IS GOLD 2
				gold=null; 
				goldfinalAlex=null; 
				gold4=null; 
				gold3=null; 
				goldAtLeast3=null; 
				gold6=null; 
				goldAtLeast2=null; 
				 requirementid=traces.getString("requirementid").trim(); 
				 classid=traces.getString("classid").trim(); 
				
				//developer gold
				if(traces.getString("gold")!=null) {
					 gold=traces.getString("gold").trim(); 
					 if(gold!=null) {
						 ListGold.add(gold); 
					 }
				}	
				
				if(traces.getString("goldAlexAtLeast3")!=null) {
					goldAlexAtLeast3=traces.getString("goldAlexAtLeast3").trim(); 
					 if(goldAlexAtLeast3!=null) {
						 ListGoldAlexAtLeast3.add(goldAlexAtLeast3); 
					 }
				}	
				
				
				if(traces.getString("goldfinalAlex")!=null) {
					goldfinalAlex=traces.getString("goldfinalAlex").trim(); 
					 if(goldfinalAlex!=null) {
						 ListGoldAlex.add(goldfinalAlex); 
					 }
				}	
				
				if(traces.getString("goldAtLeast3")!=null) {
					 goldAtLeast3=traces.getString("goldAtLeast3").trim(); 
					 if(goldAtLeast3!=null) {
						 ListGoldAtLeast3.add(goldAtLeast3); 
					 }
					
				}
				
				//gold at least 2
				if(traces.getString("goldfinal")!=null) {
					 goldAtLeast2=traces.getString("goldfinal").trim(); 
					 if(goldAtLeast2!=null) {
						 ListGoldAtLeast2.add(goldAtLeast2); 
					 }
					
				}
				
				
//				System.out.println(index);
			index++; 
	   		   }
			String ReqClass=requirementid+"-"+classid;
//			System.out.println(ReqClass);
			RequirementClassHashMapGold.put(ReqClass, ListGold); 
			RequirementClassHashMapGoldAlex.put(ReqClass, ListGoldAlex); 
			RequirementClassHashMapGoldAtLeast2.put(ReqClass, ListGoldAtLeast2); 
			RequirementClassHashMapGoldAtLeast3.put(ReqClass, ListGoldAtLeast3); 
			RequirementClassHashMapGoldAtLeast3Alex.put(ReqClass, ListGoldAlexAtLeast3); 

		}
		
		
		System.out.println("finished buolding hashmaps");
		
	
		
		for(Entry<String, List<String>>  entry: RequirementClassHashMapGoldAtLeast3Alex.entrySet()) {

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
					    
					  
					    	   if(count.CountT>0) {		
									st.executeUpdate("UPDATE `tracesclasses` SET `goldAlexAtLeast3` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

						     } 
//						    else  if(charac.trim().equals("N")) {

						    else  if(count.CountN>0 && count.CountT==0 && count.CountE==0) {
						    		
						    		
						    		
						    	 st.executeUpdate("UPDATE `tracesclasses` SET `goldAlexAtLeast3` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 



						    			     }
						     else {
									st.executeUpdate("UPDATE `tracesclasses` SET `goldAlexAtLeast3` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

						    	 
						     }
					     
			     }
			     else {
						st.executeUpdate("UPDATE `tracesclasses` SET `goldAlexAtLeast3` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			    	 
			     }
		
			     
			     
			     
			     
			     
			     
			     
		}
		
		
		for(Entry<String, List<String>>  entry: RequirementClassHashMapGoldAlex.entrySet()) {

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
					    
					  
					    	   if(count.CountT>0) {		
									st.executeUpdate("UPDATE `tracesclasses` SET `goldAlex` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

						     } 
//						    else  if(charac.trim().equals("N")) {

						    else  if(count.CountN>0 && count.CountT==0 && count.CountE==0) {
						    		
						    		
						    		
						    	 st.executeUpdate("UPDATE `tracesclasses` SET `goldAlex` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 



						    			     }
						     else {
									st.executeUpdate("UPDATE `tracesclasses` SET `goldAlex` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

						    	 
						     }
					     
			     }
			     else {
						st.executeUpdate("UPDATE `tracesclasses` SET `goldAlex` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			    	 
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
											st.executeUpdate("UPDATE `tracesclasses` SET `goldfinal` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

								     } 
//								    else  if(charac.trim().equals("N")) {

								    else  if(count.CountN>0 && count.CountT==0 && count.CountE==0) {
								    		
								    		
								    		
								    	 st.executeUpdate("UPDATE `tracesclasses` SET `goldfinal` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 



								    			     }
								     else {
											st.executeUpdate("UPDATE `tracesclasses` SET `goldfinal` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

								    	 
								     }
							     
					     }
					     else {
								st.executeUpdate("UPDATE `tracesclasses` SET `goldfinal` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

					    	 
					     }
				     
			    	 
			    	 
			     }

		
		}
		
		
		for(Entry<String, List<String>>  entry: RequirementClassHashMapGoldAtLeast3.entrySet()) {

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
					    
					  
					    	   if(count.CountT>0) {		
									st.executeUpdate("UPDATE `tracesclasses` SET `goldAtLeast3` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

						     } 
//						    else  if(charac.trim().equals("N")) {

						    else  if(count.CountN>0 && count.CountT==0 && count.CountE==0) {
						    		
						    		
						    		
						    	 st.executeUpdate("UPDATE `tracesclasses` SET `goldAtLeast3` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 



						    			     }
						     else {
									st.executeUpdate("UPDATE `tracesclasses` SET `goldAtLeast3` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

						    	 
						     }
					     
			     }
			     else {
						st.executeUpdate("UPDATE `tracesclasses` SET `goldAtLeast3` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			    	 
			     }
		
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
		}
		
		//st.executeUpdate("SELECT * FROM `traces` where method LIKE `% %`"); 
	
		for(Entry<String, List<String>>  entry: RequirementClassHashMapGoldAtLeast2.entrySet()) {

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
					    
					  
					    	   if(count.CountT>0) {		
									st.executeUpdate("UPDATE `tracesclasses` SET `goldAtLeast2` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

						     } 
//						    else  if(charac.trim().equals("N")) {

						    else  if(count.CountN>0 && count.CountT==0 && count.CountE==0) {
						    		
						    		
						    		
						    	 st.executeUpdate("UPDATE `tracesclasses` SET `goldAtLeast2` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 



						    			     }
						     else {
									st.executeUpdate("UPDATE `tracesclasses` SET `goldAtLeast2` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

						    	 
						     }
					     
			     }
			     else {
						st.executeUpdate("UPDATE `tracesclasses` SET `goldAtLeast2` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			    	 
			     }
		
			     
			     
			     
			     
			     
			     
			     
		}
		
		
		
		
	}
	private static CountTNE ComputeProportions(List<String> myValues, int countT, int countN, int countE) {
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

	
	
	
	
}
