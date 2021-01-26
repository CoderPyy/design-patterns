package com.pyy.dp.builder;

/**
 * Builder 构建复杂对象
 * @author PeiYY
 * @date 2021/1/26 22:54
 */
public class Main {

    public static void main(String[] args) {
        Person person = new Person.PersonBuilder().basicInfo(1, "peiyy", 18)
                .weight(140)
                .score(180)
                .loc("黄桥镇", "1080")
                .build();
    }
}
