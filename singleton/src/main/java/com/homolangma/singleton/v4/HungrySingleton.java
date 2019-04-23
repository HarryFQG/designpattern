package com.homolangma.singleton.v4;

/**
 * @author 36732
 * @date 2019/4/14 15:24
 * 饿汉式加载
 */
public class HungrySingleton {

    private static final HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton();
    }

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

}
