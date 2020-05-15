package com.leica.heap;

/**
 * heap sort
 *
 * @author leica
 * @date 2020/5/15 23:01
 */
public class HeapSort {

    /**
     * heap sort
     *
     * @param arr the array to be sort
     */
    public void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        buildHeap(arr);
        int k = arr.length - 1;
        while (k > 0) {
            swap(arr, 0, k--);
            heapIfy(arr, k, 0);
        }
    }

    /**
     * heapIfy
     *
     * @param arr the array
     * @param n   the index of the last element of the array
     * @param i   the index of the element to be heapIfy
     */
    private void heapIfy(int[] arr, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i) {
                break;
            }
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    /**
     * swap i and j
     *
     * @param arr the array
     * @param i   the element i
     * @param j   the element j
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * build heap
     *
     * @param arr the array
     */
    private void buildHeap(int[] arr) {
        for (int i = (arr.length - 1) >> 1; i >= 0; i--) {
            heapIfy(arr, arr.length - 1, i);
        }
    }
}
