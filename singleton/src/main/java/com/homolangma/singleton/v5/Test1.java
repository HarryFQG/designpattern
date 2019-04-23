package com.homolangma.singleton.v5;

import java.io.*;

/**
 * @author 36732
 * @date 2019/4/14 15:33
 * 破坏单例模式 序列化和反序列化
 */
public class Test1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        // 序列化 hungrySingleton
        // 1. 序列化文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(hungrySingleton);

        // 2. 从文件中序列化回来,注意readResolve() 方法
        File file = new File("singleton_file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        HungrySingleton hungrySingleton1 = (HungrySingleton) ois.readObject();
        System.out.println("hungrySingleton:" + hungrySingleton);
        System.out.println("hungrySingleton1:" + hungrySingleton1);
        System.out.println(hungrySingleton == hungrySingleton1);

    }


}
