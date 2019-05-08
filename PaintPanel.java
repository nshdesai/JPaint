import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

public class PaintPanel extends JPanel {
    public PaintPanel() {
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
