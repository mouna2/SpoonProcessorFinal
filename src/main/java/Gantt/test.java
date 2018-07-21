package Gantt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import Tables.RequirementClassKey;

public class test {

	public static void main(String[] args) {
	
		
		
		
		// TODO Auto-generated method stub
		List<RequirementClassKey> RequirementClassKeys= new ArrayList<RequirementClassKey>(); 
		Hashtable<String,String> RequirementClassHashMap=new Hashtable<String,String>(); 

		try {
			int counter2=1; 
			 File file = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\GanttFiles\\TracesGanttFinal.txt");
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);	
				String line = bufferedReader.readLine(); 
				Hashtable<RequirementClassKey,String> GoldHashTable=new Hashtable<RequirementClassKey,String>();  
				Hashtable<RequirementClassKey,String> SubjectHashTable=new Hashtable<RequirementClassKey,String>(); 
				
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
					String[] linesplitted = line.split(","); 
					String method = linesplitted[1]; 
					String requirement = linesplitted[2]; 
					String gold = linesplitted[4]; 
					String subject = linesplitted[5]; 
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
					    String[] words = methodparam.split("(?<!^)(?=[A-Z])");
					    Matcher matcher = pattern.matcher(methodparam);
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
					    method=method.replaceAll("ILnet", "int,net"); 
					    method=method.replaceAll("Lnet", "net"); 
					    method=method.replaceAll("Lorg", "org"); 
					    method=method.replaceAll("Ljava", "java"); 
					    method=method.replaceAll("Lde", "de");
					    method=method.replaceAll("Lantlr", "antlr");
					    method=method.replaceAll("ZI", "boolean,int");
					    method=method.replaceAll("I", "int");
					    method=method.replaceAll(",,", ","); 
					  //  method=methodname+"("+methodparam+")"; 
					    
					    
//					     regEx = "\\(([A-Z])\\)";
//					     pattern = Pattern.compile(regEx);
//					     matcher = pattern.matcher(method);
//					    while (matcher.find()) {
//					    	method=method.replaceAll("Z", "boolean"); 
//						 method=method.replaceAll("B", "byte"); 
//				    	 method=method.replaceAll("I", "int"); 
//				    	 method=method.replaceAll("J", "long"); 
//				    	 method=method.replaceAll("S", "short"); 
//					    }
					    method=method.substring(0, method.indexOf(")")+1); 
					  String[] parts = method.split("[$]", 2);
					  method=parts[0]; 
					  method=method.replaceAll("clinit", "init"); 
				
			
			
				}	
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	}

	public String ParseLine(String line) {
		System.out.println(line);
		String[] linesplitted = line.split(","); 
		String method = linesplitted[1]; 
		String requirement = linesplitted[2]; 
		String gold = linesplitted[4]; 
		String subject = linesplitted[5]; 
		System.out.println("HERE IS THIS SHORT METHOD========>"+ method); 
		
		String shortmethod=method; 
		String regex = "(.)*(\\d)(.)*";      
		Pattern pattern = Pattern.compile(regex);
		boolean containsNumber = pattern.matcher(shortmethod).matches();
		String[] firstpart;
		String FinalMethod = null;
		shortmethod=shortmethod.replaceAll("clinit", "init"); 
		if(shortmethod.contains("$") && shortmethod.matches(".*\\d+.*")) {
			 shortmethod=method.substring(0, method.indexOf("("));
			 firstpart = shortmethod.split("\\$");
			String myfirstpart= firstpart[0]; 
			FinalMethod=myfirstpart; 
			if(firstpart.length>=2) {
				if(StringUtils.isNumeric(firstpart[1])==false) {
					String[] secondpart = firstpart[1].split("\\d"); 
					System.out.println("my first part "+ myfirstpart+ "firstpart"+ firstpart[1]);
					FinalMethod=myfirstpart; 
					if(secondpart.length>=2) {
						String mysecondpart=secondpart[1]; 
						
						 FinalMethod=FinalMethod+mysecondpart; 
					}
					
					System.out.println("FINAL RESULT:    "+FinalMethod);
				}
			}
			
			
		}
		else if(shortmethod.contains("$(") && containsNumber==false) {
			 shortmethod=method.substring(0, method.indexOf("("));
			 firstpart = shortmethod.split("\\$");
			
			System.out.println("FINAL STRING:   "+firstpart[0]);
			
			 FinalMethod= firstpart[0]; 
			System.out.println("FINAL STRING:   "+FinalMethod);
		}
		else if(shortmethod.contains("$") && containsNumber==false) {
			 shortmethod=method.substring(0, method.indexOf("("));
			 firstpart = shortmethod.split("\\$");
			
			System.out.println("FINAL STRING:   "+firstpart[0]);
			 
			for(int i=1; i<firstpart.length; i++) {
				if(firstpart[i].contains(".")) {
					firstpart[i]=firstpart[i].substring(firstpart[i].indexOf("."), firstpart[i].length()); 
					FinalMethod=FinalMethod+firstpart[i]; 
				}
					
					
				System.out.println("FINAL STRING:   "+firstpart[1]);
			}
			
			 FinalMethod= firstpart[0]+FinalMethod; 
			System.out.println("FINAL STRING:   "+FinalMethod);
		}
		else {
			 shortmethod=method.substring(0, method.indexOf("("));
			FinalMethod=shortmethod; 
		}
		return FinalMethod; 
	}
	
	
	
}
