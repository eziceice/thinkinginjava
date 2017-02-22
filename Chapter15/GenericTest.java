package Chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 2017/2/20.
 */
public class GenericTest {
    public <T> void f(Holder<List<?>> holder) {
        List<?> list = holder.getT();
        holder.setT(list);

    }


    public static void main(String[] args) {
        GenericTest genericTest = new GenericTest();
        List<String> s = new ArrayList<>();
        Holder<List<?>> a = new Holder<List<?>>(s);
        genericTest.f(a);
    }


}
