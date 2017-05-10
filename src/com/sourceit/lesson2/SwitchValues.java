/*
 * SwitchValues
 *
 * 0.0.1
 *
 * 2017/05/09
 *
 * This software is free
 */


package com.sourceit.lesson2;

/**
 * Switches two values without using temp variable.
 *
 * @version 0.0.1
 *
 * 09 May 2017
 *
 * @author Roman Voloschuk
 */
public class SwitchValues {
    public static void main(String[] args) {
        int first = 5;
        int second = 10;

        first = first + second;
        second = first - second;
        first = first - second;

        System.out.println("First = " + first + " , second = " + second);
    }
}
