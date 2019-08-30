package ru.shabarov.common.sort;

import java.util.Arrays;

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
    }

    private static int [] getUnsortedArray() {
        return new int[]{6, 3, 8, 4, 6, 9, 5, 3, 2, 7, 1};
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
