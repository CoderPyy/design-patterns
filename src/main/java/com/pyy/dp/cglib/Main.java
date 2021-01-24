package com.pyy.dp.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * CGLIB实现动态代理不需要接口   （所有的包含jdk的代理、CGLIB等等 都是 由ASM 操作二进制字节码 来的）
 *
 * @author PeiYY
 * @date 2021/1/24 22:33
 */
public class Main {
    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Tank tank = (Tank)enhancer.create();
        tank.move();
    }
}

class TimeMethodInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println(o.getClass().getSuperclass().getName());
        System.out.println("before");
        Object result=null;
        result=methodProxy.invokeSuper(o,objects);
        System.out.println("after");
        return result;
    }
}

class Tank{
    public void move(){
        System.out.println("Tank moving clcalalcal....");

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
