package com.sourceit.lesson5.oop.users;

public class SuperUser  extends User {

    public SuperUser(String name) {
        super(name);
        this.name = "Super " + name;

    }
}
