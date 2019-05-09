import java.awt.Color;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;

public class DrawFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    // Constants
    public static final int LINE = 0;
    public static final int RECT = 1;
    public static final int OVAL = 2;
    private String[] shapeTypes = {"Line", "Rect", "Oval"};
    private String[] colorNames = {"Black", "Red", "Green", "Blue", "Yellow", "Orange"};
    private Color[] colorValues = {Color.BLACK, Color.RED, Color.green, Color.BLUE, Color.YELLOW, Color.ORANGE};

    private Color currentColor = Color.BLACK;
    private Shape currentShape = null;
    private boolean filled = false;
    private int selectedShape = LINE;

    // Widgets
    private JButton undoButton = new JButton("Undo");
    private JButton redoButton = new JButton("Redo");
    private JButton clearButton = new JButton("Clear");
    private JComboBox colorDropDown = new JComboBox(colorNames);
    private JComboBox shapeDropDown = new JComboBox(shapeTypes);
    private JCheckBox filledCheckBox = new JCheckBox("Filled");
    private JLabel statusBar;
    private JPanel widgetPanel = new JPanel();
    private PaintPanel paintPanel = new PaintPanel();

    private LinkedList<Shape> shapes = new LinkedList<>();
    private DynamicStack<Shape> undoStack = new DynamicStack<>();

    public DrawFrame() {
        super("SuperPaint");

        statusBar = new JLabel("Mouse outside panel");
        
        initPaintPanel();
        initWidgetPanel();
                
        add(statusBar, BorderLayout.SOUTH);
        add(paintPanel, BorderLayout.CENTER);
        add(widgetPanel, BorderLayout.NORTH);
    }
    
    private class MouseEventListener extends MouseAdapter {
        public void mouseMoved(MouseEvent e) {
            statusBar.setText(String.format("Mouse position: (%d, %d)\n", e.getX(), e.getY()));
        }
    }
    
    private void initPaintPanel() {
        paintPanel = new PaintPanel();
        MouseEventListener mouseListener = new MouseEventListener();
        paintPanel.addMouseMotionListener(mouseListener);
    }

    private void initWidgetPanel() {
        widgetPanel.setLayout(new GridLayout(1, 6, 10, 10));

        widgetPanel.add(undoButton);
        widgetPanel.add(redoButton);
        widgetPanel.add(clearButton);
        widgetPanel.add(colorDropDown);
        widgetPanel.add(shapeDropDown);
        widgetPanel.add(filledCheckBox);

        widgetPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        configureCheckBox();
        configureDropDowns();
        configureButtons();
    }

    private void configureCheckBox() {
        filledCheckBox.setEnabled(false);
        filledCheckBox.addItemListener(new CheckBoxListener());
    }

    private void configureDropDowns() {
        DropDownListener dropDownListener = new DropDownListener();
        colorDropDown.addItemListener(dropDownListener);
        shapeDropDown.addItemListener(dropDownListener);
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
                if (!shapes.isEmpty()) {
                    undoStack.push(shapes.removeFirst());
                }
            }
            
            else if (e.getSource() == redoButton) {
                if (!undoStack.isEmpty()) {
                    shapes.addFirst(undoStack.pop());
                }
            }
            
            else if (e.getSource() == clearButton) {
                shapes.clear();
                undoStack.clear();
            }

            repaint();
        }
    }

    /**
     * CheckBoxListener implements ItemListener
     */
    public class CheckBoxListener implements ItemListener {
    
        @Override
        public void itemStateChanged(ItemEvent e) {
             if (filledCheckBox.isSelected()) {
                 filled = true;
             } else {
                 filled = false;
             }
            
        }
    }

    /**
     * DropDownListener implements ItemListener
     */
    public class DropDownListener implements ItemListener {
    
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == colorDropDown) {
                currentColor = colorValues[colorDropDown.getSelectedIndex()];
            } else {
                selectedShape = shapeDropDown.getSelectedIndex();
                if (index == 0) {
                    filledCheckBox.setEnabled(false);
                } else {
                    filledCheckBox.setEnabled(true);
                }
            }
        }
    }
}
