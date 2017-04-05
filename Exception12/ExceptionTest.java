package Exception12;

/**
 * Created by Ryan on 2017/2/8.
 */
public class ExceptionTest extends Exception {
    private String error;
    public ExceptionTest(String s){
        error = s;
    }
    public void print() {
        System.out.println(error);
    }


    public static void main(String[] args) {
        try {
            throw new ExceptionTest("This is a test");
        } catch (ExceptionTest e) {
            e.print();
        }

        int i = 1;



        while(i != 100) {
            try{
                i = i + 1;
                throw new Exception();
            } catch (Exception e) {
                i = i + 2;
            }
            System.out.println(i);
        }

        System.out.println("finish");

    }
}
