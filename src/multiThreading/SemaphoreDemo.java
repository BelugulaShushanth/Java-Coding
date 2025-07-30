package multiThreading;

import java.util.concurrent.Semaphore;

class SemPrinter {
    private final Semaphore semaphore;
    public SemPrinter(int permits) {
        this.semaphore = new Semaphore(permits);
    }

    public void print(String msg) throws InterruptedException {
        semaphore.acquire(); // acquire a permit

        try {
            System.out.println(Thread.currentThread().getName() + " is printing: " + msg);
            Thread.sleep(5000);
        } finally {
            semaphore.release(); // release permit
        }
    }
}

public class SemaphoreDemo {
    public static void main(String[] args) {
        SemPrinter printer = new SemPrinter(3); // 3 permits
        Runnable task = () -> {
            try {
                printer.print("Hello from " + Thread.currentThread().getName());
            } catch (InterruptedException e) {}
        };

        // Start 5 threads simultaneously
        for (int i = 0; i < 10; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}

class SyncPrinter {
    public synchronized void print(String msg) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " is printing: " + msg);
        Thread.sleep(1000); // Simulate time taken to print
    }
}

class SynchronizedDemo {
    public static void main(String[] args) {
        SyncPrinter printer = new SyncPrinter();
        Runnable task = () -> {
            try {
                printer.print("Hello from " + Thread.currentThread().getName());
            } catch (InterruptedException e) {}
        };

        // Start 5 threads simultaneously
        for (int i = 0; i < 5; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}

