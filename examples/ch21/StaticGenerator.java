//file: StaticGenerator.java
import java.awt.*;
import java.awt.image.*;
import java.util.Random;
import javax.swing.*;

public class StaticGenerator extends JComponent implements Runnable {
  byte[] data;
  BufferedImage image;
  Random random;

  public void initialize() {
    int w = getSize().width, h = getSize().height;
    int length = ((w + 7) * h) / 8;
    data = new byte[length];
    DataBuffer db = new DataBufferByte(data, length);
    WritableRaster wr = Raster.createPackedRaster(db, w, h, 1, null);
    ColorModel cm = new IndexColorModel(1, 2,
        new byte[] { (byte)0, (byte)255 },
        new byte[] { (byte)0, (byte)255 },
        new byte[] { (byte)0, (byte)255 });
    image = new BufferedImage(cm, wr, false, null);
    random = new Random();
  }

  public void run() {
	if ( random == null )
		initialize();
    while (true) {
      random.nextBytes(data);
      repaint();
      try { Thread.sleep(1000 / 24); }
      catch( InterruptedException e ) { /* die */ }
    }
  }

  public void paint(Graphics g) {
    if (image == null) initialize();
    g.drawImage(image, 0, 0, this);
  }

  public void setBounds(int x, int y, int width, int height) {
	super.setBounds(x,y,width,height);
	initialize();
  }

  public static void main(String[] args) {
	//RepaintManager.currentManager(null).setDoubleBufferingEnabled(false);
    JFrame frame = new JFrame("StaticGenerator");
    StaticGenerator staticGen = new StaticGenerator();
    frame.getContentPane().add( staticGen );
    frame.setSize(300, 300);
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible(true);
	new Thread( staticGen ).start();
  }
}
