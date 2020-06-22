package com.homolangma.readwritelock;

/**
 * @author: Mr.Harry
 * @date : 2020/5/20 23:11
 * @title :
 */
public class ReadWritLockClient {
    public static void main(String[] args) {

        final SharedData sharedData = new SharedData(10);
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new WriterWorker(sharedData,"1230456").start();
        new WriterWorker(sharedData,"qazwsx").start();


    }


}
