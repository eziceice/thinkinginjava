package Chapter7;

import java.util.Random;

/**
 * Created by Ryan on 2017/1/23.
 */
public class Final {
    static Random random = new Random();
    private static final int INT = random.nextInt();
    private final int integer = random.nextInt();



    public static void main(String[] args) {
        Final f = new Final();
        Final z = new Final();
        System.out.println(f.INT);
        System.out.println(z.INT);

        System.out.println(f.integer);
        System.out.println(z.integer);
    }
}
