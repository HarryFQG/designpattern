package com.homolangma.v3.utils.cyclic.barrier.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author: Mr.Harry
 * @date : 2020/6/10 22:08
 * @title :
 * 几个线程相互等，都完成了就会继续执行下步 ；
 * 构造器可以传递一个Runnable 接口，CountDownLatch 没有
 */
public class CyclicBarrierExample1 {


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    System.out.println("T1 finished.");
                    cyclicBarrier.await();
                    System.out.println("T2 ...n the other finished.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    System.out.println("T2 finished.");
                    cyclicBarrier.await();
                    System.out.println("T3 ...n the other finished.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        /*cyclicBarrier.await();
        System.out.println("all finished");*/
        while (true){
            Thread.sleep(100);
            System.out.println("await number :" + cyclicBarrier.getNumberWaiting()+"--"+cyclicBarrier.getParties()+"---"+cyclicBarrier.isBroken());

        }

    }


}
