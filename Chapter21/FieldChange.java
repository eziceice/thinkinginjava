package Chapter21;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ryan on 2017/3/27.
 */
public class FieldChange implements Runnable {
    private IntField intField;
    public FieldChange(IntField intField) {
        this.intField = intField;
    }

    @Override
    public void run() {
        int[] c = intField.count();
        while (c[0] == 5 && c[1] == 7) {
            //System.out.println(c[0] + " ##### " + c[1]);
        }
        System.out.println("error#####################");

    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntField intField = new IntField();
        for (int i = 0; i < 10 ; i++) {
            executorService.execute(new FieldChange(intField));
        }
        executorService.shutdown();
    }

}

class IntField {
    private int a = 5;
    private int b = 7;
    public synchronized int[] count() {
        a++;
        Thread.yield();
        a--;
        Thread.yield();
        b++;
        Thread.yield();
        b--;
        Thread.yield();
        return new int[] {a,b};
    }
}

