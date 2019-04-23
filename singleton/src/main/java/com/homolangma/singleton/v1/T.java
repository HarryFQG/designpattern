package com.homolangma.singleton.v1;

/**
 * @author 36732
 * @date 2019/4/14 10:34
 */
public class T implements Runnable {

    @Override
    public void run() {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+"--"+lazySingleton);

    }
}
