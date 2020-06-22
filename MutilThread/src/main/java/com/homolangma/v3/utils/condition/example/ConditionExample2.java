package com.homolangma.v3.utils.condition.example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Mr.Harry
 * @date : 2020/6/11 22:01
 * @title :
 */
public class ConditionExample2 {

    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition condition = lock.newCondition();


    private static int data = 0;
    private static volatile boolean noUse = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                buildData();
            }
        }).start();
        for (int i = 0; i <2; i++) {
            new Thread(() -> {
                while (true) {
                    useData();
                }
            }).start();
        }


    }

    private static void buildData() {
        try {
            lock.lock();// synchronized start
            while (noUse) {
                condition.await();// monitor.wait()
            }
            data++;
            System.out.println("P:" + data);
            TimeUnit.SECONDS.sleep(1);
            noUse = true;
            condition.signal();//monitor.notify()
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//synchronized end
        }

    }

    private static void useData() {

        try {
            lock.lock();// synchronized start
            while (!noUse) {
                condition.await();// monitor.wait()
            }

            //TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+"  Consumer:" + data);
            noUse = false;
            condition.signalAll();//monitor.notify()
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//synchronized end
        }


    }


}
