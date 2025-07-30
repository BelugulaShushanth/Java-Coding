package multiThreading;

public class ThreadMethodsDemo {
    public static void main(String[] args) {
        // Create a thread with a runnable
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " is running. Count: " + i);
                try {
                    Thread.sleep(500); // Sleep for 0.5 seconds
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }, "DemoThread");

        // Thread information before start
        System.out.println("Thread ID    : " + thread.getId());
        System.out.println("Thread Name  : " + thread.getName());
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Thread Priority : " + thread.getPriority());
        System.out.println("Thread State before start: " + thread.getState());

        thread.start(); // Starts thread and invokes run()
        System.out.println("Thread State after start: " + thread.getState());
        System.out.println("Is thread alive? " + thread.isAlive());

        try {
            thread.join(); // Wait for this thread to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while joining.");
        }

        System.out.println("Thread State after completion: " + thread.getState());
        System.out.println("Is thread alive? " + thread.isAlive());

        // Daemon thread example
        Thread daemonThread = new Thread(() -> {
            while (true) {}
        }, "Daemon");
        daemonThread.setDaemon(true);
        System.out.println("Is Daemon: " + daemonThread.isDaemon());

        // Interrupt example
        Thread interruptThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("InterruptThread was interrupted during sleep!");
            }
        }, "InterruptThread");
        interruptThread.start();
        interruptThread.interrupt(); // Can be interuppted when in sleep or wait

        // Yield example
        Thread yieldThread = new Thread(() -> {
            System.out.println("Yielding...");
            Thread.yield(); // leaving control for other threads to pick it up.
            System.out.println("Finished yielding.");
        }, "YieldThread");
        yieldThread.start();
    }
}