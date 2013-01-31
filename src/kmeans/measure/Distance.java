package kmeans.measure;

import kmeans.Point;

/**
 * Class Distance: computes distances and similarities
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public abstract class Distance implements Measure {
    
    /**
     * Gets the default equivalent similarity from computed distance
     * 
     * @param p1 The first Point 
     * @param p2 The second Point
     * @return The similarity between the two given Points
     */
    @Override
    public double s(Point p1, Point p2) {
        return 1d / ( 1d + d(p1, p2) );
    }
    
}