package com.homolangma.v3.utils.count.down.latch.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Mr.Harry
 * @date : 2020/6/8 22:58
 * @title :
 */
public class CountDownLatchExample4 {
    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        Event[] events = {new Event(1), new Event(2)};

        ExecutorService service = Executors.newFixedThreadPool(5);

        for (Event event : events) {
            List<Table> capture = capture(event);
            for (Table table : capture) {
                TrustSourceColumn trustSourceColumn = new TrustSourceColumn(table);
                TrustSourceRecordCount trustSourceRecordCount = new TrustSourceRecordCount(table);
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

        public TrustSourceRecordCount(Table table) {
            this.table = table;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            table.targetCount = table.sourceRecordCount;
            System.out.println("TrustSourceRecordCount  finished  "+ table.tableName);
        }
    }

    static class TrustSourceColumn implements Runnable {
        private final Table table;

        public TrustSourceColumn(Table table) {
            this.table = table;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            table.targetColumnSchema = table.sourceColumnSchema;
            System.out.println("TrustSourceColumn  finished  "+ table.tableName);
        }
    }

    static class Event {
        int id = 0;

        public Event(int id) {
            this.id = id;
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


    }

}
