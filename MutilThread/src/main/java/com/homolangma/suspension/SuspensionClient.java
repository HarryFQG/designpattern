package com.homolangma.suspension;

/**
 * @author: Mr.Harry
 * @date : 2020/5/21 22:31
 * @title :
 */
public class SuspensionClient {

    public static void main(String[] args) throws InterruptedException {
        final RequestQueue request = new RequestQueue();
        new ClientThread(request,"tom").start();
        ServerThread serverThread = new ServerThread(request);
        serverThread.start();
        Thread.sleep(10000);
        serverThread.close();

    }


}
