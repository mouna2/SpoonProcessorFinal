import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

import org.eclipse.jdt.internal.compiler.ast.WhileStatement;

public class hello11 {

	
		// TODO Auto-generated method stub
		public static void main(String[] args) throws  IOException  {
			Stack<Character> stack= new Stack<Character>(); 
			Scanner sc = new Scanner(System.in); 
			String firstLine=sc.nextLine(); 
			int testcasesNumber=Integer.parseInt(firstLine); 
			int i=0; 
			String mystring=""; 
			while(i<testcasesNumber) {
			String number= sc.nextLine(); 
			
			 String Binaryrep = Integer.toBinaryString(Integer.parseInt(number)); 
			
			int missing=32-Binaryrep.length(); 
			String missing0s=""; 
			for(int j=0; j<missing; j++) {
				missing0s=missing0s+"0"; 
			}
			Binaryrep=missing0s+Binaryrep; 
//			System.out.println(Binaryrep);

			 char []binary= Binaryrep.toCharArray(); 
			
			for(char c: binary) {
				stack.push(c); 
			}
			
			while(!stack.isEmpty()) {
				mystring=mystring+stack.pop(); 
			}
			
//			System.out.println(mystring);
			
			double sum=0; 
			for(int k=0; k<binary.length; k++) {
				if(binary[k]=='1') {
					sum=sum+Math.pow(2, k); 
				}
			}
			
			
			System.out.println((int)sum);
			i++; 
			}
		}

	
}


