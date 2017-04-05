package Generics15;

import org.omg.CORBA.Object;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ryan on 2017/2/17.
 */

class Building{}
class House extends Building{}

public class ClassTypeCapture<T> {
    Class<T> kind;
    Map<String, Class<T>> map;

    public void addTypes(String typename, Class<T> kind) {
        map = new HashMap<>();
        this.kind = kind;
    }


    public T creatNew(String typename) {
        try {
            return kind.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object object) {
        return kind.isInstance(object);
    }


    public static void main(String[] args) {
        ClassTypeCapture<String> ct = new ClassTypeCapture<>(String.class);

    }
}
