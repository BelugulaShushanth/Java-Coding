package jvmInternalAndMemoryManagement;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Runtime rt = Runtime.getRuntime();
        System.out.println("Initial (total) heap: " + rt.totalMemory()/1024/1024 + " MB");
        System.out.println("Max heap (Xmx): " + rt.maxMemory()/1024/1024 + " MB");
        long maxMem = rt.maxMemory()/(1024 * 1024);

        WeakReference<List<byte[]>> list = new WeakReference<>(new ArrayList<>());
        while (true){
            if(list.get() == null) list = new WeakReference<>(new ArrayList<>());
            list.get().add(new byte[1024 * 1024]);
            long usedMem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024);
            System.out.println("Used: " + usedMem + " MB");
            double threshold = (double) usedMem / maxMem;
            if(threshold >= 0.97){
                list.clear();
            }
            //try { Thread.sleep(100); } catch (InterruptedException ignored) {}
        }

    }
}
