package thread.local;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/27
 * @Time: 19:18
 * @Description:
 * @version: 1.0.0
 */
public class MyThreadLocal<T> {
    private final Map<Thread, T> container = Collections.synchronizedMap(new HashMap<>());

    public void set(T value) {
        container.put(Thread.currentThread(), value);
    }

    public T get() {
        Thread currentThread = Thread.currentThread();
        T value = container.get(currentThread);
        if (value == null && !container.containsKey(currentThread)) {
            value = initValue();
            container.put(currentThread, value);
        }
        return value;
    }

    public void remove() {
        container.remove(Thread.currentThread());
    }

    protected T initValue() {
        return null;
    }

}