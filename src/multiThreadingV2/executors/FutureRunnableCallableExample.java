package multiThreadingV2.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureRunnableCallableExample {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println(Thread.currentThread().getName()+ "running");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<?> future = executorService.submit(r);
        System.out.println(future);
    }
}
