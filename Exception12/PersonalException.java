package Exception12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by Ryan on 2017/2/8.
 */
public class PersonalException {
    private static Logger logger = Logger.getLogger("Exception12");

    public static void getLogger(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }



    public static void exceptionTest() throws RuntimeException {

        String[] strings = {"a", "b", "c" , "d", "e"};
        try {
            String error = strings[5];
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args)  {


        /**
        try {
            throw new Exception12("This is a test");
        } catch (Exception12 e) {
            System.out.println(e);
        } finally {
            System.out.println("Yeah");
        }*/


        /**
        String13 s = null;

        try {
            s.toCharArray();
        } catch (NullPointerException e) {
            System.err.print(e);
        }


        try {
            s.toCharArray();
        } catch (Exception12 e) {
            System.out.println(e);
        }
        */

        try {
           exceptionTest();
        } catch (RuntimeException e) {
            System.out.println(e.getCause());
        }






    }
}
