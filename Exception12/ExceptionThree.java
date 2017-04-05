package Exception12;

/**
 * Created by Ryan on 2017/2/9.
 */
public class ExceptionThree extends Exception {

    public static void getException() throws ExceptionOne,ExceptionTwo,ExceptionThree {
        int a = 0;

        if(a == 0) {
            throw new ExceptionOne();
        }
        if(a == 1) {
            throw new ExceptionTwo();
        }
        if(a == 2) {
            throw new ExceptionThree();
        }
    }

    public static void main(String[] args) {
        try{
            getException();
        } catch (Exception e){
            //System.err.print(e);
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        }

    }
}
