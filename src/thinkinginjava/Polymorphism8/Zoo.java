package src.thinkinginjava.Polymorphism8;

import java.util.Random;

/**
 * Created by Ryan on 2017/1/25.
 */
public class Zoo {

    public static void main(String[] args) {

        Rodent[] rodents = new Rodent[10];
        for(int i = 0; i < rodents.length; i++) {
            rodents[i] = allocateRodent();
            eat(rodents[i]);
        }


    }

    public static void eat(Rodent r) {
        r.eat();
    }


    public static Rodent allocateRodent() {
        Random random = new Random();
        switch (random.nextInt(2)) {
            case 0:
                return new Mouse();
            case 1:
                return new Gerbil();
        }
        return null;
    }
}
