package Generics15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 2017/2/17.
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();


        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();

        System.out.println(c1.equals(c2));
        System.out.println(c1 == c2);

        System.out.println(l1.equals(l2));

    }
}
