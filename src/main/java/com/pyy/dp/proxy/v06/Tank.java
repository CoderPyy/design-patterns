package com.pyy.dp.proxy.v06;

import java.util.Random;

/**
 * 问题：如何实现代理的各种组合？
 * 答案：代理的对象改成Movable类型----越来越像decorator了
 *
 * 静态代理Proxy
 *
 * @author PeiYY
 * @date 2021/1/24 17:13
 */
public class Tank implements Movable {

    /**
     * 模拟坦克移动一段时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving calclallaal......");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TankTimeProxy(new TankLogProxy(new Tank())).move();
    }
}

class TankLogProxy implements Movable {

    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("start moving........");
        m.move();
        System.out.println("stopped!");
    }
}

class TankTimeProxy implements Movable {

    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

interface Movable {
    void move();
}
