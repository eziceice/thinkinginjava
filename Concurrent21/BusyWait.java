package Concurrent21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ryan on 2017/3/28.
 */
public class BusyWait {
    public volatile boolean flag = false;
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        BusyWait busyWait = new BusyWait();
        executorService.execute(new TaskA(busyWait));
        executorService.execute(new TaskB(busyWait));
        executorService.shutdown();

    }
    public synchronized void flag() {
        flag = true;
        notifyAll();
    }

    public synchronized void waitForFlag() throws InterruptedException {
        while (!flag) {
            wait();
        }
    }
}

class TaskA implements Runnable {
    BusyWait busyWait;

    public TaskA(BusyWait busyWait) {
        this.busyWait = busyWait;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            busyWait.flag();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TaskB implements Runnable {
    BusyWait busyWait;

    public TaskB(BusyWait busyWait) {
        this.busyWait = busyWait;
    }

    @Override
    public void run() {
        try {
            busyWait.waitForFlag();
            System.out.println("Get wait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
