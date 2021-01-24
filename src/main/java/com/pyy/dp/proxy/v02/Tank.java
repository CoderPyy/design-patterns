package com.pyy.dp.proxy.v02;

import java.util.Random;

/**
 * 问题1：我想记录坦克的移动时间
 * 最简单的办法：修改代码，记录时间
 *
 * @author PeiYY
 * @date 2021/1/24 16:11
 */
public class Tank implements Movable{
    @Override
    public void move() {
        long start = System.currentTimeMillis();

        System.out.println("Tank moving calclalclalca....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void main(String[] args) {
        new Tank().move();
    }
}
interface Movable{
    void move();
}