package Chapter17;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ryan on 2017/3/19.
 */
public class SortTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        SortTest sortTest = new SortTest();
        Random random = new Random(47);
        for (int i = 0; i < 10000000 ; i++) {
            int a = random.nextInt(1000);
            arrayList.add(a);
            linkedList.add(a);
        }
        sortTest.sort(arrayList);
        System.out.println("---------------------------");
        sortTest.sort(linkedList);

    }

    public void sort(List<Integer> list) {
        Long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);
        Collections.sort(list);
        Long afterTime = System.currentTimeMillis();
        System.out.println(afterTime);
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(afterTime-currentTime));
    }
}
