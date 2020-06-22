package com.homolangma.v3.utils.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * @author: Mr.Harry
 * @date : 2020/6/12 20:53
 * @title :
 */
public class ForkJoinRecursiveTask {

    private final static int MAX_THRESHOLD = 3;


    public static void main(String[] args) {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 求和
        final ForkJoinTask<Integer> submit = forkJoinPool.submit(new CalculateRecursiveTask(0, 10));
        try {
            int sum=submit.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    private static class CalculateRecursiveTask extends RecursiveTask<Integer> {

        private final int start;
        private final int end;

        public CalculateRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {

            if (end - start <= MAX_THRESHOLD) {
                return IntStream.range(start, end).sum();
            } else {
                int middle = (start + end) / 2;
                CalculateRecursiveTask leftTask = new CalculateRecursiveTask(start, middle);
                CalculateRecursiveTask rightTask = new CalculateRecursiveTask(middle, end);
                leftTask.fork();
                rightTask.fork();
                return leftTask.join() + rightTask.join();
            }

        }
    }


}
