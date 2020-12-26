package com.pyy.dp.singleton;

/**
 * lazy loading
 * 懒汉式
 * 虽然达到了按需初始化的目的，但却也带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降的问题
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;

    private Mgr05(){}

    public static Mgr05 getInstance(){
        if(INSTANCE==null){
            //妄图通过 同步代码块的方式提高效率，然后不可行，带来线程不安全的问题
            synchronized(Mgr05.class){
                try{
                    Thread.sleep(1);
                }catch (Exception e){
                    e.printStackTrace();
                }
                INSTANCE=new Mgr05();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(()->System.out.println(Mgr05.getInstance().hashCode())).start();
        }
    }

}