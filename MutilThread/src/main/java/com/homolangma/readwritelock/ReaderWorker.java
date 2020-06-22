package com.homolangma.readwritelock;

import java.util.Random;

/**
 * @author: Mr.Harry
 * @date : 2020/5/20 23:08
 * @title :
 */
public class ReaderWorker extends Thread {

    private static final Random random = new Random(System.currentTimeMillis());

    private final SharedData sharedData;

    public ReaderWorker(SharedData sharedData) {
        this.sharedData = sharedData;
    }


    @Override
    public void run() {
        try {
            while (true){
                char[] read = sharedData.read();
                System.out.println(Thread.currentThread().getName()+" readers "+ new String(read));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
