package ru.shabarov.common.sort;

class ShellSort {

    static void sort(int [] a) {
        int gap = a.length / 2;

        while (gap > 0) {
            for (int i = gap; i < a.length; i++) {
                if (a[i] < a[i - gap]) {
                    int tmp = a[i];
                    a[i] = a[i - gap];
                    a[i - gap] = tmp;
                    int reverseIdx = i - gap;
                    while (reverseIdx - gap >= 0) {
                        if (a[reverseIdx] < a[reverseIdx - gap]) {
                            int tmp2 = a[reverseIdx];
                            a[reverseIdx] = a[reverseIdx - gap];
                            a[reverseIdx - gap] = tmp2;
                        }
                        reverseIdx -= gap;
                    }
                }
            }
            gap = gap / 2;
        }
    }
}
