//file: Clock.java
public class Clock extends UpdateApplet {
    public void paint( java.awt.Graphics graphics ) {
        graphics.drawString( new java.util.Date().toString(), 10, 25 );
    }
}
