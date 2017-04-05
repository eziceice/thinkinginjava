package InnerClass10;

/**
 * Created by Ryan on 2017/2/5.
 */
public class B {
    private U[] u = new U[5];
    public void saveU(U utem, int i) {
        u[i] = utem;
    }
    public void setU() {
        u = null;
    }
    public void print() {
        for(U allu: u) {
            System.out.print(allu);
        }
    }


    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        b.saveU(a.test(), 0);
        b.saveU(a.test(), 1);
        b.saveU(a.test(), 2);
        b.saveU(a.test(), 3);
        b.saveU(a.test(), 4);

        b.print();
        b.setU();
        b.print();
    }
}
