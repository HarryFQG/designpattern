package com.homolangma.v3.utils.forkjoin;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author: Mr.Harry
 * @date : 2020/6/12 21:08
 * @title :
 */
public class ForkJoinRecursiveAction {

    private final static int MAX_THRESHOLD = 3;

    private final static AtomicInteger SUM = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 求和
        final ForkJoinTask<Void> submit = forkJoinPool.submit(new CalculateRecursiveAction(0, 10));
        final ForkJoinTask<CalculateRecursiveAction> submit1 = forkJoinPool.submit(() -> {
            System.out.println("------------------");

        }, new CalculateRecursiveAction(0, 10));


        forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(SUM);
    }

    private static class CalculateRecursiveAction extends RecursiveAction {
        private final int start;
        private final int end;

        public CalculateRecursiveAction(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {

            if (end - start <= MAX_THRESHOLD) {
                SUM.addAndGet(IntStream.rangeClosed(start, end).sum());
            } else {
                int middle = (start + end) / 2;
                CalculateRecursiveAction leftTask = new CalculateRecursiveAction(start, middle);
                CalculateRecursiveAction rightTask = new CalculateRecursiveAction(middle+1, end);
                leftTask.fork();
                rightTask.fork();
            }

        }
    }


}
