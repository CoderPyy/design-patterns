package com.pyy.dp.strategy.comparator;

import com.pyy.dp.strategy.Dog;
import com.pyy.dp.strategy.comparator.Comparator;

/**
 * @author PeiYY
 * @date 2020/12/27 17:12
 * 比较狗的策略
 */
public class DogComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
        if(o1.getFood()<o2.getFood()) return -1;
        else if(o1.getFood()>o2.getFood()) return 1;
        else return 0;
    }

}
