package kmeans.measure;

import kmeans.Point;

/**
 * Class CanberraDistance: computes Canberra-metric distances and similarities
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class CanberraDistance extends Distance {
    
    @Override
    public double d(Point p1, Point p2) {
        // TODO code the distance
        return new Double(2);
    }
    
    @Override
    public double s(Point p1, Point p2) {
        // TODO code the similarity
        return new Double(2);
    }
    
}
