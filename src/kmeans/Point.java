package kmeans;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Class Point: defines Point graphic objects
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class Point extends GraphicObject {
    
    private Double coords[]; // coordinates
    private Cluster cluster;
    
    
    /**
     * 2D Constructor
     * 
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Point(Double x, Double y) {
        this.coords = new Double[2];
        this.coords[0] = x;
        this.coords[1] = y;
    }
    
    /**
     * n-dimension constructor
     * 
     * @param coords The array of coordinates (its length is the dimension)
     */
    public Point(Double[] coords) {
        this.coords = coords;
    }
    
    
    /**
     * Gets first coordinate
     * @return The value of the first coordinate
     */
    public double getX() {
        return coords[0];
    }
    
    /**
     * Gets the second coordinate
     * @return The value of the second coordinate
     */
    public double getY() {
        return coords[1];
    }
    
    /**
     * Gets the array of coordinates
     * @return The array of coordinates
     */
    public Double[] getCoords() {
        return coords;
    }
    
    /**
     * Gets the Cluster of this Point
     * @return The Cluster
     */
    public Cluster getCluster() {
        return cluster;
    }
    
    
    /**
     * Sets 1st coordinate
     * @param x The value of the 1st coordinate
     */
    public void setX(double x) {
        this.coords[0] = x;
    }
    
    /**
     * Sets 2nd coordinate
     * @param y The value of the 2nd coordinate
     */
    public void setY(double y) {
        this.coords[1] = y;
    }
    
    /**
     * Sets the array of coordinates
     * @param coords The array the coordinates must be set to
     */
    public void setCoords(Double[] coords) {
        this.coords = coords;
    }
    
    /**
     * Sets the Cluster of this Point to given Cluster
     * @param cluster The Cluster to be set
     */
    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }
    
    
    /**
     * Returns this Point's formatted coordinates: [x][y][z](...)
     * 
     * @return The formatted String to display this Point's coordinates
     */
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < this.coords.length; ++i)
            res += "[" + this.coords[i] + "]";
        return res;
    }
    
    
    /**
     * Plots this Point on the display frame
     * 
     * @param g The graphics context
     */
    @Override
    public void plot(Graphics g) {
        
        // TODO change to compare this point with its cluster's center
        if (getCluster() != null) {
            g.setColor(Color.ORANGE);            
        } else {
            g.setColor(Color.BLUE);
        }
        drawPoint(g, getX(), getY());
        
    }
    
    
}
