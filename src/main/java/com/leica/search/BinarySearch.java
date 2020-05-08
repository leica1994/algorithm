package com.leica.search;

/**
 * binary search
 *
 * @author leica
 * @date 2020/05/08 11:15
 */
public class BinarySearch {

    /**
     * binary search non recursive implementation
     *
     * @param arr   the ordered array
     * @param value the value to search
     * @return the index of the value to search if present
     */
    public int search(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            int midValue = arr[middle];
            if (value < midValue) {
                high = middle - 1;
            } else if (value > midValue) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * binary search recursive implementation
     *
     * @param arr   the ordered array
     * @param value the value to search
     * @return the index of the value to search if present
     */
    public int binarySearch(int[] arr, int value) {
        return binarySearchInternally(arr, 0, arr.length - 1, value);
    }

    /**
     * binary search recursive specific implementation
     *
     * @param arr   the ordered array
     * @param low   the low index
     * @param high  the high index
     * @param value the ordered array
     * @return the index of the value to search if present
     */
    private int binarySearchInternally(int[] arr, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int middle = low + ((high - low) >> 1);
        int midValue = arr[middle];
        if (value < midValue) {
            return binarySearchInternally(arr, low, middle - 1, value);
        } else if (value > midValue) {
            return binarySearchInternally(arr, middle + 1, high, value);
        } else {
            return middle;
        }
    }

}
