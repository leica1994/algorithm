package com.leica.sort;

/**
 * select sort
 *
 * @author leica
 * @date 2020/04/30 11:17
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
