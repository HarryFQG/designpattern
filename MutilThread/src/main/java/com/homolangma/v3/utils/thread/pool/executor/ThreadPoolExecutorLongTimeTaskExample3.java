package com.homolangma.v3.utils.thread.pool.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author: Mr.Harry
 * @date : 2020/6/13 9:07
 * @title :
 */
public class ThreadPoolExecutorLongTimeTaskExample3 {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 20, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), r -> {
            Thread t = new Thread(r);
            return t;
        }, new ThreadPoolExecutor.AbortPolicy());
        IntStream.range(0, 2).boxed().forEach(i -> {
            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
        IntStream.range(0, 10).boxed().forEach(i -> {
            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        // 观察活跃的线程个数 与 queue 大小 的关系，
        System.out.println("Active: " + executorService.getActiveCount() + "--Core: " + executorService.getCorePoolSize() + " --Queue: " + executorService.getQueue() + "--MaximumPool: " + executorService.getMaximumPoolSize());

        executorService.shutdown();

        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("====start the sequence 串行化====");
    }

}
