package src.thinkinginjava.Concurrent21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ryan on 2017/3/28.
 */
public class WaitandNotify {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ARunnable aRunnable = new ARunnable();
        executorService.execute(aRunnable);
        executorService.execute(new BRunnable(aRunnable));
        executorService.shutdown();
    }
}

class ARunnable implements Runnable {

    @Override
    public synchronized void run() {
        try {
            wait();
            System.out.println("hahahahaha");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class BRunnable implements Runnable {
    private ARunnable aRunnable;
    public BRunnable(ARunnable aRunnable) {
        this.aRunnable = aRunnable;
    }

    @Override
    public void run() {
        try {
            synchronized (aRunnable) {
                Thread.sleep(5000);
                aRunnable.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
