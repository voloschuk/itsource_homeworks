/*
 * YourOwnBinarySearch
 *
 * 0.0.1
 *
 * 2017/05/15
 *
 * This software is free
 */

package com.sourceit.com.sourceit.lesson3;

/**
 * Binary search implementation.
 *
 * @version 0.0.1
 *
 * 15 May 2017
 *
 * @author Roman Voloschuk
 */
public class YourOwnBinarySearch {
    static int[] array = {1, 4, 7, 10, 15, 30, 48};
    static int element = 7;

    public static void main(String[] args) {
        System.out.println(binarySearch(array, element));
    }


    private static int binarySearch(int[] array, int elem) {
        int result = -1;

        if (array.length > 0) {
            int startPos = 0;
            int endPos = array.length - 1;
            if (elem < array[startPos] || elem > array[endPos]) {
                return result;
            }
            if (array[startPos] == elem) {
                return startPos;
            }
            if (array[endPos] == elem) {
                return endPos;
            }

            while (endPos - startPos > 1) {
                int middlePos = (startPos + endPos) / 2;
                if (array[middlePos] == elem) {
                    return middlePos;
                } else if (array[middlePos] > elem) {
                    endPos = middlePos;
                } else if (array[middlePos] < elem) {
                    startPos = middlePos;
                }
            }
        }
        return result;
    }

}
