package kmeans;


import java.awt.Color;
import java.awt.Graphics;

/**
 * Class FileHandler: parse data file
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
abstract class GraphicObject {
    
   public void paint(Graphics g) {
       colorize(g);
       plot(g);
   } 
   
   public void colorize(Graphics g) {
        g.setColor(Color.BLACK);
   }
    
   public abstract void plot(Graphics g);
   
   public void drawPoint(Graphics g, double x, double y) {
       g.fillRect(
               Config.ORIG_X + (int) (x * Config.DISP_RATIO) - Config.PTS_RADIUS,
               Config.ORIG_Y - (int) (y * Config.DISP_RATIO) - Config.PTS_RADIUS,
               2 * Config.PTS_RADIUS,
               2 * Config.PTS_RADIUS);
   }
   
   public void drawBigPoint(Graphics g, double x, double y) {
       g.fillOval(
               Config.ORIG_X + (int) (x * Config.DISP_RATIO) - 3 * Config.PTS_RADIUS,
               Config.ORIG_Y - (int) (y * Config.DISP_RATIO) - 3 * Config.PTS_RADIUS,
               6 * Config.PTS_RADIUS,
               6 * Config.PTS_RADIUS);
   }
    
}
