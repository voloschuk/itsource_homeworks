package com.sourceit.com.sourceit.lesson3;

public class MatrixMultiplier {
    public static void main(String[] args) {
        int[][] first = {
                {1, 2, 3, 4},
                {3, 4, 5, 6},
                {7, 5, 4, 1}
        };

        int[][] second = {
                {1, 2, 3},
                {3, 4, 6},
                {7, 5, 1},
                {3, 4, 6}
        };

        int colsNum;
        int rowsNum;
        if (first.length > 0) {
            colsNum = first[0].length;
            rowsNum = second.length;
            if (colsNum == rowsNum) {
                System.out.println(" " + second[0].length + " " + first.length);
                int[][] result = new int[second[0].length][first.length];

                /*for (int i = 0; i < colsNum; i++) {
                    for (int j = 0; j < rowsNum; j++) {
                        result[i][j] += first[i][j] * second[j][i];
                    }
                }*/


            }
        }
    }
}
