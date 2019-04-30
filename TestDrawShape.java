import javax.swing.JFrame;

public class TestDrawShape {
    public static void main(String[] args) {
        JFrame appWindow = new JFrame("Draw Shapes");

        DrawShapePanel shapePanel = new DrawShapePanel();
        appWindow.add(shapePanel);

        appWindow.setSize(300, 300);
        appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appWindow.setVisible(true);
    }
}
