import java.text.*;
import javax.swing.*;
import javax.swing.text.*;
import java.util.Date;

public class FormattedFields 
{
	public static void main( String[] args ) throws Exception {
		Box form = Box.createVerticalBox();
		form.add( new JLabel("Name:") );
		form.add( new JTextField("Joe User") );

		form.add( new JLabel("Birthday:") );
		JFormattedTextField birthdayField =
			new JFormattedTextField(new SimpleDateFormat("MM/dd/yy"));
		birthdayField.setValue( new Date() );
		form.add( birthdayField );

		form.add( new JLabel("Age:") );
		form.add(new JFormattedTextField(new Integer(32)));

		form.add( new JLabel("Hairs on Body:") );
		JFormattedTextField hairsField 
			= new JFormattedTextField( new DecimalFormat("###,###") );
		hairsField.setValue(new Integer(100000));
		form.add( hairsField );

		form.add( new JLabel("Phone Number:") );
		JFormattedTextField phoneField = 
			new JFormattedTextField( new MaskFormatter("(###)###-####") );
		phoneField.setValue("(314)555-1212");
		form.add( phoneField );

		JFrame frame = new JFrame("User Information");
		frame.getContentPane().add(form);
		frame.pack();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setVisible(true);
	}
}
