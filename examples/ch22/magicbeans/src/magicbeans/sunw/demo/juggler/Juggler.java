
package magicbeans.sunw.demo.juggler;

/**
 * A simple JavaBean demonstration class that displays an animation
 * of Duke juggling a couple of coffee beans.    The Juggler class
 * is a good simple example of how to write readObject/writeObject
 * serialization methods that restore transient state.    In this case
 * the transient state is an array of images and a Thread.
 */
// Updates and Modifications for LearningJava
// 02/2002, Niemeyer
// Added image pre-loading
// Added setJuggling() property
// Added readObject() support for serialization
// 12/2004 Changed package to avoid conflict with original Sun JavaBeans
//   examples which don't play well in NetBeans 4.x.

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.URL;
import java.beans.*;
import java.beans.DesignMode.*;
import javax.swing.*;
import java.io.*;

public class Juggler extends JComponent
implements Runnable, PropertyChangeListener, DesignMode {
    private transient Image[] images;
    private transient Thread animationThread;
    private int rate = 125;
    private transient int loop;
    private boolean stopped = true;
    private boolean debug = false;
    private boolean dmode = false;
    
    public Juggler() {
        initialize();
        setJuggling(true);
    }
    
    /**
     * method: start the Juggler .
     */
    
    public synchronized void start() {
        startJuggling();
    }
    
    /**
     * method: stop the Juggler .
     */
    
    public synchronized void stop() {
        stopJuggling();
    }
    
    /**
     * Initialize the Juggler .
     */
    private void initialize() 
    {
        // Load the image resources:
        images = new Image[5];
        for (int i = 0; i < 5; i++) {
            String imageName = "Juggler" + i + ".gif";
            images[i] = loadImage(imageName);
            if (images[i] == null) {
                System.err.println("Couldn't load image " + imageName);
                return;
            }
        }
    }
    
    
    /**
     * This is an internal utility method to load GIF icons.
     * It takes the name of a resource file associated with the
     * current object's class-loader and loads a GIF image
     * from that file.
     * <p>
     * @return    a GIF image object.    May be null if the load failed.
     */
    private java.awt.Image loadImage(String name) {
        try {
            java.net.URL url = getClass().getResource(name);
            
            ImageIcon icon = new ImageIcon(url);
            Image i = icon.getImage();
            return i;
        } catch (Exception ex) {
            return null;
        }
    }
    
    
    /**
     * Draw the current frame.
     */
    public void paintComponent(Graphics g) {
        int index = (loop%4) + 1;
        // If the animation is stopped, show the startup image.
        if (stopped) {
            index = 0;
        }
        if (images == null || index >= images.length) {
            return;
        }
        Image img = images[index];
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }
    
    
    /**
     * If false, suspend the animation thread.
     */
    public synchronized void setEnabled(boolean x) {
        super.setEnabled(x);
        notify();
    }
    
    
    /**
     * Resume the animation thread if we're enabled.
     * @see #stopJuggling
     * @see #setEnabled
     */
    public synchronized void startJuggling() {
        if (images == null) {
            initialize();
        }
        if (animationThread == null) {
            animationThread = new Thread(this);
            animationThread.start();
        }
        stopped = false;
        notify();
    }
    
    /**
     * Suspend the animation thread if neccessary.
     * @see #startJuggling
     * @see #setEnabled
     */
    public synchronized void stopJuggling() {
        stopped = true;
        loop = 0;
        // Draw the stopped frame.
        Graphics g = getGraphics();
        if (g == null || images == null) {
            return;
        }
        Image img = images[0];
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }
    
    
    /**
     * An event handling method that calls startJuggling.    This method
     * can be used to connect a Button or a MenuItem to the Juggler.
     *
     */
    public void startJuggling(ActionEvent x) {
        startJuggling();
    }
    
    /**
     * This method can be used to connect a Button or a MenuItem
     * to the Juggler.stopJuggling method.
     */
    public void stopJuggling(ActionEvent x) {
        stopJuggling();
    }
    
    
    /**
     * Returns false if the Juggler is stopped, true otherwise.
     */
    public boolean isJuggling() {
        return !stopped;
    }
    
    public int getAnimationDelay() {
        return rate;
    }
    
    public void setAnimationDelay(int x) {
        rate = x;
    }
    
    
    public Dimension getMinimumSize() {
        return new Dimension(144, 125);
    }
    
    public Dimension getPreferredSize() {
        return getMinimumSize();
    }
    
    /*
     * PropertyChangeListener method.  Currently only listen for designMode.
     */
    public void propertyChange( PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("designMode")) {
            boolean dmode = (boolean)((Boolean)evt.getNewValue()).booleanValue();
            setDesignTime(dmode);
        }
    }
    
    /*
     * If switching to runtime, turn off method tracing if it was enabled.
     * If switching to design time and debugging is true, then enable
     * method tracing if the service is available.
     */
    public void setDesignTime(boolean dmode) {
        this.dmode = dmode;
    }
    
   /*
    * Returns true if we're in design mode, false if in runtime mode.
    */
    public boolean isDesignTime() {
        return dmode;
    }
    
    public void run() {
        try {
            while(true) {
                // First wait until the animation is not stopped.
                synchronized (this) {
                    while (stopped || !isEnabled()) {
                        wait();
                    }
                }
                loop++;
                // Now draw the current frame.
                Graphics g = getGraphics();
                Image img = images[(loop % 4) + 1];
                if (g != null && img != null) {
                    g.drawImage(img, 0, 0, this);
                }
                Thread.sleep(rate);
            }
        } catch (InterruptedException e) {
        }
    }
    
    public void setJuggling( boolean b ) {
        if ( b )
            start();
        else
            stop();
    }
    
    private void readObject(ObjectInputStream s)
    throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        initialize();
        if ( !stopped )
            start();
    }
    
}
