package Generics15;

/**
 * Created by Ryan on 2017/2/16.
 */
public class Holder<T> {
    private T t;

    public Holder(T t) {
        this.t = t;
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




    public static void main(String[] args) {
        Holder<String> holder = new Holder<>("Test");
        System.out.println(holder.getT());

        holder.f("test", "gg", 200);
    }
}
