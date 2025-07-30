package multiThreading.lock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {
    private double value = 0.0;
    private final StampedLock lock = new StampedLock();

    // Write
    public void set(double v) {
        long stamp = lock.writeLock();
        try {
            System.out.println(Thread.currentThread().getName() + " (write) is writing: " + v);
            value = v;
            Thread.sleep(5000); // Simulate work
        } catch (InterruptedException ignored) {}
        finally {
            lock.unlockWrite(stamp);
        }
    }

    // Read
    public double get() {
        long stamp = lock.readLock();
        double val = value;
        try {
            System.out.println(Thread.currentThread().getName() + " (read) is reading value " + val);
            Thread.sleep(2000); // Simulate work
            return val;
        } catch (InterruptedException ignored) {
            return Double.NaN;
        } finally {
            lock.unlockRead(stamp);
        }
    }

    // Optimistic Read
    public double getOptimistic() {
        long stamp = lock.tryOptimisticRead();
        double val = value;
        if (!lock.validate(stamp)) { // fall back if write happened
            stamp = lock.readLock();
            try {
                val = value;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " (optimistic) read " + val);
        return val;
    }

    public static void main(String[] args) {
        StampedLockExample example = new StampedLockExample();

        Runnable writer = () -> example.set(Math.random());
        Runnable reader = () -> example.get();
        Runnable optimistic = () -> example.getOptimistic();

        Thread t1 = new Thread(writer, "WriterThread");
        Thread t2 = new Thread(writer, "WriterThread");
        Thread t3 = new Thread(reader, "ReaderThread");
        Thread t4 = new Thread(optimistic, "OptimisticReader");
        Thread t5 = new Thread(optimistic, "OptimisticReader");
        Thread t6 = new Thread(optimistic, "OptimisticReader");
        Thread t7 = new Thread(reader, "ReaderThread");

        t3.start();
        t4.start();
        t1.start();
        t5.start();
        t2.start();
        t6.start();
        t7.start();
    }
}
