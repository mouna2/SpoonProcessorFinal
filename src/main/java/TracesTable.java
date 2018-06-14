import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.table.*;

import mypackage.ClassTrace2;
import mypackage.ColumnGroup;
import mypackage.DatabaseReading2;
import mypackage.GroupableTableHeader;
import mypackage.Method2Details;
import mypackage.Method2Representation;
import mypackage.MethodTrace2;
import mypackage.RequirementGold;
 
public class TracesTable extends JFrame
{
  
   static List<MethodTrace2> methodtraces2= new ArrayList<MethodTrace2>(); 
   static List<ClassTrace2> classtraces2= new ArrayList<ClassTrace2>(); 
   
   static List<Method2Details> methodlist= new ArrayList<Method2Details>(); 
    public TracesTable() throws SQLException
    {
    	DatabaseReading2 db = new DatabaseReading2(); 
    	DatabaseReading2.MakePredictions();
    	methodtraces2= db.getMethodtraces2(); 
    	classtraces2 = db.getClassestraces2(); 
    	methodlist= db.getMethodlist(); 
    	    List<TableCellEditor> editors1 = new ArrayList<TableCellEditor>(methodtraces2.size());
    	    List<TableCellEditor> editors2 = new ArrayList<TableCellEditor>(methodtraces2.size());
    	    List<TableCellEditor> editors3 = new ArrayList<TableCellEditor>(methodtraces2.size());
    	    List<TableCellEditor> editors4 = new ArrayList<TableCellEditor>(methodtraces2.size());
    	int j=0; 
    	String[] items1 = new String [methodtraces2.size()]; 
    	String[] items2 = new String [methodtraces2.size()]; 
    	String[] items3 = new String [methodtraces2.size()]; 
    	String[] items4 = new String [methodtraces2.size()]; 
   	 Object[][] data = new Object[methodtraces2.size()][10000]; 
        // Create the editors to be used for each row
    	for(MethodTrace2 methodtrace: methodtraces2) {
    		data[j][0]= methodtrace.MethodRepresentation.getMethodid(); 
    		data[j][1]= methodtrace.MethodRepresentation.getMethodname(); 
    		data[j][2]= methodtrace.Requirement.getID(); 
    		data[j][3]= methodtrace.Requirement.getRequirementName(); 
    		data[j][4]= methodtrace.ClassRepresentation.classid; 
    		data[j][5]= methodtrace.ClassRepresentation.classname; 
    		data[j][6]= methodtrace.gold; 
    		data[j][7]= methodtrace.subject; 
    		data[j][27]= methodtrace.goldpredictionCaller; 
    		data[j][28]= methodtrace.goldpredictionCallee; 
    	
    		for(ClassTrace2 classtrace: classtraces2) {
    			 
    				if(methodtrace.ClassRepresentation.classid.equals(classtrace.getMyclass().classid) && 
    						methodtrace.Requirement.getID().equals(classtrace.getRequirement().getID())) {
        				String trace=classtrace.gettrace(); 
        				if(trace.equals("T")) {
        					data[j][8]= "1"; 
        					data[j][9]= "0"; 
        					data[j][10]= "0"; 
        				}else if(trace.equals("N")) {
        					data[j][8]= "0"; 
        					data[j][9]= "1"; 
        					data[j][10]= "0"; 
        				}else if(trace.equals("E")){
        					data[j][8]= "0"; 
        					data[j][9]= "0"; 
        					data[j][10]= "1"; 
        				}
        			}
    			
    	
    		}
    		ComputeCounterTNECallers(methodtrace, data, j); 
    		int count=0; 
    		String classID=""; 
    		int ClassCountCaller=0; 
    		for(Method2Representation caller: methodtrace.getCallersList()) {
    			
    		for(Method2Details meth: methodlist) {
    			if(meth.getMethodrep().getMethodid().equals(caller.getMethodid()) && count==0){
    				classID=meth.getOwnerClass().classid; 
    				ClassCountCaller++; 
    			}
    			else if(meth.getMethodrep().getMethodid().equals(caller.getMethodid()) && (classID.equals(meth.getOwnerClass().classid))==false){
    				ClassCountCaller++;  
    			}
    		}
    			
    			count++; 
    			
    		}
    		
    		
    		for(Method2Representation caller: methodtrace.getCallersListExecuted()) {
    			
        		for(Method2Details meth: methodlist) {
        			if(meth.getMethodrep().getMethodid().equals(caller.getMethodid()) && count==0){
        				classID=meth.getOwnerClass().classid; 
        				ClassCountCaller++; 
        			}
        			else if(meth.getMethodrep().getMethodid().equals(caller.getMethodid()) && (classID.equals(meth.getOwnerClass().classid))==false){
        				ClassCountCaller++;  
        			}
        		}
        			
        			count++; 
        			
        		}
    		 count=0; 
    		 classID=""; 
    		int  ClassCountCallee=0; 
    		for(Method2Representation callee: methodtrace.getCalleesList()) {
    			
    		for(Method2Details meth: methodlist) {
    			if(meth.getMethodrep().getMethodid().equals(callee.getMethodid()) && count==0){
    				classID=meth.getOwnerClass().classid; 
    				ClassCountCallee++; 
    			}
    			else if(meth.getMethodrep().getMethodid().equals(callee.getMethodid()) && (classID.equals(meth.getOwnerClass().classid))==false){
    				ClassCountCallee++;  
    			}
    		}
    			
    			count++; 
    			
    		}
    		count=0; 
    		int ClassCallerCounterT=0; 
    		int ClassCallerCounterN=0; 
    		int ClassCallerCounterE=0; 
    		int ClassCountCallerNew=0; 
    		String ClassCopyId=""; 
    		for(Method2Representation caller: methodtrace.getCallersListExecuted()) {
    			
        	
        			
        			//detecting the class ID of the caller 
        				
        				for(ClassTrace2 classtrace: classtraces2) {
        					for(Method2Details Method: methodlist) {
    							if(caller.getMethodid().equals(Method.getMethodrep().getMethodid())) {
    								classID= Method.getOwnerClass().classid; 
    								
    							}
    						}
        					
        					for(ClassTrace2 classtrace2: classtraces2) {
        					if(count==0 && classtrace2.getMyclass().classid.equals(classID) && methodtrace.Requirement.getID().equals(classtrace2.getRequirement().getID())) {
        						ClassCopyId=classID; 
        						ClassCountCallerNew++; 
        						count++; 
        						if(classtrace2.gettrace().equals("T")) {
        							ClassCallerCounterT++; 
            					}
            					else if(classtrace2.gettrace().equals("N")) {
            						ClassCallerCounterN++; 
            					}
            					else if(classtrace2.gettrace().equals("E")) {
            						ClassCallerCounterE++; 
            					}
        					}
        					else if( count!=0 &&(classID.equals(ClassCopyId)==false && methodtrace.Requirement.getID().equals(classtrace2.getRequirement().getID()))){
        						ClassCountCallerNew++; 
                				
                					
                						if(classtrace2.gettrace().equals("T")) {
                							ClassCallerCounterT++; 
                    					}
                    					else if(classtrace2.gettrace().equals("N")) {
                    						ClassCallerCounterN++; 
                    					}
                    					else if(classtrace2.gettrace().equals("E")) {
                    						ClassCallerCounterE++; 
                    					}
                					ClassCopyId=classID; 
                				count++; 
                			}
        				}
        				}
        		
        		
        			
        		
        			
        		}
    		 ClassCopyId=""; 
    		 count=0; 
    		for(Method2Representation caller: methodtrace.getCallersList()) {
    			
            	
    			
    			//detecting the class ID of the caller 
    				
    				for(ClassTrace2 classtrace: classtraces2) {
    					for(Method2Details Method: methodlist) {
							if(caller.getMethodid().equals(Method.getMethodrep().getMethodid())) {
								classID= Method.getOwnerClass().classid; 
								
							}
						}
    					
    					for(ClassTrace2 classtrace2: classtraces2) {
    					if(count==0 && classtrace2.getMyclass().classid.equals(classID) && methodtrace.Requirement.getID().equals(classtrace2.getRequirement().getID())) {
    						ClassCopyId=classID; 
    						ClassCountCallerNew++; 
    						count++; 
    						if(classtrace2.gettrace().equals("T")) {
    							ClassCallerCounterT++; 
        					}
        					else if(classtrace2.gettrace().equals("N")) {
        						ClassCallerCounterN++; 
        					}
        					else if(classtrace2.gettrace().equals("E")) {
        						ClassCallerCounterE++; 
        					}
    					}
    					else if( count!=0 &&(classID.equals(ClassCopyId)==false && methodtrace.Requirement.getID().equals(classtrace2.getRequirement().getID()))){
    						ClassCountCallerNew++; 
            				
            					
            						if(classtrace2.gettrace().equals("T")) {
            							ClassCallerCounterT++; 
                					}
                					else if(classtrace2.gettrace().equals("N")) {
                						ClassCallerCounterN++; 
                					}
                					else if(classtrace2.gettrace().equals("E")) {
                						ClassCallerCounterE++; 
                					}
            					ClassCopyId=classID; 
            				count++; 
            			}
    				}
    				}
    		
    		
    			
    		
    			
    		}
    		data[j][16]= ClassCallerCounterT; 
    		data[j][17]= ClassCallerCounterN; 
    		data[j][18]= ClassCallerCounterE; 
    		
    		data[j][15]= ClassCountCallerNew; 
    		data[j][23]= ClassCountCallee; 
    	
			
			
    		data[j][11]= methodtrace.getCallersList().size()+methodtrace.getCallersListExecuted().size(); 
    		data[j][19]= methodtrace.getCalleesList().size()+methodtrace.getCalleesListExecuted().size(); 
    		int i=0; 
    		items1 = new String[methodtrace.getCallersList().size()]; 
    		 for(Method2Representation caller: methodtrace.getCallersList()) {
	    		  items1[i]=caller.toString(); 
	    		  System.out.println(caller.toString());
	    		  i++; 
	    		  
	    	  }
    		 
    		 int r=0; 
    		 items2 = new String[methodtrace.getCallersListExecuted().size()]; 
    		 for(Method2Representation caller: methodtrace.getCallersListExecuted()) {
    			 items2[r]=caller.toString(); 
	    		  System.out.println(caller.toString());
	    		  r++; 
	    		  
	    	  }
    		// data[j][10]=items1; 
    		 int k=0; 
    		 items3 = new String[ methodtrace.getCalleesList().size()]; 
    		 for(Method2Representation caller: methodtrace.getCalleesList()) {
    			 items3[k]=caller.toString(); 
	    		  System.out.println(caller.toString());
	    		  k++; 
	    		  
	    	  }
    		
    		 int z=0; 
    		 items4 = new String[10000]; 
    		 for(Method2Representation caller: methodtrace.getCalleesListExecuted()) {
	    		  items4[z]=caller.toString(); 
	    		  System.out.println(caller.toString());
	    		  z++; 
	    		  
	    	  }
    		 
    	
    		 
    		
    	        JComboBox comboBox1 = new JComboBox( items1 );
    	        DefaultCellEditor dce1 = new DefaultCellEditor( comboBox1 );
    	        editors1.add( dce1 );
    	        
    	        JComboBox comboBox2 = new JComboBox( items2 );
    	        DefaultCellEditor dce2 = new DefaultCellEditor( comboBox2 );
    	        editors2.add( dce2 );
    	 
    	        
    	        JComboBox comboBox3 = new JComboBox( items3 );
    	        DefaultCellEditor dce3 = new DefaultCellEditor( comboBox3 );
    	        editors3.add( dce3 );
    	 
    	        
    	        JComboBox comboBox4 = new JComboBox( items4);
    	        DefaultCellEditor dce4 = new DefaultCellEditor( comboBox4 );
    	        editors4.add( dce4 );
    	        
    	        comboBox1.setEditor(new MyEditor());
    	        comboBox1.setEditable(true);
    	        
    	        comboBox2.setEditor(new MyEditor());
    	        comboBox2.setEditable(true);
    	        
    	        comboBox3.setEditor(new MyEditor());
    	        comboBox3.setEditable(true);
    	        
    	        comboBox4.setEditor(new MyEditor());
    	        comboBox4.setEditable(true);
    	     
    	   	 j++; 
    	}
       
 
 
       /* String[] items2 = { "Circle", "Square", "Triangle" };
        JComboBox comboBox2 = new JComboBox( items2 );
        DefaultCellEditor dce2 = new DefaultCellEditor( comboBox2 );
        editors.add( dce2 );
 
        String[] items3 = { "Apple", "Orange", "Banana" };
        JComboBox comboBox3 = new JComboBox( items3 );
        DefaultCellEditor dce3 = new DefaultCellEditor( comboBox3 );
        editors.add( dce3 );*/
 
        //  Create the table with default data
 
       /* Object[][] data =
        {
            {"Color", "Red"},
            {"Shape", "Square"},
            {"Fruit", "Banana"},
            {"Plain", "Text"}
        };*/
        
    
        
        String[] columnNames = {"MethodID","MethodName", "RequirementID", "RequirementName", "ClassID", "ClassName", "Gold", "Subject","OwnerClass T", "Owner Class N", "Owner Class E", "# caller methods", "# caller methods T", "#caller methods N", "#caller methods E", "# caller classes", "# caller classes T", "#caller classes N", "#caller classes E","# callee methods", "# callee methods T", "#callee methods N", "#callee methods E", "# callee classes", "# callee classes T", "#callee classes N", "#callee classes E",  "CalleePrediction", "CallerPrediction", 
        		"Callers", "CallersExecuted", "Callees", "CalleesExecuted"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model)
        {
            //  Determine editor to be used by row
            public TableCellEditor getCellEditor(int row, int column)
            {
                int modelColumn = convertColumnIndexToModel( column );
 
                if (modelColumn == 29 && row < methodtraces2.size())
                    return editors1.get(row);
                if (modelColumn == 30 && row < methodtraces2.size())
                    return editors2.get(row);
                if (modelColumn == 31 && row < methodtraces2.size())
                    return editors3.get(row);
                if (modelColumn == 32 && row < methodtraces2.size())
                    return editors4.get(row);
               
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
        
   	
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
       JScrollPane horizontalscroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       getContentPane().add( horizontalscroll );
//      table.getColumnModel().getColumn(1).setCellRenderer(new ComboBoxRenderer() );
      table.setRowHeight(50);
     
    }
 
    private void ComputeCounterTNECallers(MethodTrace2 methodtrace, Object[][] data, int j ) {
		// TODO Auto-generated method stub
    	
		int counterT=0; 
		int counterN=0; 
		int counterE=0; 
		
		for(Method2Representation caller: methodtrace.getCallersList()) {
			
			for(RequirementGold reqgold: caller.getRequirementsGold()) {
				if(reqgold.getRequirement().getID().equals(methodtrace.Requirement.getID())) {
					if(reqgold.getGold().equals("T")) {
						counterT++; 
					}else if(reqgold.getGold().equals("N")) {
						counterN++; 
    				}else if(reqgold.getGold().equals("E")){
    					counterE++; 
    				}
				}
			}
			
			
			
		}
		
for(Method2Representation caller: methodtrace.getCallersListExecuted()) {
			
			for(RequirementGold reqgold: caller.getRequirementsGold()) {
				if(reqgold.getRequirement().getID().equals(methodtrace.Requirement.getID())) {
					if(reqgold.getGold().equals("T")) {
						counterT++; 
					}else if(reqgold.getGold().equals("N")) {
						counterN++; 
    				}else if(reqgold.getGold().equals("E")){
    					counterE++; 
    				}
				}
			}
			
			
			
		}
data[j][12]= counterT; 
data[j][13]= counterN; 
data[j][14]= counterE; 
	}

	static class MyEditor extends BasicComboBoxEditor{
        JScrollPane scroller = new JScrollPane();
        //NOTE: editor is a JTextField defined in BasicComboBoxEditor

        public MyEditor(){
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
            /*editor.setEditable(false); //If you want it not to be editable */
            return editor;
        }
    }
 
    class ComboBoxRenderer extends JComboBox implements TableCellRenderer
    {
 
        public ComboBoxRenderer()
        {
            setBorder(new EmptyBorder(0, 0, 0, 0));
        }
 
        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column)
        {
//          setFocusable(false);
            removeAllItems();
            addItem( value );
            return this;
        }
    }
 
 
    public static void main(String[] args) throws SQLException
    {
    	
        TracesTable frame = new TracesTable();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    }
}





