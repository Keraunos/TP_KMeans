package kmeans;

import java.util.ArrayList;
import kmeans.measure.*;
import org.apache.commons.math3.stat.descriptive.*;

/**
 * Class KMeans: contains a k-means algorithms and associated methods
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class KMeans {
    
    // algorithm parameters
    //static private String fileName = "listOfMeans_raw.txt";
    static private String fileName = "sample2.txt";
    static private int K = 6; // number of clusters
    static private boolean stopOnConverge = true;
    static private int maxIter = 500;
    static private int nbTests = 1;
    static private double[] testResults; // list of iteration numbers to converge
    // EuclidianDistance / L1Distance / CanberraDistance
    static private Measure measure = new L1Distance();
    static private Boolean canDisplay = true;
    
    // lists of points and clusters (groups of points)
    static private ArrayList<Point> points;
    static private ArrayList<Cluster> clusters;
    static private ArrayList<Point> centers;
    
    static private Display disp;
    
    
    public static void main(String[] args) {
        
        // TEST MEASURE
//        Point p1 = new Point(-1d, -1d);
//        Point p2 = new Point(2d, 3d);
//        System.out.println(measure.d(p1, p2));
//        System.out.println(measure.s(p1, p2));
//        return;
        
        Double[][] data = FileHandler.readFile(fileName);
        
        // cannot display points if dimension is > 2
        if (data[0].length != 2) canDisplay = false;
        
        // build graphic points from coords' array
        buildPointsFromData(data);
        Config.computeBoundingRect(points);
        
        // init display
        if (canDisplay) {
            disp = new Display();
            disp.setVisible(true);
            for (Point p : points) {
                disp.addObject(p);
            }
        }
        
        testResults = new double[nbTests];
        
        for (int t = 0; t < nbTests; ++t) {
            
            // define K clusters and K temporary centres
            clusters = new ArrayList<Cluster>();
            for (int i = 0; i < K; ++i) {
                clusters.add(new Cluster());
            }
            setRandomCenters();
            for (Cluster c : clusters) {
                System.out.println("center for cluster " + c + ": " + c.getCenter());
            }
            
            if (canDisplay) pause(1000);
            
            
            // variables used in for loops
            double minDist, currDist, diff;
            Double[] prevCoords, newCoords;
            Cluster alloc;
            Point newCenter;

            for (int i = 0; i < maxIter; ++i) {

                if (canDisplay) {
                    disp.setLabel("[ iteration #" + (i + 1) + " ]");
                } else {
                    System.out.println("------> iteration #" + (i + 1));
                }

                // allocate points to group which center is closest
                for (Point p : points) {

                    minDist = Config.MAX;
                    alloc = clusters.get(0); // default initialization

                    for (Cluster c : clusters) {
                        currDist = measure.d(p, c.getCenter());
                        if (currDist < minDist) {
                            minDist = currDist;
                            alloc = c;
                        }
                    }

                    alloc.addPoint(p);
                }

                // recenter: calculate gravity centers for formed groups
                diff = 0;
                prevCoords = null;
                for (Cluster c : clusters) {

                    // delete previous center if it not a Point of the Cluster
                    if (canDisplay && !c.getPoints().contains(c.getCenter())) {
                        disp.removeObject(c.getCenter());
                    }

                    if (stopOnConverge) {
                        prevCoords = c.getCenter().getCoords();
                    }

                    newCenter = c.makeGravityCenter();

                    if (stopOnConverge) {
                        newCoords = c.getCenter().getCoords();
                        for (int k = 0; k < prevCoords.length; ++k) {
                            diff += Math.abs(prevCoords[k] - newCoords[k]);
                        }
                    }

                    if (canDisplay) {
                        disp.addObject(newCenter);
                    } else {
                        //System.out.println("\tcenter for " + c + ": " + c.getCenter());
                        System.out.println(c.getCenter());
                    }
                    
                } // loop over clusters

                if (canDisplay) {
                    disp.repaint();
                }

                // if Clusters' centers don't change anymore, then stop (algorithm converged)
                if (diff == 0 && stopOnConverge) {
                    testResults[t] = (double) i;
                    if (canDisplay) {
                        disp.setLabel("[ Converged at iteration #" + (i) + " ]");
                        disp.repaint();
                    } else {
                        System.out.println("[ Converged at iteration #" + (i) + " ]");
                    }
                    break;
                }

                pause(100);
                
            } // loop over iterations
            
            if (testResults[t] == 0) {
                System.out.println("!!!!!!!!!! Test #" + t + " did not converge.");
                if (stopOnConverge) return;
            }
            
            // reset display
            if (canDisplay && t+1 < nbTests) {
                for (Point p:points) p.setCluster(null);
                for (Cluster c:clusters) disp.removeObject(c.getCenter());
            }
            
        } // loop over tests
        
        
        // display test results and compute means
        DescriptiveStatistics stats = new DescriptiveStatistics(testResults);
        System.out.println("=========> Results:");
        for (int t = 0; t < nbTests; ++t) {
            System.out.println("--> [ " + testResults[t] + " ]");
        }
        System.out.println("=========> Means: " + stats.getMean());
        System.out.println("=========> Std dev: " + stats.getStandardDeviation());
        
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
