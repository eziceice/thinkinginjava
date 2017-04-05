package ReusableClass7;

/**
 * Created by Ryan on 2017/1/23.
 */
public class Extend {
    private String s = "12345";
    public String toString() {
        return s;
    }


    static class Extend2 extends Extend{
        public static void main(String[] args) {
            Extend2 extend2 = new Extend2();
            System.out.print(extend2);
        }
    }
}
