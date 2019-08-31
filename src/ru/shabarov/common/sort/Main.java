package ru.shabarov.common.sort;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String [] args) {
        int [] a = getUnsortedArray();

        BubbleSort.sort(a);
        validate(a);
        print(a);

        a = getUnsortedArray();

        SelectionSort.sort(a);
        validate(a);
        print(a);

        a = getUnsortedArray();
        InsertionSort.sort(a);
        validate(a);
        print(a);

        a = getUnsortedArray();
        HeapSort.sort(a);
        validate(a);
        print(a);

        a = getUnsortedArray();
        QuickSort.sort(a);
        validate(a);
        print(a);

        a = new Random().ints(0, 10).limit(10).toArray();
        BucketSort.sort(a, 0, 10);
        validate(a);
        print(a);

        a = getUnsortedArray();
        MergeSort.sort(a);
        validate(a);
        print(a);

        a = getUnsortedArray();
        ShellSort.sort(a);
        validate(a);
        print(a);
    }

    private static int [] getUnsortedArray() {
        return new int[]{6, 3, 8, 4, 9, 5, 3, 2, 7, 1};
    }

    private static void print(int [] a) {
        System.out.println(Arrays.toString(a));
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static void validate(int [] a) {
        Arrays.stream(a).reduce((l, r) -> {
            assert l <= r;
            return r;
        });
    }
}
