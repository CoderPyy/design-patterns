package com.pyy.dp.abstractfactory.magic.interface_;

import com.pyy.dp.abstractfactory.interface_.Food;
import com.pyy.dp.abstractfactory.interface_.InterfaceFactory;
import com.pyy.dp.abstractfactory.interface_.Vehicle;
import com.pyy.dp.abstractfactory.interface_.Weapon;

public class InterMagicFactory implements InterfaceFactory {
    @Override
    public Food createFood() {
        return new InterMushRoom();
    }

    @Override
    public Vehicle createVehicle() {
        return new InterBroom();
    }

    @Override
    public Weapon createWeapon() {
        return new InterMagicStick();
    }
}
