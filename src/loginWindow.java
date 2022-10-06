

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;

public class loginWindow extends JFrame  {

    JTextField loginText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JButton enterButton = new JButton("Enter");
    JButton cancelButton = new JButton("Cancel");
    Font log_font= new Font("Malgun Gothic",Font.BOLD,18);
    Font text_font = new Font("Malgun Gothic",Font.BOLD,11);

    int count = 0;
    loginWindow()  {
        loginText.setPreferredSize( new Dimension( 200, 28 ) );
        passwordText.setPreferredSize( new Dimension( 200, 28 ) );
        loginText.setFont(text_font);
        passwordText.setFont(text_font);
        passwordText.setEchoChar('*');

        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = (int) dimension.getWidth(), frameHeight = (int) dimension.getHeight();
        setBounds(frameWidth / 3, frameHeight / 3, frameWidth / 3, frameHeight / 4);
//Window properties
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setVisible(true);
        northPanel.setBackground(Color.DARK_GRAY);
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));

        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.DARK_GRAY);
        loginPanel.setVisible(true);
        loginPanel.setLayout(new FlowLayout());
// loginPanel properties
        JLabel loginLabel = new JLabel("Login: ");
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setFont(log_font);

        JLabel passLabel = new JLabel("Password: ");
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(log_font);
//loginLabel and passLabel

        loginPanel.add(loginLabel);
        loginPanel.add(Box.createRigidArea(new Dimension(frameWidth/39, 0)));

        loginPanel.add(loginText);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(Color.DARK_GRAY);
        passwordPanel.setVisible(true);



        passwordPanel.add(passLabel);
        passwordPanel.add(Box.createRigidArea(new Dimension(5, 0)));

        passwordPanel.add(passwordText);



        northPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        northPanel.add(loginPanel);
        northPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        northPanel.add(passwordPanel);
        panel.add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        southPanel.setVisible(true);
        southPanel.setBackground(Color.DARK_GRAY);

        enterButton.setFocusable(false);
        enterButton.setPreferredSize(new Dimension( 75, 30 ) );
        enterButton.setFont(text_font);
        enterButton.addActionListener(e -> {
            if(!passwordText.getText().isEmpty())System.out.println(passwordText.getText());
            if(!loginText.getText().isEmpty())System.out.println(loginText.getText());
            passwordText.setText(null);
            loginText.setText(null);
        });
        southPanel.add(enterButton);

        cancelButton.setFocusable(false);
        cancelButton.setFont(text_font);
        cancelButton.setPreferredSize(new Dimension( 75, 30 ) );
        cancelButton.addActionListener(e -> System.exit(0));
        southPanel.add(cancelButton);

        panel.add(southPanel, BorderLayout.SOUTH);
        panel.setVisible(true);
        panel.setBackground(Color.DARK_GRAY);

        add(panel);

    }
}
