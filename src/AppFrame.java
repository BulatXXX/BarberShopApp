import javax.print.attribute.standard.Media;
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
import java.util.Collections;

public class AppFrame extends JFrame implements ActionListener {
    private JPanel panel1;
    private JPanel clientPanel;

    private JPanel servicePanel;
    private JPanel schedulePanel;
    private JPanel ratingsPanel;


    private JButton bookButton;

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
    private JLabel loginNameLabel;
    private JLabel upcomingLabel;
    private JLabel hairdresserLabel;
    private JLabel bookedLabel;
    private JComboBox<String> choosingDateCombobox;
    private JButton actionButton;
    private JButton cancelBookingButton;
    private JButton autoBook;
    private JLabel upcomingMasterLbl;
    private JLabel upcomingDateLbl;
    private JLabel upcomingTimeLbl;
    private JLabel upcomingDateHeader;
    private JLabel upcomingTimeHeader;
    private JLabel choosingDateLbl;
    private JLabel successProfileLabel;
    private JPanel centralSchedulePanel;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton b10;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JPanel calendarPanel;
    private JPanel timePanel;
    private JButton a1000Button;
    private JButton a1430Button;
    private JButton a1200Button;
    private JButton a1630Button;
    private JLabel mondayLabel;
    private JLabel tuesdayLabel;
    private JLabel wednesdayLabel;
    private JLabel thursdayLabel;
    private JLabel fridayLabel;
    private JButton takeadayoffBtn;
    private JButton takeABreakButton;
    private JLabel urclientlbl1;
    private JLabel urclientlbl2;
    private JLabel urclientlbl3;
    private JLabel urclientlbl4;
    private JLabel urclient1;
    private JLabel urclient2;
    private JLabel urclient3;
    private JLabel urclient4;
    private JLabel chooseDayLbl;
    private JLabel chooseTimeLbl;
    private JLabel dayOffLbl;
    private JLabel breakLbl;
    private JLabel comingsoon;

    Color[] colors ={Color.BLACK,Color.BLUE,Color.CYAN,Color.GREEN,Color.orange,Color.WHITE,Color.red,Color.MAGENTA,Color.pink,Color.yellow,Color.lightGray};
    JLabel[] daysOfWeek = {monLabel, tueLabel, wedLabel, thuLabel, friLabel};
    JButton[] weeks = {bm1, btu1, bw1, bth1, bf1, bm2, btu2, bw2, bth2, bf2};
    JButton[] time = {btn10, btn12, btn14, btn16};

