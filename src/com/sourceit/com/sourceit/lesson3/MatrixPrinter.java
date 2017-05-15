/*
 * MatrixPrinter
 *
 * 0.0.1
 *
 * 2017/05/15
 *
 * This software is free
 */

package com.sourceit.com.sourceit.lesson3;

/**
 * Prints Matrix.
 *
 * @version 0.0.1
 *
 * 15 May 2017
 *
 * @author Roman Voloschuk
 */
public class MatrixPrinter {
    public static void main(String[] args) {
        int[][] array = {
            {1, 2000, 3,    4},
            {3, 4,    5250, -10},
            {7, 5,    4,    1}
        };

        int rowsNum = array.length;
        int colsNum = array[0].length;
        int[] maxColsLength = new int[colsNum];

        for (int i = 0; i < rowsNum; i++) {
            if (array[i].length == colsNum) {
                for (int j = 0; j < colsNum; j++) {
                    if (maxColsLength[j] == 0) {
                        //Calculate max length of the column
                        for (int k = 0; k < rowsNum; k++) {
                            int elemLength = ("" + array[k][j]).length();
                            if (elemLength > maxColsLength[j]) {
                                maxColsLength[j] = elemLength;
                            }
                        }
                    }
                    System.out.print(array[i][j]);

                    // Add whitespaces
                    if (maxColsLength[j] != 0) {
                        int currElemLength = ("" + array[i][j]).length();
                        for (int count = 0; count < maxColsLength[j] - currElemLength; count++) {
                            System.out.print(" ");
                        }
                    }
                    System.out.print(" ");
                }
                System.out.println();
            } else {
                System.out.println("Row number " + i + " was skipped. Check the structure of the input matrix!");
            }
        }
    }
}
