package Chapter15;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Ryan on 2017/2/16.
 */
public class Fibonacci implements Generator, Iterable<Integer> {

    private int n = 0;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    public Integer next() {
        return fib(n+1);
    }

    private int fib(int n) {
        if(n < 2) {
            return 1;
        }
        return fib(n-2) + fib(n-1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return Fibonacci.this.next();
            }
        };
    }


    public static void main(String[] args) {
        Fibonacci f = new Fibonacci(20);
        for (Integer i: f
             ) {
            System.out.println(i);
        }
    }
}
