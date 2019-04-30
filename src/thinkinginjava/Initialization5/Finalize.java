package src.thinkinginjava.Initialization5;

/**
 * Created by Ryan on 2017/1/19.
 */
public class Finalize {
    public static void main(String[] args){

        Tank tank = new Tank(true);
        System.gc();


    }




    static class Tank{
        private boolean state;
        public Tank(boolean state) {
            this.state = state;
        }

        public void finalize() throws Throwable {
            super.finalize();
            if(state = true)
                System.out.print("clear");
            else
                System.out.print("error");
        }
    }

}
