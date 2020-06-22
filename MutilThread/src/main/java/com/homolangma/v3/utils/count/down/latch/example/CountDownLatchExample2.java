package com.homolangma.v3.utils.count.down.latch.example;

import java.util.concurrent.CountDownLatch;

/**
 * @author: Mr.Harry
 * @date : 2020/6/7 18:56
 * @title :
 * 先并行，再串行
 */
public class CountDownLatchExample2 {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        new Thread() {
            @Override
            public void run() {
                System.out.println("Do some initial working");
                try {
                    Thread.sleep(1000);
                    latch.await();
                    System.out.println("Do other working....");
                } catch (InterruptedException e) {
                    System.out.println("er1");

                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                System.out.println("a syn prepare for data.");
                try {
                    Thread.sleep(2000);
                    System.out.println("data prepare for done.....");
                } catch (InterruptedException e) {
                    System.out.println("er2");

                } finally {
                    latch.countDown();
                }
            }
        }.start();


        new Thread() {
            @Override
            public void run() {

                try {
                    latch.await();
                    System.out.println("--await--");
                } catch (InterruptedException e) {
                    System.out.println("er3");

                }
            }
        }.start();
        Thread.currentThread().join();
    }


}
