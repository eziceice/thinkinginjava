package Generics15;

/**
 * Created by Ryan on 2017/2/20.
 */
public abstract class SelfBounded<T extends SelfBounded<T>> {
    T t;
    abstract T f(T t);

    public T g() {
        t.f(t);
        return t;
    }
}

class Test extends SelfBounded<Test> {

    @Override
    Test f(Test t) {
        return t;
    }


    public static void main(String[] args) {
        Test t = new Test();
        t.g();
    }

}
