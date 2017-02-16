package Chapter13;

/**
 * Created by Ryan on 2017/2/13.
 */
public class SplitDemo {
    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points.";
        String[] one = input.split("!!");
        String[] two = input.split("!!", 3);

        for(String s: one) {
            System.out.println(s);
        }


        for (String s: two
             ) {
            System.out.println(s);
        }
    }
}
