import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@ServletSecurity(
    httpMethodConstraints = @HttpMethodConstraint( value="POST", transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL)
)
@WebServlet( urlPatterns={"/mylogin"} )
public class MyLogin extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
       String user = request.getParameter("user");
       String password = request.getParameter("pass");
       request.login( user, password );
       // Dispatch or redirect to the next page...
    }
}

