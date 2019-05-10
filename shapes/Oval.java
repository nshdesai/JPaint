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

     public Oval(){
         this(0, 0, 0, 0, Color.WHITE, false);
     }

     public Oval(int x1, int y1, int x2, int y2, Color color, boolean filled){
         super(x1, y1, x2, y2, color, filled);
     }

     @Override
     public void draw(Graphics g) {
         g.setColor(getColor());
         g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
         if (getFilled())
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
     }
 }
