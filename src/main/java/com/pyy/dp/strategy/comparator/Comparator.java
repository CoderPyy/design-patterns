package com.pyy.dp.strategy.comparator;

/**
 * @author PeiYY
 * @date 2020/12/27 16:58
 *  策略模式！！！
 * 自定义Comparator比较器
 */
public interface Comparator<T> {
    int compare(T o1,T o2);

}
