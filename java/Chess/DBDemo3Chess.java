package Chess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.pattern.FullLocationPatternConverter;

import Chess.param;
import Tables.RequirementClassKey;
import Tables.fieldmethod;
import Tables.methodcalls;
import Tables.methodcallsexecuted;
import Tables.methods;
import Tables.tracesmethods;
import Tables.tracesmethodscallees;
import mypackage.Clazz;
import mypackage.Interface;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtComment;
import spoon.reflect.code.CtConstructorCall;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtFieldAccess;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtReturn;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtTargetedExpression;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtInterface;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.ClassFactory;
import spoon.reflect.factory.Factory;
import spoon.reflect.factory.InterfaceFactory;
import spoon.reflect.factory.MethodFactory;
import spoon.reflect.path.CtPath;
import spoon.reflect.reference.CtExecutableReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.reference.CtVariableReference;
import spoon.reflect.visitor.Query;
import spoon.reflect.visitor.filter.FieldAccessFilter;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.support.reflect.code.CtConstructorCallImpl;
import spoon.support.reflect.code.CtNewClassImpl;
import spoon.support.reflect.declaration.CtInterfaceImpl;
import spoon.support.reflect.declaration.CtTypeImpl;

/**
 * This class demonstrates how to connect to MySQL and run some basic commands.
 * 
 * In order to use this, you have to download the Connector/J driver and add
 * its .jar file to your build path.  You can find it here:
 * 
 * http://dev.mysql.com/downloads/connector/j/
 * 
 * You will see the following exception if it's not in your class path:
 * 
 * java.sql.SQLException: No suitable driver found for jdbc:mysql://localhost:3306/
 * 
 * To add it to your class path:
 * 1. Right click on your project
 * 2. Go to Build Path -> Add External Archives...
 * 3. Select the file mysql-connector-java-5.1.24-bin.jar
 *    NOTE: If you have a different version of the .jar file, the name may be
 *    a little different.
 *    
 * The user name and password are both "root", which should be correct if you followed
 * the advice in the MySQL tutorial. If you want to use different credentials, you can
 * change them below. 
 * 
 * You will get the following exception if the credentials are wrong:
 * 
 * java.sql.SQLException: Access denied for user 'userName'@'localhost' (using password: YES)
 * 
 * You will instead get the following exception if MySQL isn't installed, isn't
 * running, or if your serverName or portNumber are wrong:
 * 
 * java.net.ConnectException: Connection refused
 */
public class DBDemo3Chess {

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "root";

	/** The name of the computer running MySQL */  
	
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "databasechess";
	
	/** The name of the table we are testing with */
	private final String tableName = "classes";
	public List<tracesmethodscallees> TracesCalleesList= new ArrayList<tracesmethodscallees>();
	public List<tracesmethodscallees> TracesCallersList= new ArrayList<tracesmethodscallees>();

	
	public DBDemo3Chess(List<tracesmethodscallees> tracesCalleesList) {
		 TracesCalleesList= new ArrayList<tracesmethodscallees>();

	}

	public DBDemo3Chess() {
		// TODO Auto-generated constructor stub
	}

	public List<tracesmethodscallees> getTracesCalleesList() {
		return TracesCalleesList;
	}

	public void setTracesCalleesList(List<tracesmethodscallees> tracesCalleesList) {
		TracesCalleesList = tracesCalleesList;
	}

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
	 */
	public void run() {
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
//			st.executeUpdate("DROP SCHEMA `databasechess`"); 
//			
//			st.executeUpdate("CREATE DATABASE `databasechess`"); 
//			st.executeUpdate("CREATE TABLE `databasechess`.`classes` (\r\n" + 
//					"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
//					"  `classname` LONGTEXT NULL,\r\n" + 
//					"  PRIMARY KEY (`id`),\r\n" + 
//					"  UNIQUE INDEX `id_UNIQUE` (`id` ASC));"); 
//			
//			
//
//		    
//		   st.executeUpdate("CREATE TABLE `databasechess`.`superclasses` (\r\n" + 
//		   		"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
//		   		"  `superclassid` INT NULL,\r\n" + 
//		   		"  `superclassname` LONGTEXT NULL,\r\n" + 
//		   		"  `ownerclassid` INT NULL,\r\n" + 
//		   		"  `childclassname` LONGTEXT NULL,\r\n" + 
//		   		"  PRIMARY KEY (`id`),\r\n" + 
//		   		"  INDEX `superclassid_idx` (`superclassid` ASC),\r\n" + 
//		   		"  INDEX `ownerclassid_idx` (`ownerclassid` ASC),\r\n" + 
//		   		"  CONSTRAINT `superclassid`\r\n" + 
//		   		"    FOREIGN KEY (`superclassid`)\r\n" + 
//		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
//		   		"    ON DELETE NO ACTION\r\n" + 
//		   		"    ON UPDATE NO ACTION,\r\n" + 
//		   		"  CONSTRAINT `ownerclassid`\r\n" + 
//		   		"    FOREIGN KEY (`ownerclassid`)\r\n" + 
//		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
//		   		"    ON DELETE NO ACTION\r\n" + 
//		   		"    ON UPDATE NO ACTION);"); 
//		   
//		   st.executeUpdate("CREATE TABLE `databasechess`.`interfaces` (\r\n" + 
//		   		"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 	   	
//		   		"  `interfaceclassid` INT NULL,\r\n" + 
//		   		"  `interfacename` LONGTEXT NULL,\r\n" + 
//		   		"  `ownerclassid` INT NULL,\r\n" + 
//		   		"  `classname` LONGTEXT NULL,\r\n" +	   		
//		   		"  PRIMARY KEY (`id`),\r\n" + 
//		   		"  UNIQUE INDEX `id_UNIQUE` (`id` ASC),\r\n" + 
//		   		"  INDEX `interfaceclassid_idx` (`interfaceclassid` ASC),\r\n" + 
//		   		"  INDEX `classid_idx` (`ownerclassid` ASC),\r\n" + 
//		   		"  CONSTRAINT `interfaceclassid`\r\n" + 
//		   		"    FOREIGN KEY (`interfaceclassid`)\r\n" + 
//		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
//		   		"    ON DELETE NO ACTION\r\n" + 
//		   		"    ON UPDATE NO ACTION,\r\n" + 
//		   		"  CONSTRAINT `ownerclassid2`\r\n" + 
//		   		"    FOREIGN KEY (`ownerclassid`)\r\n" + 
//		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
//		   		"    ON DELETE NO ACTION\r\n" + 
//		   		"    ON UPDATE NO ACTION);"); 
//		   
//		   st.executeUpdate("CREATE TABLE `databasechess`.`methods` (\r\n" + 
//		   		"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
//		   		"  `methodname` LONGTEXT NULL,\r\n" + 
//		   		"  `methodnamerefined` LONGTEXT NULL,\r\n" + 
//		   		"  `methodabbreviation` LONGTEXT NULL,\r\n" + 
//		   		"  `fullmethod` LONGTEXT NULL,\r\n" + 
//		   		"  `classid` INT NULL,\r\n" + 
//		   		"  `classname` LONGTEXT NULL,\r\n" + 
//		   		"  `method` LONGTEXT NULL,\r\n" + 
//		   		"  PRIMARY KEY (`id`),\r\n" + 
//		   		"  UNIQUE INDEX `id_UNIQUE` (`id` ASC),\r\n" + 
//		   		"  INDEX `classid_idx` (`classid` ASC),\r\n" + 
//		   		"  CONSTRAINT `classid2`\r\n" + 
//		   		"    FOREIGN KEY (`classid`)\r\n" + 
//		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
//		   		"    ON DELETE NO ACTION\r\n" + 
//		   		"    ON UPDATE NO ACTION);"); 
//		   st.executeUpdate("CREATE TABLE `databasechess`.`parameters` (\r\n" + 
//		   		"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
//		   		"  `parametername` VARCHAR(200) NULL,\r\n" + 
//		   		"  `parametertype` VARCHAR(200) NULL,\r\n" + 
//		   		"  `parameterclass` INT NULL,\r\n" + 
//		   		"  `classid` INT NULL,\r\n" + 
//		   		"  `classname` VARCHAR(200) NULL,\r\n" + 
//		   		"  `methodid` INT NULL,\r\n" + 
//		   		"  `methodname`  VARCHAR(300) NULL,\r\n" + 
//		   		"  `isreturn` TINYINT NOT NULL,\r\n"+
//		   		"  `sourcecode` LONGTEXT NOT NULL,\r\n"+
//		   		"  PRIMARY KEY (`id`),\r\n" + 
//		   		"  UNIQUE INDEX `id_UNIQUE` (`id` ASC),\r\n" + 
//		   		"  INDEX `classid_idx` (`classid` ASC),\r\n" + 
//		   		"  INDEX `methodid_idx` (`methodid` ASC),\r\n" + 
//		   		"  CONSTRAINT `classid8`\r\n" + 
//		   		"    FOREIGN KEY (`classid`)\r\n" + 
//		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
//		   		"    ON DELETE NO ACTION\r\n" + 
//		   		"    ON UPDATE NO ACTION,\r\n" + 
//		   		"  CONSTRAINT `classid3`\r\n" + 
//		   		"    FOREIGN KEY (`classid`)\r\n" + 
//		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
//		   		"    ON DELETE NO ACTION\r\n" + 
//		   		"    ON UPDATE NO ACTION,\r\n" + 
//		   		"  CONSTRAINT `methodid`\r\n" + 
//		   		"    FOREIGN KEY (`methodid`)\r\n" + 
//		   		"    REFERENCES `databasechess`.`methods` (`id`)\r\n" + 
//		   		"    ON DELETE NO ACTION\r\n" + 
//		   		"    ON UPDATE NO ACTION"+   	
//		   		 ")"); 
//		   st.executeUpdate("CREATE TABLE `databasechess`.`fieldclasses` (\r\n" + 
//		   		"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
//		   		"  `fieldname` LONGTEXT NULL,\r\n" + 
//		   		"  `fieldtypeclassid` INT NULL,\r\n" + 
//		   		"  `fieldtype` LONGTEXT NULL,\r\n" + 
//		   		"  `ownerclassid` INT NULL,\r\n" + 
//		   		"  `classname` LONGTEXT NULL,\r\n" + 
//		   		"  PRIMARY KEY (`id`));"); 
//		   
//
//		   
//		   st.executeUpdate("CREATE TABLE `databasechess`.`fieldmethods` (\r\n" + 
//		   		"  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n" + 
//		   		"  `fieldaccess` VARCHAR(200) NULL,\r\n" + 
//		   		"  `fieldtypeclassid` INT NULL,\r\n" + 
//		   		"  `fieldtypeclassname` LONGTEXT NULL,\r\n" + 
//		   		"  `ownerclassname` VARCHAR(200) NULL,\r\n" + 
//		   		"  `ownerclassid` INT NULL,\r\n" + 
//		   		"  `ownermethodname` VARCHAR(400) NULL,\r\n" + 
//		   		"  `ownermethodid` INT NULL,\r\n" + 
//		   		"  `fieldclassownerclassid` LONGTEXT NULL,\r\n" + 
//		   		"  PRIMARY KEY (`id`));"); 
//		   
//
//		   st.executeUpdate("CREATE TABLE `databasechess`.`methodcalls` (\r\n" + 
//		   		"  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n" + 
//		   		"  `callermethodid` INT NULL,\r\n" + 
//		   		"  `callername` LONGTEXT NULL,\r\n" + 
//		   		"  `callerclass` LONGTEXT NULL,\r\n" + 
//		   		"  `callerclassid` LONGTEXT NULL,\r\n" + 
//		   		"  `fullcaller` LONGTEXT NULL,\r\n" +
//		   		"  `fullcallershort` LONGTEXT NULL,\r\n" + 
//		   		"  `calleemethodid` INT NULL,\r\n" + 
//		   		"  `calleename` LONGTEXT NULL,\r\n" + 
//		   		"  `calleeclass` LONGTEXT NULL,\r\n" + 
//		   		"  `calleeclassid` LONGTEXT NULL,\r\n" + 
//		   		"  `fullcallee` LONGTEXT NULL,\r\n" + 
//		   		"  `fullcalleeshort` LONGTEXT NULL,\r\n" + 
//				"  `fullmethod` LONGTEXT NULL,\r\n" + 
//		   		"  PRIMARY KEY (`id`));"); 
//		   st.executeUpdate("CREATE TABLE `databasechess`.`methodcallsexecuted` (\r\n" + 
//			   		"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
//			   		"  `callermethodid` LONGTEXT NULL,\r\n" + 
//			   		"  `callername` LONGTEXT NULL,\r\n" + 
//			   		"  `callerclass` LONGTEXT NULL,\r\n" + 
//			   		"  `fullcaller` LONGTEXT NULL,\r\n" + 
//			   		"  `fullcallershort` LONGTEXT NULL,\r\n" + 
//			   		"  `calleemethodid` LONGTEXT NULL,\r\n" + 
//			   		"  `calleename` LONGTEXT NULL,\r\n" + 
//			   		"  `calleeclass` LONGTEXT NULL,\r\n" + 
//			   		"  `fullcallee` LONGTEXT NULL,\r\n" + 
//			   		"  `fullcalleeshort` LONGTEXT NULL,\r\n" + 
//			   		"  PRIMARY KEY (`id`),\r\n" + 
//			   		"  UNIQUE INDEX `id_UNIQUE` (`id` ASC)); " ); 
//		   st.executeUpdate("CREATE TABLE `databasechess`.`traces` (\r\n" + 
//		   		"  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n" + 
//		   		"  `requirement` LONGTEXT NULL,\r\n" + 
//		   		"  `requirementid` INT,\r\n" + 
//		   		"  `method` LONGTEXT NULL,\r\n" + 
//		   		"  `methodname` LONGTEXT NULL,\r\n" + 
//		   		"  `fullmethod` LONGTEXT NULL,\r\n" +
//		   		"  `methodid` INT NULL,\r\n" + 
//		   		"  `classname` LONGTEXT NULL,\r\n" + 
//		   		"  `classid` LONGTEXT NULL,\r\n" + 
//		   		"  `gold` LONGTEXT NULL,\r\n" + 
//		   		"  `subject` LONGTEXT NULL,\r\n" + 
//		   		"  `prediction` LONGTEXT NULL,\r\n" + 
//		   		"  `likelihood` LONGTEXT NULL,\r\n" + 
//		   		"  `why` LONGTEXT NULL,\r\n" + 
//		   		"  PRIMARY KEY (`id`));\r\n" + 	
//		   		""); 
//		 
//		   
//		   st.executeUpdate("CREATE TABLE `databasechess`.`requirements` (\r\n" + 
//		   		"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
//		   		"  `requirementname` LONGTEXT NULL,\r\n" + 
//		   		"  PRIMARY KEY (`id`),\r\n" + 
//		   		"  UNIQUE INDEX `id_UNIQUE` (`id` ASC));"); 
//			 st.executeUpdate("CREATE TABLE `databasechess`.`tracesclasses` (\r\n" + 
//			 		"  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n" + 
//			 		"  `requirement` LONGTEXT NULL,\r\n" + 
//			 		"  `requirementid` INT NULL,\r\n" + 
//			 		"  `classname` LONGTEXT NULL,\r\n" + 
//			 		"  `classid` INT NULL,\r\n" + 
//			 		"  `gold` LONGTEXT NULL,\r\n" + 
//			 		"  `subject` LONGTEXT NULL,\r\n" + 
//			 		"  PRIMARY KEY (`id`),\r\n" + 
//			 		"  UNIQUE INDEX `idtracesclasses_UNIQUE` (`id` ASC));\r\n" + 
//			 		""); 
//   
//			st.executeUpdate("CREATE TABLE `databasechess`.`methodsinterfaces` (\r\n" + 
//					"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
//					"  `methodid` VARCHAR(45) NULL,\r\n" + 
//					"  `fullmethodname` LONGTEXT NULL,\r\n" +
//					"  `fullmethodnameshort` LONGTEXT NULL,\r\n" + 
//					"  `classid` VARCHAR(45) NULL,\r\n" + 
//					"  `classname` LONGTEXT NULL,\r\n" + 
//					"  `interfacemethodid` VARCHAR(45) NULL,\r\n" + 
//					"  `fullinterfacename` LONGTEXT NULL,\r\n" + 
//					"  `fullinterfacenameshort` LONGTEXT NULL,\r\n" + 
//					"  `interfaceid` VARCHAR(45) NULL,\r\n" + 
//					"  `interfacename` LONGTEXT NULL,\r\n" + 
//					"  PRIMARY KEY (`id`));\r\n" + 
//					""); 
//			
//			
//			st.executeUpdate("CREATE TABLE `databasechess`.`methodssuperclasses` (\r\n" + 
//					"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
//					"  `methodid` VARCHAR(45) NULL,\r\n" + 
//					"  `fullmethodname` LONGTEXT NULL,\r\n" + 
//					"  `fullmethodnameshort` LONGTEXT NULL,\r\n" + 
//					"  `classid` VARCHAR(45) NULL,\r\n" + 
//					"  `classname` LONGTEXT NULL,\r\n" + 
//					"  `superclassmethodid` VARCHAR(45) NULL,\r\n" + 
//					"  `fullsuperclassname` LONGTEXT NULL,\r\n" + 
//					"  `fullsuperclassnameshort` LONGTEXT NULL,\r\n" + 
//					"  `superclassid` VARCHAR(45) NULL,\r\n" + 
//					"  `superclassname` LONGTEXT NULL,\r\n" + 
//					"  PRIMARY KEY (`id`));\r\n" + 
//					""); 

		   try {
			Spoon();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  
		   
		   
		
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		}
		
		
	}
	
	/**
	 * Connect to the DB and do some stuff
	 */
	public static void main(String[] args) {
		DBDemo3Chess app = new DBDemo3Chess();
		app.run();
	}
	
