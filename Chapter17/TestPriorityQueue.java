package Chapter17;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by Ryan on 2017/3/15.
 */
public class TestPriorityQueue implements Comparable<TestPriorityQueue> {
    Integer integer;

    public TestPriorityQueue(Integer integer) {
        this.integer = integer;
    }


    @Override
    public int compareTo(TestPriorityQueue o) {
        if(integer.equals(o.integer))
            return 0;
        else
            if(integer > o.integer)
                return 1;
            else
                return -1;
    }

    @Override
    public String toString() {
        return integer + "";
    }

    public static void main(String[] args) {
        PriorityQueue<TestPriorityQueue> priorityQueues = new PriorityQueue<>();
        List<TestPriorityQueue> list = new ArrayList<>();
        Random random = new Random(47);

        for(int i = 0; i < 10; i++) {
            int a = random.nextInt(100);
            list.add(new TestPriorityQueue(a));
            priorityQueues.add(new TestPriorityQueue(a));
        }

        while (!priorityQueues.isEmpty()) {
            System.out.println(priorityQueues.poll());
        }

        System.out.println(list);

    }
}
