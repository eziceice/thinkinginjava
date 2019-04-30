package src.thinkinginjava.InnerClass10;

/**
 * Created by Ryan on 2017/2/5.
 */
public class A {
    public U test() {
        return new U() {
            @Override
            public void swim() {

            }

            @Override
            public void fly() {

            }

            @Override
            public void jump() {

            }
        };
    }
}
