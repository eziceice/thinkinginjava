package Concurrent21;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ryan on 2017/3/29.
 */
public class Shop {
    Thing thing;
    Buyer buyer = new Buyer(this);
    Producer producer = new Producer(this);
    ExecutorService executorService = Executors.newCachedThreadPool();
    CopyOnWriteArrayList<Thing> things = new CopyOnWriteArrayList<>();

    public Shop() {
        executorService.execute(buyer);
        executorService.execute(producer);
    }

    public static void main(String[] args) {
        new Shop();
    }
}

class Thing {
    private int number;
    static int numberCount = 0;

    public Thing(int number) {
        this.number = number;
        numberCount++;
    }

    @Override
    public String toString() {
        return "Thing "+ number + " From shop";
    }
}

class Buyer implements Runnable {
    private Shop shop;

    public Buyer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (Thing.numberCount == 0)
                        wait();
                }

                System.out.println("Buyer bought " + shop.things.get(Thing.numberCount-1));
                shop.things.remove(Thing.numberCount-1);
                Thing.numberCount--;

                synchronized (shop.producer) {
                        shop.producer.notifyAll();
                }

                Thread.sleep(100);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable{
    private Shop shop;

    public Producer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {

                synchronized (this) {
                    while (Thing.numberCount >= 80)
                        wait();
                }

                synchronized (shop.buyer) {
                    for (int i = 0; i < 80; i++) {
                        shop.thing = new Thing(i);
                        shop.things.add(shop.thing);
                    }
                    shop.buyer.notifyAll();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

