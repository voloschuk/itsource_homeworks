package com.sourceit.lesson5.oop;

public class Gun extends AbstractGun {

    @Override
    public void shoot() {
        System.out.println("Shoot!!!!");
        System.out.println("Damage done 5");
        loaded = false;
    }
}
