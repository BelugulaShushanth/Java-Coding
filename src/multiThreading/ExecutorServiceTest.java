package multiThreading;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorServiceTest {


    public static void main(String[] args) throws InterruptedException {
            ExecutorService pool;
//            pool = Executors.newFixedThreadPool(3);
//           pool = Executors.newSingleThreadExecutor();
//           pool = Executors.newCachedThreadPool();
            pool = Executors.newWorkStealingPool();
//            pool = new ForkJoinPool();

        for(int i = 0; i<30; i++)
            pool.submit(() -> {
                System.out.println("Calling Thread " + Thread.currentThread().getName() + "is Dameon " +
                        Thread.currentThread().isDaemon());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            });

        pool.shutdown();
        if (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("Not all tasks finished in time!");
        }

    }
}


class FutureDemo{
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        //Future Demo
        //Submit
        Future<Integer> result = pool.submit(() -> 2);
        try {
            System.out.println(result.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        //Future invokeAll
        List<Callable<Double>> inputCallable = new ArrayList<>();
        for(int i = 0; i<30; i++){
            inputCallable.add(new CallableTask());
        }

        List<Future<Double>> resultList = pool.invokeAll(inputCallable);
        for(Future<Double> r : resultList){
            try {
                System.out.println(r.isDone()); // we can use this flag along with sleep to check and
                // get the value later or handle if an exception if we get one.
                if(r.isDone()){

                    System.out.println(r.get()); // this is blocking call
                }
                System.out.println(r.get()); // this is blocking call
            } catch (ExecutionException e) {
                System.err.println("Task failed: " + e.getCause());
            }
        }

    }
}



class CallableTask implements Callable<Double>{

    public CallableTask(){}

    @Override
    public Double call() throws Exception {
        return Math.random();
    }
}

