import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    AppFrame(boolean is_client) {
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


        exitButton.addActionListener(e -> System.exit(2));
    }
}
