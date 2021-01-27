package com.pyy.dp.Iterator.v3;

/**
 * v3:添加容器的共同接口，实现容器的替换
 */
public class Main {
    public static void main(String[] args) {
        Collection_ collections = new LinkedList_();
        for (int i = 0; i < 16; i++) {
            collections.add(new String("s" + i));
        }
        System.out.println(collections.size());
    }
}
