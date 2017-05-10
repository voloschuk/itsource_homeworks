/*
 * ClockAngel
 *
 * 0.0.1
 *
 * 2017/05/09
 *
 * This software is free
 */

package com.sourceit.lesson2;

/**
 * Calculates angle between hour arrow and minute arrow.
 *
 * @version 0.0.1
 *
 * 09 May 2017
 *
 * @author Roman Voloschuk
 */
public class ClockAngel {
    public static void main(String[] args) {
        int hours = 2;
        int mins = 30;
        int result = 0;

        if (hours >= 0 && hours <= 24 && mins >= 0 && mins <= 60) {
            /* The smallest discrete is 1 minute = 6 degrees. Find difference between hour and minute arrows. */
            result = Math.abs((hours % 12) * 5 - mins) * 6;
        } else {
            System.out.println("Incorrect input data format.");
        }

        System.out.println("Angle between hour and minute arrow is " + result);
    }
}
