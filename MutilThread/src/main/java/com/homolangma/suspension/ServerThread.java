package com.homolangma.suspension;

import java.util.Random;

/**
 * @author: Mr.Harry
 * @date : 2020/5/21 22:23
 * @title :
 */
public class ServerThread extends Thread {

    private final RequestQueue queue;

    private final Random random;

    private volatile boolean flag = true;

    public ServerThread(RequestQueue queue) {
        this.queue = queue;
        this.random = new Random(System.currentTimeMillis());
    }


    @Override
    public void run() {

        while (flag) {
            Request request = queue.getRequest();
            if(null==request){
                System.out.println("server empty request;");
                continue;
            }
            System.out.println("server:"+request.getValue());

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("///e");
                return;
            }

        }
    }
    public void close(){
        this.flag=false;
        this.interrupt();
    }


}
