package src.thinkinginjava.Concurrent21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Ryan on 2017/3/28.
 */
public class TaskTest implements Runnable{
    ATask aTask = new ATask();
    @Override
    public void run() {
        aTask.trySleep();
    }


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> f = executorService.submit(new TaskTest());
        executorService.shutdown();
        f.cancel(true);
        /**
        Thread thread = new Thread(new TaskTest());
        thread.start();
        thread.interrupt();
         */
    }
}

class ATask {
    public void trySleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
