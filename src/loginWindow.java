

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class loginWindow extends JFrame  {

    JTextField loginText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JButton enterButton = new JButton("Enter");
    JButton cancelButton = new JButton("Cancel");
    Font log_font= new Font("Malgun Gothic",Font.BOLD,18);
    Font text_font = new Font("Malgun Gothic",Font.BOLD,12);


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
        northPanel.setLayout(new GridLayout(3,4,20,20));


        JLabel loginLabel = new JLabel("Login: ");
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setFont(log_font);

        JLabel passLabel = new JLabel("Password: ");
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(log_font);
//loginLabel and passLabel
        makeSpace(northPanel,5);


        northPanel.add(loginLabel);


        northPanel.add(loginText);

        makeSpace(northPanel,2);




        northPanel.add(passLabel);
        // passwordPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        northPanel.add(passwordText);


        panel.add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        southPanel.setVisible(true);
        southPanel.setBackground(Color.DARK_GRAY);

        enterButton.setBackground(Color.DARK_GRAY);
        enterButton.setForeground(Color.WHITE);

        enterButton.setFocusable(false);
        enterButton.setPreferredSize(new Dimension( 75, 30 ) );
        enterButton.setFont(text_font);

        enterButton.addActionListener(e -> {
            if(!passwordText.getText().isEmpty())System.out.println(passwordText.getText());
            if(!loginText.getText().isEmpty())System.out.println(loginText.getText());
            passwordText.setText(null);
            loginText.setText(null);
            if(checkPassword(loginText.getText(),passwordText.getText())){
                setVisible(false);
                new AppFrame(isClient(loginText.getText(),passwordText.getText()));
            }
        });
        southPanel.add(enterButton);

        cancelButton.setBackground(Color.DARK_GRAY);
        cancelButton.setForeground(Color.WHITE);
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
    private void makeSpace(JPanel northPanel,int n) {
        for (int i = 0; i < n; i++) {
            northPanel.add(Box.createRigidArea(new Dimension(30, 30)));
        }
    }
    private boolean checkPassword(String login,String password){
        return true;
    }
    private boolean isClient(String login,String password){
        return true;
    }
}
