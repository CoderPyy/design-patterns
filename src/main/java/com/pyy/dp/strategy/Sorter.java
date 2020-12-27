package com.pyy.dp.strategy;

import com.pyy.dp.strategy.comparator.Comparator;

/**
 * @author PeiYY
 * @date 2020/12/27 12:24
 */
public class Sorter<T>{

    /*public void sort(int[] a) {
        for(int i=0;i<a.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<a.length;j++){
                minPos=a[j]<a[minPos]?j:minPos;
            }
            swap(a,i,minPos);
        }
    }*/

    /*public void sort(Comparable[] a) {
        for(int i=0;i<a.length-1;i++){
            int minPos =i;
            for(int j=i+1;j<a.length;j++){
                minPos =a[j].compareTo(a[minPos])==-1?j: minPos;
            }
            swap(a,i, minPos);
        }
    }*/

    /*private void swap(Comparable[] a, int i, int minPos) {
        Comparable temp=a[i];
        a[i]=a[minPos];
        a[minPos]=temp;
    }*/


    public void sort(T[] arr, Comparator<T> comparator){
        for(int i=0;i<arr.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<arr.length;j++){
                minPos=comparator.compare(arr[j],arr[minPos])==-1?j:minPos;
            }
            swap(arr,i,minPos);
        }

    }

    private void swap(T[] arr, int i, int minPos) {
        T temp=arr[i];
        arr[i]=arr[minPos];
        arr[minPos]=temp;
    }

}
