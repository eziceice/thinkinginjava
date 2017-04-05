package Polymorphism8;

/**
 * Created by Ryan on 2017/1/25.
 */
public class Mouse extends Rodent {
    @Override
    public void eat() {
        System.out.println("Mouse eat");
    }

    @Override
    public void run() {
        System.out.println("Mouse run");
    }
}
