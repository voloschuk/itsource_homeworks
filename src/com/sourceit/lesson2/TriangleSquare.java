/*
 * TriangleSquare
 *
 * 0.0.1
 *
 * 2017/05/09
 *
 * This software is free
 */


package com.sourceit.lesson2;

/**
 * Calculates triangle square and length of all sides.
 *
 * @version 0.0.1
 *
 * 09 May 2017
 *
 * @author Roman Voloschuk
 */
public class TriangleSquare {
    public static void main(String[] args) {
        int x1 = 1;
        int y1 = 10;
        int x2 = 7;
        int y2 = 2;
        int x3 = -3;
        int y3 = 4;
        float length = 0;
        float square = 0;

        if (x1 == x2 && x2 == x3 && y1 == y2 && y2 == y3) {
            System.out.println("All three points have the same coordinates.");
        } else if ((x2 - x1) * (x3 - x1) == (y2 - y1) * (y3 - y1)) {
            System.out.println("All three points make line.");
        } else {
            /* Calculates length of each side */
            float a = (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
            float b = (float) Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
            float c = (float) Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));

            length = a + b + c;

            float halfLength = length / 2;

            /* Heron's formula */
            square = (float) Math.sqrt(halfLength * (halfLength - a) * (halfLength - b) * (halfLength - c));
        }

        System.out.println("Length of all sides is " + length);
        System.out.println("Square is " + square);
    }
}
