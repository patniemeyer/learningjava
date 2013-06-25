//file: Slippery.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Slippery {
  public static void main(String[] args) 
  {
	JFrame frame = new JFrame("Slippery v1.0");
	Container content = frame.getContentPane(  ); // unecessary in 1.5+

	JPanel main = new JPanel(new GridLayout(2, 1));
	JPanel scrollBarPanel = new JPanel();
	final JScrollBar scrollBar =
		new JScrollBar(JScrollBar.HORIZONTAL, 0, 48, 0, 255);
	int height = scrollBar.getPreferredSize(  ).height;
	scrollBar.setPreferredSize(new Dimension(175, height));
	scrollBarPanel.add(scrollBar);
	main.add(scrollBarPanel);

	JPanel sliderPanel = new JPanel();
	final JSlider slider =
		new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
	slider.setMajorTickSpacing(48);
	slider.setMinorTickSpacing(16);
	slider.setPaintTicks(true);
	sliderPanel.add(slider);
	main.add(sliderPanel);

	content.add(main, BorderLayout.CENTER);

	final JLabel statusLabel =
		new JLabel("Welcome to Slippery v1.0");
	content.add(statusLabel, BorderLayout.SOUTH);

	// wire up the event handlers
	scrollBar.addAdjustmentListener(new AdjustmentListener(  ) {
	  public void adjustmentValueChanged(AdjustmentEvent e) {
		statusLabel.setText("JScrollBar's current value = "
							+ scrollBar.getValue(  ));
	  }
	});

	slider.addChangeListener(new ChangeListener(  ) {
	  public void stateChanged(ChangeEvent e) {
		statusLabel.setText("JSlider's current value = "
							+ slider.getValue(  ));
	  }
	});

	frame.pack();
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	frame.setVisible(true);
  }
}
