package JHotDraw;

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
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.pattern.FullLocationPatternConverter;

import Chess.param;
import Gantt.DBDemo3Gantt;
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
import spoon.reflect.visitor.filter.FieldAccessFilter;
import spoon.reflect.visitor.filter.TypeFilter;


public class SpoonIssue {



	
	
	public SpoonIssue() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */

	
	/**
	 * Connect to MySQL and do some stuff.
	 * @throws SQLException 
	 */
	public void run() throws SQLException {
		ResultSet rs = null; 
		
		   try {
			Spoon();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		  
		   
		   
		
	    }
		
		
	
	
	/**
	 * Connect to the DB and do some stuff
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, SQLException {
		SpoonIssue app = new SpoonIssue();
		Spoon(); 
		
	}
	
	public static void Spoon() throws SQLException, FileNotFoundException {
		SpoonIssue dao = new SpoonIssue();
	
	
	
	    
		SpoonAPI spoon = new Launcher();
    	//spoon.addInputResource("C:\\Users\\mouna\\ownCloud\\Share\\src_jhotdraw");
    	spoon.addInputResource("C:\\Users\\mouna\\ownCloud\\Share\\src_jhotdraw");

    	
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


///////////////*********************************************************************************************************************************************************************************/	
///////////////*********************************************************************************************************************************************************************************/	
///////////////*********************************************************************************************************************************************************************************/   	
////////////////BUILD METHODSCALLED TABLE
    	int counter=1; 
    	
    	
    	String calleeDeclaringTypeName=null; 
    	
    List<methodcalls> methodcallsList = new ArrayList<methodcalls>(); 
    for(CtType<?> clazz : classFactory.getAll(true)) {
     
    	   
    for(CtMethod<?> method :clazz.getMethods()) {
    	List<CtConstructorCall> ctNewClasses = method.getElements(new TypeFilter<CtConstructorCall>(CtConstructorCall.class));
    	
    	for( CtConstructorCall myclass: ctNewClasses) {
    		//CONSTRUCTOR 
			String methodinside=null; 
			String methodinsideclass=null; 
			String MethodIDINSIDE =null; 
			String CLASSNAMEINSIDE = null; 
			String CLASSIDINSIDE = null; 
			String MethodIDInvoked=null; 
			String  CLASSNAMEInvoked =null; 
			String CLASSIDInvoked=null; 
			//the line below is retrieving new runnable()
    		if(myclass instanceof CtConstructorCall<?>) {
    			
    			//the line below is retrieving the method run()
    			List<CtMethod> methoddeclared = myclass.getElements(new TypeFilter<CtMethod>(CtMethod.class)); 
    			for(CtMethod<?> meth: methoddeclared) {
    				 methodinside=meth.getSignature(); 
    				 methodinsideclass=clazz.getQualifiedName(); 
    				
    				String mymethod=methodinsideclass+"."+methodinside; 
    				
    				
    			
        			
        			
        			
        		/////////////////////////////////////////////////////////////////////	
        			//the block below is retrieving the constructor calls made from run to constructors 
        	   		List<CtConstructorCall> constructorcalls = meth.getElements(new TypeFilter<CtConstructorCall>(CtConstructorCall.class)); 
        			for(CtConstructorCall<?> invo: constructorcalls) {	
        				System.out.println(invo);
        				String methodInvoked=invo.getExecutable().getSignature(); 
        				System.out.println(methodInvoked);
        				String constructorclass=invo.getExecutable().getDeclaringType().toString(); 
        			
        			
        			}
    		
    		
    		
    	
    		
    	
    	
    		
    	}
    }




   
    	}
    	}
    }  		    		
    
	}
	

	

}