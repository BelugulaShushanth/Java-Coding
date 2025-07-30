package multiThreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

public class UtilitiesTest {

    public static void main(String[] args) throws InterruptedException {
        UtilitiesTest ut = new UtilitiesTest();
//        ut.countDownLatchTest();
//        ut.cyclicBarrierTest();
//        ut.semaphoreTest();
    }

    public void countDownLatchTest() throws InterruptedException {
        int numWorkers = 3;
        CountDownLatch latch = new CountDownLatch(numWorkers);

        for (int i = 0; i < numWorkers; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " finished work");
                latch.countDown(); // Signal completion
            }, "Worker-" + i).start();
        }

        latch.await(); // Main thread waits for all workers
        System.out.println("All workers finished. Proceeding...");
    }

    public void cyclicBarrierTest(){
//      parties – the number of threads that must invoke await before the barrier is tripped
//      barrierAction – the command to execute when the barrier is tripped, or null if there is no action
        int numWorkers = 3;
        CyclicBarrier barrier = new CyclicBarrier(numWorkers, () ->
                System.out.println("All threads reached the barrier. Barrier action executed!")
        );

        for (int i = 0; i < numWorkers; i++) {
            new Thread(() -> {

                System.out.println(Thread.currentThread().getName() + " finished work");
                try {
                    /// some logic
                    barrier.await(); // Wait at barrier
                    //
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " passed the barrier");

            }, "Worker-" + i).start();
        }
    }

    public void semaphoreTest(){
        int permits = 2;
        Semaphore semaphore = new Semaphore(permits);
//        Semaphore semaphore = new Semaphore(permits, true); // Guarantees FIFO

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " acquired a permit");
                    Thread.sleep(5000); // Simulate work
                } catch (InterruptedException e) { e.printStackTrace(); }
                finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + " released a permit");
                }
            }, "Worker-" + i).start();
        }
    }

}

class PhaserExample {
    public static void main(String[] args) {
        // Create a Phaser with 4 registered parties (threads)
        Phaser phaser = new Phaser(3);

        // Create and start worker threads
        Thread t1 = new Thread(new Worker(phaser, "Thread-1"));
        Thread t2 = new Thread(new Worker(phaser, "Thread-2"));
        Thread t3 = new Thread(new Worker(phaser, "Thread-3"));
//        Thread t4 = new Thread(new Worker(phaser, "Thread-4"));

        t1.start();
        t2.start();
        t3.start();
//        t4.start();

        // Optionally, wait for all phases to complete in the main thread
        int phaseCount = 2; // two work phases in this example
        for (int i = 0; i < phaseCount + 1; i++) { // +1 for final barrier
            phaser.arriveAndAwaitAdvance(); // Main thread waits as well
        }
//        System.out.println("All threads have completed their tasks.");
    }

    static class Worker implements Runnable {
        private final Phaser phaser;
        private final String name;

        Worker(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
        }

        @Override
        public void run() {
            // Phase 0 barrier: synchronize starting
            System.out.println(name + " arrived at phase 0 barrier.");
            phaser.arriveAndAwaitAdvance();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Phase 1 work
            System.out.println(name + " performing phase 1 work.");
            phaser.arriveAndAwaitAdvance();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Phase 2 work
            System.out.println(name + " performing phase 2 work.");
            phaser.arriveAndAwaitAdvance();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(name + " completed all phases.");
            phaser.arriveAndDeregister(); // Optionally deregister if done
        }
    }
}


