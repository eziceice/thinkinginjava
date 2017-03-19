package Chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Ryan on 2017/3/19.
 */
public class FastTraverlsalLinkedList<E> {
    private LinkedList<E> linkedList = new LinkedList<E>();
    private ArrayList<E> arrayList = new ArrayList<E>();

    public void add(E e) {
        linkedList.add(e);
        Collections.copy(arrayList,linkedList);
    }

    public void remove(E e) {
        linkedList.remove(e);
        arrayList.clear();
        Collections.copy(arrayList,linkedList);
    }

    public void get(int index) {
        arrayList.get(index);
    }

}
