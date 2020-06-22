package com.homolangma.v3.utils.thread.executor;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: Mr.Harry
 * @date : 2020/6/14 16:11
 * @title :
 */
public class CompletableFutureExample1 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        /*final Future<?> submit = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        while (!submit.isDone()) {

        }
        System.out.println("DONE");*/
        /*CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("---execute---");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).whenComplete((v,t)->{
            System.out.println("DOWN");
        });*/
        /*List<Callable<Integer>> task = IntStream.range(0, 10).boxed().map(i -> (Callable<Integer>) () -> get()).collect(Collectors.toList());
        executorService.invokeAll(task).stream().map(future->{
            try {
                return future.get();
            } catch (Exception e) {
              throw new RuntimeException(e);
            }
        }).parallel().forEach(p->display(p));*/


        IntStream.range(0, 10).boxed().forEach(i -> CompletableFuture.supplyAsync(CompletableFutureExample1::get).thenAccept(CompletableFutureExample1::display).whenComplete((v, t) -> System.out.println(i + " down")));
        Thread.currentThread().join();
        System.out.println("--------I am not blocked---------");
    }


    private static void display(int value) {

        try {
            System.out.println(Thread.currentThread().getName() + " display  will be sleep " + value);
            TimeUnit.SECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " display execute down " + value);

    }


    private static int get() {

        int value = ThreadLocalRandom.current().nextInt(20);
        try {
            System.out.println(Thread.currentThread().getName() + " will be sleep " + value);
            TimeUnit.SECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " execute down " + value);
        return value;
    }


}
