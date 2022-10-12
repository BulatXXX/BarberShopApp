import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class loginFrame extends JFrame {
    private JPanel panel1;
    private JPanel northPanel;
    private JLabel bbshopLabel;
    private JButton exitButton;
    private BufferedImage exitButtonImg;


    Font labelFont= new Font("Montserrat Medium",Font.BOLD,18);
    loginFrame() {
        bbshopLabel.setFont(labelFont);
        setContentPane(panel1);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = (int) dimension.getWidth(), frameHeight = (int) dimension.getHeight();
        setBounds(frameWidth / 3, frameHeight / 3, frameWidth / 3, frameHeight / 3);

       // exitButtonSettings();
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

  //  private void exitButtonSettings() {
  /*
        Dimension size = exitButton.getSize();
        Insets insets = exitButton.getInsets();
        try {
            exitButtonImg = ImageIO.read(new File("exitButtonIcon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ImageIcon exitIcon = new ImageIcon("exitButtonIcon.png");
        size.width -= insets.left + insets.right;
        size.height -= insets.top + insets.bottom;
        if (size.width > size.height) {
            size.width = -1;
        } else {
            size.height = -1;
        }
        Image scaled = exitButtonImg.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);*/
        //exitButton.setIcon(new ImageIcon("exitButtonIcon.png"));
       // exitButton.addActionListener(e -> System.exit(1));
       // exitButton.setFocusable(false);
   // }
}
