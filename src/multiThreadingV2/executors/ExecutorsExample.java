package multiThreadingV2.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService;
       // executorService = Executors.newFixedThreadPool(5);
        //executorService = Executors.newCachedThreadPool();
        //executorService = Executors.newSingleThreadExecutor();
        executorService = Executors.newWorkStealingPool();
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName()+" running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
        };
        for(int i=0; i<10; i++){
            executorService.execute(task);
        }

        executorService.shutdown();
        if(!executorService.awaitTermination(1, TimeUnit.SECONDS)){
            System.out.println("Executor didn't shutdown in 1 second");
        }
    }
}
