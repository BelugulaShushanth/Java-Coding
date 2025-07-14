package referenceType;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Main {

    //Strong reference
    //As long as obj is in scope or reachable, the object stays in memory. and not GC
    String s1 = new String("Java");

    //Soft reference
    //Used for caching. GC may collect the object only if memory is low.
    SoftReference<String> s2 = new SoftReference<>("Java");

    //weak reference
    //GC collects the object as soon as it becomes weakly reachable.
    WeakReference<String> s3 = new WeakReference<>("Java");
}
