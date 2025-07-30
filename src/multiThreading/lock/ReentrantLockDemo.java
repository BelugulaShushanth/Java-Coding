package multiThreading.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    static final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            reentrantLock.lock(); // First lock (outer)
            try {
                System.out.println(threadName + " entered outer lock, hold count: " + reentrantLock.getHoldCount());

                innerLock(); // Acquire lock again, reentrant

            } finally {
                System.out.println(threadName + " exiting outer lock, hold count: " + reentrantLock.getHoldCount());
                reentrantLock.unlock(); // Unlock outer
            }
        };

        // Submit multiple tasks to see lock contention
        for (int i = 0; i < 5; i++) {
            executor.submit(task);
        }

        executor.shutdown();
    }

    // Method that acquires the same lock again (nested locking = reentrancy)
    private static void innerLock() {
        String threadName = Thread.currentThread().getName();
        reentrantLock.lock(); // Second lock (reentrant)
        try {
            System.out.println(threadName + " entered inner lock, hold count: " + reentrantLock.getHoldCount());
            Thread.sleep(500); // Simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(threadName + " exiting inner lock, hold count: " + reentrantLock.getHoldCount());
            reentrantLock.unlock(); // Unlock inner
        }
    }
}

