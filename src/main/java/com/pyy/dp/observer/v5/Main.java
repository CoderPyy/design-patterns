package com.pyy.dp.observer.v5;

import java.util.ArrayList;
import java.util.List;

/**
 * 分离观察者与被观察者
 * @author PeiYY
 * @date 2021/1/23 16:18
 */
class Child{
    private boolean cry=false;

    private List<Observer> observers=new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public boolean isCry(){return cry;}

    public void wakeUp(){
        cry=true;
        for (Observer observer : observers) {
            observer.actionOnWakeUp();
        }
    }
}

interface Observer{
    void actionOnWakeUp();
}

class Dad implements Observer{

    @Override
    public void actionOnWakeUp() {
        System.out.println("dad feeding....");
    }
}

class Mum implements Observer{

    @Override
    public void actionOnWakeUp() {
        System.out.println("mum hugging........");
    }
}

class Dog implements Observer{

    @Override
    public void actionOnWakeUp() {
        System.out.println("dog wang......");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
