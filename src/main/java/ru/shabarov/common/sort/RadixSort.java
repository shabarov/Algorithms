package ru.shabarov.common.sort;

/**
 * Counting sort extension.
 * What if the elements are in range from 1 to n^2?
 * We can’t use counting sort because counting sort will take O(n2) which is worse than comparison based sorting algorithms.
 * Can we sort such an array in linear time?
 * Radix Sort is the answer. The idea of Radix Sort is to do digit by digit sort starting from least significant digit to most significant digit.
 * On each iteration we put each element in appropriate bucket (10 buckets, from 0 to 9)
 * Radix sort uses counting sort as a subroutine to sort.
 *
 * Example:
 * Original, unsorted list:
 *
 * 170, 45, 75, 90, 802, 24, 2, 66
 * Sorting by least significant digit (1s place) gives:
 *
 * 170, 90, 802, 2, 24, 45, 75, 66
 *
 * Sorting by next digit (10s place) gives:
 *
 * 802, 2, 24, 45, 66, 170, 75, 90
 * Sorting by most significant digit (100s place) gives:
 *
 * 2, 24, 45, 66, 75, 90, 170, 802
 */
public class RadixSort {
}
