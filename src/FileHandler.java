import java.io.*;

/**
 * Class FileHandler: parse data file
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class FileHandler {
    
    
    /**
     * Parses a file and returns the data in an array
     * 
     * @param fileName the name of the file to be parsed
     * @return array of data
     */
    // TODO change integer to double, to handle non-integer coordinates
    static public Integer[][] readFile(String fileName) {
        
        // TODO do not hardcode nbDim: set functions of nb. columns in data file
        int nbDim = 2;
        int nbPoints = 0;
        
        // count lines (points)
        try {
            
            BufferedReader countReader = new BufferedReader(new FileReader("data/" + fileName));
            int lines = 0;
            while (countReader.readLine() != null) lines++;
            countReader.close();
            
            // TODO adapt in case first line is dedicated to dim names
            nbPoints = lines;
            
        } catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        Integer[][] data = new Integer[nbPoints][nbDim];
        
        // parse data file
        try{
            
            // open file
            FileInputStream fstream = new FileInputStream("data/" + fileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
            // read file line by line
            String strLine, splitLine[];
            int lineIndex = 0;
            while ((strLine = br.readLine()) != null)   {
                splitLine = strLine.split("\\t");
                for (int i = 0; i < nbDim; ++i) {
                    data[lineIndex][i] = Integer.parseInt(splitLine[i]);
                }
                ++lineIndex;
            }
            
            in.close();
            
            displayData(data);
            
        } catch (Exception e) {
            //System.err.println("Parsing file error: " + e.getMessage());
            e.printStackTrace();
        }
        
        return data;
    }
    
    
    static private void displayData(Object[][] data) {
        
        for (int i = 0; i < data.length; ++i) {
            System.out.print((i+1) + " ->\t");
            for (int j = 0; j < data[0].length; ++j) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println("");
        }
        
    }
    
}
