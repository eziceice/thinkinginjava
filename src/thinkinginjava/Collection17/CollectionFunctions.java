package src.thinkinginjava.Collection17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ryan on 2017/3/19.
 */
public class CollectionFunctions {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("C");
        list.add("a");
        list.add("b");
        list.add("a");
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        System.out.println(Collections.lastIndexOfSubList(list,list1));

        //Collections.sort(list,Collections.reverseOrder());


        System.out.println(Collections.nCopies(5,"a"));
        Collections.emptyList();


        //Collections.sort(list);
        System.out.println(list);
        System.out.println(Collections.max(list,String.CASE_INSENSITIVE_ORDER));
    }
}
