package Chapter17;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ryan on 2017/3/19.
 */
public class FakeListString{
    private String[] strings;
    private int index = 0;

    public FakeListString() {
        strings = new String[100];
    }

    public void add(String s) {
        if (index >= strings.length) {
            String[] newString = new String[index*2];
            System.arraycopy(strings,0,newString,0,index);
        } else {
            strings[index] = s;
            index++;
        }
    }

    public String get(int i) {
        if(i < strings.length && i > 0)
            return strings[i];
        return "Error";
    }


    public static void main(String[] args) {
        FakeListString fakeListString = new FakeListString();
        ArrayList<String> arrayList = new ArrayList<>();
        Long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);
        for (int i = 0; i < 10000; i++) {
            fakeListString.add("a");
        }
        Long afterTime = System.currentTimeMillis();
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(afterTime-currentTime));
        System.out.println(afterTime);
        System.out.println("------------------------------");
        currentTime = System.currentTimeMillis();
        System.out.println(currentTime);
        for (int i = 0; i < 10000; i++) {
            arrayList.add("a");
        }
        afterTime = System.currentTimeMillis();
        System.out.println(afterTime);
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(afterTime-currentTime));

    }
}
