/*
 * MatrixInverter
 *
 * 0.0.1
 *
 * 2017/05/15
 *
 * This software is free
 */

package com.sourceit.lesson3;


import java.util.Arrays;

/**
 * Inverts square Matrix.
 *
 * @version 0.0.1
 *
 * 15 May 2017
 *
 * @author Roman Voloschuk
 */
public class MatrixInverter {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {3, 4, 5, 6},
                {7, 7, 4, 1},
                {7, 5, 4, 1}
        };

        int rowsNum = array.length;
        int colsNum = rowsNum > 0 ? array[0].length : 0;
        int tmp;
        if (rowsNum > 0 && colsNum > 0 && rowsNum == colsNum) {
            for (int i = 0; i < rowsNum; i++) {
                for (int j = i; j < colsNum; j++) {
                    tmp = array[j][i];
                    array[j][i] = array[i][j];
                    array[i][j] = tmp;
                }
            }
            for (int i = 0; i < rowsNum; i++) {
                System.out.println(Arrays.toString(array[i]));
            }
        } else {
            System.out.println("Incorrect matrix structure to invert.");
        }
    }
}