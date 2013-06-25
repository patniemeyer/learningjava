//file: BackFromTheDead.java
import java.awt.Component;
import javax.swing.*; 
import java.beans.*; 
 
public class BackFromTheDead extends JFrame
{ 
	public BackFromTheDead( String name ) 
	{ 
		super("Revived Beans!"); 
		try { 
			Object bean = Beans.instantiate(  
				getClass().getClassLoader(), name ); 

			if ( Beans.isInstanceOf(bean, JComponent.class) ) { 
				JComponent comp = (JComponent)
					Beans.getInstanceOf( bean, JComponent.class ); 
				getContentPane().add("Center", comp); 
			} else {
				System.out.println("Bean is not a Component..."); 
			}
		} catch ( java.io.IOException e1 ) { 
			System.out.println("Error loading the serialized object");
		} catch ( ClassNotFoundException e2 ) { 
			System.out.println(
				"Can't find the class that goes with the object");
		} 
	 } 
 
	public static void main(String [] args) { 
		JFrame frame = new BackFromTheDead( args[0] );
		frame.pack();
		//frame.setSize(300,300);
		frame.setVisible(true);
	} 
}

