
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
   
   
    
}
