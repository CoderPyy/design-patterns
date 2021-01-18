package com.pyy.dp.factorymethod.simplefactory;

import com.pyy.dp.factorymethod.Car;
import com.pyy.dp.factorymethod.Plane;

/**
 * 简单工厂的可扩展性不好
 * @author PeiYY
 * @date 2021/1/18 22:33
 */
public class VehicleFactory {
    public Car createCar(){
        //before processing
        return new Car();
    }

    public Plane createPlane(){
        //before processing
        return new Plane();
    }
}
