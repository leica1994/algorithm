package com.leica.sort;

/**
 * radix sort
 *
 * @author leica
 * @date 2020/5/7 21:36
 */
public class RadixSort {

    /**
     * radix sort
     *
     * @param arr the array to sort
     */
    public void radixSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 1; max / i > 0; i *= 10) {
            countingSort(arr, i);
        }
    }

    /**
     * counting sort-sort the array by a certain number of digits
     *
     * @param arr the array
     * @param exp exponent
     */
    private void countingSort(int[] arr, int exp) {
        if (arr.length <= 1) {
            return;
        }
        int[] counts = new int[10];
        for (int value : arr) {
            counts[(value / exp) % 10]++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        int[] sortedArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = counts[(arr[i] / exp) % 10]-- - 1;
            sortedArray[index] = arr[i];
        }
        System.arraycopy(sortedArray, 0, arr, 0, arr.length);
    }
}
