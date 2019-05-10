package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Abstract class that provides a template for all fillable shapes
 *
 * @@author ndesai
 * @@version 10th May 2019
 */
abstract class FillableShape extends Shape {
    private boolean filled;

    /**
     * Defualt constructor for any fillable shape object
     */
    public FillableShape() {
        this(0, 0, 0, 0, Color.WHITE, false);
    }

    /**
     * Parameterized constructor for any fillable shape
     * @param x1     first x coordinate
     * @param x2     second x coordinate
     * @param y1     first y coordinate
     * @param y2     second y coordinate
     * @param color  color of shape
     * @param filled whether the shape is to be filled
     */
    public FillableShape(int x1, int x2, int y1, int y2, Color color, boolean filled){
        super(x1, x2, y1, y2, color);
        setFilled(filled);
    }

    /**
     * Mutator to set the shape to either be filled or not-filled
     * @param newFilledState is the shape _now_ filled or not?
     */
    public void setFilled(boolean newFilledState){
        filled = newFilledState;
    }

    /**
     * Accessor method to check if the rectangle is filled.
     * @return boolean filledState
     */
    public boolean getFilled(){
        return filled;
    }

    /**
     * Returns a string containing information pertaining to the object
     * @return String
     */
    public String toString(){
        return String.format("The shape with coordinates (%d, %d, %d, %d) is %s filled", getX1(), getY1(), getX2(), getY2(), getFilled() ? "" : "not");
    }

    /**
     * Returns the width of the Oval ( |x2 - x1| )
     * @return positive integer value (abs) of the width
     */
    public int getWidth(){
        return Math.abs(getX2()-getX1());
    }

    /**
     * Returns the height of the Oval (|y1 - y2|)
     * @return postive integer value (abs) of the height
     */
    public int getHeight(){
        return Math.abs(getY2()-getY1());
    }

    /**
     * Returns the Upper left x-coordinate of a given oval
     * @return int x-coord which is smaller
     */
    public int getUpperLeftX(){
        return Math.min(getX1(), getX2());
    }

    /**
     * Returns the Upper left y-coordinate of a ovalanngle
     * @return int y-coord of the upper left corner of a oval
     */
    public int getUpperLeftY(){
        return Math.min(getY1(), getY2());
    }

    /**
     * Method to draw the shape (for swing applications)
     * @param g Graphics object (from java.awt)
     * @@see java.awt.Graphics
     */
    public abstract void draw(Graphics g);
}
