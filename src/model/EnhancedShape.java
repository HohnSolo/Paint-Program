package model;

import java.awt.Color;
import java.awt.Shape;

/* class to store the drawn shapes so they can be repainted. */

public class EnhancedShape {
    
    /** for the shape. */
    private final Shape myShape;
    /** for the stroke width. */
    private final int myStroke;
    /** for the color. */
    private final Color myColor;
    /** for the fill color. */
    private final Color myFillColor;
    
    public EnhancedShape(final Shape theShape, final int theStroke,
            final Color theColor, final Color theFill) {
        myShape = theShape;
        myStroke = theStroke;
        myColor = theColor;    
        myFillColor = theFill;
    }
    
    public Shape getShape() {
        return myShape;
    }
    
    public int getStroke() {
        return myStroke;
    }
    
    public Color getColor() {
        return myColor;
    }
    
    public Color getFill() {
        return myFillColor;
    }

}
