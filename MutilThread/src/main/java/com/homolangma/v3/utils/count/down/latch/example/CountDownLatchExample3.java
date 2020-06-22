package com.homolangma.v3.utils.count.down.latch.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: Mr.Harry
 * @date : 2020/6/7 19:05
 * @title :  CountDownLatch 退出来有两种，一种是减到0 ，另外一种 主线程interrupt()
 */
public class CountDownLatchExample3 {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        Thread mainThread = Thread.currentThread();
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
                // mainThread.interrupt();
            }
        }.start();
        latch.await(1000, TimeUnit.MICROSECONDS);
        System.out.println("===================");
        latch.countDown();
    }

}
