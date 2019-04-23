package com.homolangma.singleton.v3;

/**
 * @author 36732
 * @date 2019/4/14 11:29
 * 静态内部类：
 * 1. 实现懒加载 多线程安全
 * 2. 设计类加载初始化顺序
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {
    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }

    private static class InnerClass {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }
}
