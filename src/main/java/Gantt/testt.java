package Gantt;

import org.apache.commons.lang3.StringUtils;

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
	text=" net.sourceforge.ganttproject.ChartComponentBase$2.-init-(Lnet/sourceforge/ganttproject/ChartComponentBase;[Lnet/sourceforge/ganttproject/gui/options/model/GPOptionGroup;Lnet/sourceforge/ganttproject/gui/UIFacade;)V, 01: Create Tasks, inner, N, N, N, InnerPureSurroundedN, CN, 0, 1, 0, 0, 1, 0\r\n" + 
			"";
	text="de.java_chess.javaChess.JavaChess.-init-(Lde.java_chess.javaChess.JavaChess)"; 
	text="de.java_chess.javaChess.renderer2d.ControlLayer$2";
	
	
	text="de.java_chess.javaChess.game.GameImpl.GameStatus$2"; 
	
	text="de.java_chess.javaChess.game.GameImpl.GameStatus$2"; 
	text="de.java_chess.javaChess.game.GameImpl$GameStatus"; 
	text="de.java_chess.javaChess.renderer2d.ControlLayer$2.-init-"; 
	text="de.java_chess.javaChess.renderer2d.ControlLayer.access$0(Lde/java_chess/javaChess/renderer2d/ControlLayer;)";
	text=" net.sourceforge.ganttproject.ChartComponentBase$2.-init-(Lnet/sourceforge/ganttproject/ChartComponentBase;[Lnet/sourceforge/ganttproject/gui/options/model/GPOptionGroup;Lnet/sourceforge/ganttproject/gui/UIFacade;)V, 01: Create Tasks, inner, N, N, N, InnerPureSurroundedN, CN, 0, 1, 0, 0, 1, 0\r\n" + 
			"";
	text="net.sourceforge.ganttproject.chart.ChartModelImpl$1$NewTaskColorOption"; 
	text="net.sourceforge.ganttproject.GanttProject$10"; 
	text="-init-(float,float,int,int,float,[float,float)"; 
	text="access$102(Lnet.sourceforge.ganttproject.GanttOptions,java.awt.Font)"; 
	text="net.sourceforge.ganttproject.GanttGraphicArea$OldMouseMotionListenerImpl"; 
	text="edu.ncsu.csc.itrust.dao.mysql.AccessDAO.-init-(edu.ncsu.csc.itrust.dao.DAOFactory)"; 
	String	method=RewriteFullMethodCallExecutedRemoveDollars(text);
	method=method.substring(0, method.indexOf(")")+1);
	method=method.replaceAll("Lde", "de");
	method=method.replaceAll("Lantlr", "antlr");
	method=method.replaceAll("Ljava", "java");
