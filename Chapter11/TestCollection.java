package Chapter11;

import Chapter9.Interface1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ryan on 2017/2/6.
 */
public class TestCollection {

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(21);
        //System.out.print(collection.size());
        //System.out.print(1235);
        ArrayList<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);


        for(Integer a: s) {
            System.out.println(a);
        }

        List<Integer> d = s.subList(0,2);

        for(Integer a: d) {
            System.out.print(a + " ");
        }

        s.removeAll(d);

        for(Integer a: s) {
            System.out.println("ddddd" + a);
        }

    }
}
