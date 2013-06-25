import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

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

