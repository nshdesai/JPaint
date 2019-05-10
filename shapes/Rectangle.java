package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 *Rectangle class in Java
 *
 *@author ndesai
 *@version 18 November 2018
 */
public class Rectangle extends FillableShape {
    /**
     * Default constructor for an oval object
     */
    public Rectangle(){
        this(0, 0, 0, 0, Color.WHITE, false);
    }

    /**
     * Parameterized constructor for a rectangle
     * @param x1     first x coordinate
     * @param x2     second x coordinate
     * @param y1     first y coordinate
     * @param y2     second y coordinate
     * @param color  color of rectangle
     * @param filled is the rectangle filled?
     */
    public Rectangle(int x1, int x2, int y1, int y2, Color color, boolean filled){
        super(x1, y1, x2, y2, color, filled);
        }

    /**
     * Method to draw a Rectangle (called by paintComponent)
     * @param g Graphics object (from java.awt)
     * @see java.awt.Graphics
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        if (getFilled())
           g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
    }
}
