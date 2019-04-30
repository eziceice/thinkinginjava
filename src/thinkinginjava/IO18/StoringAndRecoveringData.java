package src.thinkinginjava.IO18;

import java.io.*;

/**
 * Created by Ryan on 2017/3/21.
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) {
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;

        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("src/thinkinginjava/res/write1.txt")));
            dataOutputStream.writeDouble(3.1415926);
            dataOutputStream.writeUTF("this is a test");
            dataOutputStream.writeInt(123456);
            dataOutputStream.close();

            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("src/thinkinginjava/res/write1.txt")));
            System.out.println(dataInputStream.readDouble());
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readInt());
            dataInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
