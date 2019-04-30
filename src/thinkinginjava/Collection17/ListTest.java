package src.thinkinginjava.Collection17;

import java.util.*;

/**
 * Created by Ryan on 2017/3/14.
 */
public class ListTest {
    public static String[][] strings = {
            {"America","DC"}, {"China", "Beijing"}, {"Canada", "Waterloo"}, {"Acountry", "Capital"}
    };
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        Random random = new Random();

        for (int i = 0; i < 5 ; i++) {
            int a = random.nextInt(strings.length);
            arrayList.add(strings[a][0]);
        }

        for (int i = 0; i < 5 ; i++) {
            int a = random.nextInt(strings.length);
            linkedList.add(strings[a][0]);
        }



        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("---------------------------");
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("---------------------------");


        ListIterator<String> listIterator = arrayList.listIterator();

        int size = linkedList.size();
        while (listIterator.hasNext()) {
            linkedList.add(size,listIterator.next());
            size = size - 1;
            if (size < 0)
                break;
        }

        System.out.println(linkedList);



    }
}
