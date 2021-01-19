package com.pyy.dp.abstractfactory;

import com.pyy.dp.abstractfactory.abstract_.AbstractFactory;
import com.pyy.dp.abstractfactory.abstract_.Food;
import com.pyy.dp.abstractfactory.abstract_.Vehicle;
import com.pyy.dp.abstractfactory.abstract_.Weapon;
import com.pyy.dp.abstractfactory.interface_.InterfaceFactory;
import com.pyy.dp.abstractfactory.magic.interface_.InterMagicFactory;
import com.pyy.dp.abstractfactory.modern.ModernFactory;

/**
 * @author PeiYY
 * @date 2021/1/18 22:53
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new ModernFactory();
        Food food = factory.createFood();
        food.eat();
        Vehicle vehicle = factory.createVehicle();
        vehicle.go();
        Weapon weapon = factory.createWeapon();
        weapon.attack();
        System.out.println("------------------------------------------------");
        InterfaceFactory fact = new InterMagicFactory();
        com.pyy.dp.abstractfactory.interface_.Food food1 = fact.createFood();
        food1.eat();
        com.pyy.dp.abstractfactory.interface_.Vehicle vehicle1 = fact.createVehicle();
        vehicle1.go();
        com.pyy.dp.abstractfactory.interface_.Weapon weapon1 = fact.createWeapon();
        weapon1.attack();
    }
}
