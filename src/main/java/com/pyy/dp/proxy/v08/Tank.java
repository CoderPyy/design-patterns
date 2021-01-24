package com.pyy.dp.proxy.v08;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用jdk的动态代理
 *
 *  横切代码与业务逻辑代码分离 AOP
 *
 * @author PeiYY
 * @date 2021/1/24 21:13
 */
public class Tank implements Movable {

    /**
     * 模拟坦克移动了一段时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving calcallaclal.......");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();

        Movable m=(Movable)Proxy.newProxyInstance(tank.getClass().getClassLoader(),
                new Class[]{Movable.class},
                new TimeProxy(tank));

        m.move();
    }


}

class TimeProxy implements InvocationHandler{

    Movable m;

    public TimeProxy(Movable m) {
        this.m = m;
    }

    public void before(){System.out.println("method start......");}

    public void after(){System.out.println("method stop...");}

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(m, args);
        after();
        return invoke;
    }
}

interface Movable{
    void move();
}
