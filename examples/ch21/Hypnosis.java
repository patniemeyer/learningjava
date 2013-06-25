//file: Hypnosis.java
import java.awt.*;
import java.awt.geom.GeneralPath;
import javax.swing.*;

public class Hypnosis extends JComponent implements Runnable {
  private int[] coordinates;
  private int[] deltas;
  private Paint paint;

  public Hypnosis(int numberOfSegments) {
    int numberOfCoordinates = numberOfSegments * 4 + 2;
    coordinates = new int[numberOfCoordinates];
    deltas = new int[numberOfCoordinates];
    for (int i = 0 ; i < numberOfCoordinates; i++) {
      coordinates[i] = (int)(Math.random(  ) * 300);
      deltas[i] = (int)(Math.random(  ) * 4 + 3);
      if (deltas[i] > 4) deltas[i] = -(deltas[i] - 3);
    }
    paint = new GradientPaint(0, 0, Color.blue,
        20, 10, Color.red, true);

    Thread t = new Thread(this);
    t.start(  );
  }

  public void run(  ) {
    try {
      while (true) {
        timeStep(  );
        repaint(  );
        Thread.sleep(1000 / 24);
      }
    }
    catch (InterruptedException ie) {}
  }

  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    Shape s = createShape(  );
    g2.setPaint(paint);
    g2.fill(s);
    g2.setPaint(Color.white);
    g2.draw(s);
  }

  private void timeStep(  ) {
    Dimension d = getSize(  );
    if (d.width == 0 || d.height == 0) return;
    for (int i = 0; i < coordinates.length; i++) {
      coordinates[i] += deltas[i];
      int limit = (i % 2 == 0) ? d.width : d.height;
      if (coordinates[i] < 0) {
        coordinates[i] = 0;
        deltas[i] = -deltas[i];
      }
      else if (coordinates[i] > limit) {
        coordinates[i] = limit - 1;
        deltas[i] = -deltas[i];
      }
    }
  }

  private Shape createShape(  ) {
    GeneralPath path = new GeneralPath(  );
    path.moveTo(coordinates[0], coordinates[1]);
    for (int i = 2; i < coordinates.length; i += 4)
      path.quadTo(coordinates[i], coordinates[i + 1],
          coordinates[i + 2], coordinates[i + 3]);
    path.closePath(  );
    return path;
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Hypnosis");
    frame.getContentPane().add( new Hypnosis(4) );
    frame.setSize(300, 300);
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible(true);
  }
}
