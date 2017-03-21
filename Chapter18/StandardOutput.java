package Chapter18;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ryan on 2017/3/21.
 */
public class StandardOutput {
    public static void main(String[] args) throws IOException {
       /**
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = bufferedReader.readLine()) != null && s.length() != 0)
            System.out.println(s.toUpperCase());
        */

       /**
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine())
            System.out.println(scanner.nextLine());
        */

        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println("hello");
        PrintStream printStream = System.out;
        PrintStream printStream1 = new PrintStream(new BufferedOutputStream(new FileOutputStream(".")));
        System.setOut(printStream1);

        System.setOut(printStream);

        Process process = new ProcessBuilder("").start();
        process.getInputStream();
        process.getOutputStream();
        process.getErrorStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s;
        List<String> list = new ArrayList<>();
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
            list.add(s);
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
    }
}
