package com.homolangma.singleton.v2;

/**
 * @author 36732
 * @date 2019/4/14 10:53
 * 懒加载 双重检查锁 多线程安全
 * 注意：
 *  volatile 的特点
 */
public class LazyDoubleCheckSingleton {

    /**
     * 延迟初始化，改善重排序，缓存一致性协议
     */
    private volatile static LazyDoubleCheckSingleton lazySingleton = null;

    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance() {
        // 隐患：可能未执行完初始化，但是又不是为空
        if (null == lazySingleton) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (null == lazySingleton) {
                    lazySingleton = new LazyDoubleCheckSingleton();
                    // 1. 分配内存给这个对象
                    // 2. 初始化对象
                    // 3. 设置 lazySingleton 指向刚分配的内存地址 (2、3步骤存在重排序)
                }
            }

        }
        return lazySingleton;
    }
}
