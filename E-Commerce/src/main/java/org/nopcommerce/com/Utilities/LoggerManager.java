package org.nopcommerce.com.Utilities;

import java.io.IOException;
import java.util.logging.*;

public class LoggerManager {

private static final String LOG_FILE = "automation.log";
private static final Level LOG_LEVEL = Level.INFO;

public static Logger getLogger(Class<?> tClass){
    Logger logger = Logger.getLogger(tClass.getName());

    if(logger.getHandlers().length==0){
        try{

            //Console Handlers
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(LOG_LEVEL);
            consoleHandler.setFormatter(new SimpleFormatter());

            //File Handlers
            FileHandler fileHandler = new FileHandler(LOG_FILE,true);
            fileHandler.setLevel(LOG_LEVEL);
            fileHandler.setFormatter(new SimpleFormatter());

            //Add handlers
            logger.addHandler(consoleHandler);
            logger.addHandler(fileHandler);

            logger.setLevel(LOG_LEVEL);
            logger.setUseParentHandlers(false);

        } catch (IOException e) {
            System.err.println("Failed to set up logger: " + e.getMessage());
        }
    }
    return logger;
}


}
