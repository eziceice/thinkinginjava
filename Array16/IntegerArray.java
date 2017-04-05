package Array16;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Ryan on 2017/2/22.
 */
public class IntegerArray {
    public static void main(String[] args) {
        Integer[] integers = {3,4,6,8,1,3,2,4,5,6,7};
        Arrays.sort(integers, Comparator.reverseOrder());
        for (int i:
             integers) {
            System.out.println(i);
        }

        System.out.println(Arrays.binarySearch(integers,8,Comparator.reverseOrder()));
    }
}
