import javax.servlet.*;
import javax.servlet.annotation.*;
import java.util.concurrent.*;

@WebListener
public class BackgroundWaitService implements ServletContextListener
{
    ScheduledExecutorService executor;

    public void contextInitialized( ServletContextEvent sce )
    {
        this.executor = Executors.newScheduledThreadPool( 3 );
        sce.getServletContext().setAttribute( "BackgroundWaitExecutor", executor );
    }

    public void contextDestroyed(ServletContextEvent sce)
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool( 3 );
        executor.shutdownNow();
    }
}
