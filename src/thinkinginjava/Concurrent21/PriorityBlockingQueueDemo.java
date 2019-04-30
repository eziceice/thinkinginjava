package src.thinkinginjava.Concurrent21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ryan on 2017/3/31.
 */
public class PriorityBlockingQueueDemo {
}

class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {
    private Random random = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    protected static List<PrioritizedTask> sequence = new ArrayList<>();

    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(250));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this);
    }

    @Override
    public int compareTo(PrioritizedTask o) {
        return priority < o.priority? 1: (priority > o.priority? -1 : 0);
    }

    @Override
    public String toString() {
        return String.format("[%1$-3d]",priority) + " Task" + id;
    }

    public String summary() {
        return "(" + id + ":" + priority + ")";
    }
}

