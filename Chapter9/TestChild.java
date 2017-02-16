package Chapter9;

/**
 * Created by Ryan on 2017/2/4.
 */
public class TestChild implements TestParent {
    public void print() {
        System.out.print(System.currentTimeMillis());
    }


    public static void main(TestString[] args) {
        TestChild t = new TestChild();
        run(t);
    }

    public static void run(TestParent t) {
    }
}
