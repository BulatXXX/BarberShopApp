import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame extends JFrame {
    JPanel infoPanel = new JPanel();
    JPanel zapis = new JPanel();
    String count = "0";

    public AppFrame(boolean client) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        designPanel(infoPanel);
        designPanel(zapis);

        Font font = new Font("Malgun Gothic", Font.BOLD, 20);
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setBackground(Color.DARK_GRAY);
        JButton b = new JButton("Exit");
        b.addActionListener(e -> System.exit(0));
        tabbedPane.setBackground(Color.darkGray);
        tabbedPane.setForeground(Color.white);
        tabbedPane.setFocusable(false);
        tabbedPane.addTab("Контактная информация", infoPanel);
        tabbedPane.addTab("Запись", zapis);


        content.add(tabbedPane, BorderLayout.CENTER);

        getContentPane().add(content);

        setPreferredSize(new Dimension(1920, 1080));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void designPanel(JPanel panel) {
        panel.setFocusable(false);
        panel.setBackground(Color.DARK_GRAY);
        setVisible(true);
        count = Integer.toString(1);
        JButton btn = new JButton(count);
        btn.setBackground(Color.DARK_GRAY);
        btn.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
        btn.setForeground(Color.WHITE);
        btn.setFocusable(false);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(3);
            }
        });
        panel.add(btn);
    }
}
