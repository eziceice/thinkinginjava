package Generics15;

/**
 * Created by Ryan on 2017/2/17.
 */
public class BigFish {
    private static long counter = 1;
    private final long id = counter++;

    private BigFish() {
    }

    @Override
    public String toString() {
        return "BigFish" + id;
    }

    public static Generator<BigFish> generator() {
        return new Generator<BigFish>() {
            @Override
            public BigFish next() {
                return new BigFish();
            }
        };
    }
}
