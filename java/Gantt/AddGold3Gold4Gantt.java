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
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import JHotDraw.DatabaseReading2JHotDraw;
import spoon.Launcher;
import spoon.SpoonAPI;

public class AddGold3Gold4Gantt {
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

		   
		  
			   AddColumns();
		
		  
		   
		   
		
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		}
		
		
	}
	
	public static void main(String[] args) throws SQLException, IOException {
		AddColumns();

	}

	public static void AddColumns() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		DatabaseReading2Gantt DatabaseReading = new DatabaseReading2Gantt();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN gold2");
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN goldAtLeast3");
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN goldfinalAlex");
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN goldfinal");
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN goldAtLeast2");
		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN  goldAlexAtLeast3 "); 

		
		st.executeUpdate("ALTER TABLE `traces` ADD goldfinal LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `traces` ADD goldAtLeast3 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `traces` ADD gold2 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `traces` ADD goldfinalAlex LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `traces` ADD goldAlexAtLeast3 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `traces` ADD goldAtLeast2 LONGTEXT"); 
		int counter=1; 
		
//			File file = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\GanttFiles\\gantt_meth_votes.txt");
//			FileReader fileReader = new FileReader(file);
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			StringBuffer stringBuffer = new StringBuffer();
//			String line;
//			line = bufferedReader.readLine(); 
		int TracesNumber=0; 
		int SubjectT=0; 
		int SubjectN=0; 
	
			ResultSet TracesCount=st.executeQuery("SELECT COUNT(*) FROM traces"); 
			while(TracesCount.next()) {
				 TracesNumber= TracesCount.getInt(1); 
				System.out.println(TracesNumber);
			}
			while(counter<=TracesNumber) {
				
				ResultSet TraceInformation= st.executeQuery("SELECT traces.* from traces where id ='"+counter+"'"); 
				boolean subjectTflag=false; 
				boolean subjectNflag=false; 
				while(TraceInformation.next()) {
					String	SubjectTstr=TraceInformation.getString("SubjectT"); 
					String SubjectNstr=TraceInformation.getString("SubjectN"); 
					
					 if(SubjectTstr!=null) {
						 SubjectT=Integer.parseInt(SubjectTstr); 
						 subjectTflag=true; 
					 }
					 if(SubjectNstr!=null) {
						 SubjectN=Integer.parseInt(SubjectNstr); 
						 subjectNflag=true; 
					 }
				}
				
				
				
				String goldAtLeast3=null; 
				String goldUnionFinal=null; 
				String goldAtLeast2Alex=null; 
				String goldAtLeast3Alex=null; 
				if(subjectNflag==true && subjectTflag==true) {
				
					goldAtLeast3=PredictGoldAtLeast3(SubjectT, SubjectN); 
					goldUnionFinal=PredictGoldUnionFinal(SubjectT, SubjectN); 
					goldAtLeast2Alex=PredictGoldAtLeast2Alex(SubjectT, SubjectN); 
					goldAtLeast3Alex=PredictGoldAtLeast3Alex(SubjectT, SubjectN); 

					st.executeUpdate("UPDATE `traces` SET `goldAtLeast3` ='"+ goldAtLeast3+"',"+"`goldfinal` ='"+ goldUnionFinal+"',"+"`goldAlexAtLeast3` ='"+ goldAtLeast3Alex +"',"+"`goldfinalAlex` ='"+ goldAtLeast2Alex +"'WHERE id='"+counter+"'"); 
				}
				else {
					st.executeUpdate("UPDATE `traces` SET `goldAtLeast3` ='"+ "E"+"',"+"`goldfinal` ='"+ "E"+"',"+"`goldAlexAtLeast3` ='"+ "E"+"',"+"`goldfinalAlex` ='"+ "E" +"'WHERE id='"+counter+"'"); 

				}
				
				
				
				
				counter++; 
			}
			
			


		
		
			
		
		
		
		
		
		//st.executeUpdate("SELECT * FROM `traces` where method LIKE `% %`"); 
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
		else {
			gold3="E"; 
		}
		
		return gold3; 
	}
	
	static String PredictGoldAtLeast3(int SubjectT, int SubjectN) {
		String goldAtLeast3=null; 
		if(SubjectT+SubjectN>=3) {
			if(SubjectT>=3 && SubjectN==0) {
				goldAtLeast3="T"; 
			}
			else if(SubjectT==0 && SubjectN>=3) {
				goldAtLeast3="N"; 
			}
			else {
				goldAtLeast3="E"; 
			}
			
			
			
		}
		else {
			goldAtLeast3="E"; 
		}
		return goldAtLeast3; 
	}
	
	static String PredictGoldUnionFinal(int SubjectT, int SubjectN) {
		String goldUnion=null; 
		
			if((SubjectT>=2 && SubjectN==0) || SubjectT>=3) {
				goldUnion="T"; 
			}
			else if(SubjectT==0 && SubjectN>=2) {
				goldUnion="N"; 
			}
			else {
				goldUnion="E"; 
			}
			
			
			
		
		return goldUnion; 
	}
	
	
	
	static String PredictGoldAtLeast2Alex(int SubjectT, int SubjectN) {
		String goldAtLeast2=null; 
		if(SubjectT+SubjectN>=2) {
			if(SubjectT>=2 ) {
				goldAtLeast2="T"; 
			}
			else if(SubjectT==0 && SubjectN>=2) {
				goldAtLeast2="N"; 
			}
			else {
				goldAtLeast2="E"; 
			}
			
			
			
		}
		else {
			goldAtLeast2="E"; 
		}
		return goldAtLeast2; 
	}
	
	
	
	static String PredictGoldAtLeast3Alex(int SubjectT, int SubjectN) {
		String goldAtLeast2=null; 
	
			if(SubjectT>=3 ) {
				goldAtLeast2="T"; 
			}
			else if(SubjectT==0 && SubjectN>=2) {
				goldAtLeast2="N"; 
			}
			else {
				goldAtLeast2="E"; 
			}
			
			
			
		
		
		return goldAtLeast2; 
	}
	
	
}
