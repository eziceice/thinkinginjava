package src.thinkinginjava.ObjectBasicInfo11;

import java.util.*;

/**
 * Created by Ryan on 2017/2/6.
 */
public class TestHash {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 100 ; i++) {
            hashMap.put(i,i);
        }

        //System.out.print(hashMap);

        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 10000 ; i++) {
            hashSet.add(new Random().nextInt(40));
        }
        System.out.println(hashSet);
    }
}
