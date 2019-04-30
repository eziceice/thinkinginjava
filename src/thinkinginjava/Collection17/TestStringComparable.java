package src.thinkinginjava.Collection17;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ryan on 2017/3/19.
 */
public class TestStringComparable implements Comparable<TestStringComparable> {
    private String string1;
    private String string2;
    static int id = 0;

    public TestStringComparable(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;
        id++;
    }

    @Override
    public int compareTo(TestStringComparable o) {
        return o.string1.equals(string1)? 0:(o.string1.charAt(0) > string1.charAt(0) ? -1:1);
    }

    @Override
    public String toString() {
        return string1.toString();
    }

    @Override
    public int hashCode() {
        return string1.hashCode() + id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TestStringComparable &&
                ((TestStringComparable) obj).string1.equals(string1) &&
                ((TestStringComparable) obj).string2.equals(string2);
    }

    public static void main(String[] args) {
        ArrayList<TestStringComparable> arrayList = new ArrayList<>();
        TestStringComparable testStringComparable1 = new TestStringComparable("A","B");
        TestStringComparable testStringComparable2 = new TestStringComparable("C","B");
        TestStringComparable testStringComparable3 = new TestStringComparable("B","B");
        TestStringComparable testStringComparable4 = new TestStringComparable("B","B");
        TestStringComparable testStringComparable5 = new TestStringComparable("a","B");
        TestStringComparable testStringComparable6 = new TestStringComparable("b","B");


        arrayList.add(testStringComparable1);
        arrayList.add(testStringComparable2);
        arrayList.add(testStringComparable3);
        arrayList.add(testStringComparable4);
        arrayList.add(testStringComparable5);
        arrayList.add(testStringComparable6);


        Collections.sort(arrayList);
        System.out.println(arrayList);

        System.out.println(Collections.binarySearch(arrayList,testStringComparable3));
    }
}
