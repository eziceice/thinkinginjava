package Chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ryan on 2017/2/12.
 */
public class Regex {
    public static void main(String[] args) {
        //match("[^Java]");
        //match("\\B[reg.]*");
        //match("[n.w\\s+h(a|i)s]");
        //match("[s]?");
        //match("[s]*");
        //match("[s]+");
        //match("[s]{2}");
        //match("[s]{0,3}");
        //match("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
        //match("((^[^A-Z])|(\\s+[^A-Z]))\\w+?\\b");



    }


    public static void match(String regex) {
        //String s = "Java now has regular expressions";
        String s = "Arline ate eight apples and one orange while Anita hadn't any";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.print(m.group() + " " + m.start() + " " + (m.end() - 1) + "\n");
        }
    }
}
