package src.thinkinginjava.IO18;

import org.omg.CORBA.Object;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Ryan on 2017/3/20.
 */
public class PPrint {
    public static String pformat(Collection<?> c) {
        if (c.size() == 0) return "[]";

        StringBuilder result = new StringBuilder("[");
        for (java.lang.Object element : c) {
            if (c.size() != 1)
                result.append("\n ");
            result.append(element);
        }

        if (c.size() != 1) {
            result.append("\n");
        }
        result.append("]");
        return result.toString();
    }

    public static void pprint(Collection<?> c) {
        System.out.println(pformat(c));
    }

    public static void pprint(Object[] c) {
        System.out.println(pformat(Arrays.asList(c)));
    }
}
