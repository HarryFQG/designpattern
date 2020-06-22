package com.homolangma.v3.utils.count.down.latch.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Mr.Harry
 * @date : 2020/6/8 22:58
 * @title :
 */
public class CountDownLatchExample42 {
    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        Event[] events = {new Event(1), new Event(2)};

        ExecutorService service = Executors.newFixedThreadPool(5);

        for (Event event : events) {
            List<Table> capture = capture(event);
            TaskGroup taskGroup = new TaskGroup(capture.size(), event);
            for (Table table : capture) {

                TaskBatch taskBatch = new TaskBatch(2, taskGroup);
                TrustSourceColumn trustSourceColumn = new TrustSourceColumn(table, taskBatch);
                TrustSourceRecordCount trustSourceRecordCount = new TrustSourceRecordCount(table, taskBatch);
                service.submit(trustSourceColumn);
                service.submit(trustSourceRecordCount);
            }
            ;
        }


    }

    private static List<Table> capture(Event event) {
        List<Table> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Table("table-" + event.id + "-" + i, i * 10000));
        }

        return list;
    }

    static class TrustSourceRecordCount implements Runnable {
        private final Table table;
        private final TaskBatch taskBatch;

        public TrustSourceRecordCount(Table table, TaskBatch taskBatch) {
            this.table = table;
            this.taskBatch = taskBatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            table.targetCount = table.sourceRecordCount;
            // System.out.println("TrustSourceRecordCount  finished  " + table.tableName);
            taskBatch.done(table);
        }
    }

    static class TrustSourceColumn implements Runnable {
        private final Table table;
        private final TaskBatch taskBatch;

        public TrustSourceColumn(Table table, TaskBatch taskBatch) {
            this.table = table;
            this.taskBatch = taskBatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            table.targetColumnSchema = table.sourceColumnSchema;
            // System.out.println("TrustSourceColumn  finished  " + table.tableName);
            taskBatch.done(table);
        }
    }

    static class Event {
        int id = 0;

        public Event(int id) {
            this.id = id;
        }
    }

    interface Watcher {
        // void startWatch();

        void done(Table table);
    }

    static class TaskBatch implements Watcher {
        private CountDownLatch countDownLatch;
        private TaskGroup taskGroup;

        public TaskBatch(int size, TaskGroup taskGroup) {
            this.countDownLatch = new CountDownLatch(size);
            this.taskGroup = taskGroup;
        }

        /*@Override
        public void startWatch() {
            countDownLatch.
        }*/

        @Override
        public void done(Table table) {
            countDownLatch.countDown();
            if (countDownLatch.getCount() == 0) {
                System.out.println("这个batch 已经做完了" + table.tableName + " ---" + table);
                taskGroup.done(table);


            }
        }
    }

    static class TaskGroup implements Watcher {
        private CountDownLatch countDownLatch;
        private Event event;

        public TaskGroup(int size, Event event) {
            this.event = event;
            this.countDownLatch = new CountDownLatch(size);
        }

        /*@Override
        public void startWatch() {
           // countDownLatch.
        }*/

        @Override
        public void done(Table table) {
            countDownLatch.countDown();
            if (countDownLatch.getCount() == 0) {
                System.out.println("All of table done in event:" + event.id);
            }
        }
    }

    static class Table {
        String tableName;
        long sourceRecordCount = 10;
        long targetCount;
        String sourceColumnSchema = "<table name='a'><column name='col1' type='varchar'></table>";
        String targetColumnSchema = "";

        public Table(String tableName, long sourceRecordCount) {
            this.tableName = tableName;
            this.sourceRecordCount = sourceRecordCount;
        }

        @Override
        public String toString() {
            return "Table{" +
                    "tableName='" + tableName + '\'' +
                    ", sourceRecordCount=" + sourceRecordCount +
                    ", targetCount=" + targetCount +
                    ", sourceColumnSchema='" + sourceColumnSchema + '\'' +
                    ", targetColumnSchema='" + targetColumnSchema + '\'' +
                    '}';
        }
    }

}
