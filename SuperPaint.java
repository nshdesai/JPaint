import javax.swing.JFrame;

public class SuperPaint {
    public static void main(String[] args) {
        DrawFrame application = new DrawFrame();

        application.setSize(600, 400);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setVisible(true);
    }
}
