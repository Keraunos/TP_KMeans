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
        double res = 0;
        for (int i = 0; i < p1.getDim(); ++i) {
            if (p1.getCoord(i) != 0 || p2.getCoord(i) != 0) {
                res += Math.abs( p1.getCoord(i) - p2.getCoord(i) ) /
                    ( Math.abs(p1.getCoord(i)) + Math.abs(p2.getCoord(i)) );
            }
        }
        return res / (double) p1.getDim();
    }
    
}
