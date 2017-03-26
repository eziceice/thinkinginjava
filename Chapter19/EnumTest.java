package Chapter19;

import com.sun.beans.util.Cache;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 2017/3/23.
 */
public class EnumTest {
    public enum Kinds {BIG, HUGE, SMALL, LARGE}

    public enum Dir {
        West("West"),
        East("East"),
        South("South"),
        North("North");
        private String s;
        private Dir(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toUpperCase();
        }
    }

    public static void main(String[] args) {
        /**
        for (Kinds kinds : Kinds.values()) {
            System.out.println(kinds);
        }

        System.out.println(Kinds.valueOf(Kinds.class, "SMALL"));

        System.out.println(Dir.West);
         */
        Method[] methods = Kinds.class.getMethods();
        List<Method> list = new ArrayList<>();
        for (Method m : methods) {
            System.out.println(m.getName());
            list.add(m);
        }

        System.out.println("--------------------");
        Class e = Enum.class;
        List<Method> list1 = new ArrayList<>();
        methods = e.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
            list1.add(m);
        }

        list.removeAll(list1);
        for (Method m : list) {
            System.out.println(m);
        }



    }
}
