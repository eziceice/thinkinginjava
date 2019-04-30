package src.thinkinginjava.Interface9;

/**
 * Created by Ryan on 2017/2/4.
 */
public class TestInterface implements Interface4 {
    @Override
    public void swim() {

    }

    @Override
    public void jump() {

    }

    @Override
    public void run() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void diving() {

    }

    @Override
    public void bite() {

    }

    @Override
    public void smash() {

    }


    public void test(Interface4 interface4){
        interface4.run();
    }

    public void main(String[] args) {
        test(new TestInterface());
    }
}
