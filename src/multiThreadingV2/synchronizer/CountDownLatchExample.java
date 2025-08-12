package multiThreadingV2.synchronizer;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        final int N = 5;
        CountDownLatch latch = new CountDownLatch(N);

        for (int i = 1; i <= N; i++) {
            final int id = i;
            new Thread(() -> {
                try {
                    System.out.println("Worker-" + id + " doing work...");
                    Thread.sleep(id * 500);
                    System.out.println("Worker-" + id + " finished");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        System.out.println("Main thread awaiting workers...");
        latch.await();
        System.out.println("All workers done — main continues");
    }
}

