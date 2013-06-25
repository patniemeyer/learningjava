
import java.util.logging.*;

public class LogTest2 
{
    public static void main(String argv[]) {
        Logger logger = Logger.getLogger("DeviceLog");

        logger.info("<Device id=\"99\"/>");
    }
}

