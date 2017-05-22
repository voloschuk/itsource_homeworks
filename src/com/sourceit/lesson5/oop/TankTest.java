package com.sourceit.lesson5.oop;

public class TankTest {
    public static void main(String[] args) {
        Tank tank = new Tank(0,0, new Gun());
        Tank superTank = new Tank(0,0, new SuperGun());
        superTank.move(0, 20);
        superTank.move(0, 0);


        superTank.shoot();
        superTank.shoot();
        superTank.shoot();


    }
}
