package com.homolangma.singleton;

/**
 * @author 36732
 * @date 2019/4/14 17:47
 * 实例不唯一，线程唯一,线程单例
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> singleton = new ThreadLocal<ThreadLocalSingleton>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    private ThreadLocalSingleton() {
    }

    public ThreadLocalSingleton getInstance() {
        return singleton.get();
    }


}
