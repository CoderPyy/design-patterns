package com.pyy.dp.proxy.v09;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 通过发射观察生成的代理对象
 *
 * jdk发射生成代理必须面向接口，这是由Proxy的内部实现决定的
 *
 * @author PeiYY
 * @date 2021/1/24 21:36
 */
public class Tank implements Movable {


    /**
     * 模拟坦克移动了一段时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving claclallalc....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");//jdk1.8

//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");//jdk1.8以后

        Movable m = (Movable) Proxy.newProxyInstance(tank.getClass().getClassLoader(),
                new Class[]{Movable.class},
                new TimeProxy(tank));
        m.move();
    }
}

class TimeProxy implements InvocationHandler {

    Movable m;

    public TimeProxy(Movable m) {
        this.m = m;
    }

    public void before() {
        System.out.println("started........");
    }

    public void after() {
        System.out.println("stopped!!!");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(m, args);
        after();
        return invoke;
    }
}

interface Movable {
    void move();
}
