package multiThreadingV2.executors;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        scheduledExecutorService.schedule(() -> System.out.println("Executing after a delay"), 5, TimeUnit.SECONDS);

        //periodic fixed rate
        // starts with a delay of 2 seconds and executes periodically for every 10 seconds
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("Executing at fixed rate "+ LocalDateTime.now());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                , 2, 10, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println("Executing at fixed delay "+ LocalDateTime.now());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 3, 8, TimeUnit.SECONDS);


        scheduledExecutorService.schedule(scheduledExecutorService::shutdown, 5,TimeUnit.MINUTES);
    }
}
