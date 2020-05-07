package com.leica.sort;

/**
 * counting sort
 *
 * @author leica
 * @date 2020/05/07 10:58
 */
public class CountingSort {

    /**
     * counting sort
     *
     * @param arr the array
     */
    public void countingSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int interval = max - min;
        int[] counts = new int[interval + 1];
        for (int value : arr) {
            counts[value - min]++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        int[] sortedArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = counts[arr[i] - min]-- - 1;
            sortedArray[index] = arr[i];
        }
        System.arraycopy(sortedArray, 0, arr, 0, arr.length);
    }
}
