package src.thinkinginjava.Concurrent21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ryan on 2017/3/26.
 */
public class SleepThread implements Runnable {
    private static int count = 1;
    private final int id = count++;

    @Override
    public void run() {
        Random random = new Random();
        int sleepTime = random.nextInt(10);
        System.out.println(id + " ####### " + sleepTime);
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10 ; i++) {
            executorService.execute(new SleepThread());
        }

        executorService.shutdown();
    }
}
