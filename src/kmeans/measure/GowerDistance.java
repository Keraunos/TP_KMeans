package kmeans.measure;

import kmeans.Point;

/**
 * Class GowerDistance: computes Gower-metric distances and similarities
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class GowerDistance implements Measure {
    
    @Override
    public double d(Point p1, Point p2) {
        // TODO code the distance
        return new Double(3);
    }
    
    @Override
    public double s(Point p1, Point p2) {
        // TODO code the similarity
        return new Double(3);
    }
    
}
