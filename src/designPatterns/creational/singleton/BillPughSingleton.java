package designPatterns.creational.singleton;

public class BillPughSingleton {
    private BillPughSingleton(){}
    private static class Holder{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    public BillPughSingleton getInstance(){
        return Holder.INSTANCE;
    }
}
