package Chapter18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Ryan on 2017/3/21.
 */
public class DoubleBufferDemo {
    private static final int SIZE = 1024;

    public static void main(String[] args) throws FileNotFoundException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(SIZE);
        DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
        doubleBuffer.put(new double[]{2.31,3.5,7.6,8.8,9.0,10.3,11111.3});
        doubleBuffer.put(4,12.3);
        doubleBuffer.flip();
        while (doubleBuffer.hasRemaining()) {
            System.out.println(doubleBuffer.get());
        }

        FileChannel fileChannel = new RandomAccessFile("tst","rw").getChannel();
    }
}
