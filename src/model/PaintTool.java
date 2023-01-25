package model;
import java.awt.Shape;
import java.awt.geom.Point2D;
/**
 * @author david hohn
 * @version Dec 9
 */
public interface PaintTool {
    
    void setStart(Point2D theSetStartPoint);
   
    void setEnd(Point2D theSetEndPoint);
    
    Shape getShape();
    
    boolean fill();
}
