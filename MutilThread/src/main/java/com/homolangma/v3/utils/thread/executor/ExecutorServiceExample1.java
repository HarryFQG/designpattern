package com.homolangma.v3.utils.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author: Mr.Harry
 * @date : 2020/6/13 11:56
 * @title :
 */
public class ExecutorServiceExample1 {


    public static void main(String[] args) throws InterruptedException {
        executeRunnableTask();
    }

    private static void isShutDown() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("is shut down: " + executorService.isShutdown());
        executorService.shutdown();
        System.out.println("is shut down: " + executorService.isShutdown());
        executorService.execute(() -> System.out.println("I will execute ."));


    }

    /**
     * {@link ExecutorService#isTerminated()}
     * {@link java.util.concurrent.ThreadPoolExecutor#isTerminated()}
     */
    private static void isTerminated() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.isShutdown();
        System.out.println("is shut down: " + executorService.isShutdown());
        System.out.println("is 已经结束 : " + executorService.isTerminated());
    }

    private static void executeRunnableError() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10, new MyThreadFactory());
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        IntStream.range(0, 10).forEach(i -> {
            executorService.execute(() -> {
                System.out.println("---" + 1 / 0);
            });
        });
        executorService.isShutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("====================");
    }


    private static void executeRunnableTask() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10, new MyThreadFactory());
        IntStream.range(0, 10).boxed().forEach(i -> {
            executorService.execute( new Mytask(i) {
                @Override
                protected void error(Throwable cause) {
                    System.out.println("The " + i + " executeRunnableTask error");
                }

                @Override
                protected void doExecute() {
                    if (i% 3 == 0) {
                        int j = i / 0;
                    }
                    System.out.println("1212321");
                }

                @Override
                protected void doInit() {
                    System.out.println("do inti");
                }
            });
        });
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("------executeRunnableTask end---------");
    }

    private abstract static class Mytask implements Runnable {
        private final int no;

        public Mytask(int no) {
            this.no = no;
        }


        @Override
        public void run() {
            try {
                System.out.println("run ");
                this.doInit();
                this.doExecute();
            } catch (Throwable cause) {
                this.error(cause);
            }
        }

        protected abstract void error(Throwable cause);

        protected abstract void doExecute();

        protected abstract void doInit();
    }


    private static class MyThreadFactory implements ThreadFactory {
        private final static AtomicInteger SEQ = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("My-Thread-" + SEQ.getAndIncrement());
            thread.setUncaughtExceptionHandler((t, cause) -> {
                System.out.println("Thread " + t.getName() + "execute failed.");
                cause.printStackTrace();
                System.out.println("-------error end-----------");
            });
            return thread;
        }
    }


}
