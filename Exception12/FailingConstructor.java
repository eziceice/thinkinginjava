package Exception12;

/**
 * Created by Ryan on 2017/2/9.
 */
public class FailingConstructor {
    public FailingConstructor() throws RuntimeException {
        throw new RuntimeException();
    }

    public void dispose() {
        System.out.println("Close");
    }


    public static void main(String[] args) {
        try{
            FailingConstructor fc = new FailingConstructor();
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
