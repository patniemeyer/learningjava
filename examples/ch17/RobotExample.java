import java.awt.*;
import java.awt.event.*;

public class RobotExample
{
    public static void main( String [] args ) throws Exception 
    {
        Robot r = new Robot();
        r.mouseMove(35,35);
        r.mousePress( InputEvent.BUTTON1_MASK );
        r.mouseRelease( InputEvent.BUTTON1_MASK );
        Thread.sleep(50);
        r.mousePress( InputEvent.BUTTON1_MASK );
        r.mouseRelease( InputEvent.BUTTON1_MASK );
    }
}

