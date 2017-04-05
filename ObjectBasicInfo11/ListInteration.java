package ObjectBasicInfo11;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Ryan on 2017/2/6.
 */
public class ListInteration {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        List<Integer> list2 = new ArrayList<>();

        ListIterator<Integer> iterator = list.listIterator();

        while(iterator.hasNext()){
            iterator.next();
        }

        while(iterator.hasPrevious()) {
            list2.add(iterator.previous());
        }

        for (Integer i: list2
             ) {
            System.out.println(i);
        }

    }
}
