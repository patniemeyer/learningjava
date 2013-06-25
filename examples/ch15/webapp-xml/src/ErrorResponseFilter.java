import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ErrorResponseFilter implements Filter 
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
    }

    public void destroy() { }

	class WrappedResponse extends HttpServletResponseWrapper 
	{
		WrappedResponse( HttpServletResponse res ) {
			super( res );
		}

		public void sendError( int errorCode, String msg ) throws IOException { 
			String url = filterConfig.getInitParameter("error-"+errorCode);
			if ( url != null )
				sendRedirect( url );
			else
				super.sendError( errorCode, msg );
		}

		public void sendError( int errorCode ) throws IOException {
			sendError( errorCode, "error" );
		} 
	}
}

