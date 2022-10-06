

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginWindow extends JFrame {

    JTextField loginText = new JTextField();
    JTextField passwordText = new JTextField();
    JButton enterButton = new JButton("Enter");
    JButton cancelButton = new JButton("Cancel");
    loginWindow() {


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

        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.DARK_GRAY);
        loginPanel.setVisible(true);
        loginPanel.setLayout(new FlowLayout());
// loginPanel properties
        JLabel loginLabel = new JLabel("Login: ");
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setFont(new Font("Calibri ",Font.BOLD,18 ));

        loginPanel.add(loginLabel);
        loginPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        loginPanel.add(loginText);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(Color.DARK_GRAY);
        passwordPanel.setVisible(true);

        passwordPanel.add(new Label("pass"));
        passwordPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        passwordPanel.add(passwordText);

        northPanel.setVisible(true);
        northPanel.setBackground(Color.DARK_GRAY);

        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));

        northPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        northPanel.add(loginPanel);
        northPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        northPanel.add(passwordPanel);
        panel.add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        southPanel.setVisible(true);
        southPanel.setBackground(Color.DARK_GRAY);
        southPanel.add(enterButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        southPanel.add(cancelButton);

        panel.add(southPanel, BorderLayout.SOUTH);
        panel.setVisible(true);
        panel.setBackground(Color.DARK_GRAY);

        add(panel);

    }
}
