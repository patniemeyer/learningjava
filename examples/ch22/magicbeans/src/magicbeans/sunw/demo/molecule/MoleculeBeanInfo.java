
package magicbeans.sunw.demo.molecule;

/**
 * BeanInfo for a molecule.  We simply expose a single property
 * the molecule name, with a custome proeprty editor.
 */

import java.beans.*;

public class MoleculeBeanInfo extends SimpleBeanInfo {

    public PropertyDescriptor[] getPropertyDescriptors() {
	try {
	    PropertyDescriptor pd = new PropertyDescriptor("moleculeName",
					    		Molecule.class);
	    pd.setPropertyEditorClass(MoleculeNameEditor.class);
	    PropertyDescriptor result[] = { pd };
	    return result;
	} catch (Exception ex) {
	    System.err.println("MoleculeBeanInfo: unexpected exeption: " + ex);
	    return null;
	}
    }

}
