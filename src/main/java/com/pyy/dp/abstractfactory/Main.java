package com.pyy.dp.abstractfactory;

import com.pyy.dp.abstractfactory.abstract_.AbstractFactory;
import com.pyy.dp.abstractfactory.abstract_.Food;
import com.pyy.dp.abstractfactory.abstract_.Vehicle;
import com.pyy.dp.abstractfactory.abstract_.Weapon;
import com.pyy.dp.abstractfactory.modern.AK47;
import com.pyy.dp.abstractfactory.modern.Bread;
import com.pyy.dp.abstractfactory.modern.Car;
import com.pyy.dp.abstractfactory.modern.ModernFactory;

/**
 * @author PeiYY
 * @date 2021/1/18 22:53
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory=new ModernFactory();
        Food food = factory.createFood();
        food.eat();
        Vehicle vehicle = factory.createVehicle();
        vehicle.go();
        Weapon weapon = factory.createWeapon();
        weapon.attack();
    }
}
