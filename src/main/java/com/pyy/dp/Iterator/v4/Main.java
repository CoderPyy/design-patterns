package com.pyy.dp.Iterator.v4;

/**
 * v4:如何对容器遍历呢？
 */
public class Main {
    public static void main(String[] args) {
        Collection_ collections = new LinkedList_();
        for (int i = 0; i < 16; i++) {
            collections.add(new String("s" + i));
        }
        System.out.println(collections.size());

        LinkedList_ ll = (LinkedList_) collections;
        for (int i = 0; i < ll.size(); i++) {
            //如果用这种遍历方式，就不能实现通用了
        }

    }
}
