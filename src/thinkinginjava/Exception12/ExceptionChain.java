package src.thinkinginjava.Exception12;

/**
 * Created by Ryan on 2017/2/9.
 */
public class ExceptionChain {

    public void g() throws ExceptionOne {
        try {
            new ExceptionOne();
        } catch (Exception e) {
            e.printStackTrace();
            boolean s = true;
            int i = 0;
        }
    }



    public void f() throws ExceptionTwo {
        try {
            g();
        } catch (Exception e) {
            e.printStackTrace();

            /**
            ExceptionTwo et = new ExceptionTwo();
            et.initCause(new ExceptionOne());
            throw et;
            */
            throw new RuntimeException(e);

        }
    }
}
