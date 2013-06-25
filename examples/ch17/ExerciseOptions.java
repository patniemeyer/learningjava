import javax.swing.*;

public class ExerciseOptions {
  public static void main(String[] args) {
    JFrame frame = new JFrame("ExerciseOptions v1.0");
    frame.setSize(200, 200);
    frame.setVisible(true);
    
    JOptionPane.showMessageDialog(frame, "You have mail.");
    JOptionPane.showMessageDialog(frame, "You are low on memory.",
        "Apocalyptic message", JOptionPane.WARNING_MESSAGE);
    
    int result = JOptionPane.showConfirmDialog(null,
        "Do you want to remove Windows now?");
    switch (result) {
      case JOptionPane.YES_OPTION:
        System.out.println("Yes"); break;
      case JOptionPane.NO_OPTION:
        System.out.println("No"); break;
      case JOptionPane.CANCEL_OPTION:
        System.out.println("Cancel"); break;
      case JOptionPane.CLOSED_OPTION:
        System.out.println("Closed"); break;
    }
    
    String name = JOptionPane.showInputDialog(null,
        "Please enter your name.");
    System.out.println(name);
    
    JTextField userField = new JTextField( );
    JPasswordField passField = new JPasswordField( );
    String message = "Please enter your user name and password.";
    result = JOptionPane.showOptionDialog(frame,
        new Object[] { message, userField, passField },
        "Login", JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null, null, null);
    if (result == JOptionPane.OK_OPTION)
      System.out.println(userField.getText( ) +
          " " +  new String(passField.getPassword( )));
    
    System.exit(0);
  }
}

