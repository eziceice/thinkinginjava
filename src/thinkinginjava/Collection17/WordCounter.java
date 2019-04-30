package src.thinkinginjava.Collection17;

import java.util.*;

/**
 * Created by Ryan on 2017/3/16.
 */
public class WordCounter {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> wordCount = new LinkedHashMap<>();
        /**
         * TreeMap can use comparator to compare the key value
        Map<src.thinkinginjava.String13,Integer> map = new TreeMap<>(new Comparator<src.thinkinginjava.String13>() {
            @Override
            public int compare(src.thinkinginjava.String13 o1, src.thinkinginjava.String13 o2) {
                return 0;
            }
        });
         */
        String[] strings = ("this is a test for the word count no matter how many times the word appear it will show the " +
                "number of times the word this is a test for the world melbourne carnegie java online test program test").split(" ");
        for (int i = 0; i < strings.length ; i++) {
            if (wordCount.containsKey(strings[i])) {
                wordCount.put(strings[i],wordCount.get(strings[i]) + 1);
            } else {
                wordCount.put(strings[i],1);
            }
        }

        /**
         * sort the set based on the key value
         * Put it into a List and using Collections.sort()
         */


        ArrayList<Map.Entry<String,Integer>> arrayList = new ArrayList<>(wordCount.entrySet());
        Collections.sort(arrayList, (o1, o2) -> {
            if (o1.getValue().equals(o2.getValue()))
                return 0;
            else
                if (o1.getValue() > o2.getValue())
                    return -1;
                else
                    return 1;
        });

        System.out.println(arrayList);
        System.out.println(wordCount.entrySet());
        wordCount.keySet().iterator().next();
    }
}
