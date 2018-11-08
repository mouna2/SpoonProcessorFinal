package Chess;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.table.*;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.maven.model.Model;
import org.eclipse.swt.widgets.Table;

import mypackage.ClassField2;
import mypackage.ClassRepresentation2;
import mypackage.ClassTrace2;
import mypackage.ColumnGroup;
import mypackage.DatabaseReading2;
import mypackage.GroupableTableHeader;
import mypackage.Interface2;
import mypackage.Method2Details;
import mypackage.Method2Representation;
import mypackage.MethodField2;
import mypackage.MethodTrace2;
import mypackage.Parameter2;
import mypackage.Requirement2;
import mypackage.RequirementGold;
import mypackage.SuperClass2;

public class ComparisonExecutedParsedMethodCalls extends JFrame {
	

	
	ClassTrace2 myclasstrace = new ClassTrace2();
	static List<MethodTrace2> methodtraces2 = new ArrayList<MethodTrace2>();
	static List<ClassTrace2> classtraces2 = new ArrayList<ClassTrace2>();
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass = new  LinkedHashMap<String, ClassTrace2>(); 
	 LinkedHashMap<String, ClassTrace2> methodtracesRequirementClassGOLD2 = new  LinkedHashMap<String, ClassTrace2>(); 

	 LinkedHashMap<String, Method2Details> linkedmethodhashmap= new LinkedHashMap<String, Method2Details>(); 
	 HashMap<String, Interface2> InterfacesHashMap= new HashMap<String, Interface2>();
	 HashMap<String, Interface2> InterfacesHashMapAlreadyImpl= new HashMap<String, Interface2>(); 
	 HashMap<String, List<Interface2>>  InterfacesOwnerClassHashMap= new HashMap<String, List<Interface2>>(); 
	 HashMap<String, List< MethodField2>>  FieldMethodsHashMap= new HashMap<String, List< MethodField2>>(); 
	 HashMap<String, List< ClassField2>> FieldClassesHashMap=  new HashMap<String, List< ClassField2>>(); 
	 HashMap<String, List< SuperClass2>> SuperclassesHashMap=  new HashMap<String, List< SuperClass2>>(); 
	JTable table = new JTable(); 
	static List<Method2Details> methodlist = new ArrayList<Method2Details>();
	//File fout = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\TableLog.txt");
	File fout = new File("C:\\Users\\mouna\\dumps\\Comparison.txt");
	FileOutputStream fos = new FileOutputStream(fout);
	BufferedWriter bwGold = new BufferedWriter(new OutputStreamWriter(fos));

	
	
	private final String userName = "root";
	private final String password = "123456";
	List<Method2Representation> CallerMethodListFinal = new ArrayList<Method2Representation>();
	List<Method2Representation> CalleeMethodListFinal = new ArrayList<Method2Representation>();

	public List<Method2Representation> getCallerMethodListFinal() {
		return CallerMethodListFinal;
	}

	public void setCallerMethodListFinal(List<Method2Representation> callerMethodListFinal) {
		CallerMethodListFinal = callerMethodListFinal;
	}

	public List<Method2Representation> getCalleeMethodListFinal() {
		return CalleeMethodListFinal;
	}

	public void setCalleeMethodListFinal(List<Method2Representation> calleeMethodListFinal) {
		CalleeMethodListFinal = calleeMethodListFinal;
	}

