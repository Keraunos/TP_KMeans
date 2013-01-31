package kmeans.measure;

import kmeans.Point;

/**
 * Class EuclidianDistance: computes Euclidian distances and similarities
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class EuclidianDistance extends Distance {
    
    @Override
    public double d(Point p1, Point p2) {
        double res = 0;
        for (int i = 0; i < p1.getDim(); ++i) {
            res += Math.pow( p1.getCoord(i) - p2.getCoord(i) , 2);
        }
        return Math.sqrt(res);
    }
    
}
