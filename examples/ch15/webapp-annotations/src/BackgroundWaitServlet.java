import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.concurrent.*;

@WebServlet(
    urlPatterns={"/bgwait"},
    asyncSupported = true
)
public class BackgroundWaitServlet extends HttpServlet
{
    public void doGet( HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        final AsyncContext asyncContext = request.startAsync();
        ScheduledExecutorService executor =
            (ScheduledExecutorService)request.getServletContext().getAttribute("BackgroundWaitExecutor");
        executor.schedule( new RespondLaterJob( asyncContext ), 5, TimeUnit.SECONDS );
    }
}

class RespondLaterJob implements Runnable
{
    private AsyncContext asyncContext;

    RespondLaterJob( AsyncContext asyncContext ) {
        this.asyncContext = asyncContext;
    }

    @Override
    public void run()
    {
        try {
            ServletResponse response = asyncContext.getResponse();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body><h1>WaitServlet Response</h1></body></html>");
        } catch ( IOException e ) { throw new RuntimeException( e ); }

        asyncContext.complete();
    }
}
