package GUI;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
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

import mypackage.ClassRepresentation2;
import mypackage.ClassTrace2;
import mypackage.ColumnGroup;
import mypackage.DatabaseReading2;
import mypackage.GroupableTableHeader;
import mypackage.Method2Details;
import mypackage.Method2Representation;
import mypackage.MethodTrace2;
import mypackage.RequirementGold;

public class TracesTable extends JFrame {
	ClassTrace2 myclasstrace = new ClassTrace2();
	static List<MethodTrace2> methodtraces2 = new ArrayList<MethodTrace2>();
	static List<ClassTrace2> classtraces2 = new ArrayList<ClassTrace2>();
	JTable table = new JTable(); 
	static List<Method2Details> methodlist = new ArrayList<Method2Details>();
	File fout = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\out.txt");
	FileOutputStream fos = new FileOutputStream(fout);

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
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

	public TracesTable() throws SQLException, IOException {

		bw.write(
				"MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, Gold, Subject, OwnerClassT, OwnerClassN, "
						+ "OwnerClassE, #callermethods, #callermethodsT, #callermethodsN, #callermethodsE, #callerclasses, #callerclassesT, #callerclassesN, "
						+ "#callerclassesE, #calleemethods, #calleemethodsT, #calleemethodsN, #calleemethodsE, #calleeclasses, #calleeclassesT, #calleeclassesN, "
						+ "#calleeclassesE, CalleePrediction, CallerPrediction");
		bw.newLine();
		DatabaseReading2 db = new DatabaseReading2();
		DatabaseReading2.MakePredictions();
		methodtraces2 = db.getMethodtraces2();
		classtraces2 = db.getClassestraces2();
		methodlist = db.getMethodlist();
		List<TableCellEditor> editors1 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> editors2 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> editors3 = new ArrayList<TableCellEditor>(methodtraces2.size());
		List<TableCellEditor> editors4 = new ArrayList<TableCellEditor>(methodtraces2.size());
		int j = 0;
		final int jfinal=0; 
		String[] items1 = new String[methodtraces2.size()];
		String[] items2 = new String[methodtraces2.size()];
		String[] items3 = new String[methodtraces2.size()];
		String[] items4 = new String[methodtraces2.size()];
		Method2Representation[] callersarr = new Method2Representation[methodtraces2.size()];
		Method2Representation[] callersex = new Method2Representation[methodtraces2.size()];
		Method2Representation[] calleesarr = new Method2Representation[methodtraces2.size()];
		Method2Representation[] calleesex = new Method2Representation[methodtraces2.size()];
		Object[][] data = new Object[methodtraces2.size()][10000];
		// Create the editors to be used for each row
		for (MethodTrace2 methodtrace : methodtraces2) {
			data[j][0] = methodtrace.MethodRepresentation.getMethodid();
			data[j][1] = methodtrace.MethodRepresentation.getMethodname();
			data[j][2] = methodtrace.Requirement.getID();
			data[j][3] = methodtrace.Requirement.getRequirementName();
			data[j][4] = methodtrace.ClassRepresentation.classid;
			data[j][5] = methodtrace.ClassRepresentation.classname;
			data[j][6] = methodtrace.gold;
			data[j][7] = methodtrace.subject;
			// data[j][27]= methodtrace.goldpredictionCaller;
			// data[j][28]= methodtrace.goldpredictionCallee;

			for (ClassTrace2 classtrace : classtraces2) {

				if (methodtrace.ClassRepresentation.classid.equals(classtrace.getMyclass().classid)
						&& methodtrace.Requirement.getID().equals(classtrace.getRequirement().getID())) {
					String trace = classtrace.gettrace();
					if (trace.equals("T")) {
						data[j][8] = "1";
						data[j][9] = "0";
						data[j][10] = "0";
					} else if (trace.equals("N")) {
						data[j][8] = "0";
						data[j][9] = "1";
						data[j][10] = "0";
					} else if (trace.equals("E")) {
						data[j][8] = "0";
						data[j][9] = "0";
						data[j][10] = "1";
					}
				}

			}

			int count = 0;
			String classID = "";
			int ClassCountCaller = 0;
			for (Method2Representation caller : methodtrace.getCallersList()) {

				for (Method2Details meth : methodlist) {
					if (meth.getMethodrep().getMethodid().equals(caller.getMethodid()) && count == 0) {
						classID = meth.getOwnerClass().classid;
						ClassCountCaller++;
					} else if (meth.getMethodrep().getMethodid().equals(caller.getMethodid())
							&& (classID.equals(meth.getOwnerClass().classid)) == false) {
						ClassCountCaller++;
					}
				}

				count++;

			}

			for (Method2Representation caller : methodtrace.getCallersListExecuted()) {

				for (Method2Details meth : methodlist) {
					if (meth.getMethodrep().getMethodid().equals(caller.getMethodid()) && count == 0) {
						classID = meth.getOwnerClass().classid;
						ClassCountCaller++;
					} else if (meth.getMethodrep().getMethodid().equals(caller.getMethodid())
							&& (classID.equals(meth.getOwnerClass().classid)) == false) {
						ClassCountCaller++;
					}
				}

				count++;

			}
			count = 0;
			classID = "";
			int ClassCountCallee = 0;
			for (Method2Representation callee : methodtrace.getCalleesList()) {

				for (Method2Details meth : methodlist) {
					if (meth.getMethodrep().getMethodid().equals(callee.getMethodid()) && count == 0) {
						classID = meth.getOwnerClass().classid;
						ClassCountCallee++;
					} else if (meth.getMethodrep().getMethodid().equals(callee.getMethodid())
							&& (classID.equals(meth.getOwnerClass().classid)) == false) {
						ClassCountCallee++;
					}
				}

				count++;

			}
			/*
			 * count=0; int ClassCallerCounterT=0; int ClassCallerCounterN=0; int
			 * ClassCallerCounterE=0; int ClassCountCallerNew=0; String ClassCopyId="";
			 * for(Method2Representation caller: methodtrace.getCallersListExecuted()) {
			 * 
			 * 
			 * 
			 * //detecting the class ID of the caller
			 * 
			 * for(ClassTrace2 classtrace: classtraces2) { for(Method2Details Method:
			 * methodlist) {
			 * if(caller.getMethodid().equals(Method.getMethodrep().getMethodid())) {
			 * classID= Method.getOwnerClass().classid;
			 * 
			 * } }
			 * 
			 * for(ClassTrace2 classtrace2: classtraces2) { if(count==0 &&
			 * classtrace2.getMyclass().classid.equals(classID) &&
			 * methodtrace.Requirement.getID().equals(classtrace2.getRequirement().getID()))
			 * { ClassCopyId=classID; ClassCountCallerNew++; count++;
			 * if(classtrace2.gettrace().equals("T")) { ClassCallerCounterT++; } else
			 * if(classtrace2.gettrace().equals("N")) { ClassCallerCounterN++; } else
			 * if(classtrace2.gettrace().equals("E")) { ClassCallerCounterE++; } } else if(
			 * count!=0 &&(classID.equals(ClassCopyId)==false &&
			 * methodtrace.Requirement.getID().equals(classtrace2.getRequirement().getID()))
			 * ){ ClassCountCallerNew++;
			 * 
			 * 
			 * if(classtrace2.gettrace().equals("T")) { ClassCallerCounterT++; } else
			 * if(classtrace2.gettrace().equals("N")) { ClassCallerCounterN++; } else
			 * if(classtrace2.gettrace().equals("E")) { ClassCallerCounterE++; }
			 * ClassCopyId=classID; count++; } } }
			 * 
			 * 
			 * 
			 * 
			 * 
			 * } ClassCopyId=""; count=0; for(Method2Representation caller:
			 * methodtrace.getCallersList()) {
			 * 
			 * 
			 * 
			 * //detecting the class ID of the caller
			 * 
			 * for(ClassTrace2 classtrace: classtraces2) { for(Method2Details Method:
			 * methodlist) {
			 * if(caller.getMethodid().equals(Method.getMethodrep().getMethodid())) {
			 * classID= Method.getOwnerClass().classid;
			 * 
			 * } }
			 * 
			 * for(ClassTrace2 classtrace2: classtraces2) { if(count==0 &&
			 * classtrace2.getMyclass().classid.equals(classID) &&
			 * methodtrace.Requirement.getID().equals(classtrace2.getRequirement().getID()))
			 * { ClassCopyId=classID; ClassCountCallerNew++; count++;
			 * if(classtrace2.gettrace().equals("T")) { ClassCallerCounterT++; } else
			 * if(classtrace2.gettrace().equals("N")) { ClassCallerCounterN++; } else
			 * if(classtrace2.gettrace().equals("E")) { ClassCallerCounterE++; } } else if(
			 * count!=0 &&(classID.equals(ClassCopyId)==false &&
			 * methodtrace.Requirement.getID().equals(classtrace2.getRequirement().getID()))
			 * ){ ClassCountCallerNew++;
			 * 
			 * 
			 * if(classtrace2.gettrace().equals("T")) { ClassCallerCounterT++; } else
			 * if(classtrace2.gettrace().equals("N")) { ClassCallerCounterN++; } else
			 * if(classtrace2.gettrace().equals("E")) { ClassCallerCounterE++; }
			 * ClassCopyId=classID; count++; } } }
			 * 
			 * 
			 * 
			 * 
			 * 
			 * } data[j][16]= ClassCallerCounterT; data[j][17]= ClassCallerCounterN;
			 * data[j][18]= ClassCallerCounterE;
			 * 
			 * data[j][15]= ClassCountCallerNew; data[j][23]= ClassCountCallee;
			 * 
			 */

			int CallerCountT = 0;
			int CallerCountN = 0;
			int CallerCountE = 0;

			int CountCallers = 0;
			items1 = new String[methodtrace.getCallersList().size()];
			callersarr = new Method2Representation[methodtrace.getCallersList().size()];
			for (Method2Representation caller : methodtrace.getCallersList()) {
				items1[CountCallers] = caller.toString();
				callersarr[CountCallers] = caller;
				System.out.println(caller.toString());
				CountCallers++;
				for (RequirementGold reqgold : caller.getRequirementsGold()) {
					if (reqgold.getRequirement().getID().equals(methodtrace.getRequirement().getID())) {
						if (reqgold.getGold().equals("T")) {
							CallerCountT++;
						} else if (reqgold.getGold().equals("N")) {
							CallerCountN++;
						} else if (reqgold.getGold().equals("E")) {
							CallerCountE++;
						}
					}
				}

			}

			int CountCallersExecuted = 0;
			items2 = new String[methodtrace.getCallersListExecuted().size()];
			callersex = new Method2Representation[methodtrace.getCallersListExecuted().size()];
			for (Method2Representation caller : methodtrace.getCallersListExecuted()) {

				boolean equalbool = false;
				if (items1.length == 0) {
					items2[CountCallersExecuted] = caller.toString();
					callersex[CountCallersExecuted] = caller;
					for (RequirementGold reqgold : caller.getRequirementsGold()) {
						if (reqgold.getRequirement().getID().equals(methodtrace.getRequirement().getID())) {
							if (reqgold.getGold().equals("T")) {
								CallerCountT++;
							} else if (reqgold.getGold().equals("N")) {
								CallerCountN++;
							} else if (reqgold.getGold().equals("E")) {
								CallerCountE++;
							}
						}
					}
					CountCallersExecuted++;
				} else {
					for (String item : items1) {
						item = item.replaceAll("\\(.*\\)", "");

						if (item.equals(caller.toString()) == true) {
							equalbool = true;
						}
					}
					if (equalbool == false) {
						for (RequirementGold reqgold : caller.getRequirementsGold()) {
							if (reqgold.getRequirement().getID().equals(methodtrace.getRequirement().getID())) {
								if (reqgold.getGold().equals("T")) {
									CallerCountT++;
								} else if (reqgold.getGold().equals("N")) {
									CallerCountN++;
								} else if (reqgold.getGold().equals("E")) {
									CallerCountE++;
								}
							}
						}
						items2[CountCallersExecuted] = caller.toString();
						callersex[CountCallersExecuted] = caller;
						CountCallersExecuted++;
					}
				}

			}
			data[j][12] = CallerCountT;
			data[j][13] = CallerCountN;
			data[j][14] = CallerCountE;
			int CalleeCountT = 0;
			int CalleeCountN = 0;
			int CalleeCountE = 0;

			String[] items1And2 = new String[items1.length + items2.length];
			items1And2 = (String[]) ArrayUtils.addAll(items1, items2);
			Method2Representation[] CallerMethods = new Method2Representation[items1.length + items2.length];
			CallerMethods = (Method2Representation[]) ArrayUtils.addAll(callersarr, callersex);

			List<Method2Representation> CallerMethodsList = Arrays.asList(CallerMethods);

			// data[j][10]=items1;
			int CountCallees = 0;
			items3 = new String[methodtrace.getCalleesList().size()];
			calleesarr = new Method2Representation[methodtrace.getCalleesList().size()];
			for (Method2Representation caller : methodtrace.getCalleesList()) {
				items3[CountCallees] = caller.toString();
				calleesarr[CountCallees] = caller;
				System.out.println(caller.toString());
				CountCallees++;
				for (RequirementGold reqgold : caller.getRequirementsGold()) {
					if (reqgold.getRequirement().getID().equals(methodtrace.getRequirement().getID())) {
						if (reqgold.getGold().equals("T")) {
							CalleeCountT++;
						} else if (reqgold.getGold().equals("N")) {
							CalleeCountN++;
						} else if (reqgold.getGold().equals("E")) {
							CalleeCountE++;
						}
					}
				}
			}

			int CountCalleesExecuted = 0;
			items4 = new String[methodtrace.getCalleesListExecuted().size()];
			calleesex = new Method2Representation[methodtrace.getCalleesListExecuted().size()];
			for (Method2Representation caller : methodtrace.getCalleesListExecuted()) {
				boolean equalbool = false;
				if (items3.length == 0) {
					items4[CountCalleesExecuted] = caller.toString();
					calleesex[CountCalleesExecuted] = caller;
					CountCalleesExecuted++;
					for (RequirementGold reqgold : caller.getRequirementsGold()) {
						if (reqgold.getRequirement().getID().equals(methodtrace.getRequirement().getID())) {
							if (reqgold.getGold().equals("T")) {
								CalleeCountT++;
							} else if (reqgold.getGold().equals("N")) {
								CalleeCountN++;
							} else if (reqgold.getGold().equals("E")) {
								CalleeCountE++;
							}
						}
					}
				} else {
					for (String item : items3) {
						item = item.replaceAll("\\(.*\\)", "");
						if (item.equals(caller.toString()) == true) {
							equalbool = true;
						}
					}
					if (equalbool == false) {
						items4[CountCalleesExecuted] = caller.toString();
						calleesex[CountCalleesExecuted] = caller;

						CountCalleesExecuted++;
						for (RequirementGold reqgold : caller.getRequirementsGold()) {
							if (reqgold.getRequirement().getID().equals(methodtrace.getRequirement().getID())) {
								if (reqgold.getGold().equals("T")) {
									CalleeCountT++;
								} else if (reqgold.getGold().equals("N")) {
									CalleeCountN++;
								} else if (reqgold.getGold().equals("E")) {
									CalleeCountE++;
								}
							}
						}
					}
				}

			}

			data[j][20] = CalleeCountT;
			data[j][21] = CalleeCountN;
			data[j][22] = CalleeCountE;

			String[] items3And4 = new String[items3.length + items4.length];
			items3And4 = (String[]) ArrayUtils.addAll(items3, items4);
			Method2Representation[] CalleeMethods = new Method2Representation[items3.length + items4.length];
			CalleeMethods = (Method2Representation[]) ArrayUtils.addAll(calleesarr, calleesex);
			List<Method2Representation> CalleeMethodsList = Arrays.asList(CalleeMethods);

			data[j][11] = CountCallersExecuted + CountCallers;
			data[j][19] = CountCalleesExecuted + CountCallees;

			CallerMethodListFinal = new ArrayList<Method2Representation>();
			CalleeMethodListFinal = new ArrayList<Method2Representation>();

			for (Method2Representation methcaller : CallerMethodsList) {
				if (methcaller != null) {
					CallerMethodListFinal.add(methcaller);
				}
			}

			for (Method2Representation methcaller : CalleeMethodsList) {
				if (methcaller != null) {
					CalleeMethodListFinal.add(methcaller);
				}
			}

			int CounterTraceClassCallerT = 0;
			int CounterTraceClassCallerN = 0;
			int CounterTraceClassCallerE = 0;
			List<ClassTrace2> mycallerclasses = new ArrayList<ClassTrace2>();

			for (Method2Representation callermeth : CallerMethodListFinal) {
				ClassRepresentation2 classrep = callermeth.getClassrep();
				ClassTrace2 mycallerclass = myclasstrace.FindTrace(classtraces2, classrep.classid,
						methodtrace.Requirement.getID());
				mycallerclasses.add(mycallerclass);
			}

			ArrayList<ClassTrace2> myclasstracesCallers = new ArrayList<ClassTrace2>();// unique
			for (ClassTrace2 classtrace : mycallerclasses) {
				if (!myclasstracesCallers.contains(classtrace)) {

					myclasstracesCallers.add(classtrace);
				}
			}

			int mysize = myclasstracesCallers.size();

			data[j][15] = myclasstracesCallers.size();

			for (ClassTrace2 mycallerclass : myclasstracesCallers) {
				if (mycallerclass.gettrace().equals("T")) {
					CounterTraceClassCallerT++;
				} else if (mycallerclass.gettrace().equals("N")) {
					CounterTraceClassCallerN++;
				} else if (mycallerclass.gettrace().equals("E")) {
					CounterTraceClassCallerE++;
				}
			}

			data[j][16] = CounterTraceClassCallerT;
			data[j][17] = CounterTraceClassCallerN;
			data[j][18] = CounterTraceClassCallerE;

			/*if (((CounterTraceClassCallerT >= CounterTraceClassCallerN
					&& CounterTraceClassCallerN >= CounterTraceClassCallerE)
					|| (CounterTraceClassCallerT >= CounterTraceClassCallerE
							&& CounterTraceClassCallerE >= CounterTraceClassCallerN))
					&& CounterTraceClassCallerT != 0) {
				data[j][27] = "T";
			} else if (((CounterTraceClassCallerE >= CounterTraceClassCallerN
					&& CounterTraceClassCallerN >= CounterTraceClassCallerT)
					|| (CounterTraceClassCallerE >= CounterTraceClassCallerT
							&& CounterTraceClassCallerT >= CounterTraceClassCallerN))
					&& CounterTraceClassCallerE != 0) {
				data[j][27] = "E";
			} else if (((CounterTraceClassCallerN >= CounterTraceClassCallerE
					&& CounterTraceClassCallerE >= CounterTraceClassCallerT)
					|| (CounterTraceClassCallerN >= CounterTraceClassCallerT
							&& CounterTraceClassCallerT >= CounterTraceClassCallerE))
					&& CounterTraceClassCallerN != 0) {
				data[j][27] = "N";
			}*/

			int CounterTraceClassCalleeT = 0;
			int CounterTraceClassCalleeN = 0;
			int CounterTraceClassCalleeE = 0;
			List<ClassTrace2> mycalleeclasses = new ArrayList<ClassTrace2>();

			for (Method2Representation calleemeth : CalleeMethodListFinal) {
				ClassRepresentation2 classrep = calleemeth.getClassrep();
				ClassTrace2 mycalleeclass = myclasstrace.FindTrace(classtraces2, classrep.classid,
						methodtrace.Requirement.getID());
				mycalleeclasses.add(mycalleeclass);
			}

			ArrayList<ClassTrace2> myclasstracesCallees = new ArrayList<ClassTrace2>();// unique
			for (ClassTrace2 classtrace : mycalleeclasses) {
				if (!myclasstracesCallees.contains(classtrace)) {

					myclasstracesCallees.add(classtrace);
				}
			}

			data[j][23] = myclasstracesCallees.size();

			for (ClassTrace2 mycalleeclass : myclasstracesCallees) {
				if (mycalleeclass.gettrace().equals("T")) {
					CounterTraceClassCalleeT++;
				} else if (mycalleeclass.gettrace().equals("N")) {
					CounterTraceClassCalleeN++;
				} else if (mycalleeclass.gettrace().equals("E")) {
					CounterTraceClassCalleeE++;
				}
			}

			data[j][24] = CounterTraceClassCalleeT;
			data[j][25] = CounterTraceClassCalleeN;
			data[j][26] = CounterTraceClassCalleeE;

			/*if (((CounterTraceClassCalleeT >= CounterTraceClassCalleeN
					&& CounterTraceClassCalleeN >= CounterTraceClassCalleeE)
					|| (CounterTraceClassCalleeT >= CounterTraceClassCalleeE
							&& CounterTraceClassCalleeE >= CounterTraceClassCalleeN))
					&& CounterTraceClassCalleeT != 0) {
				data[j][28] = "T";
			} else if (((CounterTraceClassCalleeE >= CounterTraceClassCalleeN
					&& CounterTraceClassCalleeN >= CounterTraceClassCalleeT)
					|| (CounterTraceClassCalleeE >= CounterTraceClassCalleeT
							&& CounterTraceClassCalleeT >= CounterTraceClassCalleeN))
					&& CounterTraceClassCalleeE != 0) {
				data[j][28] = "E";
			} else if (((CounterTraceClassCalleeN >= CounterTraceClassCalleeE
					&& CounterTraceClassCalleeE >= CounterTraceClassCalleeT)
					|| (CounterTraceClassCalleeN >= CounterTraceClassCalleeT
							&& CounterTraceClassCalleeT >= CounterTraceClassCalleeE))
					&& CounterTraceClassCalleeN != 0) {
				data[j][28] = "N";
			}*/

			JComboBox comboBox1 = new JComboBox(items1And2);
			DefaultCellEditor dce1 = new DefaultCellEditor(comboBox1);
			editors1.add(dce1);

			/*
			 * JComboBox comboBox2 = new JComboBox( items2 ); DefaultCellEditor dce2 = new
			 * DefaultCellEditor( comboBox2 ); editors2.add( dce2 );
			 */

			JComboBox comboBox4 = new JComboBox(items3And4);
			DefaultCellEditor dce3 = new DefaultCellEditor(comboBox4);
			editors3.add(dce3);

			/*
			 * JComboBox comboBox4 = new JComboBox( items4); DefaultCellEditor dce4 = new
			 * DefaultCellEditor( comboBox4 ); editors4.add( dce4 );
			 */

			comboBox1.setEditor(new MyEditor());
			comboBox1.setEditable(true);

			/*
			 * comboBox2.setEditor(new MyEditor()); comboBox2.setEditable(true);
			 */

			comboBox4.setEditor(new MyEditor());
			comboBox4.setEditable(true);

			 
			
			 ActionListener cbActionListener = new ActionListener() {//add actionlistner to listen for change
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            		
		                 String s = (String) comboBox1.getSelectedItem();//get the selected item
		                 if(s!=null) {
		                	   System.out.println(s);
				              
				               
		                	  String methid = s.substring(0, s.indexOf(",")); 
				              int row=table.getSelectedRow();
				              TableModel model = table.getModel();

				              // Object methodid = model.getValueAt(row, 0); 
				               Object requirementID = model.getValueAt(row, 2); 
				               
				              Method2Details meth = methodlist.get((Integer.parseInt(methid.toString()))-1); 
				              
				            ClassTrace2 classtrace = myclasstrace.FindTrace(classtraces2, meth.getOwnerClass().classid,
										requirementID.toString());
				            String goldval=classtrace.gettrace();  
				            System.out.println("goldval: "+goldval);
				            System.out.println("CELL method id : "+methid.toString());
				            System.out.println("CELL  Requirement ID: "+requirementID.toString());
				            //data[j][27]=goldval; 
				           model.setValueAt(goldval, row, 27);
		                 }
		                
		            }

					
		         
		        };
		       
		        comboBox1.addActionListener(cbActionListener);
		        
		        
		        
		   	 ActionListener cbActionListener2 = new ActionListener() {//add actionlistner to listen for change
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            		
		                 String s = (String) comboBox4.getSelectedItem();//get the selected item
		                 if(s!=null) {
		                	   System.out.println(s);
				              
				               
		                	  String methid = s.substring(0, s.indexOf(",")); 
				              int row=table.getSelectedRow();
				              TableModel model = table.getModel();

				              // Object methodid = model.getValueAt(row, 0); 
				               Object requirementID = model.getValueAt(row, 2); 
				               
				              Method2Details meth = methodlist.get((Integer.parseInt(methid.toString()))-1); 
				              
				            ClassTrace2 classtrace = myclasstrace.FindTrace(classtraces2, meth.getOwnerClass().classid,
										requirementID.toString());
				            String goldval=classtrace.gettrace();  
				            System.out.println("goldval: "+goldval);
				            System.out.println("CELL method id : "+methid.toString());
				            System.out.println("CELL  Requirement ID: "+requirementID.toString());
				            //data[j][27]=goldval; 
				           model.setValueAt(goldval, row, 28);
		                 }
		                
		            }

					
		         
		        };
		       
