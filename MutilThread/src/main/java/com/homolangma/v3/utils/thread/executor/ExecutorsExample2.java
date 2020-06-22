package com.homolangma.v3.utils.thread.executor;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: Mr.Harry
 * @date : 2020/6/13 9:20
 * @title :
 */
public class ExecutorsExample2 {

    public static void main(String[] args) throws InterruptedException {
        // 线程个数是核心数，使用
        ExecutorService executorService = Executors.newWorkStealingPool();
        final List<Callable<String>> collect = IntStream.range(0, 20).boxed().map(i -> {
            return (Callable<String>) () -> {
                System.out.println("task-" + i+" - "+Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
                return "result:task-" + i+i+" - "+Thread.currentThread().getName();
            };
        }).collect(Collectors.toList());
        executorService.invokeAll(collect).stream().map(future->{
            try {
                return future.get();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }).forEach(System.out::println);

    }

}
