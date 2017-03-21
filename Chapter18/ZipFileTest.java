package Chapter18;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * Created by Ryan on 2017/3/21.
 */
public class ZipFileTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./res/ZipTest.zip");
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new Adler32());
        ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(zipOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        zipOutputStream.setComment("This is a test for Java I/O");

        BufferedReader bufferedReader = new BufferedReader(new FileReader("./res/write.txt"));
        String s;
        int c = 0;
        while ((s = bufferedReader.readLine()) != null) {
            zipOutputStream.putNextEntry(new ZipEntry(s));
            bufferedWriter.write(s);
        }
        bufferedReader.close();
        bufferedWriter.close();


        ZipFile zip = new ZipFile("./res/ZipTest.zip");
        Enumeration e = zip.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze = (ZipEntry) e.nextElement();
            System.out.println(ze);
        }

    }
}