		        comboBox4.addActionListener(cbActionListener2);
			/*
			 * comboBox4.setEditor(new MyEditor()); comboBox4.setEditable(true);
			 */

			List<Method2Representation> callers = methodtrace.getCallersList();
			List<Method2Representation> callersmerged = new ArrayList<Method2Representation>();
			List<Method2Representation> callersExecuted = methodtrace.getCallersListExecuted();

			for (Method2Representation methrep : callers) {
				String methodname = methrep.getMethodname();
				if (methodname.contains("(")) {
					methodname = methodname.replaceAll("\\(.*\\)", "");
					methrep.setMethodname(methodname);
				}

			}
			for (Method2Representation caller : callers) {
				callersmerged.add(caller);
			}
			for (Method2Representation caller : callersExecuted) {
				callersmerged.add(caller);
			}

			Set<Method2Representation> listWithoutDuplicates = new HashSet<Method2Representation>(callersmerged);
			callersmerged.clear();

			callersmerged.addAll(listWithoutDuplicates);

			int counterT = 0;
			int counterN = 0;
			int counterE = 0;

			for (Method2Representation caller : callersmerged) {

				for (RequirementGold reqgold : caller.getRequirementsGold()) {
					if (reqgold.getRequirement().getID().equals(methodtrace.Requirement.getID())) {
						if (reqgold.getGold().equals("T")) {
							counterT++;
						} else if (reqgold.getGold().equals("N")) {
							counterN++;
						} else if (reqgold.getGold().equals("E")) {
							counterE++;
						}
					}
				}

			}

