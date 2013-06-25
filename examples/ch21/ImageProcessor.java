//file: ImageProcessor.java
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

public class ImageProcessor extends JComponent {
  private BufferedImage source, destination;
  private JComboBox options;

  public ImageProcessor( BufferedImage image ) {
    source = destination = image;
    setBackground(Color.white);
    setLayout(new BorderLayout());
    // create a panel to hold the combo box
    JPanel controls = new JPanel();
    // create the combo box with the names of the area operators
    options = new JComboBox(
      new String[] { "[source]", "brighten", "darken", "rotate", "scale" }
    );
    // perform some processing when the selection changes
    options.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent ie) {
        // retrieve the selection option from the combo box
        String option = (String)options.getSelectedItem();
        // process the image according to the selected option
        BufferedImageOp op = null;
        if (option.equals("[source]"))
          destination = source;
        else if (option.equals("brighten"))
          op = new RescaleOp(1.5f, 0, null);
        else if (option.equals("darken"))
          op = new RescaleOp(.5f, 0, null);
        else if (option.equals("rotate"))
          op = new AffineTransformOp(
              AffineTransform.getRotateInstance(Math.PI / 6), null);
        else if (option.equals("scale"))
          op = new AffineTransformOp(
              AffineTransform.getScaleInstance(.5, .5), null);
        if (op != null) destination = op.filter(source, null);
        repaint();
      }
    });
    controls.add(options);
    add(controls, BorderLayout.SOUTH);
  }

  public void paintComponent(Graphics g) {
    int imageWidth = destination.getWidth();
    int imageHeight = destination.getHeight();
    int width = getSize().width;
    int height = getSize().height;
    g.drawImage(destination,
        (width - imageWidth) / 2, (height - imageHeight) / 2, null);
  }

  public static void main(String[] args) {
    String filename = args[0];

	ImageIcon icon = new ImageIcon(filename);
	Image i = icon.getImage();

    // draw the Image into a BufferedImage
    int w = i.getWidth(null), h = i.getHeight(null);
    BufferedImage buffImage = new BufferedImage(w, h,
        BufferedImage.TYPE_INT_RGB);
    Graphics2D imageGraphics = buffImage.createGraphics();
    imageGraphics.drawImage(i, 0, 0, null);

    JFrame frame = new JFrame("ImageProcessor");
    frame.getContentPane().add(new ImageProcessor(buffImage));
    frame.setSize(buffImage.getWidth(), buffImage.getHeight());
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible(true);
  }
}
