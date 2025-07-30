package designPatterns.creational.singleton;

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton(){}

    public LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
