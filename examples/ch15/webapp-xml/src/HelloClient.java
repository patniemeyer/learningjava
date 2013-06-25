//file: HelloClient.java
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloClient extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

        // must come first
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(  );

        out.println(
            "<html><head><title>Hello Client</title></head><body>"
            + "<h1> Hello Client </h1>"
            + "</body></html>" );
        out.close(  );
    }
}
