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
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;

public class DrawFrame extends JFrame {
    // Constants
    public static final int LINE = 0;
    public static final int RECT = 1;
    public static final int OVAL = 2;
    private int[] shapesTypes = {LINE, RECT, OVAL};
    private String[] colorNames = {"Black", "Red", "Green", "Blue", "Yellow", "Orange"};
    private Color[] colorValues = {Color.BLACK, Color.RED, Color.green, Color.BLUE, Color.YELLOW, Color.ORANGE};

    private Color currentColor = Color.BLACK;
    private Shape currentShape = null;

    // Widgets
    private JButton undoButton = new JButton("Undo");
    private JButton redoButton = new JButton("Redo");
    private JButton clearButton = new JButton("Clear");
    private JComboBox colorDropDown = new JComboBox(colorNames);
    private JLabel statusBar;
    private JPanel widgetPanel;
    private PaintPanel paintPanel = new PaintPanel();

    public DrawFrame() {
        super("SuperPaint");

        statusBar = new JLabel("Mouse outside panel");
        add(statusBar, BorderLayout.SOUTH);

        drawPanel = new PaintPanel();
        MouseEventListener mouseListener = new MouseEventListener();
        drawPanel.addMouseMotionListener(mouseListener);

        add(drawPanel, BorderLayout.CENTER);
    }

    private class MouseEventListener extends MouseAdapter {
        public void mouseMoved(MouseEvent e) {
            statusBar.setText(String.format("Mouse position: (%d, %d)\n", e.getX(), e.getY()));
        }
    }
}
