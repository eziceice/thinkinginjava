package IO18;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Ryan on 2017/3/21.
 */
public class GZIPTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./res/test.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                new GZIPOutputStream(new FileOutputStream("./res/test.gz"))));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            bufferedWriter.write(s);
        }
        bufferedReader.close();
        bufferedWriter.close();

        bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(
                new FileInputStream("./res/test.gz")
        )));

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new GZIPInputStream(
                new FileInputStream("./res/test.gz")));

        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }

    }
}
