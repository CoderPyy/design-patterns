package com.pyy.dp.proxy.v03;

import java.util.Random;

/**
 * 问题2：如果无法改变方法源码呢？
 * 用继承？？？
 *
 * @author PeiYY
 * @date 2021/1/24 16:16
 */
public class Tank implements Movable {

    /**
     * 模拟坦克移动一段时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving calclaclalal....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Tank2().move();
    }
}

class Tank2 extends Tank {
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

interface Movable {
    void move();
}
