package src.thinkinginjava.Exception12;

/**
 * Created by Ryan on 2017/2/9.
 */
public class A extends Exception{
    public void throwException() throws Exception {
        throw new Exception();
    }
}
