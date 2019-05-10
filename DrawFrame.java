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

    public DrawFrame() {
        super("SuperPaint");

        statusBar = new JLabel("Mouse outside panel");
        paintPanel = new PaintPanel(statusBar);

        initWidgetPanel();

        add(statusBar, BorderLayout.SOUTH);
        add(paintPanel, BorderLayout.CENTER);
        add(widgetPanel, BorderLayout.NORTH);
    }

    private void initWidgetPanel() {
        widgetPanel.setLayout(new GridLayout(1, 6, 10, 10));

        JComponent[] widgets = {undoButton, redoButton, clearButton, colorDropDown, shapeDropDown, filledCheckBox};

        for (JComponent widget : widgets) {
            widgetPanel.add(widget);
        }

        widgetPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        configureButtons();
        configureChoosingWidgets();
    }

    private void configureChoosingWidgets() {
        ChoiceListener choiceListener = new ChoiceListener();
        //Configure check box
        filledCheckBox.setEnabled(false);
        filledCheckBox.addItemListener(choiceListener);
        // Configure drop downs
        colorDropDown.setMaximumRowCount(colorValues.length); // Makes code more readable
        colorDropDown.addItemListener(choiceListener);
        shapeDropDown.setMaximumRowCount(shapeTypes.length);
        shapeDropDown.addItemListener(choiceListener);
    }

    private void configureButtons() {
        ButtonListener buttonListener = new ButtonListener();
        undoButton.addActionListener(buttonListener);
        redoButton.addActionListener(buttonListener);
        clearButton.addActionListener(buttonListener);
    }

    /**
     * ButtonListener
     */
    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == undoButton) {
                paintPanel.undoAction();
            }

            else if (e.getSource() == redoButton) {
                paintPanel.redoAction();
            }

            else if (e.getSource() == clearButton) {
                paintPanel.clearAll();
            }
        }
    }

    /**
     * CheckBoxListener implements ItemListener
     */
    public class ChoiceListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            // Handle check box events
            if (e.getSource() == filledCheckBox) {
                if (filledCheckBox.isSelected()) {
                    paintPanel.setFilled(true);
                }
                else {
                    paintPanel.setFilled(false);
                }
            }
            // Handle color choosing drop down
            else if (e.getSource() == colorDropDown) {
                paintPanel.setColor(colorValues[colorDropDown.getSelectedIndex()]);
            }
            // Handle shape choosing drop down
            else {
                paintPanel.setShape(shapeDropDown.getSelectedIndex());

                if (paintPanel.getShape() == paintPanel.LINE) {
                    filledCheckBox.setEnabled(false); // Don't enable check box while drawing a line
                }
                else {
                    filledCheckBox.setEnabled(true);
                }
            }
        }
    }
}
