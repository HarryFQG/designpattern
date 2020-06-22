package com.homolangma.v3.utils.thread.executor;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: Mr.Harry
 * @date : 2020/6/13 11:56
 * @title :
 */
public class ExecutorServiceExample4 {


    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        testInvokeAll();
    }

    /**
     * ExecutionException:  执行过程中出现问题
     * <p>
     * ThreadLocalRandom 和线程上下文绑定
     * {@link ExecutorService#invokeAny(Collection)}
     */
    private static void testInvokeAny() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final List<Callable<Integer>> collect = IntStream.range(0, 5).boxed().map(i -> (Callable<Integer>) () -> {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(20));
            System.out.println(Thread.currentThread().getName() + ":" + i);
            return i;
        }).collect(Collectors.toList());
        /**
         * 返回 其中的那一个，例如：
         *  提交五个任务，那个先完成先返回那个，后面的四个任务不再执行。
         */
        Integer integer = executorService.invokeAny(collect);
        System.out.println("---finished---" + integer);

    }

    /**
     * ExecutionException:  执行过程中出现问题
     * <p>
     * ThreadLocalRandom 和线程上下文绑定
     * {@link ExecutorService#invokeAny(Collection)}
     */
    private static void testInvokeAnyTimeOut() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final List<Callable<Integer>> collect = IntStream.range(0, 5).boxed().map(i -> (Callable<Integer>) () -> {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(20));
            System.out.println(Thread.currentThread().getName() + ":" + i);
            return i;
        }).collect(Collectors.toList());
        /**
         * 返回 其中的那一个，例如：
         *  提交五个任务，那个先完成先返回那个，后面的四个任务不再执行。
         * 设置 超时时间
         */
        Integer integer = executorService.invokeAny(collect, 2, TimeUnit.SECONDS);
        System.out.println("---finished---" + integer);

    }


    private static void testInvokeAll() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final List<Callable<Integer>> collect = IntStream.range(0, 5).boxed().map(i -> (Callable<Integer>) () -> {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName() + ":" + i);
            return i;
        }).collect(Collectors.toList());
        /**
         * 返回 其中的那一个，例如：
         *  提交五个任务，那个先完成先返回那个，后面的四个任务不再执行。
         * 设置 超时时间
         */
        List<Future<Integer>> futures = executorService.invokeAll(collect);
        futures.stream().map(p->{
            try {
                return  p.get();
            } catch (Exception e) {
               throw new RuntimeException("///");
            }
        }).forEach(System.out::println);
        System.out.println("---finished---" );

    }

}
