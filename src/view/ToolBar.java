package view;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author david hohn
 * @version Dec 8
 */

public class ToolBar extends JToolBar {

    /** A generated serialization ID. */
    private static final long serialVersionUID = -69779882826905468L;
    
    /** the word line. */
    private static final String WORD_LINE = "Line";

    /** A button group for tool bar. */ 
    private final ButtonGroup myGroup;
    
    public ToolBar() {
        super();
        myGroup = new ButtonGroup();
    }

    public void toolBarButtons(final Action theAction) {
        final JToggleButton toggleButton = new JToggleButton(theAction);
        
        myGroup.add(toggleButton);
        add(toggleButton);
        
        if (theAction.getValue(Action.NAME).equals(WORD_LINE)) {
            toggleButton.setSelected(true);
            
        }
        
        // changes the icon for line.
        if (theAction.getValue(Action.NAME).equals(WORD_LINE)) {
            toggleButton.addChangeListener(new ChangeListener() {
                public void stateChanged(final ChangeEvent theEvent) {
                    if (toggleButton.isSelected()) {
                        toggleButton.setIcon(new ImageIcon("files/line.gif"));
                    } else {
                        toggleButton.setIcon(new ImageIcon("files/line_bw.gif"));
                    }
                }
            });
         // changes the icon for Ellipse.
        } else if (theAction.getValue(Action.NAME).equals("Ellipse")) {
            toggleButton.addChangeListener(new ChangeListener() {
                public void stateChanged(final ChangeEvent theEvent) {
                    if (toggleButton.isSelected()) {
                        toggleButton.setIcon(new ImageIcon("files/ellipse.gif"));
                    } else {
                        toggleButton.setIcon(new ImageIcon("files/ellipse_bw.gif"));
                    }
                }
            });
         // changes the icon for rectangle.
        } else if (theAction.getValue(Action.NAME).equals("Rectangle")) {
            toggleButton.addChangeListener(new ChangeListener() {
                public void stateChanged(final ChangeEvent theEvent) {
                    if (toggleButton.isSelected()) {
                        toggleButton.setIcon(new ImageIcon("files/rectangle.gif"));
                    } else {
                        toggleButton.setIcon(new ImageIcon("files/rectangle_bw.gif"));
                    }
                }
            });
         // changes the icon for pencil.
        } else if (theAction.getValue(Action.NAME).equals("Pencil")) {
            toggleButton.addChangeListener(new ChangeListener() {
                public void stateChanged(final ChangeEvent theEvent) {
                    if (toggleButton.isSelected()) {
                        toggleButton.setIcon(new ImageIcon("files/pencil.gif"));
                    } else {
                        toggleButton.setIcon(new ImageIcon("files/pencil_bw.gif"));
                    }
                }
            });
        }
        
    }
    
}
