package com.homolangma.v3.utils.thread.pool.executor;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author: Mr.Harry
 * @date : 2020/6/12 21:54
 * @title :
 */
public class ThreadPoolExecutorTaskExample2 {

    /**
     * shutdown
     * <p>
     * 1.停止接收外部submit的任务
     * 2.内部正在跑的任务和队列里等待的任务，会执行完
     * 3.等到第二步完成后，才真正停止
     * </p>
     *
     *
     * shutdownNow
     * <p>
     * 1. 停止接收外部submit的任务
     * 2. 忽略队列里等待的任务
     * 3. 尝试将正在跑的任务interrupt中断
     * 4. 返回未执行的任务列表
     * </p>
     *
     * awaitTermination
     * <p>
     * 1.等所有已提交的任务（包括正在跑的和队列中等待的）执行完
     * 2.或者等超时时间到
     * 3.或者线程被中断，抛出InterruptedException
     * </p>
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(10, 20, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), r -> {
            Thread t = new Thread(r);
            return t;
        }, new ThreadPoolExecutor.AbortPolicy());
        IntStream.range(0, 20).boxed().forEach(i -> {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
        final List<Runnable> runnables = executorService.shutdownNow();
        // executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("------over------");
    }


}
