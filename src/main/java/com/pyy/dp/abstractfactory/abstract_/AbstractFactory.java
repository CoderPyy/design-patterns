package com.pyy.dp.abstractfactory.abstract_;

/**
 * 定义抽象  产品族
 * @author PeiYY
 * @date 2021/1/18 23:21
 */
public abstract class AbstractFactory {
    public abstract Food createFood();
    public abstract Vehicle createVehicle();
    public abstract Weapon createWeapon();
}
