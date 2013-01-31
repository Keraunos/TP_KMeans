package kmeans.measure;

import kmeans.Point;

/**
 * Class EuclidianDistance: computes Euclidian distances and similarities
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class EuclidianDistance implements Measure {
    
    @Override
    public double d(Point p1, Point p2) {
        double res = 0;
        for (int i = 0; i < p1.getDim(); ++i) {
            res += Math.pow( p1.getCoord(i) - p2.getCoord(i) , 2);
        }
        return Math.sqrt(res);
    }
    
    @Override
    public double s(Point p1, Point p2) {
        return 1d / ( 1d + d(p1, p2) );
    }
    
}
