package com.pyy.dp.observer.v6;

import javax.swing.plaf.synth.SynthUI;
import java.util.ArrayList;
import java.util.List;

/**
 * 有很多时候，观察者需要根据事件的具体情况来进行处理
 * @author PeiYY
 * @date 2021/1/23 17:16
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
        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(), "bed");
        for (Observer observer : observers) {
            observer.actionOnWakeUp(event);
        }

    }
}

//事件类 fire Event
class WakeUpEvent{
    long timeStamp;
    String loc;

    public WakeUpEvent(long timeStamp,String loc){
        this.timeStamp=timeStamp;
        this.loc=loc;
    }
}

interface Observer{
    void actionOnWakeUp(WakeUpEvent event);
}

class Dad implements Observer{

    public void feed(){System.out.println("Dad feeding....");}

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

    public void wang(){
        System.out.println("Dog wang......");
    }

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
