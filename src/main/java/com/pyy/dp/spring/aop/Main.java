package com.pyy.dp.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * Spring Aop Test
 *
 * @author PeiYY
 * @date 2021/1/25 21:04
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("app_auto.xml");
        Tank tank = (Tank)context.getBean("tank");
        tank.move();
    }




}
