package com.pyy.dp.strategy.comparator;

import com.pyy.dp.strategy.Cat;

/**
 * @author PeiYY
 * @date 2020/12/27 17:19
 * 比较猫的体重策略
 */
public class CatWeightComparator implements Comparator<Cat>{
    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.getWeight()<o2.getWeight()) return -1;
        else if(o1.getWeight()>o2.getWeight()) return 1;
        else return 0;
    }
}
