package com.homolangma.v3.utils.phaser.example;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author: Mr.Harry
 * @date : 2020/6/12 21:29
 * @title :
 */
public class PhaserExample1 {

    private final static Random random=new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        final Phaser phaser=new Phaser();
        // 起五个线程
        IntStream.rangeClosed(1,5).boxed().map(i->phaser).forEach(  Task::new   );
        phaser.register();
        // 等待6 个线程都完成
        phaser.arriveAndAwaitAdvance();
        System.out.println("all finished   ");
    }
    static class Task extends Thread{
        private final Phaser phaser;

        public Task(Phaser phaser) {
            this.phaser = phaser;
            this.phaser.register();
        }

        @Override
        public void run() {
            System.out.println("the worker "+getName()+"   is working.");
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
