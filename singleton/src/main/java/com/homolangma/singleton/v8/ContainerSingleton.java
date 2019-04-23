package com.homolangma.singleton.v8;


import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 36732
 * @date 2019/4/14 17:17
 * 容器单例模式: singletonMap 单例
 */
public class ContainerSingleton {

    private static Map<String, Object> singletonMap = new HashMap<>(4);
    private ContainerSingleton(){}
    public static void putInstance(String key, Object instance) {
        if (StringUtils.hasLength(key) && null != instance) {
            if (!singletonMap.containsKey(key)) {
                singletonMap.put(key, instance);
            }
        }
    }

    public static Object getInstance(String key) {
        return singletonMap.get(key);
    }


}
