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
                int value = arr[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (arr[j] > value) {
                        arr[j + step] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + step] = value;
            }
            step = step / 2;
        }
    }
}
