package com.pyy.dp.factorymethod;

/**
 * @author PeiYY
 * @date 2021/1/18 22:19
 */
public class Main {
    public static void main(String[] args) {
//        Moveable moveable=new Car();
//        moveable.go();
//        moveable.clean();

        Moveable moveable1=new CarFactory().create();
        moveable1.go();
        moveable1.clean();
    }
}
