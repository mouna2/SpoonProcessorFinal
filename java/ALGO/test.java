package ALGO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 String s="00-44  48 5555 8361"; 
	// String s="  00   "; 

//		 int []A= {-1, -3}; 
		String r= solution(s); 
System.out.println(r);
	}

	
	
	   public static String solution(String s) {
		   
			   s=s.replaceAll("-", ""); 
			   s=s.replaceAll("\\s+", ""); 
			   System.out.println("hey"+s+"jehfd");
			   if(s.length()==2|| s.length()==3) {
				   		return s ;
			   }
			   char[] myarr = s.toCharArray(); 
			   int i=0; 
			   String newString=""; 
			   int j=0; 
			   while(i<myarr.length) {
				   System.out.println(newString);
				 
				   if(j!=0 && j%3==0 ) {
					   
					   newString=newString+"-"; 
					   j=0; 
				   }else {
					   newString=newString+myarr[i]; 
					   j++; 
					   i++; 
				   }
				   
			   }
			   System.out.println(newString);
			   return newString; 
		  
		   
		  
		   
	   }
}
