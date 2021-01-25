package com.pyy.dp.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 时间代理对象
 * @author PeiYY
 * @date 2021/1/25 21:06
 */
@Aspect
public class TimeProxy {
    @Before("execution(void com.pyy.dp.spring.aop.Tank.move())")
    public void before(){System.out.println("method start..."+System.currentTimeMillis());}

    @After("execution(void com.pyy.dp.spring.aop.Tank.move())")
    public void after(){System.out.println("method after......"+System.currentTimeMillis());}
}
