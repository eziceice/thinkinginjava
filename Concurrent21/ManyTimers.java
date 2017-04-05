package Concurrent21;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Ryan on 2017/3/27.
 */
public class ManyTimers {
    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            int finalI = i;
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(finalI);
                }
            },5);
        }
    }
}
