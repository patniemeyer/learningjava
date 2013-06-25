import javax.swing.*;

public class Validator
{
	public static void main( String[] args ) throws Exception {
		Box form = Box.createVerticalBox();
		form.add( new JLabel("Any Number") );
		form.add( new JTextField("5000") );
	
		form.add( new JLabel("Only 0-100") );
		JTextField rangeField = new JTextField("50");
		rangeField.setInputVerifier( new InputVerifier() {
			public boolean verify( JComponent comp ) {
				JTextField field = (JTextField)comp;
				boolean passed = false;
				try {
					int n = Integer.parseInt(field.getText());
					passed = ( 0 <= n && n <= 100 );
				} catch (NumberFormatException e) { }
				if ( !passed ) {
					comp.getToolkit().beep();
					field.selectAll();
				}
				return passed;
			}
		} );
		form.add( rangeField );

		JFrame frame = new JFrame("User Information");
		frame.getContentPane().add(form);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible(true);
	}
}
