package Gantt;

public class testt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="net.sourceforge.ganttproject.ChartComponentBase$1.startDateChanged(Lnet/sourceforge/ganttproject/chart/ChartViewState$ViewStateEvent;)V"; 
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
