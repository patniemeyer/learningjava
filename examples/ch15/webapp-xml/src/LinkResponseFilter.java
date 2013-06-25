import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LinkResponseFilter implements Filter 
{
	FilterConfig filterConfig;

    public void init( FilterConfig filterConfig ) 
		throws ServletException 
	{ 
		this.filterConfig = filterConfig;
	}

    public void doFilter ( 
		ServletRequest req, ServletResponse res, FilterChain chain ) 
			throws IOException, ServletException 
	{
		WrappedResponse wrappedResponse = 
			new WrappedResponse( (HttpServletResponse)res );
		chain.doFilter( req, wrappedResponse );
		wrappedResponse.close();
    }

    public void destroy() { }

	class WrappedResponse extends HttpServletResponseWrapper 
	{
		boolean linkText;
		PrintWriter client;

		WrappedResponse( HttpServletResponse res ) {
			super( res );
		}

		public void setContentType( String mime ) {
			super.setContentType( mime );
			if ( mime.startsWith("text/html") )
				linkText = true;
		}

		public PrintWriter getWriter() throws IOException {
			if ( client == null )
				if ( linkText )
					client = new LinkWriter( 
						super.getWriter(), new ByteArrayOutputStream() );
				else
					client = super.getWriter();
			return client;
		}

		void close() {
			if ( client != null )
				client.close();
		}
	}

	class LinkWriter extends PrintWriter
	{
		ByteArrayOutputStream buffer;
		Writer client;

		LinkWriter( Writer client, ByteArrayOutputStream buffer ) {
			super( buffer );
			this.buffer = buffer;
			this.client = client;
		}

		public void close() {
			try {
				flush();
				client.write( linkText( buffer.toString() ) );
				client.close();
			} catch ( IOException e ) { 
				setError();
			}
		}

		String linkText( String text ) {
			Enumeration en = filterConfig.getInitParameterNames(); 
			while ( en.hasMoreElements() ) {
				String pattern = (String)en.nextElement();
				String value = filterConfig.getInitParameter( pattern );
				text = text.replaceAll( pattern, "<a href="+value+">$0</a>");
			}
			return text;
		}
	}
}

