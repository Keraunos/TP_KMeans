package kmeans;

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
    static public Double[][] readFile(String fileName) {
        
        // default initializations
        int nbDim = 0;
        int nbPoints = 0;
        boolean textOnFirstLine = false;
        
        // count lines (points = rows) and dimensions (columns)
        try {
            
            BufferedReader countReader = new BufferedReader(new FileReader("data/" + fileName));
            int lines = 0;
            String currLine;
            while ((currLine = countReader.readLine()) != null) {
                
                try {
                    // make the program raise an exception if the line does not begin with a number
                    Double.parseDouble(currLine.split("\\t")[0].replace(",", "."));
                    lines++;
                } catch (NumberFormatException nfe) {
                    textOnFirstLine = true;
                    // Ignore exception gracefully
                }
                
                if (lines == 1) {
                    nbDim = currLine.split("\\t").length;
                }
            }
            countReader.close();
            
            nbPoints = lines;
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        Double[][] data = new Double[nbPoints][nbDim];
        
        // parse data file
        try{
            
            // open file
            FileInputStream fstream = new FileInputStream("data/" + fileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
            // read file line by line
            String strLine, splitLine[];
            int lineIndex = 0;
            boolean firstLoop = true;
            while ((strLine = br.readLine()) != null)   {
                if (firstLoop && textOnFirstLine) {
                    firstLoop = false;
                    continue;
                }
                splitLine = strLine.split("\\t");
                for (int i = 0; i < nbDim; ++i) {
                    data[lineIndex][i] = Double.parseDouble(
                            splitLine[i].replace(",", "."));
                }
                ++lineIndex;
            }
            
            in.close();
            
            //displayData(data);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return data;
    }
    
    
    /**
     * Debug method to check if program reads the file properly
     * 
     * @param data 
     */
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
