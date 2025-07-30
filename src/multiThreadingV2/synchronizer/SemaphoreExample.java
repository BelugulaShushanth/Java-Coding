package multiThreadingV2.executors.synchronizer;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Resource resource = new Resource();
        for (int i=0; i<5;i++){
            new Thread(() -> {
                resource.accessResource(Thread.currentThread().getName());
            }, "Thread-"+i).start();
        }
    }
}

class Resource{

    private final Semaphore semaphore = new Semaphore(2);

    public void accessResource(String name){
        try {
            System.out.println(name+ " Waiting for permit");
            semaphore.acquire();
            System.out.println(name + " acquired permit. Processing...");
            Thread.sleep(2000); // simulate processing
            System.out.println(name + " done. Releasing permit.");
        }catch (InterruptedException e){
            System.out.println("InterruptedException");
        }finally {
            semaphore.release();
        }
    }
}