//	method=RewriteFullMethod(method);
	RemovePackage(text); 
		
	}
	
	

	
	
	private static String RemovePackage(String fullmeth) {
		// TODO Auto-generated method stub
		System.out.println(fullmeth);
		String params= fullmeth.substring(fullmeth.indexOf("("), fullmeth.length()); 
		System.out.println(params);
		String rest=fullmeth.substring(0, fullmeth.indexOf("(")); 
		System.out.println(rest);
		rest=rest.substring(rest.lastIndexOf("."), rest.length());
		System.out.println(rest);
		fullmeth=fullmeth.substring(0, fullmeth.indexOf("(")); 
		System.out.println(fullmeth);
		fullmeth=fullmeth.substring(0, fullmeth.lastIndexOf(".")); 
		System.out.println(fullmeth);
		fullmeth=fullmeth.substring(fullmeth.lastIndexOf(".")+1, fullmeth.length()); 
		System.out.println(fullmeth);
		String result= fullmeth+rest+params; 
		System.out.println(result);
		
		
		return result;
	}


	private static void PushDollarToStart(String text) {
		// TODO Auto-generated method stub
		boolean flag=true; 
		int r=0; 
		int pos=0; 
		char[] chars = text.toCharArray(); 
		while(r<chars.length) {
			if(chars[r]=='$' ) {
			
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
					if(chars[pos-1]!='.'&& chars[pos-1]!='('&& chars[pos-1]!=')'&& pos<chars.length ) {
						pos=r-i; 
						//System.out.println(chars[r]);
						StringBuilder sb = new StringBuilder();
						sb.append(chars);
						sb.deleteCharAt(pos);
						System.out.println(sb.toString());
						chars = sb.toString().toCharArray();
						i++; 
					}
					
			if(chars[pos-1]=='.') {
				flag=false; 
			}
					//r++; 

					}
			}

			
				r++; 
			
			

			}
		
		
		String res=String.valueOf(chars); 
		System.out.println(res);
	}








	private static String RewriteFullMethod(String input) {
		

		StringBuilder buf = new StringBuilder();
		String params= input.substring(input.indexOf("("), input.indexOf(")")+1); 
		String methname= input.substring(0, input.indexOf("(") );
		int i=0; 

		while(i<params.length()-1) {

		if(((params.charAt(i)=='F'|| params.charAt(i)=='D'||params.charAt(i)=='L'|| params.charAt(i)=='Z'||params.charAt(i)=='B'||params.charAt(i)=='I'||params.charAt(i)=='J'||params.charAt(i)=='S'||params.charAt(i)=='C')
		&& ((params.charAt(i+1)=='F'|| params.charAt(i+1)=='D'||params.charAt(i+1)=='L'|| params.charAt(i+1)=='Z'||params.charAt(i+1)=='B'||params.charAt(i+1)=='I'||params.charAt(i+1)=='J'||params.charAt(i+1)=='S'||params.charAt(i+1)=='C')||
		params.charAt(i+1)==')') && params.charAt(i-1)!='.') ||

		((params.charAt(i)=='F'|| params.charAt(i)=='D'||params.charAt(i)=='L'|| params.charAt(i)=='Z'||params.charAt(i)=='B'||params.charAt(i)=='I'||params.charAt(i)=='J'||params.charAt(i)=='S'||params.charAt(i)=='C')
		&& ((params.charAt(i+2)=='F'|| params.charAt(i+2)=='D'||params.charAt(i+2)=='L'|| params.charAt(i+2)=='Z'||params.charAt(i+2)=='B'||params.charAt(i+2)=='I'||params.charAt(i+2)=='J'||params.charAt(i+2)=='S'||params.charAt(i+2)=='C')||
		params.charAt(i+1)==')') && params.charAt(i-1)!='.' ) ||

		(params.charAt(i)=='[' && params.charAt(i-1)==',')||
		(params.charAt(i)=='F'|| params.charAt(i)=='D'||params.charAt(i)=='L'|| params.charAt(i)=='Z'||params.charAt(i)=='B'||params.charAt(i)=='I'||params.charAt(i)=='J'||params.charAt(i)=='S'||params.charAt(i)=='C')
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


		if(params.charAt(i+1)=='F') {
			String params1 = params.substring(0, i+1); 
			String params2 = params.substring(i+2, params.length()); 
			params=params1+",float,"+params2; 
			}
		if(params.charAt(i+1)=='D') {
			String params1 = params.substring(0, i+1); 
			String params2 = params.substring(i+2, params.length()); 
			params=params1+",double,"+params2; 
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
		
		if(params.charAt(i)=='D') {
			if(i==1) {
			String params1 = params.substring(0, 1); 
			String params2 = params.substring(i+1, params.length()); 
			params=params1+"double,"+params2; 
			}
			else {
			if(params.charAt(i-1)=='[') {

			String params1 = params.substring(0, i-1); 
			String params2 = params.substring(i-1, i); 
			String params3 = params.substring(i+2, params.length()); 
			params=params1+","+params2+"double,"+params3; 	
			}
			else {
			String params1 = params.substring(0, i-1); 
			String params2 = params.substring(i+1, params.length()); 
			params=params1+",double,"+params2; 	
			}

			}
			}
		
		if(params.charAt(i)=='F') {
			if(i==1) {
			String params1 = params.substring(0, 1); 
			String params2 = params.substring(i+1, params.length()); 
			params=params1+"float,"+params2; 
			}
			else {
			if(params.charAt(i-1)=='[') {

			String params1 = params.substring(0, i-1); 
			String params2 = params.substring(i-1, i); 
			String params3 = params.substring(i+2, params.length()); 
			params=params1+","+params2+"float,"+params3; 	
			}
			else {
			String params1 = params.substring(0, i-1); 
			String params2 = params.substring(i+1, params.length()); 
			params=params1+",float,"+params2; 	
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
//			String params1 = params.substring(0, i-1); 
//			String params2 = params.substring(i-1, i); 
//			String params3 = params.substring(i+1, params.length()); 
//			params=params1+","+params2+","+params3; 	
			}else{
			String params1 = params.substring(0, i-1); 
			String params2 = params.substring(i+1, params.length()); 
			params=params1+",,"+params2; 	
			}
			}
			}
		if(params.charAt(i+1)==')' && params.charAt(i)=='D') {
			String params1 = params.substring(0, i-1); 
			String params2 = params.substring(i+1, params.length()); 
			params=params1+",double,"+params2; 
			}
		if(params.charAt(i+1)==')' && params.charAt(i)=='F') {
			String params1 = params.substring(0, i-1); 
			String params2 = params.substring(i+1, params.length()); 
			params=params1+",float,"+params2; 
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
		System.out.println(sb.toString());
		sb.insert(r, "[],");
		chars = sb.toString().toCharArray();
		flag=false; 	 
		}
		else if(chars[r]==')' ) {
		StringBuilder sb = new StringBuilder();
		sb.append(chars);
		sb.deleteCharAt(r);
		System.out.println(sb.toString());
		sb.insert(r, "[])");
		chars = sb.toString().toCharArray();
		flag=false; 	 
		}


		}

		r++; 
		}


//		flag=false; 
//		chars = res.toCharArray();
//		r=0; 


		while(r<chars.length) {
		if(chars[r]=='$' ) {
		pos=r; 
		// temp = chars[r+1]; 
		StringBuilder sb = new StringBuilder();
		sb.append(chars);
		sb.deleteCharAt(r);
		chars = sb.toString().toCharArray();
		System.out.println(sb.toString());
		flag=true; 
		}
		while(chars[r]!='.'&& chars[r]!='('&& chars[r]!=')'&& flag==true) {
		System.out.println(chars[r]);
		StringBuilder sb = new StringBuilder();
		sb.append(chars);
		sb.deleteCharAt(r);
		chars = sb.toString().toCharArray();
		System.out.println(sb.toString());

		//r++; 

		}
		flag=false; 

		r++; 

		}
		res = String.valueOf(chars);
		System.out.println("final res : "+res);
		return res;
		

		
		
	}
		
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
//							 if(r==length) {
//								 flag=false; 
//							 }
							
							
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




public static String RewriteFullMethodCallExecutedRemoveDollars(String input) {
	
	String res=input; 
	StringBuilder buf = new StringBuilder();
	


		boolean flag=false; 
		char[] chars = res.toCharArray();
		int r = 0; 
		int pos=0; 
		
		int myindex= input.indexOf("$"); 
		char c= chars[myindex+1]; 
		char c2= chars[myindex+2]; 
		char c3= chars[myindex+3]; 
		char c4= chars[myindex+4]; 
		char c5= chars[myindex+5]; 
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
		else if(Character.isDigit(c) && chars[myindex+2]=='$' && chars[myindex]=='$' ) {
			
			while(r<chars.length) {
				if(chars[r]=='$' ) {
				 pos=r; 
				// temp = chars[r+1]; 
				StringBuilder sb = new StringBuilder();
				System.out.println(sb.toString());
				sb.append(chars);
				sb.deleteCharAt(r);
				chars = sb.toString().toCharArray();
				flag=true; 
				}
				int i=0; 
				if(pos>0) {
					while( flag==true) {
						if( chars[pos-1]!='.'&& chars[pos-1]!='('&& chars[pos-1]!=')' && pos-1<chars.length ) {
							
							pos=r-i; 
						//	System.out.println(chars[r]);
							StringBuilder sb = new StringBuilder();
							sb.append(chars);
							sb.deleteCharAt(pos);
							System.out.println(sb.toString());
							chars = sb.toString().toCharArray();
							
							i++; 
							if(chars[pos-1]=='.' && chars[pos]=='$') {
								sb.deleteCharAt(pos);
								chars = sb.toString().toCharArray();
								flag=false; 
							}else if(chars[pos-1]=='.') {
								flag=false; 
							}
						}
					

						}
				}

				
					r++; 
				
				

				}
		}
		
		
		else if(Character.isDigit(c) && chars.length-myindex-1<3) {

			
			while(r<chars.length) {
				if(chars[r]=='$' ) {
				 pos=r; 
				// temp = chars[r+1]; 
				StringBuilder sb = new StringBuilder();
				sb.append(chars);
				sb.deleteCharAt(r);
				System.out.println(sb.toString());
				chars = sb.toString().toCharArray();
				flag=true; 
				}
				int i=1; 
				if(pos>0) {
					while( flag==true) {
						
							//pos=r-i; 
						//	System.out.println(chars[r]);
							StringBuilder sb = new StringBuilder();
							sb.append(chars);
							sb.deleteCharAt(r);
							System.out.println(sb.toString());
							chars = sb.toString().toCharArray();
							pos++; 
							//r++; 
							if(r==chars.length) {
								flag=false; 
							}
						
					

						}
				}

				
					r++; 
				
				

				}
		
		}
		
else if((Character.isDigit(c)   && Character.isDigit(c2)  && Character.isDigit(c3)  && Character.isDigit(c4) )|| (Character.isDigit(c)   && Character.isDigit(c2)  && Character.isDigit(c3)  )
		|| (Character.isDigit(c)   && Character.isDigit(c2)  )) {

			
			while(r<chars.length) {
				if(chars[r]=='$' ) {
				 pos=r; 
				// temp = chars[r+1]; 
				StringBuilder sb = new StringBuilder();
				
				sb.append(chars);
				sb.deleteCharAt(r);
				System.out.println(sb.toString());
				chars = sb.toString().toCharArray();
				flag=true; 
				}
				int i=0; 
				if(pos>0) {
					while( flag==true) {
						if(chars[pos-1]!='.'&& chars[pos-1]!='('&& chars[pos-1]!=')' && pos-1<chars.length ) {
							pos=r-i; 
							//System.out.println(chars[r]);
							StringBuilder sb = new StringBuilder();
							sb.append(chars);
							sb.deleteCharAt(pos);
							System.out.println(sb.toString());
							chars = sb.toString().toCharArray();
							
							//r++; 
							if(chars[pos]=='(') {
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
				System.out.println(sb.toString());
				chars = sb.toString().toCharArray();
				flag=true; 
				}
				int i=1; 
				if(pos>0) {
					while( flag==true) {
						if(chars[pos-1]!='.'&& chars[pos-1]!='('&& chars[pos-1]!=')' && pos-1<chars.length ) {
							pos=r-i; 
							//System.out.println(chars[r]);
							StringBuilder sb = new StringBuilder();
							sb.append(chars);
							sb.deleteCharAt(pos);
							System.out.println(sb.toString());
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
					while( flag==true) {
						if(chars[pos-1]!='.'&& chars[pos-1]!='('&& chars[pos-1]!=')'&& pos<chars.length ) {
							pos=r-i; 
							//System.out.println(chars[r]);
							StringBuilder sb = new StringBuilder();
							sb.append(chars);
							sb.deleteCharAt(pos);
							System.out.println(sb.toString());
							chars = sb.toString().toCharArray();
							i++; 
						}
						
				if(chars[pos-1]=='.') {
					flag=false; 
				}
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
		
	public static String RemoveDollarConstructorTest(String text) {

		
		
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
	
	
	
	
	public  static String GetMethodNameAndParams(String method) {
		// TODO Auto-generated method stub
		System.out.println("METH BEFORE TRUNCATION"+method);
		String params=method.substring(method.indexOf("("), method.length()); 
		String BeforeParams=method.substring(0, method.indexOf("(")); 
		String methname=BeforeParams.substring(BeforeParams.lastIndexOf(".")+1, BeforeParams.length()); 
		String res= methname+params; 
		System.out.println("RES"+ res);
		return res;
	}
	public static void TransformConstructorIntoInit(String constructor) {
		String params= constructor.substring(constructor.indexOf("("), constructor.length()); 
		constructor= constructor.substring(0, constructor.indexOf("(")); 
		String part1= constructor.substring(0, constructor.lastIndexOf(".")+1); 
		//String part2= constructor.substring(constructor.indexOf("("), constructor.length()); 
		constructor=part1+"-init-"+params; 
		
		System.out.println("CONS:"+constructor);
	}
	public static void meth(String input ) {
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
			if(params.charAt(i-2)==';') {
				String[] parts = params.split(";");
				String AppendedParts=""; 
				for(String part: parts) {
					if(part.charAt(0)=='[') {
						part=part.substring(1, part.length()); 
						part=part+"[]"; 
					}
					AppendedParts=AppendedParts+part+";"; 
					params=AppendedParts; 
				}
//			String params1 = params.substring(0, i-1); 
//			String params2 = params.substring(i-1, i); 
//			String params3 = params.substring(i+1, params.length()); 
//			params=params1+","+params2+","+params3; 	
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
		
}
}
