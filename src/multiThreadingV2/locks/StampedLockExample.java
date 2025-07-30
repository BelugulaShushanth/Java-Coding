package multiThreadingV2.executors.locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Runnable deposit = () -> {
            for(int i=1; i<5; i++){
                bankAccount.deposit(100 * i);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException ex){
                    System.out.println("InterruptedException");
                }
            }
        };

        Runnable reader = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()
                        + " optimistic balance: " + bankAccount.getBalanceOptimistic());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
            }
        };

        new Thread(reader).start();
        new Thread(reader).start();
        new Thread(deposit).start();
    }
}

class BankAccount{
    private long balance = 0;
    private final StampedLock stampedLock = new StampedLock();

    public void deposit(long amount){
        long stamp = stampedLock.writeLock();
        try{
            balance += amount;
            System.out.println(Thread.currentThread().getName()+" deposited: "+balance);
        }finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public long getBalanceReadLock(){
        long stamp = stampedLock.readLock();
        try{
            System.out.println(Thread.currentThread().getName()+" balance: "+balance);
            return balance;
        }finally {
            stampedLock.unlockRead(stamp);
        }
    }

    public long getBalanceOptimistic(){
        long stamp = stampedLock.tryOptimisticRead();
        long current = balance;
        if(!stampedLock.validate(stamp)){
            stamp = stampedLock.readLock();
            try{
                current = balance;
            }finally {
                stampedLock.unlockRead(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName()+" read optimistic: "+current);
        return current;
    }
}
