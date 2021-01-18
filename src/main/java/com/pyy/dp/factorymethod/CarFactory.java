package com.pyy.dp.factorymethod;

/**
 * 生成车的工厂
 * @author PeiYY
 * @date 2021/1/18 22:36
 */
public class CarFactory {
    public Moveable create(){
        System.out.println("生成车。。。");
        return new Car();
    }
}
