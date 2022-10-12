import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame {
    private JPanel panel1;

    AppWindow(){
        setVisible(true);
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,dimension.width,dimension.height);
    }
}
