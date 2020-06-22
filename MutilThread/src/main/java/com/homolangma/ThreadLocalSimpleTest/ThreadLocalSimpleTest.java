package com.homolangma.ThreadLocalSimpleTest;

/**
 * @author: Mr.Harry
 * @date : 2020/5/21 22:43
 * @title :
 */
public class ThreadLocalSimpleTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "jerry";
        }
    };

    public static void main(String[] args) throws InterruptedException {

        threadLocal.set("tom");
        Thread.sleep(1000);
        System.out.println(threadLocal.get());

    }


}
