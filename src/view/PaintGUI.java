/*
 * TCSS 305 Autumn 2022
 * Assignmnet 5b
 */

package view;
import action.EllipseToolAction;
import action.LineToolAction;
import action.PencilToolAction;
import action.RectangleToolAction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.LineTool;


/**
 * Presents the GUI for the PowerPaint application.
 * 
 * @author Alan Fowler (acfowler@uw.edu)
 * @version Autumn 2022
 * 
 * 
 * @author david hohn
 * @version Dec 9
 */

public final class PaintGUI extends JPanel {
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = 810958738395164242L;
    
    /** string name for color chooser. */
    private static final String COLOR_CHOOSER = "Color Chooser";
    
    /** constant for the slider min value. */
    private static final int MIN_VAL = 0;
    
    /** constant for the slider max value. */
    private static final int MAX_VAL = 15;
    
    /** constant for the slider spacing. */
    private static final int SPACE = 5;
    
    /** constant for the slider initial value. */
    private static final int INITIAL_VAL = 3;
    
    /** number for dividing screen width and height. */
    private static final int PANEL_SIZE = 3;
    
    /** initial points. */
    private static final int INITIAL_POINT = -100;
    
    /** the paint panel. */
    private final PaintPanel myPanel;
    
    /** Line Tool. */
    private final LineToolAction myLineTool;
    
    /** Ellipse tool. */
    private final EllipseToolAction myEllipseTool;
    
    /** Rectangle tool. */
    private final RectangleToolAction myRectTool;
    
    /** Pencil tool. */
    private final PencilToolAction myPencilTool;
    
    /** the clear button. */
    private final JMenuItem myClear = new JMenuItem("Clear");
    
    /** the icon image for the application. */
    private final ImageIcon myImageIcon = new ImageIcon("files/w_small.png");
    
    /** the thickness slider. */
    private final JSlider myThicknessSlider = new JSlider(JSlider.HORIZONTAL, MIN_VAL
            , MAX_VAL, INITIAL_VAL);

    public PaintGUI() {   
        super();
        myPanel = new PaintPanel();
        myLineTool = new LineToolAction(myPanel);
        myEllipseTool = new EllipseToolAction(myPanel);
        myRectTool = new RectangleToolAction(myPanel);
        myPencilTool = new PencilToolAction(myPanel);
        start();
    }
    
    
    
    private JMenuBar myMenuBar() {        
        final JMenuBar menuBar = new JMenuBar();

        // adding the menus to the menu bar
        menuBar.add(myOptionsMenu());
        menuBar.add(myToolsMenu());
        menuBar.add(myHelpMenu());
        
        return menuBar;
    }
    
