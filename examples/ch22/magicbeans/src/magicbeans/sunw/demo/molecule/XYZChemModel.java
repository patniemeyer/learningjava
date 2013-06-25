/*
 * A set of classes to parse, represent and display Chemical compounds in
 * .xyz format (see http://chem.leeds.ac.uk/Project/MIME.html)
 */
 // Made atomTable generic Map 12/2004 - Pat Niemeyer

package magicbeans.sunw.demo.molecule;

import java.io.*;
import java.util.*;


/** The representation of a Chemical .xyz model */
class XYZChemModel {
    float vert[];
    Atom atoms[];
    int tvert[];
    int ZsortMap[];
    int nvert, maxvert;

    static Map<String,Atom> atomTable = new HashMap<String,Atom>();
    static Atom defaultAtom;
    static {
	atomTable.put("c", new Atom(0, 0, 0));
	atomTable.put("h", new Atom(210, 210, 210));
	atomTable.put("n", new Atom(0, 0, 255));
	atomTable.put("o", new Atom(255, 0, 0));
	atomTable.put("p", new Atom(255, 0, 255));
	atomTable.put("s", new Atom(255, 255, 0));
	atomTable.put("hn", new Atom(150, 255, 150)); /* !!*/
	defaultAtom = new Atom(255, 100, 200);
    }

    boolean transformed;
    Matrix3D mat;

    float xmin, xmax, ymin, ymax, zmin, zmax;


    XYZChemModel () {
	mat = new Matrix3D();
	mat.xrot(20);
	mat.yrot(30);
    }


    /** Create a Chemical model by parsing an input stream */
    XYZChemModel (InputStream is) {
	this();
        try {
	    StreamTokenizer st = new StreamTokenizer(
			new BufferedReader(new InputStreamReader(is)));
	    st.eolIsSignificant(true);
	    st.commentChar('#');
	    int slot = 0;
scan:
	    while (true) {
	        switch (st.nextToken()) {
	          case StreamTokenizer.TT_EOF:
		    break scan;
	          default:
		    break;
	          case StreamTokenizer.TT_WORD:
		    String name = st.sval;
		    double x = 0, y = 0, z = 0;
		    if (st.nextToken() == StreamTokenizer.TT_NUMBER) {
		        x = st.nval;
		        if (st.nextToken() == StreamTokenizer.TT_NUMBER) {
			    y = st.nval;
			    if (st.nextToken() == StreamTokenizer.TT_NUMBER)
			        z = st.nval;
		        }
		    }
		    addVert(name, (float) x, (float) y, (float) z);
		    while (st.ttype != StreamTokenizer.TT_EOL &&
			    st.ttype != StreamTokenizer.TT_EOF)
		        st.nextToken();
	        }
	    }
	    is.close();
	    if (st.ttype != StreamTokenizer.TT_EOF)
	        throw new Error(st.toString());
        } catch (Exception ex) {
    	    throw new Error("Input error: " + ex);
	}
    }

    /** Add a vertex to this model */
    int addVert(String name, float x, float y, float z) {
	int i = nvert;
	if (i >= maxvert)
	    if (vert == null) {
		maxvert = 100;
		vert = new float[maxvert * 3];
		atoms = new Atom[maxvert];
	    } else {
		maxvert *= 2;
		float nv[] = new float[maxvert * 3];
		System.arraycopy(vert, 0, nv, 0, vert.length);
		vert = nv;
		Atom na[] = new Atom[maxvert];
		System.arraycopy(atoms, 0, na, 0, atoms.length);
		atoms = na;
	    }
	Atom a = (Atom) atomTable.get(name.toLowerCase());
	if (a == null) a = defaultAtom;
	atoms[i] = a;
	i *= 3;
	vert[i] = x;
	vert[i + 1] = y;
	vert[i + 2] = z;
	return nvert++;
    }

    /** Transform all the points in this model */
    void transform() {
	if (transformed || nvert <= 0)
	    return;
	if (tvert == null || tvert.length < nvert * 3)
	    tvert = new int[nvert * 3];
	mat.transform(vert, tvert, nvert);
	transformed = true;
    }


    /**
     * Paint this model to a graphics context.  It uses the matrix associated
     * with this model to map from model space to screen space.
     * The next version of the browser should have double buffering,
     * which will make this *much* nicer 
     */
    synchronized void paint(java.awt.Graphics g) {
	if (vert == null || nvert <= 0)
	    return;
	transform();
	int v[] = tvert;
	int zs[] = ZsortMap;
	if (zs == null) {
	    ZsortMap = zs = new int[nvert];
	    for (int i = nvert; --i >= 0;)
		zs[i] = i * 3;
	}

	/*
	 * I use a bubble sort since from one iteration to the next, the sort
	 * order is pretty stable, so I just use what I had last time as a
	 * "guess" of the sorted order.  With luck, this reduces O(N log N)
	 * to O(N)
	 */

	for (int i = nvert - 1; --i >= 0;) {
	    boolean flipped = false;
	    for (int j = 0; j <= i; j++) {
		int a = zs[j];
		int b = zs[j + 1];
		if (v[a + 2] > v[b + 2]) {
		    zs[j + 1] = a;
		    zs[j] = b;
		    flipped = true;
		}
	    }
	    if (!flipped)
		break;
	}

	int lg = 0;
	int lim = nvert;
	Atom ls[] = atoms;
	if (lim <= 0 || nvert <= 0) {
	    return;
	}
	for (int i = 0; i < lim; i++) {
	    int j = zs[i];
	    int radius = v[j + 2];
	    if (radius < 0) {
		radius = 0;
	    } else if (radius > 15) {
		radius = 15;
	    }
	    atoms[j/3].paint(g, v[j], v[j + 1], radius);
	}
    }

    /** Find the bounding box of this model */
    void findBB() {
	if (nvert <= 0)
	    return;
	float v[] = vert;
	float xmin = v[0], xmax = xmin;
	float ymin = v[1], ymax = ymin;
	float zmin = v[2], zmax = zmin;
	for (int i = nvert * 3; (i -= 3) > 0;) {
	    float x = v[i];
	    if (x < xmin)
		xmin = x;
	    if (x > xmax)
		xmax = x;
	    float y = v[i + 1];
	    if (y < ymin)
		ymin = y;
	    if (y > ymax)
		ymax = y;
	    float z = v[i + 2];
	    if (z < zmin)
		zmin = z;
	    if (z > zmax)
		zmax = z;
	}
	this.xmax = xmax;
	this.xmin = xmin;
	this.ymax = ymax;
	this.ymin = ymin;
	this.zmax = zmax;
	this.zmin = zmin;
    }
}
