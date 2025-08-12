package multiThreadingV2.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    private static final ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private static final ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
    private static int count = 0;
    public static void main(String[] args) {

        Runnable producer = () -> {
            System.out.println("Producer requesting lock");
            writeLock.lock();
            try {
                for(int i=0;i<5; i++){
                    count++;
                    System.out.println("Producer incrementing count to " + count);
                    Thread.sleep(500);
                }
            }catch (InterruptedException e){
                System.out.println("Interrupted");
            }finally {
                System.out.println("Producer releasing lock");
                writeLock.unlock();
            }
        };

        Runnable consumer = () -> {
            System.out.println("Consumer requesting lock");
            readLock.lock();
            try{
                System.out.println("Consuming count: "+count);
                Thread.sleep(500);
            }catch (InterruptedException ex){
                System.out.println("InterruptedException ");
            }finally {
                System.out.println("Consumer releasing lock");
                readLock.unlock();
            }
        };

        new Thread(producer, "Producer-1").start();
        new Thread(consumer, "Consumer-1").start();
        new Thread(consumer, "Consumer-2").start();
    }
}
