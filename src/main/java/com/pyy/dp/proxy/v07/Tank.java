package com.pyy.dp.proxy.v07;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 如果让LogProxy可以重用，不仅可以代理Tank,还可以代理任务其他可以代理的类型 Object
 * (毕竟日志记录，时间计算是很多方法都需要的东西)，这时该怎么做呢？
 * 分离代理行为与被代理对象
 * 使用jdk的动态代理
 *
 * @author PeiYY
 * @date 2021/1/24 17:41
 */
public class Tank implements Movable {


    /**
     * 模拟坦克移动一段时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving clclalclaclalc....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();

        //reflection 通过二进制字节码分析类的属性和方法
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},//tank.class.getInterfaces()
                new LogHandler(tank));

        m.move();

    }
}

class LogHandler implements InvocationHandler {

    Tank tank;

    public LogHandler(Tank tank) {
        this.tank = tank;
    }

    //getClass.getMethods[]
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method " + method.getName() + " start.....");
        Object invoke = method.invoke(tank, args);
        System.out.println("method " + method.getName() + " end!!!");
        return invoke;
    }
}

interface Movable {
    void move();
}
