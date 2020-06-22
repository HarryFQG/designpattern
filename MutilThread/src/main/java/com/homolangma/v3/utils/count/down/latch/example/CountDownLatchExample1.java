package com.homolangma.v3.utils.count.down.latch.example;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author: Mr.Harry
 * @date : 2020/6/7 17:35
 * @title : 有一个线程计数器递减到0 子线程同时执行
 * CountDownLatch 与 CyclicBarrier 区别
 * 1. CountDownLatch 不能reset, 而 CyclicBarrier 可以Reset循环使用
 * 2. CountDownLatch 不行，CyclicBarrier 构造器可以传递一个Runnable 接口，CountDownLatch 没有
 * 3. CountDownLatch 各个工作线程之间不相互关心,有主线程奇数;CyclicBarrier 个线程之间相互关心
 */
public class CountDownLatchExample1 {

    private static Random random = new Random(System.currentTimeMillis());

    private static ExecutorService executor = Executors.newFixedThreadPool(2);

    private static CountDownLatch latch = new CountDownLatch(9);

    public static void main(String[] args) throws InterruptedException {

        int[] data = query();

        for (int i = 0; i < data.length; i++) {
            executor.execute(new SimpleRunnable(data, i, latch));

        }
        // 都完成了才进行后面的额
        System.out.println("all of finish down 1.");
        latch.await();
        executor.shutdown();
        // executor.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("all of finish down 2.");
    }


    private static int[] query() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    static class SimpleRunnable implements Runnable {
        private final int[] data;

        private final int index;

        private final CountDownLatch latch;

        public SimpleRunnable(int[] data, int index, CountDownLatch latch) {
            this.data = data;
            this.index = index;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int value = data[index];
            if (value % 2 == 0) {
                data[index] = value * 2;

            } else {
                data[index] = value * 10;

            }
            System.out.println(Thread.currentThread().getName() + " finished ");
            latch.countDown();
        }
    }

}
