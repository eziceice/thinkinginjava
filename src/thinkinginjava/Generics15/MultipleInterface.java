package src.thinkinginjava.Generics15;

/**
 * Created by Ryan on 2017/2/20.
 */
public class MultipleInterface {
    interface Payable<T> {}
    class Employee implements Payable {}
    class Hourly extends Employee implements Payable {}
}
