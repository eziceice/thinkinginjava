package src.thinkinginjava.Concurrent21;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ryan on 2017/3/31.
 */
public class DeadlockingDiningPhilosophers {
    public static void main(String[] args) throws InterruptedException, IOException {
        int ponder = 5;
        if (args.length > 0)
            ponder = Integer.parseInt(args[0]);
        int size = 5;
        if (args.length > 1)
            size = Integer.parseInt(args[1]);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Chopstick[] chopsticks = new Chopstick[size];
        for (int i = 0; i < size ; i++) {
            chopsticks[i] = new Chopstick();
        }
        for (int i = 0; i < size ; i++) {
            executorService.execute(new Philosopher(chopsticks[i], chopsticks[(i+1)%size], i, ponder));
        }
        if (args.length == 3 && args[2].equals("timeout"))
            TimeUnit.SECONDS.sleep(5);
        else {
            System.out.println("Press Enter to quit");
            System.in.read();
        }
        executorService.shutdownNow();
    }
}

class Chopstick {
    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while (taken)
            wait();
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}

class Philosopher implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random random = new Random(47);

    private void pause() throws InterruptedException {
        if (ponderFactor == 0)
            return;
        TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor * 250));
    }

    public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " thinking");
                pause();
                System.out.println(this + " grabbing right");
                right.take();
                System.out.println(this + " grabbing left");
                left.take();
                System.out.println(this + " eating");
                pause();
                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }
}

class ChopstickBox {
    private int size;
    private List<Chopstick> chopsticks = new ArrayList<>();
    private Random random = new Random(47);

    public ChopstickBox(int size) {
        for (int i = 0; i < size; i++) {
            chopsticks.add(new Chopstick());
        }
    }

    public synchronized void take() throws InterruptedException {
        while (chopsticks.size() <= 1)
            wait();

        chopsticks.get(chopsticks.size() - 1);
        chopsticks.get(chopsticks.size() - 2);
        chopsticks.remove(chopsticks.size() - 1);
        chopsticks.remove(chopsticks.size() - 2);
    }

    public synchronized void drop() {
        chopsticks.add(new Chopstick());
        chopsticks.add(new Chopstick());
        notifyAll();
    }
}
