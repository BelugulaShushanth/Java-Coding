package multiThreading.lock;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {
    private static int buffer = 0;
    private static final int MAX = 2;
    private static final Lock lock = new ReentrantLock();
    private static final Condition notEmpty = lock.newCondition();
    private static final Condition notFull = lock.newCondition();

    // Condition are to coordinate between 2 threads like Object notify and wait,
    // but we can have multiple conditions.
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();

        Runnable producer = () -> {
            lock.lock();
            try {
                while (buffer == MAX){
                    System.out.println(Thread.currentThread().getName() + " waiting to produce...");
//                    notFull.await();
//                    notFull.await(1,  TimeUnit.SECONDS);
                    if (!notFull.await(1, TimeUnit.SECONDS)) {
                        System.out.println(Thread.currentThread().getName() + " timeout waiting to produce.");
                        return;
                    }
                }
//                buffer = 1;
                buffer++;
                System.out.println(Thread.currentThread().getName() + " produced");
                notEmpty.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        };

        Runnable consumer = () -> {
            lock.lock();
            try {
                while (buffer == 0){
                    System.out.println(Thread.currentThread().getName() + " waiting to consume...");
                    notEmpty.await();
//                    notEmpty.await(1,  TimeUnit.SECONDS);

//                    if (!notEmpty.await(1, TimeUnit.SECONDS)) {
//                        System.out.println(Thread.currentThread().getName() + " timeout waiting to consume.");
//                        return;
//                    }
                }
//                buffer = 0;
                buffer--;
                System.out.println(Thread.currentThread().getName() + " consumed");
                notFull.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        };

        // Submit alternating producer/consumer
        pool.submit(producer);
        pool.submit(producer);
        pool.submit(producer);
        pool.submit(producer);
        pool.submit(consumer);
        pool.submit(consumer);
        pool.submit(producer);
        pool.submit(producer);

        pool.shutdown();
//        pool.awaitTermination(5, TimeUnit.SECONDS);
    }
}

