
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws Exception {

        setAppLookAndFeel();
        registerNewFont("Montserrat-Medium.ttf");
        updateNotes();
        new LoginFrame();
        //showAllInstalledLookAndFeels();
        //showAllInstalledFonts();
    }

    private static void showAllInstalledFonts() {
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        Font[] allFonts = ge.getAllFonts();
        for (Font font : allFonts) {
            System.out.println(font.getFontName(Locale.US));
        }
    }

    private static void showAllInstalledLookAndFeels() {
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo look : looks) {
            System.out.println(look.getClassName());
        }
    }

    private static void registerNewFont(String fontFilePath) throws FontFormatException {
        try {
            Font montserrat = Font.createFont(Font.TRUETYPE_FONT, new File("static\\" + fontFilePath));
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("static\\" + fontFilePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setAppLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            // UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static void updateNotes() {
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
                list = line.split(" ");
                if (Integer.parseInt(list[2].substring(8)) >= LocalDate.now().getDayOfMonth() && Integer.parseInt(list[2].substring(5, 7)) >= LocalDate.now().getMonthValue()

                ) {
                    notes.add(line);
                }
                // считываем остальные строки в цикле
                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter fstream1 = new FileWriter("notes.txt");// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            out1.close(); // закрываем
        } catch (Exception e) {
            System.err.println("Error in file cleaning: " + e.getMessage());
        }
        try (FileWriter fileWriter = new FileWriter("notes.txt", true)) {
            String str = "";
            for (int i = 0; i < notes.size() - 1; i++) {
                fileWriter.write(notes.get(i) + "\n");
            }
            fileWriter.write(notes.get(notes.size() - 1));


        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}