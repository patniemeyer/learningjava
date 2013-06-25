import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.util.*;
import java.lang.reflect.*;

public class SAXModelBuilder extends DefaultHandler
{
    Stack<Object> stack = new Stack<>();

    public void startElement(
        String namespace, String localname, String qname, Attributes atts ) throws SAXException
	{
        // Construct the new element and set any attributes on it
		Object element;
        try {
            String className = Character.toUpperCase( qname.charAt( 0 ) ) + qname.substring( 1 );
            element = Class.forName( className ).newInstance();
        } catch ( Exception e ) {
            element = new StringBuffer();
        }

		for( int i=0; i<atts.getLength(); i++) {
            try {
                setProperty( atts.getQName( i ), element, atts.getValue( i ) );
            } catch ( Exception e ) { throw new SAXException( "Error: ", e ); }
        }

        stack.push( element );
    }

	public void endElement( String namespace, String localname, String qname )
		throws SAXException
	{
        // Add the element to its parent
        if ( stack.size() > 1) {
            Object element = stack.pop();
            try {
                setProperty( qname, stack.peek(), element );
            } catch ( Exception e ) { throw new SAXException( "Error: ", e ); }
        }
	}

	public void characters(char[] ch, int start, int len )
    {
        // Receive element content text
		String text = new String( ch, start, len );
        if ( text.trim().length() == 0 ) { return; }
		((StringBuffer)stack.peek()).append( text );
	}

    void setProperty( String name, Object target, Object value )
        throws SAXException, IllegalAccessException, NoSuchFieldException
    {
        Field field = target.getClass().getField( name );

        // Convert values to field type
        if ( value instanceof StringBuffer ) {
            value = value.toString();
        }
        if ( field.getType() == Double.class ) {
            value = Double.parseDouble( value.toString() );
        }
        if ( Enum.class.isAssignableFrom( field.getType() ) ) {
            value = Enum.valueOf( (Class<Enum>)field.getType(), value.toString() );
        }

        // Apply to field
        if ( field.getType() == value.getClass() ) {
            field.set( target, value );
        } else
        if ( Collection.class.isAssignableFrom( field.getType() ) ) {
            Collection collection = (Collection)field.get( target );
            collection.add( value );
        } else {
            throw new RuntimeException( "Unable to set property..." );
        }
	}

	public Object getModel() { return stack.pop(); }
}
