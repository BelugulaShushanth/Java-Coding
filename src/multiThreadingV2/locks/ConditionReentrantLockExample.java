package multiThreadingV2.executors.locks;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionReentrantLockExample {

    public static void main(String[] args) {
        PubSub ps = new PubSub();
        Runnable p1 = () -> ps.produce("IN", "India");
        Runnable p2 = () -> ps.produce("US", "United States Of America");
        Runnable p3 = () -> ps.produce("EU", "Europe");
        Runnable p4 = () -> ps.produce("CN", "China");
        Runnable c1 = () -> ps.consume("IN");
        Runnable c2 = () -> ps.consume("US");
        Runnable p5 = () -> ps.produce("AU", "Australia");
        Runnable c3 = () -> ps.consume("EU");

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();
        new Thread(p4).start();
        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(p5).start();
        new Thread(c3).start();

    }

}
class PubSub{
    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition producerCon = lock.newCondition();
    private final Condition consumerCon = lock.newCondition();
    private HashMap<String,String> data = new LinkedHashMap<>();
    private int buffer = 0;
    private int max = 3;

    public void produce(String key, String value){
        lock.lock();
        try{
            while (buffer == max){
                System.out.println("Waiting to produce");
                producerCon.await();
            }
            data.put(key,value);
            buffer++;
            System.out.println(Thread.currentThread().getName()+" Produced "+key+" "+value);
            consumerCon.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

    public void consume(String key){
        lock.lock();
        try {
            while (buffer == 0){
                System.out.println("Waiting to consume");
                consumerCon.await();
            }
            String value = data.get(key);
            System.out.println(Thread.currentThread().getName()+" Consumed "+key+" "+value);
            data.remove(key);
            buffer--;
            producerCon.signal();
        }catch (InterruptedException e){
            System.out.println("InterruptedException");
        }finally {
            lock.unlock();
        }
    }

}
