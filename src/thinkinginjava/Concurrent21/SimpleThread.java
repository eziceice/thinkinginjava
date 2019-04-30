package src.thinkinginjava.Concurrent21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ryan on 2017/3/27.
 */
public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;

    public SimpleThread() {
        super(Integer.toString(++threadCount));
        //setDaemon(true);
        start();
    }

    @Override
    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }

    @Override
    public void run() {

        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println(this);
            if(countDown-- == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /**
        for (int i = 0; i < 100; i++) {
            new SimpleThread();
        }
        */

        ExecutorService executorService = Executors.newCachedThreadPool();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread.start();
        for (int i = 0; i < 100 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    }
}
