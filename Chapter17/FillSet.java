package Chapter17;

import java.io.FileReader;
import java.util.*;

/**
 * Created by Ryan on 2017/3/14.
 */
public class FillSet {
    public static String[][] strings = {
            {"America","DC"}, {"China", "Beijing"}, {"Canada", "Waterloo"}, {"Acountry", "Capital"}, {"America","New York"}
    };


    public static void main(String[] args) {
        HashSet<String> a = new HashSet<>();
        LinkedHashSet<String> b = new LinkedHashSet<>();
        TreeSet<String> c = new TreeSet<>();


        for (int i = 0; i < strings.length; i++) {
            a.add(strings[i][0]);
            b.add(strings[i][0]);
            c.add(strings[i][0]);
        }


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        List<String> s = new ArrayList<>();

        Collection<String> d = new ArrayList<>();


    }
}
