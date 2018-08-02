package Gantt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test2 {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\JHotDrawFiles\\TracesJHotDrawFinal2.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		String fileName="C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\JHotDrawFiles\\TracesJHotDrawFinal3.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		String line;
		line = bufferedReader.readLine(); 
		int counter=1; 
		// TODO Auto-generated method stub
		try {
			
			
			while ((line = bufferedReader.readLine()) != null) {
			//	line = bufferedReader.readLine(); 
				System.out.println("mycounter"+counter+line);

				String[] linesplitted = line.split(","); 
				String method=linesplitted[1]; 
				counter++; 
				String mypart= method.substring(0, method.indexOf("(")); 
				if(mypart.contains("$") && mypart.contains("init")) {
					System.out.println(line);
				
				    writer.write(line);
				    writer.newLine();
				   
				}
			}
			 writer.close();
	}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}