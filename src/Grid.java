
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

/**
 * Class Grid: defines a Grid in which Points must be dislayed
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class Grid extends GraphicObject {
    
    
    public Grid() {
        
    }
    
    
    @Override
    public void plot(Graphics _g) {
        
        Graphics2D g = (Graphics2D) _g;
        
        g.setColor(Color.GRAY);
        Stroke stroke = g.getStroke();
        // define new stroke to draw dashed lines
        g.setStroke(new BasicStroke(
                1f,
                BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND,
                1f,
                new float[] {4f},
                0f));
        g.drawRect(Config.WIN_MARGIN, Config.WIN_MARGIN, Config.GRID_W, Config.GRID_H);
        g.setStroke(stroke);
        
        // axis
        g.drawLine(Config.WIN_MARGIN, Config.ORIG_Y, Config.GRID_W+Config.WIN_MARGIN, Config.ORIG_Y);
        g.drawLine(Config.ORIG_X, Config.WIN_MARGIN, Config.ORIG_X, Config.GRID_H+Config.WIN_MARGIN);
        
        g.setColor(Color.BLACK);
        g.drawString("x", Config.GRID_W+Config.WIN_MARGIN, Config.GRID_H+Config.WIN_MARGIN+12);
        g.drawString("y", Config.WIN_MARGIN-12, Config.WIN_MARGIN);
    }
    
    
}
