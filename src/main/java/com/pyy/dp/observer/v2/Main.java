package com.pyy.dp.observer.v2;

/**
 * 面向对象的傻等
 * @author PeiYY
 * @date 2021/1/23 15:55
 */
class Child{
    private Boolean cry=false;

    public boolean isCry(){return cry;}

    public void wakeUp(){
        cry=true;
        System.out.println("Waked Up!Crying wuwuwuwuuwwu....");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child=new Child();
        while(!child.isCry()){
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("observing.......");
        }
    }


}
