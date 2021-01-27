package com.pyy.dp.Iterator.v5;

import java.util.LinkedList;

public class LinkedList_ implements Collection_ {

    Node head = null;
    Node tail = null;
    //目前容器中有多少个元素
    private int size = 0;

    private class Node {
        private Object o;
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
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator_ {
        private int currentSize = 0;

        @Override
        public boolean hasNext() {
            if (currentSize >= size) return false;
            return true;
        }

        @Override
        public Object next() {
            return null;
        }
    }

}
