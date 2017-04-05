package Polymorphism8;

/**
 * Created by Ryan on 2017/1/25.
 */
public class Gerbil extends Rodent{


    @Override
    public void eat() {
        System.out.println("Gerbil eat");
    }

    @Override
    public void run() {
        System.out.println("Gerbil run");
    }
}
