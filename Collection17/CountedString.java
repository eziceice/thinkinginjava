package Collection17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ryan on 2017/3/19.
 */
public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;
    private char c;

    public CountedString(String s, char c) {
        this.s = s;
        this.c = c;
        created.add(s);
        for (String s1:created) {
            if (s1.equals(s))
                id++;
        }
    }

    public CountedString(String s) {
        this.s = s;
        created.add(s);
        for (String s1:created) {
            if (s1.equals(s))
                id++;
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        /**
        result = 37 * result + id;
        result = 37 * result + (int) c;
         */
        return result;
    }

    @Override
    public String toString() {
        return "String13: " + s + "id: " + id + " hashCode(): " + hashCode() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CountedString &&
                s.equals(((CountedString) obj).s) &&
                id == ((CountedString)obj).id;
    }


    public static void main(String[] args) {
        HashMap<CountedString, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 10 ; i++) {
            CountedString cs = new CountedString("hello");
            hashMap.put(cs,i);
        }

        System.out.println(hashMap);
        System.out.println(hashMap.size());
    }
}
