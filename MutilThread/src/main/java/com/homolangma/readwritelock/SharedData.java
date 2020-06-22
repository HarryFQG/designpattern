package com.homolangma.readwritelock;

/**
 * @author: Mr.Harry
 * @date : 2020/5/20 22:38
 * @title :
 */
public class SharedData {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();


    public SharedData(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            this.buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {

        try {
            lock.readLock();
            return this.doRead();
        } finally {
            lock.readerUnlock();

        }
    }

    public void write(char c) throws InterruptedException {
        try {
            lock.writeLock();
            this.doWrite(c);
        } finally {
            lock.writeUnlock();
        }
    }

    private void doWrite(char c) {
        for (int i=0;i<buffer.length;i++) {
            buffer[i]=c;
            slowly(10);
        }

    }

    private char[] doRead() {
        char[] newBuf = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newBuf[i] = buffer[i];
        }
        slowly(50);
        return newBuf;
    }

    private void slowly(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            System.out.println("eeee");

        }

    }

}
