package jvmInternalAndMemoryManagement;

public class MemoryDemo {
    // Metaspace (class metadata area)
    private static int staticCounter = 0;           // static primitive → stored in Metaspace
    private static final String CONSTANT = "ABC";   // static final String → reference and object in Heap (string pool)

    // Heap (per-instance data)
    private int instanceValue = 123;                // instance primitive → stored in instance on Heap
    private String instanceString = new String("XYZ"); // instance reference and object → stored on Heap

    public static void main(String[] args) {
        //  Stack (method-local data)
        int localPrimitive = 10;                    // local primitive → Stack
        String localString = CONSTANT;              // local reference → Stack; object is in Heap (string pool)

        MemoryDemo demo = new MemoryDemo();         // reference on Stack, `demo` object on Heap

        System.out.println(localPrimitive);
        demo.doSomething(localString);
    }

    public void doSomething(String paramString) {
        // Stack (frame for this method)
        int anotherLocal = 20;                      // local primitive → Stack
        String str = instanceString;                // reference → Stack; object already on Heap

        System.out.println(anotherLocal);
        System.out.println(str);
    }
}
