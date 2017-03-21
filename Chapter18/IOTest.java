package Chapter18;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * Created by Ryan on 2017/3/20.
 */
public class IOTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("123");
        pattern.matcher("234").matches();

        Date date = new Date(2005,10,03);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String s = simpleDateFormat.format(date);
        System.out.println(s);
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());
    }
}
