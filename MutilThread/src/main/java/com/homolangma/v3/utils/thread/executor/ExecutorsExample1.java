package com.homolangma.v3.utils.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author: Mr.Harry
 * @date : 2020/6/13 9:20
 * @title :
 */
public class ExecutorsExample1 {

    public static void main(String[] args) throws InterruptedException {
        useFixedPool();
    }
    /**
     * thread will be created and added to the pool. Threads that have
     * not been used for sixty seconds are terminated and removed from
     * the cache.
     * These pools will typically improve the performance
     * of programs that execute many short-lived asynchronous tasks.
     * return new ThreadPoolExecutor(0, Integer.MAX_VALUE,     60L, TimeUnit.SECONDS,    new SynchronousQueue<Runnable>());
     * block queue 一个长度
     *
     */
    public static void cachedThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("init Active: " + ((ThreadPoolExecutor) executorService).getActiveCount() + "--Core: " + ((ThreadPoolExecutor) executorService).getCorePoolSize() + " --Queue: " + ((ThreadPoolExecutor) executorService).getQueue() + "--MaximumPool: " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());
        executorService.execute(() -> System.out.println("* " + Thread.currentThread().getName()));
        System.out.println(Thread.currentThread().getName() + " step1 Active: " + ((ThreadPoolExecutor) executorService).getActiveCount() + "--Core: " + ((ThreadPoolExecutor) executorService).getCorePoolSize() + " --Queue: " + ((ThreadPoolExecutor) executorService).getQueue() + "--MaximumPool: " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());
        IntStream.range(0, 100).boxed().forEach(i -> executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + " step2 Active: " + ((ThreadPoolExecutor) executorService).getActiveCount() + "--Core: " + ((ThreadPoolExecutor) executorService).getCorePoolSize() + " --Queue: " + ((ThreadPoolExecutor) executorService).getQueue() + "--MaximumPool: " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName() + " step3 Active: " + ((ThreadPoolExecutor) executorService).getActiveCount() + "--Core: " + ((ThreadPoolExecutor) executorService).getCorePoolSize() + " --Queue: " + ((ThreadPoolExecutor) executorService).getQueue() + "--MaximumPool: " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());
        TimeUnit.SECONDS.sleep(12);
        System.out.println(Thread.currentThread().getName() + " step4 Active: " + ((ThreadPoolExecutor) executorService).getActiveCount() + "--Core: " + ((ThreadPoolExecutor) executorService).getCorePoolSize() + " --Queue: " + ((ThreadPoolExecutor) executorService).getQueue() + "--MaximumPool: " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());


    }

    /**
     * @param the number of threads in the pool
     * @return the newly created thread pool
     * @throws IllegalArgumentException if {@code nThreads <= 0}
     */
    private static void useFixedPool() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println("init Active: " + ((ThreadPoolExecutor) executorService).getActiveCount() + "--Core: " + ((ThreadPoolExecutor) executorService).getCorePoolSize() + " --Queue: " + ((ThreadPoolExecutor) executorService).getQueue() + "--MaximumPool: " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());
        executorService.execute(() -> System.out.println("* " + Thread.currentThread().getName()));
        System.out.println(Thread.currentThread().getName() + " step1 Active: " + ((ThreadPoolExecutor) executorService).getActiveCount() + "--Core: " + ((ThreadPoolExecutor) executorService).getCorePoolSize() + " --Queue: " + ((ThreadPoolExecutor) executorService).getQueue() + "--MaximumPool: " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());
        IntStream.range(0, 100).boxed().forEach(i -> executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + " step2 Active: " + ((ThreadPoolExecutor) executorService).getActiveCount() + "--Core: " + ((ThreadPoolExecutor) executorService).getCorePoolSize() + " --Queue: " + ((ThreadPoolExecutor) executorService).getQueue() + "--MaximumPool: " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName() + " step3 Active: " + ((ThreadPoolExecutor) executorService).getActiveCount() + "--Core: " + ((ThreadPoolExecutor) executorService).getCorePoolSize() + " --Queue: " + ((ThreadPoolExecutor) executorService).getQueue() + "--MaximumPool: " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());
        TimeUnit.SECONDS.sleep(12);
        System.out.println(Thread.currentThread().getName() + " step4 Active: " + ((ThreadPoolExecutor) executorService).getActiveCount() + "--Core: " + ((ThreadPoolExecutor) executorService).getCorePoolSize() + " --Queue: " + ((ThreadPoolExecutor) executorService).getQueue() + "--MaximumPool: " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());
        executorService.shutdown();
        executorService.awaitTermination(20,TimeUnit.SECONDS);
        System.out.println("==========useFixedPool Stop===========");

    }

    /**
     *
     * 区别：
     * 1. 普通线程执行完就结束， 但是newSingleThread 里面的线程就不会结束，会一直存活，可以复用。
     * 2. newSingleThread 提交的任务不能放到queue 中去 。
     *
     * return new FinalizableDelegatedExecutorService (new ThreadPoolExecutor(1, 1,   0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>()));
     */
    private static void useSignlePool() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("init Active: " + ((ThreadPoolExecutor) executorService).getActiveCount() + "--Core: " + ((ThreadPoolExecutor) executorService).getCorePoolSize() + " --Queue: " + ((ThreadPoolExecutor) executorService).getQueue() + "--MaximumPool: " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());
        executorService.execute(() -> System.out.println("* " + Thread.currentThread().getName()));
        System.out.println(Thread.currentThread().getName() + " step1 Active: " + ((ThreadPoolExecutor) executorService).getActiveCount() + "--Core: " + ((ThreadPoolExecutor) executorService).getCorePoolSize() + " --Queue: " + ((ThreadPoolExecutor) executorService).getQueue() + "--MaximumPool: " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());
        IntStream.range(0, 10).boxed().forEach(i -> executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + " step2 Active: " + ((ThreadPoolExecutor) executorService).getActiveCount() + "--Core: " + ((ThreadPoolExecutor) executorService).getCorePoolSize() + " --Queue: " + ((ThreadPoolExecutor) executorService).getQueue() + "--MaximumPool: " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(Thread.currentThread().getName() + " step3 Active: " + ((ThreadPoolExecutor) executorService).getActiveCount() + "--Core: " + ((ThreadPoolExecutor) executorService).getCorePoolSize() + " --Queue: " + ((ThreadPoolExecutor) executorService).getQueue() + "--MaximumPool: " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());
        TimeUnit.SECONDS.sleep(7);
        System.out.println(Thread.currentThread().getName() + " step4 Active: " + ((ThreadPoolExecutor) executorService).getActiveCount() + "--Core: " + ((ThreadPoolExecutor) executorService).getCorePoolSize() + " --Queue: " + ((ThreadPoolExecutor) executorService).getQueue() + "--MaximumPool: " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());
        executorService.shutdown();
        executorService.awaitTermination(20,TimeUnit.SECONDS);
        System.out.println("==========useFixedPool Stop===========");

    }
}
