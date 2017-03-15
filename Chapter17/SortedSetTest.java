package Chapter17;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Ryan on 2017/3/15.
 */
public class SortedSetTest {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        Collections.addAll(sortedSet,"e a b d g k n o p q r s t u v w s z v i p o a k e d".split(" "));
        String first = sortedSet.first();
        String last = sortedSet.last();
        System.out.println(sortedSet);
        System.out.println(first);
        System.out.println(last);
        System.out.println(sortedSet.comparator());
        System.out.println("---------------------------");
        Iterator<String> it = sortedSet.iterator();

        /**
        for (int i = 0; i <= 6 ; i++) {
            if(i == 3)
                first = it.next();

            if(i == 6)
                last = it.next();
            else
                System.out.println(it.next());
        }
        System.out.println("---------------------------");
        System.out.println(first);
        System.out.println(last);
        System.out.println(sortedSet.subSet(first,last));
        System.out.println(sortedSet.headSet(first));
        System.out.println(sortedSet.tailSet(last));
         */
    }
}
