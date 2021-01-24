package com.pyy.dp.proxy.v04;

import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间，如果无法改变方法源码呢？
 * 使用代理
 *
 * @author PeiYY
 * @date 2021/1/24 16:22
 */
public class Tank implements Movable {

    /**
     * 模拟坦克移动一段时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving calclalclacl.....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TankTimeProxy(new Tank()).move();
    }
}

class TankTimeProxy implements Movable {

    Tank tank;

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

interface Movable {
    void move();
}
