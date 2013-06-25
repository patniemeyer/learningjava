//file: ShowParameters.java
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.Enumeration;

public class ShowParameters extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
      throws ServletException, IOException {
        showRequestParameters( request, response );
    }

    void showRequestParameters(HttpServletRequest request,
                               HttpServletResponse response)
      throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(  );

        out.println(
          "<html><head><title>Show Parameters</title></head><body>"
          + "<h1>Parameters</h1><ul>");

        for ( Enumeration e=request.getParameterNames(  );
              e.hasMoreElements(  ); ) {
            String name = (String)e.nextElement(  );
            String value = request.getParameter( name );
            if (! value.equals("") )
                out.println("<li>"+ name +" = "+ value );
        }

        out.close(  );
    }
}
