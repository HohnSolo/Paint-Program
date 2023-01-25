/**
 * 
 */
package model;

import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * @author david hohn
 * @version Dec 9
 */
public class LineTool extends AbstractTool {
    
    public LineTool(final Point2D theStartPoint, final Point2D theEndPoint) {
        // TODO Auto-generated constructor stub
        super(theStartPoint, theEndPoint);
    }
    
    public Shape getShape() {
        return new Line2D.Double(getStart(), getEnd());
    }

    @Override
    public boolean fill() {
        return false;
    }
    
}
