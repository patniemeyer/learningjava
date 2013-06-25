
/** 
 * The only thing we define in the Juggler BeanInfo is a GIF icon.
 */

package magicbeans.sunw.demo.juggler;

import java.beans.*;

public class JugglerBeanInfo extends SimpleBeanInfo {

    public java.awt.Image getIcon(int iconKind) {
	if (iconKind == BeanInfo.ICON_COLOR_16x16) {
	    java.awt.Image img = loadImage("JugglerIcon.gif");
	    return img;
	}
	return null;
    }

    public PropertyDescriptor[] getPropertyDescriptors() {
	try {
	    PropertyDescriptor animationRate =
		new PropertyDescriptor("animationRate", beanClass);

	    PropertyDescriptor name =
		new PropertyDescriptor("name", beanClass);

	    PropertyDescriptor juggling =
		new PropertyDescriptor("juggling", beanClass);

	    animationRate.setBound(true);
	    name.setBound(true);

	    PropertyDescriptor rv[] = { juggling, animationRate, name};
	    return rv;
	} catch( IntrospectionException e) {
	    throw new Error(e.toString());
	}
    }

    public int getDefaultPropertyIndex() {
	// the index for the animationRate property.
	return 1;
    }

    private final static Class beanClass = Juggler.class;
}
