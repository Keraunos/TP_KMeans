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
    static private String fileName = "sample3.txt";
    static private int K = 3; // number of clusters
    static private int iter = 200;
    // EuclidianDistance / L1Distance / CanberraDistance
    static private Measure measure = new EuclidianDistance();
    
    // lists of points and clusters (groups of points)
    static private ArrayList<Point> points;
    static private ArrayList<Cluster> clusters;
    static private ArrayList<Point> centers;
    
    static private Display disp;
    
    
    public static void main(String[] args) {
        
        // TEST
//        Point p1 = new Point(-1d, -1d);
//        Point p2 = new Point(2d, 3d);
//        System.out.println(measure.d(p1, p2));
//        System.out.println(measure.s(p1, p2));
//        return;
        
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
        pause(2000);
        
        double minDist, currDist;
        Cluster alloc;
        
        for (int i = 0; i < iter; ++i) {
            
            disp.setLabel("[ iteration #" + (i+1) + " ]");
            
            // allocate points to group which center is closest
            for (Point p:points) {
                
                minDist = Config.MAX;
                alloc = clusters.get(0); // default initialization
                
                for (Cluster c:clusters) {
                    currDist = measure.d(p, c.getCenter());
                    if (currDist < minDist) {
                        minDist = currDist;
                        alloc = c;
                    }
                }
                
                alloc.addPoint(p);
            }
            
            // recenter: calculate gravity centers for formed groups
            Point newCenter;
            for (Cluster c:clusters) {
                
                // delete previous center if it not a Point of the Cluster
                if ( ! c.getPoints().contains(c.getCenter()) ) {
                    disp.removeObject(c.getCenter());
                }
                
                newCenter = c.makeGravityCenter();
                disp.addObject(newCenter);
            }
            
            disp.repaint();
            pause(50);
        }
        
        
    }
    
    
    /**
     * Pauses the current thread for the given duration in ms
     * @param durationMillis The duration in milliseconds
     */
    public static void pause(int durationMillis) {
        double t1, t0 = System.currentTimeMillis();
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            t1 = System.currentTimeMillis();
        } while (t1 - t0 < durationMillis);
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
            clusters.get(i).addCenterPoint(points.get(rand));
        }
        
        for (Point p:centers) System.out.println(p);
        
    }
    
}
