package Chapter18;

import java.io.*;

/**
 * Created by Ryan on 2017/3/22.
 */
public class Blip3 implements Externalizable {
    private String s;
    private int i;

    public Blip3(String s, int i) {
        this.s = s;
        this.i = i;
    }

    public Blip3() {
        System.out.println("haha");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        s = (String) in.readObject();
        i = in.readInt();
    }

    @Override
    public String toString() {
        return s + i;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Blip3 blip3 = new Blip3("String", 4);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./res/out.txt"));
        out.writeObject(blip3);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("./res/out.txt"));
        Blip3 blip31 = (Blip3) in.readObject();
        System.out.println(blip31);
        in.close();
    }
}
