package com.pyy.dp.abstractfactory.magic.interface_;

import com.pyy.dp.abstractfactory.interface_.Vehicle;

public class InterBroom implements Vehicle {
    @Override
    public void go() {
        System.out.println("交通工具-扫把....");
    }
}
