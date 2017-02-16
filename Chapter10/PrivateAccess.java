package Chapter10;

import Chapter9.Interface1;

/**
 * Created by Ryan on 2017/2/5.
 */
public class PrivateAccess implements Interface1{
    private String s = "12345";

    private Interface1 getString() {
        boolean i = false;
        return new Interface1() {
            @Override
            public void swim() {

            }

            @Override
            public void jump() {

            }
        };
    }

    @Override
    public void swim() {

    }

    @Override
    public void jump() {

    }

    public class InsideAccess  {

        private String a = "12345678";
        public void changeString(String newS) {
            s = newS;
            System.out.print(getString());
        }
    }

    public void testString() {
        InsideAccess insideAccess = new InsideAccess();
        System.out.println(insideAccess.a);
        insideAccess.changeString("54321");
    }

    public static void main(String[] args) {
        PrivateAccess privateAccess = new PrivateAccess();
        privateAccess.testString();
    }
}
