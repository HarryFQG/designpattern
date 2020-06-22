package com.homolangma.v1;

/**
 * @author: Mr.Harry
 * @date : 2020/5/24 16:57
 * @title :
 */
public class MyClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader=new MyClassLoader("ClassLoader");
        Class<?> aClass = myClassLoader.loadClass("com.homolangma.v1.MyObject");
        Object o = aClass.newInstance();
        System.out.println(o);

    }

}
