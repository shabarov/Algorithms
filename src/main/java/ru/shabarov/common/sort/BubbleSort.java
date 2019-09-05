package ru.shabarov.common.sort;

/**
 * Complexity:
 * Worst case - array reverse sorted.
 * Worst, average case, best cases - O(n^2)
 * Best case - Can be optimized for 'already sorted' case - break if first pass gives no swaps,
 * so that the complexity becomes O(n).
 *
 * Stable: Yes
 *
 * Space: O(1)
 *
 * Auxiliary space: no, except swap buffer (O(1))
 */
class BubbleSort {

    static void sort(int[] a) {
        int n = a.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    // a = b + a - (b = a)
                    a[j + 1] = a[j] + a[j + 1] - (a[j] = a[j + 1]);
                }
            }
        }
    }
}
