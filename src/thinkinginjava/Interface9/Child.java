package src.thinkinginjava.Interface9;

/**
 * Created by Ryan on 2017/2/4.
 */
public class Child extends Parent{

    private int i = 1;

    public void print() {
        i = 10;
        System.out.println(i);
    }


    public static void main(TestString[] args) {
        Child c = new Child();
        c.print();
    }
}
