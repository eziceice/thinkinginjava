package src.thinkinginjava.Concurrent21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ryan on 2017/3/27.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel() {
        canceled = true;
    }
    public boolean isCanceled() {
        return canceled;
    }
}

class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if(val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executorService.execute(new EvenChecker(gp,i));
        }
    }

    public static void test(IntGenerator gp) {
        test(gp,10);
    }
}

class EvenGenerator extends IntGenerator {
    private int currentValue = 0;
    @Override
    public synchronized int next() {
        currentValue++;
        currentValue++;
        return currentValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
        AtomicInteger atomicInteger = new AtomicInteger(10);
    }
}
