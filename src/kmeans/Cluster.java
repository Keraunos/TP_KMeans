package kmeans;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Class Cluster: defines Cluster graphic objects
 * A Cluster is a group of Points
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class Cluster extends GraphicObject {
    
    private static int paletteIndex = 0;
    private static Color[] palette = {
        Color.BLUE,
        Color.GREEN,
        Color.RED,
        Color.YELLOW,
        Color.ORANGE,
        Color.LIGHT_GRAY,
        Color.CYAN,
        Color.MAGENTA,
        Color.PINK,
        Color.BLACK,
        Color.DARK_GRAY,
    };
    
    private Color color;
    private ArrayList<Point> points;
    private Point center;
    
    
    
    /**
     * Constructor
     */
    public Cluster() {
        setColor();
        points = new ArrayList<Point>();
    }
    
    /**
     * Sets the color of this Cluster using Cluster class palette
     */
    private void setColor() {
        this.color = palette[paletteIndex % palette.length];
        ++paletteIndex;
    }
    
    
    /**
     * Gets the Color of this Cluster
     * @return The Color of this Cluster
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Gets the center Point of this Cluster
     * @return The center Point of this Cluster
     */
    public Point getCenter() {
        return center;
    }
    
    /**
     * Gets the list of Points of this Cluster
     * @return The list of Points of this Cluster
     */
    public ArrayList<Point> getPoints() {
        return points;
    }
    
    /**
     * Gets the Point at the specified position in this Cluster's Points list
     * @param i Index of the Point to return
     * @return The Point at the specified position in this Cluster's Points list
     */
    public Point getPoint(int i) {
        return points.get(i);
    }
    
    /**
     * Sets this Cluster's Color
     * @param color The Color
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    /**
     * Sets the center Point of this Cluster - The given center must be a Point
     * of this Cluster.
     * @param center The Point to be set as center Point
     */
    public void setCenter(Point center) {
        if (center.getCluster() == this)
            this.center = center;
    }
    
    /**
     * Sets the list of Points of this Cluster
     * @param points The list of Points to be set
     */
    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
    
    
    /**
     * Adds the given Point to the list of Points of this Cluster and removes
     * the given Point from its initial Cluster's list of Points
     * @param point The Point to be added
     */
    public void addPoint(Point point) {
        
        if ( ! this.points.contains(point) ) {
            this.points.add(point);
        }
        
        if (point.getCluster() != null) {
            point.getCluster().removePoint(point);
        }
        point.setCluster(this);
    }
    
    /**
     * Adds a Point and define it as the center
     * @param point The Point to be added as the center
     */
    public void addCenterPoint(Point point) {
        addPoint(point);
        setCenter(point);
    }
    
    /**
     * Removes the given Point to the list of Points of this Cluster
     * @param point The Point to be removed
     */
    public void removePoint(Point point) {
        
        if (this.points.contains(point)) {
            this.points.remove(point);
        }
        
        if (this.center == point) this.center = null;
        point.setCluster(null);
    }
    
    
    /**
     * Plots this Cluster on the display frame
     * 
     * @param g The graphics context
     */
    @Override
    public void plot(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
