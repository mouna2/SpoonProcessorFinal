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
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import Chess.PredictionEvaluation;
import Gantt.DatabaseReading2Gantt;
import spoon.Launcher;
import spoon.SpoonAPI;

public class PrecisionRecallGoldsJHotDraw {
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
		DatabaseReading2JHotDraw3 DatabaseReading = new DatabaseReading2JHotDraw3();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
	


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
		PredictionEvaluation predictionEvaluationAlex = new PredictionEvaluation(); 
		PredictionEvaluation predictionEvaluationMouna = new PredictionEvaluation(); 

		PredictionEvaluation predictionEvaluationAlexAtLeast3 = new PredictionEvaluation(); 

				
				ResultSet TraceInformation= st.executeQuery("SELECT tracesclasses.* from tracesclasses "); 
				
				while(TraceInformation.next()) {
					String	goldfinal=TraceInformation.getString("goldfinal"); 
					String goldAtLeast2=TraceInformation.getString("goldAtLeast2"); 
					String goldAlex=TraceInformation.getString("goldAlex"); 
					
					String goldAlexAtLeast3=TraceInformation.getString("goldAlexAtLeast3"); 
					
					String val = predictionEvaluationMouna.ComparePredictionToGold(goldfinal, goldAtLeast2); 				
					predictionEvaluationMouna.UpdateCounters(val, predictionEvaluationMouna);
					
					
					String val2 = predictionEvaluationAlex.ComparePredictionToGold(goldfinal, goldAlex); 					
					predictionEvaluationAlex.UpdateCounters(val2, predictionEvaluationAlex);
					
					String val3 = predictionEvaluationAlexAtLeast3.ComparePredictionToGold(goldfinal, goldAlexAtLeast3); 					
					predictionEvaluationAlexAtLeast3.UpdateCounters(val3, predictionEvaluationAlexAtLeast3);
				}
				
			
				
			


		
		
			System.out.println("predictionEvaluationMouna JHotDraw "+predictionEvaluationMouna.toString());
			System.out.println("predictionEvaluationAlex JHotDraw "+predictionEvaluationAlex.toString());
			System.out.println("predictionEvaluationAlexAtLeast3 JHotDraw "+predictionEvaluationAlexAtLeast3.toString());
		
		
		
		
		//st.executeUpdate("SELECT * FROM `traces` where method LIKE `% %`"); 
	}
	
	
	
}
