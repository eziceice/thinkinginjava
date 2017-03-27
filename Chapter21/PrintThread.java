package Chapter21;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ryan on 2017/3/26.
 */
public class PrintThread implements Runnable {
    private final int id = count++;
    private static int count = 0;
    private int countDown = 20;



    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(id + ", " + countDown + ".");
            Thread.yield();
        }
        return;
    }


    public static void main(String[] args) {
        /** Normal new Thread
        for (int i = 0; i < 10; i++) {
            new Thread(new PrintThread()).start();
        }
         */


        /**
         * Using ExecutorService and newCachedThreadPool
         *
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new PrintThread());
        }
        executorService.shutdown();
         */

        /**
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5 ; i++) {
            executorService.execute(new PrintThread());
        }
        executorService.shutdown();
         */
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5 ; i++) {
            executorService.execute(new PrintThread());
        }
        executorService.shutdown();
    }
}
