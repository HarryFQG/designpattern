package com.homolangma.v3.utils.list;

import java.util.Random;

/**
 * @author: Mr.Harry
 * @date : 2020/6/14 21:23
 * @title : 跳表
 */
public class SimpleSkipList {
    private final static byte HEAD_NODE = (byte) -1;
    private final static byte DATA_NODE = (byte) 0;
    private final static byte TAIL_NODE = (byte) -1;


    private Node head;
    private Node tail;
    private int size;
    private int height;
    private Random random;


    public static void main(String[] args) {
        SimpleSkipList simpleSkipList = new SimpleSkipList();
        simpleSkipList.add(10);
        simpleSkipList.dumpSkipList();
        System.out.println("===================");
        simpleSkipList.add(1);
        simpleSkipList.dumpSkipList();
        System.out.println("===================");
        Random random=new Random(System.currentTimeMillis());
        for (int i = 0; i <100 ; i++) {
            simpleSkipList.add(random.nextInt(1000));

        }
        simpleSkipList.dumpSkipList();

    }

    public SimpleSkipList() {
        this.head = new Node(null, HEAD_NODE);
        this.tail = new Node(null, TAIL_NODE);
        head.right = tail;
        head.left = head;
        this.random = new Random(System.currentTimeMillis());
    }

    private Node find(Integer e) {
        Node current = head;
        for (; ; ) {
            while (current.right.bit != TAIL_NODE && current.right.value <= e) {
                current = current.right;
            }
            if (current.down != null) {
                current = current.down;
            } else break;
        }
        return current;

    }

    private boolean contains(Integer e) {
        Node node = this.find(e);
        return (node.value == node.value);
    }

    public void dumpSkipList() {
        Node temp = head;
        int i=height+1;
        while (temp != null) {
            System.out.printf("total  [%d] height [%d] ", height+1, i--);
            Node node = temp.right;

            while (node.bit == DATA_NODE) {
                System.out.printf("-> %d ", node.value);
                node = node.right;
            }
            System.out.println("");
            temp = temp.down;
        }
        /*for (int i = height + 1; i > 0; i--) {
            System.out.printf("total  [%d] height [%d] ", height, i);
            Node node = temp.right;

            while (node.bit == DATA_NODE) {
                System.out.printf("-> %d ", node.value);
                node = node.right;
            }
            System.out.println("");
            temp = temp.down;
        }*/


    }

    public void add(Integer e) {
        Node nearNode = this.find(e);
        Node newNode = new Node(e);
        newNode.left = nearNode;
        newNode.right = nearNode.right;
        nearNode.right.left = newNode;
        nearNode.right = newNode;
        int currentLevel = 0;
        while (random.nextDouble() < 0.2d) {
            if (currentLevel >= height) {
                height++;
                Node dumyHead = new Node(null, HEAD_NODE);
                Node dumyTail = new Node(null, TAIL_NODE);
                dumyHead.right = dumyTail;
                dumyHead.down = head;
                dumyHead.up = dumyHead;

                dumyTail.left = dumyHead;
                dumyTail.down = tail;
                tail.up = dumyTail;
                head.up = dumyHead;

                head = dumyHead;
                tail = dumyTail;
            }

            while ((nearNode != null) && nearNode.up == null) {
                nearNode = nearNode.left;
            }
            nearNode = nearNode.up;
            Node upNode = new Node(e);
            upNode.left = nearNode;
            upNode.right = nearNode.right;
            upNode.down = newNode;

            nearNode.right.left = upNode;
            nearNode.right = upNode;

            newNode.up = upNode;
            newNode = upNode;
            currentLevel++;

        }

    }


    private Integer get(Integer e) {
        Node node = this.find(e);
        return node.value == e ? node.value : null;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }


    private static class Node {
        Integer value;
        Node up, down, left, right;
        private byte bit;

        public Node(Integer value, byte bit) {
            this.value = value;
            this.bit = bit;
        }

        public Node(Integer value) {
            this(value, DATA_NODE);
        }


        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
