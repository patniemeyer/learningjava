/*
 * A set of classes to parse, represent and display Chemical compounds in
 * .xyz format (see http://chem.leeds.ac.uk/Project/MIME.html)
 */

package magicbeans.sunw.demo.molecule;

import java.awt.*;
import java.awt.image.*;

class Atom {
    private static java.awt.Component panel;
    private static byte[] data;
    private final static int R = 40;
    private final static int hx = 15;
    private final static int hy = 15;
    private final static int bgGrey = 192;
    private final static int nBalls = 16;
    private static int maxr;

    private int Rl;
    private int Gl;
    private int Bl;
    private Image balls[];

    static {
	data = new byte[R * 2 * R * 2];
	int mr = 0;
	for (int Y = 2 * R; --Y >= 0;) {
	    int x0 = (int) (Math.sqrt(R * R - (Y - R) * (Y - R)) + 0.5);
	    int p = Y * (R * 2) + R - x0;
	    for (int X = -x0; X < x0; X++) {
		int x = X + hx;
		int y = Y - R + hy;
		int r = (int) (Math.sqrt(x * x + y * y) + 0.5);
		if (r > mr)
		    mr = r;
		data[p++] = r <= 0 ? 1 : (byte) r;
	    }
	}
	maxr = mr;
    }
    static void setComponent(java.awt.Component app) {
	panel = app;
    }
    Atom(int Rl, int Gl, int Bl) {
	this.Rl = Rl;
	this.Gl = Gl;
	this.Bl = Bl;
    }
    private final int blend(int fg, int bg, float fgfactor) {
	return (int) (bg + (fg - bg) * fgfactor);
    }
    private synchronized void Setup() {
	balls = new Image[nBalls];
	byte red[] = new byte[256];
	red[0] = (byte) bgGrey;
	byte green[] = new byte[256];
	green[0] = (byte) bgGrey;
	byte blue[] = new byte[256];
	blue[0] = (byte) bgGrey;
	for (int r = 0; r < nBalls; r++) {
	    float b = (float) (r+1) / nBalls;
	    for (int i = maxr; i >= 1; --i) {
		float d = (float) i / maxr;
		red[i] = (byte) blend(blend(Rl, 255, d), bgGrey, b);
		green[i] = (byte) blend(blend(Gl, 255, d), bgGrey, b);
		blue[i] = (byte) blend(blend(Bl, 255, d), bgGrey, b);
	    }
	    IndexColorModel model = new IndexColorModel(8, maxr + 1,
							red, green, blue, 0);
	    balls[r] = panel.createImage(
		new MemoryImageSource(R*2, R*2, model, data, 0, R*2));
	}
    }
    synchronized void paint(Graphics gc, int x, int y, int radius) {
	if (balls == null) {
	    Setup();
	}
	Image i = balls[radius];
	int size = 10 + radius;
	gc.drawImage(i, x - (size/2), y - (size/2), size, size, panel);
    }
}
