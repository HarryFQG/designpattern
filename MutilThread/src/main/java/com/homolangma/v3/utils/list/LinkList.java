package com.homolangma.v3.utils.list;

/**
 * @author: Mr.Harry
 * @date : 2020/6/14 20:38
 * @title :
 */
public class LinkList<E> {

    public static void main(String[] args) {
        LinkList<String> list=LinkList.of("a","b","c","d","e","f");
        list.addFirst("g").addFirst("h");
        System.out.println(list.size+"---"+list.contains("d"));

    }

    private Node<E> first;
    private final Node<E> NULL = (Node<E>) null;

    private final static String PLAIN_NUL = "null";

    private int size;

    public LinkList() {
        this.first = NULL;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public static <E> LinkList<E> of(E... elements) {
        final LinkList list = new LinkList();
        if (elements.length != 0) {
            for (E e : elements) {
                list.addFirst(e);
            }
        }
        return list;

    }

    public LinkList<E> addFirst(E e) {
        final Node<E> newNode = new Node<>(e);
        newNode.next = first;
        this.size++;
        this.first = newNode;
        return this;

    }

    public boolean contains(E e) {
        Node<E> current = first;
        while (current != null) {
            if (current.value == e) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E removeFirst() {
        if (this.isEmpty()) {
            throw new NoElementsException("The linked list is empty.");
        }
        Node<E> node = first;
        first = node.next;
        size--;
        return node.value;

    }

    static class NoElementsException extends RuntimeException {

        public NoElementsException(String message) {
            super(message);
        }
    }


    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

}
