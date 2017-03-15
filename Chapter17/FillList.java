package Chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Ryan on 2017/3/14.
 */
public class FillList {


    public static void main(String[] args) {
        String[] strings = {"A","B","C","D","E","F","G"};
        ArrayList<String> stringArrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            int s = random.nextInt(strings.length);
            stringArrayList.add(strings[s]);
        }


        for (int i = 0; i < 30 ; i++) {
            linkedList.add(i);
        }

        Collections.sort(stringArrayList);
        Collections.sort(linkedList);

        System.out.println(stringArrayList);
        System.out.println(linkedList);


        Collections.shuffle(stringArrayList);
        Collections.shuffle(linkedList);

        System.out.println(stringArrayList);
        System.out.println(linkedList);
    }
}
