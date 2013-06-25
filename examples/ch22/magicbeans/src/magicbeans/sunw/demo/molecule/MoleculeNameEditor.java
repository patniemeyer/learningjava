
package magicbeans.sunw.demo.molecule;

/**
 * Special case property editor for molecule names.
 */

public class MoleculeNameEditor
		extends java.beans.PropertyEditorSupport {

    public String[] getTags() {
	String result[] = {
	    "HyaluronicAcid",
	    "benzene",
	    "buckminsterfullerine",
	    "cyclohexane",
	    "ethane",
	    "water"};
	return result;
    }

    public String getJavaInitializationString() {
	return (String)getValue();
    }

}

