
import java.util.ArrayList;

/**
 * Class Config: global configuration constants or variables
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class Config {
    
    // display sizes in pixels
    public static final int WIN_W = 600;
    public static final int WIN_H = 600;
    public static final int WIN_MARGIN = 50; // inner margin
    public static final int GRID_W = WIN_W - 2 * WIN_MARGIN;
    public static final int GRID_H = WIN_H - 2 * WIN_MARGIN;
    
    // coords of grid origin in pixels
    public static int ORIG_X;
    public static int ORIG_Y;
    
    // coeff to convert point coords to pixels
    public static double DISP_RATIO;
    
    // min/max point coords - see computeBoundingRect()
    public static double MIN_X;
    public static double MAX_X;
    public static double MIN_Y;
    public static double MAX_Y;
    
    
    public static void computeBoundingRect(ArrayList<Point> points) {
        
        double minX = points.get(0).getX();
        double maxX = minX;
        double minY = points.get(0).getY();
        double maxY = minY;
        
        for (Point p:points) {
            if (p.getX() < minX) minX = p.getX();
            else if (p.getX() > maxX) maxX = p.getX();
            if (p.getY() < minY) minY = p.getY();
            else if (p.getY() > maxY) maxY = p.getY();
        }
        
        MIN_X = minX; MAX_X = maxX;
        MIN_Y = minY; MAX_Y = maxY;
        
        if ( MAX_X - MIN_X  >  MAX_Y - MIN_Y ) {
            DISP_RATIO = GRID_H / ( MAX_X - MIN_X );
        } else {
            DISP_RATIO = GRID_W / ( MAX_Y - MIN_Y );
        }
        
        double a, b; // coords = a*pixels + b
        
        a = (MAX_X - MIN_X) / GRID_W;
        b = MIN_X - a*WIN_MARGIN;
        ORIG_X = (int) (-b/a);
        
        a = (MIN_Y - MAX_Y) / GRID_H;
        b = MAX_Y - a*WIN_MARGIN;
        ORIG_Y = (int) (-b/a);
        
    }
    
}
