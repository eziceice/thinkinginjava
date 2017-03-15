package Chapter17;

import Chapter10.E;

import java.util.*;

/**
 * Created by Ryan on 2017/3/15.
 */
public class LinkedListImplementSortedSet<E extends Number> {
    LinkedList<E> linkedList;

    public LinkedListImplementSortedSet(LinkedList<E> linkedList) {
        linkedList = new LinkedList<E>();

    }

    public LinkedListImplementSortedSet() {
        linkedList = new LinkedList<E>();
    }

    private void sort() {
        Collections.sort(linkedList, (o1, o2) -> {
            if (o1.equals(o2))
                return 0;
            else {
                if (o1.intValue() > o2.intValue())
                    return 1;
                else
                    return -1;
            }
        });
    }

    public E first() {
        return linkedList.getFirst();
    }
    public E last() {
        return linkedList.getLast();
    }

    public int getlastIndex() {
        E e = linkedList.getLast();
        int i = linkedList.indexOf(e);
        return i;
    }

    public void add(E e) {
        linkedList.add(e);
        sort();
    }

    public void remove(E e){
        linkedList.remove(e);
    }

    public int size() {
        return linkedList.size();
    }

    public E get(int i) {
        return linkedList.get(i);
    }

    public LinkedList<E> tailSet(E fromElement) {
        int i = linkedList.indexOf(fromElement);
        LinkedList<E> linkedList1 = new LinkedList<>();
        linkedList1.addAll(linkedList.subList(i,getlastIndex()));
        return linkedList1;
    }

    public LinkedList<E> headSet(E toElement) {
        int i = linkedList.indexOf(toElement);
        LinkedList<E> linkedList2 = new LinkedList<>();
        linkedList2.addAll(linkedList.subList(0,i));
        return linkedList2;
    }


    public static void main(String[] args) {
        LinkedListImplementSortedSet<Integer> testList = new LinkedListImplementSortedSet<>();
        Random r = new Random(47);
        for (int i = 0; i < 50 ; i++) {
            int number = r.nextInt(100);
            testList.add(number);
        }

        for (int i = 0; i < testList.size() ; i++) {
            System.out.println(testList.get(i));
        }

        System.out.println(testList.first() + ", " + testList.last());


        System.out.println(testList.tailSet(61));
        System.out.println(testList.headSet(61));
    }
}
