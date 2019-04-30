import java.awt.Color;

public abstract class FillableShape extends Shape {
    protected boolean filled;

    public FillableShape() {
        this(0, 0, 0, 0, Color.WHITE, false);
    }

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
        return String.format("The shape with coordinates (%d, %d, %d, %d) is %s filled", x1, y1, x2, y2, filled ? "" : "not");
    }

    /**
     * Returns the width of the Oval ( |x2 - x1| )
     * @return positive integer value (abs) of the width
     */
    public int getWidth(){
        return Math.abs(x2-x1);
    }

    /**
     * Returns the height of the Oval (|y1 - y2|)
     * @return postive integer value (abs) of the height
     */
    public int getHeight(){
        return Math.abs(y2-y1);
    }

    /**
     * Returns the Upper left x-coordinate of a given oval
     * @return int x-coord which is smaller
     */
    public int getUpperLeftX(){
        return Math.min(x1, x2);
    }

    /**
     * Returns the Upper left y-coordinate of a ovalanngle
     * @return int y-coord of the upper left corner of a oval
     */
    public int getUpperLeftY(){
        return Math.min(y1, y2);
    }
}
