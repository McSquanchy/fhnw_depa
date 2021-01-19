package patterns.singleton.soft;

import java.lang.ref.SoftReference;

public final class Singleton {
    private Singleton() { }
    private static SoftReference<Singleton> instance = null;

    public static synchronized Singleton getInstance() {
        if(instance == null || instance.get() == null)
            instance = new SoftReference<>(new Singleton());
        return instance.get();
    }
}