package Chess;

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

import spoon.Launcher;
import spoon.SpoonAPI;

public class AddGold2Column {
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
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasechess","root","123456");

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
		DBDemo2 DatabaseReading = new DBDemo2();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
		//st.executeUpdate("ALTER TABLE `traces` DROP COLUMN SubjectT"); 
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN gold2");
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN gold3");
//		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN gold4");
		st.executeUpdate("ALTER TABLE `traces` ADD gold2 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `traces` ADD gold3 LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `traces` ADD gold4 LONGTEXT"); 
		try {
			File file = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\java\\Chess\\ChessFiles\\TracesChess.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			line = bufferedReader.readLine(); 
			List<SubjectTSubjectNObject> mylist= new ArrayList<SubjectTSubjectNObject>(); 
			
			while ((line = bufferedReader.readLine()) != null) {
				String[] splittedline = line.split(",", -1); 
				
				int counter =1; 
				for(int i=4; i<splittedline.length; i++) {
					SubjectTSubjectNObject SubjectTSubjectNObj = new SubjectTSubjectNObject(); 
					String methodname= splittedline[1]+"."+splittedline[2]; 
					methodname=methodname.replaceAll("$", ""); 
					methodname=methodname.replaceAll("clinit", "init"); 
					//methodname=methodname.replaceAll("constructor", "-init-"); 
					//methodname=Pattern.compile("[{}<>]").matcher(methodname).replaceAll(""); 
				
					String RequirementID= ""+counter;
					if(splittedline[i].equals("")) {
						SubjectTSubjectNObj.setGold2("N");
					}
					else {
						SubjectTSubjectNObj.setGold2("T");
					}
					SubjectTSubjectNObj.setMethodName(methodname);
					SubjectTSubjectNObj.setRequirementID(RequirementID);
					
					counter++; 
					mylist.add(SubjectTSubjectNObj); 
				}
			
			}
			fileReader.close();
			System.out.println(mylist.size());
			int count=1;
			for (SubjectTSubjectNObject entry: mylist) {
				System.out.println(entry.toString()+ " "+count);
				String name= entry.MethodName; 
				st.executeUpdate("UPDATE `traces` SET `gold2` ='"+ entry.gold2 +"'WHERE requirementid='"+entry.RequirementID+"' AND method LIKE'%"+name+"%'"); 
				//st.executeUpdate("UPDATE `traces` SET  +"'WHERE requirementid='"+entry.RequirementID+"' AND method='"+name+"'"); 
				count++;
			}
			
			st.executeUpdate("UPDATE `traces` SET `gold2` ='"+ "E" +"'WHERE gold2 IS NULL"); 

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		//st.executeUpdate("SELECT * FROM `traces` where method LIKE `% %`"); 
	}
}
