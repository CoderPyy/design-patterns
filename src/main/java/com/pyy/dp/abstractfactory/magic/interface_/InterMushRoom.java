package com.pyy.dp.abstractfactory.magic.interface_;

import com.pyy.dp.abstractfactory.interface_.Food;

public class InterMushRoom implements Food {
    @Override
    public void eat() {
        System.out.println("吃蘑菇。。。。");
    }
}
