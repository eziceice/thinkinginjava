package Generics15;

/**
 * Created by Ryan on 2017/2/20.
 */
public class PrimitiveTypes {
    private int a = 5;
    private String s = "6";
    private double b = 7.0;
    private float c = 8.0F;
    private long l = 2L;

    public Holder<Integer> holder1 = new Holder<>(a);
    Holder<String> holder2 = new Holder<>(s);
    Holder<Double> holder3 = new Holder<>(b);
    Holder<Float> holder4 = new Holder<>(c);
    Holder<Long> holder5 = new Holder<>(l);

    public <T> void testHolder(Holder<T> holder) {
        System.out.println(holder.getT().toString());
    }


    public <T> T getHolder(Holder<T> holder) {
        return holder.getT();
    }


    public static void main(String[] args) {
        PrimitiveTypes pm = new PrimitiveTypes();
        pm.testHolder(pm.holder1);
        pm.testHolder(pm.holder2);
        pm.testHolder(pm.holder3);
        pm.testHolder(pm.holder4);
        pm.testHolder(pm.holder5);

        int a = pm.getHolder(pm.holder1);
        String b = pm.getHolder(pm.holder2);
        double c = pm.getHolder(pm.holder3);
        float d = pm.getHolder(pm.holder4);
        long e = pm.getHolder(pm.holder5);


        System.out.println(a + "," + b + "," + c + "," + d + "," + e);
    }

}
