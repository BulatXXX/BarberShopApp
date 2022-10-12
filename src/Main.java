
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws Exception {

        setAppLookAndFeel();
        registerNewFont("Montserrat-Medium.ttf");
        new loginWindow();

        showAllInstalledLookAndFeels();
        showAllInstalledFonts();
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
            Font montserrat = Font.createFont(Font.TRUETYPE_FONT,new File("static\\"+fontFilePath));
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("static\\"+fontFilePath)));
        }catch (IOException e){
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
}