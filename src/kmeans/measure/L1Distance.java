package kmeans.measure;

import kmeans.Point;

/**
 * Class L1Distance: computes L1 distances and similarities
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class L1Distance implements Measure {
    
    @Override
    public double d(Point p1, Point p2) {
        // TODO code the distance
        return new Double(1);
    }
    
    @Override
    public double s(Point p1, Point p2) {
        // TODO code the similarity
        return new Double(1);
    }
    
}
