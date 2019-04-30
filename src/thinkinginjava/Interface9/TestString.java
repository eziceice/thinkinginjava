package src.thinkinginjava.Interface9;

import java.util.Arrays;



/**
 * Created by Ryan on 2017/2/4.
 */
public class TestString {

    public void buildString(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
    }

    public String name() {
        return getClass().getSimpleName();
    }

    public Object process(Object input) {
        return input;
    }
}
