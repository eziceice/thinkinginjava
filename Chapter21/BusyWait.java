package Chapter21;

import Chapter10.E;

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

    public synchronized void setFlag(boolean flag) {
        this.flag = flag;
    }

    public synchronized boolean isFlag() {
        return flag;
    }
}

class TaskA implements Runnable {
    BusyWait busyWait;

    public TaskA(BusyWait busyWait) {
        this.busyWait = busyWait;
    }

    @Override
    public void run() {
        synchronized (busyWait) {
            try {
                Thread.sleep(5000);
                busyWait.setFlag(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        while (busyWait.isFlag()) {
            System.out.println("enter in while loop");
            busyWait.setFlag(false);
            System.out.println("hahahahaha");
        }
    }
}
