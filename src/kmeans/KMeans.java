package kmeans;

import java.util.ArrayList;
import kmeans.measure.*;

/**
 * Class KMeans: contains a k-means algorithms and associated methods
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class KMeans {
    
    // algorithm parameters
    static private String fileName = "sample1.txt";
    static private int K = 2; // number of clusters
    static private int iter = 5;
    static private Measure measure = new EuclidianDistance();
    
    // lists of points and clusters (groups of points)
    static private ArrayList<Point> points;
    static private ArrayList<Cluster> clusters;
    static private ArrayList<Point> centers;
    
    static private Display disp;
    
    
    public static void main(String[] args) {
        
        Double[][] data = FileHandler.readFile(fileName);
        
        // build graphic points from coords' array
        buildPointsFromData(data);
        Config.computeBoundingRect(points);
        
        // define K clusters and K temporary centres
        clusters = new ArrayList<Cluster>();
        for (int i = 0; i < K; ++i) {
            clusters.add(new Cluster());
        }
        setRandomCenters();
        for (Cluster c:clusters) {
            System.out.println("center for cluster " + c + ": " + c.getCenter());
            
        }
        
        disp = new Display();
        disp.setVisible(true);
        for (Point p:points) disp.addObject(p);
        
        for (int i = 0; i < iter; ++i) {
            
            // allocate points to group which center is closest
            for (Point p:points) {
                
            }
            
            // recenter: calculate gravity centers for formed groups
            
        }
        
        
        
    }
    
    
    /**
     * Creates a list of Points from raw data
     * 
     * @param data Array of coordinates
     */
    private static void buildPointsFromData(Double[][] data) {
        
        points = new ArrayList<Point>();
        
        for (int i = 0; i < data.length; ++i) {
            points.add(new Point(data[i]));
        }
        
    }
    
    
    /**
     * Randomly sets K temporary cluster centers
     * 
     */
    private static void setRandomCenters() {
        
        centers = new ArrayList<Point>();
        
        int rand;
        for (int i = 0; i < K; ++i) {
            do {
                rand = (int) (Math.random() * points.size());
            } while (centers.contains(points.get(rand)));
            centers.add(points.get(rand));
            clusters.get(i).addPoint(points.get(rand));
            clusters.get(i).setCenter(points.get(rand));
        }
        
        for (Point p:centers) System.out.println(p);
        
    }
    
}
