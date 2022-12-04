import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

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
    private JPanel bookPanel;
    private JPanel buttonPanel;
    private JButton exitButton;
    private JButton ratingsButton;
    private JPanel serviceTabsPanel;
    private JPanel newsPanelService;
    private JPanel schedulePanel;
    private JPanel ratingsPanel;
    private JPanel buttonPanel2;
    private JButton exitClient;
    private JPanel clientProfilePanel;
    private JButton clientProfileButton;
    private JLabel piclabel;
    private JLabel plabel;
    private JPanel westBook;
    private JPanel centerBook;
    private JButton bm1;
    private JButton bf1;
    private JButton bth1;
    private JButton bw1;
    private JButton btu1;
    private JButton bm2;
    private JButton btu2;
    private JButton bw2;
    private JButton bth2;
    private JButton bf2;
    private JComboBox<String> comboBox1;
    private JButton btn10;
    private JButton btn14;
    private JButton btn12;
    private JButton btn16;
    private JLabel tueLabel;
    private JLabel monLabel;
    private JLabel wedLabel;
    private JButton bookBtn;
    private JLabel friLabel;
    private JLabel thuLabel;
    private JLabel timeLabel;
    private JLabel bookingLabel;
    private JLabel chosenDateLbl;
    private JLabel chosenTimeLbl;
    private JLabel yourChoiseLable;
    private JLabel datelbl;
    private JLabel timelbl;

    private int chosenDate;
    private int chosenTime;
    Font labelFont = new Font("Montserrat Medium", Font.BOLD, 18);
    Font secondFont = new Font("Montserrat Medium", Font.BOLD, 14);

    AppFrame(User user) {

        exitButton.addActionListener(e -> System.exit(2));
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        panel1.setBackground(Color.darkGray);
        clientPanel.setBackground(Color.darkGray);
        clientProfilePanel.setBackground(Color.darkGray);
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("picture.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        piclabel.setIcon(new ImageIcon(myPicture));
        //Set Return
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = (int) dimension.getWidth(), frameHeight = (int) dimension.getHeight();
        setBounds(0, 0, frameWidth, frameHeight);
        CardLayout mode = (CardLayout) (panel1.getLayout());
        if (user.isClient) mode.show(panel1, "ClientCard");
        else mode.show(panel1, "ServiceCard");
        CardLayout tabs;

        if (user.isClient) {
            tabs = (CardLayout) (clientTabsPanel.getLayout());

            bookButton.addActionListener(e -> tabs.show(clientTabsPanel, "book"));
            clientProfileButton.addActionListener(e -> tabs.show(clientTabsPanel, "clientProfile"));
        } else {
            tabs = (CardLayout) (serviceTabsPanel.getLayout());
            newsButton1.addActionListener(e -> tabs.show(serviceTabsPanel, "news"));
            scheduleButton.addActionListener(e -> tabs.show(serviceTabsPanel, "schedule"));
            ratingsButton.addActionListener(e -> tabs.show(serviceTabsPanel, "ratings"));
        }



        northPanelButtonSettings(bookButton);
        northPanelButtonSettings(newsButton1);
        northPanelButtonSettings(scheduleButton);
        northPanelButtonSettings(ratingsButton);
        northPanelButtonSettings(clientProfileButton);
        northPanelButtonSettings(exitClient);
        bookPanel.setBackground(Color.darkGray);
        centerBook.setBackground(Color.darkGray);
        comboBox1.setBackground(Color.darkGray);
        comboBox1.setFont(secondFont);
        comboBox1.setForeground(Color.BLACK);
        comboBox1.setBorder(null);
        comboBox1.setFocusable(false);


        fillComboBox(comboBox1);


        JLabel[] daysOfWeek = {monLabel,tueLabel,wedLabel,thuLabel,friLabel};
        JButton[] weeks = {bm1, btu1, bw1, bth1, bf1, bm2, btu2, bw2, bth2, bf2};
        JButton[] time = {btn10,btn12,btn14,btn16};
        LocalDate currentDate = LocalDate.now(); // Gets the current currentDate
        LocalDate monDate = getFirstMondayDate(currentDate);
        chosenDateLbl.setText(Integer.toString(monDate.getDayOfMonth()));
        chosenDateLbl.setForeground(Color.GRAY);
        chosenTimeLbl.setForeground(Color.GRAY);
        chosenTimeLbl.setText("10:00");
        yourChoiseLable.setFont(secondFont);
        yourChoiseLable.setForeground(Color.WHITE);
        chosenTimeLbl.setFont(secondFont);
        chosenDateLbl.setFont(secondFont);
        datelbl.setFont(secondFont);
        timelbl.setFont(secondFont);
        datelbl.setForeground(Color.WHITE);
        timelbl.setForeground(Color.WHITE);
        bookingLabel.setFont(labelFont);
        bookingLabel.setForeground(Color.white);
        timeLabel.setFont(labelFont);
        timeLabel.setForeground(Color.WHITE);


        int count = 0;
        currentDate=currentDate.plusDays(4);
        for (JButton b : weeks){
            int isToday = monDate.compareTo(currentDate);
            System.out.println(isToday);
            count++;
            weeksButtonSettings(b,isToday>=0);
            b.setText(Integer.toString(monDate.getDayOfMonth()));
            if(count==5) monDate = monDate.plusDays(3);
            else monDate = monDate.plusDays(1);
        }
        for (JButton b : time){
            northPanelButtonSettings(b);
        }
        for(JLabel label : daysOfWeek){
            label.setFont(secondFont);
            label.setForeground(Color.WHITE);
        }

        exitClient.addActionListener(e -> System.exit(0));
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel2.setBackground(Color.darkGray);

    }

    private void weeksButtonSettings(JButton b,boolean isToday) {
        b.setFocusable(false);
        Color color;
        if(isToday) color= Color.GRAY;
        else color = Color.BLACK;
        b.setFont(secondFont);
        b.setForeground(color);
        b.setBackground(Color.darkGray);
        b.setBorder(null);

        b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                b.setForeground(Color.WHITE);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                b.setForeground(Color.WHITE);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                b.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b.setForeground(color);
            }
        });
        b.addActionListener(e->chosenDate=Integer.parseInt(b.getText()));
    }

    private static LocalDate getFirstMondayDate(LocalDate date) {
        int currentDay = date.getDayOfMonth();
        DayOfWeek currentWeekDay = date.getDayOfWeek();
        if(currentWeekDay==DayOfWeek.SATURDAY || currentWeekDay==DayOfWeek.SUNDAY){
        while (currentWeekDay!= DayOfWeek.MONDAY){
            date = date.plusDays(1);
            currentWeekDay = date.getDayOfWeek();
        }
        }else {
            while (currentWeekDay!= DayOfWeek.MONDAY){
                date = date.minusDays(1);
                currentWeekDay = date.getDayOfWeek();
            }
        }
        return date;
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
    public void fillComboBox(JComboBox comboBox1) {
        try {

            String[] list;

            File file = new File("people.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            int count=0;
            while (line != null) {
                list = line.split(" ");
                if(line.contains("service")){
                    comboBox1.addItem(list[0]);

                }
                // считываем остальные строки в цикле
                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
