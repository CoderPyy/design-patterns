package com.pyy.dp.Iterator.v4;

public class ArrayList_ implements Collection_ {

    Object[] objects = new Object[10];
    //索引的位置
    private int index = 0;

    @Override
    public void add(Object o) {
        if (index == objects.length) {
            Object[] newObjects = new Object[2 * objects.length];
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
}
