package com.pyy.dp.observer.v8;

import java.util.ArrayList;
import java.util.List;

/**
 * 有很多时候，观察者需要根据事件的具体情况来进行处理
 * 大多数时候，我们处理事件的时候，需要事件源对象
 * 事件也可以形成继承关系
 *
 * 事件源：Child
 * 事件：Event
 * 观察者：Observer
 *
 * @author PeiYY
 * @date 2021/1/23 18:03
 */
class Child{
    private boolean cry=false;
    public boolean isCry(){
        return cry;
    }

    private List<Observer> observers=new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
        observers.add((e)->{System.out.println("ppp");});
    }

    public void wakeUp(){
        cry=true;
        WakeUpEvent event=new WakeUpEvent(System.currentTimeMillis(),"bed",this);

        for (Observer observer : observers) {
            observer.actionOnWakeUp(event);
        }
    }
}

abstract class Event<T>{
    abstract T getSource();
}

class WakeUpEvent extends Event<Child>{

    long timeStamp;
    String loc;
    Child source;

    public WakeUpEvent(long timeStamp,String loc,Child source){
        this.timeStamp=timeStamp;
        this.loc=loc;
        this.source=source;
    }

    @Override
    Child getSource() {
        return source;
    }
}

interface Observer{
    void actionOnWakeUp(WakeUpEvent event);
}

class Dad implements Observer{
    private void feed(){System.out.println("Dad feeding.......");}

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        feed();
    }
}

class Mum implements Observer{

    private void hug(){System.out.println("Mum hugging.....");}

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        hug();
    }
}

class Dog implements Observer{

    private void wang(){System.out.println("Dog wang.......");}

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        wang();
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
