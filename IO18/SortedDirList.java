package IO18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * Created by Ryan on 2017/3/20.
 */
public class SortedDirList {
    File file;
    String[] s;

    public SortedDirList(String filePath) {
        file = new File(filePath);
    }


    public String[] list() {
        s = file.list();
        return s;
    }

    public String[] list(String regex) {
        s = file.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        return s;
    }


    public static void main(String[] args) {
        SortedDirList sortedDirList = new SortedDirList(".");

        for (String s: sortedDirList.list()) {
            System.out.println(s);
        }

        for (String s: sortedDirList.list("String13")) {
            System.out.println(s);
        }

    }
}
