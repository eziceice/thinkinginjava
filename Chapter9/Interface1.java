package Chapter9;

/**
 * Created by Ryan on 2017/2/4.
 */
public interface Interface1 {
    void swim();
    void jump();
    public static class TestClass {
        public static void see(Interface1 interface1) {
            interface1.swim();
        }
    }
}
