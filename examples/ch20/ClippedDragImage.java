import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClippedDragImage extends DragImage 
{
  int oldX, oldY;

  public ClippedDragImage( Image i ) { super(i); }

  public void mouseDragged(MouseEvent e) {
    imageX = e.getX();
    imageY = e.getY();
    Rectangle r = getAffectedArea(
		oldX, oldY, imageX, imageY, imageWidth, imageHeight);
    repaint(r);  // repaint just the affected part of the component
    oldX = imageX;
    oldY = imageY;
  }

  private Rectangle getAffectedArea( 
	int oldx, int oldy, int newx, int newy, int width, int height) 
  {
    int x = Math.min(oldx, newx);
    int y = Math.min(oldy, newy);
    int w = (Math.max(oldx, newx) + width) - x;
    int h = (Math.max(oldy, newy) + height) - y;
    return new Rectangle(x, y, w, h);
  }

  public static void main(String[] args) {
    String imageFile = "L1-Light.jpg";
    if (args.length > 0)
      imageFile = args[0];

	// Turn off double buffering
	//RepaintManager.currentManager(null).setDoubleBufferingEnabled(false);

    Image image = Toolkit.getDefaultToolkit().getImage(
        ClippedDragImage.class.getResource(imageFile));
	image = image.getScaledInstance(imageWidth,imageHeight,Image.SCALE_DEFAULT);
    JFrame frame = new JFrame("ClippedDragImage");
    frame.getContentPane().add( new ClippedDragImage(image) );
    frame.setSize(300, 300);
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible(true);
  }
}
