package com.sourceit.lesson5.oop;

public abstract class AbstractGun implements GunInterface {
    protected boolean loaded = false;

    @Override
    public void load() {
        if (!this.loaded) {
            this.loaded = true;
        }
    }

    @Override
    public boolean isLoaded() {
        return loaded;
    }

    @Override
    public abstract void shoot();
}
