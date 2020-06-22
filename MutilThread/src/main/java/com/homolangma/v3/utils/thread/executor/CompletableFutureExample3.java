package com.homolangma.v3.utils.thread.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author: Mr.Harry
 * @date : 2020/6/14 16:11
 * @title : 使用静态工厂
 */
public class CompletableFutureExample3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello");
        future.whenComplete((v, t) -> System.out.println("done"));
        future.whenCompleteAsync((v,t)->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("hei hei");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--over--");
        });
        // 将一个类型转为另外一个类型
         CompletableFuture<Integer> integerCompletableFuture = future.thenApply(String::length);
        System.out.println("======"+integerCompletableFuture.get());
        System.out.println(future.get());
        System.out.println("-------");
        Thread.currentThread().join();
    }


}
