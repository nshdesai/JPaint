import javax.swing.JFrame;

/**
 * Driver code for SuperPaint program
 *
 * @author ndesai
 * @version 10th May 2019
 */
public class SuperPaint {
    public static void main(String[] args) {
        DrawFrame application = new DrawFrame();

        application.setSize(480, 320);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setVisible(true);
    }
}
