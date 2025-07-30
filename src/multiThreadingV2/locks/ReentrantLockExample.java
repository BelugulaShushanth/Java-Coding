package multiThreadingV2.executors.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private final static ReentrantLock reentrantLock = new ReentrantLock(true);
    private static int count = 0;

    public static void main(String[] args) {
        increment();
    }

    public static void increment(){
        reentrantLock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName()+" count: "+count+" lock count: "+reentrantLock.getHoldCount());
            incrementAgain();
        }finally {
           reentrantLock.unlock();
            System.out.println(Thread.currentThread().getName()+" count: "+count+" lock count: "+reentrantLock.getHoldCount());
        }
    }

    private static void incrementAgain() {
        reentrantLock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName()+" count: "+count+" lock count: "+reentrantLock.getHoldCount());
        }finally {
            reentrantLock.unlock();
            System.out.println(Thread.currentThread().getName()+" count: "+count+" lock count: "+reentrantLock.getHoldCount());
        }
    }
}
