package Generics15;
import java.util.EnumSet;


/**
 * Created by Ryan on 2017/2/16.
 */
public class Sets {
    public static <T extends Enum<T>> EnumSet<T> union(EnumSet<T> a, EnumSet<T> b) {
        EnumSet<T> c = a.clone();
        c.addAll(b);
        return c;
    }


    public static void main(String[] args) {
        EnumSet<Watercolores> wc = EnumSet.range(Watercolores.ZINC,Watercolores.BLACK);
        EnumSet<Watercolores> wd = EnumSet.range(Watercolores.LEMON,Watercolores.ORANGE);
        System.out.println(Sets.union(wc,wd));
    }
}
