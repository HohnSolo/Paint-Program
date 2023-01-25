package model;

import java.awt.geom.Point2D;
/**
 * @author david hohn
 * @version Nov 29
 */
public abstract class AbstractTool implements PaintTool {

    /** the start point. */
    private Point2D myStartPoint;

    /** the end point. */
    private Point2D myEndPoint;
    
    public AbstractTool(final Point2D theStartPoint, final Point2D theEndPoint) {
        myStartPoint = theStartPoint;
        myEndPoint = theEndPoint;
    }
    
    public void setStart(final Point2D theStartPoint) {
        myStartPoint = theStartPoint;
    }
    
    public void setEnd(final Point2D theEndPoint) {
        myEndPoint = theEndPoint;
    }
    
    public Point2D getStart() {
        return myStartPoint;
    }
    
    public Point2D getEnd() {
        return myEndPoint;
    }

    

}
