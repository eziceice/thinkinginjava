package Chapter16;

import java.util.Arrays;

/**
 * Created by Ryan on 2017/2/22.
 */
public class ArrayTest {
    public void getArray(int[] ints) {
        System.out.println(ints.toString());
    }
    public String[] getStringArray(int n) {
        String[] strings = new String[n];
        for (int i = 0; i < strings.length ; i++) {
            strings[i] = i + "!";
        }

        return strings;
    }

    public int[][] getIntArray(int a, int b) {
        int[][] ints = new int[a][];
        for (int i = 0; i < a; i++) {
            ints[i] = new int[b];
            for(int j = 0; j < b; j++) {
                ints[i][j] = i*j;
            }
        }

        return ints;
    }

    public void printArray(int[][]...ints) {
        System.out.println(Arrays.deepToString(ints));
    }

    /**
    public void printArray(int[][][]... ints) {
        System.out.println(Arrays.deepToString(ints));
    }
     */

    public int[][][] getTripleArray(int a, int b,int c) {
        int[][][] ints = new int[a][][];
        for (int i = 0; i < a; i++) {
            ints[i] = new int[b][];
            for(int j = 0; j < b; j++) {
                ints[i][j] = new int[c];
                for(int n = 0; n < c; n++) {
                    ints[i][j][n] = i*j*n;
                }
            }

        }

        return ints;
    }


    public void testDoubleArray() {
        int[][] a = new int[5][6];
        for (int i = 0; i < a.length ; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = i * j;
            }
        }
        System.out.println(Arrays.deepToString(a));
    }


    public static void main(String[] args) {

        ArrayTest arrayTest = new ArrayTest();
        /**
        arrayTest.getArray(new int[] {1,2,3,4,5});
        int[] ints = {1,2,3,4,5};
        int[] ints1 = new int[10];
        arrayTest.getArray(ints);
        arrayTest.getArray(ints1);


        Arrays.toString(arrayTest.getStringArray(10));

        String[][] strings = {
                {"1","2","3",},{"4","5","6"},{"7"}
        };
        System.out.println(Arrays.deepToString(strings));
         */
        arrayTest.printArray(arrayTest.getIntArray(5,6));
        arrayTest.printArray(arrayTest.getTripleArray(5,6,7));

        arrayTest.testDoubleArray();

        String[] a = {"a","b","c","d","e"};
        String[] b = {"e","f", "g", "h", "k"};

        System.arraycopy(a, 1,b,1,4);
        System.out.println(b[0] + b[1] + b[2] + b[3] + b[4]);

    }
}
