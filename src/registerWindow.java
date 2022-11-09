import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class registerWindow extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JCheckBox serviceCheckBox;
    private JLabel loginlabel;
    private JButton registerButton;
    private JButton exitButton;
    private BufferedImage exitButtonImg;
    Font labelFont = new Font("Montserrat Medium", Font.BOLD, 18);
    Font secondFont = new Font("Montserrat Medium", Font.BOLD, 14);

    registerWindow(){
        setContentPane(panel1);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = (int) dimension.getWidth(), frameHeight = (int) dimension.getHeight();
        setBounds(frameWidth / 3, frameHeight / 3, frameWidth / 3, frameHeight / 3);
        panel1.setBackground(Color.darkGray);
        registerButton.setBackground(Color.darkGray);
        registerButton.setForeground(Color.GRAY);
        registerButton.setFont(secondFont);
        registerButton.setBorder(null);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setResizable(false);
        setFocusable(false);
        //exitButtonSettings();

    }
    private void exitButtonSettings() {
        exitButton.addActionListener(e -> System.exit(1));
        Dimension size = exitButton.getSize();
        Insets insets = exitButton.getInsets();

        try {
            exitButtonImg = ImageIO.read(new File("exitButtonIconR.png"));
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
        Image scaled = exitButtonImg.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
        exitButton.setIcon(new ImageIcon(scaled));
        exitButton.addActionListener(e -> System.exit(1));
        exitButton.setFocusable(false);
        exitButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                try {
                    exitButtonImg = ImageIO.read(new File("exitButtonIcon_st2.png"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Image scaled = exitButtonImg.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
                exitButton.setIcon(new ImageIcon(scaled));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                try {
                    exitButtonImg = ImageIO.read(new File("exitButtonIcon.png"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Image scaled = exitButtonImg.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
                exitButton.setIcon(new ImageIcon(scaled));
            }
        });
    }
}
