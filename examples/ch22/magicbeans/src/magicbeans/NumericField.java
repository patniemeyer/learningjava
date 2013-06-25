package magicbeans;

import javax.swing.*;
import java.awt.event.*;

public class NumericField extends JTextField {
	static int defaultFieldSize = 6;
	private double value;

    public NumericField() { 
		super( defaultFieldSize );
		setInputVerifier( new InputVerifier() {
			public boolean verify( JComponent comp ) {
				JTextField field = (JTextField)comp;
				boolean passed = false;
				try {
					setValue( Double.parseDouble( field.getText() ) );
				} catch ( NumberFormatException e ) {
					comp.getToolkit().beep();
					field.selectAll();
					return false;
				}
				return true;
			}
		} );

		addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				getInputVerifier().verify( NumericField.this );
			}
		} );

	}
 
	public double getValue() {
		return value;
	}
	public void setValue( double newValue ) {
		double oldValue = value;
		value = newValue;
		setText( "" + newValue );
		firePropertyChange( "value", oldValue, newValue );
	}
}
