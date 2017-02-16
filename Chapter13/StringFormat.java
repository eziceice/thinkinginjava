package Chapter13;

/**
 * Created by Ryan on 2017/2/12.
 */
public class StringFormat {
    private static int a = 10;
    private static long b = 2L;
    private static float c = 2.35F;
    private static double d = 2.77D;


    public static void main(String[] args) {
        System.out.println(String.format("Integer: %d, Long: %d, Float: %f, Double: %f",a,b,c,d).toString());
    }
}
