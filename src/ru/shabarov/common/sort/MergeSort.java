package ru.shabarov.common.sort;

/**
 * Complexity: O(nlog(n))
 *
 * Stable: yes
 *
 * Space: O(n)
 *
 * Usage: sort a linked lists
 */
class MergeSort {

    static void sort(int [] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lower, int right) {
        if (lower < right) {
            int m = (right + lower) / 2;
            sort(a, lower, m);
            sort(a, m + 1, right);
            merge(a, lower, m, right);
        }
    }

    private static void merge(int [] a, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        int [] res = new int [r - l + 1];
        int k = 0;
        while (k < res.length) {
            if (i <= m && j <= r) {
                if (a[i] < a[j]) {
                    res[k] = a[i];
                    i++;
                } else {
                    res[k] = a[j];
                    j++;
                }
            } else if (i <= m) {
                res[k] = a[i];
                i++;
            } else {
                res[k] = a[j];
                j++;
            }
            k++;
        }
        System.arraycopy(res, 0, a, l, res.length);
    }
}
