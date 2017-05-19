package com.sourceit.lesson3;

import java.util.Arrays;

public class MatrixMultiplier {
    public static void main(String[] args) {
        int[][] first = {
                {1, 2, 3, 4},
                {3, 4, 5, 6},
                {7, 5, 4, 1}
        };

        int[][] second = {
                {1, 2, 3, 4},
                {3, 4, 6, 5},
                {7, 5, 1, 0},
                {3, 4, 6, 6}
        };

        int firstRowsNum = first.length;
        int firstColsNum = firstRowsNum > 0 ? first[0].length : 0;
        int secondRowsNum = second.length;
        int secondColsNum = secondRowsNum > 0 ? second[0].length : 0;
        if (firstColsNum == secondRowsNum) {
            int[][] result = new int[firstRowsNum][secondColsNum];

            for (int i = 0; i < firstRowsNum; i++) {
                for (int j = 0; j < secondColsNum; j++) {

                    int productSum = 0;
                    for (int k = 0; k < firstColsNum; k++) {
                        productSum += first[i][k] * second[k][j];
                    }
                    result[i][j] = productSum;

                }
                System.out.println(Arrays.toString(result[i]));
            }
        } else {
            System.out.println("Incorrect matrix format.");
        }
    }
}
