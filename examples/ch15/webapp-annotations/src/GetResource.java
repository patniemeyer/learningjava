import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class GetResource extends HttpServlet 
{
    public void doGet( HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
	{
		URL url = getServletContext().getResource("/WEB-INF/web.xml");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
        out.println("<html><body><h1>GetRes Response</h1>");
		out.println( getStringFromStream( url.openStream() ) );
		out.println("</body></html>");
		out.close();
    }

	public static String getStringFromStream( InputStream ins )
		throws IOException
	{
		return getStringFromStream( new	InputStreamReader( ins ) );
	}

	public static String getStringFromStream( Reader reader	)
		throws IOException
	{
		StringBuffer sb	= new StringBuffer();
		BufferedReader br = new	BufferedReader(	reader );
		String line;
		while (	( line = br.readLine() ) != null )
			sb.append( line	+"\n");

		return sb.toString();
	}
}

