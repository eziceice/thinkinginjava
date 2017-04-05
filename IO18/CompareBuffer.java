package IO18;

import java.io.*;

/**
 * Created by Ryan on 2017/3/21.
 */
public class CompareBuffer {
    public static void main(String[] args) {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader("./res/test.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("./res/write.txt"));
            String s;
            Long currentTime = System.currentTimeMillis();
            while ((s = bufferedReader.readLine()) != null)
                bufferedWriter.write(s + "\n");
            bufferedReader.close();
            bufferedWriter.close();
            Long afterTime = System.currentTimeMillis();
            System.out.println(afterTime - currentTime);

            bufferedReader = new BufferedReader(new FileReader("./res/test.txt"));
            fileWriter = new FileWriter("./res/write1.txt");
            currentTime = System.currentTimeMillis();
            while ((s = bufferedReader.readLine()) != null)
                fileWriter.write(s + "\n");
            bufferedReader.close();
            fileWriter.close();
            afterTime = System.currentTimeMillis();
            System.out.println(afterTime - currentTime);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
