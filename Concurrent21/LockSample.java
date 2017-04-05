package Concurrent21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ryan on 2017/3/27.
 */
public class LockSample {
    Lock lock = new ReentrantLock();
    int i = 10;
    public int print() {
        /**
        Object object = new Object();
        synchronized (object) {
            while (true) {

            }
        }
         */
        lock.lock();
        try {
            return i++;
        } finally {

        }
    }


    public synchronized void set() {
        /**
        synchronized (this) {
            System.out.println("haha222222222");
        }
         */
        System.out.println("haha222222222");
    }


    public synchronized void setPrint() {
        /**
        synchronized (this) {
            System.out.println("haha3333333333");
        }
         */
        System.out.println("haha3333333333");
    }

    public static void main(String[] args) {
        LockSample lockSample = new LockSample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(lockSample.print());
                }
            });
        }
    }
}

