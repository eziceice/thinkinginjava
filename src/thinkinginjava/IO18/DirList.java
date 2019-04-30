package src.thinkinginjava.IO18;


import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by Ryan on 2017/3/20.
 */
public class DirList {
    public static void main(String[] args) {
        int count = 0;
        File path = new File(".");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });

        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String s:list) {
            System.out.println(s);
            count++;
        }

        System.out.println(count);

    }
}
