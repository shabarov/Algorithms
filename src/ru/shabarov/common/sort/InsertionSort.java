package ru.shabarov.common.sort;

/**
 * Complexity:
 * Worst case - O(n^2) when array is reversed
 * Average case - O(n^2)
 * Best case - O(n), when array is sorted or almost sorted
 *
 * Left array sorting cost can be lower up to O(log(i)) from O(i)
 * when use a binary search
 *
 * Space: O(1)
 *
 * Stable: Yes
 *
 * Usage: when N is small or array is almost sorted.
 */
class InsertionSort {

    static void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int current = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > current) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = current;
        }
    }
}
