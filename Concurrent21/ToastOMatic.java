package Concurrent21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ryan on 2017/3/30.
 */
public class ToastOMatic {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue
                toastQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                peanutQueue = new ToastQueue(),
                jellyQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Toaster(toastQueue));
        executorService.execute(new Butterer(toastQueue,butteredQueue));
        executorService.execute(new Jammer(butteredQueue,finishedQueue));
        /**
        executorService.execute(new PeanutButter(toastQueue,peanutQueue));
        executorService.execute(new Jelly(peanutQueue,jellyQueue));
         */
        executorService.execute(new Eater(finishedQueue));

        TimeUnit.MILLISECONDS.sleep(50);

    }
}

class Toast {
    public enum Status { DRY, BUTTERED, JAMED, PEANUTBUTTERED, JELLY }
    private Status status = Status.DRY;
    private final int id;

    public Toast(int id) {
        this.id = id;
    }

    public void butter() {
        status = Status.BUTTERED;
    }

    public void jam() {
        status = Status.JAMED;
    }

    public void peannutButter() {
        status = Status.PEANUTBUTTERED;
    }

    public void jelly() {
        status = Status.JELLY;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast " + id + ": " + status;
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast> {
}

class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);

                Toast t = new Toast(count++);
                System.out.println(t);
                toastQueue.put(t);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Butterer implements Runnable {
    private ToastQueue toastQueue;
    private ToastQueue butteredQueue;

    public Butterer(ToastQueue toastQueue, ToastQueue butteredQueue) {
        this.toastQueue = toastQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = toastQueue.take();
                t.butter();
                System.out.println(t);
                butteredQueue.put(t);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Jammer implements Runnable {
    private ToastQueue butteredQueue;
    private ToastQueue finishedQueue;

    public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = butteredQueue.take();
                t.jam();
                System.out.println(t);
                finishedQueue.put(t);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int count = 0;
    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = finishedQueue.take();
                if (t.getId() != count++ || t.getStatus() != Toast.Status.JAMED) {
                    System.out.println("Error: " + t);
                    System.exit(1);
                } else
                    System.out.println("Cheers! Good " + t);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class PeanutButter implements Runnable {
    private ToastQueue toastQueue;
    private ToastQueue peanutButterQueue;

    public PeanutButter(ToastQueue toastQueue, ToastQueue peanutButterQueue) {
        this.toastQueue = toastQueue;
        this.peanutButterQueue = peanutButterQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = toastQueue.take();
                t.peannutButter();
                System.out.println(t);
                peanutButterQueue.put(t);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Jelly implements Runnable {
    private ToastQueue peannutButterQueue;
    private ToastQueue jellyQueue;

    public Jelly(ToastQueue peannutButterQueue, ToastQueue jellyQueue) {
        this.peannutButterQueue = peannutButterQueue;
        this.jellyQueue = jellyQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = peannutButterQueue.take();
                t.jelly();
                System.out.println(t);
                jellyQueue.put(t);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
