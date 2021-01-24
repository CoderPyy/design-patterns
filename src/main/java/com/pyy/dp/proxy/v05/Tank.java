package com.pyy.dp.proxy.v05;

import java.util.Random;

/**
 * 问题：如果无法修改源代码呢？
 * 答案：使用代理
 * <p>
 * 问题：如果代理有各种类型呢？
 * 问题：如何实现代理的各种组合？继承？Decorator？
 *
 * @author PeiYY
 * @date 2021/1/24 16:41
 */
public class Tank implements Movable {
    /**
     * 模拟坦克移动一段时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving claclalcalcl....");
        try {
            Thread.sleep(new Random().nextInt(100000));
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

class TankLogProxy implements Movable{

    Tank tank;

    public TankLogProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("start moving/........");
        tank.move();
        System.out.println("stopped!");
    }
}

interface Movable {
    void move();
}
