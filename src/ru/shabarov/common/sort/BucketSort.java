package ru.shabarov.common.sort;

import java.util.LinkedList;

/**
 * Complexity: O(n)
 *
 * Space: O(n)
 *
 * Stable: yes
 *
 * Usage: limit usage when sorted objects are within certain bounds.
 */
class BucketSort {

    static void sort(int[] a, int lowerBound, int upperBound) {

        int n = a.length;
        LinkedList [] buckets = new LinkedList[upperBound - lowerBound + 1];
        for (int value : a) {
            int h = hash(value, a.length);
            if (buckets[h] == null) {
                buckets[h] = new LinkedList<Integer>();
            }
            buckets[h].add(value);
        }
        int idx = 0;
        for (LinkedList bucket : buckets) {
            if (bucket != null) {
                for (Object e : bucket) {
                    a[idx] = (int) e;
                    idx++;
                }
            }
        }
    }

    private static int hash(int elem, int n) {
        return elem;
    }
}
