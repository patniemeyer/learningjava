//file: ShowFonts.java
import java.awt.*;

public class ShowFonts {
  public static void main(String[] args) {
    Font[] fonts;
    fonts =
     GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts(  );
    for (int i = 0; i < fonts.length; i++) {
      System.out.print(fonts[i].getFontName(  ) + " : ");
      System.out.print(fonts[i].getFamily(  ) + " : ");
      System.out.print(fonts[i].getName(  ));
      System.out.println(  );
    }
  }
}
