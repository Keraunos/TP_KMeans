
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
    private Point center;
    private ArrayList<Point> points;
    private Color color;
    
    
    public Cluster() {
        setColor();
    }
    
    private void setColor() {
        this.color = palette[paletteIndex % palette.length];
        ++paletteIndex;
    }
    
    
    public Color getColor() {
        return color;
    }
    
    public Point getCenter() {
        return center;
    }
    
    public ArrayList<Point> getPoints() {
        return points;
    }
    
    public Point getPoint(int i) {
        return points.get(i);
    }
    
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public void setCenter(Point center) {
        this.center = center;
    }
    
    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
    
    public void setPoint(int i, Point point) {
        this.points.set(i, point);
    }
    
    
    public void addPoint(Point point) {
        this.points.add(point);
    }
    
    public void removePoint(Point point) {
        this.points.remove(point);
    }
    
    
    public void changePointCluster(Point point, Cluster cluster) {
        points.remove(point);
        point.setCluster(cluster);
        cluster.addPoint(point);
    }
    
    public void changePointCluster(int i, Cluster cluster) {
        changePointCluster(points.get(i), cluster);
    }
    
    
    @Override
    public void plot(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
