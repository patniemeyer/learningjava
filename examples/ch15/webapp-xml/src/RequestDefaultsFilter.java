import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestDefaultsFilter implements Filter 
{
	FilterConfig filterConfig;

    public void init( FilterConfig filterConfig ) throws ServletException
	{ 
		this.filterConfig = filterConfig;
	}

    public void doFilter ( 
		ServletRequest req, ServletResponse res, FilterChain chain ) 
			throws IOException, ServletException 
	{
		WrappedRequest wrappedRequest = 
			new WrappedRequest( (HttpServletRequest)req );
		chain.doFilter( wrappedRequest, res );
    }

    public void destroy() { }

	class WrappedRequest extends HttpServletRequestWrapper 
	{
		WrappedRequest( HttpServletRequest req ) {
			super( req );
		}

		public String getParameter( String name ) { 
			String value = super.getParameter( name );
			if ( value == null )
				value = filterConfig.getInitParameter( name );
			return value;
		}
	}

}

