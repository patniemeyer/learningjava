import java.net.URL;
import javax.swing.*;
import javax.media.*;
import java.awt.Component;

public class MediaPlayer 
{
	public static void main( String[] args ) throws Exception {
		final JFrame frame = new JFrame("MediaPlayer");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		URL url = new URL( args[0] );
		final Player player = Manager.createPlayer( url );


		player.addControllerListener( new ControllerListener() {
			public void controllerUpdate( ControllerEvent ce ) {
				if ( ce instanceof RealizeCompleteEvent ) 
				{
					Component visual = player.getVisualComponent();
					Component control = player.getControlPanelComponent();
					if ( visual != null ) 
						frame.getContentPane().add( visual, "Center" );
					frame.getContentPane().add( control, "South" );
					frame.pack();
					frame.setVisible( true );
					player.start();
				}
			}
		});

		player.realize();
	}
}
