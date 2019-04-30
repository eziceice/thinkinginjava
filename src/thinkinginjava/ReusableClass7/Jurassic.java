package src.thinkinginjava.ReusableClass7;

/**
 * Created by Ryan on 2017/1/23.
 */
public class Jurassic {

    public static void main(String[] args) {
        Dinosaur dinosaur = new Dinosaur();
        dinosaur.i = 40;
        dinosaur.j++;
        System.out.print(dinosaur.i + " " + dinosaur.j);
    }
}
