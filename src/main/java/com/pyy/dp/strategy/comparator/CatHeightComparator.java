package com.pyy.dp.strategy.comparator;

import com.pyy.dp.strategy.Cat;

/**
 * @author PeiYY
 * @date 2020/12/27 17:23
 * 比较猫的高度的策略
 */
public class CatHeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.getHeight()<o2.getHeight()) return -1;
        else if(o1.getHeight()>o2.getHeight()) return 1;
        return 0;
    }
}
