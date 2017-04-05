package InnerClass10;

import Interface9.Interface3;

/**
 * Created by Ryan on 2017/2/5.
 */
public class DefaultClass2 {
    public static class InnerClass implements Interface3 {
        private int i = 10;

        @Override
        public void diving() {

        }

        @Override
        public void bite() {

        }
    }

    public static Interface3 getInterface() {
        return new InnerClass();
    }

    public static void main(String[] args) {
        Interface3 interface3 = getInterface();
    }
}
