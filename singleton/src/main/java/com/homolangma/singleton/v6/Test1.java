package com.homolangma.singleton.v6;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 36732
 * @date 2019/4/14 15:33
 * 破坏单例模式：反射攻击 使用构造器
 */
public class Test1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1. 反射获取
        Class objectClass = HungrySingleton.class;
        Constructor constructor = objectClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        // 2. 正常获取
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton singleton = (HungrySingleton) constructor.newInstance();

        System.out.println(instance);
        System.out.println(singleton);
        System.out.println(instance == singleton);

    }


}
