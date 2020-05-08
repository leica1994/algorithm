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
    public int binarySearchNonRecursive(int[] arr, int value) {
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
    public int binarySearchRecursive(int[] arr, int value) {
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

    /**
     * find the first element whose value is equal to the given value
     * if there are duplicate values ​​in the array
     *
     * @param arr   the ordered array
     * @param value the value to search
     * @return the first element whose value is equal to the given value
     */
    public int binarySearchFirstElement(int[] arr, int value) {
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
                if (middle == 0 || arr[middle - 1] != midValue) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }

    /**
     * find the last element whose value is equal to the given value
     * if there are duplicate values ​​in the array
     *
     * @param arr   the ordered array
     * @param value the value to search
     * @return the last element whose value is equal to the given value
     */
    public int binarySearchLastElement(int[] arr, int value) {
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
                if (middle == arr.length - 1 || arr[middle + 1] != midValue) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }

    /**
     * find the first element whose value is great or equal to the given value
     *
     * @param arr   the ordered array
     * @param value the value to search
     * @return the first element whose value is great or equal to the given value
     */
    public int binarySearchGreatOrEqualFirstElement(int[] arr, int value) {
        int low = 0;
        int high = arr.length;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            int midValue = arr[middle];
            if (midValue >= value) {
                if (middle == 0 || arr[middle - 1] < value) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            } else {
                low = low + 1;
            }
        }
        return -1;
    }


    /**
     * find the last element whose value is great or equal to the given value
     *
     * @param arr   the ordered array
     * @param value the value to search
     * @return the last element whose value is great or equal to the given value
     */
    public int binarySearchGreatOrEqualLastElement(int[] arr, int value) {
        int low = 0;
        int high = arr.length;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            int midValue = arr[middle];
            if (midValue > value) {
                high = middle - 1;
            } else {
                if (middle == arr.length - 1 || arr[middle + 1] > value) {
                    return middle;
                } else {
                    low = low + 1;
                }
            }
        }
        return -1;
    }
}
