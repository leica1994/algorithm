package com.leica.sort;

/**
 * insert sort
 *
 * @author leica
 * @date 2020/04/30 11:16
 */
public class InsertionSort {
    
    public static void insertionSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }
}
