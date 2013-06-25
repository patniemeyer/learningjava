import javax.xml.XMLConstants;
import javax.xml.validation.*;
import org.xml.sax.*;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;

public class Validate 
{
	public static void main( String [] args ) throws Exception
	{
        /*
		if ( args.length != 2 ) {
			System.err.println("usage: Validate xmlfile.xml xsdfile.xsd");
			System.exit(1);
		}
		String xmlFile = args[0], schemaFile = args[1];
		*/
        String xmlFile = "zooinventory.xml";
        String schemaFile = "zooinventory.xsd";

        //String schemaFile = "zooinventory.dtd";
	/*
		DTD type isn't supported out of the box
		String schemaType =
			( schemaFile.toLowerCase().endsWith("dtd") ?
			XMLConstants.XML_DTD_NS_URI : XMLConstants.W3C_XML_SCHEMA_NS_URI );
	*/

		SchemaFactory factory =  SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
		Schema schema = factory.newSchema( new StreamSource( schemaFile) );
		Validator validator = schema.newValidator();

		ErrorHandler errHandler = new ErrorHandler() {
			public void error( SAXParseException e ) { System.out.println(e); }
			public void fatalError( SAXParseException e ) { System.out.println(e); }
			public void warning( SAXParseException e ) { System.out.println(e); }
		};
		validator.setErrorHandler( errHandler );

		try {
			 validator.validate( new SAXSource( new InputSource(xmlFile) ) );
		} catch ( SAXException e ) {
			System.out.println(e); // Invalid Document
		}
	}
}
