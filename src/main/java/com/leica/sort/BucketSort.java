package com.leica.sort;

/**
 * Bucket Sort
 *
 * @author Leica
 * @date 2020/04/23 11:55
 */
public class BucketSort {

    /**
     * bucket sort
     *
     * @param arr        the array to be sort
     * @param bucketSize the capacity of each bucket
     */
    private void bucketSort(int[] arr, int bucketSize) {
        if (arr.length < 2) {
            return;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexes = new int[bucketCount];
        //put the values to buckets
        for (int i : arr) {
            int bucketIndex = (i - min) / bucketSize;
            if (indexes[bucketIndex] == bucketSize) {
                ensureCapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexes[bucketIndex]++] = i;
        }
        //sort the data in each bucket
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (indexes[i] == 0) {
                continue;
            }
            quickSort(buckets[i], 0, indexes[i] - 1);
            for (int j = 0; j < indexes[i]; j++) {
                arr[k++] = buckets[i][j];
            }
        }
    }

    /**
     * quick sort
     *
     * @param arr   the array to sort
     * @param start the first index
     * @param end   the last index
     */
    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int q = partition(arr, start, end);
        quickSort(arr, start, q - 1);
        quickSort(arr, q + 1, end);
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
                swap(arr, i, k++);
            }

        }
        swap(arr, k, end);
        return k;
    }

    /**
     * interactive i and j position
     *
     * @param arr the array
     * @param i   the element i
     * @param j   the element j
     */
    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * expansion capacity of the array buckets
     *
     * @param buckets     the array
     * @param bucketIndex the index
     */
    private void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] temp = new int[buckets[bucketIndex].length << 1];
        System.arraycopy(buckets[bucketIndex], 0, temp, 0, buckets[bucketIndex].length);
        buckets[bucketIndex] = temp;
    }
}
