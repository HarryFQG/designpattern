package com.homolangma.readwritelock;

import java.util.Random;

/**
 * @author: Mr.Harry
 * @date : 2020/5/20 23:03
 * @title :
 */
public class WriterWorker extends Thread {
    private static final Random random = new Random(System.currentTimeMillis());

    private final SharedData sharedData;
    private final String filler;

    private int index = 0;

    public WriterWorker(SharedData sharedData, String filler) {
        this.sharedData = sharedData;
        this.filler = filler;
    }

    @Override
    public void run() {

        try {
            while (true){
                char c=nextChar();
                sharedData.write(c);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private char nextChar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length()) {
            index = 0;
        }
        return c;
    }


}
