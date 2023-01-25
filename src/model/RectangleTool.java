/**
 * 
 */
package model;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * @author David Hohn
 * @version Dec 9
 */
public class RectangleTool extends AbstractTool {

    public RectangleTool(final Point2D theStartPoint, final Point2D theEndPoint) {
        // TODO Auto-generated constructor stub
        super(theStartPoint, theEndPoint);
    }

    @Override
    public Shape getShape() {
        final Rectangle2D.Double rectangle = new Rectangle2D.Double();
        rectangle.setFrameFromDiagonal(getStart(), getEnd());
        return rectangle;
    }

    @Override
    public boolean fill() {
        return true;
    }

}
