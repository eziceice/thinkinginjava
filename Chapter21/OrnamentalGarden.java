package Chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ryan on 2017/3/28.
 */
public class OrnamentalGarden {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10 ; i++) {
            executorService.execute(new Entrance(i));
        }
        TimeUnit.MILLISECONDS.sleep(50);
        Entrance.cancel();
        executorService.shutdown();
        if(!executorService.awaitTermination(200,TimeUnit.MILLISECONDS))
            executorService.shutdownNow();
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
    }

}

class Count {
    private int count = 0;
    private Random random = new Random(47);
    public synchronized int increment() {
        int temp = count;
        if (random.nextBoolean())
            Thread.yield();
        return count = ++temp;

    }
    public synchronized int value() {
        return count;
    }
}

class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number = 0;
    private final int id;
    private static volatile boolean canceled = false;
    public static void cancel() {
        canceled = true;
    }

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                number++;
            }
            System.out.println(this + " Total: " + count.increment());
        }
    }

    public synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance e: entrances) {
            sum += e.getValue();
        }
        return sum;
    }
}
