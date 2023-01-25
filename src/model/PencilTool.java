/**
 * 
 */
package model;

import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/**
 * @author David Hohn
 * @version Dec 9
 */
public class PencilTool extends AbstractTool {
    
    
    /** the path for pencil. */
    private final Path2D.Double myPath = new Path2D.Double();

    public PencilTool(final Point2D theStartPoint, final Point2D theEndPoint) {
        // TODO Auto-generated constructor stub
        super(theStartPoint, theEndPoint);
        myPath.moveTo(getStart().getX(), getStart().getY());
    }

    @Override
    public Shape getShape() {
        if (getStart() == getEnd()) {
            myPath.moveTo(getStart().getX(), getStart().getY());
        }
        myPath.lineTo(getEnd().getX(), getEnd().getY());
        return myPath;
    }
    

    @Override
    public boolean fill() {
        return false;
    }
    
}
