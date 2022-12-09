import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class AppFrame extends JFrame {
    private JPanel panel1;
    private JPanel clientPanel;

    private JPanel servicePanel;
    private JPanel newsPanelService;
    private JPanel schedulePanel;
    private JPanel ratingsPanel;


    private JButton bookButton;
    private JButton newsButton1;
    private JButton scheduleButton;
    private JPanel clientTabsPanel;
    private JPanel bookPanel;
    private JPanel buttonPanel;
    private JButton exitButton;
    private JButton ratingsButton;
    private JPanel serviceTabsPanel;

    private JPanel buttonPanel2;
    private JButton exitClient;
    private JPanel clientProfilePanel;
    private JButton clientProfileButton;

    private JPanel centerBPan;
    private JPanel sBPan;
    private JPanel nBPan;
    private JPanel eBpan;
    private JPanel wBPan;

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
    private JButton toBookButton;
    private JLabel chooseTheHairdresserLabel;
    private JPanel calendar;
    private JPanel subNorthPan;
    private JPanel timePan;
    private JButton btn10;
    private JButton btn14;
    private JButton btn12;
    private JButton btn16;
    private JLabel tueLabel;
    private JLabel monLabel;
    private JLabel wedLabel;

    private JLabel friLabel;
    private JLabel thuLabel;
    private JLabel timeLabel;
    private JLabel bookingLabel;
    private JLabel chosenDateLbl;
    private JLabel chosenTimeLbl;
    private JLabel yourChoiceLable;
    private JLabel dateLabel;
    private JLabel timelbl;
    private JLabel masterLabel;
    private JLabel dateHeader;
    private JLabel timeHeader;
    private JLabel loginName;
    private JLabel upcomingLabel;
    private JLabel hairdresserLabel;
    private JLabel bookedLabel;

    //For notes in file
    LocalDate chosenDateSup = LocalDate.now();

    String chosenMasterSup;
    // For notes in file

    private int chosenTime=10;
    private int chosenDate;
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

        bookPanelsSettings();

        headerButtonsSettings();


        comboboxInit();
        ArrayList<String> notes = getNotes();

        JLabel[] daysOfWeek = {monLabel, tueLabel, wedLabel, thuLabel, friLabel};
        JButton[] weeks = {bm1, btu1, bw1, bth1, bf1, bm2, btu2, bw2, bth2, bf2};
        JButton[] time = {btn10, btn12, btn14, btn16};
        LocalDate currentDate = LocalDate.now(); // Gets the current currentDate
        LocalDate monDate = getFirstMondayDate(currentDate);
        chosenDateLbl.setText(currentDate.toString());
        chosenDateLbl.setForeground(Color.GRAY);
        chosenTimeLbl.setForeground(Color.GRAY);
        chosenTimeLbl.setText("10:00");
        yourChoiceLable.setFont(secondFont);
        yourChoiceLable.setForeground(Color.WHITE);
        chosenTimeLbl.setFont(secondFont);
        chosenDateLbl.setFont(secondFont);
        dateLabel.setFont(secondFont);
        timelbl.setFont(secondFont);
        dateLabel.setForeground(Color.WHITE);
        timelbl.setForeground(Color.WHITE);
        bookingLabel.setFont(labelFont);
        bookingLabel.setForeground(Color.white);


        toBookButton.setFocusable(false);
        toBookButton.setBackground(Color.darkGray);
        toBookButton.setFont(secondFont);
        toBookButton.setBorderPainted(true);
        toBookButton.setForeground(Color.GRAY);
        masterLabel.setFont(secondFont);
        masterLabel.setForeground(Color.GRAY);
        masterLabel.setText(comboBox1.getItemAt(0));
        chosenMasterSup = comboBox1.getItemAt(0);
        comboBox1.addActionListener(e -> {
            chosenMasterSup = comboBox1.getItemAt(comboBox1.getSelectedIndex());
            masterLabel.setText(chosenMasterSup);
            changeTimeButtonsSettings(time, chosenDateSup, chosenMasterSup, notes);
        });
        bookedLabel.setFont(secondFont);
        dateHeader.setForeground(Color.white);
        dateHeader.setFont(secondFont);
        timeHeader.setForeground(Color.white);
        timeHeader.setFont(secondFont);
        chooseTheHairdresserLabel.setForeground(Color.white);
        chooseTheHairdresserLabel.setFont(secondFont);
        int count = 0;

        for (JButton b : weeks) {
            int isToday = monDate.compareTo(currentDate);
            count++;
            weeksButtonSettings(b, isToday >= 0);
            if (isToday >= 0) {
                b.addActionListener(e -> {
                    LocalDate temp = currentDate;
                    temp = temp.plusDays(isToday);
                    chosenDateLbl.setText(temp.toString());
                    chosenDateSup = temp;
                    changeTimeButtonsSettings(time, chosenDateSup, chosenMasterSup, notes);
                });
            }
            b.setText(Integer.toString(monDate.getDayOfMonth()));
            if (count == 5) monDate = monDate.plusDays(3);
            else monDate = monDate.plusDays(1);
        }

        changeTimeButtonsSettings(time, chosenDateSup, chosenMasterSup, notes);
        for (JLabel label : daysOfWeek) {
            label.setFont(secondFont);
            label.setForeground(Color.WHITE);
        }
        toBookButton.addActionListener(e -> {
            boolean check = checkBooking(chosenTime,chosenDateSup,chosenMasterSup,notes);
            if(check){
                createNewNote(user.login,chosenTime,chosenDateSup,chosenMasterSup);
                bookedLabel.setForeground(Color.green);
                bookedLabel.setText("Success");
                notes.add(user.login+" "+chosenMasterSup+" "+chosenDateSup.toString()+" "+Integer.toString(chosenTime));
                changeTimeButtonsSettings(time,chosenDateSup,chosenMasterSup,notes);
            }
            else {
                bookedLabel.setForeground(Color.red);
                bookedLabel.setText("Error");
            }
            }
        );
        exitClient.addActionListener(e -> System.exit(0));
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel2.setBackground(Color.darkGray);

    }

    private void createNewNote(String login, int chosenTime, LocalDate chosenDateSup, String chosenMasterSup) {
        try (FileWriter fileWriter = new FileWriter("notes.txt", true)) {
                String string ="\n"+login+" "+chosenMasterSup+" "+chosenDateSup.toString()+" "+ chosenTime;
                fileWriter.write(string);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private boolean checkBooking(int chosenTime,LocalDate chosenDateSup, String chosenMasterSup, ArrayList<String> notes){
        for (int i = 0; i < notes.size(); i++) {
            String[] list = notes.get(i).split(" ");
            if(list[1].equals(chosenMasterSup) && list[2].equals(chosenDateSup.toString()) && list[3].equals(Integer.toString(chosenTime))){
                return false;
            }
        }
        return true;
    }
    private void changeTimeButtonsSettings(JButton[] time, LocalDate chosenDateSup, String chosenMasterSup, ArrayList<String> notes) {
        boolean[] isBooked = {false, false, false, false};

        for (int i = 0; i < notes.size(); i++) {
            String[] list = notes.get(i).split(" ");
            if (list[1].equals(chosenMasterSup) && list[2].equals(chosenDateSup.toString())) {
                if (list[3].equals("10")) {
                    isBooked[0] = true;
                }
                if (list[3].equals("12")) {
                    isBooked[1] = true;
                }
                if (list[3].equals("14")) {
                    isBooked[2] = true;
                }
                if (list[3].equals("16")) {
                    isBooked[3] = true;
                }

            }
        }
        int count = 0;
        for (JButton b : time) {
            boolean isBookedVar = isBooked[count];
            timeButtonSettings(b, isBookedVar);
            if (!isBookedVar) {
                b.addActionListener(e -> {
                    chosenTimeLbl.setText(b.getText());
                    chosenTime = Integer.parseInt(chosenTimeLbl.getText().substring(0, 2));
                });
            }
            count++;
        }
    }

    private void headerButtonsSettings() {
        northPanelButtonSettings(bookButton);
        northPanelButtonSettings(newsButton1);
        northPanelButtonSettings(scheduleButton);
        northPanelButtonSettings(ratingsButton);
        northPanelButtonSettings(clientProfileButton);
        northPanelButtonSettings(exitClient);
    }

    private void bookPanelsSettings() {
        bookPanel.setBackground(Color.darkGray);
        nBPan.setBackground(Color.darkGray);
        eBpan.setBackground(Color.darkGray);
        wBPan.setBackground(Color.darkGray);
        centerBPan.setBackground(Color.darkGray);
        subNorthPan.setBackground(Color.darkGray);
        sBPan.setBackground(Color.darkGray);
        calendar.setBackground(Color.darkGray);
        timePan.setBackground(Color.darkGray);
    }

    private void timeButtonSettings(JButton b, boolean isBooked) {
        b.setFocusable(false);

        Color color;
        if (isBooked) {
            color = Color.BLACK;
        } else color = Color.GRAY;
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

    }

    private void comboboxInit() {
        comboBox1.setBackground(Color.darkGray);
        comboBox1.setFont(secondFont);
        comboBox1.setForeground(Color.BLACK);
        comboBox1.setBorder(null);
        comboBox1.setFocusable(false);


        fillComboBox(comboBox1);
    }

    private void weeksButtonSettings(JButton b, boolean isToday) {
        b.setFocusable(false);
        Color color;
        if (isToday) color = Color.GRAY;
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
        b.addActionListener(e -> chosenDate = Integer.parseInt(b.getText()));
    }

    private static LocalDate getFirstMondayDate(LocalDate date) {
        int currentDay = date.getDayOfMonth();
        DayOfWeek currentWeekDay = date.getDayOfWeek();
        if (currentWeekDay == DayOfWeek.SATURDAY || currentWeekDay == DayOfWeek.SUNDAY) {
            while (currentWeekDay != DayOfWeek.MONDAY) {
                date = date.plusDays(1);
                currentWeekDay = date.getDayOfWeek();
            }
        } else {
            while (currentWeekDay != DayOfWeek.MONDAY) {
                date = date.minusDays(1);
                currentWeekDay = date.getDayOfWeek();
            }
        }
        return date;
    }

    private void northPanelButtonSettings(JButton btn) {
        btn.setFocusable(false);
        btn.setBackground(Color.darkGray);
        btn.setFont(secondFont);
        btn.setForeground(Color.GRAY);
        btn.setBorder(null);
        btn.addMouseListener(new MouseListener() {
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
                btn.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setForeground(Color.GRAY);
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
            int count = 0;
            while (line != null) {
                list = line.split(" ");
                if (line.contains("service")) {
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

    ArrayList<String> getNotes() {
        ArrayList<String> notes = new ArrayList<>();
        try {

            String[] list;
            File file = new File("notes.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {

                notes.add(line);

                // считываем остальные строки в цикле
                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return notes;
    }


}
