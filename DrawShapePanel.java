import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class DrawShapePanel extends JPanel {
    private Shape[] shapes = new Shape[10];

    public DrawShapePanel() {
        Random random = new Random();
        setBackground(Color.WHITE);

        for (int count = 0; count < shapes.length; count++){
            int x1 = random.nextInt(300);
            int y1 = random.nextInt(300);
            int x2 = random.nextInt(300);
            int y2 = random.nextInt(300);

            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

            int shape = random.nextInt(3);
            boolean filled = random.nextBoolean();

            switch (shape) {
                case 0:
                    shapes[count] = new Line(x1, y1, x2, y2, color);
                    break;
                case 1:
                    shapes[count] = new Oval(x1, y1, x2, y2, color, filled);
                    break;
                case 2:
                    shapes[count] = new Rectangle(x1, y1, x2, y2, color, filled);
                    break;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Call the draw() method for each Line object in the array
        for (Shape shape : shapes)
            shape.draw(g);
    }
}
