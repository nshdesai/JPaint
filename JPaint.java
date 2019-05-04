import javax.swing.JFrame;

public class TestDrawShape {
    public static void main(String[] args) {
        JPaintFrame appWindow = new JPaintFrame();

        appWindow.setSize(300, 300);
        appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appWindow.setVisible(true);
    }
}
