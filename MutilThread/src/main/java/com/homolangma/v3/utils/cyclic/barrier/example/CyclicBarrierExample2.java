package com.homolangma.v3.utils.cyclic.barrier.example;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author: Mr.Harry
 * @date : 2020/6/10 22:27
 * @title :
 */
public class CyclicBarrierExample2 {

    public static void main(String[] args) throws Exception {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                try {
                   // TimeUnit.SECONDS.sleep(5);
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        TimeUnit.MILLISECONDS.sleep(4000);
        System.out.println("awaiting number: "+cyclicBarrier.getNumberWaiting()+"---"+cyclicBarrier.getParties()+"---"+cyclicBarrier.isBroken());
        // reset() == initial==finish
        cyclicBarrier.reset();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("awaiting number: "+cyclicBarrier.getNumberWaiting()+"---"+cyclicBarrier.getParties()+"---"+cyclicBarrier.isBroken());


    }


}
