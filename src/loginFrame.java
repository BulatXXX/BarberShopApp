import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class loginFrame extends JFrame {
    private JPanel panel1;
    private JPanel northPanel;
    private JLabel bbshopLabel;
    private JButton exitButton;
    private JPanel southPanel;
    private JPanel centerPanel;
    private JLabel labelLabel;
    private JLabel userNameLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JLabel passwordLabel;
    private JButton createNewAccountButton;
    private JButton logInButton;
    private BufferedImage exitButtonImg;
    private

    Font labelFont = new Font("Montserrat Medium", Font.BOLD, 18);
    Font secondFont = new Font("Montserrat Medium", Font.BOLD, 14);

    loginFrame() {
        bbshopLabel.setForeground(Color.decode("0x616465"));
        bbshopLabel.setFont(labelFont);


        centerPanel.setBackground(Color.darkGray);
        southPanel.setBackground(Color.darkGray);

        labelLabel.setFont(labelFont);
        labelLabel.setForeground(Color.decode("0x949494"));

        setCenterPanel();

        loginButtonSettings();
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AppFrame(isClient());
            }
        });

        createNewAccountButtonSettings();
    //JFrame settings
        setContentPane(panel1);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = (int) dimension.getWidth(), frameHeight = (int) dimension.getHeight();
        setBounds(frameWidth / 3, frameHeight / 3, frameWidth / 3, frameHeight / 3);

        exitButtonSettings();
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        createNewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new registerWindow();
            }
        });
    }

    private boolean isClient() {
        if(usernameTextField.getText().equals("Client")||usernameTextField.getText().equals("client"))return true;
        if(usernameTextField.getText().equals("Service")||usernameTextField.getText().equals("service"))return false;
        return false;
    }

    private void loginButtonSettings() {
        logInButton.setBackground(Color.decode("0x404040"));
        logInButton.setForeground(Color.GRAY);
        logInButton.setBorder(null);
        logInButton.setFont(secondFont);
        logInButton.setFocusable(false);
        logInButton.addMouseListener(new MouseListener() {
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
                logInButton.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logInButton.setForeground(Color.GRAY);
            }
        });
    }

    private void setCenterPanel() {
        userNameLabel.setFont(secondFont);
        userNameLabel.setForeground(Color.decode("0x949494"));

        passwordLabel.setFont(secondFont);
        passwordLabel.setForeground(Color.decode("0x949494"));

        usernameTextField.setBackground(Color.DARK_GRAY);
        usernameTextField.setFont(secondFont);
        usernameTextField.setForeground(Color.white);
        usernameTextField.setCaretColor(Color.white);
        usernameTextField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (usernameTextField.getText().equals("Username")) usernameTextField.setCaretPosition(0);
                if (usernameTextField.getText().equals("Username")) usernameTextField.setText("");
                if (passwordTextField.getText().equals("")) passwordTextField.setText("Password");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        passwordTextField.setBackground(Color.DARK_GRAY);
        passwordTextField.setFont(secondFont);
        passwordTextField.setForeground(Color.white);
        passwordTextField.setCaretColor(Color.white);
        passwordTextField.setEchoChar('•');
        passwordTextField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (passwordTextField.getText().equals("Username")) passwordTextField.setCaretPosition(0);
                if (passwordTextField.getText().equals("Password")) passwordTextField.setText("");
                if (usernameTextField.getText().equals("")) usernameTextField.setText("Username");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        usernameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (usernameTextField.getText().equals("Username")) usernameTextField.setText("");
                if(usernameTextField.getText().length()>20){
                    String temp = usernameTextField.getText().substring(0,usernameTextField.getText().length()-2);
                    usernameTextField.setText(temp);
                }
                super.keyTyped(e);
            }
        });
        passwordTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (passwordTextField.getText().equals("Password")) passwordTextField.setText("");
                if(passwordTextField.getText().length()>20){
                    String temp = passwordTextField.getText().substring(0,passwordTextField.getText().length()-2);
                    passwordTextField.setText(temp);
                }
                super.keyTyped(e);
            }
        });

    }

    private void createNewAccountButtonSettings() {
        createNewAccountButton.setFocusable(false);
        createNewAccountButton.setBackground(Color.darkGray);
        createNewAccountButton.setFont(secondFont);
        createNewAccountButton.setForeground(Color.GRAY);
        createNewAccountButton.setBorder(null);
        createNewAccountButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // new registerWindow();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                createNewAccountButton.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                createNewAccountButton.setForeground(Color.GRAY);
            }
        });
    }

    private void exitButtonSettings() {
        exitButton.addActionListener(e -> System.exit(1));
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
    public static boolean checkPassword(){
        return true;
    }
}
