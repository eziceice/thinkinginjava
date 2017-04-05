package ObjectBasicInfo11;

import java.util.*;

/**
 * Created by Ryan on 2017/2/7.
 */
public class TestPriorityQueue {


    public static void main(String[] args) {
        Random random = new Random(47);
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 100 ; i++) {
            pq.offer(random.nextDouble());
        }

        for (int i = 0; i < pq.size() ; i++) {
            System.out.println(pq.poll());
        }
    }
}
