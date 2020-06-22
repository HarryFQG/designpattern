package com.homolangma.v3.utils.list;

/**
 * @author: Mr.Harry
 * @date : 2020/6/14 21:03
 * @title :
 */
public class PriorityLinkList<E extends Comparable<E>> {


    public static void main(String[] args) {
        PriorityLinkList<Integer> list = PriorityLinkList.of(12,-1,10,2);
        list.addFirst(3).addFirst(13);
        System.out.println(list.size + "---" + list.contains(2));

    }

    private Node<E> first;
    private final Node<E> NULL = (Node<E>) null;

    private final static String PLAIN_NUL = "null";

    private int size;

    public PriorityLinkList() {
        this.first = NULL;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public static <E extends Comparable<E>> PriorityLinkList<E> of(E... elements) {
        PriorityLinkList list = new PriorityLinkList();
        if (elements.length != 0) {
            for (E e : elements) {
                list.addFirst(e);
            }
        }
        return list;

    }

    public PriorityLinkList<E> addFirst(E e) {
        final Node<E> newNode = new Node<>(e);
        Node<E> previous = NULL;
        Node<E> current = first;
        while (current != null && e.compareTo(current.value) > 0) {
            previous = current;
            current = current.next;

        }
        if (previous == NULL) {
            first = newNode;
        } else {
            previous.next = newNode;
        }
        newNode.next = current;
        size++;
        return this;

    }

    public boolean contains(E e) {
        PriorityLinkList.Node<E> current = first;
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
            throw new LinkList.NoElementsException("The linked list is empty.");
        }
        PriorityLinkList.Node<E> node = first;
        first = node.next;
        size--;
        return node.value;

    }

    @Override
    public String toString() {
        return "PriorityLinkList{" +
                "first=" + first +
                ", NULL=" + NULL +
                ", size=" + size +
                '}';
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
