package com.leica.sort;

/**
 * Shell's Sort
 *
 * @author leica
 * @date 2020/04/30 16:25
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int step = arr.length - 1;
        while (step >= 1) {
            for (int i = step; i < arr.length; i++) {
                int j = i - step;
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            step = step / 2;
        }
    }
}
