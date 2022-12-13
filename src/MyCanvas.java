import javax.swing.*;
import java.awt.*;

class MyCanvas extends JComponent {
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("constr.gif");
        g2d.drawImage(image, 700, 350, this);
    }
}