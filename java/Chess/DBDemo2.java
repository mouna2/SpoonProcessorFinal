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
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.pattern.FullLocationPatternConverter;
import org.codehaus.plexus.util.cli.Arg;
import org.eclipse.jdt.core.dom.FieldAccess;

import Tables.RequirementClassKey;
import Tables.fieldmethod;
import Tables.methodcalls;
import Tables.methodcallsexecuted;
import Tables.methods;
import Tables.tracesmethods;
import Tables.tracesmethodscallees;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtConstructorCall;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtFieldAccess;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtReturn;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtTargetedExpression;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.ClassFactory;
import spoon.reflect.factory.Factory;
import spoon.reflect.factory.MethodFactory;
import spoon.reflect.path.CtPath;
import spoon.reflect.reference.CtExecutableReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.Query;
import spoon.reflect.visitor.filter.ExecutableReferenceFilter;
import spoon.reflect.visitor.filter.FieldAccessFilter;
import spoon.reflect.visitor.filter.TypeFilter;

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
public class DBDemo2 {

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

	
	public DBDemo2(List<tracesmethodscallees> tracesCalleesList) {
		 TracesCalleesList= new ArrayList<tracesmethodscallees>();

	}

	public DBDemo2() {
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
			st.executeUpdate("DROP SCHEMA `databasechess`"); 
			
			st.executeUpdate("CREATE DATABASE `databasechess`"); 
			st.executeUpdate("CREATE TABLE `databasechess`.`classes` (\r\n" + 
					"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
					"  `classname` LONGTEXT NULL,\r\n" + 
					"  PRIMARY KEY (`id`),\r\n" + 
					"  UNIQUE INDEX `id_UNIQUE` (`id` ASC));"); 
			
			

		    
		   st.executeUpdate("CREATE TABLE `databasechess`.`superclasses` (\r\n" + 
		   		"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
		   		"  `superclassid` INT NULL,\r\n" + 
		   		"  `superclassname` LONGTEXT NULL,\r\n" + 
		   		"  `ownerclassid` INT NULL,\r\n" + 
		   		"  `childclassname` LONGTEXT NULL,\r\n" + 
		   		"  PRIMARY KEY (`id`),\r\n" + 
		   		"  INDEX `superclassid_idx` (`superclassid` ASC),\r\n" + 
		   		"  INDEX `ownerclassid_idx` (`ownerclassid` ASC),\r\n" + 
		   		"  CONSTRAINT `superclassid`\r\n" + 
		   		"    FOREIGN KEY (`superclassid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION,\r\n" + 
		   		"  CONSTRAINT `ownerclassid`\r\n" + 
		   		"    FOREIGN KEY (`ownerclassid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION);"); 
		   
		   st.executeUpdate("CREATE TABLE `databasechess`.`interfaces` (\r\n" + 
		   		"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 	   	
		   		"  `interfaceclassid` INT NULL,\r\n" + 
		   		"  `interfacename` LONGTEXT NULL,\r\n" + 
		   		"  `ownerclassid` INT NULL,\r\n" + 
		   		"  `classname` LONGTEXT NULL,\r\n" +	   		
		   		"  PRIMARY KEY (`id`),\r\n" + 
		   		"  UNIQUE INDEX `id_UNIQUE` (`id` ASC),\r\n" + 
		   		"  INDEX `interfaceclassid_idx` (`interfaceclassid` ASC),\r\n" + 
		   		"  INDEX `classid_idx` (`ownerclassid` ASC),\r\n" + 
		   		"  CONSTRAINT `interfaceclassid`\r\n" + 
		   		"    FOREIGN KEY (`interfaceclassid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION,\r\n" + 
		   		"  CONSTRAINT `ownerclassid2`\r\n" + 
		   		"    FOREIGN KEY (`ownerclassid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION);"); 
		   
		   st.executeUpdate("CREATE TABLE `databasechess`.`methods` (\r\n" + 
		   		"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
		   		"  `methodname` LONGTEXT NULL,\r\n" + 
		   		"  `methodnamerefined` LONGTEXT NULL,\r\n" + 
		   		"  `methodabbreviation` LONGTEXT NULL,\r\n" + 
		   		"  `fullmethod` LONGTEXT NULL,\r\n" + 
		   		"  `classid` INT NULL,\r\n" + 
		   		"  `classname` LONGTEXT NULL,\r\n" + 
		   		"  PRIMARY KEY (`id`),\r\n" + 
		   		"  UNIQUE INDEX `id_UNIQUE` (`id` ASC),\r\n" + 
		   		"  INDEX `classid_idx` (`classid` ASC),\r\n" + 
		   		"  CONSTRAINT `classid2`\r\n" + 
		   		"    FOREIGN KEY (`classid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION);"); 
		   st.executeUpdate("CREATE TABLE `databasechess`.`parameters` (\r\n" + 
		   		"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
		   		"  `parametername` VARCHAR(200) NULL,\r\n" + 
		   		"  `parametertype` VARCHAR(200) NULL,\r\n" + 
		   		"  `parameterclass` INT NULL,\r\n" + 
		   		"  `classid` INT NULL,\r\n" + 
		   		"  `classname` VARCHAR(200) NULL,\r\n" + 
		   		"  `methodid` INT NULL,\r\n" + 
		   		"  `methodname` VARCHAR(200) NULL,\r\n" + 
		   		"  `isreturn` TINYINT NOT NULL,\r\n"+
		   		"  PRIMARY KEY (`id`),\r\n" + 
		   		"  UNIQUE INDEX `id_UNIQUE` (`id` ASC),\r\n" + 
		   		"  INDEX `classid_idx` (`classid` ASC),\r\n" + 
		   		"  INDEX `methodid_idx` (`methodid` ASC),\r\n" + 
		   		"  CONSTRAINT cons UNIQUE (id, parametername, classid, classname, methodname), \r\n"+
		   		"  CONSTRAINT `classid8`\r\n" + 
		   		"    FOREIGN KEY (`classid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION,\r\n" + 
		   		"  CONSTRAINT `classid3`\r\n" + 
		   		"    FOREIGN KEY (`classid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION,\r\n" + 
		   		"  CONSTRAINT `methodid`\r\n" + 
		   		"    FOREIGN KEY (`methodid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`methods` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION"+   	
		   		 ")"); 
		   st.executeUpdate("CREATE TABLE `databasechess`.`fieldclasses` (\r\n" + 
		   		"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
		   		"  `fieldname` LONGTEXT NULL,\r\n" + 
		   		"  `fieldtypeclassid` INT NULL,\r\n" + 
		   		"  `fieldtype` LONGTEXT NULL,\r\n" + 
		   		"  `ownerclassid` INT NULL,\r\n" + 
		   		"  `classname` LONGTEXT NULL,\r\n" + 
		   		"  PRIMARY KEY (`id`),\r\n" + 
		   		"  INDEX `classid_idx` (`ownerclassid` ASC),\r\n" + 
		   		"  INDEX `classid_idx2` (`ownerclassid` ASC),\r\n" + 	
		   		"  CONSTRAINT `classid4`\r\n" + 
		   		"    FOREIGN KEY (`ownerclassid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION,"+ 
		   		"  CONSTRAINT `classid6`\r\n" + 
		   		"    FOREIGN KEY (`fieldtypeclassid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION);"); 
		   

		   
		   st.executeUpdate("CREATE TABLE `databasechess`.`fieldmethods` (\r\n" + 
		   		"  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n" + 
		   		"  `fieldaccess` VARCHAR(200) NULL,\r\n" + 
		   		"  `fieldtypeclassid` INT NULL,\r\n" + 
		   		"  `fieldtype` LONGTEXT NULL,\r\n" + 
		   		"  `classname` VARCHAR(200) NULL,\r\n" + 
		   		"  `ownerclassid` INT NULL,\r\n" + 
		   		"  `methodname` VARCHAR(200) NULL,\r\n" + 
		   		"  `ownermethodid` INT NULL,\r\n" + 
		   		"  PRIMARY KEY (`id`),\r\n" + 
		   		"  UNIQUE INDEX `id_UNIQUE` (`id` ASC),\r\n" + 
		   		"  INDEX `classid_idx` (`fieldtypeclassid` ASC),\r\n" + 
		   		"  INDEX `methodid_idx` (`ownermethodid` ASC),\r\n" + 		
		   		"  CONSTRAINT `classid5`\r\n" + 
		   		"    FOREIGN KEY (`fieldtypeclassid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION,\r\n" + 
		   		"  CONSTRAINT `classid7`\r\n" + 
		   		"    FOREIGN KEY (`fieldtypeclassid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`classes` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION,\r\n" + 
		   		"  CONSTRAINT `methodid2`\r\n" + 
		   		"    FOREIGN KEY (`ownermethodid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`methods` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION);"); 
		   

		   st.executeUpdate("CREATE TABLE `databasechess`.`methodcalls` (\r\n" + 
		   		"  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n" + 
		   		"  `callermethodid` INT NULL,\r\n" + 
		   		"  `callername` LONGTEXT NULL,\r\n" + 
		   		"  `callerclass` LONGTEXT NULL,\r\n" + 
		   		"  `callerclassid` LONGTEXT NULL,\r\n" + 
		   		"  `fullcaller` LONGTEXT NULL,\r\n" + 
		   		"  `calleemethodid` INT NULL,\r\n" + 
		   		"  `calleename` LONGTEXT NULL,\r\n" + 
		   		"  `calleeclass` LONGTEXT NULL,\r\n" + 
		   		"  `calleeclassid` LONGTEXT NULL,\r\n" + 
		   		"  `fullcallee` LONGTEXT NULL,\r\n" + 
		   		"  PRIMARY KEY (`id`),\r\n" + 
		   		"  UNIQUE INDEX `id_UNIQUE` (`id` ASC),\r\n" + 
		   		"  INDEX `caller_idx` (`callermethodid` ASC),\r\n" + 
		   		"  INDEX `callee_idx` (`calleemethodid` ASC),\r\n" + 
		   		"  CONSTRAINT `methodcalledid`\r\n" + 
		   		"    FOREIGN KEY (`callermethodid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`methods` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION,\r\n" + 
		   		"  CONSTRAINT `callingmethodid`\r\n" + 
		   		"    FOREIGN KEY (`calleemethodid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`methods` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION);"); 
		   st.executeUpdate("CREATE TABLE `databasechess`.`methodcallsexecuted` (\r\n" + 
			   		"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
			   		"  `callermethodid` LONGTEXT NULL,\r\n" + 
			   		"  `callername` LONGTEXT NULL,\r\n" + 
			   		"  `callerclass` LONGTEXT NULL,\r\n" + 
			   		"  `fullcaller` LONGTEXT NULL,\r\n" + 
			   		"  `calleemethodid` LONGTEXT NULL,\r\n" + 
			   		"  `calleename` LONGTEXT NULL,\r\n" + 
			   		"  `calleeclass` LONGTEXT NULL,\r\n" + 
			   		"  `fullcallee` LONGTEXT NULL,\r\n" + 
			   		"  PRIMARY KEY (`id`),\r\n" + 
			   		"  UNIQUE INDEX `id_UNIQUE` (`id` ASC)); " ); 
		   st.executeUpdate("CREATE TABLE `databasechess`.`traces` (\r\n" + 
		   		"  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n" + 
		   		"  `requirement` LONGTEXT NULL,\r\n" + 
		   		"  `requirementid` INT,\r\n" + 
		   		"  `method` LONGTEXT NULL,\r\n" + 
		   		"  `fullmethod` LONGTEXT NULL,\r\n" +
		   		"  `methodid` INT NULL,\r\n" + 
		   		"  `classname` LONGTEXT NULL,\r\n" + 
		   		"  `classid` LONGTEXT NULL,\r\n" + 
		   		"  `gold` LONGTEXT NULL,\r\n" + 
		   		"  `subject` LONGTEXT NULL,\r\n" + 
		   		"  `goldpredictioncallee` LONGTEXT NULL,\r\n" + 
		   		"  `goldpredictioncaller` LONGTEXT NULL,\r\n" + 
		   		"  PRIMARY KEY (`id`),\r\n" + 
		   		"  INDEX `methodid_idx8` (`methodid` ASC),\r\n" + 
		   		"  CONSTRAINT `methodid8`\r\n" + 
		   		"    FOREIGN KEY (`methodid`)\r\n" + 
		   		"    REFERENCES `databasechess`.`methods` (`id`)\r\n" + 
		   		"    ON DELETE NO ACTION\r\n" + 
		   		"    ON UPDATE NO ACTION);\r\n" + 	
		   		""); 
		 
		   
		   st.executeUpdate("CREATE TABLE `databasechess`.`requirements` (\r\n" + 
		   		"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
		   		"  `requirementname` LONGTEXT NULL,\r\n" + 
		   		"  PRIMARY KEY (`id`),\r\n" + 
		   		"  UNIQUE INDEX `id_UNIQUE` (`id` ASC));"); 
			 st.executeUpdate("CREATE TABLE `databasechess`.`tracesclasses` (\r\n" + 
			 		"  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n" + 
			 		"  `requirement` LONGTEXT NULL,\r\n" + 
			 		"  `requirementid` INT NULL,\r\n" + 
			 		"  `classname` LONGTEXT NULL,\r\n" + 
			 		"  `classid` INT NULL,\r\n" + 
			 		"  `gold` LONGTEXT NULL,\r\n" + 
			 		"  `subject` LONGTEXT NULL,\r\n" + 
			 		"  PRIMARY KEY (`id`),\r\n" + 
			 		"  UNIQUE INDEX `idtracesclasses_UNIQUE` (`id` ASC));\r\n" + 
			 		""); 
		   
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
		DBDemo2 app = new DBDemo2();
		app.run();
	}
	
