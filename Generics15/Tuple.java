package Generics15;

/**
 * Created by Ryan on 2017/2/16.
 */
public class Tuple {
    public static <A,B> TwoTuple<A,B> tuple(A a, B b) {
        return new TwoTuple<A,B>(a,b);
    }


    static class TwoTuple<A,B> {
        private A a;
        private B b;
        public TwoTuple(A a, B b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + " " + b;
        }
    }

    public TwoTuple<String, Integer> twoTuple() {
        return new TwoTuple<>("yes", 5);
    }

    public TwoTuple<String, Integer> twoTupleTest() {
        return new TwoTuple("String13", 5);
    }


    public static void main(String[] args) {
        Tuple tuple = new Tuple();
        System.out.println(tuple.twoTuple());
        System.out.println(tuple.twoTupleTest());
    }
}
