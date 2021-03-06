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

import spoon.Launcher;
import spoon.SpoonAPI;

public class AddSubjectTSubjectNJHotDraw {
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
		DatabaseReading2JHotDraw2 DatabaseReading = new DatabaseReading2JHotDraw2();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();
		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN SubjectT"); 
		st.executeUpdate("ALTER TABLE `traces` DROP COLUMN SubjectN");
		st.executeUpdate("ALTER TABLE `traces` ADD SubjectT LONGTEXT"); 
		st.executeUpdate("ALTER TABLE `traces` ADD SubjectN LONGTEXT");
		List<SubjectTSubjectNObject> mylist= new ArrayList<SubjectTSubjectNObject>(); 
		try {
			File file = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\java\\JHotDrawFiles\\jhotdrawnew_meth_votes.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			line = bufferedReader.readLine(); 
			while ((line = bufferedReader.readLine()) != null) {
				String[] splittedline = line.split(","); 
				stringBuffer.append(line);
				stringBuffer.append("\n");
				int counter =1; 
				for(int i=1; i<splittedline.length; i+=2) {
					SubjectTSubjectNObject SubjectTSubjectNObj = new SubjectTSubjectNObject(); 
					String methodname= splittedline[0]; 
					methodname=methodname.replaceAll("::", "."); 
					methodname=methodname.replaceAll("constructor", "-init-"); 
					methodname=Pattern.compile("[{}<>]").matcher(methodname).replaceAll(""); 
				
					String RequirementID= ""+counter;
					String SubjectT= splittedline[i];
					String SubjectN= splittedline[i+1]; 
					SubjectTSubjectNObj.setMethodName(methodname);
					SubjectTSubjectNObj.setRequirementID(RequirementID);
					SubjectTSubjectNObj.setSubjectT(SubjectT);
					SubjectTSubjectNObj.setSubjectN(SubjectN);
					counter++; 
					mylist.add(SubjectTSubjectNObj); 
				}
			
			}
			fileReader.close();
			int counter=1; 
			for (SubjectTSubjectNObject entry: mylist) {
				System.out.println(entry.toString()+ " "+counter );
				//String name= "org.jhotdraw."+entry.MethodName; 
				String name= entry.MethodName; 
				st.executeUpdate("UPDATE `traces` SET `SubjectT` ='"+ entry.SubjectT +"',"+"`SubjectN` ='"+ entry.SubjectN +"'WHERE requirementid='"+entry.RequirementID+"' AND method LIKE'%"+name+"%'"); 
				counter++; 
			}
			System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		//st.executeUpdate("SELECT * FROM `traces` where method LIKE `% %`"); 
	}
}
