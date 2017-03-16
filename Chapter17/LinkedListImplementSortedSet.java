package Chapter17;

import java.util.*;

/**
 * Created by Ryan on 2017/3/15.
 */
public class LinkedListImplementSortedSet<E extends Number> {
    LinkedList<E> linkedList;
    LinkedList<E> linkedList1 = new LinkedList<>();

    public LinkedListImplementSortedSet(LinkedList<E> linkedList) {
        this.linkedList = linkedList;

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

    public LinkedListImplementSortedSet<E> tailSet(E fromElement) {
        linkedList1.clear();
        int i = linkedList.indexOf(fromElement);
        linkedList1.addAll(linkedList.subList(i,getlastIndex()));
        return new LinkedListImplementSortedSet<E>(linkedList1);

    }

    public LinkedList<E> headSet(E toElement) {
        linkedList1.clear();
        int i = linkedList.indexOf(toElement);
        linkedList1.addAll(linkedList.subList(0,i));
        return linkedList1;
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }

    public static void main(String[] args) {
        LinkedListImplementSortedSet<Integer> testList = new LinkedListImplementSortedSet<>();
        Random r = new Random(47);
        for (int i = 0; i < 50 ; i++) {
            int number = r.nextInt(100);
            testList.add(number);
        }

        for (int i = 0; i < testList.size(); i++) {
            System.out.println(testList.get(i));
        }

        System.out.println(testList.first() + ", " + testList.last());


        System.out.println(testList.tailSet(61));

        System.out.println(testList.headSet(61));
    }
}
