package Exception12;

/**
 * Created by Ryan on 2017/2/9.
 */
public class B extends A {
    @Override
    public void throwException() throws RuntimeException {
        throw new RuntimeException();
    }
}
