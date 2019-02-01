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
import Gantt.DatabaseReading2Gantt;
import JHotDraw.DatabaseReading2JHotDraw3;
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
	
	private final String dbName = "databasejhotdraw";

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
		
			AddColumns2();
		   
		   
		
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

	
	/***********************************************************************/
	public static void AddColumns2() throws SQLException {
		// TODO Auto-generated method stub


		// TODO Auto-generated method stub
		Connection conn = null;
		DatabaseReading2JHotDraw3 DatabaseReading = new DatabaseReading2JHotDraw3();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
	

		st.executeUpdate("ALTER TABLE `tracesclasses` DROP COLUMN SubjectGold");
		

		st.executeUpdate("ALTER TABLE `tracesclasses` ADD SubjectGold LONGTEXT"); 
	


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

		String UnionGold=""; 
		Hashtable<String,String> RequirementClassHashMapNames=new Hashtable<String,String>(); 

		Hashtable<String,List<String>> RequirementClassHashMap=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMapGold=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMapGoldAlex=new Hashtable<String,List<String>>(); 

		Hashtable<String,List<String>> RequirementClassHashMapGoldAtLeast3=new Hashtable<String,List<String>>(); 
		Hashtable<String,List<String>> RequirementClassHashMapGoldAtLeast3Alex=new Hashtable<String,List<String>>(); 

		Hashtable<String,List<String>> RequirementClassHashMapUnionGold=new Hashtable<String,List<String>>(); 

		List<String> mylist= new ArrayList<String>(); 
		List<String> ListGold= new ArrayList<String>(); 
		List<String> ListGoldAlex= new ArrayList<String>(); 
		List<String> ListUnionGold= new ArrayList<String>(); 
		List<String> ListUnionGold2= new ArrayList<String>(); 

		List<String> ListGoldAtLeast3= new ArrayList<String>(); 
		List<String> ListGoldAlexAtLeast3= new ArrayList<String>(); 

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
				String goldfinal=traces.getString("goldfinal").trim(); 
				if(RequirementClassHashMapUnionGold.get(ReqClass)==null) {
					ListUnionGold= new ArrayList<String>(); 
					RequirementClassHashMapUnionGold.put(ReqClass, ListUnionGold); 
					ListUnionGold = RequirementClassHashMapUnionGold.get(ReqClass); 
					ListUnionGold.add(goldfinal); 
					RequirementClassHashMapUnionGold.put(ReqClass, ListUnionGold); 
				}else {
					ListUnionGold = RequirementClassHashMapUnionGold.get(ReqClass); 
					ListUnionGold.add(goldfinal); 
					RequirementClassHashMapUnionGold.put(ReqClass, ListUnionGold); 
				}
				
				
				
				
				String goldNormal=traces.getString("gold").trim(); 
				if(RequirementClassHashMapGold.get(ReqClass)==null) {
					ListUnionGold2= new ArrayList<String>(); 
					RequirementClassHashMapGold.put(ReqClass, ListUnionGold2); 
					ListUnionGold2 = RequirementClassHashMapGold.get(ReqClass); 
					ListUnionGold2.add(goldNormal); 
					RequirementClassHashMapGold.put(ReqClass, ListUnionGold2); 
				}else {
					ListUnionGold2= RequirementClassHashMapGold.get(ReqClass); 
					ListUnionGold2.add(goldNormal); 
					RequirementClassHashMapGold.put(ReqClass, ListUnionGold2); 
				}
				
				
				
				
			

	   		   }
			System.out.println("COUNTER 1"+counter);
			counter++; 
		}
		
		int index=0; 

		
		
		
		
	
	counter=0; 
		for(Entry<String, List<String>>  entry: RequirementClassHashMapUnionGold.entrySet()) {

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
									st.executeUpdate("UPDATE `tracesclasses` SET `SubjectGold` ='"+ "T" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

						     } 
//						    else  if(charac.trim().equals("N")) {

						    else  if(count.CountN>0 && count.CountT==0 && count.CountE>=0) {
						    		
						    		
						    		
						    	 st.executeUpdate("UPDATE `tracesclasses` SET `SubjectGold` ='"+ "N" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 



						    			     }
						     else {
									st.executeUpdate("UPDATE `tracesclasses` SET `SubjectGold` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

						    	 
						     }
					     
			     }
			     else {
						st.executeUpdate("UPDATE `tracesclasses` SET `SubjectGold` ='"+ "E" +"'WHERE requirementid='"+requirementid+"' AND classid='"+classid+"'"); 

			    	 
			     }
		
			     
			     
			     
			     
			     
			     
			     System.out.println("COUNTER SubjectGold "+counter);
					counter++; 
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

	static String PredictGold3(int SubjectT, int SubjectN) {
		String gold3=null; 
		if(SubjectT+SubjectN>=3) {
			if(SubjectT>=SubjectN) {
				gold3="T"; 
			}
			else if(SubjectT==0 && SubjectN>=3) {
				gold3="N"; 
			}
			else {
				gold3="E"; 
			}
			
			
			
		}
		
		return gold3; 
	}
	
	
	static String PredictGold4(int SubjectT, int SubjectN) {
		
		String gold4=null; 
		if(SubjectT+SubjectN>=3) {
			if(SubjectT>=2) {
				gold4="T"; 
			}
			else if(SubjectT==0 && SubjectN>=3) {
				gold4="N"; 
			}
			else {
				gold4="E"; 
			}
			
			
			
		}
		return gold4; 
	}
}
