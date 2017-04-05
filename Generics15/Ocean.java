package Generics15;

import java.util.*;

/**
 * Created by Ryan on 2017/2/17.
 */
public class Ocean {
    public static void eat(BigFish b, LittleFish l) {
        System.out.println(b + " eats " + l);
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Queue<LittleFish> queue = new LinkedList<>();
        Generators.fill(queue, LittleFish.generator, 20);
        List<BigFish> list = new ArrayList<>();
        Generators.fill(list, BigFish.generator(), 4);

        for (LittleFish l:queue) {
            eat(list.get(Random.class.newInstance().nextInt(list.size())),l);
        }
    }
}
