package ru.shabarov.common.search;

public class BinarySearch {
    public static boolean search(int [] a, int b) {
        if (a.length == 0) return false;
        return searchInternal(a, 0, a.length - 1, b);
    }

    private static boolean searchInternal(int a[], int lo, int hi, int b) {
        if (lo == hi) {
            return a[lo] == b;
        }
        // mistake: overflow is possible
        // int mid = (lo + hi) / 2;

        int mid = lo + (hi - lo) / 2;
        if (a[mid] == b) {
            return true;
        } else if (a[mid] < b) {
            return searchInternal(a, mid + 1, hi, b);
        } else {
            return searchInternal(a, lo, mid - 1, b);
        }
    }
}
