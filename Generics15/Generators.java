package Generics15;

import java.util.*;

/**
 * Created by Ryan on 2017/2/16.
 */
public class Generators {
    public static <T> List<T> fill(List<T> t, Generator<T> gen, int n) {
        for (int i = 0; i < n ; i++) {
            t.add(gen.next());
        }
        return t;
    }

    public static <T> Queue<T> fill(Queue<T> t, Generator<T> gen, int n) {
        for (int i = 0; i < n ; i++) {
            t.add(gen.next());
        }
        return t;
    }

    public static <T> Set<T> fill(Set<T> t, Generator<T> gen, int n) {
        for (int i = 0; i < n ; i++) {
            t.add(gen.next());
        }
        return t;
    }

    public static <T> LinkedList<T> fill(LinkedList<T> t, Generator<T> gen, int n) {
        for (int i = 0; i < n ; i++) {
            t.add(gen.next());
        }
        return t;
    }

}
