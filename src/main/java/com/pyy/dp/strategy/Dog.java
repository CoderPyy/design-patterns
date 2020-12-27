package com.pyy.dp.strategy;

/**
 * @author PeiYY
 * @date 2020/12/27 13:28
 */
public class    Dog implements Comparable<Dog> {

    private int food;

    public Dog() {}

    public Dog(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }

    @Override
    public int compareTo(Dog d) {
        if(this.food<d.food) return -1;
        else if(this.food>d.food) return 1;
        else return 0;
    }

}
