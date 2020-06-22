package com.homolangma.v3.utils.condition.example;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Mr.Harry
 * @date : 2020/6/11 22:01
 * @title :
 */
public class ConditionExample3 {

    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition PRODUCE_COND = lock.newCondition();
    private static final Condition CONSUMER_COND = lock.newCondition();
    private static LinkedList<Long> TIMESTAMP_POOL = new LinkedList<>();

    private static int MAX_CAPACITY =100;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> beginProduce()).start();
        }
        for (int i = 0; i < 6; i++) {
            new Thread(()->beginConsumer()).start();
        }

        for (;;) {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("=====");
            //int waitQueueLength = lock.getWaitQueueLength(PRODUCE_COND);
           // int waitQueueLength1 = lock.getWaitQueueLength(CONSUMER_COND);
           // System.out.println("P--"+waitQueueLength+"---c--"+waitQueueLength1);
        }
    }

    private static void produce() {
        try {
            lock.lock();// synchronized start
            while (TIMESTAMP_POOL.size() >= MAX_CAPACITY) {
                PRODUCE_COND.await();
            }

            long v = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "--P--" + v +"-waitLength--"+lock.getWaitQueueLength(PRODUCE_COND));
            TIMESTAMP_POOL.add(v);
            CONSUMER_COND.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//synchronized end
        }

    }


    private static void consumer() {
        try {
            lock.lock();// synchronized start
            System.out.println("c-waitLength--"+lock.getWaitQueueLength(CONSUMER_COND));
            while (TIMESTAMP_POOL.isEmpty()) {
                CONSUMER_COND.await();
            }
            long v = TIMESTAMP_POOL.removeFirst();
            System.out.println(Thread.currentThread().getName() + "--C--" + v+"-waitLength--"+lock.getWaitQueueLength(CONSUMER_COND));
            PRODUCE_COND.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//synchronized end
        }

    }


    private static void beginProduce() {
        while (true) {
            produce();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void beginConsumer()  {
        while (true) {
            consumer();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
