package com.homolangma.v3.utils.cyclic.barrier.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: Mr.Harry
 * @date : 2020/6/10 22:40
 * @title :
 */
public class CyclicBarrierExample3 {
    public static void main(String[] args) {
        final MyCountDownLatch countDownLatch=new MyCountDownLatch(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("all of work finished down.");
            }
        });
        new Thread(){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()+"finished.");
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()+"finished.");
            }
        }.start();
    }


    static class MyCountDownLatch extends CountDownLatch {
        private final Runnable runnable;

        public MyCountDownLatch(int count, Runnable runnable) {
            super(count);
            this.runnable = runnable;
        }

        @Override
        public void countDown() {
            super.countDown();
            if (getCount() == 0) {
                this.runnable.run();
            }
        }
    }


}
