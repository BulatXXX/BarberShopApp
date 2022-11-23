import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AppFrame extends JFrame {
    private JPanel panel1;
    private JPanel clientPanel;
    private JPanel servicePanel;
    private JButton newsButton;
    private JButton pricesButton;
    private JButton bookButton;
    private JButton newsButton1;
    private JButton scheduleButton;
    private JPanel clientTabsPanel;
    private JPanel newsPanel;
    private JPanel pricesPanel;
    private JPanel bookPanel;
    private JPanel buttonPanel;
    private JButton exitButton;
    private JButton ratingsButton;
    private JPanel serviceTabsPanel;
    private JPanel newsPanelService;
    private JPanel schedulePanel;
    private JPanel ratingsPanel;
    private JPanel buttonPanel2;
    Font labelFont = new Font("Montserrat Medium", Font.BOLD, 18);
    Font secondFont = new Font("Montserrat Medium", Font.BOLD, 14);
    AppFrame(boolean is_client) {
        exitButton.addActionListener(e->System.exit(2));
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = (int) dimension.getWidth(), frameHeight = (int) dimension.getHeight();
        setBounds(0, 0, frameWidth, frameHeight);
        CardLayout mode = (CardLayout) (panel1.getLayout());
        if (is_client) mode.show(panel1, "ClientCard");
        else mode.show(panel1, "ServiceCard");
        CardLayout tabs;

        if (is_client) {
            tabs = (CardLayout) (clientTabsPanel.getLayout());
            newsButton.addActionListener(e -> tabs.show(clientTabsPanel, "news"));
            pricesButton.addActionListener(e -> tabs.show(clientTabsPanel, "prices"));
            bookButton.addActionListener(e -> tabs.show(clientTabsPanel, "book"));
        }else {
            tabs = (CardLayout) (serviceTabsPanel.getLayout());
            newsButton1.addActionListener(e -> tabs.show(serviceTabsPanel, "news"));
            scheduleButton.addActionListener(e -> tabs.show(serviceTabsPanel, "schedule"));
            ratingsButton.addActionListener(e -> tabs.show(serviceTabsPanel, "ratings"));
        }


       
        northPanelButtonSettings(newsButton);
        northPanelButtonSettings(pricesButton);
        northPanelButtonSettings(bookButton);
        northPanelButtonSettings(newsButton1);
        northPanelButtonSettings(scheduleButton);
        northPanelButtonSettings(ratingsButton);

        buttonPanel.setBackground(Color.darkGray);
        buttonPanel2.setBackground(Color.darkGray);

    }
    private void northPanelButtonSettings(JButton newsButton) {
        newsButton.setFocusable(false);
        newsButton.setBackground(Color.darkGray);
        newsButton.setFont(secondFont);
        newsButton.setForeground(Color.GRAY);
        newsButton.setBorder(null);
        newsButton.addMouseListener(new MouseListener() {
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
                newsButton.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                newsButton.setForeground(Color.GRAY);
            }
        });

    }

}
