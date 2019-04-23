package com.homolangma.singleton.v2;



/**
 * @author 36732
 * @date 2019/4/14 10:32
 */
public class Test1 {


    public static void main1(String[] args) {
        LazyDoubleCheckSingleton lazySingleton = LazyDoubleCheckSingleton.getInstance();
        System.out.println("---end---");

    }

    /**
     * 多线程调试，证明多线程不安全
     * @param args
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(new T());
        Thread thread2 = new Thread(new T());
        thread1.start();
        thread2.start();
        System.out.println("---end---");

    }


}
