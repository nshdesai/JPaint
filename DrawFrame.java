import java.awt.Color;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;

/**
 * The main frame of the SuperPaint program
 *
 * @author ndesai
 * @version 10th May 2019
 * @see {@link JFrame}
 */
public class DrawFrame extends JFrame {
    // Constants
    private String[] shapeTypes = {"Line", "Rect", "Oval"};
    private String[] colorNames = {"Black", "Red", "Green", "Blue", "Yellow", "Orange"};
    private Color[] colorValues = {Color.BLACK, Color.RED, Color.green, Color.BLUE, Color.YELLOW, Color.ORANGE};

    // Widgets
    private JButton undoButton = new JButton("Undo");
    private JButton redoButton = new JButton("Redo");
    private JButton clearButton = new JButton("Clear");
    private JComboBox<String> colorDropDown = new JComboBox<String>(colorNames);
    private JComboBox<String> shapeDropDown = new JComboBox<String>(shapeTypes);
    private JCheckBox filledCheckBox = new JCheckBox("Filled");
    private JLabel statusBar;
    private JPanel widgetPanel = new JPanel();
    private PaintPanel paintPanel;

    /**
     * Defualt constrcutor for DrawFrame.
     * Sets up all the components used in the UI and configures layout
     */
    public DrawFrame() {
        super("SuperPaint");

        statusBar = new JLabel("Mouse outside panel");
        paintPanel = new PaintPanel(statusBar);

        initWidgetPanel();

        add(statusBar, BorderLayout.SOUTH);
        add(paintPanel, BorderLayout.CENTER);
        add(widgetPanel, BorderLayout.NORTH);
    }

    /**
     * Instantiates the widget panel in the SuperPaint program
     */
    private void initWidgetPanel() {
        widgetPanel.setLayout(new GridLayout(1, 6, 10, 10));

        JComponent[] widgets = {undoButton, redoButton, clearButton, colorDropDown, shapeDropDown, filledCheckBox};

        for (JComponent widget : widgets) {
            widgetPanel.add(widget); // Add all widgets
        }

        widgetPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Pad the panel with an empty border

        configureButtons();
        configureChoosingWidgets();
    }

    /**
     * Configures all drop down menus (JComboBox) and check boxes (JCheckBox) and
     * attaches their respective listeners
     */
    private void configureChoosingWidgets() {
        ChoiceListener choiceListener = new ChoiceListener();
        //Configure check box
        filledCheckBox.setEnabled(false);
        filledCheckBox.addItemListener(choiceListener);
        // Configure drop downs
        colorDropDown.setMaximumRowCount(3); // Makes code more readable ?
        colorDropDown.addItemListener(choiceListener);
        shapeDropDown.setMaximumRowCount(3);
        shapeDropDown.addItemListener(choiceListener);
    }

    /**
     * Configures all buttons in the widget panel and attaches their respective listeners
     */
    private void configureButtons() {
        ButtonListener buttonListener = new ButtonListener();
        undoButton.addActionListener(buttonListener);
        redoButton.addActionListener(buttonListener);
        clearButton.addActionListener(buttonListener);
    }

    /**
     * ButtonListener class.
     * Listens to and handles all Button (JButton) events.
     *
     * @see {@link ActionListener}
     */
    public class ButtonListener implements ActionListener {
        /**
         * Handles undo/redo and clear button actions by updating paintPanel
         * @param e ActionEvent object containing all information concerning the action
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == undoButton) {
                paintPanel.undoAction(); // Undo if undo was pressed
            }

            else if (e.getSource() == redoButton) {
                paintPanel.redoAction(); // Redo if redo was pressed
            }

            else if (e.getSource() == clearButton) {
                paintPanel.clearAll();  // Clear screen if clear was pressed
            }
        }
    }

    /**
     * CheckBoxListener implements ItemListener.
     * Listens and handles all choice-based events (DropDowns/CheckBox).
     *
     * @see {@link ItemListener}
     */
    public class ChoiceListener implements ItemListener {

        /**
         * If one of the choice-based widget's state changed, handle their respective events.
         * @param e ItemEvent object that contains all information concerning the event that occured
         */
        @Override
        public void itemStateChanged(ItemEvent e) {
            // Handle check box events
            if (e.getSource() == filledCheckBox) { // Handle CheckBox event
                if (filledCheckBox.isSelected()) {
                    paintPanel.setFilled(true);
                }
                else {
                    paintPanel.setFilled(false);
                }
            }
            // Handle color choosing drop down
            else if (e.getSource() == colorDropDown) {
                paintPanel.setColor(colorValues[colorDropDown.getSelectedIndex()]); // Change color
            }
            // Handle shape choosing drop down
            else {
                paintPanel.setShape(shapeDropDown.getSelectedIndex()); // change shape

                if (paintPanel.getShape() == paintPanel.LINE) {
                    filledCheckBox.setSelected(false);
                    filledCheckBox.setEnabled(false); // Don't enable check box while drawing a line
                }
                else {
                    filledCheckBox.setEnabled(true); // Enable otherwise
                }
            }
        }
    }
}