    // the menu for options which includes the thickness slider
    public JMenu myOptionsMenu() {
        final JMenu options = new JMenu("Options");
        final JMenu thickness = new JMenu("Thickness");
        final JMenuItem drawColor = new JMenuItem("Draw Color...");
        final JMenuItem fillColor = new JMenuItem("Fill Color...");
        final JCheckBox fill = new JCheckBox("Fill");
        
        fill.addActionListener(new ActionListener() {

            public void actionPerformed(final ActionEvent theEvent) {
                if (fill.isSelected()) {
                    myPanel.setFillStatus(true);
                } else {
                    myPanel.setFillStatus(false);
                }
            }
        });
        
        
        myClear.addActionListener(new ActionListener() {

            public void actionPerformed(final ActionEvent theEvent) {
                myPanel.clearShapes();
            }
        });
        
        
        drawColor.addActionListener(new ActionListener() {

            public void actionPerformed(final ActionEvent theEvent) {
                final Color initialcolor = new Color(51, 0, 111);
                final Color color = JColorChooser.showDialog(null,
                        COLOR_CHOOSER, initialcolor);
                if (color != null) {
                    myPanel.setColor(color);
                }
            }
        });
        
        fillColor.addActionListener(new ActionListener() {

            public void actionPerformed(final ActionEvent theEvent) {
                final Color initialcolor = new Color(232, 211, 162);   
                final Color color = JColorChooser.showDialog(null,
                        COLOR_CHOOSER, initialcolor);
                if (color != null) {
                    myPanel.setFillColor(color);
                }
            }
        });
        
        // creating the thickness slider
        thickness.add(myThicknessSlider);
        myThicknessSlider.setMajorTickSpacing(SPACE);
        myThicknessSlider.setMinorTickSpacing(1);
        myThicknessSlider.setPaintTicks(true);
        myThicknessSlider.setPaintLabels(true);
        
        myThicknessSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(final ChangeEvent theEvent) {
                myPanel.setThickness(myThicknessSlider.getValue());
            }
        });
        
        // adding menu Items to the menu
        options.add(thickness);
        options.addSeparator();
        options.add(drawColor);
        options.addSeparator();
        options.add(fillColor);
        options.addSeparator();
        options.add(fill);
        options.addSeparator();
        options.add(myClear);
        
        return options;
    }
    
    // creates the tools menu
    private JMenu myToolsMenu() {
        // creates the tools menu
        final JMenu tools = new JMenu("Tools");
        
        // creating the menu items as radio buttons
        final JRadioButtonMenuItem line = new JRadioButtonMenuItem(myLineTool);
        final JRadioButtonMenuItem ellipse = new JRadioButtonMenuItem(myEllipseTool);
        final JRadioButtonMenuItem rect = new JRadioButtonMenuItem(myRectTool);
        final JRadioButtonMenuItem pencil = new JRadioButtonMenuItem(myPencilTool);
        
        // adding the buttons to a group so only one can be selected at a time
        final ButtonGroup group = new ButtonGroup();
        group.add(line);
        group.add(rect);
        group.add(ellipse);
        group.add(pencil);
        
     // changes the line icon in menu tools
        line.addChangeListener(new ChangeListener() {
            public void stateChanged(final ChangeEvent theEvent) {
                if (line.isSelected()) {
                    line.setIcon(new ImageIcon("files/line.gif"));
                } else {
                    line.setIcon(new ImageIcon("files/line_bw.gif"));
                }
            }
        });
        
        // changes the ellipse icon in menu tools
        ellipse.addChangeListener(new ChangeListener() {
            public void stateChanged(final ChangeEvent theEvent) {
                if (ellipse.isSelected()) {
                    ellipse.setIcon(new ImageIcon("files/ellipse.gif"));
                } else {
                    ellipse.setIcon(new ImageIcon("files/ellipse_bw.gif"));
                }
            }
        });
        
        // changes the rectangle icon in menu tools
        rect.addChangeListener(new ChangeListener() {
            public void stateChanged(final ChangeEvent theEvent) {
                if (rect.isSelected()) {
                    rect.setIcon(new ImageIcon("files/rectangle.gif"));
                } else {
                    rect.setIcon(new ImageIcon("files/rectangle_bw.gif"));
                }
            }
        });
        
        // changes the pencil icon in menu tools
        pencil.addChangeListener(new ChangeListener() {
            public void stateChanged(final ChangeEvent theEvent) {
                if (pencil.isSelected()) {
                    pencil.setIcon(new ImageIcon("files/pencil.gif"));
                } else {
                    pencil.setIcon(new ImageIcon("files/pencil_bw.gif"));
                }
            }
        });
        
        // adding the buttons to the tool menu as menu items
        tools.add(line);
        tools.addSeparator();
        tools.add(rect);
        tools.addSeparator();
        tools.add(ellipse);
        tools.addSeparator();
        tools.add(pencil);
       
        line.setSelected(true);
        
        return tools;
    }
    
    // creates the help menu
    private JMenu myHelpMenu() {
        final JMenu help = new JMenu("Help");
        final JMenuItem about = new JMenuItem("About...");
        
        about.addActionListener(new ActionListener() {

            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showInternalMessageDialog(about, "David Hohn\nAutumn 2022", 
                        "about", JOptionPane.INFORMATION_MESSAGE, myImageIcon);
            }
        });
        
        help.add(about);
        return help;
    }
    
    public void setClearButton() {
        if (myPanel.getPaintedShapes().isEmpty()) {
            myClear.setEnabled(false);
        } else {
            myClear.setEnabled(true);
        }
    }
    
    /**
     * Performs all tasks necessary to display the UI.
     */
    protected void start() {
        myPanel.setGUI(this);
        setClearButton();
 
        myClear.addActionListener(new ActionListener() {

            public void actionPerformed(final ActionEvent theEvent) {
                setClearButton();
            }
        });
        
        final JFrame frame = new JFrame("TCSS 305 Paint - Autumn 2022");       
        frame.setJMenuBar(myMenuBar());
        final ToolBar toolBar = new ToolBar();
//        JToolBar demo = new JToolBar();
        
        myPanel.setCurrentTool(new LineTool(new Point2D.Double(INITIAL_POINT, INITIAL_POINT),
                new Point2D.Double(INITIAL_POINT, INITIAL_POINT)));

        final Action[] actions = {myLineTool, myRectTool, myEllipseTool, myPencilTool};
        
        for (final Action action : actions) {
            toolBar.toolBarButtons(action);
        }
        
        frame.add(myPanel, BorderLayout.CENTER);
        frame.add(toolBar, BorderLayout.SOUTH);
        
        // sets the icon image for the frame
        frame.setIconImage(myImageIcon.getImage());     
        
        /** A ToolKit. */
        final Toolkit kit = Toolkit.getDefaultToolkit(); 
        
        /* set the size of the frame to be 1/3 of the screen */
        frame.setSize((int) (kit.getScreenSize().getWidth() 
                / PANEL_SIZE - frame.getWidth() / PANEL_SIZE), 
                (int) (kit.getScreenSize().getHeight() 
                        / PANEL_SIZE - frame.getHeight() / PANEL_SIZE));
        
        /* set the frame location */
        frame.setLocation(
            (int) (kit.getScreenSize().getWidth() / 2 - frame.getWidth() / 2),
            (int) (kit.getScreenSize().getHeight() / 2 - frame.getHeight() / 2));
        
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

}