			List<Method2Representation> callees = methodtrace.getCalleesList();
			List<Method2Representation> calleesExecuted = methodtrace.getCalleesListExecuted();
			for (Method2Representation methrep : callees) {
				String methodname = methrep.getMethodname();
				if (methodname.contains("(")) {
					methodname = methodname.replaceAll("\\(.*\\)", "");
					methrep.setMethodname(methodname);
				}
			}

			int counterTCallee = 0;
			int counterNCallee = 0;
			int counterECallee = 0;

			for (Method2Representation callee : calleesExecuted) {

				for (RequirementGold reqgold : callee.getRequirementsGold()) {
					if (reqgold.getRequirement().getID().equals(methodtrace.Requirement.getID())) {
						if (reqgold.getGold().equals("T")) {
							counterTCallee++;
						} else if (reqgold.getGold().equals("N")) {
							counterNCallee++;
						} else if (reqgold.getGold().equals("E")) {
							counterECallee++;
						}
					}
				}

			}

			bw.write(data[j][0] + "," + data[j][1] + "," + data[j][2] + "," + data[j][3] + "," + data[j][4] + ","
					+ data[j][5] + "," + data[j][6] + "," + data[j][7] + "," + data[j][8] + "," + data[j][9] + ","
					+ data[j][10] + "," + data[j][11] + "," + data[j][12] + "," + data[j][13] + "," + data[j][14] + ","
					+ data[j][15] + "," + data[j][16] + "," + data[j][17] + "," + data[j][18] + "," + data[j][19] + ","
					+ data[j][20] + "," + data[j][21] + "," + data[j][22] + "," + data[j][23] + "," + data[j][24] + ","
					+ data[j][25] + "," + data[j][26] + "," + data[j][27] + "," + data[j][28]);
			bw.newLine();