	public void Spoon() throws SQLException, FileNotFoundException {
		DBDemo3Chess dao = new DBDemo3Chess();
	Connection conn=getConnection();
	Statement st= conn.createStatement();
	
	Statement st2= conn.createStatement();
	Statement st3= conn.createStatement();
	Statement st4= conn.createStatement();
	Statement st5= conn.createStatement();
	
		SpoonAPI spoon = new Launcher();
    	spoon.addInputResource("C:\\Users\\mouna\\Downloads\\chess and gantt code\\workspace_codeBase\\Chess\\src");
    	spoon.getEnvironment().setAutoImports(true);
    	spoon.getEnvironment().setNoClasspath(true);
    	CtModel model = spoon.buildModel();
    	//List<String> classnames= new ArrayList<String>(); 
  
    	// Interact with model
    	Factory factory = spoon.getFactory();
    	ClassFactory classFactory = factory.Class();
    	MethodFactory methodFactory = factory.Method(); 
    	InterfaceFactory interfaceFactory = factory.Interface(); 
    	int i=1; 
        /*********************************************************************************************************************************************************************************/	
        /*********************************************************************************************************************************************************************************/	
        /*********************************************************************************************************************************************************************************/	  	
    
    	

		
		
		

    	
    	
  //  	BUILD CLASSES TABLE 
//    	for(CtType<?> clazz : classFactory.getAll(true)) {
//    		
//    	
//    		
//			
//			String FullClassName= clazz.getPackage()+"."+clazz.getSimpleName(); 
//			st.executeUpdate("INSERT INTO `classes`(`classname`) VALUES ('"+FullClassName+"');");
//		
//			 ResultSet rs = st.executeQuery("SELECT * FROM classes"); 
//   		   while(rs.next()){
//   			   //System.out.println(rs.getString("classname"));
//   		   }			
//   		
//    		
//    				
//    	
//   
//    		
//  		
//    		 for(CtField<?> field : clazz.getFields()) {
//    				for(CtMethod<?> method :clazz.getMethods()) {
//    	    			// method.getParameters()
//    	    			method.<CtFieldAccess<?>>getElements(new FieldAccessFilter(field.getReference()));
//    	    		}
//    		 }
//    	}
////////    	/*********************************************************************************************************************************************************************************/	
////////        /*********************************************************************************************************************************************************************************/	
////////        /*********************************************************************************************************************************************************************************/
////    //	BUILD SUPERCLASSES TABLE 
//    	for(CtType<?> clazz : classFactory.getAll(true)) {
//    		String childclassQuery = null; 
//    		String superclassQuery = null;
//    		String superclassQueryName=null; 
//    		String childclassQueryName=null; 
//    		
//    		String FullClassName= clazz.getPackage()+"."+clazz.getSimpleName(); 
//    	
//    		if(clazz.getSuperclass()!=null ) {
//    			String superclass= clazz.getSuperclass().toString();
//    		
//    
//    					ResultSet sClass = st.executeQuery("SELECT classes.* from classes where classname='"+superclass+"'"); 
//    					while(sClass.next()){
//    						 superclassQuery= sClass.getString("id"); 
//    						 superclassQueryName= sClass.getString("classname"); 
//    			
//    			   		   }
//
//    				
//    					
//    					ResultSet cClass = st.executeQuery("SELECT classes.* from classes where classname='"+FullClassName+"'"); 
//    					while(cClass.next()){
//    						 childclassQuery= cClass.getString("id"); 
//    						 childclassQueryName= cClass.getString("classname"); 
//    			
//    			   		   }
//    				
//    					
//    			String result= "SELECT classname from classes where classname='"+FullClassName+"'"; 
//    			if(superclassQuery!=null)
//    			st.executeUpdate("INSERT INTO `superclasses`(`superclassid`, `superclassname`, `ownerclassid`, `childclassname`) VALUES ('"+superclassQuery +"','" +superclassQueryName+"','" +childclassQuery+"','" +childclassQueryName+"')");
//    			
//    		
//    		
//    		
//        		
//    		}
//    	}
//     
//    	
////////////////    	/*********************************************************************************************************************************************************************************/	
////////////////        /*********************************************************************************************************************************************************************************/	
////////////////        /*********************************************************************************************************************************************************************************/	
//////////////    	  	
////////////     	//BUILD INTERFACES TABLE 
//    	
//
//
//
//
//    	
//    	
//    	
// 
//
//    	List<String> mylist2 = new ArrayList<String>(); 
//    	for(CtType clazz : classFactory.getAll(true)) {
//    		
//    		if(clazz instanceof CtClass) {
//    			String myinterfaceclassid = null;
//        		String myinterfacename = null;
//        		String myclassid = null;
//        		String myclassname = null;
//        		
//    			String FullClassName= clazz.getPackage()+"."+clazz.getSimpleName(); 
//    			Set<CtTypeReference<?>> interfaces = clazz.getSuperInterfaces(); 
//
//    			for(CtTypeReference<?> inter: interfaces) {
//    			
//    					
//    				
//    		
//    					
//    				
//    					ResultSet interfacesnames = st.executeQuery("SELECT classname from classes where classname='"+inter+"'"); 
//    					while(interfacesnames.next()){
//    						myinterfacename= interfacesnames.getString("classname"); 
//    			   		   }
//    					
//    					ResultSet interfacesclasses = st.executeQuery("SELECT id from classes where classname='"+inter+"'"); 
//    					while(interfacesclasses.next()){
//    						myinterfaceclassid= interfacesclasses.getString("id"); 
//    			   		   }
//    					
//    					ResultSet classesnames= st.executeQuery("SELECT classname from classes where classname='"+FullClassName+"'"); 
//    					while(classesnames.next()){
//    						myclassname= classesnames.getString("classname"); 
//    			   		   }
//    					
//    					ResultSet interfacesname = st.executeQuery("SELECT id from classes where classname='"+FullClassName+"'"); 
//    					while(interfacesname.next()){
//    						myclassid= interfacesname.getString("id"); 
//    			   		   }
//    					String interface1= myinterfaceclassid+ myinterfacename;  
//    					String implementation1= myclassid+ myclassname; 
//    					
//    						System.out.println("INTERRRR "+inter.getQualifiedName());
//    						System.out.println("CLAZZZZ "+clazz.getQualifiedName());
//    					
//    		
//    		
//					
//					
//					if(myinterfaceclassid!=null && !mylist2.contains(interface1+implementation1) ) {
//		    			st.executeUpdate("INSERT INTO `interfaces`(`interfaceclassid`,`interfacename`,`ownerclassid`, `classname`) VALUES ('"+myinterfaceclassid +"','" +myinterfacename+"','" +myclassid+"','" +myclassname+"')");
//		    			mylist2.add(interface1+implementation1); 
//					}
//    			}
//
//					
//				
//					
//					
//					
//			
//				
//				
//				
//			}
//			
//    		
//       	List<String> mylist = new ArrayList<String>(); 
//
//     		if(clazz instanceof CtInterface) {
//    			String myinterfaceclassid = null;
//        		String myinterfacename = null;
//        		String myclassid = null;
//        		String myclassname = null;
//        		
//    			String FullClassName= clazz.getPackage()+"."+clazz.getSimpleName(); 
//    			Set<CtTypeReference<?>> interfaces = clazz.getSuperInterfaces(); 
//
//    			for(CtTypeReference<?> inter: interfaces) {
//    			
//    				ResultSet interfacesnames = st.executeQuery("SELECT classname from classes where classname='"+inter+"'"); 
//					while(interfacesnames.next()){
//						myinterfacename= interfacesnames.getString("classname"); 
//			   		   }
//					
//					ResultSet interfacesclasses = st.executeQuery("SELECT id from classes where classname='"+inter+"'"); 
//					while(interfacesclasses.next()){
//						myinterfaceclassid= interfacesclasses.getString("id"); 
//			   		   }
//					
//					ResultSet classesnames= st.executeQuery("SELECT classname from classes where classname='"+FullClassName+"'"); 
//					while(classesnames.next()){
//						myclassname= classesnames.getString("classname"); 
//			   		   }
//					
//					ResultSet interfacesname = st.executeQuery("SELECT id from classes where classname='"+FullClassName+"'"); 
//					while(interfacesname.next()){
//						myclassid= interfacesname.getString("id"); 
//			   		   }
//					String interface1= myinterfaceclassid+ myinterfacename;  
//					String implementation1= myclassid+ myclassname; 
//    				
//    		
//    					
//    				
//    					
//    					
//    						System.out.println("INTERRRR2 "+inter.getQualifiedName());
//    						System.out.println("CLAZZZZ2 "+clazz.getQualifiedName());
//    					
//    		
//    		
//					
//					
//					if(myinterfaceclassid!=null && !mylist.contains(interface1+implementation1) ) {
//		    			st.executeUpdate("INSERT INTO `superclasses`(`superclassid`, `superclassname`, `ownerclassid`, `childclassname`) VALUES ('"+myinterfaceclassid +"','" +myinterfacename+"','" +myclassid+"','" +myclassname+"')");
//		    			mylist.add(interface1+implementation1); 
//					}
//    			}
//
//					
//				
//					
//					
//					
//			
//				
//				
//				
//			}
//    		
//
//    	}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//////
//////
/////////*********************************************************************************************************************************************************************************/	
/////////*********************************************************************************************************************************************************************************/	
/////////*********************************************************************************************************************************************************************************/	  	
//    	
//    	
//    	
//    	
//    	
//    	
//    	
//  	
////   
////    	
//////   	/*********************************************************************************************************************************************************************************/	
//////        /*********************************************************************************************************************************************************************************/	
//////        /*********************************************************************************************************************************************************************************/	  	
//////    	//BUILD METHODS TABLE 
//    	List<methods> mymethodlist = new ArrayList<methods>(); 
//    	for(CtType<?> clazz : classFactory.getAll(true)) {
//    		
//    	
//    		String myclassid = null;
//    		String myclassname = null;
//    		
//    		//ALTERNATIVE: Collection<CtMethod<?>> methods = clazz.getAllMethods(); 
//			Collection<CtMethod<?>> methods = clazz.getMethods(); 
//			System.out.println("CLASS SIMPLE NAME :    "+clazz.getSimpleName());
//			String FullClassName= clazz.getPackage()+"."+clazz.getSimpleName(); 
//			
//			int count = StringUtils.countMatches(clazz.getPackage().toString(), ".");
//			//System.out.println("count:   "+count);
//			//NEEDS TO BE CHANGED 
//		//	if(count==2) {
//			 List<CtConstructor> MyContructorlist = clazz.getElements(new TypeFilter<>(CtConstructor.class)); 
//			 for(CtConstructor<?> constructor: MyContructorlist) {
//				
//				 
//				 
//			String	constructorString=WriteConstructorIntoDatabase(constructor); 
//				 	
//					String FullConstructorName=constructor.getSignature().toString(); 
//					
//					String methodabbreviation=FullConstructorName.substring(0, FullConstructorName.indexOf("(")); 
//					 methodabbreviation=FullClassName+".-init-"; 
//
//					System.out.println("FULL CONSTRUCTOR NAME BEFORE METHOD ABBREVIATION:"+methodabbreviation);
//
//					//st.executeUpdate("INSERT INTO `fields`(`fieldname`) VALUES ('"+field+"');");
//					//24 is the size of the string "net.sourceforge.ganttproject.javaChess."
//					int packagesize= "net.sourceforge.ganttproject.".length(); 
//						FullConstructorName=FullConstructorName.substring(packagesize, FullConstructorName.length()); 
//						FullConstructorName="-init-"+FullConstructorName.substring(FullConstructorName.lastIndexOf('('));  
//						
//							System.out.println("FULL CONSTRUCTOR NAME AFTER:"+FullConstructorName);
//
//						ResultSet classesreferenced = st.executeQuery("SELECT id from classes where classname='"+FullClassName+"'"); 
//						while(classesreferenced.next()){
//							myclassid= classesreferenced.getString("id"); 
//					//		System.out.println("class referenced: "+myclass);	
//				   		   }
//						ResultSet classnames = st.executeQuery("SELECT classname from classes where classname='"+FullClassName+"'"); 
//						while(classnames.next()){
//							myclassname= classnames.getString("classname"); 
//					//		System.out.println("class referenced: "+myclass);	
//				   		   }
//						
//							System.out.println("FullClassName====="+ FullConstructorName);
//					
//							String FullMethodNameRefined=FullConstructorName.substring(0, FullConstructorName.indexOf("(")); 
//							//String FullMethodName=constructor.getSignature().toString(); 
//							String fullmeth= myclassname+"."+FullConstructorName; 
//							System.out.println(FullClassName);
//							methods meth= new methods(fullmeth, myclassid, myclassname); 
//							if(meth.contains(mymethodlist, meth)==false ) {
//							
//								
//							
//								fullmeth=myclassname+"."+FullConstructorName; 
//								 methodabbreviation=fullmeth.substring(0, fullmeth.indexOf("("));
//				    			st.executeUpdate("INSERT INTO `methods`(`methodname`, `methodnamerefined`, `methodabbreviation`, `fullmethod`,`classid`, `classname`, `method`) VALUES ('"+FullConstructorName+"','" +FullMethodNameRefined +"','" +methodabbreviation+"','" +fullmeth+"','" +myclassid+"','" +myclassname+"','" +constructorString+"')");
//
//								
//				    			mymethodlist.add(meth); 
//							}
//						
//
//						}
//			 
//			 
//			 
//			for(CtMethod<?> method: methods) {
//				 
//				 String NewMethodString = WriteMethodIntoDatabase(method); 
//				String FullMethodName=method.getSignature().toString(); 
//				System.out.println("==============>"+method.getShortRepresentation().toString());
//				//st.executeUpdate("INSERT INTO `fields`(`fieldname`) VALUES ('"+field+"');");
//			//	System.out.println(FullClassName);
//				String FullMethodNameRefined=FullMethodName.substring(0, FullMethodName.indexOf("(")); 
//				String longmeth= clazz.getQualifiedName()+"."+FullMethodName; 
//				String methodabbreviation=longmeth.substring(0, longmeth.indexOf("(")); 
//					ResultSet classesreferenced = st.executeQuery("SELECT id from classes where classname='"+FullClassName+"'"); 
//					while(classesreferenced.next()){
//						myclassid= classesreferenced.getString("id"); 
//				//		System.out.println("class referenced: "+myclass);	
//			   		   }
//					ResultSet classnames = st.executeQuery("SELECT classname from classes where classname='"+FullClassName+"'"); 
//					while(classnames.next()){
//						myclassname= classnames.getString("classname"); 
//				//		System.out.println("class referenced: "+myclass);	
//			   		   }
//					
//				
//				
//						String fullmeth= myclassname+"."+FullMethodName; 
//						System.out.println(FullClassName);
//						methods meth= new methods(FullMethodName, myclassid, myclassname); 
//						if(meth.contains(mymethodlist, meth)==false ) {
//							longmeth=myclassname+"."+FullMethodName; 
//							 methodabbreviation=longmeth.substring(0, fullmeth.indexOf("("));
//			    			st.executeUpdate("INSERT INTO `methods`(`methodname`,  `methodnamerefined`,`methodabbreviation`, `fullmethod`,`classid`, `classname`, `method`) VALUES ('"+FullMethodName +"','" +FullMethodNameRefined+"','" +methodabbreviation+"','" +longmeth+"','" +myclassid+"','" +myclassname+"','" +NewMethodString+"')");
//
//							
//			    			mymethodlist.add(meth); 
//						}
//						
//						
//   	
//					}
//
//					
//				
//				
//			//}
//			
//			
//		
//			
//		
//    	}
//    	
//    	for(CtType<?> myinterface : interfaceFactory.getAll(true)) {
//    		Collection<CtMethod<?>> methods = myinterface.getMethods(); 
//
//    		for(CtMethod<?> method: methods) {
//    			 String NewMethodString = WriteMethodIntoDatabase(method); 
//    			String myinterfaceid=null; 
//    			String myinterfacename=null; 
//				String FullMethodName=method.getSignature().toString(); 
//				System.out.println("==============>"+method.getShortRepresentation().toString());
//				//st.executeUpdate("INSERT INTO `fields`(`fieldname`) VALUES ('"+field+"');");
//			//	System.out.println(FullClassName);
//				String FullMethodNameRefined=FullMethodName.substring(0, FullMethodName.indexOf("(")); 
//				String longmeth= myinterface.getQualifiedName()+"."+FullMethodName; 
//				String methodabbreviation=longmeth.substring(0, longmeth.indexOf("(")); 
//				String inter=myinterface.getQualifiedName(); 
//				if(inter.contains("$")) {
//					inter= inter.substring(0, inter.indexOf("$")); 
//
//				}
//					ResultSet classesreferenced = st.executeQuery("SELECT classes.* from classes where classname='"+inter+"'"); 
//					System.out.println("INTER"+myinterface.getQualifiedName());
//					while(classesreferenced.next()){
//						myinterfaceid= classesreferenced.getString("id"); 
//						myinterfacename= classesreferenced.getString("classname"); 
//				//		System.out.println("class referenced: "+myclass);	
//			   		   }
//				
//					
//				
//				
//						String fullmeth= myinterfacename+"."+FullMethodName; 
//						System.out.println(fullmeth);
//						methods meth= new methods(FullMethodName, myinterfaceid, myinterfacename); 
//						if(meth.contains(mymethodlist, meth)==false ) {
//							longmeth=myinterfacename+"."+FullMethodName; 
//							 methodabbreviation=longmeth.substring(0, fullmeth.indexOf("("));
//			    			st.executeUpdate("INSERT INTO `methods`(`methodname`,  `methodnamerefined`,`methodabbreviation`, `fullmethod`,`classid`, `classname`, `method`) VALUES ('"+FullMethodName +"','" +FullMethodNameRefined+"','" +methodabbreviation+"','" +longmeth+"','" +myinterfaceid+"','" +myinterfacename+"','" +NewMethodString+"')");
//
//							
//			    			mymethodlist.add(meth); 
//						}
//						
//						
//   	
//					}
//			
//		
//    	}
//////////////////////////      	/*********************************************************************************************************************************************************************************/	
//////////////////////////        /*********************************************************************************************************************************************************************************/	
//////////////////////////        /*********************************************************************************************************************************************************************************/
////////////////////////    	
//////////////////////    	
////////    	//PARAMETERS
//  	   List<String> paramlist= new ArrayList<String>();   	
//  	   for(CtType<?> clazz : classFactory.getAll(true)) {
//  	       		
//  	       		System.out.println(clazz.getSimpleName());
//  	       		System.out.println(clazz.getPackage());
//  	       		String fullname= clazz.getPackage()+""+clazz.getQualifiedName(); 
//  	       		String MethodReferenced=null; 
//  	       		String MethodName=null; 
//  	       		String parameter=null; 
//  	       	    String ClassName=null; 
//  	       	    String classid=null; 
//  	       		String parameterclass=null; 
//  	       		String paramclassid=null; 
//  	       				
//  	       		 //for(CtField<?> field : clazz.getFields()) {
//  	       				for(CtMethod<?> method :clazz.getMethods()) {
//  	       	    			List<CtParameter<?>> params = method.getParameters(); 
//  	       				
//  	       	    			
//  	       	    			
//  	       	    		
//  	       	    		List<CtComment> CommentList = method.getElements(new TypeFilter<CtComment>(CtComment.class));
//  	       	    	List<CtComment> NewCommentList= CommentList; 
//  	       	    	NewCommentList = method.getElements(new TypeFilter<CtComment>(CtComment.class));
//  	       	    	int size=NewCommentList.size(); 
//  	       	    	System.out.println(method);
//  	       	    	int  j=0; 
//  	       	    	if(CommentList!=null) {
//  	       	    		CtMethod newmethod=method; 
//  	       	    		
//  	       	    		
//  	       	    		while(j<size) {
//  	       	    			
//  	       	    			CtComment newcomment = NewCommentList.get(j); 
//  	       	    			newmethod=newmethod.removeComment(newcomment); 
//  	       	    			 size=NewCommentList.size(); 
//  	       	    			 j++; 
//  	       	    		}
//  	       	    		
//  	       	    		method=newmethod; 
//  	       	    	}
//  	       	    	 String methodString = method.toString().replaceAll("\\/\\/.*", ""); 
//  	       	    	 methodString = methodString.toString().replaceAll("\'", ""); 
//  	       	    	 
//  	       	    	 
//  	       	    	 
//  	       	    	 
//  	       	    			for( CtParameter<?> myparam :params) {
//  	       	    				String paramInfo=""; 
//  	       	    				boolean flag2=false; 
//  	       	    				String fullmethod=clazz.getQualifiedName()+"."+method.getSignature().toString(); 
//  	       	    				ResultSet classnames = st.executeQuery("SELECT methods.* from methods where methods.fullmethod='"+fullmethod+"'"); 
//  	       	    				
//  	   	    					while(classnames.next()){
//  	   	    						 ClassName =classnames.getString("classname"); 
//  	   	    						 classid =classnames.getString("classid"); 
//  	   	    						MethodReferenced =classnames.getString("id"); 
//  	   	    			   		   }
//  	   	    					
////  	   	    					ResultSet classids = st.executeQuery("SELECT classes.id from classes INNER JOIN methods ON classes.id=methods.classid where methods.methodname='"+method.getSignature().toString()+"' "); 
////  	       	    				
////  	   	    					while(classids.next()){
////  	   	    						 classid =classids.getString("id"); 
////  	   	    					
////  	   	    			   		   }
//  	   	    					
////  	       	    					ResultSet methods = st.executeQuery("SELECT methods.id from methods INNER JOIN classes ON classes.id=methods.classid where methods.methodname='"+method.getSignature().toString()+"' and classes.id='"+classid+"'"); 
////  	       	    				
////  	       	    					while(methods.next()){
////  	       	    						MethodReferenced =methods.getString("id"); 
////  	       	    					
////  	       	    			   		   }
//  	       	    				
//  	       	    					ResultSet paramclassids = st.executeQuery("SELECT classes.id from classes where classes.classname='"+myparam.getType()+"'"); 
//  	           	    				
//  	       	    					while(paramclassids.next()){
//  	       	    						flag2=true; 
//  	       	    						paramclassid =paramclassids.getString("id"); 
//  	       	    					
//  	       	    			   		   }
//  	       	    			
//  	       	    				
//  	       	    					
//  	       	    					
//  	           		    			 paramInfo=myparam +"','" +myparam.getType() +"','"+paramclassid+"','"+classid +"','"+ClassName+"','" +MethodReferenced+"','" +method.getSignature().toString()+"','" +0; 
//
//  	       	    				//	if(field.toString().contains("java.awt")==false && field.toString().contains("javax")==false) {
//  	       	    					//	System.out.println("HERE IS A PARAMETER: "+ myparam);
//  	       	    						System.out.println("paramInfo  "+paramInfo);
//  	       	    						if(MethodReferenced==null) {
//  	       	    							System.out.println("HERE IS NULL PARAMETER: "+myparam+"method referenced======>"+MethodReferenced);
//  	       	    						}
//  	       	    						if(MethodReferenced!=null && flag2==true && paramlist.contains(paramInfo)==false) {
//  	           	    		    			st.executeUpdate("INSERT INTO `parameters`(`parametername`, `parametertype`, `parameterclass`,`classid`, `classname`, `methodid`, `methodname`, `isreturn`, `sourcecode`) VALUES ('"+myparam +"','" +myparam.getType() +"','"+paramclassid+"','"+classid +"','"+ClassName+"','" +MethodReferenced+"','" +clazz.getQualifiedName()+"."+method.getSignature().toString()+"','" +0+"','" +methodString+"')");
//  	           	    		    			paramlist.add(paramInfo); 
//  	       	    						}
//
//  	       	    				//	}
//  	       	    				
//  	       	    				
//  	       	    			}
//  	       	    			
//  	       	    		
//  	       	    			/*List<CtStatement> bodystatements = methodbody.getStatements(); 
//  	       	    			//List<CtReturn> returnstatement = methodbody.getElements(new TypeFilter<>(CtReturn.class)); 
//  	       	    		
//  	       	    				List<CtReturn> returnstatement = methodbody.getElements(new TypeFilter<>(CtReturn.class)); 
//  	       	    				for(CtReturn ret: returnstatement) {
//  	       	    					System.out.println("HERE IS RETURN: "+ret.getReturnedExpression().getType());
//  	       	    					ret.getReturnedExpression().getType(); 
//  	       	    				
//  	       	    			}*/
//  	       	    			boolean flag=false; 
//  	       	    			CtTypeReference<?> MethodType = method.getType();  
//  	        	    		//	System.out.println("METHOD TYPE  "+ MethodType);
////  	        	    			ResultSet classnames = st.executeQuery("SELECT classes.classname from classes INNER JOIN methods ON classes.id=methods.classid where methods.methodname='"+method.getSignature().toString()+"' "); 
////  	   	    				
////  	       					while(classnames.next()){
////  	       						 ClassName =classnames.getString("classname"); 
////  	       					
////  	       			   		   }
////  	       					
////  	       					ResultSet classids = st.executeQuery("SELECT classes.id from classes INNER JOIN methods ON classes.id=methods.classid where methods.methodname='"+method.getSignature().toString()+"' "); 
////  	   	    				
////  	       					while(classids.next()){
////  	       						 classid =classids.getString("id"); 
////  	       					
////  	       			   		   }
////  	       					
////  	   	    					ResultSet methods = st.executeQuery("SELECT methods.id from methods INNER JOIN classes ON classes.id=methods.classid where methods.methodname='"+method.getSignature().toString()+"' and classes.id='"+classid+"'"); 
////  	   	    				
////  	   	    					while(methods.next()){
////  	   	    						MethodReferenced =methods.getString("id"); 
////  	   	    					
////  	   	    			   		   }
//  	       	    			
// 	       	    				String fullmethod=clazz.getQualifiedName()+"."+method.getSignature().toString(); 
//
//  	   	    				
//  	       	    			ResultSet classnames = st.executeQuery("SELECT methods.* from methods where methods.fullmethod='"+fullmethod+"'"); 
// 	       	    				
// 	   	    					while(classnames.next()){
// 	   	    						 ClassName =classnames.getString("classname"); 
// 	   	    						 classid =classnames.getString("classid"); 
// 	   	    						MethodReferenced =classnames.getString("id"); 
// 	   	    			   		   }
// 	   	    				if(MethodType.toString().contains("<")==true) {
// 	   	    					String methtype=MethodType.toString().substring(MethodType.toString().indexOf("<")+1, MethodType.toString().indexOf(">")); 
// 	   	    					ResultSet parameterclasses = st.executeQuery("SELECT classes.id from classes where classes.classname='"+methtype+"'"); 
//	   		    				
//	   	    					while(parameterclasses.next()){
//	   	    						parameterclass =parameterclasses.getString("id"); 
//	   	    						flag=true; 
//	   	    					
//	   	    			   		   }
// 	   	    					}
//  	   	    					ResultSet parameterclasses = st.executeQuery("SELECT classes.id from classes where classes.classname='"+MethodType+"'"); 
//  	   		    				
//  	   	    					while(parameterclasses.next()){
//  	   	    						parameterclass =parameterclasses.getString("id"); 
//  	   	    						flag=true; 
//  	   	    					
//  	   	    			   		   }
//  	       		    			String paramInfo= MethodType +"','" +MethodType+"','" +parameterclass +"','" +classid +"','"+ClassName+"','" +MethodReferenced+"','" +method.getSignature().toString()+"','" +1; 
//  	       		    			System.out.println("paramInfo  "+paramInfo);
//  	       	    			if(MethodReferenced!=null && flag==true && paramlist.contains(paramInfo)==false) {
//  	       		    			st.executeUpdate("INSERT INTO `parameters`(`parametername`, `parametertype`, `parameterclass`,`classid`, `classname`, `methodid`, `methodname`, `isreturn`, `sourcecode`) VALUES ('"+MethodType +"','" +MethodType+"','" +parameterclass +"','" +classid +"','"+ClassName+"','" +MethodReferenced+"','" +clazz.getQualifiedName()+"."+method.getSignature().toString()+"','" +1+"','" +methodString+"')");
//  	       		    			paramlist.add(paramInfo);
//  	       	    			}
//
//  	       	    		
//  	       	    		}
//  	       				
//  	       				
//  	       				
//  	       				
//  	       				
//  	       				
//  	       				
//  	       				
//  	       			List<CtConstructor> constructorcallers = clazz.getElements(new TypeFilter<CtConstructor>(CtConstructor.class));
//  	       	   for(CtConstructor<?> cons :constructorcallers) {	
//	       	    			List<CtParameter<?>> params = cons.getParameters(); 
//	       	    			List<CtComment> CommentList = cons.getElements(new TypeFilter<CtComment>(CtComment.class));
//	       	    	    	List<CtComment> NewCommentList= CommentList; 
//	       	    	    	NewCommentList = cons.getElements(new TypeFilter<CtComment>(CtComment.class));
//	       	    	    	int size=NewCommentList.size(); 
//	       	    	    	System.out.println(cons);
//	       	    	    	int  j=0; 
//	       	    	    	if(CommentList!=null) {
//	       	    	    		CtConstructor newcons=cons; 
//	       	    	    		
//	       	    	    		
//	       	    	    		while(j<size) {
//	       	    	    			
//	       	    	    			CtComment newcomment = NewCommentList.get(j); 
//	       	    	    			newcons=newcons.removeComment(newcomment); 
//	       	    	    			 size=NewCommentList.size(); 
//	       	    	    			 j++; 
//	       	    	    		}
//	       	    	    		
//	       	    	    		cons=newcons; 
//	       	    	    	}
//	       	    	    	 String consString = cons.toString().replaceAll("\\/\\/.*", ""); 
//	       	    	    	 consString = consString.toString().replaceAll("\'", ""); 
//	       	    			
//	       	    			
//	       	    		
//	       	    	
//	       	    			for( CtParameter<?> myparam :params) {
//	       	    				String paramInfo=""; 
//	       	    				boolean flag2=false; 
//	       	    				String meth=cons.getSignature().toString(); 
//	       	    				meth="-init-"+meth.substring(meth.indexOf("("), meth.indexOf(")")+1); 
//	       	    				String fullmethod=clazz.getQualifiedName()+"."+meth; 
//	       	    				ResultSet classnames = st.executeQuery("SELECT methods.* from methods where methods.fullmethod='"+fullmethod+"'"); 
//	       	    				
//	   	    					while(classnames.next()){
//	   	    						 ClassName =classnames.getString("classname"); 
//	   	    						 classid =classnames.getString("classid"); 
//	   	    						MethodReferenced =classnames.getString("id"); 
//	   	    			   		   }
//	   	    					
//
//	       	    				
//	       	    					ResultSet paramclassids = st.executeQuery("SELECT classes.id from classes where classes.classname='"+myparam.getType()+"'"); 
//	           	    				
//	       	    					while(paramclassids.next()){
//	       	    						flag2=true; 
//	       	    						paramclassid =paramclassids.getString("id"); 
//	       	    					
//	       	    			   		   }
//	       	    			
//	       	    				
//	       	    					
//	       	    					
//	           		    			 paramInfo=myparam +"','" +myparam.getType() +"','"+paramclassid+"','"+classid +"','"+ClassName+"','" +MethodReferenced+"','" +cons.getSignature().toString()+"','" +0; 
//
//	       	    				//	if(field.toString().contains("java.awt")==false && field.toString().contains("javax")==false) {
//	       	    					//	System.out.println("HERE IS A PARAMETER: "+ myparam);
//	       	    						System.out.println("paramInfo  "+paramInfo);
//	       	    						if(MethodReferenced==null) {
//	       	    							System.out.println("HERE IS NULL PARAMETER: "+myparam+"method referenced======>"+MethodReferenced);
//	       	    						}
//	       	    						if(MethodReferenced!=null && flag2==true && paramlist.contains(paramInfo)==false) {
//	           	    		    			st.executeUpdate("INSERT INTO `parameters`(`parametername`, `parametertype`, `parameterclass`,`classid`, `classname`, `methodid`, `methodname`, `isreturn`, `sourcecode`) VALUES ('"+myparam +"','" +myparam.getType() +"','"+paramclassid+"','"+classid +"','"+ClassName+"','" +MethodReferenced+"','" +clazz.getQualifiedName()+"."+fullmethod+"','" +0+"','" +consString+"')");
//	           	    		    			paramlist.add(paramInfo); 
//	       	    						}
//
//	       	    				//	}
//	       	    				
//	       	    				
//	       	    			}
//	       	    			
//	       	    		
//
//	       	    	
//
//	       	    		
//	       	    		
//  	       				
//  	       				
//  	       				
//  	       				
//  	       				
//  	       				
//  	       				
//  	       				
//  	       				
//  	       				
//  	       				
//  	       		 //}
//  	       	}
//  	   }
///////////////////*********************************************************************************************************************************************************************************/	
///////////////////*********************************************************************************************************************************************************************************/	
///////////////////*********************************************************************************************************************************************************************************/
//////////////////	
////////////////////BUILD FIELDS TABLE -- CLASSES
//for(CtType<?> clazz : classFactory.getAll(true)) {
//	
//	
//	
//	
////ALTERNATIVE: Collection<CtFieldReference<?>> fields = clazz.getAllFields(); 
//	Collection<CtField<?>> fields = clazz.getFields(); 
//	String FullClassName= clazz.getPackage()+"."+clazz.getSimpleName(); 
//	
////ALTERNATIVE: 	for(CtFieldReference<?> field: fields) {	
//	for(CtField<?> field: fields) {
//		String myclassid = null;
//		String myclassname=null; 
//		String fieldid=null; 
//		boolean flag=false; 
//	
//		
//		if(clazz.getQualifiedName().contains("$")) {
//			String classnamedollarfree=RemoveDollar(clazz.getQualifiedName()); 
//			System.out.println(classnamedollarfree);
//		}
//		String classnamedollarfree=RemoveDollar(clazz.getQualifiedName()); 
//		
//		
//		 FullClassName= classnamedollarfree; 
//		 System.out.println(FullClassName);
//			ResultSet classesreferenced = st.executeQuery("SELECT * from classes where classname='"+FullClassName+"'"); 
//			while(classesreferenced.next()){
//				myclassid= classesreferenced.getString("id"); 
//				myclassname= classesreferenced.getString("classname"); 
//	   		   }
//		
//			
//			ResultSet fieldids = st.executeQuery("SELECT * from classes where classname='"+field.getType()+"'"); 
//			while(fieldids.next()){
//				flag=true; 
//				fieldid= fieldids.getString("id"); 
//	//			System.out.println("class referenced: "+myclass);	
//	   		   }
//			
//		//	if(field.toString().contains("java.awt")==false && field.toString().contains("javax")==false) {
//			if(fieldid!=null && flag==true) {
//    			st.executeUpdate("INSERT INTO `fieldclasses`(`fieldname`, `fieldtypeclassid`, `fieldtype`, `ownerclassid`,  `classname`) VALUES ('"+field.getSimpleName() +"','"+fieldid +"','"+field.getType() +"','" +myclassid+"','" +myclassname+"')");
//
//			}
//
//		//	}
//		
//		
//	}
//	
//
//}
///////////////////*********************************************************************************************************************************************************************************/	
///////////////////*********************************************************************************************************************************************************************************/	
///////////////////*********************************************************************************************************************************************************************************/   	
////////////////////BUILD FIELDS TABLE -- METHODS
////////////////
//for(CtType<?> clazz : classFactory.getAll(true)) {
//	
//	String FullClassName= clazz.getPackage()+"."+clazz.getSimpleName();
//	List<fieldmethod> FieldMethodsList= new ArrayList<fieldmethod>(); 
//	
//	
//	for(CtMethod<?> method :clazz.getMethods()) {
//		List<CtFieldAccess> list = method.getElements(new TypeFilter<CtFieldAccess>(CtFieldAccess.class)); 
//		for(CtFieldAccess fieldaccess: list) {
//			
//			String fieldname=null; 
//			String Fieldid=null; 
//			String Methodid=null; 
//			String myclassname=null; 
//			String MethodName=null; 
//			String FieldName=null; 
//			String myclassid=null; 
//			String myclass=null; 
//			String fieldid=null; 
//			String fieldclassid=null; 
//			String fieldaccessTargetType=null;
//			System.out.println("FIELD ACCESS===============================  "+fieldaccess);
//			System.out.println("METHOD===============================  "+clazz.getQualifiedName()+"."+method.getSignature());
//
//			boolean flag=false; 
//			
//		
//			
//			if(clazz.getQualifiedName().contains("$")) {
//				String classnamedollarfree=RemoveDollar(clazz.getQualifiedName()); 
//				System.out.println(classnamedollarfree);
//			}
//    		String classnamedollarfree=RemoveDollar(clazz.getQualifiedName()); 
//
//
//			ResultSet classesreferenced = st.executeQuery("SELECT methods.* from methods where classname='"+classnamedollarfree
//			+ "'and methodname='"+method.getSignature()+"'"); 
//	while(classesreferenced.next()){
//		 myclass = classesreferenced.getString("classname"); 
//		 myclassid = classesreferenced.getString("classid"); 
//		  Methodid = classesreferenced.getString("id"); 
//		  MethodName = classesreferenced.getString("methodname"); 
////			System.out.println("class referenced: "+myclass);	
//		   }
//	if(fieldaccess.getType()!=null) {
//		fieldaccessTargetType= fieldaccess.getType().toString(); 
//		fieldaccessTargetType= fieldaccessTargetType.replaceAll("(\\[])", ""); 
//	}
//	
//	
//	
//	System.out.println("FIELD ACCESS TYPE  ================================================================  "+ fieldaccessTargetType);
//
//			ResultSet fieldids = st.executeQuery("SELECT id from classes where classname='"+fieldaccessTargetType+"'"); 
//			while(fieldids.next()){
//				
//				fieldid= fieldids.getString("id"); 
//	   		   }
//			
//
//
//			
//			//////////////////////////////////////////////////////////////////////////////
//			ResultSet myres = st.executeQuery("SELECT * from fieldclasses where fieldname='"+fieldaccess.toString()+"' and fieldtypeclassid='"+fieldid+"' and "
//					+ "fieldtype='"+fieldaccessTargetType+"' and ownerclassid='"+myclassid+"' and classname='"+myclass+"'"); 
//			while(myres.next()){
//				
//				fieldclassid= myres.getString("id"); 
//				System.out.println("FIELD TYPE CLASS ID ::::::::::::::::::::::::::::::::::::::::::"+fieldclassid);
//	   		   }	
//			
//			if(fieldclassid==null) {
//				fieldclassid="null"; 
//			}
//			////////////////////////////////////////////////////////////////////
//			
//			
//			
//			ResultSet	 myres2=null; 
//			if(fieldid!=null) {
//					 String query= "SELECT * from fieldmethods where fieldaccess='"+fieldaccess+"' and fieldtypeclassid='"+fieldid+"' and "
//						+ "fieldtypeclassname='"+fieldaccessTargetType+"' and ownerclassid='"+myclassid+"' and ownerclassname='"+myclass+"' and "
//								+ "fieldclassownerclassid='"+fieldclassid+"'"; 
//					 
//					 
//					myres2= st.executeQuery(query); 
//				
//			}
//			if(myres2!=null) {
//				if(!myres2.next()) {
//					if(fieldid!=null) {
//						st.executeUpdate("INSERT INTO `fieldmethods`(`fieldaccess`, `fieldtypeclassid`, `fieldtypeclassname`,  `ownerclassname`,  `ownerclassid`,  `ownermethodname`, `ownermethodid`, `fieldclassownerclassid`) VALUES ('"+fieldaccess.toString() +"','" +fieldid+"','" +fieldaccessTargetType+"','" +myclass+"','" +myclassid+"','" +MethodName+"','" +Methodid+"','" +fieldclassid+"')");
//
//					}
//				}
//			}
//		
//			
//			
//			
//		
//		}
//		
//		List<CtAssignment> asslist = method.getElements(new TypeFilter<CtAssignment>(CtAssignment.class)); 
//		
//		for(CtAssignment ass: asslist) {
//
//			String fieldtypeclassid=null; 
//			String fieldaccess=null; 
//			
//			String fieldtypeclassname=null; 
//			 fieldaccess= ass.getAssigned().toString(); 
//			
//			 fieldtypeclassname= ass.getAssigned().getType().toString(); 
//			 fieldtypeclassname= fieldtypeclassname.replaceAll("(\\[])", ""); 
//
//			String ownermethodid=null; 
//			String ownerclassid=null; 
//			String fieldclassownerclassid="null"; 
//			 String ownerclassname=RemoveDollar(clazz.getQualifiedName()); 
//			 
//			String ownermethodname= method.getSignature(); 
//			System.out.println("yes");
//			
//			ResultSet fieldids = st.executeQuery("SELECT id from classes where classname='"+fieldtypeclassname+"'"); 
//			while(fieldids.next()){
//				
//				fieldtypeclassid= fieldids.getString("id"); 
//	   		   }
//			
//			
//			ResultSet assinfo = st.executeQuery("SELECT * from methods where methodname='"+ownermethodname+"' and classname='"+ownerclassname+"'"); 
//			while(assinfo.next()){
//				
//				ownermethodid= assinfo.getString("id"); 
//				ownerclassid= assinfo.getString("classid"); 
//				ownerclassname=assinfo.getString("classname");
//				ownermethodname=assinfo.getString("methodname");
//	   		   }
//			
//			
//			ResultSet myres = st.executeQuery("SELECT * from fieldclasses where fieldname='"+fieldaccess+"' and fieldtypeclassid='"+fieldtypeclassid+"' and "
//					+ "fieldtype='"+fieldtypeclassname+"' and ownerclassid='"+ownerclassid+"' and classname='"+ownerclassname+"'"); 
//			while(myres.next()){
//				
//				fieldclassownerclassid= myres.getString("id"); 
//				System.out.println("FIELD TYPE CLASS ID ::::::::::::::::::::::::::::::::::::::::::"+fieldclassownerclassid);
//	   		   }	
//			
//			if(fieldclassownerclassid==null) {
//				fieldclassownerclassid="null"; 
//			}
//			
//			
//			
//			System.out.println("fieldtypeclassname "+fieldtypeclassname);
//		System.out.println("fieldaccess  "+fieldaccess+"  fieldtypeclassid  "+fieldtypeclassid+"  fieldtypeclassname "+fieldtypeclassname+" ownerclassid "+ownerclassid+
//				" ownerclassname "+ownerclassname+"   fieldclassownerclassid "+fieldclassownerclassid);	
//		ResultSet	 myres2=null; 
//		if(fieldtypeclassid!=null) {
//				 String query= "SELECT * from fieldmethods where fieldaccess='"+fieldaccess+"' and fieldtypeclassid='"+fieldtypeclassid+"' and "
//					+ "fieldtypeclassname='"+fieldtypeclassname+"' and ownerclassid='"+ownerclassid+"' and ownerclassname='"+ownerclassname+"' and "
//							+ "fieldclassownerclassid='"+fieldclassownerclassid+"'"; 
//				 
//				 
//				myres2= st.executeQuery(query); 
//			
//		}
//		
//			
//			
//			
//		if(myres2!=null) {
//			if(!myres2.next()) {
//				if(fieldtypeclassid!=null) {
//					st.executeUpdate("INSERT INTO `fieldmethods`(`fieldaccess`, `fieldtypeclassid`, `fieldtypeclassname`,  `ownerclassname`,  `ownerclassid`,  `ownermethodname`, `ownermethodid`, `fieldclassownerclassid`) VALUES ('"+fieldaccess.toString() +"','" +fieldtypeclassid+"','" +fieldtypeclassname+"','" +ownerclassname+"','" +ownerclassid+"','" +ownermethodname+"','" +ownermethodid+"','" +fieldclassownerclassid+"')");
//
//				}
//			}
//		}
//		
//			
//			
//			
//			
//		}
//		
//		
//		
//List<CtVariableReference> varlist = method.getElements(new TypeFilter<CtVariableReference>(CtVariableReference.class)); 
//		
//		for(CtVariableReference ass: varlist) {
//
//			String fieldtypeclassid=null; 
//			String fieldaccess=null; 
//			
//			String fieldtypeclassname=null; 
//			 fieldaccess= ass.getSimpleName().toString(); 
//			if(ass.getType()!=null) {
//				 fieldtypeclassname= ass.getType().toString(); 
//				 fieldtypeclassname= fieldtypeclassname.replaceAll("(\\[])", ""); 
//
//			}
//			
//			String ownermethodid=null; 
//			String ownerclassid=null; 
//			String fieldclassownerclassid="null"; 
//			
//			 String ownerclassname=RemoveDollar(clazz.getQualifiedName()); 
//			 
//			String ownermethodname= method.getSignature(); 
//			System.out.println("yes");
//			
//			ResultSet fieldids = st.executeQuery("SELECT id from classes where classname='"+fieldtypeclassname+"'"); 
//			while(fieldids.next()){
//				
//				fieldtypeclassid= fieldids.getString("id"); 
//	   		   }
//			
//			
//			ResultSet assinfo = st.executeQuery("SELECT * from methods where methodname='"+ownermethodname+"' and classname='"+ownerclassname+"'"); 
//			while(assinfo.next()){
//				
//				ownermethodid= assinfo.getString("id"); 
//				ownerclassid= assinfo.getString("classid"); 
//				ownerclassname=assinfo.getString("classname");
//				ownermethodname=assinfo.getString("methodname");
//	   		   }
//			
//			
//			ResultSet myres = st.executeQuery("SELECT * from fieldclasses where fieldname='"+fieldaccess+"' and fieldtypeclassid='"+fieldtypeclassid+"' and "
//					+ "fieldtype='"+fieldtypeclassname+"' and ownerclassid='"+ownerclassid+"' and classname='"+ownerclassname+"'"); 
//			while(myres.next()){
//				
//				fieldclassownerclassid= myres.getString("id"); 
//				System.out.println("FIELD TYPE CLASS ID ::::::::::::::::::::::::::::::::::::::::::"+fieldclassownerclassid);
//	   		   }	
//			
//			if(fieldclassownerclassid==null) {
//				fieldclassownerclassid="null"; 
//			}
//			
//			
//			
//			System.out.println("fieldtypeclassname "+fieldtypeclassname);
//		System.out.println("fieldaccess  "+fieldaccess+"  fieldtypeclassid  "+fieldtypeclassid+"  fieldtypeclassname "+fieldtypeclassname+" ownerclassid "+ownerclassid+
//				" ownerclassname "+ownerclassname+"   fieldclassownerclassid "+fieldclassownerclassid);	
//		ResultSet	 myres2=null; 
//		if(fieldtypeclassid!=null) {
//				 String query= "SELECT * from fieldmethods where fieldaccess='"+fieldaccess+"' and fieldtypeclassid='"+fieldtypeclassid+"' and "
//					+ "fieldtypeclassname='"+fieldtypeclassname+"' and ownerclassid='"+ownerclassid+"' and ownerclassname='"+ownerclassname+"' and "
//							+ "fieldclassownerclassid='"+fieldclassownerclassid+"'"; 
//				 
//				 
//				myres2= st.executeQuery(query); 
//			
//		}
//		
//			
//			
//			
//		if(myres2!=null) {
//			if(!myres2.next()) {
//				if(fieldtypeclassid!=null) {
//					st.executeUpdate("INSERT INTO `fieldmethods`(`fieldaccess`, `fieldtypeclassid`, `fieldtypeclassname`,  `ownerclassname`,  `ownerclassid`,  `ownermethodname`, `ownermethodid`, `fieldclassownerclassid`) VALUES ('"+fieldaccess.toString() +"','" +fieldtypeclassid+"','" +fieldtypeclassname+"','" +ownerclassname+"','" +ownerclassid+"','" +ownermethodname+"','" +ownermethodid+"','" +fieldclassownerclassid+"')");
//
//				}
//			}
//		}
//		
//			
//			
//			
//			
//		}
//		
//		
//		
//	}
//	
//	
//	
//	
//	//-----------------------------------------------------------------------------------------------------------------
//	List<CtConstructor> constructorlist = clazz.getElements(new TypeFilter<CtConstructor>(CtConstructor.class)); 
//
//	for(CtConstructor cons: constructorlist) {
//
//		List<CtFieldAccess> list = cons.getElements(new TypeFilter<CtFieldAccess>(CtFieldAccess.class)); 
//		for(CtFieldAccess fieldaccess: list) {
//			
//			String fieldname=null; 
//			String Fieldid=null; 
//			String Methodid=null; 
//			String myclassname=null; 
//			String MethodName=null; 
//			String FieldName=null; 
//			String myclassid=null; 
//			String myclass=null; 
//			String fieldid=null; 
//			String fieldaccessTargetType=null;
//
//			System.out.println("FIELD ACCESS===============================  "+fieldaccess);
//			System.out.println("METHOD===============================  "+clazz.getQualifiedName()+"."+cons.getSignature());
//			
//			boolean flag=false; 
//			String consignature= TransformConstructorIntoInit(cons.getSignature()); 
//			if(clazz.getQualifiedName().contains("$")){
//				String constructorClassName=RemoveDollar(clazz.getQualifiedName()); 
//				System.out.println(constructorClassName);
//			}
//    	
//			String constructorClassName=RemoveDollar(clazz.getQualifiedName()); 
//
//		
//			
//
//
//			ResultSet classesreferenced = st.executeQuery("SELECT methods.* from methods where classname='"+constructorClassName
//			+ "'and methodname='"+consignature+"'"); 
//	while(classesreferenced.next()){
//		 myclass = classesreferenced.getString("classname"); 
//		 myclassid = classesreferenced.getString("classid"); 
//		  Methodid = classesreferenced.getString("id"); 
//		  MethodName = classesreferenced.getString("methodname"); 
////			System.out.println("class referenced: "+myclass);	
//		   }
//	if(fieldaccess.getType()!=null) {
//		fieldaccessTargetType= fieldaccess.getType().toString(); 
//		fieldaccessTargetType= fieldaccessTargetType.replaceAll("(\\[])", ""); 
//	}
//	
//	System.out.println("FIELD ACCESS TYPE  ================================================================  "+ fieldaccessTargetType);
//
//	ResultSet fieldids = st.executeQuery("SELECT id from classes where classname='"+fieldaccessTargetType+"'"); 
//	while(fieldids.next()){
//		
//		fieldid= fieldids.getString("id"); 
//		   }
//	
//
//	
//	////////////////////////////////////////////////////////////////////////////
////	if(fieldid==null) {
////		if(fieldaccess.getTarget()!=null) {
////			 fieldaccessTargetType= fieldaccess.getTarget().getType().toString(); 
////			fieldaccessTargetType= fieldaccessTargetType.replaceAll("(\\[])", ""); 
////		}else if(fieldaccess.getType()!=null){
////			fieldaccessTargetType= fieldaccess.getType().toString(); 
////		}
////
////		 fieldids = st.executeQuery("SELECT id from classes where classname='"+fieldaccessTargetType+"'"); 
////		while(fieldids.next()){
////			
////			fieldid= fieldids.getString("id"); 
////   		   }
////	}
//	
//	//////////////////////////////////////////////////////////////////////////////
//			
//			
//			fieldmethod myfield= new fieldmethod( myclassid, myclass, MethodName, Methodid); 
//		
//			
//			//	if(myfield.contains(FieldMethodsList, myfield)==false  && Methodid!=null && fieldid!=null) {
//					if( Methodid!=null && fieldid!=null) {
//					st.executeUpdate("INSERT INTO `fieldmethods`(`fieldaccess`, `fieldtypeclassid`, `fieldtype`,  `classname`,  `ownerclassid`,  `methodname`, `ownermethodid`) VALUES ('"+fieldaccess.toString() +"','" +fieldaccessTargetType+"','" +fieldaccess.getType()+"','" +myclass+"','" +myclassid+"','" +MethodName+"','" +Methodid+"')");
//					FieldMethodsList.add(myfield); 
//				}
//			
//			
//			
//			//ALTERNATIVE: 
//			//st.executeUpdate("INSERT INTO `fieldmethods`(`fieldaccess`,  `classname`,  `classid`,  `methodname`, `methodid`) VALUES ('"+fieldaccess.toString() +"','" +myclassname+"','" +myclass+"','" +MethodName+"','" +Methodid+"')");
//		}
//	
//		
//	}
//	
//
//}   	
/////////////////*********************************************************************************************************************************************************************************/	
/////////////////*********************************************************************************************************************************************************************************/	
/////////////////*********************************************************************************************************************************************************************************/   	
//////////////////BUILD METHODSCALLED TABLE
//
//
//    	
//    	
//int counter=0; 
//
//
//String calleeDeclaringTypeName=null; 
//
//List<methodcalls> methodcallsList = new ArrayList<methodcalls>(); 
//for(CtType<?> clazz : classFactory.getAll(true)) {
//List<CtConstructor> constructorcallers = clazz.getElements(new TypeFilter<CtConstructor>(CtConstructor.class));
//   for(CtConstructor<?> cons :constructorcallers) {
//	   System.out.println("COOOOOOOOOOOONS PRINTED "+cons);
//    	List<CtInvocation> MethodsInvokedByConstructors = cons.getElements(new TypeFilter<CtInvocation>(CtInvocation.class));
//    	List<CtComment> CommentList = cons.getElements(new TypeFilter<CtComment>(CtComment.class));
//    	List<CtComment> NewCommentList= CommentList; 
//    	NewCommentList = cons.getElements(new TypeFilter<CtComment>(CtComment.class));
//    	int size=NewCommentList.size(); 
//    	System.out.println(cons);
//    	int  j=0; 
//    	if(CommentList!=null) {
//    		CtConstructor newcons=cons; 
//    		
//    		
//    		while(j<size) {
//    			
//    			CtComment newcomment = NewCommentList.get(j); 
//    			newcons=newcons.removeComment(newcomment); 
//    			 size=NewCommentList.size(); 
//    			 j++; 
//    		}
//    		
//    		cons=newcons; 
//    	}
//    	 String consString = cons.toString().replaceAll("\\/\\/.*", ""); 
//    	 consString = consString.toString().replaceAll("\'", ""); 
//    	//METHODS INVOKED BY CONSTRUCTORS 
//    	for(CtInvocation<?> consInvocation: MethodsInvokedByConstructors) {
//    		   System.out.println("COOOOOOOOOOOONS INVOCATION "+consInvocation);
//
//    		String CalleeMethodID=null;  
//    		String CALLEECLASSNAME=null;  
//    		String CALLEECLASSID =null;  
//    		String fullcalleeins=null;   
//    		String CallerMethodIDcons=null; 
//        	String CALLERCLASSNAMEcons=null; 
//        	String CALLERCLASSIDcons=null; 
//        	String fullcallerinscons=null; 
//        	String fullcaller=null; 
//        	String fullcallee=null; 
//        	String InvokedMethodNamePackageFree=null;
//        	String ConstructorNamePackageFree=null; 
//        	
//    		if(cons.getDeclaringType()!=null) {
////	    		String constructorClassName = cons.getExecutable().getDeclaringType().getQualifiedName().toString();
////    		String constructorName=cons.getExecutable().getSignature(); 
//    		String constructorClassName=cons.getType().getQualifiedName();
//    		String constructorName=cons.getSignature(); 
//    		System.out.println("BEFORE constructorClassName====>"+constructorClassName);
//    		System.out.println("BEFORE constructorName====>"+constructorName);
//    		//System.out.println("CONSTRUCTOR NAME BEFORE INIT "+ constructorName);
//    		constructorClassName=RemoveDollarConstructor(constructorClassName); 
//    		constructorName=RemoveDollarConstructor(constructorName); 
//    		//System.out.println("CONS NAMEeeeeeee====>"+constructorName);	
//    		System.out.println("CONSTRUCTOR NAME BEFORE INIT "+ constructorName);
//    		constructorName=TransformConstructorIntoInit(constructorName); 
//    		System.out.println("AFTER constructorClassName====>"+constructorClassName);	    		
//    		System.out.println("AFTER constructorName====>"+constructorName);
//    		System.out.println("\n");
//    		fullcaller=constructorName; 
//    		 ConstructorNamePackageFree=KeepOnlyMethodName(constructorName);
//    		System.out.println("ConstructorNamePackageFree==ooooooooooooooooooooo==>"+ConstructorNamePackageFree);
//    		System.out.println("constructorClassName==oooooooooooooooooooooooooo==>"+constructorClassName);	   
//    		if(constructorClassName.contains("$")) {
//    			String constructorClassNameFirstPart= constructorClassName.substring(0, constructorClassName.lastIndexOf(".")+1); 
//        		String constructorClassNameSecondPart= constructorClassName.substring(constructorClassName.lastIndexOf("$")+1, constructorClassName.length()); 
//        		constructorClassName=constructorClassNameFirstPart+constructorClassNameSecondPart; 
//    		}
//    	
//    		
//    		ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+ConstructorNamePackageFree+"'"
//    				+ "and methods.classname='"+constructorClassName+"'"); 
//    		//while(callingmethodsrefined.next()){
//    		if(callingmethodsrefined.next()) {
//    			CallerMethodIDcons = callingmethodsrefined.getString("id"); 
//    			CALLERCLASSNAMEcons = callingmethodsrefined.getString("classname"); 
//    			CALLERCLASSIDcons = callingmethodsrefined.getString("classid"); 
//    			 fullcallerinscons = callingmethodsrefined.getString("fullmethod"); 
//
//    			//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//    		}
//    		System.out.println("CALLER CLASS NAME =======>>>>"+ CALLERCLASSNAMEcons);
//    		if(consInvocation.toString().contains("super")) {
//    		
//    		
//    		System.out.println("");
//    		String constructormethod = TransformConstructorIntoInit(consInvocation.getExecutable().getSignature()); 
//    		
//    		String calleeclass=consInvocation.getExecutable().getDeclaringType().toString(); 
//    		String calleepackagefree=KeepOnlyMethodName(constructormethod);
//    		
//    		ResultSet res = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+calleepackagefree+"'"
//    				+ "and methods.classname='"+calleeclass+"'"); 
//    		//while(callingmethodsrefined.next()){
//    		if(res.next()) {
//    			String CalleeMethodIDcons = res.getString("id"); 
//    			String		CALLEECLASSNAMEcons = res.getString("classname"); 
//    			String	CALLEECLASSIDcons = res.getString("classid"); 
//    			String	 fullcalleeinscons = res.getString("fullmethod"); 
//    
//    			//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//    			
//    			String callermethodname = KeepOnlyMethodName(cons.getSignature()); 
//	    		CtElement consInvocationelment = (CtElement)consInvocation; 
//	    		while(consInvocationelment instanceof CtMethod==false && consInvocationelment.getParent()!=null) {
//	    			consInvocationelment=consInvocationelment.getParent(); 
//	    		}
//    			methodcalls methodcall = new methodcalls(CalleeMethodIDcons, fullcaller, CALLEECLASSNAMEcons, CALLEECLASSIDcons, CallerMethodIDcons, fullcalleeinscons, CALLERCLASSNAMEcons); 
//    			//System.out.println(methodcall.toString()); 
//    			
//    			
//    			//&& consInvocationelment.toString().contains(callermethodname)
//    			
//    			
//    			if( methodcall.contains(methodcallsList, methodcall)==false && CallerMethodIDcons!=null && CalleeMethodIDcons!=null ) {
//    				String fullcallerinsconsshort = fullcallerinscons.substring(0, fullcallerinscons.indexOf("(")); 
//    				String fullcalleeinsconsshort = fullcalleeinscons.substring(0, fullcalleeinscons.indexOf("(")); 
//    				String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`, `fullcalleeshort`, `fullmethod`) VALUES ('"+CallerMethodIDcons +"','" +ConstructorNamePackageFree+"','" +CALLERCLASSNAMEcons+"','" +CALLERCLASSIDcons+"','" +fullcallerinscons+"','" +fullcallerinsconsshort+"','" +CalleeMethodIDcons+"','" +calleepackagefree+"','" +CALLEECLASSNAMEcons+"','" +CALLEECLASSIDcons+"','" +fullcalleeinscons+"','" +fullcalleeinsconsshort
//    						+"','" +consString+"')";
//    				
//    				st.executeUpdate(statement);
//    				methodcallsList.add(methodcall); 
//    			}
//    		}
//    		
//    	}
//    	
//    if(consInvocation.toString().contains("this")) {
//    	
//    	
//    	System.out.println("");
//    	String constructormethod = TransformConstructorIntoInit(consInvocation.getExecutable().getSignature()); 
//    	constructormethod=RemoveDollar(constructormethod); 
//    	String onlymethodname=KeepOnlyMethodName(constructormethod); 
//    	String classname= constructormethod.substring(0, constructormethod.indexOf(onlymethodname)-1); 
//    	
//    	String calleeclass=consInvocation.getExecutable().getDeclaringType().toString(); 
//    	String calleepackagefree=KeepOnlyMethodName(constructormethod);
//    	
//    	ResultSet res = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+calleepackagefree+"'"
//    			+ "and methods.classname='"+calleeclass+"'"); 
//    	//while(callingmethodsrefined.next()){
//    	if(res.next()) {
//    		String CalleeMethodIDcons = res.getString("id"); 
//    		String		CALLEECLASSNAMEcons = res.getString("classname"); 
//    		String	CALLEECLASSIDcons = res.getString("classid"); 
//    		String	 fullcalleeinscons = res.getString("fullmethod"); 
//    
//    		//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//    		
//    		
//    		methodcalls methodcall = new methodcalls(CalleeMethodIDcons, fullcaller, CALLEECLASSNAMEcons, CALLEECLASSIDcons, CallerMethodIDcons, fullcalleeinscons, CALLERCLASSNAMEcons); 
//    		//System.out.println(methodcall.toString()); 
//    		if( methodcall.contains(methodcallsList, methodcall)==false && CallerMethodIDcons!=null && CalleeMethodIDcons!=null) {
//    			String fullcallerinsconsshort = fullcallerinscons.substring(0, fullcallerinscons.indexOf("(")); 
//				String fullcalleeinsconsshort = fullcalleeinscons.substring(0, fullcalleeinscons.indexOf("(")); 
//    			String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`, `fullcalleeshort`, `fullmethod`) VALUES ('"+CallerMethodIDcons +"','" +ConstructorNamePackageFree+"','" +CALLERCLASSNAMEcons+"','" +CALLERCLASSIDcons+"','" +fullcallerinscons+"','" +fullcallerinsconsshort+"','" +CalleeMethodIDcons+"','" +calleepackagefree+"','" +CALLEECLASSNAMEcons+"','" +CALLEECLASSIDcons+"','" +fullcalleeinscons+"','" +fullcalleeinsconsshort+"','" +consString+"')";
//    			
//    			st.executeUpdate(statement);
//    			methodcallsList.add(methodcall); 
//    		}
//    	}else {
//    		 res = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+calleepackagefree+"'"
//        			+ "and methods.classname='"+classname+"'"); 
//        	//while(callingmethodsrefined.next()){
//        	if(res.next()) {
//        		String CalleeMethodIDcons = res.getString("id"); 
//        		String		CALLEECLASSNAMEcons = res.getString("classname"); 
//        		String	CALLEECLASSIDcons = res.getString("classid"); 
//        		String	 fullcalleeinscons = res.getString("fullmethod"); 
//        
//        		//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//        		
//        		
//        		methodcalls methodcall = new methodcalls(CalleeMethodIDcons, fullcaller, CALLEECLASSNAMEcons, CALLEECLASSIDcons, CallerMethodIDcons, fullcalleeinscons, CALLERCLASSNAMEcons); 
//        		//System.out.println(methodcall.toString()); 
//        		if( methodcall.contains(methodcallsList, methodcall)==false && CallerMethodIDcons!=null && CalleeMethodIDcons!=null) {
//        			String fullcallerinsconsshort = fullcallerinscons.substring(0, fullcallerinscons.indexOf("(")); 
//    				String fullcalleeinsconsshort = fullcalleeinscons.substring(0, fullcalleeinscons.indexOf("(")); 
//        			
//        			String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`, `fullcalleeshort`, `fullmethod`) VALUES ('"+CallerMethodIDcons +"','" +ConstructorNamePackageFree+"','" +CALLERCLASSNAMEcons+"','" +CALLERCLASSIDcons+"','" +fullcallerinscons+"','" +fullcallerinsconsshort+"','" +CalleeMethodIDcons+"','" +calleepackagefree+"','" +CALLEECLASSNAMEcons+"','" +CALLEECLASSIDcons+"','" +fullcalleeinscons+"','" +fullcalleeinsconsshort+"','" +consString+"')";
//        			
//        			st.executeUpdate(statement);
//        			methodcallsList.add(methodcall); 
//        		}
//        	}
//    	}
//    	
//    }
//    	}
//    		
//    		
//    		
//    		//if(consInvocation.toString().contains("super")) {
////    		
////    		
////    		System.out.println("");
////    		String constructormethod = TransformConstructorIntoInit(consInvocation.getExecutable().getSignature()); 
////    		
////    		String calleeclass=consInvocation.getExecutable().getDeclaringType().toString(); 
////    		String calleepackagefree=KeepOnlyMethodName(constructormethod);
////    		
////    		ResultSet res = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+calleepackagefree+"'"
////    				+ "and methods.classname='"+calleeclass+"'"); 
////    		//while(callingmethodsrefined.next()){
////    		if(res.next()) {
////    			String CalleeMethodIDcons = res.getString("id"); 
////    			String		CALLEECLASSNAMEcons = res.getString("classname"); 
////    			String	CALLEECLASSIDcons = res.getString("classid"); 
////    			String	 fullcalleeinscons = res.getString("fullmethod"); 
//    //
////    			//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
////    			
////    			
////    			methodcalls methodcall = new methodcalls(CalleeMethodIDcons, fullcaller, CALLEECLASSNAMEcons, CALLEECLASSIDcons, CallerMethodIDcons, fullcalleeinscons, CALLERCLASSNAMEcons); 
////    			//System.out.println(methodcall.toString()); 
////    			if( methodcall.contains(methodcallsList, methodcall)==false && CallerMethodIDcons!=null && CalleeMethodIDcons!=null) {
////    				String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`, `fullcalleeshort`) VALUES ('"+CallerMethodIDcons +"','" +ConstructorNamePackageFree+"','" +CALLERCLASSNAMEcons+"','" +CALLERCLASSIDcons+"','" +fullcallerinscons+"','" +CalleeMethodIDcons+"','" +calleepackagefree+"','" +CALLEECLASSNAMEcons+"','" +CALLEECLASSIDcons+"','" +fullcalleeinscons+"')";
////    				
////    				st.executeUpdate(statement);
////    				methodcallsList.add(methodcall); 
////    			}
////    		}
////    		
////    	}
//    //	
//    //if(consInvocation.toString().contains("this")) {
//    //	
//    //	
////    	System.out.println("");
////    	String constructormethod = TransformConstructorIntoInit(consInvocation.getExecutable().getSignature()); 
//    //	
////    	String calleeclass=consInvocation.getExecutable().getDeclaringType().toString(); 
////    	String calleepackagefree=KeepOnlyMethodName(constructormethod);
//    //	
////    	ResultSet res = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+calleepackagefree+"'"
////    			+ "and methods.classname='"+calleeclass+"'"); 
////    	//while(callingmethodsrefined.next()){
////    	if(res.next()) {
////    		String CalleeMethodIDcons = res.getString("id"); 
////    		String		CALLEECLASSNAMEcons = res.getString("classname"); 
////    		String	CALLEECLASSIDcons = res.getString("classid"); 
////    		String	 fullcalleeinscons = res.getString("fullmethod"); 
//    //
////    		//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
////    		
////    		
////    		methodcalls methodcall = new methodcalls(CalleeMethodIDcons, fullcaller, CALLEECLASSNAMEcons, CALLEECLASSIDcons, CallerMethodIDcons, fullcalleeinscons, CALLERCLASSNAMEcons); 
////    		//System.out.println(methodcall.toString()); 
////    		if( methodcall.contains(methodcallsList, methodcall)==false && CallerMethodIDcons!=null && CalleeMethodIDcons!=null) {
////    			String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`, `fullcalleeshort`) VALUES ('"+CallerMethodIDcons +"','" +ConstructorNamePackageFree+"','" +CALLERCLASSNAMEcons+"','" +CALLERCLASSIDcons+"','" +fullcallerinscons+"','" +CalleeMethodIDcons+"','" +calleepackagefree+"','" +CALLEECLASSNAMEcons+"','" +CALLEECLASSIDcons+"','" +fullcalleeinscons+"')";
////    			
////    			st.executeUpdate(statement);
////    			methodcallsList.add(methodcall); 
////    		}
////    	}
//    //	
//    //}
////    	}
//    		
//    		if(consInvocation.getExecutable().getDeclaringType()!=null) {
//    			String InvokedClassNameBEFORE = consInvocation.getExecutable().getDeclaringType().getQualifiedName().toString();
//	    		String InvokedMethodNameBEFORE=consInvocation.getExecutable().getSignature(); 
//	    		fullcallee=InvokedMethodNameBEFORE; 
//	    		System.out.println("BEFORE InvokedClassName====>"+InvokedClassNameBEFORE);
//	    		System.out.println("BEFORE InvokedMethodName====>"+InvokedMethodNameBEFORE);
//	    		String InvokedClassName=RemoveDollarConstructor(InvokedClassNameBEFORE); 
//	    		String InvokedMethodName=RemoveDollarConstructor(InvokedMethodNameBEFORE); 
//	    	System.out.println("AFTER InvokedClassName====>"+InvokedClassName);
//	    		System.out.println("AFTER InvokedMethodName====>"+InvokedMethodName);
//	    		String fullmeth= InvokedClassName+"."+InvokedMethodName; 
//	    	//	System.out.println("FULLMETH====>"+fullmeth);
//	    		System.out.println("\n");
//	    		if(consInvocation instanceof CtConstructorCall) {
//	    			InvokedMethodName=TransformConstructorIntoInit(InvokedMethodName); 
//	    			 InvokedMethodNamePackageFree=KeepOnlyMethodName(InvokedMethodName); 
//	    		}
//	    		 InvokedMethodNamePackageFree=KeepOnlyMethodName(InvokedMethodName); 
//	    	//	System.out.println("InvokedMethodNamePackageFree====>"+InvokedMethodNamePackageFree);
//	    		
//	    		
//	    		 fullmeth= InvokedClassName+"."+InvokedMethodName; 
//	    			//	System.out.println("FULLMETH====>"+fullmeth);
//	    						
//	    			//	System.out.println("InvokedClassName==oooooooooooooooooooooooo==>"+InvokedClassName);
//	    			//	System.out.println("InvokedMethodName==ooooooooooooooooooooo==>"+InvokedMethodName);
//	    				 InvokedClassName= RemoveDollar(InvokedClassName); 
//	    				
//	    				 int counterparent=0; 
//	    	    		 int counterparent2=0; 
//	    	    		 String method =""; 
//	    	    		 String type=""; 
//	    	    		 String type2=""; 
//	    	    		 String myclass=""; 
//	    	    		 CtElement consInvocationpar = consInvocation; 
//	    	    		 while(!(consInvocationpar instanceof CtMethod<?>) && counterparent<5) {
//	    	    			 if(consInvocationpar.getParent()!=null ) {
//	    	    				 consInvocationpar = consInvocationpar.getParent(); 
//	    	    				 if(consInvocationpar instanceof CtMethod) {
//	    	    					 CtMethod converted = (CtMethod)consInvocationpar; 
//		    	    				 method =  converted.getSignature(); 
//		    	    				 myclass= converted.getDeclaringType().getQualifiedName().replaceAll("1", "").replaceAll("\\$", ""); 
//		    	    				 
//	    	    				 }
//	    	    				
////	    	    				 List<CtMethod> mymeths = consInvocationpar.getElements(new TypeFilter<CtMethod>(CtMethod.class));
////	    	    				 if(mymeths.isEmpty()==false) {
////	    	    					 method = mymeths.get(0).getSignature(); 
////	    	    					 // type=mymeths.get(0).getDeclaringType().toString(); 
////	    	    					 CtMethod meth = mymeths.get(0); 
////	    	    					  type2=mymeths.get(0).getType().toString(); 
////	    	    					  
////	    	    					  myclass= mymeths.get(0).getTopLevelType().getTypeErasure().toString(); 
////	    	    				 }
//	    	    				  
//	    	    				 
//	    	    				 
//	    	    				 
//	    	    				 counterparent++; 
//	    	    			 }
//	    	    			 
//	    	    		 }
//	    				
//	    				 if(CALLERCLASSNAMEcons!=null) {
//	    				 ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+method+"'"
//	    							+ "and methods.classname='"+myclass+"'"); 
//	    					//while(callingmethodsrefined.next()){
//	    					if(callingmethodsrefined.next()) {
//	    						CallerMethodIDcons = callingmethodsrefined.getString("id"); 
//	    						CALLERCLASSNAMEcons = callingmethodsrefined.getString("classname"); 
//	    						CALLERCLASSIDcons = callingmethodsrefined.getString("classid"); 
//	    						 fullcallerinscons = callingmethodsrefined.getString("fullmethod"); 
//	    						 ConstructorNamePackageFree= callingmethodsrefined.getString("methodname"); 
//	    						//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//	    					}
//	    			 } 
//	    		ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+InvokedMethodNamePackageFree+"'"
//	    				+ "and methods.classname='"+InvokedClassName+"'"); 
//	  
//	    		//while(callingmethodsrefined.next()){
//	    		if(callingmethodsrefined.next()) {
//	    			 CalleeMethodID = callingmethodsrefined.getString("id"); 
//	    			 CALLEECLASSNAME = callingmethodsrefined.getString("classname"); 
//	    			 CALLEECLASSID = callingmethodsrefined.getString("classid"); 
//	    			  fullcalleeins = callingmethodsrefined.getString("fullmethod"); 
//
//	    			//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//	    			 
//	    				
//	    		}
//	    		if(CalleeMethodID==null && CALLEECLASSNAME==null && CALLEECLASSID==null ) {
//	    			ResultSet callingmethodsrefined2 = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+InvokedMethodNameBEFORE+"'"
//    	    				+ "and methods.classname='"+InvokedClassNameBEFORE+"'"); 
//    	  
//    	    		//while(callingmethodsrefined.next()){
//    	    		if(callingmethodsrefined2.next()) {
//    	    			 CalleeMethodID = callingmethodsrefined2.getString("id"); 
//    	    			 CALLEECLASSNAME = callingmethodsrefined2.getString("classname"); 
//    	    			 CALLEECLASSID = callingmethodsrefined2.getString("classid"); 
//    	    			  fullcalleeins = callingmethodsrefined2.getString("fullmethod"); 
//
//    	    			//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//    	    			 
//    	    				
//    	    		}
//	    		}
//	    
//	    		
//	    		if(CalleeMethodID==null && CALLEECLASSNAME==null && CALLEECLASSID==null ) {
//	    			String fullmethod=InvokedClassNameBEFORE+"."+InvokedMethodNameBEFORE; 
//	    			ResultSet callingmethodsrefined2 = st.executeQuery("SELECT methods.* from methods where methods.fullmethod='"+fullmethod+"'"); 
//    	  
//    	    		//while(callingmethodsrefined.next()){
//    	    		if(callingmethodsrefined2.next()) {
//    	    			 CalleeMethodID = callingmethodsrefined2.getString("id"); 
//    	    			 CALLEECLASSNAME = callingmethodsrefined2.getString("classname"); 
//    	    			 CALLEECLASSID = callingmethodsrefined2.getString("classid"); 
//    	    			  fullcalleeins = callingmethodsrefined2.getString("fullmethod"); 
//
//    	    			//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//    	    			 
//    	    				
//    	    		}
//	    		}
//	    		
//	    		
//	    		
//	    		
//    		}
//    	
//    		
//    		
//    		methodcalls methodcall = new methodcalls(CalleeMethodID, fullcaller, CALLEECLASSNAME, CALLEECLASSID, CallerMethodIDcons, fullcallee, CALLERCLASSNAMEcons); 
//    		//System.out.println(methodcall.toString()); 
//    		if( methodcall.contains(methodcallsList, methodcall)==false && CallerMethodIDcons!=null && CalleeMethodID!=null) {
//    			String fullcallerinsconsshort = fullcallerinscons.substring(0, fullcallerinscons.indexOf("(")); 
//				String fullcalleeinsshort = fullcalleeins.substring(0, fullcalleeins.indexOf("(")); 
//    			String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`, `fullcalleeshort`, `fullmethod`) VALUES ('"+CallerMethodIDcons +"','" +ConstructorNamePackageFree+"','" +CALLERCLASSNAMEcons+"','" +CALLERCLASSIDcons+"','" +fullcallerinscons+"','" +fullcallerinsconsshort+"','" +CalleeMethodID+"','" +InvokedMethodNamePackageFree+"','" +CALLEECLASSNAME+"','" +CALLEECLASSID+"','" +fullcalleeins+"','" +fullcalleeinsshort+"','" +consString+"')";
//    			
//    			st.executeUpdate(statement);
//    			methodcallsList.add(methodcall); 
//    		}
//    	
//    		if(consInvocation!=null) {
//    		CtTypeReference<?> TypeCons = consInvocation.getType(); 
//    		if(consInvocation!=null)
//    		System.out.println("TYPEEEE CONS   "+consInvocation);
//    		
//    		System.out.println("TYPEEEE    "+consInvocation.getExecutable().getSignature());
//    		System.out.println("TYPEEEE    "+consInvocation.getExecutable().getDeclaringType());
//    		//System.out.println("TYPEEEE CONSsss   "+cons);
//    		System.out.println("TYPEEEEsss    "+cons.getType());
//    		
//    		
//    	
//    		
//    		
//    		String fullcallee2 =null; 
//    		if(consInvocation.getExecutable().getSignature().contains("$")) {
//    			
//    			String res =RemoveDollar(consInvocation.getExecutable().getSignature()); 
//    			fullcallee2=TransformConstructorIntoInit(res); 
//    			System.out.println(res);
//    		}
//    		String res =RemoveDollar(consInvocation.getExecutable().getSignature()); 
//    		fullcallee2=TransformConstructorIntoInit(res); 
//    		ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.fullmethod='"+fullcallee2+"'"); 
//    		String calleeclassid=""; 
//    		String fullcalleefinal=""; 
//    		String calleemethodid=""; 
//    		String calleename=""; 
//    		String calleeclassname=""; 
//    		//while(callingmethodsrefined.next()){
//    		if(callingmethodsrefined.next()) {
//    			
//    			
//    			calleeclassid = callingmethodsrefined.getString("classid"); 
//    			 calleename = callingmethodsrefined.getString("methodname"); 
//    			 calleemethodid = callingmethodsrefined.getString("id"); 
//    			 calleeclassname = callingmethodsrefined.getString("classname"); 
//    			 fullcalleefinal = callingmethodsrefined.getString("fullmethod"); 
//    			 if(fullcalleefinal!=null)
//    			 fullcalleefinal=RemoveDollar(fullcalleefinal); 
//    
//    			//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//    			 
//    				
//    		}
//    		CtElement res2 = null; 
//    		List<CtComment> comment = consInvocation.getComments(); 
//    		CtInvocation<?> consInvocation2 = consInvocation; 
//    		if(comment!=null) {
//    			int r=0;
//    			while(r<comment.size()) {
//    				 res2 = consInvocation2.removeComment(comment.get(r)); 
//    				 r++; 
//    				}
//    		}
//    		else {
//    			 res2=consInvocation; 
//    		}
//    		if(fullcallerinscons!=null)
//    		fullcallerinscons=RemoveDollar(fullcallerinscons);
//    		//System.out.println(methodcall.toString());
//    		if(res2!=null) {
//    			 methodcall = new methodcalls(CallerMethodIDcons, fullcallerinscons, CALLERCLASSNAMEcons, CALLERCLASSIDcons, calleemethodid, calleename, fullcalleefinal); 
//    		if( res2.toString().contains("this(") && CallerMethodIDcons!=null && CalleeMethodID!=null) {
//    			
//    			String fullcallerinsconsshort = fullcallerinscons.substring(0, fullcallerinscons.indexOf("(")); 
//				String fullcalleefinalshort = fullcalleefinal.substring(0, fullcalleefinal.indexOf("(")); 
//    			String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`, `fullcalleeshort`, `fullmethod`) VALUES ('"+CallerMethodIDcons +"','" +ConstructorNamePackageFree+"','" +CALLERCLASSNAMEcons+"','" +CALLERCLASSIDcons+"','" +fullcallerinscons+"','" +fullcallerinsconsshort+"','" +calleemethodid+"','" +calleename+"','" +cons.getType()+"','" +calleeclassid+"','" +fullcalleefinal+"','" +fullcalleefinalshort+"','" +consString+"')";
//    			methodcallsList.add(methodcall); 
//    			st.executeUpdate(statement);
//    		}
//    	}
//    	}
//    
//    
//    }
//    	
//    	
//	   
//    	
//    	
//    	
//    	
//    ////CONSTRUCTORS INVOKED BY CONSTRUCTORS 
// 	
//    	List<CtConstructorCall> ConstructorsCalledByConstructors = cons.getElements(new TypeFilter<CtConstructorCall>(CtConstructorCall.class));
//    	for(CtConstructorCall<?> consInvocation: ConstructorsCalledByConstructors) {
//    		String CalleeMethodID=null;  
//    		String CALLEECLASSNAME=null;  
//    		String CALLEECLASSID =null;  
//    		String fullcalleeins=null;   
//    		String CallerMethodIDcons=null; 
//        	String CALLERCLASSNAMEcons=null; 
//        	String CALLERCLASSIDcons=null; 
//        	String fullcallerinscons=null; 
//        	String fullcaller=null; 
//        	String fullcallee=null; 
//        	String InvokedMethodNamePackageFree=null;
//        	String ConstructorNamePackageFree=null; 
//        	
//    		if(cons.getDeclaringType()!=null) {
////	    		String constructorClassName = cons.getExecutable().getDeclaringType().getQualifiedName().toString();
////    		String constructorName=cons.getExecutable().getSignature(); 
//    		String constructorClassName=cons.getType().getQualifiedName();
//    		String constructorName=cons.getSignature(); 
//    		System.out.println("BEFORE constructorClassName====>"+constructorClassName);
//    		System.out.println("BEFORE constructorName====>"+constructorName);
//    		//System.out.println("CONSTRUCTOR NAME BEFORE INIT "+ constructorName);
//    		constructorClassName=RemoveDollarConstructor(constructorClassName); 
//    		constructorName=RemoveDollarConstructor(constructorName); 
//    		//System.out.println("CONS NAMEeeeeeee====>"+constructorName);	
//    		System.out.println("CONSTRUCTOR NAME BEFORE INIT "+ constructorName);
//    		constructorName=TransformConstructorIntoInit(constructorName); 
//    		//System.out.println("constructorClassName====>"+constructorClassName);	    		
//    		//System.out.println("constructorName====>"+constructorName);
//    		System.out.println("\n");
//    		fullcaller=constructorName; 
//    		 ConstructorNamePackageFree=KeepOnlyMethodName(constructorName);
//    		System.out.println("ConstructorNamePackageFree==ooooooooooooooooooooo==>"+ConstructorNamePackageFree);
//    		System.out.println("constructorClassName==oooooooooooooooooooooooooo==>"+constructorClassName);	   
//    		
//    		
//    		ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+ConstructorNamePackageFree+"'"
//    				+ "and methods.classname='"+constructorClassName+"'"); 
//    		//while(callingmethodsrefined.next()){
//    		if(callingmethodsrefined.next()) {
//    			CallerMethodIDcons = callingmethodsrefined.getString("id"); 
//    			CALLERCLASSNAMEcons = callingmethodsrefined.getString("classname"); 
//    			CALLERCLASSIDcons = callingmethodsrefined.getString("classid"); 
//    			 fullcallerinscons = callingmethodsrefined.getString("fullmethod"); 
//
//    			//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//    		}
//    		}
//    		
//    		
//    		if(consInvocation.getExecutable().getDeclaringType()!=null) {
//    			String InvokedClassNameBEFORE = consInvocation.getExecutable().getDeclaringType().getQualifiedName().toString();
//	    		String InvokedMethodNameBEFORE=consInvocation.getExecutable().getSignature(); 
//	    		fullcallee=InvokedMethodNameBEFORE; 
//	    		System.out.println("BEFORE InvokedClassName====>"+InvokedClassNameBEFORE);
//	    		System.out.println("BEFORE InvokedMethodName====>"+InvokedMethodNameBEFORE);
//	    		String InvokedClassName=RemoveDollarConstructor(InvokedClassNameBEFORE); 
//	    		String InvokedMethodName=RemoveDollarConstructor(InvokedMethodNameBEFORE); 
//	    	//	System.out.println("InvokedClassName====>"+InvokedClassName);
//	    	//	System.out.println("InvokedMethodName====>"+InvokedMethodName);
//	    		String fullmeth= InvokedClassName+"."+InvokedMethodName; 
//	    	//	System.out.println("FULLMETH====>"+fullmeth);
//	    		System.out.println("\n");
//	    		if(consInvocation instanceof CtConstructorCall) {
//	    			InvokedMethodName=TransformConstructorIntoInit(InvokedMethodName); 
//	    			 InvokedMethodNamePackageFree=KeepOnlyMethodName(InvokedMethodName); 
//	    		}
//	    		 InvokedMethodNamePackageFree=KeepOnlyMethodName(InvokedMethodName); 
//	    	//	System.out.println("InvokedMethodNamePackageFree====>"+InvokedMethodNamePackageFree);
//	    		
//	    		
//	    		 fullmeth= InvokedClassName+"."+InvokedMethodName; 
//	    	//	System.out.println("FULLMETH====>"+fullmeth);
//    					
//	    	//	System.out.println("InvokedClassName==oooooooooooooooooooooooo==>"+InvokedClassName);
//	    	//	System.out.println("InvokedMethodName==ooooooooooooooooooooo==>"+InvokedMethodName);
//	    		ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+InvokedMethodNamePackageFree+"'"
//	    				+ "and methods.classname='"+InvokedClassName+"'"); 
//	  
//	    		//while(callingmethodsrefined.next()){
//	    		if(callingmethodsrefined.next()) {
//	    			 CalleeMethodID = callingmethodsrefined.getString("id"); 
//	    			 CALLEECLASSNAME = callingmethodsrefined.getString("classname"); 
//	    			 CALLEECLASSID = callingmethodsrefined.getString("classid"); 
//	    			  fullcalleeins = callingmethodsrefined.getString("fullmethod"); 
//
//	    			//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//	    			 
//	    				
//	    		}
//	    		if(CalleeMethodID==null && CALLEECLASSNAME==null && CALLEECLASSID==null ) {
//	    			ResultSet callingmethodsrefined2 = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+InvokedMethodNameBEFORE+"'"
//    	    				+ "and methods.classname='"+InvokedClassNameBEFORE+"'"); 
//    	  
//    	    		//while(callingmethodsrefined.next()){
//    	    		if(callingmethodsrefined2.next()) {
//    	    			 CalleeMethodID = callingmethodsrefined2.getString("id"); 
//    	    			 CALLEECLASSNAME = callingmethodsrefined2.getString("classname"); 
//    	    			 CALLEECLASSID = callingmethodsrefined2.getString("classid"); 
//    	    			  fullcalleeins = callingmethodsrefined2.getString("fullmethod"); 
//
//    	    			//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//    	    			 
//    	    				
//    	    		}
//	    		}
//	    		String callermethodname = KeepOnlyMethodName(cons.getSignature()); 
//	    		CtElement consInvocationelment = (CtElement)consInvocation; 
//	    		while(consInvocationelment instanceof CtConstructorCall==false && consInvocationelment.getParent()!=null) {
//	    			consInvocationelment=consInvocationelment.getParent(); 
//	    		}
//	    		
//	    		methodcalls methodcall = new methodcalls(CalleeMethodID, fullcaller, CALLEECLASSNAME, CALLEECLASSID, CallerMethodIDcons, fullcallee, CALLERCLASSNAMEcons); 
//	    		//System.out.println(methodcall.toString()); 
//	    		//&& consInvocationelment.toString().contains(callermethodname)
//	    		if( methodcall.contains(methodcallsList, methodcall)==false && CallerMethodIDcons!=null && CalleeMethodID!=null ) {
//	    			
//	    			String fullcallerinsconsshort = fullcallerinscons.substring(0, fullcallerinscons.indexOf("(")); 
//					String fullcalleeinsshort = fullcalleeins.substring(0, fullcalleeins.indexOf("(")); 
//					
//					
//	    			String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`, `fullcalleeshort`, `fullmethod`) VALUES ('"+CallerMethodIDcons +"','" +ConstructorNamePackageFree+"','" +CALLERCLASSNAMEcons+"','" +CALLERCLASSIDcons+"','" +fullcallerinscons+"','" +fullcallerinsconsshort+"','" +CalleeMethodID+"','" +InvokedMethodNamePackageFree+"','" +CALLEECLASSNAME+"','" +CALLEECLASSID+"','" +fullcalleeins+"','" +fullcalleeinsshort
//	    					+"','" +consString+"')";
//	    			
//	    			st.executeUpdate(statement);
//	    			methodcallsList.add(methodcall); 
//	    		}
//	    		
//    		}
//    	
//    		 int counterparent=0; 
//    		 int counterparent2=0; 
//    		 String method =""; 
//    		 String type=""; 
//    		 String type2=""; 
//    		 String myclass=""; 
//    		 CtElement consInvocationpar = consInvocation; 
//    		 while(!(consInvocationpar instanceof CtMethod<?>) && counterparent<5) {
//    			 if(consInvocationpar.getParent()!=null ) {
//    				 consInvocationpar = consInvocationpar.getParent(); 
//    				 List<CtMethod> mymeths = consInvocationpar.getElements(new TypeFilter<CtMethod>(CtMethod.class));
//    				 if(mymeths.isEmpty()==false) {
//    					 method = mymeths.get(0).getSignature(); 
//    					 // type=mymeths.get(0).getDeclaringType().toString(); 
//    					 CtMethod meth = mymeths.get(0); 
//    					  type2=mymeths.get(0).getType().toString(); 
//    					  
//    					  myclass= mymeths.get(0).getTopLevelType().getTypeErasure().toString(); 
//    				 }
//    				  
//    				 
//    				 
//    				 
//    				 counterparent++; 
//    			 }
//    			 
//    		 }
//    		 
//    		
//    			 
//    		 
//    		 
//    		 
//    		 ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+method+"'"
//    					+ "and methods.classname='"+myclass+"'"); 
//    			//while(callingmethodsrefined.next()){
//    			if(callingmethodsrefined.next()) {
//    				CallerMethodIDcons = callingmethodsrefined.getString("id"); 
//    				CALLERCLASSNAMEcons = callingmethodsrefined.getString("classname"); 
//    				CALLERCLASSIDcons = callingmethodsrefined.getString("classid"); 
//    				 fullcallerinscons = callingmethodsrefined.getString("fullmethod"); 
//    				 ConstructorNamePackageFree= callingmethodsrefined.getString("methodname"); 
//    				//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//    			}
//    		
//    		methodcalls methodcall = new methodcalls(CalleeMethodID, fullcaller, CALLEECLASSNAME, CALLEECLASSID, CallerMethodIDcons, fullcallee, CALLERCLASSNAMEcons); 
//    		//System.out.println(methodcall.toString()); 
//    		if( methodcall.contains(methodcallsList, methodcall)==false && CallerMethodIDcons!=null && CalleeMethodID!=null) {
//    			
//    			String fullcallerinsconsshort = fullcallerinscons.substring(0, fullcallerinscons.indexOf("(")); 
//				String fullcalleeinsshort = fullcalleeins.substring(0, fullcalleeins.indexOf("(")); 
//				
//				
//    			String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`, `fullcalleeshort`, `fullmethod`) VALUES ('"+CallerMethodIDcons +"','" +ConstructorNamePackageFree+"','" +CALLERCLASSNAMEcons+"','" +CALLERCLASSIDcons+"','" +fullcallerinscons+"','" +fullcallerinsconsshort+"','" +CalleeMethodID+"','" +InvokedMethodNamePackageFree+"','" +CALLEECLASSNAME+"','" +CALLEECLASSID+"','" +fullcalleeins+"','" +fullcalleeinsshort+"','" +consString+"')";
//    			
//    			st.executeUpdate(statement);
//    			methodcallsList.add(methodcall); 
//    		}
//    	}
//	   
//	   
//	   
//   }
//   
//   
//   
//for(CtMethod<?> method :clazz.getMethods()) {
//List<CtConstructorCall> ctNewClasses = method.getElements(new TypeFilter<CtConstructorCall>(CtConstructorCall.class));
////CONSTRUCTORS INVOKED BY METHODS 
//for( CtConstructorCall myclass: ctNewClasses) {
//	//CONSTRUCTOR 
//	List<CtComment> CommentList = method.getElements(new TypeFilter<CtComment>(CtComment.class));
//	List<CtComment> NewCommentList= CommentList; 
//	NewCommentList = method.getElements(new TypeFilter<CtComment>(CtComment.class));
//	int size=NewCommentList.size(); 
//	System.out.println(method);
//	int  j=0; 
//	if(CommentList!=null) {
//		CtMethod newmethod=method; 
//		
//		
//		while(j<size) {
//			
//			CtComment newcomment = NewCommentList.get(j); 
//			 newmethod=newmethod.removeComment(newcomment); 
//			 size=NewCommentList.size(); 
//			 j++; 
//		}
//		
//		method=newmethod; 
//	}
//	String methodString = method.toString().replaceAll("\\/\\/.*", ""); 
//	System.out.println(methodString);
//	String CallerMethodIDcons=null; 
//	String CALLERCLASSNAMEcons=null; 
//	String CALLERCLASSIDcons=null; 
//	
//	String CalleeMethodIDcons=null; 
//	String CALLEECLASSNAMEcons=null; 
//	String CALLEECLASSIDcons=null; 
//	String fullcallerinscons=null; 
//	String fullcalleeinscons=null; 
//	String constructorClassName=null; 
//	String callerclass=myclass.getExecutable().getDeclaringType().getQualifiedName(); 
//
//		constructorClassName= myclass.getExecutable().getDeclaringType().getQualifiedName(); 
//	
//		constructorClassName = RemoveDollarConstructor(constructorClassName);
//		
//	System.out.println("MYCLASS"+ clazz.getQualifiedName() +"."+method.getSignature()+"  METHOD"+ myclass.getExecutable().getSignature()+
//			"CLASSS    "+
//			myclass.getExecutable().getDeclaringType().getQualifiedName());
//	String classtype= myclass.getType().toString(); 
//	String FullCallerMeth=clazz.getQualifiedName()+"."+method.getSignature(); 
//	
//	String constructorName=myclass.getExecutable().getSignature(); 
//	System.out.println("CONSTRUCTOR AS CALLEE NAME "+ constructorName);
//	//String constructorClassName= myclass.getExecutable().getDeclaringType().getQualifiedName(); 
//	constructorName="-init-"+constructorName.substring(constructorName.indexOf("("), constructorName.length()); 
//	//System.out.println("CONSTRUCTOR NAME "+ constructorName);
//	System.out.println("CONSTRUCTOR AS CALLEE CLASS NAME"+ constructorClassName);
//	
//
//	
//	//System.out.println("CONSTRUCTOR CLASS NAME"+ constructorClassName);
//	constructorClassName=RemoveDollar(constructorClassName); 
//	
////	ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+constructorName+"'"
////			+ "and methods.classname='"+constructorClassName+"'"); 
//	
//	ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+constructorName+"'"
//			+ "and methods.classname='"+constructorClassName+"'"); 
//	//while(callingmethodsrefined.next()){
//	if(callingmethodsrefined.next()) {
//		CalleeMethodIDcons = callingmethodsrefined.getString("id"); 
//		CALLEECLASSNAMEcons = callingmethodsrefined.getString("classname"); 
//		CALLEECLASSIDcons = callingmethodsrefined.getString("classid"); 
//		 fullcalleeinscons = callingmethodsrefined.getString("fullmethod"); 
//
//		//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//	}
//	
//	
//	
//callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.fullmethod='"+FullCallerMeth+"'"); 
//	//while(callingmethodsrefined.next()){
//	if(callingmethodsrefined.next()) {
//		CallerMethodIDcons = callingmethodsrefined.getString("id"); 
//		CALLERCLASSNAMEcons = callingmethodsrefined.getString("classname"); 
//		CALLERCLASSIDcons = callingmethodsrefined.getString("classid"); 
//		 fullcallerinscons = callingmethodsrefined.getString("fullmethod"); 
//
//		//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//	}
//	
//	
//	//System.out.println("FULL CALLER INS CONS"+fullcallerinscons);
//	//System.out.println("FULL CALLEE INS CONS"+fullcalleeinscons);
//	methodcalls methodcall = new methodcalls(CalleeMethodIDcons, fullcalleeinscons, CALLEECLASSNAMEcons, CALLEECLASSIDcons, CallerMethodIDcons, fullcallerinscons, CALLERCLASSNAMEcons); 
//	//System.out.println(methodcall.toString()); 
//	if( methodcall.contains(methodcallsList, methodcall)==false && CallerMethodIDcons!=null && CalleeMethodIDcons!=null) {
//		
//		String fullcallerinsconsshort = fullcallerinscons.substring(0, fullcallerinscons.indexOf("(")); 
//		String fullcalleeinsconsshort = fullcalleeinscons.substring(0, fullcalleeinscons.indexOf("(")); 
//		
//		
//		 methodString = method.toString().replaceAll("\\/\\/.*", ""); 
//		 methodString = methodString.toString().replaceAll("\'", ""); 
//		 
//		System.out.println(methodString);
//		String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`, `fullcalleeshort`, `fullmethod`) VALUES ('"+CallerMethodIDcons +"','" +method.getSignature()+"','" +CALLERCLASSNAMEcons+"','" +CALLERCLASSIDcons+"','" +fullcallerinscons+"','" +fullcallerinsconsshort+"','" +CalleeMethodIDcons+"','" +constructorName+"','" +CALLEECLASSNAMEcons+"','" +CALLEECLASSIDcons+"','" +fullcalleeinscons+"','" +fullcalleeinsconsshort+"','" +methodString+"')";
//		System.out.println(method);
//		
//		st.executeUpdate(statement);
//		methodcallsList.add(methodcall); 
//	}
//	
//	
////		List args = (myclass.getExecutable().getArguments()); 
//	
////	System.out.println("hEYYYYYY"+args.toString());
//	
//	
//	List list = myclass.getArguments();
//	
//	//System.out.println("LIST "+ list);
//	
//	for(Object elem: list) {
//		
//		if(elem instanceof CtInvocation) {
//			
//			 CtExecutableReference elemexec = ((CtInvocation) elem).getExecutable(); 
////			System.out.println("ELEM"+elem);
////			System.out.println("EXEC"+elemexec);
//			if(elemexec.getDeclaringType()!=null) {
//				String targetType=elemexec.getDeclaringType().getQualifiedName(); 	
//			}
//			
//			
//			
//			
//			
//			  CtExpression targ = ((CtInvocation) elem).getTarget(); 
//				if(targ instanceof CtInvocation) {
//					CtExecutableReference targex = ((CtInvocation) targ).getExecutable(); 
////					System.out.println("TARG"+targex);
//					if(targex.getDeclaringType()!=null) {
//						String executableType=targex.getDeclaringType().getQualifiedName(); 
//
//					}
//					
//					
//					CtExpression targetoftarget = ((CtTargetedExpression) targ).getTarget(); 
//					while(!targetoftarget.toString().equals("") && targetoftarget instanceof CtInvocation==true ) {
//						
//						
////						System.out.println("TARGET OF TARGET: "+targetoftarget);
//						if(targetoftarget instanceof CtInvocation<?> ) {
//							targetoftarget=((CtInvocation<?>) targetoftarget).getTarget(); 
//
//						}
//						else if(targetoftarget instanceof CtConstructorCall<?>) {
//							targetoftarget=((CtConstructorCall<?>) targetoftarget).getTarget(); 
//						}
//						else if(targetoftarget instanceof CtFieldAccess<?>) {
//							targetoftarget=((CtFieldAccess<?>) targetoftarget).getTarget(); 
//						}else if(targetoftarget instanceof CtField<?>) {
//							targetoftarget=((CtFieldAccess<?>) targetoftarget).getTarget(); 
//						}
//						
//						String targetoftargetType=targex.getDeclaringType().getQualifiedName(); 
//						
//					}
//				}
////			if(elemtarg==null) {
////				System.out.println("ELEM"+elem);
////			}
////			while(elemtarg!=null) {
////				
////				elemtarg = ((CtInvocation<?>) elemtarg).getTarget(); 
////				System.out.println("ELEM TARG: "+elemtarg);
////			}
//			
//		}else if(elem instanceof CtFieldAccess) {
//			//System.out.println("ELEMFILEDACCESS"+elem);
//		}
//	}
//	
//}
//
////METHODS INVOKED BY METHODS 
//String methname=method.getSimpleName(); 
//System.out.println("CALLER METHOD pgn parser=====>"+methname);
//// List<CtInvocation> methodcalls = Query.getElements(method, new TypeFilter<>(CtInvocation.class)); 
// List<CtInvocation> methodcalls = method.getElements(new TypeFilter<>(CtInvocation.class)); 
//for( CtInvocation invocation: methodcalls) {
//	String callingmethodid=null; 
//	String callingmethodsrefinedid=null; 
//	String callingmethodsrefinedname=null; 
//	String callingmethodclass=null; 
//	String calledmethodid=null; 
//	String calledmethodname=null; 
//	String calledmethodclass=null; 
//	String paramclassid=null; 
//	String CALLEEID=null; 
//	String CALLEECLASSNAME=null; 
//	String CALLEECLASSID=null; 
//	String CALLERCLASSID=null; 
//	String CallerMethodID=null; 
//	
//	
//	//CALLING METHOD ID 
//	String CALLEENAME= invocation.getExecutable().getSignature().toString(); 
//	CtExecutableReference<?> executableRef = invocation.getExecutable();
//	CtTypeReference<?> typeRef = executableRef.getDeclaringType();
//	
//
//	
//	
//	String CALLERCLASSNAME=clazz.getQualifiedName() ; 
//	String CallerMethod= method.getSignature(); 
//	//System.out.println("CALLER METHOD NAME: "+ CallerMethod);
//	//System.out.println("CALLER CLASS  NAME : "+ CALLERCLASSNAME);
//	CALLERCLASSNAME=RemoveDollar(CALLERCLASSNAME); 
//	ResultSet callingmethodsrefined3 = st.executeQuery("SELECT methods.id from methods where methods.methodname='"+CallerMethod+"'and methods.classname='"+CALLERCLASSNAME+"'"); 
//	//while(callingmethodsrefined.next()){
//	if(callingmethodsrefined3.next()) {
//		CallerMethodID = callingmethodsrefined3.getString("id"); 
//	//	System.out.println("CALLER METHOD ID: "+ CallerMethodID);
//	}
//	String fullcallerins=null; 
//	CALLERCLASSNAME=RemoveDollar(CALLERCLASSNAME); 
//	ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+CallerMethod+"'and methods.classname='"+CALLERCLASSNAME+"'"); 
//	//while(callingmethodsrefined.next()){
//	if(callingmethodsrefined.next()) {
//		CallerMethodID = callingmethodsrefined.getString("id"); 
//		CALLERCLASSNAME = callingmethodsrefined.getString("classname"); 
//		CALLERCLASSID = callingmethodsrefined.getString("classid"); 
//		 fullcallerins = callingmethodsrefined.getString("fullmethod"); 
//
//		//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//	}
//	
//	
//	
//	
//	boolean entered=false;
////	System.out.println("CALLEE METHOD NAME: "+ CALLEENAME);
//	if(typeRef!=null) {
//		String methodCalleeClassName=typeRef.getQualifiedName();
//	//	System.out.println("METHOD CALLEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE: "+methodCalleeClassName);
//		//ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.id from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+CalledMethodExecutable+"' and classes.classname='"+  ClassQualifiedName +"'"); 
//		
//		methodCalleeClassName=RemoveDollar(methodCalleeClassName); 
//		ResultSet callingmethodsrefined2 = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+CALLEENAME+"'and methods.classname='"+methodCalleeClassName+"'"); 
//		//while(callingmethodsrefined.next()){
//		if(callingmethodsrefined2.next()) {
//			CALLEECLASSNAME = callingmethodsrefined2.getString("classname"); 
//			CALLEECLASSID = callingmethodsrefined2.getString("classid"); 
//			CALLEEID = callingmethodsrefined2.getString("id"); 
//			
//    		String fullcalleeins=null; 
//			 fullcalleeins = callingmethodsrefined2.getString("fullmethod"); 
////			System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//			//System.out.println("CALLEE CLASS NAME: "+ CALLEECLASSNAME);
//			
//			CALLEENAME= invocation.getExecutable().getSignature().toString(); 
//			String fullcaller= CALLERCLASSNAME+"."+CallerMethod; 
//			String fullcallee= CALLEECLASSNAME+"."+CALLEENAME; 
//			methodcalls methodcall= new methodcalls(CALLEEID, fullcalleeins, CALLEECLASSNAME, CALLEECLASSID, CallerMethodID, fullcallerins, CALLERCLASSNAME); 
//			//
//			//System.out.println("======>"+methodcall.toString()); 
//	//		System.out.println("FULL CALLER"+fullcallerins);
//	//		System.out.println("FULL CALLEE"+fullcalleeins);
//			 String methodString = method.toString().replaceAll("\\/\\/.*", ""); 
//			 methodString = methodString.toString().replaceAll("\'", ""); 
//			if( methodcall.contains(methodcallsList, methodcall)==false && CallerMethodID!=null && CALLEEID!=null) {
//				String fullcallerinsshort = fullcallerins.substring(0, fullcallerins.indexOf("(")); 
//				String fullcalleeinsshort = fullcalleeins.substring(0, fullcalleeins.indexOf("(")); 
//				String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`, `fullcalleeshort`, `fullmethod`) VALUES ('"+CallerMethodID +"','" +CallerMethod+"','" +CALLERCLASSNAME+"','" +CALLERCLASSID+"','" +fullcallerins+"','" +fullcallerinsshort+"','" +CALLEEID+"','" +CALLEENAME+"','" +CALLEECLASSNAME+"','" +CALLEECLASSID+"','" +fullcalleeins+"','" +fullcalleeinsshort+"','" +methodString+"')";
//				
//				st.executeUpdate(statement);
//				methodcallsList.add(methodcall); 
//				entered=true; 
//			}
//		}
//	}
//	
//	if(entered==false && invocation.getTarget()!=null && invocation.getTarget().getType()!=null && invocation.getExecutable()!=null) {
//		
//	 String type=invocation.getTarget().getType().toString(); 
//	 System.out.println("TYYYYPEEEEEE ==================="+type);
//	ResultSet callingmethodsrefined2 = st5.executeQuery("SELECT methods.* from methods where methods.methodname='"+CALLEENAME+"'and methods.classname='"+type+"'"); 
//	//while(callingmethodsrefined.next()){
//	if(callingmethodsrefined2.next()) {
//		CALLEECLASSNAME = callingmethodsrefined2.getString("classname"); 
//		CALLEECLASSID = callingmethodsrefined2.getString("classid"); 
//		CALLEEID = callingmethodsrefined2.getString("id"); 
//		
//		String fullcalleeins=null; 
//		 fullcalleeins = callingmethodsrefined2.getString("fullmethod"); 
////		System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//		//System.out.println("CALLEE CLASS NAME: "+ CALLEECLASSNAME);
//		
//		CALLEENAME= invocation.getExecutable().getSignature().toString(); 
//		String fullcaller= CALLERCLASSNAME+"."+CallerMethod; 
//		String fullcallee= CALLEECLASSNAME+"."+CALLEENAME; 
//		methodcalls methodcall= new methodcalls(CALLEEID, fullcalleeins, CALLEECLASSNAME, CALLEECLASSID, CallerMethodID, fullcallerins, CALLERCLASSNAME); 
//		//
//		//System.out.println("======>"+methodcall.toString()); 
////			System.out.println("FULL CALLER"+fullcallerins);
////			System.out.println("FULL CALLEE"+fullcalleeins);
//		if( methodcall.contains(methodcallsList, methodcall)==false && CallerMethodID!=null && CALLEEID!=null) {
//			String fullcallerinsshort = fullcallerins.substring(0, fullcallerins.indexOf("(")); 
//			String fullcalleeinsshort = fullcalleeins.substring(0, fullcalleeins.indexOf("(")); 
//			 String methodString = method.toString().replaceAll("\\/\\/.*", ""); 
//			 methodString = methodString.toString().replaceAll("\'", ""); 
//
//			String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`, `fullcalleeshort`, `fullmethod`) VALUES ('"+CallerMethodID +"','" +CallerMethod+"','" +CALLERCLASSNAME+"','" +CALLERCLASSID+"','" +fullcallerins+"','" +fullcallerinsshort+"','" +CALLEEID+"','" +CALLEENAME+"','" +CALLEECLASSNAME+"','" +CALLEECLASSID+"','" +fullcalleeins+"','" +fullcalleeinsshort+"','" +methodString+"')";
//			
//			st.executeUpdate(statement);
//			methodcallsList.add(methodcall); 
//		}
//	}
//}
//	
//	else {
//		if(invocation.getTarget()!=null && invocation.getTarget().getType()!=null) {
//			String type=invocation.getTarget().getType().toString(); 
//		
//		
//		ResultSet res = st4.executeQuery("SELECT interfaces.* from interfaces where interfaces.interfacename='"+type+"'"); 
//		
//		while(res.next()) {
//			CALLEECLASSNAME = res.getString("classname"); 
//			CALLEECLASSID = res.getString("ownerclassid"); 
//		
//
//		 callingmethodsrefined3 = st5.executeQuery("SELECT methods.* from methods where methods.methodname='"+CALLEENAME+"'and methods.classname='"+CALLEECLASSNAME+"'"); 
//			//while(callingmethodsrefined.next()){
//			if(callingmethodsrefined3.next()) {
//				CALLEECLASSNAME = callingmethodsrefined3.getString("classname"); 
//				CALLEECLASSID = callingmethodsrefined3.getString("classid"); 
//				CALLEEID = callingmethodsrefined3.getString("id"); 
//				
//				String fullcalleeins=null; 
//				 fullcalleeins = callingmethodsrefined3.getString("fullmethod"); 
////				System.out.println("CALLEE METHOD ID: "+ CALLEEID);
//				//System.out.println("CALLEE CLASS NAME: "+ CALLEECLASSNAME);
//				
//				CALLEENAME= invocation.getExecutable().getSignature().toString(); 
//				String fullcaller= CALLERCLASSNAME+"."+CallerMethod; 
//				String fullcallee= CALLEECLASSNAME+"."+CALLEENAME; 
//				methodcalls methodcall= new methodcalls(CALLEEID, fullcalleeins, CALLEECLASSNAME, CALLEECLASSID, CallerMethodID, fullcallerins, CALLERCLASSNAME); 
//				//
//				//System.out.println("======>"+methodcall.toString()); 
////					System.out.println("FULL CALLER"+fullcallerins);
////					System.out.println("FULL CALLEE"+fullcalleeins);
//				
//				ResultSet res2 = st5.executeQuery("SELECT methodcalls.* from methodcalls where methodcalls.callername='"+CallerMethod+"' and methodcalls.callerclass='"+CALLERCLASSNAME+"' and methodcalls.calleename='"+CALLEENAME+"' and methodcalls.calleeclass='"+type+"'"); 
//				
//			
//				
//				if( res2==null && methodcall.contains(methodcallsList, methodcall)==false && CallerMethodID!=null && CALLEEID!=null) {
//					String fullcallerinsshort = fullcallerins.substring(0, fullcallerins.indexOf("(")); 
//					String fullcalleeinsshort = fullcalleeins.substring(0, fullcalleeins.indexOf("(")); 
//					 String methodString = method.toString().replaceAll("\\/\\/.*", ""); 
//					 methodString = methodString.toString().replaceAll("\'", ""); 
//
//					String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`, `fullcalleeshort`, `fullmethod`) VALUES ('"+CallerMethodID +"','" +CallerMethod+"','" +CALLERCLASSNAME+"','" +CALLERCLASSID+"','" +fullcallerins+"','" +fullcallerinsshort+"','" +CALLEEID+"','" +CALLEENAME+"','" +CALLEECLASSNAME+"','" +CALLEECLASSID+"','" +fullcalleeins+"','" +fullcalleeinsshort+"','" +methodString+"')";
//					
//					st.executeUpdate(statement);
//					methodcallsList.add(methodcall); 
//				}
//			}
//	}
//	}
//	
//	
//
//	
//	
//	
//	
//	
//	
//	
//	
//	CtExpression<?> invocationTarget = invocation.getTarget(); 
//	
//	boolean  fieldaccesssflag=false; 
//	while(invocationTarget!=null ) {
//	//	String CALLEENAMETARGET= invocationTarget.toString(); 
//	//	System.out.println("TARGET: "+ CALLEENAMETARGET);
//		String NameCallee=null; 
//		if(invocationTarget instanceof CtInvocation<?>) {
//			//System.out.println("Invocation");
//			
//			List args = ((CtInvocation) invocationTarget).getArguments(); 
//			
//		//	System.out.println("hEYYYYYY"+args.toString());
//			for(Object elem: args) {
//			//	System.out.println("hEYYYYYY"+elem.toString());
//			}
//			
//			
//			
//			String calleeName = ((CtInvocation) invocationTarget).getExecutable().getSignature();
//		//	System.out.println("CALLEE NAME"+calleeName);
//		//	System.out.println(((CtInvocation) invocationTarget).getExecutable());
//			if((((CtInvocation) invocationTarget).getExecutable().getDeclaringType())!=null) {
//				 calleeDeclaringTypeName = ((CtInvocation) invocationTarget).getExecutable().getDeclaringType().getQualifiedName(); 
//		//		System.out.println("CALLEE type"+calleeDeclaringTypeName);
//			}
//			
//			List<CtParameter<?>> myparams = ((CtInvocation) invocationTarget).getExecutable().getParameters(); 
//			calleeDeclaringTypeName=RemoveDollar(calleeDeclaringTypeName); 
//			ResultSet callingmethodsrefined2 = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+calleeName+"'and methods.classname='"+calleeDeclaringTypeName+"'"); 
//			//while(callingmethodsrefined.next()){
//			 CALLEENAME= invocation.getExecutable().getSignature().toString(); 
//				
//				
//			if(callingmethodsrefined2.next()) {
//				NameCallee = callingmethodsrefined2.getString("methodname"); 
//				CALLEECLASSNAME = callingmethodsrefined2.getString("classname"); 
//				CALLEECLASSID = callingmethodsrefined2.getString("classid"); 
//				CALLEEID = callingmethodsrefined2.getString("id"); 
//				String fullcalleeins = callingmethodsrefined2.getString("fullmethod"); 
//				String fullcallee= CALLEECLASSNAME+"."+calleeName; 
//				String fullcaller= CALLERCLASSNAME+"."+CallerMethod; 
//			
//				System.out.println("CALLEE  NAME:  "+ NameCallee);
//				System.out.println("CALLEE CLASS NAME:  "+ CALLEECLASSNAME);
//				System.out.println("CALLEECLASSID:  "+ CALLEECLASSID);
//				System.out.println("CALLEEID:  "+ CALLEEID);
//				System.out.println("fullcalleeins:  "+ fullcalleeins);
//				System.out.println("fullcallee:  "+ fullcallee);
//				System.out.println("fullcaller:  "+ fullcaller);
//				System.out.println("\n");
//				methodcalls methodcall = new methodcalls(CALLEEID, fullcalleeins, CALLEECLASSNAME, CALLEECLASSID, CallerMethodID, fullcallerins, CALLERCLASSNAME); 
//				//System.out.println(methodcall.toString()); 
//				if( methodcall.contains(methodcallsList, methodcall)==false && CallerMethodID!=null && CALLEEID!=null) {
//					String fullcallerinsshort = fullcallerins.substring(0, fullcallerins.indexOf("(")); 
//					String fullcalleeinsshort = fullcalleeins.substring(0, fullcalleeins.indexOf("(")); 
//					 String methodString = method.toString().replaceAll("\\/\\/.*", ""); 
//					 methodString = methodString.toString().replaceAll("\'", ""); 
//
//					String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`, `fullcalleeshort`, `fullmethod`) VALUES ('"+CallerMethodID +"','" +CallerMethod+"','" +CALLERCLASSNAME+"','" +CALLERCLASSID+"','" +fullcallerins+"','" +fullcallerinsshort+"','" +CALLEEID+"','" +NameCallee+"','" +CALLEECLASSNAME+"','" +CALLEECLASSID+"','" +fullcalleeins+"','" +fullcalleeinsshort+"','" +methodString+"')";
//					
//					st.executeUpdate(statement);
//					methodcallsList.add(methodcall); 
//				}
//				
//		}
//		
//			invocationTarget=((CtInvocation<?>) invocationTarget).getTarget(); 
//	}	
//		else if(invocationTarget instanceof CtFieldAccess<?>) {
//		fieldaccesssflag=true; 
//		//System.out.println("Field Access");
//		invocationTarget=((CtFieldAccess<?>) invocationTarget).getTarget(); 
//	}else  {
//		
//		invocationTarget=null; 
//	}
//
//	}
//	
//	
//	
//
//	
//	
//	//ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.id from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+CalledMethodExecutable+"' and classes.classname='"+  ClassQualifiedName +"'"); 
//	
//		
//
//
//	
//	
////	ResultSet callingclasses= st.executeQuery("SELECT classes.id from classes where classes.classname='"+CALLEECLASSNAME+"' "); 
////	//while(callingmethodsrefined.next()){
////	if(callingclasses.next()) {
////		CALLEECLASSID = callingclasses.getString("id"); 
////		System.out.println("CALLEE CLASS ID: "+ CALLEECLASSID);
////	}
//	
//	
//
//	
////	if(CALLERCLASSID==null) {
////		ResultSet callerclasses= st.executeQuery("SELECT classes.id from classes where classes.classname='"+CALLERCLASSNAME+"' "); 
////		//while(callingmethodsrefined.next()){
////		if(callerclasses.next()) {
////			CALLERCLASSID = callerclasses.getString("id"); 
////			System.out.println("CALLEE CLASS ID: "+ CALLERCLASSID);
////		}
////	}
//
//	
//		//   }
//	 
//	//CALLING METHOD NAME 
//	//ResultSet callingmethodsrefinednames = st.executeQuery("SELECT methods.methodname from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+CalledMethodExecutable+"' and classes.classname='"+  ClassQualifiedName +"'"); 
///*	ResultSet callingmethodsrefinednames = st.executeQuery("SELECT methods.id from methods where methods.methodname='"+CalledMethodExecutable+"'"); 
//	while(callingmethodsrefinednames.next()){
//		callingmethodsrefinedname = callingmethodsrefinednames.getString("methodname"); 
//		   }*/
//	
//	
//	//CALLING METHOD CLASS 
//	//ResultSet callingmethodsclasses = st.executeQuery("SELECT classes.classname from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+CalledMethodExecutable+"' and classes.classname='"+  ClassQualifiedName +"'"); 
///*	ResultSet callingmethodsclasses = st.executeQuery("SELECT methods.classname from methods where methods.methodname='"+  ClassQualifiedName +"'"); 
//	while(callingmethodsclasses.next()){
//		callingmethodclass = callingmethodsclasses.getString("classname"); 
//		   }*/
//	
//	
//	//CALLED METHOD ID 
//	/*ResultSet calledmethodsids= st.executeQuery("SELECT methods.id from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+CalledMethodExecutable+"' and classes.classname='"+  ClassQualifiedName +"'"); 
//	while(calledmethodsids.next()){
//		calledmethodid = calledmethodsids.getString("id"); 
//		   }
//	 
//	//CALLED METHOD NAME 
//	ResultSet callemethodnames = st.executeQuery("SELECT methods.methodname from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+CalledMethodExecutable+"' and classes.classname='"+  ClassQualifiedName +"'"); 
//	while(callemethodnames.next()){
//		calledmethodname = callemethodnames.getString("methodname"); 
//		   }
//	
//	
//	//CALLED METHOD CLASS 
//	ResultSet calledmethodclasses = st.executeQuery("SELECT classes.classname from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+CalledMethodExecutable+"' and classes.classname='"+  ClassQualifiedName +"'"); 
//	while(calledmethodclasses.next()){
//		calledmethodclass = calledmethodclasses.getString("classname"); 
//		   }
//	
//	*/
//	//System.out.println("CALLED METHOD "+calledmethodname+ "\tCLASS2: "+calledmethodclass+"\tCALLINGMETHOD: "+callingmethodsrefinedname+"CALLING MENTHOD CLASS"+callingmethodclass);
//
//    
//	
//
//
//	}
//}
//}
//
//
//
//
//
//}  
//
////////////////
////////////////
////////////////
////////////////
////////////////
//////////////////System.out.println("Contents of file:");
//////////////////System.out.println(stringBuffer.toString());
////////////////
////    	
////    	
////    	
////    	
////  
//
//
//
//
//
///////////////////*********************************************************************************************************************************************************************************/	
///////////////////*********************************************************************************************************************************************************************************/	
///////////////////*********************************************************************************************************************************************************************************/   	
////////////////////BUILD METHODSCALLED EXECUTED TABLE
////////////////counter=0; 
File file = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\data.txt");
FileReader fileReader = new FileReader(file);
BufferedReader bufferedReader = new BufferedReader(fileReader);
StringBuffer stringBuffer = new StringBuffer();
String line;
//try {
//
//List<methodcallsexecuted> methodcallsexecutedlist= new ArrayList<methodcallsexecuted>(); 
//
//while ((line = bufferedReader.readLine()) != null) {
//
//
//
//String methodsCalling= line.substring(1, line.indexOf("---")); 	
//String ClassFROM=methodsCalling.substring(0, methodsCalling.lastIndexOf("."));
//String MethodFROM=methodsCalling.substring(methodsCalling.lastIndexOf(".")+1, methodsCalling.indexOf(")")+1);
//String returnFROM= methodsCalling.substring(methodsCalling.lastIndexOf(")")+1, methodsCalling.length());
//MethodFROM=MethodFROM.replace("/", "."); 
////MethodFROM=MethodFROM.replace(";", ","); 
////int endIndex = MethodFROM.lastIndexOf(",");
////if (endIndex != -1)  
////{
////MethodFROM = MethodFROM.substring(0, endIndex)+")"; // not forgot to put check if(endIndex != -1)
////}
////MethodFROM=MethodFROM.replace("Lde", "de"); 
//MethodFROM=MethodFROM.replace("Ljava", "java"); 
////MethodFROM=MethodFROM.replace("-", ""); 
//String methodsCalled=line.substring(line.lastIndexOf("---")+5, line.length()-1); 			
//String ClassTO=methodsCalled.substring(0, methodsCalled.lastIndexOf("."));
//String MethodTO=methodsCalled.substring(methodsCalled.lastIndexOf(".")+1, methodsCalled.indexOf(")")+1); 
//String returnTO= methodsCalled.substring(methodsCalled.lastIndexOf(")")+1, methodsCalled.length());
//MethodTO=MethodTO.replace("/", "."); 
//MethodTO=MethodTO.replace(";", ","); 
//
////endIndex = MethodTO.lastIndexOf(",");
////if (endIndex != -1)  
////{
////MethodTO = MethodTO.substring(0, endIndex)+")"; // not forgot to put check if(endIndex != -1)
////}
////MethodTO=MethodTO.substring(0, MethodTO.lastIndexOf(",")-2)+")"; 
//MethodTO=MethodTO.replace("Lde", "de"); 
//MethodTO=MethodTO.replace("Ljava", "java"); 
////MethodTO=MethodTO.replace("-", "");
//stringBuffer.append("\n");
///*stringBuffer2.append("(SELECT MethodsID from Methods \r\n" + 
//"INNER JOIN Classes \r\n" + 
//"ON Classes.ClassID=Methods.ClassID\r\n" + 
//"where Methods.MethodName='"+MethodTO+"'  AND Classes.ClassName='"+ClassTO+"')),"); 
//stringBuffer2.append("\n");*/
//// 
////
//
////System.out.println("CLASS FROM: "+ClassFROM+"        METHOD FROM       "+ MethodFROM+ "       CLASS TO       "+ ClassTO+"       Method To       "+MethodTO); 
//MethodFROM=RewriteFullMethod(MethodFROM); 
//MethodTO=RewriteFullMethod(MethodTO); 
//String callingmethodid=null; 
//String callingmethodsrefinedid=null; 
//String callingmethodsrefinedname=null; 
//String callingmethodclass=null; 
//String calledmethodid=null; 
//String calledmethodname=null; 
//String calledmethodclass=null; 
//String classFROMid=null; 
//String classTOid=null; 
//String ClassFROMName=null; 
//String ClassTOName=null; 
//String ParameterClassID=null; 
//String ClassFROMidParamater=null; 
//String ClassFROMNameParamater=null; 
////get rid of everything that comes after the $ sign 
//
//
//
////String MethodFROMTransformed= MethodFROM.substring(0, MethodFROM.indexOf("(")); 
////String MethodTOTransformed= MethodTO.substring(0, MethodTO.indexOf("(")); 
////CALLING METHOD ID 
//
//if(ClassFROM.contains("$")) {
//System.out.println("CLASS FROM BEFORE ======>"+ClassFROM);
////ClassFROM=ClassFROM.substring(0, ClassFROM.indexOf("$")); 
//ClassFROM=RewriteFullMethodCallExecutedRemoveDollars(ClassFROM); 
//System.out.println("CLASS FROM======>"+ClassFROM);
//
//}
//else {
//System.out.println("CLASS FROM======>"+ClassFROM);
//
//}
//if(ClassTO.contains("$")) {
//System.out.println("ClassTO BEFORE======>"+ClassTO);
////ClassTO=ClassTO.substring(0, ClassTO.indexOf("$")); 
//ClassTO=RewriteFullMethodCallExecutedRemoveDollars(ClassTO); 
//System.out.println("ClassTO======>"+ClassTO);
//}
//else {
//System.out.println("ClassTO======>"+ClassTO);
//}
////if(MethodTOTransformed.equals("-clinit-")) {
////MethodTOTransformed="-init-"; 
////}
////if(MethodFROMTransformed.equals("-clinit-")) {
////MethodFROMTransformed="-init-"; 
////}
//MethodTO= MethodTO.replaceAll("-clinit-", "-init-"); 
//MethodFROM= MethodFROM.replaceAll("-clinit-", "-init-"); 
//MethodTO= MethodTO.replaceAll("Lde", "de"); 
//MethodFROM= MethodFROM.replaceAll("Lde", "de"); 
//System.out.println("MethodTO======>"+MethodTO);
//System.out.println("MethodFROM======>"+MethodFROM);
//String regEx = "[A-Z]";
//Pattern pattern = Pattern.compile(regEx);
//
//
//Matcher matcher = pattern.matcher(MethodFROM);
//
//
//
//
//MethodTO=MethodTO.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
//MethodFROM=MethodFROM.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
//MethodFROM=MethodFROM.replaceAll("(Ijava.lang.String)", "int,java.lang.String"); 
//MethodTO=MethodTO.replaceAll("(Ijava.lang.String)", "int,java.lang.String"); 
//
////	counter ++; 
////CALLING METHOD ID 
//ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+MethodFROM+"' and methods.classname='"+ClassFROM+"'"); 
//if(callingmethodsrefined.next()){
//callingmethodsrefinedid = callingmethodsrefined.getString("id"); 
//callingmethodsrefinedname = callingmethodsrefined.getString("methodname"); 
//}
//
//
//
//
////CALLING METHOD CLASS 
//ResultSet callingmethodsclasses = st.executeQuery("SELECT classes.classname from classes where classes.classname ='"+ClassFROM+"'"); 
//if(callingmethodsclasses.next()){
//callingmethodclass = callingmethodsclasses.getString("classname"); 
//}
//
//MethodTO=MethodTO.replaceAll("Lantlr", "antlr"); 
//MethodFROM=MethodFROM.replaceAll("Lantlr", "antlr"); 
//MethodTO=MethodTO.replaceAll("Lde", "de"); 
//MethodFROM=MethodFROM.replaceAll("Lde", "de"); 
////CALLED METHOD ID 
//ResultSet calledmethodsids= st.executeQuery("SELECT methods.* from methods  where methods.methodname='"+MethodTO+"'and methods.classname='"+ClassTO+"'"); 
//if(calledmethodsids.next()){
//calledmethodid = calledmethodsids.getString("id"); 
//calledmethodname = calledmethodsids.getString("methodname"); 
//}
//
////CALLED METHOD NAME 
////ResultSet callemethodnames = st.executeQuery("SELECT methods.methodname from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+MethodTOTransformed+"'"); 
////while(callemethodnames.next()){
////calledmethodname = callemethodnames.getString("methodname"); 
////}
//
//
////CALLED METHOD CLASS 
//ResultSet calledmethodclasses = st.executeQuery("SELECT classes.classname from classes where classes.classname ='"+ClassTO+"'"); 
//if(calledmethodclasses.next()){
//calledmethodclass = calledmethodclasses.getString("classname"); 
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////System.out.println("CLASS FROM: "+ClassFROM+"        METHOD FROM       "+ MethodFROM+ "       CLASS TO       "+ ClassTO+"       Method To       "+MethodTO+"calling merthod refined id    "+ callingmethodsrefinedid+ "called method id    "+ calledmethodid); 
//
//methodcallsexecuted mce= new methodcallsexecuted(callingmethodsrefinedid, MethodFROM, ClassFROM, calledmethodid, MethodTO, ClassTO); 
//System.out.println(mce.toString()); 	
//if(mce.contains(methodcallsexecutedlist, mce)==false) {
//if(callingmethodsrefinedid!=null && calledmethodid!=null ) {
//String fullcaller= ClassFROM+"."+MethodFROM; 
//String fullcallee= ClassTO+"."+MethodTO; 
//String FullMethodFROM= ClassFROM+"."+MethodFROM; 
//String FullMethodTO= ClassTO+"."+MethodTO; 
//fullcaller=RewriteFullMethod(FullMethodFROM); 
//fullcallee=RewriteFullMethod(FullMethodTO); 
//fullcallee=fullcallee.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
//fullcaller=fullcaller.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
//fullcallee=fullcallee.replaceAll("(Ijava.lang.String)", "int,java.lang.String"); 
//fullcaller=fullcaller.replaceAll("(Ijava.lang.String)", "int,java.lang.String"); 
//MethodTO=MethodTO.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
//MethodFROM=MethodFROM.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
//MethodFROM=MethodFROM.replaceAll("(Ijava.lang.String)", "int,java.lang.String"); 
//MethodTO=MethodTO.replaceAll("(Ijava.lang.String)", "int,java.lang.String"); 
//String fullcallershort = fullcaller.substring(0, fullcaller.indexOf("(")); 
//String fullcalleeshort = fullcallee.substring(0, fullcallee.indexOf("(")); 
//String statement = "INSERT INTO `methodcallsexecuted`(`callermethodid`,  `callername`,  `callerclass`,  `fullcaller`,  `fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`, `fullcallee`,   `fullcalleeshort`) VALUES ('"+callingmethodsrefinedid+"','" +MethodFROM+"','" +ClassFROM+"','"+fullcaller+"','"+fullcallershort+"','"+calledmethodid +"','" +MethodTO+"','" +ClassTO+"','" +fullcallee+"','" +fullcalleeshort +"')";		
//st.executeUpdate(statement);
//methodcallsexecutedlist.add(mce); 
//}
//else {
//System.out.println("LINE THAT COULD NOT BE INSERTED=======>"+ line);
////if the methods table does not contain a method call that is obtained from parsing the log file, then I am inserting this row within the methods table
//   //This is for METHOD FROM 
//	
//
////calculate class id FROM 
//	ResultSet classidsFROM = st.executeQuery("SELECT classes.id from classes where classes.classname ='"+ClassFROM+"'"); 
//	if(classidsFROM.next()){
//		classFROMid = classidsFROM.getString("id"); 
//		   }
//	
//	//calculate class classname FROM 
//	ResultSet classnamesFROM = st.executeQuery("SELECT classes.classname from classes where classes.classname ='"+ClassFROM+"'"); 
//	if(classnamesFROM.next()){
//		ClassFROMName = classnamesFROM.getString("classname"); 
//		   }
//	
//	
//	//calculate class classname FROM 
//	ResultSet paramclassids = st.executeQuery("SELECT classes.* from classes where classes.id ='"+returnFROM+"'"); 
//	if(paramclassids.next()){
//		ClassFROMidParamater = paramclassids.getString("id"); 
//		ClassFROMNameParamater = paramclassids.getString("classname"); 
//		   }
//	
//	
////	String MethodFROMRefined= MethodFROMTransformed.substring(0, MethodFROMTransformed.indexOf("(")); 
//	String MethodFROMRefined= MethodFROM; 
//	String MethodFROMAbbreviation = ClassFROM+"."+MethodFROM; 
//	if(callingmethodsrefinedid==null && classFROMid!=null) {
//		String fullmeth=ClassFROM+"."+MethodFROM; 
//		fullmeth=RewriteFullMethod(fullmeth); 
//		
//		
//		
//		
//		
//	//	st.executeUpdate("INSERT INTO `methods`(`methodname`,  `methodnamerefined`,`methodabbreviation`, `fullmethod`, `classid`, `classname`) VALUES ('"+MethodFROM +"','" +MethodFROMRefined+"','" +MethodFROMAbbreviation+"','" +fullmeth+"','" +classFROMid+"','" +ClassFROM+"')");
//	
//		
//		
//		
//		
//		
//		//RECALCULATION PHASE: CALLING METHOD ID 
//		 callingmethodsrefined = st.executeQuery("SELECT methods.id from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+MethodFROM+"' and classes.classname='"+ClassFROM+"'"); 
//		 if(callingmethodsrefined.next()){
//			callingmethodsrefinedid = callingmethodsrefined.getString("id"); 
//	
//		}
//		
//		String par= transformstring(returnFROM); 
//		 regEx = "\\(([A-Z])\\)";
//	     pattern = Pattern.compile(regEx);
//	     matcher = pattern.matcher(par);
//	    while (matcher.find()) {
//	    	par=par.replaceAll("Z", "boolean"); 
//	    	par=par.replaceAll("B", "byte"); 
//	    	par=par.replaceAll("I", "int"); 
//	    	par=par.replaceAll("J", "long"); 
//	    	par=par.replaceAll("S", "short"); 
//	    }
//		regEx = "\\(([A-Z][A-Z]+)\\)";
//	     pattern = Pattern.compile(regEx);
//	     matcher = pattern.matcher(par);
//	    while (matcher.find()) {
//	    
//	    	par=par.replaceAll("Z", "boolean,"); 
//	    	par=par.replaceAll("B", "byte,"); 
//	    	par=par.replaceAll("I", "int,"); 
//	    	par=par.replaceAll("J", "long,"); 
//	    	par=par.replaceAll("S", "short,"); 
//	    	par=par.substring(0, par.lastIndexOf(",")); 
//	    	par=par+")"; 
//	    }
//	System.out.println("PARAM"+par);
//		 if(par.contains("net.sourceforge.ganttproject")) {//ignore the basic data types, only insert the parameters thaht have classes as data types 
//			 
//			 ResultSet ParameterClassIDs= st.executeQuery("SELECT classes.id from classes where classes.classname='"+par+"'"); 
//				while(ParameterClassIDs.next()){
//					 ParameterClassID = ParameterClassIDs.getString("id"); 
//					   }
//			 
//	//	System.out.println("COUNYER========> "+counter);	
//		if(ParameterClassID!=null)
//		st.executeUpdate("INSERT INTO `parameters`(`parametername`, `parametertype`, `parameterclass`,`classid`, `classname`, `methodid`, `methodname`, `isreturn`) VALUES ('"+par +"','" +par +"','"+ParameterClassID+"','"+ClassFROMidParamater +"','"+ClassFROMNameParamater+"','" +callingmethodsrefinedid+"','" +MethodFROM+"','" +1+"')");
//		 }
//		String[] params = ExtractParams(MethodFROM); 
//		 //insert parameters that were retrieved from the log file 
//	//	counter++; 
//		//System.out.println("HERE IS THE LINE =======>"+line+ counter);
//		for(String p: params) {
//			 regEx = "\\(([A-Z])\\)";
//		     pattern = Pattern.compile(regEx);
//		     matcher = pattern.matcher(par);
//		    while (matcher.find()) {
//		    	p=p.replaceAll("Z", "boolean"); 
//		    	p=p.replaceAll("B", "byte"); 
//		    	p=p.replaceAll("I", "int"); 
//		    	p=p.replaceAll("J", "long"); 
//		    	p=p.replaceAll("S", "short"); 
//		    }
//			regEx = "\\(([A-Z][A-Z]+)\\)";
//		     pattern = Pattern.compile(regEx);
//		     matcher = pattern.matcher(par);
//		    while (matcher.find()) {
//		    
//		    	p=p.replaceAll("Z", "boolean,"); 
//		    	p=p.replaceAll("B", "byte,"); 
//		    	p=p.replaceAll("I", "int,"); 
//		    	p=p.replaceAll("J", "long,"); 
//		    	p=p.replaceAll("S", "short,"); 
//		    	p=p.substring(0, p.lastIndexOf(",")); 
//		    	p=p+")"; 
//		    }
//		
//			System.out.println("HERE IS A PARAM==================================================================>"+p); 
//			ResultSet ParameterClassIDs= st.executeQuery("SELECT classes.id from classes where classes.classname='"+p+"'"); 
//			while(ParameterClassIDs.next()){
//				 ParameterClassID = ParameterClassIDs.getString("id"); 
//				   }
//			
//			
//			if(p.contains("net.sourceforge.ganttproject") && p!=null && p.equals("")==false && classFROMid!=null && ParameterClassID!=null) {
//				st.executeUpdate("INSERT INTO `parameters`(`parametername`, `parametertype`, `parameterclass`,`classid`, `classname`, `methodid`, `methodname`, `isreturn`) VALUES ('"+p +"','" +p +"','"+ParameterClassID+"','"+classFROMid +"','"+ClassFROMName+"','" +callingmethodsrefinedid+"','" +MethodFROM+"','" +0+"')");
//
//			}
//	}
//
////		counter++; 
//	
//	
//	//METHOD TO 
//	//calculate class id TO 
//	ResultSet classidsTO = st.executeQuery("SELECT classes.id from classes where classes.classname ='"+ClassTO+"'"); 
//	while(classidsTO.next()){
//		classTOid = classidsTO.getString("id"); 
//		   }
//	
//	//String MethodTORefined= MethodTOTransformed.substring(0, MethodTOTransformed.indexOf("(")); 
//	String MethodTORefined= MethodTO;
//	String MethodTOAbbreviation = ClassTO+"."+MethodTORefined; 
//	String FullMethTO= RewriteFullMethod(MethodTOAbbreviation); 
//	if(calledmethodid==null && classTOid!=null) {
//		
//		
//		
//		
//		//st.executeUpdate("INSERT INTO `methods`(`methodname`,  `methodnamerefined`,`methodabbreviation`,`fullmethod`, `classid`, `classname`) VALUES ('"+MethodTO +"','" +MethodTORefined+"','" +MethodTOAbbreviation+"','"+FullMethTO+"','" +classTOid+"','" +ClassTO+"')");
//
//		
//		
//		
//		//RECALCULATION PHASE: CALLED METHOD ID 
//		 calledmethodsids= st.executeQuery("SELECT methods.id from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+MethodTO+"'and classes.classname='"+ClassTO+"'"); 
//		 if(calledmethodsids.next()){
//			calledmethodid = calledmethodsids.getString("id"); 
//			   }
//		
//		
//		
//		//calculate class classname FROM 
//		ResultSet classnamesTO = st.executeQuery("SELECT classes.classname from classes where classes.classname ='"+ClassTO+"'"); 
//		
//		if(classnamesTO.next()){
//			ClassTOName = classnamesTO.getString("classname"); 
//			   }
//		 par= transformstring(returnTO); 
//		 //insert return value within the parameters table 
//		  ResultSet ParameterClassIDs = st.executeQuery("SELECT classes.id from classes where classes.classname='"+par+"'"); 
//			while(ParameterClassIDs.next()){
//				 ParameterClassID = ParameterClassIDs.getString("id"); 
//				   }
//		 if(par.contains("net.sourceforge.ganttproject") && ParameterClassID!=null) {//ignore the basic data types, only insert the parameters thaht have classes as data types 
//				st.executeUpdate("INSERT INTO `parameters`(`parametername`, `parametertype`, `parameterclass`,`classid`, `classname`, `methodid`, `methodname`, `isreturn`) VALUES ('"+par +"','" +par +"','"+ParameterClassID+"','"+classTOid +"','"+ClassTOName+"','" +calledmethodid+"','" +MethodTO+"','" +1+"')");
//
//		 }
//		 
//		 //insert parameters that were retrieved from the log file 
//		 params = ExtractParams(MethodTO); 
//		for(String p: params) {
//			System.out.println("HERE IS A PARAM==================================================================>"+p); 
//			 ParameterClassIDs= st.executeQuery("SELECT classes.id from classes where classes.classname='"+p+"'"); 
//			while(ParameterClassIDs.next()){
//				 ParameterClassID = ParameterClassIDs.getString("id"); 
//				   }
//			
//			if(p.contains("net.sourceforge.ganttproject")&& p!=null && p.equals("")==false && classTOid!=null && ParameterClassID!=null) {
//				st.executeUpdate("INSERT INTO `parameters`(`parametername`, `parametertype`, `parameterclass`,`classid`, `classname`, `methodid`, `methodname`, `isreturn`) VALUES ('"+p +"','" +p +"','"+ParameterClassID+"','"+classTOid +"','"+ClassTOName+"','" +calledmethodid+"','" +MethodTO+"','" +0+"')");
//
//			}
//		}
//	
//	}
//
//	
//	
//	
//	/*
//	//RECALCULATION PHASE: CALLING METHOD ID 
//	 callingmethodsrefined = st.executeQuery("SELECT methods.id from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodnamerefined='"+MethodFROMTransformed+"' and classes.classname='"+ClassFROM+"'"); 
//	while(callingmethodsrefined.next()){
//		callingmethodsrefinedid = callingmethodsrefined.getString("id"); 
//
//	}
//	//RECALCULATION PHASE: CALLED METHOD ID 
//	 calledmethodsids= st.executeQuery("SELECT methods.id from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodnamerefined='"+MethodTOTransformed+"'and classes.classname='"+ClassTO+"'"); 
//	while(calledmethodsids.next()){
//		calledmethodid = calledmethodsids.getString("id"); 
//		   }*/
//	
//	//insert into methodcallsexecuted table 
//	String fullcaller= ClassFROM+"."+MethodFROM; 
//	String fullcallee= ClassTO+"."+MethodTO; 
//	String FullMethodFROM= ClassFROM+"."+MethodFROM; 
//    String FullMethodTO= ClassTO+"."+MethodTO; 
//    fullcaller=RewriteFullMethod(FullMethodFROM); 
//    fullcallee=RewriteFullMethod(FullMethodTO); 
//	fullcallee=fullcallee.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
//	fullcaller=fullcaller.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
//	fullcallee=fullcallee.replaceAll("-init-(Ijava.lang.String)", "-init-(int,java.lang.String)"); 
//	fullcaller=fullcaller.replaceAll("-init-(Ijava.lang.String)", "-init-(int,java.lang.String)"); 
//	MethodTO=MethodTO.replaceAll("-init-(Ijava.lang.String)", "-init-(int,java.lang.String)"); 
//	MethodFROM=MethodFROM.replaceAll("\\[java.lang.String", "java.lang.String[]"); 
//	MethodFROM=MethodFROM.replaceAll("-init-(Ijava.lang.String)", "-init-(int,java.lang.String)"); 
//	MethodTO=MethodTO.replaceAll("-init-(Ijava.lang.String)", "-init-(int,java.lang.String)"); 
//	String fullcallershort = fullcaller.substring(0, fullcaller.indexOf("(")); 
//	String fullcalleeshort = fullcallee.substring(0, fullcallee.indexOf("(")); 
//	String statement = "INSERT INTO `methodcallsexecuted`(`callermethodid`,  `callername`,  `callerclass`,  `fullcaller`,  `fullcallershort`,`calleemethodid`,  `calleename`, `calleeclass`, `fullcallee`,   `fullcalleeshort`) VALUES ('"+callingmethodsrefinedid+"','" +MethodFROM+"','" +ClassFROM+"','" +fullcaller+"','" +fullcallershort +"','"+calledmethodid+"','" +MethodTO+"','" +ClassTO+"','" +fullcallee+"','" +fullcalleeshort +"')";		
//	st.executeUpdate(statement);
//	methodcallsexecutedlist.add(mce); 	
//	
//	
////insert into methodcalls table as well 
////	String statement2 = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`,`calleemethodid`,  `calleename`, `calleeclass`) VALUES ('"+callingmethodsrefinedid+"','" +MethodFROM+"','" +ClassFROM+"','"+calledmethodid +"','" +MethodTO+"','" +ClassTO +"')";		
////	st.executeUpdate(statement2);
//
//	
//	
//	
//}
//}
//
//
//
//
//
//
//}	
//
//}
//} catch (IOException e) {
//// TODO Auto-generated catch block
//e.printStackTrace();
//}
//
//
//
//
/////////////////////////////////////////////////////////////////////////////////////////
//
///****************************************************************************************************************************/		
//    	
//    	//BUILD INTERFACESMETHODS TABLE 
//    	
//		int counter1=1; 
//		int MethodsNumber=0; 
//		ResultSet TracesCount=st.executeQuery("SELECT COUNT(*) FROM methods"); 
//		while(TracesCount.next()) {
//			MethodsNumber= TracesCount.getInt(1); 
//			System.out.println(MethodsNumber);
//		}
//		
//		while(counter1<=MethodsNumber) {
//			ResultSet traces = st.executeQuery("SELECT methods.* from methods where id='"+counter1+"'"); 
//			String	classname=""; 
//			String	classid=""; 
//			String	methodname=""; 
//			String fullmethod=""; 
//			String fullmethodShort=""; 
//			while(traces.next()){		
//				//THIS IS GOLD 2
//					methodname=traces.getString("methodname"); 
//				String methodnamerefined = traces.getString("methodnamerefined"); 
//				String	methodabbreviation=traces.getString("methodabbreviation"); 
//				 fullmethod=traces.getString("fullmethod"); 
//				 fullmethodShort=fullmethod.substring(0, fullmethod.indexOf("(")); 
//					classid=traces.getString("classid"); 
//					classname=traces.getString("classname"); 
//				
//			
//	   		   }
//			ResultSet correspondinginterfaces = st4.executeQuery("SELECT interfaces.* from interfaces where ownerclassid='"+classid+"'"); 
//			while(correspondinginterfaces.next()){		
//				//THIS IS GOLD 2
//				String	interfaceclassid=""; 
//				String interfacename=""; 
//					interfaceclassid=correspondinginterfaces.getString("interfaceclassid"); 
//					interfacename = correspondinginterfaces.getString("interfacename"); 
//					String myinterfacename=interfacename+"."+methodname; 
//					System.out.println(myinterfacename);
//					
//					ResultSet FindingMethod = st2.executeQuery("SELECT methods.* from methods where methods.fullmethod='"+myinterfacename+"'"); 
//					while(FindingMethod.next()) {
//						String Interfacefullmethodname=FindingMethod.getString("fullmethod"); 
//						String InterfacefullmethodnameShort = Interfacefullmethodname.substring(0, Interfacefullmethodname.indexOf("(")); 
//						String interfaceID2=FindingMethod.getString("classid"); 
//						String interfacename2=FindingMethod.getString("classname"); 
//						String IDMETHOD=FindingMethod.getString("id"); 
//		    			st.executeUpdate("INSERT INTO `methodsinterfaces`(`methodid`, `fullmethodname`, `fullmethodnameshort`, `classid`, `classname`, `interfacemethodid`, `fullinterfacename`,  `fullinterfacenameshort`,`interfaceid`, `interfacename`) VALUES ('"+counter1 +"','" +fullmethod+"','" +fullmethodShort +"','" +classid +"','" +classname+"','" +IDMETHOD+"','" +Interfacefullmethodname+"','" +InterfacefullmethodnameShort +"','" +interfaceID2 +"','" +interfacename2+"')");
//
//					}
//					if(FindingMethod.next()==false) {
//						
//						ResultSet correspondinginterfaces2 = st3.executeQuery("SELECT interfaces.* from interfaces where ownerclassid='"+interfaceclassid+"'"); 
//						while(correspondinginterfaces2.next()){		
//							interfacename = correspondinginterfaces2.getString("interfacename"); 
//						}
//						myinterfacename=interfacename+"."+methodname; 
//						 FindingMethod = st5.executeQuery("SELECT methods.* from methods where methods.fullmethod='"+myinterfacename+"'"); 
//						while(FindingMethod.next()) {
//							String Interfacefullmethodname=FindingMethod.getString("fullmethod"); 
//							String InterfacefullmethodnameShort = Interfacefullmethodname.substring(0, Interfacefullmethodname.indexOf("(")); 
//
//							String interfaceID2=FindingMethod.getString("classid"); 
//							String interfacename2=FindingMethod.getString("classname"); 
//							String IDMETHOD=FindingMethod.getString("id"); 
//			    			st.executeUpdate("INSERT INTO `methodsinterfaces`(`methodid`, `fullmethodname`,  `fullmethodnameshort`,`classid`, `classname`, `interfacemethodid`, `fullinterfacename`, `fullinterfacenameshort`, `interfaceid`, `interfacename`) VALUES ('"+counter1 +"','" +fullmethod+"','" +fullmethodShort +"','" +classid +"','" +classname+"','" +IDMETHOD+"','" +Interfacefullmethodname+"','" +InterfacefullmethodnameShort +"','" +interfaceID2 +"','" +interfacename2+"')");
//
//						}
//					}
//				
//	   		   }
//			
//		
//			
//			
//			
//			counter1++; 
//		}
//		
//		
//		
//		
//		
//		
//		
//		
///****************************************************************************************************************************/		
// /****************************************************************************************************************************/		
//
//		
//		//BUILD SUPERCLASSESMETHODS TABLE 
//		int counter2=1; 
//		
//		 TracesCount=st.executeQuery("SELECT COUNT(*) FROM methods"); 
//		while(TracesCount.next()) {
//			MethodsNumber= TracesCount.getInt(1); 
//			System.out.println(MethodsNumber);
//		}
//		
//		while(counter2<=MethodsNumber) {
//			ResultSet traces = st.executeQuery("SELECT methods.* from methods where id='"+counter2+"'"); 
//			String	classname=""; 
//			String	classid=""; 
//			String	methodname=""; 
//			String fullmethod=""; 
//			String fullmethodShort=""; 
//			while(traces.next()){		
//				//THIS IS GOLD 2
//					methodname=traces.getString("methodname"); 
//				String methodnamerefined = traces.getString("methodnamerefined"); 
//				String	methodabbreviation=traces.getString("methodabbreviation"); 
//				 fullmethod=traces.getString("fullmethod"); 
//				 fullmethodShort = fullmethod.substring(0, fullmethod.indexOf("(")); 
//					classid=traces.getString("classid"); 
//					classname=traces.getString("classname"); 
//				
//			
//	   		   }
//			ResultSet correspondingsuperclasses = st3.executeQuery("SELECT superclasses.* from superclasses where ownerclassid='"+classid+"'"); 
//			while(correspondingsuperclasses.next()){		
//				//THIS IS GOLD 2
//				String	superclassclassid=""; 
//				String superclassname=""; 
//				String SuperclassfullmethodnameShort =""; 
//					superclassclassid=correspondingsuperclasses.getString("superclassid"); 
//					superclassname = correspondingsuperclasses.getString("superclassname"); 
//					String mysuperclassname=superclassname+"."+methodname; 
//					System.out.println(mysuperclassname);
//					
//					ResultSet FindingMethod = st2.executeQuery("SELECT methods.* from methods where methods.fullmethod='"+mysuperclassname+"'"); 
//					if(FindingMethod.next()) {
//						String Superclassfullmethodname=FindingMethod.getString("fullmethod"); 
//						SuperclassfullmethodnameShort = Superclassfullmethodname.substring(0, Superclassfullmethodname.indexOf("(")); 
//						String superclassID2=FindingMethod.getString("classid"); 
//						String superclassname2=FindingMethod.getString("classname"); 
//						String IDMETHOD=FindingMethod.getString("id"); 
//		    			st.executeUpdate("INSERT INTO `methodssuperclasses`(`methodid`, `fullmethodname`, `fullmethodnameshort`, `classid`, `classname`, `superclassmethodid`, `fullsuperclassname`, `fullsuperclassnameshort`, `superclassid`, `superclassname`) VALUES ('"+counter2 +"','" +fullmethod+"','" +fullmethodShort +"','" +classid +"','" +classname+"','" +IDMETHOD+"','" +Superclassfullmethodname+"','" +SuperclassfullmethodnameShort +"','" +superclassID2 +"','" +superclassname2+"')");
//
//					}
//				
//	   		   }
//			
//		
//			counter2++; 
//		}	
//    	
////    	
////    	/****************************************************************************************************************************/		
////	
////    	
////    	
////		
/////////////////*********************************************************************************************************************************************************************************/	
/////////////////*********************************************************************************************************************************************************************************/	
/////////////////*********************************************************************************************************************************************************************************/   
//////////////////CREATE REQUIREMENTS TABLE 
////////////////
//file = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\Requirements.txt");
// fileReader = new FileReader(file);
// bufferedReader = new BufferedReader(fileReader);
// stringBuffer = new StringBuffer();
//
// 
//try {
//	
//
//	while ((line = bufferedReader.readLine()) != null) {
//		System.out.println(line);
//		
//		
//		
//	
//		
//		String statement = "INSERT INTO `requirements`(`requirementname`) VALUES ('"+line+"')";		
//		st.executeUpdate(statement);
//	
//		
//		
//	}
//
//
//
//
//	}
//	
//catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
////////////
/////////////*********************************************************************************************************************************************************************************/	
/////////////*********************************************************************************************************************************************************************************/	
/////////////*********************************************************************************************************************************************************************************/   
//
//////////////CREATE TRACES TABLE 
//////////
//file = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\Traces.txt");
// fileReader = new FileReader(file);
// bufferedReader = new BufferedReader(fileReader);
// stringBuffer = new StringBuffer();
//
// List<tracesmethods> TraceListMethods= new ArrayList<tracesmethods>();
//tracesmethodscallees tmc = null; 
//int COUNTER3=1; 
//try {
//	
//	line = bufferedReader.readLine(); 
//	while ((line = bufferedReader.readLine()) != null) {
//		String interfaces_info[][] = new String[8][8];
//		 String[] inter_item= new String[4]; 
//		 String requirement=null; 
//		 String method=null; 
//		 String gold=null; 
//		 String subject=null; 
//		 String methodid=null; 
//		 String classname=null; 
//		 String classid=null; 
//		 String requirementid=null; 
//		String calleeid=null; 
//		String goldprediction=null; 
//		String calleeidexecuted=null; 
//		String callerid=null; 
//		String callerexecutedid=null; 
//		System.out.println(line);
//		String[] linesplitted = line.split(","); 
//		method=linesplitted[1]; 
//		requirement=linesplitted[2]; 
//		gold=linesplitted[4]; 
//		subject=linesplitted[5]; 
//		method=method.replace("/", "."); 
//		method=method.replace(";", ","); 
//
//		method=RewriteFullMethodCallExecutedRemoveDollarsTraces(method);
//		method=method.substring(0, method.indexOf(")")+1);
//		method=method.replaceAll("Lde", "de");
//		method=method.replaceAll("Lantlr", "antlr");
//		method=method.replaceAll("Ljava", "java");
//		method=RewriteFullMethod(method);
//
//		System.out.println("FULLLLLLLL MEEEEEEEETH========>"+ method); 
//		method=method.replaceAll(",\\)", ")");
//		System.out.println("FULLLLLLLL MEEEEEEEETH========>"+ method); 
//method=method.trim(); 
//String shortmethodname=""; 
//String shortmethod=method.substring(0, method.indexOf("("));
//System.out.println(method);
//			ResultSet methodids = st.executeQuery("SELECT methods.* from methods where methods.fullmethod ='"+method+"'"); 
//			while(methodids.next()){
//				methodid = methodids.getString("id"); 
//				shortmethodname = methodids.getString("methodname"); 
//				classname = methodids.getString("classname"); 
//				classid = methodids.getString("classid"); 
//				   }
//
//		
//			
//
//		requirementid=null; 
//		requirement=requirement.trim();
//		ResultSet requirements = st.executeQuery("SELECT requirements.id from requirements where requirements.requirementname ='"+requirement+"'"); 
//		while(requirements.next()){
//			requirementid = requirements.getString("id"); 
//			   }
//		
//	
//			
//			
//		tracesmethods tr= new tracesmethods(requirementid, methodid,  classid); 
//		if(methodid!=null && requirementid!=null ) {
//			boolean mycond=tr.contains(TraceListMethods, tr);
//			if(mycond==false) {
//			//	method=RewriteFullMethod(method);  
//				String methodnameAndParams= GetMethodNameAndParams(method); 
//				method=method.replaceAll("Lde", "de"); 
//				methodnameAndParams=methodnameAndParams.replaceAll("Lde", "de"); 
//				String statement = "INSERT INTO `traces`(`requirement`, `requirementid`, `method`, `methodname`, `fullmethod`,  `methodid`,`classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','" +shortmethod+"','" +methodnameAndParams+"','" +method+"','" +methodid+"','"+classname +"','" +classid+"','"+gold +"','" +subject+"')";		
//				st.executeUpdate(statement);
//				TraceListMethods.add(tr); 
//				
//				
//			}
//			
//			
//		}
//
//		
//		
//		
//		
//	
//		COUNTER3++; 
//		
//	}
//	
//	
	HashMap<String, String> RequirementIDNameHashMap=new HashMap<String, String> (); 
	RequirementIDNameHashMap.put("1", "R0"); 
	RequirementIDNameHashMap.put("2", "R1"); 
	RequirementIDNameHashMap.put("3", "R2"); 
	RequirementIDNameHashMap.put("4", "R3"); 
	RequirementIDNameHashMap.put("5", "R4"); 
	RequirementIDNameHashMap.put("6", "R5"); 
	RequirementIDNameHashMap.put("7", "R6"); 
	RequirementIDNameHashMap.put("8", "R7"); 
//	ResultSet mymeths = st2.executeQuery("SELECT methods.* from methods"); 
//	while(mymeths.next()){
//		String methodid = mymeths.getString("id"); 
//		String method = mymeths.getString("methodabbreviation"); 
//		String methodname = mymeths.getString("methodname"); 
//		String fullmethod = mymeths.getString("fullmethod"); 
//		
//		String classname = mymeths.getString("classname"); 
//		String classid = mymeths.getString("classid"); 
//		
//		
//		
//		for(String key: RequirementIDNameHashMap.keySet()) {
//			tracesmethods tr= new tracesmethods(key, methodid,  classid); 
//			
//			if(!tr.contains(TraceListMethods, tr)) {
//				String statement = "INSERT INTO `traces`(`requirement`, `requirementid`, `method`, `methodname`, `fullmethod`,  `methodid`,`classname`, `classid`, `gold`,  `subject`) VALUES ('"+RequirementIDNameHashMap.get(tr.getRequirementid())+"','" +tr.getRequirementid()+"','" +method+"','" +methodname+"','" +fullmethod+"','" +methodid+"','"+classname +"','" +classid+"','"+ " "+"','" + " "+"')";		
//				st.executeUpdate(statement);
//			}
//		}
//		
//	
//	}
//
//	
//	
//	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	



HashMap <String, String > RequirementClassHashMap= new HashMap <String, String > (); 

String classname=""; 
String classid=""; 
String requirementname=""; 
String requirementid="";
ResultSet Traces = st.executeQuery("SELECT classes.* from classes "); 
while(Traces.next()){
classname = Traces.getString("classname"); 
classid = Traces.getString("id"); 
			for(String keyreq: RequirementIDNameHashMap.keySet()) {
				String key= keyreq+"-"+classid; 
				String val= keyreq+"-"+RequirementIDNameHashMap.get(keyreq)+"-"+classid+"-"+classname; 

				RequirementClassHashMap.put(key, val); 
			}





}

for(Entry<String, String> entry :RequirementClassHashMap.entrySet()) {
String myvalue = entry.getValue(); 
String[] myvalues = myvalue.split("-"); 
String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`) VALUES ('"+myvalues[1]+"','" +myvalues[0]+"','"  +myvalues[3]+"','" +myvalues[2]+"')";	
st2.executeUpdate(statement8);
}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

//}
//	
//catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//
//
//
//
//
//
//
///*********************************************************************************************************************************************************************************/	
///*********************************************************************************************************************************************************************************/	
///*********************************************************************************************************************************************************************************/   
////make prediction on the column goldprediction 
////int counter=0;
///*
//for(tracesmethodscallees tc: TracesCalleesList) {
//	
//
//	System.out.println("COUNTER "+counter +"tc.gold===============================================================>"+tc.gold); 
//	System.out.println("tc.callee===============================================================>"+tc.callee); 
//	System.out.println("tc.requirementid===============================================================>"+tc.requirementid+   "------"+tc.callee); 
//
//	 String query = "update traces set goldpredictioncallee = ? where methodid = ? and requirementid = ?";
//     PreparedStatement pstmt = conn.prepareStatement(query); // create a statement
//     pstmt.setString(1, tc.gold); // set input parameter 1
//     pstmt.setString(2, tc.callee); // set input parameter 2
//     pstmt.setString(3, tc.requirementid); // set input parameter 3
//     pstmt.executeUpdate(); // execute update statement
//	
//	//PreparedStatement preparedstatement = conn.prepareStatement("update table `databasechess`.`traces` SET `traces`.`goldprediction`='"+tc.gold+"' where `traces`.`methodid`='"+tc.callee+"'"); 
//	// int goldpredictions = preparedstatement.executeUpdate();
//	// conn.commit();
//	// preparedstatement.close();
//     counter++; 
//	
//	
//}
//
//counter=0;
//for(tracesmethodscallees tc: TracesCallersList) {
//	
//
//	System.out.println("COUNTER "+counter +"tc.gold===============================================================>"+tc.gold); 
//	System.out.println("tc.callee===============================================================>"+tc.callee); 
//	System.out.println("tc.requirementid===============================================================>"+tc.requirementid+   "------"+tc.callee); 
//
//	 String query = "update traces set goldpredictioncaller = ? where methodid = ? and requirementid = ?";
//     PreparedStatement pstmt = conn.prepareStatement(query); // create a statement
//     pstmt.setString(1, tc.gold); // set input parameter 1
//     pstmt.setString(2, tc.callee); // set input parameter 2
//     pstmt.setString(3, tc.requirementid); // set input parameter 3
//     pstmt.executeUpdate(); // execute update statement
//	
//	//PreparedStatement preparedstatement = conn.prepareStatement("update table `databasechess`.`traces` SET `traces`.`goldprediction`='"+tc.gold+"' where `traces`.`methodid`='"+tc.callee+"'"); 
//	// int goldpredictions = preparedstatement.executeUpdate();
//	// conn.commit();
//	// preparedstatement.close();
//	counter++; 
//	
//	
//}
//////*/
////
////	/*********************************************************************************************************************************************************************************/	
////	/*********************************************************************************************************************************************************************************/	
////	/*********************************************************************************************************************************************************************************/   
//////BUILD TABLE FOR TRACES CLASSES 
//
//List<RequirementClassKey> RequirementClassKeys= new ArrayList<RequirementClassKey>(); 
//Hashtable<String,String> RequirementClassHashMap=new Hashtable<String,String>(); 
//
//try {
//	int  counter2=1; 
//	 file = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\Traces.txt");
//		fileReader = new FileReader(file);
//		bufferedReader = new BufferedReader(fileReader);	
//		line = bufferedReader.readLine(); 
//		Hashtable<RequirementClassKey,String> GoldHashTable=new Hashtable<RequirementClassKey,String>();  
//		Hashtable<RequirementClassKey,String> SubjectHashTable=new Hashtable<RequirementClassKey,String>(); 
//		
//		while ((line = bufferedReader.readLine()) != null) {
//			 String requirement=null; 
//			 String method=null; 
//			 String gold=null; 
//			 String subject=null; 
//			 String methodid=null; 
//			 String classname=null; 
//			 String classid=null; 
//			 String requirementid=null; 
//			String calleeid=null; 
//			String goldprediction=null; 
//			String calleeidexecuted=null; 
//			String callerid=null; 
//			String callerexecutedid=null; 
//			List<List<String>> myinterfacesList= new ArrayList<List<String>>(); 
//			System.out.println(line);
//			String[] linesplitted = line.split(","); 
//			method=linesplitted[1]; 
//			requirement=linesplitted[2]; 
//			gold=linesplitted[4]; 
//			subject=linesplitted[5]; 
//			method=method.replace("/", "."); 
//			method=method.replace(";", ","); 
//			method=method.replaceAll("Lantlr", "antlr");
//			method=method.replace("Lde", "de"); 
////			  int endIndex = method.lastIndexOf(",)");
////			    if (endIndex != -1)  
////			    {
////			    	method = method.substring(0, endIndex)+")"; // not forgot to put check if(endIndex != -1)
////			    }
////			String shortmethod=method.substring(0, method.indexOf("(")); 
////			 String regEx = "[A-Z]";
////			    Pattern pattern = Pattern.compile(regEx);
////			 
////			    String methodname=method.substring(0, method.indexOf("(")); 
////			    String methodparam=method.substring(method.indexOf("(")+1, method.indexOf(")")); 
////			    String[] words = methodparam.split("(?<!^)(?=[A-Z])");
////			    Matcher matcher = pattern.matcher(methodparam);
////			    while (matcher.find()) {
////			    	 System.out.println("Found "+matcher.groupCount());
////			    	 method=method.replaceAll("\\(Z\\)", "(boolean)"); 
////			    	 method=method.replaceAll("\\(B\\)", "(byte)"); 
////			    	 method=method.replaceAll("\\(I\\)", "(int)"); 
////			    	 method=method.replaceAll("\\(J\\)", "(long)"); 
////			    	 method=method.replaceAll("\\(S\\)", "(short)"); 
////			  
////			    	 method=method.replaceAll("BLde", "boolean,de");
////			    	 
////			    	 method=method.replaceAll("Z,", "boolean,"); 
////			    	 method=method.replaceAll("B,", "byte,"); 
////			    	 method=method.replaceAll("I,", "int,"); 
////			    	 method=method.replaceAll("J,", "long,"); 
////			    	 method=method.replaceAll("S,", "short,"); 
////			    	 
////			    	 method=method.replaceAll("\\(Z", "(boolean,"); 
////			    	 method=method.replaceAll("\\(B", "(byte,"); 
////			    	 method=method.replaceAll("\\(I", "(int,"); 
////			    	 method=method.replaceAll("\\(J", "(long,"); 
////			    	 method=method.replaceAll("\\(S", "(short,");
////			    	 
////			    	 method=method.replaceAll("II", "int,int"); 
////			    	 method=method.replaceAll("IZ", "int,boolean"); 
////			    	 
////			    	 
////			    	 method=method.replaceAll("Z\\)", ",boolean)"); 
////			    	 method=method.replaceAll("B\\)", ",byte)"); 
////			    	 method=method.replaceAll("I\\)", ",int)"); 
////			    	 method=method.replaceAll("J\\)", ",long)"); 
////			    	 method=method.replaceAll("S\\)", ",short)"); 
////			    	 
////			    	 method=method.replaceAll(",Z", ",boolean"); 
////			    	 method=method.replaceAll(",B", ",byte"); 
////			    	 method=method.replaceAll(",I", ",int"); 
////			    	 method=method.replaceAll(",J", ",long"); 
////			    	 method=method.replaceAll(",S", ",short"); 
////			    	
////			    }
////			    method=method.replaceAll("ILnet", "int,net"); 
////			    method=method.replaceAll("Lnet", "net"); 
////			    method=method.replaceAll("Lorg", "org"); 
////			    method=method.replaceAll("Ljava", "java"); 
////			    method=method.replaceAll("Lde", "de");
////			    method=method.replaceAll("Lantlr", "antlr");
////			    method=method.replaceAll("ZI", "boolean,int");
////			    method=method.replaceAll("I", "int");
////			    method=method.replaceAll(",,", ","); 
//			  //  method=methodname+"("+methodparam+")"; 
//			    
//			    
////			     regEx = "\\(([A-Z])\\)";
////			     pattern = Pattern.compile(regEx);
////			     matcher = pattern.matcher(method);
////			    while (matcher.find()) {
////			    	method=method.replaceAll("Z", "boolean"); 
////				 method=method.replaceAll("B", "byte"); 
////		    	 method=method.replaceAll("I", "int"); 
////		    	 method=method.replaceAll("J", "long"); 
////		    	 method=method.replaceAll("S", "short"); 
////			    }
////			    method=method.substring(0, method.indexOf(")")+1); 
////			  String[] parts = method.split("[$]", 2);
////			  method=parts[0]; 
//			  method=method.replaceAll("clinit", "init"); 
//		//	shortmethod=ParseLine(line); 
//			System.out.println("HERE IS THIS SHORT METHOD========>"+ method+ "COUNTER");
//			  System.out.println("BEFORE METH========>"+ method); 
//
//			  method=RewriteFullMethodCallExecutedRemoveDollarsTraces(method);
//			  method=RewriteFullMethod(method);
//			  method=method.substring(0, method.indexOf(")")+1);
//				method=method.replaceAll("Lde", "de");
//				method=method.replaceAll("Ljava", "java");
//				method=method.replaceAll(",\\)", ")");
//				System.out.println("FULLLLLLLL MEEEEEEEETH========>"+ method); 
//			  
//			  System.out.println("FINAL METH========>"+ method); 
//			
//			methodid=null; 
//			String myclass= method.substring(0, method.lastIndexOf(".")); 
//			method=method.substring(0, method.indexOf(")")+1);
//
//			if(method.contains(",)")) {
//				method=method.replaceAll(",\\)", ")");
//			}
//			
////			 shortmethod=ParseLine(line); 
//			 
//			System.out.println("HERE IS THIS SHORT METHOD========>"+ method+ "COUNTER222: "+counter2); 
////			method=method.replaceAll("Lnet", "net");
//	 String goldvalue=null; 
//	 String subjectvalue=null; 
//		
//	method=method.replaceAll("bytede", "byte,de"); 
//	method=method.replaceAll("booleanI", "boolean,int"); 
//	method=method.replaceAll("intshort", "int,short"); 
//
////	classname=null; 
////	ResultSet classnames = st.executeQuery("SELECT methods.classname from methods where methods.methodabbreviation ='"+shortmethod+"'"); 
////	while(classnames.next()){
////		classname = classnames.getString("classname"); 
////		   }
////	classid=null; 
////	ResultSet classids = st.executeQuery("SELECT methods.classid from methods where methods.methodabbreviation ='"+shortmethod+"'"); 
////	while(classids.next()){
////		classid = classids.getString("classid"); 
////		   }
//	
//	
//	classname=null;
//	classid =null; 
//	method=method.trim();
//	ResultSet classnames = st.executeQuery("SELECT methods.* from methods where methods.fullmethod ='"+method+"'"); 
//	while(classnames.next()){
//		classname = classnames.getString("classname"); 
//		classid = classnames.getString("classid"); 
//		   }
//	
////	String interfacename=null; 
////	String interfaceid=null; 
////	ResultSet interfaces = st.executeQuery("SELECT interfaces.* from interfaces where interfaces.classname LIKE'%"+classname+"%'");
////	while(interfaces.next()){
////		List<String> myinterface = new ArrayList<String>(); 
////		interfacename = interfaces.getString("interfacename"); 
////		interfaceid = interfaces.getString("interfaceclassid"); 
////		myinterface.add(interfaceid); 
////		myinterface.add(interfacename); 
////		myinterfacesList.add(myinterface); 
////		   }
//	String interfacename=null; 
//	String interfaceid=null; 
//		ResultSet interfaces = st.executeQuery("SELECT interfaces.* from interfaces where interfaces.classname ='"+classname+"'"); 
//		while(interfaces.next()){
//			List<String> myinterface = new ArrayList<String>(); 
//			interfacename = interfaces.getString("interfacename");
//			interfaceid = interfaces.getString("interfaceclassid");
//			myinterface.add(interfaceid); 
//			myinterface.add(interfacename); 
//			myinterfacesList.add(myinterface); 
//			   }
//	
//	requirement=requirement.trim(); 
//	requirementid=null; 
//	ResultSet requirements = st.executeQuery("SELECT requirements.id from requirements where requirements.requirementname LIKE'%"+requirement+"%'"); 
//	while(requirements.next()){
//		requirementid = requirements.getString("id"); 
//		   }	
//	
//
//	goldvalue=null; 
//	List<String> goldvaluesList= new ArrayList<String>();
//	ResultSet goldvalues = st.executeQuery("SELECT traces.gold from traces where traces.requirementid ='"+requirementid+"' and traces.classid='"+classid+"'"); 
//	 while(goldvalues.next()){
//			goldvalue = goldvalues.getString("gold"); 
//
//		    goldvalue=goldvalue.trim();
//			goldvaluesList.add(goldvalue);
//			   }
//	 
//	 subjectvalue=null; 
//	 List<String> subjectvaluesList= new ArrayList<String>();
//		ResultSet subjectvalues = st.executeQuery("SELECT traces.subject from traces where traces.requirementid ='"+requirementid+"' and traces.classid='"+classid+"'"); 
//		while(subjectvalues.next()){
//			subjectvalue = subjectvalues.getString("subject"); 
//
//			subjectvalue=subjectvalue.trim();
//			subjectvaluesList.add(subjectvalue);
//			   }
//		String ReqClass=requirementid+"-"+classid;
//		if(requirementid!=null && classid!=null && RequirementClassHashMap.containsKey(ReqClass)==false) {
//			
//	 //1 TT
//			
//		if(goldvaluesList.contains("T") && subjectvaluesList.contains("T")) {
//			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"T" +"','" +"T"+"')";	
//			RequirementClassHashMap.put(ReqClass, "TT");
//			st.executeUpdate(statement8);
//
//	 }
//	 //2 ET
//	 else if(goldvaluesList.contains("E") && subjectvaluesList.contains("T")) {
//			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"E" +"','" +"T"+"')";	
//			RequirementClassHashMap.put(ReqClass, "ET");
//
//			st.executeUpdate(statement8);
//
//	 }
//	 //3 TE
//	 else if(goldvaluesList.contains("T") && subjectvaluesList.contains("E")) {
//			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"T" +"','" +"E"+"')";	
//			RequirementClassHashMap.put(ReqClass, "TE");
//
//			st.executeUpdate(statement8);
//
//	 }
//	 //4 NN
//	 else if((goldvaluesList.contains("T")==false && goldvaluesList.contains("E")==false )&& (subjectvaluesList.contains("T")==false && subjectvaluesList.contains("E")==false )) {
//			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"N" +"','" +"N"+"')";	
//			RequirementClassHashMap.put(ReqClass, "NN");
//
//			st.executeUpdate(statement8);
//
//	 }
//	 //5 NT
//	 else if((goldvaluesList.contains("T")==false && goldvaluesList.contains("E")==false )&& subjectvaluesList.contains("T")) {
//			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"N" +"','" +"T"+"')";	
//			RequirementClassHashMap.put(ReqClass, "NT");
//
//			st.executeUpdate(statement8);
//
//	 }
//	 //6 EN
//	 else if( goldvaluesList.contains("E") && (subjectvaluesList.contains("T")==false && subjectvaluesList.contains("E")==false )) {
//			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"E" +"','" +"N"+"')";	
//			RequirementClassHashMap.put(ReqClass, "EN");
//
//			st.executeUpdate(statement8);
//
//	 }
//		//7 NE
//	 else if( (goldvaluesList.contains("T")==false && goldvaluesList.contains("E")==false ) && (subjectvaluesList.contains("E") )) {
//			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"N" +"','" +"E"+"')";	
//			RequirementClassHashMap.put(ReqClass, "NE");
//
//			st.executeUpdate(statement8);
//
//	 }
//		 //8 TN
//	 else if(goldvaluesList.contains("T") && (subjectvaluesList.contains("T")==false && subjectvaluesList.contains("E")==false )) {
//			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"T" +"','" +"N"+"')";	
//			RequirementClassHashMap.put(ReqClass, "TN");
//
//			st.executeUpdate(statement8);
//
//	 }
//		 // 9 EE
//	 else if(goldvaluesList.contains("E") && subjectvaluesList.contains("E")) {
//			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"E" +"','" +"E"+"')";	
//			RequirementClassHashMap.put(ReqClass, "EE");
//
//			st.executeUpdate(statement8);
//
//	 }
//		}
////		for(List<String> myinterface: myinterfacesList) {
////			interfaceid=myinterface.get(0); 
////			interfacename= myinterface.get(1); 
////		
////		 ReqClass=requirementid+"-"+interfaceid;
////		//ADDING INTERFACES TO THE TRACES CLASSES TABLE 
////		if(interfaceid!=null && interfacename!=null && RequirementClassHashMap.containsKey(ReqClass)==false) {
////			
////			 //1 TT
////				if(goldvaluesList.contains("T") && subjectvaluesList.contains("T")) {
////					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"T" +"','" +"T"+"')";	
////					st.executeUpdate(statement8);
////					RequirementClassHashMap.put(ReqClass, "TT");
////
////			 }
////			 //2 ET
////			 else if(goldvaluesList.contains("E") && subjectvaluesList.contains("T")) {
////					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"E" +"','" +"T"+"')";	
////					st.executeUpdate(statement8);
////					RequirementClassHashMap.put(ReqClass, "ET");
////
////			 }
////			 //3 TE
////			 else if(goldvaluesList.contains("T") && subjectvaluesList.contains("E")) {
////					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"T" +"','" +"E"+"')";	
////					st.executeUpdate(statement8);
////					RequirementClassHashMap.put(ReqClass, "TE");
////
////			 }
////			 //4 NN
////			 else if((goldvaluesList.contains("T")==false && goldvaluesList.contains("E")==false )&& (subjectvaluesList.contains("T")==false && subjectvaluesList.contains("E")==false )) {
////					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"N" +"','" +"N"+"')";	
////					st.executeUpdate(statement8);
////					RequirementClassHashMap.put(ReqClass, "NN");
////
////
////			 }
////			 //5 NT
////			 else if((goldvaluesList.contains("T")==false && goldvaluesList.contains("E")==false )&& subjectvaluesList.contains("T")) {
////					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"N" +"','" +"T"+"')";	
////					st.executeUpdate(statement8);
////					RequirementClassHashMap.put(ReqClass, "NT");
////
////			 }
////			 //6 EN
////			 else if( goldvaluesList.contains("E") && (subjectvaluesList.contains("T")==false && subjectvaluesList.contains("E")==false )) {
////					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"E" +"','" +"N"+"')";	
////					st.executeUpdate(statement8);
////					RequirementClassHashMap.put(ReqClass, "EN");
////
////			 }
////				//7 NE
////			 else if( (goldvaluesList.contains("T")==false && goldvaluesList.contains("E")==false ) && (subjectvaluesList.contains("E") )) {
////					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"N" +"','" +"E"+"')";	
////					st.executeUpdate(statement8);
////					RequirementClassHashMap.put(ReqClass, "NE");
////
////			 }
////				 //8 TN
////			 else if(goldvaluesList.contains("T") && (subjectvaluesList.contains("T")==false && subjectvaluesList.contains("E")==false )) {
////					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"T" +"','" +"N"+"')";	
////					st.executeUpdate(statement8);
////					RequirementClassHashMap.put(ReqClass, "TN");
////			 }			
////
////				 // 9 EE
////			 else if(goldvaluesList.contains("E") && subjectvaluesList.contains("E")) {
////					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"E" +"','" +"E"+"')";	
////					st.executeUpdate(statement8);
////					RequirementClassHashMap.put(ReqClass, "EE");
////			 }
////				
////		
////		}
////	 
////	
////		}
//	
//
//		
//	
//counter2++; 
//
//
//		}
//	
//	
//	
//	
//	}
//	catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	}
	private String WriteMethodIntoDatabase(CtMethod<?> constructor) {
		// TODO Auto-generated method stub
		List<CtComment> CommentList = constructor.getElements(new TypeFilter<CtComment>(CtComment.class));
    	List<CtComment> NewCommentList= CommentList; 
    	NewCommentList = constructor.getElements(new TypeFilter<CtComment>(CtComment.class));
    	int size=NewCommentList.size(); 
    	System.out.println(constructor);
    	int  j=0; 
    	if(CommentList!=null) {
    		CtMethod newmethod=constructor; 
    		
    		
    		while(j<size) {
    			
    			CtComment newcomment = NewCommentList.get(j); 
    			newmethod=newmethod.removeComment(newcomment); 
    			 size=NewCommentList.size(); 
    			 j++; 
    		}
    		
    		constructor=newmethod; 
    	}
    	 String methodString = constructor.toString().replaceAll("\\/\\/.*", ""); 
    	 methodString = methodString.toString().replaceAll("\'", ""); 
	 	
		String FullConstructorName=constructor.getSignature().toString(); 
		
		
		return methodString; 
	}

	public String WriteConstructorIntoDatabase(CtConstructor constructor) {
		// TODO Auto-generated method stub
		 List<CtComment> CommentList = constructor.getElements(new TypeFilter<CtComment>(CtComment.class));
	    	List<CtComment> NewCommentList= CommentList; 
	    	NewCommentList = constructor.getElements(new TypeFilter<CtComment>(CtComment.class));
	    	int size=NewCommentList.size(); 
	    	System.out.println(constructor);
	    	int  j=0; 
	    	if(CommentList!=null) {
	    		CtConstructor newmethod=constructor; 
	    		
	    		
	    		while(j<size) {
	    			
	    			CtComment newcomment = NewCommentList.get(j); 
	    			newmethod=newmethod.removeComment(newcomment); 
	    			 size=NewCommentList.size(); 
	    			 j++; 
	    		}
	    		
	    		constructor=newmethod; 
	    	}
	    	 String methodString = constructor.toString().replaceAll("\\/\\/.*", ""); 
	    	 methodString = methodString.toString().replaceAll("\'", ""); 
		 	
			String FullConstructorName=constructor.getSignature().toString(); 
			
			
			return methodString; 
	}

	private String GetMethodNameAndParams(String method) {
		// TODO Auto-generated method stub
		System.out.println("METH BEFORE TRUNCATION"+method);
		String params=method.substring(method.indexOf("("), method.length()); 
		String BeforeParams=method.substring(0, method.indexOf("(")); 
		String methname=BeforeParams.substring(BeforeParams.lastIndexOf(".")+1, BeforeParams.length()); 
		String res= methname+params; 
		System.out.println("RES"+ res);
		return res;
	}

	
	
	
	
	public static String RewriteFullMethodCallExecutedRemoveDollarsTraces(String input) {
		
		String res=input; 
		StringBuilder buf = new StringBuilder();
		


			boolean flag=false; 
			char[] chars = res.toCharArray();
			int r = 0; 
			int pos=0; 
			
			int myindex= input.indexOf("$"); 
			char c= chars[myindex+1]; 
			if((Character.isDigit(c) && myindex+2==chars.length) || (Character.isDigit(c) && chars[myindex+2]=='(')) {
				System.out.println("yeah");
				while(r<chars.length) {
					if(chars[r]=='$' ) {
					 pos=r; 
					// temp = chars[r+1]; 
					StringBuilder sb = new StringBuilder();
					sb.append(chars);
					sb.deleteCharAt(r);
					chars = sb.toString().toCharArray();
					flag=true; 
					}
					int i=1; 
					if(pos>0) {
						while( flag==true) {
							if(chars[pos-1]!='.'&& chars[pos-1]!='('&& chars[pos-1]!=')' && pos-1<chars.length ) {
								System.out.println(chars[r]);
								StringBuilder sb = new StringBuilder();
								sb.append(chars);
								sb.deleteCharAt(pos);
								chars = sb.toString().toCharArray();
								pos++; 
								//r++; 
								if(pos>chars.length) {
									flag=false; 
								}
								if(chars[pos-1]=='(') {
									flag=false; 
								}
							}
						

							}
					}

					
						r++; 
					
					

					}
				
			}
			else if(Character.isDigit(c)) {
				while(r<chars.length) {
					if(chars[r]=='$' ) {
					 pos=r; 
					// temp = chars[r+1]; 
					StringBuilder sb = new StringBuilder();
					sb.append(chars);
					sb.deleteCharAt(r);
					chars = sb.toString().toCharArray();
					flag=true; 
					}
					int i=1; 
					if(pos>0) {
						while( flag==true) {
							if(chars[pos-1]!='.'&& chars[pos-1]!='('&& chars[pos-1]!=')' && pos-1<chars.length ) {
								System.out.println(chars[r]);
								StringBuilder sb = new StringBuilder();
								sb.append(chars);
								sb.deleteCharAt(pos);
								chars = sb.toString().toCharArray();
								pos++; 
								//r++; 
								if(chars[pos-1]=='.') {
									flag=false; 
								}
							}
						

							}
					}

					
						r++; 
					
					

					}
			}
			else {
				
				while(r<chars.length) {
					if(chars[r]=='$' ) {
					 pos=r; 
					// temp = chars[r+1]; 
					StringBuilder sb = new StringBuilder();
					sb.append(chars);
					sb.deleteCharAt(r);
					chars = sb.toString().toCharArray();
					flag=true; 
					}
					int i=1; 
					if(pos>0) {
						while(chars[pos-1]!='.'&& chars[pos-1]!='('&& chars[pos-1]!=')' && pos<chars.length && flag==true) {
							pos=r-i; 
							System.out.println(chars[r]);
							StringBuilder sb = new StringBuilder();
							sb.append(chars);
							sb.deleteCharAt(pos);
							chars = sb.toString().toCharArray();
					i++; 
							//r++; 

							}
					}

					
						r++; 
					
					

					}
			}
			

			res = String.valueOf(chars);
			System.out.println(res);
			return res; 
		}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public static String RewriteFullMethodCallExecutedRemoveDollars(String input) {
		
		String res=input; 
		StringBuilder buf = new StringBuilder();
		


			boolean flag=false; 
			char[] chars = res.toCharArray();
			int r = 0; 
			int pos=0; 
			
			int myindex= input.indexOf("$"); 
			char c= chars[myindex+1]; 
			if(Character.isDigit(c) && myindex+2==chars.length) {
				System.out.println("yeah");
				while(r<chars.length) {
					if(chars[r]=='$' ) {
					 pos=r; 
					// temp = chars[r+1]; 
					StringBuilder sb = new StringBuilder();
					sb.append(chars);
					sb.deleteCharAt(r);
					chars = sb.toString().toCharArray();
					flag=true; 
					}
					int i=1; 
					if(pos>0) {
						while( flag==true) {
							if(chars[pos-1]!='.'&& chars[pos-1]!='('&& chars[pos-1]!=')' && pos-1<chars.length ) {
								System.out.println(chars[r]);
								StringBuilder sb = new StringBuilder();
								sb.append(chars);
								sb.deleteCharAt(pos);
								chars = sb.toString().toCharArray();
								pos++; 
								//r++; 
								if(pos>chars.length) {
									flag=false; 
								}
							}
						

							}
					}

					
						r++; 
					
					

					}
				
			}
			else if(Character.isDigit(c)) {
				while(r<chars.length) {
					if(chars[r]=='$' ) {
					 pos=r; 
					// temp = chars[r+1]; 
					StringBuilder sb = new StringBuilder();
					sb.append(chars);
					sb.deleteCharAt(r);
					chars = sb.toString().toCharArray();
					flag=true; 
					}
					int i=1; 
					if(pos>0) {
						while( flag==true) {
							if(chars[pos-1]!='.'&& chars[pos-1]!='('&& chars[pos-1]!=')' && pos-1<chars.length ) {
								System.out.println(chars[r]);
								StringBuilder sb = new StringBuilder();
								sb.append(chars);
								sb.deleteCharAt(pos);
								chars = sb.toString().toCharArray();
								pos++; 
								//r++; 
								if(chars[pos-1]=='.') {
									flag=false; 
								}
							}
						

							}
					}

					
						r++; 
					
					

					}
			}
			else {
				
				while(r<chars.length) {
					if(chars[r]=='$' ) {
					 pos=r; 
					// temp = chars[r+1]; 
					StringBuilder sb = new StringBuilder();
					sb.append(chars);
					sb.deleteCharAt(r);
					chars = sb.toString().toCharArray();
					flag=true; 
					}
					int i=1; 
					if(pos>0) {
						while(chars[pos-1]!='.'&& chars[pos-1]!='('&& chars[pos-1]!=')' && pos<chars.length && flag==true) {
							pos=r-i; 
							System.out.println(chars[r]);
							StringBuilder sb = new StringBuilder();
							sb.append(chars);
							sb.deleteCharAt(pos);
							chars = sb.toString().toCharArray();
					i++; 
							//r++; 

							}
					}

					
						r++; 
					
					

					}
			}
			

			res = String.valueOf(chars);
			System.out.println(res);
			return res; 
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
public String RewriteFullMethod(String input) {
	

	StringBuilder buf = new StringBuilder();
	String params= input.substring(input.indexOf("("), input.indexOf(")")+1); 
	String methname= input.substring(0, input.indexOf("(") );
	int i=0; 

	while(i<params.length()-1) {

	if(((params.charAt(i)=='L'|| params.charAt(i)=='Z'||params.charAt(i)=='B'||params.charAt(i)=='I'||params.charAt(i)=='J'||params.charAt(i)=='S'||params.charAt(i)=='C')
	&& ((params.charAt(i+1)=='L'|| params.charAt(i+1)=='Z'||params.charAt(i+1)=='B'||params.charAt(i+1)=='I'||params.charAt(i+1)=='J'||params.charAt(i+1)=='S'||params.charAt(i+1)=='C')||
	params.charAt(i+1)==')') && params.charAt(i-1)!='.') ||

	((params.charAt(i)=='L'|| params.charAt(i)=='Z'||params.charAt(i)=='B'||params.charAt(i)=='I'||params.charAt(i)=='J'||params.charAt(i)=='S'||params.charAt(i)=='C')
	&& ((params.charAt(i+2)=='L'|| params.charAt(i+2)=='Z'||params.charAt(i+2)=='B'||params.charAt(i+2)=='I'||params.charAt(i+2)=='J'||params.charAt(i+2)=='S'||params.charAt(i+2)=='C')||
	params.charAt(i+1)==')') && params.charAt(i-1)!='.' ) ||

	(params.charAt(i)=='[' && params.charAt(i-1)==',')||
	(params.charAt(i)=='L'|| params.charAt(i)=='Z'||params.charAt(i)=='B'||params.charAt(i)=='I'||params.charAt(i)=='J'||params.charAt(i)=='S'||params.charAt(i)=='C')
	&& ((params.charAt(i-1)=='['))) {


	if(params.charAt(i+1)=='C') {
	String params1 = params.substring(0, i); 
	String params2 = params.substring(i+2, params.length()); 
	params=params1+",char,"+params2; 
	}	

	if(params.charAt(i+1)=='S') {
	String params1 = params.substring(0, i); 
	String params2 = params.substring(i+2, params.length()); 
	params=params1+",short,"+params2; 
	}
	if(params.charAt(i+1)=='V') {
	String params1 = params.substring(0, i+1); 
	String params2 = params.substring(i+2, params.length()); 
	params=params1+",void,"+params2; 
	}
	if(params.charAt(i+1)=='Z') {
	String params1 = params.substring(0, i+1); 
	String params2 = params.substring(i+2, params.length()); 
	params=params1+",boolean,"+params2; 
	}
	if(params.charAt(i+1)=='J') {
	String params1 = params.substring(0, i+1); 
	String params2 = params.substring(i+2, params.length()); 
	params=params1+",long,"+params2; 
	}
	if(params.charAt(i+1)=='B') {
	String params1 = params.substring(0, i+1); 
	String params2 = params.substring(i+2, params.length()); 
	params=params1+",byte,"+params2; 
	}


	if(params.charAt(i+1)=='I') {
	String params1 = params.substring(0, i+1); 
	String params2 = params.substring(i+2, params.length()); 
	params=params1+",int,"+params2; 
	}






	if(params.charAt(i)=='S') {
	if(i==1) {
	String params1 = params.substring(0, 1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+"short,"+params2; 
	}
	else {
	if(params.charAt(i-1)=='[') {

	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i-1, i); 
	String params3 = params.substring(i+2, params.length()); 
	params=params1+","+params2+"short,"+params3; 	
	}
	else {
	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+",short,"+params2; 	
	}

	}
	}
	if(params.charAt(i)=='C') {
	if(i==1) {
	String params1 = params.substring(0, 1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+"char,"+params2; 
	}

	else {
	if(params.charAt(i-1)=='[') {

	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i-1, i); 
	String params3 = params.substring(i+1, params.length()); 
	params=params1+","+params2+"char,"+params3; 	
	}
	else{
	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+",char,"+params2; 	
	}

	}
	}
	if(params.charAt(i)=='V') {
	if(i==1) {
	String params1 = params.substring(0, 1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+"void,"+params2; 
	}
	else {
	if(params.charAt(i-1)=='[') {

	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i-1, i); 
	String params3 = params.substring(i+2, params.length()); 
	params=params1+","+params2+"void,"+params3; 	
	}else{
	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+",void,"+params2; 	
	}

	}
	}
	if(params.charAt(i)=='Z') {
	if(i==1) {
	String params1 = params.substring(0, 1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+"boolean,"+params2; 
	}
	else{
	if(params.charAt(i-1)=='[') {

	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i-1, i); 
	String params3 = params.substring(i+2, params.length()); 
	params=params1+","+params2+"boolean,"+params3; 	
	}else{
	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+",boolean,"+params2; 	
	}
	}

	}
	if(params.charAt(i)=='J') {
	if(i==1) {
	String params1 = params.substring(0, 1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+"long,"+params2; 
	}
	else {
	if(params.charAt(i-1)=='[') {

	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i-1, i); 
	String params3 = params.substring(i+2, params.length()); 
	params=params1+","+params2+"long,"+params3; 	
	}else{
	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+",long,"+params2; 	
	}
	}

	}
	if(params.charAt(i)=='B') {
	if(i==1) {
	String params1 = params.substring(0, 1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+"byte,"+params2; 
	}
	else{
	if(params.charAt(i-1)=='[') {

	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i-1, i); 
	String params3 = params.substring(i+2, params.length()); 
	params=params1+","+params2+"byte"+params3; 	
	}else{
	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+",byte,"+params2; 	
	}
	}

	}
	if(params.charAt(i)=='I') {
	if(i==1) {
	String params1 = params.substring(0, 1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+"int,"+params2; 
	}
	else{
	if(params.charAt(i-1)=='[') {

	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i-1, i); 
	String params3 = params.substring(i+1, params.length()); 
	params=params1+","+params2+"int,"+params3; 	
	}else{
	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+",int,"+params2; 	
	}
	}
	}

	System.out.println(params.charAt(i)); 
	if(params.charAt(i-1)=='[') {
		if(i==1) {
		String params1 = params.substring(0, 1); 
		String params2 = params.substring(i+1, params.length()); 
		params=params1+","+params2; 
		}
		else{
		if(params.charAt(i-2)==',') {
			String[] parts = params.split(",");
			String AppendedParts=""; 
			for(String part: parts) {
				if(part.charAt(0)=='[') {
					part=part.substring(1, part.length()); 
					part=part+"[]"; 
				}
				AppendedParts=AppendedParts+part+","; 
				params=AppendedParts; 
			}
//		String params1 = params.substring(0, i-1); 
//		String params2 = params.substring(i-1, i); 
//		String params3 = params.substring(i+1, params.length()); 
//		params=params1+","+params2+","+params3; 	
		}else{
		String params1 = params.substring(0, i-1); 
		String params2 = params.substring(i+1, params.length()); 
		params=params1+",,"+params2; 	
		}
		}
		}


	if(params.charAt(i+1)==')' && params.charAt(i)=='I') {
	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+",int,"+params2; 
	}
	if(params.charAt(i+1)==')' && params.charAt(i)=='S') {
	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+",short,"+params2; 
	}
	if(params.charAt(i+1)==')' && params.charAt(i)=='J') {
	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+",long,"+params2; 
	}
	if(params.charAt(i+1)==')' && params.charAt(i)=='B') {
	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+",byte,"+params2; 
	}
	if(params.charAt(i+1)==')' && params.charAt(i)=='Z') {
	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+",boolean,"+params2; 
	}
	if(params.charAt(i+1)==')' && params.charAt(i)=='V') {
	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+",void,"+params2; 
	}
	if(params.charAt(i+1)==')' && params.charAt(i)=='C') {
	String params1 = params.substring(0, i-1); 
	String params2 = params.substring(i+1, params.length()); 
	params=params1+",char,"+params2; 
	}
	}
	i++; 
	}
	String res= methname+params; 

	//System.out.println(res);
	res=res.replaceAll("\\(,", "\\("); 
	res=res.replaceAll(",\\)", "\\)"); 
	res=res.replaceAll(",,", ","); 
	res=res.replaceAll(";", ","); 
	res=res.replaceAll(",,", ","); 
	res=res.replaceAll(",\\[,", ",\\["); 
	res=res.replaceAll(",\\)", "\\)"); 
	//res=res.replaceAll("Ljava", "java"); 
	//System.out.println("here  "+res);



	boolean flag=false; 
	char[] chars = res.toCharArray();
	int r=0; 
	int pos=10000000; 
	char temp='\0'; 
	while(r<chars.length) {
	if(chars[r]=='[' ) {
	pos=r; 
	// temp = chars[r+1]; 
	StringBuilder sb = new StringBuilder();
	sb.append(chars);
	sb.deleteCharAt(r);
	chars = sb.toString().toCharArray();
	flag=true; 
	}
	if(flag==true) {
	pos=r; 
	// temp = chars[r+1]; 
	if(chars[r]==',' ) {
	StringBuilder sb = new StringBuilder();
	sb.append(chars);
	sb.deleteCharAt(r);

	sb.insert(r, "[],");
	chars = sb.toString().toCharArray();
	flag=false; 	 
	}
	else if(chars[r]==')' ) {
	StringBuilder sb = new StringBuilder();
	sb.append(chars);
	sb.deleteCharAt(r);
	sb.insert(r, "[])");
	chars = sb.toString().toCharArray();
	flag=false; 	 
	}


	}

	r++; 
	}


	flag=false; 
	chars = res.toCharArray();
	r=0; 


	while(r<chars.length) {
	if(chars[r]=='$' ) {
	pos=r; 
	// temp = chars[r+1]; 
	StringBuilder sb = new StringBuilder();
	sb.append(chars);
	sb.deleteCharAt(r);
	chars = sb.toString().toCharArray();
	flag=true; 
	}
	while(chars[r]!='.'&& chars[r]!='('&& chars[r]!=')'&& flag==true) {
	System.out.println(chars[r]);
	StringBuilder sb = new StringBuilder();
	sb.append(chars);
	sb.deleteCharAt(r);
	chars = sb.toString().toCharArray();

	//r++; 

	}
	flag=false; 

	r++; 

	}
	res = String.valueOf(chars);
	System.out.println("final res : "+res);
	return res;
	

	
	
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

public String KeepOnlyMethodName(String constructor) {
	String params= constructor.substring(constructor.indexOf("("), constructor.length()); 
	constructor=constructor.substring(0, constructor.indexOf("(")); 
	constructor=constructor.substring(constructor.lastIndexOf(".")+1, constructor.length()); 
	constructor=constructor+params; 

return constructor; 
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

public String TransformConstructorIntoInit(String constructor) {
	String params= constructor.substring(constructor.indexOf("("), constructor.length()); 
	constructor= constructor.substring(0, constructor.indexOf("(")); 
	
	//String part2= constructor.substring(constructor.indexOf("("), constructor.length()); 
	constructor=constructor+".-init-"+params; 
	
	return constructor; 
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

public String RemoveDollarConstructor(String text) {

	
	
	String res=""; 
	
	boolean  flag=false; 
	char[] chars = text.toCharArray();
	 int r = 0; 
	 int pos = text.indexOf("$"); 
	//System.out.println("HERE IS THE TEXT "+text);
	 int count = StringUtils.countMatches("text", "$");
if(count==1) {
	if(text.contains("$")) {
		if(chars.length-pos>7 && chars[pos+2]!='(') {
			
		
		while(r<chars.length ) {
			if(chars[r]=='$' ) {
				// pos = r; 
				// temp = chars[r+1]; 
				StringBuilder sb = new StringBuilder();
				sb.append(chars);
				sb.deleteCharAt(r);
				chars = sb.toString().toCharArray();
				flag=true; 
				 pos--; 
				
				
			}
			
			 while( flag==true ) {
				 if(chars[pos]!='.'&& chars[pos]!='('&& chars[pos]!=')') {
					 r--; 
					 pos--; 
				//	 System.out.println(chars[r]);
					 StringBuilder sb = new StringBuilder();
					 sb.append(chars);
					
					 sb.deleteCharAt(r);
				//	 System.out.println(sb);
					 chars = sb.toString().toCharArray();
					 int length=chars.length; 
//					 if(r==length) {
//						 flag=false; 
//					 }
					
					
				 }
				 else {
					 flag=false; 
				 }
				
				 //r++; 
				 
			 }
			flag=false; 
			 if(flag==true) {
				 r--; 
			 }else {
				 r++;  
			 }
			 
			
		}
		 res = String.valueOf(chars);
	}else {
		String part2=""; 
		String part1=""; 
		 res = String.valueOf(chars);
		  part1=res.substring(0,res.indexOf("$")); 
		 if(res.contains("(")) {
			  part2=res.substring(res.indexOf("("),res.length()); 
		 }
		res=part1+part2; 
	}
		
	}

	
}else if(count==2) {
	String methodname=text.substring(0, text.indexOf("(")); 
	String parameters=text.substring(text.indexOf("("), text.length()); 
	
	methodname=methodname.substring(0, methodname.lastIndexOf("$")); 
	String part1meth=methodname.substring(0, methodname.lastIndexOf(".")); 
	String part2meth=methodname.substring(methodname.indexOf("$"), methodname.length()); 
	res=part1meth+part2meth+parameters; 
}
	//System.out.println("RES====>"+res);
else {
	res=text; 
}

	
	return res; 


}



	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public String RemoveDollar(String text) {	
		
		boolean  flag=false; 
	char[] chars = text.toCharArray();
	 int r = 0; 
	 int pos = text.indexOf("$"); 
//	System.out.println("HERE IS THE TEXT "+text);
	if(text.contains("$")) {
		while(r<chars.length) {
			if(chars[r]=='$' ) {
				// pos = r; 
				// temp = chars[r+1]; 
				StringBuilder sb = new StringBuilder();
				sb.append(chars);
				sb.deleteCharAt(r);
				chars = sb.toString().toCharArray();
				flag=true; 
				 pos--; 
				
				
			}
			
			 while( flag==true ) {
				 if(chars[pos]!='.'&& chars[pos]!='('&& chars[pos]!=')') {
					 r--; 
					 pos--; 
				//	 System.out.println(chars[r]);
					 StringBuilder sb = new StringBuilder();
					 sb.append(chars);
					
					 sb.deleteCharAt(r);
				//	 System.out.println(sb);
					 chars = sb.toString().toCharArray();
					 int length=chars.length; 
//					 if(r==length) {
//						 flag=false; 
//					 }
					
					
				 }
				 else {
					 flag=false; 
				 }
				
				 //r++; 
				 
			 }
			flag=false; 
			 if(flag==true) {
				 r--; 
			 }else {
				 r++;  
			 }
			 
			
		}
		
	}
	String res = String.valueOf(chars);
//	System.out.println("RES====>"+res);
	return res; 
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public String ParseLine(String line) {
		System.out.println(line);
		String[] linesplitted = line.split(","); 
		String method = linesplitted[1]; 
		String requirement = linesplitted[2]; 
		String gold = linesplitted[4]; 
		String subject = linesplitted[5]; 
		System.out.println("HERE IS THIS SHORT METHOD========>"+ method); 
		
		String shortmethod=method.substring(0, method.indexOf("("));
		String regex = "(.)*(\\d)(.)*";      
		Pattern pattern = Pattern.compile(regex);
		boolean containsNumber = pattern.matcher(shortmethod).matches();
		String[] firstpart;
		String FinalMethod = null;
		shortmethod=shortmethod.replaceAll("clinit", "init"); 
		if(shortmethod.contains("$") && shortmethod.matches(".*\\d+.*")) {
			 firstpart = shortmethod.split("\\$");
			String myfirstpart= firstpart[0]; 
			FinalMethod=myfirstpart; 
			if(StringUtils.isNumeric(firstpart[1])==false) {
				String[] secondpart = firstpart[1].split("\\d"); 
				System.out.println("my first part "+ myfirstpart+ "firstpart"+ firstpart[1]);
				
				String mysecondpart=secondpart[1]; 
				
				 FinalMethod=myfirstpart+mysecondpart; 
				System.out.println("FINAL RESULT:    "+FinalMethod);
			}
			
		}
		
		else if(shortmethod.contains("$") && containsNumber==false) {
			 firstpart = shortmethod.split("\\$");
			
			System.out.println("FINAL STRING:   "+firstpart[0]);
			firstpart[1]=firstpart[1].substring(firstpart[1].indexOf("."), firstpart[1].length()); 
			System.out.println("FINAL STRING:   "+firstpart[1]);
			 FinalMethod= firstpart[0]+firstpart[1]; 
			System.out.println("FINAL STRING:   "+FinalMethod);
		}
		else {
			FinalMethod=shortmethod; 
		}
		return FinalMethod; 
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public String transformstring(String s) {
		s=s.replace("/", "."); 
		s=s.replace(";", ","); 
		  int endIndex = s.lastIndexOf(",");
		    if (endIndex != -1)  
		    {
		    	s = s.substring(0, endIndex); // not forgot to put check if(endIndex != -1)
		    }
		s=s.replace("Lde", "de"); 
		s=s.replace("Ljava", "java"); 
		return s; 
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public String[] ExtractParams(String method) {
		String Paramlist=method.substring(method.indexOf("(")+1, method.indexOf(")")); 
		 String[] data = Paramlist.split(",");
		 return data; 
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
public String ExtractParams2(String method) {
String Paramlist=method.substring(method.indexOf("(")+1, method.indexOf(")")); 

return Paramlist; 
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
public List<tracesmethodscallees> GetList() {
			return TracesCalleesList; 
}
}
