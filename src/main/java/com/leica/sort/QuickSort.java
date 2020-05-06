package com.leica.sort;

/**
 * quick sort
 *
 * @author leica
 * @date 2020/05/06 11:44
 */
public class QuickSort {
    /**
     * quick sort
     *
     * @param arr the arr to sort
     */
    public void sort(int[] arr) {
        divide(arr, 0, arr.length - 1);
    }

    /**
     * divide and conquer
     *
     * @param arr   the array
     * @param start the start index
     * @param end   the end index
     */
    private void divide(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int q = partition(arr, start, end);
        divide(arr, start, q - 1);
        divide(arr, q + 1, end);
    }

    /**
     * partition
     *
     * @param arr   the arr
     * @param start the start index
     * @param end   the end index
     * @return partitioned position
     */
    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int k = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                if (i == k) {
                    k++;
                } else {
                    int temp = arr[k];
                    arr[k++] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        int temp = arr[k];
        arr[k] = arr[end];
        arr[end] = temp;
        return k;
    }

    /**
     * quick sort by sentinel
     *
     * @param arr   the array
     * @param start the first index
     * @param end   the end index
     */
    public void sortSentinel(int[] arr, int start, int end) {
        int pivot = arr[start];
        int p = start;
        int q = end;
        while (p < q) {
            while (arr[q] > pivot) {
                q--;
            }
            while (arr[p] < pivot) {
                p++;
            }
            if (p < q) {
                int temp = arr[p];
                arr[p] = arr[q];
                arr[q] = temp;
            }
        }
        if (p - 1 > start) {
            sortSentinel(arr, start, p - 1);
        }
        if (q + 1 < end) {
            sortSentinel(arr, q + 1, end);
        }
    }
}
