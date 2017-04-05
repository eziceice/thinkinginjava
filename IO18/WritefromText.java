package IO18;

import java.io.*;

/**
 * Created by Ryan on 2017/3/21.
 */
public class WritefromText {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        LineNumberReader lineNumberReader = null;
        try {
            //bufferedReader = new BufferedReader(new FileReader("./res/test.txt"));
            //printWriter = new PrintWriter(new BufferedWriter(new FileWriter("./res/write.txt")));
            printWriter = new PrintWriter("./res/write.txt");
            lineNumberReader = new LineNumberReader(new BufferedReader(new FileReader("./res/test.txt")));
            String s;
            while ((s = lineNumberReader.readLine()) != null) {
                printWriter.println(lineNumberReader.getLineNumber() + ", " + s);
            }
            lineNumberReader.close();
            //bufferedReader.close();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
