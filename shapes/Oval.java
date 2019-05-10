package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Nishkrit Desai
 * @version 28th November 2018
 *
 * Oval class for a paint program
 */
 public class Oval extends FillableShape {

     /**
      * Default constructor for an oval object
      */
     public Oval(){
         this(0, 0, 0, 0, Color.WHITE, false);
     }

     /**
      * Parameterized constructor for an ellipse
      * @param x1     first x coordinate
      * @param y1     first y coordinate
      * @param x2     second x coordinate
      * @param y2     second y coordinate
      * @param color  color of oval
      * @param filled is the oval filled?
      */
     public Oval(int x1, int y1, int x2, int y2, Color color, boolean filled){
         super(x1, y1, x2, y2, color, filled);
     }

     /**
      * Method to draw an Oval (called by paintComponent)
      * @param g Graphics object (from java.awt)
      * @see java.awt.Graphics
      */
     @Override
     public void draw(Graphics g) {
        g.setColor(getColor());
        if (getFilled())
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        else
            g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
     }
 }
