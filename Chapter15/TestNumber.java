package Chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 2017/2/17.
 */
public class TestNumber {
    public static void main(String[] args) {
        Number[] numbers = new Integer[10];
        numbers[0] = 10;
        numbers[1] = 30;


        List<? extends Number> list = new ArrayList<Long>();
        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(0.5);
        doubles.add(0.3);
        list = doubles;

        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
}
