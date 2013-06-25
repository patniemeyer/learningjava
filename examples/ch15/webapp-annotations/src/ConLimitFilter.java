import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/*
    <filter>
        <filter-name>confilter1</filter-name>
        <filter-class>ConLimitFilter</filter-class>
		<init-param>
			<param-name>limit</param-name>
			<param-value>3</param-value>
		</init-param>
    </filter>
    <filter-mapping>
		<filter-name>confilter1</filter-name>
		<url-pattern>/*</url-pattern>
    </filter-mapping>
 */
@WebFilter(
    urlPatterns = "/*",
    initParams = {
        @WebInitParam(name="limit", value="3")
    }
)
public class ConLimitFilter implements Filter
{
	int limit;
	volatile int count;

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

