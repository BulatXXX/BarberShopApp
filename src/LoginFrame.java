import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.Key;

public class LoginFrame extends JFrame {
    private JPanel panel1;
    private JPanel northPanel;
    private JLabel bbshopLabel;
    private JButton exitButton;
    private JPanel southPanel;
    private JPanel centerPanel;
    private JLabel labelLabel;
    private JLabel userNameLabel;
    private JTextField loginField;
    private JPasswordField passwordTextField;
    private JLabel passwordLabel;
    private JButton createNewAccountButton;
    private JButton logInButton;
    private JLabel msgLabel;
    private BufferedImage exitButtonImg;
    private

    Font labelFont = new Font("Montserrat Medium", Font.BOLD, 18);
    Font secondFont = new Font("Montserrat Medium", Font.BOLD, 14);

    LoginFrame() {
        this.setUndecorated(true);
        bbshopLabel.setForeground(Color.decode("0x616465"));
        bbshopLabel.setFont(labelFont);
        msgLabel.setFont(secondFont);
        msgLabel.setForeground(Color.red);

        centerPanel.setBackground(Color.darkGray);
        southPanel.setBackground(Color.darkGray);

        labelLabel.setFont(labelFont);
        labelLabel.setForeground(Color.decode("0x949494"));

        setCenterPanel();

        loginButtonSettings();

        logInButton.addActionListener(e -> {

            String success = checkPassword();
            if (success.equals("Not")) {
                msgLabel.setText("Wrong login or password");
            } else {
                setVisible(false);
                new AppFrame(success);
            }
        });

        createNewAccountButtonSettings();
        //JFrame settings
        setContentPane(panel1);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = (int) dimension.getWidth(), frameHeight = (int) dimension.getHeight();
        setBounds(frameWidth / 3, frameHeight / 3, frameWidth / 3, frameHeight / 3);

        exitButtonSettings();

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        createNewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RegisterFrame();
            }
        });
    }

    private boolean isClient(String client) {
        if (client.equals("client")) return true;
        if (client.equals("service")) return false;
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

        loginField.setBackground(Color.DARK_GRAY);
        loginField.setFont(secondFont);
        loginField.setForeground(Color.white);
        loginField.setCaretColor(Color.white);
        loginField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (loginField.getText().equals("Username")) loginField.setCaretPosition(0);
                if (loginField.getText().equals("Username")) loginField.setText("");
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
                if (loginField.getText().equals("")) loginField.setText("Username");
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
        loginField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (loginField.getText().equals("Username")) loginField.setText("");
                if (loginField.getText().length() > 20) {
                    String temp = loginField.getText().substring(0, loginField.getText().length() - 2);
                    loginField.setText(temp);
                }
                super.keyTyped(e);
            }
        });
        passwordTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (passwordTextField.getText().equals("Password")) passwordTextField.setText("");
                if (passwordTextField.getText().length() > 20) {
                    String temp = passwordTextField.getText().substring(0, passwordTextField.getText().length() - 2);
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

    public String checkPassword() {
        try {

            String[] list;
            File file = new File("people.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                list = line.split(" ");
                if (loginField.getText().equals(list[0]) && passwordTextField.getText().equals(list[1])) {
                    return list[0] + " " + list[2];
                }
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Not";

    }
}
