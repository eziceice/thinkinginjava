package src.thinkinginjava.IO18;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by Ryan on 2017/3/20.
 */
public class ReadfromTxt {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/thinkinginjava/res/test.txt"));
            LinkedList<String> linkedList = new LinkedList<>();
            String string;
            while ((string = br.readLine()) != null) {
                linkedList.push(string);
            }

            System.out.println(linkedList.size());

            for (String s: linkedList) {
                if (s.matches("hi.*"))
                    System.out.println(s);
            }

            int a = linkedList.size();
            for (int i = 0; i < a; i++) {
                System.out.println(linkedList.pop().toUpperCase());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String a = "this is a test";
        try {
            br = new BufferedReader(new StringReader(a));
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(
                    new FileInputStream("src/thinkinginjava/res/test.txt")));
           while (dataInputStream.available() != 0) {
               System.out.println((char) dataInputStream.readByte());
           }
            while ((a = br.readLine()) != null) {
                System.out.println(a);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
