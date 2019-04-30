package src.thinkinginjava.Concurrent21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Ryan on 2017/3/31.
 */

class Horse implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random random = new Random(47);
    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    strides += random.nextInt(3);
                }
                barrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

    public String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < getStrides() ; i++) {
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }
}


public class HorseRace {
    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;
    public HorseRace(int nHorses, final int pause) {
        barrier = new CyclicBarrier(nHorses, () -> {
            StringBuilder s = new StringBuilder();
            for(int i = 0; i < FINISH_LINE; i++)
                s.append("=");
            System.out.println(s);
            for (Horse horse: horses)
                System.out.println(horse.tracks());
            for (Horse horse: horses) {
                if (horse.getStrides() >= FINISH_LINE) {
                    System.out.println(horse + "Won!");
                    exec.shutdownNow();
                    return;
                }
            }

            try {
                TimeUnit.MILLISECONDS.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int i = 0; i < nHorses ; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorses = 7;
        int pause = 200;
        if (args.length > 0) {
            int n = new Integer(args[0]);
            nHorses = (n > 0? n: nHorses);
        }

        if (args.length > 1) {
            int p = new Integer(args[1]);
            pause = (p > -1? p:pause);
        }
        new HorseRace(nHorses,pause);
    }
}
