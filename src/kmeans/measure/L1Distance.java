package kmeans.measure;

import kmeans.Point;

/**
 * Class L1Distance: computes L1 distances and similarities
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class L1Distance extends Distance {
    
    @Override
    public double d(Point p1, Point p2) {
        double res = 0;
        for (int i = 0; i < p1.getDim(); ++i) {
            res += Math.abs( p1.getCoord(i) - p2.getCoord(i) );
        }
        return res / (double) p1.getDim();
    }
    
}
