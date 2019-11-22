package ru.shabarov.common.sort;

import java.util.Arrays;

/**
 * The overall time complexity is O(n^2).
 */
public class PancakeSort {

    private static void flip(int[] arr, int i) {
        for (int curIndex = 0; curIndex <= i / 2; curIndex++) {
            int tmp = arr[curIndex];
            arr[curIndex] = arr[i - curIndex];
            arr[i - curIndex] = tmp;
        }
    }

    private static int max(int[] arr, int to) {
        int maxIdx = 0;
        int maxElmnt = arr[0];
        for (int i = 1; i <= to; i++) {
            if (arr[i] > maxElmnt) {
                maxElmnt = arr[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private static void pancakeSort(int[] arr, int n) {
        for (int i = n - 1; i > 1; i--) {
            int maxIdx = max(arr, i);
            flip(arr, maxIdx);
            flip(arr, i);
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,7,3,9,2,5};
        pancakeSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
