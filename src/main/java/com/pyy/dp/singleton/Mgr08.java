package com.pyy.dp.singleton;

/**
 * @author PeiYY
 * @date 2020/12/26 18:27
 *
 * 枚举单例（完美中的完美，Effective Java推荐）
 *  不仅可以解决线程同步的问题，还可以防止反序列化
 */
public enum Mgr08 {

    INSTANCE;

    public void m(){
        System.out.println("hello singleton...");
    }

    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            new Thread(()->System.out.println(Mgr08.INSTANCE.hashCode())).start();
        }
    }

}
