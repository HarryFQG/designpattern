package com.homolangma.singleton.v1;

/**
 * @author fengqigui
 * @date  2019/4/14 10:10
 * 懒汉式：
 *  注重延迟加载，多线程调试
 * 特点：
 *  单线程安全，多线不安全.
 * 解决线程不安全：
 *  1. 在静态方法上加 synchronized 关键字
 *  2.
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
    }

    public synchronized static LazySingleton getInstance() {
        if (null == lazySingleton) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }


}
