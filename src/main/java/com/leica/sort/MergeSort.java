package com.leica.sort;

/**
 * merge sort
 *
 * @author leica
 * @date 2020/05/06 9:42
 */
public class MergeSort {

    /**
     * merge sort
     *
     * @param arr the array to be sort
     */
    public void mergeSort(int[] arr) {
        divide(arr, 0, arr.length - 1);
    }

    /**
     * divide and conquer
     *
     * @param arr   the array to be divide
     * @param start the start subscript
     * @param end   the end subscript
     */
    private void divide(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        divide(arr, start, middle);
        divide(arr, middle + 1, end);
        merge(arr, start, middle, end);
    }

    /**
     * sort and merge array
     *
     * @param arr    the array
     * @param start  the start index
     * @param middle the middle index
     * @param end    the end index
     */
    private void merge(int[] arr, int start, int middle, int end) {
        int p = start;
        int q = middle + 1;
        int[] temp = new int[end - start + 1];
        int k = 0;
        while (p <= middle && q <= end) {
            if (arr[q] <= arr[p]) {
                temp[k++] = arr[q++];
            } else {
                temp[k++] = arr[p++];
            }
        }
        if (p <= middle) {
            System.arraycopy(arr, p, temp, k, middle - p + 1);
        }
        if (q <= end) {
            System.arraycopy(arr, q, temp, k, end - q + 1);
        }
        System.arraycopy(temp, 0, arr, start, temp.length);
    }
}
