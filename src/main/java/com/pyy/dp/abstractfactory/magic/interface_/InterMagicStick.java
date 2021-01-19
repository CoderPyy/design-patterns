package com.pyy.dp.abstractfactory.magic.interface_;

import com.pyy.dp.abstractfactory.interface_.Weapon;

public class InterMagicStick implements Weapon {
    @Override
    public void attack() {
       System.out.println("魔法棒。。。");
    }
}
