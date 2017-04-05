package Generics15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 2017/2/21.
 */
public class PlayGround {
    public static void main(String[] args) {
        /**
        List list = new ArrayList();
        list.add("123");
        list.add("456");
        list.add(5);
        for (int i = 0; i < list.size() ; i++) {
            String13 string = (String13) list.get(i);
            System.out.println(string);
        }
         */


        List<String> s = new ArrayList<>();
        List<Integer> i = new ArrayList<>();
        System.out.println(s.equals(i));
    }
}
