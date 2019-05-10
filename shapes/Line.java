package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Class to create drawable line objects for a paint program
 *
 * @@author ndesai
 * @@version 10th May 2019
 * @@see shape.Shape
 */
public class Line extends Shape {
    /**
     * Parameterized constructor for a line
     * @param x1     first x coordinate
     * @param y1     first y coordinate
     * @param x2     second x coordinate
     * @param y2     second y coordinate
     * @param color  color of line/stroke
     */
    public Line(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    /**
     * Method to draw a line (called by paintComponent)
     * @param g Graphics object (from java.awt)
     * @see java.awt.Graphics
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }
}
