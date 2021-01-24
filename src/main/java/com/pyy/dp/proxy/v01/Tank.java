package com.pyy.dp.proxy.v01;

import java.util.Random;

/**问题：我想记录坦克的移动时间
 * @author PeiYY
 * @date 2021/1/24 16:07
 */
public class Tank implements Movable {
    /**
     * 模拟坦克移动一段时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving calclalclalca....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

interface Movable{
    void move();
}
