package Collection17;

import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ryan on 2017/3/17.
 */
public class SlowSet<E> {
    private List<E> set = new ArrayList<E>();
    public boolean add(E e) {
        if (set.contains(e))
            return false;
        else {
            set.add(e);
            return true;
        }
    }

    public void clear() {
        set.clear();
    }

    public int size() {
        return set.size();
    }

    public boolean contains(Object o) {
        if (set.contains(o))
            return true;
        else
            return false;
    }

    public boolean isEmpty() {
        return set.isEmpty()? true:false;
    }

    public boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    public String toString() {
        return set.toString();
    }

    public static void main(String[] args) {
        SlowSet<Integer> slowSet = new SlowSet<>();
        Random random = new Random(47);
        for (int i = 0; i < 100; i++) {
            int a = random.nextInt(100);
            slowSet.add(a);
        }

        System.out.println(slowSet);
    }
}
