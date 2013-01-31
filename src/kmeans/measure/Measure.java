package kmeans.measure;

import kmeans.Point;

/**
 * Interface Measure
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public interface Measure {
    
    /**
     * Gets the distance between the two given Points
     * @param p1 The first Point
     * @param p2 The second Point
     * @return The distance between the two given Points
     */
    public double d(Point p1, Point p2);
    
    /**
     * Gets the similarity between the two given Points
     * @param p1 The first Point
     * @param p2 The second Point
     * @return The similarity between the two given Points
     */
    public double s(Point p1, Point p2);
    
}
