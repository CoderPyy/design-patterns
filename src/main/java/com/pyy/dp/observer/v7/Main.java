package com.pyy.dp.observer.v7;

import java.util.ArrayList;
import java.util.List;

/**
 * 有很多时候，观察者需要根据事件的具体情况来进行处理，，，也就说：观察者只和事件打交道，不和事件源打交道
 * 大多数时候，我们处理事件的时候，需要事件源对象，，，也就是说：事件只和事件源打交道
 * @author PeiYY
 * @date 2021/1/23 17:31
 */
class Child{
    private boolean cry=false;

    private boolean isCry(){
        return cry;
    }

    public List<Observer> observers=new ArrayList()
    {{
        add(new Dad());
        add(new Mum());
        add(new Dog());
    }};


    public void wakeUp(){
        cry=true;
        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(), "bed", this);
        for (Observer observer : observers) {
            observer.actionOnWakeUp(event);
        }
    }
}

class WakeUpEvent{
    long timeStamp;
    String loc;
    Child source;

    public WakeUpEvent(long timeStamp,String loc,Child source){
        this.timeStamp=timeStamp;
        this.loc=loc;
        this.source=source;
    }
}

interface Observer{
    void actionOnWakeUp(WakeUpEvent event);
}

class Dad implements Observer{
    public void feed(){System.out.println("Dad feeding.....");}

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        feed();
    }
}

class Mum implements Observer{
    public void hug(){System.out.println("Mum hugging......");}

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        hug();
    }
}

class Dog implements Observer{

    public void wang(){System.out.println("Dog wang........");}

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
