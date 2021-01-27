package com.pyy.dp.Iterator.v6;

public class ArrayList_<E> implements Collection_<E> {

    E[] objects = (E[])new Object[10];
    private int index = 0;

    @Override
    public void add(E o) {
        if (index == objects.length) {
            E[] newObjects = (E[])new Object[2 * objects.length];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index] = o;
        index++;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public Iterator_<E> iterator() {
        return new ArrayListIterator_();
    }

    private class ArrayListIterator_<E> implements Iterator_<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex <= index;
        }

        @Override
        public E next() {
            E o = (E)objects[currentIndex];
            currentIndex++;
            return o;
        }
    }

}
