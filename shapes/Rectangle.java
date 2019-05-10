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

    public Rectangle(){
        this(0, 0, 0, 0, Color.WHITE, false);
    }

    public Rectangle(int x1, int x2, int y1, int y2, Color color, boolean filled){
        super(x1, y1, x2, y2, color, filled);
        }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        if (getFilled())
           g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
    }
}
