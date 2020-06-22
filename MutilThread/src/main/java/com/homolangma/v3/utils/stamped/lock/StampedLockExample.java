package com.homolangma.v3.utils.stamped.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.Collectors;

/**
 * @author: Mr.Harry
 * @date : 2020/6/11 23:17
 * @title : 可以替换 ReentrantReadWriteLock
 */
public class StampedLockExample {

    private final static StampedLock lock = new StampedLock();
    private final static List<Long> DATA = new ArrayList<>();

    /**
     * 悲观的读
     * @param args
     */
    public static void main(String[] args) {

        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable readTask = () -> {
            for (; ; ) {
                read();
            }
        };
        Runnable writeTask = () -> {
            for (; ; ) {
                write();
            }
        };
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(writeTask);
    }

    private static void read() {
        long stamped = -1;
        try {
            stamped = lock.readLock();
            String collect = DATA.stream().map(p -> String.valueOf(p)).collect(Collectors.joining("#","R-",","));
            System.out.println(collect);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlockRead(stamped);
        }
    }

    private static void write() {
        long stamped = -1;
        try {
            stamped = lock.writeLock();
            DATA.add(System.currentTimeMillis());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlockWrite(stamped);
        }
    }
}
