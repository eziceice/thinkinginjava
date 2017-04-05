package Collection17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by Ryan on 2017/3/14.
 */
public class MapSetTest {
    public static String[][] strings = {
            {"America","DC"}, {"China", "Beijing"}, {"Canada", "Waterloo"}, {"Acountry", "Capital"}
    };
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        HashSet<String> hashSet = new LinkedHashSet<>();


        for (int i = 0; i < MapSetTest.strings.length ; i++) {
            /**
             * Get First Character
            char a = MapSetTest.strings[i][0].charAt(0);
            if (a == 'A') {
                hashMap.put(strings[i][0], strings[i][1]);
                hashSet.add(strings[i][0]);
            }
             */


            /**
             * Using Regular Expression
             */
            String b = strings[i][0];
            if(b.matches("A\\w+")) {
                hashMap.put(strings[i][0], strings[i][1]);
                hashSet.add(strings[i][0]);
            }
        }

        System.out.println(hashMap.entrySet());
        System.out.println(hashSet);
    }
}
