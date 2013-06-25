import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/*
    <servlet>
        <servlet-name>helloclient1</servlet-name>
        <servlet-class>HelloClient</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>helloclient1</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>

@ServletSecurity(
    //value = @HttpConstraint(rolesAllowed = "secretagent"),
    httpMethodConstraints = @HttpMethodConstraint( value="GET", transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL)
)
 */
@WebServlet( urlPatterns={"/hello", "/hola"} )
public class HelloClient extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
	{
        response.setContentType("text/html"); // must come first
        PrintWriter out = response.getWriter();
        out.println(
            "<html><head><title>Hello Client!</title></head><body>"
            + "<h1>Hello Client!</h1>"
            + "</body></html>" );
    }
}

