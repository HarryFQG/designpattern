package com.homolangma.v3.utils.reentrant.lock.example;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author: Mr.Harry
 * @date : 2020/6/10 23:07
 * @title :
 */
public class ReentrantLockExample1 {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        /*IntStream.range(0, 2).forEach(i -> {
            new Thread() {
                @Override
                public void run() {
                    // needLock();
                    needLockBySync();
                }
            }.start();
        });*/
        Thread thread1 = new Thread(()->testLockInterruptibly());
        thread1.start();
        TimeUnit.SECONDS.sleep(1);
        Thread thread2 = new Thread(()->testLockInterruptibly());
        thread2.start();
        TimeUnit.SECONDS.sleep(1);
        thread2.interrupt();
        System.out.println("=====");
    }

    public static void testLockInterruptibly() {
        try {
            // 这个锁不可被打断
            lock.lockInterruptibly();
            System.out.println("The thread " + Thread.currentThread().getName() + " get lock .");
            while (true) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void needLock() {
        try {
            lock.lock();
            System.out.println("The thread " + Thread.currentThread().getName() + " get lock .");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void needLockBySync() {
        synchronized (ReentrantLockExample1.class) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
