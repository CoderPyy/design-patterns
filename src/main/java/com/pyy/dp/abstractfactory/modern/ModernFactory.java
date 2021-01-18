package com.pyy.dp.abstractfactory.modern;

import com.pyy.dp.abstractfactory.abstract_.AbstractFactory;
import com.pyy.dp.abstractfactory.abstract_.Food;
import com.pyy.dp.abstractfactory.abstract_.Vehicle;
import com.pyy.dp.abstractfactory.abstract_.Weapon;
import com.pyy.dp.abstractfactory.modern.AK47;
import com.pyy.dp.abstractfactory.modern.Bread;
import com.pyy.dp.abstractfactory.modern.Car;

/**
 * 现代化工厂
 * @author PeiYY
 * @date 2021/1/18 23:34
 */
public class ModernFactory extends AbstractFactory {
    @Override
    public Food createFood() {
        return new Bread();
    }

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }
}
