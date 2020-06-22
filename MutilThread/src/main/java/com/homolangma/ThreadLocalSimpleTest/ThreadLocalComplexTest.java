package com.homolangma.ThreadLocalSimpleTest;

import java.util.Random;

/**
 * @author: Mr.Harry
 * @date : 2020/5/21 22:46
 * @title :
 */
public class ThreadLocalComplexTest {
    private final static ThreadLocal<String > threadLocal=new ThreadLocal<>();
    private static final Random random=new Random(System.currentTimeMillis());
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            threadLocal.set("Thread-0");
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName()+"-0a- "+threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread thread2 = new Thread(()->{
            threadLocal.set("Thread-1");
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName()+"-1b- "+threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println("============");
        System.out.println(Thread.currentThread().getName()+" --- "+threadLocal.get());

    }




}
