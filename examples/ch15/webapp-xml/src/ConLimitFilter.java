import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ConLimitFilter implements Filter 
{
	int limit;
	int count;

    public void init( FilterConfig filterConfig )
		throws ServletException
	{
		String s = filterConfig.getInitParameter("limit");
		if ( s == null )
			throw new ServletException("Missing init parameter: "+limit);
		limit = Integer.parseInt( s );
    }

    public void doFilter ( 
		ServletRequest req, ServletResponse res, FilterChain chain ) 
			throws IOException, ServletException 
	{
		if ( count > limit ) {
			HttpServletResponse httpRes = (HttpServletResponse)res;
			httpRes.sendError( httpRes.SC_SERVICE_UNAVAILABLE, "Too Busy.");
		} else {
			++count;
			chain.doFilter( req, res );
			--count;
		}
    }

    public void destroy() { }
}

