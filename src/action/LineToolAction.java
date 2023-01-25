package action;


import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import model.LineTool;
import view.PaintPanel;

/**
 * @author david hohn
 * @version Dec 7
 */
public class LineToolAction extends AbstractAction { 

    /** A generated serialization ID. */
    private static final long serialVersionUID = -69779882826905468L;
    /** the initial point. */
    private static final int INITIAL_POINT = -100;
    /** the paint panel. */
    private final PaintPanel myPanel;

    public LineToolAction(final PaintPanel thePanel) {
        super("Line", new ImageIcon("files/line.gif"));
        myPanel = thePanel; 
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(new LineTool(new Point2D.Double(INITIAL_POINT , INITIAL_POINT)
                , new Point2D.Double(INITIAL_POINT , INITIAL_POINT)));
        
        putValue(Action.SELECTED_KEY, true);
        
    }
}
