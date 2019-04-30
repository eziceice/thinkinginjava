package src.thinkinginjava.Concurrent21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

/**
 * Created by Ryan on 2017/3/30.
 */
public class TestBlockingQueues {

    static void getkey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void getKey(String message) {
        System.out.println(message);
        getkey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(i));
        }
        getKey("Press 'Enter' ( " + msg + " )");
        t.interrupt();
        System.out.println("Finished " + msg + " test");
    }


    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousBlockingQueue", new SynchronousQueue<>());
        
    }
}

class LiftOff implements Runnable {
    private int i;

    public LiftOff(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("12345" + i);
    }
}


class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    public void add(LiftOff liftOff) {
        try {
            rockets.put(liftOff);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
       try {
           while (!Thread.interrupted()) {
               LiftOff rocket = rockets.take();
               rocket.run();
           }
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
}

