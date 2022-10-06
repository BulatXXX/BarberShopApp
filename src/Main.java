
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        new loginWindow();
        try {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("A.ttf")));
        } catch (IOException | FontFormatException e) {
            //Handle exception
        }
	   // new AppWindow();
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        Font[] allFonts = ge.getAllFonts();
        for (Font font : allFonts) {
            System.out.println(font.getFontName(Locale.US));
        }
    }
}
