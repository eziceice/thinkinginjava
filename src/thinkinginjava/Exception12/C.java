package src.thinkinginjava.Exception12;

/**
 * Created by Ryan on 2017/2/9.
 */
public class C extends B {
    @Override
    public void throwException() throws RuntimeException {
        throw new RuntimeException();
    }


    public static void main(String[] args) {
        A a = new C();
        try {
            a.throwException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
