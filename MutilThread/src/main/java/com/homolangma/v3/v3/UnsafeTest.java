package com.homolangma.v3.v3;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Mr.Harry
 * @date : 2020/6/7 16:16
 * @title :
 */
public class UnsafeTest {

    public static void main(String[] args) throws Exception {
        Unsafe unsafe = getUnsafe();
        System.out.println(unsafe);

        ExecutorService service = Executors.newFixedThreadPool(1000);
        Counter counter = new StupidCounter();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            service.submit(new CounterRunnable(counter, 10000));

        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.HOURS);
        long end = System.currentTimeMillis();
        /**
         * 不加
         *counter : 9885086
         * ms : 229
         **/
        System.out.println("不加锁 counter : " + counter.getCounter());
        System.out.println("不加锁 ms : " + (end - start));


        ExecutorService serviceSync = Executors.newFixedThreadPool(1000);
        Counter counterSync = new SyncCounter();
        long startSync = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            serviceSync.submit(new CounterRunnable(counterSync, 10000));

        }
        serviceSync.shutdown();
        serviceSync.awaitTermination(1, TimeUnit.HOURS);
        long endSync = System.currentTimeMillis();
        /**
         * synchronized 加锁同步
         *counter : 10000000
         * ms : 392
         **/
        System.out.println("synchronized 加锁同步 counter : " + counterSync.getCounter());
        System.out.println("synchronized 加锁同步 ms : " + (endSync - startSync));


        ExecutorService serviceLock = Executors.newFixedThreadPool(1000);

        Counter counterLock = new LockCounter();
        long startLock = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            serviceLock.submit(new CounterRunnable(counterLock, 10000));

        }
        serviceLock.shutdown();
        serviceLock.awaitTermination(1, TimeUnit.HOURS);
        long endLock = System.currentTimeMillis();
        /**
         * Lock 加锁同步
         *Lock 加锁同步 counter : 10000000
         *Lock 加锁同步 ms : 248
         **/
        System.out.println("Lock 加锁同步 counter : " + counterLock.getCounter());
        System.out.println("Lock 加锁同步 ms : " + (endLock - startLock));


        ExecutorService serviceAtomic = Executors.newFixedThreadPool(1000);
        Counter counterAtomic = new AtomicCounter();
        long startAtomic = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            serviceAtomic.submit(new CounterRunnable(counterAtomic, 10000));

        }
        serviceAtomic.shutdown();
        serviceAtomic.awaitTermination(1, TimeUnit.HOURS);
        long endAtomic = System.currentTimeMillis();
        /**
         * Atomic 加锁同步
         *Atomic 加锁同步 counter : 10000000
         *Atomic 加锁同步 ms : 248
         **/
        System.out.println("Atomic 加锁同步 counter : " + counterAtomic.getCounter());
        System.out.println("Atomic 加锁同步 ms : " + (endAtomic - startAtomic));



        ExecutorService CASService = Executors.newFixedThreadPool(1000);
        Counter casCounter = new CASCounter();
        long cASStart = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            CASService.submit(new CounterRunnable(casCounter, 10000));

        }
        CASService.shutdown();
        CASService.awaitTermination(1, TimeUnit.HOURS);
        long endCAS = System.currentTimeMillis();
        /**
         * CAS 加锁同步
         *CAS 加锁同步 counter : 10000000
         *CAS 加锁同步 ms : 248
         **/
        System.out.println("CAS 加锁同步 counter : " + casCounter.getCounter());
        System.out.println("CAS 加锁同步 ms : " + (endCAS - cASStart));
    }

    private static Unsafe getUnsafe() {

        try {
            Field unsafe = Unsafe.class.getDeclaredField("theUnsafe");
            unsafe.setAccessible(true);
            return (Unsafe) unsafe.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static class CounterRunnable implements Runnable {
        private final Counter counter;

        private final int num;

        public CounterRunnable(Counter counter, int num) {
            this.counter = counter;
            this.num = num;
        }

        @Override
        public void run() {
            for (int i = 0; i < num; i++) {
                counter.increment();
            }
        }
    }

    interface Counter {

        void increment();

        long getCounter();
    }

    static class StupidCounter implements Counter {
        private long counter = 0;

        @Override
        public void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class SyncCounter implements Counter {
        private long counter = 0;

        @Override
        public synchronized void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class LockCounter implements Counter {
        private long counter = 0;
        private final Lock lock = new ReentrantLock();

        @Override
        public void increment() {
            try {
                lock.lock();
                counter++;
            } finally {
                lock.unlock();
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class AtomicCounter implements Counter {
        private AtomicLong counter = new AtomicLong(0);

        @Override
        public void increment() {
            counter.incrementAndGet();
        }

        @Override
        public long getCounter() {
            return counter.get();
        }
    }

    static class CASCounter implements Counter {

        private volatile long counter = 0;

        private Unsafe unsafe;
        private long offset;

        public CASCounter() throws Exception {
            unsafe = getUnsafe();
            offset = unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("counter"));
        }

        @Override
        public void increment() {
            long current = counter;
            while (!unsafe.compareAndSwapLong(this, offset, current, current + 1)) {
                current=counter;
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

}


