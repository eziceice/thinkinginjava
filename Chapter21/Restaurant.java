package Chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ryan on 2017/3/29.
 */
public class Restaurant {
    Meal meal;
    Boolean isCleaned = true;
    Waiter waiter = new Waiter(this);
    Chief chief = new Chief(this);
    BusyBoy busyBoy = new BusyBoy(this);

    ExecutorService executorService = Executors.newCachedThreadPool();

    public Restaurant() {
        executorService.execute(chief);
        executorService.execute(waiter);
        executorService.execute(busyBoy);
    }

    public static void main(String[] args) {
        new Restaurant();
    }

}

class Meal {
    private final int ordNum;

    public Meal(int ordNum) {
        this.ordNum = ordNum;
    }

    @Override
    public String toString() {
        return "Meal " + ordNum;
    }
}

class Waiter implements Runnable {
    /**
     *          显示锁和condition
     *
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
     */
    private Restaurant restaurant;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    //lock.lock();
                    while (restaurant.meal == null || !restaurant.isCleaned)
                        wait();//condition.await();
                }

                System.out.println("Waiter Got the Meal" + restaurant.meal);

                synchronized (restaurant.busyBoy) {
                    restaurant.isCleaned = false;
                    restaurant.busyBoy.notifyAll();
                }

                synchronized (restaurant.chief) {
                    restaurant.meal = null;
                    restaurant.chief.notifyAll();
                    //restaurant.chief.condition.notifyAll();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class BusyBoy implements Runnable {
    private Restaurant restaurant;

    public BusyBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {

                synchronized (this) {
                    while (restaurant.isCleaned)
                        wait();
                }

                synchronized (restaurant.waiter) {
                    restaurant.isCleaned = true;
                    System.out.println("BusyBoy is already cleaned");
                    restaurant.waiter.notifyAll();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Chief implements Runnable {
    /**
     *          显示锁和condition
     *
     Lock lock = new ReentrantLock();
     Condition condition = lock.newCondition();
     */
    private Restaurant restaurant;
    private int count = 0;

    public Chief(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null)
                        wait();
                }

                if (count >= 10) {
                    System.out.println("No Food to Get");
                    restaurant.executorService.shutdownNow();
                    return;
                }

                System.out.println("Order Up! ");

                synchronized (restaurant.waiter) {
                    restaurant.meal = new Meal(++count);
                    restaurant.waiter.notifyAll();
                }

                TimeUnit.MILLISECONDS.sleep(100);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
