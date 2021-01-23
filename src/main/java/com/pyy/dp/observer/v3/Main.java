package com.pyy.dp.observer.v3;

/**
 * 加入观察者
 *
 * @author PeiYY
 * @date 2021/1/23 16:03
 */
class Child {
    private Boolean cry = false;

    private Dad dad = new Dad();

    public Boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        dad.feed();
    }
}

class Dad {
    public void feed() {
        System.out.println("dad feeding.......");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }

}
