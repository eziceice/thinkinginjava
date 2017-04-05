package Generics15;

import java.util.Iterator;

/**
 * Created by Ryan on 2017/2/16.
 */
public class Fibonacci implements Generator, Iterable<Integer>, Runnable {

    private int n;
    private static int count = 0;
    private final int id = count++;

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
        for (int i = 0; i < 30; i++) {
            Fibonacci fibonacci = new Fibonacci(i);
            new Thread(fibonacci).start();
        }
    }

    @Override
    public void run() {
        System.out.println(fib(n) + " ############ " + id);
    }
}
