package com.homolangma.v3.v1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Mr.Harry
 * @date : 2020/5/24 17:31
 * @title :
 */
public class AtomicIntegerTest {

    /**
     * volatile:
     * 1. 可见性
     * 2. 内存屏障
     * 3. 不保证原子性
     * 注意：两个线程同时修改可能会出事儿
     */
    private static volatile int value = 0;

    private static Set<Integer> set = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {

            @Override
            public void run() {
                int x = 0;
                while (x < 100) {
                    set.add(value);
                    int tmp = value;
                    System.out.println(Thread.currentThread().getName() + " --- " + tmp);
                    value += 1;
                    x++;
                }

            }
        };
        Thread t2 = new Thread() {

            @Override
            public void run() {
                int x = 0;
                while (x < 100) {
                    set.add(value);
                    int tmp = value;
                    System.out.println(Thread.currentThread().getName() + " --- " + tmp);
                    /**
                     * value=value+1;
                     * step:
                     * 1. 从住内存中读一个数到自己缓存中
                     * 2. 加1
                     * 3. 将新的值给原来的值
                     * 4. 刷新缓存
                     */
                    value += 1;
                    x++;
                }

            }
        };
        Thread t3 = new Thread() {

            @Override
            public void run() {
                int x = 0;
                while (x < 100) {
                    set.add(value);
                    int tmp = value;
                    System.out.println(Thread.currentThread().getName() + " --- " + tmp);
                    /**
                     * value=value+1;
                     * step:
                     * 1. 从住内存中读一个数到自己缓存中
                     * 2. 加1
                     * 3. 将新的值给原来的值
                     * 4. 刷新缓存
                     */
                    value += 1;
                    x++;
                }

            }
        };
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(set.size());
    }


}
