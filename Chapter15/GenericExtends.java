package Chapter15;

/**
 * Created by Ryan on 2017/2/17.
 */

interface test1{
    void run();
}

interface test2{
    void jump();
}




public class GenericExtends<T> implements test1,test2 {
    T t;
    Class<T> type;

    public GenericExtends(Class<T> type) {
        this.type = type;
    }

    private T getT() {
        try {
            t = type.newInstance();
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T extends test1> void getTest1(T t) {
        t.run();
        System.out.println("!");
    }

    public <T extends test2> void getTest2(T t) {
        t.jump();
        System.out.println("@");
    }

    @Override
    public void run() {

    }

    @Override
    public void jump() {

    }


    public static void main(String[] args) {
        GenericExtends<testString> stringGenericExtends = new GenericExtends<testString>(testString.class);
        testString t = stringGenericExtends.getT();
        stringGenericExtends.getTest1(t);
        stringGenericExtends.getTest2(t);
    }




    static class testString implements test1,test2 {

        @Override
        public void run() {

        }

        @Override
        public void jump() {

        }
    }
}
