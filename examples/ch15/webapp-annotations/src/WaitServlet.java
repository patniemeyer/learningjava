import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*
    <servlet>
        <servlet-name>waitservlet1</servlet-name>
        <servlet-class>WaitServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>waitservlet1</servlet-name>
        <url-pattern>/wait</url-pattern>
    </servlet-mapping>
 */
@WebServlet(
    name = "waitservlet1",
    urlPatterns={"/wait"}
)
public class WaitServlet extends HttpServlet
{
    public void doGet( HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
	{
		String waitStr = request.getParameter("time");
		if ( waitStr == null )
			throw new ServletException("Missing parameter: time");
		int wait = Integer.parseInt(waitStr);

		try {
			Thread.sleep( wait * 1000 );
		} catch( InterruptedException e ) { 
			throw new ServletException(e); 
		}

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>WaitServlet Response</h1></body></html>");
    }
}

