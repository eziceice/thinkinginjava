package Chapter18;

import com.sun.corba.se.impl.io.OutputStreamHook;

import java.io.*;

/**
 * Created by Ryan on 2017/3/22.
 */
public class BlipCheck{
    static class Blip1 implements Externalizable {
        public Blip1() {
            System.out.println("Blip1Check");
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            System.out.println("Blip1.writeExternal");
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            System.out.println("Blip1.readExternal");
        }

        @Override
        public String toString() {
            return "1";
        }
    }

    static class Blip2 implements Externalizable {
        public Blip2() {
            System.out.println("Blip2Check");
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            System.out.println("Blip2.writeExternal");
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            System.out.println("Blip2.readExternal");
        }

        @Override
        public String toString() {
            return "2";
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Blip1 blip1 = new Blip1();
        Blip2 blip2 = new Blip2();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./res/out.java"));
        out.writeObject(blip1);
        out.writeObject(blip2);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("./res/out.java"));
        System.out.println(in.readObject());
        System.out.println(in.readObject());
        in.close();
    }
}
