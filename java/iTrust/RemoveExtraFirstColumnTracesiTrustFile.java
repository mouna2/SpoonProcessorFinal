package iTrust;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RemoveExtraFirstColumnTracesiTrustFile {
	public static void main(String [] args) throws IOException {

        // The name of the file to open.
        String fileName = "C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\iTrustFiles\\iTrustTraces.txt";
        String fileName2 = "C:\\Users\\mouna\\new_workspace\\SpoonProcessorFinal\\src\\main\\java\\iTrustFiles\\iTrustTracesFinal.txt";
        // This will reference one line at a time
        String line = null;
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            

          
          
            	String myline=line.substring(line.indexOf(",")+1, line.length()); 
                writer.write(myline);
                writer.newLine();
         
            }   
            writer.close();
            
            // Always close files.
            bufferedReader.close();   
            
            
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }		
}
