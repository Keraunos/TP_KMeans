import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

/**
 * Class KMeans: contains a k-means algorithms and associated methods
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class KMeans {
    
    
    static private String fileName = "sample1.txt";
    static private int K = 2;
    static private int iter = 5;
    static private ArrayList<Color> palette;
    
    public static void main(String[] args) {
        
        Double[][] data = FileHandler.readFile(fileName);
        
        // build graphic points from coords' array
        ArrayList<Point> points = pointsFromData(data);
        Config.computeBoundingRect(points);
        
        // define K temporary centres
        ArrayList<Point> centers = setRandCenters(points);
        
        Display disp = new Display();
        disp.setVisible(true);
        for (Point p:points) {
            disp.addObject(p);
        }
        
        for (int i = 0; i < iter; ++i) {
            
            // allocate points to group which centre is closest
            
            
            // recenter: calculate gravity centers for formed groups
            
        }
        
        
        
    }
    
    
    /**
     * Creates a list of Points from raw data
     * 
     * @param data
     * @return 
     */
    private static ArrayList<Point> pointsFromData(Double[][] data) {
        
        ArrayList<Point> res = new ArrayList<Point>();
        
        for (int i = 0; i < data.length; ++i) {
            res.add(new Point(data[i]));
            //System.out.println(res.get(i));
        }
        
        return res;
    }
    
    
    /**
     * Randomly sets K temporary cluster centers
     * 
     * @param points list of all the Points
     * @return list of K Points designated as temporary centers
     */
    private static ArrayList<Point> setRandCenters(ArrayList<Point> points) {
        
        ArrayList<Point> res = new ArrayList<Point>();
        
        int rand;
        for (int i = 0; i < K; ++i) {
            do {
                rand = (int) (Math.random() * points.size());
            } while (res.contains(points.get(rand)));
            res.add(points.get(rand));
        }
        
        for (Point p:res) System.out.println(p);
        
        return res;
    }
    
}