	public void Spoon() throws SQLException, FileNotFoundException {
		DBDemo2 dao = new DBDemo2();
	Connection conn=getConnection();
	Statement st= conn.createStatement();
	
	    
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
    	int i=1; 
        /*********************************************************************************************************************************************************************************/	
        /*********************************************************************************************************************************************************************************/	
        /*********************************************************************************************************************************************************************************/	  	
    
    	
    	
    	
    	
    	//BUILD CLASSES TABLE 
    	for(CtType<?> clazz : classFactory.getAll()) {
    		
    	
    		
			
			String FullClassName= clazz.getPackage()+"."+clazz.getSimpleName(); 
			st.executeUpdate("INSERT INTO `classes`(`classname`) VALUES ('"+FullClassName+"');");
		
			 ResultSet rs = st.executeQuery("SELECT * FROM classes"); 
   		   while(rs.next()){
   			   //System.out.println(rs.getString("classname"));
   		   }			
   		
    		
    				
    	
   
    		
  		
    		 for(CtField<?> field : clazz.getFields()) {
    				for(CtMethod<?> method :clazz.getMethods()) {
    	    			// method.getParameters()
    	    			method.<CtFieldAccess<?>>getElements(new FieldAccessFilter(field.getReference()));
    	    		}
    		 }
    	}
//    	/*********************************************************************************************************************************************************************************/	
//        /*********************************************************************************************************************************************************************************/	
//        /*********************************************************************************************************************************************************************************/
    	//     	BUILD SUPERCLASSES TABLE 
    	for(CtType<?> clazz : classFactory.getAll()) {
    		String childclassQuery = null; 
    		String superclassQuery = null;
    		String superclassQueryName=null; 
    		String childclassQueryName=null; 
    		
    		String FullClassName= clazz.getPackage()+"."+clazz.getSimpleName(); 
    		//String superclass= clazz.getSuperclass().toString();
    		
			
			//System.out.println("SUPERCLASS"+superclass +"SUBCLASS "+FullClassName);
if(clazz.getSuperclass()!=null && clazz.getSuperclass().toString().contains(clazz.getPackage().toString()) ) {
    			
    			String superclass= clazz.getSuperclass().toString();
    		//	System.out.println(i+"    HERE IS MY SUPERCLASS"+superclass+"AND HERE IS MY SUBCLASS  "+FullClassName);
    		i++; 
    
    					ResultSet sClass = st.executeQuery("SELECT id from classes where classname='"+superclass+"'"); 
    					while(sClass.next()){
    						 superclassQuery= sClass.getString("id"); 
    			//			System.out.println("superclass: "+superclassQuery);	
    			   		   }

    					ResultSet sClassName = st.executeQuery("SELECT classname from classes where classname='"+superclass+"'"); 
    					while(sClassName.next()){
    						 superclassQueryName= sClassName.getString("classname"); 
    			//			System.out.println("superclass: "+superclassQuery);	
    			   		   }		
    					
    					ResultSet cClass = st.executeQuery("SELECT id from classes where classname='"+FullClassName+"'"); 
    					while(cClass.next()){
    						 childclassQuery= cClass.getString("id"); 
    			//			System.out.println("subclass: "+childclassQuery);	
    			   		   }
    					ResultSet cClassName = st.executeQuery("SELECT classname from classes where classname='"+FullClassName+"'"); 
    					while(cClassName.next()){
    						 childclassQueryName= cClassName.getString("classname"); 
    			//			System.out.println("subclass: "+childclassQuery);	
    			   		   }
    					
    			String result= "SELECT classname from classes where classname='"+FullClassName+"'"; 
    			if(superclassQuery!=null)
    			st.executeUpdate("INSERT INTO `superclasses`(`superclassid`, `superclassname`, `ownerclassid`, `childclassname`) VALUES ('"+superclassQuery +"','" +superclassQueryName+"','" +childclassQuery+"','" +childclassQueryName+"')");
    			
    		
    		
    		/*	st.executeUpdate("INSERT INTO `superclasses`(`superclass`, `childclass`) VALUES( "
    					+"(("+ superclassQuery+")"
    					+ ", ("+childclassQuery+")));" ); */
        		//clazz.getSuperInterfaces();
        		
    		}
    	}
//////    	/*********************************************************************************************************************************************************************************/	
//////        /*********************************************************************************************************************************************************************************/	
//////        /*********************************************************************************************************************************************************************************/	
////    	  	
//     	//BUILD INTERFACES TABLE 
    	for(CtType<?> clazz : classFactory.getAll()) {
    		
    		
    		String myinterfaceclassid = null;
    		String myinterfacename = null;
    		String myclassid = null;
    		String myclassname = null;
    		
			String FullClassName= clazz.getPackage()+"."+clazz.getSimpleName(); 
			Set<CtTypeReference<?>> interfaces = clazz.getSuperInterfaces(); 
			
			for(CtTypeReference<?> inter: interfaces) {
			//	System.out.println("my interface   "+inter);
				if(inter.toString().contains(clazz.getPackage().toString())) {
					ResultSet interfacesnames = st.executeQuery("SELECT classname from classes where classname='"+inter+"'"); 
					while(interfacesnames.next()){
						myinterfacename= interfacesnames.getString("classname"); 
				//		System.out.println("interface: "+myinterface);	
			   		   }
					
					ResultSet interfacesclasses = st.executeQuery("SELECT id from classes where classname='"+inter+"'"); 
					while(interfacesclasses.next()){
						myinterfaceclassid= interfacesclasses.getString("id"); 
				//		System.out.println("interface: "+myinterface);	
			   		   }
					
					ResultSet classesnames= st.executeQuery("SELECT classname from classes where classname='"+FullClassName+"'"); 
					while(classesnames.next()){
						myclassname= classesnames.getString("classname"); 
				//		System.out.println("class referenced: "+myclass);	
			   		   }
					
					ResultSet interfacesname = st.executeQuery("SELECT id from classes where classname='"+FullClassName+"'"); 
					while(interfacesname.next()){
						myclassid= interfacesname.getString("id"); 
				//		System.out.println("class referenced: "+myclass);	
			   		   }
					
	    			st.executeUpdate("INSERT INTO `interfaces`(`interfaceclassid`,`interfacename`,`ownerclassid`, `classname`) VALUES ('"+myinterfaceclassid +"','" +myinterfacename+"','" +myclassid+"','" +myclassname+"')");
				}
				
			}
			

    	}
////////    	
////////    
////////    	
//////////    	/*********************************************************************************************************************************************************************************/	
//////////        /*********************************************************************************************************************************************************************************/	
//////////        /*********************************************************************************************************************************************************************************/	  	
//////////    	//BUILD METHODS TABLE 
    	List<methods> mymethodlist = new ArrayList<methods>(); 
    	for(CtType<?> clazz : classFactory.getAll()) {
    		
    	
    		String myclassid = null;
    		String myclassname = null;
    		
    		//ALTERNATIVE: Collection<CtMethod<?>> methods = clazz.getAllMethods(); 
			Collection<CtMethod<?>> methods = clazz.getMethods(); 
			System.out.println("CLASS SIMPLE NAME :    "+clazz.getSimpleName());
			String FullClassName= clazz.getPackage()+"."+clazz.getSimpleName(); 
			
			int count = StringUtils.countMatches(clazz.getPackage().toString(), ".");
			//System.out.println("count:   "+count);
			//NEEDS TO BE CHANGED 
		//	if(count==2) {
			 List<CtConstructor> MyContructorlist = clazz.getElements(new TypeFilter<>(CtConstructor.class)); 
			 for(CtConstructor<?> constructor: MyContructorlist) {
				 
				 	
					String FullConstructorName=constructor.getSignature().toString(); 
					
					String methodabbreviation=FullConstructorName.substring(0, FullConstructorName.indexOf("(")); 
					 methodabbreviation=FullClassName+".-init-"; 

					System.out.println("FULL CONSTRUCTOR NAME BEFORE METHOD ABBREVIATION:"+methodabbreviation);

					//st.executeUpdate("INSERT INTO `fields`(`fieldname`) VALUES ('"+field+"');");
					//24 is the size of the string "de.java_chess.javaChess."
					int packagesize= "de.java_chess.javaChess.".length(); 
						FullConstructorName=FullConstructorName.substring(packagesize, FullConstructorName.length()); 
						FullConstructorName="-init-"+FullConstructorName.substring(FullConstructorName.lastIndexOf('('));  
						
							System.out.println("FULL CONSTRUCTOR NAME AFTER:"+FullConstructorName);

						ResultSet classesreferenced = st.executeQuery("SELECT id from classes where classname='"+FullClassName+"'"); 
						while(classesreferenced.next()){
							myclassid= classesreferenced.getString("id"); 
					//		System.out.println("class referenced: "+myclass);	
				   		   }
						ResultSet classnames = st.executeQuery("SELECT classname from classes where classname='"+FullClassName+"'"); 
						while(classnames.next()){
							myclassname= classnames.getString("classname"); 
					//		System.out.println("class referenced: "+myclass);	
				   		   }
						
							System.out.println("FullClassName====="+ FullConstructorName);
					
							String FullMethodNameRefined=FullConstructorName.substring(0, FullConstructorName.indexOf("(")); 
							//String FullMethodName=constructor.getSignature().toString(); 
							String fullmeth= myclassname+"."+FullConstructorName; 
							System.out.println(FullClassName);
							methods meth= new methods(FullConstructorName, myclassid, myclassname); 
							if(meth.contains(mymethodlist, meth)==false ) {
				    			st.executeUpdate("INSERT INTO `methods`(`methodname`, `methodnamerefined`, `methodabbreviation`, `fullmethod`,`classid`, `classname`) VALUES ('"+FullConstructorName+"','" +FullMethodNameRefined +"','" +methodabbreviation+"','" +fullmeth+"','" +myclassid+"','" +myclassname+"')");

								
				    			mymethodlist.add(meth); 
							}
						

						}
			 
			 
			 
			for(CtMethod<?> method: methods) {
				 
				 
				String FullMethodName=method.getSignature().toString(); 
				System.out.println("==============>"+method.getShortRepresentation().toString());
				//st.executeUpdate("INSERT INTO `fields`(`fieldname`) VALUES ('"+field+"');");
			//	System.out.println(FullClassName);
				String FullMethodNameRefined=FullMethodName.substring(0, FullMethodName.indexOf("(")); 
				String longmeth= clazz.getQualifiedName()+"."+FullMethodName; 
				String methodabbreviation=longmeth.substring(0, longmeth.indexOf("(")); 
					ResultSet classesreferenced = st.executeQuery("SELECT id from classes where classname='"+FullClassName+"'"); 
					while(classesreferenced.next()){
						myclassid= classesreferenced.getString("id"); 
				//		System.out.println("class referenced: "+myclass);	
			   		   }
					ResultSet classnames = st.executeQuery("SELECT classname from classes where classname='"+FullClassName+"'"); 
					while(classnames.next()){
						myclassname= classnames.getString("classname"); 
				//		System.out.println("class referenced: "+myclass);	
			   		   }
					
				
				
						String fullmeth= myclassname+"."+FullMethodName; 
						System.out.println(FullClassName);
						methods meth= new methods(FullMethodName, myclassid, myclassname); 
						if(meth.contains(mymethodlist, meth)==false ) {
			    			st.executeUpdate("INSERT INTO `methods`(`methodname`,  `methodnamerefined`,`methodabbreviation`, `fullmethod`,`classid`, `classname`) VALUES ('"+FullMethodName +"','" +FullMethodNameRefined+"','" +methodabbreviation+"','" +longmeth+"','" +myclassid+"','" +myclassname+"')");

							
			    			mymethodlist.add(meth); 
						}
						
						

					}

					
				
				
			//}
			
			
		
			
		
    	}
//////////////      	/*********************************************************************************************************************************************************************************/	
//////////////        /*********************************************************************************************************************************************************************************/	
//////////////        /*********************************************************************************************************************************************************************************/
////////////    	
//////////    	
  List<String> paramlist= new ArrayList<String>();   	
//    	//BUILD PARAMETERS TABLE 
for(CtType<?> clazz : classFactory.getAll()) {
    		
    		System.out.println(clazz.getSimpleName());
    		System.out.println(clazz.getPackage());
    		String fullname= clazz.getPackage()+""+clazz.getQualifiedName(); 
    		 String MethodReferenced=null; 
    		String MethodName=null; 
    		String parameter=null; 
    	    String ClassName=null; 
    	    String classid=null; 
    		String parameterclass=null; 
    		String paramclassid=null; 
    				
    		 //for(CtField<?> field : clazz.getFields()) {
    				for(CtMethod<?> method :clazz.getMethods()) {
    	    			List<CtParameter<?>> params = method.getParameters(); 
    				
    	    			
    	    			
    	    		
    	    	
    	    			for( CtParameter<?> myparam :params) {
    	    				String paramInfo=""; 
    	    				boolean flag2=false; 
    	    				System.out.println("METHOD SIGNATURE==========>"+clazz.getQualifiedName()+"."+ method.getSignature());
    	    				String fullmeth=clazz.getQualifiedName()+"."+ method.getSignature(); 
    	    				ResultSet classnames = st.executeQuery("SELECT classes.classname from classes INNER JOIN methods ON classes.id=methods.classid where methods.fullmethod='"+fullmeth+"' "); 
    	    				
	    					while(classnames.next()){
	    						 ClassName =classnames.getString("classname"); 
	    					
	    			   		   }
	    					
	    					ResultSet classids = st.executeQuery("SELECT classes.id from classes INNER JOIN methods ON classes.id=methods.classid where methods.fullmethod='"+fullmeth+"' "); 
    	    				
	    					while(classids.next()){
	    						 classid =classids.getString("id"); 
	    					
	    			   		   }
	    					
    	    					ResultSet methods = st.executeQuery("SELECT methods.id from methods INNER JOIN classes ON classes.id=methods.classid where methods.fullmethod='"+fullmeth+"' and classes.id='"+classid+"'"); 
    	    				
    	    					while(methods.next()){
    	    						MethodReferenced =methods.getString("id"); 
    	    					
    	    			   		   }
    	    				
    	    					ResultSet paramclassids = st.executeQuery("SELECT classes.id from classes where classes.classname='"+myparam.getType()+"'"); 
        	    				
    	    					while(paramclassids.next()){
    	    						flag2=true; 
    	    						paramclassid =paramclassids.getString("id"); 
    	    					
    	    			   		   }
    	    			
    	    				
    	    					

    	    				
    	    				//	if(field.toString().contains("java.awt")==false && field.toString().contains("javax")==false) {
    	    						System.out.println("HERE IS A PARAMETER: "+ myparam);
    	    						if(MethodReferenced==null) {
    	    							System.out.println("HERE IS NULL PARAMETER: "+myparam+"method referenced======>"+MethodReferenced);
    	    						}
            		    			param param= new param(fullmeth, method.toString(), parameterclass, classid, ClassName, MethodReferenced, method.getSignature().toString(), "0"); 
            		    			paramInfo=myparam +"','" +myparam.getType() +"','"+paramclassid+"','"+classid +"','"+ClassName+"','" +MethodReferenced+"','" +method.getSignature().toString()+"','" +0; 
    	    						if(MethodReferenced!=null && flag2==true  && paramlist.contains(paramInfo)==false) {
        	    		    			st.executeUpdate("INSERT INTO `parameters`(`parametername`, `parametertype`, `parameterclass`,`classid`, `classname`, `methodid`, `methodname`, `isreturn`) VALUES ('"+myparam +"','" +myparam.getType() +"','"+paramclassid+"','"+classid +"','"+ClassName+"','" +MethodReferenced+"','" +fullmeth+"','" +0+"')");
        	    		    			paramlist.add(paramInfo);
    	    						}

    	    				//	}
    	    				
    	    				
    	    			}
    	    			
    	    		
    	    			/*List<CtStatement> bodystatements = methodbody.getStatements(); 
    	    			//List<CtReturn> returnstatement = methodbody.getElements(new TypeFilter<>(CtReturn.class)); 
    	    		
    	    				List<CtReturn> returnstatement = methodbody.getElements(new TypeFilter<>(CtReturn.class)); 
    	    				for(CtReturn ret: returnstatement) {
    	    					System.out.println("HERE IS RETURN: "+ret.getReturnedExpression().getType());
    	    					ret.getReturnedExpression().getType(); 
    	    				
    	    			}*/
    	    			String fullmeth=clazz.getQualifiedName()+"."+ method.getSignature(); 
    	    			boolean flag=false; 
    	    			CtTypeReference<?> MethodType = method.getType();  
     	    			System.out.println("METHOD TYPE  "+ MethodType);
     	    			ResultSet classnames = st.executeQuery("SELECT classes.classname from classes INNER JOIN methods ON classes.id=methods.classid where methods.fullmethod='"+fullmeth+"' "); 
	    				
    					while(classnames.next()){
    						 ClassName =classnames.getString("classname"); 
    					
    			   		   }
    					
    					ResultSet classids = st.executeQuery("SELECT classes.id from classes INNER JOIN methods ON classes.id=methods.classid where methods.fullmethod='"+fullmeth+"' "); 
	    				
    					while(classids.next()){
    						 classid =classids.getString("id"); 
    					
    			   		   }
    					
	    					ResultSet methods = st.executeQuery("SELECT methods.id from methods INNER JOIN classes ON classes.id=methods.classid where methods.methodname='"+method.getSignature().toString()+"' and classes.id='"+classid+"'"); 
	    				
	    					while(methods.next()){
	    						MethodReferenced =methods.getString("id"); 
	    					
	    			   		   }
	    				
	    					
	    					
	    					ResultSet parameterclasses = st.executeQuery("SELECT classes.id from classes where classes.classname='"+MethodType+"'"); 
		    				
	    					while(parameterclasses.next()){
	    						parameterclass =parameterclasses.getString("id"); 
	    						flag=true; 
	    					
	    			   		   }
    		    			param param= new param(fullmeth, MethodType.toString(), parameterclass, classid, ClassName, MethodReferenced, method.getSignature().toString(), "1"); 
    		    			String paramInfo= MethodType +"','" +MethodType+"','" +parameterclass +"','" +classid +"','"+ClassName+"','" +MethodReferenced+"','" +method.getSignature().toString()+"','" +1; 
    	    			if(MethodReferenced!=null && flag==true && paramlist.contains(paramInfo)==false) {
    		    			st.executeUpdate("INSERT INTO `parameters`(`parametername`, `parametertype`, `parameterclass`,`classid`, `classname`, `methodid`, `methodname`, `isreturn`) VALUES ('"+MethodType +"','" +MethodType+"','" +parameterclass +"','" +classid +"','"+ClassName+"','" +MethodReferenced+"','" +fullmeth+"','" +1+"')");
    		    			paramlist.add(paramInfo); 
    	    			}

    	    		
    	    		}
    		 //}
    	}
/////////*********************************************************************************************************************************************************************************/	
/////////*********************************************************************************************************************************************************************************/	
/////////*********************************************************************************************************************************************************************************/
////////	
//////////BUILD FIELDS TABLE -- CLASSES
for(CtType<?> clazz : classFactory.getAll()) {
	
	
	
	String myclass = null;
	String myclassname=null; 
	String fieldid=null; 
//ALTERNATIVE: Collection<CtFieldReference<?>> fields = clazz.getAllFields(); 
	Collection<CtField<?>> fields = clazz.getFields(); 
	String FullClassName= clazz.getPackage()+"."+clazz.getSimpleName(); 
	
//ALTERNATIVE: 	for(CtFieldReference<?> field: fields) {	
	for(CtField<?> field: fields) {
		boolean flag=false; 
		//st.executeUpdate("INSERT INTO `fields`(`fieldname`) VALUES ('"+field+"');");
	//	System.out.println("my field   "+field);
		
			
			ResultSet classesreferenced = st.executeQuery("SELECT id from classes where classname='"+FullClassName+"'"); 
			while(classesreferenced.next()){
				myclass= classesreferenced.getString("id"); 
	//			System.out.println("class referenced: "+myclass);	
	   		   }
			ResultSet classnames = st.executeQuery("SELECT classname from classes where classname='"+FullClassName+"'"); 
			while(classnames.next()){
				myclassname= classnames.getString("classname"); 
	//			System.out.println("class referenced: "+myclass);	
	   		   }
			
			ResultSet fieldids = st.executeQuery("SELECT id from classes where classname='"+field.getType()+"'"); 
			while(fieldids.next()){
				flag=true; 
				fieldid= fieldids.getString("id"); 
	//			System.out.println("class referenced: "+myclass);	
	   		   }
			
		//	if(field.toString().contains("java.awt")==false && field.toString().contains("javax")==false) {
			if(fieldid!=null && flag==true) {
    			st.executeUpdate("INSERT INTO `fieldclasses`(`fieldname`, `fieldtypeclassid`, `fieldtype`, `ownerclassid`,  `classname`) VALUES ('"+field.getSimpleName() +"','"+fieldid +"','"+field.getType() +"','" +myclass+"','" +myclassname+"')");

			}

		//	}
		
		
	}
	

}
///////////*********************************************************************************************************************************************************************************/	
///////////*********************************************************************************************************************************************************************************/	
///////////*********************************************************************************************************************************************************************************/   	
////////////BUILD FIELDS TABLE -- METHODS
////////
for(CtType<?> clazz : classFactory.getAll()) {
	String fieldname=null; 
	String Fieldid=null; 
	String Methodid=null; 
	String myclassname=null; 
	String MethodName=null; 
	String FieldName=null; 
	String myclass=null; 
	String fieldid=null; 
	String FullClassName= clazz.getPackage()+"."+clazz.getSimpleName();
	List<fieldmethod> FieldMethodsList= new ArrayList<fieldmethod>(); 
	
	
	for(CtMethod<?> method :clazz.getMethods()) {
		List<CtFieldAccess> list = method.getElements(new TypeFilter<>(CtFieldAccess.class)); 
		for(CtFieldAccess fieldaccess: list) {
			boolean flag=false; 
			ResultSet classesreferenced = st.executeQuery("SELECT id from classes where classname='"+FullClassName+"'"); 
			while(classesreferenced.next()){
				 myclass = classesreferenced.getString("id"); 
	//			System.out.println("class referenced: "+myclass);	
	   		   }
			
			
			ResultSet fieldnames = st.executeQuery("SELECT fieldname from fieldclasses where fieldclasses.fieldname='"+fieldaccess.toString()+"'"); 
			while(fieldnames.next()){
				 FieldName = fieldnames.getString("fieldname"); 
	//			System.out.println("class referenced: "+myclass);	
	   		   }
			ResultSet classnames = st.executeQuery("SELECT classname from classes where classname='"+FullClassName+"'"); 
			while(classnames.next()){
				 myclassname = classnames.getString("classname"); 
	//			System.out.println("class referenced: "+myclass);	
	   		   }
			String fullmeth=FullClassName+"."+method.getSignature().toString(); 
			ResultSet methodids = st.executeQuery("SELECT methods.* from methods where fullmethod='"+fullmeth+"'"); 
			
			while(methodids.next()){
				  Methodid = methodids.getString("id"); 
				  MethodName = methodids.getString("methodname"); 
	   		   }

			
			ResultSet fieldids = st.executeQuery("SELECT id from classes where classname='"+fieldaccess.getType()+"'"); 
			while(fieldids.next()){
				flag=true; 
				fieldid= fieldids.getString("id"); 
	//			System.out.println("class referenced: "+myclass);	
	   		   }
			
			
			
			
			
			fieldmethod myfield= new fieldmethod(FieldName, myclassname, myclass, MethodName, Methodid); 
		
			
				if(myfield.contains(FieldMethodsList, myfield)==false && FieldName!=null && flag==true) {
					st.executeUpdate("INSERT INTO `fieldmethods`(`fieldaccess`, `fieldtypeclassid`, `fieldtype`,  `classname`,  `ownerclassid`,  `methodname`, `ownermethodid`) VALUES ('"+FieldName +"','" +fieldid+"','" +fieldaccess.getType()+"','" +myclassname+"','" +myclass+"','" +MethodName+"','" +Methodid+"')");
					FieldMethodsList.add(myfield); 
				}
			
			
			
			//ALTERNATIVE: 
			//st.executeUpdate("INSERT INTO `fieldmethods`(`fieldaccess`,  `classname`,  `classid`,  `methodname`, `methodid`) VALUES ('"+fieldaccess.toString() +"','" +myclassname+"','" +myclass+"','" +MethodName+"','" +Methodid+"')");
		}
	}
}
//

	

	
/////////////*********************************************************************************************************************************************************************************/	
/////////////*********************************************************************************************************************************************************************************/	
/////////////*********************************************************************************************************************************************************************************/   	
//////////////BUILD METHODSCALLED TABLE
	int counter=0; 
	String CallerMethodIDcons=null; 
	String CALLERCLASSNAMEcons=null; 
	String CALLERCLASSIDcons=null; 
	String fullcallerinscons=null; 
	String CalleeMethodIDcons=null; 
	String CALLEECLASSNAMEcons=null; 
	String CALLEECLASSIDcons=null; 
	String fullcalleeinscons=null; 
List<methodcalls> methodcallsList = new ArrayList<methodcalls>(); 
for(CtType<?> clazz : classFactory.getAll()) {

for(CtMethod<?> method :clazz.getMethods()) {
	List<CtConstructorCall> ctNewClasses = method.getElements(new TypeFilter<CtConstructorCall>(CtConstructorCall.class));
	
	for( CtConstructorCall myclass: ctNewClasses) {
		//CONSTRUCTOR 
		System.out.println("MYCLASS"+ clazz.getQualifiedName()+"."+method.getSignature()+"  METHOD"+ myclass.getExecutable().getSignature()+
				"CLASSS    "+
				myclass.getExecutable().getDeclaringType().getQualifiedName());

		String FullCallerMeth=clazz.getQualifiedName()+"."+method.getSignature(); 
		
		String constructorName=myclass.getExecutable().getSignature(); 
		String constructorClassName= myclass.getExecutable().getDeclaringType().getQualifiedName(); 
		constructorName="-init-"+constructorName.substring(constructorName.indexOf("("), constructorName.length()); 
		System.out.println("CONSTRUCTOR NAME "+ constructorName);
		
		
		
	
		
		
		String fullcallerins=null; 
		String fullcalleeins=null; 
		ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+constructorName+"'"
				+ "and methods.classname='"+constructorClassName+"'"); 
		//while(callingmethodsrefined.next()){
		if(callingmethodsrefined.next()) {
			CalleeMethodIDcons = callingmethodsrefined.getString("id"); 
			CALLEECLASSNAMEcons = callingmethodsrefined.getString("classname"); 
			CALLEECLASSIDcons = callingmethodsrefined.getString("classid"); 
			 fullcalleeinscons = callingmethodsrefined.getString("fullmethod"); 

			//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
		}
		
		
	callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.fullmethod='"+FullCallerMeth+"'"); 
		//while(callingmethodsrefined.next()){
		if(callingmethodsrefined.next()) {
			CallerMethodIDcons = callingmethodsrefined.getString("id"); 
			CALLERCLASSNAMEcons = callingmethodsrefined.getString("classname"); 
			CALLERCLASSIDcons = callingmethodsrefined.getString("classid"); 
			 fullcallerinscons = callingmethodsrefined.getString("fullmethod"); 

			//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
		}
		
		
		
		methodcalls methodcall = new methodcalls(CalleeMethodIDcons, fullcalleeinscons, CALLEECLASSNAMEcons, CALLEECLASSIDcons, CallerMethodIDcons, fullcallerinscons, CALLERCLASSNAMEcons); 
		//System.out.println(methodcall.toString()); 
		if( methodcall.contains(methodcallsList, methodcall)==false && CallerMethodIDcons!=null && CalleeMethodIDcons!=null) {
			String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`) VALUES ('"+CallerMethodIDcons +"','" +method.getSignature()+"','" +CALLERCLASSNAMEcons+"','" +CALLERCLASSIDcons+"','" +fullcallerinscons+"','" +CalleeMethodIDcons+"','" +constructorName+"','" +CALLEECLASSNAMEcons+"','" +CALLEECLASSIDcons+"','" +fullcalleeinscons+"')";
			
			st.executeUpdate(statement);
			methodcallsList.add(methodcall); 
		}
		
		
//			List args = (myclass.getExecutable().getArguments()); 
		
//		System.out.println("hEYYYYYY"+args.toString());
		
		
		List list = myclass.getArguments();
		
		System.out.println("LIST "+ list);
		
		for(Object elem: list) {
			
			if(elem instanceof CtInvocation) {
				
				 CtExecutableReference elemexec = ((CtInvocation) elem).getExecutable(); 
				System.out.println("ELEM"+elem);
				System.out.println("EXEC"+elemexec);
				
			//	String targetType=elemexec.getDeclaringType().getQualifiedName(); 
				
				
				
				
				  CtExpression targ = ((CtInvocation) elem).getTarget(); 
					if(targ instanceof CtInvocation) {
						CtExecutableReference targex = ((CtInvocation) targ).getExecutable(); 
						System.out.println("TARG"+targex);
						String executableType=targex.getDeclaringType().getQualifiedName(); 
						
						
						CtExpression targetoftarget = ((CtTargetedExpression) targ).getTarget(); 
						while(!targetoftarget.toString().equals("") && targetoftarget instanceof CtInvocation==true ) {
							
							
							System.out.println("TARGET OF TARGET: "+targetoftarget);
							if(targetoftarget instanceof CtInvocation<?> ) {
								targetoftarget=((CtInvocation<?>) targetoftarget).getTarget(); 

							}
							else if(targetoftarget instanceof CtConstructorCall<?>) {
								targetoftarget=((CtConstructorCall<?>) targetoftarget).getTarget(); 
							}
							else if(targetoftarget instanceof CtFieldAccess<?>) {
								targetoftarget=((CtFieldAccess<?>) targetoftarget).getTarget(); 
							}else if(targetoftarget instanceof CtField<?>) {
								targetoftarget=((CtFieldAccess<?>) targetoftarget).getTarget(); 
							}
							
							String targetoftargetType=targex.getDeclaringType().getQualifiedName(); 
							
						}
					}
//				if(elemtarg==null) {
//					System.out.println("ELEM"+elem);
//				}
//				while(elemtarg!=null) {
//					
//					elemtarg = ((CtInvocation<?>) elemtarg).getTarget(); 
//					System.out.println("ELEM TARG: "+elemtarg);
//				}
				
			}else if(elem instanceof CtFieldAccess) {
				System.out.println("ELEMFILEDACCESS"+elem);
			}
		}
		
	}
	
	
	String methname=method.getSimpleName(); 
	//System.out.println("CALLER METHOD=====>"+methname);
	// List<CtInvocation> methodcalls = Query.getElements(method, new TypeFilter<>(CtInvocation.class)); 
	 List<CtInvocation> methodcalls = method.getElements(new TypeFilter<>(CtInvocation.class)); 
	for( CtInvocation invocation: methodcalls) {
		String callingmethodid=null; 
		String callingmethodsrefinedid=null; 
		String callingmethodsrefinedname=null; 
		String callingmethodclass=null; 
		String calledmethodid=null; 
		String calledmethodname=null; 
		String calledmethodclass=null; 
		String paramclassid=null; 
		String CALLEEID=null; 
		String CALLEECLASSNAME=null; 
		String CALLEECLASSID=null; 
		String CALLERCLASSID=null; 
		String CallerMethodID=null; 
		//CALLING METHOD ID 
		String CALLEENAME= invocation.getExecutable().getSignature().toString(); 
		CtExecutableReference<?> executableRef = invocation.getExecutable();
		CtTypeReference<?> typeRef = executableRef.getDeclaringType();
			
		String CALLERCLASSNAME=clazz.getQualifiedName() ; 
		String CallerMethod= method.getSignature(); 
		//System.out.println("CALLER METHOD NAME: "+ CallerMethod);
		//System.out.println("CALLER CLASS  NAME : "+ CALLERCLASSNAME);
		ResultSet callingmethodsrefined3 = st.executeQuery("SELECT methods.id from methods where methods.methodname='"+CallerMethod+"'and methods.classname='"+CALLERCLASSNAME+"'"); 
		//while(callingmethodsrefined.next()){
		if(callingmethodsrefined3.next()) {
			CallerMethodID = callingmethodsrefined3.getString("id"); 
		//	System.out.println("CALLER METHOD ID: "+ CallerMethodID);
		}
		String fullcallerins=null; 
		String fullcalleeins=null; 
		ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+CallerMethod+"'and methods.classname='"+CALLERCLASSNAME+"'"); 
		//while(callingmethodsrefined.next()){
		if(callingmethodsrefined.next()) {
			CallerMethodID = callingmethodsrefined.getString("id"); 
			CALLERCLASSNAME = callingmethodsrefined.getString("classname"); 
			CALLERCLASSID = callingmethodsrefined.getString("classid"); 
			 fullcallerins = callingmethodsrefined.getString("fullmethod"); 

			//System.out.println("CALLEE METHOD ID: "+ CALLEEID);
		}
		
		
		
		
		
	//	System.out.println("CALLEE METHOD NAME: "+ CALLEENAME);
		if(typeRef!=null) {
			String methodCalleeClassName=typeRef.getQualifiedName();
		//	System.out.println("METHOD CALLEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE: "+methodCalleeClassName);
			//ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.id from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+CalledMethodExecutable+"' and classes.classname='"+  ClassQualifiedName +"'"); 
			ResultSet callingmethodsrefined2 = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+CALLEENAME+"'and methods.classname='"+methodCalleeClassName+"'"); 
			//while(callingmethodsrefined.next()){
			if(callingmethodsrefined2.next()) {
				CALLEECLASSNAME = callingmethodsrefined2.getString("classname"); 
				CALLEECLASSID = callingmethodsrefined2.getString("classid"); 
				CALLEEID = callingmethodsrefined2.getString("id"); 
				 fullcalleeins = callingmethodsrefined2.getString("fullmethod"); 
//				System.out.println("CALLEE METHOD ID: "+ CALLEEID);
				//System.out.println("CALLEE CLASS NAME: "+ CALLEECLASSNAME);
				
				CALLEENAME= invocation.getExecutable().getSignature().toString(); 
				String fullcaller= CALLERCLASSNAME+"."+CallerMethod; 
				String fullcallee= CALLEECLASSNAME+"."+CALLEENAME; 
				methodcalls methodcall= new methodcalls(CALLEEID, fullcalleeins, CALLEECLASSNAME, CALLEECLASSID, CallerMethodID, fullcallerins, CALLERCLASSNAME); 
				//
				//System.out.println("======>"+methodcall.toString()); 
				if( methodcall.contains(methodcallsList, methodcall)==false && CallerMethodID!=null && CALLEEID!=null) {
					
					String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`) VALUES ('"+CallerMethodID +"','" +CallerMethod+"','" +CALLERCLASSNAME+"','" +CALLERCLASSID+"','" +fullcallerins+"','" +CALLEEID+"','" +CALLEENAME+"','" +CALLEECLASSNAME+"','" +CALLEECLASSID+"','" +fullcalleeins+"')";
					
					st.executeUpdate(statement);
					methodcallsList.add(methodcall); 
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		CtExpression<?> invocationTarget = invocation.getTarget(); 
		
		boolean  fieldaccesssflag=false; 
		while(invocationTarget!=null ) {
			String CALLEENAMETARGET= invocationTarget.toString(); 
		//	System.out.println("TARGET: "+ CALLEENAMETARGET);
			String NameCallee=null; 
			if(invocationTarget instanceof CtInvocation<?>) {
				//System.out.println("Invocation");
				
				List args = ((CtInvocation) invocationTarget).getArguments(); 
				
				System.out.println("hEYYYYYY"+args.toString());
				for(Object elem: args) {
				//	System.out.println("hEYYYYYY"+elem.toString());
				}
				
				
				
				String calleeName = ((CtInvocation) invocationTarget).getExecutable().getSignature();
				
				String calleeDeclaringTypeName = ((CtInvocation) invocationTarget).getExecutable().getDeclaringType().getQualifiedName(); 
				
				List<CtParameter<?>> myparams = ((CtInvocation) invocationTarget).getExecutable().getParameters(); 
				
				ResultSet callingmethodsrefined2 = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+calleeName+"'and methods.classname='"+calleeDeclaringTypeName+"'"); 
				//while(callingmethodsrefined.next()){
				 CALLEENAME= invocation.getExecutable().getSignature().toString(); 
					
					
				if(callingmethodsrefined2.next()) {
					NameCallee = callingmethodsrefined2.getString("methodname"); 
					CALLEECLASSNAME = callingmethodsrefined2.getString("classname"); 
					CALLEECLASSID = callingmethodsrefined2.getString("classid"); 
					CALLEEID = callingmethodsrefined2.getString("id"); 
					fullcalleeins = callingmethodsrefined2.getString("fullmethod"); 
					String fullcallee= CALLEECLASSNAME+"."+calleeName; 
					String fullcaller= CALLERCLASSNAME+"."+CallerMethod; 
					
					System.out.println("CALLEE  NAME:  "+ NameCallee);
					System.out.println("CALLEE CLASS NAME:  "+ CALLEECLASSNAME);
					System.out.println("CALLEECLASSID:  "+ CALLEECLASSID);
					System.out.println("CALLEEID:  "+ CALLEEID);
					System.out.println("fullcalleeins:  "+ fullcalleeins);
					System.out.println("fullcallee:  "+ fullcallee);
					System.out.println("fullcaller:  "+ fullcaller);
					System.out.println("\n");
					methodcalls methodcall = new methodcalls(CALLEEID, fullcalleeins, CALLEECLASSNAME, CALLEECLASSID, CallerMethodID, fullcallerins, CALLERCLASSNAME); 
					//System.out.println(methodcall.toString()); 
					if( methodcall.contains(methodcallsList, methodcall)==false && CallerMethodID!=null && CALLEEID!=null) {
						String statement = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`, `callerclassid`,`fullcaller`,`calleemethodid`,  `calleename`, `calleeclass`,  `calleeclassid`,  `fullcallee`) VALUES ('"+CallerMethodID +"','" +CallerMethod+"','" +CALLERCLASSNAME+"','" +CALLERCLASSID+"','" +fullcallerins+"','" +CALLEEID+"','" +NameCallee+"','" +CALLEECLASSNAME+"','" +CALLEECLASSID+"','" +fullcalleeins+"')";
						
						st.executeUpdate(statement);
						methodcallsList.add(methodcall); 
					}
					
			}
			
				invocationTarget=((CtInvocation<?>) invocationTarget).getTarget(); 
		}	
			else if(invocationTarget instanceof CtFieldAccess<?>) {
			fieldaccesssflag=true; 
			//System.out.println("Field Access");
			invocationTarget=((CtFieldAccess<?>) invocationTarget).getTarget(); 
		}else  {
			
			invocationTarget=null; 
		}
	
		}
		
		
		
	
		
		
		//ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.id from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+CalledMethodExecutable+"' and classes.classname='"+  ClassQualifiedName +"'"); 
		
			


		
		
//		ResultSet callingclasses= st.executeQuery("SELECT classes.id from classes where classes.classname='"+CALLEECLASSNAME+"' "); 
//		//while(callingmethodsrefined.next()){
//		if(callingclasses.next()) {
//			CALLEECLASSID = callingclasses.getString("id"); 
//			System.out.println("CALLEE CLASS ID: "+ CALLEECLASSID);
//		}
		
		

		
//		if(CALLERCLASSID==null) {
//			ResultSet callerclasses= st.executeQuery("SELECT classes.id from classes where classes.classname='"+CALLERCLASSNAME+"' "); 
//			//while(callingmethodsrefined.next()){
//			if(callerclasses.next()) {
//				CALLERCLASSID = callerclasses.getString("id"); 
//				System.out.println("CALLEE CLASS ID: "+ CALLERCLASSID);
//			}
//		}
	
		
   		//   }
		 
		//CALLING METHOD NAME 
		//ResultSet callingmethodsrefinednames = st.executeQuery("SELECT methods.methodname from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+CalledMethodExecutable+"' and classes.classname='"+  ClassQualifiedName +"'"); 
	/*	ResultSet callingmethodsrefinednames = st.executeQuery("SELECT methods.id from methods where methods.methodname='"+CalledMethodExecutable+"'"); 
		while(callingmethodsrefinednames.next()){
			callingmethodsrefinedname = callingmethodsrefinednames.getString("methodname"); 
   		   }*/
		
		
		//CALLING METHOD CLASS 
		//ResultSet callingmethodsclasses = st.executeQuery("SELECT classes.classname from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+CalledMethodExecutable+"' and classes.classname='"+  ClassQualifiedName +"'"); 
	/*	ResultSet callingmethodsclasses = st.executeQuery("SELECT methods.classname from methods where methods.methodname='"+  ClassQualifiedName +"'"); 
		while(callingmethodsclasses.next()){
			callingmethodclass = callingmethodsclasses.getString("classname"); 
   		   }*/
		
		
		//CALLED METHOD ID 
		/*ResultSet calledmethodsids= st.executeQuery("SELECT methods.id from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+CalledMethodExecutable+"' and classes.classname='"+  ClassQualifiedName +"'"); 
		while(calledmethodsids.next()){
			calledmethodid = calledmethodsids.getString("id"); 
   		   }
		 
		//CALLED METHOD NAME 
		ResultSet callemethodnames = st.executeQuery("SELECT methods.methodname from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+CalledMethodExecutable+"' and classes.classname='"+  ClassQualifiedName +"'"); 
		while(callemethodnames.next()){
			calledmethodname = callemethodnames.getString("methodname"); 
   		   }
		
		
		//CALLED METHOD CLASS 
		ResultSet calledmethodclasses = st.executeQuery("SELECT classes.classname from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+CalledMethodExecutable+"' and classes.classname='"+  ClassQualifiedName +"'"); 
		while(calledmethodclasses.next()){
			calledmethodclass = calledmethodclasses.getString("classname"); 
   		   }
		
		*/
		//System.out.println("CALLED METHOD "+calledmethodname+ "\tCLASS2: "+calledmethodclass+"\tCALLINGMETHOD: "+callingmethodsrefinedname+"CALLING MENTHOD CLASS"+callingmethodclass);

	    
		

	
		
	}
}





}       		
///////////////*********************************************************************************************************************************************************************************/	
///////////////*********************************************************************************************************************************************************************************/	
///////////////*********************************************************************************************************************************************************************************/   	
////////////////BUILD METHODSCALLED EXECUTED TABLE
////////   counter=0; 
File file = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\data.txt");
FileReader fileReader = new FileReader(file);
BufferedReader bufferedReader = new BufferedReader(fileReader);
StringBuffer stringBuffer = new StringBuffer();
String line;
try {
	
	List<methodcallsexecuted> methodcallsexecutedlist= new ArrayList<methodcallsexecuted>(); 

	while ((line = bufferedReader.readLine()) != null) {
		
		
		
		String methodsCalling= line.substring(1, line.indexOf("---")); 	
		String ClassFROM=methodsCalling.substring(0, methodsCalling.lastIndexOf("."));
		String MethodFROM=methodsCalling.substring(methodsCalling.lastIndexOf(".")+1, methodsCalling.indexOf(")")+1);
		String returnFROM= methodsCalling.substring(methodsCalling.lastIndexOf(")")+1, methodsCalling.length());
		MethodFROM=MethodFROM.replace("/", "."); 
		MethodFROM=MethodFROM.replace(";", ","); 
		  int endIndex = MethodFROM.lastIndexOf(",");
		    if (endIndex != -1)  
		    {
		    	MethodFROM = MethodFROM.substring(0, endIndex)+")"; // not forgot to put check if(endIndex != -1)
		    }
		MethodFROM=MethodFROM.replace("Lde", "de"); 
		MethodFROM=MethodFROM.replace("Ljava", "java"); 
		//MethodFROM=MethodFROM.replace("-", ""); 
		String methodsCalled=line.substring(line.lastIndexOf("---")+5, line.length()-1); 			
		String ClassTO=methodsCalled.substring(0, methodsCalled.lastIndexOf("."));
		String MethodTO=methodsCalled.substring(methodsCalled.lastIndexOf(".")+1, methodsCalled.indexOf(")")+1); 
		String returnTO= methodsCalled.substring(methodsCalled.lastIndexOf(")")+1, methodsCalled.length());
		MethodTO=MethodTO.replace("/", "."); 
		MethodTO=MethodTO.replace(";", ","); 
		
		   endIndex = MethodTO.lastIndexOf(",");
		    if (endIndex != -1)  
		    {
		    	MethodTO = MethodTO.substring(0, endIndex)+")"; // not forgot to put check if(endIndex != -1)
		    }
		//MethodTO=MethodTO.substring(0, MethodTO.lastIndexOf(",")-2)+")"; 
		MethodTO=MethodTO.replace("Lde", "de"); 
		MethodTO=MethodTO.replace("Ljava", "java"); 
		//MethodTO=MethodTO.replace("-", "");
		stringBuffer.append("\n");
		/*stringBuffer2.append("(SELECT MethodsID from Methods \r\n" + 
				"INNER JOIN Classes \r\n" + 
				"ON Classes.ClassID=Methods.ClassID\r\n" + 
				"where Methods.MethodName='"+MethodTO+"'  AND Classes.ClassName='"+ClassTO+"')),"); 
		stringBuffer2.append("\n");*/
		// 
		//
		
		//System.out.println("CLASS FROM: "+ClassFROM+"        METHOD FROM       "+ MethodFROM+ "       CLASS TO       "+ ClassTO+"       Method To       "+MethodTO); 
		String callingmethodid=null; 
		String callingmethodsrefinedid=null; 
		String callingmethodsrefinedname=null; 
		String callingmethodclass=null; 
		String calledmethodid=null; 
		String calledmethodname=null; 
		String calledmethodclass=null; 
		String classFROMid=null; 
		String classTOid=null; 
		String ClassFROMName=null; 
		 String ClassTOName=null; 
		 String ParameterClassID=null; 
		//get rid of everything that comes after the $ sign 
		
				
				
//		String MethodFROMTransformed= MethodFROM.substring(0, MethodFROM.indexOf("(")); 
//		String MethodTOTransformed= MethodTO.substring(0, MethodTO.indexOf("(")); 
		//CALLING METHOD ID 
		
		if(ClassFROM.contains("$")) {
			ClassFROM=ClassFROM.substring(0, ClassFROM.indexOf("$")); 

		}
		if(ClassTO.contains("$")) {
			ClassTO=ClassTO.substring(0, ClassTO.indexOf("$")); 
		}
//		if(MethodTOTransformed.equals("-clinit-")) {
//			MethodTOTransformed="-init-"; 
//		}
//		if(MethodFROMTransformed.equals("-clinit-")) {
//			MethodFROMTransformed="-init-"; 
//		}
		MethodTO= MethodTO.replaceAll("-clinit-", "-init"); 
		MethodFROM= MethodFROM.replaceAll("-clinit-", "-init"); 
		 String regEx = "[A-Z]";
	    Pattern pattern = Pattern.compile(regEx);
	 
	  
	    Matcher matcher = pattern.matcher(MethodFROM);
		while (matcher.find()) {
	    	 System.out.println("Found "+matcher.groupCount());
	    	 MethodFROM=MethodFROM.replaceAll("\\(Z\\)", "(boolean)"); 
	    	 MethodFROM=MethodFROM.replaceAll("\\(B\\)", "(byte)"); 
	    	 MethodFROM=MethodFROM.replaceAll("\\(I\\)", "(int)"); 
	    	 MethodFROM=MethodFROM.replaceAll("\\(J\\)", "(long)"); 
	    	 MethodFROM=MethodFROM.replaceAll("\\(S\\)", "(short)"); 
	  
	    	 
	    	 
	    	 MethodFROM=MethodFROM.replaceAll("Z,", "boolean,"); 
	    	 MethodFROM=MethodFROM.replaceAll("B,", "byte,"); 
	    	 MethodFROM=MethodFROM.replaceAll("I,", "int,"); 
	    	 MethodFROM=MethodFROM.replaceAll("J,", "long,"); 
	    	 MethodFROM=MethodFROM.replaceAll("S,", "short,"); 
	    	 
	    	 MethodFROM=MethodFROM.replaceAll("\\(Z", "(boolean,"); 
	    	 MethodFROM=MethodFROM.replaceAll("\\(B", "(byte,"); 
	    	 MethodFROM=MethodFROM.replaceAll("\\(I", "(int,"); 
	    	 MethodFROM=MethodFROM.replaceAll("\\(J", "(long,"); 
	    	 MethodFROM=MethodFROM.replaceAll("\\(S", "(short,");
	    	 
	    	 MethodFROM=MethodFROM.replaceAll("II", "int,int"); 
	    	 
	    	 MethodFROM=MethodFROM.replaceAll("Z\\)", ",boolean)"); 
	    	 MethodFROM=MethodFROM.replaceAll("B\\)", ",byte)"); 
	    	 MethodFROM=MethodFROM.replaceAll("I\\)", ",int)"); 
	    	 MethodFROM=MethodFROM.replaceAll("J\\)", ",long)"); 
	    	 MethodFROM=MethodFROM.replaceAll("S\\)", ",short)"); 
	    	 
	    	 MethodFROM=MethodFROM.replaceAll(",Z", ",boolean"); 
	    	 MethodFROM=MethodFROM.replaceAll(",B", ",byte"); 
	    	 MethodFROM=MethodFROM.replaceAll(",I", ",int"); 
	    	 MethodFROM=MethodFROM.replaceAll(",J", ",long"); 
	    	 MethodFROM=MethodFROM.replaceAll(",S", ",short"); 
	    	
	    }
		
		 matcher = pattern.matcher(MethodTO);
		while (matcher.find()) {
	    	 System.out.println("Found "+matcher.groupCount());
	    	 MethodTO=MethodTO.replaceAll("\\(Z\\)", "(boolean)"); 
	    	 MethodTO=MethodTO.replaceAll("\\(B\\)", "(byte)"); 
	    	 MethodTO=MethodTO.replaceAll("\\(I\\)", "(int)"); 
	    	 MethodTO=MethodTO.replaceAll("\\(J\\)", "(long)"); 
	    	 MethodTO=MethodTO.replaceAll("\\(S\\)", "(short)"); 
	  
	    	 
	    	 
	    	 MethodTO=MethodTO.replaceAll("Z,", "boolean,"); 
	    	 MethodTO=MethodTO.replaceAll("B,", "byte,"); 
	    	 MethodTO=MethodTO.replaceAll("I,", "int,"); 
	    	 MethodTO=MethodTO.replaceAll("J,", "long,"); 
	    	 MethodTO=MethodTO.replaceAll("S,", "short,"); 
	    	 
	    	 MethodTO=MethodTO.replaceAll("\\(Z", "(boolean,"); 
	    	 MethodTO=MethodTO.replaceAll("\\(B", "(byte,"); 
	    	 MethodTO=MethodTO.replaceAll("\\(I", "(int,"); 
	    	 MethodTO=MethodTO.replaceAll("\\(J", "(long,"); 
	    	 MethodTO=MethodTO.replaceAll("\\(S", "(short,");
	    	 
	    	 MethodTO=MethodTO.replaceAll("II", "int,int"); 
	    	 
	    	 MethodTO=MethodTO.replaceAll("Z\\)", ",boolean)"); 
	    	 MethodTO=MethodTO.replaceAll("B\\)", ",byte)"); 
	    	 MethodTO=MethodTO.replaceAll("I\\)", ",int)"); 
	    	 MethodTO=MethodTO.replaceAll("J\\)", ",long)"); 
	    	 MethodTO=MethodTO.replaceAll("S\\)", ",short)"); 
	    	 
	    	 MethodTO=MethodTO.replaceAll(",Z", ",boolean"); 
	    	 MethodTO=MethodTO.replaceAll(",B", ",byte"); 
	    	 MethodTO=MethodTO.replaceAll(",I", ",int"); 
	    	 MethodTO=MethodTO.replaceAll(",J", ",long"); 
	    	 MethodTO=MethodTO.replaceAll(",S", ",short"); 
	    	
	    }
		
	//	counter ++; 
		//CALLING METHOD ID 
		ResultSet callingmethodsrefined = st.executeQuery("SELECT methods.* from methods where methods.methodname='"+MethodFROM+"' and methods.classname='"+ClassFROM+"'"); 
		while(callingmethodsrefined.next()){
			callingmethodsrefinedid = callingmethodsrefined.getString("id"); 
			callingmethodsrefinedname = callingmethodsrefined.getString("methodname"); 
		}
		 
		
		
		
		//CALLING METHOD CLASS 
		ResultSet callingmethodsclasses = st.executeQuery("SELECT classes.classname from classes where classes.classname ='"+ClassFROM+"'"); 
		while(callingmethodsclasses.next()){
			callingmethodclass = callingmethodsclasses.getString("classname"); 
			   }
		
		MethodTO=MethodTO.replaceAll("Lantlr", "antlr"); 
		MethodFROM=MethodFROM.replaceAll("Lantlr", "antlr"); 
		//CALLED METHOD ID 
		ResultSet calledmethodsids= st.executeQuery("SELECT methods.* from methods  where methods.methodname='"+MethodTO+"'and methods.classname='"+ClassTO+"'"); 
		while(calledmethodsids.next()){
			calledmethodid = calledmethodsids.getString("id"); 
			calledmethodname = calledmethodsids.getString("methodname"); 
			   }
		 
		//CALLED METHOD NAME 
//		ResultSet callemethodnames = st.executeQuery("SELECT methods.methodname from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+MethodTOTransformed+"'"); 
//		while(callemethodnames.next()){
//			calledmethodname = callemethodnames.getString("methodname"); 
//			   }
		
		
		//CALLED METHOD CLASS 
		ResultSet calledmethodclasses = st.executeQuery("SELECT classes.classname from classes where classes.classname ='"+ClassTO+"'"); 
		while(calledmethodclasses.next()){
			calledmethodclass = calledmethodclasses.getString("classname"); 
			   }
		
		
		
		

		
		
		
		
				
				
				
				
		
		//System.out.println("CLASS FROM: "+ClassFROM+"        METHOD FROM       "+ MethodFROM+ "       CLASS TO       "+ ClassTO+"       Method To       "+MethodTO+"calling merthod refined id    "+ callingmethodsrefinedid+ "called method id    "+ calledmethodid); 

		methodcallsexecuted mce= new methodcallsexecuted(callingmethodsrefinedid, MethodFROM, ClassFROM, calledmethodid, MethodTO, ClassTO); 
		System.out.println(mce.toString()); 	
		if(mce.contains(methodcallsexecutedlist, mce)==false) {
			if(callingmethodsrefinedid!=null && calledmethodid!=null ) {
				String fullcaller= ClassFROM+"."+MethodFROM; 
				String fullcallee= ClassTO+"."+MethodTO; 
				String statement = "INSERT INTO `methodcallsexecuted`(`callermethodid`,  `callername`,  `callerclass`,  `fullcaller`,`calleemethodid`,  `calleename`, `calleeclass`, `fullcallee`) VALUES ('"+callingmethodsrefinedid+"','" +MethodFROM+"','" +ClassFROM+"','"+fullcaller+"','"+calledmethodid +"','" +MethodTO+"','" +ClassTO+"','" +fullcallee +"')";		
				st.executeUpdate(statement);
				methodcallsexecutedlist.add(mce); 
			}
			else {
				System.out.println("LINE THAT COULD NOT BE INSERTED=======>"+ line);
				//if the methods table does not contain a method call that is obtained from parsing the log file, then I am inserting this row within the methods table
				   //This is for METHOD FROM 
					
				
				//calculate class id FROM 
					ResultSet classidsFROM = st.executeQuery("SELECT classes.id from classes where classes.classname ='"+ClassFROM+"'"); 
					while(classidsFROM.next()){
						classFROMid = classidsFROM.getString("id"); 
						   }
					
					//calculate class classname FROM 
					ResultSet classnamesFROM = st.executeQuery("SELECT classes.classname from classes where classes.classname ='"+ClassFROM+"'"); 
					while(classnamesFROM.next()){
						ClassFROMName = classnamesFROM.getString("classname"); 
						   }
					
					
					//calculate class classname FROM 
					ResultSet paramclassids = st.executeQuery("SELECT classes.id from classes where classes.id ='"+returnFROM+"'"); 
					while(paramclassids.next()){
						classFROMid = paramclassids.getString("id"); 
						   }
					
					
				//	String MethodFROMRefined= MethodFROMTransformed.substring(0, MethodFROMTransformed.indexOf("(")); 
					String MethodFROMRefined= MethodFROM; 
					String MethodFROMAbbreviation = ClassFROM+"."+MethodFROM; 
					if(callingmethodsrefinedid==null && classFROMid!=null) {
						st.executeUpdate("INSERT INTO `methods`(`methodname`,  `methodnamerefined`,`methodabbreviation`, `classid`, `classname`) VALUES ('"+MethodFROM +"','" +MethodFROMRefined+"','" +MethodFROMAbbreviation+"','" +classFROMid+"','" +ClassFROM+"')");
		    		
						//RECALCULATION PHASE: CALLING METHOD ID 
						 callingmethodsrefined = st.executeQuery("SELECT methods.id from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+MethodFROM+"' and classes.classname='"+ClassFROM+"'"); 
						while(callingmethodsrefined.next()){
							callingmethodsrefinedid = callingmethodsrefined.getString("id"); 
					
						}
						
						String par= transformstring(returnFROM); 
						 regEx = "\\(([A-Z])\\)";
					     pattern = Pattern.compile(regEx);
					     matcher = pattern.matcher(par);
					    while (matcher.find()) {
					    	par=par.replaceAll("Z", "boolean"); 
					    	par=par.replaceAll("B", "byte"); 
					    	par=par.replaceAll("I", "int"); 
					    	par=par.replaceAll("J", "long"); 
					    	par=par.replaceAll("S", "short"); 
					    }
						regEx = "\\(([A-Z][A-Z]+)\\)";
					     pattern = Pattern.compile(regEx);
					     matcher = pattern.matcher(par);
					    while (matcher.find()) {
					    
					    	par=par.replaceAll("Z", "boolean,"); 
					    	par=par.replaceAll("B", "byte,"); 
					    	par=par.replaceAll("I", "int,"); 
					    	par=par.replaceAll("J", "long,"); 
					    	par=par.replaceAll("S", "short,"); 
					    	par=par.substring(0, par.lastIndexOf(",")); 
					    	par=par+")"; 
					    }
					System.out.println("PARAM"+par);
						 if(par.contains("de.java_chess")) {//ignore the basic data types, only insert the parameters thaht have classes as data types 
							 
							 ResultSet ParameterClassIDs= st.executeQuery("SELECT classes.id from classes where classes.classname='"+par+"'"); 
								while(ParameterClassIDs.next()){
									 ParameterClassID = ParameterClassIDs.getString("id"); 
									   }
							 
					//	System.out.println("COUNYER========> "+counter);	
						if(ParameterClassID!=null)
						st.executeUpdate("INSERT INTO `parameters`(`parametername`, `parametertype`, `parameterclass`,`classid`, `classname`, `methodid`, `methodname`, `isreturn`) VALUES ('"+par +"','" +par +"','"+ParameterClassID+"','"+classFROMid +"','"+ClassFROMName+"','" +callingmethodsrefinedid+"','" +MethodFROM+"','" +1+"')");
						 }
						String[] params = ExtractParams(MethodFROM); 
						 //insert parameters that were retrieved from the log file 
					//	counter++; 
						//System.out.println("HERE IS THE LINE =======>"+line+ counter);
						for(String p: params) {
							 regEx = "\\(([A-Z])\\)";
						     pattern = Pattern.compile(regEx);
						     matcher = pattern.matcher(par);
						    while (matcher.find()) {
						    	p=p.replaceAll("Z", "boolean"); 
						    	p=p.replaceAll("B", "byte"); 
						    	p=p.replaceAll("I", "int"); 
						    	p=p.replaceAll("J", "long"); 
						    	p=p.replaceAll("S", "short"); 
						    }
							regEx = "\\(([A-Z][A-Z]+)\\)";
						     pattern = Pattern.compile(regEx);
						     matcher = pattern.matcher(par);
						    while (matcher.find()) {
						    
						    	p=p.replaceAll("Z", "boolean,"); 
						    	p=p.replaceAll("B", "byte,"); 
						    	p=p.replaceAll("I", "int,"); 
						    	p=p.replaceAll("J", "long,"); 
						    	p=p.replaceAll("S", "short,"); 
						    	p=p.substring(0, p.lastIndexOf(",")); 
						    	p=p+")"; 
						    }
						
							System.out.println("HERE IS A PARAM==================================================================>"+p); 
							ResultSet ParameterClassIDs= st.executeQuery("SELECT classes.id from classes where classes.classname='"+p+"'"); 
							while(ParameterClassIDs.next()){
								 ParameterClassID = ParameterClassIDs.getString("id"); 
								   }
							
							
							if(p.contains("de.java_chess") && p!=null && p.equals("")==false && classFROMid!=null && ParameterClassID!=null) {
								st.executeUpdate("INSERT INTO `parameters`(`parametername`, `parametertype`, `parameterclass`,`classid`, `classname`, `methodid`, `methodname`, `isreturn`) VALUES ('"+p +"','" +p +"','"+ParameterClassID+"','"+classFROMid +"','"+ClassFROMName+"','" +callingmethodsrefinedid+"','" +MethodFROM+"','" +0+"')");

							}
					}
				
				//		counter++; 
					
					
					//METHOD TO 
					//calculate class id TO 
					ResultSet classidsTO = st.executeQuery("SELECT classes.id from classes where classes.classname ='"+ClassTO+"'"); 
					while(classidsTO.next()){
						classTOid = classidsTO.getString("id"); 
						   }
					
					//String MethodTORefined= MethodTOTransformed.substring(0, MethodTOTransformed.indexOf("(")); 
					String MethodTORefined= MethodTO;
					String MethodTOAbbreviation = ClassTO+"."+MethodTORefined; 
					if(calledmethodid==null) {
						st.executeUpdate("INSERT INTO `methods`(`methodname`,  `methodnamerefined`,`methodabbreviation`, `classid`, `classname`) VALUES ('"+MethodTO +"','" +MethodTORefined+"','" +MethodTOAbbreviation+"','" +classTOid+"','" +ClassTO+"')");

						//RECALCULATION PHASE: CALLED METHOD ID 
						 calledmethodsids= st.executeQuery("SELECT methods.id from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodname='"+MethodTO+"'and classes.classname='"+ClassTO+"'"); 
						while(calledmethodsids.next()){
							calledmethodid = calledmethodsids.getString("id"); 
							   }
						
						
						
						//calculate class classname FROM 
						ResultSet classnamesTO = st.executeQuery("SELECT classes.classname from classes where classes.classname ='"+ClassTO+"'"); 
						
						while(classnamesTO.next()){
							ClassTOName = classnamesTO.getString("classname"); 
							   }
						 par= transformstring(returnTO); 
						 //insert return value within the parameters table 
						  ResultSet ParameterClassIDs = st.executeQuery("SELECT classes.id from classes where classes.classname='"+par+"'"); 
							while(ParameterClassIDs.next()){
								 ParameterClassID = ParameterClassIDs.getString("id"); 
								   }
						 if(par.contains("de.java_chess")) {//ignore the basic data types, only insert the parameters thaht have classes as data types 
								st.executeUpdate("INSERT INTO `parameters`(`parametername`, `parametertype`, `parameterclass`,`classid`, `classname`, `methodid`, `methodname`, `isreturn`) VALUES ('"+par +"','" +par +"','"+ParameterClassID+"','"+classTOid +"','"+ClassTOName+"','" +calledmethodid+"','" +MethodTO+"','" +1+"')");

						 }
						 
						 //insert parameters that were retrieved from the log file 
						 params = ExtractParams(MethodTO); 
						for(String p: params) {
							System.out.println("HERE IS A PARAM==================================================================>"+p); 
							 ParameterClassIDs= st.executeQuery("SELECT classes.id from classes where classes.classname='"+p+"'"); 
							while(ParameterClassIDs.next()){
								 ParameterClassID = ParameterClassIDs.getString("id"); 
								   }
							
							if(p.contains("de.java_chess")&& p!=null && p.equals("")==false && classTOid!=null && ParameterClassID!=null) {
								st.executeUpdate("INSERT INTO `parameters`(`parametername`, `parametertype`, `parameterclass`,`classid`, `classname`, `methodid`, `methodname`, `isreturn`) VALUES ('"+p +"','" +p +"','"+ParameterClassID+"','"+classTOid +"','"+ClassTOName+"','" +calledmethodid+"','" +MethodTO+"','" +0+"')");

							}
						}
					
					}
				
					
					
					
					/*
					//RECALCULATION PHASE: CALLING METHOD ID 
					 callingmethodsrefined = st.executeQuery("SELECT methods.id from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodnamerefined='"+MethodFROMTransformed+"' and classes.classname='"+ClassFROM+"'"); 
					while(callingmethodsrefined.next()){
						callingmethodsrefinedid = callingmethodsrefined.getString("id"); 
				
					}
					//RECALCULATION PHASE: CALLED METHOD ID 
					 calledmethodsids= st.executeQuery("SELECT methods.id from methods INNER JOIN classes on methods.classname=classes.classname where methods.methodnamerefined='"+MethodTOTransformed+"'and classes.classname='"+ClassTO+"'"); 
					while(calledmethodsids.next()){
						calledmethodid = calledmethodsids.getString("id"); 
						   }*/
					
					//insert into methodcallsexecuted table 
					String fullcaller= ClassFROM+"."+MethodFROM; 
					String fullcallee= ClassTO+"."+MethodTO; 
					String statement = "INSERT INTO `methodcallsexecuted`(`callermethodid`,  `callername`,  `callerclass`,  `fullcaller`,`calleemethodid`,  `calleename`, `calleeclass`,  `fullcallee`) VALUES ('"+callingmethodsrefinedid+"','" +MethodFROM+"','" +ClassFROM+"','"+calledmethodid+"','" +fullcaller +"','" +MethodTO+"','" +ClassTO+"','" +fullcallee +"')";		
					st.executeUpdate(statement);
					methodcallsexecutedlist.add(mce); 	
					
					
				//insert into methodcalls table as well 
//					String statement2 = "INSERT INTO `methodcalls`(`callermethodid`,  `callername`,  `callerclass`,`calleemethodid`,  `calleename`, `calleeclass`) VALUES ('"+callingmethodsrefinedid+"','" +MethodFROM+"','" +ClassFROM+"','"+calledmethodid +"','" +MethodTO+"','" +ClassTO +"')";		
//					st.executeUpdate(statement2);
				
					
					
					
			}
		}
			
		
		
		
		
		
		}	
		
	}
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
////////////
////////////
////////////
////////////
////////////
//////////////System.out.println("Contents of file:");
//////////////System.out.println(stringBuffer.toString());
////////////
/////////////*********************************************************************************************************************************************************************************/	
/////////////*********************************************************************************************************************************************************************************/	
/////////////*********************************************************************************************************************************************************************************/   
//////////////CREATE REQUIREMENTS TABLE 
////////////
 file = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\Requirements.txt");
 fileReader = new FileReader(file);
 bufferedReader = new BufferedReader(fileReader);
 stringBuffer = new StringBuffer();

 
try {
	

	while ((line = bufferedReader.readLine()) != null) {
		System.out.println(line);
		
		
		
	
		
		String statement = "INSERT INTO `requirements`(`requirementname`) VALUES ('"+line+"')";		
		st.executeUpdate(statement);
	
		
		
	}




	}
	
catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
////////////////
/////////////////*********************************************************************************************************************************************************************************/	
/////////////////*********************************************************************************************************************************************************************************/	
/////////////////*********************************************************************************************************************************************************************************/   
//////////////////DUMMY DATA TO BE INSERTED AT THE END OF traces.txt file is found in DummyData.txt file 
////////////////
////////////////
/////////////////*String statement4 = "DELETE FROM `methodcalls` WHERE callername ='"+"CALLER"+"'";		
////////////////st.executeUpdate(statement4);
////////////////
////////////////statement4 = "DELETE FROM `methodcalls` WHERE callername ='"+"CALLER2"+"'";		
////////////////st.executeUpdate(statement4);
////////////////
////////////////
////////////////String statement2 = "DELETE FROM `methods` WHERE id ='"+"741"+"'";		
////////////////st.executeUpdate(statement2);	  
////////////////String statement3 = "DELETE FROM `methods` WHERE id ='"+"742"+"'";		
////////////////st.executeUpdate(statement3);
////////////////statement3 = "DELETE FROM `methods` WHERE id ='"+"743"+"'";		
////////////////st.executeUpdate(statement3);
////////////////statement3 = "DELETE FROM `methods` WHERE id ='"+"744"+"'";		
////////////////st.executeUpdate(statement3);
////////////////
////////////////
////////////////String  statement10 = "ALTER TABLE `methods` AUTO_INCREMENT = 740";		
////////////////st.executeUpdate(statement10);
////////////////
////////////////statement10 = "ALTER TABLE `methodcalls` AUTO_INCREMENT = 404";		
////////////////	 st.executeUpdate(statement10);
////////////////
//////////////// statement10 = "INSERT INTO `methods`(`methodname`, `methodnamerefined`, `methodabbreviation`, `classid`, `classname`) VALUES ('"+"method"+"','" +"method"+"','" +"method"+"','"  +100+"','"+"mmmm" +"')";		
////////////////st.executeUpdate(statement10);
////////////////statement10 = "INSERT INTO `methods`(`methodname`, `methodnamerefined`, `methodabbreviation`, `classid`, `classname`) VALUES ('"+"method2"+"','" +"method2"+"','" +"method2"+"','"  +100+"','"+"mmmm" +"')";		
////////////////st.executeUpdate(statement10);
////////////////
////////////////statement10 = "INSERT INTO `methods`(`methodname`, `methodnamerefined`, `methodabbreviation`, `classid`, `classname`) VALUES ('"+"method3"+"','" +"method3"+"','" +"method3"+"','"  +100+"','"+"mmmm" +"')";		
////////////////st.executeUpdate(statement10);
////////////////statement10 = "INSERT INTO `methods`(`methodname`, `methodnamerefined`, `methodabbreviation`, `classid`, `classname`) VALUES ('"+"method4"+"','" +"method4"+"','" +"method4"+"','"  +100+"','"+"mmmm" +"')";		
////////////////st.executeUpdate(statement10);
////////////////
////////////////statement10 = "INSERT INTO `methodcalls`(`callermethodid`, `callername`, `callerclass`, `calleemethodid`, `calleename`,`calleeclass`) VALUES ('"+741+"','" +"CALLER"+"','" +"CALLER CLASS"+"','" +742+"','" +"CALLEE METH"+"','"+"CALLEE CLASS" +"')";		
////////////////st.executeUpdate(statement10);
////////////////statement10 = "INSERT INTO `methodcalls`(`callermethodid`, `callername`, `callerclass`, `calleemethodid`, `calleename`,`calleeclass`) VALUES ('"+743+"','" +"CALLER"+"','" +"CALLER CLASS"+"','" +742+"','" +"CALLEE METH"+"','"+"CALLEE CLASS" +"')";		
////////////////st.executeUpdate(statement10);
////////////////statement10 = "INSERT INTO `methodcalls`(`callermethodid`, `callername`, `callerclass`, `calleemethodid`, `calleename`,`calleeclass`) VALUES ('"+744+"','" +"CALLER2"+"','" +"CALLER CLASS"+"','" +742+"','" +"CALLEE METH"+"','"+"CALLEE CLASS" +"')";		
////////////////st.executeUpdate(statement10);
////////////////*/
////////////////
////////////////
//////////////////CREATE TRACES TABLE 
//////////////
 file = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\Traces.txt");
 fileReader = new FileReader(file);
 bufferedReader = new BufferedReader(fileReader);
 stringBuffer = new StringBuffer();
 String requirement=null; 
 String method=null; 
 String gold=null; 
 String subject=null; 
 String methodid=null; 
 String classname=null; 
 String classid=null; 
 String requirementid=null; 
String calleeid=null; 
String goldprediction=null; 
String calleeidexecuted=null; 
String callerid=null; 
String callerexecutedid=null; 
 List<tracesmethods> TraceListMethods= new ArrayList<tracesmethods>();
tracesmethodscallees tmc = null; 
int COUNTER3=1; 
try {
	
	line = bufferedReader.readLine(); 
	while ((line = bufferedReader.readLine()) != null) {
		System.out.println(line);
		String[] linesplitted = line.split(","); 
		method=linesplitted[1]; 
		requirement=linesplitted[2]; 
		gold=linesplitted[4]; 
		subject=linesplitted[5]; 
		method=method.replace("/", "."); 
		method=method.replace(";", ","); 
		method=method.replace("Lde", "de"); 
		  int endIndex = method.lastIndexOf(",)");
		    if (endIndex != -1)  
		    {
		    	method = method.substring(0, endIndex)+")"; // not forgot to put check if(endIndex != -1)
		    }
		String shortmethod=method.substring(0, method.indexOf("(")); 
		 String regEx = "[A-Z]";
		    Pattern pattern = Pattern.compile(regEx);
		 
		    String methodname=method.substring(0, method.indexOf("(")); 
		    String methodparam=method.substring(method.indexOf("(")+1, method.indexOf(")")); 
		    Matcher matcher = pattern.matcher(method);
		    while (matcher.find()) {
		    	 System.out.println("Found "+matcher.groupCount());
		    	 method=method.replaceAll("\\(Z\\)", "(boolean)"); 
		    	 method=method.replaceAll("\\(B\\)", "(byte)"); 
		    	 method=method.replaceAll("\\(I\\)", "(int)"); 
		    	 method=method.replaceAll("\\(J\\)", "(long)"); 
		    	 method=method.replaceAll("\\(S\\)", "(short)"); 
		  
		    	 method=method.replaceAll("BLde", "boolean,de");
		    	 
		    	 method=method.replaceAll("Z,", "boolean,"); 
		    	 method=method.replaceAll("B,", "byte,"); 
		    	 method=method.replaceAll("I,", "int,"); 
		    	 method=method.replaceAll("J,", "long,"); 
		    	 method=method.replaceAll("S,", "short,"); 
		    	 
		    	 method=method.replaceAll("\\(Z", "(boolean,"); 
		    	 method=method.replaceAll("\\(B", "(byte,"); 
		    	 method=method.replaceAll("\\(I", "(int,"); 
		    	 method=method.replaceAll("\\(J", "(long,"); 
		    	 method=method.replaceAll("\\(S", "(short,");
		    	 
		    	 method=method.replaceAll("II", "int,int"); 
		    	 
		    	 method=method.replaceAll("IZ", "int,boolean"); 
		    	 
		    	 method=method.replaceAll("Z\\)", ",boolean)"); 
		    	 method=method.replaceAll("B\\)", ",byte)"); 
		    	 method=method.replaceAll("I\\)", ",int)"); 
		    	 method=method.replaceAll("J\\)", ",long)"); 
		    	 method=method.replaceAll("S\\)", ",short)"); 
		    	 
		    	 method=method.replaceAll(",Z", ",boolean"); 
		    	 method=method.replaceAll(",B", ",byte"); 
		    	 method=method.replaceAll(",I", ",int"); 
		    	 method=method.replaceAll(",J", ",long"); 
		    	 method=method.replaceAll(",S", ",short"); 
		    	
		    }
		    method=method.replaceAll("Ljava", "java"); 
		    method=method.replaceAll("Lde", "de");
		    method=method.replaceAll("Lantlr", "antlr");
		    
		    method=method.replaceAll(",,", ","); 
		  //  method=methodname+"("+methodparam+")"; 
		    
		    
//		     regEx = "\\(([A-Z])\\)";
//		     pattern = Pattern.compile(regEx);
//		     matcher = pattern.matcher(method);
//		    while (matcher.find()) {
//		    	method=method.replaceAll("Z", "boolean"); 
//			 method=method.replaceAll("B", "byte"); 
//	    	 method=method.replaceAll("I", "int"); 
//	    	 method=method.replaceAll("J", "long"); 
//	    	 method=method.replaceAll("S", "short"); 
//		    }
		    method=method.substring(0, method.indexOf(")")+1); 
		  String[] parts = method.split("[$]", 2);
		  method=parts[0]; 
		  method=method.replaceAll("clinit", "init"); 
		shortmethod=ParseLine(line); 
//		System.out.println("HERE IS THIS SHORT METHOD========>"+ shortmethod+ "COUNTER"+ COUNTER3); 
		System.out.println("HERE IS THIS long METHOD========>"+ method); 
		
		methodid=null; 
		String myclass= method.substring(0, method.lastIndexOf(".")); 
		method=method.substring(0, method.indexOf(")")+1);

		if(method.contains(",)")) {
			method=method.replaceAll(",\\)", ")");
		}
		
		 shortmethod=ParseLine(line); 
		 
		System.out.println("HERE IS THIS SHORT METHOD========>"+ shortmethod); 
 String goldvalue=null; 
 String subjectvalue=null; 
	
method=method.replaceAll("bytede", "byte,de"); 
method=method.replaceAll("booleanI", "boolean,int"); 
method=method.replaceAll("intshort", "int,short"); 
			ResultSet methodids = st.executeQuery("SELECT methods.* from methods where methods.fullmethod ='"+method+"'"); 
			while(methodids.next()){
				methodid = methodids.getString("id"); 
				classname = methodids.getString("classname"); 
				classid = methodids.getString("classid"); 
				   }
		if(methodid==null) {
			 methodids = st.executeQuery("SELECT methods.* from methods where methods.methodabbreviation ='"+method+"'"); 
			while(methodids.next()){
				methodid = methodids.getString("id"); 
				classname = methodids.getString("classname"); 
				classid = methodids.getString("classid"); 
		}
		}
			if(methodid==null) {
				
				 methodids = st.executeQuery("SELECT methods.* from methods where methods.methodabbreviation ='"+shortmethod+"'"); 
				while(methodids.next()){
					methodid = methodids.getString("id"); 
					classname = methodids.getString("classname"); 
					classid = methodids.getString("classid"); 
			}
			}
//		 classname=null; 
//		ResultSet classnames = st.executeQuery("SELECT methods.classname from methods where methods.methodabbreviation ='"+shortmethod+"'"); 
//		while(classnames.next()){
//			classname = classnames.getString("classname"); 
//			   }
		//COMPUTING INTERFACE CLASS IDS AND INTERFACE NAMES 
		String interfacename=null; 
			ResultSet interfaces = st.executeQuery("SELECT interfaces.interfacename from interfaces where interfaces.classname ='"+classname+"'"); 
			while(interfaces.next()){
				interfacename = interfaces.getString("interfacename"); 
				   }
			String interfaceid=null; 
			ResultSet interfacesids = st.executeQuery("SELECT interfaces.interfaceclassid from interfaces where interfaces.interfacename ='"+interfacename+"'"); 
			while(interfacesids.next()){
				interfaceid = interfacesids.getString("interfaceclassid"); 
				   }
			
			//////////////////////////////////////////////////////////////////
			
			
//		classid=null; 
//		ResultSet classids = st.executeQuery("SELECT methods.classid from methods where methods.methodabbreviation ='"+shortmethod+"'"); 
//		while(classids.next()){
//			classid = classids.getString("classid"); 
//			   }
		requirementid=null; 
		ResultSet requirements = st.executeQuery("SELECT requirements.id from requirements where requirements.requirementname ='"+requirement+"'"); 
		while(requirements.next()){
			requirementid = requirements.getString("id"); 
			   }
		// Rule: if method A calls method B and method A implements requirement X, then I can just assume that method B implements requirement X as well 
		// Retrieving the calleeid
		calleeid=null; 
			ResultSet calleesparsed = st.executeQuery("SELECT methodcalls.calleemethodid from methodcalls where methodcalls.callermethodid ='"+methodid+"'"); 
			while(calleesparsed.next()){
				 calleeid = calleesparsed.getString("calleemethodid"); }
			calleeidexecuted=null; 	   
			ResultSet calleesexecuted = st.executeQuery("SELECT methodcallsexecuted.calleemethodid from methodcallsexecuted where methodcallsexecuted.callermethodid ='"+methodid+"'"); 
			while(calleesexecuted.next()){
				 calleeidexecuted = calleesexecuted.getString("calleemethodid"); 
				   }
			callerid=null; 
			ResultSet callersparsed = st.executeQuery("SELECT methodcalls.callermethodid from methodcalls where methodcalls.calleemethodid ='"+methodid+"'"); 
			while(callersparsed.next()){
				  callerid = callersparsed.getString("callermethodid"); }
			callerexecutedid=null; 	   
			ResultSet callersexecuted = st.executeQuery("SELECT methodcallsexecuted.callermethodid from methodcallsexecuted where methodcallsexecuted.calleemethodid ='"+methodid+"'"); 
			while(callersexecuted.next()){
				 callerexecutedid = callersexecuted.getString("callermethodid"); 
				   }
	
		
		//insert into tracesmethodscallees a new object: if is found in the methodcalls table, then use the value from there 
		//otherwise, use the value from the methodcallsexecuted table 
			if(calleeid!=null && requirementid!=null) {
				 tmc= new tracesmethodscallees(requirement, requirementid, shortmethod, methodid, classname, classid, gold, subject, calleeid); 
				 TracesCalleesList.add(tmc); 
			}
			else if(calleeidexecuted!=null) {
				 tmc= new tracesmethodscallees(requirement, requirementid, shortmethod, methodid, classname, classid, gold, subject, calleeidexecuted); 
				 TracesCalleesList.add(tmc); 
			}
			
			if(calleeid!=null && requirementid!=null) {
				 tmc= new tracesmethodscallees(requirement, requirementid, shortmethod, methodid, classname, classid, gold, subject, callerid); 
				 TracesCallersList.add(tmc); 
			}
			else if(calleeidexecuted!=null) {
				 tmc= new tracesmethodscallees(requirement, requirementid, shortmethod, methodid, classname, classid, gold, subject, callerexecutedid); 
				 TracesCallersList.add(tmc); 
			}
			
			
			
		tracesmethods tr= new tracesmethods(requirement, requirementid, shortmethod, methodid, classname, classid, gold, subject); 
		if(methodid!=null && requirementid!=null ) {
			if(tr.contains(TraceListMethods, tr)==false) {
				  
				String statement = "INSERT INTO `traces`(`requirement`, `requirementid`, `method`, `fullmethod`, `methodid`,`classname`, `classid`, `gold`,  `subject`, `goldpredictioncallee`, `goldpredictioncaller`) VALUES ('"+requirement+"','" +requirementid+"','" +shortmethod+"','" +method+"','" +methodid+"','"+classname +"','" +classid+"','"+gold +"','" +subject+"','" +goldprediction+"','" +goldprediction+"')";		
				st.executeUpdate(statement);
				TraceListMethods.add(tr); 
				
				
			}
			
			
		}
		//ADDING INTERFACES TO THE TRACES TABLE 
		 if(methodid!=null && requirementid!=null && interfacename!=null) {
			 System.out.println("SHORT METHOD: " +shortmethod);
			 System.out.println(" METHOD ID: " +methodid);
			tracesmethods tracesmethods= new tracesmethods(requirement, requirementid, method, methodid, interfacename, interfaceid, gold, subject); 
			if(tr.contains(TraceListMethods, tracesmethods)==false) {
				  
				String statement = "INSERT INTO `traces`(`requirement`, `requirementid`, `method`, `fullmethod`, `methodid`,`classname`, `classid`, `gold`,  `subject`, `goldpredictioncallee`, `goldpredictioncaller`) VALUES ('"+requirement+"','" +requirementid+"','" +shortmethod+"','" +method+"','" +methodid+"','"+interfacename +"','" +interfaceid+"','"+gold +"','" +subject+"','" +goldprediction+"','" +goldprediction+"')";		
				st.executeUpdate(statement);
				TraceListMethods.add(tracesmethods); 
				
				
			}
		}
		else {
			System.out.println(shortmethod);
			System.out.println("I am here");
		}
		
		
		
		
	
		COUNTER3++; 
		
	}
	
	
	/*String filename= "TracesCalleesList.txt"; 
	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
		oos.writeObject(TracesCalleesList);
		oos.flush();
		oos.close();*/
}
	
catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
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
List<RequirementClassKey> RequirementClassKeys= new ArrayList<RequirementClassKey>(); 
Hashtable<String,String> RequirementClassHashMap=new Hashtable<String,String>(); 

try {
	int counter2=1; 
		file = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\Traces.txt");
		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);	
		line = bufferedReader.readLine(); 
		Hashtable<RequirementClassKey,String> GoldHashTable=new Hashtable<RequirementClassKey,String>();  
		Hashtable<RequirementClassKey,String> SubjectHashTable=new Hashtable<RequirementClassKey,String>(); 
		
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
			String[] linesplitted = line.split(","); 
			method=linesplitted[1]; 
			requirement=linesplitted[2]; 
			gold=linesplitted[4]; 
			subject=linesplitted[5]; 
			method=method.replace("/", "."); 
			method=method.replace(";", ","); 
			method=method.replace("Lde", "de"); 
			  int endIndex = method.lastIndexOf(",)");
			    if (endIndex != -1)  
			    {
			    	method = method.substring(0, endIndex)+")"; // not forgot to put check if(endIndex != -1)
			    }
			String shortmethod=method.substring(0, method.indexOf("(")); 
			 String regEx = "[A-Z]";
			    Pattern pattern = Pattern.compile(regEx);
			 
			    String methodname=method.substring(0, method.indexOf("(")); 
			    String methodparam=method.substring(method.indexOf("(")+1, method.indexOf(")")); 
			    Matcher matcher = pattern.matcher(method);
			    while (matcher.find()) {
			    	 System.out.println("Found "+matcher.groupCount());
			    	 method=method.replaceAll("\\(Z\\)", "(boolean)"); 
			    	 method=method.replaceAll("\\(B\\)", "(byte)"); 
			    	 method=method.replaceAll("\\(I\\)", "(int)"); 
			    	 method=method.replaceAll("\\(J\\)", "(long)"); 
			    	 method=method.replaceAll("\\(S\\)", "(short)"); 
			  
			    	 method=method.replaceAll("BLde", "boolean,de");
			    	 
			    	 method=method.replaceAll("Z,", "boolean,"); 
			    	 method=method.replaceAll("B,", "byte,"); 
			    	 method=method.replaceAll("I,", "int,"); 
			    	 method=method.replaceAll("J,", "long,"); 
			    	 method=method.replaceAll("S,", "short,"); 
			    	 
			    	 method=method.replaceAll("\\(Z", "(boolean,"); 
			    	 method=method.replaceAll("\\(B", "(byte,"); 
			    	 method=method.replaceAll("\\(I", "(int,"); 
			    	 method=method.replaceAll("\\(J", "(long,"); 
			    	 method=method.replaceAll("\\(S", "(short,");
			    	 
			    	 method=method.replaceAll("II", "int,int"); 
			    	 method=method.replaceAll("IZ", "int,boolean"); 
			    	 
			    	 
			    	 method=method.replaceAll("Z\\)", ",boolean)"); 
			    	 method=method.replaceAll("B\\)", ",byte)"); 
			    	 method=method.replaceAll("I\\)", ",int)"); 
			    	 method=method.replaceAll("J\\)", ",long)"); 
			    	 method=method.replaceAll("S\\)", ",short)"); 
			    	 
			    	 method=method.replaceAll(",Z", ",boolean"); 
			    	 method=method.replaceAll(",B", ",byte"); 
			    	 method=method.replaceAll(",I", ",int"); 
			    	 method=method.replaceAll(",J", ",long"); 
			    	 method=method.replaceAll(",S", ",short"); 
			    	
			    }
			    method=method.replaceAll("Ljava", "java"); 
			    method=method.replaceAll("Lde", "de");
			    method=method.replaceAll("Lantlr", "antlr");
			    
			    method=method.replaceAll(",,", ","); 
			  //  method=methodname+"("+methodparam+")"; 
			    
			    
//			     regEx = "\\(([A-Z])\\)";
//			     pattern = Pattern.compile(regEx);
//			     matcher = pattern.matcher(method);
//			    while (matcher.find()) {
//			    	method=method.replaceAll("Z", "boolean"); 
//				 method=method.replaceAll("B", "byte"); 
//		    	 method=method.replaceAll("I", "int"); 
//		    	 method=method.replaceAll("J", "long"); 
//		    	 method=method.replaceAll("S", "short"); 
//			    }
			    method=method.substring(0, method.indexOf(")")+1); 
			  String[] parts = method.split("[$]", 2);
			  method=parts[0]; 
			  method=method.replaceAll("clinit", "init"); 
			shortmethod=ParseLine(line); 
//			System.out.println("HERE IS THIS SHORT METHOD========>"+ shortmethod+ "COUNTER"+ COUNTER3); 
			System.out.println("HERE IS THIS long METHOD========>"+ method); 
			
			methodid=null; 
			String  myclass= method.substring(0, method.lastIndexOf(".")); 
			method=method.substring(0, method.indexOf(")")+1);

			if(method.contains(",)")) {
				method=method.replaceAll(",\\)", ")");
			}
			
			 shortmethod=ParseLine(line); 
			 
			System.out.println("HERE IS THIS SHORT METHOD========>"+ shortmethod+ "COUNTER222: "+counter2); 
	 String goldvalue=null; 
	 String subjectvalue=null; 
		
	method=method.replaceAll("bytede", "byte,de"); 
	method=method.replaceAll("booleanI", "boolean,int"); 
	method=method.replaceAll("intshort", "int,short"); 

//	classname=null; 
//	ResultSet classnames = st.executeQuery("SELECT methods.classname from methods where methods.methodabbreviation ='"+shortmethod+"'"); 
//	while(classnames.next()){
//		classname = classnames.getString("classname"); 
//		   }
//	classid=null; 
//	ResultSet classids = st.executeQuery("SELECT methods.classid from methods where methods.methodabbreviation ='"+shortmethod+"'"); 
//	while(classids.next()){
//		classid = classids.getString("classid"); 
//		   }
	
	
	classname=null; 
	ResultSet classnames = st.executeQuery("SELECT methods.classname from methods where methods.fullmethod ='"+method+"'"); 
	while(classnames.next()){
		classname = classnames.getString("classname"); 
		   }
	classid=null; 
	ResultSet classids = st.executeQuery("SELECT methods.classid from methods where methods.fullmethod ='"+method+"'"); 
	while(classids.next()){
		classid = classids.getString("classid"); 
		   }
	String interfacename=null; 
	ResultSet interfaces = st.executeQuery("SELECT interfaces.interfacename from interfaces where interfaces.classname LIKE'%"+classname+"%'");
	while(interfaces.next()){
		interfacename = interfaces.getString("interfacename"); 
		   }
	String interfaceid=null; 
	ResultSet interfacesids = st.executeQuery("SELECT interfaces.interfaceclassid from interfaces where interfaces.interfacename LIKE'%"+interfacename+"%'"); 
	while(interfacesids.next()){
		interfaceid = interfacesids.getString("interfaceclassid"); 
		   } 
	requirement=requirement.trim(); 
	requirementid=null; 
	ResultSet requirements = st.executeQuery("SELECT requirements.id from requirements where requirements.requirementname ='"+requirement+"'"); 
	while(requirements.next()){
		requirementid = requirements.getString("id"); 
		   }	
	

	goldvalue=null; 
	List<String> goldvaluesList= new ArrayList<String>();
	ResultSet goldvalues = st.executeQuery("SELECT traces.gold from traces where traces.requirementid ='"+requirementid+"' and traces.classid='"+classid+"'"); 
	 while(goldvalues.next()){
			goldvalue = goldvalues.getString("gold"); 

		    goldvalue=goldvalue.trim();
			goldvaluesList.add(goldvalue);
			   }
	 
	 subjectvalue=null; 
	 List<String> subjectvaluesList= new ArrayList<String>();
		ResultSet subjectvalues = st.executeQuery("SELECT traces.subject from traces where traces.requirementid ='"+requirementid+"' and traces.classid='"+classid+"'"); 
		while(subjectvalues.next()){
			subjectvalue = subjectvalues.getString("subject"); 

			subjectvalue=subjectvalue.trim();
			subjectvaluesList.add(subjectvalue);
			   }
		String ReqClass=requirementid+"-"+classid;
		if(requirementid!=null && classid!=null && RequirementClassHashMap.containsKey(ReqClass)==false) {
			
	 //1 TT
			
		if(goldvaluesList.contains("T") && subjectvaluesList.contains("T")) {
			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"T" +"','" +"T"+"')";	
			RequirementClassHashMap.put(ReqClass, "TT");
			st.executeUpdate(statement8);

	 }
	 //2 ET
	 else if(goldvaluesList.contains("E") && subjectvaluesList.contains("T")) {
			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"E" +"','" +"T"+"')";	
			RequirementClassHashMap.put(ReqClass, "ET");

			st.executeUpdate(statement8);

	 }
	 //3 TE
	 else if(goldvaluesList.contains("T") && subjectvaluesList.contains("E")) {
			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"T" +"','" +"E"+"')";	
			RequirementClassHashMap.put(ReqClass, "TE");

			st.executeUpdate(statement8);

	 }
	 //4 NN
	 else if((goldvaluesList.contains("T")==false && goldvaluesList.contains("E")==false )&& (subjectvaluesList.contains("T")==false && subjectvaluesList.contains("E")==false )) {
			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"N" +"','" +"N"+"')";	
			RequirementClassHashMap.put(ReqClass, "NN");

			st.executeUpdate(statement8);

	 }
	 //5 NT
	 else if((goldvaluesList.contains("T")==false && goldvaluesList.contains("E")==false )&& subjectvaluesList.contains("T")) {
			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"N" +"','" +"T"+"')";	
			RequirementClassHashMap.put(ReqClass, "NT");

			st.executeUpdate(statement8);

	 }
	 //6 EN
	 else if( goldvaluesList.contains("E") && (subjectvaluesList.contains("T")==false && subjectvaluesList.contains("E")==false )) {
			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"E" +"','" +"N"+"')";	
			RequirementClassHashMap.put(ReqClass, "EN");

			st.executeUpdate(statement8);

	 }
		//7 NE
	 else if( (goldvaluesList.contains("T")==false && goldvaluesList.contains("E")==false ) && (subjectvaluesList.contains("E") )) {
			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"N" +"','" +"E"+"')";	
			RequirementClassHashMap.put(ReqClass, "NE");

			st.executeUpdate(statement8);

	 }
		 //8 TN
	 else if(goldvaluesList.contains("T") && (subjectvaluesList.contains("T")==false && subjectvaluesList.contains("E")==false )) {
			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"T" +"','" +"N"+"')";	
			RequirementClassHashMap.put(ReqClass, "TN");

			st.executeUpdate(statement8);

	 }
		 // 9 EE
	 else if(goldvaluesList.contains("E") && subjectvaluesList.contains("E")) {
			String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +classname+"','" +classid+"','"+"E" +"','" +"E"+"')";	
			RequirementClassHashMap.put(ReqClass, "EE");

			st.executeUpdate(statement8);

	 }
		}
		
		 ReqClass=requirementid+"-"+interfaceid;
		//ADDING INTERFACES TO THE TRACES CLASSES TABLE 
		if(interfaceid!=null && interfacename!=null && RequirementClassHashMap.containsKey(ReqClass)==false) {
			
			 //1 TT
				if(goldvaluesList.contains("T") && subjectvaluesList.contains("T")) {
					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"T" +"','" +"T"+"')";	
					st.executeUpdate(statement8);
					RequirementClassHashMap.put(ReqClass, "TT");

			 }
			 //2 ET
			 else if(goldvaluesList.contains("E") && subjectvaluesList.contains("T")) {
					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"E" +"','" +"T"+"')";	
					st.executeUpdate(statement8);
					RequirementClassHashMap.put(ReqClass, "ET");

			 }
			 //3 TE
			 else if(goldvaluesList.contains("T") && subjectvaluesList.contains("E")) {
					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"T" +"','" +"E"+"')";	
					st.executeUpdate(statement8);
					RequirementClassHashMap.put(ReqClass, "TE");

			 }
			 //4 NN
			 else if((goldvaluesList.contains("T")==false && goldvaluesList.contains("E")==false )&& (subjectvaluesList.contains("T")==false && subjectvaluesList.contains("E")==false )) {
					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"N" +"','" +"N"+"')";	
					st.executeUpdate(statement8);
					RequirementClassHashMap.put(ReqClass, "NN");


			 }
			 //5 NT
			 else if((goldvaluesList.contains("T")==false && goldvaluesList.contains("E")==false )&& subjectvaluesList.contains("T")) {
					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"N" +"','" +"T"+"')";	
					st.executeUpdate(statement8);
					RequirementClassHashMap.put(ReqClass, "NT");

			 }
			 //6 EN
			 else if( goldvaluesList.contains("E") && (subjectvaluesList.contains("T")==false && subjectvaluesList.contains("E")==false )) {
					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"E" +"','" +"N"+"')";	
					st.executeUpdate(statement8);
					RequirementClassHashMap.put(ReqClass, "EN");

			 }
				//7 NE
			 else if( (goldvaluesList.contains("T")==false && goldvaluesList.contains("E")==false ) && (subjectvaluesList.contains("E") )) {
					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"N" +"','" +"E"+"')";	
					st.executeUpdate(statement8);
					RequirementClassHashMap.put(ReqClass, "NE");

			 }
				 //8 TN
			 else if(goldvaluesList.contains("T") && (subjectvaluesList.contains("T")==false && subjectvaluesList.contains("E")==false )) {
					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"T" +"','" +"N"+"')";	
					st.executeUpdate(statement8);
					RequirementClassHashMap.put(ReqClass, "TN");
			 }			

				 // 9 EE
			 else if(goldvaluesList.contains("E") && subjectvaluesList.contains("E")) {
					String statement8= "INSERT INTO `tracesclasses`(`requirement`, `requirementid`,  `classname`, `classid`, `gold`,  `subject`) VALUES ('"+requirement+"','" +requirementid+"','"  +interfacename+"','" +interfaceid+"','"+"E" +"','" +"E"+"')";	
					st.executeUpdate(statement8);
					RequirementClassHashMap.put(ReqClass, "EE");
			 }
				
		
		}
	 
	
		
	

		
	
counter2++; 


		}
	
	
	
	
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
	
public List<tracesmethodscallees> GetList() {
			return TracesCalleesList; 
}
}
