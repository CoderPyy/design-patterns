package com.pyy.dp.factorymethod;

/**
 * @author PeiYY
 * @date 2021/1/18 22:20
 */
public interface Moveable {
    public void go();

    default public void clean(){
        System.out.println("清理交通工具卫生。。。");
    }
}
