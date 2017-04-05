package Concurrent21;

import java.io.IOException;

/**
 * Created by Ryan on 2017/3/27.
 */
public class ResponsiveUI implements Runnable{
    private volatile double d = 1;

    @Override
    public void run() {
        while (true)
            System.out.println(d = d + (Math.PI + Math.E) / d);
    }

    class UnresponsiveUI {
        private volatile double d = 1;
        public UnresponsiveUI() throws Exception {
            while (d > 0)
                d = d + (Math.PI + Math.E)/d;
            System.out.println("this is a test");
        }
    }

    public static void main(String[] args) throws IOException {
        ResponsiveUI responsiveUI = new ResponsiveUI();
        new Thread(responsiveUI).start();
        System.out.println("this is a test");
    }

}
