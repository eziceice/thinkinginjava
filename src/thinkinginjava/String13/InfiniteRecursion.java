package src.thinkinginjava.String13;

/**
 * Created by Ryan on 2017/2/12.
 */
public class InfiniteRecursion {
    @Override
    public String toString() {
        return super.toString() + "\n";
    }


    public static void main(String[] args) {
        /**

        List<InfiniteRecursion> ir = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            ir.add(new InfiniteRecursion());
        }

        System.out.println(ir);
         */



        String s = "12345";
        char[] a = new char[5];
        s.getChars(0,2,a,1);
        System.out.println(a);
        String b = s.concat("12345");
        String k = b.replace('1','a');
        System.out.print(k);
    }
}
