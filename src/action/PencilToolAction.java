package action;

import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import model.PencilTool;
import view.PaintPanel;
/**
 * @author david hohn
 * @version Dec 7
 */
public class PencilToolAction extends AbstractAction {
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = 810958738395164242L;
    
    /** the initial point. */
    private static final int INITIAL_POINT = -100;
    
    /** the paint panel. */
    private final PaintPanel myPanel;


    public PencilToolAction(final PaintPanel thePanel) {
        super("Pencil", new ImageIcon("files/pencil_bw.gif"));
        myPanel = thePanel;
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(new PencilTool(new Point2D.Double(INITIAL_POINT, INITIAL_POINT),
                new Point2D.Double(INITIAL_POINT, INITIAL_POINT)));
        
        putValue(Action.SELECTED_KEY, true);
        
    }

}
