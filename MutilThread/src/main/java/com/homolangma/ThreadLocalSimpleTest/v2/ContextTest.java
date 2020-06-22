package com.homolangma.ThreadLocalSimpleTest.v2;

import java.util.stream.IntStream;

/**
 * @author: Mr.Harry
 * @date : 2020/5/21 23:09
 * @title :
 */
public class ContextTest {
    public static void main(String[] args) {
        IntStream.range(1, 5).forEach(i -> {
            new Thread(new ExecutionTask()).start();
        });


    }

}
