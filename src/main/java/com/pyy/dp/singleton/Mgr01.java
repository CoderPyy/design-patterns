package com.pyy.dp.singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用
 * 唯一缺点：不管用到与否，类装载器时就完成实例化
 *
 */
public class Mgr01 {

    //私有静态实例化一个对象在内存中
    private static final Mgr01 INSTANCE=new Mgr01();

    //私有构造器
    private Mgr01(){}

    public static Mgr01 getInstance(){
        return INSTANCE;
    }

    public void m(){
        System.out.println("hello singleton...");
    }

    public static void main(String[] args) {
        Mgr01 mgr01 = Mgr01.getInstance();
        Mgr01 mgr011 = Mgr01.getInstance();
        System.out.println(mgr01==mgr011);
        mgr01.m();
        mgr011.m();
    }

}
