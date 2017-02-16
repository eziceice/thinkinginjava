package Chapter4;

/**
 * Created by Ryan on 2017/1/17.
 */
public class Goto {

    public static void main(String[] args) {
        outer:
        for(int i = 0; i < 100 ;i++) {
            inner:
            for (int j = 0; j < 100; j++){
                if(i == j)
                    break inner;
                else if(i > j)
                    continue outer;
                else
                    break outer;
            }
        }
    }
}
