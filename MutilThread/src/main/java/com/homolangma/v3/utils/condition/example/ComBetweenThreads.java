package com.homolangma.v3.utils.condition.example;

import java.util.concurrent.TimeUnit;

/**
 * @author: Mr.Harry
 * @date : 2020/6/11 22:28
 * @title :
 */
public class ComBetweenThreads {

    private static int data = 0;

    private static boolean noUse = true;

    private final static Object MONITOR = new Object();


    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                buildData();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                useData();
            }
        }).start();

    }

    private static void buildData() {
        synchronized (MONITOR) {
            while (noUse) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data++;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("p:" + data);
            noUse = true;
            MONITOR.notifyAll();
        }
    }

    private static void useData() {
        synchronized (MONITOR) {
            while (!noUse) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("Consumer:" + data);
            noUse = false;
            MONITOR.notifyAll();
        }


    }


}
