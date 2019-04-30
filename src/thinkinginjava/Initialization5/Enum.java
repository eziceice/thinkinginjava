package src.thinkinginjava.Initialization5;
/**
 * Created by Ryan on 2017/1/19.
 */
public class Enum {

    public enum Test{
        TEST1,TEST2,TEST3,TEST4
    }

    public static void print(Test test){
        switch (test) {
            case TEST1:
                System.out.print("TEST1");
                break;
            case TEST2:
                System.out.print("TEST2");
                break;
            case TEST3:
                System.out.print("TEST3");
                break;
            case TEST4:
                System.out.print("TEST4");
                break;
            default:
                System.out.print("out");

        }
    }


    public static void order(){
        for(Test t: Test.values()){
            System.out.println(t + " , " + t.ordinal());
        }
    }


    public static void main(String[] args){
        //print(Test.TEST1);
        order();
    }

}
