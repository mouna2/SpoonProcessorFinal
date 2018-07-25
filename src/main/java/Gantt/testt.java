package Gantt;

public class testt {

	public static void main(String[] args) {
		
		
		String res=""; 
		String text="net.sourceforge.ganttproject.GPTreeTableBase$2"; 
		text="net.sourceforge.ganttproject.ChartComponentBase$2(net.sourceforge.ganttproject.gui.options.model.GPOptionGroup[],net.sourceforge.ganttproject.gui.UIFacade)"; 
		text="net.sourceforge.ganttproject.GPTreeTableBase$AbstractImplementation"; 
		//text="net.sourceforge.ganttproject.action.CalculateCriticalPathAction(net.sourceforge.ganttproject.task.TaskManager,net.sourceforge.ganttproject.GanttTree2,net.sourceforge.ganttproject.GanttOptions,net.sourceforge.ganttproject.gui.UIConfiguration,net.sourceforge.ganttproject.GanttProject)"; 
		
		//text="net.sourceforge.ganttproject.action.CalculateCriticalPathAction(net.sourceforge.ganttproject.task.TaskManager,net.sourceforge.ganttproject.GanttTree2,net.sourceforge.ganttproject.GanttOptions,net.sourceforge.ganttproject.gui.UIConfiguration,net.sourceforge.ganttproject.GanttProject)"; 
	text="net.sourceforge.ganttproject.GanttProject$11$1()"; 
		//TransformConstructorIntoInit(text); 
		meth(text); 
		
		
	}
	
	public static void TransformConstructorIntoInit(String constructor) {
		String params= constructor.substring(constructor.indexOf("("), constructor.length()); 
		constructor= constructor.substring(0, constructor.indexOf("(")); 
		String part1= constructor.substring(0, constructor.lastIndexOf(".")+1); 
		//String part2= constructor.substring(constructor.indexOf("("), constructor.length()); 
		constructor=part1+"-init-"+params; 
		
		System.out.println("CONS:"+constructor);
	}
	public static void meth(String text ) {

		
		
		String res=""; 
		
		boolean  flag=false; 
		char[] chars = text.toCharArray();
		 int r = 0; 
		 int pos = text.indexOf("$"); 
		System.out.println("HERE IS THE TEXT "+text);
		if(text.contains("$") ) {
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
//						 if(r==length) {
//							 flag=false; 
//						 }
						
						
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
		else {
			res=text; 
		}

		System.out.println("RES====>"+res);
		

		
		


}
}
