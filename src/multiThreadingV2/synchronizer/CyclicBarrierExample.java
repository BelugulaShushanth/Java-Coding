package multiThreadingV2.synchronizer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    /*
    Behavior: Each thread waits different times before calling await().
    When the fourth arrives, the barrier trips, and all threads resume—even
    starting a new cycle if reused
     */
    public static void main(String[] args) {

        int parties = 4;
        CyclicBarrier barrier = new CyclicBarrier(parties);
        for (int i = 1; i <= parties; i++) {
            final int delay = i * 1000;
            new Thread(() -> {
                try {
                    Thread.sleep(delay);
                    System.out.println(Thread.currentThread().getName() + " calling await()");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + " resumed");
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Thread-" + i).start();
        }
    }
}

