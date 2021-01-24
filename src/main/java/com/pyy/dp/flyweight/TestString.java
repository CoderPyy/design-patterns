package com.pyy.dp.flyweight;

/**
 * flyWeight 享元模式 （共享元数据）
 *
 * @author PeiYY
 * @date 2021/1/24 15:23
 */
public class TestString {

    //java 的String 就是 享元模式

    public static void main(String[] args) {
        String s1 = "abc";//放在常量池里面
        String s2 = "abc";
        String s3 = new String("abc");//在堆里面new对象
        String s4 = new String("abc");


        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s3 == s4);//false
        System.out.println(s3.intern() == s1);//true
        System.out.println(s3.intern() == s4.intern());//true
    }
}
