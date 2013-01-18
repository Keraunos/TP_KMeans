
import java.awt.Color;
import java.awt.Graphics;

/**
 * Class Point: defines Point graphic objects
 * 
 * @author Paulo Costa Fertonani, Gaetan Girin
 */
public class Point extends GraphicObject {
    
    private Double coords[];
    private Cluster cluster;
    
    
    public Point(Double x, Double y) {
        this.coords = new Double[2];
        this.coords[0] = x;
        this.coords[1] = y;
    }
    
    public Point(Double[] coords) {
        this.coords = coords;
    }
    
    
    public double getX() {
        return coords[0];
    }
    
    public double getY() {
        return coords[1];
    }
    
    public Double[] getCoords() {
        return coords;
    }
    
    public Cluster getCluster() {
        return cluster;
    }
    
    
    public void setX(double x) {
        this.coords[0] = x;
    }
    
    public void setY(double y) {
        this.coords[1] = y;
    }
    
    public void setCoords(Double[] coords) {
        this.coords = coords;
    }
    
    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }
    
    
    @Override
    public String toString() {
        return "[" + getX() + "][" + getY() + "]";
    }
    
    
    @Override
    public void plot(Graphics g) {
        
        g.setColor(Color.BLUE);
        drawPoint(g, getX(), getY());
        
    }
    
    
}
