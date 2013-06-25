/**
 * A bean to parse, represent and display Chemical compounds in
 * .xyz format (see http://chem.leeds.ac.uk/Project/MIME.html)
 */

// Modifications and updates for LearningJava
// 02/2002, Niemeyer
package magicbeans.sunw.demo.molecule;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* A Bean to display a Chemical model */

public class Molecule extends JComponent 
	implements Serializable, MouseListener, MouseMotionListener 
{
    private static int ourVersion = 3;
    XYZChemModel md;
    float xfac;
    int prevx;
    int prevy;
    float xtheta;
    float ytheta;
    float scalefudge;
    Matrix3D amat;
    Matrix3D tmat;
    String message = null;
    Image backBuffer;
    Graphics backGC;
    int width;
    int height;

    public Molecule() {
	reset();
	amat.yrot(20);
	amat.xrot(20);
	setBackground(java.awt.Color.white);
	addMouseListener(this);
	addMouseMotionListener(this);
    }

    public java.awt.Dimension getPreferredSize() {
	return new java.awt.Dimension(150,150);
    }

    public synchronized void initialize() {

	InputStream is = null;

	try {
	    width = getSize().width;
	    height = getSize().height;

	    is = this.getClass().getResourceAsStream(moleculeName + ".xyz");

	    XYZChemModel m = new XYZChemModel(is);
	    Atom.setComponent(this);
	    md = m;
	    m.findBB();
	    float xw = m.xmax - m.xmin;
	    float yw = m.ymax - m.ymin;
	    float zw = m.zmax - m.zmin;
	    if (yw > xw) {
		xw = yw;
	    }
	    if (zw > xw) {
		xw = zw;
	    }
	    float f1 = width / xw;
	    float f2 = height / xw;
	    xfac = 0.7f * (f1 < f2 ? f1 : f2) * scalefudge;
	    backBuffer = createImage(width, height);
	    backGC = backBuffer.getGraphics();
	} catch(Exception e) {
	    e.printStackTrace();
	    md = null;
	    message = e.toString();
	}
	try {
	    if (is != null) {
		is.close();
	    }
	} catch(Exception e) {
	}
    }

    private synchronized void rotate(int x, int y) {
	tmat.unit();
	float xtheta = (prevy - y) * (360.0f / width);
	float ytheta = (x - prevx) * (360.0f / height);
	tmat.xrot(xtheta);
	tmat.yrot(ytheta);
	amat.mult(tmat);
        repaint();
	prevx = x;
	prevy = y;
    }

    //----------------------------------------------------------------------

    // Mouse listener methods.

    public void mouseClicked(MouseEvent evt) {
    }

    public synchronized void mousePressed(MouseEvent evt) {
	prevx = evt.getX();
	prevy = evt.getY();
    }

    public void mouseReleased(MouseEvent evt) {
    }

    public void mouseEntered(MouseEvent evt) {
    }

    public void mouseExited(MouseEvent evt) {
    }

    public void mouseDragged(MouseEvent evt) { 
        rotate(evt.getX(), evt.getY());
    }

    public void mouseMoved(MouseEvent evt) {
    }

    //----------------------------------------------------------------------

    public synchronized void rotateOnY() {
	int x = prevx;
	int y = (prevy + 10)%height;
	rotate(x, y);
    }

    public synchronized void rotateY(ActionEvent b) {
	rotateOnY();
    }

    public synchronized void rotateOnX() {
	int x = (prevx + 10)%width;
	int y = prevy;
	rotate(x, y);
    }

    public synchronized void rotateX(ActionEvent b) {

         rotateOnX();
    }

    public synchronized void update(Graphics g) {
	if (backBuffer == null) {
	    g.clearRect(0, 0, getSize().width, getSize().height);
	}
	paint(g);
    }

    public synchronized void paint(Graphics g) {

	if (backBuffer == null || getSize().width != width 
				   || getSize().height != height) {
	    initialize();
	}

	if (md != null) {
	    md.mat.unit();
	    md.mat.translate(-(md.xmin + md.xmax) / 2,
			     -(md.ymin + md.ymax) / 2,
			     -(md.zmin + md.zmax) / 2);
	    md.mat.mult(amat);
	    // md.mat.scale(xfac, -xfac, 8 * xfac / getSize().width);
	    md.mat.scale(xfac, -xfac, 16 * xfac / getSize().width);
	    md.mat.translate(getSize().width / 2, getSize().height / 2, 8);
	    md.transformed = false;

	    backGC.setColor(getBackground());
	    backGC.fillRect(0,0,getSize().width, getSize().height);
	    md.paint(backGC);
	    g.drawImage(backBuffer, 0, 0, this);

	} else if (message != null) {
	    g.drawString("Error in model:", 3, 20);
	    g.drawString(message, 10, 40);
	}
    }

    // Support for serialization.  KGH 6/2/96

    private void writeObject(java.io.ObjectOutputStream s)
        		throws java.io.IOException {
	s.writeInt(ourVersion);
	s.writeObject(moleculeName);
    }

    private void readObject(java.io.ObjectInputStream s)
        		throws java.lang.ClassNotFoundException,
			       java.io.IOException {
	// Compensate for missing constructor.
	reset();
	if (s.readInt() != ourVersion) {
	    throw new IOException("Molecule.readObject: version mismatch");
	}
	moleculeName = (String) s.readObject();
    }

    private synchronized void reset() {
	md = null;
	xfac = (float)0.0;
	prevx = 0;
	prevy = 0;
	xtheta = (float)0.0;
	ytheta = (float)0.0;
	scalefudge = 1;
        amat = new Matrix3D();
        tmat = new Matrix3D();
	message = null;
	backBuffer = null;
	backGC = null;
    }

    //-----------------------------------------------------------------
    // Beans properties.

    public String getMoleculeName() {
	return moleculeName;
    }

    public void setMoleculeName(String name) {
	moleculeName = name;
	reset();
	repaint();
    }

    private String moleculeName = "HyaluronicAcid";

}
