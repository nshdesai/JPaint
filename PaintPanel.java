import shapes.Rectangle;
import shapes.Oval;
import shapes.Line;
import shapes.Shape;

import datastructures.LinkedList;
import datastructures.DynamicStack;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PaintPanel extends JPanel {
    public static final int LINE = 0;
    public static final int RECT = 1;
    public static final int OVAL = 2;

    private Color currentColor = Color.BLACK;
    private Shape currentShape = null;
    private boolean filled = false;
    private int selectedShape = LINE;

    private JLabel statusBar;
    private LinkedList<Shape> shapes = new LinkedList<>();
    private DynamicStack<Shape> undoStack = new DynamicStack<>();


    public PaintPanel(JLabel statusLabel) {
        statusBar = statusLabel;
        setBackground(Color.WHITE);

        MouseEventListener mouseListener = new MouseEventListener();
        addMouseMotionListener(mouseListener);
        addMouseListener(mouseListener);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

       for (int i = 0; i < shapes.size(); i++) {
           Shape currentShape = shapes.removeLast();
           currentShape.draw(g);
           shapes.addFirst(currentShape);
       }
    }

    public void buildShape(int x1, int y1, int x2, int y2) {
        switch (selectedShape) {
            case LINE:
                currentShape = new Line(x1, y1, x2, y2, currentColor);
                break;
            case RECT:
                currentShape = new Rectangle(x1, y1, x2, y2, currentColor, filled);
                break;
            case OVAL:
                currentShape = new Rectangle(x1, y1, x2, y2, currentColor, filled);
                break;
        }
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public void setColor(Color color) {
        currentColor = color;
    }

    public void setShape(int shape) {
        selectedShape = shape;
    }

    public int getShape() {
        return selectedShape;
    }


    public void clearAll() {
        undoStack.clear();
        shapes.clear();
        repaint();
    }

    public void undoAction() {
        if (!shapes.isEmpty()) {
            undoStack.push(shapes.removeFirst());
        }
        repaint();
    }

    public void redoAction() {
        if (!undoStack.isEmpty()) {
            shapes.addFirst(undoStack.pop());
        }
        repaint();
    }

    /**
     * MouseEventListener
     */
    class MouseEventListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent event) {
                buildShape(event.getX(), event.getY(), event.getX(), event.getY());
                shapes.addFirst(currentShape);
                repaint();
        }

        @Override
        public void mouseDragged(MouseEvent event) {
            currentShape.setX2(event.getX());
            currentShape.setY2(event.getY());

            statusBar.setText(String.format("Mouse position: (%d, %d)\n", event.getX(), event.getY()));
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            currentShape.setX2(event.getX());
            currentShape.setY2(event.getY());

            undoStack.clear();

            if (event.isAltDown() || event.isMetaDown()) {
                shapes.removeFirst();
            }
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            statusBar.setText(String.format("Mouse position: (%d, %d)\n", e.getX(), e.getY()));
        }
    }
}
