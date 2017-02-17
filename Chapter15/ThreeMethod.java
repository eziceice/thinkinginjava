package Chapter15;

/**
 * Created by Ryan on 2017/2/17.
 */
public class ThreeMethod implements TwoMethod {
    @Override
    public void g() {
        System.out.println("g()");
    }

    @Override
    public void f() {
        System.out.println("f()");
    }


    public void b() {
        System.out.println("b()");
    }


    public <T extends TwoMethod> void getb(T t) {
        t.g();
        t.f();
    }


    public static void main(String[] args) {
        ThreeMethod tm = new ThreeMethod();
        tm.getb(tm);
    }
}
