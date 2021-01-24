package com.pyy.dp.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 享元模式（FlyWeight）  重复利用对象，放在一个 Pool 池子里面
 * @author PeiYY
 * @date 2021/1/24 15:32
 */

class Bullet{
    public UUID id=UUID.randomUUID();

    boolean living=true;

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                ", living=" + living +
                '}';
    }
}

public class BulletPool {
    List<Bullet> bullets=new ArrayList<>();
    {
        for(int i=0;i<5;i++) bullets.add(new Bullet());
    }

    public Bullet getBullet(){
        for(int i=0;i<bullets.size();i++){
            Bullet bullet = bullets.get(i);
            if(!bullet.living) return bullet;
        }
        return new Bullet();
    }

    public static void main(String[] args) {
        BulletPool bulletPool = new BulletPool();

        for(int i=0;i<10;i++){
            Bullet bullet = bulletPool.getBullet();
            System.out.println(bullet);
        }
    }

}
