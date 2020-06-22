package com.homolangma.v3.utils.thread.pool.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: Mr.Harry
 * @date : 2020/6/12 21:54
 * @title :
 */
public class ThreadPoolExecutorBuildExample1 {

    /**
     * int corePoolSize,
     * int maximumPoolSize,
     * long keepAliveTime,
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue,
     * ThreadFactory threadFactory,
     * RejectedExecutionHandler handler
     *
     * @param args
     */
    public static void main(String[] args) {
        final ThreadPoolExecutor executorService = (ThreadPoolExecutor) buildThreadPoolExecutor();
        int activeCount = -1;
        int queueSize = -1;
        while (true) {
            if (activeCount != executorService.getActiveCount() || queueSize != executorService.getQueue().size()) {
                System.out.println("Active: " + executorService.getActiveCount() + "--Core: " + executorService.getCorePoolSize() + " --Queue: " + executorService.getQueue() + "--MaximumPool: " + executorService.getMaximumPoolSize());
                activeCount = executorService.getActiveCount();
                queueSize = executorService.getQueue().size();
            }
        }
    }

    /**
     * 1. coreSize=1,MaxSize=2 blockingQueueSize is empty , 提交3 任务会怎么样？
     * 2. coreSize=1,MaxSize=2 blockingQueueSize =5 , 提交7任务会怎么样？
     * 3. coreSize=1,MaxSize=2 blockingQueueSize =5 , 提交8任务会怎么样？
     * int corePoolSize,
     * int maximumPoolSize,
     * long keepAliveTime,
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue,
     * ThreadFactory threadFactory,
     * RejectedExecutionHandler handler
     */
    private static ExecutorService buildThreadPoolExecutor() {
        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), r -> {
            Thread t = new Thread(r);
            return t;
        }, new ThreadPoolExecutor.AbortPolicy()
        );
        System.out.println("Thread create  done.");
        executorService.execute(()->sleepSeconds(100));
        executorService.execute(()->sleepSeconds(10));
        executorService.execute(()->sleepSeconds(10));
        return executorService;
    }

    private static void sleepSeconds(long seconds) {
        try {
            System.out.println("* T : " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
