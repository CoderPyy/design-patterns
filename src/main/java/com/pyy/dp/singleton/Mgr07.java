package com.pyy.dp.singleton;

/**
 * @author PeiYY
 * @date 2020/12/26 16:50
 * 静态内部类方式(完美)
 * JVM保证单例，保证线程安全
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class Mgr07 {
    private Mgr07(){}

    private static class Mgr07Holder{
        private static final Mgr07 INSTANCE=new Mgr07();
    }

    public static Mgr07 getInstance(){
        return Mgr07Holder.INSTANCE;
    }

    public void m(){
        System.out.println("hello singleton...");
    }

    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            new Thread(()->{System.out.println(Mgr07.getInstance().hashCode());}).start();
        }
    }

}
