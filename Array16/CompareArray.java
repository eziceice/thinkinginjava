package Array16;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Ryan on 2017/2/22.
 */
public class CompareArray implements Comparator<CompareArray>, Comparable<CompareArray> {
    public int a;

    public CompareArray(int a) {
        this.a = a;
    }

    @Override
    public int compare(CompareArray o1, CompareArray o2) {
        return o1.a < o2.a? -1 : (o1.a == o2.a ? 0 : 1);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CompareArray))
            return false;
        else {
            return a ==  ((CompareArray)obj).a;
        }
    }

    public static void main(String[] args) {
        CompareArray[] a = new CompareArray[5];
        CompareArray b = new CompareArray(5);
        Arrays.fill(a, b);
        CompareArray[] c = new CompareArray[5];
        Arrays.fill(c, new CompareArray(5));
        System.out.println(Arrays.equals(a,c));
        Arrays.fill(c, b);
        System.out.println(Arrays.equals(a,c));




    }

    @Override
    public int compareTo(CompareArray o) {
        return o.a > a ? -1 : (o.a == a ? 0 : 1);
    }
}
