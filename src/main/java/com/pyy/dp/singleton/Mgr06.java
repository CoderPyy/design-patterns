package com.pyy.dp.singleton;

/**
 * lazy loading
 * 懒汉式
 * 虽然达到了按需初始化的目的，但却也带来线程不安全的问题
 * 可以通过synchronize解决，但也带来效率下降
 */
public class Mgr06 {
    private static volatile Mgr06 INSTANCE;

    private Mgr06(){}

    public static Mgr06 getInstance() {
        if(INSTANCE==null){
            //双重检查  DCL
            synchronized (Mgr06.class){
                if(INSTANCE==null){
                    try{
                        Thread.sleep(1);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    INSTANCE=new Mgr06();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            new Thread(()->System.out.println(Mgr06.getInstance().hashCode())).start();
        }
    }
}
