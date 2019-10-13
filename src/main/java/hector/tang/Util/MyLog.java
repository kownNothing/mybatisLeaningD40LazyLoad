package hector.tang.Util;

import java.util.logging.Logger;

public class MyLog {
    private static Logger logger=Logger.getLogger("log4j.properties");

    public static void info(Object obj){
        logger.info(obj.toString());
    }

}
