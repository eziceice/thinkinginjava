package Generics15;

/**
 * Created by Ryan on 2017/2/17.
 */
public class LittleFish {
    private static long counter = 1;
    private final long id = counter++;

    private LittleFish() {
    }

    public static Generator<LittleFish> generator = new Generator<LittleFish>() {
        @Override
        public LittleFish next() {
            return new LittleFish();
        }
    };

    @Override
    public String toString() {
        return "LittleFish" + id;
    }
}
