import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppWindow extends JFrame {
    private JPanel panel1;
    private JButton redButton;
    private JButton blueButton;
    private JButton greenButton;
    private JPanel red;
    private JPanel blue;
    private JPanel green;
    private JPanel colors;

    AppWindow(){
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = (int) dimension.getWidth(), frameHeight = (int) dimension.getHeight();
        setBounds(0,0,frameWidth,frameHeight);
        CardLayout cardLayout = (CardLayout) (colors.getLayout());
        redButton.addActionListener(e -> cardLayout.show(colors,"Card1"));
        blueButton.addActionListener(e -> cardLayout.show(colors,"Card2"));
        greenButton.addActionListener(e -> cardLayout.show(colors,"Card3"));
    }
}
