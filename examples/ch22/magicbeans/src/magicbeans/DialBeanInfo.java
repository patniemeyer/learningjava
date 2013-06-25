package magicbeans;

import java.beans.*;

public class DialBeanInfo extends SimpleBeanInfo {

    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor value = 
				new PropertyDescriptor("value", Dial.class);
            PropertyDescriptor minimum = 
            	new PropertyDescriptor("minimum", Dial.class);
            PropertyDescriptor maximum = 
            	new PropertyDescriptor("maximum", Dial.class);
			
            value.setBound(true);
			minimum.setBound(false);
			maximum.setBound(false);

            return new PropertyDescriptor [] { value, minimum, maximum };
        } catch (IntrospectionException e) {
			return null; 
        }
    }

    public EventSetDescriptor[] getEventSetDescriptors() {
        try {
            EventSetDescriptor dial = new EventSetDescriptor( Dial.class, 
				"dialAdjusted", DialListener.class, "dialAdjusted");
            dial.setDisplayName("Dial Adjusted");

            EventSetDescriptor changed = new EventSetDescriptor( Dial.class,
				"propertyChange", PropertyChangeListener.class, 
				"propertyChange" );
            changed.setDisplayName("Bound property change");
	
            return new EventSetDescriptor [] { dial, changed };
        } catch (IntrospectionException e) {
			return null; 
        }
    }

/*
    public BeanDescriptor getBeanDescriptor() {
        return new BeanDescriptor( Dial.class );
    }
*/

    public java.awt.Image getIcon(int iconKind) {

        if (iconKind == BeanInfo.ICON_COLOR_16x16) {
            return loadImage("DialIconColor16.gif");
        } else
        if (iconKind == BeanInfo.ICON_COLOR_32x32) {
            return loadImage("DialIconColor32.gif");
        } else
        if (iconKind == BeanInfo.ICON_MONO_16x16) {
            return loadImage("DialIconMono16.gif");
        } else
        if (iconKind == BeanInfo.ICON_MONO_32x32) {
            return loadImage("DialIconMono32.gif");
        }
        return null;
    }
}