    JLabel[] profileHeaders = {hairdresserLabel, upcomingDateHeader, upcomingTimeHeader};
    JLabel[] profileLabels = {upcomingMasterLbl, upcomingDateLbl, upcomingTimeLbl};
    JButton[] calendarButtons = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b10};
    JButton[] timeButtons = {a1000Button,a1200Button,a1430Button,a1630Button};
    JLabel[] urClientLbl = {urclientlbl1,urclientlbl2,urclientlbl3,urclientlbl4};
    JLabel[] clientsLabels = {urclient1,urclient3,urclient2,urclient4};
    LocalDate currentDate = LocalDate.now(); // Gets the current currentDate
    LocalDate monDate = getFirstMondayDate(currentDate);

    //For notes in file
    LocalDate chosenDateSup = LocalDate.now();
    ArrayList<String> notes = getNotes();
    String chosenMasterSup;
    // For notes in file
    ArrayList<String> userBooks = new ArrayList<>();
    private int chosenTime = 10;
    private int chosenDate;
    Font labelFont = new Font("Montserrat Medium", Font.BOLD, 18);
    Font secondFont = new Font("Montserrat Medium", Font.BOLD, 14);

    AppFrame(User user) {

        appFrameInit(user);
        bookPanelInit(user);
        profilePanelInit(user);
        servicePanel.setBackground(Color.darkGray);
        schedulePanel.setBackground(Color.darkGray);
        centralSchedulePanel.setBackground(Color.darkGray);
        timePanel.setBackground(Color.darkGray);
        calendarPanel.setBackground(Color.darkGray);
        chooseDayLbl.setFont(labelFont);
        chooseDayLbl.setForeground(Color.WHITE);
        chooseTimeLbl.setFont(labelFont);
        chooseTimeLbl.setForeground(Color.white);
        dayOffLbl.setForeground(Color.darkGray);
        dayOffLbl.setFont(secondFont);
        breakLbl.setForeground(Color.darkGray);
        breakLbl.setFont(secondFont);

        JLabel[] weekdays = {mondayLabel,tuesdayLabel,wednesdayLabel,thursdayLabel,fridayLabel};
        for (JLabel label:weekdays){
            label.setFont(labelFont);
            label.setForeground(Color.white);
        }

        ArrayList<String> hairdresserNotes = new ArrayList<>();
        getHairdresserNotes(user, hairdresserNotes);
        LocalDate today = LocalDate.now();
        LocalDate monday = getFirstMondayDate(today);
        int dayCounter = 0;
        setWeeksButtons(calendarButtons, hairdresserNotes, monday, dayCounter);
        setTimeButtons(timeButtons, hairdresserNotes);
        setWeekButtonsListeners(calendarButtons, hairdresserNotes, monday);
        setTimeButtonsListeners(hairdresserNotes);


        for (JLabel lbl : urClientLbl){
            lbl.setFont(secondFont);
            lbl.setForeground(Color.white);
        }
        setClients(clientsLabels, hairdresserNotes);


        takeadayoffBtn.setForeground(Color.gray);
        takeadayoffBtn.setFont(secondFont);
        takeadayoffBtn.setBackground(Color.darkGray);
        takeadayoffBtn.setFocusable(false);
        takeABreakButton.setForeground(Color.gray);
        takeABreakButton.setFont(secondFont);
        takeABreakButton.setBackground(Color.darkGray);
        takeABreakButton.setFocusable(false);
        scheduleBtnsListeners(user, hairdresserNotes, monday, dayCounter);
        ratingsPanel.add(new MyCanvas());
        comingsoon.setFont(labelFont);


        Timer timer = new Timer(250,this);
        timer.start();


    }

    private void scheduleBtnsListeners(User user, ArrayList<String> hairdresserNotes, LocalDate monday, int dayCounter) {
        takeadayoffBtn.addActionListener(e->{
            if(checkFree(user,"all")){
                try (FileWriter fileWriter = new FileWriter("notes.txt", true)) {
                    fileWriter.write("\nBREAK"+" "+ user.login+" "+chosenDateSup.toString()+" "+"10"+"\n");
                    fileWriter.write("BREAK"+" "+ user.login+" "+chosenDateSup.toString()+" "+"12"+"\n");
                    fileWriter.write("BREAK"+" "+ user.login+" "+chosenDateSup.toString()+" "+"14"+"\n");
                    fileWriter.write("BREAK"+" "+ user.login+" "+chosenDateSup.toString()+" "+"16");
                    hairdresserNotes.add("BREAK"+" "+ user.login+" "+chosenDateSup.toString()+" "+"10");
                    hairdresserNotes.add("BREAK"+" "+ user.login+" "+chosenDateSup.toString()+" "+"12");
                    hairdresserNotes.add("BREAK"+" "+ user.login+" "+chosenDateSup.toString()+" "+"14");
                    hairdresserNotes.add("BREAK"+" "+ user.login+" "+chosenDateSup.toString()+" "+"16");
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                dayOffLbl.setForeground(Color.green);
                dayOffLbl.setText("Success");
            }
            else{
                dayOffLbl.setForeground(Color.red);
                dayOffLbl.setText("Error");
            }
            setWeeksButtons(calendarButtons, hairdresserNotes, monday, dayCounter);
            setTimeButtons(timeButtons, hairdresserNotes);
            setClients(clientsLabels, hairdresserNotes);
        });
        takeABreakButton.addActionListener(e->{
            if(checkFree(user)){
                try (FileWriter fileWriter = new FileWriter("notes.txt", true)) {
                    fileWriter.write("\nBREAK"+" "+ user.login+" "+chosenDateSup.toString()+" "+chosenTime);
                    hairdresserNotes.add("BREAK"+" "+ user.login+" "+chosenDateSup.toString()+" "+chosenTime);

                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                breakLbl.setForeground(Color.green);
                breakLbl.setText("Success");

            }else {
            breakLbl.setForeground(Color.red);
            breakLbl.setText("Error");}
            setWeeksButtons(calendarButtons, hairdresserNotes, monday, dayCounter);
            setTimeButtons(timeButtons, hairdresserNotes);
            setClients(clientsLabels, hairdresserNotes);
        });
    }

    private boolean checkFree(User user,String all) {
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
                list = line.split(" ");
                if(list[1].equals(user.login)&&list[2].equals(chosenDateSup.toString()))
                    return false;
                // считываем остальные строки в цикле
                line = reader.readLine();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }
    private boolean checkFree(User user) {
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
                list = line.split(" ");
                if(list[1].equals(user.login)&&list[2].equals(chosenDateSup.toString())&&list[3].equals(Integer.toString(chosenTime)))
                    return false;
                // считываем остальные строки в цикле
                line = reader.readLine();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    private void setTimeButtonsListeners(ArrayList<String> hairdresserNotes) {
        for (JButton b : timeButtons){
            final Color color = b.getForeground();
            b.addMouseListener(new MouseListener() {

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
                    b.setForeground(Color.WHITE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if(!(chosenTime ==Integer.parseInt(b.getText().substring(0,2))))b.setForeground(color);
                }
            });
            b.addActionListener(e->{
                chosenTime = Integer.parseInt(b.getText().substring(0,2));
                b.setForeground(Color.white);
                setTimeButtons(timeButtons, hairdresserNotes);
                setClients(clientsLabels, hairdresserNotes);
            });
        }
    }

    private void setClients(JLabel[] clientsLabels, ArrayList<String> hairdresserNotes) {
        int t = 10;
        for (JLabel lbl : clientsLabels){
            lbl.setFont(secondFont);
            lbl.setText(checkNote(hairdresserNotes,chosenDateSup.toString(),t));
            if(lbl.getText().equals("NONE")||lbl.getText().equals("BREAK")) lbl.setForeground(Color.gray);
            else {lbl.setForeground(Color.white);}
            t+=2;

        }
    }

    private void setTimeButtons(JButton[] timeButtons, ArrayList<String> hairdresserNotes) {
        for (JButton b : timeButtons){
            b.setFont(secondFont);
            b.setBackground(Color.darkGray);
            b.setFocusable(false);
            b.setBorder(null);
            String check = (checkNote(hairdresserNotes,chosenDateSup.toString(),Integer.parseInt(b.getText().substring(0,2))));
            if(check.equals("NONE")&&!(chosenTime==Integer.parseInt(b.getText().substring(0,2)))){b.setForeground(Color.gray);}
            else if(chosenTime==Integer.parseInt(b.getText().substring(0,2))){b.setForeground(Color.white);}
            else {b.setForeground(Color.black);}
        }
    }

    private void setWeekButtonsListeners(JButton[] calendarButtons, ArrayList<String> hairdresserNotes, LocalDate monday) {
        for (JButton b: calendarButtons){
            final Color color = b.getForeground();

            b.addMouseListener(new MouseListener() {

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
                    b.setForeground(Color.WHITE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if(!b.getText().equals(chosenDateSup.toString().substring(8))) b.setForeground(color);
                }
            });
            b.addActionListener(e->{
                LocalDate firstDay = LocalDate.now().minusDays(LocalDate.now().getDayOfMonth()-1);
                firstDay = firstDay.plusDays(Integer.parseInt(b.getText())-1);
                chosenDateSup = firstDay;
                b.setForeground(Color.white);
                int c = 0;
                setTimeButtons(timeButtons, hairdresserNotes);
                setClients(clientsLabels,hairdresserNotes);
                setWeeksButtons(calendarButtons, hairdresserNotes, monday,c);


            });
        }
    }

    private void setWeeksButtons(JButton[] calendarButtons, ArrayList<String> hairdresserNotes, LocalDate monday, int dayCounter) {
        for (JButton b : calendarButtons){
            b.setText(Integer.toString(monday.getDayOfMonth()+ dayCounter));
            if (checkNoteDay(hairdresserNotes, b.getText())&&!b.getText().equals(chosenDateSup.toString().substring(8))) {
                b.setForeground(Color.BLACK);
            }else if(b.getText().equals(chosenDateSup.toString().substring(8))){
                b.setForeground(Color.white);
            }
            else b.setForeground(Color.gray);
            dayCounter++;
            if(dayCounter ==5) dayCounter +=2;
            b.setFocusable(false);
            b.setBackground(Color.darkGray);
            b.setBorder(null);
            b.setFont(secondFont);

        }
    }

    private static String checkNote(ArrayList<String> hairdresserNotes, String day,int time) {
        for (int i = 0; i < hairdresserNotes.size(); i++) {
            if(hairdresserNotes.get(i).split(" ")[2].equals(day) && hairdresserNotes.get(i).split(" ")[3].equals(Integer.toString(time))){

                return hairdresserNotes.get(i).split(" ")[0];

            }
        }

        return "NONE";
    }
    private static boolean checkNoteDay(ArrayList<String> hairdresserNotes, String day) {
        for (int i = 0; i < hairdresserNotes.size(); i++) {
            if(hairdresserNotes.get(i).split(" ")[2].substring(8).equals(day)){
                return true;
            }
        }
        return false;
    }

    private static void getHairdresserNotes(User user, ArrayList<String> hairdresserNotes) {
        try {
            File file = new File("notes.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] list = line.split(" ");
                if(list[1].equals(user.login)) hairdresserNotes.add(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void profilePanelInit(User user) {
        loginNameLabel.setForeground(Color.WHITE);
        loginNameLabel.setFont(labelFont);
        loginNameLabel.setText(user.login);
        upcomingLabel.setForeground(Color.white);
        upcomingLabel.setFont(labelFont);
        choosingDateLbl.setForeground(Color.white);
        choosingDateLbl.setFont(labelFont);

        cancelBookingButton.setFont(secondFont);
        cancelBookingButton.setBackground(Color.darkGray);
        cancelBookingButton.setForeground(Color.gray);
        cancelBookingButton.setFocusable(false);
        choosingDateCombobox.setFont(secondFont);
        choosingDateCombobox.setBackground(Color.darkGray);
        choosingDateCombobox.setForeground(Color.BLACK);
        choosingDateCombobox.setFocusable(false);
        actionButton.setBackground(Color.darkGray);
        actionButton.setForeground(Color.GRAY);
        actionButton.setFont(secondFont);
        actionButton.setFocusable(false);
        successProfileLabel.setFont(secondFont);
        successProfileLabel.setForeground(Color.darkGray);


        for (int i = 0; i < notes.size(); i++) {
            String[] line = notes.get(i).split(" ");
            if (line[0].equals(user.login)) {
                userBooks.add(notes.get(i));
            }
        }
        Collections.sort(userBooks);
        profileInterfaceInit(user, userBooks);
        cancelBookingButton.addActionListener(e->cancelNote(user,userBooks));
    }

    private void profileInterfaceInit(User user, ArrayList<String> userBooks) {
        for (JLabel label : profileLabels){
            label.setFont(secondFont);
            label.setForeground(Color.gray);
        }
        for (JLabel label : profileHeaders){
            label.setFont(secondFont);
            label.setForeground(Color.white);
        }
        upcomingDateLbl.setText("None");
        upcomingMasterLbl.setText("None");
        upcomingTimeLbl.setText("None");
        choosingDateLbl.setVisible(true);
        choosingDateCombobox.setVisible(true);
        cancelBookingButton.setVisible(true);
        choosingDateCombobox.removeAllItems();

        if(userBooks.size()<2){
            choosingDateLbl.setVisible(false);
            choosingDateCombobox.setVisible(false);
            cancelBookingButton.setVisible(false);
        }
        if(userBooks.size()>=1){
            int count = 1;
            String[] line = userBooks.get(0).split(" ");
            for (JLabel label : profileLabels) {
                if(count==3){
                    if(line[count].equals("10") || line[count].equals("12")){line[count]+=":00";}
                    else line[count]+=":30";
                }
                label.setText(line[count]);
                count++;
            }
            for (int i = 0; i < userBooks.size(); i++) {
                String[] lin = userBooks.get(i).split(" ");
                if(Integer.parseInt(lin[3])>13){
                    lin[3]+=":30";
                }else lin[3]+=":00";
                choosingDateCombobox.addItem(lin[1]+"      "+lin[2]+"      "+lin[3]);
            }
        }
        if(userBooks.size()==0){
            actionButton.setText("Generate Book");
            actionButton.addActionListener(e->{
                LocalDate firstMon = getFirstMondayDate(LocalDate.now());
                LocalDate currentDay = LocalDate.now();
                if (currentDay.getDayOfWeek() == DayOfWeek.SATURDAY || currentDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    currentDay = firstMon;
                }
                int lastDay = firstMon.getDayOfMonth() + 11;


                ArrayList<String> masters = new ArrayList<>();
                ArrayList<Integer> dates = new ArrayList<>();
                ArrayList<Integer> times = new ArrayList<>();

                for (int i = 0; i < comboBox1.getItemCount(); i++) {
                    masters.add(comboBox1.getItemAt(i));
                }

                for (int i = currentDay.getDayOfMonth(); i < lastDay + 1; i++) {
                    if (i == currentDay.getDayOfMonth() + 5 || i == currentDay.getDayOfMonth() + 6) {
                        continue;
                    }
                    dates.add(i);
                }
                for (int i = 10; i < 17; i += 2) {
                    times.add(i);
                }
                currentDay = LocalDate.now();


                int randomMaster = (int) (Math.random() * (masters.size()));
                int randomDay = (int) (Math.random() * (dates.size()));
                int randomTime = (int) (Math.random() * (4));
                LocalDate randomDate = currentDay.minusDays(currentDay.getDayOfMonth() - 1).plusDays(dates.get(randomDay) - 1);

                int counter = 0;
                while (!checkBooking(times.get(randomTime), randomDate, masters.get(randomMaster), notes)) {
                    randomMaster = (int) (Math.random() * (masters.size()));
                    randomDay = (int) (Math.random() * (dates.size()));
                    randomTime = (int) (Math.random() * (4));
                    randomDate = currentDay.minusDays(currentDay.getDayOfMonth() - 1).plusDays(dates.get(randomDay) - 1);
                    if (counter > 300) {
                        break;
                    }
                    counter++;
                }
                if (counter < 300) {
                    chosenTime = times.get(randomTime);
                    chosenDateSup = randomDate;
                    chosenMasterSup = masters.get(randomMaster);
                    String t;
                    if(chosenTime>13){
                        t = chosenTime+":30";
                    }else t = chosenTime+":00";
                    successProfileLabel.setForeground(Color.green);
                    successProfileLabel.setText("Success");
                    upcomingMasterLbl.setText(chosenMasterSup);
                    upcomingDateLbl.setText(chosenDateSup.toString());
                    upcomingTimeLbl.setText(t);

                    createNewNote(user.login, chosenTime, chosenDateSup, chosenMasterSup);

                    notes.add(user.login + " " + chosenMasterSup + " " + chosenDateSup.toString() + " " + chosenTime);
                    changeTimeButtonsSettings(time, chosenDateSup, chosenMasterSup, notes);
                } else {
                    successProfileLabel.setForeground(Color.red);
                    successProfileLabel.setText("Can't make a book");
                }
                changeTimeButtonsSettings(time, chosenDateSup, chosenMasterSup, notes);
                changeInterface(weeks, time, comboBox1, chosenTime, chosenDateSup, chosenMasterSup);

                userBooks.clear();
                notes.clear();
                notes = getNotes();
                for (int i = 0; i < notes.size(); i++) {
                    String[] line = notes.get(i).split(" ");
                    if (line[0].equals(user.login) && !userBooks.contains(notes.get(i))) {
                        userBooks.add(notes.get(i));
                    }
                }
                Collections.sort(userBooks);

                choosingDateCombobox.removeAllItems();
                for (int i = 0; i < userBooks.size(); i++) {
                    String[] line = userBooks.get(i).split(" ");
                    if(Integer.parseInt(line[3])>13){
                        line[3]+=":30";
                    }else line[3]+=":00";
                    choosingDateCombobox.addItem(line[1]+"      "+line[2]+"      "+line[3]);
                }
                profileInterfaceInit(user,userBooks);
            });
        }
        else {
            actionButton.setText("Cancel Book");
            actionButton.addActionListener(e->{
                cancelNote(user, userBooks);


            });
        }
    }

    private void cancelNote(User user, ArrayList<String> userBooks) {
        String[] lis = choosingDateCombobox.getSelectedItem().toString().split("      ");
        lis[2]=lis[2].substring(0,2);

        notes.clear();
        try {
            File file = new File("notes.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                if(line.split(" ")[1].equals(lis[0]) && line.split(" ")[2].equals(lis[1]) && line.split(" ")[3].equals(lis[2]) ){
                    line = reader.readLine();

                    continue;
                }
                notes.add(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter fstream1 = new FileWriter("notes.txt");// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            out1.close(); // закрываем
        } catch (Exception ex) {
            System.err.println("Error in file cleaning: " + ex.getMessage());
        }
        try (FileWriter fileWriter = new FileWriter("notes.txt", true)) {
            String str = "";
            for (int i = 0; i < notes.size()-1; i++) {
                fileWriter.write(notes.get(i) + "\n");
            }if(notes.size()>0) {
                fileWriter.write(notes.get(notes.size() - 1));
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        successProfileLabel.setForeground(Color.green);
        successProfileLabel.setText("Success");
        notes.clear();
        notes = getNotes();
        userBooks.clear();
        for (int i = 0; i < notes.size(); i++) {
            String[] line = notes.get(i).split(" ");
            if (line[0].equals(user.login) && !userBooks.contains(notes.get(i))) {
                userBooks.add(notes.get(i));
            }
        }
        Collections.sort(userBooks);

        choosingDateCombobox.removeAllItems();
        for (int i = 0; i < userBooks.size(); i++) {
            String[] line = userBooks.get(i).split(" ");
            if(Integer.parseInt(line[3])>13){
                line[3]+=":30";
            }else line[3]+=":00";
            choosingDateCombobox.addItem(line[1]+"      "+line[2]+"      "+line[3]);
        }
        profileInterfaceInit(user, userBooks);
    }

    private void appFrameInit(User user) {
        exitButton.addActionListener(e -> System.exit(2));
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        panel1.setBackground(Color.darkGray);
        clientPanel.setBackground(Color.darkGray);
        clientProfilePanel.setBackground(Color.darkGray);
        clientProfileButton.addActionListener(e -> {
            notes.clear();
            notes = getNotes();
            userBooks.clear();
            for (int i = 0; i < notes.size(); i++) {
                String[] line = notes.get(i).split(" ");
                if (line[0].equals(user.login) && !userBooks.contains(notes.get(i))) {
                    userBooks.add(notes.get(i));
                }
            }
            profileInterfaceInit(user,userBooks);
        });

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
            scheduleButton.addActionListener(e -> tabs.show(serviceTabsPanel, "schedule"));
            ratingsButton.addActionListener(e -> tabs.show(serviceTabsPanel, "ratings"));
        }
        exitClient.addActionListener(e -> System.exit(0));
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel2.setBackground(Color.darkGray);
    }

    private void bookPanelInit(User user) {
        bookPanelsSettings();
        headerButtonsSettings();


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

        bookedLabel.setText("Success");
        bookedLabel.setFont(secondFont);
        bookedLabel.setForeground(Color.darkGray);


        masterLabel.setFont(secondFont);
        masterLabel.setForeground(Color.GRAY);
        masterLabel.setText(comboBox1.getItemAt(0));
        chosenMasterSup = comboBox1.getItemAt(0);

        bookedLabel.setFont(secondFont);
        dateHeader.setForeground(Color.white);
        dateHeader.setFont(labelFont);
        timeHeader.setForeground(Color.white);
        timeHeader.setFont(labelFont);
        chooseTheHairdresserLabel.setForeground(Color.white);
        chooseTheHairdresserLabel.setFont(labelFont);
        int count = 0;

        comboboxInit(time);
        weeksButtonsSettings(notes, weeks, time, currentDate, monDate, count);
        changeTimeButtonsSettings(time, chosenDateSup, chosenMasterSup, notes);
        autoBookButtonInit(user, notes, time);
        daysOfWeekInit(daysOfWeek);
        toBookButtonInit(user, time);
    }

    private void toBookButtonInit(User user, JButton[] time) {
        toBookButton.setFocusable(false);
        toBookButton.setBackground(Color.darkGray);
        toBookButton.setFont(secondFont);
        toBookButton.setBorderPainted(true);
        toBookButton.setForeground(Color.GRAY);
        toBookButton.addActionListener(e -> {
                    boolean check = checkBooking(chosenTime, chosenDateSup, chosenMasterSup, notes);
                    if (check) {
                        createNewNote(user.login, chosenTime, chosenDateSup, chosenMasterSup);
                        bookedLabel.setForeground(Color.green);
                        bookedLabel.setText("Success");
                        notes.add(user.login + " " + chosenMasterSup + " " + chosenDateSup.toString() + " " + Integer.toString(chosenTime));
                        changeTimeButtonsSettings(time, chosenDateSup, chosenMasterSup, notes);
                    } else {
                        bookedLabel.setForeground(Color.red);
                        bookedLabel.setText("Error");
                    }
                }
        );
    }

    private void daysOfWeekInit(JLabel[] daysOfWeek) {
        for (JLabel label : daysOfWeek) {
            label.setFont(labelFont);
            label.setForeground(Color.WHITE);
        }
    }

    private void autoBookButtonInit(User user, ArrayList<String> notes, JButton[] time) {
        autoBook.setForeground(Color.GRAY);
        autoBook.setFont(secondFont);
        autoBook.setFocusable(false);
        autoBook.setBackground(Color.darkGray);
        autoBook.addActionListener(e -> {
            LocalDate firstMon = getFirstMondayDate(LocalDate.now());

            LocalDate currentDay = LocalDate.now();
            if (currentDay.getDayOfWeek() == DayOfWeek.SATURDAY || currentDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
                currentDay = firstMon;
            }
            int lastDay = firstMon.getDayOfMonth() + 11;


            ArrayList<String> masters = new ArrayList<>();
            ArrayList<Integer> dates = new ArrayList<>();
            ArrayList<Integer> times = new ArrayList<>();

            for (int i = 0; i < comboBox1.getItemCount(); i++) {
                masters.add(comboBox1.getItemAt(i));
            }

            for (int i = currentDay.getDayOfMonth(); i < lastDay + 1; i++) {
                if (i == currentDay.getDayOfMonth() + 5 || i == currentDay.getDayOfMonth() + 6) {
                    continue;
                }
                dates.add(i);
            }
            for (int i = 10; i < 17; i += 2) {
                times.add(i);
            }
            currentDay = LocalDate.now();


            int randomMaster = (int) (Math.random() * (masters.size()));
            int randomDay = (int) (Math.random() * (dates.size()));
            int randomTime = (int) (Math.random() * (4));
            LocalDate randomDate = currentDay.minusDays(currentDay.getDayOfMonth() - 1).plusDays(dates.get(randomDay) - 1);

            int counter = 0;
            while (!checkBooking(times.get(randomTime), randomDate, masters.get(randomMaster), notes)) {
                randomMaster = (int) (Math.random() * (masters.size()));
                randomDay = (int) (Math.random() * (dates.size()));
                randomTime = (int) (Math.random() * (4));
                randomDate = currentDay.minusDays(currentDay.getDayOfMonth() - 1).plusDays(dates.get(randomDay) - 1);
                if (counter > 300) {
                    break;
                }
                counter++;
            }
            if (counter < 300) {
                chosenTime = times.get(randomTime);
                chosenDateSup = randomDate;
                chosenMasterSup = masters.get(randomMaster);

                masterLabel.setText(chosenMasterSup);
                chosenDateLbl.setText(chosenDateSup.toString());
                String chosenTimeStr = Integer.toString(chosenTime) + ":";
                if (chosenTime < 13) {
                    chosenTimeStr += "00";
                } else chosenTimeStr += "30";
                chosenTimeLbl.setText(chosenTimeStr);

                createNewNote(user.login, chosenTime, chosenDateSup, chosenMasterSup);
                bookedLabel.setForeground(Color.green);
                bookedLabel.setText("Success");
                notes.add(user.login + " " + chosenMasterSup + " " + chosenDateSup.toString() + " " + chosenTime);
                changeTimeButtonsSettings(time, chosenDateSup, chosenMasterSup, notes);
            } else {
                bookedLabel.setForeground(Color.red);
                bookedLabel.setText("Error try next week");
            }
            changeTimeButtonsSettings(time, chosenDateSup, chosenMasterSup, notes);
            changeInterface(weeks, time, comboBox1, chosenTime, chosenDateSup, chosenMasterSup);
        });
    }

    private void changeInterface(JButton[] weeks, JButton[] time, JComboBox<String> comboBox1, int chosenTime, LocalDate chosenDateSup, String chosenMasterSup) {
        for (int i = 0; i < weeks.length; i++) {
            if (weeks[i].getText().equals(chosenDateSup.toString())) {
                weeks[i].setBackground(Color.orange);
            }
        }
        for (int i = 0; i < time.length; i++) {
            if (time[i].getText().substring(2).equals(Integer.toString(chosenTime))) {
                time[i].setBackground(Color.orange);
            }
        }
        for (int i = 0; i < comboBox1.getItemCount(); i++) {
            if (comboBox1.getItemAt(i).equals(chosenMasterSup)) {
                comboBox1.setSelectedIndex(i);
            }
        }
    }

    private void weeksButtonsSettings(ArrayList<String> notes, JButton[] weeks, JButton[] time, LocalDate currentDate, LocalDate monDate, int count) {
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
                    changeInterface(weeks, time, comboBox1, chosenTime, chosenDateSup, chosenMasterSup);
                });
            }
            b.setText(Integer.toString(monDate.getDayOfMonth()));
            if (count == 5) monDate = monDate.plusDays(3);
            else monDate = monDate.plusDays(1);
        }
    }

    private void createNewNote(String login, int chosenTime, LocalDate chosenDateSup, String chosenMasterSup) {
        try (FileWriter fileWriter = new FileWriter("notes.txt", true)) {
            String string = "\n" + login + " " + chosenMasterSup + " " + chosenDateSup.toString() + " " + chosenTime;
            fileWriter.write(string);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private boolean checkBooking(int chosenTime, LocalDate chosenDateSup, String chosenMasterSup, ArrayList<String> notes) {
        for (int i = 0; i < notes.size(); i++) {
            String[] list = notes.get(i).split(" ");
            if (list[1].equals(chosenMasterSup) && list[2].equals(chosenDateSup.toString()) && list[3].equals(Integer.toString(chosenTime))) {
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
        northPanelButtonSettings(exitButton);
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

    private void comboboxInit(JButton[] time) {
        comboBox1.setBackground(Color.darkGray);
        comboBox1.setFont(secondFont);
        comboBox1.setForeground(Color.BLACK);
        comboBox1.setBorder(null);
        comboBox1.setFocusable(false);
        comboBox1.addActionListener(e -> {
            chosenMasterSup = comboBox1.getItemAt(comboBox1.getSelectedIndex());
            masterLabel.setText(chosenMasterSup);
            changeTimeButtonsSettings(time, chosenDateSup, chosenMasterSup, notes);
            changeInterface(weeks, time, comboBox1, chosenTime, chosenDateSup, chosenMasterSup);
        });

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
        b.addActionListener(e -> {
            chosenDate = Integer.parseInt(b.getText());
            changeInterface(weeks, time, comboBox1, chosenTime, chosenDateSup, chosenMasterSup);
        });
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


    @Override
    public void actionPerformed(ActionEvent e) {
        int rand = (int) (Math.random() * colors.length);
        ratingsPanel.setBackground(colors[rand]);
        comingsoon.setForeground(colors[(rand+5)% colors.length]);
    }
}
