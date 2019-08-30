package ru.shabarov.common.sort;

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
