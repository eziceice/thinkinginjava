package src.thinkinginjava.ObjectBasicInfo11;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Ryan on 2017/2/6.
 */
public class LinkedTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ListIterator<Integer> listIterator = linkedList.listIterator();
        listIterator.add(1);
        for (int i = 1; i < 10; i = i + 2) {
            if(listIterator.hasNext()) {
                listIterator.add(i);
            }
            if(listIterator.hasPrevious()) {
                listIterator.add(i+1);
                listIterator.previous();
            }
        }

        for (Integer s:linkedList
             ) {
            System.out.println(s);
        }

    }
}
