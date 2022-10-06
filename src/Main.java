
import java.awt.*;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        new loginWindow();
	   // new AppWindow();
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        Font[] allFonts = ge.getAllFonts();
        for (Font font : allFonts) {
            System.out.println(font.getFontName(Locale.US));
        }
    }
}
