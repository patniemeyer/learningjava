//file: ColorPan.java
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class ColorPan extends JComponent {
  BufferedImage image;

  public void initialize(  ) {
    int width = getSize().width;
    int height = getSize().height;
    int[] data = new int [width * height];
    int i = 0;
    for (int y = 0; y < height; y++) {
      int red = (y * 255) / (height - 1);
      for (int x = 0; x < width; x++) {
        int green = (x * 255) / (width - 1);
        int blue = 128;
        data[i++] = (red << 16) | (green << 8 ) | blue;
      }
    }
    image = new BufferedImage(width, height,
        BufferedImage.TYPE_INT_RGB);
    image.setRGB(0, 0, width, height, data, 0, width);
  }

  public void paint(Graphics g) {
    if (image == null) 
        initialize();
    g.drawImage(image, 0, 0, this);
  }

  public void setBounds(int x, int y, int width, int height) {
	super.setBounds(x,y,width,height);
	initialize();
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("ColorPan");
    frame.getContentPane().add(new ColorPan(  ));
    frame.setSize(300, 300);
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible(true);
  }
}
