package com.pyy.dp.builder;

/**
 * Builder 实现链式调用  构造 还有多个对象 多个属性
 * @author PeiYY
 * @date 2021/1/26 22:41
 */
public class Person {

    int id;
    String name;
    int age;
    double weight;
    int score;
    Location location=null;

    public Person(){}

    public static class PersonBuilder{
        Person p=new Person();

        public PersonBuilder basicInfo(int id,String name,int age){
            p.id=id;
            p.name=name;
            p.age=age;
            return this;
        }

        public PersonBuilder weight(double weight){
            p.weight=weight;
            return this;
        }

        public PersonBuilder score(int score){
            p.score=score;
            return this;
        }

        public PersonBuilder loc(String street,String roomNo){
            p.location=new Location(street,roomNo);
            return this;
        }

        public Person build(){return p;}
    }

}

class Location{
    String street;
    String roomNo;

    public Location(String street,String roomNo){
        this.street=street;
        this.roomNo=roomNo;
    }

}
