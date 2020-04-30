package com.leica.sort;

/**
 * bubble sort
 *
 * @author leica
 * @date 2020/04/30 9:35
 */
public class BubbleSort {

    /**
     * bubble sort
     *
     * @param arr array to sort
     */
    public void bubbleSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                boolean flag = false;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
                if (!flag) {
                    break;
                }
            }
        }
    }

    /**
     * bubble sort upgrade
     * <p>
     * Record the position of the last element exchange after each round of sorting,
     * as the boundary of the next comparison, and the elements outside the boundary
     * do not need to be compared in the next cycle
     * </p>
     *
     * @param arr array to sort
     */
    public void bubbleSortUpgrade(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int lastExchange = 0;
        int sortBorder = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                    lastExchange = j;
                }
                sortBorder = lastExchange;
                if (!flag) {
                    break;
                }
            }
        }
    }

}
