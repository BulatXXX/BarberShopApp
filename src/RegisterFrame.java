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

public class RegisterFrame extends  JFrame {
    private JPanel panel1;
    private JButton exitButtonReg;
    private JLabel BarbershopLabel;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JTextField loginRegField;
    private JPasswordField passwordField1;
    private JLabel RegisterLabel;
    private JCheckBox serviceCheckBox;
    private JButton registerButton;
    private JLabel loginlabel;
    private JLabel passwordLabel;
    private JButton backButton;
    BufferedImage exitButtonImg = null;
    Font labelFont = new Font("Montserrat Medium", Font.BOLD, 18);
    Font secondFont = new Font("Montserrat Medium", Font.BOLD, 14);
    RegisterFrame(){
        this.setUndecorated(true);
        setContentPane(panel1);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        panel1.setBackground(Color.darkGray);
        centerPanel.setBackground(Color.darkGray);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = (int) dimension.getWidth(), frameHeight = (int) dimension.getHeight();
        setBounds(frameWidth / 3, frameHeight / 3, frameWidth / 3, frameHeight / 3);
        panel1.setBackground(Color.darkGray);
        BarbershopLabel.setFont(labelFont);
        BarbershopLabel.setForeground(Color.GRAY);
        RegisterLabel.setFont(labelFont);
        RegisterLabel.setForeground(Color.GRAY);
        backButton.setFont(secondFont);
        backButton.setBackground(Color.darkGray);
        backButton.setFocusable(false);
        backButton.setBorder(null);
        backButton.setForeground(Color.GRAY);
        registerButton.setBackground(Color.darkGray);
        registerButton.setForeground(Color.GRAY);
        registerButton.setFont(secondFont);
        registerButton.setBorder(null);
        registerButton.setFocusable(false);
        loginRegField.setCaretColor(Color.white);
        passwordField1.setCaretColor(Color.white);

        backButton.addActionListener(e -> {
            setVisible(false);
            new LoginFrame();
        });
        registerButton.addMouseListener(new MouseListener() {
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
                registerButton.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registerButton.setForeground(Color.GRAY);
            }
        });

        registerButton.addActionListener(e -> {

        });
        backButton.addMouseListener(new MouseListener() {
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
                    backButton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setForeground(Color.GRAY);
            }
        });
        loginRegField.setFont(secondFont);
        loginRegField.setBackground(Color.darkGray);
        loginRegField.setForeground(Color.white);
        loginlabel.setFont(secondFont);
        loginlabel.setForeground(Color.GRAY);
        passwordField1.setFont(secondFont);
        passwordField1.setBackground(Color.darkGray);
        passwordField1.setEchoChar('•');
        passwordField1.setForeground(Color.white);
        passwordLabel.setFont(secondFont);
        passwordLabel.setForeground(Color.GRAY);
        serviceCheckBox.setFont(secondFont);
        serviceCheckBox.setBackground(Color.darkGray);
        serviceCheckBox.setForeground(Color.GRAY);
        serviceCheckBox.setBorder(null);
        serviceCheckBox.setFocusable(false);
        setResizable(false);
        setFocusable(false);

        exitButtonSettings();

    }

    private void exitButtonSettings() {
        exitButtonReg.addActionListener(e -> System.exit(1));
        Dimension size = exitButtonReg.getSize();
        Insets insets = exitButtonReg.getInsets();



        try {
            exitButtonImg = ImageIO.read(new File("exitButtonIconR.png"));
        } catch (IOException e) {
            e.printStackTrace();

        }


        size.width -= insets.left + insets.right;
        size.height -= insets.top + insets.bottom;
        if (size.width > size.height) {
            size.width = -1;
        } else {
            size.height = -1;
        }

        Image scaled = exitButtonImg.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);

        ImageIcon exitIcon = new ImageIcon(scaled);
        exitButtonReg.setIcon(exitIcon);


        exitButtonReg.setFocusable(false);
        exitButtonReg.addMouseListener(new MouseListener() {
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
                Image scaled = exitButtonImg.getScaledInstance(size.width, size.height, 4);
                exitButtonReg.setIcon(new ImageIcon(scaled));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                try {
                    exitButtonImg = ImageIO.read(new File("exitButtonIcon.png"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Image scaled = exitButtonImg.getScaledInstance(size.width, size.height, 4);
                exitButtonReg.setIcon(new ImageIcon(scaled));
            }
        });
    }
}
