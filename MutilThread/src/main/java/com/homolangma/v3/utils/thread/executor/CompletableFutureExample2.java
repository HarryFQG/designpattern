package com.homolangma.v3.utils.thread.executor;

import java.util.concurrent.*;

/**
 * @author: Mr.Harry
 * @date : 2020/6/14 16:11
 * @title : 使用静态工厂
 */
public class CompletableFutureExample2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // supplyAsync();
        // Future<?> future = runAsync();
        // future.get();
        // completed("hello");
        // System.out.println(anyOf().get());
        anyAll();
        Thread.currentThread().join();
    }


    private static void create() {
        CompletableFuture<String> future = new CompletableFuture<>();

    }


    private static void anyAll() {

        CompletableFuture.allOf(CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Obj1=======Start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Obj1=======end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).whenComplete((v, t) -> System.out.println("=========over1=========")), CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Obj2=======Start");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Obj2=======end====:");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).whenComplete((v, t) -> System.out.println("===over2===" + v)));


    }

    private static Future<?> anyOf() {

        return CompletableFuture.anyOf(CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Obj1=======Start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Obj1=======end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).whenComplete((v, t) -> System.out.println("=========over1=========")), CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Obj2=======Start");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Obj2=======end====:");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).whenComplete((v, t) -> System.out.println("===over2===" + v)));


    }


    private static Future<Void> completed(String data) {
        return CompletableFuture.completedFuture(data).thenAccept(System.out::println);

    }


    private static Future<?> runAsync() {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Obj=======Start");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Obj=======end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).whenComplete((v, t) -> System.out.println("=========over========="));


    }

    private static void supplyAsync() {

        CompletableFuture.supplyAsync(Object::new).thenAccept(obj -> {
            try {
                System.out.println("Obj=======Start");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Obj=======end====:" + obj);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).runAfterBoth(CompletableFuture.supplyAsync(() -> "hello").thenAcceptAsync(s -> {
            try {
                System.out.println("String=======Start");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("String=======end====:" + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }), () -> System.out.println("====finished==="));

        System.out.println("--------I am not blocked---------");
    }

}
