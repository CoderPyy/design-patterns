package com.pyy.dp.strategy;

import java.util.Arrays;

/**
 * @author PeiYY
 * @date 2020/12/27 11:54
 */
public class Main {
    public static void main(String[] args) {
//        int a[]={9,4,62,87,12,6,22};
//        Cat[] cats={new Cat(10,20),new Cat(2,4),new Cat(4,7)};


//        Sorter<Cat> sorter=new Sorter();
//        sorter.sort(cats,new CatHeightComparator());
//        sorter.sort(cats,new CatWeightComparator());
//        System.out.println(Arrays.toString(cats));

        Sorter<Dog> sorter=new Sorter<>();
        Dog[] dogs={new Dog(1),new Dog(3),new Dog(0)};
        sorter.sort(dogs,(o1,o2)->{
            if(o1.getFood()<o2.getFood()) return -1;
            else if(o1.getFood()>o2.getFood()) return 1;
            return 0;
        });
        System.out.println(Arrays.toString(dogs));

    }

}
