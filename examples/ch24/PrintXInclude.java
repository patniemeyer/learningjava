import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class PrintXInclude {
	public static void main( String [] args ) throws Exception 
	{
		DocumentBuilderFactory factory = 
			DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware( true );
		factory.setXIncludeAware( true );
		DocumentBuilder parser = factory.newDocumentBuilder();
		System.out.println( "aware: "+parser.isXIncludeAware() );
		Document document = parser.parse( "chapter.xml" );
		Transformer transformer = 
			TransformerFactory.newInstance().newTransformer();
		Source source = new DOMSource( document );
		Result output = new StreamResult( System.out );
		transformer.transform( source, output );
	}
}
