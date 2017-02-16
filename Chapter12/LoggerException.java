package Chapter12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by Ryan on 2017/2/9.
 */
public class LoggerException extends Exception {
    private static Logger logger = Logger.getLogger("LoggerException");
    public static void LoggerException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }


    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            LoggerException(e);
        }
    }
}