			j++;
			
		}

		bw.close();
		/*
		 * String[] items2 = { "Circle", "Square", "Triangle" }; JComboBox comboBox2 =
		 * new JComboBox( items2 ); DefaultCellEditor dce2 = new DefaultCellEditor(
		 * comboBox2 ); editors.add( dce2 );
		 * 
		 * String[] items3 = { "Apple", "Orange", "Banana" }; JComboBox comboBox3 = new
		 * JComboBox( items3 ); DefaultCellEditor dce3 = new DefaultCellEditor(
		 * comboBox3 ); editors.add( dce3 );
		 */

		// Create the table with default data

		/*
		 * Object[][] data = { {"Color", "Red"}, {"Shape", "Square"}, {"Fruit",
		 * "Banana"}, {"Plain", "Text"} };
		 */

		String[] columnNames = { "MethodID", "MethodName", "RequirementID", "RequirementName", "ClassID", "ClassName",
				"Gold", "Subject", "OwnerClass T", "Owner Class N", "Owner Class E", "# caller methods",
				"# caller methods T", "#caller methods N", "#caller methods E", "# caller classes",
				"# caller classes T", "#caller classes N", "#caller classes E", "# callee methods",
				"# callee methods T", "#callee methods N", "#callee methods E", "# callee classes",
				"# callee classes T", "#callee classes N", "#callee classes E", "CalleePrediction", "CallerPrediction",
				"Callers", "Callees" };
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table = new JTable(model) {
			// Determine editor to be used by row
			public TableCellEditor getCellEditor(int row, int column) {
				int modelColumn = convertColumnIndexToModel(column);

				if (modelColumn == 29 && row < methodtraces2.size())
					return editors1.get(row);
				if (modelColumn == 30 && row < methodtraces2.size())
					return editors3.get(row);
				/*
				 * if (modelColumn == 31 && row < methodtraces2.size()) return
				 * editors3.get(row); if (modelColumn == 32 && row < methodtraces2.size())
				 * return editors4.get(row);
				 */

				else
					return super.getCellEditor(row, column);
			}

		};

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

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		
		
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);
		JScrollPane horizontalscroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		getContentPane().add(horizontalscroll);
		// table.getColumnModel().getColumn(1).setCellRenderer(new ComboBoxRenderer() );
		table.setRowHeight(50);

		
		
		/*
		 * getContentPane().add(comboBox); getContentPane().add(field); }
		 */

	}

	private void ComputeCounterTNECallers(MethodTrace2 methodtrace, Object[][] data, int j) throws IOException {
		// TODO Auto-generated method stub

		int counterT = 0;
		int counterN = 0;
		int counterE = 0;

		for (Method2Representation caller : methodtrace.getCallersList()) {

			for (RequirementGold reqgold : caller.getRequirementsGold()) {
				if (reqgold.getRequirement().getID().equals(methodtrace.Requirement.getID())) {
					if (reqgold.getGold().equals("T")) {
						counterT++;
					} else if (reqgold.getGold().equals("N")) {
						counterN++;
					} else if (reqgold.getGold().equals("E")) {
						counterE++;
					}
				}
			}

		}

		for (Method2Representation caller : methodtrace.getCallersListExecuted()) {

			for (RequirementGold reqgold : caller.getRequirementsGold()) {
				if (reqgold.getRequirement().getID().equals(methodtrace.Requirement.getID())) {
					if (reqgold.getGold().equals("T")) {
						counterT++;
					} else if (reqgold.getGold().equals("N")) {
						counterN++;
					} else if (reqgold.getGold().equals("E")) {
						counterE++;
					}
				}
			}

		}
		data[j][12] = counterT;
		data[j][13] = counterN;
		data[j][14] = counterE;

	}

	static class MyEditor extends BasicComboBoxEditor {
		JScrollPane scroller = new JScrollPane();
		// NOTE: editor is a JTextField defined in BasicComboBoxEditor

		public MyEditor() {
			super();
			scroller.setViewportView(editor);
			scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		}

		/** Return a JScrollPane containing the JTextField instead of the JTextField **/
		@Override
		public Component getEditorComponent() {
			return scroller;
		}

		/** Override to create your own JTextField. **/
		@Override
		protected JTextField createEditorComponent() {
			JTextField editor = new JTextField();
			editor.setBorder(null);
			/* editor.setEditable(false); //If you want it not to be editable */
			return editor;
		}
	}

	class ComboBoxRenderer extends JComboBox implements TableCellRenderer {

		public ComboBoxRenderer() {
			setBorder(new EmptyBorder(0, 0, 0, 0));
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// setFocusable(false);
			removeAllItems();
			addItem(value);
			return this;
		}
	}

	public static void main(String[] args) throws SQLException, IOException {

		TracesTable frame = new TracesTable();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
