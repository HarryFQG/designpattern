package com.homolangma.ThreadLocalSimpleTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Mr.Harry
 * @date : 2020/5/21 22:52
 * @title :  ThreadLocal 原理
 *  始终以当前线程作为key 值
 */
public class ThreadLocalSimulator<T> {
    private final Map<Thread, T> storage = new HashMap<>();

    public void set(T t) {

        synchronized (this) {
            Thread key = Thread.currentThread();
            storage.put(key, t);

        }

    }

    public T get() {
        synchronized (this) {
            Thread key = Thread.currentThread();
            T t = storage.get(key);
            if (t == null) {
                return initValue();
            }
            return t;

        }

    }

    public T initValue() {
        return null;
    }


}
