package com.pyy.dp.observer.v4;

/**
 * 加入多个观察者
 * @author PeiYY
 * @date 2021/1/23 16:13
 */
class Child{
    private Boolean cry=false;
    private Dad dad=new Dad();
    private Mum mum=new Mum();
    private Dog dog=new Dog();

    public Boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry=true;
        dad.feed();
        mum.hug();
        dog.wang();
    }
}

class Dad{
    public void feed(){
        System.out.println("dad feeding.......");
    }
}

class Mum{
    public void hug(){
        System.out.println("mum hugging......");
    }
}

class Dog{
    public void wang(){
        System.out.println("dog wangwang....");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
