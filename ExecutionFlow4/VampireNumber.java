package ExecutionFlow4;

import java.util.Arrays;

/**
 * Created by Ryan on 2017/1/17.
 */
public class VampireNumber {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 10; i < 100; i++) {
            for(int j = i + 1; j < 100; j++) {
                int val = i * j;
                if(val < 1000 || val > 9999) continue;

                char[] a = (String.valueOf(i) + String.valueOf(j)).toCharArray();
                char[] c = String.valueOf(val).toCharArray();

                Arrays.sort(a);
                Arrays.sort(c);

                if(Arrays.equals(a,c)) {
                    System.out.println(sum + ": " + i + ", " + j + " = " + val);
                    sum++;
                }

            }
        }

    }
}
