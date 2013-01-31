package kmeans;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * Class Display: frame to display points / clusters
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class Display extends JFrame {
    
    private ArrayList<GraphicObject> graphicObjects;
    
    
    public Display() {
        super("K-means");
        graphicObjects = new ArrayList<GraphicObject>();
        setSize(Config.WIN_W, Config.WIN_H);
        this.setBackground(Color.white);
        this.addObject(new Grid());
    }
    
    
    public void addObject(GraphicObject o) {
        this.graphicObjects.add(o);
    }
    
    public void removeObject(GraphicObject o) {
        this.graphicObjects.remove(o);
    }
    
    
    @Override
    public void paint(Graphics g) {
        
        ArrayList<GraphicObject> gObjList = new ArrayList<GraphicObject>(graphicObjects);
        
        for (GraphicObject gO:gObjList) {
            gO.paint(g);
        }
        
    }

    void plot(Integer[][] data) {
        // TODO code
    }
    
}