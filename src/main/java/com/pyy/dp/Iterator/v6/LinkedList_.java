package com.pyy.dp.Iterator.v6;

/**
 * @author PeiYY
 * @date 2021/1/27 23:53
 */
public class LinkedList_ implements Collection_ {

    private Node head = null;

    private Node tail = null;

    private int size = 0;

    private class Node {
        Object o = new Object();
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }

    @Override
    public void add(Object o) {
        Node n = new Node(o);
        n.next = null;
        if (head == null) {
            head = n;
            tail = n;
        }
        tail.next = n;
        tail = n;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator_ iterator() {
        return null;
    }
}
