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
    
    /**
     * List of graphical objects to be displayed
     */
    private ArrayList<GraphicObject> graphicObjects;
    
    
    /**
     * Constructor
     */
    public Display() {
        super("K-means");
        graphicObjects = new ArrayList<GraphicObject>();
        setSize(Config.WIN_W, Config.WIN_H);
        this.setBackground(Color.white);
        this.addObject(new Grid());
    }
    
    
    /**
     * Adds a graphical object to the list of objects to be displayed
     * 
     * @param o The graphical object to be added
     */
    public void addObject(GraphicObject o) {
        this.graphicObjects.add(o);
    }
    
    /**
     * Removes a graphical object from the list of objects to be displayed
     * 
     * @param o The graphical object to be removed
     */
    public void removeObject(GraphicObject o) {
        this.graphicObjects.remove(o);
    }
    
    
    /**
     * Paints the frame by painting all graphical objects from the list
     * 
     * @param g The graphic context
     */
    @Override
    public void paint(Graphics g) {
        
        ArrayList<GraphicObject> gObjList = new ArrayList<GraphicObject>(graphicObjects);
        
        for (GraphicObject gO:gObjList) {
            gO.paint(g);
        }
        
    }
    
    
}