	public ComparisonExecutedParsedMethodCalls() throws SQLException, IOException {
	
		
		DatabaseReading2 db = new DatabaseReading2();
		DatabaseReading2.MakePredictions();
		methodtraces2 = db.getMethodtraces2();
	//	methodlist = db.getMethodlist();
		 InterfacesHashMap = db.getInterfaces();
		  linkedmethodhashmap = db.getLinkedmethodhashmap(); 
		  InterfacesHashMapAlreadyImpl = db.getInterfacehashmapAlreadyImpl();
		  //INTERFACES 
		  InterfacesOwnerClassHashMap = db.getInterfacehashmapOwnerClass(); 
		  //FIELD METHODS 
		  //FIELD CLASSES 
		  //SUPERCLASSES
		  
		  
		List<TableCellEditor> editors1 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> editors2 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> editors3 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> editors4 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> myparametersEditor = new ArrayList<TableCellEditor>(methodtraces2.size());

		int j = 0;
		final int jfinal=0; 
		String[] items1 = new String[methodtraces2.size()];
		String[] items2 = new String[methodtraces2.size()];
		String[] items3 = new String[methodtraces2.size()];
		String[] items4 = new String[methodtraces2.size()];
		String[] items5 = new String[methodtraces2.size()];
		String[] items6 = new String[methodtraces2.size()];
		String[] myparameters = new String[methodtraces2.size()];
		Method2Representation[] callersarr = new Method2Representation[methodtraces2.size()];
		Method2Representation[] callersex = new Method2Representation[methodtraces2.size()];
		Method2Representation[] calleesarr = new Method2Representation[methodtraces2.size()];
		Method2Representation[] calleesex = new Method2Representation[methodtraces2.size()];
		Object[][] data = new Object[methodtraces2.size()][400];
		int myfinalcounter=1; 
		int MethodTraceCountGold=0; 
		int ClassTraceCount=0; 
		int MethodTraceCountGold2=0; 
		int BOTHPARSEDANDEXEC=0; 
		int INTERFACE=0; 
		int ONLYPARSED=0; 
		int BOTHPARSEDANDEXEC2=0; 
		int INTERFACEEXEC=0; 
		int ONLYEXEC=0; 
		HashMap <String, String> mapOnlyParsed = new HashMap <String, String>(); 
		HashMap <String, String> mapOnlyExec = new HashMap <String, String>(); 
		HashMap <String, String> mapBothParsedAndExec2 = new HashMap <String, String>(); 
		HashMap <String, String> mapBothParsedAndExec1 = new HashMap <String, String>(); 
		HashMap <String, String> mapInterfaceExec = new HashMap <String, String>(); 
		HashMap <String, String> mapInterfaceParsed = new HashMap <String, String>(); 
		HashMap <String, String> mapOnlyParsedCaller = new HashMap <String, String>(); 
		HashMap <String, String> mapOnlyExecCaller = new HashMap <String, String>(); 
		HashMap <String, String> mapInterfaceExecCaller = new HashMap <String, String>(); 
		HashMap <String, String> mapBothParsedAndExecCaller = new HashMap <String, String>(); 
		// Create the editors to be used for each row
		for (MethodTrace2 methodtrace : methodtraces2) {
			List<Method2Representation> mycalleeslist = methodtrace.getCalleesList(); 
			List<Method2Representation> mycalleeslistexecuted = methodtrace.getCalleesListExecuted(); 
			
			List<Method2Representation> mycallerslist = methodtrace.getCallersList(); 
			List<Method2Representation> mycallerslistexecuted = methodtrace.getCallersListExecuted(); 
			
			
			mycalleeslist = mycalleeslist.stream().filter(t -> t != null).collect(Collectors.toList()); 
			mycalleeslistexecuted = mycalleeslistexecuted.stream().filter(t -> t != null).collect(Collectors.toList()); 
			
			
			
			for(Method2Representation mymeth: mycalleeslist) {
				boolean entered1=false; 
				for(Method2Representation mymeth2: mycalleeslistexecuted) {
					String key2= methodtrace.MethodRepresentation.methodid+"-"+mymeth.methodid; 
					if(mapBothParsedAndExec1.get(key2)!=null) {
						entered1=true; 
					}
					else if(mymeth.classrep.classid.equals(mymeth2.classrep.classid) && mymeth.methodid.equals(mymeth2.methodid)) {
						BOTHPARSEDANDEXEC++; 
						entered1=true; 
						
						mapBothParsedAndExec1.put(key2, ""); 
						
					}
					
					
				}
				
				if(entered1==false) {
//					System.out.println("CALLEE PARSED "+ mymeth);
//					System.out.println("METHOD  "+methodtrace);
//					System.out.println(mymeth.classrep.classid);
//					System.out.println(mymeth.classrep.classname);
				String key=mymeth.classrep.classid+"-"+mymeth.classrep.classname; 
//				System.out.println(key);
				Interface2 val = InterfacesHashMap.get(key); 
				boolean entered2=false; 
				if(val!=null) {
					for(Method2Representation mymeth2: mycalleeslistexecuted) {
//						System.out.println("hey");
//						System.out.println("hey");
//						System.out.println(mymeth.getMethodname());
//						System.out.println(mymeth2.getMethodname());
//						System.out.println(val.OwnerClass.classid);
//						System.out.println(mymeth2.classrep.classid);
						String key2= methodtrace.MethodRepresentation.methodid+"-"+mymeth.methodid; 
						if(mapInterfaceExec.get(key2)!=null && entered2==false) {
							entered2=true; 
						}
						else if(mymeth.getMethodname().equals(mymeth2.getMethodname()) && val.OwnerClass.classid.equals(mymeth2.classrep.classid) && entered2==false) {
							INTERFACE++; 
							entered2=true; 
							System.out.println(key2);
							mapInterfaceParsed.put(key2, ""); 
						}
					 
					}
				}
		
				String key2= methodtrace.MethodRepresentation.methodid+"-"+mymeth.methodid; 
				if(mapOnlyParsed.get(key2)!=null) {
					
				}
				else if(entered1==false && entered2==false) {
					ONLYPARSED++; 
					
					mapOnlyParsed.put(key2, ""); 
				}
				}
				
				
				
			}
			
			
			
			
		
			
		////////////////////////////////////////////////////////////////////////////////
		//	second part
			
		
			for(Method2Representation mymeth: mycalleeslistexecuted) {
				boolean entered1exec=false; 
				for(Method2Representation mymeth2: mycalleeslist) {
//					System.out.println(mymeth.getClassrep().classname);
//					System.out.println(mymeth.getClassrep().classid);
//					System.out.println(mymeth2.getClassrep().classid);
//					System.out.println(mymeth.methodid);
//					System.out.println(mymeth2.methodid);
//					System.out.println("ITERATION "+j);
					String key2= methodtrace.MethodRepresentation.methodid+"-"+mymeth.methodid; 
					if(mapBothParsedAndExec2.get(key2)!=null) {
						entered1exec=true; 
					}
					else if(mymeth.classrep.classid.equals(mymeth2.getClassrep().classid) && mymeth.methodid.equals(mymeth2.methodid)) {
						BOTHPARSEDANDEXEC2++; 
						entered1exec=true; 
					
						mapBothParsedAndExec2.put(key2, ""); 
					}
					
					
				}
				
				if(entered1exec==false) {
//					System.out.println("CALLEE PARSED "+ mymeth);
//					System.out.println("METHOD  "+methodtrace);
//					System.out.println(mymeth.classrep.classid);
//					System.out.println(mymeth.classrep.classname);
				String key=mymeth.classrep.classid; 
//				System.out.println(key);
				 List<Interface2> myinterfaces = InterfacesOwnerClassHashMap.get(key); 
				boolean entered2exec=false; 
				if(myinterfaces!=null) {
					for(Interface2 inter: myinterfaces) {
						for(Method2Representation mymeth2: mycalleeslist) {
//							System.out.println("hey");
//							System.out.println("hey");
//							System.out.println(mymeth.getMethodname());
//							System.out.println(mymeth2.getMethodname());
//							System.out.println(inter.OwnerClass.classid);
//							System.out.println(mymeth2.classrep.classid);
							String key2= methodtrace.MethodRepresentation.methodid+"-"+mymeth2.methodid; 
							if(mapInterfaceExec.get(key2)!=null && entered2exec==false) {
								entered2exec=true; 
							}
							else
							if(mymeth.getMethodname().equals(mymeth2.getMethodname()) && inter.InterfaceClass.classid.equals(mymeth2.classrep.classid)&& entered2exec==false) {
								INTERFACEEXEC++; 
								entered2exec=true; 
								System.out.println(key2);
								mapInterfaceExec.put(key2, ""); 
							}
						 
						}
					}
					
				}
				String key2= methodtrace.MethodRepresentation.methodid+"-"+mymeth.methodid; 
				if(mapOnlyExec.get(key2)!=null) {
					
				}
				else
				if(entered1exec==false && entered2exec==false) {
					ONLYEXEC++; 
					
					mapOnlyExec.put(key2, ""); 
				}
				
			
				}
				
				
				
			}
			
////////////////////////////////////////////////////////////////////////////////
//	second part


			for(Method2Representation mymeth: mycallerslistexecuted) {
				boolean entered1execCALLER=false; 
				for(Method2Representation mymeth2: mycallerslist) {
//					System.out.println(mymeth.getClassrep().classname);
//					System.out.println(mymeth.getClassrep().classid);
//					System.out.println(mymeth2.getClassrep().classid);
//					System.out.println(mymeth.methodid);
//					System.out.println(mymeth2.methodid);
//					System.out.println("ITERATION "+j);
					String key2= methodtrace.MethodRepresentation.methodid+"-"+mymeth.methodid; 
					if(mapBothParsedAndExecCaller.get(key2)!=null) {
						entered1execCALLER=true; 
					}
					else if(mymeth.classrep.classid.equals(mymeth2.getClassrep().classid) && mymeth.methodid.equals(mymeth2.methodid)) {
						BOTHPARSEDANDEXEC2++; 
						entered1execCALLER=true; 
					
						mapBothParsedAndExecCaller.put(key2, ""); 
					}
					
					
				}
				
				if(entered1execCALLER==false) {
//					System.out.println("CALLEE PARSED "+ mymeth);
//					System.out.println("METHOD  "+methodtrace);
//					System.out.println(mymeth.classrep.classid);
//					System.out.println(mymeth.classrep.classname);
				String key=mymeth.classrep.classid; 
//				System.out.println(key);
				 List<Interface2> myinterfaces = InterfacesOwnerClassHashMap.get(key); 
				boolean entered2execCALLER=false; 
				if(myinterfaces!=null) {
					for(Interface2 inter: myinterfaces) {
						for(Method2Representation mymeth2: mycallerslist) {
//							System.out.println("hey");
//							System.out.println("hey");
//							System.out.println(mymeth.getMethodname());
//							System.out.println(mymeth2.getMethodname());
//							System.out.println(inter.OwnerClass.classid);
//							System.out.println(mymeth2.classrep.classid);
							String methname=mymeth.getMethodname(); 
							String methname2=mymeth2.getMethodname(); 
							methname=methname.replaceAll("\\[", ""); 
							methname=methname.replaceAll("\\]", ""); 
							methname=methname.replaceAll("\\[\\]", ""); 
							methname2=methname2.replaceAll("\\[", ""); 
							methname2=methname2.replaceAll("\\]", ""); 
							methname2=methname2.replaceAll("\\[\\]", ""); 
							String key2= methodtrace.MethodRepresentation.methodid+"-"+mymeth2.methodid; 
							if(mapInterfaceExecCaller.get(key2)!=null && entered2execCALLER==false) {
								entered2execCALLER=true; 
							}
							else
							
							if(methname.equals(methname2) && inter.OwnerClass.classid.equals(mymeth2.classrep.classid)&& entered2execCALLER==false) {
								INTERFACEEXEC++; 
								entered2execCALLER=true; 
								System.out.println(key2);
								mapInterfaceExecCaller.put(key2, ""); 
							}
						 
						}
					}
					
				}
				String key2= methodtrace.MethodRepresentation.methodid+"-"+mymeth.methodid; 
				if(mapOnlyExecCaller.get(key2)!=null) {
					
				}
				else
				if(entered1execCALLER==false && entered2execCALLER==false) {
					ONLYEXEC++; 
					
					mapOnlyExecCaller.put(key2, ""); 
				}
				
			
				}
				
				
				
			}
			
			
			
			j++; 
		}

//		System.out.println("BOTH PARSED AND EXEC "+BOTHPARSEDANDEXEC+ " "+mapBothParsedAndExec1.size());
//		System.out.println("ONLY FOUND IN PARSED CALLS "+ONLYPARSED+" "+mapOnlyParsed.size());
//		System.out.println("EQUIVALENT FOUND IN EXECUTED CALLS AFTER TRANSFORMING INTERFACE "+INTERFACE+ "  "+mapInterfaceParsed.size()+"\n");
		
		
		System.out.println("BOTH PARSED AND EXEC CALLEES"+" "+mapBothParsedAndExec2.size());
		System.out.println("ONLY FOUND IN EXEC CALLS CALLEES"+" "+mapOnlyExec.size());
		System.out.println("EQUIVALENT FOUND IN EXECUTED CALLS AFTER TRANSFORMING INTERFACE CALLEES"+" "+mapInterfaceExec.size());
		
		System.out.println();
		System.out.println("BOTH PARSED AND EXEC  CALLERS "+" "+mapBothParsedAndExecCaller.size());
		System.out.println("ONLY FOUND IN EXEC CALLS  CALLERS"+" "+mapOnlyExecCaller.size());
		System.out.println("EQUIVALENT FOUND IN EXECUTED CALLS AFTER TRANSFORMING INTERFACE  CALLERS"+" "+mapInterfaceExecCaller.size());
	
		
		bwGold.write("BOTH PARSED AND EXEC CALLEES"+" "+mapBothParsedAndExec2.size());
		bwGold.newLine(); 
		bwGold.write("ONLY FOUND IN EXEC CALLS CALLEES"+" "+mapOnlyExec.size());
		bwGold.newLine(); 
		bwGold.write("EQUIVALENT FOUND IN EXECUTED CALLS AFTER TRANSFORMING INTERFACE CALLEES"+" "+mapInterfaceExec.size());
		bwGold.newLine(); 
		bwGold.newLine(); 
		bwGold.write("BOTH PARSED AND EXEC CALLERS"+" "+mapBothParsedAndExecCaller.size());
		bwGold.newLine(); 
		bwGold.write("ONLY FOUND IN EXEC CALLS CALLERS"+" "+mapOnlyExecCaller.size());
		bwGold.newLine(); 
		bwGold.write("EQUIVALENT FOUND IN EXECUTED CALLS AFTER TRANSFORMING INTERFACE CALLERS"+" "+mapInterfaceExecCaller.size());
		bwGold.close();
		//		
//		System.out.println("EXECUTED ");
//	for( String item: mapInterfaceExec.keySet()) {
//			System.out.println(item);
//		}
//	System.out.println("***************************************************");
//	System.out.println("PARSED ");
//	for( String item: mapInterfaceParsed.keySet()) {
//			System.out.println(item);
//		}
		
//		String[] columnNames = {"Row",  "MethodID", "MethodName", "RequirementID", "RequirementName", "ClassID", "ClassName",
//				"Gold", "Subject", "OwnerClass T", "Owner Class N", "Owner Class E", "# caller methods",
//				"# caller methods T", "#caller methods N", "#caller methods E", "# caller classes",
//				"# caller classes T", "#caller classes N", "#caller classes E", "# callee methods",
//				"# callee methods T", "#callee methods N", "#callee methods E", "# callee classes",
//				"# callee classes T", "#callee classes N", "#callee classes E",  "OwnerClassPrediction",
//				"MajorityClassLevelCallers","MajorityClassLevelCallees", "MajorityMethodLevelCallers","MajorityMethodLevelCallees",
//				">1NPredictionClassLevelCallers", ">1NPredictionClassLevelCallees", ">1NPredictionMethodLevelCallers", 
//				">1NPredictionMethodLevelCallees", ">1TPredictionClassLevelCallers", ">1TPredictionClassLevelCallees", 
//				">1TPredictionMethodLevelCallers", ">1TPredictionMethodLevelCallees", 
//				">2NPredictionClassLevelCallers", ">2NPredictionClassLevelCallees", ">2NPredictionMethodLevelCallers", 
//				">2NPredictionMethodLevelCallees", ">2TPredictionClassLevelCallers", ">2TPredictionClassLevelCallees", 
//				">2TPredictionMethodLevelCallers", ">2TPredictionMethodLevelCallees", 
//				"AllNClassLevelCallers", "AllNClassLevelCallees","AllNMethodLevelCallers","AllNMethodLevelCallees",
//				"AllTClassLevelCallers", "AllTClassLevelCallees", "AllTMethodLevelCallers", "AllTMethodLevelCallees"
//				,"Callers", "Callees", "#parameters", "Parameters","# Parameter T" ,"# Parameter N" ,"# Parameter E" ,
//				"MajorityParameterPrediction", "AtLeast1NParameterPrediction", 
//				"AtLeast1TParameterPrediction", "AtLeast2TParameterPrediction", 
//				"AtLeast2NParameterPrediction", "AllNParameterPrediction", "AllTParameterPrediction"
//				};
		
	
		
		 
		 
		    

		    
	
		
		//Sets the width of each column to the size of the column header 
		TableColumnModel columnModel = table.getColumnModel();
        for (int col = 0; col < table.getColumnCount(); col++) {
            int maxWidth = 0;
           
            TableColumn column = columnModel.getColumn(col);
            TableCellRenderer headerRenderer = column.getHeaderRenderer();
            if (headerRenderer == null) {
                headerRenderer = table.getTableHeader().getDefaultRenderer();
            }
            Object headerValue = column.getHeaderValue();
            Component headerComp = headerRenderer.getTableCellRendererComponent(table, headerValue, false, false, 0, col);
            maxWidth =  headerComp.getPreferredSize().width;
            // note some extra padding
            column.setPreferredWidth(maxWidth + 6);//IntercellSpacing * 2 + 2 * 2 pixel instead of taking this value from Borders
        }
        DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
        stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
    //    table.setPreferredScrollableViewportSize(table.getPreferredSize());
    
		 
		   
		/*
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(8).setPreferredWidth(150);
		table.getColumnModel().getColumn(9).setPreferredWidth(150);
		table.getColumnModel().getColumn(14).setPreferredWidth(150);
		table.getColumnModel().getColumn(15).setPreferredWidth(150);
		table.getColumnModel().getColumn(16).setPreferredWidth(150);
		table.getColumnModel().getColumn(17).setPreferredWidth(150);
		table.getColumnModel().getColumn(10).setPreferredWidth(200);
		table.getColumnModel().getColumn(11).setPreferredWidth(200);
		table.getColumnModel().getColumn(12).setPreferredWidth(200);
		table.getColumnModel().getColumn(13).setPreferredWidth(200);
		table.getColumnModel().getColumn(18).setPreferredWidth(150);
		table.getColumnModel().getColumn(19).setPreferredWidth(150);
		table.getColumnModel().getColumn(20).setPreferredWidth(150);
		table.getColumnModel().getColumn(21).setPreferredWidth(150);
		table.getColumnModel().getColumn(22).setPreferredWidth(150);
		table.getColumnModel().getColumn(23).setPreferredWidth(150);
		table.getColumnModel().getColumn(24).setPreferredWidth(150);
		table.getColumnModel().getColumn(25).setPreferredWidth(150);
		table.getColumnModel().getColumn(26).setPreferredWidth(150);
		table.getColumnModel().getColumn(27).setPreferredWidth(150);
		table.getColumnModel().getColumn(28).setPreferredWidth(150);
		table.getColumnModel().getColumn(29).setPreferredWidth(150);
		table.getColumnModel().getColumn(30).setPreferredWidth(200);
		table.getColumnModel().getColumn(31).setPreferredWidth(200);
		table.getColumnModel().getColumn(32).setPreferredWidth(200);
		table.getColumnModel().getColumn(33).setPreferredWidth(200);
		table.getColumnModel().getColumn(34).setPreferredWidth(200);
		table.getColumnModel().getColumn(35).setPreferredWidth(200);
		table.getColumnModel().getColumn(36).setPreferredWidth(200);
		table.getColumnModel().getColumn(37).setPreferredWidth(200);
		table.getColumnModel().getColumn(38).setPreferredWidth(200);
		table.getColumnModel().getColumn(39).setPreferredWidth(200);
		table.getColumnModel().getColumn(40).setPreferredWidth(150);
		table.getColumnModel().getColumn(41).setPreferredWidth(150);
		table.getColumnModel().getColumn(42).setPreferredWidth(150);
		table.getColumnModel().getColumn(43).setPreferredWidth(150);
		table.getColumnModel().getColumn(44).setPreferredWidth(150);
		table.getColumnModel().getColumn(45).setPreferredWidth(150);
		table.getColumnModel().getColumn(46).setPreferredWidth(150);
		table.getColumnModel().getColumn(47).setPreferredWidth(150);*/
		
		
		
		/*
		 * getContentPane().add(comboBox); getContentPane().add(field); }
		 */

	}



	

	

	public static void main(String[] args) throws SQLException, IOException {

		ComparisonExecutedParsedMethodCalls frame = new ComparisonExecutedParsedMethodCalls();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static List<Method2Representation> removeDuplicates(List<Method2Representation> list) {
		  // convert input array to populated list

		  // convert list to populated set
		  
		  
		
		  HashSet<Method2Representation> set=new HashSet(list); 
		  set.addAll(list);
		 
		  list = new ArrayList<Method2Representation>(set);
		  // convert set to array & return, 
		  // use cast because you can't create generic arrays
		  return list;
		}	
}



