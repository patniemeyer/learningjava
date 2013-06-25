import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.concurrent.*;

public class Mandelbrot extends JFrame
{
    @Override public void paint( Graphics g ) {
        BufferedImage image = new BufferedImage( getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB );
        ForkJoinPool pool = new ForkJoinPool(); // defaults thread per processor
        pool.invoke( new MandelbrotTask( image, 0, image.getWidth()-1, 0, image.getHeight()-1 ) );
        g.drawImage( image, 0, 0, null );
    }

    public static void main( String[] args ) {
        Mandelbrot mandy = new Mandelbrot();
        mandy.setSize( 768, 768 );
        mandy.setVisible( true );
    }
}

class MandelbrotTask extends RecursiveAction
{
    private static double size = 3.0, offsetX = -0.7, thresholdSq = 100;
    private static int maxIterations = 30;
    private BufferedImage image;
    private int xStart, xEnd, yStart, yEnd;
    private static int taskSplitThreshold = 1024;

    MandelbrotTask( BufferedImage image, int xStart, int xEnd, int yStart, int yEnd ) {
        this.image = image;
        this.xStart = xStart; this.xEnd = xEnd; this.yStart = yStart; this.yEnd = yEnd;
    }

    public void renderFull()
    {
        for ( int x = xStart; x <= xEnd; x++ ) {
            for ( int y = yStart; y <= yEnd; y++ )  {
                double r = x * size / image.getWidth() -size/2 + offsetX;
                double i = y * size / image.getHeight() -size/2;
                double zr=0, zi=0;
                int iter;
                for ( iter = 0; iter < maxIterations; iter++ ) {
                    double nzr = zr*zr - zi*zi + r;
                    double nzi = 2*zr*zi + i;
                    if ( nzr*nzr + nzi*nzi > thresholdSq ) { break; }
                    zr = nzr; zi=nzi;
                }
                image.setRGB( x, y, Color.HSBtoRGB( 0.5f * iter / maxIterations, 1.0f, 1.0f) );
            }
        }
    }

    @Override protected void compute()
    {
        int width = xEnd-xStart,  height = yEnd-yStart;
        if ( width*height < taskSplitThreshold ) {
            renderFull();
        } else {
            invokeAll(
                new MandelbrotTask( image, xStart, xStart+width/2, yStart, yStart+height/2 ),
                new MandelbrotTask( image, xStart+width/2+1, xEnd, yStart, yStart+height/2 ),
                new MandelbrotTask( image, xStart, xStart+width/2, yStart+height/2+1, yEnd ),
                new MandelbrotTask( image, xStart+width/2+1, xEnd, yStart+height/2+1, yEnd )
            );
        }
    }
}

