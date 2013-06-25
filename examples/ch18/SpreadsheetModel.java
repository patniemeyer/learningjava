//file: SpreadsheetModel.java
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class SpreadsheetModel extends AbstractTableModel {
  Expression [][] data;

  public SpreadsheetModel( int rows, int cols ) {
    data = new Expression [rows][cols];
  }

  public void setValueAt(Object value, int row, int col) {
    data[row][col] = new Expression( (String)value );
    fireTableDataChanged(  );
  }

  public Object getValueAt( int row, int col ) {
    if ( data[row][col] != null )
      try { return data[row][col].eval(  ) + ""; }
      catch ( BadExpression e ) { return "Error"; }
    return "";
  }
  public int getRowCount(  ) { return data.length; }
  public int getColumnCount(  ) { return data[0].length; }
  public boolean isCellEditable(int row, int col) { return true; }

  class Expression {
    String text;
    StringTokenizer tokens;
    String token;

    Expression( String text ) { this.text = text.trim(  ); }

    float eval(  ) throws BadExpression {
      tokens = new StringTokenizer( text, " */+-(  )", true );
      try { return sum(  ); }
      catch ( Exception e ) { throw new BadExpression(  ); }
    }

    private float sum(  ) {
      float value = term(  );
      while( more(  ) && match("+-") )
        if ( match("+") ) { consume(); value = value + term(  ); }
        else { consume(); value = value - term(  ); }
      return value;
    }
    private float term(  ) {
      float value = element(  );
      while( more(  ) && match( "*/") )
        if ( match("*") ) { consume(); value = value * element(  ); }
        else { consume(); value = value / element(  ); }
      return value;
    }
    private float element(  ) {
      float value;
      if ( match( "(") ) { consume(); value = sum(  ); }
      else {
        String svalue;
        if ( Character.isLetter( token(  ).charAt(0) ) ) {
        int col = findColumn( token(  ).charAt(0) + "" );
        int row = Character.digit( token(  ).charAt(1), 10 );
        svalue = (String)getValueAt( row, col );
      } else
        svalue = token(  );
        value = Float.parseFloat( svalue );
      }
      consume(  ); // ")" or value token
      return value;
    }
    private String token(  ) {
      if ( token == null )
        while ( (token=tokens.nextToken(  )).equals(" ") );
      return token;
    }
    private void consume(  ) { token = null; }
    private boolean match( String s ) { return s.indexOf( token(  ) )!=-1; }
    private boolean more() { return tokens.hasMoreTokens(  ); }
  }

  class BadExpression extends Exception { }

  public static void main( String [] args ) {
    JFrame frame = new JFrame("Excelsior!");
    JTable table = new JTable( new SpreadsheetModel(15, 5) );
    table.setPreferredScrollableViewportSize( table.getPreferredSize() );
    table.setCellSelectionEnabled(true);
    frame.getContentPane().add( new JScrollPane( table ) );
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.pack(); 
	frame.setVisible(true);
  }
}
