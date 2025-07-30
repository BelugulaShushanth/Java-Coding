package multiThreading.lock;

import java.util.concurrent.locks.*;
import java.util.*;

public class ReadWriteLockExample {
    private final Map<String, String> map = new HashMap<>();

    //fairness doesn't guarantee order, it just handles incase of contention using FIFO order.

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock(true);
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    // Writer method
    public void put(String key, String value) {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " (write) is writing: " + key + "=" + value);
            map.put(key, value);
            Thread.sleep(2000); // Simulate work
        } catch (InterruptedException ignored) {}
        finally {
            writeLock.unlock();
        }
    }

    // Reader method
    public String get(String key) {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " (read) is reading: " + key);
            Thread.sleep(1000); // Simulate work
            return map.get(key);
        } catch (InterruptedException ignored) {
            return null;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockExample example = new ReadWriteLockExample();

        Runnable writer = () -> example.put("foo", "bar");
        Runnable reader = () -> example.get("foo");

        Thread t1 = new Thread(writer, "WriterThread");
        Thread t2 = new Thread(reader, "ReaderThread-1");
        Thread t3 = new Thread(reader, "ReaderThread-2");
        Thread t4 = new Thread(writer, "WriterThread");
        Thread t5 = new Thread(reader, "ReaderThread-3");
        Thread t6 = new Thread(reader, "ReaderThread-4");
        Thread t7 = new Thread(reader, "ReaderThread-5");
        Thread t8 = new Thread(reader, "ReaderThread-6");


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();

        System.out.println("Main thread Doesn't wait");
        t4.join();
        System.out.println("Main thread waits for t4 to complete");
    }
}