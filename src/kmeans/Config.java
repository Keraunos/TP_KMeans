package kmeans;


import java.awt.Color;
import java.util.ArrayList;

/**
 * Class Config: global configuration constants or variables
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class Config {
    
    // display sizes in pixels
    public static final int WIN_W = 900;
    public static final int WIN_H = 850;
    public static final int WIN_MARGIN = 40; // inner margin
    public static final int GRID_W = WIN_W - 2 * WIN_MARGIN;
    public static final int GRID_H = WIN_H - 2 * WIN_MARGIN;
    public static final int PTS_RADIUS = 2;
    
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
    
    public static double MAX = 1e200;
    
    // colors
    public static Color LIGHT_BLUE = new Color(200, 200, 255);
    public static Color NO_CLUSTER = LIGHT_BLUE;
    public static Color CENTER = Color.GRAY;
    
    
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
        
        double a, bx, by; // coords = a*pixels + b
        
        if ( MAX_X - MIN_X  >=  MAX_Y - MIN_Y ) {
            DISP_RATIO = GRID_W / ( MAX_X - MIN_X );
            
            a = 1/DISP_RATIO;
            bx = MIN_X - a*WIN_MARGIN;
            ORIG_X = (int) (-bx/a);
            
            int bottomY = WIN_MARGIN + (int) (GRID_H/2 + DISP_RATIO*(MAX_Y-MIN_Y)/2);
            by = MIN_Y + a*bottomY;
            ORIG_Y = (int) (by/a);
            
        } else {
            
            DISP_RATIO = GRID_H / ( MAX_Y - MIN_Y );
            System.out.println(DISP_RATIO);
            
            a = -1/DISP_RATIO;
            by = MAX_Y - a*WIN_MARGIN;
            ORIG_Y = (int) (-by/a);
            
            int rightX = WIN_MARGIN + (int) (GRID_W/2 + DISP_RATIO*(MAX_X-MIN_X)/2);
            bx = MAX_X + a*rightX;
            ORIG_X = (int) (bx/a);
            
        }
        
    }
    
}
