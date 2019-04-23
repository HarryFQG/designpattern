package com.homolangma.singleton.v6;

import java.io.Serializable;

/**
 * @author 36732
 * @date 2019/4/14 15:24
 * 饿汉式加载 反射攻击
 */
public class HungrySingleton implements Serializable {

    private static final long serialVersionUID = -5809782578272943999L;

    private static final HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton();
    }

    private HungrySingleton() {
        if (null != hungrySingleton) {
            throw new RuntimeException("eeeeeeeeeeee禁止使用反射获取");
        }

    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    /**
     * 注意这个方法可以让序列化和反序列化都是一个对象，它不会返回序列化会的对象
     *
     * @return
     */
    private Object readResolve() {
        return hungrySingleton;
    }


}
