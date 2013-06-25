//file: CookieCutter.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*
    <servlet>
        <servlet-name>cookiecutter1</servlet-name>
        <servlet-class>CookieCutter</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>cookiecutter1</servlet-name>
        <url-pattern>/cookiecutter</url-pattern>
    </servlet-mapping>
 */
@WebServlet(urlPatterns={"/cookiecutter"})
public class CookieCutter extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(  );

        if ( request.getParameter("setcookie") != null ) {
            Cookie cookie = new Cookie("Learningjava", "Cookies!");
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            out.println("<html><body><h1>Cookie Set...</h1>");
        } else {
            out.println("<html><body>");
            Cookie[] cookies = request.getCookies(  );
            if ( cookies.length == 0 ) {
                out.println("<h1>No cookies found...</h1>");
            } else {
                for (int i = 0; i < cookies.length; i++)
                    out.print("<h1>Name: "+ cookies[i].getName() + "<br>"
                              + "Value: " + cookies[i].getValue() + "</h1>" );
            }
            out.println("<p><a href=\""+ request.getRequestURI()
              +"?setcookie=true\">"
              +"Reset the Learning Java cookie.</a>");
        }
        out.println("</body></html>");
    }
}
