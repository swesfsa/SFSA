package misc;

import java.io.IOException;
import java.util.logging.*;

public class Log {

    private static FileHandler fileHandler;
    private static SimpleFormatter simpleFormatter;
    public static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private Log() {}

    public static void setUp(Level level) {

        // get the global logger to configure it
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        // suppress the logging output to the console
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            //rootLogger.removeHandler(handlers[0]);
        }

        logger.setLevel(level);

        try {
            fileHandler = new FileHandler("Logging.txt");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }

        // create a TXT formatter
        simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);
    }
}
