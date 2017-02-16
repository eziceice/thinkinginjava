package Chapter10;

import Chapter9.Interface1;

/**
 * Created by Ryan on 2017/2/5.
 */
public class Outer {

    private String i;

    public Outer(String string) {
        i = string;
    }

    class Inner{

        public String toString() {
            System.out.print(i);
            return i + "";
        }

    }


    public Inner getIner() {
        return new Inner();
    }


    public static void main(String[] args) {
        Outer outer = new Outer("desk");
        Outer.Inner inner = outer.new Inner();
        inner.toString();
    }


    private class InnerObject implements Interface1{

        @Override
        public void swim() {
            InnerObject innerObject = (InnerObject) getObject();
        }

        @Override
        public void jump() {

        }

        public Interface1 getObject() {
            return new InnerObject();
        }
    }
}
