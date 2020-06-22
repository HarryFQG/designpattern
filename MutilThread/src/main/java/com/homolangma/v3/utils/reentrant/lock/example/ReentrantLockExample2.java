package com.homolangma.v3.utils.reentrant.lock.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: Mr.Harry
 * @date : 2020/6/10 23:07
 * @title :
 */
public class ReentrantLockExample2 {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final  ReentrantReadWriteLock lockWR=new ReentrantReadWriteLock(true);

    private static final Lock lockR=lockWR.readLock();
    private static final Lock lockW=lockWR.writeLock();
    private static final List<Long> data = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> write());
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        Thread t2= new Thread(() -> read());
        t2.start();
        Thread t3= new Thread(() -> read());
        t3.start();


        TimeUnit.SECONDS.sleep(4);
        System.out.println("-------RW-------");

        Thread tw1 = new Thread(() -> write2());
        tw1.start();
        TimeUnit.SECONDS.sleep(1);
        Thread tr2= new Thread(() -> read2());
        tr2.start();
        Thread tr3= new Thread(() -> read2());
        tr3.start();
    }

    public static void write() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"  write.");
            data.add(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public static void read(){

        try {
            lock.lock();
            data.forEach(System.out::println);
            System.out.println(Thread.currentThread().getName()+"---");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public static void write2() {
        try {
            lockR.lock();
            System.out.println(Thread.currentThread().getName()+"  write.");
            data.add(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockR.unlock();
        }

    }
    public static void read2(){

        try {
            lockW.lock();
            data.forEach(System.out::println);
            System.out.println(Thread.currentThread().getName()+"---");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockW.unlock();
        }
    }
}
