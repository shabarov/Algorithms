package ru.shabarov.common.sort;

class SelectionSort {

    static void sort(int [] a) {
        int n = a.length;
        for (int i = n - 1; i > 0; i--) {
            int maxInd = 0;
            int max = a[maxInd];
            for (int j = 0; j <= i; j++) {
                if (a[j] > max) {
                    max = a[j];
                    maxInd = j;
                }
            }
            if (i != maxInd) {
                a[i] = a[i] ^ a[maxInd];
                a[maxInd] = a[i] ^ a[maxInd];
                a[i] = a[maxInd] ^ a[i];
            }
        }
    }
}
