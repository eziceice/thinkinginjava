package Concurrent21;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ryan on 2017/3/29.
 */
public class WaxAndMatic {
    private boolean waxOn = false;
    public synchronized void waxed() {
        waxOn = true;
        notify();
    }

    public synchronized void buffed() {
        waxOn = false;
        notify();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (!waxOn)
            wait();
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn)
            wait();
    }

    public static void main(String[] args) throws InterruptedException {
        WaxAndMatic waxAndMatic = new WaxAndMatic();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new WaxOn(waxAndMatic));
        executorService.execute(new WaxOff(waxAndMatic));
        TimeUnit.MILLISECONDS.sleep(3000);
        executorService.shutdownNow();
    }
}

class WaxOn implements Runnable {
    private WaxAndMatic waxAndMatic;

    public WaxOn(WaxAndMatic waxAndMatic) {
        this.waxAndMatic = waxAndMatic;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax On!");
                TimeUnit.MILLISECONDS.sleep(200);
                waxAndMatic.waxed();
                waxAndMatic.waitForBuffing();
            }
        } catch (Exception e) {
            System.out.println();
        }
    }
}


class WaxOff implements Runnable {
    private WaxAndMatic waxAndMatic;

    public WaxOff(WaxAndMatic waxAndMatic) {
        this.waxAndMatic = waxAndMatic;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                waxAndMatic.waitForWaxing();
                System.out.println("Wax Off!");
                TimeUnit.MILLISECONDS.sleep(200);
                waxAndMatic.buffed();
            }
        } catch (Exception e) {
            System.out.println();
        }
    }
}
