import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.*;

/*
<filter>
    <filter-name>defaultsfilter1</filter-name>
    <filter-class>RequestDefaultsFilter</filter-class>
    <init-param>
        <param-name>time</param-name>
        <param-value>3</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>defaultsfilter1</filter-name>
    <servlet-name>waitservlet1</servlet-name>
</filter-mapping>
*/
@WebFilter(
    //urlPatterns = "/*",
    servletNames = "waitservlet1",
    initParams = {
        @WebInitParam(name="time", value="3")
    }
)
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

