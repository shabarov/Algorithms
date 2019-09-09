package ru.shabarov.common.strings;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] a = getArray();
        LSD.sort(a, 6);
        System.out.println("a = " + Arrays.toString(a));

        a = getArray();
        MSD.sort(a);
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));

        System.out.println("BruteForceSearch pattern start pos = " + BruteForceSearch.search("BruteForceSearch", "Force"));

        System.out.println("fact(1000) = " + fact(10));
        System.out.println("fact2(1000) = " + fact2(10));
    }

    private static String [] getArray() {
        return new String [] {"KR8564", "VI5879", "AN1034", "BR0521", "AN1033", "CT2345", "MU8765"};
    }

    private static long fact(long n) {
        if (n == 1 || n == 0) return 1;
        return n * fact(n - 1);
    }

    private static long fact2(long n) {
        if (n == 1 || n == 0) return 1;
        long res = 1;
        while (n > 1) {
            res *=n;
            n--;
        }
        return res;
    }
}
