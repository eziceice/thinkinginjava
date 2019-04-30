package src.thinkinginjava.Collection17;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Created by Ryan on 2017/3/16.
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
        TreeMap<String,Integer> treeMap = new TreeMap<>(String::compareToIgnoreCase);
        
        String[] strings = "this is a test for the Map".split(" ");
        for (int i = 0; i < strings.length; i++) {
            hashMap.put(strings[i],i);
            linkedHashMap.put(strings[i],i);
            treeMap.put(strings[i],i);
        }
        System.out.println(hashMap.entrySet());
        System.out.println(linkedHashMap.entrySet());
        System.out.println(treeMap.entrySet());
    }
}
