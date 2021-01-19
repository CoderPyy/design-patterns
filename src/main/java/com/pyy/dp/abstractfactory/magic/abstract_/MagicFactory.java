package com.pyy.dp.abstractfactory.magic.abstract_;

import com.pyy.dp.abstractfactory.abstract_.AbstractFactory;
import com.pyy.dp.abstractfactory.abstract_.Food;
import com.pyy.dp.abstractfactory.abstract_.Vehicle;
import com.pyy.dp.abstractfactory.abstract_.Weapon;

/**
 * 魔法世界的工厂
 * @author PeiYY
 * @date 2021/1/18 23:38
 */
public class MagicFactory extends AbstractFactory {
    @Override
    public Food createFood() {
        return new MushRoom();
    }

    @Override
    public Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    public Weapon createWeapon() {
        return new MagicStick();
    }
}
