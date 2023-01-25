package model;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;


/**
 * @author david hohn
 * @version Dec 9
 */
public class EllipseTool extends AbstractTool {

    public EllipseTool(final Point2D theStartPoint, final Point2D theEndPoint) {
        super(theStartPoint, theEndPoint);
    }

    @Override
    public Shape getShape() {
        final Ellipse2D.Double ellipse = new Ellipse2D.Double();
        ellipse.setFrameFromDiagonal(getStart(), getEnd());
        return ellipse;
    }

    @Override
    public boolean fill() {
        return true;
    }    
}
