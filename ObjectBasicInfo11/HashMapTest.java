package ObjectBasicInfo11;


import java.util.*;

/**
 * Created by Ryan on 2017/2/7.
 */
public class HashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        ArrayList<String> strings = new ArrayList<>();
        linkedHashMap.put("BCD","bcd");
        linkedHashMap.put("CDE","cde");
        linkedHashMap.put("DEF","def");
        linkedHashMap.put("ABC","ABC");

        for (String s:linkedHashMap.keySet()
             ) {
            System.out.println(linkedHashMap.get(s));
        }

        for(String s: linkedHashMap.keySet()) {
            strings.add(s);
        }

        Collections.sort(strings);

        System.out.println("**********");

        for(String s: strings) {
            linkedHashMap.replace(s,linkedHashMap.get(s));
            System.out.println(linkedHashMap.get(s));
        }


    }
}
