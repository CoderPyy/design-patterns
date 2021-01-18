package com.pyy.dp.factorymethod;

/**
 * 生产飞机的工厂
 * @author PeiYY
 * @date 2021/1/18 22:41
 */
public class PlaneFactory {
    public Moveable create(){
        System.out.println("生产飞机。。。。。");
        return new Plane();
    }
}
