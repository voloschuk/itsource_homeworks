package com.sourceit.lesson4.sort;

public class HugeArraySorter {
    public static void main(String[] args) {
        int[] hugeArray = ArrayCreator.createHugeArray(10);

        //Make sorted matrix and counts array
        int length = hugeArray.length;
        int[][] sortedMatrix = new int[10][length];
        int[] counts = new int[10];

        for (int i = 0; i < length; i++) {
            int element = hugeArray[i];
            counts[element]++;
            sortedMatrix[element][counts[element] - 1] = element;
        }

        int tail = 0;
        for (int i = 0; i < 10; i++) {
            System.arraycopy(sortedMatrix[i], 0, hugeArray, tail, counts[i]);
            tail += counts[i];
        }

        for (int index = 0; index < hugeArray.length - 1; index++) {
            if (hugeArray[index] > hugeArray[index + 1]) {
                System.out.println("Sort failed!!!");
                return;
            }
        }

        System.out.println("Sort successful!!");
    }
}
