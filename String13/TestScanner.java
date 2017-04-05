package String13;

import java.util.Scanner;

/**
 * Created by Ryan on 2017/2/13.
 */
public class TestScanner {
    private int a;
    private long b;
    private float c;
    private double d;
    private String s;

    public TestScanner(String s) {
        this.s = s;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(long b) {
        this.b = b;
    }

    public void setC(float c) {
        this.c = c;
    }

    public void setD(double d) {
        this.d = d;
    }


    public int getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    public float getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public static void main(String[] args) {
        TestScanner ts = new TestScanner("Test Scanner");

        Scanner s = new Scanner("20,30,40,50");
        s.useDelimiter(",");
        System.out.println(s.delimiter());
        ts.setA(s.nextInt());
        ts.setB(s.nextLong());
        ts.setC(s.nextFloat());
        ts.setD(s.nextDouble());


        System.out.println(ts.getA() + ", " + ts.getB() + ", " + ts.getC() + ", " + ts.getD() + ".");
    }
}
