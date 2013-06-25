import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TestFilter implements Filter 
{
	int limit;
	int count;

    public void init( FilterConfig filterConfig )
		throws ServletException
	{
    }

    public void doFilter ( 
		ServletRequest req, ServletResponse res, FilterChain chain ) 
			throws IOException, ServletException 
	{
		System.out.println("test filter");
		chain.doFilter( req, res );
    }

    public void destroy() { }
}

