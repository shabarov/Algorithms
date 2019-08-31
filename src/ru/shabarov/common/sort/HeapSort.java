package ru.shabarov.common.sort;

/**
 * Complexity:
 * Worst case - O(nlog(n)), when array is already sorted, or array is a reversed binary heap
 * Average case - O(nlog(n))
 * Best case - O(nlog(n))
 *
 * Stable: No, but can be made stable with indexes
 *
 * Space: O(n) - because store recursion calls
 *
 * Usage:
 * 1. When array is nearly sorted
 * 2. Need to find K largest/smallest elements in array
 */
class HeapSort {

    static void sort(int[] a) {
        int n = a.length;
        buildHeap(a, n);
        for (int i = n - 1; i > 0; i--) {
            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            heapify(a, 0, i);
        }
    }

    private static void buildHeap(int[] a, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, i, n);
        }
    }

    private static void heapify(int[] a, int idx, int max) {
        int largest = idx;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        if (left < max && a[left] > a[largest]) {
            largest = left;
        }
        if (right < max && a[right] > a[largest]) {
            largest = right;
        }
        if (idx != largest) {
            int tmp = a[idx];
            a[idx] = a[largest];
            a[largest] = tmp;
            heapify(a, largest, max);
        }
    }
}
