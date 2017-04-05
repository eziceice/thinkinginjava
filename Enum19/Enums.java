package Enum19;

import java.util.Random;

/**
 * Created by Ryan on 2017/3/23.
 */
public class Enums {
    private static Random random = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> tClass) {
        return random(tClass.getEnumConstants());
    }

    public static <T> T random(T[] t) {
        return t[random.nextInt(t.length)];
    }
}
