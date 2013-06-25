import org.w3c.dom.*;
import org.xml.sax.InputSource;
import javax.xml.xpath.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XMLGrep {

	public static void printXML( Element element ) throws TransformerException
	{
		Transformer transformer = 
			TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty( OutputKeys.OMIT_XML_DECLARATION, "yes" );
		Source source = new DOMSource( element );
		Result output = new StreamResult( System.out );
		transformer.transform( source, output );
		System.out.println();
	}

	public static void main( String [] args ) throws Exception
	{
        /*
		if ( args.length != 2 ) { 
			System.out.println( "usage: PrintXPath expression file.xml" );
			System.exit(1);
		}
		String expression = args[0], filename = args[1];
		*/

        String expression = "//animal[starts-with(name,'C')]";
        String filename = "zooinventory.xml";

		XPath xpath = XPathFactory.newInstance().newXPath();
		InputSource inputSource = new InputSource( filename );

		NodeList elements = (NodeList)xpath.evaluate( 
			expression, inputSource, XPathConstants.NODESET );

		for( int i=0; i<elements.getLength(); i++ )
			if ( elements.item(i) instanceof Element ) {
				printXML( (Element)elements.item(i) );
			} else
				System.out.println( elements.item(i) );
	}

}
