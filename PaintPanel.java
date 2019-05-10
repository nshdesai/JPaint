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

/**
 * This class defines the panel used to draw shapes in the SuperPaint program.
 * It utilizes both the datastructures and shapes packages to draw basic shapes.
 *
 * @author ndesai
 * @version 10th May 2019
 * @see shapes, datastructures
 */
public class PaintPanel extends JPanel {
    // Integer constants for different shape types
    public static final int LINE = 0;
    public static final int RECT = 1;
    public static final int OVAL = 2;

    // Instance variables to track the state of the application
    private Color currentColor = Color.BLACK;
    private Shape currentShape = null;
    private boolean filled = false;
    private int selectedShape = LINE;

    private JLabel statusBar; // Shows position of mouse
    // Data structures to organize all our shapes
    private LinkedList<Shape> shapes = new LinkedList<>();
    private DynamicStack<Shape> undoStack = new DynamicStack<>();

    /**
     * Constructor for PaintPanel. Sets up mouseListener and status bar.
     * @param statusLabel JLabel taken from parent frame to show position of mouse
     */
    public PaintPanel(JLabel statusLabel) {
        statusBar = statusLabel;
        setBackground(Color.WHITE);

        MouseEventListener mouseListener = new MouseEventListener();
        addMouseMotionListener(mouseListener);
        addMouseListener(mouseListener);
    }

    /**
     * Method internally handled by swing to redraw window. We override it to
     * draw our shapes on the panel.
     * @param g Graphics object
     * @see java.awt.Graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

       for (int i = 0; i < shapes.size(); i++) {
           Shape currentShape = shapes.removeLast(); // Draw oldest shape first
           currentShape.draw(g);
           shapes.addFirst(currentShape);
       }
    }

    /**
     * Helper method to build a shape object given its coordinates and type
     * @param x1 first x coord of shape
     * @param y1 first y coord of shape
     * @param x2 second x coord of shape
     * @param y2 second y coord of shape
     */
    private void buildShape(int x1, int y1, int x2, int y2) {
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

    /**
     * Mutator: set if the shape is to be filled or not while drawn
     * @param filled boolean should the shape be filled?
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Mutator: set the new color of a shape (chosen from drop down in UI)
     * @param color Color object that contains RGB value of color
     */
    public void setColor(Color color) {
        currentColor = color;
    }

    /**
     * Mutator: set the type of the current shape to be drawn (from the integer codes specified)
     * @param shape integer code of shape
     */
    public void setShape(int shape) {
        selectedShape = shape;
    }

    /**
     * Accessor: Returns the integer code for the current shape
     * @return integer code of shape
     */
    public int getShape() {
        return selectedShape;
    }

    /**
     * clears the screen and forgets all shapes drawn
     */
    public void clearAll() {
        undoStack.clear();
        shapes.clear();
        repaint();
    }

    /**
     * Method to undo the previous action done by the user
     */
    public void undoAction() {
        if (!shapes.isEmpty()) {
            undoStack.push(shapes.removeFirst());
        }
        repaint();
    }

    /**
     * Method to redo the previously undone action
     */
    public void redoAction() {
        if (!undoStack.isEmpty()) {
            shapes.addFirst(undoStack.pop());
        }
        repaint();
    }

    /**
     * MouseEventListener class.
     * Handles all mouse events done by the user
     */
    private class MouseEventListener extends MouseAdapter {

        /**
         * Handles all events that involve the pressing of a mouse button.
         * Only does relevant actions if the left button is pressed
         * @param event MouseEvent object: Contains all information regarding mouse event
         */
        @Override
        public void mousePressed(MouseEvent event) {
            if (event.getButton() == event.BUTTON1) {
                buildShape(event.getX(), event.getY(), event.getX(), event.getY());
                shapes.addFirst(currentShape);
                repaint();
            }
        }

        /**
         * Updates the coordinates of the painted shape as the mouse is dragged
         * @param event MouseEvent object: Contains all information regarding mouse event
         */
        @Override
        public void mouseDragged(MouseEvent event) {
            currentShape.setX2(event.getX());
            currentShape.setY2(event.getY());

            // statusBar.setText(String.format("Mouse position: (%d, %d)\n", event.getX(), event.getY()));
            repaint();
        }

        /**
         * Finalizes the shape coordinates of the shape when the mouse is released
         * @param event MouseEvent object: Contains all information regarding mouse event
         */
        @Override
        public void mouseReleased(MouseEvent event) {
            currentShape.setX2(event.getX());
            currentShape.setY2(event.getY());

            undoStack.clear(); // You cannot redo after a new action has been done

            // if (event.isAltDown() || event.isMetaDown()) {
            //     shapes.removeFirst();
            // }
            repaint();
        }

        /**
         * Updates the status bar text whenever the mouse is moved
         * @param e MouseEvent object: Contains all information regarding mouse event
         */
        @Override
        public void mouseMoved(MouseEvent e) {
            statusBar.setText(String.format("Mouse position: (%d, %d)\n", e.getX(), e.getY()));
        }
    }
}
