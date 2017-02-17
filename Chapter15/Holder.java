package Chapter15;

/**
 * Created by Ryan on 2017/2/16.
 */
public class Holder<T,A,B> {
    private T t;
    private A a;
    private B b;

    public Holder(T t, A a, B b) {
        this.t = t;
        this.a = a;
        this.b = b;
    }


    public <D,F> void f(D d, String e, F f) {
        System.out.println(d + "," + e +
                "," + f);
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }


    public static void main(String[] args) {
        Holder<String,Integer,String> holder = new Holder<>("Test", 12, "Yep");
        System.out.println(holder.getA() + " " + holder.getB() + " " + holder.getT());

        holder.f("test", "gg", 200);
    }
}
