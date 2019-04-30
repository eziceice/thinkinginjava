package src.thinkinginjava.ObjectBasicInfo11;

import java.util.LinkedList;

/**
 * Created by Ryan on 2017/2/6.
 */
public class StackTest {


    public static void main(String[] args) {
        LinkedList<Character> strings = new LinkedList<>();
        String s = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
        char[] c = s.toCharArray();
        for(int i = 0;i < c.length; i++) {
            switch (c[i]) {
                case '+' :
                    strings.push(c[i+1]);
                    break;
                case '-' :
                    System.out.print(strings.pop().toString().toLowerCase());
                    break;
                default:
                    break;
            }
        }
    }
}
