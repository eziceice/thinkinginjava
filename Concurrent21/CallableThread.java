package Concurrent21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Ryan on 2017/3/26.
 */
public class CallableThread implements Callable<String> {
    private static int count = 1;
    private final int id = count++;
    @Override
    public String call() throws Exception {
        return "This is a CallableThread ########### " + id;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<String>> strings = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10 ; i++) {
            strings.add(executorService.submit(new CallableThread()));
        }

        for (Future<String> s : strings) {
            if (s.isDone()) {
                System.out.println(s.get());
            }
        }

        executorService.shutdown();
    }
}
