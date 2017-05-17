package com.sourceit.com.sourceit.lesson3;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {5, 7, 9, 15, 10, -1, 8};

        for (int upIndex = 1; upIndex < array.length; upIndex++) {
            int elem = array[upIndex];
            if (array[upIndex - 1] > elem) {
                int insIndex = 0;
                for (int downIndex = upIndex - 1; downIndex >= 0; downIndex--) {
                    if (array[downIndex] <= elem) {
                        insIndex = downIndex + 1;
                        break;
                    }
                }
                System.arraycopy(array, insIndex, array, insIndex + 1, upIndex - insIndex);
                array[insIndex] = elem;
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
