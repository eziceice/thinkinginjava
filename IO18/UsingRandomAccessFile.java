package IO18;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Ryan on 2017/3/21.
 */
public class UsingRandomAccessFile {
    static String file = "./res/random.txt";
    static void display() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file,"r");
            for (int i = 0; i < 7;i++) {
                System.out.println("Value " + i + ": " + randomAccessFile.readDouble() + "\n");
            }
            System.out.println(randomAccessFile.readUTF());
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++) {
            randomAccessFile.writeDouble(i * 1.414);
        }
        randomAccessFile.writeUTF("this is a test");
        randomAccessFile.close();
        display();
        randomAccessFile = new RandomAccessFile(file,"rw");
        randomAccessFile.seek(6*8);
        randomAccessFile.writeDouble(555555.02);
        randomAccessFile.close();
        display();
    }
}
