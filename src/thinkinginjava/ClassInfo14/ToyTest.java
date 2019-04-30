package src.thinkinginjava.ClassInfo14;

/**
 * Created by Ryan on 2017/2/14.
 */
public class ToyTest {

    interface HasBatteries{}
    interface Waterproof{}
    interface Shoots{}




    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c = Class.forName("src.thinkinginjava.ClassInfo14.Toysheet");
        Class[] d = c.getInterfaces();
        for (Class a: d
             ) {
            System.out.println(a.getSimpleName());
        }
        Object object = c.getSuperclass().newInstance();
    }
}
