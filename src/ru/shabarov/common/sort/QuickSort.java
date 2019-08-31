package ru.shabarov.common.sort;

/**
 * Complexity:
 * Worst case - O(n^2) - in our case if the array is already sorted,
 * that means that n*n passes are take place
 *
 * Average and Best case - O(nlog(n))
 *
 * Stable - no
 *
 * Space - O(log(n)) - recursion calls
 *
 * Usage - commonly used, no addition space for array needed, so no mem allocation time. Good average complexity.
 * use Merge Sort for linked lists.
 */
class QuickSort {

    static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int min, int max) {

        if ((max - min) < 1) {
            return;
        }

        int smallerInd = min;
        for (int i = min; i < max; i++) {
            if (a[i] < a[max]) {
                int tmp = a[smallerInd];
                a[smallerInd] = a[i];
                a[i] = tmp;
                smallerInd++;
            }
        }
        int tmp = a[smallerInd];
        a[smallerInd] = a[max];
        a[max] = tmp;

        sort(a, min, smallerInd - 1);
        sort(a, smallerInd + 1, max);
    }
}
