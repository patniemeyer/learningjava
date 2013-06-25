//file: StatusImage.java
import java.awt.*;
import javax.swing.*;

public class StatusImage extends JComponent
{
  boolean loaded = false;
  String message = "Loading...";
  Image image;

  public StatusImage( Image image ) { this.image = image; }

  public void paint(Graphics g) {
    if (loaded) 
		g.drawImage(image, 0, 0, this);
    else {
      g.drawRect(0, 0, getSize().width - 1, getSize(  ).height - 1);
      g.drawString(message, 20, 20);
    }
  }
  public void loaded() {
	loaded = true;
	repaint();
  }
  public void setMessage( String msg ) {
	message = msg;
	repaint();
  }

  public static void main( String [] args ) { 
	JFrame frame = new JFrame("TrackImage");
    Image image = Toolkit.getDefaultToolkit().getImage( args[0] );
	StatusImage statusImage = new StatusImage( image );
	frame.getContentPane().add( statusImage );
	frame.setSize(300,300);
	frame.setVisible(true);

    MediaTracker tracker = new MediaTracker( statusImage );
	int MAIN_IMAGE = 0;
    tracker.addImage(image, MAIN_IMAGE);
    try { 
		tracker.waitForID(MAIN_IMAGE); }
    catch (InterruptedException e) {}
    if ( tracker.isErrorID(MAIN_IMAGE) ) 
		statusImage.setMessage("Error");
    else 
		statusImage.loaded();
  }
}
