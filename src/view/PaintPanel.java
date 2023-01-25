package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import model.EnhancedShape;
import model.PaintTool;


/**
 * @author david hohn
 * @version Dec 9
 */

public class PaintPanel extends JPanel {
    
    /** The background color of the panel. */
    public static final Color BACKGROUND_COLOR = Color.WHITE;
    
    /** the start color. */
    public static final Color UW_PURPLE = new Color(51, 0, 111);
    
    /** start fill color. */
    public static final Color UW_GOLD = new Color(232, 211, 162);

    /** A generated serialization ID. */
    private static final long serialVersionUID = 810958738395164242L;
    
    /** The default size for this JPanel. */
    private static final Dimension DEFAULT_SIZE = new Dimension(400, 300);
    
    /** the start width. */
    private static final int START_WIDTH = 3;
    
    /** list to store the painted shapes to be repainted. */
    private final List<EnhancedShape> myPaintedShapes = new ArrayList<EnhancedShape>();
    
    /** the width for the line drawn. */
    private int myLineWidth = START_WIDTH;
    
    /** for setting fill. */
    private boolean myFillEnabled;
    
    /** the paint color. */
    private Color myColor = UW_PURPLE;
    
    /** the fill color. */
    private Color myFillColor = UW_GOLD;
    
    /** the tool. */
    private PaintTool myTool;
    
    /** boolean for if mouse is being dragged. */
    private boolean myDrag;
    
    /** the starting point. */
    private Point myStart;
    
    /** the GUI. */
    private PaintGUI myGUI;
    
    
    public PaintPanel() {
        super();  
        setPreferredSize(DEFAULT_SIZE);
        setBackground(Color.WHITE);
        final MouseEvents mouseListener = new MouseEvents();
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        
    }
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        
        
        
        for (final EnhancedShape shape : myPaintedShapes) {
            g2d.setStroke(new BasicStroke(shape.getStroke()));
            if (shape.getFill() != null) {
                g2d.setPaint(shape.getFill());
                g2d.fill(shape.getShape());
            }
            g2d.setPaint(shape.getColor());
            g2d.draw(shape.getShape());
        }
        if (myDrag) {
            g2d.setStroke(new BasicStroke(myLineWidth));
            if (myFillEnabled && myTool.fill()) {
                g2d.setPaint(myFillColor);
                g2d.fill(myTool.getShape());
            }
            g2d.setPaint(myColor);
            g2d.draw(myTool.getShape());
        }
        
        myGUI.setClearButton();
        
    }
    
    public void setGUI(final PaintGUI theGUI) {
        myGUI = theGUI;
    }
    
    public void setCurrentTool(final PaintTool theTool) {
        myTool = theTool;
    }
    
    public void clearShapes() {
        myPaintedShapes.clear();
    }
    
    public List<EnhancedShape> getPaintedShapes() {
        return myPaintedShapes;
    }
    
    public void setThickness(final int theThickness) {
        myLineWidth = theThickness;
    }
    
    public void setColor(final Color theColor) {
        myColor = theColor;
    }
    
    public void setFillColor(final Color theFillColor) {
        myFillColor = theFillColor;
    }
    
    public void setFillStatus(final boolean theEnable) {
        myFillEnabled = theEnable;
    }
    
    public class MouseEvents extends MouseAdapter {
    
        public void mousePressed(final MouseEvent theEvent) {
            myDrag = true;
            myStart = theEvent.getPoint();
            myTool.setStart(myStart);
            myTool.setEnd(myStart);
            repaint();
        }    

        public void mouseDragged(final MouseEvent theEvent) {
            myDrag = true;
            myTool.setEnd(theEvent.getPoint()); 
            repaint();
        }
    
        public void mouseReleased(final MouseEvent theEvent) {
            myDrag = false;
            myTool.setEnd(theEvent.getPoint());
            if (myFillEnabled && myTool.fill()) {
                myPaintedShapes.add(new EnhancedShape(myTool.getShape()
                    , myLineWidth, myColor, myFillColor));
            } else {
                myPaintedShapes.add(new EnhancedShape(myTool.getShape()
                        , myLineWidth, myColor, null));
            }
            repaint();
        }     
    
    }
    
}
