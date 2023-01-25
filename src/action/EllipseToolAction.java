package action;

import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import model.EllipseTool;
import view.PaintPanel;
/**
 * @author david hohn
 * @version Dec 7
 */
public class EllipseToolAction extends AbstractAction {

    /** A generated serialization ID. */
    private static final long serialVersionUID = 4757602148100534862L;
    
    /** the initial point. */
    private static final int INITIAL_POINT = -100;
    
    /** the paint Panel. */
    private final PaintPanel myPanel;
    
    public EllipseToolAction(final PaintPanel thePanel) {
        super("Ellipse", new ImageIcon("files/ellipse_bw.gif"));
        myPanel = thePanel;
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(new EllipseTool(new Point2D.Double(INITIAL_POINT, INITIAL_POINT)
                , new Point2D.Double(INITIAL_POINT, INITIAL_POINT)));
        
        putValue(Action.SELECTED_KEY, true);
    }

}
