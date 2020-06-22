package com.homolangma.suspension;

import java.util.Random;

/**
 * @author: Mr.Harry
 * @date : 2020/5/21 22:19
 * @title :
 */
public class ClientThread extends Thread {

    private final RequestQueue queue;
    private final Random random;

    private final String sendValue;

    public ClientThread(RequestQueue queue, String sendValue) {
        this.queue = queue;
        this.sendValue = sendValue;
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("CLient -> request:"+sendValue);
            queue.putRequest(new Request(sendValue));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("ee");

            }


        }
    }
}
