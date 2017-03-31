package Chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Ryan on 2017/3/30.
 */
public class PipedIO {
    public static void main(String[] args) {
        LinkedBlockingQueue<String>
                senders = new LinkedBlockingQueue<>(),
                receivers = new LinkedBlockingQueue<>();
        Sender sender = new Sender(senders);
        Receiver receiver = new Receiver(senders, receivers);

        ExecutorService executors = Executors.newCachedThreadPool();
        executors.execute(sender);
        executors.execute(receiver);


    }


}

class Sender implements Runnable {
    private LinkedBlockingQueue<String> senders;

    public Sender(LinkedBlockingQueue<String> senders) {
        this.senders = senders;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (char c = 'a'; c <= 'z'; c++) {
                    senders.put(String.valueOf(c));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Receiver implements Runnable {
    private LinkedBlockingQueue<String> senders;
    private LinkedBlockingQueue<String> receivers;

    public Receiver(LinkedBlockingQueue<String> senders, LinkedBlockingQueue<String> receivers) {
        this.senders = senders;
        this.receivers = receivers;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                String s = senders.take();
                System.out.println(s);
                receivers.put(s);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
