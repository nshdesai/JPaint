package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Abstract class that provides a template for all shapes (Lines/Rects/Ovals)
 *
 * @@author ndesai
 * @@version 10th May 2019
 */
public abstract class Shape {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private Color color;

    /**
     * Parameterized constructor for any shape
     * @param x1     first x coordinate of shape
     * @param x2     second x coordinate of shape
     * @param y1     first y coordinate of shape
     * @param y2     second y coordinate of shape
     * @param color  color of shape
     */
    public Shape(int x1, int y1, int x2, int y2, Color color) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setColor(color);
    }

    /**
    * @param int x1
    * Method to set a new value for x1. Only non-negative integers
    */
    public void setX1(int x1){
        this.x1 = checkLessThanZero(x1);
    }

    /**
    * @param int x1
    * Method to set a new value for x2. Only non-negative integers
    */
    public void setX2(int x2){
        this.x2 = checkLessThanZero(x2);
    }

    /**
    * @param int y1
    * Method to set a new value for y1. Only non-negative integers
    */
    public void setY1(int y1){
        this.y1 = checkLessThanZero(y1);
    }

    /**
    * @param int y2
    * Method to set a new value for y2. Only non-negative integers
    */
    public void setY2(int y2){
        this.y2 = checkLessThanZero(y2);
    }

    /**
     * Sets the color of a shape
     * @param color RGB color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Helper function for sanity checking in mutators
     */
    public int checkLessThanZero(int coord){
        if (coord < 0){
            System.err.println("Attempting to set a coordinate to a value less that zero (0). Setting value to 0");
            return 0;
        }
        else {
            return coord;
        }
    }

    /**
     * Accessor method for the x1 instance variable
     * @return int x1
     */
    public int getX1(){
        return x1;
    }

    /**
     * Accesor method for the x2 instance variable
     * @return int x2
     */
    public int getX2(){
        return x2;
    }

    /**
     * Accesor method for the y1 instance variable
     * @return int y1
     */
    public int getY1(){
        return y1;
    }

    /**
     * Accesor method for the y2 instance variable
     * @return int y2
     */
    public int getY2(){
        return y2;
    }

    /**
     * Returns the RGB color of a given shape
     * @return Color of the shape
     */
    public Color getColor() {
        return color;
    }

    /**
     * Method to draw a shape (called by paintComponent)
     * @param g Graphics object (from java.awt)
     * @see java.awt.Graphics
     */
    public abstract void draw(Graphics g);
}
