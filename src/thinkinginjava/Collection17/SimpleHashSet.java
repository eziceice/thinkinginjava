package src.thinkinginjava.Collection17;

import java.util.*;

/**
 * Created by Ryan on 2017/3/17.
 */
public class SimpleHashSet<T> extends AbstractSet<T> {
    static int SIZE = 997;
    static int count = 0;
    LinkedList<T>[] buckets = new LinkedList[SIZE];
    public boolean add(T t) {
        int index = Math.abs(t.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<T>();
        LinkedList<T> bucket = buckets[index];
        if (bucket.contains(t))
            return false;
        count++;
        return bucket.add(t);
    }

    public boolean remove(Object o) {
        int index = Math.abs(o.hashCode()) % SIZE;
        if (buckets[index] == null)
            return false;
        for (T t:buckets[index]) {
            if (t.equals(o)) {
                count--;
                return buckets[index].remove(t);
            }
        }
        return false;
    }



    public boolean contains(Object o) {
        int index = Math.abs(o.hashCode()) % SIZE;
        if (buckets[index] == null)
            return false;
        else
            return buckets[index].contains(o);
    }

    public boolean isEmpty() {
        int a = 0;
        for (int i = 0; i < buckets.length ; i++) {
            if (buckets[i] == null)
                a++;
            else
                return false;
        }
        return true;
    }



    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < buckets.length ; i++) {
            if (buckets[i] != null)
                size++;
        }
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < buckets.length ; i++) {
            if (buckets[i] != null) {
                result.append(buckets[i].toString());
            }
        }
        return result.toString();
    }


    private void rehash() {
        if (count > SIZE/2) {
            SIZE = SIZE * 2;
            LinkedList[] newBuckets = new LinkedList[getNumber(SIZE)];
            System.arraycopy(buckets,0,newBuckets,0,SIZE/2);
        }

    }

    private int getNumber(int number) {
        int needNumber = 0;
        for (int i = 0; i < number; i++) {
            if (number % i == 0) {
                getNumber(number++);
                needNumber = number;
            }
        }
        return needNumber;
    }

    public static void main(String[] args) {
        SimpleHashSet<Integer> simpleHashSet = new SimpleHashSet<>();
        Random random = new Random(47);
        for (int i = 0; i < 30 ; i++) {
            int b = random.nextInt(30);
            simpleHashSet.add(b);
            System.out.println(b);
        }

        for (int i = 0; i < simpleHashSet.buckets.length; i++) {
            if (simpleHashSet.buckets[i] != null)
                System.out.println(simpleHashSet.buckets[i].toString());
        }


        System.out.println(simpleHashSet);
    }


}
