package String13;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ryan on 2017/2/12.
 */
public class Splitting {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";
    public static void spilt(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }


    public static void main(String[] args) {
        System.out.println(knights.matches("^[A-Z].*[\\!]$"));
        spilt("the|you");
        System.out.println(knights.replaceAll("a|e|i|o|u", "_"));
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher s = pattern.matcher(knights);
        while (s.find()) {
            System.out.println(s.group());
        }
    }
}
