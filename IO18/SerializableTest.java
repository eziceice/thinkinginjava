package IO18;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Ryan on 2017/3/22.
 */
public class SerializableTest {
    static class Data implements Serializable {
        private int i;

        public Data(int i) {
            this.i = i;
        }

        @Override
        public String toString() {
            return Integer.toString(i);
        }
    }


    static class SerializableData implements Serializable {
        private Data[] datas = {new Data(10), new Data(11), new Data(12)};

        @Override
        public String toString() {
            return Arrays.toString(datas);
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(new SerializableTest.SerializableData());
        out.writeObject("this is a test");
        out.close();

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        System.out.println(in.readObject());
        System.out.println(in.readObject());
        in.close();

    }
}
