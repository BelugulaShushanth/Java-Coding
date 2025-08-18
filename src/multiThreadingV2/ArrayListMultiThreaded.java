package multiThreadingV2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ArrayListMultiThreaded {

    public void execute() throws ExecutionException, InterruptedException {
        List<Future<List<String>>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<List<String>> callable = () -> {
            List<String> localList = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                localList.add(Thread.currentThread().getName() + " " + j);
            }
            return localList;
        };
        for(int i=0; i<5; i++) {
            Future<List<String>> future = executorService.submit(callable);
            futures.add(future);
        }
        executorService.shutdown();
        if(executorService.awaitTermination(5, TimeUnit.SECONDS)){
            System.out.println("Shut down success");
        }else{
            executorService.shutdownNow();
        }

        List<String> result = new ArrayList<>();
        for (Future<List<String>> future: futures){
            List<String> strings = future.get();
            result.addAll(strings);
        }
        System.out.println(result);

    }
}
