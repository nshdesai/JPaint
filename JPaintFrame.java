import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.MouseAdapter;


public class JPaintFrame extends JFrame {
    public JPaintFrame() {
        super("JPaint Program");

        JLabel statusBar = new JLabel("Mouse outside panel");
        add(statusBar, BorderLayout.SOUTH);

        PaintPanel drawPanel = new PaintPanel();
        MouseEventListener mouseListener = new MouseEventListener();
        mousePanel.addMouseMotionListener(mouseListener);

        add(mousePanel, BorderLayout.CENTER);
    }

    private class MouseEventListener extends MouseAdapter {
        public void mouseMoved(Event e) {
            statusBar.setText(String.format("Mouse position: (%d, %d)\n", e.getX(), e.getY()));
        }
    }
}
