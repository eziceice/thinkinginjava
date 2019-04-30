package src.thinkinginjava.Concurrent21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Ryan on 2017/3/27.
 */
public class CaptureUncaughtException {
    static class ExceptionThread2 implements Runnable {
        @Override
        public void run() {
            Thread t = Thread.currentThread();
            System.out.println("run() by " + t);
            System.out.println("eh = " + t.getUncaughtExceptionHandler());
            throw new RuntimeException();
        }
    }

    static class MyUnCaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("caught " + e);
        }
    }

    static class HandlerThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            System.out.println(this + "creating new Thread");
            Thread t = new Thread(r);
            System.out.println("created " + t);
            t.setUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
            System.out.println("eh = " + t.getUncaughtExceptionHandler());
            return t;
        }
    }

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread2());
        //Thread.setDefaultUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
    }
}
