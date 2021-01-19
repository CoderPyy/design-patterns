package com.pyy.dp.abstractfactory.interface_;

/**
 * 定义抽象接口工厂
 * 定义抽象接口 产品族
 */
public interface InterfaceFactory {
    Food createFood();
    Vehicle createVehicle();
    Weapon createWeapon();
}
